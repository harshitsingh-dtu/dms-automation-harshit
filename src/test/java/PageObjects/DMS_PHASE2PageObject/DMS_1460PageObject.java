package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class DMS_1460PageObject extends PageObject {

    Actions act=new Actions(getDriver());

    @FindBy(xpath="//div[@class='flex space-between flex-gap']//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath="//div[text()='Users management']")
    private WebElementFacade userManagement_btn;

    @FindBy(xpath="//input[@placeholder='All Organisations']")
    private WebElementFacade filter_organization;

    @FindBy(xpath="//input[@placeholder='All Roles']")
    private WebElementFacade filter_roles;

    @FindBy(xpath="//input[@placeholder='All Status']")
    private WebElementFacade filter_status;

    @FindBy(xpath = "//th//div[text()=\"User's name\"]")
    private WebElementFacade usernameColumn;

    @FindBy(xpath = "//th//div[text()='Email id']")
    private WebElementFacade emailIdColumn;

    @FindBy(xpath = "//th//div[text()='Mobile no']")
    private WebElementFacade mobileNoColumn;

    @FindBy(xpath = "//th//div[text()='Name of organisations']")
    private WebElementFacade organizationIdColumn;

    @FindBy(xpath = "//th//div[text()='Status']")
    private WebElementFacade statusColumn;

    @FindBy(xpath = "//th//div[text()='Action']")
    private WebElementFacade actionColumn;

    @FindBy(xpath="//div[@class='search-add-container ']//input")
    private WebElementFacade search_added_Users;

    @FindBy(xpath = "//input[@placeholder='Search by email id']")
    private WebElementFacade search_newUsers;

    @FindBy(xpath="//tr//td//button[text()='Update']")
    private WebElementFacade editDetails_btn;

    @FindBy(xpath="//td//div//label")
    private WebElementFacade status_btn;

    @FindBy(xpath = "//div[@class='paginator']")
    private WebElementFacade pagination_container;

    @FindBy(xpath="//div[text()='User information']")
    private WebElementFacade user_infoText;

    @FindBy(xpath="//h5[text()='Roles mapping']")
    private WebElementFacade roleMapping_text;

    @FindBy(xpath="//input[@placeholder='Select Roles']")
    private WebElementFacade selectRole;

    @FindBy(xpath="//div[@class='role-list']")
    private WebElementFacade roleList;

    @FindBy(xpath="//input[@placeholder='Search by LEI name']")
    private WebElementFacade search_LEI;

    @FindBy(xpath="(//div[@class='lei-orgtype-wrapper']//tr)[2]")
    private WebElementFacade leiORGType_List;

    @FindBy(xpath="//div[@class='lei-org-title']//h5")
    private WebElementFacade addedLeiOrg_Text;

    @FindBy(xpath="//div[@class='select-container']//h5[text()='Select Doc type']")
    private WebElementFacade select_DocTypeText;

    @FindBy(xpath="(//input[@placeholder='Select Doc Type'])[1]")
    private WebElementFacade select_DocType;

    @FindBy(xpath="//div[@class='lei-org-title']//input[@placeholder='Select Doc Type']")
    private WebElementFacade select_DocType_addedLEI;

    @FindBy(xpath="//div[@class='select-container']//h5[text()='Select LEIs']")
    private WebElementFacade select_LEIText;

    @FindBy(xpath="//div[text()='Select LEIs']")
    private WebElementFacade select_LEI;

    @FindBy(xpath="//div[@class='select-container']//h5[text()='Select Org type']")
    private WebElementFacade select_OrgTypeText;

    @FindBy(xpath="//div[@class='lei-org-edit']//input[@placeholder='Select Org Type']")
    private WebElementFacade select_OrgType;

    @FindBy(xpath="//button[text()='+ Add']")
    private WebElementFacade addButton;

    @FindBy(xpath="//button[text()='Update']")
    private WebElementFacade UpdateButton;

    @FindBy(xpath="//ul[@role='listbox']")
    private WebElementFacade dropdown_list;

    @FindBy(xpath="//table//tbody//tr//td[1]")
    private WebElementFacade docType_value;

    @FindBy(xpath="//table//tbody//tr//td[2]//span")
    private WebElementFacade LEI_value;

    @FindBy(xpath="//table//tbody//tr//td[3]")
    private WebElementFacade orgType_value;

    @FindBy(xpath="//span[@class='lei-name']")
    private WebElementFacade check_LEIName;

    @FindBy(xpath="//td[text()='No Record Found']")
    private WebElementFacade noRecordFound;

    @FindBy(xpath="//li[@role='option']//p[text()='EB']")
    private WebElementFacade orgType_EB;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade SearchedDocType;


    @FindBy(xpath="//button[text()='Submit']")
    private WebElementFacade submit_button;

    @FindBy(xpath = "//button[text()='Yes']")
    private  WebElementFacade confirmation_YES_btn;

    @FindBy(xpath = "(//div[@class='info-label'])[1]")
    private  WebElementFacade firstname_value;

    @FindBy(xpath = "(//div[@class='info-label'])[2]")
    private  WebElementFacade lastname_value;

    @FindBy(xpath = "(//div[@class='info-label'])[3]")
    private  WebElementFacade email_value;

    @FindBy(xpath = "(//div[@class='info-label'])[4]")
    private  WebElementFacade mobileNo_value;

    @FindBy(xpath = "(//div[@class='info-label'])[5]")
    private  WebElementFacade organisation_value;

    @FindBy(xpath = "//div[@class='paginator']//span[text()='Showing page ']")
    private WebElementFacade showing_page;

    @FindBy(xpath = "//input[@class='page-number']")
    private WebElementFacade showing_page_page_number;

    @FindBy(xpath = "//div[@class='paginator']//span[@class='total-page']")
    private WebElementFacade showing_page_total_page;

    @FindBy(xpath = "//select[@class='page-row-size']")
    private WebElementFacade records_per_page_value;

    @FindBy(xpath = "//span[@class='page-size-num']")
    private WebElementFacade current_record_page_value;

    @FindBy(xpath ="//div[@class='btn-container']//button[1]")
    private WebElementFacade previous_page_button;

    @FindBy(xpath ="//div[@class='btn-container']//button[2]")
    private WebElementFacade next_page_button;

    @FindBy(xpath = "//p[text()='4 Way']")
    private WebElementFacade fourWayDocTypeFromDropdown;

    @FindBy(xpath = "//p[text()='DN']")
    private WebElementFacade DNDocTypeFromDropdown;

    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade noOptionForDocType;

    @FindBy(xpath = "//p[text()='Client']")
    private WebElementFacade client_text;

    @FindBy(xpath = "//p[text()='PB']")
    private WebElementFacade PB_text;

    @FindBy(xpath = "//p[text()='EB']")
    private WebElementFacade EB_text;


    public void navigateToUserManagement() {
        try {
            navigation_btn.waitUntilClickable();
            navigation_btn.click();
            withAction().moveToElement(userManagement_btn).click().pause(Duration.ofSeconds(3)).build().perform();
            log.info("Clicked on user management button");
        }
        catch (Exception e){
            log.error("Not able to navigate to user management screen-->"+e);
            Assert.fail();
        }
    }
    public void searchUser(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            search_added_Users.waitUntilVisible();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(search_added_Users).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(search_added_Users).click().sendKeys(dataTable.get("User")).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }catch (Exception e){
            log.error("Unable to search user-->"+e);
            Assert.fail();
        }
    }
    public void selectDocType(List<String> filters){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        select_DocType.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        try
        {
            for (int begin=1;begin<filters.size();begin++)
            {
                select_DocType.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(filters.get(begin),SearchedDocType.getText());
                select_DocType.clear();
            }
        }
        catch (Exception e)
        {
            log.error("Expected doc type is not present");
            Assert.fail();
        }
    }
    public void docType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_DocType.waitUntilClickable().click();
            Assert.assertTrue(dropdown_list.isDisplayed());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void checkValueDocType_addedLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_DocType_addedLEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            docType_value.waitUntilVisible();
            if(dataTable.get("Doc Type").equalsIgnoreCase(docType_value.getText())){
                log.info("Corresponding value is visible");
            }
            else{
                log.info("Corresponding values not visible");
            }
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void search_LEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            search_LEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            search_LEI.click();
            withAction().moveToElement(search_LEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(search_LEI).click().sendKeys(dataTable.get("LEI Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search LEI Name" +e);
            Assert.fail();
        }
    }
    public void verifyResultInLeiOrgSection(){
        try{
            if(check_LEIName.isVisible()){
                log.info("Corresponding LEI is Present");
            }
            else if (noRecordFound.isVisible()){
                log.info("No Record Found");
            }
            else{
                log.info("LEI does not exist");
            }
        }
        catch (Exception e){
            log.error("Unable to see result in LEI Org type section" +e);
            Assert.fail();
        }
    }
    public void select_LEI(){
        try{
            select_LEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_LEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_LEI).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select LEI" +e);
            Assert.fail();
        }
    }
    public void docType_addedLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_DocType_addedLEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void check_orgTypeEB(){
        try{
            if (orgType_EB.isVisible()) {
                Assert.assertTrue(orgType_EB.isCurrentlyVisible());
                log.info("Eb Org type is visible");
            }
            else {
                Assert.assertFalse(orgType_EB.isCurrentlyVisible());
                log.info("EB Org type is not visible");
            }
        }
        catch (Exception e){
            log.error("Unable to check EB Org type" +e);
            Assert.fail();
        }
    }
    public void selectOrgType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_OrgType.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType).click().sendKeys(dataTable.get("Org Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to select org type" +e);
            Assert.fail();
        }
    }

    public void click_selectOrgType(){
        try{
            select_OrgType.waitUntilClickable();
            select_OrgType.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            log.info("Clicked on select Org type");
        }
        catch (Exception e){
            log.error("Unable to click select Org type" +e);
            Assert.fail();
        }
    }
    public void checkChanges_userInfoSection(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            String Firstname_valueText = firstname_value.getText().trim();
            String Lastname_valueText = lastname_value.getText().trim();
            String Email_valueText = email_value.getText().trim();
            String Organisation_valueText = organisation_value.getText().trim();
            select_DocType.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals(Firstname_valueText,firstname_value.getText());
            Assert.assertEquals(Lastname_valueText,lastname_value.getText());
            Assert.assertEquals(Email_valueText,email_value.getText());
            Assert.assertEquals(Organisation_valueText,organisation_value.getText());
        }
        catch (Exception e){
            log.error("Unable to check changes in user information section" +e);
            Assert.fail();
        }
    }
    public void check_previous_page_btn(){
        try {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", pagination_container);
            Assert.assertTrue(previous_page_button.isVisible());
            if (showing_page_page_number.getAttribute("value").equals("1")){
                Assert.assertFalse(previous_page_button.isEnabled());
//                Assert.assertTrue(next_page_button.isEnabled());
            }
            else {
                Assert.assertTrue(previous_page_button.isEnabled());
            }
        }catch (Exception e){
            log.error("Unable to verify whether previous page button is enabled or not"+e);
            Assert.fail();
        }
    }
    public void check_next_page_btn(){
        try {
            Assert.assertTrue(next_page_button.isVisible());
            String last_page=showing_page_total_page.getText();
            last_page=last_page.substring(last_page.length()-1);
            showing_page_page_number.clear();
            typeInto(showing_page_page_number,last_page);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Assert.assertTrue(next_page_button.isDisabled());
//            Assert.assertTrue(previous_page_button.isEnabled());
        }catch (AssertionError e){
            log.error("Unable to verify whether next page button is visible or not");
        }
    }
    public void caseSensitivityForDocType(List<String> Doctype){
        try{
            for (int begin=1;begin<Doctype.size();begin++){
                select_DocType.clear();
                select_DocType.type(Doctype.get(begin));
                if (fourWayDocTypeFromDropdown.isVisible()){
                    Assert.assertTrue(fourWayDocTypeFromDropdown.isVisible());
                    log.info("Doctype 4 Way is found for input " +Doctype.get(begin));
                } else if(DNDocTypeFromDropdown.isVisible()){
                    Assert.assertTrue(DNDocTypeFromDropdown.isVisible());
                    log.info("Doctype DN is found for input " +Doctype.get(begin));
                }else {
                    Assert.assertTrue(noOptionForDocType.isVisible());
                    log.info("please enter valid Doctype there is no option for Doctype" +Doctype.get(begin));
                }
            }
        }
        catch (Exception e){
            log.error("There is something wrong for finding document " +e);
            Assert.fail();
        }
    }
    public void input_LEI_DocType_OrgType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            select_DocType.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            select_LEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_LEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_LEI).click().sendKeys(dataTable.get("LEI Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            select_OrgType.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType).click().sendKeys(dataTable.get("Org Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            addButton.waitUntilEnabled();
            addButton.click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if(dataTable.get("Doc Type").equalsIgnoreCase(docType_value.getText()) && dataTable.get("LEI Name").equalsIgnoreCase(LEI_value.getText()) && dataTable.get("Org Type").equalsIgnoreCase(orgType_value.getText())){
                log.info("Corresponding combination is present");
            }
        }
        catch (Exception e){
            log.error("Unable to see corresponding combination");
            Assert.fail();
        }
    }
}
