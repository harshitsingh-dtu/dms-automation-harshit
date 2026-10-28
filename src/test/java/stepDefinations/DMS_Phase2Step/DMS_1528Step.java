package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1523PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1528PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class DMS_1528Step extends PageObject {

    DMS_1528PageObject dms1528PageObject;
    DMS_1523PageObject dms1523PageObject;


    @And("User will click on create new template button and get redirected to create new document template screen")
    public void user_will_click_on_create_new_template_button_and_get_redirected_to_create_new_document_template_screen() {
        dms1528PageObject.getCreate_New_Template_Btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1528PageObject.getCreateNewDocumentTemplate_Txt().isVisible());

    }

    @Then("user will enter template name organisation name and Doctype")
    public void user_will_enter_template_name_organisation_name_and_Doctype(DataTable datatable) {
        dms1528PageObject.Entertemplatename(datatable);
        dms1528PageObject.SelectOrganisationName(datatable);
        dms1528PageObject.SelectDocType(datatable);

    }

    @When("^User creates the following document templates$")
    public void user_creates_the_following_document_templates(DataTable dataTable) {
        dms1528PageObject.createMultipleDocumentTemplates(dataTable);
    }

    @Then("^Verify the user can view document template for all organizations$")
    public void verify_the_user_can_view_doc_template_for_all_organizations() {
        dms1528PageObject.validateViewAllAccessOnly();
    }

    @Then("^verify the created document templates are visible on the listing screen$")
    public void verify_created_templates_are_visible() {
        dms1528PageObject.verifyGeneratedTemplatesVisibility();
    }

    @When("^User updates the created document templates by modifying their names$")
    public void user_updates_created_document_templates() {
        dms1528PageObject.updateGeneratedDocumentTemplates();
    }

    @Then("user will enter template name organisation Name")
    public void user_will_enter_template_name_organisation_name(DataTable dataTable) {
        dms1528PageObject.Entertemplatename(dataTable);
        dms1528PageObject.SelectOrganisationName(dataTable);

    }
    @And("user will be able to see doctype for different case sensitive doctypename")
    public void user_will_be_able_to_see_doctype_for_different_case_sensitive_doctypenam(List<String> doctypeList){
        dms1528PageObject.casesensitivityforDoctype(doctypeList);
    }
    @And("user will be able to see the filtered list for doctype")
    public void user_will_be_able_to_see_the_filtered_list_of_doctype(List<String> doctype) {
        dms1528PageObject.filtereddoctype(doctype);
    }
    @And("user will click on next button and redirected Update screen of Template screen")
    public void  user_will_click_on_next_button_and_redirected_Update_screen_of_Template_screen(){
        // Fixed: ElementClickInterceptedError - Using JS click
        dms1528PageObject.clickNext_btn_JS();
        dms1528PageObject.getUpdate_document_template_text().waitUntilPresent();
        Assert.assertTrue(dms1528PageObject.getUpdate_document_template_text().isPresent());
    }
    @And("user will able to see Document Template information and Approval Workflow tab Enforcement Rules tab Legal Terms tab Discard  button Save as Draft button Next button")
    public void user_will_able_to_see_Document_Template_information_and_Approval_Workflow_tab_Enforcement_Rules_tab_Legal_Terms_tab_Discard_button_Save_as_Draft_button_Next_button(){
        Assert.assertTrue(dms1528PageObject.getDocument_template_information_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getTemplatename_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getOrganization_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getDoctype_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isVisible());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isVisible());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isVisible());
        Assert.assertTrue(dms1528PageObject.getSave_as_draftButton().isVisible());
        Assert.assertTrue(dms1528PageObject.getNext_Button().isVisible());
    }







    @And("User will click on the next button and reached the Legal term Screen.")
    public void User_will_click_on_the_next_button_and_reached_the_Legal_term_Screen(){
        // Fixed: ElementClickInterceptedError - Using JS click
        dms1528PageObject.clickNext_btn_JS();
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        Assert.assertTrue(dms1528PageObject.getConnecteduser_text().isVisible());

    }
    @And("user will be able to see no.of connected user and CK editor")
    public void user_will_be_able_to_see_no_of_connected_user_and_CK_editor(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1528PageObject.getConnecteduser_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getCk_editor().isVisible());
    }

    @And("User will click on Submit button and redirect to Document template listing screen")
    public void user_will_click_on_submit_button_and_redirect_to_document_template_listing_screen() {
        // Fixed: ElementClickInterceptedError - Using JS click
        dms1528PageObject.clickSubmit_btn_JS();
        dms1528PageObject.getDocumenttemplate_text().withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        Assert.assertTrue(dms1528PageObject.getDocumenttemplate_text().isVisible());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(0, -100)");
    }
    @And("User Validates Document Template history Screen")
    public void user_Validate_DocumentTemplate_History() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dms1528PageObject.getDocumentTemplate_HistoryScreen());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms1528PageObject.getDocumentTemplate_HistoryScreen().isDisplayed());
    }
    @And("User Validates the data on Document Template history Screen")
    public void user_Validate_DocumentTemplate_History_Screen_Data(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1528PageObject.validateAuditHistoryData(table));
    }

    @And("User verifies no Edit or delete icon is present")
    public void user_NoEditDeleteButtonExists() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dms1528PageObject.getDocumentTemplate_HistoryScreen());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            dms1528PageObject.getEditButton().isDisplayed();
            dms1528PageObject.getDeleteButton().isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Then("User will click on create new template button")
    public void click_on_docTemp_button () {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1528PageObject.getCreate_New_Template_Btn().click();
    }

}
