package PageObjects.ProductGroup;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
@Slf4j
@Data
public class ProductGroupDeletePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//*[@placeholder='Search by product name']")
    private WebElementFacade productGroupSearch_bar;
    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade productGroupUpdate_btn;
    @FindBy(xpath = "//img[@title='Delete']")
    private WebElementFacade productGroupDelete_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;
    public void clickUpdateProductGroup_DeleteProductLine(){
        try{
            Assert.assertTrue(productGroupDelete_btn.isVisible());
            productGroupDelete_btn.waitUntilClickable().click();
        }catch (Exception e){
            log.error("Unable to delete Product Group-->"+e);
            Assert.fail();
        }
    }
    public void submit_btn(){
        Submit_btn.waitUntilClickable().click();
    }
}