package stepDefinations.Document;

import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.Documents.DocumentSingleEditPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@Slf4j
public class DocumentSingleEditStep extends PageObject {
    Actions act=new Actions(getDriver());
    DocumentPageObject documentPageObject;
    DocumentSingleEditPageObject documentSingleEditPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Given("^User is on the all document screen$")
    public void user_is_on_the_all_document_screen(){
        act.pause(Duration.ofSeconds(7)).build().perform();
        documentPageObject.clickMenuButton();
        documentPageObject.clickDocumentTab();
        documentPageObject.verifyDocumentText();
        documentPageObject.unselectShowOnlyLatestVersion();
    }
    @Given("^User clicks on All documents in side menu$")
    public void user_clicks_on_all_document_screen(){
        act.pause(Duration.ofSeconds(2)).build().perform();
        documentPageObject.clickMenuButton();
        act.pause(Duration.ofSeconds(2)).build().perform();
        documentPageObject.getAllDocument_tab().waitUntilClickable().click();
        documentPageObject.verifyDocumentText();
    }

    @When("^User set the filter expect in approval$")
    public void user_set_the_filter_expect_inapproval(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }
    @When("^User set the filter for which edit button should be visible$")
    public void user_set_the_filter_for_which_edit_button_should_be_visible(DataTable table){
        Assert.assertTrue(documentPageObject.getDocumentstatus_col().isVisible());
        documentPageObject.check_if_filterStatus_and_type(table);
    }

    @Then("^Edit button should be visible for all the documents on the screen$")
    public void edit_button_should_be_visible_for_all_the_documents_on_the_screen()  {
        documentSingleEditPageObject.check_edit_button_on_the_alldocument_screen();
    }
    @When("^User will set the filter as draft$")
    public void user_will_set_the_filter_as_draft(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);

    }
    @And("^Search for document and click on edit button on the all document screen$")
    public void search_for_document_and_click_on_edit_button_on_the_all_document_screen(DataTable table) {
        documentPageObject.search_document(table);
        documentSingleEditPageObject.check_edit_button();
        if (documentPageObject.getDocumentedit_btn().isVisible()){
            documentPageObject.getDocumentedit_btn().click();
        }
        else {
            log.info("Document not present");
        }

    }
    @And("^Search for document version and click on edit button on the all document screen$")
    public void search_for_document_version_and_click_on_edit_button_on_the_all_document_screen(DataTable table) {
        documentPageObject.search_document_using_versionid(table);
        documentSingleEditPageObject.check_edit_button();
        if (documentPageObject.getDocumentedit_btn().isVisible()){
            documentPageObject.getDocumentedit_btn().click();
            act.pause(Duration.ofSeconds(6)).build().perform();
        }
        else {
            log.info("Document not present");
        }

    }
    @And("^Search for document on the all document screen$")
    public void search_for_document_on_the_all_document_screen(DataTable table) {
        documentPageObject.search_document(table);
    }

    @Then("User deletes the document if it exists")
    public void user_is_able_to_verify_the_current_status_of_the_document() {
        try {
            if (documentPageObject.getDN_Document().isVisible()) {
                List<WebElementFacade> deleteBtns = documentPageObject.getDocumentdelete_btn();
                if (deleteBtns != null && !deleteBtns.isEmpty() && deleteBtns.get(0).isVisible()) {
                    boolean clicked = false;
                    for (WebElement btn : deleteBtns) {
                        btn.click();
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        clicked = true;
                    }
                    if (clicked && documentPageObject.getYES_Btn_confirm_delete_document().isVisible()) {
                        documentCreateNewPageObject.startContinuousToastInterceptor();
                        documentPageObject.getYES_Btn_confirm_delete_document().waitUntilClickable().click();
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        documentPageObject.getTrack_screen_norecordfound().isVisible();
                    }
                } else {
                    log.info("Delete icon does not exist for the document. Skipping deletion and continuing with next steps.");
                }
            } else {
                log.info("No Record found");
            }
        }catch (Exception e) {
            // Catching any unexpected errors so the test does not fail and moves to the next step
            log.info("Exception caught while trying to delete the document. Ignoring to continue next steps: " + e.getMessage());
        }
    }

    @Then("User deletes the 4 Way document if it exists")
    public void user_is_able_to_verify_the_current_status_of_the_4Way_document() {
        if(documentPageObject.getWay_Document().isVisible())
        {
            for (WebElement btn : documentPageObject.getDocumentdelete_btn()) {
                btn.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            documentPageObject.getYES_Btn_confirm_delete_document().waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            documentPageObject.getTrack_screen_norecordfound().isVisible();
        }
        else {
            log.info("No Record found");
        }
    }

    @Then("^user validates the document is created")
    public void documentexists()  {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentPageObject.getDN_Document());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentPageObject.getDN_Document().isPresent());
    }
    @Then("^User refreshes the document screen$")
    public void refreshDocumentScreen()  {
        documentPageObject.getRefreshButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("^User is able to see approval workflow tab$")
    public void Validate_Approval_Workflow()  {
        withAction().pause(Duration.ofSeconds(15)).build().perform();
       Assert.assertTrue(documentPageObject.getApprovalWorkflowTab().isVisible());
    }

    @Then("^User is able to see approval workflow tab for DF$")
    public void Validate_Approval_Workflow_DF()  {
        withAction().pause(Duration.ofSeconds(15)).build().perform();
        Assert.assertTrue(documentPageObject.getApprovalWorkflowTabDF().isVisible());
    }

    @Then("^Edit popup window should appear$")
    public void edit_popup_window_should_appear()  {
        documentSingleEditPageObject.check_editScreen_columns();
    }
    @Then("^Verify User reaches on edit pop up window$")
    public void verify_user_reaches_on_edit_pop_up_window(){
        Assert.assertTrue(documentSingleEditPageObject.getEdit_title_edit_popup().isVisible());
    }

    @And("^Current version ID is visible$")
    public void current_version_id_is_visible()  {
        Assert.assertTrue(documentSingleEditPageObject.getCurrenctversionID_text().isVisible());
        Assert.assertTrue(documentSingleEditPageObject.getCurrenctversionID_value().isVisible());
    }

    @And("^Document type is visible$")
    public void document_type_is_visible()  {
        Assert.assertTrue(documentSingleEditPageObject.getDocumenttype_text().isVisible());
        Assert.assertTrue(documentSingleEditPageObject.getDocumenttype_value().isVisible());
    }

    @And("^Cancel button should be visible$")
    public void cancel_button_should_be_visible(){
        Assert.assertTrue(documentSingleEditPageObject.getCancel_edit_popup().isVisible());
    }

    @And("^Submit button should be visible$")
    public void submit_button_should_be_visible(){
        Assert.assertTrue(documentSingleEditPageObject.getSubmit_edit_popup().isVisible());
    }
    @Then("Edit pop up window asking acting as and action type dropdowns should be visible")
    public void edit_pop_up_window_asking_acting_as_and_action_type_dropdowns_should_be_visible()  {
        documentSingleEditPageObject.edit_pop_up_screen();
    }

    @When("^user will set filter as Enforced$")
    public void user_will_set_filter_as_enforced(DataTable table)  {
        documentPageObject.check_if_filterStatus_and_type(table);
    }
    @Then("^Edit button should be visible on the all document screen$")
    public void edit_button_should_be_visible_on_the_all_document_screen(){
        documentSingleEditPageObject.check_edit_button();
    }
    @When("^User set the filter on the all document screen$")
    public void user_set_the_filter_on_the_all_document_screen(DataTable table){
        documentPageObject.check_if_filterStatus_and_type(table);
    }
    @When("^User removes the filter$")
    public void removeFilter(){
        documentPageObject.getClear_Filter().waitUntilVisible();
        documentPageObject.getClear_Filter().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("^User select Acting as in the edit pop up screen$")
    public void user_select_acting_as_in_the_edit_pop_up_screen(List<String> actingAs) {
        documentSingleEditPageObject.select_Actingas(actingAs);
    }

    @And("user clicks on Document Edit icon")
    public void user_clicks_on_Edit_icon() {
        documentSingleEditPageObject.click_edit_icon();
    }

    @And("^User select Action type in the edit pop up screen$")
    public void user_select_action_type_in_the_edit_pop_up_screen(List<String> actiontype) {
        documentSingleEditPageObject.select_Actiontype(actiontype);
    }
    @And("^Get the old version and click on the submit button, and check the new version created on the edit screen for the document$")
    public void get_the_old_version_and_click_on_the_submit_button_and_check_the_new_version_created_on_the_edit_screen_for_the_document(){
        documentSingleEditPageObject.compare_the_version_and_submit_edit_popup();
    }

    @And("^click on the submit button on the edit pop up screen$")
    public void click_on_the_submit_button_on_the_edit_pop_up_screen()  {
        documentSingleEditPageObject.click_on_the_submit_button_on_the_edit_pop_up_screen();
//        documentSingleEditPageObject.compare_the_version_and_submit_edit_popup();
    }
    @When("^user will set filter as rejected$")
    public void user_will_set_filter_as_rejected(DataTable table){
        documentPageObject.check_if_filterStatus_and_type(table);
    }

    @When("^user will set filter as in approval$")
    public void user_will_set_filter_as_in_approval(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }
    @Then("^Edit button should not be visible for all the documents on the screen$")
    public void edit_button_should_not_be_visible_for_all_the_documents_on_the_screen() {
        documentSingleEditPageObject.check_edit_button_not_visible();
    }

    @When("^user will set filter as approved$")
    public void user_will_set_filter_as_approved(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }

    @When("^user will set filter as expired$")
    public void user_will_set_filter_as_expired(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }

    @When("^user will set filter as terminated$")
    public void user_will_set_filter_as_terminated(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }
    @When("^user will set filter as deleted$")
    public void user_will_set_filter_as_deleted(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }

    @When("^user will set filter as cancelled$")
    public void user_will_set_filter_as_cancelled(DataTable table) {
        documentPageObject.check_if_filterStatus_and_type(table);
    }

    @Then("^All the tabs expect approval workflow and preview will be disabled$")
    public void all_the_tabs_expect_approval_workflow_and_preview_will_be_disabled(){
        Assert.assertTrue(documentSingleEditPageObject.getTab_approvalworkflow().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_previewandsubmit().isEnabled());
    }

    @Then("^All the tabs expect enforcement rules and preview will be disabled$")
    public void all_the_tabs_expect_enforcement_rules_and_preview_will_be_disabled(){
        documentSingleEditPageObject.waitForPageOpen();
        Assert.assertTrue(documentSingleEditPageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_enforcementrules().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_previewandsubmit().isEnabled());
    }

    @Then("^All the tabs expect legal terms and preview will be disabled$")
    public void all_the_tabs_expect_legal_terms_and_preview_will_be_disabled() {
        Assert.assertTrue(documentSingleEditPageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_legalterms().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_previewandsubmit().isEnabled());
    }

    @Then("^All the tabs expect Limit scope and preview will be disabled$")
    public void all_the_tabs_expect_limit_scope_and_preview_will_be_disabled(){
        Assert.assertTrue(documentSingleEditPageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_previewandsubmit().isEnabled());
    }

    @Then("^All the tabs expect Auth scope and preview will be disabled$")
    public void all_the_tabs_expect_auth_scope_and_preview_will_be_disabled() {
        Assert.assertTrue(documentSingleEditPageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_authscope().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_previewandsubmit().isEnabled());
    }
    @Then("^All the tabs will be enabled on the edit screen$")
    public void all_the_tabs_will_be_enabled_on_the_edit_screen()  {
        Assert.assertTrue(documentSingleEditPageObject.getTab_approvalworkflow().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_enforcementrules().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_legalterms().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_authscope().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isEnabled());
        Assert.assertTrue(documentSingleEditPageObject.getTab_previewandsubmit().isEnabled());
        act.pause(Duration.ofSeconds(5)).build().perform();
    }

    @Then("^User performs approval workflow for the Single edit document and submit$")
    public void user_performs_approval_workflow_for_the_single_edit_document_and_submit(){
        documentSingleEditPageObject.getTab_approvalworkflow().click();
        documentCreateNewPageObject.clickSelectApprovalWorkflow();
    }

    @Then("^User performs Enforcement rules for the Single edit document and submit$")
    public void user_performs_enforcement_rules_for_the_single_edit_document_and_submit() {
        documentSingleEditPageObject.getTab_enforcementrules().click();
        documentCreateNewPageObject.clickSelectEnforcementRules();
    }

    @Then("^User performs legal terms for the Single edit document and submit$")
    public void user_performs_legal_terms_for_the_single_edit_document_and_submit(DataTable table) {
        documentSingleEditPageObject.waitForPageOpen();
        if( documentSingleEditPageObject.getTab_legalterms().isVisible()){
            documentSingleEditPageObject.getTab_legalterms().click();
            act.pause(Duration.ofSeconds(8)).build().perform();
            documentCreateNewPageObject.clickSelectLegalTerms(table);
        }


    }

    @Then("^User performs remove currency for the Auth scope in the Single edit document and submit$")
    public void user_performs_remove_currency_for_the_auth_scope_in_the_single_edit_document_and_submit(List<String> selectcurrencyList) throws InterruptedException {
        if (documentSingleEditPageObject.getTab_authscope().isSelected()){
            documentSingleEditPageObject.Validate_Add_currency_in_AuthScope(selectcurrencyList);
            documentSingleEditPageObject.Validate_Remove_currency_from_AuthScope(selectcurrencyList);
        }else {
            documentSingleEditPageObject.getTab_authscope().click();
            if (documentSingleEditPageObject.getEdit_currency_pencil_icon().isVisible()){
                act.pause(Duration.ofSeconds(3)).build().perform();
                documentSingleEditPageObject.getEdit_currency_pencil_icon().click();
                documentSingleEditPageObject.Validate_Add_currency_in_AuthScope(selectcurrencyList);
                documentSingleEditPageObject.Validate_Remove_currency_from_AuthScope(selectcurrencyList);
            }
            else {
                documentSingleEditPageObject.Validate_Add_currency_in_AuthScope(selectcurrencyList);
                documentSingleEditPageObject.Validate_Remove_currency_from_AuthScope(selectcurrencyList);
            }
        }
    }

    @Then("^performs remove currency for the Auth scope in the Single edit document and submit$")
    public void performs_remove_currency_for_the_auth_scope_in_the_single_edit_document_and_submit(List<String> selectcurrencyList)  {
        try {
            documentSingleEditPageObject.Validate_Add_currency_in_AuthScope(selectcurrencyList);
            documentSingleEditPageObject.Validate_Remove_currency_from_AuthScope(selectcurrencyList);
        } catch (Exception e){
            log.error("Unable to remove currency"+e);
            Assert.fail();
        }
    }
    @Then("^User performs add currency for the Auth scope in the Single edit document and submit$")
    public void user_performs_add_currency_for_the_auth_scope_in_the_single_edit_document_and_submit(List<String> selectcurrencyList) {
        try {
            documentSingleEditPageObject.getTab_authscope().click();
            documentSingleEditPageObject.Validate_Add_currency_in_AuthScope(selectcurrencyList);
        }catch (Exception e){
            log.error("Unable to add currency"+e);
            Assert.fail();
        }

    }

    @Then("^add currency for the Auth scope in the Single edit document and submit$")
    public void add_currency_for_the_auth_scope_in_the_single_edit_document_and_submit(List<String> selectcurrencyList) {
        try {
            documentSingleEditPageObject.Validate_Add_currency_in_AuthScope(selectcurrencyList);
        }
        catch (Exception e){
            log.error("Unable to add currency"+e);
            Assert.fail();
        }
    }

    @Then("^User performs remove products for the Limit scope in the Single edit document and submit$")
    public void user_performs_remove_products_for_the_limit_scope_in_the_single_edit_document_and_submit() {
        documentSingleEditPageObject.getTab_authscope().click();
        Assert.assertTrue( documentSingleEditPageObject.getDelete_product_icon().isVisible());
        documentSingleEditPageObject.Remove_product_from_auth_scope();
    }

    @Then("^User performs add products for the Limit scope in the Single edit document and submit$")
    public void user_performs_add_products_for_the_limit_scope_in_the_single_edit_document_and_submit() {
        documentSingleEditPageObject.getTab_limiscope().click();
    }
    @Then("^User is on Limit Scope tab$")
    public void user_is_on_LimitScopeTab() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isDisabled());
    }
    @Then("^User is on Auth Scope tab$")
    public void user_is_on_AuthScopeTab() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.getTab_limiscope().isDisabled());
    }
    @Then("Click on + Add currencies")
    public void click_on_add_currencies() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentSingleEditPageObject.getAdd_currency_button());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.getAdd_currency_button().isVisible());
        documentSingleEditPageObject.getAdd_currency_button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("Click on DN Edit currencies")
    public void click_on_DN_edit_currencies() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentSingleEditPageObject.getDN_add_currency_button());
//        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentSingleEditPageObject.getDN_add_currency_button());
        Assert.assertTrue(documentSingleEditPageObject.getDN_add_currency_button().waitUntilVisible().isVisible());
        withAction().moveToElement(documentSingleEditPageObject.getDN_add_currency_button()).click().build().perform();
//        documentSingleEditPageObject.getDN_add_currency_button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("Select currency group and click submit")
    public void select_currency_group_and_click_submit(DataTable table) {
        documentSingleEditPageObject.Add_currency_grp(table);
    }
    @Then("Add Auth tenor")
    public void add_auth_tenor(DataTable table)
    {
        documentSingleEditPageObject.add_auth_tenor(table);
    }

    @Then("Validate following field is not displayed")
    public void validate_field_is_not_displayed(DataTable table) {
        Assert.assertTrue(documentSingleEditPageObject.fieldNotdisplayed(table));
    }
    @Then("User fetches the document version ID")
    public void fetches_version_ID() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.getDocumentVersionID().isVisible());
        documentSingleEditPageObject.documentVersionID();
    }
    @Then("User validates the DF version in DN")
    public void validate_version_ID() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.validateDocumentVersionID());
    }

    @Then("User validates the previous approved version is expired")
    public void validatePreviousVersionExpired() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
       Assert.assertEquals("Expired",documentSingleEditPageObject.previousVersionExpired());
    }

    @Then("User validates the Document Framework approved successfully notification")
    public void documentFrameworkApproved() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.getApprovedNotification().isVisible());
    }
    @And("User validates PB and EB are disabled for DN")
    public void validate_PB_EB_result(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.getPB_disabled().isDisplayed());
        Assert.assertTrue(documentSingleEditPageObject.getEB_disabled().isDisplayed());

    }
    @Then("Validate Client is not displayed")
    public void clientDoesNotExists() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(documentSingleEditPageObject.ClientNotVisible());
    }
    @Then("User enters dynamic alternate IDs for Client and EB")
    public void user_enters_the_following_alternate_ids() {
        documentSingleEditPageObject.enterAlternateId();
    }

    @And("User click on the Save button for edit alternate id")

    public void userClickOnTheSaveButton() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentSingleEditPageObject.clickSaveButton();
    }
    }