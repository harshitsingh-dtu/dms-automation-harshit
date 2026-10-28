package stepDefinations.Document;

import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.util.List;

@Slf4j
@Getter
@Setter
public class DocumentScreenValidationsPageStep extends PageObject {
    DocumentPageObject documentPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;

    @Given("User will be redirected to create new document screen after clicking Create New Document button")
    public void user_will_be_redirected_to_create_new_document_screen_after_clicking_create_new_document_button() {
        documentPageObject.clickMenuButton();
        documentPageObject.clickDocumentTab();
    }

    @Then("User will be able to see all the elements on the Create New Document screen")
    public void user_will_be_able_to_see_all_the_elements_on_the_create_new_document_screen() {
        Assert.assertTrue(documentCreateNewPageObject.clickNewDocument());
    }


    @Then("User validates the limit value in the limit line in Pdf")
    public void userValidateTheFormattingOfLongNumbers(DataTable dataTable) {
        documentPageObject.validateLimitValuesInPdfTable(dataTable);
    }

    @Then("^User validate the limit value$")
    public void user_validate_the_limit_value(DataTable table) {
        documentPageObject.validateLimitValue(table.cell(1, 0));
    }
    @Then("^User clear the filter")
    public void user_clear_the_filter() {
        documentPageObject.getClear_btn_AdFiler().click();
    }
    @Then("^User validate the limit value in Bulk Edit$")
    public void user_validate_the_limit_value_In_bulkEdit(DataTable table) {
        documentPageObject.validateLimitValueInBulkEdit(table.cell(1, 0));
    }
    @Then("User validates the calculation type in the limit line in Pdf")
    public void userValidatesCalculationTypeInPDF(DataTable dataTable) {
        documentPageObject.validateCalculationTypeInPdfTable(dataTable);
    }
}