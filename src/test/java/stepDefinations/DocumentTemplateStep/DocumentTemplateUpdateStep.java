package stepDefinations.DocumentTemplateStep;

import PageObjects.DocumentTemplate.DocumentTemplateUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class DocumentTemplateUpdateStep extends PageObject {
    DocumentTemplateUpdatePageObject documentTemplateUpdatePageObject;
    @Then("^User can see all the elements on the screen$")
    public void user_can_see_all_the_elements_on_the_screen() throws Throwable {
        documentTemplateUpdatePageObject.validate_DocumentTemplateUpdateScreen();
    }

    @And("^User will search for the document template$")
    public void user_will_search_for_the_document_template(DataTable table) {
        documentTemplateUpdatePageObject.searchdocument(table);
    }
    @And("^User will search for the document template at DN Creation page$")
    public void user_will_search_for_the_document_template_at_DN_Creation_Page(DataTable table) {
        documentTemplateUpdatePageObject.searchdocumenttemplate(table);

    }

    @And("^User will reach the document template update screen$")
    public void user_will_reach_the_document_template_update_screen() throws Throwable {
        documentTemplateUpdatePageObject.clickupdate_btn();
    }
    @Then("^User will see all the elements of the enforcement rules$")
    public void user_will_see_all_the_elements_of_the_enforcement_rules() throws Throwable {
        documentTemplateUpdatePageObject.checkEnforcementRulesForNewDocument();
        documentTemplateUpdatePageObject.checkEnforcementRulesForAmendment();
        documentTemplateUpdatePageObject.checkEnforcementRulesFortermination();
    }
    @And("^User validate enforcement rules screen is visible$")
    public void user_validate_enforcement_rules() throws Throwable {
        documentTemplateUpdatePageObject.getFornewdocument_txt().waitUntilVisible().isDisplayed();
    }
    @And("^click submit for document template$")
    public void click_submit_for_document_template() throws Throwable {
        documentTemplateUpdatePageObject.clickSubmit_btn();
    }
    @And("User select the document template for 4 Way & check all tabs in preview")
    public void userSelectTheDocumentTemplateFor4WayCheckAllTabsInPreview(String TemplateName) {
        documentTemplateUpdatePageObject.validatedocdocumenttemplate(TemplateName);
    }

    @And("User select the document template for DN Way & check all tabs in preview")
    public void userSelectTheDocumentTemplateForDNWayCheckAllTabsInPreview(String TemplateName) {
        documentTemplateUpdatePageObject.validateDNdocumenttemplate(TemplateName);
    }

    @And("User validates the data is loaded in preview for 4 way")
    public void userValidatesDatafor4Way(DataTable dataTable) {
        documentTemplateUpdatePageObject.ValidateDataInTemplate(dataTable);
        Assert.assertTrue(documentTemplateUpdatePageObject.DocumentTermsData(dataTable));
    }

    @And("User validates the data is loaded in preview for DN")
    public void userValidatesDataforDN(DataTable dataTable) {
        Assert.assertTrue(documentTemplateUpdatePageObject.DocumentTermsData(dataTable));
    }
    @And("User clicks on Document terms tab")
    public void userwillreachtoDocumentTemplate() throws Throwable {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",documentTemplateUpdatePageObject.getDocumentTerm_btn());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentTemplateUpdatePageObject.clickDocumentTerm_btn();
    }

}