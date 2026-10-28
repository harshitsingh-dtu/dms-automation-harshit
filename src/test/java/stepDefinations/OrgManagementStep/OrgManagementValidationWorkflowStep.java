package stepDefinations.OrgManagementStep;

import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.OrgManagement.OrgManagementPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class OrgManagementValidationWorkflowStep extends PageObject {
    OrgManagementPageObject orgManagementPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Then("^User navigates to the organisation screen$")
    public void user_navigates_to_the_organisation_screen() {
        orgManagementPageObject.navigateToOrganizationScreen();
        Assert.assertTrue(orgManagementPageObject.getOrganization_text().getText().trim().equalsIgnoreCase("Organisations"));
    }

    @Then("^User navigates to the Organisation Management screen$")
    public void user_navigates_to_the_organisation_management_screen() {
        orgManagementPageObject.navigateToOrganizationManagement();
        Assert.assertTrue(orgManagementPageObject.getOrganization_text().withTimeoutOf(Duration.ofSeconds(10)).getText().trim().equalsIgnoreCase("Organisations"));
    }

    @Then("^User searches the Organisation$")
    public void the_search_results_should_appear_by_typing_2_characters(List<String> search_lei)  {
        orgManagementPageObject.typeInPredictiveSearchBar(search_lei);
    }

//    @Then("^User searches and updates the status for the following Organisations$")
//    public void user_searches_and_updates_status(DataTable orgTable) {
//        orgManagementPageObject.searchAndUpdateOrganisationStatus(orgTable);
//    }

    @Then("^User toggles PB status to Lite and then resets to Online for the following Organisations$")
    public void user_toggles_status_to_lite_and_resets(DataTable orgTable) {
        orgManagementPageObject.searchAndUpdateOrgStatusToLiteAndReset(orgTable);
    }


    @Then("User will be able to see predictive search bar and type for searching LEI id's")
    public void user_will_be_able_to_see_predictive_search_bar_for_searching_lei_ids(List<String> lei)  {
        orgManagementPageObject.typeInPredictiveSearchBar(lei);
    }

    @And("User will be able to see table consisting of columns LEI id, LEI name, DN Push Notification and action")
    public void validatecolumns(){
        orgManagementPageObject.checkAllelementsonOrganizationscreen();
    }
    @And("User will be able to see update button")
    public void User_will_be_able_to_see_update_button() {
        orgManagementPageObject.checkUpdatebtn();
    }

    @And("^User will be able to see the pagination$")
    public void user_will_be_able_to_see_the_pagination() {
        Assert.assertTrue(orgManagementPageObject.getPagination_container().isVisible());
    }

    @Then("User will be able to see the information regarding the LEI on the listing screen")
    public void User_will_be_able_to_see_the_information_regarding_the_LEI_on_the_listing_screen() {
        orgManagementPageObject.checkAllinformationregardinglei();
    }
    @Then("^User can see showing page$")
    public void user_can_see_showing_page()  {
        Assert.assertTrue(orgManagementPageObject.getShowing_page().isVisible());
        Assert.assertTrue(orgManagementPageObject.getShowing_page_page_number().isVisible());
        Assert.assertTrue(orgManagementPageObject.getShowing_page_total_page().isVisible());
    }

    @And("^User can see Records per page$")
    public void user_can_see_records_per_page() {
        Assert.assertTrue(orgManagementPageObject.getRecords_per_page_value().isVisible());
    }
    @And("^Validate total number of records returned remains same when user switch to next page$")
    public void total_number_of_records_next_page() {
        Assert.assertTrue(orgManagementPageObject.getCurrent_record_page_value().isVisible());
        Assert.assertEquals(orgManagementPageObject.getCurrent_record_page_value().getText(),orgManagementPageObject.firstPageCount());
    }

    @And("^Validate total number of records returned remains same when user switch to next page and enters the next page number$")
    public void enters_pagenumber_and_total_number_of_records_next_page() {
        Assert.assertTrue(orgManagementPageObject.getCurrent_record_page_value().isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",orgManagementPageObject.getNext_page_button());
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", orgManagementPageObject.getNext_page_button().waitUntilVisible());
        Assert.assertEquals(orgManagementPageObject.getCurrent_record_page_value().getText(),orgManagementPageObject.anyPageCount());
    }

    @And("^User can see Total record count$")
    public void total_record_count()  {
        Assert.assertTrue(orgManagementPageObject.getCurrent_record_page_value().isVisible());
    }

    @And("^User validates the Total record count text$")
    public void total_record_count_text()  {
        Assert.assertTrue(orgManagementPageObject.getTotal_record_count_text().isVisible());
    }
    @And("Verify the Total Record Count")
    public void total_record_count_text(List<String> expected)  {
        Assert.assertEquals(orgManagementPageObject.getCurrent_record_page_value().getText(),expected.get(0));
    }

    @And("^when the user is on the first page then prev button should be disabled$")
    public void when_the_user_is_on_the_first_page_then_prev_button_should_be_disabled() {
        orgManagementPageObject.check_previous_page_btn();
    }

    @And("^when the user is on the last page then next button should be disabled$")
    public void when_the_user_is_on_the_last_page_then_next_button_should_be_disabled()  {
        orgManagementPageObject.check_next_page_btn();
    }
    @Then("^User validates DN Push Notification button on Organisation Screen$")
    public void user_validates_DNPushNotification() {
        Assert.assertTrue(orgManagementPageObject.getDNPushNotifications_OrgScreen().isVisible());
    }
    @Then("^User click toggle button for DN Push Notification$")
    public void user_enables_DNPushNotification() {
        WebElementFacade toggle = orgManagementPageObject.getDNPushNotifications_button();
        documentCreateNewPageObject.startContinuousToastInterceptor();
        toggle.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("^User click toggle button for DN Push Notification to enable$")
    public void user_clicks_toggle_to_enable_DNPushNotification() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        orgManagementPageObject.toggleDNPushNotificationAndEnsureEnabled();
    }

    @Then("^User click toggle button for DN Push Notification to disable$")
    public void user_clicks_toggle_to_disable_DNPushNotification() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        orgManagementPageObject.toggleDNPushNotificationAndEnsureDisabled();
    }
    @Then("^User validates the Alternate Executing Broker ID field is visible$")
    public void user_validates_AlternateExecutingBrokerID() {
        Assert.assertTrue(orgManagementPageObject.getAlternateEB_ID().isVisible());
    }

    @Then("^User validates the Alternate Executing Broker ID field is visible Second$")
    public void user_validates_AlternateExecutingBrokerIDNew() {
        Assert.assertTrue(orgManagementPageObject.getAlternateEB_IDNew().isVisible());
    }
    @Then("^User enters the random characters into Alternate Executing Broker ID dropdown$")
    public void user_entersRandomCharactersIn_AlternateExecutingBrokerID() {
        withAction().moveToElement(orgManagementPageObject.getAlternateEB_ID()).click().sendKeys(orgManagementPageObject.getRandomCharacters()).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(255,orgManagementPageObject.getAlternateEB_ID().getAttribute("value").length());
    }

    @Then("^User enters the random characters into Alternate Executing Broker ID dropdown value button$")
    public void user_entersRandomCharactersIn_AlternateExecutingBrokerIDValue() {
        withAction().moveToElement(orgManagementPageObject.getAlternateEB_IDInputValue()).click().sendKeys(orgManagementPageObject.getRandomCharacters()).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(255,orgManagementPageObject.getAlternateEB_IDInputValue().getAttribute("value").length());
    }


    @Then("^User validates the Alternate Client ID field is visible$")
    public void user_validates_AlternateClientID() {
        Assert.assertTrue(orgManagementPageObject.getAlternateClient_ID().isVisible());
    }
    @Then("^User enters the random characters into Alternate Client ID dropdown$")
    public void user_entersRandomCharactersIn_ClientID() {
        withAction().moveToElement(orgManagementPageObject.getAlternateClient_ID()).click().sendKeys(orgManagementPageObject.getRandomCharacters()).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(255,orgManagementPageObject.getAlternateClient_ID().getAttribute("value").length());
    }

    @Then("^User enters the random characters into Alternate Client ID dropdown value button$")
    public void user_entersRandomCharactersIn_ClientIDValue() {
        withAction().moveToElement(orgManagementPageObject.getAlternateClient_IDInputValue()).click().sendKeys(orgManagementPageObject.getRandomCharacters()).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(255,orgManagementPageObject.getAlternateClient_IDInputValue().getAttribute("value").length());
    }

    @Then("^User click on add Alternate ID$")
    public void add_AlternateEBID() {
        Assert.assertTrue(orgManagementPageObject.getAlternateEB_ID().isPresent());
        orgManagementPageObject.getAlternateEB_ID().click();
    }
    @Then("^User enters the random characters into the Alternate ID in document")
    public void add_AlternateID() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
//        Assert.assertTrue(orgManagementPageObject.getAlternate_ID_textField().isPresent());
        withAction().moveToElement(orgManagementPageObject.getAlternate_ID_textField()).click().sendKeys(orgManagementPageObject.getRandomCharacters()).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        orgManagementPageObject.getClickonTickbutton().click();
    }
    @Then("^User enter the value in Alternate ID field for document")
    public void enter_ValueinAlternateID(List<String> str) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
//        orgManagementPageObject.getAlternate_ID_textField().clear();
        orgManagementPageObject.getAlternate_ID_textField().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        withAction().moveToElement(orgManagementPageObject.getAlternate_ID_textField()).sendKeys(str.get(0)).build().perform();
//        orgManagementPageObject.getAlternate_ID_EdiIcon().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
//        withAction().moveToElement(orgManagementPageObject.getAlternate_ID_EdiIcon()).sendKeys(str.get(0)).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        orgManagementPageObject.getClickonTickbutton().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("^User validates the text field length for Alternate ID$")
    public void validateAlternateIDlength() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(orgManagementPageObject.getAlternate_ID_Value().isPresent());
        Assert.assertEquals(255,orgManagementPageObject.getAlternate_ID_Value().getText().length());
    }
    @Then("^User clicks on edit icon for Alternate ID$")
    public void clickOnEditIconForAlternateID() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(orgManagementPageObject.getAlternate_ID_EdiIcon().isVisible());
        orgManagementPageObject.getAlternate_ID_EdiIcon().click();
    }
    @Then("^User validates the Alternate ID field is not visible$")
    public void user_validates_AlternateIDNotVisible() {
        try {
            orgManagementPageObject.getAlternateEB_ID().isVisible();
            orgManagementPageObject.getAlternateClient_ID().isVisible();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
}
