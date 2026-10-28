package stepDefinations.PermissionsStep;

import PageObjects.Login.LoginPageObject;
import PageObjects.OrgManagement.OrgManagementPageObject;
import PageObjects.PermissionsPageObject.OrganisationPermissionsPageObject;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.List;

public class OrganisationsPermssionsStep extends PageObject {
    LoginPageObject loginPageObject;
    OrgManagementPageObject orgManagementPageObject;
    OrganisationPermissionsPageObject organisationPermissionsPageObject;
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    @When("User will select VIEW_ALL roles for Org")
    public void user_will_select_view_all_roles_for_org(List<String> userRolesList) {
        organisationPermissionsPageObject.Select_userRoles(userRolesList);
    }

    @When("User will select Doctype LEI Orgtype mapping in case not present")
    public void user_will_select_doctype_lei_orgtype_mapping_in_case_not_present() {
        //checking if 4 Way mapping is present is present
        if (!userManagementEditDetailsPageObject.getAddedLEIsOrgtype_Doctype_list().containsText("4 Way")){
            organisationPermissionsPageObject.random_4Way_LEI_Orgtype_Mapping();
        }
        //selecting random LEI mapping for 4 Way doc type

    }

    @When("User will Submit the update user service")
    public void user_will_submit_the_update_user_service() {
        if (userManagementEditDetailsPageObject.getSubmit_btn().isClickable()){
            userManagementEditDetailsPageObject.getSubmit_btn().click();
        }
        else {
            userManagementEditDetailsPageObject.getCancel_btn().click();
        }
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @When("User will logout of the application")
    public void user_will_logout_of_the_application() {
        loginPageObject.clickLogout();
    }

    @Then("User will search for other organisations and corresponding result is visible")
    public void user_will_search_for_other_organisations_and_corresponding_result_is_visible(List<String> lei) {
        orgManagementPageObject.typeInPredictiveSearchBar(lei);
    }
}
