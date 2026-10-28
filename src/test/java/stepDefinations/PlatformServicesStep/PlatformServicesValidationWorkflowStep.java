package stepDefinations.PlatformServicesStep;

import PageObjects.PlatformServices.PlatformServicesPageObject;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;

import java.time.Duration;

public class PlatformServicesValidationWorkflowStep extends PageObject {
    PlatformServicesPageObject platformServicesPageObject;
    @Then("User validates Platform Services is not visible")
    public void user_is_able_to_select_parent_organisations() {
        platformServicesPageObject.clickParentOrganisations();
    }
    @Then("Verifies the Parent Organisations Page")
    public void verifies_the_parent_organisations_page() {
        platformServicesPageObject.verifyParentOrganisations();
    }

    @Then("User is able to select Legacy Organisations")
    public void user_is_able_to_select_legacy_organisations() {
        platformServicesPageObject.clickLegacyOrganisations();
    }
    @Then("Verifies the Legacy Organisations Page")
    public void verifies_the_legacy_organisations_page() throws InterruptedException {
        platformServicesPageObject.verifyLegacyOrganisations();
    }
    @Then("User is able to select Legacy Users")
    public void user_is_able_to_select_legacy_users() {
        platformServicesPageObject.clickLegacyUsers();
    }
    @Then("User is able to select Legal Entities")
    public void user_is_able_to_select_Legal_Entities() {
        platformServicesPageObject.getPlatformServices().waitUntilVisible().click();
        platformServicesPageObject.getLegalEntities_tab().waitUntilVisible().click();
    }
    @Then("Verifies the Legacy Users Page")
    public void verifies_the_legacy_users_page() {
        platformServicesPageObject.verifyLegacyUsers();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }




}