package stepDefinations.PlatformServicesStep;

import PageObjects.PlatformServices.LegalEntitiesPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
public class LegalEntitiesStep extends PageObject {
    LegalEntitiesPageObject legalEntitiesPageObject;

    @Then("User redirects to the Legal Entity screen")
    public void user_redirects_to_the_legal_entity_screen() {
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(legalEntitiesPageObject.getLegalEntities_title().isVisible());
            legalEntitiesPageObject.getLegalEntities_title().isVisible();
        }catch (Exception e){
            log.error("Not redirected to Legal Entities listing screen");
            getDriver().close();
        }
    }
    @Then("User is able to see search functionality by LEI ID or Legal Entity name")
    public void user_is_able_to_see_search_functionality_by_lei_id_or_legal_entity_name() {
        Assert.assertTrue(legalEntitiesPageObject.getSearch_byLEIid().isVisible());
    }
    @Then("User is able to see Legal enity type filter on the legal entity listing screen")
    public void user_is_able_to_see_legal_enity_type_filter_on_the_legal_entity_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getFilter_legalEntityType().isVisible());
    }
    @Then("User is able to see parent org filter on the legal entity listing screen")
    public void user_is_able_to_see_parent_org_filter_on_the_legal_entity_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getFilter_parentOrgs().isVisible());
    }
    @Then("User is able to see the download button on the legal entity listing screen")
    public void user_is_able_to_see_the_download_button_on_the_legal_entity_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getDownload_btn().isVisible());
    }
    @Then("User is able to see the columns on the legal entity listing screen")
    public void user_is_able_to_see_the_columns_on_the_legal_entity_listing_screen() {
        try {
            Assert.assertTrue(legalEntitiesPageObject.getColumn_parentLEIID().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getColumn_legalEntityName().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getColumn_legalEntityType().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getColumn_Action().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getColumn_parentOrgName().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getColumn_LEIID().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements"+e);
        }
    }
    @Then("User is able to see view details button on the legal entity listing screen")
    public void user_is_able_to_see_view_details_button_on_the_legal_entity_listing_screen() {
        Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
    }
    @When("user types into the search functionality by LEI ID or Legal Entity name")
    public void user_types_into_the_search_functionality_by_lei_id_or_legal_entity_name(DataTable dataTable) {
        legalEntitiesPageObject.check_SearchByLEIid(dataTable);
    }

    @When("User types into legal entity filter")
    public void user_types_into_legal_entity_filter(DataTable table) {
        legalEntitiesPageObject.type_filterLegalEntityType(table);
    }
    @Then("User will get corresponding result to legal entity filter")
    public void user_will_get_corresponding_result_to_legal_entity_filter(DataTable table) {
        Assert.assertTrue(legalEntitiesPageObject.getLegalEntityTypeResult().isVisible());
        legalEntitiesPageObject.legal_entity_filter_result(table);
    }
    @When("User types into Parent org filter")
    public void user_types_into_parent_org_filter(DataTable table) {
        legalEntitiesPageObject.type_filterParentOrg(table);
    }
    @Then("User will get corresponding result to parent org filter")
    public void user_will_get_corresponding_result_to_parent_org_filter(DataTable table) {
        Assert.assertTrue(legalEntitiesPageObject.getParentOrgResult().isVisible());
        legalEntitiesPageObject.parent_org_filter_result(table);
    }
    @Then("User will click view details button on the legal entity listing screen")
    public void user_will_click_view_details_button_on_the_legal_entity_listing_screen() {
        legalEntitiesPageObject.getViewDetails_btn().waitUntilVisible().click();
    }
    @Then("User is able to see legal entity information")
    public void user_is_able_to_see_legal_entity_information() {
        try {
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_column_legalEntityName().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_column_address().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_column_LEIID().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements");
        }
    }
    @Then("User is able to see Parent org details on the view details screen for legal entities")
    public void user_is_able_to_see_parent_org_details_on_the_view_details_screen_for_legal_entities() {
        try {
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_parentorg_column_active_users().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_parentorg_column_action().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_parentorg_column_Parent_org_name().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_parentorg_column_parentLEIID().isVisible());
            Assert.assertTrue(legalEntitiesPageObject.getViewscreen_parentorg_column_total_users().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements");
        }
    }
    @Then("User is able to see back button on the view details screen for legal entities")
    public void user_is_able_to_see_back_button_on_the_view_details_screen_for_legal_entities() {
        Assert.assertTrue(legalEntitiesPageObject.getGoback_btn().isVisible());
    }

}