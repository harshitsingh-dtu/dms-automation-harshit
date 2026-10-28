package PageObjects.ApprovalAgreement;

import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import Utilities.ConfigFileReader;
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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.*;

@Slf4j
@Data
public class ApprovalAgreementCreatePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    ConfigFileReader configFileReader=new ConfigFileReader();

    @FindBy(xpath = "//div[text()='Approval agreement']")
    private WebElementFacade ApprovalAgreementTab;
    @FindBy(xpath = "//div[text()='Showing all Approval Agreements']")
    private WebElementFacade ApprovalAgreementDashboard;
    @FindBy(xpath = "//button[text()='+ Create New Approval Agreement']")
    private WebElementFacade CreateNewApprovalAgreementButton;
    @FindBy(xpath = "//div[text()='Select Prime Broker']")
    private WebElementFacade selectPB;
    @FindBy(xpath = "//div[text()='Select Executing Broker']")
    private WebElementFacade selectEB;
    @FindBy(xpath = "//div[text()='Traiana Approval language terms']")
    private WebElementFacade Traiana_Approval_language;
    @FindBy(xpath = "//div[text()='Traiana Approval language terms']/..//div[@class='clause-textarea']//p")
    List<WebElementFacade>  Traiana_Approval_language_text;
    @FindBy(xpath = "//div[text()='OSTTRA Approval language terms']")
    private WebElementFacade Osttra_Approval_language;
    @FindBy(xpath = "//div[text()='OSTTRA Approval language terms']/..//div[@class='clause-textarea']//p")
    List<WebElementFacade> Osttra_Approval_language_text;
    @FindBy(xpath = "//input[@value='Agreement Signed Externally']//parent::span")
    private WebElementFacade Agreement_Signed_Externally_radioButton;
    @FindBy(xpath = "//input[@value='Agreement Signed Externally']/ancestor::span[contains(@class,'Mui-checked')]")
    private WebElementFacade Agreement_Signed_Externally_radioButton_Checked;
    @FindBy(xpath = "//input[@value='Electronic Signature']//parent::span")
    private WebElementFacade Electronic_Signature_radioButton;
    @FindBy(xpath = "//input[@value='Electronic Signature']/ancestor::span[contains(@class,'Mui-checked')]")
    private WebElementFacade Electronic_Signature_radioButton_Checked;

    @FindBy(xpath = "//th[@data-testid='doc-table-th-agreementId']")
    private WebElementFacade AgreementID;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-pb1Name']")
    private WebElementFacade PBLegalEntityName;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-pb1']")
    private WebElementFacade PBLEI_ID;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-eb1Name']")
    private WebElementFacade EBLegalEntityName;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-eb1']")
    private WebElementFacade EBLEI_ID;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-status']")
    private WebElementFacade Status;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-action']")
    private WebElementFacade Action;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-updatedBy']")
    private WebElementFacade LastUpdatedBy;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-updatedOn']")
    private WebElementFacade LastUpdatedOn;

    @FindBy(xpath = "//div[@class='approval-creation-approvers'][1]//input[@role='combobox']")
    private WebElementFacade PBApproversCount;
    @FindBy(xpath = "//div[@class='approval-creation-approvers'][2]//input[@role='combobox']")
    private WebElementFacade EBApproversCount;
    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade ListOfApproversCount;
    @FindBy(xpath = "//div[text()='Please fill all required details for Approver details']")
    private WebElementFacade Validation_Warning;
    @FindBy(xpath = "//div[text()='Approval Agreement created']")
    private WebElementFacade Approval_Agreement_created_succesfully;
    @FindBy(xpath = "//div[text()='Approval Agreement updated']")
    private WebElementFacade Approval_Agreement_Updated;
    @FindBy(xpath = "//button[@aria-label='Disable']")
    private WebElementFacade Disable_button;
    @FindBy(xpath = "//div[text()='Agreement Disabled successfully']")
    private WebElementFacade Agreement_disabled_succesfully;
    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade ApproveButton;
    @FindBy(xpath = "//button[text()='Disapprove']")
    private WebElementFacade DisapproveButton;

    @FindBy(xpath = "//tbody//td[2]")
    private WebElementFacade PB_ApprovalAgreements;
    @FindBy(xpath = "//tbody//td[4]")
    private WebElementFacade EB_ApprovalAgreements;
    @FindBy(xpath = "//tbody//td[6]/span")
    private WebElementFacade Status_ApprovalAgreements;

    @FindBy(xpath = "(//button[@aria-label='Audit'])[1]")
    private WebElementFacade AuditButton;
    @FindBy(xpath = "//div[text()='Agreement History']")
    private WebElementFacade AgreementHistory;
    @FindBy(xpath = "//div[text()=': Approve']")
    private WebElementFacade ApproveStatusInAudit;
    @FindBy(xpath = "//div[@class='preview-container audit']//tbody//td[5]")
    List<WebElementFacade> AgreementDateInAudit;

    public void filterAndSelectColumnValues(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            String columnName = dataTable.get("Column Name").trim();
            String dataTestId = "";

            if (columnName.equalsIgnoreCase("Agreement Id") || columnName.equalsIgnoreCase("Agreement ID")) {
                dataTestId = "doc-table-th-agreementId";
            } else if (columnName.equalsIgnoreCase("PB Legal Entity Name") || columnName.equalsIgnoreCase("PB legal entity name")) {
                dataTestId = "doc-table-th-pb1Name";
            } else if (columnName.equalsIgnoreCase("PB LEI")) {
                dataTestId = "doc-table-th-pb1";
            } else if (columnName.equalsIgnoreCase("EB Legal Entity Name") || columnName.equalsIgnoreCase("EB legal entity name")) {
                dataTestId = "doc-table-th-eb1Name";
            } else if (columnName.equalsIgnoreCase("EB LEI")) {
                dataTestId = "doc-table-th-eb1";
            } else if (columnName.equalsIgnoreCase("Status")) {
                dataTestId = "doc-table-th-status";
            } else if (columnName.equalsIgnoreCase("Last Updated By") || columnName.equalsIgnoreCase("Last updated by")) {
                dataTestId = "doc-table-th-updatedBy";
            } else if (columnName.equalsIgnoreCase("Last Updated On") || columnName.equalsIgnoreCase("Last updated on")) {
                dataTestId = "doc-table-th-updatedOn";
            }

            WebElementFacade filterOnListingScreen;
            if (!dataTestId.isEmpty()) {
                filterOnListingScreen = find(By.xpath("//th[@data-testid='" + dataTestId + "']//input"));
            } else {
                filterOnListingScreen = find(By.xpath("//th[contains(.,'" + columnName + "')]//input"));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);

            // 1. Robustly clear the field
            filterOnListingScreen.waitUntilClickable().click();
            withAction().pause(Duration.ofMillis(500)).build().perform();
            filterOnListingScreen.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            // 2. Type and Select Value
            if (dataTable.get("Column Name").contains("PB") || dataTable.get("Column Name").contains("EB")) {
                filterOnListingScreen.sendKeys(dataTable.get("value"));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String targetVal = dataTable.get("value").trim().toLowerCase();
                WebElementFacade valueOnListingScreen = find(By.xpath("//div[@role='presentation']//*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')=\"" + targetVal + "\"]"));
                valueOnListingScreen.waitUntilVisible().click();
            } else {
                filterOnListingScreen.sendKeys(dataTable.get("value"));
                withAction().pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            }

            withAction().pause(Duration.ofSeconds(5)).build().perform();

            // 3. CLEANUP: Hit clear button to clear the value if displayed (only for single-filter scenarios)
            if (data.size() == 1) {
                try {
                    String clearButtonXpath = !dataTestId.isEmpty() 
                        ? ("//th[@data-testid='" + dataTestId + "']//input//..//button[@title='Clear']") 
                        : ("//th[contains(.,'" + columnName + "')]//input//..//button[@title='Clear']");
                    WebElementFacade clearBtn = find(By.xpath(clearButtonXpath));
                    if (clearBtn.isCurrentlyVisible() && clearBtn.isEnabled()) {
                        clearBtn.click();
                        withAction().pause(Duration.ofSeconds(3)).build().perform();
                    }
                } catch (Exception e) {
                    log.info("Clear button not visible or clickable, skipping cleanup: " + e.getLocalizedMessage());
                }
            }
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
    }

    public void selectLEI(DataTable table) {
        List<List<String>> leilist = table.asLists();
        for (List<String> columns : leilist) {
            switch (columns.get(0)) {
                case "Prime Broker":
                    selectPB.waitUntilVisible();
                    act.moveToElement(selectPB).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                    act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    break;
                case "Executing Broker":
                    act.moveToElement(selectEB).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                    act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    break;
            }
        }
    }
    public void PBApproversDetails(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            WebElementFacade filterOnListingScreen = find(By.xpath("(//input[@name='" + dataTable.get("Field Name") + "'])[1]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);
            getJavascriptExecutorFacade().executeScript("window.scrollBy(-100,0)");
            filterOnListingScreen.click();
            filterOnListingScreen.clear();
            withAction().sendKeys(dataTable.get("Values")).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }
    public void EBApproversDetails(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            WebElementFacade filterOnListingScreen = find(By.xpath("(//input[@name='" + dataTable.get("Field Name") + "'])[2]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);
            getJavascriptExecutorFacade().executeScript("window.scrollBy(-20,0)");
            filterOnListingScreen.click();
            filterOnListingScreen.clear();
            withAction().sendKeys(dataTable.get("Values")).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }
    public Boolean TrianaApprovalLanguage()
    {
        boolean result = false;
        StringBuilder actual = new StringBuilder();
        String expected="Notwithstanding any provision contained under any master give-up agreement (\"MGUP\") between (1) the Dealer and/or the Executing Broker, as applicable, and (2) the Prime Broker governing the issuance of a Designation Notice (as defined below) which purpose is for the Prime Broker to designate a counterparty (\"Designated Party\") to enter into transactions on its behalf with the Dealer and/or the Executing Broker, as applicable, and applying the specified trading parameters applicable to such Designated Party, the Prime Broker and the Dealer and/or the Executing Broker, as applicable, hereby agree and acknowledge that to the extent that a Designation Notice is issued through the CreditLink DNM platform operated by Traiana Harmony TM for the purposes of Designation Notice issuance and management (the \"System\"), the Designation Notice's terms described under the MGUP are hereby restated by the applicable Designation Notice's terms under the System. The parties using the System hereby agree, by accepting the following terms and conditions, that to the extent a Designation Notice is issued through the System, the parties consent to amend their MGUP in relation to the Designation Notice by applying the issuance and notification process as provided by the System's terms and conditions, and hereby waive any requirement under their MGUP by which any amendment to the MGUP has to be agreed in writing or be delivered in a specified manner or to a specified destination. Notwithstanding the foregoing, the parties agree that any purported amendments to the MGUP made outside the System shall be made pursuant to the terms of the relevant MGUP." +
                "\"Designation Notice\" means (i) a notice substantially in the form described under the MGUP with the Dealer and/or the Executing Broker, as applicable, (\"Paper DN\"), and/or (ii) an electronic designation notice (\"EDN\") transmitted from the Prime Broker to the Dealer and/or the Executing Broker, as applicable, via the System, each or both as may be amended from time to time in accordance with the terms of the MGUP. For the avoidance of doubt, the Prime Broker and the Dealer and/or the Executing Broker, as applicable, hereby agree that an EDN shall constitute a legally binding and enforceable agreement between the parties. For the further avoidance of doubt, the Prime Broker and the Dealer and/or the Executing Broker, as applicable, agree that a Designation Notice may be (i) sent as, (ii) amended by or (iii) terminated by, a Paper DN and/or an EDN, and in the event of any inconsistency between a Paper DN and an EDN, the Designation Notice issued later in time shall prevail with respect to the term(s) being established or amended." +
                "\"Prime Broker\" means the party designated as \"PB\" in the System that is the party under the MGUP designating a Designated Party to enter into transactions on its behalf with a Dealer or Executing Broker." +
                "\"Dealer or Executing Broker\" means the party designated as \"EB\" in the System that is the party under the MGUP designated to enter into transactions with certain counterparties designated by the Prime Broker as Designated Parties.";

        for(int i =0;i<Traiana_Approval_language_text.size();i++){
            actual.append(Traiana_Approval_language_text.get(i).getText());
        }
        if(expected.equalsIgnoreCase(String.valueOf(actual))){
            result = true;
    }
    return result;
    }
    public Boolean OsttraApprovalLanguage()
    {
        boolean result = false;
        StringBuilder actual = new StringBuilder();
        String expected="Notwithstanding any provision contained under any master give-up agreement (\"MGUP\") between (1) the Dealer and/or the Executing Broker, as applicable, and (2) the Prime Broker governing the issuance of a Designation Notice (as defined below) which purpose is for the Prime Broker to designate a counterparty (\"Designated Party\") to enter into transactions on its behalf with the Dealer and/or the Executing Broker, as applicable, and applying the specified trading parameters applicable to such Designated Party, the Prime Broker and the Dealer and/or the Executing Broker, as applicable, hereby agree and acknowledge that to the extent that a Designation Notice is issued through the Osttra Documentation Center platform for the purposes of Designation Notice issuance and management (the \"System\"), the Designation Notice's terms described under the MGUP are hereby restated by the applicable Designation Notice's terms under the System. The parties using the System hereby agree, by accepting the following terms and conditions, that to the extent a Designation Notice is issued through the System, the parties consent to amend their MGUP in relation to the Designation Notice by applying the issuance and notification process as provided by the System's terms and conditions, and hereby waive any requirement under their MGUP by which any amendment to the MGUP has to be agreed in writing or be delivered in a specified manner or to a specified destination. Notwithstanding the foregoing, the parties agree that any purported amendments to the MGUP made outside the System shall be made pursuant to the terms of the relevant MGUP." +
                "\"Designation Notice\" means (i) a notice substantially in the form described under the MGUP with the Dealer and/or the Executing Broker, as applicable, (\"Paper DN\"), and/or (ii) an electronic designation notice (\"EDN\") transmitted from the Prime Broker to the Dealer and/or the Executing Broker, as applicable, via the System, each or both as may be amended from time to time in accordance with the terms of the MGUP. For the avoidance of doubt, the Prime Broker and the Dealer and/or the Executing Broker, as applicable, hereby agree that an EDN shall constitute a legally binding and enforceable agreement between the parties. For the further avoidance of doubt, the Prime Broker and the Dealer and/or the Executing Broker, as applicable, agree that a Designation Notice may be (i) sent as, (ii) amended by or (iii) terminated by, a Paper DN and/or an EDN, and in the event of any inconsistency between a Paper DN and an EDN, the Designation Notice issued later in time shall prevail with respect to the term(s) being established or amended." +
                "\"Prime Broker\" means the party designated as \"PB\" in the System that is the party under the MGUP designating a Designated Party to enter into transactions on its behalf with a Dealer or Executing Broker." +
                "\"Dealer or Executing Broker\" means the party designated as \"EB\" in the System that is the party under the MGUP designated to enter into transactions with certain counterparties designated by the Prime Broker as Designated Parties.";
        for(int i =0;i<Osttra_Approval_language_text.size();i++){
            actual.append(Osttra_Approval_language_text.get(i).getText());
        }
        if(expected.equalsIgnoreCase(String.valueOf(actual))){
            result = true;
        }
        return result;
    }
    public boolean AuditAndUserDetails(DataTable table) {
        boolean result = false;
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            String event = dataTable.get("Audit Event");
            String user = dataTable.get("User");
            WebElementFacade row = find(By.xpath("//tbody/tr[td[contains(text(),'" + event + "')] and td[contains(text(),'" + user + "')]]"));
            if (row.isDisplayed()) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }
    public static String theMonth(int month){
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    public boolean validateDate(){
        boolean result = false;
        Calendar cal = Calendar.getInstance();
        String year = String.valueOf(cal.get(Calendar.YEAR));
        String day = String.format("%02d", cal.get(Calendar.DATE));
        String daySingle = String.valueOf(cal.get(Calendar.DATE));
        String month = String.format("%02d", cal.get(Calendar.MONTH) + 1);

        String format1 = daySingle + theMonth(cal.get(Calendar.MONTH)) + year; // "14July2026"
        String format2 = month + "/" + day + "/" + year; // "07/14/2026"
        String format3 = day + "/" + month + "/" + year; // "14/07/2026"

        for(WebElementFacade Agreementdate : AgreementDateInAudit) {
            String text = Agreementdate.getText().trim();
            if (text.contains(format1) || text.contains(format2) || text.contains(format3) || (text.contains(year) && (text.contains(day) || text.contains(daySingle)))) {
                result = true;
            }
        }
        return result;
    }
    public void validateDropdownValuesNotDisplayed(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            String columnName = dataTable.get("Column Name").trim();
            String targetVal = dataTable.get("value").trim();
            String dataTestId = "";

            if (columnName.equalsIgnoreCase("Agreement Id") || columnName.equalsIgnoreCase("Agreement ID")) {
                dataTestId = "doc-table-th-agreementId";
            } else if (columnName.equalsIgnoreCase("PB Legal Entity Name") || columnName.equalsIgnoreCase("PB legal entity name")) {
                dataTestId = "doc-table-th-pb1Name";
            } else if (columnName.equalsIgnoreCase("PB LEI")) {
                dataTestId = "doc-table-th-pb1";
            } else if (columnName.equalsIgnoreCase("EB Legal Entity Name") || columnName.equalsIgnoreCase("EB legal entity name")) {
                dataTestId = "doc-table-th-eb1Name";
            } else if (columnName.equalsIgnoreCase("EB LEI")) {
                dataTestId = "doc-table-th-eb1";
            } else if (columnName.equalsIgnoreCase("Status")) {
                dataTestId = "doc-table-th-status";
            } else if (columnName.equalsIgnoreCase("Last Updated By") || columnName.equalsIgnoreCase("Last updated by")) {
                dataTestId = "doc-table-th-updatedBy";
            } else if (columnName.equalsIgnoreCase("Last Updated On") || columnName.equalsIgnoreCase("Last updated on")) {
                dataTestId = "doc-table-th-updatedOn";
            }

            WebElementFacade filterOnListingScreen;
            if (!dataTestId.isEmpty()) {
                filterOnListingScreen = find(By.xpath("//th[@data-testid='" + dataTestId + "']//input"));
            } else {
                filterOnListingScreen = find(By.xpath("//th[contains(.,'" + columnName + "')]//input"));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterOnListingScreen);

            // Clear the input and enter the value to search
            filterOnListingScreen.click();
            filterOnListingScreen.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            filterOnListingScreen.sendKeys(targetVal);

            // Wait for dropdown to evaluate the search
            withAction().pause(Duration.ofSeconds(3)).build().perform();

            // Convert target value to lower case for case-insensitive XPath comparison
            String lowerTargetVal = targetVal.toLowerCase();
            String valueOnListingScreenXPath = "//div[@role='presentation']//*[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')=\"" + lowerTargetVal + "\"]";

            // Use findAll() to check if the element exists without throwing a NoSuchElementException
            boolean isValuePresent = !findAll(By.xpath(valueOnListingScreenXPath)).isEmpty();

            // Assert that the value is NOT present in the dropdown
            Assert.assertFalse("Validation Failed: The value '" + targetVal + "' SHOULD NOT be displayed under '" + columnName + "', but it was found in the dropdown!", isValuePresent);

            log.info("Successfully validated that '" + targetVal + "' is NOT displayed in the dropdown for column: " + columnName);

            // Clear the filter text so it doesn't affect the next iteration
            filterOnListingScreen.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
        }
    }

    public void applyPBFilterAndRefresh(String expectedName) {
        try {
            // 1. Locate the PB legal entity name input box
            WebElementFacade pbFilterInput = find(By.xpath("//th[contains(., 'PB legal entity name')]//input"));

            // 2. Click, clear, and type the expected name
            pbFilterInput.waitUntilClickable().click();
            pbFilterInput.clear();
            pbFilterInput.sendKeys(expectedName);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // 3. Attempt to click the dropdown list option that appears
            try {
                WebElementFacade dropdownOption = find(By.xpath("//li[@role='option' and contains(normalize-space(.), '" + expectedName + "')]"));
                dropdownOption.waitUntilClickable().click();
            } catch (Exception e) {
                // If the list option isn't found, try pressing ENTER as a fallback
                pbFilterInput.sendKeys(Keys.ENTER);
            }

            // 4. Click outside the box (clicking the main body) to force the UI to apply the filter
            find(By.xpath("//body")).click();

            // Pause to let the table network call complete
            withAction().pause(Duration.ofSeconds(3)).build().perform();

        } catch (Exception e) {
            System.out.println("Warning: Manual filter workaround failed: " + e.getMessage());
        }
    }
}