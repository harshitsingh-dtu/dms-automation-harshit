package stepDefinations.DocumentFramework;

import PageObjects.DocumentTemplate.AuthScopeTemplatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class AuthScopeTemplateStep extends PageObject {

    AuthScopeTemplatePageObject authScopeTemplatePageObject;

    @Given("User navigates to Authorisation scope templates listing screen")
    public void user_navigates_to_authorisation_scope_templates_listing_screen() {
        authScopeTemplatePageObject.navigateToAuthScopeTemplatesScreen();
    }

    @Then("User validates Authorisation scope templates listing screen elements")
    public void user_validates_authorisation_scope_templates_listing_screen_elements(DataTable table) {
        authScopeTemplatePageObject.validateListingScreenElements(table);
    }

    @When("User clicks on Create Template button")
    public void user_clicks_on_create_template_button() {
        authScopeTemplatePageObject.clickCreateTemplate();
    }

    @Then("User validates Create Auth scope template screen is displayed")
    public void user_validates_create_auth_scope_template_screen_is_displayed(DataTable table) {
        authScopeTemplatePageObject.validateCreateTemplateHeader(table);
    }

    @When("User enters template name on create screen")
    public void user_enters_template_name_on_create_screen(DataTable table) {
        authScopeTemplatePageObject.enterTemplateNameOnCreateScreen(table);
    }

    @And("User selects Asset Class, Product Family, Product on template screen")
    public void user_selects_asset_class_product_family_product_on_template_screen(DataTable table) {
        authScopeTemplatePageObject.selectAssetFamilyProduct(table);
    }

    @And("User selects attributes for {string} on template screen")
    public void user_selects_attributes_on_template_screen(String lineName, DataTable table) {
        authScopeTemplatePageObject.selectAttributesForLine(lineName, table);
    }

    @When("User clicks on Save As Draft button")
    public void user_clicks_on_save_as_draft_button() {
        authScopeTemplatePageObject.clickSaveAsDraft();
    }

    @And("User searches for the authorisation scope template")
    @When("User searches for the authorisation scope template")
    public void user_searches_for_the_authorisation_scope_template(DataTable table) {
        authScopeTemplatePageObject.searchTemplate(table);
    }

    @Then("User validates template record in Authorisation scope templates table")
    public void user_validates_template_record_in_authorisation_scope_templates_table(DataTable table) {
        authScopeTemplatePageObject.validateTemplateRecordInTable(table);
    }

    @And("User clicks on Edit icon for template in Action column")
    public void user_clicks_on_edit_icon_for_template_in_action_column() {
        authScopeTemplatePageObject.clickEditIconForTemplate();
    }

    @And("User clicks on Delete icon for template in Action column")
    public void user_clicks_on_delete_icon_for_template_in_action_column() {
        authScopeTemplatePageObject.clickDeleteIconForTemplate();
    }

    @And("User confirms deletion on popup")
    public void user_confirms_deletion_on_popup() {
        authScopeTemplatePageObject.confirmDeletion();
    }

    @And("User validates template status is updated or removed")
    public void user_validates_template_status_is_updated_or_removed(DataTable table) {
        authScopeTemplatePageObject.validateTemplateRecordInTable(table);
    }

    @Then("User validates optional tenor toggle is not present on template screen")
    public void user_validates_optional_tenor_toggle_is_not_present_on_template_screen() {
        authScopeTemplatePageObject.validateOptionalTenorNotPresentOnScreen();
    }

    @And("User validates only non-optional tenor fields are displayed on template line")
    public void user_validates_only_non_optional_tenor_fields_are_displayed_on_template_line(DataTable table) {
        authScopeTemplatePageObject.validateNonOptionalTenorFieldsDisplayed(table);
    }

    @When("User attempts to add authorisation line with optional tenor")
    public void user_attempts_to_add_authorisation_line_with_optional_tenor(DataTable table) {
        authScopeTemplatePageObject.attemptAddLineWithOptionalTenor(table);
    }

    @Then("User validates error message for invalid tenor")
    public void user_validates_error_message_for_invalid_tenor(DataTable table) {
        authScopeTemplatePageObject.validateInvalidTenorError(table);
    }

    @And("User validates Auth line with optional tenor is not added")
    public void user_validates_auth_line_with_optional_tenor_is_not_added() {
        authScopeTemplatePageObject.validateAuthLineNotAdded();
    }

    @Then("User clicks on Submit button")
    public void user_clicks_on_submit_button_template() {
        authScopeTemplatePageObject.getSubmitTemplate_btn().waitUntilClickable().click();
    }
}
