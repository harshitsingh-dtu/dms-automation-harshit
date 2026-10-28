package stepDefinations.UserManagementStep;

import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import PageObjects.UserManagement.UserManagementPageObject;
import Utilities.GeneralMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;
@Data
@Slf4j
public class UserManagementEditDetailsValidationStep {
    UserManagementPageObject userManagementPageObject;
  GeneralMethod generalMethod;
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    @Given("User is on User Management Edit Details screen")
    public void user_is_on_user_management_edit_details_screen(List<String> users){
        userManagementPageObject.navigateToUserManagement();
        userManagementPageObject.searchUser(users);
        userManagementPageObject.clickEditDeatils_btn();
    }

    @Then("User will see all the information")
    public void user_will_see_all_the_information(DataTable table)  {
        userManagementEditDetailsPageObject.userInformation(table);
    }
    @Then("User validates all the information on User Access Page")
    public void user_validates_information_UserAccessPage(DataTable table)  {
        userManagementEditDetailsPageObject.userInformationInUserAccessScreen(table);
    }
    @Then("^User can see Active in Active toggle button$")
    public void user_can_see_active_in_active_toggle_button(){
        Assert.assertTrue(userManagementEditDetailsPageObject.getActive_btn().isVisible());
    }
    @Then("User should get a list of LEI's")
    public void user_should_get_a_list_of_leis(){
        userManagementEditDetailsPageObject.checkifaddedLEI();
    }

    @When("User will search lei on the screen Org LEI")
    public void User_will_search_for_the_Org_LEI(DataTable table){
        userManagementEditDetailsPageObject.search_addedLEI(table);
    }
    @When("User will search the LEI on the User management screen")
    public void User_will_search_for_the_Org(DataTable table){
        userManagementEditDetailsPageObject.search_AllOrg(table);
    }

    @And("User will search org type on the screen Org type")
    public void user_will_search_for_the_org_type(DataTable table){
        userManagementEditDetailsPageObject.setSearch_addedOrgType(table);
    }
    @Then("^User will search for LEI org type and remove it on the user management service edit screen$")
    public void user_will_search_for_lei_org_type_and_remove_it_on_the_user_management_service_edit_screen(DataTable table)  {
        userManagementEditDetailsPageObject.remove_LEIOrgtype(table);
    }
    @Then("User should observe no changes")
    public void user_should_observe_no_changes(){

    }
    @Then("^User is able to see role mapping dropdown$")
    public void user_is_able_to_see_role_mapping_dropdown(){
        userManagementEditDetailsPageObject.checkrolemapping();
    }

    @Then("^verify the user can view and edit user profiles for all organizations$")
    public void verify_cross_org_user_edit_access(DataTable orgTable) {
        userManagementEditDetailsPageObject.verifyCrossOrgUserEditAccess(orgTable);
    }

    @And("^User is able to assign a role$")
    public void user_is_able_to_assign_a_role(DataTable table) {
        userManagementEditDetailsPageObject.typerolemappingnew(table);
    }

    @And("^User is able to remove a role$")
    public void user_is_able_to_remove_a_role(DataTable table) {
        userManagementEditDetailsPageObject.remove_roleMapping(table);
    }

    @And("^User is able to remove all the role$")
    public void user_is_able_to_remove_all_roles() {
        userManagementEditDetailsPageObject.remove_roleMapping2new();
    }
    @Then("Under the Added LEIs & Org type listing section, Doc type Filter, to get the list of LEI Org type that exists under the doc type")
    public void under_the_added_le_is_org_type_listing_section_doc_type_filter_to_get_the_list_of_lei_org_type_that_exists_under_the_doc_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Under the LEIs & Org type section, Doc type select Dropdown")
    public void under_the_le_is_org_type_section_doc_type_select_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Under the Added LEIs & Org type listing section, Doc type Column, mentioning which doc type the corresponding LEI Org type belongs to")
    public void under_the_added_le_is_org_type_listing_section_doc_type_column_mentioning_which_doc_type_the_corresponding_lei_org_type_belongs_to() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}