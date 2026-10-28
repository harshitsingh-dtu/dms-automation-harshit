package PageObjects.ProductGroup;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import java.time.Duration;

@Slf4j
@Data
public class ProductGroupValidationPageObject extends PageObject {
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupAndTemplate_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Product groups']")
    private WebElementFacade productGroup_tab;
    @FindBy(xpath = "//div[@class='heading' or text()='Product groups']")
    private WebElementFacade productGroup_text;
    @FindBy(xpath = "//div//p")
    private WebElementFacade showing_all_product_text;
    @FindBy(xpath = "//input[@placeholder='Search by product name']")
    private WebElementFacade search_box;
    @FindBy(xpath = "//button[text()='+ Create Product Group']")
    private WebElementFacade create_productGroup_button;
    @FindBy(xpath = "//th//div[text()='Product group name']")
    private WebElementFacade productGroup_name;
    @FindBy(xpath = "//th//div[text()='Organisation name']")
    private WebElementFacade organisation_name;
    @FindBy(xpath = "//th//div[text()='Created on']")
    private WebElementFacade created_on;
    @FindBy(xpath = "//th//div[text()='Action']")
    private WebElementFacade action;

    public void clickProductGroupTab(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (!productGroup_tab.isCurrentlyVisible()) {
            groupAndTemplate_tab.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        productGroup_tab.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    public void verifyProductGroupText(){
        try {
            productGroup_text.waitUntilVisible();
            Assert.assertTrue(productGroup_text.isVisible());
            Assert.assertEquals("Showing all product groups", showing_all_product_text.getText().trim());
            Assert.assertTrue(search_box.isVisible());
            Assert.assertTrue(create_productGroup_button.isVisible());
            Assert.assertEquals("Product group name", productGroup_name.getText().trim());
            Assert.assertEquals("Organisation name", organisation_name.getText().trim());
            Assert.assertEquals("Created on", created_on.getText().trim());
            Assert.assertEquals("Action", action.getText().trim());
            log.error("Validate the product group page successfully");
        }
        catch(Exception e){
            log.error("Unable to validate the product group screen" +e);
            Assert.fail();
        }

    }
}