package stepDefinations.DMS_Phase2Step;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import PageObjects.DMS_PHASE2PageObject.DMS_1525_PageObject;

import java.util.List;

public class DMS_1525_Step extends PageObject {
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;

    @Given("User is on document listing screen")
    public void user_is_on_document_listing_screen() {
        Validation_of_Document_Listing_screen_for_Doc.clickMenuButton();
        Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getDocument_tab() .isVisible());
        Validation_of_Document_Listing_screen_for_Doc.getDocument_tab().click();
        Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getAllDocument_tab().isVisible());
        Validation_of_Document_Listing_screen_for_Doc.getAllDocument_tab().click();




    }

    @When("User is able to see doc type filter")
    public void user_is_able_to_see_doc_type_filter() {
        Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getDocument_Type_Input().isVisible());
    }

    @Then("Verify doc type filters list")
    public void verify_doc_type_filters_list(List<String> filters)
    {
        Validation_of_Document_Listing_screen_for_Doc.verifyDocTypesList(filters);
    }
    @Then("select DN from doc type filter")
    public void select_dn_from_doc_type_filter(DataTable table)
    {
        Validation_of_Document_Listing_screen_for_Doc.select_doc_type(table);
    }
    @Then("Check that only DN doc list is present")
    public void check_that_dn_doc_list_is_present(DataTable dataTable)
    {
        Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getDN_DocTypeFromDocList().isVisible());
        Assert.assertFalse(Validation_of_Document_Listing_screen_for_Doc.getFour_Way_DocTypeFromDocList().isVisible());
        Validation_of_Document_Listing_screen_for_Doc.ColumnAndColumnValueCheck(dataTable);
    }
    @Then("Verify Document ID search box and check result")
    public void verify_document_id_search_box() {
//        Validation_of_Document_Listing_screen_for_Doc.SearchDocByID(document_ID);

        Validation_of_Document_Listing_screen_for_Doc.pick_and_search_random_doc_id();
//        Assert.assertEquals(document_ID.get(1),Validation_of_Document_Listing_screen_for_Doc.getResultant_documentID().getText());
    }
    @Then("Verify Document version ID search box and check the responding result")
    public void verify_document_version_id_search_box(DataTable table)
    {
        Validation_of_Document_Listing_screen_for_Doc.SearchDocByVersionID(table);
        Validation_of_Document_Listing_screen_for_Doc.checkResultOfScearchedDocVersionID(table);

    }


    @Then("click on Document status filter set document status and check the responding result")
    public void clickOnDocumentStatusFilterSetDocumentStatus(List<String> Document_Status)
    {
        Validation_of_Document_Listing_screen_for_Doc.select_doc_status(Document_Status);
        Validation_of_Document_Listing_screen_for_Doc.checkResultOfScearchedDocStatus(Document_Status);
    }
    @When("select four Way from doc type filter")
    public void select_four_way_from_doc_type_filter(DataTable table) {
        Validation_of_Document_Listing_screen_for_Doc.select_doc_type(table);
    }
    @Then("Search document ID belong to DN")
    public void search_document_id_belong_to_dn(List<String> document_ID) {
        Validation_of_Document_Listing_screen_for_Doc.ClearDocVersionID_TextBox();
        Validation_of_Document_Listing_screen_for_Doc.SearchDocByID(document_ID);
    }
    @Then("Verify No Record Found msg should be displayed")
    public void verify_no_record_found_msg_should_be_displayed() {
   Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible());
    }
    @Then("Search doc version ID belong to DN")
    public void search_doc_version_id_belong_to_dn(DataTable table) {
        Validation_of_Document_Listing_screen_for_Doc.ClearDocID_TextBox();
        Validation_of_Document_Listing_screen_for_Doc.SearchDocByVersionID(table);
    }
    @Then("Select Doc status")
    public void select_doc_status(List<String> Document_Status) {
        Validation_of_Document_Listing_screen_for_Doc.select_doc_status(Document_Status);
    }
    @Then("Verify DN doc should not be displayed")
    public void verify_dn_doc_should_not_be_displayed()
    {
        Assert.assertFalse(Validation_of_Document_Listing_screen_for_Doc.getDN_DocTypeFromDocList().isVisible());
    }

    @Then("Search doc ID belong to Four Way")
    public void searchDocIDBelongToFourWay(List<String> document_ID)
    {
        Validation_of_Document_Listing_screen_for_Doc.SearchDocByID(document_ID);
    }

    @Then("Search doc version ID belong to Four Way")
    public void searchDocVersionIDBelongToFourWay(DataTable table) {
        Validation_of_Document_Listing_screen_for_Doc.ClearDocID_TextBox();
        Validation_of_Document_Listing_screen_for_Doc.SearchDocByVersionID(table);
    }

    @And("Verify Four Way doc should not be displayed")
    public void verifyFourWayDocShouldNotBeDisplayed() {
        Assert.assertFalse(Validation_of_Document_Listing_screen_for_Doc.getFour_Way_DocTypeFromDocList().isVisible());
    }

    @When("Click on the column selection button")
    public void clickOnTheColumnSelectionButton()
    {
        Validation_of_Document_Listing_screen_for_Doc.Click_On_columns_selection_button();
    }

    @And("Verify columns are visible")
    public void verifyColumnsAreVisible(List<String> filters)
    {
Validation_of_Document_Listing_screen_for_Doc.verify_filters_List_From_columns_selection(filters);
    }

    @Then("select filter and click on apply button verify filter is added on listing screen")
    public void selectFilterAndClickOnApplyButtonVerifyFilterIsAddedOnListingScreen(List<String> filters) {
        Validation_of_Document_Listing_screen_for_Doc.select_filters_List_From_columns_selection(filters);
        Validation_of_Document_Listing_screen_for_Doc.getApply_button().click();
        Validation_of_Document_Listing_screen_for_Doc.verify_filter_is_visible_on_listing_screen(filters);


    }

    @And("Scearch LEI ID using EB one LEI ID filter Verify result of documents corresponding to that particular LEI would be visible")
    public void scearchLEIIDUsingEBOneLEIIDFilterVerifyResultOfDocumentsCorrespondingToThatParticularLEIWouldBeVisible(List<String> LEI_ID) {
        Validation_of_Document_Listing_screen_for_Doc.search_LEI_ID_verify_corresponding_results(LEI_ID);
    }

    @And("select multiple LEI ID using EB one LEI ID filter Verify result of documents corresponding to that particular LEI would be visible")
    public void selectMultipleLEIIDUsingEBLEIIDFilterVerifyResultOfDocumentsCorrespondingToThatParticularLEIWouldBeVisible(List<String> LEI_ID) {
        Validation_of_Document_Listing_screen_for_Doc.search_LEI_ID_verify_corresponding_results(LEI_ID);
    }


    @And("select LEI Name using EB one LEI Name filter Verify result of documents corresponding to that particular LEI would be visible")
    public void selectMultipleLEINameUsingEBLEINameFilterVerifyResultOfDocumentsCorrespondingToThatParticularLEIWouldBeVisible(List<String> LEI_Name) {
        Validation_of_Document_Listing_screen_for_Doc.search_LEI_Name_verify_corresponding_results(LEI_Name);
    }

    @And("select LEI ID using EB one LEI ID filter")
    public void selectLEIIDUsingEBOneLEIIDFilter(List<String> LEI_ID) {
        Validation_of_Document_Listing_screen_for_Doc.search_LEI_ID_on_listing_screen(LEI_ID);
    }



    @And("select LEI Name using EB one LEI Name filter")
    public void selectLEINameUsingEBOneLEINameFilter(List<String> LEI_Name) {
        Validation_of_Document_Listing_screen_for_Doc.search_LEI_Name_on_listing_screen(LEI_Name);
    }

    @And("Refresh web page")
    public void refreshWebPage()
    {
        Validation_of_Document_Listing_screen_for_Doc.refresh_web_page();
    }

    @When("Click on Add or Edit Query button")
    public void clickOnAddEditQueryButton()
    {
        Validation_of_Document_Listing_screen_for_Doc.clickOnAddEditQueryButton();
    }

    @And("Click on Add query block")
    public void clickOnAddQueryBlock()
    {
        Validation_of_Document_Listing_screen_for_Doc.click_On_Add_query_block_btn();
    }


    @And("Enter Query name")
    public void enterQueryName(DataTable table)
    {
        Validation_of_Document_Listing_screen_for_Doc.Enter_query_name(table);
    }


    @Then("Click on select field and select filter from dropdown")
    public void clickOnSelectFieldAndSelectFilterFromDropdown(DataTable table)
    {
        Validation_of_Document_Listing_screen_for_Doc.clickOnSelectFieldAndSelectFilterFromDropdown(table);
    }

    @And("Select Operator")
    public void selectOperator(DataTable table)
    {
        Validation_of_Document_Listing_screen_for_Doc.selectOperator(table);
    }


    @And("Verify values on query block")
    public void verifyValuesOnQueryBlock(List<String> value)
    {
        Validation_of_Document_Listing_screen_for_Doc.verifyValuesOnQueryBlock(value);
    }

    @And("Select value on query block")
    public void selectValueOnQueryBlock(DataTable table)
    {
        Validation_of_Document_Listing_screen_for_Doc.selectValueOnQueryBlock(table);
    }

    @And("Click on Save & Apply")
    public void clickOnSaveApply()
    {
        Validation_of_Document_Listing_screen_for_Doc.clickOnSaveApply();
    }


}
