package stepDefinations.UserManagementStep;

import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import PageObjects.UserManagement.UserManagementPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Slf4j
public class UserManagementWorkflowStep extends PageObject {
    UserManagementPageObject userManagementPageObject;
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Then("^User reaches the User Management screen$")
    public void user_reaches_the_user_management_screen(){
        userManagementPageObject.userManagementscreen();
    }

    @And("^User clicks on User management$")
    public void user_clicks_on_user_management() {
        userManagementPageObject.navigateToUserManagement();
    }

    @Given("User is on the User onboarding screen")
    public void user_is_on_the_user_onboarding_screen()  {
        userManagementPageObject.navigateToUserManagement();
    }

    @Then("User can see all the filters")
    public void user_can_see_all_the_filters(){
        userManagementPageObject.checkiffilters();
    }

    @And("User can see the column names")
    public void user_can_see_the_column_names(){
        userManagementPageObject.checkifallcolumns();
    }

    @And("User can search for the existing user")
    public void user_can_search_for_the_existing_user(){
        userManagementPageObject.checkSearch_forExisting();
    }

    @And("User can search for new user")
    public void user_can_search_for_new_user(){
        userManagementPageObject.checkSearch_fornew();
    }

    @And("User can see the edit button")
    public void user_can_see_the_edit_button(){
        userManagementPageObject.checkifEditbtn();
    }

    @And("User can see the status button")
    public void user_can_see_the_status_button(){
        userManagementPageObject.checkifstatus_btn();
    }

    @When("User will set the organization,status,roles filters")
    public void user_will_set_the_filters(DataTable table) {
        userManagementPageObject.organizationFilter(table);
        userManagementPageObject.statusFilter(table);
        userManagementPageObject.rolesFilter(table);
    }
    @When("User searches for the role in User Access Screen")
    public void user_seacrhesForTheRole(DataTable table) {
        userManagementPageObject.searchRole(table);
    }
    @When("User searches for the role in User Access Screen without selecting")
    public void userSearchesForRoleWithoutSelecting(DataTable table) {
        userManagementPageObject.searchRoleWithoutSelecting(table);
    }

    @And("User validates no record found should Not be displayed")
    public void No_record_Found_ISNOT_Displayed(){
        Assert.assertFalse(userManagementPageObject.getNoRecordFound_text().isCurrentlyVisible());
    }

    @Then("Validate No options should be displayed in Role dropdown")
    public void validateNoOptionsInRoleDropdown() {
        Assert.assertTrue(
                "FAILED: 'No options' was not displayed in the Role dropdown",
                userManagementPageObject.validateRoleDropdownNoOptionsDisplayed()
        );
        log.info("SUCCESS: 'No options' correctly displayed in Role dropdown");
    }

    @And("User validates Create new User button has been removed")
    public void No_Create_New_User_Is_Displayed(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        try{
            userManagementPageObject.getCreateNewUser().isDisplayed();
        }
        catch (NoSuchElementException e)
        {
          System.out.println("Create new User button does not exists");
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Then("User will perform role mapping,Doc type,LEI,Org type actions")
    public void user_will_perform_actions(DataTable table){
        userManagementEditDetailsPageObject.typerolemapping(table);
        userManagementEditDetailsPageObject.doctype(table);
        userManagementEditDetailsPageObject.searchLEI(table);
        userManagementEditDetailsPageObject.searchOrgType(table);
        userManagementEditDetailsPageObject.add_btn();

    }

    @And("User will search for the User")
    public void user_will_search_for_the_user(List<String> users){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        userManagementPageObject.searchUser(users);

    }

    @And("User will search for the User Not Found")
    public void user_will_search_for_the_usernotfound(List<String> users){
        userManagementPageObject.searchUserNotfound(users);

    }

    @And("^User click on Edit button on the User management listing screen$")
    public void user_click_on_edit_button_on_the_user_management_listing_screen()  {

    }
    @Then("^corresponding information of user will be visible on the screen$")
    public void corresponding_information_of_user_will_be_visible_on_the_screen(){
        userManagementPageObject.checkInfovisible();
    }

    @And("User will reach on the Edit Details screen")
    public void user_will_reach_on_the_edit_details_screen(){
        userManagementPageObject.clickEditDeatils_btn();
    }
    @And("User will reach on the View Details screen")
    public void user_will_reach_on_the_view_details_screen(){
        userManagementPageObject.clickViewDeatils_btn();
    }

    @Then("^User can see role mapping,LEI,Org type actions$")
    public void user_can_see_role_mappingleiorg_type_actions() {
        Assert.assertTrue( userManagementEditDetailsPageObject.getRolemappingDropbox().isDisplayed());
        Assert.assertTrue(userManagementEditDetailsPageObject.getSearch_addedLEI().isVisible());
        Assert.assertTrue(userManagementEditDetailsPageObject.getSearch_addedOrgtype().isVisible());
        log.info("All three are visible");
    }

    @Then("^User can see Selected Roles$")
    public void user_can_see_selected_roles() {
        Assert.assertTrue(userManagementEditDetailsPageObject.getSelectedRoles().isVisible());
        log.info("Selected Roles are visible");
    }

    @Then("^User checks LEIs,Doc Type and Orgtype dropdowns")
    public void user_checks_leis_and_orgtype_dropdowns() {
        Assert.assertTrue(userManagementEditDetailsPageObject.getDoctype().isVisible());
        Assert.assertTrue(userManagementEditDetailsPageObject.getSearch_LEI().isVisible());
        Assert.assertTrue(userManagementEditDetailsPageObject.getSearch_orgType().isVisible());
    }

    @And("^User removes all existing LEI Org type mappings$")
    public void user_removes_all_existing_lei_org_type_mappings() {
        userManagementEditDetailsPageObject.removeAllLeiOrgTypeMappings();
    }

    @And("^User is able to select LEI from LEIs dropdown$")
    public void user_is_able_to_select_lei_from_leis_dropdown(DataTable table)  {
        userManagementEditDetailsPageObject.searchLEI(table);
    }

    @And("^User is able to select Org type from Org type dropdown$")
    public void user_is_able_to_select_org_type_from_org_type_dropdown(DataTable table)  {
        userManagementEditDetailsPageObject.searchOrgType(table);
    }
    @And("^Validate EB does not exists$")
    public void EB_doesNot_exists(DataTable table)  {
        Assert.assertTrue(userManagementEditDetailsPageObject.EBDoesNotExists(table).equalsIgnoreCase("No options"));
    }

    @And("^User is able to add the LEI Org type combination$")
    public void user_is_able_to_add_the_lei_org_type_combination() {
        userManagementEditDetailsPageObject.add_btn();
    }
    @And("^User gets the Mapping already exists warning$")
    public void MappingAlreadyExists() {
        Assert.assertTrue(userManagementEditDetailsPageObject.getAlert_popup().isVisible());
    }
    @And("user will submit the changes")
    public void user_will_submit_the_changes() {
        userManagementEditDetailsPageObject.clickSubmit_btn();
    }

    @Then("User validates the user update notification")
    public void user_validates_user_update_notification() {
        userManagementEditDetailsPageObject.validateUserUpdateNotification();
    }

    @Then("^User should be able to change the status using toggle button$")
    public void user_should_be_able_to_able_the_status_of_toggle_button(){
        documentCreateNewPageObject.startContinuousToastInterceptor();
        userManagementPageObject.change_toggle_status();
    }
    @When("^user will search in find and add user and click on Add and Verify User already exists$")
    public void user_will_search_in_find_and_add_user_and_click_on_add(List<String> users){
       Assert.assertTrue("User already exists",userManagementPageObject.search_new_users_and_add(users));
    }

    @Then("User removes lei mapping for doc type and org type")
    public void user_removes_lei_mapping(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String docType = data.get(0).get("doc type");
        String orgType = data.get(0).get("Org type");
        userManagementEditDetailsPageObject.removeLeiMapping(docType, orgType);
    }

    @Then("^User checks if status is active, if not makes it active$")
    public void user_checks_if_status_is_active_if_not_makes_it_active() {
        userManagementPageObject.ensureStatusIsActive();
    }

}