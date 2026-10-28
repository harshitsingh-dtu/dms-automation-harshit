package stepDefinations.ProductGroup;

import PageObjects.Documents.BulkEdit.BulkActionEditRemoveCurrencyPageObject;
import PageObjects.ProductGroup.ProductGroupAddNewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddNewProductGroupPageStep extends PageObject {
    ProductGroupAddNewPageObject productGroupAddNewPageObject;
    @When("User clicks on search for the product group to add")
    public void user_clicks_on_search_for_the_product_group_to_add(DataTable table) {
        productGroupAddNewPageObject.clickProductGroupSearch_bar(table);
    }
    @Then("User Add Asset Class, Product Family, Product to the product group")
    public void user_add_new_product_line_to_the_product_group(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProductFamily(table);
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProduct(table);
        productGroupAddNewPageObject.addProductLine_btn();
    }
    @Then("User Add Asset Class, Product Family, Product to the Auth Scope")
    public void user_asset_Details(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProductFamily(table);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProduct(table);
    }
    @Then("User clicks select All in Auth Scope Product Family")
    public void selectAllAuthScope_ProductFamily(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickSelectAllProductFamily();
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProduct(table);
        productGroupAddNewPageObject.getDrop_down_Close().click();
    }
    @Then("User clicks select All in Auth Scope Product")
    public void selectAllAuthScope_Product(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickSelectAllProductFamily();
        productGroupAddNewPageObject.clickSelectAllNon_BullionProduct();
        productGroupAddNewPageObject.getDrop_down_Close().click();
    }
    @Then("User clicks select All in Auth Scope for Bullion Product Family")
    public void selectAllBullion_ProductFamily(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickSelectBullionProductFamily();
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProduct(table);
        productGroupAddNewPageObject.getDrop_down_Close().click();
    }
    @Then("User clicks select All in Auth Scope for Bullion Product")
    public void selectAllBullion_Product(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickSelectBullionProductFamily();
        productGroupAddNewPageObject.clickSelectAllBullionProduct();
        productGroupAddNewPageObject.getDrop_down_Close().click();
    }
    @Then("User DeSelects all Products in AuthScope and validate")
    public void DeSelect_AuthScope_selectAllandValidate() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.getProductFamilyValueDropDown().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupAddNewPageObject.getSelectAllProductFamilyCheckbox().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getSelectProductFamily().isDisplayed());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User DeSelects Bullion Product family and validate")
    public void DeSelect_bullionandValidate() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.getProductFamilyValueDropDown_EDN().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupAddNewPageObject.getSelectBullionProductFamilyCheckbox().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getSelectProductFamily().isDisplayed());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User validates all Product Families should be selected")
    public void Validate_AuthScope_SelectAll() {
       Assert.assertEquals("Cash+3",productGroupAddNewPageObject.validateSelectAllProductFamily());
    }
    @Then("User validates all Products should be selected")
    public void Validate_AuthScope_SelectAll_Products() {
        Assert.assertEquals("Future+19",productGroupAddNewPageObject.validateSelectAllProduct());
    }
    @Then("User validates all Bullion Product should be selected")
    public void Validate_AuthScope_SelectBullion() {
        Assert.assertEquals("Bullion Vanilla Options+2",productGroupAddNewPageObject.validateSelectAllProduct());
    }
    @Then("User deletes the auth Lines")
    public void DeleteAuthLines(DataTable table) {
        productGroupAddNewPageObject.DeleteAuthLine(table);
    }
    @Then("User deletes the limit Lines")
    public void DeleteLimitLines(DataTable table) {
        productGroupAddNewPageObject.DeleteLimitLine(table);
    }

    @Then("User deletes the limit Lines in DF")
    public void DeleteLimitLinesInDF() {
        productGroupAddNewPageObject.DeleteLimitLineinDF();
    }

    @Then("User Validates Other lines should be greyed out")
    public void auth_disabled_lines(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProductFamily(table);
        productGroupAddNewPageObject.Validate_Product_disabled(table);
    }
    @Then("User Add Asset Class, Product Family to the Auth Scope")
    public void user_add_Details(DataTable table) {
        productGroupAddNewPageObject.clickAddNewProductGroup_AddAssetClass(table);
        productGroupAddNewPageObject.clickAddNewProductGroup_AddProductFamily(table);
    }
    @Then("User validates there should be 3 products in Bullion Family")
    public void user_validates_BullionFamily() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.getSelectProduct().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getBullion_Exotic_options().isVisible());
        Assert.assertTrue(productGroupAddNewPageObject.getBullion_Spot().isVisible());
        Assert.assertTrue(productGroupAddNewPageObject.getBullion_Vanilla().isVisible());
    }
    @Then("User validate the list of currencies for bullion")
    public void user_validate_bullion_currencies() {
       Assert.assertTrue(productGroupAddNewPageObject.validateBullionCurrencies());
    }
    @Then("User clicks on Currencies-Pair and validates the values")
    public void user_validate_bullion_currencies_Pair() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupAddNewPageObject.getCurrency_pair().click();
        Assert.assertTrue(productGroupAddNewPageObject.validateBullionCurrencies_Pair());
    }
    @Then("User clicks on Currencies-Pair and enter currency pair in the filter")
    public void user_enter_currency_pair_in_filter(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupAddNewPageObject.getCurrency_pair_InFilterDF().click();
        productGroupAddNewPageObject.addCurrencyPairDF(table);
    }

    @Then("User clicks on Currencies-Pair and enter currency pair in the filter of DF")
    public void user_enter_currency_pair_in_filter_of_DF(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupAddNewPageObject.getCurrency_pair_InFilterDF().click();
        productGroupAddNewPageObject.addCurrencyPairDF(table);
    }

    @Then("User clicks on Currencies and enter currency in the advance filter")
    public void user_enter_currency_in_Advancefilter(DataTable table) {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        productGroupAddNewPageObject.getCurrenciesButton().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        productGroupAddNewPageObject.addCurrencyPair(table);
    }
    @Then("User enables all Auth Lines")
    public void user_click_on_enable_button() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertFalse(productGroupAddNewPageObject.getEnable_AuthButton().isEmpty());
        productGroupAddNewPageObject.enableAllAuthLines();
    }
    @Then("User validates Auth line is copied and disabled")
    public void Validate_CopiedAuthLines_Disabled() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(2,productGroupAddNewPageObject.getBullionAuthLines().size());
        Assert.assertEquals(1,productGroupAddNewPageObject.getEnable_AuthButton().size());
    }
    @Then("User click on edit icon of currency for the Auth line")
    public void Edit_CurrencyForAuthLines() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getEditCurrencyForAuthLines().isVisible());
        productGroupAddNewPageObject.getEditCurrencyForAuthLines().click();
    }
    @Then("User edit currency for the copied line")
    public void Edit_CopiedAuthLines() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productGroupAddNewPageObject.getEditCurrencyForCopiedAuthLines());
        Assert.assertTrue(productGroupAddNewPageObject.getEditCurrencyForCopiedAuthLines().isVisible());
        productGroupAddNewPageObject.getEditCurrencyForCopiedAuthLines().click();
    }

    @Then("User deletes the copied line and validate the same")
    public void delete_CopiedAuthLines() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getDeleteCopiedLine().isVisible());
        productGroupAddNewPageObject.getDeleteCopiedLine().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertEquals(1,productGroupAddNewPageObject.getBullionAuthLines().size());
    }

    @Then("User deletes all the auth Lines")
    public void delete_AuthLines() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.DeleteAll_AuthLines();
    }
    @Then("User deletes all the auth Lines if available")
    public void delete_AuthLines_IfAvailable() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.DeleteAll_AuthLines_IfAvailable();
    }
    @Then("User deletes all the auth Lines in Remove Products action")
    public void delete_AllAuthLines() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.DeleteAll_AuthLinesInRemoveProducts();
    }

    @Then("User validate Add Auth Line is disabled")
    public void addAuthLineDisbled() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(productGroupAddNewPageObject.getDisabled_AuthButton().isVisible());
    }

    @Then("User validates Window period tab should be visible")
    public void window_period_tab_with_Values(DataTable table) {
         String Visibility = productGroupAddNewPageObject.windowPeriodTab(table);
         if(Visibility.equalsIgnoreCase("No")) {
             Assert.assertFalse(productGroupAddNewPageObject.getWindowPeriod_Tab().isVisible());
         }
         else{
             Assert.assertTrue(productGroupAddNewPageObject.getWindowPeriod_Tab().isVisible());
         }
    }
    @Then("User clicks on multiple Currencies-Pair and enter currency pair in the filter")
    public void user_enters_currency_pairs(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        productGroupAddNewPageObject.getCurrency_pair_InFilterDF().click();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String pair = columns.get("Currencies-pair");
            productGroupAddNewPageObject.addCurrencyPairInput(pair);
        }
    }

    @Then("Clicks on DF Auth scope Expand All button")
    public void clicks_on_DF_Auth_scope_Expand_All_button() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.clickAuthScopeExpandAll();
    }
    @Then("Clicks on DF Auth scope Expand All button if Expand is visible")
    public void clicks_on_DF_Auth_scope_Expand_All_button_if_visible() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        productGroupAddNewPageObject.clickAuthScopeExpandAllIfVisible();
    }

    @Then("User adds product group into Auth Scope")
    public void user_adds_product_group_into_auth_scope(DataTable table) {
        productGroupAddNewPageObject.addProductGroupIntoAuthScope(table);
    }
}
