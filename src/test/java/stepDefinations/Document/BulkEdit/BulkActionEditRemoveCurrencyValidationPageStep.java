package stepDefinations.Document.BulkEdit;

import PageObjects.Documents.BulkEdit.BulkActionEditRemoveCurrencyPageObject;
import PageObjects.Documents.BulkEdit.BulkEditApprovePageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.List;

public class BulkActionEditRemoveCurrencyValidationPageStep extends PageObject
{

    BulkActionEditRemoveCurrencyPageObject bulkActionEditRemoveCurrencyPageObject;
    BulkEditApprovePageObject bulkEditApprovePageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Given("User is on DocumentPage")
    public void user_is_on_documentPage() throws InterruptedException {

        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getDoc_page().isVisible());
    }
    @Then("User clicks on BulkAction button")
    public void user_clicks_on_bulkAction_button() {
        bulkEditApprovePageObject.clickBulkEditBtn();
    }
    @And("User selects Approve from BulkAction menu")
    public void user_selects_approve_from_bulkAction_menu() {
        bulkEditApprovePageObject.clickBulkEditApproveAction();
    }
    @And("User selects edit button")
    public void userSelectsEditButton() {
        bulkEditApprovePageObject.clickBulkEditButton();
    }
    @And("User clicks on editButton for BulkEdit")
    public void User_clicks_on_editButton()
    {
        bulkActionEditRemoveCurrencyPageObject.clickOnBulkActionEditButton();
    }
    @Then("User will select doc type for edit")
    public void user_will_select_doc_type_for_edit(DataTable table) {
        bulkActionEditRemoveCurrencyPageObject.selectDocTypeAction(table);
    }
    @Then("User will clear Selecting As filter")
    public void user_will_clear_selectingAs() {
        bulkActionEditRemoveCurrencyPageObject.getClearActingAsFilter().waitUntilVisible();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        bulkActionEditRemoveCurrencyPageObject.getClearActingAsFilter().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User will select acting as LEIs for edit")
    public void user_will_select_acting_as_leis_for_edit(DataTable table) {
        bulkActionEditRemoveCurrencyPageObject.selectActingAsAction(table);
    }
    @And("User will type into action type for edit")
    public void user_will_Type_in_select_action_type(DataTable table) {
        bulkActionEditRemoveCurrencyPageObject.TypeIntoActionType(table);
    }
    @And("User will select action type for edit")
    public void user_will_select_action_type_for_edit(DataTable table) {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        bulkActionEditRemoveCurrencyPageObject.selectActionType(table);
    }
    @Then("User clicks on NextButton")
    public void user_clicks_on_nextButton() {
        bulkActionEditRemoveCurrencyPageObject.click_Nextbtn();
        waitForAbsenceOf("//div[contains(@class,'modal-backdrop')]");
    }

    @Then("User clicks on NextButton Again")
    public void user_clicks_on_nextButtonAgain() {
        bulkActionEditRemoveCurrencyPageObject.click_Nextbtn();
    }

    @Then("Verify user is able to see Document ID, Document Version ID, Document Status")
    public void verify_user_is_able_to_see_document_id_document_version_id_document_status()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getDocument_id().isVisible());
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getDocument_Version_id().isVisible());
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getDocument_status().isVisible());
    }
    @Then("Verify search functionality by Document ID")
    public void verify_search_functionality_by_document_id(DataTable table) {
        bulkActionEditRemoveCurrencyPageObject.varify_search_functionality_for_doc_id(table);
    }
    @Then("Verify search functionality by Document Version ID")
    public void verify_search_functionality_by_document_version_id(DataTable table) {
        bulkActionEditRemoveCurrencyPageObject.varify_search_functionality_for_doc_version_id(table);
    }
    @Then("Select document to remove currency")
    public void select_document_to_remove_currency(DataTable table) {
        bulkActionEditRemoveCurrencyPageObject.Select_doc_to_remove_currency(table);
    }
    @Then("Verify next button and click")
    public void verify_next_button_and_click() {
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getNext_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.click_Nextbtn();
    }

    @Then("Verify user able to addCurrency")
    public void verify_user_able_to_addCurrency(List<String> selectcurrencyList)throws InterruptedException
    {
        bulkActionEditRemoveCurrencyPageObject.Validate_Add_currency(selectcurrencyList);
        Thread.sleep(3000);
    }
    @Then("Verify user able to removeCurrency")
    public void verify_user_able_to_removeCurrency(List<String> remove_currencyList) throws InterruptedException {
        bulkActionEditRemoveCurrencyPageObject.Validate_Remove_currencye(remove_currencyList);
        Thread.sleep(3000);
    }
    @Then("Verify submit for approval button")
    public void verify_submit_for_approval_button()
    {
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getSubmit_for_approval_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.Click_submit_for_approval_button();
    }

    @Then("verify cancel button")
    public void verify_cancel_button() {
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getCancel_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.Click_cancel_button();
    }
    @Then("Verify and click back button")
    public void verify_back_button()
    {   Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getBack_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.Click_back_button();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("verify Confirmation popup")
    public void verify_Confirmation_popup()
    {
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getConfirmation_popup_no_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.Click_Popup_no_button();

        bulkActionEditRemoveCurrencyPageObject.Click_back_button();

        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getConfirmation_popup_yes_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.Click_Popup_yes_button();

    }
    @Then("User enters limit value on Edit limit screen")
    public void enterLimitValueOnEditLimitScreen(DataTable table)
    {
        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getBack_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.limitValueOnEditLimitScreen(table);
    }
    @Then("User edits the Product family value")
    public void enterLimitProductFamily(DataTable table)
    {
        bulkActionEditRemoveCurrencyPageObject.limitProductFamily(table);
    }

    @Then("User enters limit value on Edit limit screen Again")
    public void enterLimitValueOnEditLimitScreenAgain(DataTable table)
    {
//        Assert.assertTrue(bulkActionEditRemoveCurrencyPageObject.getBack_btn().isVisible());
        bulkActionEditRemoveCurrencyPageObject.limitValueOnEditLimitScreen(table);
    }


//    @Then("Verify user able to select product family")
//    public void verify_user_able_to_select_product_family() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("Verify user able to select product")
//    public void verify_user_able_to_select_product() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("user is able to click on remove product line")
//    public void user_is_able_to_click_on_remove_product_line() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("Verify submit for approval button")
//    public void verify_submit_for_approval_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @And("Select first document")
    public void select_first_document_to_remove_currency() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        bulkActionEditRemoveCurrencyPageObject.clickFirstDocCheckbox();
    }
    @And("User verify the sequence of Columns for Bulk Edit Screen")
    public void User_Verify_Sequence(DataTable table){
        bulkActionEditRemoveCurrencyPageObject.VerifySequence(table);
    }


}