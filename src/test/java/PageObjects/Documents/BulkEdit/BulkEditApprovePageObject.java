package PageObjects.Documents.BulkEdit;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class BulkEditApprovePageObject extends PageObject {
    @FindBy(xpath = "//button[text()='Bulk Action']")
    private WebElementFacade bulkAction_btn;
    @FindBy(xpath = "//*[text()=' Approve']")
    private WebElementFacade bulkEditApprove_btn;
    @FindBy(xpath = "//li[text()='Edit']")
    private WebElementFacade bulk_action_edit_btn;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade Doctype_Action;
    @FindBy(xpath = "//input[@class= 'lp-copy-sel__input']")
    private WebElementFacade actingAs_Action;
    @FindBy(xpath = "//div[@class='acting-content dif']/div/div/div/input")
    private WebElementFacade approvalGroup_Action;
    @FindBy(xpath = "//div[text()=\"In-approval Documents\"]")
    private WebElementFacade inApprovalPage_bulk;
    @FindBy(xpath = "(//input[@type=\"checkbox\"])[1]")
    private WebElementFacade inApprovalPage_checkbox;
    @FindBy(xpath = "//button[text()=\"Approve\"]")
    private WebElementFacade approve_btn;
    @FindBy(xpath = "//img[@alt=\"Approve\"]")
    private WebElementFacade approve_btnDN;
    @FindBy(xpath = "//*[text()='Error to CreditLink']")
    private WebElementFacade bulkErrorCL_btn;
    @FindBy(xpath = "//div[contains(@class, 'select-acting-as') and contains(., 'Select')]")
    private WebElementFacade NoValue_For_Acting_AS;


    public void clickBulkEditBtn(){
        try{
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", bulkAction_btn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            bulkAction_btn.click();
        }catch (Exception e){
            log.info("Unable to click Bulk Edit button" + e);
        }
    }
    public void clickBulkEditButton(){
        try{
            bulk_action_edit_btn.click();
        }catch (Exception e){
            log.info("Unable to click Bulk Edit button" + e);
        }
    }
    public void clickBulkEditApproveAction (){
        try{
            bulkEditApprove_btn.click();
        }catch (Exception e){
            log.info("Unable to click Bulk Edit Approve Action" + e);
        }
    }
    public void clickBulkEdit_edit_btn(){
        try{
            bulk_action_edit_btn.click();
        }catch (Exception e){
            log.info("Unable to click Bulk Edit Approve Action" + e);
        }
    }

    public void selectDocTypeAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            Doctype_Action.waitUntilVisible();
            withAction().moveToElement(Doctype_Action).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Doc Type " + e);
        }
    }
    public void selectActingAsAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            actingAs_Action.waitUntilVisible();
            withAction().moveToElement(actingAs_Action).click().sendKeys(dataTable.get("Acting as")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Acting As LEIs" + e);
        }
    }
    public void selectApprovalGroupAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        
        String groupName = dataTable.get("Approval Group");
        String storedGroupName = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_APPROVAL_GROUP_NAME");
        
        // If 'AUTO_GENERATED' is provided or if we have a stored name that starts with the provided name
        if (storedGroupName != null && !storedGroupName.isEmpty()) {
            if (groupName.equalsIgnoreCase("AUTO_GENERATED") || storedGroupName.startsWith(groupName)) {
                log.info("Using stored approval group name: " + storedGroupName);
                groupName = storedGroupName;
            }
        }

        try{
            approvalGroup_Action.waitUntilVisible();
            withAction().moveToElement(approvalGroup_Action).click().sendKeys(groupName).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Approval Group Action" + e);
        }
    }
    public void selectBulkApprovalDocuments(){
        try{
            String versionID = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_VERSION_ID");
            if (versionID != null && !versionID.isEmpty()) {
                log.info("Selecting specific document with Version ID: " + versionID);
                WebElementFacade checkbox = $(org.openqa.selenium.By.xpath("//td[contains(text(), '" + versionID + "')]/parent::tr//input[@type='checkbox']"));
                if (checkbox.isPresent()) {
                    if (!checkbox.isSelected()) checkbox.click();
                    return;
                }
            }
            log.info("Falling back to select first checkbox.");
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            inApprovalPage_bulk.waitUntilVisible();
            inApprovalPage_checkbox.waitUntilPresent().click();
        }catch (Exception e){
            log.info("Unable to check Bulk Edit Approve Checkbox" + e);
        }
    }
    public void clickApproveBtn(){
        try{
            approve_btn.click();
        }catch (Exception e){
            log.info("Unable to click Approve Button" + e);
        }
    }

    public void clickApproveBtnDN(){
        try{
            approve_btnDN.click();
            approve_btn.click();
        }catch (Exception e){
            log.info("Unable to click Approve Button" + e);
        }
    }

}