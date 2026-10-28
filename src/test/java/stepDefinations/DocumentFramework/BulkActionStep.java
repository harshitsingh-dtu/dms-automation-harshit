package stepDefinations.DocumentFramework;

import PageObjects.DocumentFrameworkPageObject.BulkActionPageObject;
import PageObjects.DocumentFrameworkPageObject.DocumentFrameworkPageObject;
import PageObjects.Documents.BulkEdit.BulkEditApprovePageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class BulkActionStep extends PageObject {
    BulkEditApprovePageObject bulkEditApprovePageObject;
    BulkActionPageObject bulkActionPageObject;

    @And("User verify error to CL option from Bulk Action menu")
    public void user_selects_error_CL_from_bulk_action_menu() {
        bulkEditApprovePageObject.getBulkErrorCL_btn().isVisible();
        bulkActionPageObject.clickBulkEditErrorCLAction();
    }
    @Then("User validates the CL status")
    public void user_Validate_CL_status(List<String> docStatus) {
        bulkActionPageObject.validate_document_status();
        Assert.assertEquals(docStatus.get(1).toLowerCase(),bulkActionPageObject.getErrorackstatus().getText().toLowerCase());
    }
}