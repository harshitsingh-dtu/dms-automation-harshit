package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1549PageObject;
import PageObjects.PermissionsPageObject.OrganisationPermissionsPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class DMS_1549Step extends PageObject {
    OrganisationPermissionsPageObject organisationPermissionsPageObject;
    DMS_1549PageObject dms_1549;
    @Then("User will be able to see roles related to DN")
    public void user_will_be_able_to_see_roles_related_to_dn(List<String> userRolesList) {
      dms_1549.check_DN_roles(userRolesList);
    }
    @Then("User will be able to see roles related to Four Way")
    public void user_will_be_able_to_see_roles_related_to_fourway(List<String> userRolesList) {
        dms_1549.check_4W_roles(userRolesList);
    }
    @Then("User will be able to see Admin related roles")
    public void user_will_be_able_to_see_admin_related_roles(List<String> userRolesList) {
        dms_1549.check_admin_roles(userRolesList);
    }

    @When("Assign below roles to the user")
    public void assignBelowRolesToTheUser(List<String> userRolesList) {
        organisationPermissionsPageObject.Select_userRoles(userRolesList);
    }

    @Then("User should be able to see the updated role")
    public void userShouldBeAbleToSeeTheUpdatedRole(List<String> userRolesList) {
        dms_1549.check_assigned_roles(userRolesList);
    }


}
