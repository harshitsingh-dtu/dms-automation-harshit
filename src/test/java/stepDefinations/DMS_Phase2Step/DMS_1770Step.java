package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1570PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1770PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;

import java.time.Duration;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data

public class DMS_1770Step extends PageObject {

    DMS_1770PageObject DMS1770RequestsNotificationSystem;

    DMS_1570PageObject DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject;

    @And("User will select the parties for DN on request create document screen and click submit request")
    public void User_will_select_the_parties_for_DN_on_request_create_document_screen_and_click_submit_request(DataTable table){
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.EnterPrimeBroker1(table);
        DMS1770RequestsNotificationSystem.EnterExecutingBroker1(table);
        DMS1570AsauserIshouldbeabletoreceivenotificationsaspernewDocTypePageObject.randomEnterClient1();
        DMS1770RequestsNotificationSystem.getSubmitRequest_btn().waitUntilEnabled();
        DMS1770RequestsNotificationSystem.getSubmitRequest_btn().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("Check if User will be able to see notification in the dialogue box for request to create document")
    public void Check_if_User_will_be_able_to_see_notification_in_the_dialogue_box_for_request_to_create_document(){
        DMS1770RequestsNotificationSystem.notificationRequestCreateDocument_dialogueBox();
    }
}
