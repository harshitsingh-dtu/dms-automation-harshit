package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1528PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1553PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1553Step extends PageObject {

    DMS_1553PageObject dms1553PageObject;
    DMS_1528PageObject dms1528PageObject;

    @And("User will search for the added user and able to see corresponding result")
    public void User_will_search_for_the_added_user_and_able_to_see_corresponding_result(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms1553PageObject.getUserManagementscreen().waitUntilVisible();
        dms1553PageObject.SearchAddedUser(dataTable);
    }

    @When("User Click on Update button and redirect to update screen")
    public void User_Click_on_Update_button_and_redirect_to_update_screen(){
        Assert.assertTrue(dms1553PageObject.getUpdatebuttonfor_SearchedUser().isVisible());
        dms1553PageObject.getUpdatebuttonfor_SearchedUser().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1553PageObject.getUserUpdateScreen().isVisible());
    }

    @And("User navigate to role mapping section and remove role in case assigned")
    public void User_navigate_to_role_mapping_section_and_remove_role_in_case_assigned(List<String> RolesList){
        dms1553PageObject.RemoveUserRoles(RolesList);
    }

    @And("User navigate to role mapping section and Assign role in case not assigned")
    public void User_navigate_to_role_mapping_section_and_assign_role_in_case_not_assigned(List<String> RolesList){
        dms1553PageObject.AssignUserRoles(RolesList);
    }

    @And("User Navigate to LEIs Org type and Doctype Mapping Section add atleast one one LEI for both Doctype")
    public void User_Navigate_to_LEIs_Org_type_and_Doctype_Mapping_Section_add_atleast_one_one_LEI_for_both_Doctype(List<String> Doctype){
        dms1553PageObject.AddLEIS_For_Doctypes(Doctype);
    }

    @And("Click on Submit button get success message and redirect to user management screen")
    public void Click_on_Submit_button_get_success_message_and_redirect_to_user_management_screen(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (dms1553PageObject.getSubmitButton().isDisabled()){
            Assert.assertTrue(dms1553PageObject.getSubmitButton().isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(dms1553PageObject.getCancelbutton().isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            dms1553PageObject.getCancelbutton().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(dms1553PageObject.getUserManagementscreen().isVisible());
        }else {
            Assert.assertTrue(dms1553PageObject.getSubmitButton().isVisible());
            dms1553PageObject.getSubmitButton().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(dms1553PageObject.getSuccessMessage().isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(dms1553PageObject.getUserManagementscreen().isVisible());
        }
    }

    @And("click on profile icon and logout the current profile")
    public void click_on_profile_icon_and_logout_the_current_profile(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1553PageObject.getProfile_icon().isVisible());
        dms1553PageObject.getProfile_icon().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1553PageObject.getLogout_btn().isVisible());
        dms1553PageObject.getLogout_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("Re Login with the Credentials of updated user")
    public void ReLogin_with_the_Credentials_of_updated_user(DataTable dataTable){
        dms1553PageObject.ReloginwithUpdatedUser(dataTable);
    }

    @And("User will search to Document template that belongs to DN and 4 Way Able to see view button for correspondence searched template")
    public void User_will_search_to_Document_template_that_belongs_to_DN_and_fourWay_Able_to_see_view_button_for_correspondence_searched_template(List<String> Doctem){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1553PageObject.viewButtonDocumentTemplate(Doctem);
    }


    @And("User Navigate to LEI's Org type & Doctype Mapping Section add atleast one one LEI for 4 way Doctype")
    public void User_Navigate_to_LEIs_Org_type_and_Doctype_Mapping_Section_add_atleast_one_one_LEI_for_four_way_Doctype(List<String> Doctype){
        dms1553PageObject.AddLEIS_For_Doctypes(Doctype);
    }

    @And("User Navigate to LEI's Org type & Doctype Mapping Section add atleast one one LEI for DN Doctype")
    public void User_Navigate_to_LEIs_Org_type_and_Doctype_Mapping_Section_add_atleast_one_one_LEI_for_DN_Doctype(List<String> Doctype){
        dms1553PageObject.AddLEIS_For_Doctypes(Doctype);
    }

    @And("User will search to Document template that belongs to 4 Way Able to see view button for correspondence searched template")
    public void User_will_search_to_Document_template_that_belongs_to_fourWay_Able_to_see_view_button_for_correspondence_searched_template(List<String> Doctem){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1553PageObject.viewButtonDocumentTemplate(Doctem);
    }

    @And("User will search to Document template that belongs to DN Able to see view button for correspondence searched template")
    public void User_will_search_to_Document_template_that_belongs_to_DN_Able_to_see_view_button_for_correspondence_searched_template(List<String> Doctem){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1553PageObject.viewButtonDocumentTemplate(Doctem);
    }

    @And("User will search to Document template that belongs to DN and 4 Way Able to see update button for correspondence searched template")
    public void User_will_search_to_Document_template_that_belongs_to_DN_and_fourWay_Able_to_see_update_button_for_correspondence_searched_template(List<String> Doctem){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1553PageObject.UpdateButtonDocumentTemplate(Doctem);
    }

    @And("User is not able to see Create new Template button")
    public void User_is_not_able_to_see_Create_new_Template_button(){
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertFalse(dms1553PageObject.getCreatenewTemplateButton().isVisible());
    }

    @And("User is able to see Create new Template button")
    public void User_is_able_to_see_Create_new_Template_button(){
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dms1553PageObject.getCreatenewTemplateButton().isVisible());
    }
    @And("User will enter the document template name and click on the organization dropdown, then list of organizations assigned to user will be visible in the dropdown")
    public void User_will_enter_the_document_template_name_and_click_on_the_organization_dropdownthen_list_of_organizations_assigned_to_user_will_be_visible_in_the_dropdown(DataTable datatable){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1528PageObject.Entertemplatename(datatable);
        dms1553PageObject.ValidateOrganizationList();
    }

    @And("User is able to see No result found when search for Document template that belongs to DN")
    public void user_is_able_to_see_no_result_found_when_search_for_document_template_that_belongs_to_dn(List<String> Doctem) {
        dms1553PageObject.CheckDocumentTemplateforDNwhenPermissionNotAssign(Doctem);
    }

    @And("User is able to see correspondence result when Search for Document template that belongs to 4 Way")
    public void user_is_able_to_see_correspondence_result_when_search_for_document_template_that_belongs_to_fourway(List<String> Doctem) {
        dms1553PageObject.CheckDocumentTemplatewhenPermissionAssign(Doctem);
    }

    @And("User is able to see No result found when search for Document template that belongs to 4 way")
    public void user_is_able_to_see_no_result_found_when_search_for_document_template_that_belongs_to_fourWay(List<String> Doctem) {
        dms1553PageObject.CheckDocumentTemplatefor4waywhenPermissionNotAssign(Doctem);
    }

    @And("User is able to see correspondence result when Search for Document template that belongs to DN")
    public void user_is_able_to_see_correspondence_result_when_search_for_document_template_that_belongs_to_dn(List<String> Doctem) {
        dms1553PageObject.CheckDocumentTemplatewhenPermissionAssign(Doctem);
    }

}
