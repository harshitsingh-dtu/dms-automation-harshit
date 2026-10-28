package stepDefinations.LoggingAuthenticationStep;

import PageObjects.Login.LoginPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import java.time.Duration;
import java.util.List;
@Slf4j
public class LoginStep extends PageObject {
    LoginPageObject loginPageObject;
    Actions act = new Actions(getDriver());

    @Given("user types in the email id")
    public void user_types_in_the_email_id(List<String> email) {
        loginPageObject.typesmail(email);
    }

    @Then("user profile is visible on the screen after successful login")
    public void user_profile_is_visible_on_the_screen_after_successful_login() {
        loginPageObject.checkifprofilevisible();
    }

    @And("user types in the password and submit")
    public void user_types_in_the_password(List<String> password) {
        loginPageObject.typePassword(password);
        loginPageObject.clicksubmit();
    }

    @And("user types in the wrong password and submit")
    public void user_types_in_the_wrong_password(List<String> password) {
        loginPageObject.typePassword(password);
        loginPageObject.clicksubmit();
    }

    @Given("user types in the wrong email id")
    public void user_types_in_the_wrong_email_id(List<String> email) {
        loginPageObject.typesmail(email);
    }

    @Then("User not found alert should be visible")
    public void user_not_found_alert_should_be_visible() {
        loginPageObject.checkifUsernotFoundAlert();
    }

    @Given("Click on logout button")
    public void click_on_logout_button() {
        loginPageObject.clickLogout();
    }

    @When("After successful logout on the login screen press the back button")
    public void after_successful_logout_on_the_login_screen_press_the_back_button() {
        loginPageObject.backbutton();
    }

    @Then("user should not be able to navigate to any page of application")
    public void user_should_not_be_able_to_navigate_to_any_page_of_application() {
//        loginPageObject.checkifonLoginscreen();
        try {
            //url check
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String url=getDriver().getCurrentUrl();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
//          waitOnPage();
            Assert.assertEquals("https://qa-docs-osttra.traianaops.luminatesec.com/login",url);
            log.info("User is on the same page");

        }catch (Exception e){
            log.error("unable to confirm -->"+e);
            Assert.fail();
        }
    }

    @Then("user is redirected to login screen")
    public void user_is_redirected_to_login_screen() {
        loginPageObject.checkifonLoginscreen();
    }

    @When("user go to new tab and try to login")
    public void user_go_to_new_tab_and_try_to_login() {
        loginPageObject.redirectTonewtab();
    }

    @Then("user is already logged in for the new tab")
    public void user_is_already_logged_in_for_the_new_tab() {
        loginPageObject.checkifprofilevisible();
    }

    @When("After successful login press the back button")
    public void after_successful_login_press_the_back_button() {
        loginPageObject.backbutton();
    }

    @Then("user should stay on home page")
    public void user_should_stay_on_home_page() {
        loginPageObject.checkifprofilevisible();
    }

    @When("^user belongs to online lei org type and tries to login$")
    public void user_belongs_to_online_lei_org_type_and_tries_to_login(){
        loginPageObject.loginusingdatabasecredentials("Online");
    }
    @When("^user belongs to lite lei org type and tries to login$")
    public void user_belongs_to_lite_lei_org_type_and_tries_to_login(){
        loginPageObject.loginusingdatabasecredentials("Lite");
    }
    @When("^user is active and tries to login$")
    public void user_is_active_and_tries_to_login() {

    }
    @When("^user is inactive and tries to login$")
    public void user_is_inactive_and_tries_to_login()  {

    }

    @Given("user is loggedin successfully")
    public void user_enters_Valid_creds() {
        open();
//        Set<Cookie> cookiesList =  getDriver().manage().getCookies();
        System.out.println("Cookies are "+ getDriver().manage().getCookies());
//        for (Cookie getcookies :cookiesList) {
//            System.out.println("Cookies are "+ getcookies);
//        }
//        System.out.println("email is "+ System.getProperty(webdriver.base.url));
    }

    @Given("The primary browser launches again")
    public void the_primary_browser_launches_again() {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        setDriver(driver);
        loginPageObject.setDriver(driver);
        open();
    }
    @Given("^User validates Main page heading as OSTTRA Documentation Centre$")
    public void user_validates_Page_Heading()  {
        loginPageObject.validateHeading();
    }

    @Given("^User validates internal page heading as OSTTRA Documentation Centre$")
    public void user_validates_internal_Page_Heading()  {
        loginPageObject.validateInternalHeading();
    }

    @Given("^dummy dummy$")
    public void dummy_dummy()  {
        act.pause(Duration.ofSeconds(2)).build().perform();

    }
    @Given("User is on the login screen")
    public void User_is_on_the_login_screen(){
        loginPageObject.openloginpage();
    }
    @When("User clicks on the forgot password button")
    public void User_clicks_on_the_forgot_password_button(){
        loginPageObject.clickforgotPassword();
    }
    @Then("Verify if user is able to enter email id and get a notification on screen")
    public void Verify_if_user_is_able_to_enter_email_id_and_get_a_notification_on_screen(List<String> email){
        loginPageObject.verifyemailandnotification(email);
    }
    @And("User types in the password")
    public void User_types_in_the_password(List<String> password){
        loginPageObject.typePassword(password);
    }
    @Then("Verify if user is able to login after pressing enter key")
    public void Verify_if_user_is_able_to_login_after_pressing_enter_key(){
        loginPageObject.pressEnter();
    }

}