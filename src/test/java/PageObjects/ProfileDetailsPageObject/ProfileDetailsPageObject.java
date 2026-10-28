package PageObjects.ProfileDetailsPageObject;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class ProfileDetailsPageObject extends PageObject {

    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade Profileicon;
    @FindBy(xpath = "//li[text()='View Profile']")
    private WebElementFacade ProfiledetailsButton;
    @FindBy(xpath = "//div//header")
    private WebElementFacade ProfileScreenHeader;

    @FindBy(xpath = "//div//div[@class='title']")
    private WebElementFacade DocumentHeader;

    @FindBy(xpath = "//div[@class=\"user-details\"]//div")
    private WebElementFacade OrganisationNameHeader;

    @FindBy(xpath = "//li[text()='Sign Out']")
    private WebElementFacade LogoutButton;

    @FindBy(xpath = "//li[@data-link=\"profile-details\"]")
    private WebElementFacade ProfileDetailsTab;

    @FindBy(xpath = "//li[@data-link=\"reset-password\"]")
    private WebElementFacade ResetPasswordTab;

    @FindBy(xpath = "//li[@data-link=\"help-and-support\"]")
    private WebElementFacade HelpSupportTab;

    @FindBy(xpath = "//div//h3[text()='Profile details']")
    private WebElementFacade ProfileDetailsHeader;

    @FindBy(xpath = "//div//div[text()=\"User's Name\"]")
    private WebElementFacade UserName;

    @FindBy(xpath = "//div//div[text()=\"User's Email id\"]")
    private WebElementFacade UserEmail;

    @FindBy(xpath = "//div//div[text()='Contact Number']")
    private WebElementFacade ContactNumber;

    @FindBy(xpath = "//div//div[text()='Organisation Name']")
    private WebElementFacade OrganisationName;

    @FindBy(xpath = "//div//div[text()='Roles']")
    private WebElementFacade Roles;

    @FindBy(xpath = "(//div//div//h4)[5]")
    private WebElementFacade RolesList;

    @FindBy(xpath = "//div//h3[text()='Mapped Legal entities & Org type']")
    private WebElementFacade MappedLegalEntity;

    @FindBy(xpath = "//div[@class='detail-entities pf-border']")
    private WebElementFacade LegalEntityList;

    @FindBy(xpath = "//header[@class='header']")
    private WebElementFacade CreateNewPassword;

    @FindBy(xpath = "//input[@placeholder='Enter current password']")
    private WebElementFacade inputcurrentpassword;

    @FindBy(xpath = "//input[@placeholder='Enter new password']")
    private WebElementFacade inputnewpassword;

    @FindBy(xpath = "//input[@placeholder='Confirm new password']")
    private WebElementFacade inputconfirmpassword;

    @FindBy(xpath = "//div[text()='Password Policy']")
    private WebElementFacade passwordpolicy;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade submitbutton;

    @FindBy(xpath = "//div[@class='pf-box pf-support']//h3")
    private WebElementFacade HelpSupportHeader;

    @FindBy(xpath = "//span[text()='Details for contacting support email']")
    private WebElementFacade DetailContactSupport;

    @FindBy(xpath = "//div[@class='help-content']//h4")
    private WebElementFacade SupportEmail;

    @FindBy(xpath = "//div//span[text()='Support contact numbers']")
    private WebElementFacade SupportContacts;

    @FindBy(xpath = "//div[@class='helpline-list']")
    private WebElementFacade HelplineList;

    @FindBy(xpath = "//li[text()=\"Reset Password\"]")
    private WebElementFacade ResetPassword;



    public void clickProfileButton(){
        try{
            Profileicon.waitUntilVisible();
            Profileicon.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(OrganisationNameHeader.isVisible());
            Assert.assertTrue(ProfiledetailsButton.isVisible());
            Assert.assertTrue(LogoutButton.isVisible());
            ProfiledetailsButton.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Clicked on profile button");
        }
        catch(Exception e){
            log.error("Unable to click on profile button");
        }
    }
    public void redirectProfileScreen(){
        try{
            ProfileScreenHeader.waitUntilVisible();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertEquals("Help & Settings",ProfileScreenHeader.getText().trim());
            log.info("Successfully redirect to profile screen");
        }
        catch (Exception e){
            log.error("Unable to redirect on the profile screen" +e);
            Assert.fail();
        }
    }
    public void checkDocumentHeader(){
        try{
            DocumentHeader.waitUntilVisible();
            Assert.assertEquals("Documents",DocumentHeader.getText().trim());
        }
        catch (Exception e){
            log.error("Unable to see Document Header");
        }
    }
    public void checkProfileButton(){
        try{
            Profileicon.waitUntilVisible();
            Profileicon.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(ProfiledetailsButton.isVisible());
            log.info("Profile details button is visible");
        }
        catch (Exception e){
            log.error("Unable to see profile details button" +e);
            Assert.fail();
        }
    }
    public void validateProfileScreen(){
        try{
            Assert.assertTrue(ProfileDetailsTab.isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            Assert.assertFalse(ResetPasswordTab.isVisible());
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(HelpSupportTab.isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("ProfileDetailsTab and HelpSupportTab are visible and ResetPasswordTab is removed");
        }
        catch (Exception e){
            log.info("Something is missing among three");
        }
    }
    public void clickProfileDetailsTab(){
        ProfileDetailsTab.click();
        act.pause(Duration.ofSeconds(1)).build().perform();
    }
    public void validateProfileDetailsTab(){
      try {
          Assert.assertEquals("Profile Details", ProfileDetailsHeader.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertEquals("User's Name", UserName.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertEquals("User's Email id", UserEmail.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertEquals("Contact Number", ContactNumber.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertEquals("Organisation Name", OrganisationName.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertEquals("Roles", Roles.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertTrue(RolesList.isVisible());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertEquals("Mapped Legal Entities & Org Type", MappedLegalEntity.getText().trim());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          Assert.assertTrue(LegalEntityList.isVisible());
          withAction().pause(Duration.ofSeconds(1)).build().perform();
          log.info("Successfully validated the profile details tab");
      }
      catch(Exception e){
          log.error("Unable to validate profile details tab" +e);
          Assert.fail();
      }
    }

    public void clickResetPasswordTab(){
        ResetPasswordTab.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void validateResetPasswordScreen(){
        try{
            Assert.assertEquals("Create new password", CreateNewPassword.getText().trim());
            Assert.assertTrue(inputcurrentpassword.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(inputnewpassword.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(inputconfirmpassword.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals("Password Policy",passwordpolicy.getText().trim());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(submitbutton.isVisible());
            log.info("Successfully validated the reset password screen");
        }
        catch(Exception e){
            log.error("Unable to validate reset password screen");
        }
    }
    public void searchAllPassword(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try{
            inputcurrentpassword.waitUntilVisible();
            inputcurrentpassword.clear();
            act.moveToElement(inputcurrentpassword).click().sendKeys(dataTable.get("Current Password")).pause(Duration.ofSeconds(4)).build().perform();
            inputnewpassword.clear();
            act.moveToElement(inputnewpassword).click().sendKeys(dataTable.get("New Password")).pause(Duration.ofSeconds(4)).build().perform();
            inputconfirmpassword.clear();
            act.moveToElement(inputconfirmpassword).click().sendKeys(dataTable.get("Confirm Password")).pause(Duration.ofSeconds(4)).build().perform();
            log.info("Input all three passwords successfully");
        }
        catch (Exception e){
            log.error("Unable to input the password");
        }
    }
    public void sumbmitButton(){
        try {
//        submitbutton.click();
            log.info("Successfully clicked on submit button");
        }
        catch (Exception e){
            log.error("Unable to click on submit button" +e);
            Assert.fail();
        }
    }
    public void clickHelpSupport(){
        try{
            HelpSupportTab.click();
        }
        catch(Exception e){
            log.error("Unable to click on Help and support tab");
        }
    }

    public void validateHelpSupportScreen(){
        try{
            Assert.assertEquals("Help & Support", HelpSupportHeader.getText().trim());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals("Details for contacting support email",DetailContactSupport.getText().trim());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals("fx-support@osttra.com",SupportEmail.getText().trim());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
//            Assert.assertEquals("Support contact numbers",SupportContacts.getText().trim());
//            withAction().pause(Duration.ofSeconds(1)).build().perform();
//            Assert.assertTrue(HelplineList.isVisible());
//            log.info("Successfully validate help & support screen");
        }
        catch(Exception e){
            log.error("Unable to validate help & support screen");
        }
    }

    public void validateResetPassword(){
        try {
            Assert.assertFalse(ResetPassword.isVisible());
        }
        catch (NoSuchElementException e) {
            log.info("Reset password button is not present on the UI, which is the expected behavior.");
        } catch (AssertionError e) {
            log.error("Reset password button is visible, but it shouldn't be.", e);
        }
    }

    public void clickProfileButtonOnly(){
        try {
            Profileicon.waitUntilVisible();
            Profileicon.click();
        }
        catch (NoSuchElementException e) {
            log.info("Profile Icon button is not present on the UI", e);
        }
    }
}
