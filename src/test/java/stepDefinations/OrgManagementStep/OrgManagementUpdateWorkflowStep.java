package stepDefinations.OrgManagementStep;

import PageObjects.OrgManagement.OrgManagementPageObject;
import PageObjects.OrgManagement.OrgManagementUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class OrgManagementUpdateWorkflowStep extends PageObject {
    OrgManagementUpdatePageObject orgManagementUpdatePageObject;
    OrgManagementPageObject orgManagementPageObject;

    @Given("User will reach the Organization section")
    public void user_will_reach_the_organization_section() {
        orgManagementPageObject.navigateToOrganizationScreen();
    }

    @Then("Validate side window elements on organisation update screen")
    public void validateSideWindowElementsOnOrganisationUpdateScreen() {
        orgManagementPageObject.getSide_window().isVisible();
        Assert.assertTrue(orgManagementPageObject.getSide_window_DocType().isVisible());
        Assert.assertTrue(orgManagementPageObject.getSide_window_OrgType().isVisible());
        Assert.assertTrue(orgManagementPageObject.getSide_window_BodyType().isVisible());
    }

    @When("User will click on the Update button")
    public void user_will_click_on_the_update_button() {
        orgManagementPageObject.clickupdate_btn();
    }

    @Then("User will reach on the Update screen")
    public void user_will_reach_on_the_update_screen() {
        orgManagementUpdatePageObject.checkifonupdatescreen();
    }

    @Given("User is on the update screen")
    public void user_is_on_the_update_screen() {
        orgManagementPageObject.clickupdate_btn();
    }

    @Then("User searches for organization {string} and verifies CL status is enabled")
    public void verifyCLStatusForOrg(String orgName) {
        orgManagementUpdatePageObject.searchAndVerifyEnabledStatus(orgName);
    }

    @Then("User should be able to see all the details of the Organization")
    public void user_should_be_able_to_see_all_the_details_of_the_organization() {
        orgManagementUpdatePageObject.checkifuserinfocol();
    }
    @Then("Select data for Doc type filter and Corresponding result should be visible in the doc type filter")
    public void selectDataFromDocTypeFilterOnOrganisationUpdateScreenCorrespondingResultShouldBeVisibleInTheDocTypeFilter(List<String>list) {
        orgManagementUpdatePageObject.select_doctype_and_checkresult_indoctype_filter(list);
    }

    @And("User should be able to see predictive search bar")
    public void user_should_be_able_to_see_predictive_search_bar() {
        orgManagementUpdatePageObject.checkifsearchbar();
    }

    @And("User should be able to see LEI org type status table")
    public void user_should_be_able_to_see_lei_org_type_status_table() {
        orgManagementUpdatePageObject.checkifLEIorgtypestatustable();
    }
    @When("Set Doc type filter on Organisation update screen")
    public void set_doc_type_filter_on_organisation_update_screen(List<String> list) {
        orgManagementUpdatePageObject.getDoctype_filter().waitUntilVisible();
        orgManagementUpdatePageObject.select_doctype_and_checkresult_indoctype_filter(list);
    }

    @And("User should be able to see cancel button")
    public void user_should_be_able_to_see_cancel_button() {
        orgManagementUpdatePageObject.checkifcancelbtn();
    }

    @And("User should be able to see submit button")
    public void user_should_be_able_to_see_submit_button() {
        orgManagementUpdatePageObject.checkifsubmitbtn();
    }

    @Given("User is on the organization update screen")
    public void user_is_on_the_organization_update_screen(List<String> lei) {
        orgManagementPageObject.navigateToOrganizationScreen();
        orgManagementPageObject.typeInPredictiveSearchBar(lei);
        orgManagementPageObject.clickupdate_btn();
    }

    @When("User searches for the LEI in the search bar")
    public void user_searches_for_the_lei_in_the_search_bar(List<String> lei) {
        orgManagementUpdatePageObject.searchleiOnUpdatescreen(lei);
    }

    @Then("User is able to change the status of PB org type")
    public void user_is_able_to_change_the_status_of_pb_org_type() {
        orgManagementUpdatePageObject.changePBtoggle();
    }

    @Then("User is able to change the status of EB org type")
    public void user_is_able_to_change_the_status_of_eb_org_type() {
        orgManagementUpdatePageObject.changeEBtoggle();
    }

    @Then("User is able to change the status of Client org type")
    public void user_is_able_to_change_the_status_of_client_org_type() {
        orgManagementUpdatePageObject.changeClienttoggle();
    }

    @Then("User is able to change the status of org type")
    public void user_is_able_to_change_the_status_of_org_type(List<String> orgtype) {
        orgManagementUpdatePageObject.changetogglestatus(orgtype);
    }

    @Then("^User is able to change the status of org type from online to lite$")
    public void user_is_able_to_change_the_status_of_org_type_from_online_to_lite(DataTable table) {
        orgManagementUpdatePageObject.changetoggle_onlinetolite(table);
    }

    @Then("^User is able to change the status of org type from lite to online$")
    public void user_is_able_to_change_the_status_of_org_type_from_lite_to_online(DataTable table) {
        orgManagementUpdatePageObject.changetoggle_litetoonline(table);
    }

    @And("Save the changes by clicking on submit")
    public void save_the_changes_by_clicking_on_submit() {
        orgManagementUpdatePageObject.clicksubmit_btn();
    }


    @Given("Below the Organisation information section, Doc type Filter should be visible")
    public void below_the_organisation_information_section_doc_type_filter_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("corresponding results are visible when User will select doc type filter on organisation management Update screen")
    public void corresponding_results_are_visible_when_user_will_select_doc_type_filter_on_organisation_management_update_screen(DataTable dataTable) {

    }


    @Given("In the LEI Org type status table, for the LEI Org type status mapping as Online\\/Lite, There will be states Lite, Neutral and Online.")
    public void in_the_lei_org_type_status_table_for_the_lei_org_type_status_mapping_as_online_lite_there_will_be_states_lite_neutral_and_online() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("A confirmation pop-up will appear")
    public void a_confirmation_pop_up_will_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("induvial clicks will be disabled for the Org type for all the LEIs")
    public void induvial_clicks_will_be_disabled_for_the_org_type_for_all_the_le_is() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("In the LEI Org type status table, for the LEI Org type status mapping as Online\\/Lite, There will be {int} states Lite, Neutral and Online.")
    public void in_the_lei_org_type_status_table_for_the_lei_org_type_status_mapping_as_online_lite_there_will_be_states_lite_neutral_and_online(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Click on the Online Tab in the LEI Org type status table")
    public void click_on_the_online_tab_in_the_lei_org_type_status_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("All the LEIs will be set as Online")
    public void all_the_le_is_will_be_set_as_online() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("LEI ID and Legal Entity name of the LEI opened should be visible")
    public void lei_id_and_legal_entity_name_of_the_lei_opened_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("A table with columns Doc type and Org type status corresponding to that Doc type should be visible")
    public void a_table_with_columns_doc_type_and_org_type_status_corresponding_to_that_doc_type_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("all the org type status is divided into states Lite, Online, Neutral functioning same as update screen should be visible")
    public void all_the_org_type_status_is_divided_into_states_lite_online_neutral_functioning_same_as_update_screen_should_be_visible(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Cancel Button should be visible")
    public void cancel_button_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("a cross at the very left top corner for closing the side window should be visible")
    public void a_cross_at_the_very_left_top_corner_for_closing_the_side_window_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("In the LEI Org type status table, Click on the LEI name")
    public void in_the_lei_org_type_status_table_click_on_the_lei_name(DataTable dataTable) {

    }

    @Then("A side window will open")
    public void a_side_window_will_open() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Click on the Lite Tab in the LEI Org type status table")
    public void click_on_the_lite_tab_in_the_lei_org_type_status_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("When clicked Yes, all the LEIs will be set as Lite")
    public void when_clicked_yes_all_the_le_is_will_be_set_as_lite() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("Set DN doc type in update organization")
    public void Set_DN_doc_type_in_update_organization() {
        orgManagementUpdatePageObject.Selectdoctype("DN");
    }
    @And("Set 4 Way doc type in update organization")
    public void Set_4Way_doc_type_in_update_organization() {
        orgManagementUpdatePageObject.Selectdoctype("4 Way");
    }

    @Given("Select yes on lite org warning")
    public void Select_yes_on_lite_org_warning() {
        orgManagementPageObject.getWarningYes().waitUntilClickable().click();
    }
    @Then("User validates that lei is online for org type PB")
    public void validate_lei_status(DataTable dataTable) {
        String leiName = dataTable.asMaps(String.class, String.class).get(0).get("lei name");
        orgManagementPageObject.validateLeiIsOnlineForPB(leiName);
    }

    @And("User validates the Org type is as same as used to create the approval group with the same lei")
    public void check_the_orgType_used_in_approval_group_creation() {
        String expectedOrgType = "PB";
        orgManagementPageObject.getPB_Header().shouldContainText(expectedOrgType);
    }
    @Then("User validates the neutral button is clickable")
    public void validates_neutral_button () {
        orgManagementPageObject.validateNeutralButton();
    }
    @Then("User makes the lei Online for PB")
    public void user_turns_Online (){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        orgManagementUpdatePageObject.getPB_Online().click();
    }
    @Then("User makes the lei Lite for PB")
    public void user_turns_Lite (){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        orgManagementUpdatePageObject.getPB_Lite().click();
//        withAction().pause(Duration.ofSeconds(1)).build().perform();
//        orgManagementUpdatePageObject.getConfirmation_popup_yes().click();

    }
}
