package PageObjects.QueryBuilder;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
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

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class QueryBuilderColumnsPageObject extends PageObject {
    Actions act = new Actions(getDriver());


    @FindBy(xpath = "//button[text()='Column Selection']")
    private WebElementFacade columnsSelection_btn;
    @FindBy(xpath = "//div[@class='search-add-container col-search']//input")
    private WebElementFacade search_bar;
    @FindBy(xpath = "//input[@name='checkbox']")
    private WebElementFacade checkbox_search;
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElementFacade apply_search;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_search;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-creditLinkSyncStatus' or text()='CreditLink sync status']")
    private WebElementFacade creditLinkStatus;
    @FindBy(xpath = "//span[text()='sent']")
    private WebElementFacade creditLinkSentStatus;
    @FindBy(xpath = "//tbody//tr[1]//td[count(//th[descendant-or-self::*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='document type']]/preceding-sibling::th) + 1]")
    private WebElementFacade filterResults;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade closeDropDown;
    @FindBy(xpath = "//div[@class = 'title' and text()='Documents']")
    private WebElementFacade DocumentTitle;
    @FindBy(xpath = "(//div[@class='icon']/*[name()='svg'])[1]")
    private WebElementFacade clickOnCrossIcon;
    @FindBy(xpath = "//th[text() = 'Client-2 Funds']//input[@placeholder = 'Search']")//input[@placeholder='Search']/ancestor::div//th[text()='Client-2 Funds']
    private WebElementFacade FundSearch;
    @FindBy(xpath = "//button[@class='funds-count link']")
    private WebElementFacade FundCount;
    @FindBy(xpath = "//button[@class ='funds-count ' and text()='No Funds']")
    private WebElementFacade NoFunds;
    @FindBy(xpath = "//*[text()='Yes']")
    private WebElementFacade YesButon;
    @FindBy(xpath = "(//button[@aria-label='Delete'])[1]")
    private WebElementFacade DeleteIconIndex;
    @FindBy(xpath = "(//button[@aria-label='Terminate'])[1]")
    private WebElementFacade TerminateIconIndex;
    @FindBy(xpath = "//div[@class='drag-handle']")
    private List<WebElementFacade> DragHandleCount;
    @FindBy(xpath = "(//div[@class='columns-content']//span)[1]")
    private WebElementFacade FirstPosition_Column;
    @FindBy(xpath = "(//div[@class='columns-content']//span)[3]")
    private WebElementFacade ThirdPosition_Column;
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElementFacade ApplyButton;
    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElementFacade> documentTableRows;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade docTypeDropdown;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade docTypeInput;

    @FindBy(xpath = "//input[@placeholder='Select LEIs']")
    private WebElementFacade leiInput;

    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgTypeInput;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElementFacade addButton;


    public void selectSearchBar() {
        // Open Column Selection panel if not already open (works for all screens)
        if (!search_bar.isCurrentlyVisible()) {
            columnsSelection_btn.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        search_bar.waitUntilPresent().click();
    }

    public void deleteTerminateDoc(){
        List<WebElement> deleteIcon = getDriver().findElements(By.xpath("//button[@aria-label='Delete']"));
        for(int i =0; i<deleteIcon.size(); i++){
            DeleteIconIndex.click();
            YesButon.click();
        }

        List<WebElement> terminateIcon = getDriver().findElements(By.xpath("//button[@aria-label='Terminate']"));
        for(int i =0; i<deleteIcon.size(); i++){
            TerminateIconIndex.click();

        }
    }
////table[@class='doc-table']//tbody/tr
public void columnText_search(DataTable columns) {
    withAction().pause(Duration.ofSeconds(3)).build().perform();
    List<Map<String, String>> data = columns.asMaps(String.class, String.class);

    for (Map<String, String> dataTable : data) {
        String columnName = dataTable.get("Column Name");
        // Convert to lowercase and trim any accidental whitespace
        String lowerCaseColumnName = columnName.toLowerCase().trim();

        // 1. React-friendly clear: Click, Select All, Backspace
        search_bar.waitUntilClickable().click();
        search_bar.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        withAction().pause(Duration.ofMillis(500)).build().perform();

        // 2. Type the target column name
        search_bar.sendKeys(columnName);
        withAction().pause(Duration.ofSeconds(2)).build().perform(); // Wait for DOM to filter

        // 3. Bulletproof Checkbox XPath
        // Finds the text span (case-insensitive), moves up to the label wrapper, and grabs the input inside
        String dynamicCheckboxXpath = "//span[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerCaseColumnName + "']/ancestor::label//input";

        WebElementFacade specificCheckbox = find(By.xpath(dynamicCheckboxXpath));

        // 4. Increase timeout slightly for this specific element resolution
        specificCheckbox.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();

        // 5. Evaluate and perform action
        boolean isAlreadyChecked = specificCheckbox.isSelected() || (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && (arguments[0].parentElement.classList.contains('Mui-checked') || arguments[0].parentElement.classList.contains('checked')));", specificCheckbox);
        if (isAlreadyChecked) {
            // If it's already checked, clear the search and move to the next item
            if(clickOnCrossIcon.isCurrentlyVisible()){
                clickOnCrossIcon.click();
            }
        } else {
            // If it's NOT checked, click it using JavaScript to bypass any UI overlays
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", specificCheckbox);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    // Click Apply
    withAction().pause(Duration.ofSeconds(1)).build().perform();
    getJavascriptExecutorFacade().executeScript("arguments[0].click();", apply_search);
    withAction().pause(Duration.ofSeconds(2)).build().perform();
}

    public void verifyColumn(DataTable columns) {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        List<Map<String, String>> data = columns.asMaps(String.class, String.class);

        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

            String columnName = dataTable.get("Column Name");
            String filterValue = dataTable.get("value").trim();
            String lowerCaseColumnName = columnName.toLowerCase().trim();

            // 1. Case-insensitive XPath to find the main Column Header (<th>)
            String headerXpath = "//th[descendant::*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerCaseColumnName + "']] | //th[contains(translate(@data-testid, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "')]";

            WebElementFacade columnHeader = find(By.xpath(headerXpath));
            columnHeader.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();

            // 2. SCROLL the column header into the center of the view
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", columnHeader);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // 3. Find the input field specifically inside this visible header and click
            WebElementFacade filterOnListingScreen = columnHeader.find(By.xpath(".//input"));
            filterOnListingScreen.waitUntilClickable();

            evaluateJavascript("arguments[0].click();", filterOnListingScreen);

            // Clear existing text safely using Ctrl+A and Backspace
            filterOnListingScreen.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            // 4. Handle Dropdown (PB, EB, Client, Status) vs Standard Text Inputs
            String columnNameUpper = columnName.toUpperCase();
            if (columnNameUpper.contains("PB") || columnNameUpper.contains("EB") || columnNameUpper.contains("CLIENT") || columnNameUpper.contains("STATUS") || columnNameUpper.contains("LIFECYCLE")) {

                filterOnListingScreen.type(filterValue);
                withAction().pause(Duration.ofSeconds(4)).build().perform(); // Wait for dropdown API to load

                String lowerValue = filterValue.toLowerCase();
                List<WebElementFacade> options = findAll(By.xpath(
                        "//div[@role='presentation']//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerValue + "')] | " +
                                "//li[@role='option' and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerValue + "')]"
                ));

                WebElementFacade targetMatch = null;

                // Attempt 1: Look for an EXACT match first
                for (WebElementFacade option : options) {
                    String optionText = option.getText().replaceAll("\\s+", " ").trim();
                    String compareValue = filterValue.replaceAll("\\s+", " ").trim();

                    if (optionText.equalsIgnoreCase(compareValue)) {
                        targetMatch = option;
                        break;
                    }
                }

                // Attempt 2 (Fallback): If exact match fails, look for a PARTIAL match (e.g., to handle hidden UI spaces)
                if (targetMatch == null && !options.isEmpty()) {
                    log.warn("Exact match not found for '{}'. Attempting partial match fallback...", filterValue);
                    String compareValue = filterValue.replaceAll("\\s+", " ").trim().toLowerCase();

                    for (WebElementFacade option : options) {
                        String optionText = option.getText().replaceAll("\\s+", " ").trim().toLowerCase();
                        if (optionText.contains(compareValue)) {
                            targetMatch = option;
                            log.info("Partial match found and selected: '{}'", option.getText());
                            break;
                        }
                    }
                }

                // Finally, Click the matched element
                if (targetMatch != null) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", targetMatch);
                    try {
                        targetMatch.click();
                    } catch (Exception e) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", targetMatch);
                    }
                    log.info("Successfully selected dropdown option for: " + filterValue);
                } else {
                    log.error("No exact or partial match found for '{}'.", filterValue);
                    Assert.fail("Dropdown match not found in the UI for: '" + filterValue + "'");
                }

            } else {
                // Logic for standard text inputs (Non-dropdowns)
                filterOnListingScreen.type(filterValue);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            }

            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
        }
    }

    public void verifyAllColumns(DataTable columns) {
        List<Map<String, String>> data = columns.asMaps(String.class, String.class);

        for (Map<String, String> dataTable : data) {
            String columnName = dataTable.get("Column Name");
            String valueToType = dataTable.get("value").trim();
            String lowerCaseColumnName = columnName.toLowerCase().trim();

            try {
                // 1. Case-insensitive XPath to find the main Column Header (<th>)
                String headerXpath = "//th[descendant::*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerCaseColumnName + "']] | //th[contains(translate(@data-testid, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "')]";

                WebElementFacade columnHeader = find(By.xpath(headerXpath));
                columnHeader.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();

                // 2. SCROLL the column header into the center of the view
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", columnHeader);
                withAction().pause(Duration.ofSeconds(2)).build().perform(); // Wait for scroll

                // 3. Find the input field specifically inside this visible header and click
                WebElementFacade filterOnListingScreen = columnHeader.find(By.xpath(".//input"));
                filterOnListingScreen.waitUntilClickable();
                evaluateJavascript("arguments[0].click();", filterOnListingScreen);
                filterOnListingScreen.clear();
                withAction().pause(Duration.ofMillis(500)).build().perform();

                if (columnName.contains("PB") || columnName.contains("EB") || columnName.contains("Client")) {
                    if (valueToType.equalsIgnoreCase("A1 Fund SPC")) {
                        filterOnListingScreen.type(valueToType);
                        find(By.xpath("//div[@role='presentation']")).withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
                        Actions act = new Actions(getDriver());
                        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
                    } else {
                        filterOnListingScreen.type(valueToType);
                        String dropdownOptionXPath = "//div[@role='presentation']//*[normalize-space()='" + valueToType + "']";
                        WebElementFacade valueOnListingScreen = find(By.xpath(dropdownOptionXPath));
                        valueOnListingScreen.withTimeoutOf(Duration.ofSeconds(10)).shouldBeVisible();
                        valueOnListingScreen.click();
                    }
                } else {
                    filterOnListingScreen.typeAndEnter(valueToType);
                }

                Actions shiftTabAction = new Actions(getDriver());
                shiftTabAction.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();

            } catch (AssertionError e) {
                log.error("Validation FAILED: Column '{}', value '{}'. Element not visible. Error: {}", columnName, valueToType, e.getMessage(), e);
                Assert.fail("Validation FAILED: Column '" + columnName + "'. Element not visible. See logs.");
            } catch (Exception e) {
                log.error("Failed to filter column '{}' with value '{}'. Error: {}", columnName, valueToType, e.getMessage(), e);
                Assert.fail("Test failed: Could not filter column '" + columnName + "'. See logs.");
            }
        }
    }

    public void user_Validates_the_columns_are_displayed_on_Dashboard(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable : data) {
            String columnName = dataTable.get("Column Name");
            // Flexible XPath to find the header either as direct text or within a span
            String columnHeaderXPath = "//th[normalize-space(.)='" + columnName + "'] | //th[descendant::span[normalize-space()='" + columnName + "']]";
            try {
                WebElementFacade columnHeader = find(By.xpath(columnHeaderXPath));
                // Increased timeout for CI environments
                columnHeader.withTimeoutOf(Duration.ofSeconds(15)).waitUntilPresent();
                // Explicit horizontal and vertical scroll
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", columnHeader);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                
                Assert.assertTrue("Column '" + columnName + "' was not visible on the dashboard grid.", columnHeader.isCurrentlyVisible());
                log.info("Validation successful: Column '{}' is displayed.", columnName);
            }
            catch (Exception e) {
                log.error("Validation FAILED: Column '{}' was not found or is not visible. {}", columnName, e.getMessage());
                Assert.fail("Validation FAILED: Column '" + columnName + "' was not found or is not visible.");
            }
        }
    }

    public void filterAndSelectColumnValues(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            WebElementFacade filterOnListingScreen = find(By.xpath("//th[text()='" + dataTable.get("Column Name") + "']//input"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);
            filterOnListingScreen.click();
            filterOnListingScreen.clear();
            if(dataTable.get("Column Name").contains("PB") || dataTable.get("Column Name").contains("EB") || dataTable.get("Column Name").contains("Client"))
            {
                withAction().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).build().perform();
                WebElementFacade valueOnListingScreen = find(By.xpath("//div[@role='presentation']//*[text()='" + dataTable.get("value") + "']"));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                valueOnListingScreen.waitUntilVisible().click();
            }
            else {
                withAction().pause(Duration.ofSeconds(1)).sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            }
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            if(!dataTable.get("Column Name").equalsIgnoreCase("Document Type")) {
                closeDropDown.click();
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }

    public void validateColumnValues(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            Assert.assertTrue(find(By.xpath("//*[text()='" + dataTable_map.get("Column Name") + "']")).isPresent());
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }
    }

    public void validateColumnAreAdded(DataTable table) {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> dataTable_map : data) {
            String columnName = dataTable_map.get("Column Name");
            String lowerCaseColumnName = columnName.toLowerCase().trim();

            // 1. Case-insensitive XPath using data-testid or text()
            String dynamicXpath = "//*[contains(translate(@data-testid, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "') or translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerCaseColumnName + "']";

            // 2. Find the element in the DOM (it just needs to exist, not be visible yet)
            WebElementFacade columnHeader = find(By.xpath(dynamicXpath));
            columnHeader.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();

            // 3. YOUR FIX: Scroll the element into the center of the view
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", columnHeader);

            // Give the UI a moment to finish scrolling
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // 4. Now assert that it is actually visible on the screen
            Assert.assertTrue("Validation Failed: Column '" + columnName + "' is not visible on the screen.", columnHeader.isCurrentlyVisible());
        }
    }
    public void ClientFund(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",FundCount);
        FundCount.waitUntilClickable();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        FundCount.click();
    }
    public void SearchFund(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
//        WebElementFacade filterOnListingScreen = find(By.xpath("//th[contains(., 'Client-2 Funds') and contains(., '"+dataTable.get("Column Name")+"')]//input)"));
//        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);
//        WebElementFacade filterOnListingScreen = find(By.xpath("//th[text()='" + dataTable.get("Column Name") + "']//input"));
//        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);
        try {
            withAction().moveToElement(FundSearch).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to search the Fund"+e);
            Assert.fail();
        }
}
    public void NoFundsVisible(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",NoFunds);
        withAction().pause(Duration.ofSeconds(5)).build().perform();

        Assert.assertTrue(NoFunds.isVisible());
    }
    public void validateColumnSequence_withDocumentAction(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            Assert.assertTrue(find(By.xpath("//th[text()='Document Action']/following-sibling::th[text()='" + dataTable_map.get("Column Name") + "']")).isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }
    public void validateColumnSequence_withStatusAndCurrencies(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            Assert.assertTrue(find(By.xpath("//th[text()='Document Type']/following-sibling::th[text()='" + dataTable_map.get("Column Name") + "']")).isVisible());
            Assert.assertTrue(find(By.xpath("//th[text()='Allowed Currencies']/following-sibling::th[text()='" + dataTable_map.get("Column Name") + "']")).isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }

    public void DragAndDropColumnSelection(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            WebElement source = getDriver().findElement(By.xpath("//div[@class='column-selection-wrapper']//span[text()='"+dataTable_map.get("Column Name")+"']/ancestor::div[1]/div"));

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", source);
            act.dragAndDrop(source, FirstPosition_Column).build().perform();
            act.pause(Duration.ofSeconds(2)).build().perform();
        }
    }
    public void DragAndDropColumnSelection_3rdPosition(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            WebElement source = getDriver().findElement(By.xpath("//div[@class='column-selection-wrapper']//span[text()='"+dataTable_map.get("Column Name")+"']/ancestor::div[1]/div"));

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", source);
            act.clickAndHold(source).moveToElement(ThirdPosition_Column).moveByOffset(0, 10).pause(Duration.ofSeconds(1)).release().build().perform();
            act.pause(Duration.ofSeconds(2)).build().perform();

        }
    }
    public void VerifySequence(DataTable table)
    {
        int i = 1;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            WebElement element = getDriver().findElement(By.xpath("//tr//th//span[text()='" + dataTable_map.get("Sequence") + "']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            Assert.assertTrue(getDriver().findElement(By.xpath("(//tr//th[" + i + "]//span)[1]")).getText().equalsIgnoreCase(dataTable_map.get("Sequence")));
            i++;
        }}
    public void creditLinkCLSyncStatusValidation() {
        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", creditLinkStatus);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            if (creditLinkStatus.isVisible()) {
                if (creditLinkSentStatus.isVisible()) {
                    log.info("Validation Successful: CreditLink Sync Status is 'sent'.");
                } else {
                    log.error("Validation Failed: 'sent' status NOT found.");
                    throw new AssertionError("Expected 'sent' status was not found in the CreditLink Sync Status column.");
                }
            } else {
                log.error("CreditLink Status container is not visible even after scrolling.");
                throw new AssertionError("CreditLink Status container is missing from the UI.");
            }
        } catch (Exception e) {
            log.error("Error during CreditLink status validation: " + e.getMessage());
            throw e;
        }
    }
/////////////////////////old filter only handle case insensitive cases we will remove this code one below  new code worksfine///////////////
//    public void verifyColumnNew(DataTable columns) {
//        List<Map<String, String>> data = columns.asMaps(String.class, String.class);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
//        for (Map<String, String> row : data) {
//            String columnName = row.get("Column Name");
//            String value = row.get("value");
//            log.info("Applying filter on column '{}' with value '{}'", columnName, value);
//            try {
//                String lowerCaseColumnName = columnName.toLowerCase().trim();
//                String headerXpath = "//th[descendant::*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerCaseColumnName + "']] | //th[contains(translate(@data-testid, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "')]";
//                WebElement columnHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(headerXpath)));
//                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", columnHeader);
//                withAction().pause(Duration.ofSeconds(1)).build().perform();
//                WebElement filterInput = wait.until(ExpectedConditions.elementToBeClickable(columnHeader.findElement(By.xpath(".//input"))));
//                filterInput.click();
//                filterInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
//                withAction().pause(Duration.ofMillis(500)).build().perform();
//                filterInput.sendKeys(value);
//                filterInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//
//                String lowerVal = value.trim().toLowerCase();
//                String combinedXPath = "//li[@role='option' and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerVal + "')] | " +
//                                       "//div[@role='presentation']//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerVal + "')] | " +
//                                       "//*[contains(@class, 'MuiAutocomplete-option') and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerVal + "')]";
//
//                try {
//                    WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//                    WebElement option = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(combinedXPath)));
//
//                    try {
//                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", option);
//                        withAction().pause(Duration.ofMillis(500)).build().perform();
//                    } catch (Exception ignored) {}
//
//                    try {
//                        List<WebElement> inputs = option.findElements(By.xpath(".//input[@type='checkbox']"));
//                        if (!inputs.isEmpty() && !inputs.get(0).isSelected()) {
//                            try {
//                                inputs.get(0).click();
//                            } catch (Exception e) {
//                                getJavascriptExecutorFacade().executeScript("arguments[0].click();", inputs.get(0));
//                            }
//                        } else {
//                            option.click();
//                        }
//                    } catch (Exception clickEx) {
//                        getJavascriptExecutorFacade().executeScript("arguments[0].dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true, view: window }));", option);
//                    }
//                } catch (Exception findOptionEx) {
//                    log.warn("Option not found via xpath, falling back to keyboard ARROW_DOWN + ENTER for value '{}'", value);
//                    filterInput.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//                }
//
//                withAction().pause(Duration.ofSeconds(1)).build().perform();
//                boolean closedViaButton = false;
//                try {
//                    List<WebElement> closeBtns = getDriver().findElements(By.xpath("//button[@title='Close']"));
//                    for (WebElement cb : closeBtns) {
//                        if (cb.isDisplayed()) {
//                            cb.click();
//                            closedViaButton = true;
//                            break;
//                        }
//                    }
//                } catch (Exception ignored) {}
//
//                if (!closedViaButton) {
//                    try {
//                        withAction().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
//                    } catch (Exception ignored) {}
//                }
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//            } catch (Exception e) {
//                log.error("Failed to filter column '{}'. Error: {}", columnName, e.getMessage());
//                org.junit.Assert.fail("Failed to apply filter on Document listing screen.");
//            }
//        }
//    }
/// ///////////////////////////////////////////////////

public void verifyColumnNew(DataTable columns) {
    List<Map<String, String>> data = columns.asMaps(String.class, String.class);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

    for (Map<String, String> row : data) {
        String columnName = row.get("Column Name");
        String value = row.get("value").trim();
        log.info("Applying filter on column '{}' with value '{}'", columnName, value);

        try {
            String lowerCaseColumnName = columnName.toLowerCase().trim();
            String headerXpath = "//th[descendant::*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerCaseColumnName + "']] | //th[contains(translate(@data-testid, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "')]";

            WebElement columnHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(headerXpath)));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", columnHeader);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            //CLEAR PREVIOUS SELECTION
            try {
                List<WebElement> clearIcons = columnHeader.findElements(By.xpath(".//*[local-name()='svg' and (@data-testid='CancelIcon' or @data-testid='CloseIcon' or contains(@class, 'clear'))] | .//button[@title='Clear'] | .//div[contains(@class, 'endAdornment')]//button"));
                for (WebElement clearIcon : clearIcons) {
                    if (clearIcon.isDisplayed()) {
                        log.info("Found existing value. Clearing previous filter for: " + columnName);
                        // Using JS click to bypass any UI overlays
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", clearIcon);
                        withAction().pause(Duration.ofSeconds(1)).build().perform();
                        break;
                    }
                }
            } catch (Exception ignored) {
                // Ignore if clear icon isn't found, meaning the field is already empty
            }

            // 3. Open Filter and Type Value safely
            WebElement filterInput = wait.until(ExpectedConditions.elementToBeClickable(columnHeader.findElement(By.xpath(".//input"))));

            try {
                filterInput.click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", filterInput); // JS fallback bypasses overlays
            }

            // Backup text clearing using keyboard commands
            filterInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            filterInput.sendKeys(value);
            filterInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
            withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for React to render the dropdown
            // 4. EXACT TEXT MATCH LOGIC
            List<WebElement> allOptions = getDriver().findElements(By.xpath("//li[@role='option'] | //div[@role='presentation']//li"));
            WebElement exactMatchOption = null;

            for (WebElement opt : allOptions) {
                String visibleText = opt.getText().replaceAll("\\n", " ").trim();
                if (visibleText.equalsIgnoreCase(value)) {
                    exactMatchOption = opt;
                    log.info("Found EXACT dropdown match for: " + visibleText);
                    break;
                }
            }

            // 5. Click the Exact Match
            if (exactMatchOption != null) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", exactMatchOption);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                // Prioritize clicking the actual checkbox inside the option, otherwise click the row
                List<WebElement> checkboxes = exactMatchOption.findElements(By.xpath(".//input[@type='checkbox'] | .//*[contains(@class,'MuiCheckbox-root')] | .//*[local-name()='svg']"));
                if (!checkboxes.isEmpty()) {
                    try {
                        checkboxes.get(0).click();
                    } catch (Exception e) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkboxes.get(0));
                    }
                } else {
                    try {
                        exactMatchOption.click();
                    } catch (Exception e) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", exactMatchOption);
                    }
                }
            } else {
                log.warn("Exact match not found. Falling back to ARROW_DOWN + ENTER for text input fields.");
                filterInput.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            }

            withAction().pause(Duration.ofSeconds(1)).build().perform();

            // 6. Close the dropdown safely
            boolean closedViaButton = false;
            try {
                List<WebElement> closeBtns = getDriver().findElements(By.xpath("//button[@title='Close']"));
                for (WebElement cb : closeBtns) {
                    if (cb.isDisplayed()) {
                        cb.click();
                        closedViaButton = true;
                        break;
                    }
                }
            } catch (Exception ignored) {}

            if (!closedViaButton) {
                try {
                    withAction().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
                } catch (Exception ignored) {}
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();

        } catch (Exception e) {
            log.error("Failed to filter column '{}'. Error: {}", columnName, e.getMessage());
            org.junit.Assert.fail("Failed to apply filter on Document listing screen.");
        }
    }
}

    public void verifyCrossOrgDownloadVisibility(DataTable entities) {
        List<Map<String, String>> data = entities.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        String columnName = "PB-1 Legal Entity Name";

        for (Map<String, String> row : data) {
            String entityName = row.get("Legal Entity Name");
            log.info("Verifying Download visibility for Legal Entity: {}", entityName);
            try {
                String headerXPath = "//th[contains(., '" + columnName + "')]";
                WebElement headerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(headerXPath)));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", headerElement);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                String inputXPath = headerXPath + "//input";
                WebElement filterInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputXPath)));

                // 3. CLEAR PREVIOUS SELECTIONS (Click 'x' on the chip if it exists)
                String clearChipXPath = headerXPath + "//*[local-name()='svg' and (@data-testid='CloseIcon' or contains(@class, 'clear'))]";
                List<WebElementFacade> clearChips = findAll(By.xpath(clearChipXPath));
                if (!clearChips.isEmpty() && clearChips.get(0).isCurrentlyVisible()) {
                    log.info("Clearing previous selection in {}", columnName);
                    try {
                        clearChips.get(0).click();
                    } catch(Exception e) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", clearChips.get(0));
                    }
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
                try {
                    filterInput.click();
                } catch (Exception clickEx) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", filterInput); // JS fallback click
                }
                filterInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE); // Clear text
                filterInput.sendKeys(entityName);
                filterInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE); // React wake-up
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // wait for dropdown

                // 5. SELECT CHECKBOX OPTION
                String optionXPath = "//li[@role='option' and contains(., '" + entityName + "')]";
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath)));
                option.click();

                // 6. CLOSE DROPDOWN & WAIT FOR TABLE TO FILTER
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
                withAction().pause(Duration.ofSeconds(4)).build().perform();

                // 7. VERIFY RECORDS & DOWNLOAD ICON
                List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
                boolean hasValidRecords = false;
                boolean hasDownloadIcon = false;

                for (WebElementFacade tableRow : tableRows) {
                    if (tableRow.isCurrentlyVisible() && !tableRow.getText().toLowerCase().contains("no record")) {
                        hasValidRecords = true;

                        // Scroll to the far right to ensure the "Action" column is in view before verifying
                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'end' });", tableRow);

                        // Look for an action button/SVG in the final "Action" column
                        String actionColXPath = ".//td[last()]//button";
                        if (!tableRow.findElements(By.xpath(actionColXPath)).isEmpty()) {
                            hasDownloadIcon = true;
                        }
                        break; // We only need to verify the first valid row has the icon
                    }
                }

                // 8. ASSERTIONS
                if (!hasValidRecords) {
                    org.junit.Assert.fail("DOWNLOAD Validation Failed: No 'Enforced' documents found for '" + entityName + "'.");
                }
                if (!hasDownloadIcon) {
                    org.junit.Assert.fail("DOWNLOAD Validation Failed: Documents found for '" + entityName + "', but no Action/Download icon is visible!");
                }

                log.info("Validation Passed: Download capability successfully verified for '{}'.", entityName);

            } catch (Exception e) {
                log.error("Failed during cross-org download validation for '{}'. Error: {}", entityName, e.getMessage());
                org.junit.Assert.fail("Failed to search or validate download visibility for: " + entityName);
            }
        }
    }

    public void verifyCrossOrgDownloadVisibilityNew(DataTable entities) {
        List<Map<String, String>> data = entities.asMaps(String.class, String.class);
        String columnName = "PB-1 Legal Entity Name";

        for (Map<String, String> row : data) {
            String entityName = row.get("Legal Entity Name");
            String currentAction = "Initializing"; // Tracks exact point of failure
            log.info("--- Starting Download visibility check for: {} ---", entityName);

            try {
                // 1. LOCATE AND SCROLL THE COLUMN HEADER INTO VIEW
                currentAction = "Locating column header: " + columnName;
                String headerXPath = "//th[contains(., '" + columnName + "')] | //span[contains(text(), '" + columnName + "')]/ancestor::th";
                WebElementFacade headerElement = $(By.xpath(headerXPath)).waitUntilPresent();

                // Force horizontal scroll to bring the column into the center of the viewport
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", headerElement);
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                // 2. CLEAR PREVIOUS SELECTIONS (Click 'x' on the chip if it exists)
                currentAction = "Checking for existing selected chips to clear";
                String clearChipXPath = headerXPath + "//*[local-name()='svg' and (@data-testid='CancelIcon' or contains(@class, 'clear'))]";
                List<WebElementFacade> clearChips = findAll(By.xpath(clearChipXPath));

                if (!clearChips.isEmpty() && clearChips.get(0).isCurrentlyVisible()) {
                    currentAction = "Clicking the 'x' to clear the previous organization";
                    log.info("Clearing previous selection...");
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", clearChips.get(0)); // JS Click bypasses intercept errors
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }

                // 3. FIND INPUT AND TYPE
                currentAction = "Locating the input search field inside the column header";
                WebElementFacade filterInput = $(By.xpath(headerXPath + "//input")).waitUntilPresent();

                currentAction = "Clicking and clearing the input field";
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", filterInput);
                filterInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                currentAction = "Typing the Legal Entity name: " + entityName;
                filterInput.sendKeys(entityName);
                filterInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE); // React wake-up trick
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for API

                // 4. SELECT CHECKBOX OPTION
                currentAction = "Selecting the target organization from the dropdown popper";
                String optionXPath = "//li[@role='option' and contains(., '" + entityName + "')] | //div[@role='presentation']//li[contains(., '" + entityName + "')]";
                WebElementFacade option = $(By.xpath(optionXPath)).waitUntilVisible().waitUntilClickable();
                option.click();

                // 5. CLOSE DROPDOWN & WAIT FOR TABLE TO FILTER
                currentAction = "Closing dropdown and waiting for table to filter";
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
                withAction().pause(Duration.ofSeconds(4)).build().perform();

                // 6. VERIFY RECORDS & DOWNLOAD ICON
                currentAction = "Verifying the resulting table rows and Action icons";
                List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
                boolean hasValidRecords = false;
                boolean hasDownloadIcon = false;

                for (WebElementFacade tableRow : tableRows) {
                    if (tableRow.isCurrentlyVisible() && !tableRow.getText().toLowerCase().contains("no record")) {
                        hasValidRecords = true;

                        // Scroll to the far right to ensure the "Action" column is in view before verifying
                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'end' });", tableRow);

                        // Look for an action button/SVG in the final "Action" column
                        String actionColXPath = ".//td[last()]//button | .//td[last()]//a | .//td[last()]//*[local-name()='svg']";
                        if (!tableRow.findElements(By.xpath(actionColXPath)).isEmpty()) {
                            hasDownloadIcon = true;
                        }
                        break; // We only need to verify the first valid row has the icon
                    }
                }

                // 7. FINAL ASSERTIONS
                if (!hasValidRecords) {
                    org.junit.Assert.fail("DOWNLOAD Validation Failed: No 'Enforced' documents found for '" + entityName + "'.");
                }
                if (!hasDownloadIcon) {
                    org.junit.Assert.fail("DOWNLOAD Validation Failed: Documents found for '" + entityName + "', but no Action/Download icon is visible!");
                }

                log.info("Validation Passed: Download capability successfully verified for '{}'.", entityName);

            } catch (Exception e) {
                // If it fails, it will now tell you the EXACT action that caused the crash!
                log.error("Failed during action: '{}' for entity '{}'. Exact Error: {}", currentAction, entityName, e.getMessage());
                org.junit.Assert.fail("Failed during: " + currentAction + " | Entity: " + entityName);
            }
        }
    }

    public void verifyViewAndDownloadForOrganisations(List<Map<String, String>> orgData) {
        Assert.assertFalse("Document table is empty.", documentTableRows.isEmpty());

        // 1. Verify specific organizations from the data table are present
        for (Map<String, String> rowData : orgData) {
            String expectedOrg = rowData.get("Legal Entity Name");
            boolean found = documentTableRows.stream().anyMatch(r -> r.getTextContent().contains(expectedOrg));
            Assert.assertTrue("Organization '" + expectedOrg + "' not found in the table.", found);
        }

        // 2. Count valid documents and download them
        int expectedDownloadCount = 0;
        long startTime = System.currentTimeMillis();

        log.info("Starting download of all documents on the screen...");

        for (WebElementFacade row : documentTableRows) {
            // Filter out empty rows or "no record" rows
            if (row.isCurrentlyVisible() && !row.getText().toLowerCase().contains("no record")) {
                // The XPath targets both button and icon variants for the download action
                WebElementFacade downloadBtn = row.findBy(By.xpath(".//button[@data-testid='download-btn'] | .//*[local-name()='svg' and @data-testid='DownloadIcon'] | .//button[contains(@class,'download-container')]"));
                if (downloadBtn.isPresent() && downloadBtn.isCurrentlyVisible()) {
                    // Scroll the download button into view to ensure it's clickable
                    getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'end' });", downloadBtn);
                    downloadBtn.waitUntilClickable().click();
                    expectedDownloadCount++;
                    // Short pause to ensure the browser handles multiple download triggers correctly
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                } else {
                    log.warn("Download button not found or not visible for row: {}", row.getText().substring(0, Math.min(row.getText().length(), 50)));
                }
            }
        }

        Assert.assertTrue("No documents were found to download!", expectedDownloadCount > 0);
        log.info("Successfully triggered {} downloads.", expectedDownloadCount);

        // 3. Verify the count of downloaded files in the Downloads folder
        verifyFilesOnDisk(startTime, expectedDownloadCount);
    }

    private void verifyFilesOnDisk(long startTime, int expectedCount) {
        String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
        File dir = new File(downloadPath);

        // Polling to wait for all downloads to finish
        int timeoutSeconds = 30;
        int actualCount = 0;

        log.info("Verifying {} files in Downloads folder: {}", expectedCount, downloadPath);

        for (int i = 0; i < timeoutSeconds; i++) {
            File[] files = dir.listFiles();
            actualCount = 0;
            if (files != null) {
                for (File file : files) {
                    // Check if file was modified after we started the download
                    // and ignore temporary/partial download files
                    if (file.lastModified() >= startTime &&
                            !file.getName().endsWith(".crdownload") &&
                            !file.getName().endsWith(".tmp")) {
                        actualCount++;
                    }
                }
            }

            if (actualCount >= expectedCount) {
                break;
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }

        log.info("Actual files found on disk: {}", actualCount);
        Assert.assertEquals("The count of downloaded documents does not match the count on the screen!", expectedCount, actualCount);
    }

    private void selectFromSearchableDropdown(WebElementFacade inputField, String value) {
        inputField.click();
        inputField.clear();
        inputField.sendKeys(value);

        // Wait for the result to appear and click the specific option matching the text
        // This targets the dropdown option that appears after typing
        String optionXpath = String.format("//div[contains(@class,'option')]//span[text()='%s'] | //li[text()='%s']", value, value);

        WebElementFacade option = element(By.xpath(optionXpath));

        if(option.isVisible()) {
            option.click();
        } else {
            // Fallback: If standard click fails, use JavaScript click
            evaluateJavascript("arguments[0].click();", option);
        }
    }

    public void configureUserMappings(List<Map<String, String>> data) {
        Map<String, String> mapping = data.get(0);

        // 1. Select Doc Type
        selectFromSearchableDropdown(docTypeInput, mapping.get("Doc Type"));

        // 2. Select LEI
        selectFromSearchableDropdown(leiInput, mapping.get("LEI"));

        // 3. Select Org Type
        selectFromSearchableDropdown(orgTypeInput, mapping.get("Org type"));

        // 4. Click the Add button
        Assert.assertTrue("Add button is not enabled after selections!", addButton.isEnabled());
        addButton.click();
    }

}