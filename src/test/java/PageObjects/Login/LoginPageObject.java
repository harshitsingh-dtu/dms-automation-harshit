package PageObjects.Login;

import PageObjects.OrgManagement.OrgManagementPageObject;
import Utilities.ConfigFileReader;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class LoginPageObject extends PageObject {

    Robot robot = new Robot();
    ConfigFileReader configfileReader=new ConfigFileReader();
    Connection connection;
    private String Email;
    private String Password;
    OrgManagementPageObject orgManagementPageObject;
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//input[@placeholder='Enter registered email id']")
    private WebElementFacade username;
    @FindBy(xpath = "//input[@type='password']")
    private WebElementFacade pass;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade submit;
    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profile;
    @FindBy(xpath = "//div[@class='Toastify']//div[@role='alert']")
    private WebElementFacade usernotfound_alert;
    @FindBy(xpath = "//*[text()='Sign Out']")
    private WebElementFacade logout_btn;
    @FindBy(xpath = "//img[@src='/container/latest/a0b505d17aff9f21d1f9c62b50ce977d.svg']")
    private WebElementFacade Main_Page_Logo;
    @FindBy(xpath = "//div[@class='header-wrapper']//img[@src='/container/latest/2f805e88389181e764b407e10890bbc8.svg']")
    private WebElementFacade Internal_Page_Logo;
    @FindBy(xpath = "//div//a")
    private WebElementFacade forgot_btn;
    @FindBy(xpath = "//div//div[text()='A password reset link has been sent to your email. Please check your inbox.']")
    private WebElementFacade resetLinkPopup;

    public LoginPageObject() throws AWTException {
    }


    public void typesmail(List<String> email){
        try {
            open();
            typeInto(username,email.get(1));
            log.info("Types in the username");
        }catch (Exception e){
            Assert.fail("Not able to type username");
            log.error("Not able to type username "+e);
        }
    }
    public void typePassword(List<String> Password){
        try{
            pass.sendKeys(Password.get(1));
            log.info("Types in the password");
        }catch (Exception e){
            log.error("Not able to type password");
        }
    }
    public void clicksubmit(){
        try {
            submit.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Not able to log in");
        }
    }
    public void checkifprofilevisible(){
        try {
            Assert.assertTrue(profile.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            log.info("On the homepage");
        }catch (AssertionError e){
            log.error("Not able to view user profile");
            Assert.fail();
        }
    }
    public void checkifUsernotFoundAlert(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            usernotfound_alert.waitUntilPresent();
            log.info("Alert was found");
        }catch (AssertionError e){
            log.error("Not able to capture the Alert");
            Assert.fail();
        }
    }
    public void clickLogout(){
        try {
            profile.click();
            logout_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(8)).build().perform();
        }catch (Exception e){
            log.error("Not able to logout -->"+e);
            Assert.fail();
        }
}
    public void checkifonLoginscreen(){
        try {
            //url check
            String url=getDriver().getCurrentUrl();
            waitOnPage();
            Assert.assertEquals("https://qa-docs-osttra.traianaops.luminatesec.com/login",url);
            log.info("Back on login screen");

        }catch (Exception e){
            log.error("unable to confirm -->"+e);
            Assert.fail();
        }
    }
    public void redirectTonewtab(){
        //new tab open
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            act.pause(Duration.ofSeconds(4)).build().perform();
            ArrayList<String> tabs = new ArrayList (getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
            open();//paste the url of the site
            //url check of login should not be present
        }catch (Exception e){
            log.error("Not able to confirm");
            Assert.fail();
        }

    }
    public void backbutton(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().navigate().back();
            log.info("clicked back button");
            waitOnPage();
        }catch (Exception e){
            log.error("not able to go back-->"+e);
            Assert.fail();
        }
    }
    public String lei_id(String lei_status){
        String lei_id;
        ResultSet rs = null;
        String statement="select id from lei_org_type where status=?";
        try {
            rs=configfileReader.connectDatabase("osttra_dms_organisation",statement,lei_status);
            while (rs.next()){
                lei_id = rs.getString("id");
                if (lei_id!=null){
                    log.info(lei_id);
                    return lei_id;
                }
                else {
                    log.error("Required entry not present in database");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("Required entry not present in database");
        }
        return null;
    }
    public String user_id(String status){
        String user_id;
        ResultSet rs;
        try {
            String lei_org_type_id=lei_id(status);
            rs=configfileReader.connectDatabase("dms_postgres_user","select user_id from user_lei_org_type where lei_org_type_id=?",lei_org_type_id);
            while (rs.next()){
                user_id = rs.getString("user_id");
                if (user_id!=null){
                    log.info(user_id);
                    return user_id;
                }
                else {
                    log.error("Required entry not present in database");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("Required entry not present in database");
        }
        return null;
    }
    public String email_id(String status){
        String email_id = null;
        ResultSet rs;
        try {
            String user_id=user_id(status);
            rs=configfileReader.connectDatabase("dms_postgres_user","select email_id from dms_user where user_id=?",user_id);
            while (rs.next()){
                email_id=rs.getString("email_id");
                if (email_id.isEmpty()){
                    log.error("Required entry not present in database");
                    Assert.fail();
                }
                else {
                    log.info(email_id);
                }
            }
        }catch (Exception e){
            //
        }
        return email_id;
    }
    public void loginusingdatabasecredentials(String status){
        String user_email=email_id(status);
        if (user_email==null){
            log.error("blah");
            Assert.fail();
        }
        open();
        typeInto(username,user_email);
        log.info("Types in the username");
        pass.sendKeys("dummy_pass");
        log.info("types in the password");
        clicksubmit();

    }
    public void clickforgotPassword(){
        try{
            open();
            forgot_btn.waitUntilVisible();
            forgot_btn.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Clicked on forgot button");
        }
        catch(Exception e){
        }

    }
    public void openloginpage(){
        try{
            open();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to open the login page");
        }
    }
    public void verifyemailandnotification(List<String> email){
        try {
            typeInto(username,email.get(1));
            log.info("Types in the username");
            submit.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String Resetlinktext=resetLinkPopup.getText().trim();
            if (Resetlinktext.equalsIgnoreCase("A password reset link has been sent to your email. Please check your inbox.")){
                log.info("Password reset link sent successfully");
            }
            else{
                log.info("Email does not exist");
            }

        }catch (Exception e){
            Assert.fail("Not able to type username");
            log.error("Not able to type username "+e);
            log.error("Not able to sent password reset link"+e);
        }
    }
    public void pressEnter(){
        try {
            robot.keyPress(KeyEvent.VK_ENTER);
            log.info("Enter Pressed");
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }
        catch(Exception e){
            log.error("Unable to press enter");
        }
    }
    public void validateHeading(){
        try {
            Assert.assertTrue(Main_Page_Logo.isVisible());
        }catch (Exception e){
            log.error("Heading doesn't match or isn't available"+e);
            Assert.fail();
        }
    }
    public void validateInternalHeading(){
        try {
            Assert.assertTrue(Internal_Page_Logo.isVisible());
        }catch (Exception e){
            log.error("Internal App logo doesn't match or isn't available"+e);
            Assert.fail();
        }
    }

}
