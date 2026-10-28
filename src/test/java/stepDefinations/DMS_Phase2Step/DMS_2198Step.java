package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_2198PageObject;
import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.QueryBuilder.QueryBuilderColumnsPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2198Step extends PageObject {

    DMS_2198PageObject dms2198PageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    DocumentPageObject documentPageObject;

    @Given("User is on USP Rider Template screen")
    public void User_is_on_USP_Rider_Template_screen() {
        dms2198PageObject.navigateToUSPRiderTemplateScreen();
    }

    @When("User is redirected to USP Rider Template listing screen")
    public void User_is_redirected_to_USP_Rider_Template_listing_screen() {
        Assert.assertTrue(dms2198PageObject.getUSPRiderTemplate_screen().isVisible());
        log.info("Redirected to USP Rider Template listing screen");
    }

    @And("Clicks on Create New Template button")
    public void Clicks_on_Create_New_Template_button() {
        dms2198PageObject.getCreateNewTemplate_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("User should be redirected to create new USP Rider Template screen")
    public void User_should_be_redirected_to_create_new_USP_Rider_Template_screen() {
        Assert.assertTrue(dms2198PageObject.getCreateNewUSPTemplate_screen().isVisible());
        log.info("Redirected to Create new USP Rider Template screen");
    }

    @Then("Corresponding information should be visible on create new USP Template screen")
    public void Corresponding_information_should_be_visible_on_create_new_USP_Template_screen() {
        dms2198PageObject.getCreateNewUSPTemplate_screen().waitUntilVisible();
        Assert.assertTrue(dms2198PageObject.getCreateDocType_dropdown().isVisible());
        Assert.assertTrue(dms2198PageObject.getSelectUSPPB().isVisible());
        Assert.assertTrue(dms2198PageObject.getSelectUSP_Client().isVisible());
        Assert.assertTrue(dms2198PageObject.getEnterPBContact().isVisible());
        Assert.assertTrue(dms2198PageObject.getWordClause_checkbox().isVisible());
        Assert.assertTrue(dms2198PageObject.getFirstColumn_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getSearchAndAddFund().isVisible());
        Assert.assertTrue(dms2198PageObject.getSecondColumn_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getSecondColumn_radioBlock().isVisible());
        Assert.assertTrue(dms2198PageObject.getThirdColumn_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getFirstSubColumn_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getFirstSubColumn_radioBlock().isVisible());
        Assert.assertTrue(dms2198PageObject.getSecondSubColumn_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getSecondSubColumn_radioBlock().isVisible());
        Assert.assertTrue(dms2198PageObject.getAdditionalRelief_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getAdditionalRelief_radioBlock().isVisible());
        Assert.assertTrue(dms2198PageObject.getCancel_btn().isVisible());
        Assert.assertTrue(dms2198PageObject.getSubmit_btn().isVisible());
        log.info("All corresponding information is visible on create new USP Template screen");
    }

    @When("User will click on select doc type dropdown")
    public void User_will_click_on_select_doc_type_dropdown() {
        dms2198PageObject.getDocType_dropdown().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("Corresponding data should be visible in the doc type dropdown")
    public void Corresponding_data_should_be_visible_in_the_doc_type_dropdown() {
        Assert.assertTrue(dms2198PageObject.getFourWay_text().isVisible());
        Assert.assertTrue(dms2198PageObject.getDN_text().isVisible());
        log.info("Both 4 Way and DN are visible in the dropdown");
    }

    @And("User will be able to select both doc types simultaneously in the dropdown")
    public void User_will_be_able_to_select_both_doc_types_simultaneously_in_the_dropdown() {
        dms2198PageObject.checkMultiselect_docType();
    }

    @Then("User will be able to enter doc type and check selection")
    public void User_will_be_able_to_enter_doc_type_and_check_selection(List<String> docType) {
        dms2198PageObject.check_docTypeDropdown(docType);
    }

    @When("User will click on search and add fund dropdown")
    public void User_will_click_on_search_and_add_fund_dropdown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", dms2198PageObject.getSearchAndAddFund());
        dms2198PageObject.getSearchAndAddFund().click();
    }

    @Then("Corresponding list of LEI or fund should be visible")
    public void Corresponding_list_of_LEI_or_fund_should_be_visible() {
        dms2198PageObject.validate_searchAndAddFund();
    }

    @When("User will enter LEI in search and add fund dropdown then corresponding results should be visible")
    public void User_will_enter_LEI_in_search_and_add_fund_dropdown_then_corresponding_results_should_be_visible(List<String> lei) {
        dms2198PageObject.select_searchAndAddFund(lei);
    }

    @And("User will Enter input in PB Contact field and Check field accept maximum 100 Character only")
    public void User_will_Enter_input_in_PB_Contact_field_and_Check_field_accept_maximum_100_Character_only() {
        dms2198PageObject.checkCharacterLengthOfPBContactField();
    }

    @When("User will click on PB dropdown")
    public void User_will_click_on_PB_dropdown() {
        dms2198PageObject.getSelectPrimeBroker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User will enter doc type in the dropdown")
    public void User_will_enter_doc_type_in_the_dropdown() {
        dms2198PageObject.selectDoc();
    }

    @Then("Corresponding data should be visible in the PB dropdown")
    public void Corresponding_data_should_be_visible_in_the_PB_dropdown() {
        dms2198PageObject.validate_PB_ClientDropdown();
    }

    @When("User will click on Client dropdown")
    public void User_will_click_on_Client_dropdown() {
        dms2198PageObject.getSelectClient().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("Corresponding data should be visible in the Client dropdown")
    public void Corresponding_data_should_be_visible_in_the_Client_dropdown() {
        dms2198PageObject.validate_PB_ClientDropdown();
    }

    @And("User will search LEI in PB dropdown and able to select searched LEI")
    public void User_will_search_LEI_in_PB_dropdown_and_able_to_select_searched_LEI(List<String> lei) {
        dms2198PageObject.searchLei_PBDropdown(lei);
    }

    @And("User will search LEI in Client dropdown and able to select searched LEI")
    public void User_will_search_LEI_in_Client_dropdown_and_able_to_select_searched_LEI(List<String> lei) {
        dms2198PageObject.searchLei_clientDropdown(lei);
    }

    @And("Option to include your own word clause should not be selected by default")
    public void Option_to_include_your_own_word_clause_should_not_be_selected_by_default() {
        Assert.assertTrue(dms2198PageObject.getTypeWordClause_field().getText().isEmpty());
        log.info("Option to include your own word clause is not selected by default");
    }

    @When("User clicks on checkbox of option to include your own word clause")
    public void User_clicks_on_checkbox_of_option_to_include_your_own_word_clause() {
        dms2198PageObject.getWordClause_checkbox().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("Text will be displayed in the TextBox of option to include your own word clause")
    public void Text_will_be_displayed_in_the_TextBox_of_option_to_include_your_own_word_clause() {
        Assert.assertFalse(dms2198PageObject.getTypeWordClause_field().getText().isEmpty());
        log.info("Text is displayed in the TextBox");
    }

    @And("When user deselects option to include your own word clause")
    public void When_user_deselects_option_to_include_your_own_word_clause() {
        dms2198PageObject.getWordClause_checkbox().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("Data should not reset and user should be able to edit word clause TextBox")
    public void Data_should_not_reset_and_user_should_be_able_to_edit_word_clause_TextBox() {
        Assert.assertFalse(dms2198PageObject.getTypeWordClause_field().getText().isEmpty());
        log.info("Existing Data didn't get reset");
        dms2198PageObject.edit_wordClauseTextBox();
    }

    @And("User will enter LEI in search and add fund")
    public void User_will_enter_LEI_in_search_and_add_fund(List<String> lei) {
        dms2198PageObject.enterSearchAddFund(lei);
    }

    @Then("User will select all YES options for PB counterparties added")
    public void User_will_select_all_YES_options_for_PB_counterparties_added() {
        dms2198PageObject.select_allYesOptions();
    }

    @And("Clicks on add icon in search and add fund")
    public void Clicks_on_add_icon_in_search_and_add_fund() {
        Assert.assertTrue(dms2198PageObject.getAdd_icon().isVisible());
        dms2198PageObject.getAdd_icon().click();
    }

    @Then("Again user will enter LEI in search and add fund")
    public void Again_user_will_enter_LEI_in_search_and_add_fund(List<String> lei) {
        dms2198PageObject.enterSearchAddFund2(lei);
    }

    @And("User will select all NO options for PB counterparties added")
    public void User_will_select_all_NO_options_for_PB_counterparties_added() {
        dms2198PageObject.select_allNOOptions();
    }

    @And("User will select random combination of YES and NO options")
    public void User_will_select_random_combination_of_YES_and_NO_options() {
        dms2198PageObject.select_randomCombinationYes_NO();
    }

    @When("User will enter non existing LEI in search and add fund dropdown")
    public void User_will_enter_non_existing_LEI_in_search_and_add_fund_dropdown(List<String> lei) {
        dms2198PageObject.enterNonExistingLEI(lei);
    }

    @Then("Add button should be visible")
    public void Add_button_should_be_visible() {
        Assert.assertTrue(dms2198PageObject.getAdd_button().isVisible());
        log.info("Add button is visible");
    }

    @And("User will be able to see add icon and clicks on add icon")
    public void User_will_be_able_to_see_add_icon_and_clicks_on_add_icon() {
        dms2198PageObject.getAdd_icon().click();
        Assert.assertTrue(dms2198PageObject.getAdd_icon().isVisible());
        Assert.assertTrue(dms2198PageObject.getDelete_icon().isVisible());
    }

    @And("User will click on delete icon in search and add fund")
    public void User_will_click_on_delete_icon_in_search_and_add_fund() {
        dms2198PageObject.getDelete_icon().click();
        log.info("PB counterparty is removed");
    }

    @And("User will select doc type on Create USP Template screen")
    public void User_will_select_doc_type_on_Create_USP_Template_screen() {
        dms2198PageObject.selectDoc();
    }

    @And("User will select random LEI in PB dropdown on Create USP Template screen")
    public void User_will_select_random_LEI_in_PB_dropdown_on_Create_USP_Template_screen() {
        dms2198PageObject.enterLEIPBDropdown();
    }

    @And("User will select random LEI in Client dropdown on Create USP Template screen")
    public void User_will_select_random_LEI_in_Client_dropdown_on_Create_USP_Template_screen() {
        dms2198PageObject.enterLEIClientDropdown();
    }

    @And("User will enter PB Contact on Create USP Template screen")
    public void User_will_enter_PB_Contact_on_Create_USP_Template_screen(List<String> contact) {
        dms2198PageObject.enterPBContact(contact);
    }

    @And("User will insert word clause on Create USP Template screen")
    public void User_will_insert_word_clause_on_Create_USP_Template_screen() {
        dms2198PageObject.getWordClause_checkbox().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @And("Clicks on Submit Button of Create USP Template screen")
    public void Clicks_on_Submit_Button_of_Create_USP_Template_screen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2198PageObject.getSubmit_btn().waitUntilEnabled();
        dms2198PageObject.getSubmit_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2198PageObject.getToastAlert_USPCreateScreen().isVisible());
    }

    @Then("User should be redirected to USP Rider Template listing screen and success message of creation should be visible")
    public void User_should_be_redirected_to_USP_Rider_Template_listing_screen_and_success_message_of_creation_should_be_visible() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (dms2198PageObject.getAlertPopup().isVisible()) {
            dms2198PageObject.getAlertPopup_NoBtn().click();
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2198PageObject.getUSPRiderTemplate_screen().isVisible());
        log.info("Redirected to USP Rider Template listing screen");
    }

    @And("Clicks on Discard Button of Create USP Template screen")
    public void Clicks_on_Discard_Button_of_Create_USP_Template_screen() {
        dms2198PageObject.getCancel_btn().waitUntilClickable();
        dms2198PageObject.getCancel_btn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("User should be redirected to USP Rider Template listing screen")
    public void User_should_be_redirected_to_USP_Rider_Template_listing_screen() {
        Assert.assertTrue(dms2198PageObject.getUSPRiderTemplate_screen().isVisible());
        log.info("Redirected to USP Rider Template listing screen");
    }

    @And("Clicks on Create New Template button and able to select doc type and select LEI for both PB and Client dropdown")
    public void Clicks_on_Create_New_Template_button_and_able_to_select_doc_type_and_select_LEI_for_both_PB_and_Client_dropdown() {
        dms2198PageObject.selectDocType_AndParties();
    }

    @Then("Error message should be displayed informing combination already exists")
    public void Error_message_should_be_displayed_informing_combination_already_exists() {
        Assert.assertTrue(dms2198PageObject.getToastAlert_USPCreateScreen().getText().trim().contains("USP Rider template already exists between"));
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        log.info("Error message is displayed informing combination already exists");
    }

    @Then("Create New Template button should not be visible on USP Rider Template listing screen")
    public void Create_New_Template_button_should_not_be_visible_on_USP_Rider_Template_listing_screen() {
        Assert.assertFalse(dms2198PageObject.getCreateNewTemplate_btn().isVisible());
        log.info("Create New Template button is not visible");
    }

    @And("User will select Doc type and org type under added LEI column and remove it")
    public void User_will_select_Doc_type_and_org_type_under_added_LEI_column_and_remove_it(DataTable table) {
        dms2198PageObject.selectDocType_OrgType(table);
    }

    @And("User will select org type under added LEI column and remove it")
    public void User_will_select_org_type_under_added_LEI_column_and_remove_it(DataTable table) {
        dms2198PageObject.selectOrgType_USPRider(table);
    }

    @Then("User will click on PB dropdown and corresponding result should be visible on Create USP Template screen")
    public void User_will_click_on_PB_dropdown_and_corresponding_result_should_be_visible_on_Create_USP_Template_screen() {
        dms2198PageObject.getSelectPrimeBroker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2198PageObject.getSearchedResult().isVisible());
    }

    @And("User will remove DN from doc type dropdown")
    public void User_will_remove_DN_from_doc_type_dropdown() {
        dms2198PageObject.getDocType_dropdown().click();
        dms2198PageObject.getClearIcon().click();
    }

    @And("Again User will be able to enter doc type on Create USP Template screen")
    public void Again_User_will_be_able_to_enter_doc_type_on_Create_USP_Template_screen(List<String> docType) {
        dms2198PageObject.check_docTypeDropdown(docType);
    }

    @Then("Again user will click on PB dropdown and no options should be visible")
    public void Again_user_will_click_on_PB_dropdown_and_no_options_should_be_visible() {
        dms2198PageObject.getSelectPrimeBroker().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2198PageObject.getNoOptionForDocType().isVisible());
        log.info("No Options is visible");
    }

    @And("user will select Column Values")
    public void user_will_select_Column_Values() {
        dms2198PageObject.filterAndSelectValues();

    }

    @And("User will select PB and client dropdown on Create USP Template screen")
    public void User_will_select_PB_and_client_dropdown_on_Create_USP_Template_screen(DataTable dataTable) {
        dms2198PageObject.enterPBDropdown(dataTable);
        dms2198PageObject.enterClientDropdown(dataTable);
    }

    @And("User Click on Update button")
    public void User_Click_on_Update_button() {
        dms2198PageObject.getUpdate_Button().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("User verify the content of USP rider")
    public void User_verify_the_content_of_USP_rider(DataTable table) {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2198PageObject.getEdit_USP_Rider().isVisible());
        Assert.assertTrue(dms2198PageObject.USPRiderWordClause());
        Assert.assertEquals(4, dms2198PageObject.getYes_Selected().size());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2198PageObject.validatecontact(table));
        Assert.assertTrue(dms2198PageObject.addedfund(table));
    }

    @And("user click on audit  icon")
    public void userClickOnAuditIcon() {
        dms2198PageObject.getAudit_Button().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User Validates the USP Rider Audit history Screen")
    public void userValidatesTheUSPRiderAuditHistoryScreen() {
        dms2198PageObject.getUspRiderScreen_Text().isVisible();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User Validates the data on USP Rider Audit history Screen")
    public void userValidatesTheDataOnUSPRiderAuditHistoryScreen(DataTable table) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms2198PageObject.validateUspRiderAuditHistoryData(table);
    }
}
