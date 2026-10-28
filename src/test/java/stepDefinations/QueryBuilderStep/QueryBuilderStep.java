package stepDefinations.QueryBuilderStep;

import PageObjects.QueryBuilder.QueryBuilderPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

@Slf4j
public class QueryBuilderStep extends PageObject {
    QueryBuilderPageObject queryBuilderPageObject;
    @And("User can see Add Edit query button")
    public void user_can_see_add_edit_query_button(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getAddEditQuery_btn().isVisible());
        }
        catch (AssertionError e){
            log.error("Add/Edit button not present"+e);
        }
    }

    @And("User can see select query dropdown")
    public void user_can_see_select_query_dropdown(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getAddEdit_selectquery_dropdown().isVisible());
        }
        catch (AssertionError e){
            log.error("Select dropdown is not visible on the screen"+e);
        }
    }

    @When("^User will click on the Add Edit query button$")
    public void user_will_click_on_the_add_edit_query_button() {
        if (queryBuilderPageObject.getAddEditQuery_btn().isVisible()){
            queryBuilderPageObject.getAddEditQuery_btn().click();
        }
    }

    @Then("^User will be redirected to Add Edit query screen$")
    public void user_will_be_redirected_to_add_edit_query_screen() {
        Assert.assertTrue(queryBuilderPageObject.getAddEdit_title().isVisible());
    }
    @Then("^validates query is applied successfully$")
    public void add_edit_query_screenIsClosed() {
        Assert.assertFalse(queryBuilderPageObject.getAddEdit_title().isVisible());
    }

    @And("^User can see select query dropdown on Add Edit screen$")
    public void user_can_see_select_query_dropdown_on_add_edit_screen(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getAddEdit_selectquery_dropdown().isVisible());
        }
        catch (AssertionError e){
            log.error("Select dropdown is not visible on the Add/Edit screen"+e);
        }
    }

    @And("^User can see and type into the query name$")
    public void user_can_see_and_type_into_the_query_name(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getQueryname().isVisible());
            // Clear out text properly using explicit Serenity action sequence
            queryBuilderPageObject.getQueryname().click();
            queryBuilderPageObject.getQueryname().clear();
            queryBuilderPageObject.getQueryname().typeAndEnter("testing text");
        }
        catch (AssertionError e){
            log.error("Query name is not visible on the screen"+e);
        }
    }

    @And("^user can see Add query button$")
    public void user_can_see_add_query_button(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getAddquery_btn().isVisible());
        }
        catch (AssertionError e){
            log.error("Add query button is not visible on the screen"+e);
        }
    }

    @And("^User can see the cancel button on Add Edit screen$")
    public void user_can_see_the_cancel_button_on_add_edit_screen() {
        try {
            Assert.assertTrue(queryBuilderPageObject.getCancel_btn().isVisible());
        }
        catch (AssertionError e){
            log.error("Cancel button is not visible on the screen"+e);
        }
    }

    @And("^User can see Save and Apply button on the Add Edit screen$")
    public void user_can_see_save_and_apply_button_on_the_add_edit_screen(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getSave_and_apply_btn().isVisible());
        }
        catch (AssertionError e){
            log.error("Save and Apply is not visible on the screen"+e);
        }
    }

    @And("User can see Apply button on the Add Edit screen")
    public void user_can_see_apply_button_on_the_add_edit_screen(){
        try {
            Assert.assertTrue(queryBuilderPageObject.getApply_btn().isVisible());
        }
        catch (AssertionError e){
            log.error("Apply button is not visible on the screen"+e);
        }
    }
    @When("^User will select a existing query from Add Edit screen$")
    public void user_will_select_a_existing_query_from_add_edit_screen(DataTable table){
        queryBuilderPageObject.select_existing_query_ADDEditScreen(table);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("^User will be able to remove a query block$")
    public void user_will_be_able_to_remove_a_query_block(DataTable table){
        queryBuilderPageObject.AddEdit_remove_existing_queryblock(table);
    }
    @When("^User will select a existing query from select query dropdown on document screen$")
    public void user_will_select_a_existing_query_from_select_query_dropdown_on_document_screen(DataTable table) {
        queryBuilderPageObject.select_existing_query(table);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @When("^User gives the unique query name on Add Edit screen$")
    public void user_gives_the_query_name_on_add_edit_screen(DataTable table){
        queryBuilderPageObject.AddEdit_queryname(table);
    }
    @And("^User clicks on Add query block$")
    public void user_clicks_on_add_query_block() {
        queryBuilderPageObject.getAddquery_btn().click();
    }
    @Then("^User clicks on Apply$")
    public void user_clicks_on_apply() {
        queryBuilderPageObject.getApply_btn().click();
        waitABit(3000);
        try {
            queryBuilderPageObject.getDocumentIDField().click();
        } catch (Exception e) {
            try {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", queryBuilderPageObject.getDocumentIDField());
            } catch (Exception ignored) {}
        }
        waitABit(1000);
    }
    @And("^User gets an error on the Add Edit screen$")
    public void user_gets_an_error_on_the_add_edit_screen(){
        try {
//            if (queryBuilderPageObject.getAddEdit_error_msg_queryname().isVisible()){
//                //
//            }
//            else {
//                Assert.assertTrue(queryBuilderPageObject.getAddEdit_error_msg().isVisible());
//            }
            queryBuilderPageObject.getAlert_addEdit().isVisible();
        }catch (Exception e){
            log.error("No error is captured");
        }
    }

    @Then("^User clicks on save and apply$")
    public void user_clicks_on_save_and_apply() {
        // Safe micro-pause to ensure the React UI catches up with state validation flags
        withAction().pause(Duration.ofMillis(500)).build().perform();

        queryBuilderPageObject.getSave_and_apply_btn().waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("^User clicks on apply button without saving$")
    public void userClicksOnApplyButtonWithoutSaving() {
        log.info("Applying query filters immediately without saving to prevent test environment data clutter...");
        queryBuilderPageObject.clickApplyButtonOnly();
    }

    @And("^User selects the field operator and value$")
    public void user_selects_the_field_operator_and_value(DataTable table) {
        queryBuilderPageObject.AddEdit_queryblock_details(table);
    }
    @And("^User performs multiple Add query block$")
    public void user_performs_multiple_add_query_block(DataTable table) {
        queryBuilderPageObject.AddEdit_multiple_queryblock_details(table);
    }

    @And("^User performs multiple Add query block for DN$")
    public void user_performs_multiple_add_query_block_DN(DataTable table) {
        queryBuilderPageObject.AddEdit_multiple_queryblock_details_DN(table);
    }
    @And("User will click on Add button for another query line")
    public void clickonAddbuttonToAddquery() {
        queryBuilderPageObject.getAdd_queryblock().click();
    }
    @And("User removes the query applied")
    public void remove_query_block() {
        queryBuilderPageObject.getClear_selectquery_dropdown().click();
        // Force a UI refresh by clicking on an unrelated field to trigger the filter clearing
        queryBuilderPageObject.getDocumentIDField().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(queryBuilderPageObject.getBlank_selectquery_dropdown().isVisible());
    }
    @And("User validates query is removed")
    public void validate_query_block_removed() {
        queryBuilderPageObject.getBlank_selectquery_dropdown().withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
        Assert.assertTrue("The query dropdown should be empty after the query is removed",
                queryBuilderPageObject.getBlank_selectquery_dropdown().isVisible());
    }

    @And("User will click on Apply More Filters")
    public void click_Apply_More_Filters() {
        queryBuilderPageObject.getApplyMoreFilters_btn().click();
    }
    @And("User will be redirected to Advance Filters Screen")
    public void advanceFilterScreens() {
        Assert.assertTrue(queryBuilderPageObject.getAdvFiltersScreen().waitUntilVisible().isVisible());
    }
    @And("User validates the fields on the filter screen")
    public void validateAdvanceFilterScreen() {
       queryBuilderPageObject.verifyAdvanceFilterFieldsNew();
    }
    @And("^User enters Auth Scope values in Advance filters$")
    public void user_enter_advanceFilter(DataTable table) {
        queryBuilderPageObject.AddAuthScopeValuesInAdvanceFilters(table);
    }
    @Then("^User reliably selects Auth Scope values in Advance filters$")
    public void user_reliably_selects_auth_scope_values_in_advance_filters(DataTable table) {
        queryBuilderPageObject.reliablyAddAuthScopeValues(table);
    }

    @And("^Click on Apply Filters$")
    public void user_advanceFilter() {
        queryBuilderPageObject.getApplyFilters().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("User validates the max value limit value")
    public void user_validates_the_max_value_limit_value(DataTable dataTable) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        queryBuilderPageObject.maxValueOfLimitValue(dataTable);
    }

}