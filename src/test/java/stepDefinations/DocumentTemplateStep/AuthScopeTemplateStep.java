package stepDefinations.DocumentTemplateStep;

import PageObjects.DocumentTemplate.AuthScopeTemplatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class AuthScopeTemplateStep extends PageObject {

    AuthScopeTemplatePageObject authScopeTemplatePageObject;

    @Given("^User navigates to Authorisation scope templates listing screen$")
    public void user_navigates_to_authorisation_scope_templates_listing_screen() {
        authScopeTemplatePageObject.navigateToAuthScopeTemplatesScreen();
    }

    @Then("^User validates Authorisation scope templates listing screen elements$")
    public void user_validates_authorisation_scope_templates_listing_screen_elements(DataTable table) {
        authScopeTemplatePageObject.validateListingScreenElements(table);
    }

    @When("^User clicks on Create Template button$")
    public void user_clicks_on_create_template_button() {
        authScopeTemplatePageObject.clickCreateTemplate();
    }

    @And("^User enters template name and organisation details$")
    public void user_enters_template_name_and_organisation_details(DataTable table) {
        authScopeTemplatePageObject.enterTemplateNameAndOrg(table);
    }

    @And("^User searches for the authorisation scope template$")
    @When("^User searches for the authorisation scope template$")
    public void user_searches_for_the_authorisation_scope_template(DataTable table) {
        authScopeTemplatePageObject.searchTemplate(table);
    }

    @Then("^User validates template record in Authorisation scope templates table$")
    public void user_validates_template_record_in_authorisation_scope_templates_table(DataTable table) {
        authScopeTemplatePageObject.validateTemplateRecordInTable(table);
    }

    @And("^User clicks on Edit icon for template in Action column$")
    public void user_clicks_on_edit_icon_for_template_in_action_column() {
        authScopeTemplatePageObject.clickEditIconForTemplate();
    }

    @And("^User clicks on Delete icon for template in Action column$")
    public void user_clicks_on_delete_icon_for_template_in_action_column() {
        authScopeTemplatePageObject.clickDeleteIconForTemplate();
    }

    @And("^User confirms deletion on popup$")
    public void user_confirms_deletion_on_popup() {
        authScopeTemplatePageObject.confirmDeletion();
    }

    @And("^User validates template status is updated or removed$")
    public void user_validates_template_status_is_updated_or_removed(DataTable table) {
        authScopeTemplatePageObject.validateTemplateRecordInTable(table);
    }

    @Then("^User validates optional tenor option is disabled or not present for template$")
    public void user_validates_optional_tenor_option_is_disabled_or_not_present_for_template() {
        authScopeTemplatePageObject.validateOptionalTenorDisabledOrNotPresent();
    }

    @When("^User attempts to select optional tenor$")
    public void user_attempts_to_select_optional_tenor(DataTable table) {
        authScopeTemplatePageObject.attemptSelectOptionalTenor(table);
    }

    @Then("^User validates error message for invalid tenor$")
    public void user_validates_error_message_for_invalid_tenor(DataTable table) {
        authScopeTemplatePageObject.validateInvalidTenorError(table);
    }

    @And("^User validates Auth line with optional tenor is not added$")
    public void user_validates_auth_line_with_optional_tenor_is_not_added() {
        authScopeTemplatePageObject.validateAuthLineNotAdded();
    }

    @Then("User clicks on Submit button")
    public void user_clicks_on_submit_button_template() {
        authScopeTemplatePageObject.getSubmitTemplate_btn().waitUntilClickable().click();
    }
}
