package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1491PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1523PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1706PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1570PageObject;
import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
@Data

public class DMS_1706Step extends PageObject {

    DMS_1706PageObject dms1706AuthenticateDocumentTypeWiseRolePageObject;

    DMS_1491PageObject DMS1491ApprovalGroupDocTypeUIChangePageObject;

    DMS_1570PageObject DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject;

    DMS_1523PageObject dms1523PageObject;

    DocumentTemplateCreatePageObject documentTemplateCreatePageObject;

    @Then("Again user will search for the approval group name and click update")
    public void Again_user_will_search_for_the_approval_group_name_and_click_update(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.search_ApprovalGroup(table);
        DMS1491ApprovalGroupDocTypeUIChangePageObject.getUpdate_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @And("User fills in the Group name and Organization")
    public void User_fills_in_the_Group_name_and_Organization(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.user_fills_the_group_name();
        dms1706AuthenticateDocumentTypeWiseRolePageObject.user_fills_the_organization_name(table);
    }
    @Then("No options should be visible in the dropdown")
    public void No_options_should_be_visible_in_the_dropdown(){
        Assert.assertTrue(dms1706AuthenticateDocumentTypeWiseRolePageObject.getNoOptions().isVisible());
        log.info("No Options is visible in the dropdown");
    }
    @Then("User will search for the approval group name")
    public void User_will_search_for_the_approval_group_name(DataTable table){
        DMS1491ApprovalGroupDocTypeUIChangePageObject.search_ApprovalGroup(table);
    }
    @Then("View button should be visible to the user")
    public void View_button_should_be_visible_to_the_user(){
        Assert.assertTrue(dms1706AuthenticateDocumentTypeWiseRolePageObject.getView_button().isVisible());
        log.info("View button is visible");
    }
    @Then("User will search for the organization")
    public void User_will_search_for_the_organization(DataTable table){
        dms1523PageObject.checkIfOrganizationFilter_and_type(table);
    }
    @Then("User will be redirected to document template listing screen")
    public void User_will_be_redirected_to_document_template_listing_screen(){
        Assert.assertTrue(dms1706AuthenticateDocumentTypeWiseRolePageObject.getDocumentTemplate_screen().isVisible());
        log.info("Redirected to document template listing screen");
    }
    @Then("User will enter Template name and search for organization")
    public void User_will_enter_Template_name_and_search_for_organization(DataTable table){
        documentTemplateCreatePageObject.selectTemplateName(table);
        documentTemplateCreatePageObject.selectOrganisationName(table);
    }
    @And("Create New Template button should not be visible")
    public void Create_New_Template_button_should_not_be_visible(){
        Assert.assertFalse(dms1706AuthenticateDocumentTypeWiseRolePageObject.getCreateNewTemplate_btn().isVisible());
        log.info("Create New Template button is not visible");
    }
    @Then("User will search for the random approval group name and click update")
    public void User_will_search_for_the_random_approval_group_name_and_click_update(){
        dms1706AuthenticateDocumentTypeWiseRolePageObject.searchRandomFirst_approvalGroup();
    }
    @Then("Again user will search for the random approval group of other organisation name and click update")
    public void Again_user_will_search_for_the_random_approval_group_of_other_organisation_name_and_click_update(){
        dms1706AuthenticateDocumentTypeWiseRolePageObject.searchRandom_approvalGroup();
    }
    @Then("User will search for the random approval matrix and click update")
    public void User_will_search_for_the_random_approval_matrix_and_click_update(){
        dms1706AuthenticateDocumentTypeWiseRolePageObject.searchRandomFirst_approvalMatrix();
    }
    @Then("Again user will search for the random approval matrix of other organisation and click update")
    public void Again_user_will_search_for_the_random_approval_matrix_of_other_organisation_and_click_update(){
        dms1706AuthenticateDocumentTypeWiseRolePageObject.searchRandom_approvalMatrix();
    }
    @And("Search for random document template on document template listing screen and click update")
    public void Search_for_random_document_template_on_document_template_listing_screen_and_click_update(){
        dms1706AuthenticateDocumentTypeWiseRolePageObject.searchRandom_documentTemplate();
    }
}
