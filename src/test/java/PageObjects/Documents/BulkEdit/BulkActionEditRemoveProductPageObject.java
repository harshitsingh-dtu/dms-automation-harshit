package PageObjects.Documents.BulkEdit;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;

@Slf4j
@Data

public class BulkActionEditRemoveProductPageObject extends PageObject
{
    @FindBy (xpath = "//input[@placeholder='Select Product Family']")
    public WebElementFacade select_product_grp;

    @FindBy (xpath = "//input[@placeholder='Select Product']")
    public WebElementFacade select_product;

    @FindBy (xpath = "//button[text()='Remove Product Line']")
    public WebElementFacade remove_product_line_btn;

    @FindBy(xpath =" //button[text()='Submit for Approval']")
    private WebElementFacade submit_for_approval_btn;

    public void Select_product_grp(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            select_product_grp.waitUntilVisible();
            withAction().moveToElement(select_product_grp).click().sendKeys(dataTable.get("product family")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        catch (Exception e){
            log.info("unable to select product family" + e);
            Assert.fail();
        }

    }

    public void Select_product(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_product.waitUntilVisible();
            withAction().moveToElement(select_product).click().sendKeys(dataTable.get("product")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        catch (Exception e){
            log.info("unable to select product" + e);
            Assert.fail();
        }

    }

    public void Verify_remove_product_line_btn(){
        try {
            remove_product_line_btn.isClickable();
            remove_product_line_btn.click();
        }
        catch (Exception e){
            log.info("unable to click on remove product line button" + e);
            Assert.fail();
        }
    }

    public void Click_submit_for_approval_button(){
        submit_for_approval_btn.waitUntilVisible().click();

    }
}