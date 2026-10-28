package stepDefinations.ApprovalGroups;

import PageObjects.Approval.ApprovalgroupCreatePageObject;
import PageObjects.Approval.ApprovalgroupPageObject;
import PageObjects.Approval.ApprovalgroupUpdatePageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.util.List;
import java.time.Duration;

@Slf4j
public class ApprovalgroupsCreateStep extends PageObject {
    ApprovalgroupPageObject approvalgroupPageObject;
    ApprovalgroupUpdatePageObject approvalgroupUpdatePageObject;
    ApprovalgroupCreatePageObject approvalgroupCreatePageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Given("User is on create new approval group screen")
    public void user_is_on_create_new_approval_group_screen(){
        approvalgroupPageObject.navigateToApprovalgrpScreen();
        approvalgroupCreatePageObject.clickcreatenew_btn();
    }

    @When("User fills the group name,organization name,doc type,LEI's,org type")
    public void user_fills_the_group_name_organization_name_doc_type_lei_s_org_type(DataTable table){
        approvalgroupCreatePageObject.user_fills_the_group_name(table);
        approvalgroupCreatePageObject.user_fills_the_organization_name(table);
        approvalgroupCreatePageObject.user_fills_the_doc_type(table);
        approvalgroupCreatePageObject.user_fills_the_leis(table);
        approvalgroupCreatePageObject.user_fills_the_org_type(table);
    }
    @When("User generates unique the group name,organization name,LEI's,org type")
    public void user_enters_the_data(DataTable table){
        approvalgroupCreatePageObject.user_generates_unique_group_name(table);
        approvalgroupCreatePageObject.user_fills_the_organization_name(table);
        approvalgroupCreatePageObject.user_fills_the_doc_type(table);
        approvalgroupCreatePageObject.user_fills_the_leis(table);
        approvalgroupCreatePageObject.user_fills_the_org_type(table);
    }
    @Then("^User is able to see filters of group name, organisation name, LEI, org type and next button$")
    public void user_is_able_to_see_filters_of_group_name_organisation_name_lei_org_type_and_next_button()  {
        try {

            Assert.assertTrue(approvalgroupCreatePageObject.getGroupname_box().isVisible());
            Assert.assertTrue(approvalgroupCreatePageObject.getOrganizationname_box().isVisible());
            Assert.assertTrue(approvalgroupCreatePageObject.getLeiname_box().isVisible());
            Assert.assertTrue(approvalgroupCreatePageObject.getOrgtype_box().isVisible());
            Assert.assertTrue(approvalgroupCreatePageObject.getNext_btn().isVisible());
            Assert.assertTrue(approvalgroupCreatePageObject.getCancel_btn().isVisible());

        }catch (Exception e){
            log.error("Elements are missing"+e);
            Assert.fail();
        }
    }

    @Then("user is redirected to update approval group screen")
    public void user_is_redirected_to_second_screen_for_new_approval_screen()  {
        if (approvalgroupCreatePageObject.getAlert_approval_group_exists().isVisible()){
            log.info("Approval group already present");
            Assert.fail();
        }
        approvalgroupUpdatePageObject.checkifonupdatescreen();
    }
    @When("User validates for the Approval group name")
    public void user_validates_approval_group(List<String> approvalGroup){
       String expected = approvalgroupCreatePageObject.validates_group_name(approvalGroup);
        Assert.assertEquals(expected,approvalgroupCreatePageObject.getApprovalGroupName().waitUntilVisible().getText());
    }

    @And("clicks on next")
    public void clicks_on_next() {
        //withAction().pause(Duration.ofSeconds(3)).moveToElement(approvalgroupCreatePageObject.getNext_btn()).click().build().perform();
        documentCreateNewPageObject.startContinuousToastInterceptor();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        evaluateJavascript("arguments[0].click();", approvalgroupCreatePageObject.getNext_btn());
    }

    @When("User updates the group name")
    public void user_validates_approval_group(DataTable table) {
        approvalgroupCreatePageObject.user_updatesApprovalGroupName(table);
    }
    @Then("User navigates to Approval group screen")
    public void user_on_approval_group_screen() {
        approvalgroupPageObject.navigateToApprovalgrpScreenValidation();
    }
    @Then("User validates number of users is {int} for approval group")
    public void validate_number_of_users_for_group(int expectedCount, DataTable table) {

        String groupName = table.asMaps(String.class, String.class)
                .get(0)
                .get("group name");

        approvalgroupCreatePageObject.validateNoOfUsersForApprovalGroup(groupName, expectedCount);
    }
    @When("User click on create new approval group button")
    public void create_new_approval_group() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        approvalgroupCreatePageObject.getCreate_approval_grp().click();
    }

    @Then("^verify the user can view records for all organizations in the table$")
    public void verify_the_user_can_view_records_for_all_organizations(DataTable entitiesTable) {
        approvalgroupCreatePageObject.verifyCrossOrgVisibility(entitiesTable);
    }

    @When("^User creates the approval matrix for the following combinations if not present$")
    public void user_creates_approval_matrix_if_not_present(DataTable dataTable) {
        approvalgroupCreatePageObject.createApprovalMatrixIfNotPresent(dataTable);
    }

    @And("User validates approval group name length")
    public void validate_approval_group_name_length (){
        approvalgroupCreatePageObject.validateGroupNameMaxLength();
    }
}