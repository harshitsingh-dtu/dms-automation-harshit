package stepDefinations.ApprovalMatrix;

import PageObjects.Approval.ApprovalMatrixCreatePageObject;
import PageObjects.Approval.ApprovalMatrixPageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

public class ApprovalMatrixCreateStep extends PageObject {
    ApprovalMatrixCreatePageObject approvalMatrixCreatePageObject;
    ApprovalMatrixPageObject approvalMatrixPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Given("User is on the create approval matrix screen")
    public void user_is_on_the_create_approval_matrix_screen()  {
        approvalMatrixPageObject.navigateToApprovalMatrixListingScreen();
        approvalMatrixPageObject.checkifcreateApprovalMatrixbtn();
        Assert.assertTrue(approvalMatrixPageObject.getCreate_btn().isVisible());
        approvalMatrixPageObject.getCreate_btn().click();
        Assert.assertTrue(approvalMatrixCreatePageObject.getCreatenewapprovalmatrix_txt().isVisible());
    }

    @Given("User is on the create approval matrix screen Alone")
    public void user_is_on_the_create_approval_matrix_screen_alone()  {
        withAction().pause(Duration.ofSeconds(2));
        approvalMatrixPageObject.navigateToApprovalMatrixListingScreenAlone();
        approvalMatrixPageObject.checkifcreateApprovalMatrixbtn();
        Assert.assertTrue(approvalMatrixPageObject.getCreate_btn().isVisible());
        approvalMatrixPageObject.getCreate_btn().click();
        Assert.assertTrue(approvalMatrixCreatePageObject.getCreatenewapprovalmatrix_txt().isVisible());
    }

    @Given("User enter the org value on create approval matrix screen")
    public void user_enter_Org_Value(DataTable table)  {
        approvalMatrixCreatePageObject.checkiforganizationfilter_and_type(table);
    }
    @Then("user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen")
    public void user_will_perform_actionsthen_user_can_see_and_able_to_fill_in_all_the_fields(DataTable table)  {
        approvalMatrixCreatePageObject.checkiforganizationfilter_and_type(table);
        approvalMatrixCreatePageObject.checkifDoctypefilter_and_type(table);
        approvalMatrixCreatePageObject.checkifLEIsfilter_and_type(table);
        approvalMatrixCreatePageObject.checkifOrgtypefilter_and_type(table);
    }

    @Then("User adds Sequential Column in Approval Matrix Screen")
    public void add_Sequential_Columns(){
        approvalMatrixCreatePageObject.getAdd_seqential_column().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("^User can see the cancel button on the create approval matrix screen$")
    public void user_can_see_the_cancel_button_on_the_create_approval_matrix_screen() {
        approvalMatrixCreatePageObject.checkifcancalbtn();
    }

    @And("^User can see the next button on the create approval matrix screen$")
    public void user_can_see_the_next_button_on_the_create_approval_matrix_screen() {
        approvalMatrixCreatePageObject.checkifnextbtn();
    }
    @And("^User can see and click the next button on the create approval matrix screen$")
    public void user_can_see_and_click_the_next_button_on_the_create_approval_matrix_screen()  {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        approvalMatrixCreatePageObject.click_next_btn();
    }
    @Then("^User will search for the approval group to be removed from approval matrix and remove it$")
    public void user_will_search_for_the_approval_group_to_be_removed_from_approval_matrix_and_remove_it(DataTable table) {
        approvalMatrixCreatePageObject.remove_approval_group(table);
    }
    @And("User clicks on the delete icon for sequence column {string}")
    public void userClicksOnDeleteIconForSequenceColumn(String sequenceId) {
        approvalMatrixCreatePageObject.deleteSequenceColumn(sequenceId);
    }
    @And("User clicks on the Confirm button on the popup")
    public void userClicksConfirmButtonOnPopup() {
        approvalMatrixCreatePageObject.clickConfirmOnPopup();
    }

    @Then("^User validates the Approval matrix already exists message$")
    public void approval_matrix_already_exists() {
    Assert.assertTrue(approvalMatrixCreatePageObject.getMatrix_already_exists().waitUntilVisible().isDisplayed());
    }
    @Then("User navigates to {string} action in Approval Matrix")
    public void DocumentAction_approval_matrix(String DocAction) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", getDriver().findElement(By.xpath("//*[text()='"+DocAction+"']")));
       withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
}