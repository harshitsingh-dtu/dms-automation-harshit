package stepDefinations.CLOverride;

import PageObjects.CLOverride.CLOverridePageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.OrgManagement.OrgManagementPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
public class CLOverrideStep extends PageObject {
    DocumentPageObject documentPageObject;
    CLOverridePageObject CLOverridePageObject;
    OrgManagementPageObject OrgManagementPageObject;

    @Given("User is on the CL override screen")
    public void user_is_on_the_CLOverride_update_screen() {
        documentPageObject.clickMenuButton();
        OrgManagementPageObject.getOrganization_btn().waitUntilClickable();
        OrgManagementPageObject.getOrganization_btn().click();
        CLOverridePageObject.getCLOverrideTab().waitUntilClickable();
        CLOverridePageObject.getCLOverrideTab().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Given("User validates the CL override Page")
    public void user_is_on_the_organization_update_screen() {
        Assert.assertTrue(CLOverridePageObject.getCLOverridePage().isDisplayed());
    }

    @Given("User will select the Doc type for CL Overrride")
    public void user_selectDocType(DataTable table) {
        CLOverridePageObject.selectDocType(table);
    }

    @Then("User Enters the text PB Column")
    public void enterTextInPB(String text) {
        CLOverridePageObject.enterTextInPB(text);
    }
    @Then("User Enters the text only for PB Column")
    public void enterTextInPBOnly(String text) {
        CLOverridePageObject.enterTextInPBOnly(text);
    }

    @Then("User Enter the text PB Column")
    public void enterTextInPBInput() {
        CLOverridePageObject.enterTextInPBInput();
    }
    @Then("User Enters the text EB Column")
    public void enterTextInEB() {
        CLOverridePageObject.enterTextInEB();
    }
    @Then("User Enters the text Client Column")
    public void enterTextInClient() {
        CLOverridePageObject.enterTextInClient();
    }
    @Then("User Enters the text Client Column for 4 Way")
    public void enterTextInClientFor4Way() {
        CLOverridePageObject.enterTextInClientFor4Way();
    }

    @Given("User clicks on Save button for Override Values")
    public void user_save_Changes_on_the_all_Override() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", CLOverridePageObject.getOverride_value_SaveIcon());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        CLOverridePageObject.getPB_Override_SaveIcon().click();
    }

    @Then("User clicks on Audit button for CL Override")
    public void user_ClickOnAudiButton() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", CLOverridePageObject.getPB_Override_AuditIcon());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        CLOverridePageObject.getPB_Override_AuditIcon().click();
    }

    @Then("User Validates the CL Override Audit history Screen")
    public void user_Validate_CL_OverrideScreen() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", CLOverridePageObject.getCL_OverrideHistoryScreen());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(CLOverridePageObject.getCL_OverrideHistoryScreen().isDisplayed());
    }

    @Then("User Validates the data on Cl Override Audit history Screen")
    public void user_Validate_Audit_HistoryData(DataTable table) {
        Assert.assertTrue(CLOverridePageObject.ValidateDataInHistoryTab(table));
    }
    @Then("User Validates the all data on Cl Override Audit history Screen")
    public void user_Validate_all_Audit_HistoryData(DataTable table) {
        Assert.assertTrue(CLOverridePageObject.validateAuditHistoryData(table));
    }

    @Then("User removes the PB value")
    public void user_remove_the_OverrideID() {
        CLOverridePageObject.removeTextInPB();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }

    @Then("User clicks on the Organisation Dropdown")
    public void user_clicks_on_the_organisation_dropdown() {
        OrgManagementPageObject.getOrganization_btn().waitUntilClickable().click();
    }

    @And("Verify CreditLink Override text is present")
    public void verify_credit_link_override_is_present() {
        CLOverridePageObject.getCLOverrideTab().waitUntilVisible();
        boolean isPresent = CLOverridePageObject.getCLOverrideTab().isCurrentlyVisible();
        Assert.assertTrue("The CreditLink Override sub-menu item was not visible after clicking dropdown", isPresent);
    }

    @Then("User removes the value from PB, EB, Client if not empty")
    public void user_remove_the_OverrideID_from_all_inputBoxes_if_not_empty() {
        CLOverridePageObject.removeTextInPB();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        CLOverridePageObject.removeTextInEB();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        CLOverridePageObject.removeTextInClient();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @Then("User removes the value from PB, Client if not empty")
    public void user_remove_the_OverrideID_from_inputBoxes_if_not_empty() {
        CLOverridePageObject.removeTextInPB();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        CLOverridePageObject.removeTextInClientFor4way();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @And("User verifies whether Save message appears or not")
    public void user_verifies_whether_save_message_appear_or_not(DataTable table) {
        List<String> data = table.asList();
        String expectedMessage = data.get(0);
        boolean isMessagePresent = CLOverridePageObject.validateSavedMessage(expectedMessage);
        Assert.assertFalse("Test Failed: The 'Save' message appeared when it shouldn't have!", isMessagePresent);
    }

    @Then("User validates the length of Override ID is 100 characters")
    public void user_verifies_maximin_length_of_IDS () {
        CLOverridePageObject.checkMaximumLength();
    }

    @Then("User validates column Lei, Legal Entity Name and Action columns are present")
    public void verifyColumnsOnClOverrideScreen () {
        CLOverridePageObject.validateTableHeaders();
    }

    @And("User validates column Organisation Id and name, active users, total users")
    public void verifyColumnsOnUpdateScreen () {
        CLOverridePageObject.validateUpdateScreenColumnHeaders();
    }
    @Then("User clicks on cross button")
    public void crossButtonOnAuditScreenForCLOverride () {
        CLOverridePageObject.closeHistorySidebar();
    }

    @Then("User validates the Organisation information screen is displayed")
    public void validatesOrganisationInformation () {
        CLOverridePageObject.validateOrganisationInformationVisible();
    }

    @Then("User verifies the following roles are present on the profile screen")
    public void user_verifies_roles(DataTable table) {
        // Convert DataTable to a List of Strings
        List<String> requiredRoles = table.asList(String.class);

        // Assert that the verification method returns true
        Assert.assertTrue("One or more required roles were not found on the profile screen!",
                CLOverridePageObject.verifyRequiredRoles(requiredRoles));
    }

    @When("^user clears the PB override text if present$")
    public void user_clears_the_pb_override_text_if_present() {
        CLOverridePageObject.clearPBOverrideIfPresent();
    }

}