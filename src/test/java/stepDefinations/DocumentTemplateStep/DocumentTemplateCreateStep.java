package stepDefinations.DocumentTemplateStep;

import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import PageObjects.DocumentTemplate.DocumentTemplatePageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class DocumentTemplateCreateStep extends PageObject {
    DocumentPageObject documentPageObject;
    DocumentTemplatePageObject documentTemplatePageObject;
    DocumentTemplateCreatePageObject documentTemplateCreatePageObject;
    @Given("^User has logged in$")
    public void user_has_logged_in(){
    }

    @Then("^User will go to Document template screen$")
    public void user_will_go_to_document_template_screen(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentPageObject.clickMenuButton();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentTemplatePageObject.clickDocumentTemplateTab();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @And("^User validates Document Template Screen$")
    public void validate_template_screen() {
        Assert.assertTrue(documentTemplateCreatePageObject.getCreate_btn().isDisplayed());
    }

    @Then("^User will be redirected to create screen after clicking create New template button$")
    public void user_will_be_redirected_to_create_screen_after_clicking_create_new_template_button() {
        documentTemplateCreatePageObject.clickCreatebtn();
        documentTemplateCreatePageObject.checkifOnCreateTemplatescreen();
    }
    @And("User input details to create a new Document Template")
    public void user_input_details_to_create_a_new_document_template(DataTable table) {
        documentTemplateCreatePageObject.selectTemplateName(table);
        documentTemplateCreatePageObject.selectOrganisationName(table);
        documentTemplateCreatePageObject.selectDocType(table);
    }
    @And("^User will click next and gets redirected to other create screen$")
    public void user_will_click_next_and_gets_redirected_to_other_create_screen()  {
        documentTemplateCreatePageObject.clickTemplateNextbtn();
    }
    @When("^User will click on the Approval Workflow tab$")
    public void user_will_click_on_the_approval_workflow_tab() {
        documentTemplateCreatePageObject.clickApprovalWorkflow_btn();
    }
    @Then("^User will use drag and drop PB1 to approval Seq 1 in Document and Click on next button$")
    public void user_will_use_drag_and_drop() {
        documentTemplateCreatePageObject.selectApprovalWorkflow();
    }

    @Then("^User will use drag and drop PB1 to approval Seq 1 in 4W Document$")
    public void user_will_use_drag_and_dropRemoveCurrency() {
        documentTemplateCreatePageObject.selectApprovalWorkflowRemoveCurrency();
    }

    @Then("^User will use drag and drop PB1 to approval Seq 2 in Document and Click on next button$")
    public void user_will_use_drag_and_drop2() {
        documentTemplateCreatePageObject.dragToApprovalSeq2();
    }
    @When("^User will click on the enforcement rules tab$")
    public void user_will_click_on_the_enforcement_rules_tab() {
        documentTemplateCreatePageObject.clickEnforcementRules_btn();
    }
    @When("^User validates the enforcement data$")
    public void validates_enforcement_data() {
        documentTemplateCreatePageObject.validate_enforcement_data();
    }
    @When("^User validates the enforcement data as immediate$")
    public void validates_enforcement_data_immediate() {
        Assert.assertTrue(documentTemplateCreatePageObject.getEnforcementRule_immediate_DF().isVisible());
    }

    @And("^User validates the enforcement data on preview tab$")
    public void validates_enforcement_data_on_preview_tab(DataTable table) {
        documentTemplateCreatePageObject.validateEnforcementDataOnPreviewTab(table);
    }

    @Then("^User validates the enforcement data as immediate in DF$")
    public void validates_enforcement_data_immediate_in_DF() {
    documentTemplateCreatePageObject.verifySingleImmediateInputIsPresentAndVisible();
    }

    @And("^User will fill the required enforcement rules and click next$")
    public void user_will_fill_the_required_enforcement_rules_and_click_next() {
        documentTemplateCreatePageObject.typeinto_fornewdocument();
        documentTemplateCreatePageObject.typeinto_forammendment();
        documentTemplateCreatePageObject.typeinto_fortermination();
        documentTemplateCreatePageObject.clickNext_btn();
    }
    @And("User will click on the CK editor and type text into document content")
    public void user_will_click_on_the_ck_editor_and_type_text_into_document_content(DataTable table) {
        documentTemplateCreatePageObject.typetextintoCKEditordocumentcontent(table);
    }
    @And("^User validates the Document terms data$")
    public void user_validates_Document_terms(String DocumentTerms) {
        Assert.assertTrue(documentTemplateCreatePageObject.validateDocumentTerms(DocumentTerms));
    }
    @And("^Click submit for document template$")
    public void click_submit_for_document_template() {
        documentTemplateCreatePageObject.clickSubmit_btn();
    }
    @And("User will able to see Document Template information and not able to see Approval Workflow tab Enforcement Rules tab")
    public void User_will_able_to_see_Document_Template_information_and_not_able_to_see_Approval_Workflow_tab_Enforcement_Rules_tab(){
        Assert.assertTrue(documentTemplateCreatePageObject.getDocument_template_information_text().isVisible());
        Assert.assertTrue(documentTemplateCreatePageObject.getTemplatename_text().isVisible());
        Assert.assertTrue(documentTemplateCreatePageObject.getOrganization_text().isVisible());
        Assert.assertTrue(documentTemplateCreatePageObject.getDoctype_text().isVisible());
        Assert.assertFalse(documentTemplateCreatePageObject.getApproval_workflowTab().isVisible());
        Assert.assertFalse(documentTemplateCreatePageObject.getEnforcement_ruleTab().isVisible());
        Assert.assertTrue(documentTemplateCreatePageObject.getLegal_termTab().isVisible());
        Assert.assertTrue(documentTemplateCreatePageObject.getSubmitbutton().isVisible());
        Assert.assertTrue(documentTemplateCreatePageObject.getCancelButton().isVisible());
    }

    @Then("User is on document Template screen")
    public void user_is_on_document_template_screen(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentPageObject.navigateToDocumentTemplateScreen();
    }

    @Then("User validates document template name length")
    public void user_validate_template_length() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentPageObject.validateDocTempNameMaxLength();
    }
}
