package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1553PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1571PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2199PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;



@Slf4j
public class DMS_2199Step extends PageObject {


    DMS_2199PageObject dms2199pageobject;

    DMS_1571PageObject dms1571PageObject;
    DMS_1553PageObject dms1553PageObject;


    @And("user will select value for Document Action filter")
    public void user_will_select_value_for_Document_Action_filter(List<String> DocumentAction){
        dms2199pageobject.Selectitemfor_DocumentAction_Column(DocumentAction);
    }

    @Then("User will click on Edit Button and redirect to Edit Screen then able to see USP Rider tab")
    public void User_will_click_on_Edit_Button_and_redirect_to_Edit_Screen_then_able_to__see_USP_Rider_tab(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isVisible());
    }
    @And("USer will Click on USP Rider tab and Redirected to USP Rider tab")
    public void USer_will_Click_on_USP_Rider_tab_and_Redirected_to_USP_Rider_tab(){
        if (dms1553PageObject.getNObuttonOnpopup().isVisible()){
            dms1553PageObject.getNObuttonOnpopup().click();
        }
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",dms2199pageobject.getUSPRider_button());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isVisible());
        dms2199pageobject.getUSPRider_button().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms2199pageobject.getUSPRiderContainer().isVisible());
    }

    @Then("User Will Navigate Back to Listing Screen")
    public void User_Will_Navigate_Back_to_Listing_Screen(){
        getDriver().navigate().back();
        withAction().pause(Duration.ofSeconds(7)).build().perform();
    }

    @Then("User will click on Edit Button and able to see Edit Popup")
    public void User_will_click_on_Edit_Button_and_able_to_see_Edit_Popup(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEdit_Text().isVisible());

    }

    @And("User will Select Action type then Click on submit Button and Redirected to Edit Document Screen")
    public void User_will_Select_Action_type_then_Click_on_submit_Button_and_Redirected_to_Edit_Document_Screen(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isVisible());
    }
    @And("user will click on next button and get Success message then redirected to edit document screen")
    public void user_will_click_on_next_button_and_get_Success_message_then_redirected_to_edit_document_screen(){
        Assert.assertTrue(dms1571PageObject.getNext_button().isVisible());
        dms1571PageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        if (dms2199pageobject.getSuccessmessage().getText().contains("Document Created.")){
            Assert.assertTrue(dms2199pageobject.getSuccessmessage().getText().contains("Document Created."));
        } else {
            Assert.assertTrue(dms2199pageobject.getSuccessmessage().getText().contains("Document already exist with this combination"));
            log.info("The Document already exist with this combination please try with another combination");
        }
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms2199pageobject.getUSPApprovalmatrix().containsText("Apply USP Rider"));
        withAction().pause(Duration.ofSeconds(2)).build().perform();

    }

    @Then("User is able to see all the Information on USP Rider Template")
    public void User_is_able_to_see_all_the_Information_on_USP_Rider_Template(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        if (dms2199pageobject.getUSPRiderContainer().isVisible()){
            Assert.assertTrue(dms2199pageobject.getPrimeBroker1Text_ON_USP_RIDER_tab().isVisible());
            Assert.assertTrue(dms2199pageobject.getClient1Text_ON_USP_RIDER_tab().isVisible());
            Assert.assertTrue(dms2199pageobject.getLEI_IDofPrimeBroker1_ON_USP_RIDER_tab().isVisible());
            Assert.assertTrue(dms2199pageobject.getLEI_NameofPrimeBroker1_ON_USP_RIDER_tab().isVisible());
            Assert.assertTrue(dms2199pageobject.getLEI_IDofClient1_ON_USP_RIDER_tab().isVisible());
            Assert.assertTrue(dms2199pageobject.getLEI_NameofClient1_ON_USP_RIDER_tab().isVisible());
            Assert.assertTrue(dms2199pageobject.getArrow_to_Show_Further_INFO_of_Template().isVisible());
        }
        Assert.assertTrue(dms2199pageobject.getCancel_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getBack_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getReset_Current_changes_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getSave_As_draft_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getNext_Button().isVisible());
    }

    @And("User is able to check USP Rider Document availability")
    public void User_is_able_to_check_USP_Rider_Document_availability(){
        dms2199pageobject.CheckUSPRiderDocumentAvailability();
    }

    @And("User is able to see template combination according to Document type")
    public void User_is_able_to_see_template_combination_according_to_Document_type(){
        dms2199pageobject.CheckUSPRiderTemplateCount();
    }
    @And("User able to verify datepicker")
    public void User_able_to_verify_datepicker(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",dms2199pageobject.getDatepickercheckbox());
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        dms2199pageobject.getDatepickercheckbox().click();
        Assert.assertTrue(dms2199pageobject.getDatepicker().isVisible());
    }

    @Then("user is able to see Select parties section section with respective parties filters")
    public void user_is_able_to_see_Select_parties_section_section_with_respective_parties_filters(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1571PageObject.getSelectparties_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getPrimeBroker1Filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getClient1Filter().isVisible());
        if (dms1571PageObject.getDocumenttypefilter().getAttribute("value").equalsIgnoreCase("DN")){
            Assert.assertTrue(dms1571PageObject.getExecutingBroker1Filter().isVisible());
        } else if (dms1571PageObject.getDocumenttypefilter().getAttribute("value").equalsIgnoreCase("4 Way")) {
            Assert.assertTrue(dms1571PageObject.getPrimeBroker2Filter().isVisible());
            Assert.assertTrue(dms1571PageObject.getClient2Filter().isVisible());
        }
    }

    @Then("User is able to see USP Rider tab Along with other tabs")
    public void User_is_able_to_see_USP_Rider_tab_Along_with_other_tabs(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isVisible());
    }

    @Then("User will click on accordion button and able to see details of Available USP Rider")
    public void User_will_click_on_accordion_button_and_able_to_see_details_of_Available_USP_Rider(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms2199pageobject.getArrow_to_Show_Further_INFO_of_Template().isVisible());
//        dms2199pageobject.getArrow_to_Show_Further_INFO_of_Template().click();
        dms2199pageobject.CheckUSPDetailContainervisiblity();
    }

    @And("User is able to addremove USP Rider and save as Draft Then redirect to same document and able to see changes for USP Rider")
    public void User_is_able_to_addremove_USP_Rider_and_save_as_Draft_Then_redirect_to_same_document_and_able_to_see_changes_for_USP_Rider(){
        dms2199pageobject.UpdateAvailableUSPRider();
    }

    @And("User is able to see Create New Button for USP Rider when PB is online and not able to see in case of PB lite")
    public void User_is_able_to_see_Create_New_Button_for_USP_Rider_when_PB_is_online_and_not_able_to_see_in_case_of_PB_lite(){
        dms2199pageobject.CheckUSPRiderDocumentAvailability();
    }

    @Given("User will be on Profile details of user")
    public void User_will_be_on_Profile_details_of_user(){
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(dms1553PageObject.getProfile_icon().isVisible());
        dms1553PageObject.getProfile_icon().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1553PageObject.getProfile_Details().isVisible());
        dms1553PageObject.getProfile_Details().click();
    }

    @Then("Check User should have Osttra Admin role perform operation for USP Rider")
    public void Check_User_should_have_Osttra_Admin_role_perform_operation_for_USP_Rider(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms2199pageobject.getAssignedRoles_For_loggedIN_USER().isVisible());
        if (dms2199pageobject.getAssignedRoles_For_loggedIN_USER().getText().contains("OSTTRA_ADMIN")){

        }else {
            log.info("User doesn't have Osttra Admin permission ");
            Assert.fail();
        }
    }

}
