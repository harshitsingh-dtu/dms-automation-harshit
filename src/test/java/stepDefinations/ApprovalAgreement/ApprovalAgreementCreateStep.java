package stepDefinations.ApprovalAgreement;

import PageObjects.Approval.ApprovalgroupCreatePageObject;
import PageObjects.Approval.ApprovalgroupPageObject;
import PageObjects.Approval.ApprovalgroupUpdatePageObject;
import PageObjects.ApprovalAgreement.ApprovalAgreementCreatePageObject;
import PageObjects.Documents.DocumentPageObject;
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
public class ApprovalAgreementCreateStep extends PageObject {
    DocumentPageObject documentPageObject;
    ApprovalAgreementCreatePageObject approvalAgreementCreatePageObject;

    @Given("^User is on Approval Agreement Screen$")
    public void user_navigates_to_approval_agreement_screen(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentPageObject.clickMenuButton();
        approvalAgreementCreatePageObject.getApprovalAgreementTab().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("Validate User is on Approval Agreement Screen")
    public void Validate_user_is_on_the_approval_agreement_screen(){
        Assert.assertTrue(approvalAgreementCreatePageObject.getApprovalAgreementDashboard().isVisible());
    }
    @When("User applies filter on Approval Agreement Screen")
    public void Filtering_Approvers_Agreements(DataTable table) {
        approvalAgreementCreatePageObject.filterAndSelectColumnValues(table);
    }
    @When("User validates the data filtered")
    public void ValidatesFilteredRecord(List data) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",approvalAgreementCreatePageObject.getPB_ApprovalAgreements());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-50)");
        Assert.assertEquals(data.get(0).toString().trim().toLowerCase(), approvalAgreementCreatePageObject.getPB_ApprovalAgreements().getText().trim().toLowerCase());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",approvalAgreementCreatePageObject.getEB_ApprovalAgreements());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-50)");
        Assert.assertEquals(data.get(1).toString().trim().toLowerCase(), approvalAgreementCreatePageObject.getEB_ApprovalAgreements().getText().trim().toLowerCase());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",approvalAgreementCreatePageObject.getStatus_ApprovalAgreements());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-50)");
        Assert.assertEquals(data.get(2).toString().trim().toLowerCase(), approvalAgreementCreatePageObject.getStatus_ApprovalAgreements().getText().trim().toLowerCase());
    }

    @Then("User validates the columns on Approval Agreement Screen")
    public void Validate_approval_agreement_screen_elements(){
        Assert.assertTrue(approvalAgreementCreatePageObject.getAgreementID().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.getPBLegalEntityName().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.getPBLEI_ID().isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",approvalAgreementCreatePageObject.getStatus());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        Assert.assertTrue(approvalAgreementCreatePageObject.getEBLegalEntityName().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.getEBLEI_ID().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.getStatus().isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",approvalAgreementCreatePageObject.getLastUpdatedOn());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        Assert.assertTrue(approvalAgreementCreatePageObject.getLastUpdatedOn().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.getAction().isVisible());
    }
    @Then("User clicks on Create New Approval agreement")
    public void click_on_Create_approval_agreement(){
        Assert.assertTrue(approvalAgreementCreatePageObject.getCreateNewApprovalAgreementButton().isVisible());
        approvalAgreementCreatePageObject.getCreateNewApprovalAgreementButton().click();
    }
    @When("User select the LEIs in Approval Agreement")
    public void user_select_LEIs(DataTable table) {
        approvalAgreementCreatePageObject.selectLEI(table);
    }
    @When("User validates Traiana Approval language terms")
    public void user_validates_Triana_Approval_Language() {
        Assert.assertTrue(approvalAgreementCreatePageObject.getTraiana_Approval_language().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.TrianaApprovalLanguage());
    }
    @When("User validates Osttra Approval language terms")
    public void user_validates_Osttra_Approval_Language() {
        Assert.assertTrue(approvalAgreementCreatePageObject.getOsttra_Approval_language().isVisible());
        Assert.assertTrue(approvalAgreementCreatePageObject.OsttraApprovalLanguage());
    }
    @When("User selects the Agreement Signed Externally checkbox")
    public void user_checks_Agreement_Signed_Externally() {
//        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approvalAgreementCreatePageObject.getAgreement_Signed_Externally_radioButton());
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getAgreement_Signed_Externally_radioButton().isVisible());
        approvalAgreementCreatePageObject.getAgreement_Signed_Externally_radioButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getAgreement_Signed_Externally_radioButton_Checked().isVisible());
    }
    @When("User selects Electronic Signature checkbox")
    public void user_checks_Electronic_Signature() {
        Assert.assertTrue(approvalAgreementCreatePageObject.getElectronic_Signature_radioButton().isVisible());
        approvalAgreementCreatePageObject.getElectronic_Signature_radioButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getElectronic_Signature_radioButton_Checked().isVisible());
    }
    @When("User selects PB Approvers Required")
    public void PB_Approvers_Required(String Count) {
        Assert.assertTrue(approvalAgreementCreatePageObject.getPBApproversCount().isVisible());
        approvalAgreementCreatePageObject.getPBApproversCount().sendKeys(Count);
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    @When("User validates the maximum number of PBs & EBs is 3")
    public void List_of_Approvers_Required() {
        Assert.assertTrue(approvalAgreementCreatePageObject.getPBApproversCount().isVisible());
        approvalAgreementCreatePageObject.getPBApproversCount().click();
        Assert.assertTrue(approvalAgreementCreatePageObject.getListOfApproversCount().getText().equalsIgnoreCase("1\n2\n3"));
        approvalAgreementCreatePageObject.getEBApproversCount().click();
        Assert.assertTrue(approvalAgreementCreatePageObject.getListOfApproversCount().getText().equalsIgnoreCase("1\n2\n3"));
    }
    @When("User validates the entering more than 3 approvers shows No Option")
    public void Invalid_Approvers_Required(String Count) {
        Assert.assertTrue(approvalAgreementCreatePageObject.getPBApproversCount().isVisible());
        approvalAgreementCreatePageObject.getPBApproversCount().sendKeys(Count);
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals("No options",approvalAgreementCreatePageObject.getListOfApproversCount().getText());
        approvalAgreementCreatePageObject.getEBApproversCount().sendKeys(Count);
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals("No options",approvalAgreementCreatePageObject.getListOfApproversCount().getText());
    }
    @When("User selects EB Approvers Required")
    public void EB_Approvers_Required(String Count) {
        Assert.assertTrue(approvalAgreementCreatePageObject.getEBApproversCount().isVisible());
        approvalAgreementCreatePageObject.getEBApproversCount().sendKeys(Count);
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    @When("User enters PB Approvers Details")
    public void PB_Approvers_Details(DataTable table) {
        approvalAgreementCreatePageObject.PBApproversDetails(table);
    }
    @When("User enters EB Approvers Details")
    public void EB_Approvers_Details(DataTable table) {
        approvalAgreementCreatePageObject.EBApproversDetails(table);
    }
    @When("User validated the mandatory field warning on Approval Agreement Screen")
    public void Warning_On_Approvers_Agreement_screen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getValidation_Warning().isVisible());
    }
    @When("User validates Approval Agreement Created successfully notification")
    public void Approvers_Agreement_created_successfully() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getApproval_Agreement_created_succesfully().isVisible());
    }
    @When("User validates Approval Agreement updated notification")
    public void Approvers_Agreement_Updated() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getApproval_Agreement_Updated().isVisible());
    }
    @When("User validates Agreement Disabled successfully notification")
    public void Agreement_Disabled_successfully() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getAgreement_disabled_succesfully().isVisible());
    }
    @When("User clicks on disable button")
    public void User_ClicksOnDisabled_Button() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getDisable_button().isVisible());
        approvalAgreementCreatePageObject.getDisable_button().click();
    }
    @When("User disapproves the usage terms")
    public void User_Disapproves_UsageTerms() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getApproveButton().isVisible());
        approvalAgreementCreatePageObject.getApproveButton().click();
        Assert.assertTrue(approvalAgreementCreatePageObject.getDisapproveButton().isVisible());
    }
    @When("User clicks on Audit button")
    public void User_Clicks_Audit_Button() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getAuditButton().isVisible());
        approvalAgreementCreatePageObject.getAuditButton().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getAgreementHistory().isVisible());
    }
    @When("User validates the Audit event and User")
    public void AuditEvent_and_UserDetails(DataTable table) {
        Assert.assertTrue(approvalAgreementCreatePageObject.AuditAndUserDetails(table));
    }
    @When("User validates approve has been logged in Event changes")
    public void User_validates_ApproveStatus() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.getApproveStatusInAudit().isVisible());
    }
    @When("User validated the date has been logged in Event Changes")
    public void User_validates_Date_logged() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(approvalAgreementCreatePageObject.validateDate());
    }

    @And("^User validates the updated org name is coming for approval agreement$")
    public void validateOrgNameUSPRider(List<String> LEIName) {
        String expectedName = LEIName.get(0);

        // 1. Call the page object method to apply the filter and refresh the table
        approvalAgreementCreatePageObject.applyPBFilterAndRefresh(expectedName);

        // 2. Validate the record is displayed
        String dynamicXpath = "//*[contains(normalize-space(text()), '" + expectedName + "')]";
        try {
            boolean isDisplayed = find(By.xpath(dynamicXpath))
                    .withTimeoutOf(Duration.ofSeconds(10))
                    .waitUntilVisible()
                    .isDisplayed();

            Assert.assertTrue("The expected org name '" + expectedName + "' was not found on the screen.", isDisplayed);
        } catch (Exception e) {
            Assert.fail("Failed to find '" + expectedName + "'. The filter could not be applied. Error: " + e.getMessage());
        }
    }

    @Then("User validates the below drop down values should NOT be displayed")
    public void user_validates_dropdown_values_should_not_be_displayed(DataTable table) {
        approvalAgreementCreatePageObject.validateDropdownValuesNotDisplayed(table);
    }
}