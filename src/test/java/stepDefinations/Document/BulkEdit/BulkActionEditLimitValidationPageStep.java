package stepDefinations.Document.BulkEdit;

import PageObjects.Documents.BulkEdit.BulkActionEditLimitPageObject;
import PageObjects.Documents.BulkEdit.BulkActionEditRemoveCurrencyPageObject;
import PageObjects.Documents.BulkEdit.BulkEditApprovePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class BulkActionEditLimitValidationPageStep extends PageObject
{
    BulkActionEditLimitPageObject bulkActionEditLimitPageObject;
    @Then("Verify Document id and Document version id")
    public void verify_document_id_and_document_version_id(DataTable table)
    {
        bulkActionEditLimitPageObject.Verify_document_id(table);
        bulkActionEditLimitPageObject.Verify_document_version_id(table);
    }
    @Then("Select document")
    public void select_document() {
        bulkActionEditLimitPageObject.Select_first_doc();
    }
    @Then("Verify user able to change edit Limit value")
    public void verify_user_able_to_change_edit_limit_value(DataTable table) {
        bulkActionEditLimitPageObject.change_limit_value(table);
    }
    @Then("Verify submit for approval")
    public void verify_submit_for_approval() {
        Assert.assertTrue(bulkActionEditLimitPageObject.getSubmit_for_approval_btn().isVisible());
        bulkActionEditLimitPageObject.getSubmit_for_approval_btn().click();
//        bulkActionEditLimitPageObject.Click_submit_for_approval_button();
    }
    @Then("Verify user able to change edit Limit value again")
    public void verify_user_able_to_change_edit_limit_value_again(DataTable table) {
        bulkActionEditLimitPageObject.change_limit_value_again(table);
    }

}