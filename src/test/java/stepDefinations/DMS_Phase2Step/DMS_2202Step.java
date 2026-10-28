package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.Approval_groups_matrix_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2202PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.With;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2202Step extends PageObject {

    DMS_2202PageObject dms2202PageObject;

    Approval_groups_matrix_PageObject approval_groups_matrix_PageObject;
    @And("Click on USP rider template tab under Groups and Template tab")
    public void Click_on_USP_rider_template_tab_under_Groups_and_Template_tab(){
        dms2202PageObject.clickOnUSPRiderTemplateTabUnderGroupsTemplateTab();
    }
    @Then("Update button should be visible on USP Rider Template listing screen as per assigned roles")
    public void Update_button_should_be_visible_on_USP_Rider_Template_listing_screen_as_per_assigned_roles(DataTable table){
        approval_groups_matrix_PageObject.ColumnAndColumnValueCheck(table);
    }
    @Then("Update button should not be visible on USP Rider Template listing screen as per assigned roles")
    public void Update_button_should_not_be_visible_on_USP_Rider_Template_listing_screen_as_per_assigned_roles(DataTable table){
        approval_groups_matrix_PageObject.ColumnAndColumnValueCheck(table);
    }
    @Then("View button should be visible on USP Rider Template listing screen as per assigned roles")
    public void View_button_should_be_visible_on_USP_Rider_Template_listing_screen_as_per_assigned_roles(DataTable table){
        approval_groups_matrix_PageObject.ColumnAndColumnValueCheck(table);
    }
    @Then("User will be redirected to USP Rider template listing screen")
    public void User_will_be_redirected_to_USP_Rider_template_listing_screen(){
        Assert.assertTrue(dms2202PageObject.getRedirected_USPListingScreen().isVisible());
    }
    @And("Click on Update button of USP Template listing screen")
    public void Click_on_Update_button_of_USP_Template_listing_screen(){
        dms2202PageObject.getUpdateButton_USPListingScreen().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User should be redirected to update screen and validate elements on update screen of USP Rider template")
    public void User_should_be_redirected_to_update_screen_and_validate_elements_on_update_screen_of_USP_Rider_template(){
        Assert.assertTrue(dms2202PageObject.getUpdateScreen_USPRider().isVisible());
        Assert.assertTrue(dms2202PageObject.getSelectedDocType_USPRiderTempUpdateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getPrimeBrokerName_USPCreateTemplateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getClientName_USPCreateTemplateScreen().isVisible());
        dms2202PageObject.validateUpdateScreen_USPRiderTemplate();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dms2202PageObject.getPbCounterParty_USPUpdateTemplateScreen());
        Assert.assertTrue(dms2202PageObject.getPbCounterParty_USPUpdateTemplateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getCancelButton_USPCreateTemplateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getSubmitButton_USPCreateTemplateScreen().isVisible());
    }
    @And("Click on View button of USP Template listing screen")
    public void Click_on_View_button_of_USP_Template_listing_screen(){
        dms2202PageObject.getViewButton_USPListingScreen().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User should be redirected to view screen and validate corresponding information on view screen of USP Rider template")
    public void User_should_be_redirected_to_view_screen_and_validate_corresponding_information_on_view_screen_of_USP_Rider_template(){
        Assert.assertTrue(dms2202PageObject.getViewScreen_USPRider().isVisible());
        Assert.assertTrue(dms2202PageObject.getSelectedDocType_USPRiderTempUpdateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getPrimeBrokerName_USPCreateTemplateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getClientName_USPCreateTemplateScreen().isVisible());
        if (dms2202PageObject.getPbContactWordClauseValue_USPListingScreen().isVisible()){
            Assert.assertTrue(dms2202PageObject.getPbContactWordClauseValue_USPListingScreen().isVisible());
        }
        Assert.assertTrue(dms2202PageObject.getPbCounterParty_USPViewTemplateScreen().isVisible());
    }
    @And("User will select Doc type on USP Rider listing screen and check results for update button")
    public void User_will_select_Doc_type_on_USP_Rider_listing_screen_and_check_results_for_update_button(List<String> docType){
        dms2202PageObject.selectDocTypeUpdate_USPTempListingScreen(docType);
    }
    @And("when again user will select Doc type on USP Rider listing screen and check results for update button")
    public void when_again_user_will_select_Doc_type_on_USP_Rider_listing_screen_and_check_results_for_update_button(List<String> docType){
        dms2202PageObject.selectDocTypeDNUpdate_USPTempListingScreen(docType);
    }
    @And("User will select Doc type on USP Rider listing screen and check results for view button")
    public void User_will_select_Doc_type_on_USP_Rider_listing_screen_and_check_results_for_view_button(List<String> docType){
        dms2202PageObject.selectDocTypeView_USPTempListingScreen(docType);
    }
    @And("when again user will select Doc type on USP Rider listing screen and check results for view button")
    public void when_again_user_will_select_Doc_type_on_USP_Rider_listing_screen_and_check_results_for_view_button(List<String> docType){
        dms2202PageObject.selectDocTypeDNView_USPTempListingScreen(docType);
    }
    @And("User will select both Doc type on USP Rider listing screen and check results for view button")
    public void User_will_select_both_Doc_type_on_USP_Rider_listing_screen_and_check_results_for_view_button(List<String> docType){
        dms2202PageObject.select_bothDocType(docType);
    }

    @And("Make some changes on USP update screen")
    public void Make_some_changes_on_USP_update_screen(List<String> pBContact){
        dms2202PageObject.enterPBContact_USPUpdateScreen(pBContact);
    }
    @Then("Submit button should be enabled on USP template update screen")
    public void Submit_button_should_be_enabled_on_USP_template_update_screen(){
        Assert.assertTrue(dms2202PageObject.getSubmitButton_USPCreateTemplateScreen().isEnabled());
        log.info("Submit button is enabled on USP Template update screen");
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("Click on submit button of USP Template update screen")
    public void Click_on_submit_button_of_USP_Template_update_screen(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        dms2202PageObject.getSubmitButton_USPCreateTemplateScreen().click();
    }
    @Then("Popup asking to view impacted documents and toast message should be visible on USP Template update screen")
    public void Popup_asking_to_view_impacted_documents_and_toast_message_should_be_visible_on_USP_Template_update_screen(){
        Assert.assertTrue(dms2202PageObject.getImpactedDocumentPopup_USPTempUpdateScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getUpdateToastMessage_impactedDocument().getText().trim().equalsIgnoreCase("Usprider template updated"));
        log.info("Impacted document popup and toast message is visible");
    }
    @And("Validate information or feature present on impacted documents popup screen")
    public void Validate_information_or_feature_present_on_impacted_documents_popup_screen(){
        Assert.assertTrue(dms2202PageObject.getConfirmationText_impactedDocumentsPopup().isVisible());
        Assert.assertTrue(dms2202PageObject.getMessageText_impactedDocumentsPopup().isVisible());
        Assert.assertTrue(dms2202PageObject.getNoButton_impactedDocumentsPopup().isVisible());
        Assert.assertTrue(dms2202PageObject.getYesButton_impactedDocumentsPopup().isVisible());
    }
    @And("When clicked on submit button then user will be able to see changes for recently updated field")
    public void When_clicked_on_submit_button_then_user_will_be_able_to_see_changes_for_recently_updated_field(){
        dms2202PageObject.seeChanges_UpdatedField();
    }
    @And("When clicked on cancel button then user will not be able to see changes for recently updated field")
    public void When_clicked_on_cancel_button_then_user_will_not_be_able_to_see_changes_for_recently_updated_field(){
        dms2202PageObject.notSeeChanges_UpdatedField();
    }
    @And("Click on Yes button of impacted documents popup screen")
    public void Click_on_Yes_button_of_impacted_documents_popup_screen(){
        dms2202PageObject.getYesButton_impactedDocumentsPopup().click();
    }
    @And("Validate impacted documents drawer screen")
    public void Validate_impacted_documents_drawer_screen(){
        Assert.assertTrue(dms2202PageObject.getCloseButton_impactedDocumentsDrawerScreen().isVisible());
        Assert.assertTrue(dms2202PageObject.getApplyButton_impactedDocumentsDrawerScreen().isVisible());
        dms2202PageObject.validateImpactedDocuments_drawerScreen();
    }
    @Then("Select document if found and click apply button on impacted documents drawer screen")
    public void Select_document_if_found_and_click_apply_button_on_impacted_documents_drawer_screen(){
        dms2202PageObject.selectAllDocumentCheckbox_impactedDocumentsDrawerScreen();
        dms2202PageObject.getApplyButton_impactedDocumentsDrawerScreen().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("In case of lite users lite users alert screen should be visible with email option and submit button")
    public void In_case_of_lite_users_lite_users_alert_screen_should_be_visible_with_email_option_and_submit_button(){
        dms2202PageObject.getLiteUsersAlert_impactedDocumentsDrawerScreen().waitUntilVisible();
        Assert.assertTrue(dms2202PageObject.getLiteUsersAlert_impactedDocumentsDrawerScreen().isVisible());
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(dms2202PageObject.getSubmitButton_USPCreateTemplateScreen().isVisible());
    }
    @And("User will click on submit button of impacted documents drawer screen")
    public void User_will_click_on_submit_button_of_impacted_documents_drawer_screen(){
        dms2202PageObject.getSubmitButton_USPCreateTemplateScreen().click();
    }
    @Then("User should be redirected to bulk request screen after impacted documents drawer screen")
    public void User_should_be_redirected_to_bulk_request_screen_after_impacted_documents_drawer_screen(){
        dms2202PageObject.getBulkRequestText_impactedDocumentsDrawerScreen().waitUntilVisible();
        Assert.assertTrue(dms2202PageObject.getBulkRequestText_impactedDocumentsDrawerScreen().isVisible());
        log.info("Redirected to bulk request screen");
    }
    @And("Only DN related USP Rider Templates will be visible correspondence with update button")
    public void Only_DN_related_USP_Rider_Templates_will_be_visible_correspondence_with_update_button(){
        dms2202PageObject.checkDNRelatedUSPTemplates();
    }
    @And("Only 4 Way related USP Rider Templates will be visible correspondence with update button")
    public void Only_4_Way_related_USP_Rider_Templates_will_be_visible_correspondence_with_update_button(){
        dms2202PageObject.checkFourWayRelatedUSPTemplates();
    }
    @And("Validate usp rider listing screen element")
    public void Validate_usp_rider_listing_screen_element(){
        dms2202PageObject.Validate_usp_rider_listing_screen_element();

    }
}
