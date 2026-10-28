package PageObjects.PlatformServices;

import com.google.common.collect.Maps;
import com.ibm.icu.impl.UResource;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class LegacyOrganisationsPageObject extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Search by Legacy Organisation name']")
    private WebElementFacade search_ByLegacyOrganisation;
    @FindBy(xpath = "//label[text()='All org types']")
    private WebElementFacade filter_orgType;
    @FindBy(xpath = "//label[text()='All source applications']")
    private WebElementFacade filter_sourceApplications;
    @FindBy(xpath = "//label[text()='All parent orgs']")
    private WebElementFacade filter_parentOrgs;
    @FindBy(xpath = "//input[@placeholder='Start date & time']")
    private WebElementFacade filter_startdate;
    @FindBy(xpath = "//input[@placeholder='End date & time']")
    private WebElementFacade filter_enddate;
    @FindBy(xpath = "//button[text()='Map Parent']")
    private  WebElementFacade mapParent_btn;
    @FindBy(xpath = "//input[@placeholder='Enter org name']")
    private WebElementFacade search_ParentOrgLegalEntity;
    @FindBy(xpath = "//button[text()='Search']")
    private  WebElementFacade search_btn;
    @FindBy(xpath = "//button[text()='Select as Parent']")
    private  WebElementFacade selectAsParent_btn;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade confirmDialog_Yes_btn;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='No']")
    private WebElementFacade confirmDialog_No_btn;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;
    //listing screen column names
    @FindBy(xpath = "//div[text()='Name of legacy Organisations']")
    private WebElementFacade column_NameoflegacyOrganisations;
    @FindBy(xpath = "//div[text()='Organisations type']")
    private WebElementFacade column_Organisationstype;
    @FindBy(xpath = "//div[text()='Source application']")
    private WebElementFacade column_Sourceapplication;
    @FindBy(xpath = "//div[text()='Parent LEI ID']")
    private WebElementFacade column_ParentLEIID;
    @FindBy(xpath = "//div[text()='Parent Org name']")
    private WebElementFacade column_ParentOrgname;
    @FindBy(xpath = "//div[text()='Updated time (UTC)']")
    private WebElementFacade column_Updatedtime;
    @FindBy(xpath = "//div[text()='Action']")
    private WebElementFacade column_Action;
    //    view screen column names
    @FindBy(xpath = "//div[text()='Legacy organisation name']")
    private WebElementFacade viewScreen_Legacy_organisation_name;
    @FindBy(xpath = "//div[text()='Legacy user']")
    private WebElementFacade viewScreen_Legacy_user;
    @FindBy(xpath = "//div[text()='Org Type']")
    private WebElementFacade viewScreen_Org_Type;
    @FindBy(xpath = "//div[text()='Source Application']")
    private WebElementFacade viewScreen_Source_Application;

    @FindBy(xpath = "//div[text()='Parent LEI ID']")
    private WebElementFacade viewScreen_Parent_LEI_ID;
    @FindBy(xpath = "//div[text()='Parent org name]")
    private WebElementFacade viewScreen_Parent_org_name;
    @FindBy(xpath = "//div[text()='Active users']")
    private WebElementFacade viewScreen_Active_users;
    @FindBy(xpath = "//div[text()='Total users']")
    private WebElementFacade viewScreen_Total_users;

    @FindBy(xpath = "//div[text()='User's full name']")
    private WebElementFacade viewScreen_UserFullName;
    @FindBy(xpath = "//div[text()='Username']")
    private WebElementFacade viewScreen_Username;
    @FindBy(xpath = "//div[text()='Email Id']")
    private WebElementFacade viewScreen_Email_Id;
    @FindBy(xpath = "//div[text()='Contact Number']")
    private WebElementFacade viewScreen_Contact_Number;
    @FindBy(xpath = "//div[text()='Platform user']")
    private WebElementFacade viewScreen_Platform_user;

    public void type_filterOrgTypes(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            withAction().moveToElement(filter_orgType).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to set the filter");
        }
    }
    public void type_filterSourceApplication(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            withAction().moveToElement(filter_sourceApplications).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to set the filter");
        }
    }
    public void type_filterParentOrgs(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            withAction().moveToElement(filter_parentOrgs).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to set the filter");
        }
    }
}