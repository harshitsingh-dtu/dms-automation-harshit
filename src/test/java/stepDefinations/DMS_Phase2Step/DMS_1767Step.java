package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1570PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1767PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_1767Step extends PageObject {

    DMS_1767PageObject DMS1767RequestsDocumentCreationPageObject;

    DMS_1570PageObject DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject;

    @And("User will be able to remove the roles if assigned")
    public void User_will_be_able_to_remove_the_roles_if_assigned(List<String> roles){
        DMS1767RequestsDocumentCreationPageObject.removeRole(roles);
    }
    @Then("Check if above combination is present or not if present then remove it")
    public void Check_if_above_combination_is_present_or_not_if_present_then_remove_it(DataTable table){
        DMS1767RequestsDocumentCreationPageObject.checkCombination_present(table);
    }
    @When("User will input LEI Org type and Doc type mapping and click add")
    public void User_will_input_LEI_Org_type_and_Doc_type_mapping_and_click_add(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.docType(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.select_LEI(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.selectOrgType(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.click_Add_btn();
    }
    @And("Clicks on submit button")
    public void Clicks_on_submit_button(){
        if (DMS1767RequestsDocumentCreationPageObject.getSubmit_btn().isEnabled()){
            DMS1767RequestsDocumentCreationPageObject.getSubmit_btn().click();
        }
    }
    @Then("User should be able to see update message")
    public void User_should_be_able_to_see_update_message(){
        Assert.assertEquals("Updated Successfully", DMS1767RequestsDocumentCreationPageObject.getCheckNotification_Updated().getText().trim());
        log.info("Updated message is visible");
        withAction().pause(Duration.ofSeconds(8)).build().perform();
    }
    @Then("Request Document Creation button should be visible")
    public void Request_Document_Creation_button_should_be_visible(){
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getRequestDocumentCreation_btn().isVisible());
        log.info("Request Document Creation button is visible");
    }
    @When("User will click on Request Document Creation button")
    public void User_will_click_on_Request_Document_Creation_button(){
        DMS1767RequestsDocumentCreationPageObject.getRequestDocumentCreation_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @And("User will click on Doc type filter")
    public void User_will_click_on_Doc_type_filter(){
        DMS1767RequestsDocumentCreationPageObject.getSelect_docType().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User should be able to see only 4 Way in dropdown")
    public void User_should_be_able_to_see_only_4_Way_in_dropdown(){
        Assert.assertFalse(DMS1767RequestsDocumentCreationPageObject.getDN_text().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getFourWay_text().isVisible());
        Assert.assertEquals("4 Way", DMS1767RequestsDocumentCreationPageObject.getFourWay_text().getText().trim());
        log.info("Only 4 Way is visible");
    }
    @Then("User should be able to see corresponding information on Request Document Creation screen")
    public void User_should_be_able_to_see_corresponding_information_on_Request_Document_Creation_screen(){
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getSelect_docType().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getActingAs_dropdown().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getAllowedCurrencies_text().isDisplayed());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getAllowedCurrencies_checkbox().isPresent());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getDiscard_btn().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().isVisible());
        log.info("All corresponding information is visible on Request Document Creation screen");
    }
    @Then("User should be able to see only DN in dropdown")
    public void User_should_be_able_to_see_only_DN_in_dropdown(){
        Assert.assertFalse(DMS1767RequestsDocumentCreationPageObject.getFourWay_text().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getDN_text().isVisible());
        Assert.assertEquals("DN", DMS1767RequestsDocumentCreationPageObject.getDN_text().getText().trim());
        log.info("Only DN is visible");
    }
    @Then("User will be able to input Doc type on Request Document Creation screen")
    public void User_will_be_able_to_input_Doc_type_on_Request_Document_Creation_screen(DataTable table){
        DMS1767RequestsDocumentCreationPageObject.enter_docType(table);
    }
    @And("User will be able to input Acting As on Request Document Creation screen")
    public void User_will_be_able_to_input_Acting_As_on_Request_Document_Creation_screen(){
        DMS1767RequestsDocumentCreationPageObject.enter_actingAs();
    }
    @And("User will select the parties on Request Document Creation screen and click submit request")
    public void User_will_select_the_parties_on_Request_Document_Creation_screen_and_click_submit_request(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterPrimeBroker1(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.randomEnterClient1();
        DMS1767RequestsDocumentCreationPageObject.randomEnterPrimeBroker2();
        DMS1767RequestsDocumentCreationPageObject.randomEnterClient2();
        DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().waitUntilEnabled();
        DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @And("User will select the parties for DN on Request Document Creation screen and click submit request")
    public void User_will_select_the_parties_for_DN_on_Request_Document_Creation_screen_and_click_submit_request(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterPrimeBroker1(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.randomEnterExecutingBroker1();
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.randomEnterClient1();
        DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().waitUntilEnabled();
        DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("User should be able to see the popup on Request Document Creation screen")
    public void User_should_be_able_to_see_the_popup_on_Request_Document_Creation_screen(){
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getPopup_alert().isVisible());
    }
    @When("User will select the reviewer and click submit")
    public void User_will_select_the_reviewer_and_click_submit(){
        DMS1767RequestsDocumentCreationPageObject.select_Reviewer();
        DMS1767RequestsDocumentCreationPageObject.getSubmit_btn().waitUntilEnabled();
        DMS1767RequestsDocumentCreationPageObject.getSubmit_btn().click();
        withAction().pause(Duration.ofSeconds(15)).build().perform();
    }
    @Then("User should be able to see message request for document creation")
    public void User_should_be_able_to_see_message_request_for_document_creation(){
        DMS1767RequestsDocumentCreationPageObject.getMessageRequest_documentCreation().waitUntilVisible();
        Assert.assertEquals("Your request for document creation has been submitted successfully.", DMS1767RequestsDocumentCreationPageObject.getMessageRequest_documentCreation().getText().trim());
        log.info("Message request for document creation is visible");
    }
    @And("User will click on Got it button and redirected to the access request listing screen")
    public void User_will_click_on_Got_it_button_and_redirected_to_the_access_request_listing_screen(){
       DMS1767RequestsDocumentCreationPageObject.getGotIt_btn().click();
       withAction().pause(Duration.ofSeconds(6)).build().perform();
       Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getDocumentAccessRequest().isVisible());
       log.info("Redirected to Document access request screen");
    }
    @And("User will click on Acting As and corresponding result should be visible")
    public void User_will_click_on_Acting_As_and_corresponding_result_should_be_visible(){
        DMS1767RequestsDocumentCreationPageObject.getActingAs_dropdown().waitUntilClickable();
        DMS1767RequestsDocumentCreationPageObject.getActingAs_dropdown().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getClient_text().isVisible());
    }
    @Then("User will be able to validate all the elements present on the popup screen")
    public void User_will_be_able_to_validate_all_the_elements_present_on_the_popup_screen(){
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getPopup_alert().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getDefineReviewer_text().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getSelectReviewer_text().isVisible());
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getSelect_Reviewer().isVisible());
        log.info("All elements are visible on the popup screen");
    }
    @Then("User will click on Create new document")
    public void User_will_click_on_Create_new_document(){
        DMS1767RequestsDocumentCreationPageObject.getCreate_NewDocument().waitUntilVisible();
        DMS1767RequestsDocumentCreationPageObject.getCreate_NewDocument().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @Then("User will be able to input Doc type on Request Document Creation screen and request to create new document would be visible")
    public void User_will_be_able_to_input_Doc_type_on_Request_Document_Creation_screen_and_request_to_create_new_document_would_be_visible(DataTable table){
        DMS1767RequestsDocumentCreationPageObject.enter_docType(table);
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getRequestCreateNewDocument_text().isVisible());
    }
    @Then("User will be able to input Doc type on create new document screen")
    public void User_will_be_able_to_input_Doc_type_on_create_new_document_screen(DataTable table){
        DMS1767RequestsDocumentCreationPageObject.enter_docType(table);
    }
    @And("User will select the parties on create new document screen")
    public void User_will_select_the_parties_on_create_new_document_screen_and_click_submit_request(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterPrimeBroker1(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.randomEnterClient1();
        DMS1767RequestsDocumentCreationPageObject.randomEnterPrimeBroker2();
        DMS1767RequestsDocumentCreationPageObject.randomEnterClient2();
    }
    @And("User will be able to see request to create new document text")
    public void User_will_be_able_to_see_request_to_create_new_document_text(){
        Assert.assertTrue(DMS1767RequestsDocumentCreationPageObject.getRequestCreateNewDocument_text().isVisible());
    }
    @And("User will select the parties for 4 Way on request create document screen and click submit request")
    public void User_will_select_the_parties_for_4_Way_on_request_create_document_screen_and_click_submit_request(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterPrimeBroker1(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.randomEnterClient1();
        DMS1767RequestsDocumentCreationPageObject.clickSelectPartiesAsPB2(table);
        DMS1767RequestsDocumentCreationPageObject.randomEnterClient2();
        DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().waitUntilEnabled();
        DMS1767RequestsDocumentCreationPageObject.getSubmitRequest_btn().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @When("User will input reviewer and click submit")
    public void User_will_input_reviewer_and_click_submit(DataTable table){
        DMS1767RequestsDocumentCreationPageObject.input_Reviewer(table);
        DMS1767RequestsDocumentCreationPageObject.getSubmit_btn().waitUntilEnabled();
        DMS1767RequestsDocumentCreationPageObject.getSubmit_btn().click();
        withAction().pause(Duration.ofSeconds(15)).build().perform();
    }
    @And("User will input Acting As on Request Document Creation screen")
    public void User_will_input_Acting_As_on_Request_Document_Creation_screen(DataTable table){
        DMS1767RequestsDocumentCreationPageObject.input_actingAs(table);
    }
}
