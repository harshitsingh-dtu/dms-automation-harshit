package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1491PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1460PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


@Slf4j
public class DMS_1491Step extends PageObject {

    DMS_1491PageObject DMS1491ApprovalGroupDocTypeUIChangePageObject;
    DMS_1460PageObject DMS1460UserManagementDocTypeUIChangesPageObject;
    Actions act=new Actions(getDriver());

    @Given("User is on Approval Group Screen")
    public void User_is_on_Approval_Group_Screen() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        DMS1491ApprovalGroupDocTypeUIChangePageObject.navigateToApprovalGrpScreen();
    }
    @Then("Verify if user is on the approval group screen")
    public void Verify_if_user_is_on_the_approval_group_screen(){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getApprovalGroup_title().isDisplayed());
        log.info("Approval group title is visible");
    }
    @And("User should be able to see all information on the approval group screen")
    public void User_should_be_able_to_see_all_information_on_the_approval_group_screen(){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getSearch_approvalGroupName().isVisible());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getSelectLEIs().isVisible());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getSelectOrgType().isVisible());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getSelectDocType().isVisible());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getCreateApprovalGroup_btn().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getGroupName_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getOrganisationName_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getDocType_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getLEIName_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getOrgType_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getNo_of_Users_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getCreatedOn_Text().isDisplayed());
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getAction_Text().isDisplayed());
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        log.info("All information is visible on the approval group screen");

    }
    @When("User will select the Doc type")
    public void User_will_select_the_Doc_type(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.select_docType(table);
    }
    @And("Search for the approval group that belongs to DN Doc type then Corresponding approval group details should be visible")
    public void Search_for_the_approval_group_that_belongs_to_DN_Doc_type_then_Corresponding_approval_group_details_should_be_visible(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.search_ApprovalGroup(table);
    }
    @When("User is on Create new Approval Group screen")
    public void User_is_on_Create_new_Approval_Group_screen(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.navigateToApprovalGrpScreen();
        if (DMS1491ApprovalGroupDocTypeUIChangePageObject.getCreateApprovalGroup_btn().isVisible()){
            DMS1491ApprovalGroupDocTypeUIChangePageObject.getCreateApprovalGroup_btn().click();
            act.pause(Duration.ofSeconds(3)).build().perform();
       }
    }
    @And("User will be on Create new Approval Group screen")
    public void User_will_be_on_Create_new_Approval_Group_screen(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.navigateToApprovalGrpScreen();
        if (DMS1491ApprovalGroupDocTypeUIChangePageObject.getCreateApprovalGroup_btn().isVisible()){
            DMS1491ApprovalGroupDocTypeUIChangePageObject.getCreateApprovalGroup_btn().click();
            act.pause(Duration.ofSeconds(3)).build().perform();
        }
    }
    @When("User fills the Group name,Organization name,Doc type,LEI's,Org type")
    public void User_fills_the_Group_name_Organization_name_Doc_type_LEI_s_Org_type(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_group_name();
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_organization_name();
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_doc_type(table);
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_leis();
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_org_type(table);
    }
    @And("Clicks on next")
    public void Clicks_on_next(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.getNext_btn().click();
        act.pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User will redirected to the second screen")
    public void User_will_redirected_to_the_second_screen(){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getAdduser_text().isDisplayed());
        log.info("Redirected to second screen and Add user text is visible");
    }
    @When("User enters the group name and organisation name")
    public void User_enters_the_group_name_and_organisation_name(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_group_name();
        DMS1491ApprovalGroupDocTypeUIChangePageObject.user_fills_the_organization_name();
    }
    @Then("User will redirected to the second screen and add user")
    public void User_will_redirected_to_the_second_screen_and_add_user(DataTable table){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getAdduser_text().isDisplayed());
        DMS1491ApprovalGroupDocTypeUIChangePageObject.addUser(table);
        if(DMS1491ApprovalGroupDocTypeUIChangePageObject.getAdd_btn().isVisible()) {
            DMS1491ApprovalGroupDocTypeUIChangePageObject.getAdd_btn().click();
            act.pause(Duration.ofSeconds(2)).build().perform();
        }
        if(DMS1491ApprovalGroupDocTypeUIChangePageObject.getSubmit_btn().isEnabled()) {
            DMS1491ApprovalGroupDocTypeUIChangePageObject.getSubmit_btn().click();
            act.pause(Duration.ofSeconds(7)).build().perform();
        }
    }
    @And("User will redirected to the approval group listing screen")
    public void User_will_redirected_to_the_approval_group_listing_screen(){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getApprovalGroup_title().isDisplayed());
        log.info("Redirected to Approval Group listing Screen");
    }
    @Then("User will redirected to the second screen and search for user")
    public void User_will_redirected_to_the_second_screen_and_search_for_user(DataTable table){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getAdduser_text().isDisplayed());
        DMS1491ApprovalGroupDocTypeUIChangePageObject.addUser(table);
    }
    @Then("No Record found should be displayed")
    public void No_Record_found_should_be_displayed(){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getNoRecordFound().isDisplayed());
        log.info("No Record found is visible");
    }
    @Then("User will search for the approval group name and click update")
    public void User_will_search_for_the_approval_group_name_and_click_update(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.search_ApprovalGroup(table);
        DMS1491ApprovalGroupDocTypeUIChangePageObject.getUpdate_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @Then("User will be redirected to the update screen of the Approval group")
    public void User_will_be_redirected_to_the_update_screen_of_the_Approval_group(){
        Assert.assertTrue(DMS1491ApprovalGroupDocTypeUIChangePageObject.getUpdateApprovalGroup_Text().isDisplayed());
    }
    @And("Remove previously added user and Submit")
    public void Remove_previously_added_user_and_Submit(){
        if(DMS1491ApprovalGroupDocTypeUIChangePageObject.getCross_icon().isPresent()) {
            DMS1491ApprovalGroupDocTypeUIChangePageObject.getCross_icon().click();
            act.pause(Duration.ofSeconds(2)).build().perform();
        }
        if (DMS1491ApprovalGroupDocTypeUIChangePageObject.getSubmit_btn().isEnabled()){
            DMS1491ApprovalGroupDocTypeUIChangePageObject.getSubmit_btn().click();
            act.pause(Duration.ofSeconds(4)).build().perform();
            log.info("Successfully removed the previously added user");
        }
    }
    @Then("User will go to the User Onboarding Screen")
    public void User_will_go_to_the_User_Onboarding_Screen(){
        DMS1460UserManagementDocTypeUIChangesPageObject.navigateToUserManagement();
    }
    @And("User will search for the Org type under added LEI column")
    public void User_will_search_for_the_Org_type_under_added_LEI_column(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.selectOrgType_addedLEI(table);
    }
    @Then("User will go to the approval group listing screen")
    public void User_will_go_to_the_approval_group_listing_screen(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.navigateToApprovalGrpScreen();
    }
    @And("Search for the previously created approval group")
    public void Search_for_the_previously_created_approval_group(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.searchPreviouslyCreated_approvalGroup();
    }
    @Then("User will be able to see no of users under the no of users column")
    public void User_will_be_able_to_see_no_of_users_under_the_no_of_users_column(){
        Assert.assertEquals("0", DMS1491ApprovalGroupDocTypeUIChangePageObject.getNoOfUsers_value().getText().trim());
        log.info("The value of no. of users is 0");
    }
    @And("Click on update button on approval group listing screen")
    public void Click_on_update_button_on_approval_group_listing_screen(){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.getUpdate_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
}
