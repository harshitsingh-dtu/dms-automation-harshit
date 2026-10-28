package PageObjects.PlatformServices;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class PlatformUsersPageObject extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Search by user email']")
    private WebElementFacade search_ByuserEmail;
    @FindBy(xpath = "//label[text()='All parent orgs']")
    private WebElementFacade filter_parentOrgs;
    @FindBy(xpath = "//label[text()='Last updated by']")
    private WebElementFacade filter_lastUpdatedBy;
    @FindBy(xpath = "//div[@class='datetimerange']")
    private WebElementFacade filter_date;
    @FindBy(xpath = "")
    private WebElementFacade filter_startDate;
    @FindBy(xpath = "//label[text()='All password status']")
    private WebElementFacade filter_passwordStatus;
    @FindBy(xpath = "//label[text()='All status']")
    private WebElementFacade filter_status;
    @FindBy(xpath = "//button[text()='+ Create Platform User']")
    private WebElementFacade createNewUser_btn;
    //    listing screen column elements
    @FindBy(xpath = "//div[text()='Email Id']")
    private WebElementFacade column_Email_Id;
    @FindBy(xpath = "//div[text()='First name']")
    private WebElementFacade column_First_name;
    @FindBy(xpath = "//div[text()='Last name']")
    private WebElementFacade column_Last_name;
    @FindBy(xpath = "//div[text()='Parent organisation']")
    private WebElementFacade column_Parent_organisation;
    @FindBy(xpath = "//div[text()='Last updated by']")
    private WebElementFacade column_Last_updated_by;
    @FindBy(xpath = "//div[text()='Last updated on (UTC)']")
    private WebElementFacade column_Last_updated_on;
    @FindBy(xpath = "//div[text()='Password status']")
    private WebElementFacade column_Password_status;
    @FindBy(xpath = "//div[text()='Status']")
    private WebElementFacade column_Status;
    @FindBy(xpath = "//div[text()='Action']")
    private WebElementFacade column_Action;
    //    view screen elements
    @FindBy(xpath = "//div[text()=\"User's name\"]")
    private WebElementFacade viewscreen_column_Users_name;
    @FindBy(xpath = "//div[text()=\"Email ID\"]")
    private WebElementFacade viewscreen_column_Email_Id;
    @FindBy(xpath = "//div[text()=\"Parent Org\"]")
    private WebElementFacade viewscreen_Parent_Org;
    @FindBy(xpath = "//div[text()=\"Contact number\"]")
    private WebElementFacade viewscreen_Contact_Number;
    @FindBy(xpath = "//div[text()=\"Password status\"]")
    private WebElementFacade viewscreen_Password_status;

    @FindBy(xpath = "//div[@class=\"custom_accordion parent-org-details\"]//div[text()=\"Parent LEI ID\"]")
    private WebElementFacade viewscreen_parentorg_column_Parent_LEI_ID;
    @FindBy(xpath = "//div[@class=\"custom_accordion parent-org-details\"]//div[text()=\"Parent org name\"]")
    private WebElementFacade viewscreen_parentorg_column_Parent_org_name;
    @FindBy(xpath = "//div[@class=\"custom_accordion parent-org-details\"]//div[text()=\"Active users\"]")
    private WebElementFacade viewscreen_parentorg_column_Active_users;
    @FindBy(xpath = "//div[@class=\"custom_accordion parent-org-details\"]//div[text()=\"Total users\"]")
    private WebElementFacade viewscreen_parentorg_column_Total_users;
    @FindBy(xpath = "//div[@class=\"custom_accordion parent-org-details\"]//div[text()=\"Action\"]")
    private WebElementFacade viewscreen_parentorg_column_Action;

    @FindBy(xpath = "// button[text()='Update Parent']")
    private WebElementFacade viewscreen_parentorg_column_updateParent_button;
    @FindBy(xpath = "//input[@placeholder='Enter org name']")
    private WebElementFacade search_orgnamefor_updateparent;
    @FindBy(xpath = "//button[text()='Search']")
    private WebElementFacade searchbutton_for_updateparent;
    @FindBy(xpath = "//button[text()='Select as Parent']")
    private  WebElementFacade SetASParent_for_searchedOrg;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade ConfirmOnPopUpForSetAsParent;
    @FindBy(xpath = "//h3[text()='Create new platform users']")
    private  WebElementFacade Create_new_plateform_user_text;
    @FindBy(xpath = "//input[@id=\"email-input\"]")
    private WebElementFacade typeuseremailID;
    @FindBy(xpath = "//button[text()='SUBMIT']")
    private WebElementFacade Submitcreatenewplatformuser;
    @FindBy(xpath = "//div[text()='The user associated with this email already exists.']")
    private WebElementFacade errormessageforalreadyexistuser;
    @FindBy(xpath = "//div[@class='pt-scr-container create-user-form']//form")
    private WebElementFacade userDetails_section;
    @FindBy(xpath = "//div[@class='pt-scr-container create-user-form']//Section")
    private WebElementFacade Legacydetails_connected_with_email_Section;
    @FindBy(xpath = "//input[@id='firstname-input']")
    private WebElementFacade typeFirstname;
    @FindBy(xpath = "//input[@id='lastname-input']")
    private WebElementFacade typeLastname;
    @FindBy(xpath = "//input[@placeholder='1 (702) 123-4567']")
    private WebElementFacade typeContactnumber;
    @FindBy(xpath = "//input[@id='parentorg-select']")
    private WebElementFacade typeParantOrgname;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade SubmitButton_for_Createnewplatformuser;
    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade NoButton_of_Doyouwanttocreateanotheruserinplatform;
    @FindBy(xpath = "//div[@class='success popup']/p")
    private WebElementFacade successpopup_for_Createnewplatformuser;


    @FindBy(xpath = "//div[@class=\"custom_accordion legacy-user-details\"]//div[text()=\"User's full name\"]")
    private WebElementFacade viewscreen_legacyuser_column_User_full_name;
    @FindBy(xpath = "//div[@class=\"custom_accordion legacy-user-details\"]//div[text()=\"Username\"]")
    private WebElementFacade viewscreen_legacyuser_column_Username;
    @FindBy(xpath = "//div[@class=\"custom_accordion legacy-user-details\"]//div[text()=\"Contact Number\"]")
    private WebElementFacade viewscreen_legacyuser_column_Contact_Number;
    @FindBy(xpath = "//div[@class=\"custom_accordion legacy-user-details\"]//div[text()=\"Legacy org\"]")
    private WebElementFacade viewscreen_legacyuser_column_Legacy_org;
    @FindBy(xpath = "//div[@class=\"custom_accordion legacy-user-details\"]//div[text()=\"Legacy org type\"]")
    private WebElementFacade viewscreen_legacyuser_column_Legacy_org_type;
    @FindBy(xpath = "//div[@class=\"custom_accordion legacy-user-details\"]//div[text()=\"Source application\"]")
    private WebElementFacade viewscreen_legacyuser_column_Source_application;


    public void typesearchbytheemail(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(search_ByuserEmail).click().sendKeys(dataTable.get("Email")).pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to type email in search " + e);
            Assert.fail();

        }


    }

    public void verifyupdateParentButtonFunctionality(){
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(viewscreen_parentorg_column_updateParent_button.isVisible());
            withAction().moveToElement(viewscreen_parentorg_column_updateParent_button).click().build().perform();
        }catch (Exception e){
            log.error("Update Parent Button is clicked "+e);
            Assert.fail();
        }
    }

    public void searchorgnameforupdateparent(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(search_orgnamefor_updateparent.isVisible());
            withAction().moveToElement(search_orgnamefor_updateparent).click().sendKeys(dataTable.get("Org Name")).pause(Duration.ofSeconds(3)).build().perform();
            searchbutton_for_updateparent.waitUntilVisible().click();
        } catch (Exception e) {
            log.error("Unable to search for org name to update parent" + e);
            Assert.fail();

        }
    }

    public void setasparentforsearchedorg(){
        try{
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(SetASParent_for_searchedOrg.isVisible());
            withAction().moveToElement(SetASParent_for_searchedOrg).click().build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(ConfirmOnPopUpForSetAsParent.isVisible());
            withAction().moveToElement(ConfirmOnPopUpForSetAsParent).click().build().perform();
        } catch (Exception e) {
            log.error("Unable to confirm PopUP" + e);
            Assert.fail();

        }
    }

    public void clickCreatenewplateformuser(){
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(createNewUser_btn.isVisible());
            withAction().moveToElement(createNewUser_btn).click().build().perform();
        }
        catch (Exception e){
            log.error("unable to click Create new platform user button "+e);
            Assert.fail();
        }
    }

    public void typeuseremailoncreatenewplatformuserscreen(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String s = RandomStringUtils.randomAlphabetic(3);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertEquals(Create_new_plateform_user_text.getText(), "Create new platform users");
            withAction().moveToElement(typeuseremailID).click().sendKeys(s+dataTable.get("User email ID")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("unable tp type User Email Id" + e);
            Assert.fail();

        }
    }

    public void typeFirstname(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            typeFirstname.waitUntilVisible().clear();
            withAction().moveToElement(typeFirstname).click().sendKeys(dataTable.get("First Name")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("unable to type User First name" + e);
            Assert.fail();
        }
    }

    public void typeLastname(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            typeLastname.waitUntilVisible().clear();
            withAction().moveToElement(typeLastname).click().sendKeys(dataTable.get("Last Name")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("unable to type User Last name" + e);
            Assert.fail();
        }
    }

    public void typeContactNumber(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            typeContactnumber.waitUntilVisible().clear();
            withAction().moveToElement(typeContactnumber).click().sendKeys(dataTable.get("Contact Number")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("unable to type User Contact number " + e);
            Assert.fail();
        }
    }

    public void typeParentOrg(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            typeParantOrgname.waitUntilVisible().clear();
            withAction().moveToElement(typeParantOrgname).click().sendKeys(dataTable.get("Parent Org")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("unable to type Parent Org " + e);
            Assert.fail();
        }
    }

    public void ClickonSubmitButtonandrespondthesuccesspopup(){
        try{
            Assert.assertTrue(SubmitButton_for_Createnewplatformuser.isVisible());
            SubmitButton_for_Createnewplatformuser.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if(successpopup_for_Createnewplatformuser.isVisible()) {
//                Assert.assertEquals(successpopup_for_Createnewplatformuser.getText(), "success");
                NoButton_of_Doyouwanttocreateanotheruserinplatform.click();
            }else {
                log.info("new platform user is not created successfully");
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (AssertionError e){
            log.error("New Platform user is not created");
            Assert.fail();
        }
    }

    public void SubmitButton_Createnew_platform_usersScreen(){
        try{
            Assert.assertTrue(Submitcreatenewplatformuser.isVisible());
            Submitcreatenewplatformuser.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if(errormessageforalreadyexistuser.isVisible()){
                log.info("The user associated with this email already exists.  Please Try with Another user Email ID");
                Assert.assertEquals(errormessageforalreadyexistuser.getText(),"The user associated with this email already exists.");
            }
        }catch (AssertionError e){
            log.error("Submit button on Create new platform user page not found "+e);
            Assert.fail();
        }
    }



}
