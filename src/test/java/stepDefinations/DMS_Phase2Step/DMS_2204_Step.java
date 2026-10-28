package stepDefinations.DMS_Phase2Step;


import PageObjects.DMS_PHASE2PageObject.DMS_1548_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2204_PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.List;

public class DMS_2204_Step extends PageObject
{
    DMS_2204_PageObject DMS_2204;
    DMS_1548_PageObject DMS_1548;

    @And("Verify user can see USP rider template tab under Groups& Template tab")
    public void verifyUserCanSeeUSPRiderTemplateTabUnderGroupsTemplateTab()
    {
        Assert.assertTrue(DMS_1548.getNavigation_btn().isDisplayed());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getGroupAndTemplate_tab().isEnabled());
        DMS_1548.getGroupAndTemplate_tab().click();
        Assert.assertTrue(DMS_2204.getUSP_rider_Template_tab().isEnabled());

    }

    @Given("Click on USP rider template tab under Groups & Template tab")
    public void clickOnUSPRiderTemplateTabUnderGroupsTemplateTab() {
        if (!DMS_2204.getUSP_rider_Template_tab().isCurrentlyVisible()) {
            boolean isSidebarOpen = false;
            try {
                isSidebarOpen = Boolean.parseBoolean(String.valueOf(evaluateJavascript("return document.querySelector('.sidebar-wrapper')?.classList.contains('openSidebar') ?? false;")));
            } catch (Exception ignored) {}
            if (!isSidebarOpen) {
                try { DMS_1548.getNavigation_btn().waitUntilVisible().click(); } 
                catch (Exception e) { evaluateJavascript("arguments[0].click();", DMS_1548.getNavigation_btn()); }
            }
            if (!DMS_2204.getUSP_rider_Template_tab().isCurrentlyVisible()) {
                try { DMS_1548.getGroupAndTemplate_tab().waitUntilVisible().click(); } 
                catch (Exception e) { evaluateJavascript("arguments[0].click();", DMS_1548.getGroupAndTemplate_tab()); }
            }
        }
        try { DMS_2204.getUSP_rider_Template_tab().waitUntilVisible().waitUntilClickable().click(); } 
        catch (Exception e) { evaluateJavascript("arguments[0].click();", DMS_2204.getUSP_rider_Template_tab()); }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("Verify user is on USP Rider Template listing screen")
    public void verifyUserIsOnUSPRiderTemplateListingScreen()
    {
        Assert.assertTrue(DMS_2204.getUsp_title().isVisible());
    }

    @Then("Verify elements on USP rider template listing screen")
    public void verifyElementsOnUSPRiderTemplateListingScreen()
    {
        Assert.assertTrue(DMS_2204.getUsp_title().isVisible());
        Assert.assertTrue(DMS_2204.getUSP_sub_tittle().isVisible());
        Assert.assertTrue(DMS_2204.getSearch_box_by_USP_ID().isVisible());
        Assert.assertTrue(DMS_2204.getCreate_new_USP_template_button().isVisible());
        Assert.assertTrue(DMS_2204.getPB_dropdown().isVisible());
        Assert.assertTrue(DMS_2204.getClients_dropdown().isVisible());
        Assert.assertTrue(DMS_2204.getDoc_type_filter().isVisible());

        Assert.assertTrue(DMS_2204.getID_column().isVisible());
        Assert.assertTrue(DMS_2204.getPB_Name_column().isVisible());
        Assert.assertTrue(DMS_2204.getClient_Name_column().isVisible());
        Assert.assertTrue(DMS_2204.getDoc_type_column().isVisible());
        Assert.assertTrue(DMS_2204.getWord_clause_column().isVisible());
        Assert.assertTrue(DMS_2204.getLast_Updated_on_column().isVisible());
        Assert.assertTrue(DMS_2204.getAction_column().isVisible());
        Assert.assertTrue(DMS_2204.getRelated_documents_column().isVisible());
        Assert.assertTrue(DMS_2204.getPagination_column().isVisible());

    }

    @Given("User is on document screen")
    public void userIsOnDocumentScreen()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
       Assert.assertTrue(DMS_2204.getDoclist_content().isVisible());
    }

    @Then("Verify USP rider template ID format")
    public void verifyUSPRiderTemplateIDFormat()
    {
    DMS_2204.Check_UPS_ID_format();
    }

    @Then("Verify USP rider template Last Updated By format")
    public void verifyUSPRiderTemplateLastUpdatedByFormat()
    {
        DMS_2204.Check_USP_ID_Last_Updated_By_Format();
    }

    @Then("Verify USP rider template Last Updated on format")
    public void verifyUSPRiderTemplateLastUpdatedOnFormat()
    {
        DMS_2204.Check_UPS_ID_Last_Updated_On_Format();
    }

    @Then("Verify search functionality on USP rider template listing screen by ID")
    public void verifySearchFunctionalityOnUSPRiderTemplateListingScreenByID()
    {
       DMS_2204.verify_search_functionality_by_ID();

    }

    @Then("Verify default records on USP rider template listing screen")
    public void verifyDefaultRecordsOnUSPRiderTemplateListingScreen()
    {
        DMS_2204.verify_records_are_same_on_webpage_as_per_web_page();
    }

    @Then("Verify default list under PB dropdown")
    public void verifyDefaultListUnderPBDropdown()
    {
        DMS_2204.check_default_list_under_PB_dropdown();
    }

    @And("Verify search functionality of PB dropdown")
    public void verifySearchFunctionalityOfPBDropdown()
    {
        DMS_2204.verify_search_functionality_by_PB();
    }

    @And("Verify PB dropdown default list")
    public void verifyPBDropdownDefaultList()
    {
        DMS_2204.check_default_list_under_PB_dropdown();
    }

    @Then("Verify Client dropdown default list")
    public void verifyClientDropdownDefaultList()
    {
        DMS_2204.check_default_list_under_client_dropdown();
    }

    @And("Verify search functionality of Client dropdown")
    public void verifySearchFunctionalityOfClientDropdown()
    {
        DMS_2204.verify_search_functionality_by_Client();
    }

    @And("Verify doc type filters list on USP listing Screen")
    public void verifyDocTypeFiltersListOnUSPListingScreen(List<String> filters)
    {
        DMS_2204.verifyDocTypesList(filters);
    }

    @And("Verify search functionality of Doc type filter")
    public void verifySearchFunctionalityOfDocTypeFilter(List<String> filters)
    {
    DMS_2204.verify_search_functionality_by_Doc_Type_Filter(filters);
    }

    @And("Verify user can see Create new template for USP")
    public void verifyUserCanSeeCreateNewTemplateForUSP()
    {
        Assert.assertTrue(DMS_2204.getCreate_new_USP_template_button().isEnabled());
    }

    @And("Verify Create new template button for USP should not visible")
    public void verifyCreateNewTemplateButtonForUSPShouldNotVisible()
    {
        Assert.assertFalse(DMS_2204.getCreate_new_USP_template_button().isVisible());

    }

    @And("Verify Update button for USP template should not visible")
    public void verifyUpdateButtonForUSPTemplateShouldNotVisible()
    {
        Assert.assertFalse(DMS_2204.getAction_button().getText().toLowerCase().contains("update"));
    }

    @And("Verify user can see other org in PB column USP Rider template")
    public void verifyUserCanSeeOtherOrgInPBColumnUSPRiderTemplate()
    {
        DMS_2204.check_user_can_see_other_org_under_PB_column();
    }

    @And("Verify user can see only own org in PB column USP Rider template")
    public void verifyUserCanSeeOnlyOwnOrgInPBColumnUSPRiderTemplate()
    {
        DMS_2204.check_user_can_see_only_own_org_under_PB_column();
    }

    @And("Verify view button for all USP template should visible")
    public void verifyViewButtonForAllUSPTemplateShouldVisible()
    {
        DMS_2204.check_all_temp_have_View_button();
    }

    @Then("Verify USP rider template tab should not visible under Groups & Template tab")
    public void verifyUSPRiderTemplateTabShouldNotVisibleUnderGroupsTemplateTab()
    {
        Assert.assertTrue(DMS_1548.getNavigation_btn().isEnabled());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getGroupAndTemplate_tab().isEnabled());
        DMS_1548.getGroupAndTemplate_tab().click();
        Assert.assertFalse(DMS_2204.getUSP_rider_Template_tab().isVisible());
    }

    @And("Update button should be visible corresponding all the four Way USP Rider templates")
    public void updateButtonShouldBeVisibleCorrespondingAllTheFourWayUSPRiderTemplates()
    {
        DMS_2204.check_update_button_should_visible_only_for_4Way_temp();
    }

    @And("View button should be visible for all the DN doc type USP Rider templates")
    public void viewButtonShouldBeVisibleForAllTheDNDocTypeUSPRiderTemplates()
    {
        DMS_2204.check_view_button_should_visible_other_then_4Way_temp();
    }

    @And("Update button should be visible corresponding all the DN USP Rider templates")
    public void updateButtonShouldBeVisibleCorrespondingAllTheDNUSPRiderTemplates()
    {
        DMS_2204.check_update_button_should_visible_only_for_DN_USP_temp();
    }

    @And("View button should be visible for all the four Way doc type USP Rider templates")
    public void viewButtonShouldBeVisibleForAllTheFourWayDocTypeUSPRiderTemplates()
    {
        DMS_2204.check_view_button_should_visible_other_then_DN_USP_temp();
    }


    @And("Verify multi select functionality of PB dropdown")
    public void verifyMultiSelectFunctionalityOfPBDropdown()
    {
DMS_2204.verify_search_functionality_of_PB_dropdown_of_USP_listing_screen();
    }

    @And("Verify multi select functionality of Client dropdown")
    public void verifyMultiSelectFunctionalityOfClientDropdown()
    {
        DMS_2204.verify_search_functionality_of_Clients_dropdown_of_USP_listing_screen();

    }

    @And("select PB and client on USP listing screen")
    public void select_PB_and_client_on_USP_listing_screen(DataTable dataTable)
    {
        DMS_2204.SelectUSPPB(dataTable);
        DMS_2204.SelectUSPclient(dataTable);

    }


}
