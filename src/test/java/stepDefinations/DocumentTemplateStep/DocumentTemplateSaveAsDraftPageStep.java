package stepDefinations.DocumentTemplateStep;

import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.java.en.And;
import net.serenitybdd.core.pages.PageObject;

public class DocumentTemplateSaveAsDraftPageStep extends PageObject {
    DocumentTemplateCreatePageObject documentTemplateCreatePageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @And("^User will fill the required enforcement rules$")
    public void user_will_fill_the_required_enforcement_rules() {
        documentTemplateCreatePageObject.typeinto_fornewdocument();
        documentTemplateCreatePageObject.typeinto_forammendment();
        documentTemplateCreatePageObject.typeinto_fortermination();
    }
    @And("^User clicks on Save As Draft button$")
    public void user_click_save_as_draft_for_document_template() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        documentTemplateCreatePageObject.clickSaveAsDraftbtn();
    }
}