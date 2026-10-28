package stepDefinations.GeneralFeatures;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import PageObjects.GeneralFeatures.HeaderSectionObject;
import org.junit.Assert;
import java.time.Duration;

public class HeaderSection extends PageObject {
    HeaderSectionObject HeaderSection;

    @Then("User validates the QA environment")
    public void Validate_Env()
    {
        HeaderSection.validateEnv();
    }

    @Then("User validates the App logo")
    public void Validate_AppLogo()
    {
        HeaderSection.validateAppLogo();
    }

    @Then("User validates the Messages in header section")
    public void validate_Message()
    {
        HeaderSection.validateMessage();
    }
    @Then("User validates the User Details in header section")
    public void validate_User_Details()
    {
        HeaderSection.validateUserDetails();
    }
    @Then("User validates the Help in header section")
    public void validate_Help_Section()
    {
        HeaderSection.validateHelpSection();
    }
    @Then("User clicks on {string}")
    public void userClicksOn(String text) {
        HeaderSection.clickOnTExt(text);
    }

    @And("Verify mail and web are hyperlinks")
    public void verifyMailAndWebAreHyperlinks() {
        Assert.assertEquals(HeaderSection.getWeb().getTagName(),"a");
        Assert.assertEquals(HeaderSection.getMail().getTagName(),"a");
    }

    @Then("Click on close icon")
    public void clickOnCloseIcon() {
        HeaderSection.getCloseIcon().withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable();
        try {
            HeaderSection.getCloseIcon().click();
        } catch (Exception e) {
            evaluateJavascript("arguments[0].click();", HeaderSection.getCloseIcon());
        }
    }

    @And("Verify the email mentioned is hyperlink")
    public void verifyTheEmailMentionedIsHyperlink() {
        Assert.assertEquals(HeaderSection.getSupportEmail().getTagName(),"a");
    }
}
