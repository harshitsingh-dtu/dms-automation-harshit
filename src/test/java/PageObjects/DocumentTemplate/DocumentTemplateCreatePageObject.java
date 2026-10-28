package PageObjects.DocumentTemplate;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DocumentTemplateCreatePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//button[text()='+ Create New Template']")
    private WebElementFacade create_btn;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_btn;
    @FindBy(xpath = "//*[text()='Create new document template']")
    private WebElementFacade createnewtemplate_txt;
    @FindBy(xpath = "//input[@placeholder=\"Enter template name\"]")
    private WebElementFacade templateName;
    @FindBy(xpath = "//input[@placeholder=\"Select Organisation\"]")
    private WebElementFacade organisation;
    @FindBy(xpath = "//input[@placeholder=\"Select Doc Type\"]")
    private WebElementFacade doctype;
    @FindBy(xpath = "//button[text()=\"Approval workflow\"]")
    private WebElementFacade approvalWorkflow_btn;

    @FindBy(xpath = "//button[text()='Approval Workflow']")
    private WebElementFacade approvalWorkflow_btn4W;

    @FindBy(xpath="//div[@class='dragBox']//div[contains(text(),'Prime Broker - 1')]")
    private WebElementFacade PB1_participant;
    @FindBy(xpath = "//div[@class='drag-box  ' and text()='Client - 1']")
    private WebElementFacade Client1_participant;
    @FindBy(xpath = "//div[@class='drag-box  ' and text()='Prime Broker - 2']")
    private WebElementFacade PB2_participant;
    @FindBy(xpath = "//div[@class='drag-box  ' and text()='Client - 2']")
    private WebElementFacade Client2_participant;
    @FindBy(xpath = "(//div[text()='Drag and Drop here the participant'])[1]")
    private WebElementFacade approvalSeq1;
    @FindBy(xpath = "(//table[@class='workflow-table']/tbody/tr/td[text()='Remove Currency']/following-sibling::td/div[@class='cell-container'])[1]")
    private WebElementFacade approvalSeq1RemoveCurrency;
    @FindBy(xpath = "//table[@class='workflow-table']/tbody/tr[td[text()='Remove Currency']]")
    private WebElementFacade RemoveCurrencyText;

    @FindBy(xpath = "(//div[text()='Drag and Drop here the participant'])[2]")
    private WebElementFacade approvalSeq2;
    @FindBy(xpath = "(//div[text()='Drag and Drop here the participant'])[3]")
    private WebElementFacade approvalSeq3;
    @FindBy(xpath = "(//div[text()='Drag and Drop here the participant'])[4]")
    private WebElementFacade approvalSeq4;
    @FindBy(xpath = "//button[text()=\"Enforcement rules\"]")
    private WebElementFacade enforcementRules_btn;
    @FindBy(xpath = "//div[@class='rule-container'][1]//div[@class='radio-input']//label[text()='Immediate']")
    private WebElementFacade fornewdocument_immediate;
    @FindBy(xpath = "//div[@class='rule-container'][2]//div[@class='radio-input']//label[text()='Immediate']")
    private WebElementFacade foramendment_immediate;
    @FindBy(xpath = "//div[@class='rule-container'][3]//div[@class='radio-input']//label[text()='Immediate']")
    private WebElementFacade fortermination_immediate;
    @FindBy(xpath = "//input[@placeholder='Duration']")
    private WebElementFacade duration_schedule;
    @FindBy(xpath = "//div[text()='Immediate']")
    private WebElementFacade EnforcementRule_immediate;
    @FindBy(xpath = "//input[@value='Immediate']")
    private WebElementFacade EnforcementRule_immediate_DF;
    @FindBy(xpath = "//p[@data-placeholder='Type or paste your content here!']")
    private WebElementFacade Ck_editor;
    @FindBy(xpath = "//button[text()=\"Submit\"]")
    private WebElementFacade submit_btn;
    @FindBy(xpath = "//button[text()=\"Save as Draft\"]")
    private WebElementFacade saveAsDraft_btn;
    @FindBy(xpath = "//*[@class='ck ck-editor__main']//p")
    private WebElementFacade documentTermText;

    //Document template screen
    @FindBy(xpath = "//button[text()='+ Create New Template']")
    private WebElementFacade Create_New_Template_Btn;
    @FindBy(xpath = "//div[text()='Document templates']")
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
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submitbutton;
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
    @FindBy(xpath = "//button[text()='Approval workflow']")
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

    @FindBy(xpath = "//img[@class='audit-log-btn']//..")
    private WebElementFacade audit_btn;
    @FindBy(xpath = "//input[@placeholder='Search by template name']")
    private WebElementFacade search_bar;
    @FindBy(xpath = "//table//tbody//tr[1]//td[1]")
    private WebElementFacade first_search_result;

    public void clickCreatebtn(){
        create_btn.waitUntilVisible().click();
    }
    public void checkifOnCreateTemplatescreen() {
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            createnewtemplate_txt.isVisible();
        } catch (Exception e) {
            log.info("Unable to input termination type-->" + e);
            Assert.fail();
        }
    }
    public void selectTemplateName(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            templateName.waitUntilVisible();
            withAction().moveToElement(templateName).click().sendKeys(dataTable.get("Template Name")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("Unable to input into Template Name-->" + e);
            Assert.fail();
        }
    }

    public static StringBuilder randomStringGenerator()
    {
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        StringBuilder s = new StringBuilder();
        for (int i=0; i<5; i++) {
            int ch = (int)(AlphaNumericStr.length() * Math.random());
            s.append(AlphaNumericStr.charAt(ch));
        }
        return s;
    }

    public void selectOrganisationName(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            organisation.waitUntilVisible();
            withAction().moveToElement(organisation).click().sendKeys(dataTable.get("Organisation Name")).pause(Duration.ofSeconds(2)).build().perform();
            WebElement option = getDriver().findElement(By.xpath("//p[contains(text(), '" + dataTable.get("Organisation Name") + "')]"));
            option.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.info("Unable to input Organisation Name-->" + e);
            Assert.fail();
        }
    }
    public void selectDocType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doctype.waitUntilVisible();
            withAction().moveToElement(doctype).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            WebElement option = getDriver().findElement(By.xpath("//p[text()='" + dataTable.get("Doc Type") + "']"));
            option.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.info("Unable to input Doc Type-->" + e);
            Assert.fail();
        }
    }
    public void clickTemplateNextbtn(){
        next_btn.waitUntilVisible();
        // Fixed: ElementClickInterceptedError - Using JS click to bypass interception by 'Need help?' bubble
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", next_btn);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    public void clickApprovalWorkflow_btn(){
        approvalWorkflow_btn.waitUntilPresent();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void selectApprovalWorkflow() {
            approvalWorkflow_btn.waitUntilPresent();
            act.dragAndDrop(PB1_participant, approvalSeq1);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            next_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void selectApprovalWorkflowRemoveCurrency() {
        approvalWorkflow_btn4W.waitUntilPresent();
        act.dragAndDrop(PB1_participant, approvalSeq1);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", RemoveCurrencyText);
        act.dragAndDrop(PB1_participant, approvalSeq1RemoveCurrency);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void dragToApprovalSeq2() {
        approvalWorkflow_btn.waitUntilPresent();
        act.dragAndDrop(PB1_participant, approvalSeq2);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        next_btn.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void clickEnforcementRules_btn(){
        enforcementRules_btn.click();
    }

    public void validate_enforcement_data(){
        try {
            duration_schedule.isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            log.error("Element does not exist "+e);
        }
    }

    public void verifySingleImmediateInputIsPresentAndVisible() {
        List<WebElement> immediateElements = getDriver().findElements(By.xpath("//label[text()='Immediate']"));
        if (immediateElements.size() == 3) {
            Assert.assertTrue("Error: The 'Immediate' label was found, but it is NOT visible.", immediateElements.get(0).isDisplayed());
        } else {
            Assert.fail(
                    "Error: Expected exactly 3 'Immediate' label, but found " + immediateElements.size());
        }
    }
    public void validateEnforcementDataOnPreviewTab(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> expectedValues = data.get(0);

        for (Map.Entry<String, String> column : expectedValues.entrySet()) {
            String columnName = column.getKey().trim();
            String expectedValue = column.getValue().trim();

            String bodyCellXpath = "//table[@data-testid='enforcement-preview-table']//tbody//tr/td["
                    + "count(//table[@data-testid='enforcement-preview-table']//th[normalize-space(.)='" + columnName + "']/preceding-sibling::th) + 1]";

            try {
                WebElementFacade bodyCell = find(By.xpath(bodyCellXpath));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", bodyCell);
                bodyCell.waitUntilVisible();

                String actualValue = bodyCell.getText().replace("\n", " ").trim();

                Assert.assertTrue(
                        "Enforcement value mismatch for column '" + columnName + "'. Expected to contain: '"
                                + expectedValue + "', but found: '" + actualValue + "'",
                        actualValue.equalsIgnoreCase(expectedValue) || actualValue.toLowerCase().contains(expectedValue.toLowerCase()));

                log.info("Validated enforcement column '{}' -> expected: '{}', actual: '{}'", columnName, expectedValue, actualValue);
            } catch (NoSuchElementException e) {
                Assert.fail("Could not find column '" + columnName + "' in the enforcement preview table. Check the header text matches the UI exactly.");
            }
        }
    }

    public void typeinto_fornewdocument(){
        try{
            fornewdocument_immediate.waitUntilClickable().click();
        }catch (Exception e){
            log.info("Unable to input termination type-->"+e);
            Assert.fail();
        }
    }
    public void typeinto_forammendment(){
        try{
            foramendment_immediate.waitUntilClickable().click();
        }catch (Exception e){
            log.info("Unable to input ammendment type-->"+e);
            Assert.fail();
        }
    }
    public void typeinto_fortermination(){
        try {
            fortermination_immediate.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }catch (Exception e){
            log.info("Unable to input termination type-->"+e);
            Assert.fail();
        }
    }
    public void clickNext_btn(){
        next_btn.waitUntilVisible();
        // Fixed: ElementClickInterceptedError - Using JS click to bypass interception by 'Need help?' bubble
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", next_btn);
        withAction().pause(Duration.ofSeconds(6)).build().perform();
    }
    public void typetextintoCKEditordocumentcontent(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        Ck_editor.waitUntilPresent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",Ck_editor);
        Ck_editor.withTimeoutOf(Duration.ofSeconds(7)).waitUntilVisible().waitUntilClickable();
        Ck_editor.waitUntilClickable().click();
        Ck_editor.sendKeys("Hello");
        Ck_editor.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        Ck_editor.sendKeys(dataTable.get("Content"));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public boolean validateDocumentTerms(String DocumentTerms) {
        try {
            documentTermText.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            String inputText = documentTermText.getText();
            if (inputText.contains(DocumentTerms)) {
                next_btn.waitUntilClickable().click();
                return true;
            } else {
                log.info("Document terms mismatch. Expected: " + DocumentTerms + " but found: " + inputText);
                return false;
            }
        } catch (Exception e) {
            log.error("Element not found or not visible: " + e.getMessage());
            return false;
        }
    }
    public void clickSubmit_btn(){
        submit_btn.waitUntilVisible();
        // Fixed: ElementClickInterceptedError - Using JS click to bypass interception by 'Need help?' bubble
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", submit_btn);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        log.info("Clicked on submit for new document template");
    }

    public void clickAuditBtn() {
        try {
            audit_btn.waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", audit_btn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            audit_btn.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.info("Unable to click Audit button-->" + e);
            Assert.fail();
        }
    }
    public void clickSaveAsDraftbtn() {
        saveAsDraft_btn.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        log.info("Clicked on Save as draft");
    }
}
