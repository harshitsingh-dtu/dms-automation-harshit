package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1523PageObject;
import lombok.Data;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import java.time.Duration;

@Slf4j
@Data
public class DMS_1523Step extends PageObject {

    DMS_1523PageObject dms1523PageObject;

    @Given("User is on approval matrix listing screen")
    public void User_is_on_approval_matrix_listing_screen(){
        dms1523PageObject.navigateToApprovalMatrixListingScreen();
    }
    @Then("User will be able to see create approval matrix button")
    public void User_will_be_able_to_see_create_approval_matrix_button(){
        Assert.assertTrue(dms1523PageObject.getCreate_btn().isVisible());
    }
    @And("User will be able to see search bar")
    public void User_will_be_able_to_see_search_bar(){
        Assert.assertTrue(dms1523PageObject.getSearchBar().isVisible());
    }

    @And("User will be able to see organization name, LEIs name, org type, doc type, created on, action")
    public void User_will_be_able_to_see_organization_name_leis_name_org_type_doc_type_created_on_action() {
        Assert.assertTrue(dms1523PageObject.getOrganizationName_col().isVisible());
        Assert.assertTrue(dms1523PageObject.getDocType_col().isVisible());
        Assert.assertTrue(dms1523PageObject.getLEIsName_col().isVisible());
        Assert.assertTrue(dms1523PageObject.getOrgType_col().isVisible());
        Assert.assertTrue(dms1523PageObject.getCreatedOn_col().isVisible());
        Assert.assertTrue(dms1523PageObject.getAction_col().isVisible());
        log.info("All columns are visible");
    }
    @And("User will be able to see select LEI, Org type and Doc type filter")
    public void User_will_be_able_to_see_select_LEI_Org_type_and_Doc_type_filter() {
        Assert.assertTrue(dms1523PageObject.getSelectLEI().isVisible());
        Assert.assertTrue(dms1523PageObject.getOrgType_filter().isVisible());
        Assert.assertTrue(dms1523PageObject.getDocType_filter().isVisible());
        log.info("LEI, Org type and Doc type filters are visible");
    }
    @And("User will be able to see Update button")
    public void User_will_be_able_to_see_Update_button() {
        Assert.assertTrue(dms1523PageObject.getUpdate_btn().isVisible());
        log.info("Update button is visible");
    }
    @When("User clicks on create approval matrix button")
    public void User_clicks_on_create_approval_matrix_button(){
        dms1523PageObject.getCreate_btn().waitUntilVisible();
        dms1523PageObject.getCreate_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1523PageObject.getCreateNewApprovalMatrix_txt().isVisible());
    }
    @Then("User should be able to see all information on the create new approval matrix screen")
    public void User_should_be_able_to_see_all_information_on_the_create_new_approval_matrix_screen(){
        Assert.assertTrue(dms1523PageObject.getOrganization_filter().isVisible());
        Assert.assertTrue(dms1523PageObject.getDocType_filter().isVisible());
        Assert.assertTrue(dms1523PageObject.getLEI_filter().isVisible());
        Assert.assertTrue(dms1523PageObject.getOrgType_filter().isVisible());
        Assert.assertTrue(dms1523PageObject.getCancel_btn().isVisible());
        Assert.assertTrue(dms1523PageObject.getNext_btn().isVisible());
        log.info("All information is visible on the create new approval group screen");
    }
    @Then("User will see and able to fill organization filter,LEI filter,org type filter in all the fields")
    public void User_will_see_and_able_to_fill_organization_filter_LEI_filter_org_type_filter_in_all_the_fields(DataTable table){
        dms1523PageObject.checkIfOrganizationFilter_and_type(table);
        dms1523PageObject.checkIfDocTypeFilter_and_type(table);
        dms1523PageObject.checkIfLEIsFilter_and_type(table);
    }
    @And("User will click on the Org type filter and able to see corresponding items for 4 Way Doc type")
    public void User_will_click_on_the_Org_type_filter_and_able_to_see_corresponding_items_for_4_Way_Doc_type(){
        Assert.assertTrue(dms1523PageObject.getOrgType_filter_txt().isVisible());
        dms1523PageObject.getOrgType_filter().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1523PageObject.getClient_text().isPresent());
        Assert.assertTrue(dms1523PageObject.getPB_text().isPresent());
        Assert.assertFalse(dms1523PageObject.getEB_text().isPresent());
        log.info("Client and PB are visible");
    }
    @And("User will click on the Org type filter and able to see corresponding items for DN Doc type")
    public void User_will_click_on_the_Org_type_filter_and_able_to_see_corresponding_items_for_DN_Doc_type() {
        Assert.assertTrue(dms1523PageObject.getOrgType_filter_txt().isVisible());
        dms1523PageObject.getOrgType_filter().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1523PageObject.getClient_text().isPresent());
        Assert.assertTrue(dms1523PageObject.getPB_text().isPresent());
        Assert.assertTrue(dms1523PageObject.getEB_text().isPresent());
        log.info("Client,PB and EB are visible");
    }
//@Then("User can see and able to fill organization filter LEI filter org type filter doc type filter in all the fields")
  // public void User_can_see_and_able_to_fill_organization_filter_LEI_filter_org_type_filter_doc_type_filter_in_all_the_fields(DataTable table){
    //    dms1523PageObject.checkIfOrganizationFilter_and_type(table);
      //  dms1523PageObject.checkIfDocTypeFilter_and_type(table);
        //dms1523PageObject.checkIfLEIsFilter_and_type(table);
        //dms1523PageObject.checkIfOrgTypeFilter_and_type(table);
    //}
    @And("User will click on next button on the create approval matrix screen")
    public void User_will_click_on_next_button_on_the_create_approval_matrix_screen(){
        Assert.assertTrue(dms1523PageObject.getNext_btn().isDisplayed());
        dms1523PageObject.getNext_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1523PageObject.getAll_Info().isDisplayed());
        Assert.assertTrue(dms1523PageObject.getDocumentAction_dropdown().isVisible());
        Assert.assertTrue(dms1523PageObject.getApprovalGroups_dropdown().isVisible());
        Assert.assertTrue(dms1523PageObject.getAdd_btn().isDisplayed());
        Assert.assertTrue(dms1523PageObject.getCancel_btn().isDisplayed());
        Assert.assertTrue(dms1523PageObject.getSubmit_btn().isDisplayed());
    }
    @Then("User will select document action and approval groups")
    public void User_will_select_document_action_and_approval_groups(DataTable table){
        dms1523PageObject.typeDocumentActionandapprovalgroup(table);
        Assert.assertTrue(dms1523PageObject.getAdd_btn().isEnabled());
        dms1523PageObject.getAdd_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User will click on submit")
    public void User_will_click_on_submit() {
        Assert.assertTrue(dms1523PageObject.getSubmit_btn().isEnabled());
        dms1523PageObject.getSubmit_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @And("User should get the notification that group mapping already exist")
    public void User_should_get_the_notification_that_group_mapping_already_exist() {
        Assert.assertTrue(dms1523PageObject.getAlert_popup().isVisible());
        Assert.assertEquals("Group mapping already exist", dms1523PageObject.getAlert_popup().getText().trim());
        log.info("Group mapping already exist popup is visible");
    }
    @When("User will search for the approval matrix")
    public void User_will_search_for_the_approval_matrix(DataTable table){
        dms1523PageObject.searchApprovalMatrix(table);
    }
    @And("User will select the LEI, Doc type and Org type filter on approval matrix listing screen")
    public void User_will_select_the_LEI_Doc_type_and_Org_type_filter_on_approval_matrix_listing_screen(DataTable table){
        dms1523PageObject.selectLEI(table);
        dms1523PageObject.checkIfOrgTypeFilter_and_type(table);
        dms1523PageObject.checkIfDocTypeFilter_and_type(table);
    }

    @Then("User will search for the Approval Group to be removed from Approval Matrix and remove it")
    public void User_will_search_for_the_Approval_Group_to_be_removed_from_Approval_Matrix_and_remove_it(DataTable table) {
        dms1523PageObject.remove_approval_group(table);
    }
    @And("User will click on next button")
    public void User_will_click_on_next_button() {
        Assert.assertTrue(dms1523PageObject.getNext_btn().isEnabled());
        dms1523PageObject.getNext_btn().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("User should get a notification that approval matrix already exists")
    public void User_should_get_a_notification_that_approval_matrix_already_exists() {
        Assert.assertTrue(dms1523PageObject.getAlert_popup().isVisible());
        Assert.assertEquals("Approval Matrix already exists.", dms1523PageObject.getAlert_popup().getText().trim());
        log.info("Approval Matrix already exists popup is visible");
    }
}
