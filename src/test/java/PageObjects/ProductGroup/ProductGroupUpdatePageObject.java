package PageObjects.ProductGroup;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class ProductGroupUpdatePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    String AssetClass="FX";
    String ProductFamily="Vanilla Options";
    String Product="Swap";
    @FindBy(xpath = "//*[@placeholder='Search by product group name']")
    private WebElementFacade productGroupSearch_bar;
    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade productGroupUpdate_btn;
    @FindBy(xpath = "//*[@placeholder='Asset Class']")
    private WebElementFacade SelectAssetClass;
    @FindBy(xpath = "//*[@placeholder='Select Product Family']")
    private WebElementFacade SelectProductFamily;
    @FindBy(xpath = "//*[@placeholder='Select Product']")
    private WebElementFacade SelectProduct;
    @FindBy(xpath = "//button[text()='Add Product Line']")
    private WebElementFacade AddProductLine_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;
    @FindBy(xpath = "//*[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='expand all'] | //*[@data-testid='auth-scope-expand-collapse-all']")
    private WebElementFacade ExpandAll_btn;

    @FindBy(xpath = "//*[text()='Collapse All']")
    private WebElementFacade CollapseAll_btn;
    @FindBy(xpath = "//img[@title='Delete']")//img[@alt='Delete']
    private WebElementFacade Delete_icon;//img[@alt='Delete']
    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade Delete_iconDF;
    @FindBy(xpath = "//div[@class='cross-icon delete']")
    private WebElementFacade PG_Delete_btn;
    @FindBy(xpath = "//div[text()='There should be atleast one line to create this product group.']")
    private WebElementFacade warningText;
    @FindBy(xpath = "//*[contains(text(),'No Record Found')]")
    private WebElementFacade noRecordFound;
    @FindBy(xpath = "//input[@placeholder=\"Search by product group name\"]")
    private WebElementFacade Searchbar;
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElementFacade searchedresult_grpname;
    @FindBy(xpath = "//div[text()=\"Product group name\"]")
    private WebElementFacade product_group_name;
    @FindBy(xpath = "//div[text()=\"Organisation name\"]")
    private WebElementFacade organisation_name;
    @FindBy(xpath = "//div[text()=\"Created on\"]")
    private WebElementFacade createdOn;
    @FindBy(xpath = "//div[text()=\"Action\"]")
    private WebElementFacade Action;
    @FindBy(xpath = "//div[contains(text(),'Product Group deleted successfully!')]")
    private WebElementFacade PG_dlt_popUp;


    public void deleteProductGroupAndValidate(DataTable table) {
        clickProductGroupSearch_bar(table);
        getPG_Delete_btn().waitUntilClickable().click();
        PG_dlt_popUp.waitUntilVisible();
        Assert.assertTrue("Delete product group notification was not shown", PG_dlt_popUp.isVisible());
    }

    public void deleteProductGroupIfExists(DataTable table) {
        clickProductGroupSearch_bar(table);
        act.pause(Duration.ofMillis(500)).build().perform();
        try {
            if (PG_Delete_btn.isPresent() && PG_Delete_btn.isCurrentlyVisible()) {
                log.info("Product group found. Proceeding to delete it.");
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", PG_Delete_btn);
                act.pause(Duration.ofMillis(500)).build().perform();
                if (PG_dlt_popUp.isPresent() && PG_dlt_popUp.isCurrentlyVisible()) {
                    log.info("Successfully triggered the delete popup/action.");
                }

            } else {
                log.info("Product group does not exist. Skipping deletion and moving to the next step.");
            }

        } catch (Exception e) {
            log.info("Product group was not found on the screen. Proceeding safely.");
        }
    }

    public void clickProductGroupSearch_bar(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            productGroupSearch_bar.clear();
            withAction().moveToElement(productGroupSearch_bar).click().sendKeys(dataTable.get("Product group")).pause(Duration.ofMillis(500)).build().perform();
            act.pause(Duration.ofMillis(500)).build().perform();
        }catch (Exception e){
            log.error("Unable to click search bar-->"+e);
            Assert.fail();
        }
    }
    public void clickProductGroupUpdate_btn(){
        try{
            productGroupUpdate_btn.waitUntilClickable().click();
        }catch (Exception e){
            log.error("Unable to click update button-->"+e);
            Assert.fail();
        }
    }
    public void clickUpdateProductGroup_AddAssetClass(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SelectAssetClass.click();
            SelectAssetClass.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            act.moveToElement(SelectAssetClass).click().sendKeys(dataTable.get("Asset Class")).pause(Duration.ofMillis(500)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to add Asset Class-->"+e);
            Assert.fail();
        }
    }
    public void clickUpdateProductGroup_AddProductFamily(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SelectProductFamily.click();
            SelectProductFamily.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            act.moveToElement(SelectProductFamily).click().sendKeys(dataTable.get("Product Family")).pause(Duration.ofMillis(500)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to add Product Family-->"+e);
            Assert.fail();
        }
    }
    public void clickUpdateProductGroup_AddProduct(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SelectProduct.click();
            SelectProduct.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            act.moveToElement(SelectProduct).click().sendKeys(dataTable.get("Product")).pause(Duration.ofMillis(500)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to add Product-->"+e);
            Assert.fail();
        }
    }
    public void addProductLine_btn(){
        Assert.assertTrue( AddProductLine_btn.isVisible());
        AddProductLine_btn.waitUntilClickable().click();
    }
    public void submit_btn(){
        Submit_btn.waitUntilClickable().click();

    }
    public void expandAll_btn(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            WebElement expandLink = find(By.xpath("//span[@data-testid='auth-scope-expand-collapse-all'] | //*[text()='Expand all' or text()='Expand All']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", expandLink);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            try {
                expandLink.click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", expandLink);
            }
        } catch (Exception e) {
            log.warn("expandAll_btn fallback: " + e.getMessage());
            if (ExpandAll_btn.isCurrentlyVisible()) {
                ExpandAll_btn.click();
            }
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void productexpand_btn(String productName){
        try {
            String xpath = "//*[@id='group-accordion-arrow-" + productName + "' or @class='group-accordion-arrow-" + productName + "' or @data-testid='group-accordion-arrow-" + productName + "' or contains(@id, 'group-accordion-arrow-" + productName + "') or contains(@class, 'group-accordion-arrow-" + productName + "')]";
            WebElementFacade element = $(By.xpath(xpath));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
            act.pause(Duration.ofMillis(200)).build().perform();
            element.waitUntilClickable().click();
        } catch (Exception e) {
            log.error("Unable to click ProductExpand button for " + productName + " --> " + e);
            Assert.fail();
        }
    }
    public void warningText(){
        act.pause(Duration.ofMillis(200)).build().perform();
        warningText.isVisible();
    }
    public void collapseAll_btn(){
        act.pause(Duration.ofMillis(200)).build().perform();
        Assert.assertTrue( CollapseAll_btn.isVisible());
    }
    public void no_collapseAll_btn(){
        Assert.assertFalse( CollapseAll_btn.isVisible());
    }
    public void expandAll_btn_Visible(){
        Assert.assertTrue( ExpandAll_btn.isVisible());
    }
    public void no_expandAll_btn_Visible(){
        Assert.assertFalse(ExpandAll_btn.isVisible());
    }

    public void deleteIcon(){
        Delete_icon.waitUntilClickable().click();
    }

    public void deleteIconDF(){
        Delete_iconDF.waitUntilClickable().click();
    }

    public boolean checkresult() {
            withAction().pause(Duration.ofMillis(500)).build().perform();
            if (searchedresult_grpname.getText().equalsIgnoreCase(Searchbar.getAttribute("value"))){
                return true;
            }
            else {
                return false;
            }

        }

    public void checkVisibility() {
        Assert.assertTrue(product_group_name.isVisible());
        Assert.assertTrue(organisation_name.isVisible());
        Assert.assertTrue(createdOn.isVisible());
        Assert.assertTrue(Action.isVisible());
        Assert.assertEquals("Search by product group name",Searchbar.getAttribute("placeholder"));
    }

    public void clickCollapseAll_btn() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            WebElement collapseLink = find(By.xpath("//span[@data-testid='auth-scope-expand-collapse-all'] | //*[text()='Collapse all' or text()='Collapse All']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", collapseLink);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            try {
                collapseLink.click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", collapseLink);
            }
        } catch (Exception e) {
            log.warn("clickCollapseAll_btn fallback: " + e.getMessage());
            if (CollapseAll_btn.isCurrentlyVisible()) {
                CollapseAll_btn.click();
            }
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
}