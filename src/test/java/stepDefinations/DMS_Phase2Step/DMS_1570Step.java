package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1570PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1571PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1767PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
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

public class DMS_1570Step extends PageObject {

    DMS_1570PageObject DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject;

    DMS_1767PageObject DMS1767RequestsDocumentCreationPageObject;
    DMS_1571PageObject dms1571PageObject;

    @Then("User will be able to see role mapping dropdown")
    public void User_will_be_able_to_see_role_mapping_dropdown(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getRole_Mapping1().isDisplayed());
        log.info("Role Mapping is visible");
    }
    @And("User will be able to assign a role")
    public void User_will_be_able_to_assign_a_role(List<String> RolesList){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.assignRole_RequestDocument(RolesList);
    }
    @Then("User check the notification")
    public void User_check_the_notification(){
        Assert.assertEquals("Updated Successfully", DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheck_Notification().getText().trim());
        log.info("Get the notification successfully");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @And("User will logout from the current user")
    public void User_will_logout_from_the_current_user(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickLogout();
    }
    @When("User types in the email id and password whose role has been updated")
    public void User_types_in_the_email_id_and_password_whose_role_has_been_updated(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.enterEmailAndPass(table);
    }

    @Then("Check if User will be able to see the notification in the dialogue box for assigning a role")
    public void Check_if_User_will_be_able_to_see_the_notification_in_the_dialogue_box_for_assigning_a_role(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationAssignRole_dialogueBox();
    }
    @And("User will be able to remove a role")
    public void User_will_be_able_to_remove_a_role(List<String> roles){
        DMS1767RequestsDocumentCreationPageObject.removeRole(roles);
    }
    @Then("Check if User will be able to see the notification in the dialogue box for removing a role")
    public void Check_if_User_will_be_able_to_see_the_notification_in_the_dialogue_box_for_removing_a_role(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationRemoveRole_dialogueBox();
    }
    @Then("User will perform Doc type,LEI and Org type actions and add the combination")
    public void User_will_perform_Doc_type_LEI_and_Org_type_actions_and_add_the_combination(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.docType(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.select_LEI(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.selectOrgType(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.click_Add_btn();
    }
    
    @Then("Check if User will be able to see the notification in the dialogue box for adding a LEI")
    public void Check_if_User_will_be_able_to_see_the_notification_in_the_dialogue_box_for_adding_a_LEI(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationAddLEI_dialogueBox();
    }
    @And("User will select Doc type under added LEI column")
    public void User_will_select_Doc_type_under_added_LEI_column(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.docType_addedLEI(table);
    }
    @And("User will select LEI Name under added LEI column")
    public void User_will_select_LEI_Name_under_added_LEI_column(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.searchLEI_addedLEI(table);
    }
    @And("User will select Org type under added LEI column")
    public void User_will_select_Org_type_under_added_LEI_column(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.orgType_addedLEI(table);
    }
    @Then("No Record found should be displayed in the added LEI column")
    public void No_Record_found_should_be_displayed_in_the_added_LEI_column(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNoRecordFound().isDisplayed());
    }
    @And("User remove the mapping")
    public void User_remove_the_mapping(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickCross_icon();
    }
    @Then("Check if User will be able to see the notification in the dialogue box for removing a LEI")
    public void Check_if_User_will_be_able_to_see_the_notification_in_the_dialogue_box_for_removing_a_LEI(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationRemoveLEI_dialogueBox();
    }
    @And("User change the status of toggle button")
    public void User_change_the_status_of_toggle_button(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.change_toggle_status();
    }
    @Then("User should be able to see notification popup to activate the user")
    public void User_should_be_able_to_see_notification_popup_to_activate_the_user(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.checkNotification_activeUser();
    }
    @Then("Check if User will be able to see the notification in the dialogue box for activating the user")
    public void Check_if_User_will_be_able_to_see_the_notification_in_the_dialogue_box_for_activating_the_user(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationActivateUser_dialogueBox();
    }
    @Then("User should be able to see notification popup to inactivate the user")
    public void User_should_be_able_to_see_notification_popup_to_inactivate_the_user(){
        Assert.assertEquals("DMS User Status updated to in-active", DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNotification_activeInactiveUser().getText().trim());
        log.info("Get the notification to inactivate the user");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @Then("Check if User will be able to get the notification when trying to login with inactive user")
    public void Check_if_User_will_be_able_to_get_the_notification_when_trying_to_login_with_inactive_user(){
        Assert.assertEquals("User is Inactive in Docs!", DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNotification_activeInactiveUser().getText().trim());
        log.info("Get the notification that user is In-active");
    }
    @And("User will be able to assign a role belongs to DN if not assigned")
    public void User_will_be_able_to_assign_a_role_belongs_to_DN_if_not_assigned(List<String> RolesList){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.assignRole(RolesList);
    }
    @And("User will be able to assign a role if not assigned")
    public void User_will_be_able_to_assign_a_role_if_not_assigned(List<String> RolesList){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.assignRole_RequestDocument(RolesList);
    }
    @And("User will be able to add the LEI belongs to DN if not added")
    public void User_will_be_able_to_add_the_LEI_belongs_to_DN_if_not_added(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.addLEI_ifNotAdded(table);
    }
    @Then("User will check mapped legal entity, Org type and click on organisations- Online")
    public void User_will_check_mapped_legal_entity_Org_type_and_click_on_organisations_Online(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.checkLegalEntity_OrgType_Online(table);
    }
    @Then("User will check mapped legal entity, Org type and click on organisations- Lite")
    public void User_will_check_mapped_legal_entity_Org_type_and_click_on_organisations_Lite(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.checkLegalEntity_OrgType_Lite(table);
    }
    @Then("Check if User will be able to see notification in the dialogue box for the status change")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_the_status_change(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationStatusChange_dialogueBox();
    }
    @Then("Check if User will be able to get the notification in the dialogue box for adding a user to the approval group")
    public void Check_if_User_will_be_able_to_get_the_notification_in_the_dialogue_box_for_adding_a_user_to_the_approval_group(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationAddUserApprovalGroup_dialogueBox();
    }
    @Then("Check if User will be able to get the notification in the dialogue box for removing a user from the approval group")
    public void Check_if_User_will_be_able_to_get_the_notification_in_the_dialogue_box_for_removing_a_user_from_the_approval_group(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationRemoveUserApprovalGroup_dialogueBox();
    }
    @Then("User fills in the Group name,Organization,Doc type,LEI's,Org type")
    public void User_fills_in_the_Group_name_Organization_Doc_type_LEI_s_Org_type(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_group_name();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_organization_name();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_doc_type(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_leis();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_org_type(table);
    }
    @Then("User will redirected to the second screen and add user to approval group")
    public void User_will_redirected_to_the_second_screen_and_add_user_to_approval_group(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.addUser();
    }
    @And("User will be able to see and fill organization filter,LEI filter,org type filter,doc type filter in all the fields")
    public void User_will_be_able_to_see_and_fill_organization_filter_LEI_filter_org_type_filter_doc_type_filter_in_all_the_fields(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_organization_name();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_doc_type(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_leis();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_org_type(table);
    }
    @Then("Check if User will be able to see notification in the dialogue box for adding the approval group to the approval matrix")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_adding_the_approval_group_to_the_approval_matrix(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationAddApprovalGroup_ApprovalMatrix_dialogueBox();
    }
    @Then("User search for the organisation name")
    public void User_search_for_the_organisation_name(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.searchApprovalMatrix();
    }
    @And("User will select the LEI filter, Doc type and Org type filter on approval matrix listing screen")
    public void User_will_select_the_LEI_filter_Doc_type_and_Org_type_filter_on_approval_matrix_listing_screen(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.selectLEI();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_org_type(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_doc_type(table);
    }
    @Then("User should not be able to see removed approval group on update screen")
    public void User_should_not_be_abl_to_see_removed_approval_group_on_update_screen(){
        Assert.assertFalse(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getRemoved_approvalGrp().isVisible());
    }
    @Then("Check if User will be able to see notification in the dialogue box for removing the approval group from the approval matrix")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_removing_the_approval_group_from_the_approval_matrix(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationRemoveApprovalGroup_ApprovalMatrix_dialogueBox();
    }
    @And("User will Enter input for Document type")
    public void user_will_enter_input_for_document_type(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterDocType(table);
    }
    @And("User will Enter input for Acting As")
    public void User_will_Enter_input_for_Acting_As(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterActingAs(table);
    }
    @Then("user is able to see corresponding parties")
    public void user_is_able_to_see_corresponding_parties(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getSelectParties_text().isVisible());
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getPrimeBroker1Filter().isVisible());
        if(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getExecutingBroker1Filter().isVisible()){
            Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getExecutingBroker1Filter().isVisible());
        }
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getClient1Filter().isVisible());
    }


    @And("User will select document template from document template dropdown")
    public void User_will_select_document_template_from_document_template_dropdown(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.SelectDocumentTemplate();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @And("user will click on next button and redirected to edit document screen")
    public void user_will_click_on_next_button_and_redirected_to_edit_document_screen(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNext_button().isVisible());
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(9)).build().perform();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getEditDocument_text().waitUntilVisible();
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getEditDocument_text().isVisible());
    }
    @And("user is able to see approval workflow tab and their respective information")
    public void user_is_able_to_see_approval_workflow_tab_and_their_respective_information(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getParticipants_text().isVisible());
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getInitiator_button().isVisible());
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getPrimeBroker1_button().isVisible());
        if (DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getExecutingBroker1_button().isVisible()) {
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getExecutingBroker1_button().isVisible());
        }
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getClient1_button().isVisible());
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getApprovalworkflow_table().isVisible());
    }

//    @And("User will click on the next button and reached the Legal term Screen")
//    public void User_will_click_on_the_next_button_and_reached_the_Legal_term_Screen(){
//        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNext_button().click();
//        withAction().pause(Duration.ofSeconds(10)).build().perform();
//        getDMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject().gettextboxDocumentTerms().waitUntilVisible();
//        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.gettextboxDocumentTerms().isVisible());
//    }
    @And("User will click on preview and submit button")
    public void User_will_click_on_preview_and_submit_button(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.click_previewSubmit();
    }
    @And("User should be able to check notification for in approval")
    public void User_should_be_able_to_check_notification_for_in_approval(){
        Assert.assertEquals("Document is In-approval", DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheck_Notification().getText().trim());
        log.info("Get the notification document is in approval");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @And("Check if User will be able to see notification in the dialogue box for in approval")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_in_approval(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationDocumentInApproval_dialogueBox();
    }
    @And("User will enter terms in Legal Terms")
    public void user_will_enter_terms_in_Legal_Terms(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectLegalTerms(table);
    }
    @And("User will select the Auth Product Group")
    public void user_will_select_the_auth_product_group(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectAuthProductGroup(table);
    }
    @And("User will add the Currencies group")
    public void user_will_add_the_currencies_group(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectCurrenciesGroup(table);
    }
    @And("User will input the Auth Tenor value")
    public void user_will_input_the_auth_tenor_value(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectAuthTenorvalue(table);
    }
    @And("User will select the tenor in Auth Tenor")
    public void user_select_the_tenor_in_auth_tenor(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectAuthTenor(table);
    }
    @And("User will input the Calculation Type")
    public void user_will_input_the_calculation_type(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectCalculationType(table);
    }
    @And("User will input the Limit Value")
    public void user_will_input_the_limit_value(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectLimitValue(table);
    }
    @And("User will input the Netting Type")
    public void user_will_input_the_netting_type(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectNettingType(table);
    }
    @And("User will input the Delta")
    public void user_will_input_the_delta(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectDelta(table);
    }
    @And("User will input the Product family")
    public void user_will_input_the_product_family(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectProductFamily(table);
    }
    @And("User will input the Exclude CLS from calculation")
    public void user_will_input_the_exclude_cls_from_calculation(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.clickSelectExcludeCLS(table);
    }
    @When("User set the filter on document screen")
    public void user_set_the_filter_as_in_approval(DataTable table) {
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.check_if_filterStatus_and_type(table);
    }
    @And("User set the filter for Doc type")
    public void User_set_the_filter_for_Doc_type(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.enter_docType(table);
    }
    @And("User will select Acting as on Approve confirmation popup")
    public void User_will_select_Acting_as_on_Approve_confirmation_popup(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.confirmation_popup_actingAs();
    }
    @And("User will select the approval group on confirmation popup and click approve")
    public void User_will_select_the_approval_group_on_confirmation_popup_and_click_approve(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.confirmation_popup_Approval_Group();
    }
    @Then("User will check notification for document approval")
    public void User_will_check_notification_for_document_approval(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheck_Notification().isVisible());
        log.info("Get the notification for approve document");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @Then("Check if User will be able to see notification in the dialogue box for approving the document")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_approving_the_document(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationDocumentApproved_dialogueBox();
    }
    @And("User will select Acting as on Reject confirmation popup")
    public void User_will_select_Acting_as_on_Reject_confirmation_popup(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.confirmation_popup_actingAs();
    }
    @And("User will select the approval group on confirmation popup and click reject")
    public void User_will_select_the_approval_group_on_confirmation_popup_and_click_reject(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.confirmation_popup_Approval_Group();
    }
    @Then("User will check notification for document rejected")
    public void User_will_check_notification_for_document_rejected(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheck_Notification().isVisible());
        log.info("Get the notification for reject document");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @Then("Check if User will be able to see notification in the dialogue box for rejecting the document")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_rejecting_the_document(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationDocumentRejected_dialogueBox();
    }

    @Then("User check the notification for document cancelled")
    public void User_check_the_notification_for_document_cancelled(){
        Assert.assertEquals("Document Version Updated", DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheckNotification_cancelButton().getText().trim());
        log.info("Get the notification for cancelling the document");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @Then("Check if User will be able to see notification in the dialogue box for cancelling the document")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_cancelling_the_document(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationDocumentCanceled_dialogueBox();
    }
    @And("User will select Acting as on Terminate confirmation popup and submit")
    public void User_will_select_Acting_as_on_Terminate_confirmation_popup_and_submit(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.confirmation_popup_actingAs();
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getSubmit_btn().isEnabled());
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getSubmit_btn().click();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @Then("User check the notification for document terminated")
    public void User_check_the_notification_for_document_terminated(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheck_Notification().isVisible());
        withAction().pause(Duration.ofSeconds(6)).build().perform();
    }

    @And("User will click on Save As Draft button")
    public void User_will_click_on_Save_As_Draft_button(){
        if (DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getSaveAsDraft_btn().isEnabled()){
            DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getSaveAsDraft_btn().click();
            Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getCheck_Notification().isVisible());
            withAction().pause(Duration.ofSeconds(8)).build().perform();
        }
    }
    @Then("Check if User will be able to see notification in the dialogue box for saving the document as draft")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_saving_the_document_as_draft(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationDocumentDraft_dialogueBox();
    }
    @Then("User will click on Edit icon")
    public void User_will_click_on_Edit_icon(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getEdit_btn().waitUntilVisible();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getEdit_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @And("User will select Acting as on Enforced confirmation popup")
    public void User_will_select_Acting_as_on_Enforced_confirmation_popup(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.confirmation_popup_actingAs();
    }
    @And("User will select Action type and click submit")
    public void User_will_select_Action_type_and_click_submit(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.selectActionType_Edit(table);
    }
//    @Then("User will search for document version ID")
//    public void User_will_search_for_document_version_ID(DataTable table){
//        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.search_document_using_version_id(table);
//    }
    @And("User should see the document in approved state")
    public void User_should_see_the_document_in_approved_state(){
        Assert.assertTrue(DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getApproved_state().isVisible());
    }
    @Then("User will wait till the document changes to enforced state")
    public void User_will_wait_till_the_document_changes_to_enforced_state(){
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }
    @Then("Check if User will be able to see notification in the dialogue box for enforcing the document")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_enforcing_the_document(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.notificationDocumentEnforced_dialogueBox();
    }
    @When("user will click on next button and redirected to enforcement rule page")
    public void user_will_click_on_next_button_and_redirected_to_enforcement_rule_page(){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
}
