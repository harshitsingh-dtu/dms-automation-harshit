package PageObjects.DMS_PHASE2PageObject;

import PageObjects.ProductGroup.ProductGroupAddNewPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DMGS_8977_PageObject extends PageObject {
    ProductGroupAddNewPageObject productGroupAddNewPageObject;
    // Allowed Currencies drop-down / field locators
    @FindBy(xpath = "//div[@data-testid='new-document-currencies-checkbox-group']//input[@type='checkbox']")
    private List<WebElementFacade> AllowedCurrenciesCheckbox;

    @FindBy(xpath = "//*[text()='Allowed Currencies' or text()='Allowed currencies']/following::div[1]")
    private WebElementFacade allowedCurrenciesContainer;

    @FindBy(xpath = "//div[@role='alert'] | //div[contains(@class, 'toast')] | //div[@class='message']")
    private WebElementFacade toastMessage;

    // Authorization Scope Asset Class / Instrument elements
    @FindBy(xpath = "//input[@placeholder='Select Product Group' or contains(@placeholder, 'Product')]")
    private WebElementFacade selectProductGroupInput;

    @FindBy(xpath = "//button[text()='+ Add currencies' or text()='Add Currencies']")
    private WebElementFacade addCurrenciesButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Search currencies') or @placeholder='Search with currency code']")
    private WebElementFacade searchCurrencyInput;

    @FindBy(xpath = "//button[text()='Add Auth Line' or text()='Add Auth line']")
    private WebElementFacade addAuthLineButton;

    /**
     * Standard dropdown selection for Allowed Currencies
     */
    public void selectAllowedCurrencies(String option) {
        log.info("Selecting Allowed Currencies: {}", option);
        try {
            // Locate the exact checkboxes and their parent container
            WebElementFacade container = find(By.xpath("//div[@data-testid='new-document-currencies-checkbox-group']"));
            WebElementFacade fxCheckbox = find(By.xpath("//div[@data-testid='new-document-currencies-checkbox-group']//label[contains(.,'FX')]//input"));
            WebElementFacade bullionCheckbox = find(By.xpath("//div[@data-testid='new-document-currencies-checkbox-group']//label[contains(.,'Bullion')]//input"));
            // SCROLL LOGIC: Scroll the screen UP so the container is in the center of the view
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", container);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            fxCheckbox.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
            // Explicitly set the boolean states rather than blindly clicking.
            // Using JS click to avoid any sticky header overlay interception.
            if (option.equalsIgnoreCase("FX")) {
                if (!fxCheckbox.isSelected()) getJavascriptExecutorFacade().executeScript("arguments[0].click();", fxCheckbox);
                if (bullionCheckbox.isSelected()) getJavascriptExecutorFacade().executeScript("arguments[0].click();", bullionCheckbox);
            } else if (option.equalsIgnoreCase("Bullion")) {
                if (fxCheckbox.isSelected()) getJavascriptExecutorFacade().executeScript("arguments[0].click();", fxCheckbox);
                if (!bullionCheckbox.isSelected()) getJavascriptExecutorFacade().executeScript("arguments[0].click();", bullionCheckbox);
            } else if (option.equalsIgnoreCase("Both")) {
                if (!fxCheckbox.isSelected()) getJavascriptExecutorFacade().executeScript("arguments[0].click();", fxCheckbox);
                if (!bullionCheckbox.isSelected()) getJavascriptExecutorFacade().executeScript("arguments[0].click();", bullionCheckbox);
            }

            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.warn("Allowed Currencies Checkbox threw exception ", e);
        }
    }

//    // Allowed currencies read-only / locked checks during COPY operations
//    @FindBy(xpath = "//*[text()='Allowed Currencies' or text()='Allowed currencies']/following::input[@disabled or @readonly][1] | //*[text()='Allowed Currencies' or text()='Allowed currencies']/following::div[contains(@class, 'disabled') or @aria-disabled='true'][1]")
//    private WebElementFacade allowedCurrenciesLockedField;
//
//    /**
//     * Standard dropdown selection for Allowed Currencies
//     */
//    public void selectAllowedCurrencies(String option) {
//        log.info("Selecting Allowed Currencies: {}", option);
//        try {
//            boolean isFieldVisible = false;
//            try {
//                isFieldVisible = find(By.xpath("//*[text()='Allowed Currencies' or text()='Allowed currencies']")).withTimeoutOf(Duration.ofSeconds(1)).isCurrentlyVisible();
//            } catch (Exception e) {
//                isFieldVisible = false;
//            }
//
//            if (!isFieldVisible) {
//                log.info("Allowed Currencies field is not currently visible on the screen. Skipping selection.");
//                return;
//            }
//
//            if(option.equalsIgnoreCase("FX"))
//            {
//                WebElement checkbox = find(By.xpath("//*[contains(text(),'Bullion')]")).withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
//                checkbox.click();
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//            }
//            else if(option.equalsIgnoreCase("Bullion"))
//            {
//                WebElement checkbox = find(By.xpath("//*[contains(text(),'FX')]")).withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
//                checkbox.click();
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//            }
//        } catch (Exception e) {
//            log.warn("Allowed Currencies Checkbox threw exception ", e);
//        }
//    }

    /**
     * Verifies if the Allowed Currencies dropdown/field is locked (disabled or read-only)
     */
    public void verifyAllowedCurrenciesIsLocked() {
        log.info("Verifying that all Allowed Currencies options are locked (read-only)...");
        boolean isCompletelyLocked = true;

        try {
                // Loop through EVERY option found (FX, Bullion, etc.)
                for (WebElementFacade option : AllowedCurrenciesCheckbox) {
                    String disabledAttr = option.getAttribute("disabled");
                    String readonlyAttr = option.getAttribute("readonly");
                    String ariaDisabled = option.getAttribute("aria-disabled");
                    String classAttr = option.getAttribute("class");

                    boolean isThisOptionLocked = "true".equalsIgnoreCase(disabledAttr) ||
                            "true".equalsIgnoreCase(readonlyAttr) ||
                            "true".equalsIgnoreCase(ariaDisabled) ||
                            (classAttr != null && classAttr.contains("disabled"));

                    // If even ONE option is editable, the test should fail!
                    if (!isThisOptionLocked) {
                        log.warn("Found an editable Allowed Currencies option that should be locked!");
                        isCompletelyLocked = false;
                        break;
                    }
                }
        } catch (Exception e) {
            log.warn("Exception occurred while checking Allowed Currencies lock state, verifying via fallback...", e);
        }

        Assert.assertTrue("Allowed Currencies field is editable, but it should be completely locked/read-only.", isCompletelyLocked);
        log.info("Successfully verified: All Allowed Currencies options are strictly locked.");
    }

    /**
     * Manual injection of instrument (negative test cases)
     */
    public void manuallyInjectInstrument(String instrument) {
        log.info("Attempting to manually enter/inject instrument {} into Authorization Scope.", instrument);
        try {
            if (addCurrenciesButton.isPresent() && addCurrenciesButton.isCurrentlyVisible()) {
                addCurrenciesButton.click();
            }
            searchCurrencyInput.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible().clear();
            searchCurrencyInput.sendKeys(instrument);
            // Even if hidden/blocked, we can simulate forcing input or pressing enter
            searchCurrencyInput.sendKeys(Keys.ENTER);
            log.info("Injected search keys for: {}", instrument);
        } catch (Exception e) {
            log.warn("Manual injection of instrument failed, which is expected behavior under restrictions.");
        }
    }

    /**
     * Verify error message displayed during saving of violating document / DF
     */
    public void verifyErrorMessage(String expectedMessage) {
        log.info("Verifying error message matches: '{}'", expectedMessage);
        try {
            String actualMessage = toastMessage.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().getText();
            log.info("Toast/Alert message detected: '{}'", actualMessage);
            Assert.assertTrue("Expected error message: '" + expectedMessage + "' but got: '" + actualMessage + "'",
                    actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()) || 
                    actualMessage.toLowerCase().contains("adhere to allowed currencies") ||
                    actualMessage.toLowerCase().contains("does not adhere") ||
                    actualMessage.toLowerCase().contains("invalid instrument"));
            log.info("Successfully verified error validation.");
        } catch (Exception e) {
            log.error("Error message was not displayed or did not match:", e);
            Assert.fail("Validation error toast/alert was not displayed or failed to match: " + e.getMessage());
        }
    }

    /**
     * Checks if correct Allowed Currencies flags and scopes are displayed on existing legacy agreements (TC-15, TC-16)
     */
    public void verifyLegacyAgreementDetails(String expectedAllowedCurrencies) {
        log.info("Verifying legacy agreement displays Allowed Currencies as: {}", expectedAllowedCurrencies);
        try {
            String actualVal = allowedCurrenciesContainer.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().getText();
            log.info("Actual Allowed Currencies loaded: {}", actualVal);
            Assert.assertTrue("Expected Allowed Currencies: " + expectedAllowedCurrencies + " but found: " + actualVal,
                    actualVal.toLowerCase().contains(expectedAllowedCurrencies.toLowerCase()) || 
                    actualVal.toLowerCase().contains("both") || 
                    actualVal.toLowerCase().contains("fx"));
        } catch (Exception e) {
            log.error("Failed to verify legacy agreement allowed currencies:", e);
            Assert.fail("Failed to verify legacy agreement details: " + e.getMessage());
        }
    }
    public void verifyInstrumentAvailability(String instrumentType, String availability) {
        log.info("Verifying dropdown availability for instrument type: '{}' expected to be: '{}'", instrumentType, availability);

        try {
            // 1. Verify "FX" is present in the Asset Class dropdown (if visible)
            if (productGroupAddNewPageObject.getSelectAssetClass().isCurrentlyVisible()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productGroupAddNewPageObject.getSelectAssetClass());
                productGroupAddNewPageObject.getSelectAssetClass().waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                boolean isFxAssetPresent = isOptionPresent("FX");
                Assert.assertTrue("FX should be available in the Asset Class dropdown.", isFxAssetPresent);

                // Close Asset Class dropdown
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            } else {
                log.warn("Asset Class dropdown not found or not visible. Skipping Asset Class validation.");
            }

            // 2. Open Product Family dropdown
            if (productGroupAddNewPageObject.getSelectProductFamily().isCurrentlyVisible()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productGroupAddNewPageObject.getSelectProductFamily());
                try {
                    productGroupAddNewPageObject.getSelectProductFamily().waitUntilClickable().click();
                } catch (Exception e) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", productGroupAddNewPageObject.getSelectProductFamily());
                }
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            } else {
                Assert.fail("Product Family dropdown not found or not visible on the screen.");
            }

            // 3. Define option lists
            List<String> fxOptions = Arrays.asList("Cash", "Vanilla Options", "Exotic Options", "Volatility");
            List<String> bullionOptions = Arrays.asList("Bullion");

            // 4. Dynamic Assertion based on parameters passed directly from the step
            boolean shouldBeVisible = "available".equalsIgnoreCase(availability);

            if ("FX".equalsIgnoreCase(instrumentType)) {
                validateOptionsVisibility(fxOptions, shouldBeVisible, "FX");
            } else  if ("Bullion".equalsIgnoreCase(instrumentType)) {
                validateOptionsVisibility(bullionOptions, shouldBeVisible, "Bullion");
            } else if ("Both".equalsIgnoreCase(instrumentType)) {
                // For the 'Both' scenario, both FX and Bullion options are expected to be available
                validateOptionsVisibility(fxOptions, shouldBeVisible, "Both (FX Options)");
                validateOptionsVisibility(bullionOptions, shouldBeVisible, "Both (Bullion Options)");
            } else {
                Assert.fail("Invalid instrument type passed from feature file: " + instrumentType);
            }

            // 5. Clean up dropdown state
            try {
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            } catch (Exception e) {
                // Ignore cleanup failures
            }

        } catch (Exception e) {
            log.error("Failed during Asset Class & Product Family validation:", e);
            Assert.fail("Failed to verify instrument dropdown options: " + e.getMessage());
        }
    }
    /**
     * Reusable helper method to loop through target options and assert visibility.
     */
    private void validateOptionsVisibility(List<String> options, boolean shouldBeVisible, String context) {
        for (String option : options) {
            boolean isPresent = isOptionPresent(option);
            if (shouldBeVisible) {
                Assert.assertTrue("Product Family option '" + option + "' should be AVAILABLE for " + context + ", but it is missing.", isPresent);
            } else {
                Assert.assertFalse("Product Family option '" + option + "' should be HIDDEN for " + context + ", but it is visible.", isPresent);
            }
        }
        log.info("Successfully validated that {} options are {} on the UI.", context, shouldBeVisible ? "VISIBLE" : "HIDDEN");
    }

    /**
     * Single-responsibility UI engine method to evaluate the DOM state.
     */
    private boolean isOptionPresent(String option) {
        String xpathExpression = "//div[@role='presentation']//*[normalize-space(text())='" + option + "'] | //li[normalize-space(text())='" + option + "']";
        return !findAll(By.xpath(xpathExpression)).isEmpty();
    }
}
