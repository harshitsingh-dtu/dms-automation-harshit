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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

@Slf4j
@Data
public class ProductGroupAddNewPageObject extends PageObject {

    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//*[@placeholder='Search by product name']")
    private WebElementFacade productGroupSearch_bar;
    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade productGroupUpdate_btn;
    @FindBy(xpath = "//*[@placeholder='Asset Class']")
    private WebElementFacade SelectAssetClass;
    @FindBy(xpath = "//*[@placeholder='Select Product Family']")
    private WebElementFacade SelectProductFamily;
    @FindBy(xpath = "//*[@placeholder='Select Product']")
    private WebElementFacade SelectProduct;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade Drop_down_Close;
    @FindBy(xpath = "//button[text()='Add Product Line']")
    private WebElementFacade AddProductLine_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;

    @FindBy(xpath = "//*[text()[contains(.,'Bullion Exotic')]]")
    private WebElementFacade Bullion_Exotic_options;
    @FindBy(xpath = "//*[text()[contains(.,'Bullion Spot')]]")
    private WebElementFacade Bullion_Spot;
    @FindBy(xpath = "//*[text()[contains(.,'Bullion Vanilla')]]")
    private WebElementFacade Bullion_Vanilla;
    @FindBy(xpath = "//div[@class='card ']/span")
    private List<WebElementFacade> Bullion_Currencies;
    @FindBy(xpath = "//button[text()='Currencies-pair']")
    private WebElementFacade Currency_pair;
    @FindBy(xpath = "//button[text()='Currencies pair']")
    private WebElementFacade Currency_pair_InFilter;
    @FindBy(xpath = "//button[text()='Currencies-pair']")
    private WebElementFacade Currency_pair_InFilterDF;
    @FindBy(xpath = "//button[text()='Currencies']")
    private WebElementFacade CurrenciesButton;
    @FindBy(xpath = "//div[@data-testid='left-header-search-container']//input[@placeholder='Search']")
    private WebElementFacade Search_currency;
    @FindBy(xpath = "//div[@class='card ']/span")
    private WebElementFacade Add_Currency;
    @FindBy(xpath = "//button[@class='card  ']")
    private WebElementFacade Add_CurrencyDF;

    @FindBy(xpath = "//div[@class='enable-switch-container cursor-pointer']")
    private List<WebElementFacade> Enable_AuthButton;
    @FindBy(xpath = "//img[@alt = 'delete-line']")
    private List<WebElementFacade> Deleteicon_LimitLine;
    @FindBy(xpath = "//img[@title='Delete']")
    private List<WebElementFacade> Delete_AuthLine;
    @FindBy(xpath = "//div[@class='accordian-auth']")
    private List<WebElementFacade> NumberOfAuthLines;
    @FindBy(xpath = "//span[text()='Bullion']")
    private List<WebElementFacade> BullionAuthLines;
    @FindBy(xpath = "(//img[@title='Edit' or @alt='edit-line'])[1]")
    private WebElementFacade EditCurrencyForAuthLines;
    @FindBy(xpath = "(//img[@title='Edit' or @alt='edit-line'])[2]")
    private WebElementFacade EditCurrencyForCopiedAuthLines;
    @FindBy(xpath = "(//img[@title='Edit'])[1]")
    private WebElementFacade EditRowForAuthLines;
    @FindBy(xpath = "(//img[@title='Edit'])[2]")
    private WebElementFacade EditRowForCopiedAuthLines;
    @FindBy(xpath = "(//img[@title='Delete'])[2]")
    private WebElementFacade DeleteCopiedLine;
    @FindBy(xpath = "//button[@disabled and text()='Add Auth Line']")
    private WebElementFacade Disabled_AuthButton;
    @FindBy(xpath = "//*[text()='Yes']//input")
    private WebElementFacade WindowPeriod_Yes;
    @FindBy(xpath = "//*[text()='No']//input")
    private WebElementFacade WindowPeriod_No;
    @FindBy(xpath = "//div[text()='Window Period']")
    private WebElementFacade WindowPeriod_Tab;
    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade SaveAsDraft_button;
    @FindBy(xpath = "//*[contains(text(),'No options')]")
    private WebElementFacade NoOptions;
    @FindBy(xpath = "//*[text()='Yes']")
    private WebElementFacade YesButton;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade closeDropDown;
    @FindBy(xpath = "//div[@role='presentation']//*[text()='ALL']")
    private WebElementFacade selectAllProductFamilyCheckbox;
//    @FindBy(xpath = "(//div[@role='presentation']//*[text()='BULLION'])[1]")
//    private WebElementFacade selectBullionProductFamilyCheckbox;
    @FindBy(xpath = "//div[@role='presentation']//*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='bullion']")
    private WebElementFacade selectBullionProductFamilyCheckbox;

    @FindBy(xpath = "//*[@class='auth-child']//div[3]")
    private WebElementFacade ProductFamilyValueDropDown;
    @FindBy(xpath = "(//*[@class='selected-values-container'])[1]")
    private WebElementFacade selectAllProductFamilyValue;
    @FindBy(xpath = "(//*[@class='selected-values-container'])[2]")
    private WebElementFacade selectAllProductValue;
    @FindBy(xpath = "(//div[@role='presentation']//*[text()='Cash'])[1]")
    private WebElementFacade CashProduct;
    @FindBy(xpath = "(//div[@role='presentation']//*[text()='Exotic Options'])[1]")
    private WebElementFacade exoticOptionsProduct;
    @FindBy(xpath = "(//div[@role='presentation']//*[text()='Vanilla Options'])[1]")
    private WebElementFacade vanillaOptionsProduct;
    @FindBy(xpath = "(//div[@role='presentation']//*[text()='Volatility'])[1]")
    private WebElementFacade VolatilityProduct;
    @FindBy(xpath = "(//div[@role='presentation']//*[text()='Bullion'])[1]")
    private WebElementFacade BullionProduct;

    @FindBy(xpath = "(//*[@class='selected-values-container'])[1]/..")
    private WebElementFacade ProductFamilyValueDropDown_EDN;
    @FindBy(xpath = "(//div[contains(@class, 'auth-child')]//div[2]//div)[1]")
    private WebElementFacade ProductValueDropDown_EDN;
    @FindBy(xpath = "//span[@data-testid='auth-scope-expand-collapse-all']")
    private WebElementFacade AuthScope_ExpandAll_Link;
    @FindBy(xpath = "//input[@placeholder='Select Product Group']")
    private WebElementFacade SelectProductGroup;



    public void clickProductGroupSearch_bar(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(productGroupSearch_bar.isVisible());
            act.moveToElement(productGroupSearch_bar).click().sendKeys(dataTable.get("Product group")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to search Product group-->" + e);
            Assert.fail();
        }
    }
    public void clickAddNewProductGroup_AddAssetClass(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            SelectAssetClass.withTimeoutOf(Duration.ofSeconds(12)).waitUntilPresent();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",SelectAssetClass);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SelectAssetClass.waitUntilVisible().click();
            SelectAssetClass.waitUntilVisible().clear();
            act.moveToElement(SelectAssetClass).click().sendKeys(dataTable.get("Asset Class")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        }
        catch (Exception e) {
        log.error("Unable to add Product Group-->" + e);
        Assert.fail();
    }
}
public void clickSelectAllProductFamily() {
    try {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", SelectProductFamily);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        SelectProductFamily.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        selectAllProductFamilyCheckbox.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        closeDropDown.click();
    } catch (Exception e) {
        log.error("Unable to add selectAll-->" + e);
        Assert.fail();
    }
}
    public void clickSelectBullionProductFamily() {
        try {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", SelectProductFamily);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SelectProductFamily.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            String listboxId = SelectProductFamily.getAttribute("aria-controls");
            if (listboxId == null || listboxId.isEmpty()) {
                Assert.fail("Product Family dropdown did not open (no aria-controls) — cannot select Bullion.");
            }

            String bullionHeaderXpath = "//*[@id='" + listboxId + "']//li[@role='option']" +
                    "[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='bullion'][1]";
            WebElement bullionCheckbox = getDriver().findElement(By.xpath(bullionHeaderXpath));

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", bullionCheckbox);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            try {
                bullionCheckbox.click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", bullionCheckbox);
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            closeDropDown.click();
        } catch (Exception e) {
            log.error("Unable to add selectAll-->" + e);
            Assert.fail();
        }
    }
public void clickSelectAllBullionProduct() {
    try {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", SelectProduct);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        SelectProduct.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        //Selecting All bullion options
        BullionProduct.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    } catch (Exception e) {
        log.error("Unable to add selectAll-->" + e);
        Assert.fail();
    }
}
public void clickSelectAllNon_BullionProduct() {
    try {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", SelectProduct);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        SelectProduct.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        //Selecting All non-bullion options
        CashProduct.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", exoticOptionsProduct);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        exoticOptionsProduct.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", vanillaOptionsProduct);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        vanillaOptionsProduct.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", VolatilityProduct);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        VolatilityProduct.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

    } catch (Exception e) {
        log.error("Unable to add selectAll-->" + e);
        Assert.fail();
    }
}
public String validateSelectAllProductFamily() {
    ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", selectAllProductFamilyValue);
    withAction().pause(Duration.ofSeconds(2)).build().perform();
    return selectAllProductFamilyValue.getText().replace("\n","");
}
public String validateSelectAllProduct() {
    ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", selectAllProductValue);
    withAction().pause(Duration.ofSeconds(2)).build().perform();
    return selectAllProductValue.getText().replace("\n","");
}
    public void clickAddNewProductGroup_AddProductFamily(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> map_dataTable = data.get(0);
        String productFamilyValues = map_dataTable.get("Product Family");
        String[] splitArray = productFamilyValues.split(",");
        SelectProductFamily.waitUntilPresent().waitUntilClickable().click();
        withAction().pause(Duration.ofMillis(500)).build().perform();
        String listboxId = SelectProductFamily.getAttribute("aria-controls");
        if (listboxId == null || listboxId.isEmpty()) {
            Assert.fail("Product Family dropdown did not open (no aria-controls on the input). Cannot select options.");
        }

        for (String value : splitArray) {
            String trimmedValue = value.trim();
            String optionXpath = "//*[@id='" + listboxId + "']//li[@role='option']" +
                    "[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + trimmedValue.toLowerCase() + "']";

            WebElement eachValueElement = getDriver().findElement(By.xpath(optionXpath));
            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", eachValueElement
            );
            withAction().pause(Duration.ofMillis(300)).build().perform();

            try {
                WebElement checkbox = eachValueElement.findElement(By.xpath(".//input[@type='checkbox']"));
                if (!checkbox.isSelected()) {
                    eachValueElement.click();
                }
            } catch (NoSuchElementException e) {
                eachValueElement.click();
            }
            withAction().pause(Duration.ofMillis(500)).build().perform();
        }
        try {
            SelectProductFamily.sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
            withAction().sendKeys(Keys.ESCAPE).build().perform();
        }
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void clickAddNewProductGroup_AddProduct(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map = data.get(0);
        String ProductValues = dataTable_map.get("Product");
        String[] splitValuesArray = ProductValues.split(",");

        SelectProduct.waitUntilPresent().click();
        withAction().pause(Duration.ofMillis(500)).build().perform();

        // Grab the listbox id the dropdown actually opened (aria-controls on the input)
        String listboxId = SelectProduct.getAttribute("aria-controls");
        if (listboxId == null || listboxId.isEmpty()) {
            Assert.fail("Product dropdown did not open (no aria-controls on the input) — cannot select any options.");
        }

        for (String eachValue : splitValuesArray) {
            String trimmedValue = eachValue.trim();
            // Scope strictly to <li role="option"> rows inside THIS open listbox —
            // avoids matching the duplicate text node inside the selected-values chip container.
            String optionXpath = "//*[@id='" + listboxId + "']//li[@role='option'][normalize-space(.)='" + trimmedValue + "']";
            WebElement eachValueElement = getDriver().findElement(By.xpath(optionXpath));

            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", eachValueElement
            );
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            try {
                eachValueElement.click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", eachValueElement);
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }
public void Validate_Product_disabled(DataTable table) {
    List<Map<String, String>> data = table.asMaps(String.class, String.class);
    Map<String,String> dataTable_map= data.get(0);
    String ProductValues = dataTable_map.get("Product");
    String[] splitValuesArray = ProductValues.split(",");
    for (String eachValue : splitValuesArray) {
        act.moveToElement(SelectProduct).click().sendKeys(eachValue).pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(NoOptions.isDisplayed());
    }
}
public void addProductLine_btn(){
    Assert.assertTrue(AddProductLine_btn.isVisible());
    AddProductLine_btn.waitUntilClickable().click();
}
public boolean validateBullionCurrencies(){
    boolean result=false;
    String[] arr = {"XAG","XAU","XPD","XPT"};
    List<String> arrList = Arrays.asList(arr);
    if(Bullion_Currencies.size()==4) {
        for (WebElementFacade ele : Bullion_Currencies) {
            result = arrList.contains(ele.getText());
            if (result) {
            } else {
                break;
            }
        }
    }
    return result;
}
public boolean validateBullionCurrencies_Pair(){
    boolean result=false;
    String[] arr = {"EUR-XAU","XAG-AUD","XAG-CAD","XAG-CHF","XAG-EUR","XAG-GBP","XAG-HKD","XAG-JPY","XAG-USD","XAU-AUD","XAU-CAD","XAU-CHF","XAU-EUR","XAU-GBP","XAU-JPY","XAU-TRY","XAU-USD","XAU-VND","XPD-AUD","XPD-CAD","XPD-CHF","XPD-EUR","XPD-GBP","XPD-JPY","XPD-USD","XPT-AUD","XPT-CAD","XPT-CHF","XPT-EUR","XPT-GBP","XPT-JPY","XPT-USD"};
    List<String> arrList = Arrays.asList(arr);
    if(Bullion_Currencies.size()==32) {
        for (WebElementFacade ele : Bullion_Currencies) {
            result = arrList.contains(ele.getText());
            if (result) {
            } else {
                break;
            }
        }
    }
    return result;
}
public void addCurrencyPair(DataTable table) {
    List<Map<String, String>> data = table.asMaps(String.class, String.class);
    Map<String,String> dataTable_map= data.get(0);
    HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
    act.moveToElement(Search_currency).click().sendKeys(dataTable.get("Currencies")).pause(Duration.ofSeconds(2)).build().perform();
    Add_Currency.waitUntilVisible().click();
}

public void addCurrencyPairDF(DataTable table) {
    List<Map<String, String>> data = table.asMaps(String.class, String.class);
    Map<String,String> dataTable_map= data.get(0);
    HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
    act.moveToElement(Search_currency).click().sendKeys(dataTable.get("Currencies-pair")).pause(Duration.ofSeconds(5)).build().perform();
    Add_CurrencyDF.waitUntilClickable().click();
}


public String windowPeriodTab(DataTable table) {
    List<Map<String, String>> data = table.asMaps(String.class, String.class);
    Map<String,String> dataTable_map= data.get(0);
    HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
    String result = "";
    if(dataTable.get("Window").equalsIgnoreCase("Both"))
    {
        act.moveToElement(WindowPeriod_Yes).click().pause(Duration.ofSeconds(1)).build().perform();
        act.moveToElement(WindowPeriod_No).click().pause(Duration.ofSeconds(1)).build().perform();
        act.moveToElement(SaveAsDraft_button).click().pause(Duration.ofSeconds(2)).build().perform();
        result = "Yes";
    }
    else if(dataTable.get("Window").equalsIgnoreCase("Yes"))
    {
        act.moveToElement(WindowPeriod_Yes).click().pause(Duration.ofSeconds(1)).build().perform();
        act.moveToElement(SaveAsDraft_button).click().pause(Duration.ofSeconds(2)).build().perform();
        result = "Yes";
    }
    else if(dataTable.get("Window").equalsIgnoreCase("No"))
    {
        act.moveToElement(WindowPeriod_No).click().pause(Duration.ofSeconds(1)).build().perform();
        act.moveToElement(SaveAsDraft_button).click().pause(Duration.ofSeconds(2)).build().perform();
        result = "No";
    }
    return result;
}
public void enableAllAuthLines() {
    for(WebElementFacade enableButton : Enable_AuthButton)
    {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", enableButton);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        enableButton.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
}
public void DeleteAll_AuthLines() {
    for(WebElementFacade deleteButton : Delete_AuthLine)
    {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deleteButton);
        deleteButton.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
}

    public void DeleteAll_AuthLines_IfAvailable(){
        List<WebElementFacade> deleteIcons = Delete_AuthLine;
        if (deleteIcons.isEmpty()) {
            log.info("No document is available with the above values.");
            return;
        }

        while (!deleteIcons.isEmpty()) {
            WebElementFacade icon = deleteIcons.get(0);
            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", icon
            );
            withAction().pause(Duration.ofMillis(500)).build().perform();

            try {
                icon.waitUntilClickable().click();
            } catch (Exception e) {
                log.warn("Standard click intercepted (likely by chatbot overlay), falling back to JS click.");
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", icon);
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            // Re-fetch the list since the DOM re-renders after each deletion
            deleteIcons = Delete_AuthLine;
        }
    }
public void DeleteAll_AuthLinesInRemoveProducts() {
    for(WebElementFacade deleteButton : Delete_AuthLine)
    {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deleteButton);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        deleteButton.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
//        YesButton.click();
//        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
}
public void DeleteAuthLine(DataTable table) {
    List<Map<String, String>> data = table.asMaps(String.class, String.class);
    try {
        for (Map<String, String> row : data) {
            WebElement ele = getDriver().findElement(By.xpath("//div[text()='" + row.get("Product") + "']/../../..//img[@title='Delete']"));
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", ele);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            ele.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            getDriver().findElement(By.xpath("//div[text()='" + row.get("Product") + "']")).isDisplayed();
        }
    } catch (org.openqa.selenium.NoSuchElementException e) {
        Assert.assertTrue(true);
    }
}
public void DeleteLimitLine(DataTable table) {
    List<Map<String, String>> data = table.asMaps(String.class, String.class);
    try {
        for (Map<String, String> row : data) {
            WebElement ele = getDriver().findElement(By.xpath("//td[text()='" + row.get("Calculation Type") + "']/following-sibling::td[text()='"+row.get("Netting Type")+"']/..//img[@title='Delete']"));
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", ele);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            ele.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            getDriver().findElement(By.xpath("//td[text()='" + row.get("Calculation Type") + "']/following-sibling::td[text()='"+row.get("Netting Type")+"']")).isDisplayed();
        }
    } catch (org.openqa.selenium.NoSuchElementException e) {
        Assert.assertTrue(true);
    }
    }

    public void DeleteLimitLineinDF() {
        By deleteButtons = By.xpath("//img[@alt = 'delete-line']");
        while (getDriver().findElements(deleteButtons).size() > 0) {
            try {
                WebElement btn = getDriver().findElement(deleteButtons);
                btn.click();
                new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                        .until(ExpectedConditions.stalenessOf(btn));
                System.out.println("Deleted a line...");
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("All previous lines cleared.");

    }

    public void addCurrencyPairInput(String pairValue) {
        try {
            Search_currency.clear();
            act.moveToElement(Search_currency)
                    .click()
                    .sendKeys(pairValue)
                    .pause(Duration.ofSeconds(3))
                    .build()
                    .perform();
            Add_CurrencyDF.waitUntilClickable().click();
            log.info("Successfully added pair: " + pairValue);
        } catch (Exception e) {
            log.error("Could not add currency pair: " + pairValue + " | " + e.getMessage());
            Assert.fail("Failed to select currency pair from dropdown: " + pairValue);
        }
    }

    public void clickAuthScopeExpandAll() {
        AuthScope_ExpandAll_Link.waitUntilVisible();
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", AuthScope_ExpandAll_Link
        );
        withAction().pause(Duration.ofMillis(500)).build().perform();
        try {
            AuthScope_ExpandAll_Link.waitUntilClickable().click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", AuthScope_ExpandAll_Link);
        }
    }
    public void clickAuthScopeExpandAllIfVisible() {
        try {
            boolean isPresent = AuthScope_ExpandAll_Link
                    .withTimeoutOf(Duration.ofSeconds(3))
                    .isCurrentlyVisible();

            if (!isPresent) {
                log.info("'Expand all' link not visible — skipping expand step, continuing.");
                return;
            }

            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", AuthScope_ExpandAll_Link
            );
            withAction().pause(Duration.ofMillis(500)).build().perform();
            try {
                AuthScope_ExpandAll_Link.waitUntilClickable().click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", AuthScope_ExpandAll_Link);
            }
            log.info("'Expand all' link was visible and clicked.");

        } catch (Exception e) {
            log.info("'Expand all' link not found — skipping expand step, continuing. (" + e.getMessage() + ")");
        }
    }

    public void addProductGroupIntoAuthScope(DataTable table) {
        String productGroupName = table.asMaps(String.class, String.class).get(0).get("product group");

        SelectProductGroup.waitUntilClickable().click();
        SelectProductGroup.clear();
        SelectProductGroup.sendKeys(productGroupName);

        withAction().pause(Duration.ofSeconds(2)).build().perform();

        WebElementFacade optionCheckbox = find(By.xpath("//div[@role='presentation']//*[normalize-space(text())='" + productGroupName + "']"));

        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", optionCheckbox);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", optionCheckbox);

        log.info("Successfully clicked checkbox for product group: " + productGroupName);

        // 4. Close the dropdown safely by pressing the ESCAPE key
        try {
            SelectProductGroup.sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
            withAction().sendKeys(Keys.ESCAPE).build().perform();
        }
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
}
