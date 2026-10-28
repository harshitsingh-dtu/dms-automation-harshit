package stepDefinations;

import PageObjects.OrgManagement.OrgManagementPageObject;
import PageObjects.Approval.ApprovalMatrixPageObject;
import PageObjects.Approval.ApprovalMatrixUpdatePageObject;
import Utilities.ConfigFileReader;
import de.taimos.totp.TOTP;
import io.cucumber.java.Before;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

@Data
@Slf4j
public class Hooks extends PageObject {

    private String Email;
    private String Password;
    private OrgManagementPageObject orgManagementPageObject;
    private ApprovalMatrixPageObject approvalMatrixPageObject;
    private ApprovalMatrixUpdatePageObject approvalMatrixUpdatePageObject;
    private Actions act;
    ConfigFileReader configfileReader;

    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    private WebElementFacade username;

    @FindBy(xpath = "//div[text()='Sign in']")
    private WebElementFacade test;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElementFacade pass;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElementFacade login;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElementFacade submit;

    @FindBy(xpath = "//div[@id='idDiv_SAOTCS_HavingTrouble']/a")
    private WebElementFacade CantUseAuthenticator;

    @FindBy(xpath = "(//div[@class='table-row'])[2]")
    private WebElementFacade UseVerificationCode;

    @FindBy(xpath = "//input[@placeholder='Code']")
    private WebElementFacade TotpCode;

    @FindBy(xpath = "//input[@placeholder='Enter Email']")
    private WebElementFacade mail;

    // non-fed pop up screen
    @FindBy(xpath = "//h2[text()='Important Information']")
    private WebElementFacade Important_Info_PopUp;

    @FindBy(xpath = "//div[@class='t-checkbox']")
    private WebElementFacade CheckBox_tick;

    @FindBy(xpath = "//button[contains(text(),'I understand')]")
    private WebElementFacade Accept_Button;

    // NEW: Logout page "Click here to login again" link
    // XPath confirmed via DevTools: data-testid="login-link"
    @FindBy(xpath = "//a[@data-testid='login-link']")
    private WebElementFacade clickHereToLoginAgain;

    // NEW: Dashboard sidebar icon - only present on authenticated ODC dashboard
    // Same element used by DocumentPageObject.clickMenuButton() line 232
    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')]")
    private WebElementFacade sidebarIcon;

    // NEW: Cookie Pop-up Accept Button (Using ID and Text from DOM)
    @FindBy(xpath = "//button[@id='ketch-banner-button-primary' or normalize-space()='Accept All Cookies']")
    private WebElementFacade acceptAllCookiesBtn;

    // =========================================================
    // STATIC FIELDS
    // volatile added: prevents stale reads in parallel test runs
    // =========================================================
    static WebDriver driver;
    static volatile boolean cookiesResult = false;
    private static boolean globalSetupDone = false;

    @Before(value = "not @PureApi", order = 1)
    public static void globalSetup() {
        if (!globalSetupDone) {
            try {
                Hooks obj = new Hooks();
                obj.open();
                WebElementFacade dummy = (WebElementFacade) driver.findElement(By.xpath("//input[@type='email']"));
                String abc = dummy.getShadowRoot().toString();
                System.out.println("Performing global setup once before all features..." + abc);
                dummy.waitUntilVisible();
                dummy.waitUntilClickable();
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dummy);
                globalSetupDone = true;
            } catch (Exception e) {
                System.out.println("Throwing exception" + e);
            }
        }
    }

    //Secondary hook to manage browser launch and decide between session restore or fresh login
    @Before(value = "not @PureApi", order = 2)
    public void beforeHookBrowserLaunch() throws IOException {
        if (!cookiesResult) {
            // Path 1: Fresh Login - Delete old session file and start credential flow
            deleteStaleCookieFile();
            open();
            withAction().pause(Duration.ofSeconds(10)).build().perform();
            login();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        } else {
            // Path 2: Session Restore - Attempt to load cookies to bypass login
            cookies.loadCookies(getDriver(), configfileReader.getDataFromConfigFile("webdriver.base.url"));
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            // If the restored session is rejected, perform emergency recovery and login
            if (isOnLogoutPage()) {
                log.warn("Session expired after cookie restore. Recovering...");
                recoverFromLogoutPage();
                cookiesResult = false;
                login();
                withAction().pause(Duration.ofSeconds(5)).build().perform();
            }
        }
        // Verification: Ensure the ODC dashboard is fully loaded before test steps begin
        waitForDashboardToLoad();
    }

    @Before(value = "@ConfigureApprovalMatrix", order = 3)
    public void configureMatrixHook() {
        log.info("Hook Triggered: Automatically configuring matrix...");

        // 1. Navigate to Approval Matrix listing
        approvalMatrixPageObject.navigateToApprovalMatrixListingScreen();

        // 1.5. Search for the specific matrix on the listing screen
        try {
            log.info("Searching for Approval Matrix for OSTTRA INDIA SERVICES PRIVATE LIMITED PB DN...");

            // Select LEI
            WebElementFacade selectLEI = approvalMatrixPageObject.getSelectLEI();
            selectLEI.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectLEI);
            selectLEI.type("OSTTRA INDIA SERVICES PRIVATE LIMITED");
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            org.openqa.selenium.WebElement leiOption = getDriver().findElement(By.xpath(
                    "//li/p[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'osttra india services private')]"));
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", leiOption);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // Select Doc Type
            log.info("Selecting doc type filter: DN");
            WebElementFacade selectDocType = approvalMatrixPageObject.getSelectDocType();
            selectDocType.waitUntilVisible();
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectDocType);
            selectDocType.type("DN");
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            org.openqa.selenium.WebElement docOption = getDriver().findElement(By.xpath(
                    "//li/p[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'dn')]"));
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", docOption);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // Select Org Type
            log.info("Selecting org type filter: PB");
            WebElementFacade selectOrgType = approvalMatrixPageObject.getSelectOrgType();
            selectOrgType.waitUntilVisible();
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectOrgType);
            selectOrgType.type("PB");
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            org.openqa.selenium.WebElement orgOption = getDriver().findElement(By.xpath(
                    "//li/p[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'pb')]"));
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", orgOption);
            withAction().pause(Duration.ofSeconds(3)).build().perform();

            // Validate that we found it
            WebElementFacade searchedMatrix = approvalMatrixPageObject.getSearchedMatrix();
            searchedMatrix.waitUntilVisible();
            org.junit.Assert.assertTrue("Approval matrix search failed: expected OSTTRA INDIA SERVICES PRIVATE LIMITED",
                    searchedMatrix.getText().trim().equalsIgnoreCase("OSTTRA INDIA SERVICES PRIVATE LIMITED"));
        } catch (Exception e) {
            log.error("Failed to filter and search Approval Matrix: " + e.getMessage(), e);
            org.junit.Assert.fail("Approval Matrix filtering failed: " + e.getMessage());
        }

        // 2. Click update button to load the update screen
        approvalMatrixPageObject.clickupdatebtn();
        approvalMatrixUpdatePageObject.getUpdate_approval_matrix_header_text().withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();

        // 3. Perform the matrix checks on the Update screen
        boolean isAllConfigured = true;
        String groupName = "Automation_OT_ApprovalGroup_DN_Osttra";

        // Resolve group name if needed
        String resolvedGroup = PageObjects.Approval.ApprovalgroupCreatePageObject.getGeneratedGroupName(groupName);
        if (resolvedGroup != null) {
            groupName = resolvedGroup;
        }

        String[] actionsList = {
                "New Document", "Edit Approval Workflow", "Edit Enforcement Rules",
                "Edit Document Terms", "Remove Currency", "Remove Products",
                "Terminate Document", "Apply USP Rider", "Edit Document"
        };

        for (String actionName : actionsList) {
            String xpath = "//td[normalize-space()='" + actionName + "']/following-sibling::td//input";
            try {
                // Scroll label into view to ensure element is rendered
                String labelXpath = "//td[normalize-space()='" + actionName + "']";
                org.openqa.selenium.WebElement labelElement = getDriver().findElement(By.xpath(labelXpath));
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", labelElement);
                withAction().pause(Duration.ofMillis(200)).build().perform();

                WebElementFacade el = find(By.xpath(xpath));
                String actualGroup = el.getAttribute("value").trim();
                if (!actualGroup.equalsIgnoreCase(groupName)) {
                    isAllConfigured = false;
                    log.info("Mismatch found for action '" + actionName + "'. Expected: '" + groupName + "', Actual: '" + actualGroup + "'");
                    break;
                }
            } catch (Exception e) {
                isAllConfigured = false;
                log.info("Action row or input for '" + actionName + "' not visible/found. Configuring matrix.");
                break;
            }
        }

        if (isAllConfigured) {
            log.info("Approval Matrix is ALREADY configured with approval group '" + groupName + "' for all actions. Navigating back to listing screen...");
            approvalMatrixPageObject.navigateToApprovalMatrixListingScreen();
            return;
        }

        log.info("Approval Matrix is NOT fully configured. Initiating configuration steps...");
        approvalMatrixUpdatePageObject.getUpdate_approval_matrix_header_text().withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();

        // Perform configuration steps
        String action = "New Document";
        int targetSequence = 1;
        String rowInputsXpath = "//td[normalize-space()='" + action + "']/parent::tr//input";
        List<WebElementFacade> existingInputs = findAll(By.xpath(rowInputsXpath));

        if (existingInputs.size() < targetSequence) {
            int clicksNeeded = targetSequence - existingInputs.size();
            WebElementFacade AddSequenceColumnButton = approvalMatrixUpdatePageObject.getAddSequenceColumnButton();
            for (int i = 0; i < clicksNeeded; i++) {
                evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", AddSequenceColumnButton);
                AddSequenceColumnButton.waitUntilVisible();
                evaluateJavascript("arguments[0].click();", AddSequenceColumnButton);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }

        WebElementFacade inputField = find(By.xpath("(//td[normalize-space()='" + action + "']/parent::tr//input)[" + targetSequence + "]"));
        evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", inputField);

        withAction().moveToElement(inputField).pause(Duration.ofMillis(500)).perform();
        String clearBtnXpath = "(//td[normalize-space()='" + action + "']/parent::tr//button[@title='Clear'])[" + targetSequence + "]";
        List<WebElementFacade> clearButtons = findAll(By.xpath(clearBtnXpath));

        if (!clearButtons.isEmpty() && clearButtons.get(0).isCurrentlyVisible()) {
            evaluateJavascript("arguments[0].click();", clearButtons.get(0));
            withAction().pause(Duration.ofMillis(500)).build().perform();
        } else {
            inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        }

        withAction().click(inputField)
                .pause(Duration.ofMillis(500))
                .sendKeys(groupName)
                .pause(Duration.ofSeconds(2))
                .build().perform();

        String exactOptionXpath = "//li[@role='option' and normalize-space()='" + groupName + "']";
        List<WebElementFacade> exactOptions = findAll(By.xpath(exactOptionXpath));
        if (!exactOptions.isEmpty()) {
            evaluateJavascript("arguments[0].click();", exactOptions.get(0));
        } else {
            log.error("No exact-match option found in dropdown for group: '" + groupName + "'. Falling back to first available.");
            List<WebElementFacade> anyOptions = findAll(By.xpath("//li[@role='option']"));
            org.junit.Assert.assertFalse("No approval group options rendered for input: " + groupName, anyOptions.isEmpty());
            evaluateJavascript("arguments[0].click();", anyOptions.get(0));
        }

        // Click Apply All button
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getApply_all_button());
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        // Click Submit Button on the update screen
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getSubmit_btn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        // Click Submit button on confirmation pop-up
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getConfirmation_submit_btn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        log.info("Approval Matrix configuration successfully updated in main window via Hook.");
    }

    public void login() {
        int retryCount = 3;
        int attempts = 0;
        boolean success = false;

        while (attempts < retryCount && !success) {
            attempts++;
            log.info("Login Attempt: " + attempts);

            try {

                // 1. Handle Cookie Popup immediately to prevent element interception
                acceptCookiesIfPresent();
                // Wait for the username field to be ready for interaction
                username.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible().waitUntilClickable();
                username.click();
                // Clear existing values via JavaScript to prevent autocomplete interference
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", username);
                username.sendKeys(configfileReader.getDataFromConfigFile("username"));
                // Press Escape to dismiss any browser-native autocomplete dropdowns
                username.sendKeys(Keys.ESCAPE);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                // Click Login button using JS to ensure it registers even if partially obscured
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", login.waitUntilPresent());

                // 2. Handle Important Information popup if it appears
                boolean popupHandled = false;
                try {
                    Important_Info_PopUp.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
                    log.info("Important Info Pop-up detected. Handling...");
                    CheckBox_tick.waitUntilClickable().click();
                    Accept_Button.waitUntilClickable().click();
                    popupHandled = true;
                } catch (Exception e) {
                    log.info("Important Info Pop-up did not appear. Proceeding to password...");
                }

                // 3. Enter password
                pass.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible().waitUntilClickable();
                pass.clear();
                pass.sendKeys(configfileReader.getDataFromConfigFile("password"));
                submit.waitUntilClickable().click();

                // 4. Handle TOTP
                if (!popupHandled) {
                    TotpCode.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible().waitUntilClickable();
                    TotpCode.clear();

                    // FIX 2: TOTP timing safety
                    // If <=4s remain in the 30s TOTP window, the server may receive
                    // the code after the window rolls over and reject it.
                    // Wait for next window before generating the code.
                    long secondsRemaining = 30 - (System.currentTimeMillis() / 1000L) % 30;
                    if (secondsRemaining <= 4) {
                        log.warn("TOTP window ending in " + secondsRemaining + "s - waiting for next window.");
                        withAction().pause(Duration.ofSeconds(secondsRemaining + 1)).build().perform();
                    }
                    // Generate 6-digit MFA code and submit
                    TotpCode.sendKeys(getTOTPCode(configfileReader.getDataFromConfigFile("secretKey")));
                    submit.waitUntilClickable().click();
                }
                // Post-Login: Save the successful session cookies for future tests
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                cookies.saveCookies(getDriver());
                log.info("Login executed successfully.");
                cookiesResult = true;
                success = true;

            } catch (Exception e) {
                log.warn("Login failed on attempt " + attempts + " due to: " + e.getMessage());

                if (attempts < retryCount) {
                    //Navigate to base URL instead of refresh()
                    // refresh() on logout/error page reloads the same page.
                    // navigate().to(baseUrl) gets back to a clean starting point.
                    log.info("Navigating to base URL to retry...");
                    try {
                        getDriver().navigate().to(configfileReader.getDataFromConfigFile("webdriver.base.url"));
                    } catch (Exception navEx) {
                        getDriver().navigate().refresh();
                    }
                    withAction().pause(Duration.ofSeconds(5)).build().perform();

                    // FIX Recover if retry landed on logout or SSO login page
                    if (isOnLogoutPage()) {
                        log.warn("Retry landed on logout/SSO page - recovering...");
                        recoverFromLogoutPage();
                    }
                }
            }
        }

        if (!success) {
            org.junit.Assert.fail("Failed to login securely after " + retryCount + " attempts.");
        }
    }

    // Helper method to catch and clear the cookie banner overlay
    private void acceptCookiesIfPresent() {
        try {
            if (acceptAllCookiesBtn.withTimeoutOf(Duration.ofSeconds(5)).isCurrentlyVisible()) {
                log.info("Cookie popup detected. Clicking 'Accept All Cookies'...");
                acceptAllCookiesBtn.waitUntilClickable().click();
                // Brief pause to allow the modal overlay to fully fade out
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.info("Cookie popup did not appear, proceeding with login workflow.");
        }
    }

    // Decodes the Secret Key and generates a valid 6-digit TOTP code
    private String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    // =========================================================
    // waitForDashboardToLoad
    //
    // Waits up to 30s for the sidebar-icon to appear.
    // This element is ONLY present on the authenticated ODC
    // dashboard - it is the same element clickMenuButton() uses.
    //
    // WHY THIS IS NEEDED:
    // The @Before hook was finishing with only a time-based pause.
    // On Jenkins the page loads slower. Scenario step 1 ran before
    // the dashboard was ready -> AssertionError on every scenario.
    // This method guarantees the dashboard is fully loaded before
    // any scenario step executes.
    //
    // Emergency re-login if dashboard fails to load.
    // =========================================================
    private void waitForDashboardToLoad() {
        try {
            log.info("waitForDashboardToLoad: waiting for sidebar-icon...");
            sidebarIcon.withTimeoutOf(Duration.ofSeconds(30)).waitUntilVisible();
            log.info("waitForDashboardToLoad: dashboard ready.");
        } catch (Exception e) {
            String currentUrl = getDriver().getCurrentUrl();
            log.error("waitForDashboardToLoad: NOT loaded after 30s. URL=" + currentUrl);

            if (isOnLogoutPage()) {
                log.warn("waitForDashboardToLoad: logout/SSO page detected - emergency re-login.");
                try {
                    recoverFromLogoutPage();
                    cookiesResult = false;
                    login();
                    sidebarIcon.withTimeoutOf(Duration.ofSeconds(30)).waitUntilVisible();
                    log.info("waitForDashboardToLoad: emergency re-login successful.");
                } catch (Exception recoveryEx) {
                    org.junit.Assert.fail(
                            "Dashboard failed to load after login and emergency recovery. " +
                                    "URL: " + currentUrl + " | Error: " + recoveryEx.getMessage()
                    );
                }
            } else {
                org.junit.Assert.fail(
                        "Dashboard failed to load within 30 seconds. " +
                                "URL: " + currentUrl + " | Error: " + e.getMessage()
                );
            }
        }
    }

    //deleteStaleCookieFile
    // Deletes the local cookie file to ensure a clean login for the first test of a build
    private void deleteStaleCookieFile() {
        try {
            java.nio.file.Path cookiePath = Paths.get("src/test/resources/cookies.ser");
            if (Files.exists(cookiePath)) {
                Files.delete(cookiePath);
                log.info("deleteStaleCookieFile: deleted stale cookies.ser.");
            }
        } catch (Exception e) {
            log.warn("deleteStaleCookieFile: could not delete - " + e.getMessage());
        }
    }

    // Checks current URL and DOM to detect if the session has been kicked out to a logout/login page
    private boolean isOnLogoutPage() {
        try {
            String url = getDriver().getCurrentUrl();

            if (url == null || url.trim().isEmpty()) {
                log.warn("isOnLogoutPage: URL null/empty - session invalid.");
                return true;
            }
            if (url.contains("docs.osttra.com/logout")) {
                log.warn("isOnLogoutPage: ODC logout page -> " + url);
                return true;
            }
            if (url.contains("sso.osttra.com/saml/login")) {
                log.warn("isOnLogoutPage: SSO login page (session expired) -> " + url);
                return true;
            }
            boolean logoutDomPresent = !getDriver()
                    .findElements(By.xpath("//div[@data-testid='logout-content']"))
                    .isEmpty();
            if (logoutDomPresent) {
                log.warn("isOnLogoutPage: logout-content DOM found.");
                return true;
            }
            return false;
        } catch (Exception e) {
            log.warn("isOnLogoutPage error: " + e.getMessage());
            return false;
        }
    }

    // Navigates from the logout screen back to the SSO login form to allow re-entry
    private void recoverFromLogoutPage() {
        try {
            String url = getDriver().getCurrentUrl();

            if (url != null && url.contains("sso.osttra.com/saml/login")) {
                log.info("recoverFromLogoutPage: already on SSO login page - no action needed.");
                return;
            }

            log.info("recoverFromLogoutPage: clicking login-link on ODC logout page...");
            clickHereToLoginAgain
                    .withTimeoutOf(Duration.ofSeconds(8))
                    .waitUntilVisible()
                    .click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            log.info("recoverFromLogoutPage: clicked - now on SSO login page.");

        } catch (Exception e) {
            log.warn("recoverFromLogoutPage: link click failed - navigating to base URL.");
            try {
                getDriver().navigate().to(configfileReader.getDataFromConfigFile("webdriver.base.url"));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
            } catch (Exception navEx) {
                log.warn("recoverFromLogoutPage: navigation also failed: " + navEx.getMessage());
            }
        }
    }
}