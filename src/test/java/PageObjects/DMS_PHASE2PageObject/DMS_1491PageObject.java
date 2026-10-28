package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class DMS_1491PageObject extends PageObject {

    @FindBy(xpath="//div[@class='flex align-center justify-center pointer sidebar-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath ="//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupsTemplate_btn;

    @FindBy(xpath="//a[@data-testid='submenu-link-Approval groups']")
    private WebElementFacade approvalGroup_btn;

    @FindBy(xpath="//div[text()='Approval groups']")
    private WebElementFacade approvalGroup_title;

    @FindBy(xpath="//input[@placeholder='Search by group name']")
    private WebElementFacade search_approvalGroupName;

    @FindBy(xpath="//input[@placeholder='Select LEIs']")
    private WebElementFacade selectLEIs;

    @FindBy(xpath="//input[@placeholder='Select Org Type']")
    private WebElementFacade selectOrgType;

    @FindBy(xpath="//input[@placeholder='Select Doc Type']")
    private WebElementFacade selectDocType;

    @FindBy(xpath="//div[text()='Group name']")
    private WebElementFacade groupName_Text;

    @FindBy(xpath="//div[text()='Organisation name']")
    private WebElementFacade organisationName_Text;

    @FindBy(xpath="//div[text()='Doc type']")
    private WebElementFacade docType_Text;

    @FindBy(xpath="//div[text()='LEIs name']")
    private WebElementFacade LEIName_Text;

    @FindBy(xpath="//div[text()='Org type']")
    private WebElementFacade orgType_Text;

    @FindBy(xpath="//div[text()='No. of users']")
    private WebElementFacade No_of_Users_Text;

    @FindBy(xpath="//div[text()='Created on']")
    private WebElementFacade createdOn_Text;

    @FindBy(xpath="//div[text()='Action']")
    private WebElementFacade action_Text;

    @FindBy(xpath="//button[text()='+ Create Approval Group']")
    private WebElementFacade createApprovalGroup_btn;

    @FindBy(xpath="//tbody//tr//td[1]")
    private WebElementFacade approvalGrp_name;

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationName_box;

    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgType_box;

    @FindBy(xpath = "//div[text()='Select Leis']")
    private WebElementFacade leiName_box;

    @FindBy(xpath = "//input[@placeholder='Enter group name']")
    private WebElementFacade groupName_box;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;

    @FindBy(xpath = "//div[text()='Add users']")
    private WebElementFacade adduser_text;

    @FindBy(xpath = "//input[@placeholder='Search by email id']")
    private WebElementFacade searchEmail_Add;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade add_btn;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;

    @FindBy(xpath = "//p[text()='No Record Found']")
    private WebElementFacade NoRecordFound;

    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade Update_btn;

    @FindBy(xpath = "//div[text()='Update approval group']")
    private WebElementFacade UpdateApprovalGroup_Text;

    @FindBy(xpath = "//div[@class='cross-icon ']")
    private WebElementFacade cross_icon;

    @FindBy(xpath="//div[@class='lei-org-title']/div/div/div/div//input[@placeholder='Select Org Type']")
    private WebElementFacade select_OrgType_addedLEI;

    @FindBy(xpath = "//tbody//td[6]")
    private WebElementFacade noOfUsers_value;

    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profileIconButton_approvalGroup;

    @FindBy(xpath = "//header[@class='pf-header']")
    private WebElementFacade organisationNameHeading_approvalGroup;


    public void navigateToApprovalGrpScreen(){
        try {
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            navigation_btn.waitUntilClickable().click();
            if (approvalGroup_btn.isVisible()) {
                approvalGroup_btn.waitUntilClickable().click();
            }
            else{
                groupsTemplate_btn.waitUntilClickable().click();
                approvalGroup_btn.click();
            }
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Service not found in the navigation menu -->"+e);
            Assert.fail();
        }
    }
    public void select_docType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectDocType.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(selectDocType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(selectDocType).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to search approval group" +e);
            Assert.fail();
        }
    }
    public void search_ApprovalGroup(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            search_approvalGroupName.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(search_approvalGroupName).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(search_approvalGroupName).click().sendKeys(dataTable.get("Group Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            approvalGrp_name.waitUntilVisible();
            if(dataTable.get("Group Name").equalsIgnoreCase(approvalGrp_name.getText())){
                log.info("Corresponding approval group is visible");
            }
        }
        catch (Exception e){
            log.error("Not able to see corresponding approval group details" +e);
            Assert.fail();
        }
    }
    public void user_fills_the_group_name(){
        String ranstring = RandomString.make(5);
        try {
            groupName_box.waitUntilClickable();
            withAction().moveToElement(groupName_box).click().sendKeys(ranstring).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("user is unable to input the group name -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_organization_name(){
        try {
            organizationName_box.waitUntilClickable();
            profileIconButton_approvalGroup.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            String OrganisationHeading= organisationNameHeading_approvalGroup.getText().trim();
            withAction().moveToElement(organizationName_box).click().sendKeys(OrganisationHeading).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the organisation name -->"+e);
            Assert.fail();
        }
    }

    public void user_fills_the_doc_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectDocType.waitUntilClickable();
            withAction().moveToElement(selectDocType).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Doc type -->"+e);
            Assert.fail();
        }
    }

    public void user_fills_the_leis() {
        try {
            leiName_box.waitUntilClickable();
            withAction().moveToElement(leiName_box).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the LEI name -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_org_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            orgType_box.waitUntilClickable();
            withAction().moveToElement(orgType_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("org type"),Keys.DOWN,Keys.RETURN).build().perform();}
        catch (Exception e){
            log.error("Unable to fill in the Org type -->"+e);
            Assert.fail();
        }
    }
    public void addUser(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            searchEmail_Add.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(searchEmail_Add).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(searchEmail_Add).click().sendKeys(dataTable.get("Email Id")).pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to add user" +e);
            Assert.fail();
        }
    }
    public void selectOrgType_addedLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_OrgType_addedLEI.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).click().sendKeys(dataTable.get("Org Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to select org type" +e);
            Assert.fail();
        }
    }
    public void searchPreviouslyCreated_approvalGroup(){
        try{
            String FirstApprovalGroup= approvalGrp_name.getText().trim();
            withAction().moveToElement(search_approvalGroupName).click().sendKeys(FirstApprovalGroup).pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search previously added approval group" +e);
            Assert.fail();
        }
    }
}
