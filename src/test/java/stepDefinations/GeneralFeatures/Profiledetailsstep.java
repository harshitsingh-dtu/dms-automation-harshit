package stepDefinations.GeneralFeatures;

import PageObjects.ProfileDetailsPageObject.ProfileDetailsPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Profiledetailsstep extends PageObject{

    ProfileDetailsPageObject profileDetailsPageObject;

    Actions act = new Actions(getDriver());

    @Given("User has logged in using credentials")
    public void user_has_logged_in_using_credentials() {
        //hooks
        act.pause(Duration.ofSeconds(20)).build().perform();
    }

    @When("User clicks on the profile button")
    public void User_clicks_on_the_profile_button(){
        profileDetailsPageObject.clickProfileButton();
    }

    @Then("Verify that user is on Profile Details Screen")
    public void Verify_that_user_is_on_Profile_Details_Screen(){
        profileDetailsPageObject.redirectProfileScreen();
    }

    @When("User is on the landing Screen")
    public void User_is_on_the_landing_Screen(){
        profileDetailsPageObject.checkDocumentHeader();
    }

    @Then("User should be able to see the Profile Details Button")
    public void User_should_be_able_to_see_the_Profile_Details_Button(){
        profileDetailsPageObject.checkProfileButton();
    }

    @Then("Verify if user is able to see Profile Details tab,Reset Password tab and Help and Support tab")
    public void Verify_if_user_is_able_to_see_Profile_Details_tab_Reset_Password_tab_and_Help_and_Support_tab(){
        profileDetailsPageObject.validateProfileScreen();
    }

    @Then("User clicks on the Profile Details Tab")
    public void User_clicks_on_the_Profile_Details_Tab(){
        profileDetailsPageObject.clickProfileDetailsTab();
    }

    @And("Verify user is able to see all the information on the profile screen")
    public void Verify_user_is_able_to_see_all_the_information_on_the_profile_screen(){
        profileDetailsPageObject.validateProfileDetailsTab();
    }

    @Then("User clicks on the Reset Password Tab")
    public void User_clicks_on_the_Reset_Password_Tab(){
        profileDetailsPageObject.clickResetPasswordTab();
    }

    @And("Validate the Reset Password Screen")
    public void Validate_the_Reset_Password_Screen(){
        profileDetailsPageObject.validateResetPasswordScreen();
    }

    @Then("User will search for current password,new password and confirm password")
    public void User_will_search_for_current_password_new_password_and_confirm_password(DataTable table){
        profileDetailsPageObject.searchAllPassword(table);
    }

    @And("User will submit the changes made")
    public void User_will_submit_the_changes_made(){
        profileDetailsPageObject.sumbmitButton();
    }

    @Then("User clicks on the Help and Support Tab")
    public void User_clicks_on_the_Help_and_Support_Tab(){
        profileDetailsPageObject.clickHelpSupport();
    }

    @And("Validate the Help and Support Screen")
    public void Validate_the_Help_and_Support_Screen(){
        profileDetailsPageObject.validateHelpSupportScreen();
    }

    @And("Validate the Reset Password is removed")
    public void validateTheResetPasswordIsRemoved() {
        profileDetailsPageObject.validateResetPassword();
    }

    @Then("User clicks on the profile button only")
    public void userClicksOnTheProfileButtonOnly() {
        profileDetailsPageObject.clickProfileButtonOnly();
    }
}

