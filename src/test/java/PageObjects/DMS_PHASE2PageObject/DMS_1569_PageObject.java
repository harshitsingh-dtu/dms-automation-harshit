package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Data
public class DMS_1569_PageObject extends PageObject
{
    @FindBy(xpath = "//tr/th[text()='Document Status']//input")
    private WebElementFacade filter_document_status;
    @FindBy(xpath = "//tr/th[text()='Document ID']//input")
    private WebElementFacade search_documentID;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_txt;
    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade document_edit_btn;
    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade documentDelete_btn;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade documentCancel_btn;
    @FindBy (xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade search_versionID;
    @FindBy(xpath = "//button[text()='Approval workflow']")
    private WebElementFacade tab_approvalworkflow;
    @FindBy(xpath = "//button[text()='Enforcement rule']")
    private WebElementFacade tab_enforcementrules;
    @FindBy(xpath = "//button[text()='Legal term']")
    private WebElementFacade tab_legalterms;
    @FindBy(xpath = "//button[text()='Limit scope']")
    private WebElementFacade tab_limiscope;
    @FindBy(xpath = "//button[text()='Auth scope']")
    private WebElementFacade tab_authscope;
    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade tab_previewandsubmit;


    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_button;
    @FindBy(xpath = "//button[text()='Reset current changes']")
    private WebElementFacade Reset_current_changes_button;
    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade Save_as_draft_button;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade Next_button;
    @FindBy(xpath = "//button[text()='Submit for approval']")
    private WebElementFacade Submit_for_approval_button;

    @FindBy(xpath = "//div[@class='info-container']/div[@class='content-label']")
    private WebElementFacade DocumentVersionid_text;
    @FindBy(xpath = "//div[text()='Document type']/following::div/div")
    private WebElementFacade documenttype_text;
    @FindBy(xpath = "//div[text()='Allowed currencies']/following::div/div")
    private WebElementFacade allowedcurrencies_text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']")
    private WebElementFacade PartyPrimebBroker1_text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']")
    private WebElementFacade PartyExecutingBroker1_text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']")
    private WebElementFacade PartyClient1text;

    @FindBy(xpath = "//div[@class='lp-copy-sel__input-container css-19bb58m']")
    private WebElementFacade acting_as_input_field;
    @FindBy(xpath = "//div[@class='acting-content dif']//input")
    private WebElementFacade action_type_input_field;
    @FindBy(xpath = "//div[@class='acting-content dif']//input")
    private WebElementFacade Approval_group_input_field;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_edit_popup;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_Terminate_popup;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Cancel_button_on_popup;
    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade Approve_button_on_popup;
    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade Reject_button_on_popup;
    @FindBy(xpath = "//div[text()='Initiator']")
    private WebElementFacade Initiator_tab;
    @FindBy(xpath = "//div[@data-testid='box'][text()='Prime Broker - 1']")
    private WebElementFacade Prime_Broker_1_tab;
    @FindBy(xpath = "//div[@data-testid='box'][text()='Executing Broker - 1']")
    private WebElementFacade Executing_Broker_1_tab;
    @FindBy(xpath = "//div[@data-testid='box'][text()='Client - 1']")
    private WebElementFacade Client_1_tab;

    @FindBy(xpath = "//td[text()='New Document']")
    private WebElementFacade NEW_DOCUMENT_Action;
    @FindBy(xpath = "//td[text()='Edit Approval Workflow']")
    private WebElementFacade EDIT_APPROVAL_WORKFLOW_Action;
    @FindBy(xpath = "//td[text()='Edit Enforcement Rules']")
    private WebElementFacade EDIT_ENFORCEMENT_RULES_Action;
    @FindBy(xpath = "//td[text()='Edit Legal Terms']")
    private WebElementFacade EDIT_LEGAL_TERMS_Action;
    @FindBy(xpath = "//td[text()='Remove Currency']")
    private WebElementFacade REMOVE_CURRENCY_Action;
    @FindBy(xpath = "//td[text()='Remove Products']")
    private WebElementFacade REMOVE_PRODUCTS_Action;
    @FindBy(xpath = "//td[text()='Edit Limit Increase']")
    private WebElementFacade EDIT_LIMIT_INCREASE_Action;
    @FindBy(xpath = "//td[text()='Edit Limit Decrease']")
    private WebElementFacade EDIT_LIMIT_DECREASE_Action;
    @FindBy(xpath = "//td[text()='Edit Documents']")
    private WebElementFacade EDIT_DOCUMENTS_Action;
    @FindBy(xpath = "//td[text()='Terminate Document']")
    private WebElementFacade TERMINATE_DOCUMENT_Action;
    @FindBy(xpath = "//div[@class='ck ck-presence-list__counter']")
    private WebElementFacade number_of_connected_user_text;
    @FindBy(xpath = "//div[@class='ck ck-editor__main']")
    private WebElementFacade CK_editor;

//Enforcement rule
    @FindBy(xpath = "//div[text()='For new document']")
    private WebElementFacade for_new_document_text;
    @FindBy(xpath = "//div[text()='For amendment']")
    private WebElementFacade for_amendment_text;
    @FindBy(xpath = "//div[text()='For termination']")
    private WebElementFacade for_termination_text;
    @FindBy(xpath = "(//div[@class='card']//*[name()='svg'])[1]")
    private WebElementFacade Crossbutton_for_RemoveParticipants_From_ApprovalSqquence;

    @FindBy(xpath = "//label[@for='Immediate1']")
    private WebElementFacade for_newdocument_immediate_Radio_button;
    @FindBy(xpath = "//label[@for='Immediate2']")
    private WebElementFacade for_amendment_immediate_Radio_button;
    @FindBy(xpath ="//label[@for='Immediate3']")
    private WebElementFacade for_termination_immediate_Radio_button;
    @FindBy(xpath = "//label[@for='Scheduled1']")
    private WebElementFacade for_new_document_Schedule_Radio_button;
    @FindBy(xpath = "//label[@for='Scheduled2']")
    private WebElementFacade for_amendment_Schedule_Radio_button;
    @FindBy(xpath = "//label[@for='Scheduled3']")
    private WebElementFacade for_termination_Schedule_Radio_button;


//#    Checking req.---------------------------------
    @FindBy(xpath = "/div[contains(@class, 'rule-container')][1]//input[@type='number']/")
    private WebElementFacade valuefor_fornewdocument_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][2]//input[@type='number']")
    private WebElementFacade valuefor_foramendment_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][3]//input[@type='number']")
    private WebElementFacade valuefor_fortermination_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][1]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fornewdocument_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][2]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_foramendment_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][3]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fortermination_Schedule;
    @FindBy(xpath = "//button[@data-testid=\"submit-btn\"]")
    private WebElementFacade SubmitProdButton;

//    =================================================

    @FindBy(xpath = "//input[@placeholder='Select Product Group']")
    private WebElementFacade SelectProductGroupInput;
    @FindBy(xpath = "//input[@placeholder='Asset Class']")
    private WebElementFacade SelectAssetClassInput;
    @FindBy(xpath = "//input[@placeholder='Select Product Family']")
    private WebElementFacade SelectProductFamilyInput;
    @FindBy(xpath = "//input[@placeholder='Select Product']")
    private WebElementFacade SelectProductInput;
    @FindBy(xpath = "//button[text()='+ Add currencies']")
    private WebElementFacade AddCurrenciesButton;
    @FindBy(xpath = "//input[@placeholder='Value']")
    private WebElementFacade AuthTenorValueInput;
    @FindBy(xpath = "//input[@placeholder='Select Tenor']")
    private WebElementFacade SelectAuthTenorInput;
    @FindBy(xpath = "//button[text()='Add Auth Line']")
    private WebElementFacade AddAuthLineButton;
    @FindBy(xpath = "//div[@style='position: absolute;']")
    private WebElementFacade No_Auth_scope_defined_Text;
    @FindBy(xpath = "//img[@title='Delete']")
    private WebElementFacade Delete_Button;
    @FindBy(xpath = "//img[@title='Copy']")
    private WebElementFacade Copy_Button;
    @FindBy(xpath = "//button[text()='Currencies']")
    private WebElementFacade Currencies_tab;
    @FindBy(xpath = "//button[text()='Currencies-pair']")
    private WebElementFacade Currencies_pair_tab;

//    =========================================================
    @FindBy(xpath = "//button[text()='Limit Scope']")
    private WebElementFacade LimitScope_tab;
    @FindBy(xpath = "//div[text()='Calculation Type']//following-sibling::div//child::input")
    private WebElementFacade calculationType_tab;
    @FindBy(xpath = "//*[@placeholder='$ Limit value']")
    private WebElementFacade limitValue_tab;
    @FindBy(xpath = "//div[text()='Netting Type']//following-sibling::div//child::input")
    private WebElementFacade nettingType_tab;
    @FindBy(xpath = "//div[text()='Bullion Trades']//following-sibling::div//child::input")
    private WebElementFacade bullion_Trades;
    @FindBy(xpath = "//div[text()='Delta']//following-sibling::div//child::input")
    private WebElementFacade delta_tab;
    @FindBy(xpath = "//div[text()='Product family']//following-sibling::div//child::input")
    private WebElementFacade productFamily_tab;
    @FindBy(xpath = "//div[text()='Exclude CLS from calculation']//following-sibling::div//child::input")
    private WebElementFacade excludeCLS_tab;
    @FindBy(xpath = "//button[text()='Add Limit']")
    private WebElementFacade addLimit_btn;
    @FindBy(xpath = "//img[@title='Edit']")
    private WebElementFacade Edit_Button;
    @FindBy(xpath = "//img[@alt='Compare']")
    private WebElementFacade Compare_Button;
    @FindBy(xpath = "//button[text()='Submit for approval']")
    private WebElementFacade submit_for_approval_btn;
    @FindBy(xpath = "//img[@alt='Terminate']")
    private WebElementFacade Terminate_Button;
    @FindBy(xpath = "//img[@alt='Download']")
    private WebElementFacade Download_Button;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElementFacade PopUp_Body;
    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade PopUp_No_button;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade PopUp_Yes_button;
    @FindBy(xpath = "//div[@class='message']")
    private WebElementFacade PopUp_text;


    @FindBy(xpath = " //span[text()='Current version']")
    private WebElementFacade CurrentVersion_text_on_compare_screen;
    @FindBy(xpath = "// span[text()='Enforced version']")
    private WebElementFacade EnforcedVersion_text_on_compare_screen;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade Toast_notification;
    @FindBy(xpath = "//img[@alt='Approve']")
    private WebElementFacade Approve_button_All_document_listing_screen;
    @FindBy(xpath = "//img[@alt='Reject']")
    private WebElementFacade Reject_button_All_document_listing_screen;

    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRoles;
    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade  roleMapping;



    public void check_if_filterStatus_and_type(String filter){
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_document_status).click().pause(Duration.ofSeconds(2)).sendKeys(filter, Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the status filter"+e);
            Assert.fail();
        }
    }

    public void search_document(String documentID){
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            search_documentID.clear();
            withAction().moveToElement(search_documentID).click().sendKeys(documentID).pause(Duration.ofSeconds(10)).build().perform();

    }
    public void Click_on_doc_edit_button() {
       withAction().pause(Duration.ofSeconds(2)).build().perform();
            document_edit_btn.click();
            log.info("Clicked on Document edit button");
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    public void search_document_using_versionid(String documentVersionID){
        try {
            withAction().moveToElement(search_versionID).click().sendKeys(documentVersionID).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to search the document ID"+e);
            Assert.fail();
        }
    }

    public void check_if_filterStatus_and_enter(String filter){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(filter_document_status).click().pause(Duration.ofSeconds(2)).sendKeys(filter, Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the status filter"+e);
            Assert.fail();
        }
    }

    public void select_document_status_filter(List<String> filter){
        try
        {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(filter_document_status).click().pause(Duration.ofSeconds(2)).sendKeys(filter.get(1), Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e)
        {
            log.error("Unable to set the status filter"+e);
            Assert.fail();
        }
    }
    public void quit(){
        getDriver().quit();
    }

    public String get_DocumentType_text(){
        return documenttype_text.getText();
    }
    public void select_acting_as(String ActingAs)
    {
       withAction().moveToElement(acting_as_input_field).click().sendKeys(ActingAs,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }
    public void select_action_type(String ActionType)
    {
        withAction().moveToElement(action_type_input_field).click().sendKeys(ActionType,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }
    public void click_on_the_submit_button_on_the_edit_pop_up_screen() {

            submit_edit_popup.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        public void ClickOnAuthScopeTab(){
            tab_authscope.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
    public void ClickOnLimitScopeTab(){
        LimitScope_tab.click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }
    public void drag_and_drop_for_approval_workflow(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
//        try {
            List<WebElementFacade> elements = findAll("//div[@class='card']//*[name()='svg']");
            int size = elements.size();
            for(int i=0;i<=size;i++){
                if (Crossbutton_for_RemoveParticipants_From_ApprovalSqquence.isVisible()){
                Crossbutton_for_RemoveParticipants_From_ApprovalSqquence.click();
                }
                 }
            for (Map<String, String> approvalworkflow : data) {
                String participant = approvalworkflow.get("Participants");
                String documentaction = approvalworkflow.get("Document_Action");
                String Approvalsequence = approvalworkflow.get("Approval_sequence");
                if (participant.equalsIgnoreCase(find(By.xpath("//div[@class='drag-box  '][text()='"+participant+"']")).getText())) {
                    WebElementFacade source = find(By.xpath("//div[@class='drag-box  '][text()='"+participant+"']"));
                    WebElementFacade destination = find(By.xpath("(//td[text()='"+documentaction+"']/following-sibling::td/div[@class='cell-container']/div[@class='drag-over'])["+Approvalsequence+"]"));
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().clickAndHold(source).moveToElement(destination).release().build().perform();
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            }
//        }
//        catch(Exception e){
//            log.error("unable to arrange participants with document action for approval workflow");
//            Assert.fail();
//        }
    }
    public void ClickOnSubmit_for_approval(){
        submit_for_approval_btn.click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }


    public void EnterTextInCK_Editor()
    {
        String s = RandomStringUtils.randomAlphabetic(10);
        log.info("Entered value in ck editor is ---> "+s);
        withAction().moveToElement(CK_editor).click().sendKeys(s).pause(Duration.ofSeconds(2)).build().perform();
    }

    public void Click_on_delete_button_to_remove_product(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Delete_Button.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void remove_role(List<String> roles){

        try {
            // first ! check if the role is selected in the already selected list,if yes-->> go to next role

            for (int begin=1;begin<roles.size();begin++){
                log.info(selectedRoles.getText());
                if (selectedRoles.getText().contains(roles.get(begin))){
                    if (roleMapping.isVisible()) {
                        log.info("Role Mapping dropdown is visible");
                    }
                    else {
                        log.info("Role Mapping dropdown not visible");
                    }
                    roleMapping.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    roleMapping.clear();
                    withAction().moveToElement(roleMapping).click().sendKeys(roles.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();

                    if (PopUp_Body.isVisible()){
                        PopUp_Yes_button.click();
                    }
                }
                else {
                    continue;
                }
            }
            //if role not selected, user will search and select the role
        }catch (Exception e){
            Assert.fail("User was unable to set the desired roles"+e);
        }
    }
}
