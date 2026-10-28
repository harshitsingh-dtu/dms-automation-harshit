package stepDefinations.GeneralFeatures;

import PageObjects.Documents.DocumentPageObject;
import PageObjects.Notifications.NotificationPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import java.time.Duration;

public class RevisedMenuValidationPage extends PageObject {
    DocumentPageObject documentPageObject;
    @Then("Validate osttra details in bottom")
    public void Validate_osttra_details_in_bottom() {
        String bottomtext = documentPageObject.getBottomtext().getText();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("Proprietary and Confidential",bottomtext);
    }
    @Then("Validate the dashboard")
    public void Validate_renaming_of_dashboard_to_overview() {
        Assert.assertEquals("Dashboard",documentPageObject.getDashboard().getText());
    }
    @Then("Validate Env details beside X icon")
    public void Validate_Env_details_beside_X_icon() {
        String env = documentPageObject.getEnviroment().getText();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("QA",env);
    }
    @When("User is on about osttra page")
    public void User_is_on_about_osttra_page() {
        documentPageObject.openaboutosttra();
    }
    @When("User click on help dropdown")
    public void User_click_on_help_dropdown() {
        documentPageObject.click_help();
    }

    @Then("Validate about osttra page")
    public void Validate_about_osttra_page() {
        String about = documentPageObject.getAboutpage().getText();
        String aboutterms = documentPageObject.getAboutpageterms().getText();
        String aboutsupport = documentPageObject.getAboutpagesupport().getText();
        Assert.assertEquals("read more",about);
        Assert.assertEquals("Terms of Use",aboutterms);
        Assert.assertEquals("Customer support",aboutsupport);
    }
    @Then("Validate about osttra option")
    public void Validate_about_osttra_option() {
        String aboutosttra = documentPageObject.getAboutosttra().getText();
        Assert.assertEquals("About OSTTRA", aboutosttra);
    }
}
