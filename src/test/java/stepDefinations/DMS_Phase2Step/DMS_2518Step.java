package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.*;
import PageObjects.DocumentTemplate.DocumentTemplatePageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_2518Step extends PageObject {

    DMS_2518PageObject dms_2518PageObject;
    DMS_1523PageObject dms1523PageObject;
    DMS_1528PageObject dms1528PageObject;
    DMS_1571PageObject dms1571PageObject;
    DMS_2199PageObject dms2199pageobject;
    DMS_1553PageObject dms1553PageObject;
    DMS_2025PageObject dms2025PageObject;


    @And("User can see and able to fill organization filter LEI filter org type filter doc type filter in all the fields")
    public void User_can_see_and_able_to_fill_organization_filter_LEI_filter_org_type_filter_doc_type_filter_in_all_the_fields(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms_2518PageObject.randomllySelectOrganizationName();
        dms_2518PageObject.randomllySelectDocType();
        dms_2518PageObject.randomllySelectLEIs();
        dms_2518PageObject.randomllySelectOrgtype();
    }

    @And("User will Click on next button and redirected to Update Approval Matrix Screen")
    public void User_will_Click_on_next_button_and_redirected_to_Update_Approval_Matrix_Screen(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms_2518PageObject.getNext_btn_CreateNewApprovalMatrix_Screen().isVisible());
        dms_2518PageObject.getNext_btn_CreateNewApprovalMatrix_Screen().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms_2518PageObject.getUpdateApprovalMatrix_text().isVisible());
    }

    @Then("User will able to see Apply USP Rider under Document Action")
    public void User_will_able_to_see_Apply_USP_Rider_Document_Action(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms_2518PageObject.getApplyUSPRider_UnderDocumentAction().isVisible());
    }
    @And("User will Select input for Document type")
    public void User_will_Select_input_for_Document_type(){
        dms_2518PageObject.EnterinputforDoctype();
    }

    @And("User will Redirected to Approval matrix listing screen")
    public void User_will_Redirected_to_Approval_matrix_listing_screen(){
        dms1523PageObject.navigateToApprovalMatrixListingScreen();
        withAction().pause(Duration.ofSeconds(3)).build().perform();

    }
    @Then("User will Click on Update button and Redirected to Update Approval Matrix Screen")
    public void User_will_Click_on_Update_button_and_Redirected_to_Update_Approval_Matrix_Screen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1523PageObject.getUpdate_btn().isVisible());
        dms1523PageObject.getUpdate_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms_2518PageObject.getUpdateApprovalMatrix_text().isVisible());
    }
    @Then("User will Click on Update button and Redirected to Update Document template screen")
    public void User_will_Click_on_Update_button_and_Redirected_to_Update_Document_template_screen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1523PageObject.getUpdate_btn().isVisible());
        dms1523PageObject.getUpdate_btn().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        dms1528PageObject.getUpdate_document_template_text().waitUntilVisible();
        Assert.assertTrue(dms1528PageObject.getUpdate_document_template_text().isVisible());
    }

    @And("User will able to see and fill template name organisation name and Doctype")
    public void User_will_able_to_see_and_fill_template_name_organisation_name_and_Doctype(DataTable dataTable){
        dms1528PageObject.Entertemplatename(dataTable);
        dms_2518PageObject.randomllySelectOrganizationName();
        dms_2518PageObject.randomllySelectDocType();
    }

    @And("User will be redirected to document template screen")
    public void User_will_be_redirected_to_document_template_screen(){
        dms1523PageObject.navigateToDocumenttemplateListingScreen();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User will Select Action type then Click on submit Button and Redirected to approval workflow tab on Edit Document Screen")
    public void User_will_Select_Action_type_then_Click_on_submit_Button_and_Redirected_to_approval_workflow_tab_on_Edit_Document_Screen(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getApprovalworkflow_table().isVisible());
    }

    @Then("User will click on Edit Button and redirect to approval workflow tab on Edit Document Screen")
    public void User_will_click_on_Edit_Button_and_redirect_to_approval_workflow_tab_on_Edit_Document_Screen(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditButton().isVisible());
        dms2199pageobject.getEditButton().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
        Assert.assertTrue(dms1528PageObject.getApprovalworkflow_table().isVisible());
    }

    @And("User will Click on Action type dropdown and able to see Apply USP Rider in the dropdown list")
    public void User_will_Click_on_Action_type_dropdown_and_able_to_see_Apply_USP_Rider_in_the_dropdown_list(List<String> filtered_item){
        dms_2518PageObject.filteredActiontypeforEditPOPup(filtered_item) ;
    }

    @And("User will select Action type as Apply USP Rider")
    public void User_will_select_Action_type_as_Apply_USP_Rider(DataTable dataTable){
        dms2199pageobject.SelectActionType(dataTable);
    }

    @Then("User will click on Submit Button and Redirected to USP Rider Tab on Edit Document Screen")
    public void User_will_click_on_Submit_Button_and_Redirected_to_USP_Rider_Tab_on_Edit_Document_Screen(){
        Assert.assertTrue(dms2199pageobject.getSubmitButtonONEDIT_POPUP().isVisible());
        dms2199pageobject.getSubmitButtonONEDIT_POPUP().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        Assert.assertTrue(dms2199pageobject.getEditDocument_text().isVisible());
        if (dms1553PageObject.getNObuttonOnpopup().isVisible()){
            dms1553PageObject.getNObuttonOnpopup().click();
        }
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    @And("User is able to see all the buttons and all the tab Disabled except USP Rider and Preview&Submit")
    public void User_is_able_to_see_all_the_buttons_and_all_the_tab_Disabled_except_USP_Rider_and_PreviewandSubmit(){
        Assert.assertTrue(dms1528PageObject.getApproval_workflowTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getEnforcement_ruleTab().isDisabled());
        Assert.assertTrue(dms1528PageObject.getLegal_termTab().isDisabled());
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isDisabled());
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isDisabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isEnabled());
        Assert.assertTrue(dms2025PageObject.getGeneral_Term_Tab().isDisabled());
        Assert.assertTrue(dms2025PageObject.getPreviewANDSubmit_Tab().isEnabled());
        Assert.assertTrue(dms2199pageobject.getUSPRider_button().isVisible());
        Assert.assertTrue(dms2199pageobject.getUSPRiderContainer().isVisible());
        Assert.assertTrue(dms2199pageobject.getCancel_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getReset_Current_changes_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getSave_As_draft_Button().isVisible());
        Assert.assertTrue(dms2199pageobject.getSubmit_forApproval_Button().isVisible());
    }

    @And("User will perform changes for USP Rider Tab and Submit for approval and able to see approved document on listing screen")
    public void User_will_perform_changes_for_USP_Rider_Tab_and_Submit_for_approval_and_able_to_see_approved_document_on_listing_screen(){
        dms_2518PageObject.performchangesONUSPRidertab();
    }
}
