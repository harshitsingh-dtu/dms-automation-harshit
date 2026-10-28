package PageObjects.Documents;

import PageObjects.query;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.Map;

@Slf4j
public class DocumentResetPageObject extends PageObject {

    query dbQuery;

    // =========================================================
    // COMMON HELPER — Extract document_id from query result
    // =========================================================
    private String findDocumentId(String sql) {
        List<Map<String, Object>> result = dbQuery.fetchData(sql);
        if (result != null && !result.isEmpty()) {
            return (String) result.get(0).get("document_id");
        }
        return null;
    }

    private void cleanupDocumentById(String documentId) {
        try {
            String cleanBatchItemSql = String.format(
                    "DELETE FROM odc_doc.batch_item WHERE doc_version_id IN (" +
                            "  SELECT id FROM odc_doc.document_version WHERE document_id::text = '%s'" +
                            ")",
                    documentId
            );
            dbQuery.executeStoredProcedure(cleanBatchItemSql);
            log.info("Cleaned up referencing batch_item records for document_id={}", documentId);
        } catch (Exception e) {
            log.warn("Pre-cleanup of batch_item for document_id={} skipped or failed: {}", documentId, e.getMessage());
        }

        String call = String.format("CALL odc_doc.cleanup_document_by_id('%s')", documentId);
        dbQuery.executeStoredProcedure(call);
    }


    // =========================================================
    // DN — CHECK + RESET
    // JOIN approach: lot.lei_id directly in HAVING
    // PB (org_type=1, seq=1) + EB (org_type=2, seq=1)
    //   + Client (org_type=3, seq=1) → COUNT = 3
    // =========================================================
    public void resetDNDocument(String docTypeId,
                                String pbLeiId,
                                String ebLeiId,
                                String clientLeiId) {

        log.info("=== DN RESET START ===");
        log.info("PB={}, EB={}, Client={}", pbLeiId, ebLeiId, clientLeiId);

        String sql = String.format(
                "SELECT d.id::text as document_id " +
                        "FROM odc_doc.document d " +
                        "WHERE d.document_type_id::text = '%s' " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 1 AND dp.sequence = 1) " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 2 AND dp.sequence = 1) " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 3 AND dp.sequence = 1) " +
                        "ORDER BY d.created_date DESC " +
                        "LIMIT 1",
                docTypeId, pbLeiId, ebLeiId, clientLeiId
        );
//        String sql = String.format(
//                "WITH target_document AS ( " +
//                        "    SELECT d.id as document_id " +
//                        "    FROM odc_doc.document d " +
//                        "    WHERE d.document_type_id::text = '%s' " +
//                        "      AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
//                        "                  JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
//                        "                  WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 1 AND dp.sequence = 1) " +
//                        "      AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
//                        "                  JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
//                        "                  WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 2 AND dp.sequence = 1) " +
//                        "      AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
//                        "                  JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
//                        "                  WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 3 AND dp.sequence = 1) " +
//                        "    ORDER BY d.created_date DESC " +
//                        "    LIMIT 1 " +
//                        ") " +
//                        "DELETE FROM odc_doc.mv_document_versions " +
//                        "WHERE document_id = (SELECT document_id FROM target_document); " +
//                        "SELECT odc_doc.sp_refresh_mv_document_version(null, null);",
//                docTypeId, pbLeiId, ebLeiId, clientLeiId
//        );
        String documentId = findDocumentId(sql);

        if (documentId == null) {
            log.info("DN document NOT found in DB — skipping deletion.");
            log.info("=== DN RESET SKIPPED ===");
            return;
        }

        log.info("DN document found. document_id={} — deleting...", documentId);
        cleanupDocumentById(documentId);
        log.info("DN document deleted successfully. document_id={}", documentId);
        log.info("=== DN RESET COMPLETE ===");
    }

    // =========================================================
    // DF — CHECK + RESET
    // JOIN approach: lot.lei_id directly in HAVING
    // PB (org_type=1, seq=1) + EB (org_type=2, seq=1) → COUNT = 2
    //
    // IMPORTANT: DF can contains child DNs,
    // so first delete the DNs then DF.
    // =========================================================
    public void resetDFDocument(String docTypeId,
                                String pbLeiId,
                                String ebLeiId) {

        log.info("=== DF RESET START ===");
        log.info("PB={}, EB={}", pbLeiId, ebLeiId);

        String sql = String.format(
                "SELECT d.id::text as document_id " +
                        "FROM odc_doc.document d " +
                        "WHERE d.document_type_id::text = '%s' " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 1 AND dp.sequence = 1) " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = 2 AND dp.sequence = 1) " +
                        "ORDER BY d.created_date DESC " +
                        "LIMIT 1",
                docTypeId, pbLeiId, ebLeiId
        );

        String documentId = findDocumentId(sql);

        if (documentId == null) {
            log.info("DF document NOT found in DB — skipping deletion.");
            log.info("=== DF RESET SKIPPED ===");
            return;
        }

        log.info("DF document found. document_id={}", documentId);

        // Step 1: Find and delete child DNs first
        log.info("DF: Scanning for child DN documents...");
        String childDnSql = String.format(
                "SELECT DISTINCT dv1.document_id::text as document_id " +
                        "FROM odc_doc.document_version dv1 " +
                        "WHERE dv1.restriction_version_id IN (" +
                        "  SELECT id FROM odc_doc.document_version WHERE document_id::text = '%s'" +
                        ")",
                documentId
        );

        List<Map<String, Object>> childDns = dbQuery.fetchData(childDnSql);
        if (childDns != null && !childDns.isEmpty()) {
            for (Map<String, Object> childDn : childDns) {
                String childDnId = (String) childDn.get("document_id");
                log.info("DF: Deleting child DN document_id={}", childDnId);
                cleanupDocumentById(childDnId);
                log.info("DF: Child DN deleted. document_id={}", childDnId);
            }
        } else {
            log.info("DF: No child DNs found.");
        }

        // Step 2: Delete DF document
        log.info("DF: Deleting main DF document...");
        cleanupDocumentById(documentId);
        log.info("DF document (and linked child DNs) deleted successfully. document_id={}", documentId);
        log.info("=== DF RESET COMPLETE ===");
    }


    // =========================================================
    // 4WAY — CHECK + RESET
    // EXISTS approach: Each participant checked independently
    // Avoids GROUP BY counting issues with cross-mapped LEIs
    //
    // PB1    (lei_id, org_type, seq=1)
    // PB2    (lei_id, org_type, seq=2)
    // Client1 (lei_id, org_type, seq=1)
    // Client2 (lei_id, org_type, seq=2)
    //
    // ORDER BY created_date DESC LIMIT 1 → latest doc only
    // (same participants can have multiple document)
    // =========================================================
    public void reset4WayDocument(String docTypeId,
                                  String pb1LeiId,    int pb1OrgTypeKey,
                                  String pb2LeiId,    int pb2OrgTypeKey,
                                  String client1LeiId, int client1OrgTypeKey,
                                  String client2LeiId, int client2OrgTypeKey) {

        log.info("=== 4WAY RESET START ===");
        log.info("PB1={} orgType={}, PB2={} orgType={}",
                pb1LeiId, pb1OrgTypeKey, pb2LeiId, pb2OrgTypeKey);
        log.info("C1={} orgType={}, C2={} orgType={}",
                client1LeiId, client1OrgTypeKey, client2LeiId, client2OrgTypeKey);

        String sql = String.format(
                "SELECT d.id::text as document_id " +
                        "FROM odc_doc.document d " +
                        "WHERE d.document_type_id::text = '%s' " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = %d AND dp.sequence = 1) " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = %d AND dp.sequence = 2) " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = %d AND dp.sequence = 1) " +
                        "  AND EXISTS (SELECT 1 FROM odc_doc.document_participants dp " +
                        "              JOIN odc_org.lei_org_type lot ON lot.id::text = dp.lei_org_type_doctype_id::text " +
                        "              WHERE dp.document_id::text = d.id::text AND lot.lei_id = '%s' AND dp.org_type_id = %d AND dp.sequence = 2) " +
                        "ORDER BY d.created_date DESC " +
                        "LIMIT 1",
                docTypeId,
                pb1LeiId,     pb1OrgTypeKey,
                pb2LeiId,     pb2OrgTypeKey,
                client1LeiId, client1OrgTypeKey,
                client2LeiId, client2OrgTypeKey
        );

        String documentId = findDocumentId(sql);

        if (documentId == null) {
            log.info("4WAY document NOT found in DB — skipping deletion.");
            log.info("=== 4WAY RESET SKIPPED ===");
            return;
        }

        log.info("4WAY document found. document_id={} — deleting...", documentId);
        cleanupDocumentById(documentId);
        log.info("4WAY document deleted successfully. document_id={}", documentId);
        log.info("=== 4WAY RESET COMPLETE ===");
    }
}
