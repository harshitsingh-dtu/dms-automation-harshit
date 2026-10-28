package PageObjects.OrgManagement;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@Data
public class OrgManagementPageObject extends PageObject {
    //    @WhenPageOpens
//    public boolean waitForPageOpen() {
//        withAction().pause(Duration.ofSeconds(4)).build().perform();
//        return waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(500)).ignoring(Exception.class).until((ExpectedCondition<Boolean>) input -> evaluateJavascript("return typeof jQuery === 'undefined' || $.active == 0;").equals(true));
//    }
    Actions act = new Actions(getDriver());
    String predictiveSearchBarText = "JPMORGAN CHASE & CO.";
    String RandomCharacters = "aB3!c@D$e%F^g&H*i(J)k-L+m=N[o]{P|q;R:s'Tu<V,w>X.?y0z1A2b4C5d6E7f8G9h!I@j#K$l%M^n&O*p(Q)r-S+t=U[v]{W|x;Y:z'0A1B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z6a7b8c9d0e1f2g3h4i5j6k7l8m8n9o0p1q2r3s4t5u6v7w8x9y0z1A2B3C4D5E6F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z6a7b8c9d0e1f2g3h4i5j6k7l8m9n0o1p2q3r4s5t6u7v8w9x0y1z2A3B4C5D6E7F8G9H0I1J2K3L3M4N5O6P7Q8R0S1T2U3V4W5X6Y7Z8a9b0c1d2e3f4g5h6i7j8k9l0m1n2o3p4q5r6s7t8u9v0w1x2y3z4A5B6C7D8E9F0G1H2I3J4K5L6M7N8O9P0Q1R2S3T4U5V6W7X8Y9Z0a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y3z4!@#$%^&*()_+-=[]{}|;':,.<>?qwertyuiop";


    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')]")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade navigation_btn;

    @FindBy(xpath = "//div[@class='status-container']")
    private WebElementFacade side_window;
    @FindBy(xpath = "(//th[text()='Doc type'])[2]")
    private WebElementFacade side_window_DocType;
    @FindBy(xpath = "(//th[text()='Org type status'])[2]")
    private WebElementFacade side_window_OrgType;
    @FindBy(xpath = "(//tbody)[2]")
    private WebElementFacade side_window_BodyType;

    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Organisations']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade organization_btn;

    @FindBy(xpath = "//*[@data-testid='submenu-link-Organisations management']")
    private WebElementFacade organizationManagement_btn;

    @FindBy(xpath = "//header[contains(@class,'t-head')]")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade organization_text;


    @FindBy(xpath = "//button[text()='Update']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade update_btn;

    @FindBy(xpath = "//input[@placeholder='Search by LEI or name']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade searchbar_listingPage;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/thead[1]/tr[1]/th['+i+']/div[1]")
    private WebElementFacade commonxpathTableheaders;

    @FindBy(xpath = "//th/div[text()='LEI']")
    private WebElementFacade LEIID_col;

    @FindBy(xpath = "//th/div[text()='Legal entity name']")
    private WebElementFacade nameoforganization_col;

    @FindBy(xpath = "//th/div[@data-testid='doc-table-th-dnPushNotifications' or text()='DN push notifications']")
    private WebElementFacade DNPushNotifications_col;

    @FindBy(xpath = "//th/div[text()='Action']")
    private WebElementFacade action_col;

    @FindBy(xpath = "//tr[1]/td[1]")
    private WebElementFacade searchedLEIID;

    @FindBy(xpath = "//tr[1]/td[2]")
    private WebElementFacade searchednameofOrganization;

    @FindBy(xpath = "//tr[1]/td[3]")
    private WebElementFacade searched_address;

    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade norecordfound_txt;

    @FindBy(xpath = "//div[@class='paginator']")
    private WebElementFacade pagination_container;

    @FindBy(xpath = "//div[@class='paginator']//span[text()='Showing page ']")
    private WebElementFacade showing_page;

    @FindBy(xpath = "//input[@class='page-number']")
    private WebElementFacade showing_page_page_number;

    @FindBy(xpath = "//div[@class='paginator']//span[@class='total-page']")
    private WebElementFacade showing_page_total_page;

    @FindBy(xpath = "//span[text()=' Records per page ']")
    private WebElementFacade records_per_page;

    @FindBy(xpath = "//select[@class='page-row-size']")
    private WebElementFacade records_per_page_value;

    @FindBy(xpath = "//span[text()='Total record count']")
    private WebElementFacade Total_record_count_text;

    @FindBy(xpath = "//span[@class='page-size-num']")
    private WebElementFacade current_record_page_value;

    @FindBy(xpath = "//input[@class='page-number']")
    private WebElementFacade change_page_number;

    @FindBy(xpath = "//div[@class='btn-container']//button[1]")
    private WebElementFacade previous_page_button;

    @FindBy(xpath = "//div[@class='btn-container']//button[2]")
    private WebElementFacade next_page_button;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/div[2]/table/tbody/tr/td[3]/div/div/label/span[1]/span[1]/input")
    private WebElementFacade enablebutton;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctype_filter;
    @FindBy(xpath="//button[normalize-space()='Submit']")
    private WebElementFacade submitbtn;
    @FindBy(xpath="//button[normalize-space()='Cancel']")
    private WebElementFacade CancelButton;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div[2]/button[2]")
    private WebElementFacade warningYes;
    @FindBy(xpath = "//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'dn push notification')]")
    private WebElementFacade DNPushNotifications_OrgScreen;
    @FindBy(xpath = "//div[contains(@class,'enable-switch')]//label")
    private WebElementFacade DNPushNotifications_button;
    @FindBy(xpath = "(//*[contains(text(),'+ Alternate ID')])[1]")
//*[contains(text(),'Alternate Executing Broker ID')]/following-sibling::input
    private WebElementFacade AlternateEB_ID;//*[contains(text(),'Alternate Executing Broker ID')])[1]
    @FindBy(xpath = "//*[contains(text(),'Alternate Client ID')]")
//*[contains(text(),'Alternate Client ID')]/following-sibling::input
    private WebElementFacade AlternateClient_ID;
    @FindBy(xpath = "//*[contains(text(),'Alternate Client ID')]/following-sibling::input")
    private WebElementFacade AlternateClient_IDInputValue;
    @FindBy(xpath = "//*[contains(text(),'Alternate Executing Broker ID')]/following-sibling::input")
    private WebElementFacade AlternateEB_IDInputValue;
    @FindBy(xpath = "(//*[contains(text(),'Alternate Executing Broker ID')])[1]")
//*[contains(text(),'Alternate Executing Broker ID')]/following-sibling::input
    private WebElementFacade AlternateEB_IDNew;
    @FindBy(xpath = "(//button[text()='+ Alternate ID'])[1]")
    private WebElementFacade Alternate_ID;
    @FindBy(xpath = "//*[@placeholder='Enter Alternate ID']")
    private WebElementFacade Alternate_ID_textField;
    @FindBy(xpath = "//div[@class='action-btn']/*[name()='svg'][2]")
    private WebElementFacade clickonTickbutton;
    @FindBy(xpath = "(//div[@class='edit-email'])[1]")
    private WebElementFacade Alternate_ID_Value;//div[@class='edit-email'])//span
    @FindBy(xpath = "(//div[@class='edit-email'])[1]/*[name()='svg']")
    private WebElementFacade Alternate_ID_EdiIcon;
    @FindBy(xpath = "//th[normalize-space()='PB']")
    private WebElementFacade PB_Header;
    @FindBy(xpath = "(//button[text()='Online'])[3]")
    private WebElementFacade OnlineButtonForClient;
    @FindBy(xpath = "(//button[text()='Neutral'])[3]")
    private WebElementFacade NeutralButton;


    public void navigateToOrganizationScreen() {
        if (organization_text.isPresent() && organization_text.getText().trim().equalsIgnoreCase("Organisations")) {
            log.info("Already on Organisations screen");
            return;
        }
        try {
            if (!organization_btn.isVisible()) {
                navigation_btn.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.info("Navigation button might not be needed or already open: " + e.getMessage());
        }
        organization_btn.waitUntilClickable().click();
        organizationManagement_btn.waitUntilClickable().click();
    }

    public void navigateToOrganizationManagement() {
        try {
            log.info("Navigating to Organisation Management screen...");
            getDriver().navigate().refresh();
            withAction().pause(Duration.ofSeconds(5)).build().perform();

            navigation_btn.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
            try {
                navigation_btn.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", navigation_btn);
            }

            organization_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            try {
                organization_btn.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", organization_btn);
            }

            organizationManagement_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            try {
                organizationManagement_btn.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", organizationManagement_btn);
            }

            organization_text.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
            log.info("Successfully navigated to Organisation screen.");
        } catch (Exception e) {
            log.error("Failed to navigate to Organisation screen: " + e.getMessage());
            Assert.fail("Navigation to Organisation screen failed.");
        }
    }

    public void typeInPredictiveSearchBar(List<String> lei) {
        try {
            for (int begin = 0; begin < lei.size(); begin++) {
                String searchTerm = lei.get(begin).trim();
                if (searchTerm.isEmpty() || searchTerm.equalsIgnoreCase("search_orgname") || searchTerm.equalsIgnoreCase("search lei")) continue;

                searchbar_listingPage.waitUntilVisible();
                searchbar_listingPage.clear();
                searchbar_listingPage.typeAndEnter(searchTerm);
                act.pause(Duration.ofSeconds(3)).build().perform();
                if (norecordfound_txt.isVisible()) {
                    log.info("No entry found corresponding to the searched entity: " + searchTerm);
                } else {
                    Assert.assertTrue(searchedLEIID.isVisible());
                }
            }
        } catch (Exception e) {
            log.error("Not able to interact with predictive search bar" + e);
            Assert.fail();
        }

    }

    public void checkPredictiveSearchBarVisible() {

        try {
            Assert.assertTrue(searchbar_listingPage.isVisible());
        } catch (AssertionError e) {
            log.error("predictive search bar not visible");
        }
    }

    public void checkAllelementsonOrganizationscreen() {
        try {
            Assert.assertTrue(LEIID_col.isVisible());
            Assert.assertTrue(nameoforganization_col.isVisible());
            Assert.assertTrue(DNPushNotifications_col.isVisible());
            Assert.assertTrue(action_col.isVisible());
        } catch (AssertionError e) {
            log.error("Not all the columns are visible");
            Assert.fail();
        }
    }

    public void checkAllinformationregardinglei() {
        try {
            Assert.assertTrue(searchedLEIID.isVisible());
            Assert.assertTrue(searchednameofOrganization.isVisible());
            Assert.assertTrue(searched_address.isVisible());
            Assert.assertTrue(update_btn.isVisible());
        } catch (AssertionError e) {
            if (norecordfound_txt.isVisible()) {
                log.info("No enrty corresponding to the input found");
            } else {
                log.error("Error while validating the LEI information" + e);
                Assert.fail();
            }

        }

    }

    public void checkUpdatebtn() {
        try {
            Assert.assertTrue(update_btn.isVisible());
        } catch (AssertionError e) {
            log.error("Not able to interact with update button");
            Assert.fail();
        }

    }

    public void clickupdate_btn() {
        try {
            update_btn.waitUntilClickable();
            update_btn.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Not able to interact with update button" + e);
            Assert.fail();
        }
    }


    public void check_previous_page_btn() {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", pagination_container);
            Assert.assertTrue(previous_page_button.isVisible());
            if (showing_page_page_number.getAttribute("value").equals("1")) {
                Assert.assertFalse(previous_page_button.isEnabled());
//                Assert.assertTrue(next_page_button.isEnabled());
            } else {
                Assert.assertTrue(previous_page_button.isEnabled());
            }
        } catch (Exception e) {
            log.error("Unable to verify whether previous page button is enabled or not" + e);
            Assert.fail();
        }

    }

    public void check_next_page_btn() {
        try {
            Assert.assertTrue(next_page_button.isVisible());
            String last_page = showing_page_total_page.getText();
            last_page = last_page.substring(last_page.length() - 1);
            showing_page_page_number.clear();
            typeInto(showing_page_page_number, last_page);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Assert.assertTrue(next_page_button.isDisabled());
//            Assert.assertTrue(previous_page_button.isEnabled());
        } catch (AssertionError e) {
            log.error("Unable to verify whether next page button is visible or not");
        }
    }

    public void Selectdoctype(String docType) {
        try {
            WebElementFacade filter = doctype_filter.isPresent() ? doctype_filter : find(By.xpath("//div[@data-testid='doc-type-select']//input"));
            filter.waitUntilVisible().clear();
            withAction().moveToElement(filter).click()
                .pause(Duration.ofSeconds(1))
                .sendKeys(docType)
                .build().perform();
            act.pause(Duration.ofSeconds(1)).build().perform();

            String dynamicXpath = "//li[contains(normalize-space(),'" + docType + "')]";
            WebElementFacade option = find(By.xpath(dynamicXpath));
            if (option.isPresent()) {
                evaluateJavascript("arguments[0].click();", option);
            } else {
                filter.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            }
            act.pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Not able to select doc type: " + docType + " - " + e);
            Assert.fail();
        }
    }

    public void selectYesWarning() {
        try {
            withAction().moveToElement(warningYes).click().build().perform();
        } catch (Exception e) {
            log.error("Select yes on warning " + e);
            Assert.fail();
        }
    }

    public String firstPageCount() {
        String first= current_record_page_value.getText();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", next_page_button);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        return first;
    }

    public String anyPageCount() {
        String anyPageNum= current_record_page_value.getText();
//        next_page_button.click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        return anyPageNum;
    }

    public void validateLeiIsOnlineForPB(String leiName) {
        String upperLei = leiName.trim().toUpperCase();
        WebElementFacade pbSwitch = find(By.xpath(
                "//tr[td[translate(normalize-space(.), " +
                        "'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')='" + upperLei + "']]" +
                        "//td[contains(@data-testid,'PBStatus')]//input[@type='checkbox']"));
        pbSwitch.shouldBePresent();
        assertThat(pbSwitch.isSelected())
                .as("PB org type should be Online for LEI: " + leiName)
                .isTrue();
    }

    public void searchAndUpdateOrgStatusToLiteAndReset(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String orgName = row.get("Organisation Name");
            log.info("--- Processing Status Toggle (Online <-> Lite) for: {} ---", orgName);

            try {
                searchbar_listingPage.waitUntilClickable().click();
                searchbar_listingPage.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                searchbar_listingPage.sendKeys(orgName);
                searchbar_listingPage.sendKeys(Keys.RETURN);
                withAction().pause(Duration.ofSeconds(3)).build().perform();

                if (norecordfound_txt.isCurrentlyVisible()) {
                    org.junit.Assert.fail("Organisation not found: " + orgName);
                }

                toggleStatusFlow(orgName, "Lite");

                toggleStatusFlow(orgName, "Online");

                log.info("Successfully toggled and reset status for '{}'.", orgName);

            } catch (Exception e) {
                log.error("Failed status toggle for org '{}': {}", orgName, e.getMessage());
                org.junit.Assert.fail("Status toggle failed for: " + orgName);
            }
        }
    }

    private void toggleStatusFlow(String orgName, String targetStatus) {
        log.info("Toggling '{}' to status: {}", orgName, targetStatus);

        String updateBtnXPath = "//tr[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                + orgName.trim().toLowerCase() + "')]//button[contains(normalize-space(.), 'Update')]";
        WebElementFacade updateBtn = $(By.xpath(updateBtnXPath)).waitUntilPresent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", updateBtn);
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", updateBtn);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        String pbToggleXPath = "//td[contains(@data-testid, 'switch-cell') or contains(@data-testid, 'Status')]//input[@type='checkbox'] "
                + "| //div[contains(@class, 'modal') or contains(@class, 'dialog')]//input[@type='checkbox'] "
                + "| //input[@type='checkbox' or @role='switch']";
        WebElementFacade pbToggle = $(By.xpath(pbToggleXPath)).waitUntilPresent();

        String currentStatusText = pbToggle.getText().trim();
        log.info("Current PB status: " + currentStatusText);

        if (!currentStatusText.equalsIgnoreCase(targetStatus)) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", pbToggle);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            try {
                WebElementFacade confirmYes = $(By.xpath("//button[text()='Yes']"));
                if (confirmYes.withTimeoutOf(Duration.ofSeconds(3)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmYes);
                    log.info("Confirmation 'Yes' clicked.");
                }
            } catch (Exception e) { /* ignore */ }

            String submitBtnXPath = "//button[contains(., 'Submit') or contains(., 'Save') or contains(., 'Update')]";
            WebElementFacade submitBtn = $(By.xpath(submitBtnXPath)).waitUntilClickable();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", submitBtn);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        } else {
            log.info("Already in status '{}', skipping toggle.", targetStatus);
            $(By.xpath("//button[contains(., 'Cancel')]")).click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    public void validateNeutralButton() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        OnlineButtonForClient.waitUntilClickable().click();
        log.info("Clicked Online Button.");
        if (submitbtn.waitUntilPresent().isClickable()) {
            log.info("Submit button is clickable after clicking Online");
            NeutralButton.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (!submitbtn.isClickable()) {
                log.info("Submit button is NOT clickable after clicking Neutral");
                CancelButton.waitUntilClickable().click();
            } else {
                log.error("Submit button is still clickable after clicking Neutral.");
                throw new AssertionError("Submit button should not be clickable after clicking Neutral.");
            }
        } else {
            log.error("Submit button was not clickable after clicking Online.");
            throw new AssertionError("Submit button should be clickable after clicking Online.");
        }
    }

    /**
     * Implements the comment in OrgDNPushNotification.feature:
     * "if toggle is already enabled then make it disabled, and then click enable it again"
     * Ensures the scenario always ends with the toggle Enabled
     */
    public void toggleDNPushNotificationAndEnsureEnabled() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        // The underlying <input type="checkbox"> inside the MUI switch is visually
        // hidden, so Serenity's isSelected() (which requires an interactable/displayed
        // element) times out. Read .checked directly via JS instead.
        Boolean isCurrentlyEnabled = (Boolean) getJavascriptExecutorFacade().executeScript(
                "var el = document.querySelector(\"div.enable-switch input[type='checkbox']\");" +
                        "return el ? el.checked : false;"
        );
        log.info("DN Push Notification current state - Enabled: " + isCurrentlyEnabled);

        if (Boolean.TRUE.equals(isCurrentlyEnabled)) {
            log.info("Toggle already Enabled. Disabling first, then re-enabling to capture 'enabled for' message.");
            // Click 1: disable (fires 'disabled for' toast - irrelevant to this validation)
            DNPushNotifications_button.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            // Click 2: re-enable (fires 'enabled for' toast - this is what the scenario validates)
            DNPushNotifications_button.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } else {
            // Already Disabled: single click enables it directly
            DNPushNotifications_button.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }
    /**
     * "if it is disabled first, check the state - if disabled then first
     * make this enabled, then click" (to perform the disable action).
     * Ensures the scenario always ends with the toggle Disabled
     */
    public void toggleDNPushNotificationAndEnsureDisabled() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        Boolean isCurrentlyEnabled = (Boolean) getJavascriptExecutorFacade().executeScript(
                "var el = document.querySelector(\"div.enable-switch input[type='checkbox']\");" +
                        "return el ? el.checked : false;"
        );
        log.info("DN Push Notification current state - Enabled: " + isCurrentlyEnabled);

        if (Boolean.TRUE.equals(isCurrentlyEnabled)) {
            // Already Enabled: single click disables it directly
            DNPushNotifications_button.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } else {
            log.info("Toggle already Disabled. Enabling first, then disabling to capture 'disabled for' message.");
            // Click 1: enable (fires 'enabled for' toast - irrelevant to this validation)
            DNPushNotifications_button.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            // Click 2: disable (fires 'disabled for' toast - this is what the scenario validates)
            DNPushNotifications_button.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }
}



