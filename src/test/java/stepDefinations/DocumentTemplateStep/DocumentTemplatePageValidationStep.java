package stepDefinations.DocumentTemplateStep;

import PageObjects.DocumentTemplate.DocumentTemplatePageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
public class DocumentTemplatePageValidationStep extends PageObject {
    DocumentTemplatePageObject documentTemplatePageObject;
    @Then("^User is able to select Document Template$")
    public void user_is_able_to_select_document_template() {
        documentTemplatePageObject.clickDocumentTemplateTab();
    }
    @And("^Verifies the Document Template Page$")
    public void verifies_the_document_template_page() {
        documentTemplatePageObject.verifyDocumentTemplateText();
    }
    @And("^Verifies the Document Template field")
    public void verifies_the_document_template_field() {
        documentTemplatePageObject.verifyDocumentTemplateText();
    }
}