package stepDefinations.Document.BulkEdit;

import PageObjects.Documents.BulkEdit.BulkEditApprovePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class BulkEditApprovalValidationPageStep extends PageObject {
    BulkEditApprovePageObject bulkEditApprovePageObject;
    @Then("User clicks on Bulk Action button")
    public void user_clicks_on_bulk_action_button() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",bulkEditApprovePageObject.getBulkAction_btn());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        bulkEditApprovePageObject.clickBulkEditBtn();
    }
    @And("User selects Approve from Bulk Action menu")
    public void user_selects_approve_from_bulk_action_menu() {
        bulkEditApprovePageObject.clickBulkEditApproveAction();
    }
    @Then("User will select doc type for approval")
    public void user_will_select_doc_type_for_approval(DataTable table) {
        bulkEditApprovePageObject.selectDocTypeAction(table);
    }
    @Then("User will select acting as LEIs for approval")
    public void user_will_select_acting_as_leis_for_approval(DataTable table) {
        bulkEditApprovePageObject.selectActingAsAction(table);
    }
    @And("User will select approval group for approval")
    public void user_will_select_approval_group_for_approval(DataTable table) {
        bulkEditApprovePageObject.selectApprovalGroupAction(table);
    }
    @Then("User selects all documents that needs to be approved")
    public void user_selects_all_documents_that_needs_to_be_approved() {
        bulkEditApprovePageObject.selectBulkApprovalDocuments();
    }
    @And("click on Approve button")
    public void click_on_approve_button() {
        bulkEditApprovePageObject.clickApproveBtn();
    }

    @And("click on Approve button on DN")
    public void click_on_approve_button_on_DN() {
        bulkEditApprovePageObject.clickApproveBtnDN();
    }

    @Then("User validates No Value should be coming for Acting As field in Bulk Action")
    public void user_validates_Blank_Field_For_Acting_As() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(bulkEditApprovePageObject.getNoValue_For_Acting_AS().isDisplayed());
    }

}