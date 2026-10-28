package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
public class DMS_2025Step extends PageObject {

    DMS_1931PageObject dMS1931PageObject;


    DMS_2024PageObject dms2024PageObject;
    DMS_1707PageObject dms1707PageObject;
    DMS_2199PageObject dms2199pageobject;
    DMS_1528PageObject dms1528PageObject;
    DMS_1553PageObject dms1553PageObject;

    DMS_1571PageObject dms1571PageObject;
    DMS_2025PageObject dms2025PageObject;


    @And("user will select Doctype for Document type filter")
    public void user_will_select_Doctype_for_Document_type_filter(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1707PageObject.EnterDoctype(dataTable);
    }
    @And("User will Select Action type Click on submit Button and Redirected to Edit Document Screen")
    public void User_will_Select_Action_type_Click_on_submit_Button_and_Redirected_to_Edit_Document_Screen(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
    }
    @And("User is able to see all the tab Disabled except ApprovalWorkflow and Preview&Submit")
    public void User_is_able_to_see_all_the_tab_Disabled_except_ApprovalWorkflow_and_PreviewandSubmit(){
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isEnabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isDisabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isDisabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isDisabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isDisabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isDisabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
    }
    @And("User will Click on View Fund Detail button redirected to side window for fund")
    public void User_will_Click_on_View_Fund_Detail_button_redirected_to_side_window_for_fund(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms2025PageObject.getViewFundDetails_Button_forClient1().isVisible());
        dms2025PageObject.getViewFundDetails_Button_forClient1().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
    }

    @Then("User is not able to see Edit button on Fund side window")
    public void User_is_not_able_to_see_Edit_button_on_Fund_side_window(){
        Assert.assertFalse(dms2025PageObject.getEdit_button().isVisible());

    }

    @And("User is able to see all the tab Disabled except Enforcement Rules and Preview&Submit")
    public void User_is_able_to_see_all_the_tab_Disabled_except_Enforcement_Rules_and_PreviewandSubmit(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isEnabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isDisabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isDisabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isDisabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isDisabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isDisabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
    }

    @And("User is able to see all the tab Disabled except Legal Terms and Preview&Submit")
    public void User_is_able_to_see_all_the_tab_Disabled_except_Legal_Terms_and_PreviewandSubmit(){
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isEnabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isDisabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isDisabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isDisabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isDisabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
    }

    @And("User is able to see all the tab Disabled except Limit Scope and Preview&Submit")
    public void User_is_able_to_see_all_the_tab_Disabled_except_Limit_Scope_and_PreviewandSubmit(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        dms1528PageObject.getApproval_workflowTab().waitUntilVisible();
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isDisabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isDisabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isEnabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isDisabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isDisabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
    }

    @And("User is able to see all the tab Disabled except Auth Scope and Preview&Submit")
    public void User_is_able_to_see_all_the_tab_Disabled_except_Auth_Scope_and_PreviewandSubmit(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isDisabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isEnabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isDisabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isDisabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isDisabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
    }

    @And("User is able to see all the tab are Enabled")
    public void User_is_able_to_see_all_the_tab_are_Enabled(){
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isEnabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isEnabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isEnabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isEnabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isEnabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isEnabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isEnabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
    }

    @Then("User is able to see Edit button on Fund side window")
    public void User_is_able_to_see_Edit_button_on_Fund_side_window(){
        Assert.assertTrue(dms2025PageObject.getEdit_button().isVisible());
    }

    @And("User will Select Action type click on Submit button and Redirected to Edit Document Screen")
    public void User_will_Select_Action_type_click_on_Submit_button_and_Redirected_to_Edit_Document_Screen(){
        dms2025PageObject.SelectAnyActiontype();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(9)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
    }

    @Then("User will able to see View Fund Details button")
    public void User_will_able_to_see_View_Fund_Details_button(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2025PageObject.getViewFundDetails_Button_forClient1().isVisible());
    }

    @Then("User will able to see View Fund Details button for both Client")
    public void User_will_able_to_see_View_Fund_Details_button_for_both_Client(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2025PageObject.getViewFundDetails_Button_forClient1().isVisible());
        Assert.assertTrue(dms2025PageObject.getViewFundDetails_Button_forClient2().isVisible());
    }

    @And("User will Click on Cancel and Click on View Fund Detail button of Client two redirected to side window for fund")
    public void User_will_Click_on_Cancel_and_Click_on_View_Fund_Detail_button_of_Client2_redirected_to_side_window_for_fund(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2025PageObject.getCancel_button().isVisible());
        dms2025PageObject.getCancel_button().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2025PageObject.getViewFundDetails_Button_forClient2().isVisible());
        dms2025PageObject.getViewFundDetails_Button_forClient2().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getFundsText_onSideWindow().isVisible());
    }

    @Then("User will click on Edit button able to successfully add and remove a Fund")
    public void User_will_click_on_Edit_button_able_to_successfully_add_and_remove_a_Fund(List<String> Funds){
        Assert.assertTrue(dms2025PageObject.getEdit_button().isVisible());
        dms2025PageObject.getEdit_button().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms2024PageObject.AddLEIthatDoesnotexistinsystem(Funds);
        Assert.assertTrue(dms2024PageObject.getAddFundsText_onSideWindow().isVisible());
        dms2024PageObject.getAddFundsText_onSideWindow().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getAddedFundItem_On_FundSideWindow().isVisible());
        Assert.assertTrue(dms2024PageObject.getCrossButton_On_FundSideWindow().isVisible());
        dms2024PageObject.getCrossButton_On_FundSideWindow().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        }



    @And("Click on save and Get success message for update fund and Side Window geting closed")
    public void Click_on_save_and_Get_success_message_for_update_fund_and_Side_Window_geting_closed(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2024PageObject.getSaveButtonOnFundSideWindow().isVisible());
        dms2024PageObject.getSaveButtonOnFundSideWindow().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2199pageobject.getSuccessmessage().getText().contains("Funds updated successfully"));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertFalse(dms2024PageObject.getFundsText_onSideWindow().isVisible());
    }

    @Then("User will Able to see Added Fund list on Side Window of Fund")
    public void User_will_Able_to_see_Added_Fund_list_on_Side_Window_of_Fund(){
        if (dms2025PageObject.getLISTOFAddedFundForSideWindowOF_ViewFundDetails_Button().isVisible()){
            Assert.assertTrue(dms2025PageObject.getLISTOFAddedFundForSideWindowOF_ViewFundDetails_Button().isVisible());
        }else {
            Assert.assertTrue(dms2025PageObject.getNoRecordFound_When_FundsAreNotAdded().isVisible());
        }
    }

    @Then("User will click on Edit Button and Redirected to Edit Document Screen")
    public void User_will_click_on_Edit_Button_and_Redirected_to_Edit_Document_Screen(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        if (dms1553PageObject.getNObuttonOnpopup().isVisible()){
            dms1553PageObject.getNObuttonOnpopup().click();
        }
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());

    }





}
