package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1928PageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1928Step extends PageObject {
    DocumentPageObject documentPageObject;
    DMS_1928PageObject dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject;


    @And("User is on the Approval Access Request screen")
    public void User_is_on_the_Approval_Access_Request_screen(){
        documentPageObject.clickMenuButton();
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.NavigateToApprovalAccessRequestTab();
    }

    @When("user will search for Request ID and able to get respective Result")
    public void user_will_search_for_Request_ID_and_able_to_get_respective_Result(List<String> RequestID){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.SearchForRequestID(RequestID);
    }
    @Then("User will Click on View Details Button and should be Redirected to Approval Access Request Screen")
    public void User_will_Click_on_View_Details_Button_and_should_be_Redirected_to_Approval_Access_Request_Screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getViewDetailsButton().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getViewDetailsButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDetailsofapprovalrequest_Text().isVisible());
    }

    @Then("User will Click on View Details Button and should be Redirected to Documents Access Request Screen")
    public void User_will_Click_on_View_Details_Button_and_should_be_Redirected_to_Documents_Access_Request_Screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getViewDetailsButton().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getViewDetailsButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDetailsofAccessRequest_text().isVisible());
    }



    @And("Click on respective button redirected to another screen")
    public void Click_on_respective_button_redirected_to_another_screen(){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.ClickonRespectivebutton();
    }


    @And("User is able to see all the Information")
    public void User_is_able_to_see_all_the_Information(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDetailsofapprovalrequest_Text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getStatus_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedID_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedtype_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDoctype_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedby_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedon_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestdocumentdetails_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDocumenttype_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getActingas_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getAllowedcurrencies_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getSelectparties_text().isVisible());
    }

    @Then("user Will check the information According to Status")
    public void user_Will_check_the_information_According_to_Status(){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.Validateinformation();
    }

    @And("User will Enter Status and able to see ApproveReject button under Action Column")
    public void User_will_Enter_Status_and_able_to_see_ApproveReject_button_under_Action_Column(List<String> Status){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.SelectStatusAndValidatetheButton(Status);
    }
    @And("User will Enter Status and able to see View button under Action Column")
    public void User_will_Enter_Status_and_able_to_see_View_button_under_Action_Column(List<String> Status){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.SelectStatusAndValidatetheButton(Status);
    }
    @And("User will Enter Status")
    public void User_will_Enter_Status(List<String> Status){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.SelectStatus(Status);
    }

    @And("User is able to see all the Information on access request screen")
    public void User_is_able_to_see_all_the_Information_on_access_request_screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDetailsofAccessRequest_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getStatus_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedID_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedtype_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDoctype_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedby_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestedon_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRequestdocumentdetails_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDocumenttype_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getActingas_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getAllowedcurrencies_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getSelectparties_text().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getClosebutton().isVisible());
    }

    @Then("Click on view Button and redirected to Details of access request screen")
    public void Click_on_view_Button_and_redirected_to_Details_of_access_request_screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getViewDetailsButton().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getViewDetailsButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDetailsofAccessRequest_text().isVisible());
    }

    @And("User will Click on ApproveReject button and redirected to Details of approval request screen")
    public void User_will_Click_on_ApproveReject_button_and_redirected_to_Details_of_approval_request_screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getApproveRejectButton().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getApproveRejectButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getDetailsofapprovalrequest_Text().isVisible());
    }
    @Then("User will click on approve button and get success message then redirected to Approval Access request Screen")
    public void User_will_click_on_approve_button_and_get_success_message_then_redirected_to_Approval_Access_request_Screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getApproveButton().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getApproveButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getMessageforUpdateStatus().waitUntilVisible();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getMessageforUpdateStatus().getText().contains("Document request status updated"));
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getApprovalAccessRequest_text().isVisible());
    }

    @Then("User will approve Request with Success message then validate Approved Status for approved document")
    public void User_will_approve_Document_with_Success_message_then_validate_Approved_Status_for_approved_document(){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.RequestAppproved_Successfully();
    }

    @Then("User will Reject Request with Success message then validate Rejected Status for approved document")
    public void User_will_approve_Document_with_Success_message_then_validate_Rejected_Status_for_approved_document(){
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.RequestReject_Successfully();
    }



    @Then("User will click on Reject button and get success message then redirected to Approval Access request Screen")
    public void User_will_click_on_Reject_button_and_get_success_message_then_redirected_to_Approval_Access_request_Screen(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRejectButton().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRejectButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getMessageforUpdateStatus().getText().contains("Document request status updated"));
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getApprovalAccessRequest_text().isVisible());
    }

//    @And("User will search for the Request ID that has just been Rejected and able to see status as Rejected")
//    public void User_will_search_for_the_Request_ID_that_has_just_been_Rejected_and_able_to_see_status_as_Rejected(List<String> RequestID){
//        withAction().pause(Duration.ofSeconds(2)).build().perform();
//        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.CheckRejectedStatusForRequestID(RequestID);
//    }







    @And("User will click on Record Per page Dropdown and able to see Perpage count option")
    public void User_will_click_on_Record_Per_page_Dropdown_and_able_to_see_Perpage_count_option(){
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRecords_per_page_value().isVisible());
        dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getRecords_per_page_value().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getOnezerorecordperpage().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getTwofiverecordperpage().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getFivezerorecordperpage().isVisible());
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getOnezerozerorecordperpage().isVisible());
    }

}
