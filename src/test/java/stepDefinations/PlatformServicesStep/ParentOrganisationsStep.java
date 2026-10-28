package stepDefinations.PlatformServicesStep;

import PageObjects.PlatformServices.LegalEntitiesPageObject;
import PageObjects.PlatformServices.PlatformOrganisationsPageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WidgetObject;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ParentOrganisationsStep extends PageObject {
    LegalEntitiesPageObject legalEntitiesPageObject;
    PlatformOrganisationsPageObject platformOrganisationsPageObject;
    @Then("User is able to see search by organisation name or parent LEI ID on parent organisation screen")
    public void user_is_able_to_see_search_by_organisation_name_or_parent_lei_id_on_parent_organisation_screen() {
        Assert.assertTrue(platformOrganisationsPageObject.getSearch_ByOrganisationName().isVisible());
    }
    @Then("User is able to see last updated filter on parent organisation screen")
    public void user_is_able_to_see_last_updated_filter_on_parent_organisation_screen() {
        Assert.assertTrue(platformOrganisationsPageObject.getFilter_LastUpdatedBy().isVisible());
    }
    @Then("User is able to see date and time filter on parent organisation screen")
    public void user_is_able_to_see_date_and_time_filteron_parent_organisation_screen() {
        Assert.assertTrue(platformOrganisationsPageObject.getFilter_date().isVisible());
    }
    @Then("User is able to see status filter on parent organisation screen")
    public void user_is_able_to_see_status_filter_on_parent_organisation_screen() {
        Assert.assertTrue(platformOrganisationsPageObject.getFilter_status().isVisible());
    }
    @Then("User is able to see following columns on parent organisation screen")
    public void user_is_able_to_see_following_columns_on_parent_organisation_screen() {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(legalEntitiesPageObject.getColumn_parentLEIID().isVisible());
        Assert.assertTrue(legalEntitiesPageObject.getColumn_parentOrgName().isVisible());
        Assert.assertTrue(legalEntitiesPageObject.getColumn_LastUpdatedBy().isVisible());
        Assert.assertTrue(legalEntitiesPageObject.getColumn_LastUpdatedOn().isVisible());
        Assert.assertTrue(legalEntitiesPageObject.getColumn_Status().isVisible());
        Assert.assertTrue(legalEntitiesPageObject.getColumn_Action().isVisible());
    }
    @Then("User is able to see view details button on parent organisation screen")
    public void user_is_able_to_see_view_details_button_on_parent_organisation_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
    }

    @When("user types into the search functionality by organisation name or parent LEI ID")
    public void user_types_into_the_search_functionality_by_organisation_name_or_parent_lei_id(DataTable dataTable) {
        platformOrganisationsPageObject.search__ByOrganisationName(dataTable);
    }


    @When("User types into Last Updated filter")
    public void typeIntoLastUpdatedFilter(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(platformOrganisationsPageObject.getFilter_LastUpdatedBy()).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(6)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
    }

    @When("User types into status filter")
    public void typeIntoStatusFilter(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(platformOrganisationsPageObject.getFilter_status()).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(6)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
    }
    @Then("User will click view details button on parent organisation screen")
    public void clickViewDetailsButton() {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        legalEntitiesPageObject.getViewDetails_btn().click();
    }
    @Then("User is able to see legacy org details")
    public void verifylegacyorgDetails() {
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Legacyusers().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Sourceapplication().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Organisationstype().isVisible());
    }
    @Then("User is able to see Parent organisation details")
    public void verifyParentOrganisationDetails() {
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_parentLEIID().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_parentOrgName().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_ActiveUsers().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_TotalUsers().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Adress().isVisible());
    }

    @Then("User is able to see child LEIs details")
    public void verifyChildLEIDetails() {
        platformOrganisationsPageObject.getTab_childLEIs().click();
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_LegalentityAddress().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Legalentityname().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_LEIsID().isVisible());
    }

    @Then("User is able to see platform user details")
    public void verifyPlatformUserDetails() {
        platformOrganisationsPageObject.getTab_platformUsers().click();
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_PasswordStatus().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Status().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_ContactNumber().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Emailid().isVisible());
        Assert.assertTrue(platformOrganisationsPageObject.getViewDetailScreen_column_Usersfullname().isVisible());
    }

    @And("User will click on the +Create new Org button on parent organisation screen")
    public void click_on_the_Create_new_Org_button_on_parent_organisation_screen(){
        try{
            Assert.assertTrue(platformOrganisationsPageObject.getCreatenewOrgbutton().isVisible());
            platformOrganisationsPageObject.getCreatenewOrgbutton().waitUntilClickable().click();
        }catch (AssertionError  e){
            log.error("Create_new_Org_button is not clickable ");
            Assert.fail();
        }
    }
    @When("User search for organisation on Create new organisation screen")
    public void search_for_organisation_on_Create_new_organisation_screen(DataTable datatable){
        platformOrganisationsPageObject.Enterorganisationname_or_LEIID(datatable);
    }
    @Then("user will click on the Create new Button on Create new organisation screen")
    public void click_on_the_Creat_new_Button_on_Create_new_organisation_screen(){
        try {
            Assert.assertTrue(platformOrganisationsPageObject.getCreatenewbutton_for_createnewOrg().isVisible());
            platformOrganisationsPageObject.getCreatenewbutton_for_createnewOrg().waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(6)).build().perform();
        }catch (AssertionError e){
            log.error("unable to click Create new button on Create new Organisation page");
            Assert.fail();
        }
    }
    @And("User fill required fileds organisation name, Addressline, Country, City and Postcode on  Create new organisation screen")
    public void typedata_in_organisationname_Addressline_Country_City_and_Postcode_on_Create_new_organisation_screen(DataTable datatable){
        platformOrganisationsPageObject.Enterorganisationname(datatable);
        platformOrganisationsPageObject.EnterAddressLine(datatable);
        platformOrganisationsPageObject.Entercountry(datatable);
        platformOrganisationsPageObject.EnterCity(datatable);
        platformOrganisationsPageObject.EnterPostCode(datatable);

    }
    @And("User will click on submit button and validate Success popup on Create new organisation screen")
    public void click_on_submit_button_and_validate_Success_popup_on_Create_new_organisation_screen(){
        try{
            Assert.assertTrue(platformOrganisationsPageObject.getSubmitButton_for_CreatenewOrg().isVisible());
            platformOrganisationsPageObject.getSubmitButton_for_CreatenewOrg().waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(6)).build().perform();
            platformOrganisationsPageObject.getSuccessMessageforCreateneworg().waitUntilVisible();
            Assert.assertEquals(platformOrganisationsPageObject.getSuccessMessageforCreateneworg().getText(),"Parent org is created successfully.");

        }catch (AssertionError e){
            log.error("unable to create Parent Org ");
            Assert.fail();
        }
    }




}