package stepDefinations.Document.BulkEdit;

import PageObjects.Documents.BulkEdit.BulkActionEditRemoveCurrencyPageObject;
import PageObjects.Documents.BulkEdit.BulkActionEditRemoveProductPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

public class BulkActionEditRemoveProductValidationPageStep extends PageObject
{
    BulkActionEditRemoveProductPageObject bulkActionEditRemoveproductPageObject;

    @Then("Verify select product family")
    public void verify_select_product_family(DataTable table)
    {
        bulkActionEditRemoveproductPageObject.Select_product_grp(table);
    }
    @Then("Verify product selection")
    public void verify_product_selection(DataTable table) {
        bulkActionEditRemoveproductPageObject.Select_product(table);
    }
    @Then("Verify remove product line button")
    public void verify_remove_product_line_button() {
        Assert.assertTrue(bulkActionEditRemoveproductPageObject.getRemove_product_line_btn().isVisible());
        bulkActionEditRemoveproductPageObject.Verify_remove_product_line_btn();
    }
    @Then("Verify submit for approval button for remove product")
    public void verify_submit_for_approval_button_for_remove_product()
    {
        Assert.assertTrue(bulkActionEditRemoveproductPageObject.getSubmit_for_approval_btn().isVisible());
        bulkActionEditRemoveproductPageObject.Click_submit_for_approval_button();
    }
}