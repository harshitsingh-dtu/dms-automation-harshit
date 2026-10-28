package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1615PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class DMS_1615Step extends PageObject{

    DMS_1615PageObject dms1615_PageObject;



    @And("User Click on Bulk Action Button")
    public void User_Click_on_Bulk_Action_Button(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1615_PageObject.getBulkActionButton().isVisible());
        dms1615_PageObject.getBulkActionButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1615_PageObject.getSelectBulkActionBelowText().isVisible());
    }

    @And("User is not able to see Approve Button")
    public void User_is_not_able_to_see_Approve_Button(){
        Assert.assertFalse(dms1615_PageObject.getApprovebutton().isVisible());
    }

    @And("User is not able to see Reject Button")
    public void User_is_not_able_to_see_Reject_Button(){
        Assert.assertFalse(dms1615_PageObject.getRejectbutton().isVisible());
    }

    @And("User is able to see Approve and Reject Button")
    public void User_is_able_to_see_Approve_and_Reject_Button(){
        Assert.assertTrue(dms1615_PageObject.getApprovebutton().isVisible());
        Assert.assertTrue(dms1615_PageObject.getRejectbutton().isVisible());
    }

    @And("User is not able to see Terminate Button")
    public void User_is_not_able_to_see_Terminate_Button(){
        Assert.assertFalse(dms1615_PageObject.getTerminatebutton().isVisible());
    }

    @And("User is not able to see Edit Button")
    public void User_is_not_able_to_see_Edit_Button(){
        Assert.assertFalse(dms1615_PageObject.getEditbutton().isVisible());
    }

    @And("User is able to see Terminate and Edit Button")
    public void User_is_able_to_see_Terminate_and_Edit_Button(){
        Assert.assertTrue(dms1615_PageObject.getTerminatebutton().isVisible());
        Assert.assertTrue(dms1615_PageObject.getEditbutton().isVisible());
    }

    @And("User will Click on any Bulk Action like Approve, Reject and able to Document action Popup")
    public void User_will_Click_on_any_Bulk_Action_like_Approve_Reject_and_able_to_Document_action_Popup(){
        Assert.assertTrue(dms1615_PageObject.getApprovebutton().isVisible());
        dms1615_PageObject.getApprovebutton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User will click on the document type dropdown and should only see 'DN' inside the dropdown")
    public void User_will_click_on_the_document_type_dropdown_and_should_only_see_DN_inside_the_dropdown(){
        Assert.assertTrue(dms1615_PageObject.getDoctypeDropdown().isVisible());
        dms1615_PageObject.getDoctypeDropdown().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1615_PageObject.getDNdoctypefromdropdown().isVisible());
        Assert.assertFalse(dms1615_PageObject.getFourWaydoctypefromdropdown().isVisible());
    }

    @And("User will click on the document type dropdown and should only see '4 Way' inside the dropdown")
    public void User_will_click_on_the_document_type_dropdown_and_should_only_see_4way_inside_the_dropdown(){
        Assert.assertTrue(dms1615_PageObject.getDoctypeDropdown().isVisible());
        dms1615_PageObject.getDoctypeDropdown().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertFalse(dms1615_PageObject.getDNdoctypefromdropdown().isVisible());
        Assert.assertTrue(dms1615_PageObject.getFourWaydoctypefromdropdown().isVisible());
    }

    @And("User is able to see permission error message when select '4 Way' doctype from Doc type Dropdown")
    public void User_is_able_to_see_permission_error_message_when_select_4Waydoctype_from_Doc_type_Dropdown(DataTable dataTable){
        dms1615_PageObject.CheckErrorMEssagefor4wayDoctype(dataTable);
    }

    @And("User is able to see permission error message when select 'DN' doctype from Doc type Dropdown")
    public void User_is_able_to_see_permission_error_message_when_select_DNdoctype_from_Doc_type_Dropdown(DataTable dataTable){
        dms1615_PageObject.CheckErrorMEssageforDNDoctype(dataTable);
    }
    @Then("User click on Sync to CreditLink button")
    public void User_clicks_CLSync_Button(){
        dms1615_PageObject.getSyncToCLButton().click();
    }
    @Then("User validates the data on listing screen")
    public void validate_data_on_listing_screen() {
        dms1615_PageObject.validateDataOnListingScreen();
    }

}
