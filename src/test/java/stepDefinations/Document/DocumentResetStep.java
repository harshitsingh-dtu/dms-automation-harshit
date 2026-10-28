package stepDefinations.Document;

import PageObjects.Documents.DocumentResetPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;

import java.util.Map;

@Slf4j
public class DocumentResetStep extends PageObject {

    DocumentResetPageObject documentResetPageObject;

    /**
     * DN Document Reset
     * orgTypeKey auto-resolved: PB=1, EB=2, Client=3
     */
    @Given("User resets DN document")
    public void user_resets_dn_document(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        log.info("DN Reset triggered with data: {}", data);
        documentResetPageObject.resetDNDocument(
                data.get("docTypeId"),
                data.get("pbLeiId"),
                data.get("ebLeiId"),
                data.get("clientLeiId")
        );
    }

    /**
     * DF Document Reset
     * Also auto-deletes all linked child DN documents.
     * orgTypeKey auto-resolved: PB=1, EB=2
     */
    @Given("User resets DF document")
    public void user_resets_df_document(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        log.info("DF Reset triggered with data: {}", data);
        documentResetPageObject.resetDFDocument(
                data.get("docTypeId"),
                data.get("pbLeiId"),
                data.get("ebLeiId")
        );
    }

    /**
     * 4Way Document Reset
     * Pass orgTypeKey for each participant because same lei
     * can appear in multiple roles (PB and Client both)
     * Deletes LATEST created document with matching participants
     */
    @Given("User resets 4Way document")
    public void user_resets_4way_document(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        log.info("4WAY Reset triggered with data: {}", data);
        documentResetPageObject.reset4WayDocument(
                data.get("docTypeId"),
                data.get("pb1LeiId"),     Integer.parseInt(data.get("pb1OrgTypeKey")),
                data.get("pb2LeiId"),     Integer.parseInt(data.get("pb2OrgTypeKey")),
                data.get("client1LeiId"), Integer.parseInt(data.get("client1OrgTypeKey")),
                data.get("client2LeiId"), Integer.parseInt(data.get("client2OrgTypeKey"))
        );
    }
}
