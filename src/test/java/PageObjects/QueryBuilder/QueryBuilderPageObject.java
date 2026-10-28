package PageObjects.QueryBuilder;

import PageObjects.ApprovalAgreement.ApprovalAgreementCreatePageObject;
import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
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

import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
public class QueryBuilderPageObject extends PageObject {
    @FindBy(xpath = "//button[text()='+ Add/Edit query']")
    private WebElementFacade AddEditQuery_btn;
    @FindBy(xpath = "//button[text()='+ Apply more filters']")
    private WebElementFacade ApplyMoreFilters_btn;
    @FindBy(xpath = "//div[contains(text(),'No options')]")
    private WebElementFacade noOptions;
    @FindBy(xpath = "//header[text()='Advance filters']")
    private WebElementFacade AdvFiltersScreen;
    @FindBy(xpath = "//div[@class='query-builder-wrapper']//header")
    private  WebElementFacade AddEdit_title;
    @FindBy(xpath = "//input[@placeholder='Select query']")
    private WebElementFacade AddEdit_selectquery_dropdown;
    @FindBy(xpath = "//input[@placeholder='Select query' and @value='']")
    private WebElementFacade Blank_selectquery_dropdown;
    @FindBy(xpath = "//div[@class='report-action']//button[@title='Clear']")
    private WebElementFacade clear_selectquery_dropdown;
    @FindBy(xpath = "//span[contains(translate(text(), 'ENFORCED', 'enforced'), 'enforced')]")
    private WebElementFacade enforced_document;
    @FindBy(xpath = "//div[@class='query-builder-wrapper']//input[@placeholder='Enter query name']")
    private WebElementFacade queryname;
    @FindBy(xpath = "//input[@placeholder='Select field']")
    private WebElementFacade AddEdit_Documentfield;
    @FindBy(xpath = "//input[@placeholder='Operators']")
    private WebElementFacade AddEdit_Documentoperator;
    @FindBy(xpath = "//input[@placeholder='Select value']")
    private  WebElementFacade AddEdit_Documentvalue;
    @FindBy(xpath = "//input[@placeholder='Enter value']")
    private  WebElementFacade AddEdit_DocumentIDValue;
    @FindBy(xpath = "//div[@class='query-builder-wrapper']//button[text()='+ Add query block']")
    private  WebElementFacade addquery_btn;
    @FindBy(xpath = "//div[@class='query-builder-wrapper']//button[text()='Cancel']")
    private WebElementFacade cancel_btn;
    @FindBy(xpath = "//div[@class='query-builder-wrapper']//button[text()='Save & Apply']")
    private WebElementFacade save_and_apply_btn;
    @FindBy(xpath = "//div[@class='query-builder-wrapper']//button[text()='Apply']")
    private WebElementFacade apply_btn;
    @FindBy(xpath = " //div[@class='qb-actions']//*[name()='svg'][1]")
    private WebElementFacade remove_queryblock;
    @FindBy(xpath = "//div[@class='qb-actions']//*[name()='svg'][2]")
    private WebElementFacade add_queryblock;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Please enter query name']")
    private  WebElementFacade AddEdit_error_msg_queryname;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Please select Query fields']")
    private  WebElementFacade AddEdit_error_msg;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade Alert_addEdit;

    @FindBy(xpath = "//input[@placeholder='Select family']")
    private WebElementFacade auth_ProductFamily;
    @FindBy(xpath = "//input[@placeholder='Select product']")
    private WebElementFacade auth_Product;
    @FindBy(xpath = "//input[@placeholder='Enter value']")
    private WebElementFacade auth_Tenor;
    @FindBy(xpath = "//input[@placeholder='Select tenor']")
    private WebElementFacade auth_SelectTenor;
    @FindBy(xpath = "//div[@class='select-filter']//div[@role='presentation']")
    private WebElementFacade auth_TenorValues;
    @FindBy(xpath = "//div[@class='auth-header']//div[@class='btn-clear clear-disabled']")
    private WebElementFacade clearFilter;
    @FindBy(xpath = "//h4[text()='Auth Currencies']")
    private WebElementFacade authCurrencies;
    @FindBy(xpath = "//button[text()='Currencies']")
    private WebElementFacade currenciesTab;
    @FindBy(xpath = "//button[text()='Currencies pair']")
    private WebElementFacade currenciesPairTab;
    @FindBy(xpath = "//div[text()='All currencies']")
    private WebElementFacade AllCurrencies;
    @FindBy(xpath = "//div[text()='Both - Deliverable & Non Deliverable']")
    private WebElementFacade BothCurrencies;
    @FindBy(xpath = "//h4[text()='Limit Scope']")
    private WebElementFacade limitScope;
    @FindBy(xpath = "//label[text()='Calculation type']")
    private WebElementFacade calculationTypeLabel;
    @FindBy(xpath = "//label[text()='Calculation type']//parent::div//input[@placeholder='Select']")
    private WebElementFacade calculationType;
    @FindBy(xpath = "//label[text()='Calculation type']//parent::div//div[@role='presentation']")
    private WebElementFacade calculationTypeValues;
    //ul[@id='calc-type-select-listbox']
    @FindBy(xpath = "//ul[@id='calc-type-select-listbox']")
    private WebElementFacade calculationTypeValuesSecond;
    @FindBy(xpath = "//input[@placeholder='$ Limit value']")
    private WebElementFacade limitValue;
    @FindBy(xpath = "//label[text()='Netting type']//parent::div//input[@placeholder='Select']")
    private WebElementFacade NettingType;
    @FindBy(xpath = "//label[text()='Bullion Trades']")
    private WebElementFacade bullionTradesLabel;
    @FindBy(xpath = "//label[text()='Bullion Trades']//parent::div//input[@placeholder='Select']")
    private WebElementFacade bullionTrades;
    @FindBy(xpath = "//label[text()='Bullion Trades']//parent::div//div[@role='presentation']")
    private WebElementFacade bullionTradesValues;
    @FindBy(xpath = "//label[text()='Delta']//parent::div//input[@placeholder='Select']")
    private WebElementFacade delta;
    @FindBy(xpath = "//label[text()='Delta']//parent::div//div[@role='presentation']")
    private WebElementFacade deltaValues;
    @FindBy(xpath = "//label[text()='Exclude CLS from calculation']//parent::div//input[@placeholder='Select']")
    private WebElementFacade excludeCLS;
    @FindBy(xpath = "//label[text()='Exclude CLS from calculation']//parent::div//div[@role='presentation']")
    private WebElementFacade excludeCLSValues;
    @FindBy(xpath = "//button[text()='Apply filters']")
    private WebElementFacade ApplyFilters;
    @FindBy(xpath = "//input[@value='Select Date']")
    private WebElementFacade DateFilter;
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
    private WebElementFacade DocumentIDField;
    @FindBy(xpath = "//input[@id='product-family-select']")
    private WebElementFacade auth_ProductFamily_DN;
    @FindBy(xpath = "//input[@id='product-select']")
    private WebElementFacade auth_Product_DN;
    @FindBy(xpath = "//input[@id='value-select']")
    private WebElementFacade auth_TenorValue_DN;
    @FindBy(xpath = "//input[@id='auth-tenor-select']")
    private WebElementFacade auth_SelectTenor_DN;
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElementFacade applyOnlyBtn;


    public void select_existing_query(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String,String> dataTable_map= data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            String baseQueryName = dataTable.get("query block").trim();
            // Read the exact generated name stored during creation (handles random suffix)
            String storedName = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_QUERY_" + baseQueryName);
            String queryToSelect = (storedName != null && !storedName.toString().isEmpty())
                    ? storedName.toString() : baseQueryName;
            log.info("Selecting existing query: " + queryToSelect);
            withAction().moveToElement(AddEdit_selectquery_dropdown).click().sendKeys(queryToSelect).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to select the existing query");
        }
    }
    public void select_existing_query_ADDEditScreen(DataTable table) {
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            String baseQueryName = dataTable.get("query block").trim();
            String storedName = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_QUERY_" + baseQueryName);
            String queryToSelect = (storedName != null && !storedName.toString().isEmpty())
                    ? storedName.toString() : baseQueryName;
            log.info("Selecting existing query (Add Edit screen): " + queryToSelect);
            withAction().moveToElement(AddEdit_selectquery_dropdown).click().sendKeys(queryToSelect).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to select the existing query");
        }
    }
    public void AddEdit_remove_existing_queryblock(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            if (AddEdit_Documentfield.getText().equalsIgnoreCase(dataTable.get("field"))){
                remove_queryblock.click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }
        }
        catch (Exception e) {
            log.error("Unable to remove the existing queryblock");
        }
    }

    public void AddEdit_queryname(DataTable table){
        StringBuilder random = DocumentTemplateCreatePageObject.randomStringGenerator();
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            String fullQueryName = dataTable.get("query name") + random;

            // --- FIX IMPLEMENTED HERE ---
            queryname.waitUntilClickable().click();

            // Clean sweeping any ghost characters or placeholders
            queryname.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
            queryname.sendKeys(org.openqa.selenium.Keys.DELETE);

            // Native Serenity typeInto bubbles the value directly into the application's React state
            typeInto(queryname, fullQueryName);

            // Focus away to commit 'onBlur' events
            queryname.sendKeys(org.openqa.selenium.Keys.TAB);
            // -----------------------------

            // Store under base-name key so other scenarios in this run can find the exact generated name
            net.serenitybdd.core.Serenity.setSessionVariable("STORED_QUERY_" + dataTable.get("query name").trim()).to(fullQueryName);
            log.info("Saved unique query name to session: " + fullQueryName);
        } catch (Exception e) {
            log.error("Unable to name query", e);
        }
    }

    public void AddEdit_queryblock_details(DataTable table){
        try {
            Calendar cal= Calendar.getInstance();
            String Month = ApprovalAgreementCreatePageObject.theMonth(cal.get(Calendar.MONTH));
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            AddEdit_Documentfield.waitUntilVisible();
            withAction().moveToElement(AddEdit_Documentfield).click().sendKeys(dataTable.get("field")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            AddEdit_Documentoperator.waitUntilVisible();
            withAction().moveToElement(AddEdit_Documentoperator).click().sendKeys(dataTable.get("operator")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            if((dataTable.get("field").equalsIgnoreCase("Document Version ID")) ||(dataTable.get("field").equalsIgnoreCase("Limit Value"))||(dataTable.get("field").equalsIgnoreCase("Document ID"))||(dataTable.get("field").equalsIgnoreCase("Client-2 Funds"))||(dataTable.get("field").equalsIgnoreCase("EB Alternate ID")))
            {
                withAction().moveToElement(AddEdit_DocumentIDValue).click().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }
            else if((dataTable.get("value").equalsIgnoreCase("Current Date")))
            {
                DateFilter.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                System.out.println("Current Dates are :-"+ cal.get(Calendar.DATE) + "Month" + Month);
                System.out.println("Xpath Created is :- "+"//div[contains(text(),'" + Month+ "')]/../following-sibling::div//div//div[text()='"+cal.get(Calendar.DATE)+"']");
                WebElementFacade currentDate = find(By.xpath("//div[contains(text(),'" + Month+ "')]/../following-sibling::div//div//div[text()='"+cal.get(Calendar.DATE)+"']"));
                currentDate.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            else {
                withAction().moveToElement(AddEdit_Documentvalue).click().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
//                withAction().moveToElement(AddEdit_Documentvalue).click().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(2)).build().perform();
            }

        }catch (Exception e) {
            log.error("Unable to make query"+e);
        }
    }
    public void AddEdit_multiple_queryblock_details(DataTable table) {
        // Clear out any existing query blocks first to prevent session-persistence conflicts
        int existingBlocksCount = getDriver().findElements(By.xpath("//div[@class='query-builder-rule']")).size();
        for (int i = 0; i < existingBlocksCount; i++) {
            try {
                WebElement deleteBtn = getDriver().findElement(By.xpath("//div[@class='qb-actions']//*[name()='svg'][1]"));
                evaluateJavascript("arguments[0].click();", deleteBtn);
                withAction().pause(Duration.ofMillis(500)).build().perform();
            } catch (Exception e) {
                // Ignore if cannot click
            }
        }
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        int block = 1;

        for (Map<String, String> row : data) {
            AddEdit_Documentfield.waitUntilVisible();
            WebElementFacade fieldInput = find(By.xpath("//div[@class='query-builder-rule'][" + block + "]//input[@placeholder='Select field']"));
            fieldInput.click();
            fieldInput.sendKeys(row.get("field"));
            waitABit(1000);
            fieldInput.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
            waitABit(1000);

            AddEdit_Documentoperator.waitUntilVisible();
            WebElementFacade operatorInput = find(By.xpath("//div[@class='query-builder-rule'][" + block + "]//input[@placeholder='Operators']"));
            operatorInput.click();
            operatorInput.sendKeys(row.get("operator"));
            waitABit(1000);
            operatorInput.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
            waitABit(1000);

            if (row.get("field").toUpperCase().contains("ID")) {
                WebElementFacade valueInput = find(By.xpath("//div[@class='query-builder-rule'][" + block + "]//div[3]//input"));
                valueInput.click();
                valueInput.sendKeys(row.get("value"));
                waitABit(1000);
            } else {
                WebElementFacade valueInput = find(By.xpath("//div[@class='query-builder-rule'][" + block + "]//div[3]//input"));
                valueInput.click();
                valueInput.sendKeys(row.get("value"));
                waitABit(1000);

                String targetedValue = row.get("value").trim();
                String caseInsensitiveXpath = "//div[@role='presentation']//*[translate(normalize-space(text()), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')='"
                        + targetedValue.toUpperCase() + "']";
                WebElementFacade valueOnListingScreen = find(By.xpath(caseInsensitiveXpath));
                try {
                    valueOnListingScreen.waitUntilVisible().click();
                } catch (Exception e) {
                    evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", valueOnListingScreen);
                    evaluateJavascript("arguments[0].click();", valueOnListingScreen);
                }
                waitABit(1000);
            }
            if (row.get("condition").equalsIgnoreCase("and")) {
                add_queryblock.click();
                block++;
            } else if (row.get("condition").equalsIgnoreCase("or")) {
                add_queryblock.click();
                WebElementFacade orBtn = find(By.xpath("//div[@role='group'][" + block + "]//button[text()='OR']"));
                try {
                    orBtn.click();
                } catch (Exception clickEx) {
                    evaluateJavascript("arguments[0].click();", orBtn);
                }
                block++;
            } else {
                log.info("Query blocks added successfully.");
            }
        }
    }

    public void AddEdit_multiple_queryblock_details_DN(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        int block=1;
        for (Map<String, String> row : data){

            AddEdit_Documentfield.waitUntilVisible();
            withAction().moveToElement(find(By.xpath("//div[@class='query-builder-rule']["+block+"]//input[@placeholder='Select field']"))).click().sendKeys(row.get("field")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            AddEdit_Documentoperator.waitUntilVisible();
            withAction().moveToElement(find(By.xpath("//div[@class='query-builder-rule']["+block+"]//input[@placeholder='Operators']"))).click().sendKeys(row.get("operator")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();

            if (row.get("field").toUpperCase().contains("ID")) {
                WebElementFacade valueInput = find(By.xpath("//div[@class='query-builder-rule'][" + block + "]//div[3]//input"));
                withAction().moveToElement(valueInput).click().sendKeys(row.get("value")).pause(Duration.ofSeconds(2)).build().perform();
            }
            else
            {
                WebElementFacade valueInput = find(By.xpath("//div[@class='query-builder-rule']["+block+"]//div[3]//input"));
                withAction().moveToElement(valueInput).click().sendKeys(row.get("value")).pause(Duration.ofSeconds(2)).build().perform();
                selectVisibleDropdownOption_DN(row.get("value"));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }

            if (row.get("condition").equalsIgnoreCase("and")){
                add_queryblock.click();
                block++;
            } else if (row.get("condition").equalsIgnoreCase("or")) {
                add_queryblock.click();
                withAction().moveToElement(find(By.xpath("//div[@role='group']["+block+"]//button[text()='OR']"))).click().build().perform();
                block++;
            }
            else {
                log.info("Query blocks added (DN)");
            }
        }
    }
    private void selectVisibleDropdownOption_DN(String value) {
        String xpath = "//div[@role='presentation']//*[normalize-space(text())='" + value + "']";
        WebElementFacade target = findVisibleMatch_DN(xpath);
        if (target == null) {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            target = findVisibleMatch_DN(xpath);
        }
        if (target == null) {
            Assert.fail("Unable to find a visible dropdown option for value: " + value);
        }
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", target);
        target.waitUntilClickable().click();
    }

    private WebElementFacade findVisibleMatch_DN(String xpath) {
        for (WebElementFacade candidate : findAll(By.xpath(xpath))) {
            if (candidate.isCurrentlyVisible()) {
                return candidate;
            }
        }
        return null;
    }

    public boolean verifyAdvanceFilterFields(){
        boolean result =false;
        //Auth Scope
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        auth_ProductFamily.waitUntilVisible();
        auth_Product.waitUntilVisible();
        auth_Tenor.waitUntilVisible();
        auth_SelectTenor.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        log.info("Actual Values :" + auth_TenorValues.getText());
        log.info("Calendar Days\nBusiness Days\nMonths\nYears\nSpot-only\nUp-to-spot");
        Assert.assertTrue(auth_TenorValues.getText().equalsIgnoreCase("Calendar Days\nBusiness Days\nMonths\nYears\nSpot-only\nUp-to-spot"));
        auth_SelectTenor.waitUntilVisible().click();
        clearFilter.waitUntilVisible();
        //Auth Currencies
        authCurrencies.waitUntilVisible();
        currenciesTab.waitUntilVisible();
        currenciesPairTab.waitUntilVisible();
        AllCurrencies.waitUntilVisible();
        BothCurrencies.waitUntilVisible();
        //Limit Scope
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", calculationTypeLabel);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        calculationTypeLabel.waitUntilVisible();
        calculationType.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        log.info("Actual Values :" + calculationTypeValuesSecond.getText());
        log.info("NOP\nDSL");
        Assert.assertTrue(calculationTypeValuesSecond.getText().equalsIgnoreCase("NOP\nDSL"));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        limitValue.waitUntilVisible();
        NettingType.waitUntilVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", bullionTradesLabel);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        bullionTradesLabel.waitUntilVisible();
        bullionTrades.waitUntilPresent().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(bullionTradesValues.getText().equalsIgnoreCase("Include Metals\nExclude Metals\nOnly Metals"));
        bullionTrades.click();
        delta.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(deltaValues.getText().equalsIgnoreCase("No\nYes"));
        delta.click();
        excludeCLS.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        result= excludeCLSValues.getText().equalsIgnoreCase("No\nYes");
        excludeCLS.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        return result;
    }

    public void verifyAdvanceFilterFieldsNew() {
        auth_SelectTenor.waitUntilVisible().click();
        auth_TenorValues.waitUntilVisible();
        String actualTenorValues = auth_TenorValues.getText().replace("\r\n", "\n");
        String expectedTenor = "Calendar Days\nBusiness Days\nMonths\nYears\nSpot-only\nUp-to-spot";
        log.info("Actual Tenor Values: " + actualTenorValues);
        Assert.assertEquals("Tenor values did not match!", expectedTenor, actualTenorValues);
        auth_SelectTenor.click();
        clearFilter.waitUntilVisible();
        authCurrencies.waitUntilVisible();
        currenciesTab.waitUntilVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", calculationTypeLabel);
        calculationTypeLabel.waitUntilVisible();
        calculationType.click();
        calculationTypeValuesSecond.waitUntilVisible();
        String actualCalcValues = calculationTypeValuesSecond.getText().replace("\r\n", "\n");
        log.info("Actual Calc Values: " + actualCalcValues);
        Assert.assertTrue("Calculation Type values incorrect", actualCalcValues.equalsIgnoreCase("DSL\nNOP"));
        calculationType.click();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", bullionTradesLabel);
        bullionTradesLabel.waitUntilVisible();
        bullionTrades.waitUntilPresent().click();
        bullionTradesValues.waitUntilVisible();
        String actualBullion = bullionTradesValues.getText().replace("\r\n", "\n");
        Assert.assertTrue("Bullion values incorrect", actualBullion.equalsIgnoreCase("Include Metals\nExclude Metals\nOnly Metals"));
        bullionTrades.click();
        delta.click();
        deltaValues.waitUntilVisible();
        Assert.assertTrue("Delta values incorrect", deltaValues.getText().replace("\r\n", "\n").equalsIgnoreCase("No\nYes"));
        delta.click();
        excludeCLS.click();
        excludeCLSValues.waitUntilVisible();
        String actualCLS = excludeCLSValues.getText().replace("\r\n", "\n");
        Assert.assertTrue("Exclude CLS values incorrect", actualCLS.equalsIgnoreCase("No\nYes"));
        excludeCLS.click();
    }


    public void AddAuthScopeValuesInAdvanceFilters(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);

        String productFamily = dataTable.get("Product Family");
        String product = dataTable.get("Product");
        String tenorValue = dataTable.get("Tenor Value");
        String tenorType = dataTable.get("Tenor");

        // 1. Select Product Family
        if (productFamily != null && !productFamily.isEmpty()) {
            WebElement familyInput = find(By.xpath("//input[@id='product-family-select' or @placeholder='Select family' or contains(@placeholder, 'family') or contains(@placeholder, 'Family')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", familyInput);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            familyInput.click();
            familyInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            familyInput.sendKeys(productFamily);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            try {
                WebElementFacade familyOption = findVisibleDropdownOption_DN(productFamily);
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", familyOption);
                familyOption.waitUntilClickable().click();
            } catch (Exception e) {
                familyInput.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }

        // 2. Select Product
        if (product != null && !product.isEmpty()) {
            String[] splitValuesArray = product.split(",");
            WebElement productInput = find(By.xpath("//input[@id='product-select' or @placeholder='Select product' or contains(@placeholder, 'product') or contains(@placeholder, 'Product')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", productInput);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            for (String eachValue : splitValuesArray) {
                String trimmedValue = eachValue.trim();
                productInput.click();
                productInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofMillis(500)).build().perform();
                productInput.sendKeys(trimmedValue);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                try {
                    WebElementFacade option = findVisibleDropdownOption_DN(trimmedValue);
                    getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", option);
                    option.waitUntilClickable().click();
                } catch (Exception e) {
                    productInput.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            withAction().sendKeys(Keys.ESCAPE).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }

        // 3. Enter Tenor Value
        if (tenorValue != null && !tenorValue.isEmpty()) {
            WebElement tenorValueInput = find(By.xpath("//input[@id='value-select' or @placeholder='Enter value' or contains(@placeholder, 'value') or contains(@placeholder, 'Value')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", tenorValueInput);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            tenorValueInput.click();
            tenorValueInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            tenorValueInput.sendKeys(tenorValue);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }

        // 4. Select Tenor
        if (tenorType != null && !tenorType.isEmpty()) {
            WebElement tenorSelectInput = find(By.xpath("//input[@id='auth-tenor-select' or @placeholder='Select tenor' or contains(@placeholder, 'tenor') or contains(@placeholder, 'Tenor')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", tenorSelectInput);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            tenorSelectInput.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            try {
                WebElementFacade tenorOption = findVisibleDropdownOption_DN(tenorType);
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", tenorOption);
                tenorOption.waitUntilClickable().click();
            } catch (Exception e) {
                tenorSelectInput.sendKeys(tenorType, Keys.ARROW_DOWN, Keys.RETURN);
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }

        // 5. Apply Filters if button is visible
        try {
            List<WebElement> applyBtns = getDriver().findElements(By.xpath("//button[text()='Apply filters' or text()='Apply']"));
            for (WebElement btn : applyBtns) {
                if (btn.isDisplayed()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                    btn.click();
                    log.info("Clicked Apply Filters on Advance Filters screen.");
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    break;
                }
            }
        } catch (Exception ignored) {}
    }
    public void reliablyAddAuthScopeValues(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);

        String productFamily = dataTable.get("Product Family");
        String product = dataTable.get("Product");
        String tenorValue = dataTable.get("Tenor Value");
        String tenorType = dataTable.get("Tenor");
        if (productFamily != null && !productFamily.isEmpty()) {
            auth_ProductFamily_DN.waitUntilClickable();
            withAction().moveToElement(auth_ProductFamily_DN).click().sendKeys(productFamily).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            WebElementFacade familyOption = findVisibleDropdownOption_DN(productFamily);
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", familyOption);
            familyOption.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }

        if (product != null && !product.isEmpty()) {
            String[] splitValuesArray = product.split(",");

            for (String eachValue : splitValuesArray) {
                String trimmedValue = eachValue.trim();

                auth_Product_DN.waitUntilClickable();
                withAction().moveToElement(auth_Product_DN).click().sendKeys(trimmedValue).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                WebElementFacade option = findVisibleDropdownOption_DN(trimmedValue);
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", option);
                option.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }

            withAction().sendKeys(Keys.ESCAPE).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        if (tenorValue != null && !tenorValue.isEmpty()) {
            auth_TenorValue_DN.waitUntilVisible().clear();
            withAction().moveToElement(auth_TenorValue_DN).click().sendKeys(tenorValue).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        if (tenorType != null && !tenorType.isEmpty()) {
            auth_SelectTenor_DN.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            WebElementFacade tenorOption = findVisibleDropdownOption_DN(tenorType);
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", tenorOption);
            tenorOption.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }
    private WebElementFacade findVisibleDropdownOption_DN(String value) {
        String xpath = "//li[@role='option' and contains(normalize-space(.), '" + value + "')] | " +
                      "//li[contains(normalize-space(.), '" + value + "')] | " +
                      "//div[@role='presentation']//*[contains(normalize-space(text()), '" + value + "')] | " +
                      "//span[contains(text(), '" + value + "')]";
        List<WebElementFacade> candidates = findAll(By.xpath(xpath));
        for (WebElementFacade candidate : candidates) {
            if (candidate.isCurrentlyVisible()) {
                return candidate;
            }
        }
        Assert.fail("Unable to find a visible option for value: " + value);
        return null;
    }
    public void maxValueOfLimitValue(DataTable dataTable) {
        String expectedFormattedValue = dataTable.asLists(String.class).get(0).get(0).trim();
        WebElementFacade limitValueInput = find(By.xpath("//input[@placeholder='Enter value']"));
        limitValueInput.waitUntilVisible();
        String actualFormattedValue = limitValueInput.getValue().trim();
        Assert.assertEquals("Formatted max value mismatch", expectedFormattedValue, actualFormattedValue);
        String rawValue = actualFormattedValue.replace("$", "").replace(",", "");
        Assert.assertEquals("Raw max value mismatch", "999999999999999", rawValue);
    }

    public void clickApplyButtonOnly() {
        applyOnlyBtn.withTimeoutOf(Duration.ofSeconds(15))
                .waitUntilPresent()
                .waitUntilVisible()
                .waitUntilClickable();

        try {
            applyOnlyBtn.click();
        } catch (Exception e) {
            log.warn("Standard button click intercepted by dialog overlay canvas tree. Executing JavaScript action bypass.");
            evaluateJavascript("arguments[0].click();", applyOnlyBtn);
        }
        log.info("Query filter criteria injected onto table view successfully!");

        // Give the network a brief 2.5-second buffer window to completely re-render table cell values
        try { Thread.sleep(2500); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
    }

}