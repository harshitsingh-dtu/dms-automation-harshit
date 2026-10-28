package PageObjects.Currency;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.fail;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
@Slf4j
@Data
public class CurrencygroupPageObject extends PageObject {
    Actions act = new Actions(getDriver());

    @FindBy(xpath = "//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade navigation_btn;

    @FindBy(xpath = "//a[@data-testid='submenu-link-Currencies groups']")
    private WebElementFacade currencygrp_btn;//button[text()='Currencies groups']
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupstemplate_btn;

    @FindBy(xpath = "//div[@class='content-header']//p")
    private WebElementFacade currencygrp_text;

    @FindBy(xpath = "//div[@class='content-header']//p")
    private WebElementFacade currencyPairgrp_text;

    @FindBy(xpath = "//button[text()='Currencies-pair groups']")
    private WebElementFacade currencyPairgrp_tab;

    @FindBy(xpath = "//input[@placeholder='Search by currencies group name']")
    private WebElementFacade search;
    @FindBy(xpath = "//input[@placeholder='Search by currencies-pair group name']")
    private WebElementFacade currenciespairsearch;
    @FindBy(xpath = "(//button[text()='Update'])")//button[text()='Update']
    private WebElementFacade update_btn;//button[text()='Update'][1]

    @FindBy(xpath = "//button[text()='+ Create New Group']")
    private WebElementFacade createnewgroup_btn;

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationFilter;

    @FindBy(xpath = "//input[@placeholder='Search by currencies group name']")
    private WebElementFacade SearchBar;

    @FindBy(xpath = "//div[@class='cross-icon delete']")
    private WebElementFacade delete_btn;

    @FindBy(xpath = "//th[1]")
    private WebElementFacade currencygrpname_col;

    @FindBy(xpath = "//th//div[text()='Organisations']")
    private WebElementFacade organization_col;

    @FindBy(xpath = "//th//div[text()='Created on']")
    private WebElementFacade createdOn_col;

    @FindBy(xpath = "//th//div[text()='Action']")
    private WebElementFacade action_col;

    @FindBy(xpath = "//tbody//tr[1]//td[1]")
    private WebElementFacade searchedCurrency;

    @FindBy(xpath = "//td//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_txt;

    @FindBy(xpath = "//table[@class=\"csm_standard_table undefined\"]//tbody//tr//td[1]")
    private WebElementFacade searchedresult_grpname;

    @FindBy(xpath = "//input[@id = 'select-all-checkbox-id-Deliverable']")
    private WebElementFacade selectAll_Deliverable;


    public void Selectallcurrency() {
        selectAll_Deliverable.waitUntilPresent();
        selectAll_Deliverable.waitUntilClickable().click();
    }

    public void navigateToCurrencyscreen() {
        try {
            navigation_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilClickable().click();
            groupstemplate_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            if (currencygrp_btn.isVisible()) {
                currencygrp_btn.waitUntilClickable().click();
            } else {
                groupstemplate_btn.waitUntilClickable().click();
                currencygrp_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
            }
        } catch (Exception e) {
            log.error("Failed to navigate to Currency screen: " + e.getMessage());
            Assert.fail("Navigation to Currency screen failed: " + e.getMessage());
        }

    }

    public void navigateToCurrencyscreenAgain() {
        try {
            navigation_btn.waitUntilVisible();
            navigation_btn.click();
//            groupstemplate_btn.waitUntilVisible();
//            groupstemplate_btn.click();
            currencygrp_btn.waitUntilClickable();
            currencygrp_btn.click();
        } catch (Exception e) {
            log.error("Not able to navigate to the currency screen");
            Assert.fail();
        }

    }


    public void checkifonCurrencygrpscreen() {
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            currencygrp_text.waitUntilVisible();
            Assert.assertEquals("Currencies groups", currencygrp_text.getText().trim());
        } catch (AssertionError e) {
            log.error("Not able to check whether on the currency screen");
            Assert.fail();
        }

    }

    public void navigatetoCurrencyPairgroupscreenAlone() {
        currencyPairgrp_tab.waitUntilClickable();
        currencyPairgrp_tab.click();
    }

    public void navigatetoCurrencyPairgroupscreen() {
        try {
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            currencyPairgrp_tab.waitUntilClickable();
            currencyPairgrp_tab.click();
            currencyPairgrp_text.waitUntilVisible();
            Assert.assertEquals("Currencies-pair groups", currencyPairgrp_text.getText().trim());
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Not able to check whether on the currency-pair groups screen");
            getDriver().close();
        }

    }

    public void searchCurrencygroup(List<String> currency_group) {
        search.waitUntilPresent();
        search.type(currency_group.get(1));
        withAction().pause(Duration.ofSeconds(6)).build().perform();
    }

    public void mapCurrencygroup() {
        if (searchedCurrency.isVisible()) {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            delete_btn.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            log.info("Successfully Deleted the currency group");
        } else {
            log.error("Searched Currency not available");
        }
    }

    public void mapCurrencypairgroup() {
        if (searchedCurrency.isPresent()) {
            withAction().pause(Duration.ofSeconds(10)).build().perform();
            delete_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            log.info("Successfully Deleted the currency pair group");
        } else {
            log.error("Searched Currency not available");
        }
    }

    public void searchCurrencyPairgroup(List<String> name) {

        currenciespairsearch.waitUntilVisible();
        currenciespairsearch.type(name.get(1)).waitUntilVisible();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }

    public void navigateToCurrencygroupUpdatescreen() {
        update_btn.waitUntilClickable();
        update_btn.click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void checkifCreatenewbtn() {
        Assert.assertTrue(createnewgroup_btn.isVisible());
    }

    public void checkiforganizationfilter() {
        Assert.assertTrue(organizationFilter.isVisible());
    }

    public void checkifSearchBar() {
        Assert.assertTrue(SearchBar.isVisible());
    }
    public void checkifCurrencies_pair_group_SearchBar() {
        Assert.assertTrue(currenciespairsearch.isVisible());
    }

    public void checkifcolumns() {
        Assert.assertTrue(currencygrpname_col.isVisible());
        try {
            currencygrpname_col.getText().equalsIgnoreCase("Currencies group name");
        } catch (Exception e) {
            Assert.assertEquals("Currencies Pair group name", currencygrpname_col.getText());
        }
        Assert.assertTrue(organization_col.isVisible());
        Assert.assertTrue(createdOn_col.isVisible());
        Assert.assertTrue(action_col.isVisible());
    }

    public void checkifdeletebtn() {
        if (delete_btn.isPresent()) {
            //
        } else {
            Assert.assertTrue(noRecordFound_txt.isVisible());
        }


    }


    public void searchAndDeleteCurrencyGroup(List<String> currency_group) {
        try {
            searchCurrencygroup(currency_group);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            String txt = searchedCurrency.getText();
            if (txt.equalsIgnoreCase(currency_group.get(1).trim())) {
                delete_btn.waitUntilClickable();
                delete_btn.click();
                withAction().pause(Duration.ofSeconds(5)).build().perform();
            }
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        } catch (Exception e) {
            log.error("Not able to delete the existing currency");
        }

    }

    public void clickCurrencyGroupSearch_bar(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            search.waitUntilVisible().click();
            search.clear();
            typeInto(search, dataTable.get("Currency group"));
            act.pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to type-->" + e);
            Assert.fail();
        }
    }

    public boolean checkCurrencyResult() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        return !noRecordFound_txt.isVisible();

    }

    public void validateCurrencyGroupNameMaxLength() {
        WebElementFacade groupNameInput = find(By.xpath("//input[@placeholder=\"Enter currencies group name\"]"));
        groupNameInput.waitUntilVisible();
        groupNameInput.clear();
        groupNameInput.sendKeys(RandomStringUtils.randomAlphabetic(51));
        int actualLength = groupNameInput.getValue().length();
        if (actualLength > 50) {
            throw new AssertionError("Currency group name field accepts more than 50 characters.");
        } else {
            log.info("Currency group name field correctly restricts input to 50 characters.");
        }
    }

    public void verifyCurrencyCrossOrgVisibility(DataTable entities) {
        List<Map<String, String>> data = entities.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        for (Map<String, String> row : data) {
            String orgName = row.get("Organisation Name");
            log.info("Verifying VIEW_ALL cross-org visibility for Organisation: {}", orgName);
            try {
                String filterBoxXPath = "//input[contains(@placeholder, 'Organisation')]";
                WebElement filterBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterBoxXPath)));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", filterBox);
                try {
                    filterBox.click();
                } catch (Exception clickErr) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", filterBox);
                }
                withAction().pause(Duration.ofMillis(500)).build().perform();
                filterBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                filterBox.sendKeys(orgName);
                filterBox.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String dropdownOptionXPath = "//li[@role='option' and contains(., '" + orgName + "')]";
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownOptionXPath)));
                option.click();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
                boolean hasValidRecords = false;
                for (WebElementFacade tableRow : tableRows) {
                    if (tableRow.isCurrentlyVisible() && !tableRow.getText().toLowerCase().contains("no record")) {
                        hasValidRecords = true;
                        break;
                    }
                }
                if (!hasValidRecords) {
                    org.junit.Assert.fail("VIEW_ALL Validation Failed: The table was empty when searching for Organisation '" + orgName + "'. Secondary user might lack cross-org permissions.");
                } else {
                    log.info("Validation Passed: Data successfully populated for '{}'.", orgName);
                }
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
            } catch (Exception e) {
                log.error("Failed during cross-org validation for '{}'. Error: {}", orgName, e.getMessage());
                org.junit.Assert.fail("Failed to search or validate visibility for Organisation: " + orgName);
            }
        }
    }

    public void verifyDocTemplateCrossOrgVisibility(DataTable entities) {
        List<Map<String, String>> data = entities.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        for (Map<String, String> row : data) {
            String orgName = row.get("Organisation Name");
            try {
                String filterBoxXPath = "//input[contains(@placeholder, 'Organisation')]";
                WebElement filterBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterBoxXPath)));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", filterBox);
                try {
                    filterBox.click();
                } catch (Exception clickErr) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", filterBox);
                }
                withAction().pause(Duration.ofMillis(500)).build().perform();
                filterBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                filterBox.sendKeys(orgName);
                filterBox.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String dropdownOptionXPath = "//li[@role='option' and contains(., '" + orgName + "')]";
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownOptionXPath)));
                option.click();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
                boolean hasValidRecords = false;
                for (WebElementFacade tableRow : tableRows) {
                    if (tableRow.isCurrentlyVisible() && !tableRow.getText().toLowerCase().contains("no record")) {
                        hasValidRecords = true;
                        break;
                    }
                }
                if (!hasValidRecords) {
                    org.junit.Assert.fail("VIEW_ALL Validation Failed: The table was empty when searching for Organisation '" + orgName + "'. Secondary user might lack cross-org permissions.");
                } else {
                    log.info("Validation Passed: Data successfully populated for '{}'.", orgName);
                }
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
            } catch (Exception e) {
                log.error("Failed during cross-org validation for '{}'. Error: {}", orgName, e.getMessage());
                org.junit.Assert.fail("Failed to search or validate visibility for Organisation: " + orgName);
            }
        }
    }

//    public void createAndUpdateCurrencyGroups(DataTable table) {
//        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
//            String uniqueName = row.get("Currency Group Name") + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);
//            log.info("--- Starting Create & Update lifecycle for Currency Group: {} ---", uniqueName);
//            try {
//                $("//button[contains(., 'Create New Group')]").waitUntilClickable().click();
//                $("//input[contains(@placeholder, 'Enter currencies group name')]").waitUntilVisible().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName);
//                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')]").waitUntilPresent());
//                $("//input[contains(@placeholder, 'Select Organisation')]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, row.get("Organisation Name"), Keys.SPACE, Keys.BACK_SPACE);
//                $("//li[@role='option' and contains(., '" + row.get("Organisation Name") + "')]").waitUntilClickable().click();
//                evaluateJavascript("arguments[0].click();", $("//*[contains(@class, 'currency') or @role='button'][text()='" + row.get("Currency") + "'] | //span[text()='" + row.get("Currency") + "']").waitUntilClickable());
//                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit')]").waitUntilClickable());
//                $("//input[contains(@placeholder, 'Search by currencies group name')]").waitUntilVisible().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName, Keys.RETURN);
//                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + uniqueName + "')]//button[contains(., 'Update')]").waitUntilClickable());
//                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update')]").waitUntilClickable());
//            } catch (Exception e) {
//                log.error("Lifecycle failed for group '{}'. Error: {}", uniqueName, e.getMessage());
//                fail("Create/Update lifecycle failed for Group: " + uniqueName + " with error: " + e.getMessage());
//            }
//        }
//    }
//
//    public void createAndUpdateCurrencyPairGroups(DataTable table) {
//        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
//            String uniqueName = row.get("Currency Pair Group Name") + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);
//            log.info("--- Starting Create & Update lifecycle for Currency Pair Group: {} ---", uniqueName);
//            try {
//                $("//button[contains(., 'Create New Group')]").waitUntilClickable().click();
//                $("//input[contains(@placeholder, 'Enter currencies group name')]").waitUntilVisible().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName);
//                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')]").waitUntilPresent());
//                $("//input[contains(@placeholder, 'Select Organisation')]")
//                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, row.get("Organisation Name"), Keys.SPACE, Keys.BACK_SPACE);
//                $("//li[@role='option' and contains(., '" + row.get("Organisation Name") + "')]").waitUntilClickable().click();
//                evaluateJavascript("arguments[0].click();", $("//*[contains(text(), '" + row.get("Currency Pair") + "')]").waitUntilClickable());
//                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit')]").waitUntilClickable());
//                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").waitUntilVisible().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName, Keys.RETURN);
//                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + uniqueName + "')]//button[contains(., 'Update')]").waitUntilClickable());
//                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update')]").waitUntilClickable());
//            } catch (Exception e) {
//                log.error("Lifecycle failed for pair group '{}'. Error: {}", uniqueName, e.getMessage());
//                fail("Create/Update lifecycle failed for Pair Group: " + uniqueName + " with error: " + e.getMessage());
//            }
//        }
//    }

    public void createAndUpdateCurrencyGroups(DataTable table) {
        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
            String uniqueName = row.get("Currency Group Name") + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);
            log.info("--- Starting Create & Update lifecycle for Currency Group: {} ---", uniqueName);

            try {
                // Click Create
                $("//button[contains(., 'Create New Group')]").waitUntilClickable().click();

                // Clear and Enter Name
                $("//input[contains(@placeholder, 'Enter currencies group name')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName);

                // Select Organisation
                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')]").waitUntilPresent());
                $("//input[contains(@placeholder, 'Select Organisation')]")
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, row.get("Organisation Name"), Keys.SPACE, Keys.BACK_SPACE);
                $("//li[@role='option' and contains(., '" + row.get("Organisation Name") + "')]").waitUntilClickable().click();

                // Select Currency
                evaluateJavascript("arguments[0].click();", $("//*[contains(@class, 'currency') or @role='button'][text()='" + row.get("Currency") + "'] | //span[text()='" + row.get("Currency") + "']").waitUntilClickable());

                // Submit Create
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for redirect to finish

                // React-Safe Search: Clear -> Type -> Wait for Debounce -> Press Return
                $("//input[contains(@placeholder, 'Search by currencies group name')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                $("//input[contains(@placeholder, 'Search by currencies group name')]").sendKeys(uniqueName);

                withAction().pause(Duration.ofSeconds(1)).build().perform(); // Crucial pause for React
                $("//input[contains(@placeholder, 'Search by currencies group name')]").sendKeys(Keys.RETURN);

                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for skeleton loaders to disappear

                // Click Update on the resulting record
                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + uniqueName + "')]//button[contains(., 'Update')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                // Submit the Update
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(3)).build().perform();

            } catch (Exception e) {
                log.error("Lifecycle failed for group '{}'. Error: {}", uniqueName, e.getMessage());
                org.assertj.core.api.Assertions.fail("Create/Update lifecycle failed for Group: " + uniqueName + " with error: " + e.getMessage());
            }
        }
    }

    // 2. Optimized Method for Currency Pair Groups
//    public void createAndUpdateCurrencyPairGroups(DataTable table) {
//        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
//            String uniqueName = row.get("Currency Pair Group Name") + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);
//            log.info("--- Starting Create & Update lifecycle for Currency Pair Group: {} ---", uniqueName);
//
//            try {
//                // Click Create
//                $("//button[contains(., 'Create New Group')]").waitUntilClickable().click();
//
//                // Clear and Enter Name
//                $("//input[contains(@placeholder, 'Enter currencies group name')]").waitUntilVisible()
//                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName);
//
//                // Select Organisation
//                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')]").waitUntilPresent());
//                $("//input[contains(@placeholder, 'Select Organisation')]")
//                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, row.get("Organisation Name"), Keys.SPACE, Keys.BACK_SPACE);
//                $("//li[@role='option' and contains(., '" + row.get("Organisation Name") + "')]").waitUntilClickable().click();
//
//                // Select Currency Pair
//                evaluateJavascript("arguments[0].click();", $("//*[contains(text(), '" + row.get("Currency Pair") + "')]").waitUntilClickable());
//
//                // Submit Create
//                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit')]").waitUntilClickable());
//                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for redirect to finish
//
//                // NEW: Switch back to the Currency-Pair Group Tab
//                evaluateJavascript("arguments[0].click();", $("//*[contains(text(), 'Currencies-Pair Group')]").waitUntilClickable());
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//
//                // React-Safe Search
//                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").waitUntilVisible()
//                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
//                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").sendKeys(uniqueName);
//
//                withAction().pause(Duration.ofSeconds(1)).build().perform(); // Crucial pause for React
//                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").sendKeys(Keys.RETURN);
//
//                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for skeleton loaders to disappear
//
//                // Click Update on the resulting record
//                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + uniqueName + "')]//button[contains(., 'Update')]").waitUntilClickable());
//                withAction().pause(Duration.ofSeconds(1)).build().perform();
//
//                // Submit the Update
//                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update')]").waitUntilClickable());
//                withAction().pause(Duration.ofSeconds(3)).build().perform();
//
//            } catch (Exception e) {
//                log.error("Lifecycle failed for pair group '{}'. Error: {}", uniqueName, e.getMessage());
//                org.assertj.core.api.Assertions.fail("Create/Update lifecycle failed for Pair Group: " + uniqueName + " with error: " + e.getMessage());
//            }
//        }

    public void createAndUpdateCurrencyPairGroups(DataTable table) {
        // Strict locator ensuring it only clicks the exact tab text, not the page header
        String pairTabXPath = "//*[text()='Currencies-Pair Group'] | //div[@role='tab' and contains(., 'Pair')]";

        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
            String uniqueName = row.get("Currency Pair Group Name") + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);
            log.info("--- Starting Create & Update lifecycle for Currency Pair Group: {} ---", uniqueName);

            try {
                // Click Create
                $("//button[contains(., 'Create New Group')]").waitUntilClickable().click();

//                // Select 'Currencies Pair Group' Radio Button
//                evaluateJavascript("arguments[0].click();", $("//label[contains(., 'Currencies Pair Group')]//input | //input[@type='radio' and contains(@value, 'Pair')]").waitUntilPresent());

                // Clear and Enter Name
                $("//input[contains(@placeholder, 'Enter currencies group name')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName);

                // Select Organisation
                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')]").waitUntilPresent());
                $("//input[contains(@placeholder, 'Select Organisation')]")
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, row.get("Organisation Name"), Keys.SPACE, Keys.BACK_SPACE);
                $("//li[@role='option' and contains(., '" + row.get("Organisation Name") + "')]").waitUntilClickable().click();

                // Select Currency Pair Checkbox
                evaluateJavascript("arguments[0].click();", $("//*[contains(text(), '" + row.get("Currency Pair") + "')]").waitUntilClickable());

                // Submit Create
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit')]").waitUntilClickable());

                // CRITICAL FIX 1: Wait for the success toast so we know the page reload has stabilized!
                $("//*[contains(text(), 'Records created successfully') or contains(text(), 'successfully')]").waitUntilVisible();
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // CRITICAL FIX 2: Switch to the Pair Tab
                evaluateJavascript("arguments[0].click();", $(By.xpath(pairTabXPath)).waitUntilClickable());
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // React-Safe Search
                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").sendKeys(uniqueName);

                withAction().pause(Duration.ofSeconds(1)).build().perform(); // Debounce pause
                $("//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search by pair')]").sendKeys(Keys.RETURN);
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for table to filter

                // Click Update on the resulting record
                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + uniqueName + "')]//button[contains(., 'Update')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                // Submit the Update
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update')]").waitUntilClickable());

                // Wait for the update success toast
                $("//*[contains(text(), 'updated successfully') or contains(text(), 'successfully')]").waitUntilVisible();
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // CRITICAL FIX 3: Switch back to the Pair Tab AGAIN so the NEXT loop starts on the correct screen
                evaluateJavascript("arguments[0].click();", $(By.xpath(pairTabXPath)).waitUntilClickable());
                withAction().pause(Duration.ofSeconds(1)).build().perform();

            } catch (Exception e) {
                log.error("Lifecycle failed for pair group '{}'. Error: {}", uniqueName, e.getMessage());
                // Fully PR Compliant AssertJ failure
                fail("Create/Update lifecycle failed for Pair Group: " + uniqueName + " with error: " + e.getMessage());
            }
        }
    }


}