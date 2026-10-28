package stepDefinations.PlatformServicesStep;

import PageObjects.PlatformServices.LegacyOrganisationsPageObject;
import PageObjects.PlatformServices.LegalEntitiesPageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LegacyOrganisationsStep extends PageObject {
    LegalEntitiesPageObject legalEntitiesPageObject;
    LegacyOrganisationsPageObject legacyOrganisationsPageObject;
    @Then("User is able to see all the columns on the legal organisations listing screen")
    public void user_is_able_to_see_all_the_columns_on_the_legal_organisations_listing_screen() {
        try {
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_NameoflegacyOrganisations().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_Organisationstype().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_Sourceapplication().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_ParentLEIID().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_Updatedtime().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_ParentOrgname().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getColumn_Action().isVisible());
        }catch (AssertionError e){
            log.error("Elements are missing"+e);
        }
    }
    @Then("User is able to see search using Legacy organisation name on the legal organisations listing screen")
    public void user_is_able_to_see_search_using_legacy_organisation_name_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legacyOrganisationsPageObject.getSearch_ByLegacyOrganisation().isVisible());
    }
    @Then("User types into search using Legacy organisation name on the legal organisations listing screen")
    public void user_types_into_search_using_legacy_organisation_name_on_the_legal_organisations_listing_screen(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(legacyOrganisationsPageObject.getSearch_ByLegacyOrganisation()).click().sendKeys(dataTable.get("search")).pause(Duration.ofSeconds(6)).build().perform();
        }catch (Exception e){
            log.error("Unable to search "+e);
            Assert.fail();
        }    }
    @Then("User can see filter using org types on the legal organisations listing screen")
    public void user_can_see_filter_using_org_types_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legacyOrganisationsPageObject.getFilter_orgType().isVisible());

    }
    @Then("User can see filter using source applications on the legal organisations listing screen")
    public void user_can_see_filter_using_source_applications_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legacyOrganisationsPageObject.getFilter_sourceApplications().isVisible());

    }
    @Then("User can see filter using parent orgs on the legal organisations listing screen")
    public void user_can_see_filter_using_parent_orgs_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legacyOrganisationsPageObject.getFilter_parentOrgs().isVisible());

    }
    @Then("User can see filter using date on the legal organisations listing screen")
    public void user_can_see_filter_using_date_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legacyOrganisationsPageObject.getFilter_startdate().isVisible());
        Assert.assertTrue(legacyOrganisationsPageObject.getFilter_enddate().isVisible());
    }
    @Then("User can see download button on the legal organisations listing screen")
    public void user_can_see_download_button_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getDownload_btn().isVisible());
    }
    @Then("User can see view details button on the legal organisations listing screen")
    public void user_can_see_view_details_button_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
    }
    @When("User types into orgs type filter on the legal organisations listing screen")
    public void user_types_into_orgs_type_filter_on_the_legal_organisations_listing_screen(DataTable dataTable) {
        legacyOrganisationsPageObject.type_filterOrgTypes(dataTable);
    }
    @When("User types into source application filter on the legal organisations listing screen")
    public void user_types_into_source_application_filter_on_the_legal_organisations_listing_screen(DataTable dataTable) {
        legacyOrganisationsPageObject.type_filterSourceApplication(dataTable);
    }
    @When("User types into parent orgs filter on the legal organisations listing screen")
    public void user_types_into_parent_orgs_filter_on_the_legal_organisations_listing_screen(DataTable dataTable) {
        legacyOrganisationsPageObject.type_filterParentOrgs(dataTable);
    }
    @Given("User is able to see view details button on the legal organisations listing screen")
    public void user_is_able_to_see_view_details_button_on_the_legal_organisations_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
    }

    @Given("User will click view details button on the legal organisations listing screen")
    public void user_will_click_view_details_button_on_the_legal_organisations_listing_screen() {
        legalEntitiesPageObject.getViewDetails_btn().waitUntilVisible().click();
    }
    @Then("User is able to see legacy organisation information on the legal organisations view details screen")
    public void user_is_able_to_see_legacy_organisation_information_on_the_legal_organisations_view_details_screen() {
        try {
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Legacy_organisation_name().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Legacy_user().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Org_Type().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Source_Application().isVisible());
        }catch (AssertionError e){
            log.error("Elements are missing"+e);
        }
    }
    @Then("User is able to see Parent org information on the legal organisations view details screen")
    public void user_is_able_to_see_parent_org_information_on_the_legal_organisations_view_details_screen() {
        try{
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Parent_LEI_ID().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Parent_org_name().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Active_users().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Total_users().isVisible());
        }catch (AssertionError e){
            log.error("Elements Missing"+e);
        }
    }
    @Then("User is able to see legacy users information on the legal organisations view details screen")
    public void user_is_able_to_see_legacy_users_information_on_the_legal_organisations_view_details_screen() {
        try {
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_UserFullName().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Username().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Email_Id().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Contact_Number().isVisible());
            Assert.assertTrue(legacyOrganisationsPageObject.getViewScreen_Platform_user().isVisible());
        }catch (AssertionError e){
            log.error("Elements Missing"+e);
        }
    }
    @And("User clicks on map parent button on the legal organisations listing screen")
    public void clickMapParentButton() {
        legacyOrganisationsPageObject.getMapParent_btn().waitUntilVisible().click();
    }
    @And("User types into Search Parent Org Legal Entity on the next screen")
    public void searchParentOrgLegalEntity(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(legacyOrganisationsPageObject.getSearch_ParentOrgLegalEntity()).click().sendKeys(dataTable.get("Search Parent Org / Legal Entity")).build().perform();
    }
    @And("User clicks on search button")
    public void clickSearchButton() {
        legacyOrganisationsPageObject.getSearch_btn().waitUntilVisible().click();

    }
    @And("User will click on select as parent button")
    public void clickSelectAsParentButton() {
        legacyOrganisationsPageObject.getSelectAsParent_btn().waitUntilVisible().click();

    }
    @Then("User will give confirmation for selecting parent")
    public void confirmParentSelection() {
        legacyOrganisationsPageObject.getConfirmDialog_Yes_btn().waitUntilVisible().click();
    }
    @And("User will select the Legacy users")
    public void selectLegacyUsers(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row :data){
            if (find(By.xpath("//div[@class='no-record-found']")).isVisible()){
                break;
            }else {
                withAction().moveToElement(find(By.xpath("//td[text()='"+row.get("users")+"']//ancestor::tr//input[@type='checkbox']"))).click().build().perform();

            }
        }
    }
    @And("User will click on submit button after viewing user details")
    public void clickSubmitButton() {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        legalEntitiesPageObject.getViewDetails_btn().waitUntilVisible();
        legacyOrganisationsPageObject.getSubmit_btn().click();
    }

}