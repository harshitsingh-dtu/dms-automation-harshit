package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1931Step extends PageObject {

    DMS_1928PageObject dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject;


    DMS_1553PageObject dms1553PageObject;

    DMS_2199PageObject dms2199pageobject;
    DMS_1528PageObject dms1528PageObject;
    DMS_1571PageObject dms1571PageObject;
    DMS_2025PageObject dms2025PageObject;

    DMS_1931PageObject dMS1931PageObject;


    @Then("User will able to see General term Along with all the other tabs")
    public void User_will_able_to_see_General_term_Along_with_all_the_other_tabs(){
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isVisible());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isVisible());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isVisible());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isVisible());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isVisible());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isVisible());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isVisible());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isVisible());

    }

    @And("User will click on the next button and reached the General term Screen")
    public void User_will_click_on_the_next_button_and_reached_the_general_term_Screen(){
        dms1528PageObject.getNext_Button().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dMS1931PageObject.getContactSpecifiedOffices_Text_on_GeneralTermTab().isVisible());



    }

    @Then("User is able to see all the Static information for all the tabs")
    public void User_is_able_to_see_all_the_Static_information_for_all_the_tabs(){
        Assert.assertTrue(dMS1931PageObject.getAllInfoFORDocument().isVisible());
        String DocumentINFO_on_GeneralTerm = dMS1931PageObject.getAllInfoFORDocument().getText();
        dms1528PageObject.getApproval_workflowTab().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertEquals(DocumentINFO_on_GeneralTerm, dMS1931PageObject.getAllInfoFORDocument().getText());
    }

    @And("User will Click on General term tab and Redirected to General term tab")
    public void User_will_Click_on_General_term_tab_and_Redirected_to_General_term_tab(){
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isVisible());
        dms2025PageObject.getGeneral_Term_Tab().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dMS1931PageObject.getContactSpecifiedOffices_Text_on_GeneralTermTab().isVisible());
    }

    @Then("User is able to see Static information and all the fields and Dropdown under ContactSpecified offices")
    public void User_is_able_to_see_Static_information_and_all_the_information_under_ContactSpecified_offices(){
        Assert.assertTrue(dms1571PageObject.getDocumentversionid_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getDocumenttype_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getAllowedcurrencies_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectedpartyprimebroker1_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectedpartyClient1text().isVisible());
        if (dms1571PageObject.getDocumenttype_text().getText().equals("4 Way")){
            Assert.assertTrue(dms1571PageObject.getSelectedpartyprimebroker2_text().isVisible());
            Assert.assertTrue(dms1571PageObject.getSelectedpartyClient2text().isVisible());
            Assert.assertTrue(dMS1931PageObject.getAddressfield_for_PrimeBroker2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getContactfield_for_PrimeBroker2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getActionOfficeDropdown_for_PrimeBroker2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getRelationshipDropdown_for_PrimeBroker2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getSpecifiedOfficeDropdown_for_PrimeBroker2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getNOTEStextField_for_PrimeBroker2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getAddressfield_for_Client2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getContactfield_for_Client2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getActionOfficeDropdown_for_Client2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getRelationshipDropdown_for_Client2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getSpecifiedOfficeDropdown_for_Client2().isVisible());
            Assert.assertTrue(dMS1931PageObject.getNOTEStextField_for_PrimeClient2().isVisible());
        } else if (dms1571PageObject.getDocumenttype_text().getText().equals("DN")) {
            Assert.assertTrue(dms1571PageObject.getSelectedpartyExecutingBroker1_text().isVisible());

            Assert.assertTrue(dMS1931PageObject.getAddressfield_For_ExecutingBroker().isVisible());
            Assert.assertTrue(dMS1931PageObject.getContactfield_For_ExecutingBroker().isVisible());
            Assert.assertTrue(dMS1931PageObject.getActionOfficeDropdown_For_ExecutingBroker().isVisible());
            Assert.assertTrue(dMS1931PageObject.getRelationshipDropdown_For_ExecutingBroker().isVisible());
            Assert.assertTrue(dMS1931PageObject.getSpecifiedOfficeDropdown_For_ExecutingBroker().isVisible());
            Assert.assertTrue(dMS1931PageObject.getNOTEStextField_For_ExecutingBroker().isVisible());
        }
        Assert.assertTrue(dMS1931PageObject.getContactSpecifiedOffices_Text_on_GeneralTermTab().isVisible());
        Assert.assertTrue(dMS1931PageObject.getAddressfield_for_PrimeBroker1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getContactfield_for_PrimeBroker1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getActionOfficeDropdown_for_PrimeBroker1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getRelationshipDropdown_for_PrimeBroker1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getSpecifiedOfficeDropdown_for_PrimeBroker1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getNOTEStextField_for_PrimeBroker1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getAddressfield_for_Client1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getContactfield_for_Client1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getActionOfficeDropdown_for_Client1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getSpecifiedOfficeDropdown_for_Client1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getNOTEStextField_for_PrimeClient1().isVisible());
        Assert.assertTrue(dMS1931PageObject.getCancel_Button().isVisible());
        Assert.assertTrue(dMS1931PageObject.getResetCurrentChanges_Button().isVisible());
        Assert.assertTrue(dms1528PageObject.getSave_as_draftButton().isVisible());
        Assert.assertTrue(dms1571PageObject.getNext_button().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }

    @Then("User will Click on Specified Officies Dropdown and Select some offices")
    public void User_will_Click_on_Specified_Officies_Dropdown_and_Select_some_offices(){
        dMS1931PageObject.SelectMultipleSpecifiedOfficies();
    }

    @Then("User will Enter input in Address field and Check field accept maximum 100 Character only")
    public void User_will_Enter_input_in_Address_field_and_Check_field_accept_maximum_100_Character_only(){
        dMS1931PageObject.checkCharacterlengthofAddressField();
    }

    @Then("User will Enter input in Contact field and Check field accept maximum 100 Character only")
    public void User_will_Enter_input_in_Contact_field_and_Check_field_accept_maximum_100_Character_only(){
        dMS1931PageObject.checkCharacterlengthofContactField();
    }

    @Then("User will Enter input in Notes field and Check field accept maximum 1000 Character only")
    public void User_will_Enter_input_in_Notes_field_and_Check_field_accept_maximum_1000_Character_only(){
        dMS1931PageObject.checkCharacterlengthofNotesField();
    }


    @Then("User will click on relationship dropdown and able to below relationships")
    public void User_will_click_on_relationship_dropdown_and_able_to_below_relationships(List<String> itemlist){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dMS1931PageObject.FilteredItemForRelationship(itemlist);
    }

    @And("User will Enter data in the Field")
    public void User_will_Enter_data_in_the_Field(DataTable dataTable){
        dMS1931PageObject.EnterInput_for_Address_contact_Notes(dataTable);
        dMS1931PageObject.EnterRandomInput_for_ActingOffice_Relationship_SpecifiedOffice();
    }

    @Then("User will Click on Next Button and redirected to Auth Scope Screen Successfully")
    public void User_will_Click_on_Next_Button_and_redirected_to_Auth_Scope_Screen_Successfully(){
        Assert.assertTrue(dms1571PageObject.getNext_button().isVisible());
        dms1571PageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1571PageObject.getAuthproducts_text().isVisible());
    }



    @Then("User will click the Back button, confirm the popup by clicking Yes, and then be redirected to the Legal Term tab")
    public void User_will_click_the_Back_button_confirm_the_popup_by_clicking_Yes_and_then_be_redirected_to_the_Legal_Term_tab(){
        Assert.assertTrue(dMS1931PageObject.getBack_Button().isVisible());
        dMS1931PageObject.getBack_Button().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1553PageObject.getYesbuttonOnpopup().isVisible());
        dms1553PageObject.getYesbuttonOnpopup().click();
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        if (dms1528PageObject.getConnecteduser_text().isVisible()) {
        Assert.assertTrue(dms1528PageObject.getConnecteduser_text().isVisible());
        }else {
            Assert.assertTrue(dms1528PageObject.getCk_editor().isVisible());
        }

    }

    @Then("User will click the Cancel button, confirm the popup by clicking Yes, and then be redirected to the All Document Screen")
    public void User_will_click_the_Cancel_button_confirm_the_popup_by_clicking_Yes_and_then_be_redirected_to_the_All_Document_Screen(){
        Assert.assertTrue(dMS1931PageObject.getCancel_Button().isVisible());
        dMS1931PageObject.getCancel_Button().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1553PageObject.getYesbuttonOnpopup().isVisible());
        dms1553PageObject.getYesbuttonOnpopup().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dMS1931PageObject.getDocuments_text().isVisible());
    }

    @Then("User is able to see confirmation popup, switching tabs without saving change, need to click on 'Yes' to proceed with redirection")
    public void User_is_able_to_see_confirmation_popup_switching_tabs_without_saving_change_need_to_click_on_Yes_to_proceed_with_redirection(){
        dMS1931PageObject.CheckConfirmationPOPUPWhileChangingTab();

    }

    @Then("User will do some Changes and click on Reset Current Changes button to Reset Current ChangesSuccessfully")
    public void User_will_do_some_Changes_and_click_on_Reset_Current_Changes_button_to_Reset_Current_ChangesSuccessfully(DataTable dataTable){
        dMS1931PageObject.CheckTheFunctionalityOFResetCurrentChangesButton(dataTable);
    }

    @Then("User will Click on the save as Draft Button and able to see success message")
    public void User_will_Click_on_the_save_as_Draft_Button_and_able_to_see_success_message(){
        Assert.assertTrue(dms1528PageObject.getSave_as_draftButton().isVisible());
        dms1528PageObject.getSave_as_draftButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1928AsausershouldbeAbletoOpentheDetailsofanyRequestDirectlyFromtheListingScreenPageObject.getMessageforUpdateStatus().getText().contains("General terms saved successfully"));
    }




}





