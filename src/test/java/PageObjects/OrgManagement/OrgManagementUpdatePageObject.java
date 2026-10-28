package PageObjects.OrgManagement;

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
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class OrgManagementUpdatePageObject extends PageObject {
    Actions act = new Actions(getDriver());
    String[] organizationinfo = {"Organisation id", "Organisation name", "Active users", "Total users", "Address"};

    @FindBy(xpath = "//button[text()='Update']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade update_btn;

    @FindBy(xpath = "//div[@data-testid='info-header-name']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade organizationinformation_txt;

    @FindBy(xpath = "//div[contains(@class,'lei-label')]")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade leiorgtypestatus_txt;

    @FindBy(xpath = "//input[contains(@placeholder,'Search by LEI')]")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade searchbar;

    @FindBy(xpath = "//div[@data-testid='info-header-label-organisationId']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade orgnaizationid_col;

    @FindBy(xpath = "//div[@data-testid='info-header-value-organisationId']")
    private WebElementFacade organizationid;


    @FindBy(xpath = "//div[@data-testid='info-header-label-name']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade organizationname_col;

    @FindBy(xpath = "//div[@data-testid='info-header-value-name']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade organizationname;

    @FindBy(xpath = "//div[@data-testid='info-header-label-activeUsers']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade activeusers_col;

    @FindBy(xpath = "//div[@data-testid='info-header-value-activeUsers']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade activeusers;

    @FindBy(xpath = "//div[@data-testid='info-header-label-totalUsers']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade totalusers_col;

    @FindBy(xpath = "//div[@data-testid='info-header-value-totalUsers']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade totalusers;

    @FindBy(xpath = "//button[@data-testid='cancel-button']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade cancelbtn;

    @FindBy(xpath = "//button[@data-testid='submit-button']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade submitbtn;

    @FindBy(xpath = "//div[@class='enable-switch ']//span")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade togglebtn;

    @FindBy(xpath = "//th[text()='LEI']")
    private WebElementFacade leiid_col;

    @FindBy(xpath = "//th[text()='Name']")
    private WebElementFacade name_col;

    @FindBy(xpath = "//th[text()='Org type status']")
    private WebElementFacade orgtypestatus_col;

    @FindBy(xpath = "//td[6]//div[contains(@class,'enable-switch')]/label")
    private WebElementFacade PBtoggle_btn;

    @FindBy(xpath = "//td[7]//div[contains(@class,'enable-switch')]/label")
    private WebElementFacade EBtoggle_btn;

    @FindBy(xpath = "//td[8]//div[contains(@class,'enable-switch')]/label")
    private WebElementFacade Clienttoggle_btn;

    @FindBy(xpath = "//div[@role='dialog']//button[normalize-space()='Yes']")
    private WebElementFacade confirmation_popup_yes;
    
    @FindBy(xpath = "//div[@data-testid='doc-type-select']//input")
    private WebElementFacade doctype_filter;
    @FindBy(xpath = "//button[@title='Clear']")
    private WebElementFacade Clear_button;
    @FindBy(xpath = "(//button[normalize-space()='Online'])[1]")
    private WebElementFacade PB_Online;
    @FindBy(xpath = "(//button[normalize-space()='Lite'])[1]")
    private WebElementFacade PB_Lite;

    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade dropDownList;

    public void Selectdoctype(String docType) {
        try {
            doctype_filter.waitUntilVisible().clear();
            withAction().moveToElement(doctype_filter).click()
                .pause(Duration.ofSeconds(1))
                .sendKeys(docType)
                .build().perform();
            act.pause(Duration.ofSeconds(1)).build().perform();
            
            String dynamicXpath = "//li[contains(normalize-space(),'" + docType + "')]";
            WebElementFacade option = find(By.xpath(dynamicXpath));
            if (option.isPresent()) {
                evaluateJavascript("arguments[0].click();", option);
            } else {
                doctype_filter.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            }
            act.pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Not able to select doc type on update screen: " + docType + " - " + e);
            Assert.fail();
        }
    }

    public void checkifonupdatescreen() {
        try {
            Assert.assertTrue(organizationinformation_txt.isVisible());

        } catch (AssertionError e) {
            log.error("Not able to reach the update screen" + e);
            Assert.fail();
        }
    }

    public void checkifuserinfocol() {
        try {
            organizationname_col.shouldBePresent();
            organizationid.shouldBePresent();
            orgnaizationid_col.shouldBePresent();
            organizationname.shouldBePresent();
            activeusers_col.shouldBePresent();
            activeusers.shouldBePresent();
            totalusers_col.shouldBePresent();
            totalusers.shouldBePresent();
        } catch (Exception e) {
            log.error("Not all the column information is visible on the screen" + e);
            Assert.fail();
        }

    }

    public void checkifsearchbar() {
        try {
            searchbar.shouldBePresent();

        } catch (Exception e) {
            log.error("Search bar not visible on the screen" + e);
            Assert.fail();
        }
    }

    public void checkifLEIorgtypestatustable() {
        try {
            leiid_col.isVisible();
            name_col.isVisible();
            orgtypestatus_col.isVisible();
        } catch (Exception e) {
            log.error("Not able to see the Org status table" + e);
            Assert.fail();
        }

    }

    public void checkifcancelbtn() {
        cancelbtn.shouldBePresent();
    }

    public void checkifsubmitbtn() {
        submitbtn.isVisible();
    }

    public void clicksubmit_btn() {
        try {
            withAction().moveToElement(submitbtn).click().pause(Duration.ofSeconds(3)).build().perform();

        } catch (Exception e) {
            log.error("Not able to interact with submit button" + e);
            Assert.fail();
        }
    }

    public void searchleiOnUpdatescreen(List<String> lei) {
        try {
            searchbar.waitUntilClickable();
            searchbar.click();
            searchbar.type(lei.get(1));
            act.pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Not able to interact with search bar" + e);
            Assert.fail();
        }

    }

    public void changePBtoggle() {
        try {
            if (PBtoggle_btn.isVisible()) {
                withAction().moveToElement(PBtoggle_btn).click().pause(Duration.ofSeconds(4)).build().perform();
            }
            if (confirmation_popup_yes.isVisible()) {
                act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
            }
        } catch (Exception e) {
            log.error("Not able to interact with toggle button" + e);
            Assert.fail();
        }

    }

    public void changeEBtoggle() {
        try {
            if (EBtoggle_btn.isVisible()) {
                withAction().moveToElement(EBtoggle_btn).click().pause(Duration.ofSeconds(4)).build().perform();
            }
            if (confirmation_popup_yes.isVisible()) {
                act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
            }
        } catch (Exception e) {
            log.error("Not able to interact with toggle button" + e);
            Assert.fail();
        }
    }

    public void changeClienttoggle() {
        try {
            if (Clienttoggle_btn.isVisible()) {
                withAction().moveToElement(Clienttoggle_btn).click().pause(Duration.ofSeconds(4)).build().perform();
            }
            if (confirmation_popup_yes.isVisible()) {
                act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
            }
        } catch (Exception e) {
            log.error("Not able to interact with toggle button" + e);
            Assert.fail();
        }

    }

    public void changetogglestatus(List<String> orgtype) {
        try {
            switch (orgtype.get(1)) {
                case "PB":
                    PBtoggle_btn.waitUntilVisible();
                    PBtoggle_btn.click();
                    if (confirmation_popup_yes.isVisible()) {
                        act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
                    }
                    break;
                case "EB":
                    EBtoggle_btn.waitUntilVisible();
                    EBtoggle_btn.click();
                    if (confirmation_popup_yes.isVisible()) {
                        act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
                    }
                    break;
                case "Client":
                    Clienttoggle_btn.waitUntilVisible();
                    Clienttoggle_btn.click();
                    if (confirmation_popup_yes.isVisible()) {
                        act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
                    }
                    break;
            }
        } catch (Exception e) {
            log.error("Not able to interact with toggle button" + e);
            Assert.fail();
        }
    }

    public void changetoggle_onlinetolite(DataTable orgtype) {
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            switch (dataTable.get("Org type")) {
                case "PB":
                    PBtoggle_btn.waitUntilVisible();
                    if (PBtoggle_btn.getText().trim().equalsIgnoreCase("Online")) {
                        PBtoggle_btn.click();
                        act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
                        clicksubmit_btn();
                        break;
                    }
                    cancelbtn.click();
                    break;
                case "EB":
                    EBtoggle_btn.waitUntilVisible();
                    if (EBtoggle_btn.getText().trim().equalsIgnoreCase("Online")) {
                        EBtoggle_btn.click();
                        act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
                        clicksubmit_btn();
                        break;
                    }
                    cancelbtn.click();
                    break;
                case "Client":
                    Clienttoggle_btn.waitUntilVisible();
                    if (Clienttoggle_btn.getText().trim().equalsIgnoreCase("Online")) {
                        Clienttoggle_btn.click();
                        act.pause(Duration.ofSeconds(3)).moveToElement(confirmation_popup_yes).click().build().perform();
                        clicksubmit_btn();
                        break;
                    }
                    cancelbtn.click();
                    break;
            }

        } catch (Exception e) {
            log.error("Can't change the status -->" + e);
            Assert.fail();
        }
    }

    public void select_doctype_and_checkresult_indoctype_filter(List<String> list) {
        boolean skipFirst = true;
        for (String item : list) {
            if (skipFirst) {
                skipFirst = false;
                continue;
            }
            doctype_filter.waitUntilVisible().clear();
            withAction().moveToElement(doctype_filter).click()
                    .pause(Duration.ofSeconds(1))
                    .sendKeys(item)
                    .build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            
            String dynamicXpath = "//li[contains(normalize-space(),'" + item + "')]";
            WebElementFacade option = find(By.xpath(dynamicXpath));
            if (option.isPresent()) {
                evaluateJavascript("arguments[0].click();", option);
            } else {
                doctype_filter.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            }
            act.pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    public void changetoggle_litetoonline(DataTable orgtype) {
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String status;
        try {
            switch (dataTable.get("Org type")) {
                case "PB":
                    PBtoggle_btn.waitUntilVisible();
                    act.moveToElement(PBtoggle_btn).build().perform();
                    if (PBtoggle_btn.getText().trim().equalsIgnoreCase("Lite")) {
                        PBtoggle_btn.click();
                        clicksubmit_btn();
                        break;
                    }
                    cancelbtn.click();
                    break;
                case "EB":
                    EBtoggle_btn.waitUntilVisible();
                    act.moveToElement(EBtoggle_btn).build().perform();
                    if (EBtoggle_btn.getText().trim().equalsIgnoreCase("Lite")) {
                        EBtoggle_btn.click();
                        clicksubmit_btn();
                        break;
                    }
                    cancelbtn.click();
                    break;
                case "Client":
                    Clienttoggle_btn.waitUntilVisible();
                    act.moveToElement(Clienttoggle_btn).build().perform();
                    if (Clienttoggle_btn.getText().trim().equalsIgnoreCase("Lite")) {
                        Clienttoggle_btn.click();
                        clicksubmit_btn();
                        break;
                    }
                    cancelbtn.click();
                    break;
            }

        } catch (Exception e) {

        }
    }

//    public void searchAndVerifyEnabledStatus(String orgName) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        try {
//            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search by LEI's id or name\"]")));
//            withAction().moveToElement(searchBox).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).sendKeys(orgName).pause(Duration.ofMillis(500)).sendKeys(Keys.ENTER).build().perform();
//        } catch (Exception e) {
//            Assert.fail("Failed to interact with the Search Box.");
//        }
//        try {
//            String rowXpath = "//td[normalize-space()='" + orgName + "']/ancestor::tr";
//            WebElement resultRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rowXpath)));
//            List<WebElement> enabledStatuses = resultRow.findElements(By.xpath(".//*[normalize-space()='Enabled']"));
//            int enabledCount = enabledStatuses.size();
//            if (enabledCount < 2) {
//                String fullRowText = resultRow.getText();
//                Assert.fail("Test Failed: Expected 2 'Enabled' statuses (PB & EB) for '" + orgName +
//                        "', but found only " + enabledCount + ". Row content: " + fullRowText);
//            }
//        } catch (TimeoutException e) {
//            Assert.fail("Test Failed: No row found for organization '" + orgName + "' after searching.");
//        }
//    }

    public void searchAndVerifyEnabledStatus(String orgName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        int maxRetries = 3;
        boolean searchSuccess = false;

        try {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search by LEI's id or name\"]")));

            for (int i = 0; i < maxRetries; i++) {
                try {
                    searchBox.click();

                    if (i > 0) {
                        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", searchBox);
                    } else {
                        searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                        searchBox.sendKeys(Keys.BACK_SPACE);
                    }

                    searchBox.sendKeys(orgName);
                    Thread.sleep(1000);

                } catch (Exception e) {
                }

                String currentVal = searchBox.getAttribute("value");
                if (currentVal != null && currentVal.trim().equals(orgName.trim())) {
                    searchBox.sendKeys(Keys.ENTER);
                    searchSuccess = true;
                    break;
                }
            }

            if (!searchSuccess) {
                Assert.fail("Failed to enter correct organization name '" + orgName + "' after " + maxRetries + " attempts.");
            }

        } catch (Exception e) {
            Assert.fail("Failed to interact with the Search Box: " + e.getMessage());
        }

        int verifyAttempts = 0;
        while (verifyAttempts < 3) {
            try {
                WebElement firstResultRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]")));

                if (!firstResultRow.getText().contains(orgName)) {
                    Thread.sleep(1000);
                    verifyAttempts++;
                    continue;
                }

                List<WebElement> enabledStatuses = firstResultRow.findElements(By.xpath(".//*[normalize-space()='Enabled']"));
                int enabledCount = enabledStatuses.size();

                if (enabledCount < 2) {
                    if (verifyAttempts == 0) {
                        Thread.sleep(1000);
                        verifyAttempts++;
                        continue;
                    }
                    String fullRowText = firstResultRow.getText();
                    Assert.fail("Test Failed: Expected 2 'Enabled' statuses (PB & EB) for '" + orgName +
                            "', but found only " + enabledCount + ". Row content: " + fullRowText);
                }
                return;

            } catch (StaleElementReferenceException e) {
                verifyAttempts++;
            } catch (Exception e) {
                Assert.fail("An unexpected error occurred: " + e.getMessage());
            }
        }

        Assert.fail("Test Failed: Could not verify status for '" + orgName + "' after multiple attempts.");
    }

}
