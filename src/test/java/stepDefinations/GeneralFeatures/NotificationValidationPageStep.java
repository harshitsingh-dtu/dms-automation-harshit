package stepDefinations.GeneralFeatures;

import PageObjects.Documents.DocumentPageObject;
import PageObjects.Notifications.NotificationPageObject;
import PageObjects.Currency.CurrencygroupPageObject;
import PageObjects.Currency.CurrencygroupUpdatePageObject;
import PageObjects.ProductGroup.ProductGroupCreatePageObject;
import PageObjects.ProductGroup.ProductGroupValidationPageObject;
import PageObjects.ProductGroup.ProductGroupUpdatePageObject;
import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import PageObjects.UserManagement.UserManagementPageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class NotificationValidationPageStep extends PageObject {
    NotificationPageObject notificationPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    UserManagementPageObject userManagementPageObject;
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    DocumentTemplateCreatePageObject documentTemplateCreatePageObject;
    CurrencygroupPageObject currencygroupPageObject;
    CurrencygroupUpdatePageObject currencygroupUpdatePageObject;
    ProductGroupUpdatePageObject productGroupUpdatePageObject;
    DocumentPageObject documentPageObject;
    ProductGroupValidationPageObject productGroupValidationPageObject;
    ProductGroupCreatePageObject productGroupCreatePageObject;
    @Given("User will go to landing screen")
    public void user_will_go_to_landing_screen() {
    }
    @Then("User will click on notifications icon")
    public void user_will_click_on_notifications_icon() {
        notificationPageObject.clickNotificationIcon();
    }
    @Then("User will be click on selected or view all notifications")
    public void user_will_be_click_on_selected_or_view_all_notifications() {
        notificationPageObject.clickAllNotification();
    }
    @Then("User is able to verify the notification status")
    public void user_is_able_to_verify_the_notification_status() {
        notificationPageObject.checkAllNotification();
    }
    @Then("User will check the notification for create currency group")
    public void User_will_check_the_notification_for_create_currency_group(){
        notificationPageObject.checknotificationsforcreatecurrencycurrency();
    }
    @Then("User will check the notification for update currency group")
    public void User_will_check_the_notification_for_update_currency_group(){
        notificationPageObject.checknotificationforupdatecurrencygroup();
    }
    @Then("^User will check the notification for create product group$")
    public void User_will_check_the_notification_for_create_product_group(){
        notificationPageObject.checknotificationforcreateproductgroup();
    }
    @Then("User will check the notification for update product group")
    public void User_will_check_the_notification_for_update_product_group(){
        notificationPageObject.checknotificationforupdateproductgroup();
    }
    @Then("^User will check the notification for update document template$")
    public void User_will_check_the_notification_for_update_document_template(){
        notificationPageObject.checknotificationfortemplateupdate();
    }
    @Then("User checks the notification for assigning a role to user")
    public void User_checks_the_notification_for_assigning_a_role_to_user(){
        notificationPageObject.checknotificationforassignrole();
    }
    @Then("User checks the notification for removing a role from user")
    public void User_checks_the_notification_for_removing_a_role_from_user(){
        notificationPageObject.checknotificationforremoverole();
    }
    @Then("^User will check the notification for adding LEI/Org to user$")
    public void User_will_check_the_notification_for_adding_LEI_Org_to_user(){
        notificationPageObject.checknotificationforaddLEIOrg();
    }
    @Then("^User will check the notification for removing LEI/Org from user$")
    public void User_will_check_the_notification_for_removing_LEI_Org_from_user(){
        notificationPageObject.checknotificationforremoveLEIOrg();
    }
    @Then("^User will see the notification to change the status of toggle button$")
    public void User_will_see_the_notification_to_change_the_status_of_toggle_button(){
        notificationPageObject.checkNotificationfortogglebutton();
    }

    @Then("^User will click on approval button$")
    public void User_will_click_on_approval_button(){
//        notificationPageObject.clickApproval_btn();
        withAction().moveToElement(notificationPageObject.getDocumentapprove_btn()).click().build().perform();
    }
    @And("^User will select the approval group and click approve$")
    public void User_will_select_the_approval_group_and_click_approve(DataTable table){
        documentPageObject.confirmation_popup_Approval_Group(table);
    }

    @Then("^User will click on reject icon$")
    public void User_will_click_on_reject_icon(){
//        notificationPageObject.clickrejecticon();
        withAction().moveToElement(notificationPageObject.getDocumentreject_btn()).click().build().perform();
    }
    @And("^User will select the approval group and click reject$")
    public void User_will_select_the_approval_group_and_click_reject(DataTable table){
        documentPageObject.selectapprovalgroup_reject(table);
    }

    @Then("^User will click on cancel icon and select yes$")
    public void User_will_click_on_cance_icon_an_select_yes(){
        notificationPageObject.clickcancelicon();
    }

    @Then("^User will click on terminate icon and select yes$")
    public void User_will_click_on_terminate_icon_and_select_yes(){
        notificationPageObject.clickterminateiconDF();
    }

    @Then("^User will check the notification for document cancelled$")
    public void User_will_check_the_notification_for_document_cancelled(){
        notificationPageObject.checkNotification_canceldocument();
    }
    @Then("^User will click on terminate icon$")
    public void User_will_click_on_terminate_icon(){
//        notificationPageObject.clickterminateicon();
        withAction().moveToElement(notificationPageObject.getDocumentterminate_btn()).click().build().perform();
    }
    @Then("^User will select acting as for edit document$")
    public void User_will_select_acting_as_and_click_submit(DataTable table){
        documentPageObject.confirmation_popup_actingas(table);
    }

    @And("^Search for document version$")
    public void Search_for_document_version(DataTable table){
        documentPageObject.search_document_using_versionid(table);
    }
    @Then("User clicks on Forgot password")
    public void user_clicks_on_Forgot_Password() {
        notificationPageObject.clickForgotPassword();
    }

    @Then("User is able to verify the Email is required notification")
    public void user_verifies_email_required() {
        notificationPageObject.emailRequiredNotification();
    }

    @Then("User waits for {int} seconds")
    public void user_waits(int dur) {
        withAction().pause(Duration.ofSeconds(dur)).build().perform();
    }
    @Then("User is able to check the notification for new draft DF")
    public void User_is_able_to_check_the_notification_for_new_document_draft(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(notificationPageObject.getDraftDocument_Notification().isDisplayed());
    }
    @Then("^User will check the notification for in approval DF$")
    public void User_will_check_the_notification_for_document_approval(){
        Assert.assertTrue(notificationPageObject.getIn_approval_Notification().isVisible());
        Assert.assertTrue(notificationPageObject.getIn_approval_Notification().getText().contains("for OSTTRA needs your review and approval"));
    }
    @Then("^User is able to check the notification for approved DF$")
    public void User_will_check_the_notification_for_approved_DF(){
        Assert.assertTrue(notificationPageObject.getApproved_DF_Notification().isVisible());
        }

    @Then("^User is able to check the notification for terminated DF$")
    public void User_will_check_the_notification_for_Terminated_DF(){
        Assert.assertTrue(notificationPageObject.getTerminated_DF_Notification().isVisible());
    }
    @Then("^User is able to check the notification for edited DF$")
    public void User_will_check_the_notification_for_edited_DF(){
        Assert.assertTrue(notificationPageObject.getEdited_DF_Notification().isVisible());
    }
    @Then("^validate that No notification is sent for expired DF$")
    public void No_notification_for_expired_DF(){
        Assert.assertFalse(notificationPageObject.getNo_Notification_ForExpired_DF().isVisible());
    }
    @Then("^User should not see any notification related to DN$")
    public void No_notification_for_DN(){
        Assert.assertFalse(notificationPageObject.getDN_Notification().isVisible());
    }
}