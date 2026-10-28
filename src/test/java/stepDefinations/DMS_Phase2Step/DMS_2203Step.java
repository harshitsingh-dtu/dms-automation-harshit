package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.*;
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

public class DMS_2203Step extends PageObject {

    DMS_2203PageObject dms_2203PageObject;
    DMS_1707PageObject dms1707PageObject;
    DMS_2199PageObject dms2199pageobject;
    DMS_1528PageObject dms1528PageObject;


    @Then("User will search for USP Rider column and able to see inside the filter")
    public void User_will_search_for_USP_Rider_column_and_able_to_see_inside_the_filter(List<String> filters){
        dms_2203PageObject.ChecktheVisibilityofColumnInsidetheColumnSelection(filters);

    }

    @Then("User will search for USP Rider column and able to select and deselect for checkbox")
    public void User_will_search_for_USP_Rider_column_and_able_to_select_and_deselect_for_checkbox(List<String> filters){
        dms_2203PageObject.SelectandDeselectcheckbox(filters);
    }

    @Then("User will search for USP Rider column and able to apply and able to see applied column on Listing Screen")
    public void User_will_search_for_USP_Rider_column_and_able_to_apply_and_able_to_see_applied_column_on_Listing_Screen(List<String> filters){
        dms_2203PageObject.ApplyforSearchedColumn(filters);
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms1707PageObject.CheckFilterOnListingScreen(filters);
    }

    @And("User will enter data in USP Rider filter able to see correspondence filtered result")
    public void User_will_enter_data_in_USP_Rider_filter_able_to_see_correspondence_filtered_result(List<String> filters){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms_2203PageObject.CheckfilteredUSPRider(filters);
    }

    @Then("User will enter data in USP Rider filter on Document Listing screen")
    public void User_will_enter_data_in_USP_Rider_filter_on_document_ListingScreen(DataTable dataTable){
        dms_2203PageObject.SelectinputforUSPRiderFilter(dataTable);
    }
    @Then("User will click on Document version id and able to see Document Preview screen")
    public void User_will_click_on_Document_version_id_and_able_to_see_Document_Preview_screen(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        withAction().moveToElement(dms_2203PageObject.getFirst_DocumentVersion()).click().pause(Duration.ofSeconds(2)).build().perform();
//        dms_2203PageObject.getFirst_DocumentVersion().click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getDocumentPreview_text().isVisible());
    }

    @And("User will able to see prominent Message and View button")
    public void User_will_able_to_see_prominent_Message_and_View_button(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getProminent_Message_ON_DocumentPreviewScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getViewButton_on_DocumentPreviewScreen().isVisible());
    }

    @When("User will select Document Status filter other than Enforced and Draft")
    public void User_will_select_Document_Status_filter_other_than_Enforced_and_Draft(){
        dms_2203PageObject.RandomSelectDocumentStatus();
    }

    @And("User will not be able to see prominent Message and View button")
    public void User_will_not_be_able_to_see_prominent_Message_and_View_button(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertFalse(dms_2203PageObject.getProminent_Message_ON_DocumentPreviewScreen().isVisible());
        Assert.assertFalse(dms_2203PageObject.getViewButton_on_DocumentPreviewScreen().isVisible());
    }

    @Then("User navigate back to listing screen and Select NA for USP Rider filter")
    public void User_navigate_back_to_listing_screen_and_Select_NA_for_USP_Rider_filter(DataTable dataTable){
        dms_2203PageObject.getCloseButton_on_DocumentPreviewScreen().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms_2203PageObject.SelectinputforUSPRiderFilter(dataTable);
    }

    @And("User will Click on View button and able to see respective information on Comparision window")
    public void User_will_Click_on_View_button_and_able_to_see_respective_information_on_Comparision_window(){
        Assert.assertTrue(dms_2203PageObject.getViewButton_on_DocumentPreviewScreen().isVisible());
        dms_2203PageObject.getViewButton_on_DocumentPreviewScreen().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getVersionCompare_Screen_text().isVisible());
        Assert.assertTrue(dms_2203PageObject.getUSPRiderID_on_VersionCompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getCurrentVersion_window_on_VersionCompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getNewVersion_window_on_VersionCompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getCLose_button_on_VersioncompareScreen().isVisible());

    }

    @Then("User will Click on Close button and comparision window should be close and user will be on preview screen")
    public void User_will_Click_on_Close_button_and_comparision_window_should_be_close_and_user_will_be_on_preview_screen(){
        dms_2203PageObject.getCLose_button_on_VersioncompareScreen().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getDocumentPreview_text().isVisible());
        Assert.assertTrue(dms_2203PageObject.getProminent_Message_ON_DocumentPreviewScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getViewButton_on_DocumentPreviewScreen().isVisible());
    }

    @And("User will Select Action type then Click on submit Button then able to see popup for updated USP Rider")
    public void User_will_Select_Action_type_then_Click_on_submit_Button_then_able_to_see_popup_for_updated_USP_Rider(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(9)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
    }

    @And("User will Select Action type then Click on submit Button then not able to see popup for updated USP Rider")
    public void User_will_Select_Action_type_then_Click_on_submit_Button_then_not_able_to_see_popup_for_updated_USP_Rider(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertFalse(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
    }

    @And("User will Select Action type other then Edit Document, Click on submit Button then not able to see popup for updated USP Rider")
    public void User_will_Select_Action_typeother_then_Edit_Document_Click_on_submit_Button_then_not_able_to_see_popup_for_updated_USP_Rider(){
        dms_2203PageObject.RandomSelectActiontype();
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertFalse(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
    }

    @And("User will Select Action type then Click on submit Button then able to see popup with all the element for updated USP Rider")
    public void User_will_Select_Action_type_then_Click_on_submit_Button_then_able_to_see_popup_with_all_the_element_for_updated_USP_Rider(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(9)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
        Assert.assertTrue(dms_2203PageObject.getUpdateAvailableForUSPtext_on_UpdatedUSPRider_POPUP().getText().contains("There is a new update available for USP attached to the document"));
        Assert.assertTrue(dms_2203PageObject.getForAskToViewAvailableUpdate_text_on_UpdatedUSPRider_POPUP().getText().contains("Would you like to view new available update."));
        Assert.assertTrue(dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().isVisible());
        Assert.assertTrue(dms_2203PageObject.getYesButton_on_UpdateAvailableForUSP_POPUP().isVisible());
    }

    @Then("User will Re-direct back to listing screen")
    public void User_will_Redirect_back_to_listing_screen(){
        if (dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().isVisible()) {
            Assert.assertTrue(dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().isVisible());
            dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().click();
        }
        getDriver().navigate().back();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("User will Click on EditButton and redirect to Edit Screen and able to see popup for updated USP Rider")
    public void User_will_Click_on_EditButton_and_redirect_to_Edit_Screen_and_able_to_see_popup_for_updated_USP_Rider(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
    }

    @Then("User will Click on EditButton and redirect to Edit Screen and not able to see popup for updated USP Rider")
    public void User_will_Click_on_EditButton_and_redirect_to_Edit_Screen_and_not_able_to_see_popup_for_updated_USP_Rider(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertFalse(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
    }
    @Then("User will Click on EditButton and redirect to Edit Screen and able to see popup with all the element for updated USP Rider")
    public void User_will_Click_on_EditButton_and_redirect_to_Edit_Screen_and_able_to_see_popup_with_all_the_element_for_updated_USP_Rider(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getConfirmation_text_on_UpdatedUSPRider_POPUP().isVisible());
        Assert.assertTrue(dms_2203PageObject.getUpdateAvailableForUSPtext_on_UpdatedUSPRider_POPUP().getText().contains("There is a new update available for USP attached to the document"));
        Assert.assertTrue(dms_2203PageObject.getForAskToViewAvailableUpdate_text_on_UpdatedUSPRider_POPUP().getText().contains("Would you like to view new available update."));
        Assert.assertTrue(dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().isVisible());
        Assert.assertTrue(dms_2203PageObject.getYesButton_on_UpdateAvailableForUSP_POPUP().isVisible());
    }

    @Then("User will Click on No button on USP Rider Update POPUP and Redirected to Approval WorkFlow Screen")
    public void User_will_Click_on_No_button_on_USP_Rider_Update_POPUP_and_Redirected_to_Approval_WorkFlow_Screen(){
        dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertFalse(dms_2203PageObject.getNOButton_on_UpdateAvailableForUSP_POPUP().isVisible());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1528PageObject.getParticipants_text().isVisible());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isVisible());
    }

    @Then("User able to see atleast one highlighted New Update available link text correspondence USP Rider")
    public void User_able_to_see_atleast_one_highlighted_New_Update_available_link_text_correspondence_USP_Rider(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dms_2203PageObject.getDateFilter());
        Assert.assertTrue(dms_2203PageObject.getNewUpdateAvailable_linktext().isVisible());
    }

    @Then("User will Click on yes button on USP Rider Update POPUP and Redirected to Comparison Window")
    public void User_will_Click_on_yes_button_on_USP_Rider_Update_POPUP_and_Redirected_to_Comparison_Window(){
        Assert.assertTrue(dms_2203PageObject.getYesButton_on_UpdateAvailableForUSP_POPUP().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms_2203PageObject.getYesButton_on_UpdateAvailableForUSP_POPUP().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getVersionCompare_Screen_text().isVisible());
    }

    @And("User will able to see all the correspondence information and buttons on Version Compare screen")
    public void User_will_able_to_see_to_all_the_correspondence_information_and_buttons_on_Version_Compare_screen(){
        Assert.assertTrue(dms_2203PageObject.getVersionCompare_Screen_text().isVisible());
        Assert.assertTrue(dms_2203PageObject.getUSPRiderID_on_VersionCompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getCurrentVersion_window_on_VersionCompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getNewVersion_window_on_VersionCompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getCLose_button_on_VersioncompareScreen().isVisible());
        Assert.assertTrue(dms_2203PageObject.getApplyUpdate_button_on_VersioncompareScreen().isVisible());
    }

    @Then("User will Click on Apply Update button and able to Success Message Document Version Update")
    public void User_will_Click_on_Apply_Update_button_and_able_to_Success_Message_Document_Version_Update(){
        dms_2203PageObject.getApplyUpdate_button_on_VersioncompareScreen().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2199pageobject.getSuccessmessage().getText().contains("Document Version Updated"));
    }
    @And("User will Click on New highlighted new Update LinkText then Verison Compare window should be open")
    public void User_will_Click_on_New_highlighted_new_Update_LinkText_then_Verison_Compare_window_should_be_open(){
        dms_2203PageObject.getNewUpdateAvailable_linktext().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms_2203PageObject.getVersionCompare_Screen_text().isVisible());
    }



}
