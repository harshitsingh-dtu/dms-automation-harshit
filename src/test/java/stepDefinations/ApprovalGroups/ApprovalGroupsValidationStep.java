package stepDefinations.ApprovalGroups;

import PageObjects.Approval.ApprovalgroupPageObject;
import PageObjects.Approval.ApprovalgroupUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;
@Slf4j
public class ApprovalGroupsValidationStep extends PageObject {
    ApprovalgroupPageObject approvalgroupPageObject;
    ApprovalgroupUpdatePageObject approvalgroupUpdatePageObject;
    @Given("User is on Approval group screen")
    public void user_is_on_approval_group_screen() {
        approvalgroupPageObject.navigateToApprovalgrpScreen();
    }
    @Given("user navigates to Approval group screen")
    public void user_is_on_approval_Group_screen() {
        approvalgroupPageObject.navigateToApprovalGroupScreen();
    }


    @Then("List of Approval group should be visbile to the user")
    public void list_of_approval_group_should_be_visbile_to_the_user()  {
        approvalgroupPageObject.checkifonListingPage();
    }
    @Then("Create Approval button is visible to the user")
    public void create_approval_button_is_visible_to_the_user() {
        approvalgroupPageObject.checkifcreateapprovalbtn();
    }

    @Then("User should be able to see headers of approval Group table")
    public void user_should_be_able_to_see_headers_of_approval_group_table() throws Throwable {
        Assert.assertTrue(approvalgroupPageObject.getGroupname_col().isVisible());
        Assert.assertTrue(approvalgroupPageObject.getOrganizationName_col().isVisible());
        Assert.assertTrue(approvalgroupPageObject.getLEIsName_col().isVisible());
        Assert.assertTrue(approvalgroupPageObject.getOrgType_col().isVisible());
        Assert.assertTrue(approvalgroupPageObject.getNoOfUsers_col().isVisible());
        Assert.assertTrue(approvalgroupPageObject.getCreatedOn_col().isVisible());
        Assert.assertTrue(approvalgroupPageObject.getAction_col().isVisible());
    }
    @When("User clicks on update button")
    public void user_clicks_on_update_button()  {
        approvalgroupPageObject.checkandclickupdatebtn();
    }

    @Then("User should be redirected to another screen")
    public void user_should_be_redirected_to_another_screen()  {
        approvalgroupUpdatePageObject.checkifonupdatescreen();
    }

    @When("User searches for Approval group name in the search bar and validates")
    public void user_searches_for_group_name_in_the_search_bar(DataTable groupname){
        Assert.assertTrue(approvalgroupPageObject.checkSearchBar(groupname));
    }

    @Then("User validates the search field")
    public void validates_the_search_field(){
        Assert.assertTrue(approvalgroupPageObject.getSearchbar().waitUntilVisible().isDisplayed());
        Assert.assertTrue(approvalgroupPageObject.getSearchBox().waitUntilVisible().isDisplayed());
        Assert.assertTrue(approvalgroupPageObject.getSearchIcon().waitUntilVisible().isDisplayed());
    }
    @And("^All the details corresponding to the approval group should be visible$")
    public void all_the_details_corresponding_to_the_approval_group_should_be_visible(){
        try {
            Assert.assertTrue(approvalgroupPageObject.getSearchedresult_organisationname().isVisible());
            Assert.assertTrue(approvalgroupPageObject.getSearchedresult_LEIname().isVisible());
            Assert.assertTrue(approvalgroupPageObject.getSearchedresult_orgtypename().isVisible());
            Assert.assertTrue(approvalgroupPageObject.getSearchedresult_createdon().isVisible());
            Assert.assertTrue(approvalgroupPageObject.getSearchedresult_noofusers().isVisible());
        }catch (Exception e){
            log.error("Not able to verify all the elements"+e);
            Assert.fail();
        }
    }
   @Then("User validates the list of LEIs")
   public void validates_the_LEIs_list(){
        approvalgroupPageObject.getSelect_LEI_DropDown().click();
       Assert.assertTrue(approvalgroupPageObject.getDropDownList().waitUntilVisible().isDisplayed());
   }

    @Then("User will search for the LEI on Approval Group Listing screen")
    public void search_for_LEI(List<String> LEIname){
        approvalgroupPageObject.searchLEI(LEIname);
    }
    @Then("User validates the select org type dropdown values for 4 way")
    public void select_org_type_dropdown(){
        Assert.assertTrue(approvalgroupPageObject.check4wayOrgTypeDropDownValues());
    }

    @Then("User validates the select org type dropdown values for DN")
    public void select_org_type_dropdownforDN(){
        Assert.assertTrue(approvalgroupPageObject.checkDNOrgTypeDropDownValuesDN());
    }

    @Then("User will select the Org type on Approval Listing screen")
    public void select_org_type(List<String> orgType){
        approvalgroupPageObject.selectOrgType(orgType);
        approvalgroupPageObject.clickselectOrgType(orgType);
    }
    @Then("User will select and click the Org type on Approval Listing screen")
    public void select_click_org_type(List<String> orgType){
        approvalgroupPageObject.clickselectOrgType(orgType);
    }

    @Then("User validates the doc type dropdown values")
    public void select_doc_type_dropdown(){
        approvalgroupPageObject.getDocType_DropDown().click();
        Assert.assertEquals("4 Way", approvalgroupPageObject.getDocType_DropDown().getValue().trim());
    }

    @Then("User validates the doc type dropdown contains {string}")
    public void user_validates_the_doc_type_dropdown_contains(String expectedValue) {
        approvalgroupPageObject.getDocType_DropDown().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        String actualOptionsText = approvalgroupPageObject.getDropDownValues().getTextContent();
        Assert.assertTrue("Expected dropdown options to contain: " + expectedValue + ", but actual was: " + actualOptionsText,
                actualOptionsText.toLowerCase().contains(expectedValue.toLowerCase()));
    }

    @Then("User will select the DocType on Approval Group Listing screen")
    public void select_doc_type(List<String> orgType){
        approvalgroupPageObject.selectDocType(orgType);
    }

    @Then("User deletes the added user in the Approval Group")
    public void delete_user(){
        Assert.assertTrue(approvalgroupPageObject.getDeleteUserIcon().isDisplayed());
        approvalgroupPageObject.getDeleteUserIcon().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(approvalgroupPageObject.getNoRecordFound().waitUntilVisible().isDisplayed());
    }
    @Then("User validates the renaming at approval group update page")
    public void renaming_On_UpdatePage(){
        Assert.assertTrue(approvalgroupPageObject.getRename_UpdateScreen().waitUntilVisible().isDisplayed());
    }
    @Then("User clicks on Audit button for Approval Group")
    public void AuditButton_ApprovalGroup(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approvalgroupPageObject.getAuditButton());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", approvalgroupPageObject.getAuditButton().findElement(org.openqa.selenium.By.tagName("img")));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User Validates the Approval Group Audit history Screen")
    public void user_Validate_AG_OverrideScreen() {
        approvalgroupPageObject.getAG_HistoryScreen().withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approvalgroupPageObject.getAG_HistoryScreen());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(approvalgroupPageObject.getAG_HistoryScreen().isDisplayed());
    }
    @Then("User Validates the data on Approval Group Audit history Screen")
    public void user_Validate_all_Audit_HistoryData(DataTable table) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(approvalgroupPageObject.validateAuditHistoryData(table));
    }
    @Then("User Validates the approval group name in Track")
    public void user_Validate_approval_group_Name_In_Track(DataTable table) {
        Assert.assertTrue(approvalgroupPageObject.ValidateApprovalgrpNameInTrack(table));
    }
    @Then("User captures the number of rows")
    public void user_Captures_the_Audit_HistoryDataRows() {
        approvalgroupPageObject.CaptureNumberofRows();
    }
    @Then("User validates the the number of rows")
    public void user_validates_the_Audit_HistoryDataRows() {
        Assert.assertTrue(approvalgroupPageObject.ValidateNumberofRows());
    }
    @Then("User selects the status")
    public void user_selects_the_status(DataTable table) {
        approvalgroupPageObject.SelectDeletedStatus(table);
    }

    @Then("the {string} column should only contain {string} or {string} for the rows")
    public void verifyDeletedColumnStatus(String columnName, String expectedVal1, String expectedVal2) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        boolean isDataValid = approvalgroupPageObject.validateColumnValues(columnName, expectedVal1, expectedVal2);
        Assert.assertTrue("Validation failed: " + columnName + " column has unexpected values.", isDataValid);
    }
    @Then("User validates the delete message on the popup")
    public void validatedeleteMessage(){
        approvalgroupPageObject.validatedeleteMessage();
    }
    @Then("User redirects to approval group screen with no action performed")
    public void validatesApprovalGroupScreen(){
        approvalgroupPageObject.getApprovalGroupHeading().isDisplayed();
    }
    @Then("User validate error message upon failed deletion of approval group")
    public void validate_deleted_message() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        approvalgroupPageObject.getApprovalGroupDeletionWarning().isDisplayed();
    }
    @When("User searches for Approval group name in the search bar")
    public void user_searches_for_approval_group_name_in_the_search_bar(DataTable groupname){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        approvalgroupPageObject.checkSearchBarAndEnterValue(groupname);
    }
    @Then("User validates the status dropdown values")
    public void user_validates_status_dropdown_values() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        approvalgroupPageObject.validateStatusDropdownValues();
    }
    @Then("User clicks on Delete icon for Approval Group")
    public void user_clicks_on_delete_icon_for_approval_group() {
        String searchedGroup = getDriver().findElement(org.openqa.selenium.By.xpath("//input[@placeholder='Search by group name']")).getAttribute("value").trim();
        org.openqa.selenium.WebElement deleteIcon = getDriver().findElement(org.openqa.selenium.By.xpath(String.format("(//tr[td[starts-with(normalize-space(), '%s')]]//div[@class='cross-icon delete'])[1]", searchedGroup)));
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deleteIcon);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", deleteIcon);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
}