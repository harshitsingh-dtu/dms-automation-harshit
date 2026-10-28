package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1569_PageObject;
import PageObjects.DMS_PHASE2PageObject.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1569_Step extends PageObject
{
    DMS_1569_PageObject single_edit_document_doc_type_dn_pageObject;

    @When("Click on document status filter set the {string}")
    public void click_on_document_status_filter_set_the_filter(String filter) {
        single_edit_document_doc_type_dn_pageObject.check_if_filterStatus_and_type(filter);
    }
    @When("Click on Document ID Search {string}")
    public void click_on_document_id_search_for_a_document(String documentID) {
        single_edit_document_doc_type_dn_pageObject.search_document(documentID);
    }
    @When("Edit button should be visible to the user under the Action column")
    public void edit_button_should_be_visible_to_the_user_under_the_action_column()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isVisible());
    }


    @And("Click on Document Version ID Search {string}")
    public void clickOnDocumentVersionIDSearchForADocument(String documentVersionID)
    {
        single_edit_document_doc_type_dn_pageObject.search_document_using_versionid(documentVersionID);
    }

    @And("Click on on edit button")
    public void clickOnOnEditButton()
    {
        single_edit_document_doc_type_dn_pageObject.Click_on_doc_edit_button();
    }

    @Then("All the tabs should be present on the edit screen for Draft {string}")
    public void allTheTabsShouldBePresentOnTheEditScreenforDraft(String DocType)
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentVersionid_text().isVisible());
        Assert.assertEquals(DocType,single_edit_document_doc_type_dn_pageObject.get_DocumentType_text());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAllowedcurrencies_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPartyPrimebBroker1_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPartyExecutingBroker1_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPartyClient1text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_approvalworkflow().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_enforcementrules().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_legalterms().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_authscope().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_limiscope().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_previewandsubmit().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNext_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSave_as_draft_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReset_current_changes_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button().isEnabled());

    }
    @Then("All the tabs should be present on the edit screen for Enforced {string}")
    public void allTheTabsShouldBePresentOnTheEditScreenforEnforced(String DocType)
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentVersionid_text().isVisible());
        Assert.assertEquals(DocType,single_edit_document_doc_type_dn_pageObject.get_DocumentType_text());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAllowedcurrencies_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPartyPrimebBroker1_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPartyExecutingBroker1_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPartyClient1text().isVisible());
    }

    @When("Click on document status filter set the filter {string}")
    public void click_on_document_status_draft_set_the(String filter)
    {
      single_edit_document_doc_type_dn_pageObject.check_if_filterStatus_and_enter(filter);
    }

    @And("Apply Quit")
    public void ApplyQuit()
    {
        single_edit_document_doc_type_dn_pageObject.quit();
    }

    @And("Select {string} And {string}")
    public void selectActingAsAndActionType(String ActingAs, String ActionType)
    {
        single_edit_document_doc_type_dn_pageObject.select_acting_as(ActingAs);
        single_edit_document_doc_type_dn_pageObject.select_action_type(ActionType);
    }

    @And("click on the submit button on pop up screen")
    public void clickOnTheSubmitButtonOnPopUpScreen()
    {
        single_edit_document_doc_type_dn_pageObject.click_on_the_submit_button_on_the_edit_pop_up_screen();
    }

    @And("Verify elements for APPROVAL WORKFLOW")
    public void verifyElementsForAPPROVALWORKFLOW()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_approvalworkflow().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_previewandsubmit().isEnabled());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSubmit_for_approval_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSave_as_draft_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReset_current_changes_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button().isEnabled());


        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getInitiator_tab().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPrime_Broker_1_tab().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getExecuting_Broker_1_tab().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getClient_1_tab().isVisible());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNEW_DOCUMENT_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEDIT_APPROVAL_WORKFLOW_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEDIT_ENFORCEMENT_RULES_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEDIT_LEGAL_TERMS_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getREMOVE_CURRENCY_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getREMOVE_PRODUCTS_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEDIT_LIMIT_INCREASE_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEDIT_LIMIT_DECREASE_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEDIT_DOCUMENTS_Action().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTERMINATE_DOCUMENT_Action().isVisible());
    }

    @And("Verify elements for EDIT ENFORCEMENT RULES")
    public void verifyElementsFor_EDIT_ENFORCEMENT_RULES()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_enforcementrules().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_previewandsubmit().isEnabled());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSubmit_for_approval_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSave_as_draft_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReset_current_changes_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button().isEnabled());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_termination_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_amendment_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_new_document_text().isVisible());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_termination_Schedule_Radio_button().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_amendment_Schedule_Radio_button().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_new_document_Schedule_Radio_button().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_termination_immediate_Radio_button().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_amendment_immediate_Radio_button().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getFor_newdocument_immediate_Radio_button().isVisible());

//        #    Checking req. ---------------------------------
        if (single_edit_document_doc_type_dn_pageObject.getFor_new_document_Schedule_Radio_button().isSelected()) {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getValuefor_fornewdocument_Schedule().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDurationfor_fornewdocument_Schedule().isVisible());
        }
        if (single_edit_document_doc_type_dn_pageObject.getFor_amendment_Schedule_Radio_button().isSelected()){
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getValuefor_foramendment_Schedule().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDurationfor_foramendment_Schedule().isVisible());
        }
        if (single_edit_document_doc_type_dn_pageObject.getFor_termination_Schedule_Radio_button().isSelected()){
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getValuefor_fortermination_Schedule().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDurationfor_fortermination_Schedule().isVisible());
        }

    }

    @And("Verify elements for EDIT LEGAL TERMS")
    public void verifyElementsForEDITLEGALTERMS()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_legalterms().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_authscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_previewandsubmit().isEnabled());


        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSubmit_for_approval_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSave_as_draft_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReset_current_changes_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button().isEnabled());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNumber_of_connected_user_text().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCK_editor().isVisible());
    }

    @And("Click on Auth Scope tab")
    public void clickOnAuthScopeTab()
    {
        single_edit_document_doc_type_dn_pageObject.ClickOnAuthScopeTab();
    }

    @And("Verify elements for Auth Scope tab")
    public void verifyElementsForAuthScopeTab()
    {
        if (single_edit_document_doc_type_dn_pageObject.getNo_Auth_scope_defined_Text().isVisible()) {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectProductGroupInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectAssetClassInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectProductFamilyInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectProductInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAddCurrenciesButton().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAuthTenorValueInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAddAuthLineButton().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNo_Auth_scope_defined_Text().isVisible());
        }
        else {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectProductGroupInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectAssetClassInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectProductFamilyInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSelectProductInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAddCurrenciesButton().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAuthTenorValueInput().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAddAuthLineButton().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCopy_Button().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDelete_Button().isVisible());
             }
    }

    @And("Verify elements for REMOVE CURRENCY")
    public void verifyElementsForREMOVECURRENCY()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_approvalworkflow().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_enforcementrules().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_legalterms().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_authscope().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_limiscope().isDisabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTab_previewandsubmit().isEnabled());

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCurrencies_tab().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCurrencies_pair_tab().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSubmit_for_approval_btn().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSave_as_draft_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReset_current_changes_button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button().isEnabled());

    }

    @And("Click on limit Scope Tab")
    public void clickOnLimitScopeTab()
    {
        single_edit_document_doc_type_dn_pageObject.ClickOnLimitScopeTab();
    }

    @And("Verify elements for limit Scope Tab")
    public void VerifyElementsForLimitScopeTab()
    {
        if (single_edit_document_doc_type_dn_pageObject.getNo_Auth_scope_defined_Text().isVisible()) {

            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCalculationType_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getLimitValue_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNettingType_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDelta_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getProductFamily_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getExcludeCLS_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAddLimit_btn().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNo_Auth_scope_defined_Text().isVisible());

        }
        else
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCalculationType_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getLimitValue_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getNettingType_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDelta_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getProductFamily_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getExcludeCLS_tab().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getAddLimit_btn().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCopy_Button().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDelete_Button().isEnabled());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEdit_Button().isEnabled());

        }
    }

    @And("Click on Submit for Approval button")
    public void clickOnSubmitForApprovalButton()
    {
        single_edit_document_doc_type_dn_pageObject.ClickOnSubmit_for_approval();
    }

    @And("Drag the participant to the document action vs approval sequence")
    public void dragTheParticipantToTheDocumentActionVsApprovalSequence(DataTable dataTable)
    {
        single_edit_document_doc_type_dn_pageObject.drag_and_drop_for_approval_workflow(dataTable);
    }



    @And("click on ck Editor Type into all document content")
    public void clickOnCkEditorTypeIntoAllDocumentContent()
    {
        single_edit_document_doc_type_dn_pageObject.EnterTextInCK_Editor();

    }

    @And("click on the currencies or currencies pair to be removed")
    public void clickOnTheCurrenciesCurrenciesPairToBeRemoved()
    {

    }

    @And("Verify elements for REMOVE PRODUCTS")
    public void verifyElementsForREMOVEPRODUCTS()
    {
        if (single_edit_document_doc_type_dn_pageObject.getNo_Auth_scope_defined_Text().isVisible())
        {
            single_edit_document_doc_type_dn_pageObject.getNo_Auth_scope_defined_Text().isVisible();
        }
        else {
            single_edit_document_doc_type_dn_pageObject.getDelete_Button().isVisible();
        }
    }

    @And("click on the Delete button for the product to be removed")
    public void clickOnTheDeleteButtonForTheProductToBeRemoved()
    {
        if (single_edit_document_doc_type_dn_pageObject.getDelete_Button().isVisible()){
            single_edit_document_doc_type_dn_pageObject.Click_on_delete_button_to_remove_product();
        }
    }

    @Then("Verify elements for Draft document on all document listing screen")
    public void verifyElementsForDraftDocumentOnAllDocumentListingScreen() {

        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentDelete_btn().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCompare_Button().isEnabled());
    }


    @Then("Verify elements for Enforced document on all document listing screen")
    public void verifyElementsForEnforcedDocumentOnAllDocumentListingScreen()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTerminate_Button().isEnabled());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDownload_Button().isEnabled());

    }

    @Then("Verify elements for Approved document on all document listing screen")
    public void verifyElementsForApprovedDocumentOnAllDocumentListingScreen()
    {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCompare_Button().isVisible());
        }

    }

    @Then("Verify elements for Rejected document on all document listing screen")
    public void verifyElementsForRejectedDocumentOnAllDocumentListingScreen()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCompare_Button().isVisible());
    }

    @Then("Verify elements for Cancelled document on all document listing screen")
    public void verifyElementsForCancelledDocumentOnAllDocumentListingScreen()
    {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentDelete_btn().isVisible());
        }
    }

    @Then("Verify elements for Terminated document on all document listing screen")
    public void verifyElementsForTerminatedDocumentOnAllDocumentListingScreen()
    {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentDelete_btn().isVisible());
        }
    }

    @Then("Verify elements for Expired document on all document listing screen")
    public void verifyElementsForExpiredDocumentOnAllDocumentListingScreen()
    {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCompare_Button().isVisible());
        }
    }

    @And("User will click on cancel button")
    public void userWillClickOnCancelButton()
    {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentCancel_btn().isVisible());
            single_edit_document_doc_type_dn_pageObject.getDocumentCancel_btn().click();
        }
        else
        {
            Utility.quiting_and_failing();
        }

    }
    @And("User will click on GT cancel button")
    public void userWillClickOnGTCancelButton()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocumentCancel_btn().isVisible());
        single_edit_document_doc_type_dn_pageObject.getDocumentCancel_btn().click();
    }

    @And("Verify pop up {string}")
    public void verifyPopUp(String popUp_text)
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPopUp_Body().isVisible());
        if (single_edit_document_doc_type_dn_pageObject.getPopUp_Body().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPopUp_No_button().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getPopUp_Yes_button().isVisible());
            Assert.assertEquals(popUp_text,single_edit_document_doc_type_dn_pageObject.getPopUp_text().getText());
        }
    }


    @And("Click on NO button")
    public void clickOnNOButton()
    {
            single_edit_document_doc_type_dn_pageObject.getPopUp_No_button().click();

    }

    @And("Click on the compare button")
    public void clickOnTheCompareButton()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCompare_Button().isVisible());
        single_edit_document_doc_type_dn_pageObject.getCompare_Button().click();
    }

    @And("Verify elements on compare page")
    public void verifyElementsOnComparePage()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCurrentVersion_text_on_compare_screen().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getEnforcedVersion_text_on_compare_screen().isVisible());

    }

    @And("Click on the Terminate button")
    public void clickOnTheTerminateButton()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getTerminate_Button().isVisible());
        if (single_edit_document_doc_type_dn_pageObject.getTerminate_Button().isVisible()){
            single_edit_document_doc_type_dn_pageObject.getTerminate_Button().click();
        }

    }

    @And("Select {string}")
    public void select(String ActingAs)
    {
        single_edit_document_doc_type_dn_pageObject.select_acting_as(ActingAs);
    }

    @Then("Verify elements on Terminate popUp")
    public void verifyElementsOnTerminatePopUp()
    {
        if (single_edit_document_doc_type_dn_pageObject.getPopUp_Body().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSubmit_Terminate_popup().isVisible());
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button_on_popup().isVisible());
        }
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }

    @And("Click on submit button of popup")
    public void clickOnSubmitButtonOfPopup()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getSubmit_Terminate_popup().isVisible());
        single_edit_document_doc_type_dn_pageObject.getSubmit_Terminate_popup().click();
    }
    @And("verify toast notification should be display")
    public void verifyToastNotificationShouldBeDisplay()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getToast_notification().isVisible());

    }

    @And("Click on the Approve button")
    public void clickOnTheApproveButton() {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible()&&single_edit_document_doc_type_dn_pageObject.getApprove_button_All_document_listing_screen().isVisible())
        {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getApprove_button_All_document_listing_screen().isVisible());
            single_edit_document_doc_type_dn_pageObject.getApprove_button_All_document_listing_screen().click();
        }
        else
        {
            Utility.quiting_and_failing();
        }
    }

    @And("Verify elements for Approve popup")
    public void verifyElementsForApprovePopup()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button_on_popup().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getActing_as_input_field().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getApproval_group_input_field().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getApprove_button_on_popup().isVisible());

    }

    @And("Click on the Reject button")
    public void clickOnTheRejectButton() {
        if (!single_edit_document_doc_type_dn_pageObject.getNoRecordFound_txt().isVisible()&&single_edit_document_doc_type_dn_pageObject.getApprove_button_All_document_listing_screen().isVisible()) {
            Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReject_button_All_document_listing_screen().isVisible());
            single_edit_document_doc_type_dn_pageObject.getReject_button_All_document_listing_screen().click();
        }
        else
        {
            Utility.quiting_and_failing();
        }
    }

    @And("Verify elements for Reject popup")
    public void verifyElementsForRejectPopup()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getCancel_button_on_popup().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getActing_as_input_field().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getApproval_group_input_field().isVisible());
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getReject_button_on_popup().isVisible());

    }

    @And("Remove roles")
    public void removeRoles(List<String> roles)
    {
        single_edit_document_doc_type_dn_pageObject.remove_role(roles);
    }

    @And("Click on document status filter set the filter Draft and Check edit button")
    public void clickOnDocumentStatusFilterSetTheFilterDraftAndCheckEditButton(List<String> filter)
    {
        single_edit_document_doc_type_dn_pageObject.select_document_status_filter(filter);
    }

    @And("Click on document status filter set the filter Enforced")
    public void clickOnDocumentStatusFilterSetTheFilterEnforced(List<String> filter)
    {
        single_edit_document_doc_type_dn_pageObject.select_document_status_filter(filter);
    }

    @And("Verify elements for draft documents if user have VIEW OWN permission only")
    public void verifyElementsForDraftDocumentsIfUserHaveVIEW_OWNPermissionOnly()
    {
        Assert.assertFalse(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isVisible());
    }

    @And("Verify elements for enforced documents if user have VIEW OWN permission only")
    public void verifyElementsForEnforcedDocumentsIfUserHaveVIEW_OWNPermissionOnly()
    {
        Assert.assertFalse(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isVisible());
    }

    @And("Verify elements for draft documents if user have VIEW ALL permission only")
    public void verifyElementsForDraftDocumentsIfUserHaveVIEW_ALLPermissionOnly()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isVisible());

    }

    @And("Verify elements for enforced documents if user have VIEW ALL permission only")
    public void verifyElementsForEnforcedDocumentsIfUserHaveVIEW_ALLPermissionOnly()
    {
        Assert.assertTrue(single_edit_document_doc_type_dn_pageObject.getDocument_edit_btn().isVisible());
    }

    @Then("click on the submit button on product group popup")
    public void sumit_on_prod_grp_popup() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        single_edit_document_doc_type_dn_pageObject.getSubmitProdButton().click();
    }

}
