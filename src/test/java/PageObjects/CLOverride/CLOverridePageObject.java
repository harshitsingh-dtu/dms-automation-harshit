package PageObjects.CLOverride;

import Utilities.ConfigFileReader;

import java.security.SecureRandom;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class CLOverridePageObject extends PageObject {
    Actions act = new Actions(getDriver());
    ConfigFileReader configFileReader = new ConfigFileReader();

    // Add this variable at the class level to store the runtime typed text
    private String actualTypedText = "";
    // Add this variable at the class level to temporarily store the dynamic value
    private String lastTypedPBText = "";

    // Fixed: Pointed Logger directly to this class context
    private static final Logger log = LoggerFactory.getLogger(CLOverridePageObject.class);

    @FindBy(xpath = "//div[text()='CreditLink override']")
    private WebElementFacade CLOverrideTab;
    @FindBy(xpath = "//header[text()='Organisations']")
    private WebElementFacade CLOverridePage;
    @FindBy(xpath = "(//div[@class='lei-list-header']//input)[1]")
    private WebElementFacade CLOverrideDocTypeDD;
    @FindBy(xpath = "//div[@class='lei-list-header']//button[@title='Clear']")
    private WebElementFacade CLOverrideDocTypeDD_Clear;
    @FindBy(xpath = "(//div[@class='override-id-input']//input)[1]")
    private WebElementFacade PB_Override_Box;
    @FindBy(xpath = "(//div[@class='override-id-input']//input)[2]")
    private WebElementFacade EB_Override_Box;
    @FindBy(xpath = "(//div[@class='override-id-input']//input)[3]")
    private WebElementFacade Client_Override_Box;
    @FindBy(xpath = "(//div[@class='override-id-input']//input)[2]")
    private WebElementFacade Client_Override_Box2;
    @FindBy(xpath = "//tbody//button[@title='Clear']")
    private WebElementFacade Clear_textBox;

    @FindBy(xpath = "(//button[@aria-label='Edit'])[1]")
    private WebElementFacade PB_Override_SaveIcon;
    @FindBy(xpath = "(//button[@aria-label='Edit'])[1]")
    private WebElementFacade Override_value_SaveIcon;
    @FindBy(xpath = "(//button[@aria-label='History'])[1]")
    private WebElementFacade PB_Override_AuditIcon;
    @FindBy(xpath = "//*[text()='CL Override History']")
    private WebElementFacade CL_OverrideHistoryScreen;
    @FindBy(xpath = "(//table[@class='audit-table']//tbody//tr)[1]//td[3]")
    private WebElementFacade CL_OverrideUpdatedByFirstRow;
    @FindBy(xpath = "//li[span[text()='PB Override ID']]")
    private WebElementFacade CL_OverrideEventChangesFirstRow;
    @FindBy(xpath = "(//th//div[text()='LEI'])")
    private WebElementFacade Lei_Table_header;
    @FindBy(xpath = "(//th//div[text()='Legal entity name'])")
    private WebElementFacade LeiName_Table_header;
    @FindBy(xpath = "(//th//div[text()='Action'])")
    private WebElementFacade Action_Table_header;
    @FindBy(xpath = "//div[@class='info-head' and text()='Organisation id']")
    private WebElementFacade Org_id_header;
    @FindBy(xpath = "//div[@class='info-head' and text()='Organisation name']")
    private WebElementFacade Org_name_header;
    @FindBy(xpath = "//div[@class='info-head' and text()='Active users']")
    private WebElementFacade Active_user_header;
    @FindBy(xpath = "//div[@class='info-head' and text()='Total users']")
    private WebElementFacade Total_user_header;
    @FindBy(xpath = "//*[local-name()='svg' and @class='close-icon']")
    private WebElementFacade closeHistory_btn;
    @FindBy(xpath = "//div[@class='content-label' and text()='Organisation information']")
    private WebElementFacade organisationInformation_label;
    @FindBy(xpath = "//div[div[text()='Roles']]/h4")
    private WebElementFacade rolesTextElement;

    @FindBy(xpath = "(//input[contains(@data-testid,'-PBOverrideId')])[1]")
    private WebElementFacade PB_Override_Input_TestId;

    @FindBy(xpath = "(//button[contains(@data-testid,'edit-save-btn-')])[1]")
    private WebElementFacade PB_EditSave_Btn_TestId;

    @FindBy(xpath = "(//button[contains(@data-testid,'clear-btn-') and contains(@data-testid,'-PBOverrideId')])[1]")
    private WebElementFacade PB_Clear_Btn_TestId;

    public void selectDocType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        //clearing Drop Down Value
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", CLOverrideDocTypeDD);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        CLOverrideDocTypeDD.click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        CLOverrideDocTypeDD_Clear.click();

        //Entering the DocType Value in Drop-Down
        withAction()
                .moveToElement(CLOverrideDocTypeDD)
                .click()
                .sendKeys(dataTable.get("Doc Type"))
                .build()
                .perform();

        withAction().pause(Duration.ofMillis(500)).build().perform();

        WebElementFacade hoveredOption = find(
                By.xpath("//*[normalize-space(text())='" + dataTable.get("Doc Type") + "']")
        );

        getJavascriptExecutorFacade().executeScript("arguments[0].click();", hoveredOption);
    }

    public String getCurrentTimeStamp() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy HH");
        return dateFormat.format(cal.getTime());
    }

    public void enterTextInPB(String text) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", PB_Override_Box);
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        if (Clear_textBox.isCurrentlyVisible()) {
            Clear_textBox.click();
        }

        // Generate the dynamic random text segment
        String randomText = org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(5);

        // Construct the complete exact text being submitted
        this.lastTypedPBText = text + " " + randomText + " " + getCurrentTimeStamp();

        // Send the exact constructed string to the input field
        withAction().moveToElement(PB_Override_Box).click().sendKeys(this.lastTypedPBText).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void enterTextInPBOnly(String text) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", PB_Override_Box);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (Clear_textBox.isCurrentlyVisible()) {
            Clear_textBox.click();
        }
        withAction().moveToElement(PB_Override_Box).click().sendKeys(text).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public String getRandomText(int maxLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        int length = random.nextInt(maxLength) + 1;
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public void enterTextInPBInput() {
        String randomText = getRandomText(10);

        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                PB_Override_Box
        );
        withAction()
                .moveToElement(PB_Override_Box)
                .click()
                .sendKeys(randomText)
                .build()
                .perform();

        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void enterTextInEB() {
        String randomText = getRandomText(10);

        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                EB_Override_Box
        );
        withAction()
                .moveToElement(EB_Override_Box)
                .click()
                .sendKeys(randomText)
                .build()
                .perform();

        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void enterTextInClient() {
        String randomText = getRandomText(10);

        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                Client_Override_Box
        );
        withAction()
                .moveToElement(Client_Override_Box)
                .click()
                .sendKeys(randomText)
                .build()
                .perform();

        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void enterTextInClientFor4Way() {
        String randomText = getRandomText(10);

        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                Client_Override_Box2
        );
        withAction()
                .moveToElement(Client_Override_Box2)
                .click()
                .sendKeys(randomText)
                .build()
                .perform();

        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void removeTextInPB() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", PB_Override_Box);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (Clear_textBox.isCurrentlyVisible()) {
            Clear_textBox.click();
        }
    }

    public void removeTextInEB() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EB_Override_Box);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (Clear_textBox.isCurrentlyVisible()) {
            Clear_textBox.click();
        }
    }

    public void removeTextInClient() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Client_Override_Box);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (Clear_textBox.isCurrentlyVisible()) {
            Clear_textBox.click();
        }
    }

    public void removeTextInClientFor4way() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Client_Override_Box2);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (Clear_textBox.isCurrentlyVisible()) {
            Clear_textBox.click();
        }
    }


    public boolean ValidateDataInHistoryTab(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);

        String uiUpdatedBy = CL_OverrideUpdatedByFirstRow.getText().trim();
        String uiEventChanges = CL_OverrideEventChangesFirstRow.getText().trim();

        log.info("[DEBUG] --- START AUDIT HISTORY TAB VALIDATION ---");
        log.info("[DEBUG] UI Text Captured - Updated By   : '{}'", uiUpdatedBy);
        log.info("[DEBUG] UI Text Captured - Event Changes : '{}'", uiEventChanges);
        log.info("[DEBUG] Class Stored Variable (lastTypedPBText): '{}'", this.lastTypedPBText);

        if (dataTable.get("Event Changes").contains("PB Override ID was Added")) {
            String baseExpectedFromTable = dataTable.get("Event Changes").trim();
            String expectedFinalString;

            if (this.lastTypedPBText != null && !this.lastTypedPBText.isEmpty()) {
                int firstQuoteIndex = baseExpectedFromTable.indexOf("'");
                String messagePrefix = baseExpectedFromTable.substring(0, firstQuoteIndex + 1);
                expectedFinalString = messagePrefix + this.lastTypedPBText + "'";

                this.lastTypedPBText = ""; // Context reset
            } else {
                int lastQuoteIndex = baseExpectedFromTable.lastIndexOf("'");
                expectedFinalString = baseExpectedFromTable.substring(0, lastQuoteIndex)
                        + " " + getCurrentTimeStamp() + "'";
            }

            boolean isUpdatedByCorrect = uiUpdatedBy.equalsIgnoreCase(dataTable.get("Updated By").trim());
            boolean isEventChangesCorrect = uiEventChanges.equalsIgnoreCase(expectedFinalString);

            //log.info("[DEBUG] Expected Values vs Actual UI Elements:");
            //log.info("[DEBUG] -> Updated By | Expected: '{}' | Actual: '{}' | Match: {}", dataTable.get("Updated By").trim(), uiUpdatedBy, isUpdatedByCorrect);
           // log.info("[DEBUG] -> Event Chg  | Expected: '{}' | Actual: '{}' | Match: {}", expectedFinalString, uiEventChanges, isEventChangesCorrect);
            //log.info("[DEBUG] --- END AUDIT HISTORY TAB VALIDATION ---");

            return isUpdatedByCorrect && isEventChangesCorrect;
        } else {
            boolean isUpdatedByCorrect = uiUpdatedBy.equalsIgnoreCase(dataTable.get("Updated By").trim());
            boolean isEventChangesCorrect = uiEventChanges.equalsIgnoreCase(dataTable.get("Event Changes").trim());

            //log.info("[DEBUG] -> Standard Check - Updated By Match: {} | Event Changes Match: {}", isUpdatedByCorrect, isEventChangesCorrect);
            //log.info("[DEBUG] --- END AUDIT HISTORY TAB VALIDATION ---");

            return isUpdatedByCorrect && isEventChangesCorrect;
        }
    }

    public boolean validateAuditHistoryData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);
        String actualUpdatedBy = CL_OverrideUpdatedByFirstRow.waitUntilVisible().getText().trim();
        String actualEventChanges = CL_OverrideEventChangesFirstRow.getText().trim();
        String expectedUpdatedBy = dataTable.get("Updated By").trim();
        String expectedEventChanges = dataTable.get("Event Changes").trim();
        System.out.println("Audit Validation - Actual User: " + actualUpdatedBy + " | Expected: " + expectedUpdatedBy);
        System.out.println("Audit Validation - Actual Event: " + actualEventChanges + " | Expected: " + expectedEventChanges);
        boolean isUpdatedByCorrect = actualUpdatedBy.equalsIgnoreCase(expectedUpdatedBy);
        boolean isEventChangesCorrect = actualEventChanges.equalsIgnoreCase(expectedEventChanges);
        return isUpdatedByCorrect && isEventChangesCorrect;
    }

    public boolean validateSavedMessage(String errMessage) {
        try {
            return withTimeoutOf(Duration.ofSeconds(10))
                    .find(By.xpath("//*[contains(text(),'" + errMessage + "')]"))
                    .isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public void checkMaximumLength() {
        String inputString = "MhuW8plBUsvETzHhhPIe7Cz4AqykdgLQWNr2w1eSRAhl7VUvcvxYLFZ1ntIVGZqpmVbh8YvQTY2C57BA69qfMikSLTfba5BKQ6jW8";
        if (inputString.length() != 101) {
            throw new RuntimeException("Test data error: inputString is not 101 characters.");
        }
        PB_Override_Box.clear();
        PB_Override_Box.sendKeys(inputString);
        String actualValuePB = PB_Override_Box.getAttribute("value");
        Assert.assertEquals("Field allowed more than 100 characters!", 100, actualValuePB.length());
    }

    public void validateTableHeaders() {
        Lei_Table_header.isDisplayed();
        LeiName_Table_header.isDisplayed();
        Action_Table_header.isDisplayed();
    }

    public void validateUpdateScreenColumnHeaders() {
        Org_id_header.shouldBeVisible();
        Org_name_header.shouldBeVisible();
        Active_user_header.shouldBeVisible();
        Total_user_header.shouldBeVisible();
    }

    public void closeHistorySidebar() {
        closeHistory_btn.waitUntilClickable().click();
    }

    public void validateOrganisationInformationVisible() {
        organisationInformation_label.shouldBeVisible();
    }

    public boolean verifyRequiredRoles(List<String> requiredRoles) {
        try {
            String actualRoles = rolesTextElement.waitUntilVisible().getText();
            for (String role : requiredRoles) {
                if (!actualRoles.contains(role)) {
                    log.error("Role missing: " + role);
                    return false;
                }
            }
            log.info("All required roles verified: " + requiredRoles);
            return true;
        } catch (Exception e) {
            log.error("Unable to verify roles: " + e.getMessage());
            return false;
        }
    }
    public void clearPBOverrideIfPresent() {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", PB_Override_Input_TestId);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        String pbValue = PB_Override_Input_TestId.getAttribute("value");
        log.info("[DEBUG] Current PB Override value: '{}'", pbValue);

        if (pbValue != null && !pbValue.trim().isEmpty()) {
            PB_EditSave_Btn_TestId.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            if (PB_Clear_Btn_TestId.isCurrentlyVisible()) {
                PB_Clear_Btn_TestId.click();
            } else {
                PB_Override_Input_TestId.clear();
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            PB_EditSave_Btn_TestId.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            log.info("[DEBUG] PB Override text cleared and saved.");
        } else {
            log.info("[DEBUG] PB Override field already empty - no action taken.");
        }
    }

}