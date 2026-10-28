package PageObjects.DMS_PHASE2PageObject;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DMS_1523PageObject extends PageObject {

    Actions act=new Actions(getDriver());

    @FindBy(xpath="//div[@class='flex align-center justify-center pointer sidebar-icon']//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath = "//div[@data-testid='menu-category-name' and contains(., 'Groups & template')]")
    private WebElementFacade groupsTemplate_btn;

    @FindBy(xpath = "//a[@data-testid='submenu-link-Approval matrices']")
    private WebElementFacade approvalMatrix_btn;

    @FindBy(xpath = "//a[@data-testid='submenu-link-Document templates']")
    private WebElementFacade documenttemplate_btn;

    @FindBy(xpath = "//div[@data-testid='matrix-title']")
    private WebElementFacade approvalMatrix_txt;

    @FindBy(xpath = "//div[text()='Document templates']")
    private WebElementFacade Documenttemplate_text;

    @FindBy(xpath = "//button[text()='+ Create Approval Matrix']")
    private WebElementFacade create_btn;

    @FindBy(xpath = "//input[@placeholder='Search by organisation name']")
    private WebElementFacade searchBar;
    @FindBy(xpath = "//table[@class=\"csm_standard_table undefined\"]//tbody//tr//td[1]")
    private WebElementFacade searchedresult_grpname;

    @FindBy(xpath = "//tr//th//div[text()='Organisation name']")
    private WebElementFacade organizationName_col;

    @FindBy(xpath = "//tr//th//div[text()='LEIs name']")
    private WebElementFacade LEIsName_col;

    @FindBy(xpath = "//tr//th//div[text()='Org type']")
    private WebElementFacade orgType_col;

    @FindBy(xpath = "//tr//th//div[text()='Doc type']")
    private WebElementFacade docType_col;

    @FindBy(xpath = "//tr//th//div[text()='Created on']")
    private WebElementFacade createdOn_col;

    @FindBy(xpath = "//tr//th//div[text()='Action']")
    private WebElementFacade action_col;

    @FindBy(xpath = "(//tr//button[text()='Update'])[1]")
    private WebElementFacade update_btn;

    @FindBy(xpath = "//div[text()='Create new approval matrix']")
    private WebElementFacade createNewApprovalMatrix_txt;

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organization_filter;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade docType_filter;

    @FindBy(xpath = "//div[text()='Select Leis']")
    private WebElementFacade LEI_filter;

    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgType_filter;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_btn;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;

    @FindBy(xpath = "//*[contains(text(),'Organisation*')]")
    private WebElementFacade organization_filter_txt;

    @FindBy(xpath = "//*[contains(text(),'Doc type*')]")
    private WebElementFacade docType_filter_txt;

    @FindBy(xpath = "//*[contains(text(),'LEIs*')]")
    private WebElementFacade LEI_filter_txt;

    @FindBy(xpath = "//*[contains(text(),'Org type*')]")
    private WebElementFacade orgType_filter_txt;

    @FindBy(xpath = "//p[text()='Client']")
    private WebElementFacade client_text;

    @FindBy(xpath = "//p[text()='PB']")
    private WebElementFacade PB_text;

    @FindBy(xpath = "//p[text()='EB']")
    private WebElementFacade EB_text;

    @FindBy(xpath = "//div[@class='info']")
    private WebElementFacade all_Info;

    @FindBy(xpath = "//input[@placeholder='Select action']")
    private WebElementFacade documentAction_dropdown;

    @FindBy(xpath = "//input[@placeholder='Search and select action']")
    private WebElementFacade approvalGroups_dropdown;

    @FindBy(xpath = "//div[@class='group-add']")
    private WebElementFacade add_btn;

    @FindBy(xpath = "//div[@class='MuiChip-deleteIcon MuiChip-deleteIconMedium MuiChip-deleteIconColorDefault MuiChip-deleteIconFilledColorDefault']")
    private WebElementFacade crossIcon_approvalMatrix;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;

    @FindBy(xpath = "//label[contains(text(),'Document action')]")
    private WebElementFacade documentAction_filter_txt;

    @FindBy(xpath = "//label[contains(text(),'Approval groups')]")
    private WebElementFacade approvalGroups_filter_txt;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade alert_popup;

    @FindBy(xpath = "//input[@placeholder='Select Legal entity name']")
    private WebElementFacade selectLEI;

    public void navigateToApprovalMatrixListingScreen(){
        try {
            withAction().pause(Duration.ofSeconds(6)).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            navigation_btn.waitUntilClickable();
            navigation_btn.click();
            if(approvalMatrix_btn.isVisible()){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                approvalMatrix_btn.waitUntilClickable().click();
            }
            else {
                groupsTemplate_btn.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                approvalMatrix_btn.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(approvalMatrix_txt.isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to reach the approval matrix screen -->"+e);
            Assert.fail();
        }
    }

    public void navigateToDocumenttemplateListingScreen(){
        try {
            withAction().pause(Duration.ofSeconds(6)).build().perform();
            navigation_btn.waitUntilClickable();
            navigation_btn.click();
            if(documenttemplate_btn.isVisible()){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                documenttemplate_btn.waitUntilClickable().click();
            }
            else {
                groupsTemplate_btn.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                documenttemplate_btn.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(Documenttemplate_text.isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to reach the approval matrix screen -->"+e);
            Assert.fail();
        }
    }
    public void checkIfOrganizationFilter_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(organization_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("organisation name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        catch (Exception e){
            log.error("unable to input in the organization filter-->"+e);
            Assert.fail();
        }
    }
    public void checkIfDocTypeFilter_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(docType_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("doc type filter")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("unable to input in the doc type filter-->"+e);
            Assert.fail();
        }
    }
    public void checkIfLEIsFilter_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(LEI_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("LEI filter")).pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        catch (Exception e){
            log.error("Unable to input in the lei filter-->"+e);
            Assert.fail();
        }
    }
    public void checkIfOrgTypeFilter_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(orgType_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("org type filter")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to input in the org type filter-->"+e);
            Assert.fail();
        }
    }
    public void typeDocumentActionandapprovalgroup(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            documentAction_filter_txt.waitUntilVisible();
            act.moveToElement(documentAction_dropdown).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("Document Action")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            approvalGroups_filter_txt.waitUntilVisible();
            withAction().moveToElement(approvalGroups_dropdown).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to add Approval groups to Approval matrix"+e);
            Assert.fail();
        }
    }
    public void searchApprovalMatrix(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(searchBar.isVisible());
            withAction().moveToElement(searchBar).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("Approval matrix")).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("unable to input in the organization filter-->"+e);
            Assert.fail();
        }
    }
    public void selectLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(selectLEI).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("Select LEI")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to input in the lei filter-->"+e);
            Assert.fail();
        }
    }
    public void remove_approval_group(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(crossIcon_approvalMatrix).click().build().perform();
            log.info("User removed the existing approval group");
        }catch (Exception e){
            log.error("Unable to remove approval groups"+e);
            Assert.fail();
        }
    }
}
