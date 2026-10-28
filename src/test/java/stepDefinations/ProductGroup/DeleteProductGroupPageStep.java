package stepDefinations.ProductGroup;

import PageObjects.ProductGroup.ProductGroupCreatePageObject;
import PageObjects.ProductGroup.ProductGroupDeletePageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class DeleteProductGroupPageStep extends PageObject {
    ProductGroupCreatePageObject productGroupCreatePageObject;
    ProductGroupDeletePageObject productGroupDeletePageObject;
    @Then("User Deletes Product Line to the product group")
    public void user_deletes_product_line_to_the_product_group() {
        productGroupDeletePageObject.clickUpdateProductGroup_DeleteProductLine();
    }
}
