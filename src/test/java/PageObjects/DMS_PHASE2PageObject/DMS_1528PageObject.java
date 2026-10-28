package PageObjects.DMS_PHASE2PageObject;

import PageObjects.Documents.DocumentCreateNewPageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;

import java.text.SimpleDateFormat;
import static org.assertj.core.api.Assertions.fail;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Data
public class DMS_1528PageObject extends PageObject {

    public static List<String> generatedTemplateNames = new ArrayList<>();

    //Document template screen
    @FindBy(xpath = "//button[text()='+ Create New Template']")
    private WebElementFacade Create_New_Template_Btn;
    @FindBy(xpath = "//div[@data-testid='template-title'] | //*[normalize-space()='Document templates' or contains(text(),'Document templates')] | //p[contains(text(),'Showing all document templates')]")
    private WebElementFacade Documenttemplate_text;

    //Create new Document template Screen
    @FindBy(xpath = "//div[text()='Create new document template']")
    private WebElementFacade CreateNewDocumentTemplate_Txt;
    @FindBy(xpath = "//input[@placeholder='Enter template name']")
    private WebElementFacade EnterTemplateName;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade OrganisationDropdown;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctypeDropdown;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filtereddoctype;

    @FindBy(xpath = "//p[text()='4 Way']")
    private WebElementFacade fourWaydoctypefromdropdown;
    @FindBy(xpath = "//p[text()='DN']")
    private WebElementFacade DNdoctypefromdropdown;
    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade nooptionfordoctype;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade Next_Button;

    //Update Document template screen
    @FindBy(xpath = "//div[text()='Update document template']")
    private WebElementFacade Update_document_template_text;
    @FindBy(xpath = "//div[text()='Document template information']")
    private WebElementFacade Document_template_information_text;
    @FindBy(xpath = "//div[text()='Template name*']")
    private WebElementFacade templatename_text;
    @FindBy(xpath = "//div[text()='Organisation']")
    private WebElementFacade organization_text;
    @FindBy(xpath = "//div[text()='Doc type']")
    private WebElementFacade doctype_text;
    @FindBy(xpath = "//button[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'approval workflow')]")
    private WebElementFacade approval_workflowTab;
    @FindBy(xpath = "//button[text()='Enforcement rules']")
    private WebElementFacade enforcement_ruleTab;
    @FindBy(xpath = "//button[text()='Document terms']")
    private WebElementFacade legal_termTab;
    @FindBy(xpath = "//button[text()='Discard']")
    private WebElementFacade DiscardButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade CancelButton;
    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade save_as_draftButton;

    //Appproval Workflow Tab
    @FindBy(xpath = "//div[text()='Participants']")
    private WebElementFacade Participants_text;
    @FindBy(xpath = "//div[@class='drag-box  '][text()='Initiator']")
    private WebElementFacade Initiator_button;
    @FindBy(xpath = "//div[@class='drag-box  '][text()='Prime Broker - 1']")
    private WebElementFacade PrimeBroker1_button;
    @FindBy(xpath = "//div[@class='drag-box  '][text()='Prime Broker - 2']")
    private WebElementFacade PrimeBroker2_button;
    @FindBy(xpath = "//div[@class='drag-box  '][text()='Executing Broker - 1']")
    private WebElementFacade ExecutingBroker1_button;
    @FindBy(xpath = "//div[@class='drag-box  '][text()='Client - 1']")
    private WebElementFacade Client1_button;
    @FindBy(xpath = "//div[@class='drag-box  '][text()='Client - 2']")
    private WebElementFacade Client2_button;


    @FindBy(xpath = "//table[@class='workflow-table']")
    private WebElementFacade approvalworkflow_table;
    @FindBy(xpath = "//div[@role='alert']//div[2]")
    private WebElementFacade Alert_Message_for_ApprovalMatrix;
    @FindBy(xpath = "(//div[@class='card']//*[name()='svg'])[1]")
    private WebElementFacade Crossbutton_for_RemoveParticipants_From_ApprovalSqquence;

    //Enforcement tab
    @FindBy(xpath = "//div[text()='For new document']")
    private WebElementFacade fornewdocument_text;
    @FindBy(xpath = "//div[text()='For amendment']")
    private WebElementFacade foramendment_text;
    @FindBy(xpath = "//div[text()='For termination']")
    private WebElementFacade fortermination_text;
    @FindBy(xpath = "//label[@for='Immediate1']")
    private WebElementFacade fornewdocument_immediateRadio;
    @FindBy(xpath = "//label[@for='Immediate2']")
    private WebElementFacade foramendment_immediateRadio;
    @FindBy(xpath = "//label[@for='Immediate3']")
    private WebElementFacade fortermination_immediateRadio;
    @FindBy(xpath = "//label[@for='Scheduled1']")
    private WebElementFacade fornewdocument_ScheduleRadio;
    @FindBy(xpath = "//label[@for='Scheduled2']")
    private WebElementFacade foramendment_ScheduleRadio;
    @FindBy(xpath = "//label[@for='Scheduled3']")
    private WebElementFacade fortermination_ScheduleRadio;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][1]//input[@type='number']")
    private WebElementFacade valuefor_fornewdocument_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][2]//input[@type='number']")
    private WebElementFacade valuefor_foramendment_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][3]//input[@type='number']")
    private WebElementFacade valuefor_fortermination_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][1]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fornewdocument_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][2]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_foramendment_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][3]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fortermination_Schedule;

    //legal term screen
    @FindBy(xpath = "//div[@class='ck ck-presence-list__counter']")
    private WebElementFacade connecteduser_text;
    @FindBy(xpath = "//p[@data-placeholder='Type or paste your content here!']")
    private WebElementFacade Ck_editor;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submitbutton;
    @FindBy(xpath = "//*[text()='Document Template History']")
    private WebElementFacade DocumentTemplate_HistoryScreen;
    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'edit']")
    private WebElementFacade EditButton;
    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'delete']")
    private WebElementFacade DeleteButton;

    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[1]")
    private WebElementFacade Template_AuditID;
    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[2]")
    private WebElementFacade Template_Name_HistoryScreen;
    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[3]")
    private WebElementFacade Template_OrgName_HistoryScreen;
    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[4]")
    private WebElementFacade Template_AuditEvent_HistoryScreen;
    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[5]")
    private WebElementFacade Template_Date_HistoryScreen;
    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[6]")
    private WebElementFacade Template_UpdatedBy_HistoryScreen;
    @FindBy(xpath = "//div[@class='preview-container audit document-template-audit-container']//tbody//tr[1]//td[7]//p")
    private WebElementFacade Template_EventsChanges_HistoryScreen;
    @FindBy(xpath = "(//span[contains(text(), 'View Content')]//parent::div)[1]")
    private WebElementFacade Template_EventsChanges_DropDown;

    @FindBy(xpath = "//input[@id = 'select-all-checkbox-id-Deliverable']")
    private WebElementFacade filterBoxDocTemplate;

    @FindBy(xpath = "//table//tr/td[2]")
    private List<WebElementFacade> organisationNameCells;
    @FindBy(xpath = "//button[contains(text(),'View')]")
    private List<WebElementFacade> viewButtonsList;

    // Locators for restricted actions to ensure 'View All' role is enforced
    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    private List<WebElementFacade> editButtonsList;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    private List<WebElementFacade> deleteButtonsList;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElementFacade> tableRows;

    public void Entertemplatename(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            EnterTemplateName.waitUntilClickable();
            Assert.assertTrue(EnterTemplateName.isVisible());
            withAction().moveToElement(EnterTemplateName).click().sendKeys(dataTable.get("Template Name") + RandomStringUtils.randomAlphabetic(5)).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to input into Template Name-->" + e);
            Assert.fail();
        }
    }

    public void SelectOrganisationName(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            OrganisationDropdown.waitUntilVisible();
            Assert.assertTrue(OrganisationDropdown.isVisible());
            withAction().moveToElement(OrganisationDropdown).click().sendKeys(dataTable.get("Organisation Name")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Organisation Name-->" + e);
            Assert.fail();
        }
    }
    public void SelectDocType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doctypeDropdown.waitUntilVisible();
            Assert.assertTrue(doctypeDropdown.isVisible());
            withAction().moveToElement(doctypeDropdown).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Doc Type-->" + e);
            Assert.fail();
        }
    }

    public void filtereddoctype(List<String> doctypelist) {

        try {
            for (int begin = 1; begin < doctypelist.size(); begin++) {
                doctypeDropdown.waitUntilClickable().click();
                doctypeDropdown.type(doctypelist.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(doctypelist.get(begin), filtereddoctype.getText());
                doctypeDropdown.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found entered Doc Type-->" + e);
            Assert.fail();
        }
    }


    public void casesensitivityforDoctype(List<String> Doctype) {
        try {
            for (int begin = 1; begin < Doctype.size(); begin++) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                doctypeDropdown.type(Doctype.get(begin));
                if (fourWaydoctypefromdropdown.isVisible()) {
                    Assert.assertTrue(fourWaydoctypefromdropdown.isVisible());
                    log.info("Doctype 4 Way is found for input " + Doctype.get(begin));
                } else if (DNdoctypefromdropdown.isVisible()) {
                    Assert.assertTrue(DNdoctypefromdropdown.isVisible());
                    log.info("Doctype DN is found for input " + Doctype.get(begin));
                } else {
                    Assert.assertTrue(nooptionfordoctype.isVisible());
                    log.info("please enter valid Doctype there is no option for Doctype" + Doctype.get(begin));
                }
                doctypeDropdown.clear();
            }
        } catch (Exception e) {
            log.error("There is something wrong for finding document " + e);
            Assert.fail();
        }
    }


    public void typetextintoCKEditordocumentcontent(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(5));
            withAction().moveToElement(Ck_editor).click().sendKeys(dataTable.get("Document content")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to type content in CK Editor-->" + e);
            Assert.fail();
        }
    }

    public void clickNext_btn_JS() {
        Next_Button.waitUntilVisible();
        // Fixed: ElementClickInterceptedError - Using JS click to bypass interception by 'Need help?' bubble
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", Next_Button);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    public void clickSubmit_btn_JS() {
        submitbutton.waitUntilVisible();
        // Fixed: ElementClickInterceptedError - Using JS click to bypass interception by 'Need help?' bubble
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", submitbutton);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    public boolean validateAuditHistoryData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);

        // Initialize all flags to true. They will only be evaluated to false if a provided key doesn't match.
        boolean isAuditID = true;
        boolean isGroupName = true;
        boolean isOrgName = true;
        boolean isAuditEvent = true;
        boolean isActualDate = true;
        boolean isUpdatedByCorrect = true;
        boolean isEventChangesCorrect = true;

        if (dataTable.containsKey("Template Audit ID") && dataTable.get("Template Audit ID") != null) {
            isAuditID = Template_AuditID.getText().trim().contains(dataTable.get("Template Audit ID").trim());
        }

        if (dataTable.containsKey("Template Name") && dataTable.get("Template Name") != null) {
            isGroupName = Template_Name_HistoryScreen.getText().trim().contains(dataTable.get("Template Name").trim());
        }

        if (dataTable.containsKey("Template Org") && dataTable.get("Template Org") != null) {
            isOrgName = Template_OrgName_HistoryScreen.getText().trim().contains(dataTable.get("Template Org").trim());
        }

        if (dataTable.containsKey("Audit Event") && dataTable.get("Audit Event") != null) {
            isAuditEvent = Template_AuditEvent_HistoryScreen.getText().trim().equalsIgnoreCase(dataTable.get("Audit Event").trim());
        }

        if (dataTable.containsKey("Date") && dataTable.get("Date") != null) {
            String expectedDate;
            if (dataTable.get("Date").trim().contains("Current")) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                expectedDate = dateFormat.format(cal.getTime());
            } else {
                expectedDate = dataTable.get("Date").trim();
            }
            isActualDate = Template_Date_HistoryScreen.getText().trim().contains(expectedDate);
        }

        if (dataTable.containsKey("Updated By") && dataTable.get("Updated By") != null) {
            isUpdatedByCorrect = Template_UpdatedBy_HistoryScreen.getText().trim().equalsIgnoreCase(dataTable.get("Updated By").trim());
        }

        if (dataTable.containsKey("Event Changes") && dataTable.get("Event Changes") != null) {
            try {
                isEventChangesCorrect = Template_EventsChanges_HistoryScreen.getText().trim().contains(dataTable.get("Event Changes").trim());
            } catch (ElementNotInteractableException e) {
                Template_EventsChanges_DropDown.click();
                withAction().pause(Duration.ofSeconds(1));
                isEventChangesCorrect = Template_EventsChanges_HistoryScreen.getText().trim().contains(dataTable.get("Event Changes").trim());
            }
        }

        // Returns true only if all PROVIDED fields match their respective UI elements
        return isAuditID && isGroupName && isOrgName && isAuditEvent && isActualDate && isUpdatedByCorrect && isEventChangesCorrect;
    }

    public void createMultipleDocumentTemplates(DataTable table) {
        generatedTemplateNames.clear(); // Reset memory for this test run
        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
            String orgName = row.get("Organisation Name");
            String docType = row.get("Doc Type");
            // Inline unique name generation
            String uniqueName = row.get("Template Name") + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);

            generatedTemplateNames.add(uniqueName);
            String currentAction = "Initializing Creation Cycle";
            log.info("--- Starting creation cycle for template: {} ---", uniqueName);

            try {
                // 1. Click Create New Template
                currentAction = "Clicking '+ Create New Template' button";
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Create New Template')]").waitUntilClickable());

                // 2. Clear and Enter Template Name
                currentAction = "Entering Template Name";
                $("//input[contains(@placeholder, 'Enter template name') or contains(@placeholder, 'Template name')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, uniqueName);

                // 3. Select Organisation
                currentAction = "Selecting Organisation: " + orgName;
                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')]").waitUntilPresent());
                $("//input[contains(@placeholder, 'Select Organisation')]")
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, orgName, Keys.SPACE, Keys.BACK_SPACE);
                $("//li[@role='option' and contains(., '" + orgName + "')]").waitUntilClickable().click();

                // 4. Select Doc Type (with React Debounce protection)
                currentAction = "Selecting Doc Type: " + docType;
                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Doc Type') or contains(@placeholder, 'Select Doc type')]").waitUntilPresent());
                $("//input[contains(@placeholder, 'Select Doc Type') or contains(@placeholder, 'Select Doc type')]")
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, docType);
                withAction().pause(Duration.ofSeconds(1)).build().perform(); // Brief pause for React
                $("//input[contains(@placeholder, 'Select Doc Type') or contains(@placeholder, 'Select Doc type')]")
                        .sendKeys(Keys.SPACE, Keys.BACK_SPACE);
                $("//li[@role='option' and contains(., '" + docType + "')]").waitUntilClickable().click();

                // 5. Click Next
                currentAction = "Clicking 'Next' button";
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Next')]").waitUntilClickable());

                // Wait for the next screen (Workflow/Enforcement) to fully load before clicking Cancel
                $("//*[contains(text(), 'Document terms')]").waitUntilVisible();

                // 6. Click Cancel (Saves as draft and returns to listing)
                currentAction = "Clicking 'Cancel' button to save as draft and return";
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Cancel')]").waitUntilClickable());

                // Wait for the main listing screen to reload completely before starting the next loop
                $("//button[contains(., 'Create New Template')]").waitUntilVisible();

                log.info("Successfully created and returned to listing for: {}", uniqueName);

            } catch (Exception e) {
                log.error("Failed during action: '{}' for template '{}'. Error: {}", currentAction, uniqueName, e.getMessage());
                // Fully PR Compliant AssertJ failure
                fail("Failed during: " + currentAction + " | Template: " + uniqueName + " | Exact error: " + e.getMessage());
            }
        }
    }

    public void verifyGeneratedTemplatesVisibility() {
        log.info("Verifying visibility of newly created templates...");
        if (generatedTemplateNames.isEmpty()) {
            org.junit.Assert.fail("No templates were found in memory. Creation step may have failed.");
        }
        String searchBoxXPath = "//input[contains(@placeholder, 'Search by template name')]";
        WebElementFacade searchBox = find(By.xpath(searchBoxXPath));
        for (String templateName : generatedTemplateNames) {
            try {
                searchBox.waitUntilClickable().click();
                searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofMillis(500)).build().perform();
                searchBox.sendKeys(templateName);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                String tableResultXPath = "//table/tbody/tr//td[contains(text(), '" + templateName + "')]";
                boolean isVisible = !findAll(By.xpath(tableResultXPath)).isEmpty();
                if (isVisible) {
                    log.info("Validation Passed: Template '{}' is visible to the restricted user.", templateName);
                } else {
                    org.junit.Assert.fail("VIEW_ALL Security Failure: Template '" + templateName + "' is NOT visible to the restricted user.");
                }
            } catch (Exception e) {
                log.error("Failed during validation search for '{}'. Error: {}", templateName, e.getMessage());
                org.junit.Assert.fail("Validation step failed while searching for templates.");
            }
        }
        searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    public void updateGeneratedDocumentTemplates() {
        log.info("--- Starting Update lifecycle for Document Templates ---");
        if (generatedTemplateNames.isEmpty()) {
            fail("No Document Templates found in memory. The creation step may have failed.");
        }
        List<String> successfullyUpdatedNames = new ArrayList<>();

        for (String templateName : generatedTemplateNames) {
            // We will append "_UPD" to the end of the template name to verify the edit works
            String updatedName = templateName + "_UPD";
            log.info("Updating Template: '{}' to '{}'", templateName, updatedName);

            try {
                // 1. Search for the previously created template
                $("//input[contains(@placeholder, 'Search by template name') or contains(@placeholder, 'Search')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                $("//input[contains(@placeholder, 'Search by template name') or contains(@placeholder, 'Search')]").sendKeys(templateName);

                withAction().pause(Duration.ofSeconds(1)).build().perform(); // React debounce pause
                $("//input[contains(@placeholder, 'Search by template name') or contains(@placeholder, 'Search')]").sendKeys(Keys.RETURN);
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for table to filter

                // 2. Click the Update/Edit button on the resulting row
                // Targets either an 'Update' button or an 'edit' SVG icon
                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + templateName + "')]//button[contains(., 'Update') or contains(., 'Edit')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // 3. Clear the old name and enter the updated name
                $("//label[contains(., 'Template Name') or contains(., 'template name')]/..//input").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, updatedName);

                // 4. Click 'Next' (Based on your previous Document Template creation flow)
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Next')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // 5. Submit the Update (Looks for Submit, Update, Save, or Cancel-to-draft)
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update') or contains(., 'Save') or contains(., 'Cancel')]").waitUntilClickable());

                // 6. Wait for the success toast to ensure the backend saved it
                $("//*[contains(text(), 'successfully') or contains(text(), 'Updated')]").waitUntilVisible();
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // Save the new name into our temporary list
                successfullyUpdatedNames.add(updatedName);
                log.info("Successfully updated template to '{}'", updatedName);

            } catch (Exception e) {
                log.error("Failed to update template '{}'. Error: {}", templateName, e.getMessage());
                fail("Update lifecycle failed for Template: " + templateName + " with error: " + e.getMessage());
            }
        }generatedTemplateNames.clear();
        generatedTemplateNames.addAll(successfullyUpdatedNames);
    }

    public void validateViewAllAccessOnly() {
        Assert.assertTrue("No records found in the Document Template table to validate.",!tableRows.isEmpty());
        Assert.assertTrue("Mismatch found: Not all records have a 'View' button visible.", viewButtonsList.size() == tableRows.size());
        for (WebElementFacade viewBtn : viewButtonsList) {
            Assert.assertTrue("A 'View' button was found but it is not enabled/clickable.", viewBtn.isEnabled());
        }
        Assert.assertTrue("Security Breach: 'Edit' buttons are visible despite 'View All' role.",
                editButtonsList.isEmpty());
        Assert.assertTrue("Security Breach: 'Delete' buttons are visible despite 'View All' role.",
                deleteButtonsList.isEmpty());
    }
}