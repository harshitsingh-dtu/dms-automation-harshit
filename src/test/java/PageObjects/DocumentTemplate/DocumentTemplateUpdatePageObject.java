package PageObjects.DocumentTemplate;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DocumentTemplateUpdatePageObject extends PageObject {
    String[] fornewdocument_duration={"immediate"};
    String[] forammendment_duration={"Schedule","3","hours"};
    String[] fortermination_duration={"immediate"};
    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade update_btn;
    @FindBy(xpath = "//button[text()=\"Next\"]")
    private WebElementFacade next_btn;
    @FindBy(xpath = "//button[text()=\"Submit\"]")
    private WebElementFacade submit_btn;

    @FindBy(xpath = "//input[@placeholder=\"Search by template name\"]")
    private WebElementFacade searchbydocumentname;

    @FindBy(xpath = "//button[text()=\"Approval workflow\"]")
    private WebElementFacade approvalWorkflow_btn;
    @FindBy(xpath = "//button[text()=\"Enforcement rules\"]")
    private WebElementFacade enforcementRules_btn;
    @FindBy(xpath = "//button[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='document terms']")
    private WebElementFacade DocumentTerm_btn;
    @FindBy(xpath = "//*[contains(text(),'For new document')]")
    private WebElementFacade fornewdocument_txt;
    @FindBy(xpath = "//div[@class='rule-container'][1]//div[@class='radio-input']//label[text()='Immediate']")
    private WebElementFacade fornewdocument_immediate;
    @FindBy(xpath = "//div[@class='rule-container'][1]//div[@class='radio-input']//label[text()='Schedule']")
    private WebElementFacade fornewdocument_schedule;
    @FindBy(xpath = "//*[contains(text(),'For amendment')]")
    private WebElementFacade foramendment_txt;
    @FindBy(xpath = "//div[@class='rule-container'][2]//div[@class='radio-input']//label[text()='Immediate']")
    private WebElementFacade foramendment_immediate;
    @FindBy(xpath = "//div[@class='rule-container'][2]//div[@class='radio-input']//label[text()='Schedule']")
    private WebElementFacade foramendment_schedule;
    @FindBy(xpath = "//*[contains(text(),'For termination')]")
    private WebElementFacade fortermination_txt;
    @FindBy(xpath = "//div[@class='rule-container'][3]//div[@class='radio-input']//label[text()='Immediate']")
    private WebElementFacade fortermination_immediate;
    @FindBy(xpath = "//div[@class='rule-container'][3]//div[@class='radio-input']//label[text()='Schedule']")
    private WebElementFacade fortermination_schedule;
    @FindBy(xpath = "//input[@placeholder='Value']")
    private WebElementFacade value_schedule;
    @FindBy(xpath = "//input[@placeholder='Duration']")
    private WebElementFacade duration_schedule;
    @FindBy(xpath = "//*[@id=\"editor-container\"]/div/div[2]/div[2]/div")
    private WebElementFacade legalTermsTextBox;
    @FindBy(xpath = "//div[@class='select-container']//div[text()='Document template information']")
    private WebElementFacade documentTemplateInfo;
    @FindBy(xpath = "//input[@placeholder=\"Select Template\"]")
    private WebElementFacade documenttemplatedropdown;
    @FindBy(xpath = "//p[text()='Approval Workflow']")
    private WebElementFacade documenttemplateapproval;
    @FindBy(xpath = "//p[text()='Enforcement Rules']")
    private WebElementFacade documenttemplateenforcement;
    @FindBy(xpath = "//p[text()='Document Terms']")
    private WebElementFacade documenttemplatedocumentterms;
    @FindBy(xpath = "//*[@placeholder='Select Doc type']")
    private WebElementFacade selectDocType;

    @FindBy(xpath = "//td[text()='Edit Enforcement Rules']")
    private WebElementFacade EditEnforcementRules;
    @FindBy(xpath = "//*[contains(text(),'Scheduled')]")
    private WebElementFacade EnforcementData;




    public void clickupdate_btn(){
        update_btn.isVisible();
        update_btn.click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    public void clickDocumentTerm_btn(){
        DocumentTerm_btn.isVisible();
        DocumentTerm_btn.click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    public void searchdocument(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            searchbydocumentname.waitUntilVisible();
            withAction().moveToElement(searchbydocumentname).click().sendKeys(dataTable.get("Document Name")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("Unable to input into Template Name-->" + e);
            Assert.fail();
        }
    }
    public void searchdocumenttemplate(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        documenttemplatedropdown.waitUntilVisible();
        withAction().moveToElement(documenttemplatedropdown).click().sendKeys(dataTable.get("Document Name")).pause(Duration.ofSeconds(2)).build().perform();
    }

    public void checkEnforcementRulesForNewDocument(){
        fornewdocument_txt.isVisible();
        foramendment_immediate.isVisible();
        foramendment_schedule.isVisible();
    }
    public void checkEnforcementRulesForAmendment(){
        foramendment_txt.isVisible();
        foramendment_immediate.isVisible();
        foramendment_schedule.isVisible();
    }
    public void checkEnforcementRulesFortermination(){
        fortermination_txt.isVisible();
        fortermination_immediate.isVisible();
        fortermination_schedule.isVisible();
    }
    public void typeinto_fornewdocument(){
        if (fornewdocument_duration[0].equalsIgnoreCase("immediate")){
            fornewdocument_immediate.isVisible();
            fornewdocument_immediate.click();
        }else {
            fornewdocument_schedule.isVisible();
            fornewdocument_schedule.click();
            value_schedule.isVisible();
            withAction().moveToElement(value_schedule).click().sendKeys(fornewdocument_duration[1]).build().perform();
            withAction().moveToElement(duration_schedule).click().sendKeys(fornewdocument_duration[2], Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void typeinto_forammendment(){
        if (forammendment_duration[0].equalsIgnoreCase("immediate")){
            foramendment_immediate.isVisible();
            foramendment_immediate.click();
        }else {
            foramendment_schedule.isVisible();
            foramendment_schedule.click();
            value_schedule.isVisible();
            withAction().moveToElement(value_schedule).click().sendKeys(forammendment_duration[1]).build().perform();
            withAction().moveToElement(duration_schedule).click().sendKeys(forammendment_duration[2], Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();

    }
    public void typeinto_fortermination(){
        if (fortermination_duration[0].equalsIgnoreCase("immediate")){
            fortermination_immediate.isVisible();
            fortermination_immediate.click();
        }else {
            fortermination_schedule.isVisible();
            fortermination_schedule.click();
            value_schedule.isVisible();
            withAction().moveToElement(value_schedule).click().sendKeys(fortermination_duration[1]).build().perform();
            withAction().moveToElement(duration_schedule).click().sendKeys(fortermination_duration[2], Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void clickNext_btn(){
        next_btn.isVisible();
        next_btn.click();
        withAction().pause(Duration.ofSeconds(7)).build().perform();
    }
    public void typeintoLegalTerms() {
        try {
            withAction().moveToElement(legalTermsTextBox).click().sendKeys("this is a sample text").pause(Duration.ofSeconds(2)).build().perform();
            //file load either from property file using java or serenity methods.
        } catch (Exception e) {
            log.error("Unable to input Legal terms-->" + e);
            Assert.fail();
        }
    }
    public void clickSubmit_btn(){
        submit_btn.isVisible();
        submit_btn.click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        log.info("Successfully clicked on submit button");
    }

    public void validate_DocumentTemplateUpdateScreen(){
        try{
            documentTemplateInfo.waitUntilVisible();
            Assert.assertTrue(documentTemplateInfo.isVisible());
            Assert.assertEquals("Document template information",documentTemplateInfo.getText().trim());
            Assert.assertTrue(approvalWorkflow_btn.isVisible());
            Assert.assertTrue(enforcementRules_btn.isVisible());
            Assert.assertTrue(DocumentTerm_btn.isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Successfully validated the template update screen");
        }
        catch (Exception e){
            log.error("Unable to validate the template update screen" +e);
            Assert.fail();
        }
    }

    public void validatedocdocumenttemplate(String TemplateName) {
        documenttemplatedropdown.click();
        documenttemplatedropdown.clear();
        documenttemplatedropdown.sendKeys(TemplateName);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        documenttemplatedropdown.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(documenttemplateapproval.isDisplayed());
        Assert.assertTrue(documenttemplateenforcement.isDisplayed());
        Assert.assertTrue(documenttemplatedocumentterms.isDisplayed());
    }

    public void validateDNdocumenttemplate(String TemplateName) {
        documenttemplatedropdown.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documenttemplatedropdown.sendKeys(TemplateName);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documenttemplatedropdown.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(documenttemplatedocumentterms.isDisplayed());
    }

    public void ValidateDataInTemplate(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        documenttemplateapproval.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        List<WebElementFacade> ApprovalWorkflowData = findAll(By.xpath("//div[text()='" + dataTable.get("Approval Workflow") + "']"));
        WebElement targetElement = getDriver().findElement(By.xpath("//p[text()='Approval Workflow']"));
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", targetElement);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if(!ApprovalWorkflowData.isEmpty())
        {
            documenttemplateapproval.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            documenttemplateenforcement.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if(dataTable.get("Enforcement Rule").contains("Hour"))
            {
                EnforcementData.isDisplayed();
            }
        }
    }

    public boolean DocumentTermsData(DataTable table)
    {
        boolean result = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documenttemplatedocumentterms);
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        documenttemplatedocumentterms.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        WebElementFacade DocumentTermsData = find(By.xpath("//p[text()='" + dataTable.get("Document Terms") + "']"));

        if(DocumentTermsData.isDisplayed())
        {
           result = true;
        }
        return result;
    }
}