package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1491PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1523PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1570PageObject;
import PageObjects.DMS_PHASE2PageObject.Approval_groups_matrix_PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
@Data

public class approval_groups_matrix_Step extends PageObject {

    Approval_groups_matrix_PageObject approval_groups_matrix_PageObject;

    DMS_1570PageObject DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject;

    DMS_1491PageObject DMS1491ApprovalGroupDocTypeUIChangePageObject;

    DMS_1523PageObject approvalmatrixDocTypeUIChangePageObjectDMS1523;

        @Then("Create Approval Group button should not be visible to the user")
        public void Create_Approval_Group_button_should_not_be_visible_to_the_user() {
            Assert.assertFalse(approval_groups_matrix_PageObject.getCreateApprovalGroup_btn().isVisible());
            log.info("Create approval group button is not visible");
        }
        @Then("User fills in the Group name and Organization name")
        public void User_fills_in_the_Group_name_and_Organization_name(){
            DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_group_name();
            DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_organization_name();
        }
        @And("Click on Doc type filter then user should not be able to see DN doc type")
        public void Click_on_Doc_type_filter_then_user_should_not_be_able_to_see_DN_doc_type(){
            approval_groups_matrix_PageObject.getDoc_type_box().waitUntilClickable();
            approval_groups_matrix_PageObject.getDoc_type_box().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(approval_groups_matrix_PageObject.getFourWay_text().isVisible());
            Assert.assertFalse(approval_groups_matrix_PageObject.getDN_text().isVisible());
            log.info("4 Way is visible and DN doc type is not visible");
        }
       @And("Click on Doc type filter then user should not be able to see 4 Way doc type")
       public void Click_on_Doc_type_filter_then_user_should_not_be_able_to_see_4_Way_doc_type(){
           approval_groups_matrix_PageObject.getDoc_type_box().waitUntilClickable();
           approval_groups_matrix_PageObject.getDoc_type_box().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(approval_groups_matrix_PageObject.getDN_text().isVisible());
            Assert.assertFalse(approval_groups_matrix_PageObject.getFourWay_text().isVisible());
            log.info("DN is visible and 4 Way doc type is not visible");
    }
       @And("Click on Doc type filter then user should be able to see both 4 Way and DN dropdown")
       public void Click_on_Doc_type_filter_then_user_should_be_able_to_see_both_4_Way_and_DN_dropdown(){
           approval_groups_matrix_PageObject.getDoc_type_box().waitUntilClickable();
           approval_groups_matrix_PageObject.getDoc_type_box().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(approval_groups_matrix_PageObject.getDN_text().isVisible());
            Assert.assertTrue(approval_groups_matrix_PageObject.getFourWay_text().isVisible());
            log.info("Both 4 Way and DN dropdown is visible");
    }
    @Then("User fills in the Group name,Organization and Doc type")
    public void User_fills_in_the_Group_name_Organization_and_Doc_type(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_group_name();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_organization_name();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_doc_type(table);
    }
    @And("User will select the LEI")
    public void User_will_select_the_LEI(DataTable table){
        approval_groups_matrix_PageObject.user_selectLEI(table);
    }
    @Then("User should be able to see only assigned LEI")
    public void User_should_be_able_to_see_only_assigned_LEI(){
        Assert.assertTrue(approval_groups_matrix_PageObject.getAssignedLEI().isVisible());
        log.info("Assigned LEI is visible");
    }
    @Then("No result found should be visible in the select LEI dropdown")
    public void No_result_found_should_be_visible_in_the_select_LEI_dropdown(){
        Assert.assertTrue(approval_groups_matrix_PageObject.getNoOptions_text().isVisible());
        log.info("No Options is visible");
    }
    @Then("User will be able to see corresponding result as per selected doc type")
    public void User_will_be_able_to_see_corresponding_result_as_per_selected_doc_type(DataTable table){
        approval_groups_matrix_PageObject.ColumnAndColumnValueCheck(table);
    }
    @Then("View button should be visible as per the selected doc type")
    public void View_button_should_be_visible_as_per_the_selected_doc_type(DataTable table){
        approval_groups_matrix_PageObject.ColumnAndColumnValueCheck(table);
    }
    @And("User will select the Doc type again")
    public void User_will_select_the_Doc_type_again(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.select_docType(table);
    }
    @And("Create approval group button should not be visible")
    public void Create_approval_group_button_should_not_be_visible(){
        Assert.assertFalse(approval_groups_matrix_PageObject.getCreateApprovalGroup_btn().isVisible());
        log.info("Create Approval Group button is not visible");
    }
    @And("No Record found should be displayed after selecting DN")
    public void No_Record_found_should_be_displayed_after_selecting_DN(){
        Assert.assertTrue(approval_groups_matrix_PageObject.getNoRecordFound_text().isVisible());
        log.info("No Record Found is displayed");
    }
    @Then("User will be redirected to approval matrix listing screen")
    public void User_will_be_redirected_to_approval_matrix_listing_screen(){
        Assert.assertTrue(approval_groups_matrix_PageObject.getApprovalMatrix_title().isVisible());
    }
    @Then("User can see and able to fill organization filter")
    public void User_can_see_and_able_to_fill_organization_filter(DataTable table){
        approvalmatrixDocTypeUIChangePageObjectDMS1523.checkIfOrganizationFilter_and_type(table);
    }
    @And("User will click on select doc type")
    public void User_will_click_on_select_doc_type(){
        approval_groups_matrix_PageObject.getDoc_type_box().waitUntilClickable();
        approval_groups_matrix_PageObject.getDoc_type_box().click();
    }
    @Then("User should not be able to see Four Way in dropdown")
    public void User_should_not_be_able_to_see_4_Way_in_dropdown(){
        Assert.assertFalse(approval_groups_matrix_PageObject.getFourWay_text().isVisible());
        log.info("4 Way is not visible in the dropdown");
    }
    @Then("User should not be able to see DN in dropdown")
    public void User_should_not_be_able_to_see_DN_in_dropdown(){
        Assert.assertFalse(approval_groups_matrix_PageObject.getDN_text().isVisible());
        log.info("DN is not visible in the dropdown");
    }
    @Then("Create Approval Matrix button should not be visible to the user")
    public void Create_Approval_Matrix_button_should_not_be_visible_to_the_user(){
        Assert.assertFalse(approval_groups_matrix_PageObject.getCreateApprovalMatrix_btn().isVisible());
        log.info("Create approval matrix button is not visible");
    }
    @Then("User can see and able to fill organization filter and doc type filter")
    public void User_can_see_and_able_to_fill_organization_filter_and_doc_type_filter(DataTable table){
        approvalmatrixDocTypeUIChangePageObjectDMS1523.checkIfOrganizationFilter_and_type(table);
        approvalmatrixDocTypeUIChangePageObjectDMS1523.checkIfDocTypeFilter_and_type(table);
    }
}
