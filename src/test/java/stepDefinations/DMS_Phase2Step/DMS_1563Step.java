package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1563PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j

public class DMS_1563Step extends PageObject {
    DMS_1563PageObject DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject;

    @When("User clicks on select LEI dropdown and see all LEIs name in the dropdown on the approval group listing screen")
    public void User_clicks_on_select_LEI_dropdown_and_see_all_LEIs_name_in_the_dropdown_on_the_approval_group_listing_screen(List<String> valuelist){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.clickLEIDropdown_ApprovalGroup(valuelist);
    }
    @Then("User will be able to input LEI in the select LEI column and see corresponding result for the selected LEI on approval group listing screen")
    public void User_will_be_able_to_input_LEI_in_the_select_LEI_column_and_see_corresponding_result_for_the_selected_LEI_on_approval_group_listing_screen(DataTable table){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.selectLEIApprovalGroup_seeResults(table);
    }
    @When("User will click on select Org type dropdown and see corresponding list")
    public void User_will_click_on_select_Org_type_dropdown_and_see_corresponding_list(){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getOrgType_box().waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getPB_text().isDisplayed());
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getEB_text().isDisplayed());
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getClient_text().isDisplayed());
        log.info("PB, EB and Client org type are visible");
    }
    @Then("User will be able to input Org type in the Org type column for approval group and see corresponding result for the selected Org type")
    public void User_will_be_able_to_input_Org_type_in_the_Org_type_column_for_approval_group_and_see_corresponding_result_for_the_selected_Org_type(DataTable table){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.selectOrgTypeApprovalGroup_seeResults(table);
    }
    @When("User will click on select Doc type dropdown and see corresponding list")
    public void User_will_click_on_select_Doc_type_dropdown_and_see_corresponding_list(){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getSelectDocType().waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getFourWayDocTypeFromDropdown().isDisplayed());
        Assert.assertTrue(DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.getDNDocTypeFromDropdown().isDisplayed());
        log.info("Both 4 Way and DN doc type are visible");
    }
    @Then("User will be able to input Doc type in the Doc type column for approval group and see corresponding result for the selected Doc type")
    public void User_will_be_able_to_input_Doc_type_in_the_Doc_type_column_for_approval_group_and_see_corresponding_result_for_the_selected_Doc_type(DataTable table){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.selectDocTypeApprovalGroup_seeResults(table);
    }
    @Then("User will be able to input Org type in the Org type column for approval matrix and see corresponding result for the selected Org type")
    public void User_will_be_able_to_input_Org_type_in_the_Org_type_column_for_approval_matrix_and_see_corresponding_result_for_the_selected_Org_type(DataTable table){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.selectOrgTypeApprovalMatrix_seeResults(table);
    }
    @Then("User will be able to input Doc type in the Doc type column for approval matrix and see corresponding result for the selected Doc type")
    public void User_will_be_able_to_input_Doc_type_in_the_Doc_type_column_for_approval_matrix_and_see_corresponding_result_for_the_selected_Doc_type(DataTable table){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.selectDocTypeApprovalMatrix_seeResults(table);
    }
    @When("User clicks on select LEI dropdown and see all LEIs name in the dropdown on the approval matrix listing screen")
    public void User_clicks_on_select_LE_dropdown_and_see_all_LEIs_name_in_the_dropdown_on_the_approval_matrix_listing_screen(List<String> valuelist){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.clickLEIDropdown_ApprovalMatrix(valuelist);
    }
    @Then("User will be able to input LEI in the select LEI column and see corresponding result for the selected LEI on approval matrix listing screen")
    public void User_will_be_able_to_input_LEI_in_the_select_LEI_column_and_see_corresponding_result_for_the_selected_LEI_on_approval_matrix_listing_screen(DataTable table){
        DMS1563AddFiltersonApprovalMatrixandGroupDocTypeLEIOrgTypePageObject.selectLEIApprovalMatrix_seeResults(table);
    }
}
