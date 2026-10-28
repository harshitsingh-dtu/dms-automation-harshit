package PageObjects.DocumentFrameworkPageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PageObjects.Documents.DocumentPageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Slf4j
@Data
public class DocumentFrameworkPageObject extends PageObject {
    DocumentPageObject DocumentPageObject;
    Actions act = new Actions(getDriver());

    @FindBy(xpath = "//input[@class='lp-copy-sel__input']")
    private WebElementFacade actingasTerminate;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn_Terminate;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade YesButtonDelete;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade YesButton;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Document Frameworks']")
    private WebElementFacade Document_Framework_tab;
    @FindBy(xpath = "//button[text()='+ Create new Document Framework']")
    private WebElementFacade Create_New_DF;
    @FindBy(xpath = "//div[@data-testid='restriction-title' and contains(text(), 'Document Frameworks (DF)')]")
    private WebElementFacade Document_Framework_Page;
    @FindBy(xpath = "//div[text()='Create Document Framework']")
    private WebElementFacade Renaming_on_DF_createScreen;
    @FindBy(xpath = "//*[@value='DN']")
    private WebElementFacade Document_type_DN;
    @FindBy(xpath = "//th[descendant::*[normalize-space()='Lifecycle status']]//input")
    private WebElementFacade lifecycle_Filter;
    @FindBy(xpath = "//*[text()='Showing all Document Frameworks']")
    private WebElementFacade showing_all_DF;
    @FindBy(xpath = "//*[text()='DF ID'] | //*[contains(text(), 'Document framework ID')]")
    private WebElementFacade DF_ID;
    @FindBy(xpath = "//*[@data-testid='doc-table-th-allowedCurrencies' or text()='Allowed currencies']")
    private WebElementFacade AllowedCurrencies;
    @FindBy(xpath = "//*[text()='Lifecycle status']")
    private WebElementFacade LifeCycle_Status;
    @FindBy(xpath = "//*[@data-testid='doc-table-th-dfVersionId' or text()='DF version ID']")
    private WebElementFacade DF_VersionID;
    @FindBy(xpath = "//*[translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'df status']")
    private WebElementFacade DF_Status;
    @FindBy(xpath = "//span[starts-with(@data-testid, 'cell-restriction-status-') and contains(@class, 'Active')]")
    private WebElementFacade DF_status_Value;
    @FindBy(xpath = "(//td[contains(normalize-space(.), 'DF-')])[1]")
    private WebElementFacade DF_Abbreviation_ID;
    @FindBy(xpath = "(//button[contains(normalize-space(.), 'DF-')])[1]")
    private WebElementFacade DF_Abbreviation_VersionID;
    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr//td[3]//span")
    private WebElementFacade Life_cycle_status;
    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')] | //div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")
    private WebElementFacade menu_btn;
    @FindBy(xpath = "//*[text()='Associated doc count']")
    private WebElementFacade DF_AssociatedDocCount;
    @FindBy(xpath = "//button[@class='link document-count']")
    private WebElementFacade DF_AssociatedDocCountLink;
    @FindBy(xpath = "//button[@class=' document-count']")
    private WebElementFacade DF_AssociatedDocCount_Value;
    @FindBy(xpath = "//div[contains(text(),'Associated Documents for')]")
    private WebElementFacade Associated_Doc_Count_pop_up;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentId' or contains(translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'document id')]")
    private WebElementFacade Doc_Count_doc_id;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentVersionId' or contains(text(),'Document version ID') or contains(text(),'Document version Id')]")
    private WebElementFacade Doc_Count_doc_Version_id;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentType' or contains(text(),'Document type')]")
    private WebElementFacade Doc_Count_doc_TypeId;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-updatedBy' or contains(text(),'Updated by')]")
    private WebElementFacade Doc_Count_Updated_By;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-updatedOn' or contains(text(),'Updated on')]")
    private WebElementFacade Doc_Count_Updated_On;
    @FindBy(xpath = "//th[contains(text(),'Status')]")
    private WebElementFacade Doc_Count_Status;
    @FindBy(xpath = "//table[@class='custom-batch-table']//tbody//tr[1]")
    private WebElementFacade Doc_Count_DataRow;
    @FindBy(xpath = "//input[@placeholder='Search with document ID']")
    private WebElementFacade Associated_Doc_Search_with_DocID;
    @FindBy(xpath = "//input[@placeholder='Search with document version ID']")
    private WebElementFacade Associated_Doc_Search_with_DocVersionID;
    @FindBy(xpath = "//button[text()='Associated DNs']")
    private WebElementFacade AssociatedDNs_Button;
    @FindBy(xpath = "//table[@class='custom-batch-table']//tbody//tr[1]//td[2]")
    private WebElementFacade AssociatedDoc_VersionID_Value;
    @FindBy(xpath = "//table[@class='custom-batch-table']//tbody//tr[1]//td[1]")
    private WebElementFacade AssociatedDoc_Value;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-docType' or text()='Doc type']")
    private WebElementFacade DocType_OnDF_Dashboard;
    @FindBy(xpath = "//*[@data-testid='column-label-dnmMaId']")
    private WebElementFacade DNM_MA_ID_DF_Dashboard;
    @FindBy(xpath = "//*[@data-testid='column-label-dnmMaMainId']")
    private WebElementFacade DNM_MAIN_ID_DF_Dashboard;
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Document']")
    private WebElementFacade document_tab;
    @FindBy(xpath = "//button[text()='Approval Workflow for Document Framework']")
    private WebElementFacade approvalWorkflowForDF_btn;
    @FindBy(xpath = "//td[@data-testid='drag-table-action-name-1' or contains(text(),'New Document Framework')]")
    private WebElementFacade NewDF_tab;
    @FindBy(xpath = "//td[@data-testid='drag-table-action-name-9' or contains(text(),'Edit Document Framework')]")
    private WebElementFacade EditDF_tab;
    @FindBy(xpath = "//div[@class='dragBox']//div[contains(text(),'Prime Broker - 1')]")
    private WebElementFacade PB1_participant;
    @FindBy(xpath = "//div[@class='dragBox']//div[contains(text(),'Initiator')]")
    private WebElementFacade Initiator;
    @FindBy(xpath = "(//div[text()='Drag and Drop here the participant'])[1]")
    private WebElementFacade approvalSeq1;
    @FindBy(xpath = "//div[@data-testid='drop-cell-placeholder-1-seq-1']")
    private WebElementFacade dropCellPlaceholder_NewDocument_Seq1;
    @FindBy(xpath = "//div[@data-testid='drop-cell-placeholder-9-seq-1']")
    private WebElementFacade approvalSeq2;
    @FindBy(xpath = "//td[text()='Edit Document']/..//td[2]/div[1]/div")
    private WebElementFacade editDocumentAW;
    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade RejectButton;
    @FindBy(xpath = "//p[text()='Reject']")
    private WebElementFacade RejectionHeader;
    @FindBy(xpath = "//textarea[@class='rejection-reason-text']")
    private WebElementFacade RejectionReasonBox;
    @FindBy(xpath = "//div[@class='lp-copy-sel__input-container css-19bb58m']")
    private WebElementFacade ActingAs_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//label[text()='Action type']/following::input")
    private WebElementFacade Actingtype_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr[1]//button[contains(text(), '4W-') or contains(text(), 'DF-') or contains(text(), 'DN-')] | //table[@class='doc-table']//tbody//tr[1]/td[2]/button | //table[@class='doc-table']//tbody//tr[1]//button[@aria-label='Preview' or @title='Preview' or contains(@class,'preview')] | //table[@class='doc-table']//tbody//tr[1]//td[contains(@class,'version')]//button | //table[@class='doc-table']//tbody//tr[1]/td[2]/div")
    private WebElementFacade DF_on_listingScreen;
    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade Actingtype_NoOptions;
    @FindBy(xpath = "//*[contains(text(),'DF-')]")
    private WebElementFacade DF_existsOn_listingScreen;
    @FindBy(xpath = "//span[text()='Life cycle status:']")
    private WebElementFacade LifeCycleStatusInPreviewVisible;
    @FindBy(xpath = "//span[text()='Life cycle status:']/parent::p")
    private WebElementFacade LifeCycleStatusValue;
    @FindBy(xpath = "//div[@class='content-label']")
    private WebElementFacade DF_VersionID_Preview;
    @FindBy(xpath = "//div[contains(text(),'Document type')]")
    private WebElementFacade DF_DocType_Preview;
    @FindBy(xpath = "//div[contains(text(),'Allowed currencies')]")
    private WebElementFacade DF_AllowedCurrencies_Preview;
    @FindBy(xpath = "//div[contains(@data-testid,'info-header-head-title') and contains(text(),'Prime Broker')]")
    private WebElementFacade DF_PB_Preview;
    @FindBy(xpath = "//div[contains(@data-testid,'info-header-head-title') and contains(text(),'Executing Broker')]")
    private WebElementFacade DF_EB_Preview;
    @FindBy(xpath = "//div[contains(@data-testid,'info-header-head-title') and contains(text(),'Client')]")
    private WebElementFacade DF_Client_Preview;
    @FindBy(xpath = "//*[text()='Approval Workflow for Document Framework']")
    private WebElementFacade ApprovalWF_for_DF_Preview;
    @FindBy(xpath = "//*[text()='Approval Workflow for DN']")
    private WebElementFacade Approval_Workflow_DN;
    @FindBy(xpath = "//*[text()='Approval Workflow for DN']")
    private WebElementFacade ApprovalWF_for_DN_Preview;
    @FindBy(xpath = "//*[text()='Initiator']")
    private WebElementFacade InitiatorAG;
    @FindBy(xpath = "(//*[text()='Prime Broker - 1'])[2]")
    private WebElementFacade PrimeBroker1;
    @FindBy(xpath = "(//*[text()='Executing Broker - 1'])[2]")
    private WebElementFacade ExecutingBroker1;
    @FindBy(xpath = "//*[contains(text(),'DF-')]")
    private WebElementFacade DF_Value;
    @FindBy(xpath = "//*[text()='Enforcement Rules for DN']")
    private WebElementFacade EnforcementRule_for_DN_Preview;
    @FindBy(xpath = "//*[text()='General Terms']")
    private WebElementFacade GeneralTerms_for_DN_Preview;
    @FindBy(xpath = "//*[text()='Auth Scope']")
    private WebElementFacade AuthScope_for_DN_Preview;
    @FindBy(xpath = "//*[text()='Limit Scope']")
    private WebElementFacade LimitScope_for_DN_Preview;
    @FindBy(xpath = "//div[@class='preview-wrapper']//button[text()='Approval Workflow for Document Framework']")
    private WebElementFacade approvalWorkflowForDF_Preview_Submit_Tab;
    @FindBy(xpath = "//div[text()='Rejection Reason']")
    private WebElementFacade RejectionReasonVisible;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade closeButton;
    @FindBy(xpath = "//div[@class='preview-header']/*[name()='svg']")
    private WebElementFacade crossIcon;
    @FindBy(xpath = "//input[@value='Edit Document Framework']")
    private WebElementFacade EditPopUp;
    @FindBy(xpath = "//div[text()='Copy Document Framework']")
    private WebElementFacade Copy_DF;
    @FindBy(xpath = "//div[@class='card']/*[name()='svg']")
    private WebElementFacade Delete_ApprovalWorkflow;
    @FindBy(xpath = "//label[@for='Immediate2']")
    private WebElementFacade forAmendment_immediateRadio;
    @FindBy(xpath = "//label[@for='Immediate1']")
    private WebElementFacade forNewDocument_immediateRadio;
    @FindBy(xpath = "//label[@for='Scheduled1']")
    private WebElementFacade fornewdocument_ScheduleRadio;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][1]//input[@type='number']")
    private WebElementFacade valuefor_fornewdocument_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][1]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fornewdocument_Schedule;
    @FindBy(xpath = "//label[@for='Immediate2']")
    private WebElementFacade foramendment_immediateRadio;
    @FindBy(xpath = "//label[@for='Scheduled2']")
    private WebElementFacade foramendment_ScheduleRadio;
    @FindBy(xpath = "//input[@class=\"duration-value\"]")
    private WebElementFacade valuefor_foramendment_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][2]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_foramendment_Schedule;
    @FindBy(xpath = "//label[@for='Immediate3']")
    private WebElementFacade fortermination_immediateRadio;
    @FindBy(xpath = "//label[@for='Scheduled3']")
    private WebElementFacade fortermination_ScheduleRadio;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][3]//input[@type='number']")
    private WebElementFacade valuefor_fortermination_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][3]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fortermination_Schedule;
    @FindBy(xpath = "(//div[@class='list'])[1]/span")
    private WebElementFacade approved_DF_Notification;
    @FindBy(xpath = "(//div[@class='list'])[2]/span")
    private WebElementFacade Draft_DF_Notification;
    @FindBy(xpath = "//div[text()='Master Agreement ISDA']")
    private WebElementFacade MSDA_text;
    @FindBy(xpath = "//input[@data-testid='documentation-date-range-input-maIsda']")
    private WebElementFacade MSDA_date_input;
    @FindBy(xpath = "(//div[@class='react-datepicker__week'])[1]")
    private WebElementFacade date_selection;
    @FindBy(xpath = "//div[text()='Master Agreement Give-Up']")
    private WebElementFacade MasterGiveUp_text;
    @FindBy(xpath = "//div[contains(normalize-space(), 'Master Agreement Give-up')]")
    private WebElementFacade MasterGiveUp_textDF;
    @FindBy(xpath = "//div[contains(normalize-space(), 'Master Agreement Give-up')]/parent::*//input")
    private WebElementFacade MasterGiveUp_date_input;
    @FindBy(xpath = "//div[contains(normalize-space(), 'EMTA')]")
    private WebElementFacade EMTA_text;
    @FindBy(xpath = "//input[@data-testid='documentation-date-range-input-emta']")
    private WebElementFacade EMTA_date_input;
    @FindBy(xpath = "//div[contains(normalize-space(), 'EMTA')]/parent::*//*[@data-testid='CloseIcon']")
    private WebElementFacade DeselectIcon;
    @FindBy(xpath = "//input[@placeholder='Select Date']")
    private WebElementFacade selectDatetext;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade toastMessage_alert;
    @FindBy(xpath = "(//div[text()='EMTA'])[2]")
    private WebElementFacade EMTA_text_inPDF;
    @FindBy(xpath = "(//div[text()='Master Agreement Give-Up'])[2]")
    private WebElementFacade MasterGiveUp_text_inPDF;
    @FindBy(xpath = "(//div[text()='Master Agreement ISDA'])[2]")
    private WebElementFacade ISDA_text_inPDF;
    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade DeleteIcon;
    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade NoButton;
    @FindBy(xpath = "//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'scope change preview')]")
    private WebElementFacade ScopeChangePreview;
    @FindBy(xpath = "(//button[text()='Auth Scope'])[3]//span")
    private WebElementFacade AuthScopeDisabled;
    @FindBy(xpath = "(//button[text()='Limit Scope'])[3]")
    private WebElementFacade LimitScopeInScopeChange;
    @FindBy(xpath = "//div[@class='impact-limit-button']//button[@disabled]")
    private WebElementFacade ImpactedDocs_LimitScope;
    @FindBy(xpath = "//div[@class='impact-limit-button']//button")
    private WebElementFacade EnabledImpactedDocs_LimitScope;
    @FindBy(xpath = "//div[@class='impact-limit-button']//button")
    private WebElementFacade EnabledImpactedDocs_AuthScope;
    @FindBy(xpath = "//th[text()='Document ID']//input")
    private WebElementFacade Document_ID;
    @FindBy(xpath = "//tbody//td[2]/button")
    private WebElementFacade Document_Version_ID_Value;
    @FindBy(xpath = "//*[text()='Confirm']")
    private WebElementFacade Confirm;
    ArrayList<String> documentVersionIDList = new ArrayList<>();
    @FindBy(xpath = "//table[@class='custom-batch-table']//tbody//td[2]")
    List<WebElementFacade> DocVersionIDs;
    HashMap<String, String> documentVersionID_statusList = new HashMap<>();
    @FindBy(xpath = "//span[@id='version']/strong")
    WebElementFacade DocVersionIDs_inImpactedScopeDocs;
    @FindBy(xpath = "//*[@data-testid='ExpandMoreIcon']/..")
    private WebElementFacade ExpandButton;
    @FindBy(xpath = "//div[@class='enable-switch ']")
    private List<WebElementFacade> Enable_AuthLines;
    @FindBy(xpath = "//input[@type='text' and @value='$ 0']")
    private List<WebElementFacade> LimitLines_inImpactedDocs;
    @FindBy(xpath = "//tbody//tr[1]//td[3]/span")
    private WebElementFacade Top_LifeCycleStatus;
    @FindBy(xpath = "//tbody//tr[1]//td[4]")
    private WebElementFacade Top_PBName;
    @FindBy(xpath = "//tbody//tr[1]//td[5]")
    private WebElementFacade Top_EBName;
    @FindBy(xpath = "//div[@class='scope-change']/p/div/span")
    private WebElementFacade ScopeChangeText1;
    @FindBy(xpath = "//div[@class='scope-change']/p/div/b")
    private WebElementFacade ScopeChangeText2;
    @FindBy(xpath = "//button//img[@alt='Terminate']")
    private WebElementFacade documentterminate;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade yesButton;
    @FindBy(xpath = "//label[contains(.,'Up')]//input[@name='checkbox']")
    private WebElementFacade TouchDirection_Up;
    @FindBy(xpath = "//label[contains(text(), 'Down')]/input[@name='checkbox']")
    private WebElementFacade TouchDirection_Down;
    @FindBy(xpath = "//label[contains(., 'Put')]/input[@name='checkbox']")
    private WebElementFacade ContractType_Put;
    @FindBy(xpath = "//label[contains(., 'Call')]/input[@name='checkbox']")
    private WebElementFacade ContractType_Call;
    @FindBy(xpath = "//tr//th[1]")
    private WebElementFacade FirstPosition_Column;
    @FindBy(xpath = "//div[@role='button' and @aria-label='Need help?']")
    private WebElementFacade needHelpButton;
    @FindBy(xpath = "//textarea[@placeholder='Enter your question here']")
    private WebElementFacade chatInputArea;
    @FindBy(xpath = "//button[@aria-label='submit question']")
    private WebElementFacade submitQuestionButton;
    @FindBy(xpath = "//button[contains(@class, 'o-digital-assistant-faq')]")
    private WebElementFacade suggestedQuestionChips;
    // 2. Contact Support Link
    @FindBy(xpath = "//a[contains(@class, 'o-subtle-action') and text()='Contact support']")
    private WebElementFacade contactSupportLink;
    // 3. Disclaimer Text
    @FindBy(xpath = "//span[contains(text(), 'Answers are generated')]")
    private WebElementFacade disclaimerText;
    @FindBy(xpath = "//section[contains(@class, 'o-digital-assistant-response')]//p")
    private WebElementFacade botResponseText;
    @FindBy(xpath = "//label[contains(., 'Subject')]/following::input[1]")
    private WebElementFacade contactSupportSubjectInput;
    @FindBy(xpath = "//label[contains(., 'Description')]/following::textarea[1]")
    private WebElementFacade contactSupportDescriptionArea;
    // Using text contains for the buttons and labels
    @FindBy(xpath = "//button[contains(., 'Send')]")
    private WebElementFacade sendButton;
    @FindBy(xpath = "//button[contains(., 'Back')]")
    private WebElementFacade backButton;
    @FindBy(xpath = "//*[contains(text(), 'A confirmation email will be sent')]")
    private WebElementFacade confirmationEmailText;
    @FindBy(xpath = "//h3[text()='Contact support']")
    private WebElementFacade contactSupportTitle;
    @FindBy(xpath = "//h3[text()='Need help?']")
    private WebElementFacade needHelpTitle;
    @FindBy(xpath = "//*[text()='Your message has been sent!']")
    private WebElementFacade successMessageTitle;
    @FindBy(xpath = "//*[contains(text(), 'Thank you for contacting support')]")
    private WebElementFacade successMessageBody;
    @FindBy(xpath = "//button[contains(., 'Ask another question')]")
    private WebElementFacade askAnotherQuestionButton;
    @FindBy(xpath = "//button[contains(., 'Close')]")
    private WebElementFacade closeChatBotButton;
    @FindBy(xpath = "//*[text()='Beta']")
    private WebElementFacade betaTag;
    @FindBy(xpath = "(//section[contains(@class, 'o-digital-assistant-response')]//p)[last()]")
    private WebElementFacade latestBotResponseBubble;
    @FindBy(xpath = "//*[contains(text(), \"We can't find an answer to your question\")]")
    private WebElementFacade fallbackErrorBubble;
    @FindBy(xpath = "//table[@data-testid='doc-table-element']//tbody//tr[1]//td[starts-with(@data-testid,'table-cell-documentCount-')]")
    private WebElementFacade DocCount_Row;
    @FindBy(xpath = "//label[@class='checkbox-label-df' and @data-testid='latest-version-label-df']//input[@type='checkbox']")
    private WebElementFacade latestVersionCheckboxInputDF;
    @FindBy(xpath = "//label[@class='checkbox-label-df' and @data-testid='latest-version-label-df']")
    private WebElementFacade latestVersionCheckboxLabelDF;
    @FindBy(xpath = "//div[@data-testid='gt-info-label-master-agreement-isda']")
    private WebElementFacade MSDA_text_inPreview;
    @FindBy(xpath = "//div[@data-testid='gt-info-label-master-agreement-give-up']")
    private WebElementFacade MasterGiveUp_text_inPreview;
    @FindBy(xpath = "//div[@data-testid='gt-info-label-emta']")
    private WebElementFacade EMTA_text_inPreview;
    @FindBy(xpath = "//div[@data-testid='documentation-date-label-maIsda']")
    private WebElementFacade MSDA_text_New;
    @FindBy(xpath = "//input[@data-testid='documentation-date-range-input-maIsda']")
    private WebElementFacade MSDA_date_input_New;
    @FindBy(xpath = "//div[@data-testid='documentation-date-label-maGiveup']")
    private WebElementFacade MasterGiveUp_text_New;
    @FindBy(xpath = "//input[@data-testid='documentation-date-range-input-maGiveup']")
    private WebElementFacade MasterGiveUp_date_input_New;
    @FindBy(xpath = "//div[@data-testid='documentation-date-label-emta']")
    private WebElementFacade EMTA_text_New;
    @FindBy(xpath = "//input[@data-testid='documentation-date-range-input-emta']")
    private WebElementFacade EMTA_date_input_New;

    public void filterAndSelectColumnValues_DF(DataTable table) {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> dataTable_map : data) {
            String columnName = dataTable_map.get("Column Name");
            String filterValue = dataTable_map.get("value").trim();
            String lowerCaseColumnName = columnName.toLowerCase().trim();

            log.info("Filtering column: " + columnName);

            try {
                // 1. Flexible Case-insensitive XPath using contains() to ignore sort arrows
                String headerXpath = "//th[descendant::*[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "')]] | //th[contains(translate(@data-testid, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerCaseColumnName + "')]";

                WebElementFacade columnHeader = find(By.xpath(headerXpath));
                columnHeader.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();

                // 2. SCROLL the column header into the center of the view
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", columnHeader);
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // 3. Find the input field specifically inside this visible header
                WebElementFacade filterOnListingScreen = columnHeader.find(By.xpath(".//input"));
                filterOnListingScreen.waitUntilClickable();

                // Focus the input field
                evaluateJavascript("arguments[0].click();", filterOnListingScreen);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                String columnNameUpper = columnName.toUpperCase();

                // Route PB, EB, Client, AND Lifecycle Status to the Dropdown logic
                if (columnNameUpper.contains("PB") || columnNameUpper.contains("EB") || columnNameUpper.contains("CLIENT") || columnNameUpper.contains("STATUS") || columnNameUpper.contains("LIFECYCLE")) {

                    // CRITICAL FIX: Overwrite existing text immediately to prevent lingering characters
                    filterOnListingScreen.sendKeys(Keys.chord(Keys.CONTROL, "a"), filterValue);
                    withAction().pause(Duration.ofSeconds(4)).build().perform();

                    String lowerValue = filterValue.toLowerCase();
                    List<WebElementFacade> options = findAll(By.xpath(
                            "//div[@role='presentation']//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerValue + "')] | " +
                                    "//li[@role='option' and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerValue + "')]"
                    ));

                    WebElementFacade exactMatch = null;
                    for (WebElementFacade option : options) {
                        String optionText = option.getText().replaceAll("\\s+", " ").trim();
                        String compareValue = filterValue.replaceAll("\\s+", " ").trim();
                        if (optionText.equalsIgnoreCase(compareValue)) {
                            exactMatch = option;
                            break;
                        }
                    }

                    if (exactMatch != null) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", exactMatch);
                        try {
                            exactMatch.click();
                        } catch (Exception e) {
                            getJavascriptExecutorFacade().executeScript("arguments[0].click();", exactMatch);
                        }
                        log.info("Successfully selected exact match: " + filterValue);
                    } else {
                        log.error("No exact match found for '{}'. Available options: {}", filterValue,
                                options.stream().map(o -> o.getText().trim()).collect(java.util.stream.Collectors.toList()));
                        Assert.fail("Dropdown exact match not found for: '" + filterValue + "'");
                    }

                } else {
                    // For standard text inputs
                    filterOnListingScreen.sendKeys(Keys.chord(Keys.CONTROL, "a"), filterValue);
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    withAction().sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                }

                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();

            } catch (Exception e) {
                log.error("Failed to filter column '{}'. Error: {}", columnName, e.getMessage());
                Assert.fail("Test failed: Could not filter column '" + columnName + "'. See logs.");
            }
        }
    }
    public void clearfilter(DataTable table) {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            String columnName = dataTable_map.get("Column Name");
            log.info("Clearing filter for column: " + columnName);

            WebElementFacade headerCell = find(By.xpath("//th[descendant::span[normalize-space()='" + columnName + "']]"));
            headerCell.waitUntilPresent();

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", headerCell);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            withAction().moveToElement(headerCell).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            WebElementFacade clickCross = headerCell.find(By.xpath(".//button[1]"));

            try {
                clickCross.withTimeoutOf(Duration.ofSeconds(3)).waitUntilClickable().click();
            } catch (Exception e) {
                log.info("Standard click failed for clear button on " + columnName + ", trying JS click...");
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", clickCross);
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    public boolean validateDocumentOnTop(DataTable table) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        boolean result = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            result = Top_LifeCycleStatus.getText().equalsIgnoreCase(dataTable_map.get("Lifecycle status")) && Top_PBName.getText().equalsIgnoreCase(dataTable_map.get("PB Name")) && Top_EBName.getText().equalsIgnoreCase(dataTable_map.get("EB Name"));
        }
        return result;
    }

    public void validateStatus() {
        if (showing_all_DF.isPresent() && showing_all_DF.isCurrentlyVisible()) {
            log.info("We are on the Listing Screen. Validating status from listing table...");
        } else {
            try {
                Document_Framework_Page.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
            } catch (Exception e) {
                log.warn("Document_Framework_Page not visible, continuing validation from current screen.");
            }
        }
        int attempts = 0;
        String doc_status = "";
        while (attempts < 15) {
            try {
                doc_status = Life_cycle_status.getText().trim();
                if (doc_status.equalsIgnoreCase("Approved")) {
                    break;
                }
            } catch (Exception ignored) {}
            waitABit(1000);
            attempts++;
        }
        log.info("Validated Document Framework Status: " + doc_status);
        Assert.assertTrue(doc_status.equalsIgnoreCase("Approved"));
    }

    public void selectApprovalWorkflowforEditDocument() {
        getJavascriptExecutorFacade().executeScript("arguments[1].scrollIntoView({ block: 'center', inline: 'center' });", editDocumentAW);
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-20)");
        act.dragAndDrop(PB1_participant, editDocumentAW);
        act.pause(Duration.ofSeconds(2)).build().perform();
    }

    public void selectApprovalWorkflowPB1toSeq1() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dropCellPlaceholder_NewDocument_Seq1);
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-20)");

        String script =
                "function simulateDragAndDrop(source, destination) {\n" +
                        "    const dataTransfer = new DataTransfer();\n" +
                        "    const dragStartEvent = new DragEvent('dragstart', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                        "    source.dispatchEvent(dragStartEvent);\n" +
                        "    const dropEvent = new DragEvent('drop', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                        "    destination.dispatchEvent(dropEvent);\n" +
                        "    const dragEndEvent = new DragEvent('dragend', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                        "    source.dispatchEvent(dragEndEvent);\n" +
                        "}\n" +
                        "simulateDragAndDrop(arguments[0], arguments[1]);";
        getJavascriptExecutorFacade().executeScript(script, PB1_participant, dropCellPlaceholder_NewDocument_Seq1);

        act.pause(Duration.ofSeconds(2)).build().perform();

        boolean stillEmpty = !findAll(By.xpath("//div[@data-testid='drop-cell-placeholder-1-seq-1' and normalize-space()='Drag and Drop here the participant']")).isEmpty();
        if (stillEmpty) {
            Assert.fail("Drag and drop of Prime Broker - 1 into Approval sequence - 1 did not register: "
                    + "the cell still shows the empty placeholder text after the simulated drop.");
        }

        act.pause(Duration.ofSeconds(3)).build().perform();
    }

public void selectApprovalWorkflowPB1ToSeq2() {
    getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approvalSeq2);
    getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-20)");
    String script =
            "function simulateDragAndDrop(source, destination) {\n" +
                    "    const dataTransfer = new DataTransfer();\n" +
                    "    const dragStartEvent = new DragEvent('dragstart', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                    "    source.dispatchEvent(dragStartEvent);\n" +
                    "    const dropEvent = new DragEvent('drop', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                    "    destination.dispatchEvent(dropEvent);\n" +
                    "    const dragEndEvent = new DragEvent('dragend', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                    "    source.dispatchEvent(dragEndEvent);\n" +
                    "}\n" +
                    "simulateDragAndDrop(arguments[0], arguments[1]);";
    getJavascriptExecutorFacade().executeScript(script, PB1_participant, approvalSeq2);
    withAction().pause(Duration.ofSeconds(2)).build().perform();
}

    public void enterRejectionReason(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(RejectionReasonBox).click().sendKeys(dataTable.get("Rejection Reason")).build().perform();
    }

    public void actingAs_Edit_pop_Up(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(ActingAs_Input_ONEDIT_POPUP).click().sendKeys(dataTable.get("Acting As")).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void actionType_Edit_pop_Up(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(Actingtype_Input_ONEDIT_POPUP).click().sendKeys(dataTable.get("Action Type")).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public boolean validateRejectionReasonInDFPreview() {
        DF_on_listingScreen.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", RejectionReasonVisible);
        return RejectionReasonVisible.isDisplayed();
    }

    public boolean LifeCycleStatus(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        return LifeCycleStatusValue.getText().contains(dataTable.get("Status"));
    }

    public boolean NoLifeCycleStatus(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String unwantedStatus = dataTable.get("Status");

        if (LifeCycleStatusValue.isCurrentlyVisible()) {
            String actualText = LifeCycleStatusValue.getText();
            return actualText.contains(unwantedStatus);
        }
        return false;
    }

    public void LifeCycleStatusFilter(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String val = data.get(0).get("lifeCycle status").trim();

        log.info("Filtering Lifecycle status with value: " + val);

        // 1. Ensure the filter is in view and click to open
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", lifecycle_Filter);
        lifecycle_Filter.waitUntilClickable().click();

        // 2. Type the value and wait for the dropdown to filter
        withAction().sendKeys(val).pause(Duration.ofSeconds(3)).build().perform();

        // 3. Selection from the presentation layer (handles case sensitivity and highlights)
        String optionXpath = "//div[@role='presentation']//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + val.toLowerCase() + "')] | " +
                             "//li[@role='option' and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + val.toLowerCase() + "')]";

        try {
            WebElementFacade option = find(By.xpath(optionXpath));
            // Force a wait for visibility
            option.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", option);

            try {
                option.click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", option);
            }
            log.info("Successfully selected status: " + val);
        } catch (Exception ex) {
            log.warn("Option '" + val + "' not found via click, attempting keyboard fallback.");
            lifecycle_Filter.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        }

        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public boolean ValidateSearchFunctionality() {
        boolean result = false;
        String searchVersionID = AssociatedDoc_VersionID_Value.getText();
        withAction().moveToElement(Associated_Doc_Search_with_DocVersionID).click().sendKeys(searchVersionID).build().perform();
        if (Doc_Count_DataRow.isDisplayed()) {
            String searchDocID = AssociatedDoc_Value.getText();
            withAction().moveToElement(Associated_Doc_Search_with_DocID).click().sendKeys(searchDocID).build().perform();
            if (Doc_Count_DataRow.isDisplayed()) {
                result = true;
            }
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        return result;
    }

    public void captureDFVersionID() {
        log.info("Attempting to capture DF Version ID from screen header...");

        WebElementFacade idElement = find(By.xpath(
                "//h2[contains(text(),'DF-')] | " +
                        "//div[contains(@class,'header')]//span[contains(text(),'DF-')] | " +
                        "//div[contains(text(),'DF-') and (contains(@class,'version') or contains(@class,'label'))] | " +
                        "//table[@data-testid='doc-table']//tbody//tr[1]//button[starts-with(@data-testid,'cell-version-link-')]"
        ));
        idElement.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();

        String dfVersionID = idElement.getText().trim();
        if (dfVersionID.contains(":")) {
            dfVersionID = dfVersionID.substring(dfVersionID.indexOf(":") + 1).trim();
        }
        if (dfVersionID.toLowerCase().contains("version")) {
            dfVersionID = dfVersionID.replaceAll("(?i)version", "").trim();
        }

        net.serenitybdd.core.Serenity.setSessionVariable("STORED_DF_VERSION_ID").to(dfVersionID);
        log.info("Successfully captured DF Version ID: " + dfVersionID);
    }


    public void validateAssociatedDocCountForStoredDF(String expectedCount) {
        String storedID = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_DF_VERSION_ID");
        if (storedID == null) {
            log.error("No stored DF Version ID found in session. Failing validation.");
            Assert.fail("DF Version ID was not captured in a previous step.");
        }

        log.info("Filtering for stored DF Version ID: " + storedID);
        WebElementFacade filterBox = find(By.xpath("//th[descendant::span[normalize-space()='DF Version ID']]//input"));
        filterBox.waitUntilPresent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", filterBox);
        filterBox.click();
        filterBox.clear();
        filterBox.typeAndEnter(storedID);
        withAction().pause(Duration.ofSeconds(4)).build().perform();

        int columnIndex = -1;
        List<WebElementFacade> headers = findAll(By.xpath("//table//th"));
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().toLowerCase().contains("associated doc count")) {
                columnIndex = i + 1;
                break;
            }
        }

        if (columnIndex == -1) {
            log.warn("Could not find 'Associated Doc Count' column by text, falling back to index 9");
            columnIndex = 9;
        }

        String countCellXPath = "//tr[contains(., '" + storedID + "')]//td[" + columnIndex + "]";
        WebElementFacade countCell = find(By.xpath(countCellXPath));

        String actualCount = "";
        for (int i = 0; i < 10; i++) {
            actualCount = countCell.getText().trim();
            if (actualCount.isEmpty() || actualCount.length() > 5) {
                WebElementFacade btn = countCell.find(By.xpath(".//button"));
                if (btn.isPresent()) actualCount = btn.getText().trim();
            }

            if (!actualCount.isEmpty() && !actualCount.contains("DF-")) {
                break;
            }
            log.info("Waiting for correct count data to populate... Current value: " + actualCount);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }

        log.info("Validation - Stored ID: " + storedID + " | Expected Count: " + expectedCount + " | Actual Count: " + actualCount);
        Assert.assertEquals("Associated Doc Count mismatch for " + storedID, expectedCount, actualCount);
    }

    public void validateAssociatedDocCountRow(String expectedCount) {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DF_AssociatedDocCount);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        DocCount_Row.waitUntilVisible();
        String actualCount = DocCount_Row.getText().trim();
        log.info("Associated Doc Count (first row) - Expected: " + expectedCount + " | Actual: " + actualCount);
        Assert.assertEquals("Associated Doc Count mismatch for first row", expectedCount, actualCount);
    }

    public void drapanddropforapprovalworkflow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        if (!data.isEmpty()) {
            String firstParticipant = data.get(0).get("Participants");
            log.info("Waiting for Approval Workflow screen to load. Checking for participant: " + firstParticipant);
            String xpath = "//div[contains(@class,'dragBox')]//*[contains(normalize-space(.),'" + firstParticipant + "')] | //div[contains(@class,'dragBox')]//*[contains(normalize-space(.),'Initiator')]";
            find(By.xpath(xpath)).withTimeoutOf(Duration.ofSeconds(60)).waitUntilVisible();
        }

        String script =
                "function simulateDragAndDrop(source, destination) {\n" +
                        "    const dataTransfer = new DataTransfer();\n" +
                        "    const dragStartEvent = new DragEvent('dragstart', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                        "    source.dispatchEvent(dragStartEvent);\n" +
                        "    const dropEvent = new DragEvent('drop', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                        "    destination.dispatchEvent(dropEvent);\n" +
                        "    const dragEndEvent = new DragEvent('dragend', {bubbles: true, cancelable: true, dataTransfer: dataTransfer});\n" +
                        "    source.dispatchEvent(dragEndEvent);\n" +
                        "}\n" +
                        "simulateDragAndDrop(arguments[0], arguments[1]);";
        for (Map<String, String> approvalworkflow : data) {
            String participant = approvalworkflow.get("Participants");
            String documentation = approvalworkflow.get("Document_Action");
            String Approvalsequence = approvalworkflow.get("Approval_sequence");
            if (find(By.xpath("//div[@class='dragBox']//div[contains(text(),'" + participant + "')]")).isDisplayed()) {
                WebElementFacade source = find(By.xpath("//div[@class='dragBox']//div[contains(text(),'" + participant + "')]"));
                WebElementFacade destination = find(By.xpath("(//td[text()='" + documentation + "']/following-sibling::td/div[@class='cell-container']/div[@class='drag-over'])[" + Approvalsequence + "]"));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", destination);
                getJavascriptExecutorFacade().executeScript(script, source, destination);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        }
    }

    public Boolean validateDataInApprovalworkflow(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        boolean result = false;
        for (Map<String, String> approvalworkflow : data) {
            String participant = approvalworkflow.get("Participants");
            String documentAction = approvalworkflow.get("Document_Action");
            WebElementFacade documentActionColumn = find(By.xpath("//td[text()='" + documentAction + "']"));
            int Approvalsequence = Integer.parseInt(approvalworkflow.get("Approval_sequence")) + 1;
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentActionColumn);
            WebElementFacade source = find(By.xpath("//td[text()='" + documentAction + "']//..//td[" + Approvalsequence + "]//div[text()='" + participant + "']"));
            if (source.isDisplayed()) {
                result = true;
            }
        }
        return result;
    }

    public boolean NoRejectionReasonInDFPreview() {
        if (RejectionReasonVisible.isCurrentlyVisible()) {
            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", RejectionReasonVisible);
            return true;
        }
        return false;
    }

    public boolean ValidateErrorMessage(String errMessage) {
        WebElementFacade documentActionColumn = find(By.xpath("//*[contains(text(),'" + errMessage + "')]"));
        return documentActionColumn.isPresent();
    }

    public void verifyScopeChangePreviewElements() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            String expectedText = "Scope is not narrowed in the document framework.";
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='" + expectedText + "']")));
            Assert.assertTrue("The text '" + expectedText + "' is not displayed on screen.", messageElement.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("Failed to find the text 'Scope is not narrowed...' on the Scope Change Preview screen.");
        }
    }


    private static final int TIMEOUT_SECONDS = 5;

    public boolean ValidateDocumentErrorMessage(String expectedMessage) {
        By messageLocator = By.xpath("//*[contains(normalize-space(.), '" + expectedMessage.trim() + "')]");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
            return true;
        } catch (Exception e) {
            System.err.println("Document message '" + expectedMessage + "' was not visible within " + TIMEOUT_SECONDS + " seconds.");
            return false;
        }
    }

    public int generateRandomInteger() {
        int min = 1;
        int max = 59;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public void provideEnforcementrulefornewdoctype(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", forNewDocument_immediateRadio);

            if (dataTable.containsKey("For new document") && dataTable.get("For new document").equalsIgnoreCase(forNewDocument_immediateRadio.getText())) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(forNewDocument_immediateRadio.isVisible());
                forNewDocument_immediateRadio.waitUntilClickable().click();

            } else if (dataTable.containsKey("For new document") && dataTable.get("For new document").equalsIgnoreCase(fornewdocument_ScheduleRadio.getText())) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(fornewdocument_ScheduleRadio.isVisible());
                fornewdocument_ScheduleRadio.waitUntilClickable().click();

                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(valuefor_fornewdocument_Schedule.isVisible());
                valuefor_fornewdocument_Schedule.waitUntilClickable().click();
                valuefor_fornewdocument_Schedule.clear();

                if (dataTable.get("value").equalsIgnoreCase("random")) {
                    withAction().moveToElement(valuefor_fornewdocument_Schedule).sendKeys(generateRandomInteger() + "").build().perform();
                } else {
                    withAction().moveToElement(valuefor_fornewdocument_Schedule).sendKeys(dataTable.get("value")).build().perform();
                }

                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(Durationfor_fornewdocument_Schedule.isVisible());
                Durationfor_fornewdocument_Schedule.waitUntilClickable().click();
                withAction().moveToElement(Durationfor_fornewdocument_Schedule).sendKeys(dataTable.get("Duration")).pause(Duration.ofSeconds(3)).sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
            }
            if (dataTable.containsKey("For amendment")) {
                if (dataTable.get("For amendment").equalsIgnoreCase(forAmendment_immediateRadio.getText())) {
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    Assert.assertTrue(forAmendment_immediateRadio.isVisible());
                    forAmendment_immediateRadio.waitUntilClickable().click();
                } else if (dataTable.get("For amendment").equalsIgnoreCase(foramendment_ScheduleRadio.getText())) {
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", foramendment_ScheduleRadio);
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(foramendment_ScheduleRadio.isVisible());
                    foramendment_ScheduleRadio.waitUntilClickable().click();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", valuefor_foramendment_Schedule);
                    Assert.assertTrue(valuefor_foramendment_Schedule.isVisible());
                    valuefor_foramendment_Schedule.clear();
                    valuefor_foramendment_Schedule.waitUntilClickable().click();
                    withAction().moveToElement(valuefor_foramendment_Schedule).sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).build().perform();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    Assert.assertTrue(Durationfor_foramendment_Schedule.isVisible());
                    Durationfor_foramendment_Schedule.clear();
                    Durationfor_foramendment_Schedule.waitUntilClickable().click();
                    withAction().moveToElement(Durationfor_foramendment_Schedule).sendKeys(dataTable.get("Duration")).pause(Duration.ofSeconds(3)).sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
                }
            }
        } catch (Exception e) {
            log.error("Unable to provide Enforcement rule. Exception: " + e);
            Assert.fail();
        }
    }


    public void provideEnforcementrulesforamendment(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", forAmendment_immediateRadio);
            if (dataTable.get("For amendment").equalsIgnoreCase(forAmendment_immediateRadio.getText())) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(forAmendment_immediateRadio.isVisible());
                forAmendment_immediateRadio.waitUntilClickable().click();
            } else if (dataTable.get("For amendment").equalsIgnoreCase(foramendment_ScheduleRadio.getText())) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", foramendment_ScheduleRadio);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(foramendment_ScheduleRadio.isVisible());
                foramendment_ScheduleRadio.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", valuefor_foramendment_Schedule);
                Assert.assertTrue(valuefor_foramendment_Schedule.isVisible());
                valuefor_foramendment_Schedule.clear();
                valuefor_foramendment_Schedule.waitUntilClickable().click();
                withAction().moveToElement(valuefor_foramendment_Schedule).sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(Durationfor_foramendment_Schedule.isVisible());
                Durationfor_foramendment_Schedule.clear();
                Durationfor_foramendment_Schedule.waitUntilClickable().click();
                withAction().moveToElement(Durationfor_foramendment_Schedule).sendKeys(dataTable.get("Duration")).pause(Duration.ofSeconds(3)).sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
            }
        } catch (Exception e) {
            log.error("unable to provide Enforcement rule for amandment" + e);
            Assert.fail();
        }
    }

    public void provideEnforcementrulesfortermination(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            if (dataTable.get("For termination").equalsIgnoreCase(fortermination_immediateRadio.getText())) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(fortermination_immediateRadio.isVisible());
                fortermination_immediateRadio.waitUntilClickable().click();
            } else if (dataTable.get("For termination").equalsIgnoreCase(fortermination_ScheduleRadio.getText())) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(fortermination_ScheduleRadio.isVisible());
                fortermination_ScheduleRadio.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(valuefor_fortermination_Schedule.isVisible());
                valuefor_fortermination_Schedule.waitUntilClickable().click();
                withAction().moveToElement(valuefor_fortermination_Schedule).sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(Durationfor_fortermination_Schedule.isVisible());
                Durationfor_fortermination_Schedule.waitUntilClickable().click();
                withAction().moveToElement(Durationfor_fortermination_Schedule).sendKeys(dataTable.get("Duration")).pause(Duration.ofSeconds(3)).sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
            }
        } catch (Exception e) {
            log.error("unable to provide Enforcement rule for termination" + e);
            Assert.fail();
        }
    }

    public void validateEnforcementRuleData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        if (dataTable.get("For new document").equalsIgnoreCase("Immediate") || dataTable.get("For amendment").equalsIgnoreCase("Immediate")) {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElementFacade documentActionColumn = find(By.xpath("//*[text()='Immediate']"));
            Assert.assertTrue(documentActionColumn.isVisible());
        } else if (dataTable.get("For new document").equalsIgnoreCase("Schedule") || dataTable.get("For amendment").equalsIgnoreCase("Schedule")) {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElementFacade documentActionColumn = find(By.xpath("//*[@value='" + dataTable.get("Duration") + "']"));
            Assert.assertTrue(documentActionColumn.isVisible());
        }
    }

    public void storeDocumentVersionID() {
        for (WebElementFacade docVersionID : DocVersionIDs) {
            documentVersionIDList.add(docVersionID.getText());
        }
        System.out.println("Document Version ID" + documentVersionIDList);
    }

    public void storeDocumentVersionIDAndStatus() {
        for (WebElementFacade docVersionID : DocVersionIDs) {
            WebElement EDNstatus = getDriver().findElement(By.xpath(docVersionID + "/following-sibling::td[4]"));
            documentVersionID_statusList.put(EDNstatus.getText(), docVersionID.getText());
        }
        System.out.println("Maps" + documentVersionID_statusList);
    }

    public void searchDocumentID() {
        for (String docVersionID : documentVersionIDList) {
            Document_ID.waitUntilVisible();
            Document_ID.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Document_ID.clear();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String[] docID = docVersionID.split("-0");
            Document_ID.sendKeys(docID[0]);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            DocumentPageObject.getShowLatestVersion().click();
            Assert.assertEquals(docVersionID, Document_Version_ID_Value.getText());
        }
    }

    public boolean validateDocumentDisplayed(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        boolean result = false;
        for (Map<String, String> DocumentData : data) {
            if (documentVersionID_statusList.containsKey(DocumentData.get("Status"))) {
                String DocumentVersionID = documentVersionID_statusList.get(DocumentData.get("Status"));
                if (DocumentVersionID.equalsIgnoreCase(DocVersionIDs_inImpactedScopeDocs.getText())) {
                    result = true;
                }
            }
        }
        return result;
    }

    public void enableAuthLines() {
        for (WebElementFacade enableAuthLine : Enable_AuthLines) {
            enableAuthLine.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }

    public void enterLimitValues(List<String> limitvalue) {
        for (WebElementFacade limitline : LimitLines_inImpactedDocs) {
            limitline.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            limitline.sendKeys(limitvalue.get(1));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    public boolean scopeChangeTextCompare(String s1, String s2, String s3) {
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        String actual = ScopeChangeText1.getText().trim() + " " + ScopeChangeText2.getText().trim();
        log.info("Actual Scope Change Text: " + actual);
        boolean result = actual.contains(s1) &&
                        (actual.toLowerCase().contains(s2.toLowerCase()) || actual.contains(s2)) &&
                        (actual.toLowerCase().contains(s3.toLowerCase()) || actual.contains(s3));
        return result;
    }

    public void performDelete() {
        DeleteIcon.waitUntilClickable().click();
        YesButton.withTimeoutOf(Duration.ofSeconds(5)).waitUntilClickable().click();
    }

    public void documentisPresent() {
        if (documentterminate.isVisible()) {
            documentterminate.click();
            actingasTerminate.waitUntilVisible().click();
            actingasTerminate.sendKeys("OSTTRA INDIA SERVICES PRIVATE LIMITED");
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            Submit_btn_Terminate.click();
        } else if (DeleteIcon.isVisible()) {
            DeleteIcon.click();
            YesButton.click();
        }
    }

    public void documentisterminated() {
        for (int i = 0; i < 2; i++) {
            if (DeleteIcon.isVisible()) {
                DeleteIcon.click();
                YesButton.click();
            }
        }
    }

    public void documentisdeleted() {
        if (DeleteIcon.isVisible()) {
            DeleteIcon.click();
            YesButton.click();
        }
    }

    public void handleTouchDirection(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String direction = data.get("Touch Direction").trim();
        WebElementFacade element = direction.equalsIgnoreCase("Up")
                ? getTouchDirection_Up()
                : getTouchDirection_Down();
        handleClick(element);
    }

    public void handleContractType(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String contractType = data.get("Contract Type").trim();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block:'center'});", ContractType_Put);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        WebElementFacade element = contractType.equalsIgnoreCase("Put")
                ? getContractType_Put()
                : getContractType_Call();
        handleClick(element);
    }

    private void handleClick(WebElementFacade element) {
        element.waitUntilPresent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        element.waitUntilClickable();
        element.click();
    }

    public void navigateToDocumentFrameWorkScreen() {
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();

            boolean isSidebarOpen = false;
            try {
                Object openClass = evaluateJavascript("return document.querySelector('.sidebar-wrapper') ? document.querySelector('.sidebar-wrapper').classList.contains('openSidebar') : false;");
                isSidebarOpen = Boolean.parseBoolean(String.valueOf(openClass));
            } catch (Exception ignored) {}

            if (!isSidebarOpen) {
                menu_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
                try {
                    menu_btn.click();
                } catch (Exception e) {
                    evaluateJavascript("arguments[0].click();", menu_btn);
                }
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }

            if (!Document_Framework_tab.isCurrentlyVisible()) {
                try {
                    document_tab.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
                    try {
                        document_tab.click();
                    } catch (Exception e) {
                        evaluateJavascript("arguments[0].click();", document_tab);
                    }
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                } catch (Exception ignored) {}
            }

            Document_Framework_tab.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            try {
                Document_Framework_tab.click();
            } catch (Exception clickEx) {
                log.warn("Standard click failed for Document Framework tab, trying JS click: " + clickEx.getMessage());
                evaluateJavascript("arguments[0].click();", Document_Framework_tab);
            }
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("Not able to reach the Document FrameWork page -->" + e);
            Assert.fail();
        }
    }
    public void selectApprovalWorkflowInitiatortoSeq1() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", InitiatorAG);
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-20)");
        act.dragAndDrop(InitiatorAG, approvalSeq1).build().perform();
        act.pause(Duration.ofSeconds(5)).build().perform();
    }
  public void DragAndDropColumnSelection_DF(DataTable table)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            WebElement source = getDriver().findElement(By.xpath("//th[text()='"+dataTable_map.get("Column Name")+"']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", source);
            act.dragAndDrop(source, FirstPosition_Column).build().perform();
            act.pause(Duration.ofSeconds(2)).build().perform();
        }
    }
    public void deleteAllApprovalWorkflowData() {
        int itemsToDelete = findAll(By.xpath("//div[@class='card']/*[name()='svg']")).size();
        for (int i = 0; i < itemsToDelete; i++) {
            try {
                List<WebElementFacade> currentIcons = findAll(By.xpath("//div[@class='card']/*[name()='svg']"));
                if (currentIcons.isEmpty()) break;
                WebElementFacade deleteIcon = currentIcons.get(0);
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deleteIcon);
                withAction().pause(Duration.ofMillis(500)).build().perform();
                deleteIcon.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            } catch (Exception e) {
                log.error("Failed to delete participant at index " + i + " : " + e.getMessage());
                break;
            }
        }
    }

    public void clickNeedHelp() {
        needHelpButton.waitUntilClickable().click();
    }

    public void askQuestion(String question) {
        chatInputArea.waitUntilVisible().type(question);
        submitQuestionButton.waitUntilClickable().click();
    }

    public String getBotResponseText() {
        // Chatbots take a moment to type. We add a wait with a timeout here.
        return botResponseText.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible().getText();
    }

    public boolean isChatbotUIVisible() {
        return needHelpTitle.isVisible() &&
                chatInputArea.isVisible() &&
                submitQuestionButton.isVisible() &&
                suggestedQuestionChips.isVisible() &&
                contactSupportLink.isVisible() &&
                disclaimerText.isVisible();
    }

    public void clickContactSupportLink() {
        contactSupportLink.waitUntilClickable().click();
    }

    public boolean isContactSupportScreenVisible() {
        return contactSupportSubjectInput.waitUntilVisible().isVisible();
    }

    public boolean isContactSupportUIFullyLoaded() {
        return contactSupportTitle.isVisible() &&
                contactSupportSubjectInput.isVisible() &&
                contactSupportDescriptionArea.isVisible() &&
                sendButton.isVisible() &&
                backButton.isVisible() &&
                confirmationEmailText.isVisible();
    }

    public void fillContactSupportForm(String subject, String description) {
        contactSupportSubjectInput.waitUntilVisible().type(subject);
        contactSupportDescriptionArea.waitUntilVisible().type(description);
    }

    public boolean isSendButtonEnabled() {
        return sendButton.isEnabled();
    }

    public void clickBackButton() {
        backButton.waitUntilClickable().click();
    }

    public void clickSendButton() {
        sendButton.waitUntilClickable().click();
    }

    public boolean isMessageSentSuccessUIVisible() {
        return successMessageTitle.isVisible() &&
                successMessageBody.isVisible() &&
                askAnotherQuestionButton.isVisible() &&
                closeButton.isVisible();
    }

    public void clickAskAnotherQuestionButton() {
        askAnotherQuestionButton.waitUntilClickable().click();
    }

    public void clickCloseButton() {
        closeButton.waitUntilClickable().click();
    }

    public boolean isChatbotClosed() {
        return !needHelpTitle.isCurrentlyVisible();
    }

    public boolean isBetaTagVisible() {
        // Returns true if the Beta tag is still rendering on screen
        return betaTag.isCurrentlyVisible();
    }

    public String getLatestBotResponseText() {
        latestBotResponseBubble.withTimeoutOf(java.time.Duration.ofSeconds(20))
                .waitUntilVisible();
        return latestBotResponseBubble.waitUntilVisible().getText();
    }

    public String getFallbackErrorText() {
        return fallbackErrorBubble.withTimeoutOf(java.time.Duration.ofSeconds(20))
                .waitUntilVisible()
                .getText();
    }
    public void unselectShowOnlyLatestVersionDF() {
        try {
            // Wait for the label area to be present on screen
            latestVersionCheckboxLabelDF.withTimeoutOf(Duration.ofSeconds(5)).waitUntilPresent();

            // Check if the underlying input element is selected
            if (latestVersionCheckboxInputDF.isSelected()) {
                log.info("'Show only latest version' checkbox on DF screen is currently SELECTED. Unselecting it now.");

                // Click the label to toggle the checkbox off
                latestVersionCheckboxLabelDF.waitUntilClickable().click();

                // Pause to allow the table data to refresh
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            } else {
                log.info("'Show only latest version' checkbox on DF screen is already UNSELECTED. Skipping action.");
            }
        } catch (Exception e) {
            log.error("Failed to interact with 'Show only latest version' checkbox on DF screen: " + e.getMessage());
        }
    }

    public void selectPbOnBehalfOfEb() {
        WebElementFacade checkboxInput = find(By.xpath("//div[contains(@class, 'pb-eb-checkbox-wrapper')]//input[@type='checkbox']"));
        WebElementFacade checkboxLabel = find(By.xpath("//div[contains(@class, 'pb-eb-checkbox-wrapper')]//label[contains(@class, 'csm_checkbox')]"));
        checkboxInput.waitUntilPresent();
        if (!checkboxInput.isSelected()) {
            checkboxLabel.waitUntilClickable().click();
            System.out.println("PB on behalf of EB checkbox was not selected. Clicking it now.");
        } else {
            System.out.println("PB on behalf of EB checkbox is already selected.");
        }
    }
    public void clickApprovalWorkflowForDNTab() {
        WebElementFacade dnWorkflowTab = find(By.xpath("//button[@role='tab' and contains(., 'Approval Workflow for DN')]"));
        dnWorkflowTab.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform(); // Optional brief pause to let UI render
    }

}