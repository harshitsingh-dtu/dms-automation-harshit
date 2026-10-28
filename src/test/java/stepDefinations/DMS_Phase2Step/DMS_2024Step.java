package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1571PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2024PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_2024Step extends PageObject {

    DMS_1571PageObject dms1571PageObject;
    DMS_2024PageObject dms2024PageObject;





    @Then("User is able to see Selected Parties and filters according to DocType")
    public void User_is_able_to_see_Selected_Parties_and_filters_according_to_DocType(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1571PageObject.getSelectparties_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getPrimeBroker1Filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getClient1Filter().isVisible());
        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient1().isVisible());
        if (dms1571PageObject.getDocumenttypefilter().getAttribute("value").equalsIgnoreCase("DN")){
            Assert.assertTrue(dms1571PageObject.getExecutingBroker1Filter().isVisible());
        } else if (dms1571PageObject.getDocumenttypefilter().getAttribute("value").equalsIgnoreCase("4 Way")) {
            Assert.assertTrue(dms1571PageObject.getPrimeBroker2Filter().isVisible());
            Assert.assertTrue(dms1571PageObject.getClient2Filter().isVisible());
            Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient2().isVisible());
        }
    }

    @Then("User will click on Add Funds Button then should be able to see side window for Funds")
    public void User_will_click_on_Add_Funds_Button_then_User_should_be_able_to_see_side_window_for_Funds(){
        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient1().isVisible());
        dms2024PageObject.getAddFundButtonwithClient1().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getCancelButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getCancelButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if (dms1571PageObject.getDocumenttypefilter().getAttribute("value").equalsIgnoreCase("4 Way")) {
            Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient2().isVisible());
            dms2024PageObject.getAddFundButtonwithClient2().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
            Assert.assertTrue(dms2024PageObject.getCancelButtonOnFundSideWindow().isVisible());
            dms2024PageObject.getCancelButtonOnFundSideWindow().click();
        }
    }

    @And("User will click on Add Funds Button then able to see all the elements on side window for Funds")
    public void User_will_click_on_Add_Funds_Button_then_able_to_see_all_the_elements_on_side_window_for_Funds(){
        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient1().isVisible());
        dms2024PageObject.getAddFundButtonwithClient1().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getAddFundsText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getSearchandAddfund_Input_Filter_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getFundNameText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getSearchByIDorNAME_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getCancelButtonOnFundSideWindow().isVisible());
        if (dms2024PageObject.getAddedFundItem_On_FundSideWindow().isVisible()){
            Assert.assertTrue(dms2024PageObject.getAddedFundItem_On_FundSideWindow().isVisible());
            Assert.assertTrue(dms2024PageObject.getCrossButton_On_FundSideWindow().isVisible());
        }else {
            Assert.assertTrue(dms2024PageObject.getNO_Record_Found_On_FundSideWindow().isVisible());
        }
    }

    @And("User will click on Add Funds Button for Client2 then able to see all the elements on side window for Funds")
    public void User_will_click_on_Add_Funds_for_Client2_Button_then_able_to_see_all_the_elements_on_side_window_for_Funds(){
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getSaveButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient2().isVisible());
        dms2024PageObject.getAddFundButtonwithClient2().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getAddFundsText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getSearchandAddfund_Input_Filter_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getFundNameText_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getSearchByIDorNAME_onSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getCancelButtonOnFundSideWindow().isVisible());
        if (dms2024PageObject.getAddedFundItem_On_FundSideWindow().isVisible()){
            Assert.assertTrue(dms2024PageObject.getAddedFundItem_On_FundSideWindow().isVisible());
            Assert.assertTrue(dms2024PageObject.getCrossButton_On_FundSideWindow().isVisible());
        }else {
            Assert.assertTrue(dms2024PageObject.getNO_Record_Found_On_FundSideWindow().isVisible());
        }
    }


    @And("User is click on Search Box and Search for LEI then able to see Correspondence searched Result")
    public void User_is_click_on_Search_Box_and_Search_for_LEI_then_able_to_see_Correspondence_searched_Result(List<String> LEIIDorLEIName){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.SearchforLEIID_or_LEI_NAME(LEIIDorLEIName);
    }


    @And("User will click on Search Box and able to randomally select multiple LEIs")
    public void User_will_click_on_Search_Box_and_able_to_randomally_select_multiple_LEIs(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.SelectMultipleLEIs();
    }

    @And("User is able to see No Record Found Text in case no funds are added")
    public void User_is_able_to_see_No_Record_Found_Text_in_case_no_funds_are_added(){
        dms2024PageObject.CheckNoRecord();
    }

    @And("User will click on Search Box then able to see Funds List in search box")
    public void User_will_click_on_Search_Box_then_able_to_see_Funds_List_in_search_box(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.CheckAvailabiltyofAddedFundsinsearchbox();
    }

    @And("User is click on Search Box and Search for LEI that does not exist in the System then able to see Add button Along with Correspondence searched Result")
    public void User_is_click_on_Search_Box_and_Search_for_LEI_that_doesnot_exist_in_the_System_then_able_to_see_Add_button_Along_with_Correspondence_searched_Result(List<String> LEIIDorLEIName){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.CheckAddButtonforNewLEIID_or_LEI_NAME(LEIIDorLEIName);
    }

    @And("User will click on Search Box and select some LEIs then able to see Selected Funds in the Added Funds list section")
    public void User_will_click_on_Search_Box_and_select_some_LEIs_then_able_to_see_Selected_Funds_in_the_Added_Funds_list_section(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.SelectMultipleLEIs();
    }

    @And("User will click on Search Box and select some LEIs for Add fund of Client2 then able to see Selected Funds in the Added Funds list section")
    public void User_will_click_on_Search_Box_and_select_some_LEIs_for_Add_fund_of_Client2_then_able_to_see_Selected_Funds_in_the_Added_Funds_list_section(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.SelectMultipleLEIs();
    }

    @And("User clicks on the search box enters a non existent LEIs clicks Add button and views the selected LEIs in the Added Funds List section")
    public void User_clicks_on_the_search_box_enters_a_nonexistent_LEIs_clicks_Add_button_and_views_the_selected_LEIs_in_the_Added_Funds_List_section(List<String> Funds){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.AddLEIthatDoesnotexistinsystem(Funds);
    }

    @And("User will click on save button and again navigate to Add fund Screen")
    public void User_will_click_on_save_button_and_again_navigate_to_Add_fund_Screen(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getSaveButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient1().isVisible());
        dms2024PageObject.getAddFundButtonwithClient1().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
    }

    @And("User will able to see recently added LEIs in the Added Funds list section")
    public void User_will_able_to_see_recently_added_LEIs_in_the_Added_Funds_list_section(List<String> LEIIDorLEIName){
        dms2024PageObject.CheckRecentlyaddedLEIS(LEIIDorLEIName);
    }

    @And("User will able to remove funds Successfully")
    public void Use_will_able_to_remove_funds_Successfully(List<String> Funds){
        dms2024PageObject.RemoveAddedFundsformList(Funds);
//        dms2024PageObject.RemoveAddedFundsformList(dataTable);

    }


    @And("User will Click on save button and Change Doc type")
    public void User_will_Click_on_save_button_and_Change_Doc_type(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getSaveButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1571PageObject.EnterDocType(dataTable);
        dms1571PageObject.EnterActingas(dataTable);
    }

    @And("User Again Navigate to Add FundScreen then All added funds Should be reset")
    public void User_Again_Navigate_to_Add_FundScreen_then_All_added_funds_Should_be_reset(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient1().isVisible());
        dms2024PageObject.getAddFundButtonwithClient1().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
        Assert.assertFalse(dms2024PageObject.getAddedFundItem_On_FundSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getNO_Record_Found_On_FundSideWindow().isVisible());
    }


    @And("User will click on the save button then change the Acting As and then be redirected to the Add Fund screen where they will be able to see the added funds")
    public void user_will_click_on_the_save_button_then_change_the_Acting_As_and_then_be_redirected_to_the_Add_Fund_screen_where_they_will_be_able_to_see_the_added_funds(DataTable dataTable){
        dms2024PageObject.validateaddedfundsforChangeActingas(dataTable);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("User will click on the save button then click on the add fund button again and be redirected to the add funds side screen where they will be able to see previously added funds")
    public void User_will_click_on_the_save_button_then_click_on_the_add_fund_button_again_and_be_redirected_to_the_add_funds_side_screen_where_they_will_be_able_to_see_previously_added_funds(){
        dms2024PageObject.validateaddedfundslist();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User will select parties all required parties according to Doc type")
    public void User_will_select_parties_all_required_parties_according_to_Doc_type(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1571PageObject.SelectPrimeBroker1();
        dms1571PageObject.randomEnterExecutingBroker1();
        dms1571PageObject.randomEnterClient1();
        dms1571PageObject.randomEnterPrimeBroker2();
        dms1571PageObject.randomEnterClient2();
    }


    @And("User will CLick on save Button on Fund Side window and Redirected to Request to create new document Screen")
    public void User_will_CLick_on_save_Button_on_Fund_Side_window_and_Redirected_to_Request_to_create_new_document_Screen(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.getCrossButton_On_FundSideWindow().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getSaveButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1571PageObject.getRequest_to_CreateNewDocument_text().isVisible());
    }

    @And("User will Click on Submit Request button and navigate to see Define Reviewer POPUP")
    public void User_will_Click_on_Submit_Request_button_and_navigate_to_see_Define_Reviewer_POPUP(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSubmitRequest_Button().isVisible());
        dms2024PageObject.getSubmitRequest_Button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2024PageObject.getDefineReviwer_POPUP_TEXT().isVisible());
    }

    @And("User will Select Reviewer and Click on Submit Button and Get Success POPUP With Gotit Button")
    public void User_will_Select_Reviewer_and_Click_on_Submit_Button_and_Get_Success_POPUP_With_Gotit_Button(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSelectReviwer_INPUT().isVisible());
        dms2024PageObject.SelectRandomReviewer();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSubmitButton_on_POPUP().isVisible());
        dms2024PageObject.getSubmitButton_on_POPUP().click();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSuccessMessageforSubmitRequestForCreateDocument().isVisible());
        Assert.assertTrue(dms2024PageObject.getSuccessMessageforSubmitRequestForCreateDocument().getText().contains("Your request for document creation has been submitted successfully"));
        Assert.assertTrue(dms2024PageObject.getGotIT_buttonOnSubmitRequestForCreateDocument_PopUP().isVisible());
        dms2024PageObject.getGotIT_buttonOnSubmitRequestForCreateDocument_PopUP().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("User will Click on Save button and navigate to fund side screen for Client2")
    public void User_will_Click_on_Save_button_and_navigate_to_fund_side_screen_for_Client2(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getSaveButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms1571PageObject.getCreatenewdocument_text().isVisible());
        Assert.assertTrue(dms2024PageObject.getAddFundButtonwithClient2().isVisible());
        dms2024PageObject.getAddFundButtonwithClient2().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
    }


    @And("User will select some LEIs to add funds then search one of the Selected fund through LEI ID in Added List and able to get search result")
    public void User_will_select_some_LEIs_to_add_funds_then_search_one_of_the_Selected_fund_through_LEI_ID_in_Added_List_and_able_to_get_search_result(){
        dms2024PageObject.SelectMultipleLEI_IDAndSearchforAddedList();
    }

    @And("User will select some LEIs to add funds then search one of the Selected fund through LEI NAME in Added List and able to get search result")
    public void User_will_select_some_LEIs_to_add_funds_then_search_one_of_the_Selected_fund_through_LEI_NAME_in_Added_List_and_able_to_get_search_result(){
        dms2024PageObject.SelectMultipleLEI_NAMEAndSearchforAddedList();
    }

    @Then("User will able to see AddRemove Funds of one client shouldnt affect the funds for other client")
    public void User_will_able_to_see_AddRemove_Funds_of_one_client_shouldnt_affect_the_funds_for_other_client(List<String> OneMoreAddedFund){
        dms2024PageObject.CheckAddRemoveFundsEffect(OneMoreAddedFund);
    }






}
