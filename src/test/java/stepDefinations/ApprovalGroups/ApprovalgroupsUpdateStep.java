package stepDefinations.ApprovalGroups;

import PageObjects.Approval.ApprovalgroupPageObject;
import PageObjects.Approval.ApprovalgroupUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class ApprovalgroupsUpdateStep extends PageObject {
    ApprovalgroupPageObject approvalgroupPageObject;
    ApprovalgroupUpdatePageObject approvalgroupUpdatePageObject;

    @Given("User will search for group name and reaches the update screen")
    public void user_will_search_for_group_name_and_reaches_the_update_screen(DataTable table)  {
        approvalgroupPageObject.checkSearchBar(table);
        approvalgroupPageObject.checkandclickupdatebtn();
        approvalgroupUpdatePageObject.checkifonupdatescreen();

    }
    @Then("User will search for LEI and reaches the update screen")
    public void userWillSearchForLEIAndReachesTheUpdateScreen() {
        approvalgroupPageObject.random_search_LEI();
        if (!approvalgroupPageObject.getSearchedresult_grpname().getText().isEmpty()){
            approvalgroupUpdatePageObject.checkifonupdatescreen();
        }
    }
    @Then("User will search for the users to be added and add them")
    public void user_will_search_for_the_users_to_be_added_and_add_them(DataTable users) {
        approvalgroupUpdatePageObject.searchandAddUsers(users);
    }
    @Then("^User will search for the users to be removed and remove them$")
    public void user_will_search_for_the_users_to_be_removed_and_remove_them(List<String> users){
        approvalgroupUpdatePageObject.searchandRemoveUsers(users);
    }

    @And("User will submit the changes after adding users to the approval group")
    public void user_will_submit_the_changes_after_adding_users_to_the_approval_group()  {
        approvalgroupUpdatePageObject.submitchanges();

    }

    @And("Validates User added successfully notification and lands on approval group page")
    public void user_validates_approval_group()  {
        approvalgroupUpdatePageObject.getApprovalGroupNotification().waitUntilVisible();
        Assert.assertEquals("1 user added successfully",approvalgroupUpdatePageObject.getApprovalGroupNotification().getText());
        Assert.assertTrue(approvalgroupPageObject.getCreateapproval_btn().isDisplayed());
    }

    @And("Validates User removed successfully notification and lands on approval group page")
    public void user_validates_remove_user_notification()  {
        approvalgroupUpdatePageObject.getApprovalGroupNotification().waitUntilVisible();
        Assert.assertEquals("User removed successfully",approvalgroupUpdatePageObject.getApprovalGroupNotification().getText());
        Assert.assertTrue(approvalgroupPageObject.getCreateapproval_btn().isDisplayed());
    }
    @And("User validates approval group created successfully notification")
    public void user_validates_approval_group_created_successfully()  {
        approvalgroupUpdatePageObject.getApprovalGroupNotification().waitUntilVisible();
        Assert.assertEquals("Approval group created successfully",approvalgroupUpdatePageObject.getApprovalGroupNotification().getText());

    }
    @Then("User will search for the users to be added and validate no record found")
    public void user_will_search_and_validate_no_record_found(DataTable users) {
        approvalgroupUpdatePageObject.searchUsersAndValidateNoRecordFound(users);
    }

    @Then("User will delete the approval group")
    public void user_deletes_approval_group() {
        approvalgroupUpdatePageObject.getDeleteIcon().click();
        approvalgroupUpdatePageObject.getYesButton().click();
    }
    @Then("User clicks on Delete button for approval group")
    public void delete_approval_group() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        approvalgroupUpdatePageObject.getDeleteIcon().click();
    }
    @Then("User clicks on the No button on popup")
    public void click_on_no_button() {
        approvalgroupUpdatePageObject.getNoButton().click();
    }
    @Then("User will navigate to approval group listing screen")
    public void navigate_to_approval_group_listing_screen(){
        approvalgroupPageObject.navigateToApprovalGroupScreen();
    }
    @Then("the user selects active from the Status filter")
    public void the_user_selects_from_the_status_filter() {
        approvalgroupPageObject.selectStatusFilter();
    }
    @Then("User verify approved tick mark for the 1st approval group")
    public void user_validated_approvedTick_for_firstApproval_group() {
        approvalgroupPageObject.getFirst_Approved().isVisible();
    }
    @Then("User verify approved tick mark for the 2nd approval group")
    public void user_validated_approvedTick_for_secondApproval_group() {
        approvalgroupPageObject.getSecond_Approved().isVisible();
    }
    @Then("User verify rejected tick mark for the approval group")
    public void user_validated_rejectedTick_for_Approval_group() {
        approvalgroupPageObject.getRejected_approvalGroup().isVisible();
    }
    @Then("User validates the user id of the designated approval group")
    public void user_validates_userId_of_designated_ApprovalGroup(DataTable dataTable) {
        approvalgroupPageObject.validateUserIdInGroups(dataTable);
    }
    @Then("User validates approved document status in track graph")
    public void user_validates_docStatus_in_track() {
        approvalgroupPageObject.getApprovedStatus().isVisible();
    }
    @Then("User validates rejected document status in track graph")
    public void user_validates_rejected_docStatus_in_track() {
        approvalgroupPageObject.getRejectedStatus().isVisible();
    }

    @Then("User clicks on Expand Icon for approval groups")
    public void user_click_on_expand_button_for_approvalGroups () {
        approvalgroupPageObject.getExpandButton_approvalGroups().click();
    }
}