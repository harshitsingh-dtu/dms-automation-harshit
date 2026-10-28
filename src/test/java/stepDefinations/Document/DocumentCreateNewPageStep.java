package stepDefinations.Document;

import PageObjects.DMS_PHASE2PageObject.DMS_1548_PageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.ProductGroup.ProductGroupAddNewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DocumentCreateNewPageStep extends PageObject {
    ProductGroupAddNewPageObject productGroupAddNewPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    DocumentPageObject documentPageObject;
    DMS_1548_PageObject DMS_1548;
    @Given("User is on Document Page")
    public void user_is_on_document_page() {
        WebDriver driver = net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver();
        setDriver(driver);
        documentPageObject.setDriver(driver);
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        documentPageObject.clickMenuButton();
        documentPageObject.clickDocumentTab();
        documentPageObject.unselectShowOnlyLatestVersion();
    }

@Given("User is on Document Page Again")
public void user_is_on_document_page_Again() {
    WebDriver driver = net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver();
    setDriver(driver);
    documentPageObject.setDriver(driver);
    withAction().pause(Duration.ofSeconds(3)).build().perform();
    documentPageObject.clickMenuButton();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='submenu-link-All documents']")));
    documentPageObject.clickDocumentTab();
}

    @Then("Verify Approval Workflow is not copied")
    public void verifyApprovalWorkflowIsNotCopied() {
        documentCreateNewPageObject.ApprovalWorkflowNotCopied();
    }

    @Then("User clicks on Create New Document")
    public void user_clicks_on_create_new_document() {
        withAction().pause(Duration.ofSeconds(12)).build().perform();
        documentCreateNewPageObject.clickNewDocument();
    }



    @Then("User clicks on edit icon")
    public void user_click_on_edit_icon() {
//        withAction().pause(Duration.ofSeconds(10));
        documentCreateNewPageObject.clickEditDocument();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }
    @And("Search for document version ID")
    public void Search_for_document_version_ID(DataTable table){
        documentCreateNewPageObject.search_document_using_version_id(table);
    }

    @Then("User validates the document version ID on Edit screen")
    public void user_validates_document_version_ID(List<String> docVersionID) {
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        documentCreateNewPageObject.getDocVersionID_Edit().waitUntilVisible();
        Assert.assertTrue(documentCreateNewPageObject.getDocVersionID_Edit().getText().contains(docVersionID.get(1)));
    }

    @Then("User validates document type on Edit screen")
    public void user_validates_document_Type(List<String> docVersionID) {
        Assert.assertTrue(documentCreateNewPageObject.getDocType_Edit().getText().contains(docVersionID.get(1)));
    }

    @Then("User validates allowed currency on edit screen")
    public void user_validates_allowedCurrency(List<String> docVersionID) {
        Assert.assertTrue(documentCreateNewPageObject.getAllowedCurrency().getText().contains(docVersionID.get(1)));
    }
    @Then("User validates the PB,EB and Client on edit screen")
    public void user_validates_PB_EB_Client(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validate_PB_EB_Client(table));
    }
    @Then("User validates the tabs on edit screen")
    public void     user_validates_all_Tabs() {
        Assert.assertTrue(documentCreateNewPageObject.getApprovalWorkflow_btn().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getEnforcement_forEDN().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getDocumentTerms().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getGeneralTerms().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getAuthScope_tab().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getLimitScope_tab().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getUspRiderTab().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getPreviewAndSubmit_tab().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getCancel_btn().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getSaveAsDraft_btn().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getNext_btn().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getResetCurrentChanges_btn().isVisible());
    }

    @Then("User validates the enforcement screen")
    public void user_validates_enforcement_screen() {
        Assert.assertTrue(documentCreateNewPageObject.getRedirected_enforcementRuleTab().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getAmendment_Tab().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getTermination_Tab().isVisible());
    }
    @Then("User validates the enforcement screen is read only")
    public void user_validates_ReadOnly_enforcement_screen() {
        Assert.assertFalse(documentCreateNewPageObject.getEnforceammendment().isVisible());
        Assert.assertFalse(documentCreateNewPageObject.getEnforced_schedule2().isVisible());
    }

    @And("Set the ENFORCEMENT RULES")
    public void setTheENFORCEMENT_RULES(DataTable table)
    {
        documentCreateNewPageObject.Enforcement_rule(table);
    }
    @And("User validates Document terms screen")
    public void Validate_Document_screen()
    {
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getTextboxDocumentTerms().isVisible());
    }

    @And("User validates Legal Term renamed to Document terms")
    public void Validate_LegalTerm_Renamedto_DocumntTerm()
    {
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getDocumentTermsDocTemplate().isVisible());
    }

    @And("User will be able to See all the Information like all dropdowns and buttons")
    public void user_will_be_able_to_see_all_the_information_like_all_dropdowns_and_buttons() {
        Assert.assertTrue(documentCreateNewPageObject.getLimitLineHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getCalculationTypeHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getLimitvalueHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getNettingTypeHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getBullionTradesHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getDeltaHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getProductfamilyHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getExcludeCLSHeader().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getActionHeader().isVisible());
    }
    @And("User validates the Limit Scope table headers in the new UI")
    public void user_validates_limit_scope_headers_new_ui() {
        documentCreateNewPageObject.validateNewLimitScopeHeaders();
    }

    @Then("User select document type,acting as")
    public void user_select_document_typeacting_as(DataTable table) {
        documentCreateNewPageObject.user_select_document_type(table);
        documentCreateNewPageObject.user_select_acting_as(table);
    }
    @Then("User clicks on Acting as DropDown")
    public void user_clicks_typeacting_as() {
        documentCreateNewPageObject.getSelectDocumentType().waitUntilVisible().click();
        documentCreateNewPageObject.getSelectDNDocumentType().waitUntilVisible().click();
        documentCreateNewPageObject.getSelectActingAs().waitUntilEnabled().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @Then("User Validates Client is not displayed in DropDown")
    public void user_validates_Client_is_Not_Displayed() {
        String DropDownValues = documentCreateNewPageObject.getDropDownValues().getText();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DropDownValues.equalsIgnoreCase("PB\nEB"));
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User validates document type")
    public void user_validate_doc_type() {
        Assert.assertTrue(documentCreateNewPageObject.getDocTypeValue_4way().isDisplayed());
    }
    @Then("User validates the document version ID")
    public void user_validate_docVersionID(List<String> docVersionID) {
        Assert.assertTrue(documentCreateNewPageObject.getDocVersionID().getText().contains(docVersionID.get(1)));
    }

    @Then("User validates the document version ID and compares both")
    public void user_validate_docVersionID_and_compare() {
        documentCreateNewPageObject.captureDocumentVersionID();
        documentCreateNewPageObject.verifyBulkApproveVersionMatches();
    }

    @Then("User validates the document version ID on 4W creation Screen")
    public void user_validate_docVersionID_on_4W_Creation() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.captureDocumentVersionID();
//        documentCreateNewPageObject.verifyBulkApproveVersionMatches();
    }

    @Then("User validates the document version ID and compares both the ids")
    public void user_validate_docVersionID_and_compare_both_the_ids() {
//        documentCreateNewPageObject.captureDocumentVersionID();
        documentCreateNewPageObject.verifyBulkApproveVersionMatches();
    }

    @Then("User validates the EB-1 Data")
    public void user_validate_EB_LEI(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.checkEB1Data(table));
    }
    @Then("User validate the allowed currency")
    public void user_validate_allowedCurrency() {
        documentCreateNewPageObject.validateAllowedCurrency();
        Assert.assertTrue(documentCreateNewPageObject.getAllowedCurrencyFX().isDisplayed());
        Assert.assertTrue(documentCreateNewPageObject.getAllowedCurrencyBullion().isDisplayed());
    }
    @Then("User select acting as")
    public void user_select_acting_as(DataTable table) {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0, 0)");
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.user_select_acting_as(table);
    }

    @Then("User select acting as in DF DN Screen")
    public void user_select_acting_as_in_DF_DN(DataTable table) {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0, 0)");
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.user_select_acting_as_in_DF_DN(table);
    }
    @And("User searches for acting as value in DF DN Screen")
    public void user_searches_for_acting_as_value_in_DF_DN(DataTable table) {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0, 0)");
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.search_acting_as_in_DF_DN(table);
    }

    @When("User select unique parties as Client1,PrimeBroker2")
    public void user_select_parties_as_prime_broker1_client1(DataTable table) {
//        documentCreateNewPageObject.generateRandomPB1();
        documentCreateNewPageObject.clickSelectPartiesAsPB1(table);
        documentCreateNewPageObject.clickSelectPartiesAsClient1(table);
        documentCreateNewPageObject.clickSelectPartiesAsPB2(table);
        documentCreateNewPageObject.clickSelectPartiesAsClient2(table);
    }
    @When("User validates the PB and Client")
    public void validate_PB_Client() {
        Assert.assertTrue(documentCreateNewPageObject.getSelectPB1().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getSelectPB2().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getSelectClient1().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getSelectClient2().isVisible());
    }
    @When("User validates the PB,EB and Client")
    public void validatePB_EB_Client() {
        Assert.assertTrue(documentCreateNewPageObject.getSelectPB1().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getSelectEB().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getSelectClient1().isVisible());
    }

    @When("User select the LEIs")
    public void user_select_LEIs(DataTable table) {
        documentCreateNewPageObject.selectLEIForNotification(table);
    }
    @When("User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2")
    public void user_select_parties_as_prime_broker1_client1_prime_broker2_and_client2(DataTable table) {
        documentCreateNewPageObject.clickSelectPartiesAsPB1(table);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.clickSelectPartiesAsClient1(table);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.clickSelectPartiesAsPB2(table);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.clickSelectPartiesAsClient2(table);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User clicks on Next button")
    public void user_clicks_on_next_button() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        documentCreateNewPageObject.clickNextbtn();
    }

    @Then("User clicks on Next Button on Auth Scope")
    public void user_clicks_on_next_button_on_AuthScope() {
        documentCreateNewPageObject.clickNextbtnonAuthScope();
    }

    @Then("User clicks on Cancel button")
    public void user_clicks_on_cancel_button() {
        documentCreateNewPageObject.clickCancelbtn();
    }
    @Then("User clicks on Cancel button for edit screen")
    public void user_clicks_on_cancel_button_for_edit_limit() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.clickCancelbtnForEditLimit();
    }
    @Then("User clicks on Cancel button for popup")
    public void user_clicks_on_cancel_button_for_popup() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.clickCancelbtnForPopup();
    }
    @Then("User select participants in Approval workflow")
    public void user_select_participants_in_approval_workflow() {
        documentCreateNewPageObject.clickSelectApprovalWorkflow();
    }
    @Then("User clicks on enforcement rules tab for DF")
    public void User_clicks_on_enforcement_rules_tab_on_document_template_update_screen(){
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        documentCreateNewPageObject.getEnforcementRuleTab_documentTemplateScreen().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getRedirected_enforcementRuleTab().waitUntilVisible();
    }
    @Then("User select rules in Enforcement rule")
    public void user_select_rules_in_enforcement_rule() {
        documentCreateNewPageObject.clickSelectEnforcementRules();
    }
    @Then("User semi fills the enforcement rules")
    public void user_semi_fills_enforcement_rules() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getEnforced_schedule1());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getEnforced_schedule1().click();
    }

    @Then("User clicks on Enforcement rule Tab in Preview tab")
    public void user_click_on_EnforcementTab_Preview() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getEnforcementRuleTabOnPreview().click();
    }

    @Then("User clicks on General Terms Tab")
    public void user_click_on_GeneralTerms() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.getGeneralTerms().waitUntilPresent().click();
    }

    @Then("User update the General Terms dates with Current date")
    public void updates_GeneralTerms(DataTable table) {
        documentCreateNewPageObject.EnterGeneralTerms(table);
    }

    @Then("User validates the Date values for General Terms in Document")
    public void validates_GeneralTerms(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateGeneralTerms(table));
    }

    @Then("User validates the Date values for General Terms in Document Preview on Dashboard")
    public void validates_GeneralTerms_OnDashboardPreview(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateGeneralTermsOnDocumentPreview(table));
    }


    @Then("User clicks on General Terms Tab Preview tab")
    public void user_click_on_GeneralTerms_Preview() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getGeneralTermsOnPreview().click();
    }
    @Then("User verifies Physically Settled Bullion is displayed")
    public void user_Verify_physically_settled_bullion() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getPhysicallySettledBullion().isVisible());
    }
    @Then("User selects the Physically Settled Bullion checkbox")
    public void user_clicks_physically_settled_bullion() {
        documentCreateNewPageObject.getPhysicallySettledBullion_checkbox().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("validate the Physically Settled Bullion is true")
    public void user_validate_physically_settled_bullion_true() {
        Assert.assertTrue(documentCreateNewPageObject.getPhysicallySettledBullion_True().isDisplayed());
    }
    @Then("User validates the documents are displayed with Physically bullion value as True")
    public void user_validate_Documents_True() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertFalse("No documents are displayed with Physically bullion value as True!", 
                documentCreateNewPageObject.getDocumentsWithValueAsTrue().isEmpty());
        Assert.assertTrue("Documents with value False were found in a True-filtered list!", 
                documentCreateNewPageObject.getDocumentsWithValueAsFalse().isEmpty());
    }
    @Then("User validates the documents are displayed with Physically bullion value as False")
    public void user_validate_Documents_False() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertFalse("No documents are displayed with Physically bullion value as False!", 
                documentCreateNewPageObject.getDocumentsWithValueAsFalse().isEmpty());
        Assert.assertTrue("Documents with value True were found in a False-filtered list!", 
                documentCreateNewPageObject.getDocumentsWithValueAsTrue().isEmpty());
    }

    @Then("User enters the current issue date")
    public void user_enters_current_issue_date() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCurrentDate_picker());
        documentCreateNewPageObject.getCurrentDate_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getCurrentDate();
    }
    @Then("User validates the current issue date")
    public void user_validate_CurrentIssue_date() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCurrentDate_picker());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.VerifyCurrentDate());
    }
    @Then("User enters the current ISDA date")
    public void user_enters_current_ISDA_date() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getDF_ISDA_Date_Picker());
        documentCreateNewPageObject.getDF_ISDA_Date_Picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getCurrentDate();
    }
    @Then("User validates the DF ISDA date")
    public void user_validate_ISDA_date(DataTable table) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getDF_ISDA_Date_Picker());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.DF_ISDA(table));
    }

    @Then("User enters the Reference date")
    public void user_enters_reference_date() {
        documentCreateNewPageObject.getReferenceDate_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getCurrentDate();
    }
    @Then("User enters the First Issue date")
    public void user_enters_FirstIssue_date() {
        documentCreateNewPageObject.getFirstIssue_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getCurrentDate();
    }
    @Then("User enter the Current Enforcement Time")
    public void user_enters_CurrentEnfrcmntTime() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCurrentEnforcementTime_picker());
        documentCreateNewPageObject.getCurrentEnforcementTime_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getCurrentDate();
    }
    @Then("User enters the Current Return Time")
    public void user_enters_current_ReturnTime() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCurrentReturnTime_picker());
        documentCreateNewPageObject.getCurrentReturnTime_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getCurrentDate();
    }
    @Then("User edits the bullion dates")
    public void user_edits_bullion_dates() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCurrentEnforcementTime_picker());
        documentCreateNewPageObject.getCurrentDate_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getUpdateDate_value().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getCurrentEnforcementTime_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getUpdateDate_value().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getCurrentReturnTime_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getUpdateDate_value().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getFirstIssue_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getUpdateDate_value().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getReferenceDate_picker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getUpdateDate_value().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("User validates Notes are visible for Prime Broker and not for Client")
    public void user_Validates_Notes_for_PB() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getPB_Notes());
        Assert.assertTrue(documentCreateNewPageObject.getPB_Notes().isPresent());
        documentCreateNewPageObject.getPB_Notes_textarea().click();
        documentCreateNewPageObject.getPB_Notes_textarea().clear();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.getPB_Notes_textarea().sendKeys("This is dummy PB Notes");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getClient_Office());
        try{
            documentCreateNewPageObject.getClient_Notes().isVisible();
        }
        catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
    @Then("Common notes section should be displayed and enter dummy text")
    public void user_Validates_common_notes() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCommon_Notes());
        Assert.assertTrue(documentCreateNewPageObject.getCommon_Notes().isVisible());
        documentCreateNewPageObject.getCommon_Notes_Textarea().click();
        documentCreateNewPageObject.getCommon_Notes_Textarea().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getCommon_Notes_Textarea().sendKeys("This is dummy Common Notes");
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("User validates PB notes data in preview")
    public void user_Validates_PB_notes_data(String Notes) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getPB_Notes_Preview());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(documentCreateNewPageObject.getPB_Notes_Preview().getText(),Notes);
    }
    @Then("User validate Common notes data in preview")
    public void user_Validates_common_notes_data(String Notes) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCommon_Notes_data());
        Assert.assertEquals(Notes, documentCreateNewPageObject.getCommon_Notes_data().getText());
    }
    @Then("Validate the Address max character limit is 100")
    public void user_Validates_Address_field_limit() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getAddress_field_PB());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getAddress_field_PB().isVisible());
        documentCreateNewPageObject.getAddress_field_PB().click();
        documentCreateNewPageObject.getAddress_field_PB().sendKeys("qwertyuiopadfghjklzxcvbm1qwertyuiopadfghjklzxcvbm2qwertyuiopadfghjklzxcvbm3qwertyuiopadfghjklzxcvbm4NO");
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        WebElement addressField = getDriver().findElement(By.xpath("//input[contains(@value,'qwertyuiopadfg')]"));
        Assert.assertEquals(100, addressField.getAttribute("value").length());
    }
    @Then("Validate the Contact max character limit is 400")
    public void user_Validates_contact_field_limit() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getContact_field_PB());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getContact_field_PB().isVisible());
        Assert.assertEquals(400,documentCreateNewPageObject.Validate_ContactField());
    }
    @Then("Validate Contact is reset to blank")
    public void user_Validates_contact_field() {
        Assert.assertTrue(documentCreateNewPageObject.getEmpty_Contact_field_PB().isVisible());
    }

    @Then("Validate the Notes max character limit is 1000")
    public void user_Validates_Notes_field_limit() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCommon_Notes());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getCommon_Notes().isVisible());
        Assert.assertEquals(1000,documentCreateNewPageObject.Validate_CommonNotes());
    }

    @Then("User navigate to Relationship Status and its values")
    public void user_Validates_relationShip_status() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getRelationship_PB());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getRelationship_PB().isVisible());
        documentCreateNewPageObject.getRelationship_PB().click();
        Assert.assertTrue(documentCreateNewPageObject.getRelationship_PBValues().getText().equalsIgnoreCase("NA\nActing through\nOperating through"));
    }

    @Then("User will select Auth Product Group")
    public void user_will_select_auth_product_group(DataTable table) {
        documentCreateNewPageObject.clickSelectAuthProductGroup(table);
    }
    @Then("User will select all the visible Auth Product Groups")
    public void user_will_multiple_auth_product_group(DataTable table) {
        documentCreateNewPageObject.clickSelectMultipleAuthProductGroup(table);
    }

    @Then("User will add Currencies")
    public void user_will_add_currencies(DataTable table) {
        documentCreateNewPageObject.clickSelectCurrenciesGroup(table);
    }
    @Then("User adds Currencies")
    public void user_add_currencies() {
        documentCreateNewPageObject.clickonCurrencies();
    }
    @Then("User adds bullion Currencies")
    public void user_add_Bullion_currencies() {
        documentCreateNewPageObject.getAuthCurrencies().waitUntilVisible().click();
        documentCreateNewPageObject.getAdd_XAG().click();
        documentCreateNewPageObject.getSubmit_btn().click();
    }
    @Then("User adds bullion Currencies-pair")
    public void user_add_Bullion_currencies_pair() {
        documentCreateNewPageObject.getAuthCurrencies().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getCurrenciesPair().click();
        documentCreateNewPageObject.getAdd_EUR_XAU().click();
        documentCreateNewPageObject.getSubmit_btn().click();
    }

    @Then("User will input Auth Tenor value")
    public void user_will_input_auth_tenor_value(DataTable table) {
        documentCreateNewPageObject.clickSelectAuthTenorvalue(table);
    }

    @Then("User will input Auth Tenor value Again")
    public void user_will_input_auth_tenor_value_again(DataTable table) {
        documentCreateNewPageObject.clickSelectAuthTenorvalueafterSelectingValue(table);
    }

    @Then("User will clear the Auth Tenor Value in DF")
    public void user_will_clear_auth_tenor_value_in_DF() {
        documentCreateNewPageObject.clickClearAuthTenorvalue();
    }

    @Then("User enables Tenor")
    public void user_will_enable_tenor() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getEnableAuthTenorDF());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        WebElement checkbox = getDriver().findElement(By.xpath("//div[contains(@class, 'enable-switch ')]//input"));
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkbox);
    }

    @Then("User clicks on disable button for tenor")
    public void user_will_enable_tenor_disablebutton() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getEnableAuthTenorDF());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        WebElement checkbox = getDriver().findElement(By.xpath("//div[contains(@class, 'enable-switch ')]//input"));
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkbox);
    }

    @Then("User clicks on disable button for tenor on DN")
    public void user_will_enable_tenor_disablebutton_on_DN() {
//        withAction().pause(Duration.ofSeconds(5)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getEnableAuthTenorDF());
        withAction().moveToElement(documentCreateNewPageObject.getEnableAuthTenorDF()).click().build().perform();
//        documentCreateNewPageObject.getEnableAuthTenorDF().waitUntilClickable().click();
    }


    @Then("User will edit Auth Tenor value")
    public void user_will_edit_auth_tenor_value(String TenorValue) {
        Assert.assertTrue(documentCreateNewPageObject.getEditTenorValue().isDisplayed());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getEditTenorValue());
        documentCreateNewPageObject.getEditTenorValue().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getEditTenorValue().clear();
        documentCreateNewPageObject.getEditTenorValue().sendKeys(TenorValue);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User will empty Tenor Value")
    public void user_will_Empty_auth_tenor_value() {
        Assert.assertTrue(documentCreateNewPageObject.getEditTenorValue().isDisplayed());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getEditTenorValue());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getEditTenorValue().click();
        documentCreateNewPageObject.getEditTenorValue().sendKeys(Keys.BACK_SPACE);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User will edit Auth Tenor value on DF")
    public void editAuthTenorValue(DataTable dataTable) {
        String tenorValue = dataTable.cell(0, 0);
        documentCreateNewPageObject.editFirstTenorValue(tenorValue);
    }

    @Then("User clicks on Auth Scope Tab")
    public void user_click_on_Auth_Scope() {
        documentCreateNewPageObject.getAuthScope_tab().withTimeoutOf(Duration.ofSeconds(30)).waitUntilVisible();
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                documentCreateNewPageObject.getAuthScope_tab()
        );
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.clickOnAuthScopeTab();
    }
    @Then("User validate Non-Zero Value notification is displayed")
    public void user_Non_Zero_Validation() {
        Assert.assertTrue(documentCreateNewPageObject.getNon_ZeroValidation().isDisplayed());
    }
    @Then("User validates No Lines are there")
    public void no_authLines_exists() {
        Assert.assertTrue(documentCreateNewPageObject.getNo_Auth_lines().isDisplayed());
         }

    @Then("User deletes the lines created")
    public void user_Deleted_AuthLines() {
        documentCreateNewPageObject.deleteAuthLines();
    }
    @Then("User clicks on copy icon for lines to be copied")
    public void user_copy_AuthLines() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        WebElementFacade copyBtn = documentCreateNewPageObject.getCopy_AuthLine();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", copyBtn);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            copyBtn.waitUntilVisible().click();
        } catch (Exception e) {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", copyBtn);
        }
    }
    @Then("User clicks on copy icon for lines to be copied for DF")
    public void user_copy_AuthLines_DF() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCopy_AuthLineDF());
        documentCreateNewPageObject.getCopy_AuthLineDF().waitUntilVisible().click();
    }

    @Then("User clicks on Reset Current Changes button")
    public void click_on_Reset_Current_Changes() {
        documentCreateNewPageObject.getReset_Current_Changes().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User clicks on Auth Scope Tab in Final Preview")
    public void user_click_on_Auth_Scope_inPReview() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        WebElementFacade authScopeBtn = documentCreateNewPageObject.getAuthScope_InPreview();
        authScopeBtn.withTimeoutOf(Duration.ofSeconds(20)).waitUntilPresent();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", authScopeBtn);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue("Auth Scope tab in preview is not visible", authScopeBtn.isCurrentlyVisible());
        try {
            authScopeBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", authScopeBtn);
        }
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User clicks on Expand Icon")
    public void user_click_Expand_Icon() {
        documentCreateNewPageObject.clickOnExpandIcon();
    }
    @Then("User clicks on Expand Icon for \"([^\"]*)\"$")
    public void user_click_Expand_Icon_ForAuthLines(String AuthLine) {
        documentCreateNewPageObject.clickOnExpandIconForAuthLine(AuthLine);
    }
    @Then("User clicks on Expand Icon for \"([^\"]*)\" for 4Way$")
    public void user_click_Expand_Icon_ForAuthLinesfor4way(String AuthLine) {
        documentCreateNewPageObject.clickOnExpandIconForAuthLineFor4Way(AuthLine);
    }
    @Then("^(?:User clicks on Expand Icon for parent \"([^\"]*)\" for 4Way|User expands parent \"([^\"]*)\" for 4Way|User expands parent \"([^\"]*)\" in Auth Scope)$")
    public void user_click_Expand_Icon_ForParent_for4way(String p1, String p2, String p3) {
        String parentName = p1 != null ? p1 : (p2 != null ? p2 : p3);
        documentCreateNewPageObject.clickOnExpandParentFor4Way(parentName);
    }
    @Then("User selects the Touch direction for \"([^\"]*)\"$")
    public void user_selectTouchDirection_ForAuthLines(String AuthLine , DataTable table) {
        documentCreateNewPageObject.selectTouchdirection(AuthLine, table);
    }
    @Then("User selects the Contract type Input for \"([^\"]*)\"$")
    public void user_selectContractType_ForAuthLines(String AuthLine , DataTable table) {
        documentCreateNewPageObject.selectContractType(AuthLine, table);
    }
    @Then("User selects Barrier Type for \"([^\"]*)\"$")
    public void select_Barrier_type(String AuthLine ,DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.select_barrierType(AuthLine, table);
    }
    @Then("User clicks on one Expand Icon and validates it")
    public void user_click_one_Expand_Icon() {
        documentCreateNewPageObject.clickOnOneExpandIcon();
    }
    @Then("User will select tenor in Auth Tenor")
    public void user_select_tenor_in_auth_tenor(DataTable table) {
        documentCreateNewPageObject.clickSelectAuthTenor(table);
    }
    @Then("User will click on Add Auth Line and click Next")
    public void user_will_click_on_add_auth_line_and_click_next() {
        documentCreateNewPageObject.clickAuthLineandNext();
    }
    @Then("User clicks on Add Auth Line")
    public void user_clicks_on_add_auth_line() {
        documentCreateNewPageObject.clickAuthLine();
    }
    @Then("User clicks on edit icon in Auth line")
    public void user_click_on_edit_Auth_line() {
        Assert.assertTrue(documentCreateNewPageObject.getEdit_In_Auth_Line().isVisible());
        documentCreateNewPageObject.getEdit_In_Auth_Line().waitUntilVisible().click();
    }

    @Then("User validates Auth Scope data")
    public void user_validate_AuthScope() {
        documentCreateNewPageObject.validateAuthScope();
    }

    @Then("user validate the Auth Scope data")
    public void user_validate_the_auth_scope_data(DataTable table) {
        documentCreateNewPageObject.validateAuthScopeDataDetailed(table);
    }

    @Then("User validates Auth Scope is visible")
    public void user_validate_AuthScope_isVisible() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getAuthCurrencies().isVisible());
    }
    @Then("User validates Limit Scope is visible")
    public void user_Validates_LimitScope() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getCalculationType_tab().isVisible());
    }
    @Then("User clicks on Limit Scope Tab in Final Preview")
    public void user_Validates_LimitScopeInPreview() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getLimitscope_tabInPreview().isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getLimitscope_tabInPreview());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getLimitscope_tabInPreview().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("User select limits in Limit Scope")
    public void user_select_limits_in_limit_scope() {
        documentCreateNewPageObject.clickSelectLimitScope();
    }

    @Then("User validates Bullion Trades in Preview")
    public void BullionTrades_inPreview() {
        Assert.assertTrue("Include Metals should be visible",
                documentCreateNewPageObject.getBullionTrade_includeMetals().waitUntilVisible().isVisible());
        Assert.assertTrue("Exclude Metals should be visible",
                documentCreateNewPageObject.getBullionTrade_excludeMetals().waitUntilVisible().isVisible());
        Assert.assertTrue("Only Metals should be visible",
                documentCreateNewPageObject.getBullionTrade_OnlyMetals().waitUntilVisible().isVisible());
    }

    @Then("User will input Calculation Type")
    public void user_will_input_calculation_type(DataTable table) {
        documentCreateNewPageObject.clickSelectCalculationType(table);
    }
    @Then("User will input Limit Value")
    public void user_will_input_limit_value(DataTable table) {
        documentCreateNewPageObject.clickSelectLimitValue(table);
    }
    @Then("User will input Limit Value on Edit Limit screen")
    public void user_will_input_limit_value_on_edit_limit_screen(DataTable table) {
        documentCreateNewPageObject.clickSelectLimitValueForEditLimit(table);
    }
    @Then("User will edit Limit Value in Edit Limit Action")
    public void user_edit_limit_value(List<String> limitValue) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getEdit_limitValue_LimitAction().isClickable());
        documentCreateNewPageObject.getEdit_limitValue_LimitAction().sendKeys(limitValue.get(1));
    }
    @Then("User will input Netting Type")
    public void user_will_input_netting_type(DataTable table) {
        documentCreateNewPageObject.clickSelectNettingType(table);
    }
    @Then("User will input Delta")
    public void user_will_input_delta(DataTable table) {
        documentCreateNewPageObject.clickSelectDelta(table);
    }
    @Then("User will input Product family")
    public void user_will_input_product_family(DataTable table) {
        documentCreateNewPageObject.clickSelectProductFamily(table);
    }
    @Then("User edit the Product family")
    public void user_will_edit_product_family(DataTable table) {
        documentCreateNewPageObject.clickEditProductFamily(table);
    }

    @Then("User clicks on Limit Scope edit icon 4way")
    public void user_clicks_on_limit_scope_edit_icon_4way(DataTable table) {
        documentCreateNewPageObject.editLimitScopeProductFamily(table);
    }

    @Then("User edit the Product family 4way")
    public void user_will_edit_product_family_4way(DataTable table) {
        documentCreateNewPageObject.editProductFamily4Way(table);
    }
    @Then("User edit the Product family for DF")
    public void user_will_edit_product_family_DF(DataTable table) {
        documentCreateNewPageObject.clickEditProductFamily_DF(table);
    }

    @Then("User will input Exclude CLS from calculation")
    public void user_will_input_exclude_cls_from_calculation(DataTable table) {
        documentCreateNewPageObject.clickSelectExcludeCLS(table);
    }
    @Then("User clicks on Add Limit button")
    public void click_on_Add_Limit() {
        Assert.assertTrue(documentCreateNewPageObject.getAddLimit_btn().isDisplayed());
        documentCreateNewPageObject.getAddLimit_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User enters values in Copied limit line")
    public void user_enters_values_in_copied_line(DataTable table) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getCopy_AuthLineDF());
        documentCreateNewPageObject.copyLimitLine(table);
    }
    @Then("User click on save icon for limit line")
    public void click_On_Save_Icon() {
        documentCreateNewPageObject.getSave_Icon().click();
    }
//    @Then("User click on save icon for limit line for DF")
//    public void click_On_Save_IconDF() {
//        documentCreateNewPageObject.startContinuousToastInterceptor();
//        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getSave_IconDF());
//        documentCreateNewPageObject.getSave_IconDF().click();
//    }
    @Then("User click on save icon for limit line for 4way")
    public void click_On_Save_Icon_4way() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        WebElement saveBtn = getDriver().findElement(By.xpath("//button[@aria-label='Save']"));
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", saveBtn);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", saveBtn);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User clicks on Delete icon for limit line")
    public void click_On_Delete_Icon_LimitLineDF() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getLimitLine_Delete_Icon());
        documentCreateNewPageObject.getLimitLine_Delete_Icon().click();
    }
    @And("User validates General Terms saved successfully is displayed")
    public void GeneralTermsNotification(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getToastMessage_alert().getText().equalsIgnoreCase("General terms saved successfully"));
    }
    @And("User validates limit scope updated successfully is displayed")
    public void LimitScopeNotification(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getToastMessage_alert().getText().equalsIgnoreCase("Limit scope updated successfully"));
    }

    @Then("User enter Bullion Trades in Limit Scope")
    public void user_will_enterBullionTrade(List<String> bullion) {
        documentCreateNewPageObject.getBullionTrade_inputField().waitUntilVisible().click();
        withAction().moveToElement(documentCreateNewPageObject.getBullionTrade_inputField()).sendKeys(bullion.get(0)).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
    }
    @Then("User Final Preview & Submit the Document")
    public void user_final_preview_submit_the_document() {
        documentCreateNewPageObject.clickPreviewAndSubmit();
    }

    @Then("User verifies the following deleted products are displayed in Removed Products section")
    public void verifyDeletedProductsInRemovedSection(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            WebElement removedSectionHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[normalize-space()='Products Removed']")));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", removedSectionHeader);
            Thread.sleep(500);

        } catch (Exception e) {
            System.err.println("Could not find or scroll to 'Products Removed' section header: " + e);
        }
        for (Map<String, String> row : data) {
            String productToVerify = row.get("Product Family");
            String dynamicXpath = "//*[normalize-space()='Products Removed']/following::*[contains(normalize-space(), '" + productToVerify + "')]";

            try {
                WebElement removedItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", removedItem);
                Assert.assertTrue("Product '" + productToVerify + "' was not found in the Removed Products section.", removedItem.isDisplayed());

            } catch (TimeoutException e) {
                Assert.fail("Failed to find product '" + productToVerify + "' in the Removed Products section.");
            }
        }
    }

    @Then("User clicks on submit for approval button")
    public void submit_for_approval() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        documentCreateNewPageObject.getSubmitForApprovalButton().waitUntilClickable();
        documentCreateNewPageObject.getSubmitForApprovalButton().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("User clicks on submit for approval button for Edit Limit")
    public void submit_for_approval_for_edit_limit() {
        documentCreateNewPageObject.getSubmitForApprovalButtonForEditLimit().waitUntilClickable();
        documentCreateNewPageObject.getSubmitForApprovalButtonForEditLimit().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @Then("User clicks on submit for approval button on version Compare screen")
    public void submit_for_approvalCompareScreen() {
        documentCreateNewPageObject.getSubmitForApprovalButton_VersionCompareScreen().waitUntilVisible();
        documentCreateNewPageObject.getSubmitForApprovalButton_VersionCompareScreen().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User clicks on ignore button for name change")
    public void click_on_ignore_button() {
            documentCreateNewPageObject.handleUnsupportedFunctionalityPopUp();
    }
    @Then("Users click on Commit button on the following functionality is not supported pop-up")
    public void functionality_Not_Supported() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getCommitButton().isVisible());
        documentCreateNewPageObject.getCommitButton().click();
    }

    @Then("User clicks on Submit for Scope Change Preview")
    public void user_scopeChange_Preview_document() {
        documentCreateNewPageObject.getSubmitforScopeChangePreview().waitUntilVisible();
        documentCreateNewPageObject.getSubmitforScopeChangePreview().click();
        documentCreateNewPageObject.getIgnoreButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("User refreshes the browser")
    public void RefreshBrowser(){
        getDriver().navigate().refresh();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }

    @Then("User refreshes the browser on Batch Details Screen")
    public void RefreshBrowserBatchDetailsScreen(){
        getDriver().navigate().refresh();
        withAction().pause(Duration.ofSeconds(50)).build().perform();
    }

    @Then("User refreshes the browser on Batch Details Screen for status to be processed")
    public void RefreshBrowserBatchDetailsScreenProcessed(){
        withAction().pause(Duration.ofSeconds(40)).build().perform();
        getDriver().navigate().refresh();
    }

    @Then("User clicks on Preview & Submit tab")
    public void user_clicks_on_preview_submit_tab() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        documentCreateNewPageObject.clickPreviewAndSubmitTab();
    }
    @Then("User click on Cancel icon and select yes")
    public void User_click_on_Cancel_icon_and_select_yes(){
        documentCreateNewPageObject.clickCancel_icon();
    }

    @Then("User clicks on Limit Scope")
    public void user_clicks_on_Limit_Scope() {
        documentCreateNewPageObject.clickLimitScope();
    }
    @Then("User deletes all the Limit Lines")
    public void user_clicks_on_Limit_Lines() {
        documentCreateNewPageObject.DeleteAll_AuthLines();
    }

    @Then("User enable the Limit line and validate the same")
    public void user_enable_Limit_line() {
        documentCreateNewPageObject.EnableLimitLine();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getLimitLineEnabled().isVisible());
    }
    @Then("User enables first limit line")
    public void user_enable_first_Limit_line() {
        documentCreateNewPageObject.EnableFirstLimitLine();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getLimitLineEnabled().isVisible());
    }
    @Then("User will click on USP Rider tab in document edit")
    public void user_clicks_on_USP_Rider() {
        documentCreateNewPageObject.clickUSPRider();
    }
    @Then("User checks the NDF Cleared Trades checkbox")
    public void CheckNDFClearedCheckbox() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_Enabled());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            WebElement input = documentCreateNewPageObject.getNDF_Checkbox_Enabled().findElement(By.xpath(".//input"));
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", input);
        } catch (Exception e) {
            documentCreateNewPageObject.getNDF_Checkbox_Enabled().click();
        }
    }

    @Then("User verifies NDF Cleared Trades as true on Compare Screen")
    public void VerifyNDFClearedValue() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        WebElement ndfElement = documentCreateNewPageObject.getNDF_Checkbox_Enabled_Value();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", ndfElement);
        Assert.assertTrue("NDF Cleared Trades value 'True' is not displayed.", ndfElement.isDisplayed());
    }

    @Then("User verifies NDF Cleared Trades as false on Compare Screen")
    public void VerifyNDFClearedValueAsFalse() {
        WebElement ndfElement = documentCreateNewPageObject.getNDF_Checkbox_Disabled_Value();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", ndfElement);
        Assert.assertTrue("NDF Cleared Trades value 'True' is not displayed.", ndfElement.isDisplayed());
    }

    @Then("User Unchecks the NDF Cleared Trades checkbox")
    public void UncheckNDFClearedCheckbox() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_Enabled());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            WebElement input = documentCreateNewPageObject.getNDF_Checkbox_Enabled().findElement(By.xpath(".//input"));
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", input);
        } catch (Exception e) {
            documentCreateNewPageObject.getNDF_Checkbox_Enabled().click();
        }
    }

    @Then("User disables the Limit line and validate the same")
    public void user_disables_Limit_line() {
        documentCreateNewPageObject.DisableLimitLine();
    }
//    @Then("User clicks on limit line edit icon and enters value")
//    public void EditLimitLineAndEnterValue(String LimitValue) {
//        documentCreateNewPageObject.startContinuousToastInterceptor();
//        withAction().pause(Duration.ofSeconds(2)).build().perform();
//        documentCreateNewPageObject.EditLimitLine(LimitValue);
//    }
    @Then("^User (?:clicks on limit line edit icon and )?enters (?:limit line )?value$")
    public void EditLimitLineAndEnterValue(String LimitValue) {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.EditLimitLine(LimitValue);
    }

    @And("User will enter the Limit Value on Limit screen")
    public void user_will_enter_limit_value_on_limit_screen(io.cucumber.datatable.DataTable dataTable) {
        // Parse the DataTable to get the value passed in the feature file
        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String limitValue = data.get(0).get("Limit Value");
        // Call the page object method
        documentCreateNewPageObject.clearAndEnterLimitValue(limitValue);
    }
    @Then("User validates the Copy icon and clicks on it")
    public void user_validates_and_clicks_on_Copy_icon() {
        documentCreateNewPageObject.clickCopyIcon();
    }

    @Then("User clicks on Discard button")
    public void user_clicks_on_Discard() {
        documentCreateNewPageObject.getDiscard_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("user validates copy icon should not be there")
    public void user_validates_no_copy_icon() {
        documentCreateNewPageObject.noCopyIcon();
    }
    @Then("User validates participants in Approval workflow in copied document")
    public void user_validates_participants_in_approval_workflow() {
        Assert.assertTrue(documentCreateNewPageObject.validateApprovalWorkflowForCopiedDocument());
        documentCreateNewPageObject.clickNextbtn();
    }
    @Then("User validates data in Limit Scope")
    public void user_validates_participants_in_Limit_workflow() {
        documentCreateNewPageObject.validateLimitScope();
        documentCreateNewPageObject.clickNextbtn();
    }
    @Then("User validate the \"Notification recipient email ID\" text")
    public void user_validates_Notification_Email_text() {
        documentCreateNewPageObject.validateEmailText();
    }
    @Then("User waits for some time, refreshes the page and validates the status")
    public void user_refresh_and_Validate() {
        documentCreateNewPageObject.refresh_and_validate();
    }
    @Then("User waits for some time, refreshes the page")
    public void user_wait_and_refresh() {
        documentCreateNewPageObject.wait_and_refresh();
    }
    @Then("User validates the document status")
    public void user_Validate_Document_status(List<String> docStatus) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertEquals(docStatus.get(1).toLowerCase(),documentCreateNewPageObject.getStatus().getText().toLowerCase());
    }
    @Then("User approves the document")
    public void user_approves_document() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.approveDocument();
    }

    @Then("User will click on Submit Button")
    public void submitButton() {
        documentCreateNewPageObject.getSubmit_btn().waitUntilVisible();
        documentCreateNewPageObject.startContinuousToastInterceptor();
        evaluateJavascript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getSubmit_btn());
        evaluateJavascript("arguments[0].click();", documentCreateNewPageObject.getSubmit_btn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("user validates Submit button is disabled")
    public void Submit_button_should_be_disabled_on_USP_template_update_screen(){
        Assert.assertTrue(documentCreateNewPageObject.getSubmit_btn().isDisabled());
       }
    @Then("User clicks on Terminate button")
    public void terminateButton() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getTerminate_btn().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @And("Click on Yes button of popup")
    public void clickOnYesButtonOfPopup()
    {
        Assert.assertTrue(documentCreateNewPageObject.getPopup_Yes_btn().isVisible());
        documentCreateNewPageObject.getPopup_Yes_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("Click on Yes button")
    public void clickOnYesButton()
    {
        Assert.assertTrue(documentCreateNewPageObject.getPopup_Yes_btn().isVisible());
        documentCreateNewPageObject.getPopup_Yes_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User validates the notification for Document Termination")
    public void document_terminated_notification()
    {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getDoc_terminated_Notification().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }

    @Then("User select the approval group")
    public void user_select_approval_group() {
        documentCreateNewPageObject.approvalGroupSelect();
    }
    @Then("Verify renaming of Legal term to document terms")
    public void Verify_renaming_of_Legal_term_to_document_terms() {
        documentCreateNewPageObject.CheckDocumentTerms();
    }
    @Then("Verify renaming of Legal term to document terms in document comparison")
    public void Verify_renaming_to_document_terms_comparison() {
        documentCreateNewPageObject.CheckDocumentTermsComparison();
    }

    @Then("Verify renaming of Legal term to document terms on View as PDF")
    public void Verify_renaming_to_document_terms_on_view_as_pdf() {
        documentCreateNewPageObject.CheckDocumentTermsOnViewAsPdf();
    }

    @When("User on Final Preview & Submit tab of Document")
    public void user_on_final_preview_submit_tab_of_document() {
        documentCreateNewPageObject.PreviewAndSubmit();
    }
    @Then("Verify renaming of Legal term to document terms on final submit & preview")
    public void Verify_renaming_of_Legal_term_to_document_terms_on_final_submit_and_preview() {
        documentCreateNewPageObject.CheckDocumentTermsTab();
    }
// Started from hare


    @When("User clicks on document terms tab")
    public void documentTerms()
    {
        documentCreateNewPageObject.getDocumentTerms().waitUntilClickable();
        documentCreateNewPageObject.getDocumentTerms().click();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @When("Verify Document templates dropdown")
    public void verify_document_templates_dropdown()
    {
        documentCreateNewPageObject.templatesDropdown();
        Assert.assertTrue( documentCreateNewPageObject.getSelect_temp_dropdown().isVisible());
    }

    @When("Verify user is able to select Templates")
    public void verify_user_is_able_to_select_templates(DataTable table)
    {
        documentCreateNewPageObject.SelectTemplates(table);
    }

    @When("Verify user is able to see Template Preview")
    public void verify_user_is_able_to_see_template_preview()
    {
        documentCreateNewPageObject.verify_temp_preview();
        Assert.assertTrue(documentCreateNewPageObject.getTemp_preview().isVisible());
    }

    @When("Verify ApprovalWorkflow , Enforcement Rule , Document Terms Text and dropdown button are visible of templates")
    public void verify_approval_workflow_enforcement_rule_legal_term_text_and_dropdown_button_are_visible_of_templates()
    {
        Assert.assertTrue(documentCreateNewPageObject.getApproval_workflow().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getEnforcement_rule().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getDocument_term().isVisible());


    }

    @When("verify prefilled data")
    public void verify_prefilled_data() {
        documentCreateNewPageObject.verify_prefilled_data();
    }

    @Then("Verify user is on Edit Document page")
    public void verify_user_is_on_edit_document_page()
    {
        Assert.assertTrue(documentCreateNewPageObject.getEdit_document().isVisible());
    }

    @Then("Verify user able to add currency")
    public void verify_user_able_to_add_currency(List<String> selectcurrencyList)
    {
        documentCreateNewPageObject.Validate_Add_currency_from_AuthScope(selectcurrencyList);

    }
    @Then("Verify user able to remove currency")
    public void verify_user_able_to_remove_currency(List<String> remove_currencyList)
    {
        documentCreateNewPageObject.Validate_Remove_currency_from_AuthScope(remove_currencyList);

    }
    @When("User select unique parties as Client1,PrimeBroker1")
    public void user_select_parties_as_PB1_client1(DataTable table) {
        documentCreateNewPageObject.clickSelectPartiesAsPB1(table);
        documentCreateNewPageObject.clickSelectPartiesAsClient1(table);
        documentCreateNewPageObject.generateRandomPB2();
        documentCreateNewPageObject.generateRandomClient2();
    }
    @Then("User validates document Copied successfully pop-up")
    public void verify_Document_Created_popUp()
    {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getDocCreatedSuccessfully().isDisplayed());
    }

    @When("user will select value for Lifecycle Status filter value")
    public void user_select_document_filter_for_lifecycleStatus(DataTable table) {
        documentCreateNewPageObject.selectLifecycleStatus(table);
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @When("Verify that No Terminate button is visible")
    public void Verify_No_Terminate_Button() {
        Assert.assertFalse(documentCreateNewPageObject.getTerminate_btn().isVisible());
    }
    @When("User validates Auth Scope Data in Document Preview")
    public void Verify_Bullion_And_Volatility(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateAuthScopeData(table));
        }

    @When("User validates Auth Scope Data in Document Preview of Bulk Action")
    public void Verify_Auth_Scope_in_Doc_Preview(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateDocumentData(table));
    }

    @When("User validates Auth Scope Data is not in Document Preview of Bulk Action")
    public void Verify_Auth_Scope_is_not_in_Doc_Preview(DataTable table) {
        Assert.assertFalse(documentCreateNewPageObject.validateDocumentData(table));
    }

    @When("User validates Limit Value in Document Preview")
    public void Verify_Limit_Value_in_Doc_Preview(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateLimitValueData(table));
    }
    @When("User validates the Document terms data in view as PDF")
    public void ValidateDocumentTermsData(String Data) {
        Assert.assertTrue(documentCreateNewPageObject.validateDocumentTermsDataInViewAsPDF(Data));
    }

    @When("User validates Auth Scope Data in view as PDF")
    public void BullionTradeAndVolatilitySwapInPDF(DataTable table) {

        Assert.assertTrue(documentCreateNewPageObject.validateAuthScopeData(table));
    }
    @When("User validates Auth Scope Data on Preview of Document")
    public void user_validates_Auth_Scope_Data_on_Preview_of_Document(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateAuthScopeDataInPreview(table));
    }
    @When("User validates the BullionTrade in Preview in DF")
    public void BullionTradeInPDF_DF() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getBullionVanilla_inPreviewDF().getText().contains("Bullion Vanilla"));
    }
    @When("User validates the BullionTrade in Preview in DF in view as PDF")
    public void BullionTradeInPDF_InDF() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getBullionVanilla_inPreviewDF());
        Assert.assertTrue(documentCreateNewPageObject.getBullionVanilla_inPreviewDF().getText().contains("Bullion Vanilla"));
    }
    @When("User clicks on view as PDF button")
    public void Click_view_as_pdf() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getViewAsPDF_btn());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getViewAsPDF_btn().isVisible());
        documentCreateNewPageObject.getViewAsPDF_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @When("User validates the DN document on listing screen")
    public void ValidateDocument() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getDN_doc_Listing_screen().isVisible());
    }
    @When("User validates the 4Way document on listing screen")
    public void Way4_ValidateDocument() {
        Assert.assertTrue(documentCreateNewPageObject.getWay4_doc_Listing_screen().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @When("User validates the Bullion in Limit Line in Preview in DF")
    public void BullionLimitLineIn_DF() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getBullionLimitLine_inPreview().isDisplayed());
    }
    @When("User validates the Bullion in Limit Line in view as PDF")
    public void BullionLimitLineIn_PDF_DF() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getBullionLimitLine_inPDF().isDisplayed());
    }
    @And("Validate that Enforcement Rule is read only")
    public void User_validate_read_only_enforcementRule(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertFalse(documentCreateNewPageObject.getEnforcenew().isVisible());
    }
    @Then("^Validates that approval workflow is read only$")
    public void approval_workflow_read_only() {
        Assert.assertTrue(documentCreateNewPageObject.getRead_Only_Tiles().isVisible());
        Assert.assertFalse(documentCreateNewPageObject.getClient().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getDrag_DropValidation().isVisible());
        Assert.assertTrue(documentCreateNewPageObject.getApprovalSeq1().isVisible());
    }
    @And("Validate approval workflow client option")
    public void validateApprovalWorkflowClientOption() {
        Assert.assertFalse(documentCreateNewPageObject.getClient().isVisible());
    }
    @And("Validate No options should be displayed")
    public void NoOptionsDisplayed() {
        Assert.assertTrue(documentCreateNewPageObject.getNoOptions().isDisplayed());
    }
    @And("Validate No options should Not be displayed")
    public void NoOptionsIsNotDisplayed() {
        Assert.assertFalse(documentCreateNewPageObject.getNoOptions().isVisible());
    }
    @And("User applies filter of the current date for CreatedOn Local Time")
    public void createdOnLocalTime() {
        documentCreateNewPageObject.CreatedOnLocalTime();
        Assert.assertTrue(documentCreateNewPageObject.getConfirmDate().isVisible());
        documentCreateNewPageObject.getConfirmDate().click();
    }
    @And("User applies filter of the current date for CreatedOn UTC Time")
    public void createdOnUTCTime() {
        documentCreateNewPageObject.CreatedOnUTCTime();
        Assert.assertTrue(documentCreateNewPageObject.getConfirmDate().isVisible());
        documentCreateNewPageObject.getConfirmDate().click();
    }
    @And("User validate the error message for DN operations prohibited")
    public void DN_Operations_Prohibited_Error() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getDN_opr_prohibited_warning().isDisplayed());
    }
    @And("User validate the error message for DN operations prohibited should not come")
    public void No_DN_Operations_Prohibited_Error() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.validateNoProhibited_Error());
    }
    @And("User selects the Settlement type")
    public void select_Settlement_Type(List<String> str) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getNon_deliverable());
        if(str.get(0).equalsIgnoreCase("Non Deliverable"))
        {
            documentCreateNewPageObject.getNon_deliverable().isVisible();
            documentCreateNewPageObject.getNon_deliverable().click();
        }
        else if(str.get(0).equalsIgnoreCase("Deliverable"))
        {
            documentCreateNewPageObject.getDeliverable().isVisible();
            documentCreateNewPageObject.getDeliverable().click();
        }
    }

    @And("User selects the multiple Settlement types")
    public void select_Multiple_Settlement_Types(List<String> types) {
        for (String type : types) {
            if (type.equalsIgnoreCase("Non Deliverable")) {
                WebElementFacade element = documentCreateNewPageObject.getNon_deliverable();
                element.waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
                try { element.click(); } catch (Exception e) { getJavascriptExecutorFacade().executeScript("arguments[0].click();", element); }
            } else if (type.equalsIgnoreCase("Deliverable")) {
                WebElementFacade element = documentCreateNewPageObject.getDeliverable();
                element.waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
                try { element.click(); } catch (Exception e) { getJavascriptExecutorFacade().executeScript("arguments[0].click();", element); }
            }
            withAction().pause(java.time.Duration.ofMillis(500)).build().perform();
        }
    }

    @And("User clicks on document version ID on Dashboard")
    public void clickOnDocument(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        try {
            WebElementFacade link = documentCreateNewPageObject.getDocumentLink();
            link.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", link);
            link.click();
        } catch (Exception e) {
            WebElement btn = getDriver().findElement(By.xpath("//tbody/tr[1]//button[contains(text(), '4W-') or contains(text(), 'DF-') or contains(text(), 'DN-')] | //tbody/tr[1]//button"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", btn);
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", btn);
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User clicks on document version ID on Batch Details Dashboard")
    public void clickOnBatchDetailsDocument(){
        documentCreateNewPageObject.getBulkApproveVersionId().waitUntilVisible();
        documentCreateNewPageObject.getBulkApproveVersionId().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User validates the limit line")
    public void User_validates_LimitLine(DataTable table){
        documentCreateNewPageObject.validateLimitLine(table);
    }
    @And("User validates the limit line is deleted")
    public void User_validates_LimitLine_deleted(DataTable table){
        documentCreateNewPageObject.validateLimitLineDeleted(table);
    }
    @And("User validates the Auth line is added")
    public void User_validates_AuthLine_added(DataTable table){
        documentCreateNewPageObject.validateAuthLineAdded(table);
    }
    @And("User validates the Auth line is deleted")
    public void User_validates_AuthLine_deleted(DataTable table){
        documentCreateNewPageObject.validateAuthLineDeleted(table);
    }
    @And("User navigates to Limit Line in PDF")
    public void User_navigates_to_LimitScope_inPDF(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getLimitScope());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User navigates to Auth Scope in PDF")
    public void User_navigates_to_AuthScope_inPDF(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getAuthScope());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User stores the first Document ID from Document dashboard and searches it")
    public void FirstDocumentID(){
        documentCreateNewPageObject.firstDocumentID();

    }
    @And("User validates Show latest version screen")
    public void ShowLatestVersionScreen(){
        Assert.assertTrue(documentCreateNewPageObject.getShowLatestVersion().isDisplayed());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User clicks on Show latest version screen checkbox")
    public void ShowLatestVersionCheckbox(){
        Assert.assertTrue(documentCreateNewPageObject.getShowLatestVersionCheckbox().isDisplayed());
        documentCreateNewPageObject.getShowLatestVersionCheckbox().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User clicks on compare button icon")
    public void ClickOnCompareButtonIcon(){
        Assert.assertTrue(documentCreateNewPageObject.getCompareButton().isDisplayed());
        documentCreateNewPageObject.getCompareButton().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User closes the compare screen")
    public void ClickOnCompareButtonCloseIcon(){
        Assert.assertTrue(documentCreateNewPageObject.getCompare_Close_Button().isDisplayed());
        documentCreateNewPageObject.getCompare_Close_Button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("Validate Compare button is not visible")
    public void NoCompareButtonIcon(){
        try {
            documentCreateNewPageObject.getCompareButton().isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
    @And("User validates text is visible")
    public void validateText(DataTable table){
        documentCreateNewPageObject.validateText(table);
    }
    @And("User validates text is visible in preview")
    public void validateTextInPreview(DataTable table){
        documentCreateNewPageObject.validateTextInPreview(table);
    }
    @And("User validates text is NOT visible")
    public void ValidateTextNotdisplayed(DataTable table){
        documentCreateNewPageObject.ValidateTextNotdisplayed(table);
    }
    @And("User validates the Dates data on the Dashboard")
    public void ValidateDataOnDashboard(){
        documentCreateNewPageObject.validateDocumentData();
    }

    @And("User deletes all the document if available")
    public void userDeletesAllTheDocumentIfAvailable() {
        documentCreateNewPageObject.deletAllAvailableDocument();
    }

    @And("Select rules for the document")
    public void selectRulesForTheDocument() {
        documentCreateNewPageObject.selectRulesForDocument();
    }

    @And("The user Select all the dates")
    public void theUserSelctAllTheDates(DataTable table) {
        documentCreateNewPageObject.selectDates(table);
    }

    @Then("User validates all Product Families should be selected for Limit Scope")
    public void Validate_LimitScope_SelectAll() {
        Assert.assertEquals("Cash+4",productGroupAddNewPageObject.validateSelectAllProductFamily());
    }
    @Then("User validates all selected Products are deSelected in LimitScope")
    public void Validate_DeSelected_SelectAll() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getSelectProductFamily().isDisplayed());
    }
    @Then("User deletes the all the limit lines")
    public void Delete_All_Limitlines() {
        DMS_1548.Remove_all_product_lines();
    }

//    @And("User deletes the document if it already exists")
//    public void userDeletesTheDocumentIfItAlreadyExists() {
//        documentCreateNewPageObject.performDelete
//    }

    @Then("Verify NDF Cleared Trades checkbox is visible")
    public void Validate_NDF_cleared_trade_isVisible() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_Visible());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getNDF_Checkbox_Visible().isDisplayed());
    }
    @Then("Verify NDF Cleared Trades checkbox is disabled")
    public void Validate_NDF_cleared_trade_disabled() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_Disabled());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getNDF_Checkbox_Disabled().isDisplayed());
    }
    @Then("Verify NDF Cleared Trades checkbox is set to True in EDN Preview")
    public void Validate_NDF_cleared_trade_True() {
        documentCreateNewPageObject.getNDF_Checkbox_True_Preview().withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_True_Preview());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getNDF_Checkbox_True_Preview().isDisplayed());
    }
    @Then("Verify NDF Cleared Trades checkbox is set to False")
    public void Validate_NDF_cleared_trade_False() {
        documentCreateNewPageObject.getNDF_Checkbox_False_Preview().withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_False_Preview());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getNDF_Checkbox_False_Preview().isDisplayed());
    }

    @Then("Verify NDF Cleared Trades checkbox is set to true for View as PDF")
    public void Validate_NDF_cleared_trade_True_PDF() {
        documentCreateNewPageObject.getNDF_Checkbox_True_ViewPDF().withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_True_ViewPDF());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getNDF_Checkbox_True_ViewPDF().isDisplayed());
    }
    @Then("Verify NDF Cleared Trades checkbox is set to False for View as PDF")
    public void Validate_NDF_cleared_trade_False_PDF() {
        documentCreateNewPageObject.getNDF_Checkbox_False_ViewPDF().withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getNDF_Checkbox_False_ViewPDF());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentCreateNewPageObject.getNDF_Checkbox_False_ViewPDF().isDisplayed());
    }
    @When("User validates Auth Scope Data in view as PDF for Deliverable currencies")
    public void validateAuthScopeDataForDeliverableCurrencies (DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateAuthScopeDataForDeliverableCurrencies(table));
    }

    @And("User clicks on Preview of Document")
    public void click_on_Doc_preview(){
        Assert.assertTrue(documentCreateNewPageObject.getDoc_on_listingScreen().isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getDoc_on_listingScreen());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getDoc_on_listingScreen().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User validates the disabled Tenor type for Spot only")
    public void validateDisableTenorType() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getSpotOnlyDisabledTenor());
        Assert.assertTrue(documentCreateNewPageObject.getSpotOnlyDisabledTenor().isDisplayed());
    }
    @Then("User validated the Tenor values for Auth line")
    public void validateTenorType(DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateTenorValue(table));
    }
    @Then("User validates the values in Tenor drop-down for Spot only")
    public void validateDropDownValues() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getSpotValueDropDown());
        documentCreateNewPageObject.getSpotValueDropDown().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        String dropdownText = documentCreateNewPageObject.getDropDownValues().getText();
        try {
            getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
        } catch (Exception ignored) {}
        Assert.assertTrue("Dropdown text did not contain Calendar Days and Business Days. Actual: " + dropdownText,
                dropdownText.toLowerCase().contains("calendar days") && dropdownText.toLowerCase().contains("business days"));

    }

    @Then("User enter Tenor Value")
    public void enterTenorValues(String TenorValue) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getTenorValueInput());
        documentCreateNewPageObject.getTenorValueInput().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getTenorValueInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        documentCreateNewPageObject.getTenorValueInput().sendKeys(TenorValue);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("User enters the Tenor Type")
    public void enterTenorType(String TenorDays) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getTenorDays());
        documentCreateNewPageObject.getTenorDays().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getTenorDays().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        documentCreateNewPageObject.getTenorDays().sendKeys(TenorDays);
        withAction().sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User validates the LEI {string} is NOT present in the dropdown for {string}")
    public void validate_lei_not_present(String leiValue, String fieldName) {
        documentCreateNewPageObject.validateValueNotPresentInDropdown(leiValue, fieldName);
    }

    @When("User validates Auth Scope Data in view as PDF for Non-Deliverable currencies")
    public void validateAuthScopeDataForNonDeliverableCurrencies (DataTable table) {
        Assert.assertTrue(documentCreateNewPageObject.validateAuthScopeDataForNonDeliverableCurrencies(table));
    }

    @Then("User clicks on Expand row Icon")
    public void clickOnExpandButton() {
        documentCreateNewPageObject.getExpandButton().click();
    }
    @Then("User will input Limit Value in Bulk Edit")
    public void user_will_input_limit_value_BulkEdit(DataTable table) {
        documentCreateNewPageObject.clickSelectLimitValueInBulkEdit(table);
    }
    @Then("User click on Approval Workflow for DN tab")
    public void click_approval_workflow_tab_in_docs(){
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        documentCreateNewPageObject.getApproval_Workflow_tab().click();
    }

    @Then("User is on document listing screen again")
    public void navigate_to_doc_screen() {
        documentCreateNewPageObject.getOnDocumentScreen();
    }
    @And("Click on Commit button of popup if it appears")
    public void clickOnCommitButtonOfPopup() {
        try {
            // Check if the commit button is visible within 5 seconds
            if (documentCreateNewPageObject.getPopup_Commit_btn().withTimeoutOf(Duration.ofSeconds(5)).isCurrentlyVisible()) {
                documentCreateNewPageObject.getPopup_Commit_btn().waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            } else {
                log.info("Commit popup did not appear. Continuing execution.");
            }
        } catch (Exception e) {
            log.info("Commit popup was not found, which is acceptable. Continuing execution.");
        }
    }
    @And("Clicks on Approve Button for approval Group")
    public void clickOnApproveButton() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getApproveBtn_approvalGrp().click();
    }
    @And("^Clicks on Approve Button for approval Group on DF screen$")
    public void clickOnApproveButtonOnDFScreen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.clickApproveButtonOnDFScreen();
    }

    @And("Click on Approve button of popup")
    public void clickOnApproveButtonOfPopup() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        documentCreateNewPageObject.getApproveButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User click on Approval Workflow in 4 Way")
    public void click_approval_workflow_tab_in_4Way(){
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        documentCreateNewPageObject.getApproval_Workflow_tab_4Way().click();
    }
    @When("User Validates Product group dropdown should not be there")
    public void validatePGDropDownIsNotThere () {
        try{
            documentCreateNewPageObject.getAuthProducts_group().isDisplayed();
        }
        catch(NoSuchElementException e)
        {
            Assert.assertTrue(true);
        }
    }
    @When("User validates the below attribute is selected")
    public void validate_attribute_isSelected(DataTable attribute) {
       Assert.assertTrue(documentCreateNewPageObject.validateAttributeIsSelected(attribute));
    }
    @When("User validates the below attribute is NOT selected")
    public void validate_attribute_isNOTSelected(DataTable attribute) {
        Assert.assertFalse(documentCreateNewPageObject.validateAttributeIsNOTSelected(attribute));
    }
    @When("User gets the view details error")
    public void validate_viewDetails() {
        Assert.assertTrue(documentCreateNewPageObject.getViewDetailsError().isDisplayed());
    }
    @When("User validates the Product group selection limit")
    public void validate_ProductGroup() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentCreateNewPageObject.getAuthProducts_group());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getAuthProducts_group().click();
        documentCreateNewPageObject.getAuthProducts_group().sendKeys("automation");
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertEquals(10,documentCreateNewPageObject.getDropDownValues_inApprovalGroup().size());
    }
    @When("User tick the USP Rider checkbox")
    public void validate_USPRider_Checkbox() {
        Assert.assertTrue(documentCreateNewPageObject.getUSP_Rider_Checkbox().isDisplayed());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getUSP_Rider_Checkbox());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getUSP_Rider_Checkbox().click();
    }
    @When("User selects the USP Rider and enter the date")
    public void validate_DateForUSPRider() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getUSP_Rider_Calendar_Icon());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getUSP_Rider_Calendar_Icon().click();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentCreateNewPageObject.getUSP_Rider_Date_Selection());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentCreateNewPageObject.getUSP_Rider_Date_Selection().click();
    }

    @Then("User will input email Id")
    public void user_will_input_email_id(DataTable dataTable) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        documentCreateNewPageObject.enterManualPDFApprovalEmail(dataTable);
    }
    @Then("User validate the email id")
    public void user_validate_the_email_id(DataTable dataTable) {
        documentCreateNewPageObject.validateEmailId(dataTable);
    }
    @Then("User will validate empty input box")
    public void user_will_validate_empty_input_box() {
        documentCreateNewPageObject.validateEmptyInputBox();
    }
    @Then("User removes the email")
    public void user_removes_the_email() {
        documentCreateNewPageObject.removeEmailId();
    }
    @Then("User click on copy button")
    public void click_copy_button() {
        documentCreateNewPageObject.getCopy_icon().click();
    }
    @Then("User validates the email on preview")
    public void user_validates_the_email_on_preview(DataTable dataTable) {
        documentCreateNewPageObject.validateEmailOnPreview(dataTable);
    }
    @Then("User remove the approver")
    public void remove_approver_from_workflow(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        documentCreateNewPageObject.getRemoveApprover().click();
    }
    @Then("User clicks on Submit button for Scope Change Preview")
    public void user_scope_Change_Preview_document() {
        documentCreateNewPageObject.getSubmitforScopeChangePreview().waitUntilVisible();
        documentCreateNewPageObject.getSubmitforScopeChangePreview().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User sorts in \"([^\"]*)\" in descending order$")
    public void user_sorts_in_descending_order(String ColumnName) {
        documentCreateNewPageObject.sortInDescendingOrder(ColumnName);

    }

    @Then("User click on Tenor Configuration")
    public void user_click_tenor_config_button() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getTenorConfig().click();
    }
    @Then("user select tenor value and auth tenor for {string} product")
    public void user_select_tenor_value_and_auth_tenor_for_product(String product, DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.selectTenorForProduct(product, table);
    }
    @Then("User click on save tenor button")
    public void user_click_save_tenor_button() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getSaveTenor().click();
    }
    @Then("User will validate the tenor value and auth value")
    public void user_will_validate_tenor_and_auth(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.validateTenorAndAuthValue(table);
    }
    @Then("User clicks on Cancel button of tenor config popup")
    public void user_clicks_cancel_on_tenor_popup (){
        documentCreateNewPageObject.getCancelButton_tenorConfig().click();
    }
    @Then("User clicks on clear all button")
    public void user_clicks_clear_all_button() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getClear_all_button().click();
    }
    @Then("User will validate the tenor value")
    public void user_will_validate_the_tenor_value(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.validateTenorValueOnly(table);
    }
    @Then("User will validate the tenor value in DF")
    public void user_will_validate_the_tenor_value_in_DF(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.validateTenorValueOnlyInDF(table);
    }

    @Then("User clicks on edit icon on product line")
    public void user_click_on_edit_icon_for_product_line() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.getEditIconForPG().click();
    }
    @Then("User select product from pop up")
    public void user_select_product_for_product_line(DataTable dataTable) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentCreateNewPageObject.selectProductFromPopUp(dataTable);
    }
    @Then("User will input Calculation Type for advance filter")
    public void user_will_input_calculation_type_adFilter(DataTable table) {
        documentCreateNewPageObject.clickSelectCalculationTypeForAdvanceFilter(table);
    }
    @Then("User validates Exclude CLS is enable or not")
    public void user_validates_enable_element_excludeCLS(){
        documentCreateNewPageObject.validateEnabledElementExcludeCLS();
    }
    @Then("User enter on notification recipient email ID")
    public void enter_notification_recipient_email(DataTable dataTable) {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.enterLiteUserEmail(dataTable);
    }
    @Then("User enter a limit value")
    public void enter_limit_values(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentCreateNewPageObject.userEnterLimitValue(dataTable);
    }
    @Then("User clicks on submit for approval button on edit screen")
    public void submit_for_approval_editScreen() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        documentCreateNewPageObject.getSubmitForApprovalButtonForEdit().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User will compare the version of the document")
    public void userWillCompareTheVersionOfTheDocument(DataTable table) {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        documentCreateNewPageObject.compareDocumentVersions(table);
    }
    @Then("User checks if Legal Name changes pop-up appears ignore it")
    public void ignoreLegalNameChangesPop_up() {
        documentCreateNewPageObject.ignoreLegalNameChangePopupIfPresent();
    }
    @Then("User validates the warning pop-up message")
    public void user_validates_the_warning_pop_up_message(DataTable dataTable) {
        Assert.assertTrue(documentCreateNewPageObject.validateWarningPopupMessage(dataTable));
    }
    @Then("User clicks on {string} button")
    public void user_clicks_on_dynamic_button(String buttonName) {
        documentCreateNewPageObject.clickOnDynamicButton(buttonName);
    }

    @And("User enables Tenor for DN")
    public void user_enables_tenor_for_DN() {
        documentCreateNewPageObject.enableTenor_DN();
    }

    @Then("User will input Auth Tenor value for DN")
    public void user_will_input_auth_tenor_value_for_DN(DataTable table) {
        documentCreateNewPageObject.inputAuthTenorValue_DN(table);
    }

    @Then("User will select tenor in Auth Tenor for DN")
    public void user_will_select_tenor_in_auth_tenor_for_DN(DataTable table) {
        documentCreateNewPageObject.selectAuthTenorType_DN(table);
    }
    @Then("User clicks on edit icon for limit line")
    public void click_Limit_Line() {
        documentCreateNewPageObject.getLimitLineEditIcon().waitUntilVisible();
        documentCreateNewPageObject.getLimitLineEditIcon().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User validates the following attributes for Auth Line {string}")
    public void user_validates_the_following_attributes_for_Auth_Line(String authLineName, DataTable table) {
        documentCreateNewPageObject.validateAttributesForAuthLine(authLineName, table);
    }

    @Then("User enable the Limit line where Cash is not present")
    public void user_enable_Limit_line_where_Cash_is_not_present() {
        documentCreateNewPageObject.EnableLimitLineWithoutCash();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

}
