package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.*;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_1768Step extends PageObject {

    DMS_1768PageObject dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject;

    DocumentPageObject documentPageObject;

    DMS_1563PageObject DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject;

    DMS_1525_PageObject dMS_1525_PageObject;

    Approval_groups_matrix_PageObject approval_groups_matrix_PageObject;

    DMS_1570PageObject DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject;

    @Given("User is on document tab on the side menu")
    public void User_is_on_document_tab_on_the_side_menu(){
        documentPageObject.clickMenuButton();
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getDocument_tab().waitUntilVisible();
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getDocument_tab().click();
    }
    @Then("Documents access request should be visible to the user")
    public void Documents_access_request_should_be_visible_to_the_user(){
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getDocumentsAccessRequest().isVisible());
        log.info("Documents access request is visible");
    }
    @When("User clicks on document access request")
    public void User_clicks_on_document_access_request(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getDocumentsAccessRequest().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User will be redirected to documents access request screen")
    public void User_will_be_redirected_to_documents_access_request_screen(){
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getDocumentsAccessRequest().isVisible());
        log.info("Redirected to documents access request screen");
    }
    @And("User will be able to see corresponding information on document access request screen")
    public void User_will_be_able_to_see_corresponding_information_on_document_access_request_screen(){
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSearch_RequestID().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_Requester().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_RequesterLEI().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_Reviewer().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_ReviewerLEI().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_docType().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_status().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getViewDetails_btn().isVisible());
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.validateColumns();
    }
    @When("User will click on select status filter")
    public void User_will_click_on_select_status_filter(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_status().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("Corresponding results should be visible in the status filter dropdown")
    public void Corresponding_results_should_be_visible_in_the_status_filter_dropdown(){
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getPending_text().isCurrentlyVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getApproved_text().isCurrentlyVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getRejected_text().isCurrentlyVisible());
        log.info("Corresponding results are visible in the status filter dropdown");
    }
    @When("User will input value in select status filter")
    public void User_will_input_value_in_select_status_filter(List<String> status){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.selectStatus(status);
    }
    @Then("User will be able to see corresponding result as per selected status")
    public void User_will_be_able_to_see_corresponding_result_as_per_selected_status(DataTable table){
        approval_groups_matrix_PageObject.ColumnAndColumnValueCheck(table);
    }
    @When("User will click on doc type dropdown")
    public void User_will_click_on_doc_type_dropdown(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getSelect_docType().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("Corresponding data items should be visible")
    public void Corresponding_data_items_should_be_visible(){
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getFourWayDocTypeFromDropdown().isDisplayed());
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getDNDocTypeFromDropdown().isDisplayed());
        log.info("Both 4 Way and DN doc type are visible");
    }
    @And("User checks the request ID format on the document access request screen")
    public void User_checks_the_request_ID_format_on_the_document_access_request_screen(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.verify_request_ID_format();
    }
    @When("User will input request ID in the search box then corresponding result should be visible")
    public void User_will_input_request_ID_in_the_search_box_then_corresponding_result_should_be_visible(DataTable table){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.search_requestID(table);
    }
    @When("User will input doc type in doc type filter")
    public void User_will_input_doc_type_in_doc_type_filter(List<String> docType){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.input_docType(docType);
    }
    @And("When user will input doc type in doc type filter again")
    public void When_user_will_input_doc_type_in_doc_type_filter_again(List<String> docType){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.input_docType(docType);
    }
    @And("User will Navigate to Document Access Request screen")
    public void User_will_Navigate_to_Document_Access_Request_screen(){
        documentPageObject.clickMenuButton();
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.NavigateToDocumentAccessRequestTab();
    }
    @Then("User will redirect to footer of Document Access Request screen")
    public void User_will_redirect_to_footer_of_Document_Access_Request_screen(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getPagination_container().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getShowing_page_text().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getShowing_CurrentPagenumber().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getTotal_pageNumber().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getRecords_per_page_text().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getRecords_per_page_value().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getTotal_record_count_text().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getCurrent_record_page_value().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getPrevious_page_button().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getNext_page_button().isVisible());
    }
    @And("User Click on next page button Redirected to next page")
    public void User_Click_on_next_page_button_Redirected_to_next_page(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.CheckNextPagebutton();
    }
    @And("User Click on previous page button Redirected to previous page")
    public void User_Click_on_previous_page_button_Redirected_to_previous_page(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.CheckPreviousPagebutton();
    }
    @And("User will change record per page Accordingly listing screen data should change")
    public void User_will_change_record_per_page_Accordingly_listing_Screen_data_should_change(List<String> record){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.CheckPerpageRecordDropdown(record);
    }
    @And("User will click on Record Per page Dropdown and able to see Per page count option")
    public void User_will_click_on_Record_Per_page_Dropdown_and_able_to_see_Per_page_count_option(){
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getRecords_per_page_value().isVisible());
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getRecords_per_page_value().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getOnezerorecordperpage().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getTwofiverecordperpage().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getFivezerorecordperpage().isVisible());
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getOnezerozerorecordperpage().isVisible());
    }
    @And("Column should be blank under version ID column")
    public void Column_should_be_blank_under_version_ID_column(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.checkBlankVersionID_Column();
    }
    @And("Version ID should be visible under version id column with proper format")
    public void Version_ID_should_be_visible_under_version_id_column_with_proper_format(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.checkVersionID_Column();
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.verify_version_ID_format();
    }
    @And("Column should be blank under Reviewed by column")
    public void Column_should_be_blank_under_Reviewed_by_column(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.checkBlankReviewedBy_Column();
    }
    @And("Email should be visible under Reviewed by column with proper format")
    public void Email_should_be_visible_under_Reviewed_by_column_with_proper_format(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.checkReviewedBy_Column();
    }
    @When("User will input data in the select requester filter then able to see corresponding results on listing screen")
    public void User_will_input_data_in_the_select_requester_filter_then_able_to_see_corresponding_results_on_listing_screen(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.selectMultipleRequester();
    }
    @When("User will input data in the select requester LEI filter then able to see corresponding results on listing screen")
    public void User_will_input_data_in_the_select_requester_LEI_filter_then_able_to_see_corresponding_results_on_listing_screen(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.selectMultipleRequesterLEI();
    }
    @When("User will input data in the select reviewer filter then able to see corresponding results on listing screen")
    public void User_will_input_data_in_the_select_reviewer_filter_then_able_to_see_corresponding_results_on_listing_screen(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.selectMultipleReviewer();
    }
    @When("User will input data in the select reviewer LEI filter then able to see corresponding results on listing screen")
    public void User_will_input_data_in_the_select_reviewer_LEI_filter_then_able_to_see_corresponding_results_on_listing_screen(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.selectMultipleReviewerLEI();
    }
    @When("User types in the email id and password")
    public void User_types_in_the_email_id_and_password(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.enterEmailAndPass(table);
    }
    @And("Requests should be visible of same organisation as of current user organisation")
    public void Requests_should_be_visible_of_same_organisation_as_of_current_user_organisation(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.validateRequesterLEI_column();
    }
    @Then("No Record found should be displayed on document access listing screen")
    public void No_Record_found_should_be_displayed_on_document_access_listing_screen(){
        dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getNoRecordFound_documentAccessScreen().waitUntilVisible();
        Assert.assertTrue(dms1768AsAUserIShouldBeAbleToViewAllRequestsOnTheListingScreenPageObject.getNoRecordFound_documentAccessScreen().isVisible());
        log.info("No Record Found is displayed");
    }
}
