package stepDefinations.ProductGroup;

import PageObjects.ProductGroup.ProductGroupValidationPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;

public class ProductGroupValidationPageStep extends PageObject {
    ProductGroupValidationPageObject productGroupValidationPageObject;
    @Then("^User is able to select Product Group$")
    public void user_is_able_to_select_product_group() {
        productGroupValidationPageObject.clickProductGroupTab();
    }
    @And("^Verifies the Product Group Page$")
    public void verifies_the_product_group_page() {
        productGroupValidationPageObject.verifyProductGroupText();
    }
}
