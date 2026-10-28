package stepDefinations.GeneralFeatures;

import PageObjects.Notifications.NotificationPageObject;
import PageObjects.Notifications.ProfilePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProfileValidationPageStep extends PageObject {
    ProfilePageObject profilePageObject;
    @When("User is on Profile details screen")
    public void User_is_on_Profile_details_screen() {
        profilePageObject.openProfileDeatils();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User validates Edit icon is not visible")
    public void User_Click_on_edit_icon()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertFalse(profilePageObject.getEditicon().isVisible());
    }

    @And("User enter first & last name")
    public void User_enter_first_and_last_name(DataTable table)
    {
     profilePageObject.enterFirstLastName(table);
    }
    @And("User click on submit button")
    public void User_click_on_submit_button()
    {
        profilePageObject.ClickSubmit();
    }
    @Then("Validate successful message & updated name")
    public void Validate_successful_message_and_updated_name()
    {
        profilePageObject.validateSuccessUpdate();
    }
    @Then("Validate unsuccessful message when no change found")
    public void Validate_unsuccessful_message_when_no_change_found()
    {
        profilePageObject.validateNoChange();
    }
    @Then("Validate unsuccessful message when first name limit exceed")
    public void Validate_unsuccessful_message_when_first_name_limit_exceed()
    {
        profilePageObject.validateLimitExceed();
    }
    @Then("Validate unsuccessful message when last name limit exceed")
    public void Validate_unsuccessful_message_when_last_name_limit_exceed()
    {
        profilePageObject.validateLimitExceed();
    }

}
