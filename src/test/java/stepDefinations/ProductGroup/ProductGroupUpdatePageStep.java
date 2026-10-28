package stepDefinations.ProductGroup;

import PageObjects.ProductGroup.ProductGroupUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class ProductGroupUpdatePageStep extends PageObject {
    ProductGroupUpdatePageObject productGroupUpdatePageObject;
    @When("^User clicks on search for the product group to update$")
    public void user_clicks_on_search_for_the_product_group_to_update(DataTable table) {
        productGroupUpdatePageObject.clickProductGroupSearch_bar(table);
    }

    @When("^User validates no record found$")
    public void user_validates_no_record() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(productGroupUpdatePageObject.getNoRecordFound().waitUntilVisible().isDisplayed());
    }
    @When("^User clicks on PG delete button$")
    public void clicks_on_PG_delete_button() {
        productGroupUpdatePageObject.getPG_Delete_btn().waitUntilVisible().click();
    }
    @When("^Clicks on update button$")
    public void clicks_on_update_button() {
        productGroupUpdatePageObject.clickProductGroupUpdate_btn();
    }
    @Then("^User update the asset class, product family, product to update the group$")
    public void user_add_asset_class_product_family_and_product(DataTable table) {
        productGroupUpdatePageObject.clickUpdateProductGroup_AddAssetClass(table);
        productGroupUpdatePageObject.clickUpdateProductGroup_AddProductFamily(table);
        productGroupUpdatePageObject.clickUpdateProductGroup_AddProduct(table);
        productGroupUpdatePageObject.addProductLine_btn();
    }
    @Then("^Clicks on Submit Button$")
    public void clicks_on_submit_button() {
        productGroupUpdatePageObject.submit_btn();
    }

    @Then("^Clicks on (.*) ProductExpand button$")
    public void clicks_on_productexpand_button(String productName) {
        productGroupUpdatePageObject.productexpand_btn(productName);
    }
    @Then("^Clicks on ExpandAll button$")
    public void clicks_on_expandAll_button() {
        productGroupUpdatePageObject.expandAll_btn();
    }
    @Then("^User validates CollapseAll button$")
    public void Validates_CollapseAll_button() {
        productGroupUpdatePageObject.collapseAll_btn();
    }
    @Then("^User validates CollapseAll button should not be there$")
    public void Validates_no_CollapseAll_button() {
        productGroupUpdatePageObject.no_collapseAll_btn();
    }
    @Then("^User validates ExpandAll button$")
    public void Validates_ExpandAll_button() {
        productGroupUpdatePageObject.expandAll_btn_Visible();
    }
    @And("^User validates ExpandAll button should not be there$")
    public void Validates_No_ExpandAll_button() {
        productGroupUpdatePageObject.no_expandAll_btn_Visible();
    }
    @And("^User clicks on Delete icon$")
    public void Delete_button() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",productGroupUpdatePageObject.getDelete_icon());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupUpdatePageObject.deleteIcon();
    }

    @And("^User clicks on Delete icon DF$")
    public void Delete_buttonDF() {
        productGroupUpdatePageObject.deleteIconDF();
    }

    @And("^User validates warning message$")
    public void warning_message() {
        productGroupUpdatePageObject.warningText();
    }

    @Then("^User validated product group listing screen$")
    public void User_validated_product_group_listing_screen() {
        productGroupUpdatePageObject.checkVisibility();
    }

    @Then("^User deletes the following Product group and validate the success$")
    public void userDeletesTheFollowingProductGroupAndValidateTheSuccess(DataTable table) {
        productGroupUpdatePageObject.deleteProductGroupAndValidate(table);
    }

    @Then("^User deletes the following Product group if it exists$")
    public void userDeletesTheFollowingProductGroupIfExists(DataTable table) {
        productGroupUpdatePageObject.deleteProductGroupIfExists(table);
    }

    @Then("^(?:Clicks on CollapseAll button|User clicks on Collapse all)$")
    public void clicks_on_collapse_all_button() {
        productGroupUpdatePageObject.clickCollapseAll_btn();
    }
}
