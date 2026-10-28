package stepDefinations.Document;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.Documents.DocumentSingleEditPageObject;
import PageObjects.OrgManagement.OrgManagementPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
@Slf4j
public class DocumentPageStep extends PageObject {
    DocumentPageObject documentPageObject;
    DocumentSingleEditPageObject documentSingleEditPageObject;
    OrgManagementPageObject orgManagementPageObject;

    @Given("^User is on the Dashboard$")
    public void user_is_on_the_dashboard() {
//        documentPageObject.checkTitle()
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(documentPageObject.title_text.isVisible());
    }

    @When("^User clicks on Menu bar on Dashboard$")
    public void user_clicks_on_menu_bar_on_dashboard() {
        documentPageObject.clickMenuButton();
    }

    @Then("^User is able to select Document$")
    public void user_is_able_to_select_document() {
        documentPageObject.clickDocumentTab();
    }

    @And("^User Verifies the Documents Page$")
    public void verifies_the_documents_page() {
        documentPageObject.verifyDocumentText();
    }

    @When("^User will search using Document ID on All Document listing screen$")
    public void user_will_search_using_document_id_on_all_document_listing_screen(DataTable table) {
        documentPageObject.search_document(table);
    }

    @Then("^corresponding search results is displayed on the all document listing screen$")
    public void corresponding_search_results_is_displayed_on_the_all_document_listing_screen() {
        try {
            Assert.assertEquals(documentPageObject.getSearch_documentID().getAttribute("value"),documentPageObject.getSearched_document_id().getText());
            log.info("Search results is displayed successfully");

        }catch (Exception e){
            if (documentPageObject.getTrack_screen_norecordfound().isVisible()){

            }
            else {
                log.error("Not expected result"+e);
                Assert.fail();
            }

        }
    }

    @Then("^User can see button bulk action$")
    public void user_can_see_button_bulk_action() {
        Assert.assertTrue(documentPageObject.getBulkaction_btn().withTimeoutOf(java.time.Duration.ofSeconds(10)).isVisible());
    }

    @And("^User can see create new document button$")
    public void user_can_see_create_new_document_button() {
        Assert.assertTrue(documentPageObject.getCreatenewdocument_btn().isVisible());
    }
    @And("^User can see pending approval status$")
    public void user_can_see_pending_approval_status()  {
        Assert.assertTrue(documentPageObject.getPending_approval_container().isVisible());
    }
    @And("^User can see query builder$")
    public void user_can_see_query_builder() {
        documentPageObject.checkifquerybuilder();
    }

    @And("^User can see predictive search bar$")
    public void user_can_see_predictive_search_bar() {
        try {
            Assert.assertTrue(documentPageObject.getDocument_id_col().isVisible());
            Assert.assertTrue(documentPageObject.getSearch_documentID().isVisible());
            Assert.assertTrue(documentPageObject.getSearch_versionID().isVisible());
            Assert.assertTrue(documentPageObject.getVersion_id_col().isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to verify predictive search bar "+ e);
        }

    }

    @And("^User can see all the filters on the document screen$")
    public void user_can_see_all_the_filters_on_the_document_screen() {
//      Assert.assertTrue(documentPageObject.getFilter_document_status().isVisible());
        documentPageObject.checkifBasicfilters();
    }

    @And("^User can see all the default columns in the document listing screen$")
    public void user_can_see_all_the_columns_in_the_document_listing_screen() {
        documentPageObject.checkifallcolumns();
    }

    @And("^User unselects the Show only latest version checkbox if it is selected$")
    public void userUnselectsShowOnlyLatestVersionCheckbox() {
        documentPageObject.unselectShowOnlyLatestVersion();
    }

    @And("^User can see the track button on the document screen$")
    public void user_can_see_the_track_button_on_the_document_screen() {
        Assert.assertTrue(documentPageObject.getTrack_col().isVisible());
        Assert.assertTrue(documentPageObject.getDocumenttrack_btn().isVisible());
    }

    @And("^User can see icons on the document screen$")
    public void user_can_see_icons_on_the_document_screen() {
        Assert.assertTrue(documentPageObject.getIcon_container().isVisible());
    }

    @And("^User can see pagination on the document screen$")
    public void user_can_see_pagination_on_the_document_screen() {
        Assert.assertTrue(documentPageObject.getPagination_container().isVisible());
    }

    @When("^User scroll to the foot of the screen$")
    public void user_scroll_to_the_foot_of_the_screen() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("^User is able to see the Edit button$")
    public void user_is_able_to_see_the_edit_button() {
        Assert.assertTrue(documentPageObject.getDocumentedit_btn().isVisible());
    }

    @And("^User is able to see the Approve button$")
    public void user_is_able_to_see_the_approve_button() {
        Assert.assertTrue(documentPageObject.getDocumentapprove_btn().isVisible());
    }

    @And("^User is able to see the Reject button$")
    public void user_is_able_to_see_the_reject_button() {
        Assert.assertTrue(documentPageObject.getDocumentreject_btn().isVisible());
    }

    @And("^User is able to see the Copy button$")
    public void user_is_able_to_see_the_copy_button() {
        Assert.assertTrue(documentPageObject.getDocument_copy().isVisible());
    }

    @And("^User is able to see the Cancel button$")
    public void user_is_able_to_see_the_cancel_button() {
        Assert.assertTrue(documentPageObject.getDocumentcancel_btn().isVisible());
    }

    @And("^User is able to see the Compare button$")
    public void user_is_able_to_see_the_compare_button() {
        Assert.assertTrue(documentPageObject.getDocumentcompare_btn().isVisible());
    }

    @And("^User is able to see the Delete button$")
    public void user_is_able_to_see_the_delete_button() {
        Assert.assertFalse(documentPageObject.getDocumentdelete_btn().isEmpty());
        Assert.assertTrue(documentPageObject.getDocumentdelete_btn().get(0).isVisible());
    }

    @And("^User is able to see the Terminate button$")
    public void user_is_able_to_see_the_terminate_button() {
        Assert.assertTrue(documentPageObject.getDocumentterminate_btn().isVisible());
    }

    @And("^User is able to see the Download button$")
    public void user_is_able_to_see_the_download_button() {
        Assert.assertTrue(documentPageObject.getDocumentdownload_btn().isVisible());
    }

    @When("^User will click on Track button$")
    public void user_will_click_on_track_button_on_the_document_screen() {
        documentPageObject.getDocumenttrack_btn().click();
    }

    @Then("^User will be redirected to the track screen$")
    public void user_will_be_redirected_to_the_track_screen() {
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(documentPageObject.getTrack_document_history_txt().isVisible());
        documentPageObject.validate_track_screen();
    }

    @When("^User will search for the document ID to be deleted$")
    public void user_will_search_for_the_document_ID_to_be_deleted(DataTable table) {
        documentPageObject.search_document(table);
    }
    @When("^User will search the document to be approved$")
    public void user_will_search_the_document_to_be_approved(DataTable table){
        documentPageObject.search_document(table);
    }

    @Then("^User will select Acting as on the Approve confirmation pop up$")
    public void user_will_select_acting_as_on_the_approve_confirmation_pop_up(DataTable table)  {
        documentPageObject.confirmation_popup_actingas(table);
    }

    @And("^User will click on the approve button$")
    public void user_will_click_on_the_approve_button()  {
        documentPageObject.getDocumentapprove_btn().waitUntilClickable();
        if (documentPageObject.getDocumentapprove_btn().isVisible()){
            documentPageObject.getDocumentapprove_btn().click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }else {
            Assert.fail();
        }
    }
    @Then("^User is able to see document details on the Approve confirmation pop up$")
    public void user_is_able_to_see_document_details_on_the_approve_confirmation_pop_up() {
        try {
            Assert.assertTrue( documentPageObject.getConfirmation_pop_up_documentversionid().isVisible());
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_documenttype().isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to see document details on the screen");
        }
    }

    @And("^User is able to see Acting as on the Approve confirmation pop up$")
    public void user_is_able_to_see_acting_as_on_the_approve_confirmation_pop_up()  {
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_actingas().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }

    @And("^User is able to see Approval group on the Approve confirmation pop up$")
    public void user_is_able_to_see_approval_group_on_the_approve_confirmation_pop_up() {
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_approvalgroup().isVisible());
        }catch (Exception e){
            log.error("Unable to view Approval group");
        }
    }

    @And("^User will select Approval group on the Approve confirmation pop up$")
    public void User_will_select_Approval_group_on_the_Approve_confirmation_pop_up(DataTable table){
        documentPageObject.confirmation_popup_Approval_Group(table);
    }

    @And("^User will select Approval group on the Reject confirmation pop up$")
    public void User_will_select_Approval_group_on_the_Reject_confirmation_pop_up(DataTable table){
        documentPageObject.selectapprovalgroup_reject(table);
    }

    @And("^User is able to see cancel and submit button on the Approve confirmation pop up$")
    public void user_is_able_to_see_cancel_and_submit_button_on_the_approve_confirmation_pop_up()  {
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_cancel_btn().isVisible());
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_approve_btn().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }

    @And("^User will select Action type on the Approve confirmation pop up$")
    public void user_will_select_action_type_on_the_approve_confirmation_pop_up(DataTable table) {
//        documentPageObject.confirmation_popup_actiontype(table);
        documentPageObject.confirmation_popup_Approval_Group(table);
    }

    @And("^User will click submit button on the Approve confirmation pop up$")
    public void user_will_click_submit_button_on_the_approve_confirmation_pop_up() {
        documentPageObject.getConfirmation_pop_up_approve_btn().click();
//        documentPageObject.getConfirmation_pop_up_cancel_btn().click();
    }
    @Then("^User will give the confirmation to delete the document$")
    public void user_will_give_the_confirmation_to_delete_the_document() {
        documentPageObject.check_confirmation_to_delete();
        documentPageObject.getNO_Btn_confirm_delete_document().click();
//        documentPageObject.getYES_Btn_confirm_delete_document().click();
    }

    @When("^User will search the document to be terminated$")
    public void user_will_search_the_document_to_be_terminated(DataTable table){
        documentPageObject.search_document(table);
    }

    @Then("^User is able to see document details on the terminate confirmation pop up$")
    public void user_is_able_to_see_document_details_on_the_terminate_confirmation_pop_up(){
        try {
            Assert.assertTrue( documentPageObject.getConfirmation_pop_up_documentversionid().isVisible());
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_documenttype().isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to see document details on the screen");
        }
    }

    @And("^User will click on the terminate button$")
    public void user_will_click_on_the_terminate_button() {
        documentPageObject.getDocumentterminate_btn().click();
    }

    @And("^User is able to see Acting as on the terminate confirmation pop up$")
    public void user_is_able_to_see_acting_as_on_the_terminate_confirmation_pop_up() {
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_actingas().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }

    @And("^User is able to see Action type on the terminate confirmation pop up$")
    public void user_is_able_to_see_action_type_on_the_terminate_confirmation_pop_up(){
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_actiontype().isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }

    @And("^User is able to see cancel and submit button on the terminate confirmation pop up$")
    public void user_is_able_to_see_cancel_and_submit_button_on_the_terminate_confirmation_pop_up(){
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_cancel_btn().isVisible());
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_submit_btn().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }
    @When("^User will search the document to be compared$")
    public void user_will_search_the_document_to_be_compared(DataTable table){
        documentPageObject.search_document(table);
    }

    @Then("^User is on document compare screen$")
    public void user_is_on_document_compare_screen(){
        Assert.assertTrue(documentPageObject.getComparescreen_title().isVisible());
    }
    @Then("^User clicks on the download button$")
    public void user_click_on_Download_button(){
        documentPageObject.clickDocumentDownloadButton();
    }
    @Then("^User validates the file is downloaded$")
    public void user_validates_download(){
        documentPageObject.validateDocumentDownload();
    }
    @And("^User will click on the compare button$")
    public void user_will_click_on_the_compare_button(){
        documentPageObject.getDocumentcompare_btn().waitUntilVisible().click();
    }

    @And("^User can see the Enforced version of the document$")
    public void user_can_see_the_enforced_version_of_the_document() {
        Assert.assertTrue(documentPageObject.getComparescreen_enforcedversion_title().isVisible());
    }

    @And("^User can see the current version of the document$")
    public void user_can_see_the_current_version_of_the_document(){
        Assert.assertTrue(documentPageObject.getComparescreen_currentversion_title().isVisible());
    }
    @Then("^User will select Acting as on the terminate confirmation pop up$")
    public void user_will_select_acting_as_on_the_terminate_confirmation_pop_up(DataTable table){
        documentPageObject.confirmation_popup_actingas(table);
    }
    @And("Click on notification bell icon")
    public void Click_on_notification_bell_icon(){
        documentPageObject.clickNotification_bell();
    }
    @Then("Check if User will be able to see notification in the dialogue box for terminating the document")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_terminating_the_document(){
        Assert.assertTrue(documentPageObject.notificationDocumentTerminated_dialogueBox());
    }
    @Then("Check if User will be able to see notification for Rejecting the document")
    public void Rejection_notification(){
        Assert.assertTrue(documentPageObject.notificationDocumentRejected_dialogueBox());
    }

    @And("^User will select Action type on the terminate confirmation pop up$")
    public void user_will_select_action_type_on_the_terminate_confirmation_pop_up(DataTable table){
        documentPageObject.confirmation_popup_actiontype(table);
    }

    @And("^User will click submit button on the terminate confirmation pop up$")
    public void user_will_click_submit_button_on_the_terminate_confirmation_pop_up(){
        documentPageObject.getConfirmation_pop_up_submit_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        log.info("Clicked on submit to terminate the document");
    }
    @When("^User will search the document to be cancelled$")
    public void user_will_search_the_document_to_be_cancelled(DataTable table) {
        documentPageObject.search_document(table);
    }

    @Then("^User can see the cancel confirmation pop up$")
    public void user_can_see_the_cancel_confirmation_pop_up(){
        try {
            Assert.assertTrue(documentPageObject.getMsg_confirm_delete_document().isVisible());
            Assert.assertTrue(documentPageObject.getNO_Btn_confirm_delete_document().isVisible());
            Assert.assertTrue(documentPageObject.getYES_Btn_confirm_delete_document().isVisible());
        }catch (Exception e){
            log.error("Unable to verify");
            Assert.fail();
        }
    }

    @And("^User will click on the cancel button$")
    public void user_will_click_on_the_cancel_button(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentPageObject.getDocumentcancel_btn());
        documentPageObject.getDocumentcancel_btn().waitUntilClickable().click();
    }
    @Then("^User will give the confirmation to cancel the document$")
    public void user_will_give_the_confirmation_to_cancel_the_document() {
//        documentPageObject.getNO_Btn_confirm_delete_document().click();
        documentPageObject.getYES_Btn_confirm_delete_document().click();
    }
    @When("^User will search the document to be rejected$")
    public void user_will_search_the_document_to_be_rejected(DataTable table) {
        documentPageObject.search_document(table);
    }

    @Then("^User will select Acting as on the reject confirmation pop up$")
    public void user_will_select_acting_as_on_the_reject_confirmation_pop_up(DataTable table) {
        documentPageObject.confirmation_popup_actingas(table);
    }

    @And("^User will click on the reject button$")
    public void user_will_click_on_the_reject_button(){
        if (documentPageObject.getDocumentreject_btn().isVisible()){
            documentPageObject.getDocumentreject_btn().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }else {
            getDriver().close();
        }

    }

    @And("^User will select Action type on the reject confirmation pop up$")
    public void user_will_select_action_type_on_the_reject_confirmation_pop_up(DataTable table){
        documentPageObject.confirmation_popup_actiontype(table);
    }

    @And("^User will click submit button on the reject confirmation pop up$")
    public void user_will_click_submit_button_on_the_reject_confirmation_pop_up(){
        documentPageObject.getConfirmation_pop_up_reject_btn().click();
//        documentPageObject.getConfirmation_pop_up_cancel_btn().click();
    }
    @Then("^User is able to see document details on the reject confirmation pop up$")
    public void user_is_able_to_see_document_details_on_the_reject_confirmation_pop_up(){
        try {
            Assert.assertTrue( documentPageObject.getConfirmation_pop_up_documentversionid().isVisible());
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_documenttype().isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }catch (Exception e){
            log.error("Unable to see document details on the screen");
        }
    }

    @And("^User is able to see Acting as on the reject confirmation pop up$")
    public void user_is_able_to_see_acting_as_on_the_reject_confirmation_pop_up(){
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_actingas().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }

    @And("^User is able to see Approval group on the reject confirmation pop up$")
    public void user_is_able_to_see_action_type_on_the_reject_confirmation_pop_up(){
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_approvalgroup().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }

    @And("^User is able to see cancel and submit button on the reject confirmation pop up$")
    public void user_is_able_to_see_cancel_and_submit_button_on_the_reject_confirmation_pop_up() {
        try {
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_cancel_btn().isVisible());
            Assert.assertTrue(documentPageObject.getConfirmation_pop_up_reject_btn().isVisible());
        }catch (Exception e){
            log.error("Unable to view Acting as");
        }
    }
    @Then("User click on Reject Button on popup")
    public void user_clicks_on_reject_button(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentPageObject.getConfirmation_pop_up_reject_btn().click();
    }
    @Then("Validate the initiator lei in the track")
    public void validateInitiatorLeiInTrack(DataTable table) {
        documentPageObject.validateInitiatorDetails(table);
    }

    @And("User clicks on view all notifications")
    public void user_clicks_on_view_all_notifications() {
        documentPageObject.clickViewAllNotifications();
    }

    @And("User clicks on Set Configuration button")
    public void user_clicks_on_set_configuration_button() {
        documentPageObject.clickSetConfigurationButton();
    }

    @And("user will select Column Values on notification")
    public void user_will_select_column_values_on_notification(DataTable table) {
        documentPageObject.selectNotificationConfigValues(table);
    }



}