package stepDefinations.Document.BulkEdit;

import PageObjects.Documents.BulkEdit.BulkEditRejectPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;

public class BulkEditRejectValidationPageStep extends PageObject {

    BulkEditRejectPageObject bulkEditRejectPageObject;

    @And("User selects Reject from Bulk Action menu")
    public void user_selects_reject_from_bulk_action_menu() {
        bulkEditRejectPageObject.clickBulkEditRejectAction();
    }

    @Then("User will select doc type for reject")
    public void user_will_select_doc_type_for_reject(DataTable table) {
        bulkEditRejectPageObject.selectDoctypeAction(table);
    }

    @Then("User will select acting as LEIs for reject")
    public void user_will_select_acting_as_leis_for_reject(DataTable table) {
        bulkEditRejectPageObject.selectActingAsAction(table);
    }
    @And("User will select approval group for reject")
    public void user_will_select_approval_group_for_reject(DataTable table) {
        bulkEditRejectPageObject.selectApprovalGroupAction(table);
    }
    @Then("User selects all documents that needs to be rejected")
    public void user_selects_all_documents_that_needs_to_be_rejected() {
        bulkEditRejectPageObject.selectBulkRejectDocuments();
    }
    @And("click on Reject button")
    public void click_on_reject_button() {
        bulkEditRejectPageObject.clickRejectBtn();
    }

}