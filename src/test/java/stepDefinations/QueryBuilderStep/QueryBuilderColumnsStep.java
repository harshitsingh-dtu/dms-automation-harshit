package stepDefinations.QueryBuilderStep;

import PageObjects.QueryBuilder.QueryBuilderColumnsPageObject;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class QueryBuilderColumnsStep extends PageObject {
    QueryBuilderColumnsPageObject queryBuilderColumnsPageObject;
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    @When("User clicks on Column Selection button")
    public void user_is_able_to_select_columns_selections() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        WebElementFacade columnsBtn = queryBuilderColumnsPageObject.getColumnsSelection_btn();
        try {
            columnsBtn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", columnsBtn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", columnsBtn);
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("var btn = Array.from(document.querySelectorAll('button')).find(b => b.textContent.trim() === 'Column Selection'); if (btn) btn.click();");
        }
    }

    @Then("Delete or Terminate all the relatable documents")
    public void deleteOrTerminateAllTheRelatableDocuments() {
        queryBuilderColumnsPageObject.deleteTerminateDoc();
    }

    @Then("User will search for column, selects it if not already selected and validates the same on Document listing screen")
    public void user_enter_the_required_column_to_be_selected(DataTable columns) {
        queryBuilderColumnsPageObject.selectSearchBar();
        queryBuilderColumnsPageObject.columnText_search(columns);
        queryBuilderColumnsPageObject.validateColumnAreAdded(columns);
    }
    @And("user will select Column Values on Document listing screen")
    public void user_will_select_LEIsfor_the_filter(DataTable columns){
        queryBuilderColumnsPageObject.verifyColumnNew(columns);
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", queryBuilderColumnsPageObject.getDocumentTitle());
    }

    @And("user will select Column Values on Document Dashboard listing screen")
    public void user_will_select_LEIsfor_the_filteron_DocDashboard(DataTable columns){
//        getJavascriptExecutorFacade().executeScript("window.scrollTo(0, window.scrollY);");
        queryBuilderColumnsPageObject.verifyColumnNew(columns);
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", queryBuilderColumnsPageObject.getDocumentTitle());
    }

    @Then("Verify the user can view and download documents for all organizations")
    public void verifyViewAndDownload(List<Map<String, String>> orgTable) {
        queryBuilderColumnsPageObject.verifyViewAndDownloadForOrganisations(orgTable);
    }

    @And("User is able to select Doc type from Doc type dropdown")
    public void userSelectsDocType(List<Map<String, String>> docTypeTable) {
        userManagementEditDetailsPageObject.selectDocTypeFromDropdown(docTypeTable);
    }

    @And("User configures Document Mapping details")
    public void userConfiguresMapping(List<Map<String, String>> mappingData) {
        // This calls the method we created in UserManagementEditDetailsPageObject
        queryBuilderColumnsPageObject.configureUserMappings(mappingData);
    }

    @And("user will select Column Values Again on Document listing screen")
    public void user_will_select_LEIsfor_the_filter_Again(DataTable columns){
//        getJavascriptExecutorFacade().executeScript("window.scrollTo(0, window.scrollY);");
        queryBuilderColumnsPageObject.verifyAllColumns(columns);
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", queryBuilderColumnsPageObject.getDocumentTitle());
    }

    @And("User Validates the columns are displayed on Dashboard")
    public void user_validates_theColumn_on_Dashboard(DataTable table){
        queryBuilderColumnsPageObject.user_Validates_the_columns_are_displayed_on_Dashboard(table);
    }

    @And("User validates DN Documents are displayed")
    public void validate_filter_result() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        WebElementFacade resultElement = queryBuilderColumnsPageObject.getFilterResults();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", resultElement);
        withAction().pause(Duration.ofMillis(500)).build().perform();
        String actualText = resultElement.getAttribute("textContent").trim();
        Assert.assertTrue("Expected text to be 'DN' but found: '" + actualText + "'",
                actualText.equalsIgnoreCase("DN"));
    }

    @And("Search for fund name")
    public void Search_for_fund_name(DataTable table){
        queryBuilderColumnsPageObject.SearchFund(table);
    }
    @And("User clicks on Client-2 Funds fund count")
    public void user_clicks_on_fund_count() {
        queryBuilderColumnsPageObject.ClientFund();
    }
    @And("Validate No Funds appear if fund is not added")
    public void validates_no_funds() {
        queryBuilderColumnsPageObject.NoFundsVisible();
    }

    @And("User validate the Fund count")
    public void validates_funds_count() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",queryBuilderColumnsPageObject.getFundCount());
//        getJavascriptExecutorFacade().executeScript(
//                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
//                queryBuilderColumnsPageObject.getFundCount()
//        );
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(queryBuilderColumnsPageObject.getFundCount().getText().equalsIgnoreCase("1"));
    }
    @And("User validates the sequence of below columns comes after Document Action")
    public void validate_PB_EB_Sequence(DataTable table){
        queryBuilderColumnsPageObject.validateColumnSequence_withDocumentAction(table);
    }
    @And("User validates the sequence of below columns comes after Document Status and Allowed Currencies")
    public void validate_Limit_fields(DataTable table){
        queryBuilderColumnsPageObject.validateColumnSequence_withStatusAndCurrencies(table);
    }
    @And("User verifies the Drag handle is visible for each column on Document Dashboard")
    public void validate_Drag_HandleCount_DocumentDashboard(){
        Assert.assertEquals(58,queryBuilderColumnsPageObject.getDragHandleCount().size());
    }
    @And("User verifies the Drag handle is visible for each column on DF Dashboard")
    public void validate_Drag_HandleCount_DFDashboard(){
        Assert.assertEquals(15,queryBuilderColumnsPageObject.getDragHandleCount().size());
    }
    @And("User Drags the column to the top")
    public void User_Drag_HandleCount_Dashboard_first_position(DataTable table){
        queryBuilderColumnsPageObject.DragAndDropColumnSelection(table);
    }
    @And("User Drags the column to 3rd position")
    public void User_Drag_HandleCount_Dashboard_3rd_position(DataTable table){
        queryBuilderColumnsPageObject.DragAndDropColumnSelection_3rdPosition(table);
    }
    @And("User verify the sequence of Columns")
    public void User_Verify_Sequence(DataTable table){
        queryBuilderColumnsPageObject.VerifySequence(table);
    }
    @And("User clicks on Apply button")
    public void User_Verify_Sequence(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",queryBuilderColumnsPageObject.getApplyButton());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        queryBuilderColumnsPageObject.getApplyButton().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

}
    @Then("User Verifies The Credit Link Sync Status")
    public void validateCLSyncStatus () {
        queryBuilderColumnsPageObject.creditLinkCLSyncStatusValidation();
    }

    @And("User clears all listing column filters")
    public void clearAllListingFilters() {
        getJavascriptExecutorFacade().executeScript(
            "document.querySelectorAll('.MuiAutocomplete-clearIndicator').forEach(btn => btn.click());"
        );
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
}