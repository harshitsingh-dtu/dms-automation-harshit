package PageObjects.PlatformServices;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
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
import java.util.logging.Logger;

@Slf4j
@Data
public class LegalUsersPageObject extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Search by user name & email']")
    private WebElementFacade search_ByEmailid;
    @FindBy(xpath = "//label[text()='Select legacy orgs']")
    private WebElementFacade filter_legacyorgs;
    @FindBy(xpath = "//label[text()='All legacy org types']")
    private WebElementFacade filter_legacyorgstype;
    @FindBy(xpath = "//label[text()='All applications']")
    private WebElementFacade filter_applications;
    @FindBy(xpath = "(//input[@role='combobox'])[4]")
    private WebElementFacade filter_status;
    @FindBy(xpath = "(//div[text()='Legacy Users'])[1]")
    private WebElementFacade Legacy_users_text;
    @FindBy(xpath = "//main[@class='pt-erroring-modal-body']")
    private WebElementFacade popup_body;
    @FindBy(xpath = "//h3[text()='Create new platform user']")
    private WebElementFacade ceate_new_platform_user_page_header_text;

    @FindBy(xpath = "//input[@id='email-input']")
    private WebElementFacade email_text_box;
    @FindBy(xpath = "//input[@id='firstname-input']")
    private WebElementFacade first_name_text_box;
    @FindBy(xpath = "//input[@id='lastname-input']")
    private WebElementFacade last_name_text_box;
    @FindBy(xpath = "//input[@id='parentorg-select']")
    private WebElementFacade parent_org_text_box;

//    listing screen elements

    @FindBy(xpath = "//tr//th//div[text()='Legacy user’s name']")
    private WebElementFacade column_LegacyUsername;
    @FindBy(xpath = "//tr//th//div[text()='Username']")
    private WebElementFacade column_Username;
    @FindBy(xpath = "//tr//th//div[text()='Email Id']")
    private WebElementFacade column_Email_Id;
    @FindBy(xpath = "//tr//th//div[text()='Contact Number']")
    private WebElementFacade column_Contact_Number;
    @FindBy(xpath = "//tr//th//div[text()='Legacy org']")
    private WebElementFacade column_Legacy_org;
    @FindBy(xpath = "//tr//th//div[text()='Legacy org type']")
    private WebElementFacade column_Legacy_org_type;
    @FindBy(xpath = "//tr//th//div[text()='Source Application']")
    private WebElementFacade column_Source_Application;
    @FindBy(xpath = "//tr//th//div[text()='Platform user']")
    private WebElementFacade column_Platform_user;
    @FindBy(xpath = "//tr//th//div[text()='Action']")
    private WebElementFacade column_Action;
    //    view screen elements
    @FindBy(xpath = "//div[text()=\"Legacy User's name\"]")
    private WebElementFacade viewScreen_column_LegacyUsername;
    @FindBy(xpath = "//div[text()=\"Username\"]")
    private WebElementFacade viewScreen_column_Username;
    @FindBy(xpath = "//div[@class=\"details-card \"]//div[text()=\"Email ID\"]")
    private WebElementFacade viewScreen_column_Email_ID;
    @FindBy(xpath = "//div[@class=\"details-card \"]//div[text()=\"Contact number\"]")
    private WebElementFacade viewScreen_column_Contact_number;
    @FindBy(xpath = "//div[@class=\"details-card \"]//div[text()=\"Legacy Org\"]")
    private WebElementFacade viewScreen_column_Legacy_Org;
    @FindBy(xpath = "//div[@class=\"details-card \"]//div[text()=\"Legacy Org type\"]")
    private WebElementFacade viewScreen_column_Legacy_Org_type;
    @FindBy(xpath = "//div[@class=\"details-card \"]//div[text()=\"Source Application\"]")
    private WebElementFacade viewScreen_column_Source_Application;
    @FindBy(xpath = "//div[@class=\"details-card \"]//div[text()=\"Platform status\"]")
    private WebElementFacade viewScreen_column_Platform_status;


    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"User’s name\"]")
    private WebElementFacade viewScreen_platformcolumn_username;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Email ID\"]")
    private WebElementFacade viewScreen_platformcolumn_Email_ID;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Parent LEI ID\"]")
    private WebElementFacade viewScreen_platformcolumn_Parent_LEI_ID;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Parent Org name\"]")
    private WebElementFacade viewScreen_platformcolumn_Parent_Org_name;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Contact number\"]")
    private WebElementFacade viewScreen_platformcolumn_Contact_number;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Status\"]")
    private WebElementFacade viewScreen_platformcolumn_Status;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Password status\"]")
    private WebElementFacade viewScreen_platformcolumn_Password_status;
    @FindBy(xpath = "//div[@class=\"custom_accordion platform-user-acc\"]//div[text()=\"Action\"]")
    private WebElementFacade viewScreen_platformcolumn_Action;

    @FindBy(xpath = "///div[@class=\"custom_accordion legacy-org-acc\"]//div[text()=\"Name of legacy Org\"]")
    private WebElementFacade viewScreen_legacycolumn_Name_of_legacy_Org;
    @FindBy(xpath = "///div[@class=\"custom_accordion legacy-org-acc\"]//div[text()=\"Legacy Org type\"]")
    private WebElementFacade viewScreen_legacycolumn_Legacy_Org_type;
    @FindBy(xpath = "///div[@class=\"custom_accordion legacy-org-acc\"]//div[text()=\"Source Application\"]")
    private WebElementFacade viewScreen_legacycolumn_Source_Application;
    @FindBy(xpath = "///div[@class=\"custom_accordion legacy-org-acc\"]//div[text()=\"Parent LEI ID\"]")
    private WebElementFacade viewScreen_legacycolumn_Parent_LEI_ID;
    @FindBy(xpath = "///div[@class=\"custom_accordion legacy-org-acc\"]//div[text()=\"Parent Org name\"]")
    private WebElementFacade viewScreen_legacycolumn_Parent_Org_name;
    @FindBy(xpath = "///div[@class=\"custom_accordion legacy-org-acc\"]//div[text()=\"Action\"]")
    private WebElementFacade viewScreen_legacycolumn_Action;

    @FindBy(xpath = "//button[text()='Create/map in Platform']")
    private WebElementFacade CreateinPlatformbutton;
    @FindBy(xpath = "//div[text()='Create new user in Platform']")
    private WebElementFacade createnewuserinplatformondoesnotexistpopup;


    public void SearchforLegacyuser(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            search_ByEmailid.waitUntilVisible().clear();
            withAction().moveToElement(search_ByEmailid).click().sendKeys(dataTable.get("Legacy username")).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("unable to search for legacyuser " + e);
            Assert.fail();
        }
    }

    public void SetStatusforlegacyusers(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            filter_status.waitUntilVisible().clear();
            withAction().moveToElement(filter_status).click().sendKeys(dataTable.get("Status")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            search_ByEmailid.waitUntilVisible().clear();
        } catch (Exception e) {
            log.error("unable to set Status for legacy user " + e);
            Assert.fail();
        }
    }
    public void Statusforlegacyusers(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        filter_status.sendKeys(dataTable.get("Status"));
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        withAction().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Legacy_users_text.click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void check_popup_is_present_or_not()
    {
        if (popup_body.isPresent())
        {
            log.error("Popup is presnt TC close");
            getDriver().quit();
        }
        else {
            log.error("Popup not found executing next step");
        }

    }


    //    Passing dynamic email
    public void insert_email(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String s = RandomStringUtils.randomAlphabetic(3);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            email_text_box.waitUntilVisible().clear();
            withAction().moveToElement(email_text_box).click().sendKeys(s+dataTable.get("Email")).pause(Duration.ofSeconds(2)).build().perform();
//            withAction().moveToElement(email_text_box).click().sendKeys("abc"+s+"@gmail.com").pause(Duration.ofSeconds(2)).build().perform();

        } catch (Exception e) {
            log.error("unable to insert_email " + e);
            Assert.fail();
        }

    }
    public void insert_first_name(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            first_name_text_box.waitUntilVisible().clear();
            withAction().moveToElement(first_name_text_box).click().sendKeys(dataTable.get("first name")).pause(Duration.ofSeconds(2)).build().perform();

        } catch (Exception e) {
            log.error("unable to insert_first_name" + e);
            Assert.fail();
        }
    }
    public void insert_last_name(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            last_name_text_box.waitUntilVisible().clear();
            withAction().moveToElement(last_name_text_box).click().sendKeys(dataTable.get("last name")).pause(Duration.ofSeconds(2)).build().perform();

        } catch (Exception e) {
            log.error("unable to insert_last_name " + e);
            Assert.fail();
        }
    }

    public void insert_parent_org_name(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {

        } catch (Exception e) {
            log.error("unable to insert_parent_org_name " + e);
            Assert.fail();
        }
    }

    public void clickCreate_in_Platform_button(){
        try{
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(CreateinPlatformbutton.isVisible());
            CreateinPlatformbutton.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Create/map in Platform button is not visible" +e);
            Assert.fail();
        }
    }

    public void Clickoncreatenewuserinplatformonuserdoesnotexistinplatformpopup(){
        try{
            Assert.assertTrue(createnewuserinplatformondoesnotexistpopup.isVisible());
            createnewuserinplatformondoesnotexistpopup.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("create new user in platform button not visible on User does not exist POPUP" +e);
            Assert.fail();
        }
    }
}