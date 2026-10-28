package stepDefinations.ApprovalMatrix;

import PageObjects.Approval.ApprovalMatrixCreatePageObject;
import PageObjects.Approval.ApprovalMatrixPageObject;
import PageObjects.Approval.ApprovalMatrixUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class ApprovalMatrixStep extends PageObject {
    ApprovalMatrixPageObject approvalMatrixPageObject;
    ApprovalMatrixCreatePageObject approvalMatrixCreatePageObject;
    ApprovalMatrixUpdatePageObject approvalMatrixUpdatePageObject;

    @Given("user is on approval matrix listing screen")
    public void user_is_on_approval_matrix_listing_screen(){
        approvalMatrixPageObject.navigateToApprovalMatrixListingScreen();
        approvalMatrixPageObject.getCreate_btn().withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
    }
    @Given("user navigates to approval matrix screen")
    public void user_navigates_to_approval_matrix_listing_screen(){
//        withAction().pause(Duration.ofSeconds(5)).build().perform();
       // approvalMatrixPageObject.navigateToApprovalMatrixScreen();
        approvalMatrixPageObject.navigateToApprovalMatrixListingScreen();
        approvalMatrixPageObject.getCreate_btn().withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
    }

    @Then("user will be able to see create approval matrix button")
    public void user_will_be_able_to_see_create_approval_matrix_button(){
        approvalMatrixPageObject.getCreate_btn().waitUntilVisible();
       Assert.assertTrue( approvalMatrixPageObject.getCreate_btn().isVisible());
    }
    @And("user will be able to see search bar")
    public void user_will_be_able_to_see_search_bar(){
        Assert.assertTrue(approvalMatrixPageObject.getSearchBar().isVisible());
    }

    @And("user will be able to see organization name, LEIs name, org type, doc type, created on, action")
    public void user_will_be_able_to_see_organization_name_leis_name_org_type_doc_type_created_on_action() {
        approvalMatrixPageObject.checkifAllcolumns();
    }

    @And("^user will be able to see update button$")
    public void user_will_be_able_to_see_update_button() {
        approvalMatrixPageObject.checkifupdatebtn();
    }

    @And("^user will be able to see View button$")
    public void user_will_be_able_to_see_view_button() {
        approvalMatrixPageObject.checkifviewbtn();
    }

    @When("^user searches for a approval matrix$")
    public void user_searches_for_a_approval_matrix(List<String> approvaMatrix)  {
        approvalMatrixPageObject.searchapprovalMatrix(approvaMatrix);
    }

    @And("^when clicked, user redirects to the create screen$")
    public void when_clicked_user_redirects_to_the_create_screen() {
        approvalMatrixPageObject.getCreate_btn().click();
        Assert.assertTrue(approvalMatrixCreatePageObject.getCreatenewapprovalmatrix_txt().isVisible());

    }
    @Then("^check if update button is visible$")
    public void check_if_update_button_is_visible() throws Throwable {
        approvalMatrixPageObject.checkifupdatebtn();
    }

    @And("^when clicked, user redirects to the update screen$")
    public void when_clicked_user_redirects_to_the_update_screen() {
        approvalMatrixPageObject.clickupdatebtn();
        Assert.assertTrue(approvalMatrixUpdatePageObject.getUpdate_approval_matrix_header_text().isVisible());

    }
    @And("^user searches for a approval matrix and validates the results$")
    public void search_and_validate(DataTable table){
      Assert.assertTrue(approvalMatrixPageObject.searchApprovalMatrix(table));
    }
    @And("^User validates all the Approval Matrix for the Org type searched$")
    public void validateOrgTypeResults(){
        Assert.assertTrue(approvalMatrixPageObject.ValidateOrgTyperesults());
    }

    @And("^User validates the approval matrix notification for Approval Group$")
    public void validateApprovalmatrixNotification(){
        Assert.assertTrue(approvalMatrixPageObject.validateNotification());
    }
    @And("^User gets the notification that group mapping already exist$")
    public void validateMappingExistsNotification(){
        Assert.assertTrue(approvalMatrixPageObject.getGroupMappingAlreadyExists().waitUntilVisible().isDisplayed());
    }
    @And("^User validates the renaming at approval matrix update page$")
    public void validateRenamingUpdateScreen(){
        Assert.assertTrue(approvalMatrixPageObject.getRename_LEI_UpdateScreen().waitUntilVisible().isDisplayed());
    }

}