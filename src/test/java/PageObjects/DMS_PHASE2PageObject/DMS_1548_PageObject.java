package PageObjects.DMS_PHASE2PageObject;

import PageObjects.PermissionsPageObject.ApprovalGroupPermissionsPageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefinations.DMS_Phase2Step.DMS_1548_Step;

import java.time.Duration;
import java.util.*;

@Slf4j
@Data

public class DMS_1548_PageObject extends PageObject {

    ApprovalGroupPermissionsPageObject approvalGroupPermissionsPageObject;
    @FindBy(xpath = "//ul[@role='listbox']")
    private WebElementFacade Roles_list_from_role_mapping_dropdown;
    @FindBy(xpath = "//input[@placeholder='Select Roles']")
    private WebElementFacade roleMapping;
    @FindBy(xpath = "//input[@placeholder='Search by product name']")
    private WebElementFacade productGroupSearch_bar;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElementFacade> Number_of_Product_groups_present_on_listing_screen;
    @FindBy(xpath = "//tbody/tr//button")
    private List<WebElementFacade> Number_of_UPDATE_buttons_Product_groups_listing_screen;
    @FindBy(xpath = "//input[@placeholder='Asset Class']")
    private WebElementFacade SelectAssetClass;
    @FindBy(xpath = "//tbody/tr//button[text()='Update']")
    private WebElementFacade UPDATE_buttons_Product_groups_listing_screen;
    @FindBy(xpath = "//button[text()='Add Product Line']")
    private WebElementFacade AddProductLine_btn;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Cancel_btn;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade Toast_alert_msg;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElementFacade> Product_groups_org_names_listing_screen;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElementFacade> Groups_org_names_listing_screen;
    @FindBy(xpath = "//div[@class='profile-menus']//header")
    private WebElementFacade User_organisation;
    @FindBy(xpath = "//div[@class='profile-menus']//h3")
    private WebElementFacade User_name;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationname_box;
    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profile;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade select_organisation;
    @FindBy(xpath = "//input[@placeholder='Enter product group name']")
    private WebElementFacade product_group_name_input;
    @FindBy(xpath = "//div[@class='flex align-center justify-center pointer sidebar-icon']")
//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade navigation_btn;
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupAndTemplate_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Currencies groups']")
    private WebElementFacade Currencies_group_tab;
    @FindBy(xpath = "//button[text()='+ Create New Group']")
    private WebElementFacade Create_new_group_btn;
    @FindBy(xpath = "//input[@placeholder='Enter currencies group name']")
    private WebElementFacade currencies_group_name_input;
    @FindBy(xpath = "//tr//td[4]")
    private List<WebElementFacade> user_org_names_listing_screen;
    @FindBy(xpath = "//tr//td[6]")
    private List<WebElementFacade> Action_btn_listing_screen;
    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRoles;
    @FindBy(xpath = "//div[@class='enable-switch ']")
    private WebElementFacade active_btn;
    @FindBy(xpath = "//div[text()='Organisations']")
    private WebElementFacade Organisations_btn;
    @FindBy(xpath = "//tr//td[4]")
    private List<WebElementFacade> Organisations_update_btn;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElementFacade> Organisations_names;
    @FindBy(xpath = "//div[normalize-space()='Document']")
    private WebElementFacade document_tab;
    @FindBy(xpath = "//*[text()='All documents']")
    private WebElementFacade allDocument_tab;
    @FindBy(xpath = "//img[@alt='Download']")
    private WebElementFacade Document_download_btn;
    @FindBy(xpath = "//tr//td[4]")
    private List<WebElementFacade> org_names_user_Management_listing_screen;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElementFacade> org_names_organisations_Management_listing_screen;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Approval groups']")
    private WebElementFacade Approval_group_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Approval matrices']")
    private WebElementFacade Approval_matrix_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Document templates']")
    private WebElementFacade Document_template_tab;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElementFacade> list_of_docs_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Download']")
    private List<WebElementFacade> list_of_download_btn_on_listing_screen;
    @FindBy(xpath = "//div[@class='detail-pf']/div")
    private List<WebElementFacade> list_of_LEI_assigned_to_user;
    @FindBy(xpath = "//span[text()=' Profile details']")
    private WebElementFacade profile_details_tab;
    @FindBy(xpath = "//img[@alt='Edit']")
    private List<WebElementFacade> list_of_Edit_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade edit_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Delete']")
    private List<WebElementFacade> list_of_Delete_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Terminate']")
    private List<WebElementFacade> list_of_Terminate_btn_on_listing_screen;
    @FindBy(xpath = "//tr//td[1]")
    private List<WebElementFacade> list_of_user_name_on_user_management_listing_screen;
    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade Delete_btn_on_listing_screen;
    @FindBy(xpath = "//input[@placeholder='Select Doc type']")
    private WebElementFacade Select_Doc_type_input;
    @FindBy(xpath = "//input[@placeholder='Select Orgtype']")
    private WebElementFacade Select_acting_As_input;
    @FindBy(xpath = "//ul[contains(@class,'MuiAutocomplete-listbox')]")
    private WebElementFacade list_of_acting_As_dropdown;
    @FindBy(xpath = "//p[contains(@class,'MuiTypography-root MuiTypography-body1')]")
    private WebElementFacade SearchedDocType;
    @FindBy(xpath = "//input[@placeholder='Select Doc type']")
    private WebElementFacade Document_Type_Input_on_create_doc_page;
    @FindBy(xpath = "//*[@id='react-select-14-input' or text()='Select Prime Broker - 1']")
    private WebElementFacade selectPB1;
    @FindBy(xpath = "//*[@id='react-select-3-placeholder' or text()='Select Client - 1']")
    private WebElementFacade selectClient1;
    @FindBy(xpath = "//*[@id='react-select-4-placeholder']")
    private WebElementFacade selectPB2;
    @FindBy(xpath = "//*[@id='react-select-5-placeholder']")
    private WebElementFacade selectClient2;
    @FindBy(xpath = "//*[@id='react-select-14-input' or text()='Select Executing Broker - 1']")
    private WebElementFacade selectEB1;
    @FindBy(xpath = "//tbody/tr/td[@class]")
    private WebElementFacade document_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Reject']")
    private WebElementFacade Document_REJECT_btn;
    @FindBy(xpath = "//img[@alt='Approve']")
    private WebElementFacade Document_Approve_btn;
    @FindBy(xpath = "//img[@alt='Terminate']")
    private WebElementFacade Document_Terminate_btn;
    @FindBy(xpath = "//img[@alt='Cancel']")
    private WebElementFacade Document_Cancel_btn;
    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade Document_Delete_btn;
    @FindBy(xpath = "//tr//td[1]")
    private List<WebElementFacade> org_names_on_Approval_Matrix_listing_screen;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElementFacade> org_names_on_Document_Template_listing_screen;
    @FindBy(xpath = "//a[@data-testid='submenu-link-USP Riders']")
    private WebElementFacade USP_rider_Template_tab;
    @FindBy(xpath = "//img[@alt='delete-line']")
    private List<WebElementFacade> Product_line_delete_btn;
    @FindBy(xpath = "//img[@alt='delete-line']")
    private WebElementFacade Product_line_delete_button;

    public void Search_product_group(List<String> product_groups) {
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(productGroupSearch_bar).click().sendKeys(product_groups.get(1)).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to search Product group-->" + e);
            Assert.fail();
        }
    }

    public void verifyRolesFromRoleMappingDropdown(List<String> roles) {
        roleMapping.waitUntilClickable();
        roleMapping.click();
        for (int begin = 1; begin < roles.size(); begin++) {
            if (Roles_list_from_role_mapping_dropdown.getText().contains(roles.get(begin))) {
                log.info(roles.get(begin) + "  --->is present in Role mapping drop down");
            } else {
                log.info(roles.get(begin) + "  --->is not present in Role mapping drop down");
                Assert.fail();
            }
        }
    }

    public boolean check_update_for_product_group() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        int Number_of_Submit_buttons = Number_of_UPDATE_buttons_Product_groups_listing_screen.size();
        int Number_of_Product_groups = Number_of_Product_groups_present_on_listing_screen.size();
        boolean b = Number_of_Product_groups == Number_of_Submit_buttons;
        return b;
    }

    public void select_assert_class() {
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Random random = new Random();
        int randNumber = Math.abs(random.nextInt(10));
        withAction().moveToElement(SelectAssetClass).click().build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        for (int i = 1; i < randNumber+1; i++) {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        withAction().sendKeys(Keys.RETURN).build().perform();

    }

    @FindBy(xpath = "//*[@placeholder='Select Product Family']")
    private WebElementFacade SelectProductFamily;

    public void Select_product_family() {
        withAction().pause(Duration.ofSeconds(8)).build().perform();

        Random random = new Random();
        int randNumber = Math.abs(random.nextInt(10));
        withAction().moveToElement(SelectProductFamily).click().build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        for (int i = 1; i < randNumber+1; i++) {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        withAction().sendKeys(Keys.RETURN).build().perform();

    }

    @FindBy(xpath = "//*[@placeholder='Select Product']")
    private WebElementFacade SelectProduct;

    public void Select_product() {
        Random random = new Random();
        int randNumber = Math.abs(random.nextInt(10));
        withAction().moveToElement(SelectProduct).click().build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        for (int i = 1; i < randNumber+1; i++) {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        withAction().sendKeys(Keys.RETURN).build().perform();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void Remove_all_product_lines() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        String deleteIconXPath = "//img[@alt='delete-line']";
        List<WebElement> deleteButtons = getDriver().findElements(By.xpath(deleteIconXPath));
        while (deleteButtons.size() > 0) {
            WebElement deleteBtn = deleteButtons.get(0);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deleteBtn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            try {
                deleteBtn.click();
            } catch (Exception e) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", deleteBtn);
            }
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            deleteButtons = getDriver().findElements(By.xpath(deleteIconXPath));
        }
    }

    public void Select_product_grp_belong_to_parent_org_and_click_update_btn() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
//        Assert.assertEquals(User_organisation.getText().trim(), organizationname_box.getValue().trim());
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= Product_groups_org_names_listing_screen.size(); i++) {
            if (Product_groups_org_names_listing_screen.get(i).getText().contains(parent_org_name)) {
                Number_of_UPDATE_buttons_Product_groups_listing_screen.get(i).click();
            }
        }
    }

    public void Select_product_grp_not_belong_to_parent_org_and_click_update_btn() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        if (!User_organisation.isVisible()) {
            withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
            String parent_org_name = User_organisation.getText().trim();

            for (int i = 0; i <= Product_groups_org_names_listing_screen.size(); i++) {
                if (!Product_groups_org_names_listing_screen.get(i).getText().contains(parent_org_name)) {
                    Number_of_UPDATE_buttons_Product_groups_listing_screen.get(i).click();
                }
            }

        }
    }

    public void Records_per_page_make_it_max() {
        Select pages = new Select(getDriver().findElement(By.tagName("select")));
        pages.selectByValue("100");

    }

    public void check_user_can_see_product_groups_of_other_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= Product_groups_org_names_listing_screen.size() - 1; i++) {
            try {
                if (!Product_groups_org_names_listing_screen.get(i).getText().contains(parent_org_name)) {
                    String othet_then_parent_org_name = Product_groups_org_names_listing_screen.get(i).getText();
                    log.info("found another org Product groups--->" + othet_then_parent_org_name);
                }
            } catch (Exception e) {
                log.info("not found another org Product groups--->" + e);
                Assert.fail();
            }
        }
    }

    public void select_Org() {
        withAction().pause(Duration.ofSeconds(8)).build().perform();

        Random random = new Random();
        int randNumber = Math.abs(random.nextInt(10));
        withAction().moveToElement(select_organisation).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).build().perform();
        select_organisation.clear();
        for (int i = 1; i < randNumber; i++) {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        withAction().sendKeys(Keys.RETURN).build().perform();

    }

    public void select_product_group_name(List<String> product_groups_name) {

        String randNumber = RandomString.make(5);
        withAction().moveToElement(product_group_name_input).click().sendKeys(product_groups_name.get(1) + randNumber).build().perform();

    }

    public boolean check_update_for_currency_group() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        int Number_of_Submit_buttons = Number_of_UPDATE_buttons_Product_groups_listing_screen.size();
        int Number_of_Product_groups = Number_of_Product_groups_present_on_listing_screen.size();
        boolean b = Number_of_Product_groups == Number_of_Submit_buttons;
        return b;
    }

    public void Select_currency_grp_belong_to_parent_org_and_click_update_btn()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= Product_groups_org_names_listing_screen.size(); i++) {
            if (Product_groups_org_names_listing_screen.get(i).getText().contains(parent_org_name)) {
                Number_of_UPDATE_buttons_Product_groups_listing_screen.get(i).click();
            }
        }
    }
    @FindBy(xpath = "//div[@class='currency-map-card']//div/span")
    private List<WebElementFacade> Selected_currency;
    @FindBy(xpath = "//div[@class='currency-card']//div/span")
    private List<WebElementFacade> To_select_currency;
    @FindBy(xpath = "//div[@class='currency-map-card']")
    private WebElementFacade Selected_currency_tab;
    @FindBy(xpath = "//div[@class='currency-card']")
    private WebElementFacade To_select_currency_tab;

    public void remove_currency()
    {

       if (Selected_currency_tab.isVisible())
         {
             if (Selected_currency.size()>1)
             {
                 Selected_currency.get(1).click();
             }
             else if(Selected_currency.size()<2)
             {
                 Random random = new Random();
                 int randNumber = Math.abs(random.nextInt(10));
                 for (int i = 0; i<=randNumber; i++)
                 {
                     if (To_select_currency_tab.isVisible())
                     {
                         if (To_select_currency.get(1).isVisible())
                         {
                             To_select_currency.get(i).click();
                         }
                     }
                 }
             }
             else
             {
                 log.info("currency is not selected in currency group to remove");
                 Assert.fail();
             }
         }
    }
    public void check_user_can_see_currency_groups_of_other_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= Groups_org_names_listing_screen.size() - 1; i++)
        {
            try
            {
                if (!Groups_org_names_listing_screen.get(i).getText().contains(parent_org_name))
                {
                    String othet_then_parent_org_name = Groups_org_names_listing_screen.get(i).getText();
                    log.info("found another org currency groups--->" + othet_then_parent_org_name);
                }
            }
            catch (Exception e)
              {
                log.info("not found another org currency groups--->" + e);
                Assert.fail();
              }
        }
    }
    public void select_currency_group_name(List<String> currencies_group_name) {

        String randNumber = RandomString.make(5);
        withAction().moveToElement(currencies_group_name_input).click().sendKeys(currencies_group_name.get(1) + randNumber).build().perform();

    }
    public void Add_currency(){
        Random random = new Random();
        int randNumber = Math.abs(random.nextInt(10));
        for (int i = 0; i<=randNumber; i++)
        {
            if (To_select_currency_tab.isVisible())
            {
                if (To_select_currency.get(1).isVisible())
                {
                    To_select_currency.get(i).click();
                }
            }
        }
    }
    public void verify_update_btn_for_own_org_user()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= user_org_names_listing_screen.size()-1; i++)
        {
            if (user_org_names_listing_screen.get(i).getText().contains(parent_org_name))
            {
                Assert.assertTrue(Action_btn_listing_screen.get(i).getText().contains("View"));
            }
            else if (!user_org_names_listing_screen.get(i).getText().contains(parent_org_name))
            {
                Assert.assertTrue(Action_btn_listing_screen.get(i).getText().contains("Update"));
            }
        }
    }
    public void check_user_can_see_other_org_users()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= user_org_names_listing_screen.size() - 1; i++)
        {
         try {
             if (!user_org_names_listing_screen.get(i).getText().contains(parent_org_name)) {
                 String other_then_parent_org_name = Groups_org_names_listing_screen.get(i).getText();
                 log.info("found another org user--->" + other_then_parent_org_name);
             }
         }catch (Exception e)
         {
             log.info("Not found another org user ");
         }

        }
    }
    public boolean verify_update_btn_for_organisations_management_if_user_have_EDIT_OWN_permition()
    {    withAction().pause(Duration.ofSeconds(3)).build().perform();
        int update_btn = Organisations_update_btn.size();
        int Organisations_name_list = Organisations_names.size();
        boolean b = Organisations_name_list == update_btn;
        return b;
    }
    public void check_user_can_see_other_orgs_on_user_management_screen()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= org_names_user_Management_listing_screen.size() - 1; i++)
        {
            try {
                if (!org_names_user_Management_listing_screen.get(i).getText().contains(parent_org_name)) {
                    String other_then_parent_org_name = org_names_user_Management_listing_screen.get(i).getText();
                    log.info("found another org user--->" + other_then_parent_org_name);
                }
            }catch (Exception e)
            {
                log.info("Not found another org user ");
            }

        }
    }
    public void verify_update_btn_for_own_org_user_if_user_have_admin_role()
    {   withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String user_name = User_name.getText().trim().toLowerCase();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        for (int i = 0; i <= user_org_names_listing_screen.size()-1; i++)
        {
            if (!list_of_user_name_on_user_management_listing_screen.get(i).getText().trim().toLowerCase().contains(user_name))
            {
                Assert.assertTrue(Action_btn_listing_screen.get(i).getText().contains("Update"));
            }
        }
    }
    public void check_user_can_see_other_orgs_on_organisations_management_screen()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= org_names_organisations_Management_listing_screen.size() - 1; i++)
        {
            try {
                if (!org_names_organisations_Management_listing_screen.get(i).getText().contains(parent_org_name)) {
                    String other_then_parent_org_name = org_names_organisations_Management_listing_screen.get(i).getText();
                    log.info("found another org user--->" + other_then_parent_org_name);
                }
            }catch (Exception e)
            {
                log.info("Not found another org user ");
            }

        }
    }
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;
    @FindBy(xpath = "//div[@class='search-add-container col-search']//input")
    private WebElementFacade columns_selection_search_box;
    @FindBy(xpath = " //input[@type='checkbox']")
    private WebElementFacade columns_selection_searched_filter_checkbox;
    @FindBy(xpath = "//tr/th[text()='Document Status']//input")
    private WebElementFacade filter_document_status;
    @FindBy(xpath = "//th[text()='PB-1 LEI ID']//div/input")
    private WebElementFacade filter1;
    @FindBy(xpath = "//li[@class='MuiAutocomplete-option Mui-focused']")
    private WebElementFacade Resultant_lei;
    @FindBy(xpath = "//th[text()='Client-1 LEI ID']//div/input")
    private WebElementFacade filter2;

    public void check_doc_for_assigned_lei_if_doc_type_DN(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile_details_tab).click().pause(Duration.ofSeconds(4)).build().perform();

        Set<String> assigned_LEI = new HashSet<>();

        for (WebElementFacade element : list_of_LEI_assigned_to_user)
        {
            assigned_LEI.add(element.getText());

        }
        Validation_of_Document_Listing_screen_for_Doc.clickMenuButton();
        Validation_of_Document_Listing_screen_for_Doc.clickDocumentTab();

        Validation_of_Document_Listing_screen_for_Doc.Click_On_columns_selection_button();
        String[] filters= {"PB-1 LEI ID", "Client-1 LEI ID", "EB-1 LEI ID"};
        for (String f : filters)
        {
            withAction().moveToElement(columns_selection_search_box).click().sendKeys(f).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (!columns_selection_searched_filter_checkbox.isSelected()) {
                columns_selection_searched_filter_checkbox.click();
            }
            columns_selection_search_box.clear();
        }
        Validation_of_Document_Listing_screen_for_Doc.getApply_button().click();
        Validation_of_Document_Listing_screen_for_Doc.select_doc_type(table);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        withAction().moveToElement(filter_document_status).click().sendKeys(dataTable.get("Document_Status")).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        boolean stopExecution = false;

        for (String f : filters) {
            if (stopExecution) {
                break;
            }

            for (String lei : assigned_LEI) {
                WebElement filterA = getDriver().findElement(By.xpath("//th[text()='" + f + "']//div/input"));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterA);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                jsExecutor.executeScript("window.scrollBy(0, 500);");
                jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");
                withAction().moveToElement(filterA).click().pause(Duration.ofSeconds(2)).sendKeys(lei).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
                log.info(f + ">-------------->" + lei + "---" + filterA.getText());
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                if (document_on_listing_screen.isVisible()) {

                    log.info("We got data------>"+document_on_listing_screen.getText());
                    stopExecution = true; // Set flag to stop execution
                    break;
                }
                log.info("by clear method");
                filterA.clear();
            }
            // Clear filter

           if(Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
           {
               log.info("clearing filter-->"+f);
               getDriver().findElement(By.xpath("//th[text()='" + f + "']//div//button[@title='Clear']")).click();
           }
        }
    }


    public void check_doc_for_assigned_lei_if_doc_type_4W(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile_details_tab).click().pause(Duration.ofSeconds(4)).build().perform();

        Set<String> assigned_LEI = new HashSet<>();

        for (WebElementFacade element : list_of_LEI_assigned_to_user)
        {
            assigned_LEI.add(element.getText());

        }
        Validation_of_Document_Listing_screen_for_Doc.clickMenuButton();
        Validation_of_Document_Listing_screen_for_Doc.clickDocumentTab();

        Validation_of_Document_Listing_screen_for_Doc.Click_On_columns_selection_button();
        String[] filters= {"PB-1 LEI ID", "Client-1 LEI ID", "PB-2 LEI ID","Client-2 LEI ID"};
        for (String f : filters)
        {
            withAction().moveToElement(columns_selection_search_box).click().sendKeys(f).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (!columns_selection_searched_filter_checkbox.isSelected()) {
                columns_selection_searched_filter_checkbox.click();
            }
            columns_selection_search_box.clear();
        }
        Validation_of_Document_Listing_screen_for_Doc.getApply_button().click();
        Validation_of_Document_Listing_screen_for_Doc.select_doc_type(table);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        withAction().moveToElement(filter_document_status).click().sendKeys(dataTable.get("Document_Status")).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        boolean stopExecution = false;

        for (String f : filters) {
            if (stopExecution) {
                break;
            }

            for (String lei : assigned_LEI) {
                WebElement filterA = getDriver().findElement(By.xpath("//th[text()='" + f + "']//div/input"));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterA);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                jsExecutor.executeScript("window.scrollBy(0, 500);");
                jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");
                withAction().moveToElement(filterA).click().pause(Duration.ofSeconds(2)).sendKeys(lei).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
                log.info(f + ">-------------->" + lei + "---" + filterA.getText());
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                if (document_on_listing_screen.isVisible()) {

                    log.info("We got data------>"+document_on_listing_screen.getText());
                    stopExecution = true; // Set flag to stop execution
                    break;
                }
                log.info("by clear method");
                filterA.clear();
            }
            // Clear filter

            if(Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("clear method using dynamic x-path");
                getDriver().findElement(By.xpath("//th[text()='" + f + "']//div//button[@title='Clear']")).click();
            }
        }
    }


    public void checking_download_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (Document_download_btn.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
           if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
           {
               log.info("No record found");
               Assert.fail();
           }
        }
    }
    public void checking_REJECT_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (Document_REJECT_btn.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
            if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("No record found");
                Assert.fail();
            }
        }
    }
    public void checking_Approve_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (Document_Approve_btn.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
            if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("No record found");
                Assert.fail();
            }
        }
    }
    public void checking_Terminate_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (Document_Terminate_btn.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
            if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("No record found");
                Assert.fail();
            }
        }
    }
    public void checking_Cancel_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (Document_Cancel_btn.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
            if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("No record found");
                Assert.fail();
            }
        }
    }
    public void checking_Delete_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (Document_Delete_btn.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
            if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("No record found");
                Assert.fail();
            }
        }
    }

    public void checking_Edit_btn_for_Assigned_lei()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if(document_on_listing_screen.isVisible())
        {
            log.info("We got data------>"+document_on_listing_screen.getText());
            if (edit_btn_on_listing_screen.isVisible()){
                log.info("download_btn is present for document TC pass");
            }
            else {
                log.info("download_btn is not present for document TC fail");
                Assert.fail();
            }
        }
        else {
            if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
            {
                log.info("No record found");
                Assert.fail();
            }
        }
    }

    @FindBy(xpath = "//*[@placeholder='Select Doc type']")
    private WebElementFacade selectDocType;
    public void select_doc_types(List<String> filters)
    {
        withAction().moveToElement(Select_Doc_type_input).click().sendKeys(filters.get(1),Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }

    public void select_Acting_As(List<String> filters)
    {
        withAction().moveToElement(Select_acting_As_input).click().sendKeys(filters.get(1)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }

    public void verifyDocTypesListOnCreateDocPage(List<String> filters)
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Document_Type_Input_on_create_doc_page.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin = 1; begin < filters.size(); begin++) {
            Document_Type_Input_on_create_doc_page.type(filters.get(begin));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals(filters.get(begin),SearchedDocType.getText());
        }
        Document_Type_Input_on_create_doc_page.clear();
    }


    public void check_user_can_see_Approval_Groups_of_other_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= Groups_org_names_listing_screen.size() - 1; i++)
        {
            try
            {
                if (!Groups_org_names_listing_screen.get(i).getText().contains(parent_org_name))
                {
                    String other_then_parent_org_name = Groups_org_names_listing_screen.get(i).getText();
                    log.info("found another org currency groups--->" + other_then_parent_org_name);
                }
            }
            catch (Exception e)
            {
                log.info("not found another org currency groups--->" + e);
                Assert.fail();
            }
        }
    }
    @FindBy(xpath = "//div[@class='detail-entities ']")
    private WebElementFacade Assign;
    @FindBy(xpath = "//input[@placeholder='Select LEIs']")
    private WebElementFacade LEI_input;
    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade Org_Type_input;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doc_Type_input;
    DMS_1548_Step DMS_1548_step;
    public void check_user_can_see_Groups_of_only_assign_lei() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile_details_tab).click().pause(Duration.ofSeconds(4)).build().perform();
        log.info(Assign.getText());

        String[] lines = Assign.getText().split("\\n");

        String doc_type = lines[0];
        String LEI_ID = lines[1];
        String LEI_name = lines[2];
        String Org_type= lines[3];

        // Printing each line to verify
        System.out.println("Line 1: " + doc_type);
        System.out.println("Line 2: " + LEI_ID);
        System.out.println("Line 3: " + LEI_name);
        System.out.println("Line 4: " + Org_type);

        navigation_btn.click();

        if (!Approval_group_tab.isEnabled()){
            groupAndTemplate_tab.click();
        }
        Approval_group_tab.click();

        withAction().moveToElement(doc_Type_input).click().sendKeys(doc_type).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().moveToElement(Org_Type_input).click().sendKeys(Org_type).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().moveToElement(LEI_input).click().sendKeys(LEI_ID).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();


    }
    public void check_user_can_see_Matrix_of_only_assign_lei() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile_details_tab).click().pause(Duration.ofSeconds(4)).build().perform();
        log.info(Assign.getText());

        String[] lines = Assign.getText().split("\\n");

        String doc_type = lines[0];
        String LEI_ID = lines[1];
        String LEI_name = lines[2];
        String Org_type= lines[3];

        // Printing each line to verify
        System.out.println("Line 1: " + doc_type);
        System.out.println("Line 2: " + LEI_ID);
        System.out.println("Line 3: " + LEI_name);
        System.out.println("Line 4: " + Org_type);

        navigation_btn.click();

        if (!Approval_matrix_tab.isEnabled()){
            groupAndTemplate_tab.click();
        }
        Approval_matrix_tab.click();

        withAction().moveToElement(doc_Type_input).click().sendKeys(doc_type).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().moveToElement(Org_Type_input).click().sendKeys(Org_type).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().moveToElement(LEI_input).click().sendKeys(LEI_ID).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();


    }

    public void check_user_can_see_Approval_Matrix_of_other_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= org_names_on_Approval_Matrix_listing_screen.size() - 1; i++)
        {
            try
            {
                if (!org_names_on_Approval_Matrix_listing_screen.get(i).getText().contains(parent_org_name))
                {
                    String other_then_parent_org_name = org_names_on_Approval_Matrix_listing_screen.get(i).getText();
                    log.info("found another org Approval Matrix--->" + other_then_parent_org_name);
                }
            }
            catch (Exception e)
            {
                log.info("not found another org Approval Matrix--->" + e);
                Assert.fail();
            }
        }
    }

    public void check_user_can_see_Approval_Matrix_of_only_self_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= org_names_on_Approval_Matrix_listing_screen.size() - 1; i++)
        {
            if (!org_names_on_Approval_Matrix_listing_screen.get(i).getText().contains(parent_org_name))
            {
                log.info("found another org Approval Matrix--->"+org_names_on_Approval_Matrix_listing_screen.get(i).getText());
                Assert.fail();
            }
            else
            {
                log.info("Found self org Approval Matrix--->" + org_names_on_Approval_Matrix_listing_screen.get(i).getText());
            }
        }
    }
    @FindBy(xpath = "//tbody/tr/td[1]")
    private WebElementFacade Approval_Groups_name;
    public void check_user_can_see_Approval_Groups_of_only_assign_lei()
    {
        if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
          log.info("Records not found --");
          Assert.fail();
        }
        else {
              log.info("We got Approval_Groups ---->"+ Approval_Groups_name.getText() +"<---TC pass");
        }
    }
    public void check_user_can_see_Approval_Matrix_of_only_assign_lei()
    {
        if (Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            log.info("Records not found --");
            Assert.fail();
        }
        else {
            log.info("We got Approval Matrix for assign lei ------- >TC pass");
        }
    }
    public void check_user_can_see_Document_Template_of_only_self_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();

        for (int i = 0; i <= org_names_on_Document_Template_listing_screen.size() - 1; i++)
        {
            if (!org_names_on_Document_Template_listing_screen.get(i).getText().contains(parent_org_name))
            {
                log.info("found another org Document Template--->"+org_names_on_Document_Template_listing_screen.get(i).getText());
                Assert.fail();
            }
            else
            {
                log.info("Found self org Document Template--->" + org_names_on_Document_Template_listing_screen.get(i).getText());
            }
        }
    }

    public void check_user_can_see_Document_Template_of_other_orgs() {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim();
try {
    for (int i = 0; i <= org_names_on_Document_Template_listing_screen.size() - 1; i++)
    {
        if (org_names_on_Document_Template_listing_screen.get(i).getText().contains(parent_org_name))
        {
            log.info("found another org Document Template--->"+org_names_on_Document_Template_listing_screen.get(i).getText());
        }
    }
}
catch (Exception e){
    log.info("Other org Document Template is not visible");
    Assert.fail();
}

    }


}
