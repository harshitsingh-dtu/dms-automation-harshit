package PageObjects.Notifications;

import PageObjects.Documents.DocumentCreateNewPageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
@Slf4j
@Data
public class NotificationPageObject extends PageObject {

    DocumentCreateNewPageObject documentCreateNewPageObject;
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//div[@class='notification-icon profile-icon']")
    private WebElementFacade notificationIcon;
    @FindBy(xpath = "//*[text()='View all Notifications']")
    private WebElementFacade allNotifications;
    @FindBy(xpath = "//*[text()='Showing all notifications']")
    private WebElementFacade allNotificationsText;
    @FindBy(xpath = "//*[text()='Forgot password']")
    private WebElementFacade ForgotPassword;
    @FindBy(xpath = "//*[text()=\"Email is required\"]")
    private WebElementFacade emailRequired;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Document workflow updated successfully']")
    private WebElementFacade checkNotification_documentDraft;
    @FindBy(xpath = "//button[text()=\"Save as Draft\"]")
    private WebElementFacade saveAsDraft_btn;
    @FindBy(xpath = "//div[@class=\"drag-box  \"][text()='Prime Broker - 1']")
    private WebElementFacade PB1_participant;
    @FindBy(xpath = "(//div//*[text()='Drag and Drop here the participant'])[1]")
    private WebElementFacade approvalSeq1;
    @FindBy(xpath="//div[@role='alert']")
    private WebElementFacade check_Notifications;
    @FindBy(xpath="//div[@role='alert']//div[text()='Document Version Updated']")
    private WebElementFacade checkNotification_cancelButton;
    @FindBy(xpath ="//button//img[@alt='Approve']")
    private WebElementFacade documentapprove_btn;
    @FindBy(xpath = "//button//img[@alt='Reject']")
    private WebElementFacade documentreject_btn;
    @FindBy(xpath = "//button//img[@alt='Terminate']")
    private WebElementFacade documentterminate_btn;
    @FindBy(xpath="//div//button[text()='Submit']")
    private WebElementFacade submit_button;
    @FindBy(xpath="//span[@data-testid='notification-title' and contains(text(), 'Add document draft for participant')]")
    private WebElementFacade DraftDocument_Notification;
    @FindBy(xpath="//*[contains(text(),'Approval sequence notification')]/span")
    private WebElementFacade In_approval_Notification;
    @FindBy(xpath="//*[contains(text(),'Document Approved Notification')]")
    private WebElementFacade Approved_DF_Notification;
    @FindBy(xpath="//*[contains(text(),'Document Terminated Notification')]")
    private WebElementFacade Terminated_DF_Notification;
    @FindBy(xpath="//*[contains(text(),'Edit document draft for participant')]")
    private WebElementFacade Edited_DF_Notification;
    @FindBy(xpath="//div[contains(text(),'expired')]")
    private WebElementFacade No_Notification_ForExpired_DF;

    @FindBy(xpath ="//div[@role='alert']//div[text()='DMS User Status updated to in-active']")
    private WebElementFacade InactiveUser_notification;
    @FindBy(xpath ="//div[@role='alert']//div[text()='Updated Successfully']")
    private WebElementFacade checkNotificationLEIOrg;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Updated Successfully']")
    private  WebElementFacade checkNotification_assignRole;

    @FindBy(xpath = "//div[@role='alert']//div[text()='Updated Successfully']")
    private  WebElementFacade checkNotification_removeRole;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Document Template Updated successfully']")
    private WebElementFacade checkNotificationupdatetemplate;
    @FindBy(xpath = "//div[@role='alert']//div[text()='product group updated successfully']")
    private WebElementFacade checkNotificationUpdate;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Product Group Added Successfully']")
    private WebElementFacade checkNotification;
    @FindBy(xpath = "//div[text()='Records updated successfully']")
    private WebElementFacade updateGroup_notification;
    @FindBy(xpath = "//div[@role=\"alert\"]//div[text()='Records created successfully']")
    private WebElementFacade createGroup_notification;
    @FindBy(xpath = "//button//img[@alt='Cancel']")
    private WebElementFacade documentcancel_btn;
    @FindBy(xpath = "//button//img[@alt='Terminate']")
    private WebElementFacade DFterminate_btn;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade YES_Btn_confirm_delete_document;

    @FindBy(xpath="//*[contains(text(),'DN-')]")
    private WebElementFacade DN_Notification;

    public void checknotificationfortemplateupdate(){
        try{
            checkNotificationupdatetemplate.waitUntilVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals("Document Template Updated successfully", checkNotificationupdatetemplate.getText().trim());
            log.info("Get the notification for Update document template");
        }
        catch (Exception e){
            log.error("Unable to get the notification for Update document template" +e);
            Assert.fail();
        }
    }
    public void checknotificationsforcreatecurrencycurrency(){
        try{
            Assert.assertEquals("Records created successfully", createGroup_notification.getText().trim());
            log.info("Get the notification for Currency group created successfully");
        }
        catch (Exception e){
            log.error("Unable to get notification for create currency group" +e);
            Assert.fail();
        }
    }
    public void checknotificationforupdatecurrencygroup(){
        try{
            updateGroup_notification.waitUntilVisible();
            act.pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertEquals("Records updated successfully", updateGroup_notification.getText().trim());
            log.info("Get the notification for Currency group updated successfully");
        }
        catch (Exception e){
            log.error("Unable to get the notification for update currency group" +e);
            Assert.fail();
        }
    }
    public void checknotificationforcreateproductgroup(){
        try{
            checkNotification.waitUntilVisible();
            Assert.assertEquals("Product Group Added Successfully", checkNotification.getText().trim());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            log.info("Get notification for create product group");
        }
        catch (Exception e){
            log.error("Unable to get notification for create product group" +e);
            Assert.fail();
        }
    }
    public void checknotificationforupdateproductgroup(){
        try{
            checkNotificationUpdate.waitUntilVisible();
            Assert.assertEquals("product group updated successfully", checkNotificationUpdate.getText().trim());
            log.info("Get the notification for Update product group");
        }catch (Exception e){
            log.error("Unable to get the notification for Update product group" +e);
            Assert.fail();
        }
    }
    public void clickNotificationIcon(){
        Assert.assertTrue(notificationIcon.isVisible());
        notificationIcon.waitUntilClickable().click();
        log.info("Clicked on the notification icon");
    }
    public void clickAllNotification(){
        act.pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(allNotifications.isVisible());
        allNotifications.waitUntilClickable().click();
        log.info("Clicked on view all notification");
    }
    public void checkAllNotification(){
        act.pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(allNotificationsText.isVisible());
        //allNotificationsText.waitUntilClickable().click();
        log.info("Showing all notifications");
    }
    public void checkNotificationfortogglebutton(){
        try{
            InactiveUser_notification.waitUntilVisible();
            Assert.assertEquals("DMS User Status updated to in-active",InactiveUser_notification.getText().trim());
            log.info("Get the notification to change the status to inactive");
        }
        catch (Exception e){
            log.error("Unable to get the notification to change the status");
            Assert.fail();
        }
    }
    public void checknotificationforremoveLEIOrg(){
        try{
            checkNotificationLEIOrg.waitUntilVisible();
            Assert.assertEquals("Updated Successfully",checkNotificationLEIOrg.getText().trim());
            log.info("Get the notification to remove LEI/Org from the user");
        }
        catch (Exception e){
            log.error("Unable to get the notification to remove LEI/Org from user" +e);
            Assert.fail();
        }
    }
    public void checknotificationforaddLEIOrg(){
        try{
            checkNotificationLEIOrg.waitUntilVisible();
            Assert.assertEquals("Updated Successfully",checkNotificationLEIOrg.getText().trim());
            log.info("Get the notification to add LEI/Org to the user");
        }
        catch (Exception e){
            log.error("Unable to get the notification to add LEI/Org to user" +e);
            Assert.fail();
        }
    }

    public void checknotificationforremoverole(){
        try {
            checkNotification_removeRole.waitUntilVisible();
            Assert.assertEquals("Updated Successfully", checkNotification_removeRole.getText().trim());
            log.info("Get the notification for removing a role");
        }
        catch (Exception e){
            log.error("Unable to get the notification for removing a role" +e);
            Assert.fail();
        }
    }
    public void checknotificationforassignrole(){
        try{
            checkNotification_assignRole.waitUntilVisible();
            Assert.assertEquals("Updated Successfully", checkNotification_assignRole.getText().trim());
            log.info("Get the notification for assigning a role");
        }
        catch (Exception e){
            log.error("Unable to get the notification for assigning a role" +e);
            Assert.fail();
        }
    }

    public void checkNotification_canceldocument(){
        try{
            checkNotification_cancelButton.waitUntilVisible();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertEquals("Document Version Updated",checkNotification_cancelButton.getText().trim());
            log.info("Get the notification for cancelling the document");
        }
        catch (Exception e){
            log.error("Unable to get the notification for cancelling the document" +e);
            Assert.fail();
        }
    }

    public void clickcancelicon(){
        try{
            documentcancel_btn.waitUntilVisible();
            documentcancel_btn.waitUntilClickable().click();
            log.info("Clicked on cancel icon");
            YES_Btn_confirm_delete_document.waitUntilVisible();
            YES_Btn_confirm_delete_document.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            log.info("Clicked on Yes Button");
        }
        catch (Exception e){
            log.error("Unable to click on cancel icon" +e);
            Assert.fail();
        }
    }

    public void clickterminateiconDF(){
        try{
            DFterminate_btn.waitUntilVisible();
            DFterminate_btn.waitUntilClickable().click();
            log.info("Clicked on cancel icon");
            YES_Btn_confirm_delete_document.waitUntilVisible();
            YES_Btn_confirm_delete_document.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            log.info("Clicked on Yes Button");
        }
        catch (Exception e){
            log.error("Unable to click on cancel icon" +e);
            Assert.fail();
        }
    }

//    public void clickterminateicon(){
//        try{
//            documentterminate_btn.waitUntilVisible();
//            documentterminate_btn.waitUntilClickable().click();
//            log.info("Clicked on terminate icon");
//        }
//        catch (Exception e){
//            log.error("Unable to click on terminate icon");
//            Assert.fail();
//        }
//    }
public void clickForgotPassword(){
    act.pause(Duration.ofSeconds(2)).build().perform();
    $(ForgotPassword).click();
    Assert.assertTrue(ForgotPassword.isVisible());

}

    public void emailRequiredNotification(){
        act.pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(emailRequired.isVisible());

    }

    public void waitTime(int dur){
        act.pause(Duration.ofSeconds(dur)).build().perform();
    }
}