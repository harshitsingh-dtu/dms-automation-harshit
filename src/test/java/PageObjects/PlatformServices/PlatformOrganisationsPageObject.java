package PageObjects.PlatformServices;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
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
public class PlatformOrganisationsPageObject extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Search by Organisation name/ Parent LEI ID']")
    private WebElementFacade search_ByOrganisationName;
    @FindBy(xpath = "//label[text()='Last updated by']")
    private WebElementFacade filter_LastUpdatedBy;
    @FindBy(xpath = "//input[@placeholder='Start date & time']")
    private  WebElementFacade Filter_date;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private  WebElementFacade filter_status;
    @FindBy(xpath = "//label[text()='Child LEIs']")
    private WebElementFacade tab_childLEIs;
    @FindBy(xpath = "//label[text()='Platform Users']")
    private WebElementFacade tab_platformUsers;
    @FindBy(xpath = "//div[text()='Parent LEI ID']")
    private WebElementFacade viewDetailScreen_column_parentLEIID;
    @FindBy(xpath = "//div[text()='Parent Org name']")
    private WebElementFacade viewDetailScreen_column_parentOrgName;
    @FindBy(xpath = "//div[text()='Active users']")
    private WebElementFacade viewDetailScreen_column_ActiveUsers;
    @FindBy(xpath = "//div[text()='Total users']")
    private WebElementFacade viewDetailScreen_column_TotalUsers;
    @FindBy(xpath = "//div[text()='Address']")
    private WebElementFacade viewDetailScreen_column_Adress;
    @FindBy(xpath = "//div[text()='Organisations type']")
    private WebElementFacade viewDetailScreen_column_Organisationstype;
    @FindBy(xpath = "//div[text()='Source application']")
    private WebElementFacade viewDetailScreen_column_Sourceapplication;
    @FindBy(xpath = "//div[text()='Legacy users']")
    private WebElementFacade viewDetailScreen_column_Legacyusers;
    @FindBy(xpath = "//div[text()='LEIs ID']")
    private WebElementFacade viewDetailScreen_column_LEIsID;
    @FindBy(xpath = "//div[text()='Legal entity name']")
    private WebElementFacade viewDetailScreen_column_Legalentityname;
    @FindBy(xpath = "//div[text()='Legal entity Address']")
    private WebElementFacade viewDetailScreen_column_LegalentityAddress;
    @FindBy(xpath = "//div[text()='Email id']")
    private WebElementFacade viewDetailScreen_column_Emailid;
    @FindBy(xpath = "//div[text()='Contact Number']")
    private WebElementFacade viewDetailScreen_column_ContactNumber;
    @FindBy(xpath = "//div[text()='Status']")
    private WebElementFacade viewDetailScreen_column_Status;
    @FindBy(xpath = "//div[text()='Password Status']")
    private WebElementFacade viewDetailScreen_column_PasswordStatus;
    @FindBy(xpath = "//div[text()=\"User's full name\"]")
    private WebElementFacade viewDetailScreen_column_Usersfullname;

    @FindBy(xpath = "//button[text()='+ Create new Org']")
    private WebElementFacade createnewOrgbutton;
    @FindBy(xpath = "//input[@id='org-input']")
    private  WebElementFacade Typeorganisationname_or_LEIID;
    @FindBy(xpath = "//button[text()='Search']")
    private WebElementFacade searchbutton_for_createnewOrg;
    @FindBy(xpath = "//button[text()='Create New']")
    private WebElementFacade createnewbutton_for_createnewOrg;
    @FindBy(xpath = "//input[@id='orgname-input']")
    private WebElementFacade EnterOrganizationname_for_CreatenewOrg;
    @FindBy(xpath = "//input[@id='address-input']")
    private WebElementFacade EnterAddressLine_for_CreatenewOrg;
    @FindBy(xpath = "//input[@id='country-select']")
    private WebElementFacade EnterCountry_for_CreatenewOrg;
    @FindBy(xpath = "//input[@id='city-input']")
    private WebElementFacade EnterCity_for_CreatenewOrg;
    @FindBy(xpath = "//input[@id='postal-input']")
    private WebElementFacade EnterPostalCode_for_CreatenewOrg;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade SubmitButton_for_CreatenewOrg;
    @FindBy(xpath = "//p[text()='Parent org is created successfully.']")
    private WebElementFacade SuccessMessageforCreateneworg;


    public void search__ByOrganisationName(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(search_ByOrganisationName).click().sendKeys(dataTable.get("search")).pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to search "+e);
            Assert.fail();
        }
    }

    public void Enterorganisationname_or_LEIID(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(Typeorganisationname_or_LEIID.isVisible());
            Typeorganisationname_or_LEIID.waitUntilClickable().clear();
            withAction().moveToElement(Typeorganisationname_or_LEIID).click().sendKeys(dataTable.get("organisation Name / LEI's Name")).pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(searchbutton_for_createnewOrg.isVisible());
            searchbutton_for_createnewOrg.waitUntilClickable().click();
//            withAction().moveToElement(searchbutton_for_createnewOrg).click();
            withAction().pause(Duration.ofSeconds(7)).build().perform();
        }catch (Exception e){
            log.error("Unable to Search for organization on create new org page "+e);
            Assert.fail();
        }
    }

    public void Enterorganisationname(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(EnterOrganizationname_for_CreatenewOrg.isVisible());
            EnterOrganizationname_for_CreatenewOrg.waitUntilVisible().clear();
            withAction().moveToElement(EnterOrganizationname_for_CreatenewOrg).click().sendKeys(dataTable.get("organisation name")).pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to Enter organization name on create new org page "+e);
            Assert.fail();
        }
    }

    public void EnterAddressLine(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(EnterAddressLine_for_CreatenewOrg.isVisible());
            EnterAddressLine_for_CreatenewOrg.waitUntilVisible().clear();
            withAction().moveToElement(EnterAddressLine_for_CreatenewOrg).click().sendKeys(dataTable.get("Addressline")).pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to Enter Address line on create new org page "+e);
            Assert.fail();
        }
    }

    public void Entercountry(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(EnterCountry_for_CreatenewOrg.isVisible());
            EnterCountry_for_CreatenewOrg.waitUntilVisible().clear();
            withAction().moveToElement(EnterCountry_for_CreatenewOrg).click().sendKeys(dataTable.get("Country")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to Enter Country name on create new org page "+e);
            Assert.fail();
        }
    }

    public void EnterCity(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(EnterCity_for_CreatenewOrg.isVisible());
            EnterCity_for_CreatenewOrg.waitUntilVisible().clear();
            withAction().moveToElement(EnterCity_for_CreatenewOrg).click().sendKeys(dataTable.get("City")).pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to Enter City on create new org page "+e);
            Assert.fail();
        }
    }

    public void EnterPostCode(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(EnterPostalCode_for_CreatenewOrg.isVisible());
            EnterPostalCode_for_CreatenewOrg.waitUntilVisible().clear();
            withAction().moveToElement(EnterPostalCode_for_CreatenewOrg).click().sendKeys(dataTable.get("Postalcode")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }catch (Exception e){
            log.error("Unable to Enter PostCode on create new org page "+e);
            Assert.fail();
        }
    }




}