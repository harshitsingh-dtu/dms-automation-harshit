package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1460PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import java.util.List;

@Slf4j
public class DMS_1460Step extends PageObject {

    DMS_1460PageObject DMS1460UserManagementDocTypeUIChangesPageObject;

    @Given("User is on the User Onboarding Screen")
    public void User_is_on_the_User_Onboarding_Screen()  {
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        DMS1460UserManagementDocTypeUIChangesPageObject.navigateToUserManagement();
    }
    @Then("User will be able see all the Filters")
    public void User_will_be_able_see_all_the_Filters()  {
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getFilter_organization().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getFilter_roles().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getFilter_status().isVisible());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        log.info("All the filters are visible");
    }
    @And("User will be able to see the Column Names")
    public void User_will_be_able_to_see_the_Column_Names()  {
        Assert.assertEquals("User's name", DMS1460UserManagementDocTypeUIChangesPageObject.getUsernameColumn().getText().trim());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("Email id", DMS1460UserManagementDocTypeUIChangesPageObject.getEmailIdColumn().getText().trim());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("Mobile no", DMS1460UserManagementDocTypeUIChangesPageObject.getMobileNoColumn().getText().trim());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("Name of organisations", DMS1460UserManagementDocTypeUIChangesPageObject.getOrganizationIdColumn().getText().trim());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("Status", DMS1460UserManagementDocTypeUIChangesPageObject.getStatusColumn().getText().trim());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals("Action", DMS1460UserManagementDocTypeUIChangesPageObject.getActionColumn().getText().trim());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        log.info("All the Columns are visible");
    }
    @And("User can search for the Existing User")
    public void User_can_search_for_the_Existing_User()  {
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSearch_added_Users().isVisible());
        log.info("Search for existing user is visible");
    }
    @And("User can search for New User")
    public void User_can_search_for_New_User()  {
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSearch_newUsers().isVisible());
        log.info("Search for new user is visible");
    }
    @And("User will be able to see Edit Button")
    public void User_will_be_able_to_see_Edit_Button()  {
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getEditDetails_btn().isVisible());
        log.info("Edit Button is visible");
    }
    @And("User will be able to see the Status Button")
    public void User_will_be_able_to_see_the_Status_Button(){
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getStatus_btn().isVisible());
        log.info("Status button is visible");
    }
    @And("User will be able to see the Pagination")
    public void User_will_be_able_to_see_the_Pagination(){
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getPagination_container().isVisible());
        log.info("Pagination is visible");
    }
    @When("User will search for Existing User")
    public void User_will_search_for_Existing_User(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.searchUser(table);
    }
    @Then("Corresponding information of user will be visible on the screen")
    public void Corresponding_information_of_user_will_be_visible_on_the_screen(){
        Assert.assertEquals("User information", DMS1460UserManagementDocTypeUIChangesPageObject.getUser_infoText().getText().trim());
        Assert.assertEquals("Role mapping", DMS1460UserManagementDocTypeUIChangesPageObject.getRoleMapping_text().getText().trim());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSelectRole().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getRoleList().isVisible());
        Assert.assertEquals("Added LEIs, Org type & Doc type", DMS1460UserManagementDocTypeUIChangesPageObject.getAddedLeiOrg_Text().getText().trim());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSearch_LEI().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getLeiORGType_List().isVisible());
        Assert.assertEquals("Select Doc type", DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_DocTypeText().getText().trim());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_DocType().isVisible());
        Assert.assertEquals("Select LEIs", DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_LEIText().getText().trim());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_LEI().isVisible());
        Assert.assertEquals("Select Org type", DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_OrgTypeText().getText().trim());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_OrgType().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getAddButton().isVisible());
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        log.info("All Info of User is Visible");
    }
    @And("User clicks on the Update Button")
    public void User_clicks_on_the_Update_Button(){
        if (DMS1460UserManagementDocTypeUIChangesPageObject.getUpdateButton().isVisible()){
            DMS1460UserManagementDocTypeUIChangesPageObject.getUpdateButton().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getUser_infoText().isDisplayed());
        }
    }
    @Then("User will click on the select Doc Type and see item list")
    public void User_will_click_on_the_select_Doc_Type_and_see_item_list(List<String> filters){
        DMS1460UserManagementDocTypeUIChangesPageObject.selectDocType(filters);
    }
    @Then("User will click on the Doc Type filter and select Doc type")
    public void User_will_click_on_the_Doc_Type_filter_and_select_Doc_type(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.docType(table);
    }
    @Then("User will select Doc type filter and verify changes in user information section")
    public void User_will_select_Doc_type_filter_and_verify_changes_in_user_information_section(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.checkChanges_userInfoSection(table);
    }
    @And("User will enter Doc Type filter then correspondence data should be visible for added LEI")
    public void User_will_enter_Doc_Type_filter_then_correspondence_data_should_be_visible_for_added_LEI(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.checkValueDocType_addedLEI(table);
    }
    @Then("Doc Type column should be visible")
    public void Doc_Type_column_should_be_visible(){
        DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_DocType_addedLEI().waitUntilVisible();
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_DocType_addedLEI().isDisplayed());
        log.info("Doc type column is visible under added LEI section");
    }
    @And("User will search for the LEI that belongs to 4 Way")
    public void User_will_search_for_the_LEI_that_belongs_to_4_Way(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.search_LEI(table);
    }
    @And("User will search for the LEI that doesn't belongs to 4 Way")
    public void User_will_search_for_the_LEI_that_doesnt_belongs_to_4_Way(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.search_LEI(table);
    }
    @And("User will search for the LEI that belongs to DN")
    public void User_will_search_for_the_LEI_that_belongs_to_DN(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.search_LEI(table);
    }
    @And("User will search for the LEI that doesn't belongs to DN")
    public void User_will_search_for_the_LEI_that_doesnt_belongs_to_DN(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.search_LEI(table);
    }
    @Then("User is able to verify corresponding result in the LEIs,Org type and Doc type section")
    public void User_is_able_to_verify_corresponding_result_in_the_LEIs_Org_type_and_Doc_type_section(){
        DMS1460UserManagementDocTypeUIChangesPageObject.verifyResultInLeiOrgSection();
    }
    @And("User will be able to check that LEI Dropdown is clickable or not")
    public void User_will_be_able_to_check_that_LEI_Dropdown_is_clickable_or_not(){
        DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_LEI().waitUntilClickable();
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_LEI().isClickable());
        log.info("Select LEI Dropdown is clickable");
    }
    @And("User will select the LEI for DN Doc type")
    public void User_will_select_the_LEI_for_DN_Doc_type(){
        DMS1460UserManagementDocTypeUIChangesPageObject.select_LEI();
    }
    @And("User will select the LEI for 4 Way Doc type")
    public void User_will_select_the_LEI_for_4_Way_Doc_type(){
        DMS1460UserManagementDocTypeUIChangesPageObject.select_LEI();
    }
    @Then("User will click on the Doc Type filter for added LEI and select Doc type")
    public void User_will_click_on_the_Doc_Type_filter_for_added_LEI_and_select_Doc_type(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.docType_addedLEI(table);
    }
    @Then("User is able to verify that EB Org type is visible or not")
    public void User_is_able_to_verify_that_EB_Org_type_is_visible_or_not(){
        DMS1460UserManagementDocTypeUIChangesPageObject.check_orgTypeEB();
    }
    @And("User will select the Org Type for DN Doc type")
    public void User_will_select_the_Org_Type_for_DN_Doc_type(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_OrgType().waitUntilVisible().click();
        if (DMS1460UserManagementDocTypeUIChangesPageObject.getEB_text().isVisible()){
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getEB_text().isPresent());
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getPB_text().isPresent());
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getClient_text().isPresent());
            log.info("PB, EB and Client are visible in the dropdown");
        }
        else {
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getPB_text().isPresent());
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getClient_text().isPresent());
            log.info("PB and Client are visible in the dropdown");
        }
        DMS1460UserManagementDocTypeUIChangesPageObject.selectOrgType(table);
    }
    @And("User will select the Org Type for 4 Way Doc type")
    public void User_will_select_the_Org_Type_for_4_Way_Doc_type(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.getSelect_OrgType().waitUntilVisible().click();
        if (DMS1460UserManagementDocTypeUIChangesPageObject.getEB_text().isVisible()){
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getEB_text().isPresent());
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getPB_text().isPresent());
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getClient_text().isPresent());
            log.info("PB, EB and Client are visible in the dropdown");
        }
        else {
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getPB_text().isPresent());
            Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getClient_text().isPresent());
            log.info("PB and Client are visible in the dropdown");
        }
        DMS1460UserManagementDocTypeUIChangesPageObject.selectOrgType(table);
    }
    @Then("User clicks on Add button")
    public void User_clicks_on_Add_button(){
        if (DMS1460UserManagementDocTypeUIChangesPageObject.getAddButton().isEnabled()) {
            DMS1460UserManagementDocTypeUIChangesPageObject.getAddButton().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }
    @Then("User will set doc type filter as DN")
    public void User_will_set_doc_type_filter_as_DN(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.docType_addedLEI(table);
    }

    @Then("User search for the same user")
    public void User_search_for_the_same_user(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.searchUser(table);
    }
    @And("Corresponding result should be visible")
    public void Corresponding_result_should_be_visible(){
        DMS1460UserManagementDocTypeUIChangesPageObject.getNoRecordFound().waitUntilVisible();
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getNoRecordFound().isDisplayed());
        log.info("No Record Found");
    }
    @And("Clicks on the select Org type")
    public void Clicks_on_the_select_Org_type(){
        DMS1460UserManagementDocTypeUIChangesPageObject.click_selectOrgType();
    }
    @Then("User can see Showing Page")
    public void User_can_see_Showing_Page(){
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getShowing_page().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getShowing_page_page_number().isVisible());
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getShowing_page_total_page().isVisible());
    }
    @And("User can see Records Per Page")
    public void User_can_see_Records_Per_Page(){
        Assert.assertTrue(DMS1460UserManagementDocTypeUIChangesPageObject.getRecords_per_page_value().isVisible());
    }
    @And("when the User is on the first page then prev button should be disabled")
    public void when_the_User_is_on_the_first_page_then_prev_button_should_be_disabled(){
        DMS1460UserManagementDocTypeUIChangesPageObject.check_previous_page_btn();
    }
    @And("when the User is on the last page then next button should be disabled")
    public void when_the_User_is_on_the_last_page_then_next_button_should_be_disabled(){
        DMS1460UserManagementDocTypeUIChangesPageObject.check_next_page_btn();
    }
    @Then("User will be able to see Doc type for different case sensitive Doc type name")
    public void User_will_be_able_to_see_Doc_type_for_different_case_sensitive_Doc_type_name(List<String> doctypeList){
        DMS1460UserManagementDocTypeUIChangesPageObject.caseSensitivityForDocType(doctypeList);
    }
    @Then("User will input LEI Org type and Doc type mapping and click add and check combination")
    public void User_will_input_LEI_Org_type_and_Doc_type_mapping_and_click_add_and_check_combination(DataTable table){
        DMS1460UserManagementDocTypeUIChangesPageObject.input_LEI_DocType_OrgType(table);
    }
}
