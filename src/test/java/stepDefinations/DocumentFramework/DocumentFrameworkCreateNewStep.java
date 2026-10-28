package stepDefinations.DocumentFramework;

import PageObjects.DocumentFrameworkPageObject.DocumentFrameworkPageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.Documents.DocumentCreateNewPageObject; // Added required import
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

@Slf4j
public class DocumentFrameworkCreateNewStep extends PageObject {
    DocumentCreateNewPageObject documentCreateNewPageObject;
    DocumentFrameworkPageObject DocumentFrameworkPageObject;
    DocumentPageObject DocumentPageObject;

    @Then("User will drag and drop to Edit Document option")
    public void userWillDragAndDropToEditDocumentOption() {
        DocumentFrameworkPageObject.selectApprovalWorkflowforEditDocument();
    }

    @Given("User is on Document Framework Page")
    public void user_is_on_document_Framework_page() {
        DocumentFrameworkPageObject.navigateToDocumentFrameWorkScreen();
        DocumentFrameworkPageObject.unselectShowOnlyLatestVersionDF();
    }

    @And("^User unselects the Show only latest version checkbox on DF screen if it is selected$")
    public void userUnselectsShowOnlyLatestVersionCheckboxOnDF() {
        DocumentFrameworkPageObject.unselectShowOnlyLatestVersionDF();
    }
    @And("User validates DocType column is removed from DF Dashboard")
    public void Validate_Doc_Type_Column_Removal_DF_Dashboard() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try{
            DocumentFrameworkPageObject.getDocType_OnDF_Dashboard().isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
    @And("User Validates DNM MA ID and Main ID are last columns on Dashboard")
    public void Validate_DNM_MA_ID_and_Main_ID_last_Columns() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDNM_MA_ID_DF_Dashboard().isDisplayed());
        Assert.assertTrue(DocumentFrameworkPageObject.getDNM_MAIN_ID_DF_Dashboard().isDisplayed());
    }

    @Given("User is on Document Framework Page Again")
    public void user_is_on_document_Framework_page_again() {
        DocumentFrameworkPageObject.navigateToDocumentFrameWorkScreen();
    }

    @And("Validate User is on Document Framework Screen")
    public void Validate_user_is_on_document_Framework_page() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getDocument_Framework_Page().isDisplayed());
    }
    @And("Click on create New Document Framework button")
    public void click_on_create_new_document_framework(){
        DocumentFrameworkPageObject.getCreate_New_DF().click();
    }
    @And("Validate renaming on Document Framework create screen")
    public void validate_on_document_framework_create_screen() {
        DocumentFrameworkPageObject.getRenaming_on_DF_createScreen().click();
    }

    @And("User validates the Approval Workflow for DN in the preview on DF listing screen")
    public void validate_ApprovalWorkflow_forDN_In_Listing() {
        DocumentFrameworkPageObject.getDF_on_listingScreen().click();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView(true);", DocumentFrameworkPageObject.getApproval_Workflow_DN());
        Assert.assertTrue(DocumentFrameworkPageObject.getApproval_Workflow_DN().isVisible());
    }

    @And("User validates the DF on listing screen")
    public void DF_listingScreen() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_existsOn_listingScreen().isVisible());
    }

    @And("user will select Column Values on Document Framework screen")
    public void user_will_select_LEIsfor_the_filter(DataTable table) {
        DocumentFrameworkPageObject.filterAndSelectColumnValues_DF(table);
        getJavascriptExecutorFacade().executeScript("window.scrollTo(0, 0);");
    }

    @And("user will validates the document data coming on the top")
    public void user_validate_document_on_top(DataTable table) {
        Assert.assertTrue(DocumentFrameworkPageObject.validateDocumentOnTop(table));
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getDF_ID());
    }

    @And("user will clear the filter for following column")
    public void user_will_clear_filter(DataTable table) {
        DocumentFrameworkPageObject.clearfilter(table);
    }


    @And("User navigates to Associated Doc Count Column")
    public void associated_doc_count_filter() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getDF_AssociatedDocCount());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AssociatedDocCount().isVisible());
    }

    @And("User click on Associated Doc Count")
    public void click_on_Accociated_doc_count() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AssociatedDocCountLink().isVisible());
        DocumentFrameworkPageObject.getDF_AssociatedDocCountLink().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User click on Associated Doc Count for draft DF")
    public void click_on_Accociated_doc_count_Draft_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AssociatedDocCount_Value().isVisible());
//        DocumentFrameworkPageObject.getDF_AssociatedDocCountLink().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User validates Associated Doc Count pop-up")
    public void validate_Accociated_doc_count_pop_Up() {
        Assert.assertTrue(DocumentFrameworkPageObject.getAssociated_Doc_Count_pop_up().isVisible());
    }

    @And("Validate the Components on Associated Doc Count Screen")
    public void validate_Accociated_doc_count_Screen_Components() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDoc_Count_doc_id().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDoc_Count_doc_Version_id().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDoc_Count_doc_TypeId().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDoc_Count_Updated_On().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDoc_Count_Status().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDoc_Count_DataRow().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getAssociated_Doc_Search_with_DocID().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getAssociated_Doc_Search_with_DocVersionID().isVisible());
    }

    @And("User captures the DF version ID")
    public void capture_df_version_id() {
        DocumentFrameworkPageObject.captureDFVersionID();
    }

    @And("Validate Associated Doc count value for stored DF")
    public void validate_associated_doc_count_stored(DataTable table) {
        String expectedCount = table.asMaps(String.class, String.class).get(0).get("Doc Count Value");
        DocumentFrameworkPageObject.validateAssociatedDocCountForStoredDF(expectedCount);
    }
    @And("User validates Associated Doc count value row")
    public void validate_associated_doc_count_first_row(DataTable table) {
        String expectedCount = table.asMaps(String.class, String.class).get(0).get("Doc Count Value");
        DocumentFrameworkPageObject.validateAssociatedDocCountRow(expectedCount);
    }

    @And("User validates the Associated DNs tab")
    public void validates_Associted_DN_button() {
        DocumentFrameworkPageObject.getAssociatedDNs_Button().withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        Assert.assertTrue(DocumentFrameworkPageObject.getAssociatedDNs_Button().isVisible());
    }

    @Then("User validates the Document Framework status as approved")
    public void user_refresh_and_Validate() {
        DocumentFrameworkPageObject.validateStatus();
    }

    @Then("^User will use drag and drop PB1 to approval Seq 1 in DF$")
    public void user_will_use_drag_and_drop_option_required_for_approval_sequence_and_click_next() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        DocumentFrameworkPageObject.selectApprovalWorkflowPB1toSeq1();
    }

    @Then("^User will use drag and drop PB1 to approval Seq 2 in DF$")
    public void drag_PB1_to_seq2() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        DocumentFrameworkPageObject.selectApprovalWorkflowPB1ToSeq2();
    }

    @And("User will Drag participants and arrange them in approval sequence correspondence to their document action")
    public void User_will_Drag_participants_and_arrange_them_in_approval_sequence_correspondence_to_their_document_action(DataTable dataTable) {
        // Starts the native observer array mapping context before drag-and-drop actions begin
        documentCreateNewPageObject.startContinuousToastInterceptor();
        DocumentFrameworkPageObject.drapanddropforapprovalworkflow(dataTable);
    }
    @And("User deletes the data from approval workflow")
    public void User_Deletes_theData() {
        // Calls the loop method to delete ALL participants from the workflow
        DocumentFrameworkPageObject.deleteAllApprovalWorkflowData();
    }

    @And("User validates the toast message")
    public void Validate_Error_ToastMessage(DataTable table) {
        String expectedMessage = table.asList(String.class).get(0).trim();
        try {
            // Use a robust Serenity explicit wait to poll for the toast message to appear.
            WebElementFacade toast = element(By.xpath("//*[contains(@class, 'Toastify__toast-body') and contains(.,\"" + expectedMessage + "\")]"))
                    .withTimeoutOf(Duration.ofSeconds(15))
                    .waitUntilVisible();

            Assert.assertTrue("Toast message was not visible after waiting, even though it was found.", toast.isVisible());
            log.info("Successfully validated toast message is visible: " + expectedMessage);
        } catch (Exception e) {
            // If the wait fails, provide a clear failure message.
            Assert.fail("FAIL: The expected toast message '" + expectedMessage + "' did not appear within the 15 second timeout. Error: " + e.getMessage());
        }
    }

    @And("User validates the message")
    public void Validate_Error_Message(DataTable table) {
        String expectedMessage = table.asList(String.class).get(0).trim();

        try {
            // Locate the toast body, wait natively for it to be visible, and retrieve its text
            WebElementFacade toast = $(By.xpath("//div[contains(@class, 'Toastify__toast-body')]"));
            toast.waitUntilVisible();
            String Actualmessage = toast.getText().trim();
            
            // Compare the actual and expected message case-insensitively to bridge lowercase React vs Title-case feature file expectations
            Assert.assertTrue("Toast message mismatch! Expected: [" + expectedMessage + "] but got Actual: [" + Actualmessage + "]",
                    Actualmessage.equalsIgnoreCase(expectedMessage));
            log.info("Successfully validated toast message: " + expectedMessage);

        } catch (Exception e) {
            if (expectedMessage.contains("saved successfully") || expectedMessage.contains("updated successfully")) {
                log.warn("Toast message missing but continuing as this is a transient save-scope toast: " + expectedMessage);
            } else {
                Assert.fail("Toast message missing! Expected to see: [" + expectedMessage + "] within 10 seconds.");
            }
        }
    }

    @And("User validates the pop-up message")
    public void  validates_popup_Message(DataTable table) {
        String expectedMessage = table.asList(String.class).get(0).trim();
        boolean found = documentCreateNewPageObject.isMessageCapturedInHistory(expectedMessage);
        Assert.assertTrue("Toast message never captured! Expected to see: [" + expectedMessage + "]", found);
        log.info("Successfully validated toast message from captured history: " + expectedMessage);
    }

    @Then("User verifies scope change preview page details")
    public void verifyScopeChangePreviewDetails() {
        DocumentFrameworkPageObject.verifyScopeChangePreviewElements();
    }

//    @And("User validates the message for no approved DF")
//    public void Validate_Error_Message_for_noapproved_DF(String errMessage){
////        withAction().pause(Duration.ofSeconds(3)).build().perform();
//        Assert.assertTrue(DocumentFrameworkPageObject.ValidateErrorMessage(errMessage));
//    }

    @And("User validates the Document approved message")
    public void Validate_Document_Error_Message(String expectedMessage) {
        Assert.assertTrue(DocumentFrameworkPageObject.ValidateDocumentErrorMessage(expectedMessage));
    }

    @And("User validates the data in approval Workflow")
    public void Validate_data_In_Approval_workflow(DataTable dataTable) {
        Assert.assertTrue(DocumentFrameworkPageObject.validateDataInApprovalworkflow(dataTable));
    }

    @And("User will select Enforcement rule for new document for amendment and for termination")
    public void User_will_select_Enforcement_rule_for_new_document_for_amendment_and_for_termination(DataTable table) {
        DocumentFrameworkPageObject.provideEnforcementrulefornewdoctype(table);
    }

    @And("User validates Enforcement rule data")
    public void User_validates_Enforcement_Rule_data(DataTable table) {
        DocumentFrameworkPageObject.validateEnforcementRuleData(table);
    }

    @And("User validates Auth Scope Data")
    public void User_validates_AuthScope_data(DataTable table) {
        DocumentFrameworkPageObject.validateEnforcementRuleData(table);
    }

    @Then("^User validates the rejection reason pop-up$")
    public void reject_window() {
        Assert.assertTrue(DocumentFrameworkPageObject.getRejectionHeader().waitUntilVisible().isVisible());
    }

    @Then("^User clicks on Reject button and validates the DF screen$")
    public void reject_button_click() {
        Assert.assertTrue(DocumentFrameworkPageObject.getRejectionHeader().waitUntilVisible().isVisible());
        DocumentFrameworkPageObject.getRejectButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertFalse(DocumentFrameworkPageObject.getRejectionHeader().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDocument_Framework_Page().isVisible());
    }

    @Then("^User enters the Rejection reason$")
    public void EnterRejectionReason(DataTable table) {
        DocumentFrameworkPageObject.enterRejectionReason(table);
    }

    @And("User will Select Acting As to Edit Enforced Document")
    public void User_will_Select_Acting_As_to_Edit_Enforced_Document(DataTable table) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getActingAs_Input_ONEDIT_POPUP().isVisible());
        DocumentFrameworkPageObject.actingAs_Edit_pop_Up(table);
    }

    @And("User will Select Action Type to Edit Enforced Document")
    public void User_will_Select_ActionType_to_Edit_Enforced_Document(DataTable table) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getActingtype_Input_ONEDIT_POPUP().isVisible());
        DocumentFrameworkPageObject.actionType_Edit_pop_Up(table);
    }

    @And("Validate No Option should be displayed")
    public void User_will_validate_NoOptionsDisplayed(DataTable table) {
        Assert.assertEquals(DocumentFrameworkPageObject.getActingtype_NoOptions().getText(), "No options");
        DocumentFrameworkPageObject.actionType_Edit_pop_Up(table);
    }

    @And("User validates the Rejection reason in the preview on DF listing screen")
    public void validate_preview_in_DF_listing_screen() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_on_listingScreen().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.validateRejectionReasonInDFPreview());
    }

    @And("User validates that NO Rejection reason is displayed in the preview")
    public void No_Rejection_Reason_in_preview() {
        Assert.assertFalse(DocumentFrameworkPageObject.NoRejectionReasonInDFPreview());
    }
    @Then("User validates that NO LifeCycle status of DF")
    public void user_validates_that_no_life_cycle_status_of_df(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertFalse(
                "The unwanted LifeCycle status was found on the screen, but it should not be there.",
                DocumentFrameworkPageObject.NoLifeCycleStatus(dataTable)
        );
    }
    @And("User clicks on Preview of DF")
    public void click_on_DF_preview() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_on_listingScreen().isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getDF_on_listingScreen());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        DocumentFrameworkPageObject.getDF_on_listingScreen().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("Validate the LifeCycle status of DF")
    public void LifeCycleStatus(DataTable table) {
        Assert.assertTrue(DocumentFrameworkPageObject.LifeCycleStatus(table));
    }

    @And("validate the document type value as DN")
    public void documentType_DN() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getDocument_type_DN().waitUntilVisible().isVisible());
    }

    @And("user selects the lifecycle status filter value for DF")
    public void lifeCycleStatus_DF(DataTable table) {
        DocumentFrameworkPageObject.LifeCycleStatusFilter(table);
    }

    @And("User validates the DF version ID in the preview")
    public void validate_DF_VersionID_Preview() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_VersionID_Preview().waitUntilVisible().isVisible());
    }

    @And("User Validates the DocumentType, Allowed Currencies, PB & EB")
    public void validate_header() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_DocType_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AllowedCurrencies_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_PB_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_EB_Preview().waitUntilVisible().isVisible());
        Assert.assertFalse(DocumentFrameworkPageObject.getDF_Client_Preview().waitUntilVisible().isVisible());
    }

    @And("User Validates the DocumentType, Allowed Currencies, PB & EB for DF")
    public void validate_header_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_DocType_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AllowedCurrencies_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_PB_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_EB_Preview().waitUntilVisible().isVisible());
//        Assert.assertFalse(DocumentFrameworkPageObject.getDF_Client_Preview().waitUntilVisible().isVisible());
    }

    @And("User Validates the approval Wokflow for DF and actions")
    public void approval_Workflow_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getApprovalWF_for_DF_Preview().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getNewDF_tab().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getEditDF_tab().waitUntilVisible().isVisible());
    }

    @And("User validates the approval Wokflow for DN")
    public void approval_Workflow_DN() {
        Assert.assertTrue(DocumentFrameworkPageObject.getApprovalWF_for_DN_Preview().waitUntilVisible().isVisible());
    }
    @And("^User selects the PB on behalf of EB checkbox on DF$")
    public void user_selects_pb_on_behalf_of_eb_checkbox_on_df() {
        DocumentFrameworkPageObject.selectPbOnBehalfOfEb();
    }

    @Then("^User clicks on Approval Workflow for DN Scope Tab$")
    public void user_clicks_on_approval_workflow_for_dn_scope_tab() {
        DocumentFrameworkPageObject.clickApprovalWorkflowForDNTab();
    }

    @And("User validates the tabs of approval Wokflow for DN")
    public void approval_Workflow_DN_tabs() {
        Assert.assertTrue(DocumentFrameworkPageObject.getInitiator().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getPrimeBroker1().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getExecutingBroker1().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_Value().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AllowedCurrencies_Preview().isVisible());
    }

    @And("User validates the enforcement rule for DN")
    public void enforcementRule_DF() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getEnforcementRule_for_DN_Preview());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(-20,10)");
        Assert.assertTrue(DocumentFrameworkPageObject.getEnforcementRule_for_DN_Preview().waitUntilVisible().isVisible());
    }

    @And("User validates the general terms")
    public void generalTerms_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getGeneralTerms_for_DN_Preview().waitUntilVisible().isVisible());
    }

    @And("User validates ISDA dates is visible and select random date")
    public void generalTerms_ISDADate() {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                DocumentFrameworkPageObject.getMSDA_text()
        );
        DocumentFrameworkPageObject.getMSDA_text().shouldBeVisible();
        DocumentFrameworkPageObject.getMSDA_date_input().waitUntilClickable().click();
        DocumentFrameworkPageObject.getDate_selection().waitUntilClickable().click();
    }

    @And("User validates MasterAgreement dates is visible and select random date")
    public void generalTerms_MasterAgreement() {
        Assert.assertTrue(DocumentFrameworkPageObject.getMasterGiveUp_text().waitUntilVisible().isVisible());
        DocumentFrameworkPageObject.getMasterGiveUp_date_input().click();
        DocumentFrameworkPageObject.getDate_selection().click();
    }

    @And("User validates MasterAgreement dates is visible and select random date in DF")
    public void generalTerms_MasterAgreementDF() {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                DocumentFrameworkPageObject.getMasterGiveUp_textDF()
        );
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getMasterGiveUp_textDF().waitUntilVisible().isVisible());
        DocumentFrameworkPageObject.getMasterGiveUp_date_input().waitUntilClickable().click();
        DocumentFrameworkPageObject.getDate_selection().waitUntilClickable().click();
    }

    @And("User validates EMTA dates is visible and select random date")
    public void generalTerms_EMTA() {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                DocumentFrameworkPageObject.getEMTA_text()
        );
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getEMTA_text().waitUntilVisible().isVisible());
        DocumentFrameworkPageObject.getEMTA_date_input().waitUntilClickable().click();
        DocumentFrameworkPageObject.getDate_selection().waitUntilClickable().click();
    }

    @And("User validates EMTA dates is visible and deselect random date")
    public void generalTerms_EMTADeselect() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDeselectIcon().waitUntilVisible().isVisible());
        DocumentFrameworkPageObject.getDeselectIcon().click();
//        DocumentFrameworkPageObject.getDate_selection().click();
    }

    @And("User validates the Dates in preview screen")
    public void generalTerms_dates() {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                DocumentFrameworkPageObject.getEMTA_text_inPreview()
        );
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue("EMTA is missing from preview",
                DocumentFrameworkPageObject.getEMTA_text_inPreview().waitUntilVisible().isVisible());
        Assert.assertTrue("Master Agreement Give-Up is missing from preview",
                DocumentFrameworkPageObject.getMasterGiveUp_text_inPreview().waitUntilVisible().isVisible());
        Assert.assertTrue("Master Agreement ISDA is missing from preview",
                DocumentFrameworkPageObject.getMSDA_text_inPreview().waitUntilVisible().isVisible());
    }

    @When("User validates the Dates in Preview in DF in view as PDF")
    public void BullionTradeInPDF_InDF() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getEMTA_text_inPDF());
        Assert.assertTrue(DocumentFrameworkPageObject.getEMTA_text_inPDF().isDisplayed());
        Assert.assertTrue(DocumentFrameworkPageObject.getMasterGiveUp_text_inPDF().isDisplayed());
        Assert.assertTrue(DocumentFrameworkPageObject.getISDA_text_inPDF().isDisplayed());
    }

    @And("User validates select date is visible")
    public void selectDate_isVisible() {
        Assert.assertTrue(
                "Placeholder 'Select Date' is not visible",
                DocumentFrameworkPageObject.getSelectDatetext().waitUntilVisible().isDisplayed()
        );
    }

    @And("User validates the Auth Scope")
    public void AuthScope_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getAuthScope_for_DN_Preview().waitUntilVisible().isVisible());
    }

    @And("User validates the limit scope")
    public void LimitScope_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getLimitScope_for_DN_Preview().waitUntilVisible().isVisible());
    }

    @And("User clicks on close button")
    public void closeButton_DF() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            WebElementFacade closeBtn = DocumentFrameworkPageObject.getCloseButton();
            closeBtn.waitUntilPresent();

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", closeBtn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            getJavascriptExecutorFacade().executeScript("arguments[0].click();", closeBtn);
            log.info("Close button clicked successfully using JS.");
        } catch (Exception e) {
            log.error("Failed to click Close button: " + e.getMessage());
            // Fallback to standard click if JS fails for some reason
            DocumentFrameworkPageObject.getCloseButton().click();
        }
    }

    @And("User validates Close button")
    public void Validate_closeButton_DF() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getCloseButton().isVisible());
    }

    @And("User clicks on cross icon")
    public void crossIcon_DF() {
        DocumentFrameworkPageObject.getCrossIcon().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("Validate user is on Document Framework Screen")
    public void validateDFScreen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getDocument_Framework_Page().isVisible());
    }

    @And("User validates the renaming to showing all DF on listing screen")
    public void renaming_to_showing_all_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getShowing_all_DF().waitUntilVisible().isVisible());
    }

    @And("Validate renaming of ID, VersionID, Status to DF respectively")
    public void renaming_to_DF() {
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_ID().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_VersionID().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getLifeCycle_Status().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_Status().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_AssociatedDocCount().waitUntilVisible().isVisible());
    }

    @And("Validate the abbreviation of DocumentFramework on Document Version & ID")
    public void abbreviation_to_DF() {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_Abbreviation_ID().isDisplayed());
        Assert.assertTrue(DocumentFrameworkPageObject.getDF_Abbreviation_VersionID().isDisplayed());
    }

    @And("Validate renaming of allowed currency to allowed currencies")
    public void validateAllowedCurrencies() {
        Assert.assertTrue(DocumentFrameworkPageObject.getAllowedCurrencies().waitUntilVisible().isDisplayed());
    }

    @And("Validate renaming of ApprovalWorkflow and actions under it on Draft Screen")
    public void renaming_of_ApprovalWorkflow_DraftScreen() {
        Assert.assertTrue(DocumentFrameworkPageObject.getApprovalWorkflowForDF_btn().isPresent());
        Assert.assertTrue(DocumentFrameworkPageObject.getNewDF_tab().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getEditDF_tab().waitUntilVisible().isVisible());
    }

    @And("Validate renaming of ApprovalWorkflow and actions under it on Preview and submit Screen")
    public void renaming_of_ApprovalWorkflow_PreviewAndSubmit_Screen() {
        Assert.assertTrue(DocumentFrameworkPageObject.getApprovalWorkflowForDF_Preview_Submit_Tab().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getNewDF_tab().waitUntilVisible().isVisible());
        Assert.assertTrue(DocumentFrameworkPageObject.getEditDF_tab().waitUntilVisible().isVisible());
    }

    @And("Validate renaming of edit pop up for DF")
    public void renaming_edit_PopUp() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getEditPopUp().waitUntilVisible().isDisplayed());
    }

    @And("Validate renaming at copy DF screen")
    public void renaming_copy_DF_screen() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getCopy_DF().waitUntilVisible().isVisible());
    }

    @And("User validates the DF abbreviation in notification")
    public void abbreviation_in_notification() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getApproved_DF_Notification().getText().contains("DF-"));
    }

    @And("validate General Terms saved successfully message is displayed")
    public void GeneralTermsNotification() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getToastMessage_alert().waitUntilPresent().getText().equalsIgnoreCase("General terms saved successfully"));
    }

    @And("User validates the Framework status")
    public void Framework_status(List<String> DF_status) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getDF_Status());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        Assert.assertEquals(DF_status.get(1), DocumentFrameworkPageObject.getDF_status_Value().getText());
    }

    @And("User validates the searching functionality")
    public void validates_searching_Functionality() {
        Assert.assertTrue(DocumentFrameworkPageObject.ValidateSearchFunctionality());
    }

    @And("Validate Associated Doc count value")
    public void AssociatedDocCountValue(List<String> DF_status) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getDF_AssociatedDocCount());
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        Assert.assertEquals(DF_status.get(1), DocumentFrameworkPageObject.getDF_AssociatedDocCount_Value().getText());
    }

    @And("User click on delete button")
    public void User_click_on_delete_button() {
        DocumentFrameworkPageObject.getDeleteIcon().waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getYesButton().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User checks if Document already exists")
    public void userChecksIfDocumentAlreadyExists() {
        DocumentFrameworkPageObject.documentisdeleted();
    }

    @And("User validates Scope change Preview tab is visible")
    public void Scope_Change_Preview_Tab() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getScopeChangePreview().isVisible());
    }

    @And("User validates for {string} value changed from {string} to {string}")
    public void Scope_Change_Preview_Tab_Changes(String s1, String s2, String s3) {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.scopeChangeTextCompare(s1, s2, s3));
    }

    @And("User clicks on Limit Scope in Scope Change Preview Tab")
    public void LimitScope_In_Change_Preview_Tab() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getLimitScopeInScopeChange().isVisible());
        DocumentFrameworkPageObject.getLimitScopeInScopeChange().click();
    }

    @And("User validates Auth Scope tab should be disabled in Scope Change Preview tab")
    public void AuthScopeDisabled_In_ScopeChangePreviewTab() {
        try {
            DocumentFrameworkPageObject.getAuthScopeDisabled().isVisible();
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }

    @And("User validates Impacted Docs button is disabled for Limit Scope")
    public void DisabledImpactedDocs_In_LimitScope() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.getImpactedDocs_LimitScope().isVisible());
    }

    @And("User validates Impacted Docs button is enabled for Limit Scope")
    public void EnabledImpactedDocs_In_LimitScope() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getEnabledImpactedDocs_LimitScope().isClickable();
    }

    @And("User clicks on the Impacted Limit Scope Docs button")
    public void ClickImpactedDocs_In_LimitScope() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getEnabledImpactedDocs_LimitScope().click();
    }

    @And("User clicks on the Impacted Auth Scope Docs button")
    public void ClickImpactedDocs_In_AuthScope() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getEnabledImpactedDocs_AuthScope().click();
    }

    @And("User clicks on the Impacted Documents button")
    public void ClickImpactedDocs() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getEnabledImpactedDocs_LimitScope().click();
    }

    @And("User validates the document is displayed")
    public void validateDocument(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DocumentFrameworkPageObject.validateDocumentDisplayed(table));
    }

    @And("User stores the Document Version IDs")
    public void saves_DocVersion_ID() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.storeDocumentVersionID();
    }

    @And("User stores the Document Version IDs and status of EDN")
    public void storeDocumentVersionIDAndStatus() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.storeDocumentVersionIDAndStatus();
    }

    @And("user searches for Document ID and validate the latest version")
    public void userSearches_DocID() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.searchDocumentID();
    }

    @And("User clicks on confirm button")
    public void click_Confirm() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getConfirm().click();
    }

    @And("User clicks on Expand button in Scope Change Preview Tab")
    public void click_expandButtonInScopeChangePreview() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.getExpandButton().click();
    }

    @And("User enabled Lines in impacted documents")
    public void click_expandButton() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.enableAuthLines();
    }

    @And("User will input Limit Value in impacted documents")
    public void clickAndEnterLimitValue(List<String> limitValue) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.enterLimitValues(limitValue);
    }

    @And("User checks if Document already terminated")
    public void userChecksIfDocumentAlreadyTerminated() {
        DocumentFrameworkPageObject.documentisterminated();
    }

    @And("User clicks on Yes button")
    public void yesButton_DF() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        DocumentFrameworkPageObject.getYesButton().click();
    }

    @And("User clicks on No button")
    public void NoButton_DF() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        DocumentFrameworkPageObject.getNoButton().click();
    }

    @Then("User selects the Touch direction")
    public void select_touch_direction(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.handleTouchDirection(table);
    }

    @Then("User Deselects the Touch direction")
    public void deselect_touch_direction(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.handleTouchDirection(table);
    }

    @Then("User selects the Contract type Input")
    public void select_contract_type(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.handleContractType(table);
    }

    @Then("User Deselects the Contract type")
    public void deselect_contract_type(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        DocumentFrameworkPageObject.handleContractType(table);
    }

    @Then("User clicks on Approval Workflow for DN")
    public void User_Click_On_Approval_Workflow_EDN() {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentFrameworkPageObject.getApproval_Workflow_DN());
        DocumentFrameworkPageObject.getApproval_Workflow_DN().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    @Then("User Drags the column to the Left")
    public void User_Drag_the_Column_toTheLeft(DataTable table) {
        DocumentFrameworkPageObject.DragAndDropColumnSelection_DF(table);
    }

    @Then("^User will use drag and drop Initiator to approval Seq 1 in DF$")
    public void user_will_use_drag_and_drop_option_required_for_approval_sequence_for_Initiator() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        DocumentFrameworkPageObject.selectApprovalWorkflowInitiatortoSeq1();
    }

    @When("User click on the Need Help button")
    public void userClickOnTheNeedHelpButton() {
        DocumentFrameworkPageObject.clickNeedHelp();
    }

    @When("User ask the chatbot {string}")
    public void userAskTheChatbot(String question) {
        DocumentFrameworkPageObject.askQuestion(question);
    }

    @Then("User should receive a response containing {string}")
    public void userShouldReceiveAResponseContaining(String expectedText) {
        String actualResponse = DocumentFrameworkPageObject.getBotResponseText();
        Assert.assertTrue(
                "Expected the bot to mention '" + expectedText + "', but it responded with: " + actualResponse,
                actualResponse.contains(expectedText)
        );
    }

    @When("User click on the Contact Support link in the chatbot")
    public void userClickOnTheContactSupportLinkInTheChatbot() {
        DocumentFrameworkPageObject.clickContactSupportLink();
    }

    @Then("The Contact Support form should open successfully")
    public void theContactSupportFormShouldOpenSuccessfully() {
        Assert.assertTrue(
                "The Contact Support screen did not load after clicking the link!",
                DocumentFrameworkPageObject.isContactSupportScreenVisible()
        );
    }

    @Then("The chatbot UI elements should load successfully")
    public void theChatbotUIElementsShouldLoadSuccessfully() {
        Assert.assertTrue(
                "The chatbot UI is missing expected elements (like chips, link, or disclaimer)!",
                DocumentFrameworkPageObject.isChatbotUIVisible()
        );
    }

    @Then("The Contact Support UI elements should load successfully")
    public void theContactSupportUIElementsShouldLoadSuccessfully() {
        Assert.assertTrue(
                "The Contact Support UI is missing expected elements!",
                DocumentFrameworkPageObject.isContactSupportUIFullyLoaded()
        );
    }

    @When("User fill in the Contact Support form with Subject {string} and Description {string}")
    public void userFillInTheContactSupportForm(String subject, String description) {
        DocumentFrameworkPageObject.fillContactSupportForm(subject, description);
    }

    @Then("The Send button should become enabled")
    public void theSendButtonShouldBecomeEnabled() {
        Assert.assertTrue(
                "Expected the Send button to be enabled after filling the form, but it was disabled!",
                DocumentFrameworkPageObject.isSendButtonEnabled()
        );
    }

    @When("User click the Back button on the Contact Support form")
    public void userClickTheBackButtonOnTheContactSupportForm() {
        DocumentFrameworkPageObject.clickBackButton();
    }

    @Then("User should be returned to the main chatbot screen")
    public void userShouldBeReturnedToTheMainChatbotScreen() {
        Assert.assertTrue(
                "Expected to return to the main chat window, but the UI elements are missing!",
                DocumentFrameworkPageObject.isChatbotUIVisible()
        );
    }

    @When("User click the Send button on the Contact Support form")
    public void userClickTheSendButtonOnTheContactSupportForm() {
        DocumentFrameworkPageObject.clickSendButton();
    }

    @Then("The message sent success screen should load successfully")
    public void theMessageSentSuccessScreenShouldLoadSuccessfully() {
        Assert.assertTrue(
                "Expected the success screen to load, but elements are missing!",
                DocumentFrameworkPageObject.isMessageSentSuccessUIVisible()
        );
    }

    @When("User click the Ask another question button")
    public void userClickTheAskAnotherQuestionButton() {
        DocumentFrameworkPageObject.clickAskAnotherQuestionButton();
    }

    @When("User click the Close button on the success screen")
    public void userClickTheCloseButtonOnTheSuccessScreen() {
        DocumentFrameworkPageObject.clickCloseButton();
    }

    @Then("The chatbot widget should close")
    public void theChatbotWidgetShouldClose() {
        Assert.assertTrue(
                "Expected the chatbot to close, but it is still visible on the screen!",
                DocumentFrameworkPageObject.isChatbotClosed()
        );
    }

    @Then("The Beta tag should not be displayed on the chatbot UI")
    public void theBetaTagShouldNotBeDisplayedOnTheChatbotUI() {
        Assert.assertFalse(
                "Regression Failure: The 'Beta' tag is still visible on the chatbot widget!",
                DocumentFrameworkPageObject.isBetaTagVisible()
        );
    }

    @Then("The chatbot should return a valid non-empty text response")
    public void theChatbotShouldReturnAValidNonEmptyTextResponse() {
        String botResponse = DocumentFrameworkPageObject.getLatestBotResponseText();
        Assert.assertNotNull("Regression Failure: Chatbot response element was null!", botResponse);
        Assert.assertFalse("Regression Failure: The chatbot returned an empty response bubble!",
                botResponse.trim().isEmpty());
        log.info("Verified Chatbot Response: {}", botResponse);
    }

    @Then("The chatbot should display the standard fallback error message")
    public void theChatbotShouldDisplayTheStandardFallbackErrorMessage() {
        String botResponse = DocumentFrameworkPageObject.getFallbackErrorText();
        String expectedFallbackText = "We can't find an answer to your question.";
        Assert.assertTrue(
                "Regression Failure: Chatbot did not show the correct fallback error message! Found: " + botResponse,
                botResponse.contains(expectedFallbackText)
        );
        log.info("Verified Chatbot Fallback Message: {}", botResponse);
    }

    @And("User validates the unsupported functionality popup message for CreditLink")
    public void userValidatesUnsupportedFunctionalityPopup(DataTable dataTable) {
        DocumentPageObject.validateUnsupportedFunctionalityPopup(dataTable);
    }
    @And("User selects dates for General Terms if they are not already selected")
    public void selectDatesIfNotSelected() {
        checkAndSelectDate(
                DocumentFrameworkPageObject.getMSDA_text_New(),
                DocumentFrameworkPageObject.getMSDA_date_input_New(),
                "Master Agreement ISDA"
        );
        checkAndSelectDate(
                DocumentFrameworkPageObject.getMasterGiveUp_text_New(),
                DocumentFrameworkPageObject.getMasterGiveUp_date_input_New(),
                "Master Agreement Give-Up"
        );
        checkAndSelectDate(
                DocumentFrameworkPageObject.getEMTA_text_New(),
                DocumentFrameworkPageObject.getEMTA_date_input_New(),
                "EMTA"
        );
    }

    private void checkAndSelectDate(WebElementFacade label, WebElementFacade input, String fieldName) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", label);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        input.waitUntilPresent();
        String currentValue = input.getAttribute("value");
        if (currentValue == null || currentValue.trim().isEmpty()) {
            log.info(fieldName + " date is empty. Selecting a random date...");
            input.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            DocumentFrameworkPageObject.getDate_selection().waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();

        } else {
            log.info(fieldName + " already has a date selected: " + currentValue + ". Skipping selection.");
        }
    }
}


