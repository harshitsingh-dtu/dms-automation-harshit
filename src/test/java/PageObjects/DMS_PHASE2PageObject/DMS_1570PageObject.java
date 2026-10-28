package PageObjects.DMS_PHASE2PageObject;


import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data

public class DMS_1570PageObject extends PageObject {

    @FindBy(xpath = "//div[@class='multiselect-container']//input")
    private WebElementFacade role_Mapping1;

    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRole_list;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade check_Notification;

    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profile_icon;

    @FindBy(xpath = "//*[text()='Logout']")
    private WebElementFacade logout_btn;

    @FindBy(xpath = "//input[@placeholder='Enter registered email id']")
    private WebElementFacade username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElementFacade password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade login_btn;

    @FindBy(xpath = "//div[@class='notification-icon profile-icon']")
    private WebElementFacade notification_icon;

    @FindBy(xpath = "//div[@class='list']")
    private WebElementFacade notification_message;

    @FindBy(xpath="//div[@class='lei-org-edit']//input[@placeholder='Select Doc Type']")
    private WebElementFacade select_DocType;

    @FindBy(xpath="//div[text()='Select LEIs']")
    private WebElementFacade select_LEI;

    @FindBy(xpath="//div[@class='lei-org-edit']//input[@placeholder='Select Org Type']")
    private WebElementFacade select_OrgType;

    @FindBy(xpath="//button[text()='+ Add']")
    private WebElementFacade addButton;

    @FindBy(xpath="//div[@class='lei-org-title']//input[@placeholder='Select Doc Type']")
    private WebElementFacade select_DocType_addedLEI;

    @FindBy(xpath="//input[@placeholder='Search by LEI name']")
    private WebElementFacade search_LEI;

    @FindBy(xpath="//div[@class='lei-org-title']//input[@placeholder='Select Org Type']")
    private WebElementFacade select_OrgType_addedLEI;

    @FindBy(xpath="//div[@class='lei-orgtype-wrapper']//button")
    private WebElementFacade cross_icon;

    @FindBy(xpath="//div[@class='alert-msg']")
    private WebElementFacade confirmation_popup;

    @FindBy(xpath="//button[text()='Yes']")
    private WebElementFacade confirmation_Yes_btn;

    @FindBy(xpath="//td//div//label")
    private WebElementFacade status_btn;

    @FindBy(xpath="//div[@role='alert']//div//following::div")
    private WebElementFacade notification_activeInactiveUser;

    @FindBy(xpath="//table//tbody//tr//td[1]")
    private WebElementFacade docType_value;

    @FindBy(xpath="//table//tbody//tr//td[3]")
    private WebElementFacade orgType_value;

    @FindBy(xpath="//div[@class='pf-name']//header")
    private WebElementFacade organization_header;

    @FindBy(xpath="//div[@class='flex space-between flex-gap']//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath="//div[text()='Organisations']")
    private WebElementFacade organization_btn;

    @FindBy(xpath="//input[@placeholder='Search by LEI id or organisation name']")
    private WebElementFacade searchOrganization_name;

    @FindBy(xpath="//button[text()='Update']")
    private WebElementFacade update_btn;

    @FindBy(xpath="//div[@class='doc-select-wrapper']//input[@placeholder='Select Doc Type']")
    private WebElementFacade organisation_DocType;

    @FindBy(xpath="//input[@placeholder='Search by LEIs id or name']")
    private WebElementFacade search_LEIName_Organisations;

    @FindBy(xpath="//div[@class='pf-details']//span[text()=' Profile details']")
    private WebElementFacade profile_details;

    @FindBy(xpath="(//div[@class='pf-box pf org']//div//div)[1]")
    private WebElementFacade mapped_docType;

    @FindBy(xpath="(//div[@class='pf-box pf org']//div//h4)[1]")
    private WebElementFacade mapped_LEIName;

    @FindBy(xpath="(//div[@class='pf-box pf org']//div//div)[4]")
    private WebElementFacade mapped_orgType;

    @FindBy(xpath = "//input[@placeholder='Enter group name']")
    private WebElementFacade groupName_box;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doc_type_box;

    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgType_box;

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationName_box;

    @FindBy(xpath = "//div[text()='Select Leis']")
    private WebElementFacade leiName_box;

    @FindBy(xpath = "//td[4]//div[@class='enable-switch ']/label")
    private WebElementFacade PBToggle_btn;

    @FindBy(xpath = "//td[4]//div[@class='enable-switch ']/label")
    private WebElementFacade EBToggle_btn;

    @FindBy(xpath = "//td[5]//div[@class='enable-switch ']/label")
    private WebElementFacade ClientToggle_btn;

    @FindBy(xpath="//button[normalize-space()='Cancel']")
    private WebElementFacade cancel_btn;

    @FindBy(xpath = "//input[@placeholder='Search by email id']")
    private WebElementFacade searchEmail_Add;

    @FindBy(xpath = "//div[text()=\"User's email id\"]//following::h4[1]")
    private WebElementFacade users_EmailId;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade addUser_btn;

    @FindBy(xpath = "//input[@placeholder='Search by organisation name']")
    private WebElementFacade searchBar;

    @FindBy(xpath = "//div[@role='button']")
    private WebElementFacade removed_approvalGrp;

    @FindBy(xpath = "//input[@placeholder='Select LEIs']")
    private WebElementFacade selectLEI_approvalMatrix;

    @FindBy(xpath = "//input[@placeholder='Select Doc type']")
    private WebElementFacade documentTypeFilter;

    @FindBy(xpath = "//input[@placeholder='Select Orgtype']")
    private WebElementFacade ActingAs_filter;

    @FindBy(xpath = "//div[text()='Select parties']")
    private WebElementFacade SelectParties_text;

    @FindBy(xpath = "//div[text()='Select Prime Broker - 1']")
    private WebElementFacade PrimeBroker1Filter;

    @FindBy(xpath = "//div[text()='Select Executing Broker - 1']")
    private WebElementFacade ExecutingBroker1Filter;

    @FindBy(xpath = "//div[text()='Select Client - 1']")
    private WebElementFacade Client1Filter;

    @FindBy(xpath = "//div[text()='Select Prime Broker - 2']")
    private WebElementFacade PrimeBroker2Filter;

    @FindBy(xpath = "//div[text()='Select Client - 2']")
    private WebElementFacade Client2Filter;

    @FindBy(xpath = "//input[@placeholder='Select Template']")
    private WebElementFacade documentTemplate_filter;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_button;

    @FindBy(xpath = "//div[text()='Edit Document']")
    private WebElementFacade EditDocument_text;

    @FindBy(xpath = "//div[text()='For new document']")
    private WebElementFacade forNewDocument_text;

    @FindBy(xpath = "//div[text()='Participants']")
    private WebElementFacade Participants_text;

    @FindBy(xpath = "//div[@class='drag-box onDrag  '][text()='Initiator']")
    private WebElementFacade Initiator_button;

    @FindBy(xpath = "//div[@class='drag-box onDrag  '][text()='Prime Broker - 1']")
    private WebElementFacade PrimeBroker1_button;

    @FindBy(xpath = "//div[@class='drag-box onDrag  '][text()='Executing Broker - 1']")
    private WebElementFacade ExecutingBroker1_button;

    @FindBy(xpath = "//div[@class='drag-box onDrag  '][text()='Client - 1']")
    private WebElementFacade Client1_button;

    @FindBy(xpath = "//table[@class='workflow-table']")
    private WebElementFacade approvalworkflow_table;

    @FindBy(xpath = "//div[@role='alert']//div[2]")
    private WebElementFacade Alert_Message_for_ApprovalMatrix;

    @FindBy(xpath = "(//div[@class='card']//*[name()='svg'])[1]")
    private WebElementFacade Crossbutton_for_RemoveParticipants_From_ApprovalSqquence;

    @FindBy(xpath = "//div[text()='For amendment']")
    private WebElementFacade forAmendment_text;

    @FindBy(xpath = "//div[text()='For termination']")
    private WebElementFacade forTermination_text;

    @FindBy(xpath = "//div[@class='ck ck-presence-list__counter']")
    private WebElementFacade connecteduser_text;

    @FindBy(xpath = "//button[text()='Submit For Approval']")
    private WebElementFacade submitForApproval;

    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade previewAndSubmit_tab;

    @FindBy(xpath = "//div[@class='ck ck-editor__main']//div")
    private WebElementFacade textboxDocumentTerms;

    @FindBy(xpath = "//input[@placeholder='Select Product Group']")
    private WebElementFacade AuthProducts_group;

    @FindBy(xpath = "//button[text()='+ Add currencies']")
    private WebElementFacade authCurrencies;

    @FindBy(xpath = "//*[@placeholder='Currencies Group']")
    private WebElementFacade currenciesGroup;

    @FindBy(xpath = "//input[@placeholder='Value']")
    private WebElementFacade authTenorValue;

    @FindBy(xpath = "//*[@placeholder='Select Tenor']")
    private WebElementFacade authSelectTenor;

    @FindBy(xpath = "//div[text()='Calculation Type']//following-sibling::div//child::input")
    private WebElementFacade calculationType_tab;

    @FindBy(xpath = "//*[@placeholder='Limit value']")
    private WebElementFacade limitValue_tab;

    @FindBy(xpath = "//div[text()='Netting Type']//following-sibling::div//child::input")
    private WebElementFacade nettingType_tab;

    @FindBy(xpath = "//div[text()='Delta']//following-sibling::div//child::input")
    private WebElementFacade delta_tab;

    @FindBy(xpath = "//div[text()='Product family']//following-sibling::div//child::input")
    private WebElementFacade productFamily_tab;

    @FindBy(xpath = "//div[text()='Exclude CLS from calculation']//following-sibling::div//child::input")
    private WebElementFacade excludeCLS_tab;

    @FindBy(xpath = "//button[text()='Add Limit']")
    private WebElementFacade addLimit_btn;

    @FindBy(xpath = "//tr/th[text()='Document Status']//input")
    private WebElementFacade filter_document_status;

    @FindBy (xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade search_versionID;

    @FindBy(xpath = "//div//label[text()='Acting as']//following::input[1]")
    private WebElementFacade confirmation_pop_up_actingAs;

    @FindBy(xpath = "//div[@class='acting-content dif']//input")
    private WebElementFacade confirmation_pop_up_approvalGroup;

    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade confirmation_pop_up_approve_btn;

    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade confirmation_pop_up_reject_btn;

    @FindBy(xpath = "//button//img[@alt='Cancel']")
    private WebElementFacade cancel_icon;

    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade YES_Btn_confirm_cancel_document;

    @FindBy(xpath="//div[@role='alert']//div[text()='Document Version Updated']")
    private WebElementFacade checkNotification_cancelButton;

    @FindBy(xpath = "//th[text()='Document Type']//input")
    private WebElementFacade selectDocType;

    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade SaveAsDraft_btn;

    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade edit_btn;

    @FindBy(xpath = "//tbody//span[text()='approved']")
    private WebElementFacade approved_state;

    @FindBy(xpath = "//td[text()='No Record Found']")
    private WebElementFacade noRecordFound;

    @FindBy(xpath = "//button[text()='USP Rider']")
    private WebElementFacade uspRiderTab_previewAndSubmitScreen;

    public void clickLogout(){
        try {
            profile_icon.click();
            logout_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Not able to logout -->"+e);
            Assert.fail();
        }
    }
    public void enterEmailAndPass(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            username.waitUntilVisible();
            withAction().moveToElement(username).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(username).click().sendKeys(dataTable.get("email id")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(password).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(password).click().sendKeys(dataTable.get("password")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            login_btn.click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to enter email id and pass" +e);
            Assert.fail();
        }
    }

    public void notificationAssignRole_dialogueBox(){
        try{
          String notificationMessage_text = notification_message.getText().trim();
          log.info("Message is :" +notificationMessage_text);
          withAction().pause(Duration.ofSeconds(2)).build().perform();

          if (notificationMessage_text.contains("Add role notification")){

              log.info("Correct notification is visible for assigning a role");

          }
          else {
              log.info("Unable to see correct message");
              Assert.fail();
          }
        }
        catch (Exception e){
            log.error("Unable to see the notification for assigning a role" +e);
            Assert.fail();
        }
    }
    public void notificationRemoveRole_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Remove role notification")){

                log.info("Correct notification is visible for removing a role");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for removing a role" +e);
            Assert.fail();
        }
    }
    public void docType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_DocType.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void select_LEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            select_LEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_LEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_LEI).click().sendKeys(dataTable.get("LEI Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select LEI" +e);
            Assert.fail();
        }
    }
    public void selectOrgType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_OrgType.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType).click().sendKeys(dataTable.get("Org Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to select org type" +e);
            Assert.fail();
        }
    }
    public void click_Add_btn(){
        try{
            addButton.waitUntilEnabled();
            addButton.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to click Add button" +e);
            Assert.fail();
        }
    }
    public void notificationAddLEI_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Add Lei notification")){

                log.info("Correct notification is visible for adding a LEI");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for adding a LEI" +e);
            Assert.fail();
        }
    }
    public void docType_addedLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_DocType_addedLEI.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void searchLEI_addedLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            search_LEI.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(search_LEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(search_LEI).click().sendKeys(dataTable.get("LEI Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void orgType_addedLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_OrgType_addedLEI.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).click().sendKeys(dataTable.get("org type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type" +e);
            Assert.fail();
        }
    }
    public void clickCross_icon(){
        try{
            cross_icon.waitUntilVisible();
            cross_icon.click();
            Assert.assertTrue(confirmation_popup.isDisplayed());
            confirmation_Yes_btn.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to click on Confirmation Yes button" +e);
            Assert.fail();
        }
    }
    public void notificationRemoveLEI_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Remove Lei notification")){

                log.info("Correct notification is visible for removing a LEI");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for removing a LEI" +e);
            Assert.fail();
        }
    }
    public void change_toggle_status(){
        try {
               status_btn.click();
               log.info("Changed the status of Status button");

        }catch (Exception e){
            log.error("Unable to change toggle button status"+e);
            Assert.fail();
        }
    }
    public void checkNotification_activeUser(){
        try{
            notification_activeInactiveUser.waitUntilVisible();
            if (notification_activeInactiveUser.getText().contains("DMS User Status updated to active. Email with password creation link already sent to the user email id harsh.kaushik@osttra.com")){
                log.info("Get the notification to activate the user");
                withAction().pause(Duration.ofSeconds(8)).build().perform();
            }
            else{
                log.info("Unable to get the notification to activate the user");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to get the notification to activate the user");
            Assert.fail();
        }
    }
    public void notificationActivateUser_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("User Status Update notification")){

                log.info("Correct notification is visible for activating the user");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for activating the user" +e);
            Assert.fail();
        }
    }
    public void assignRole(List<String> RolesList)
    {
        try {
            selectedRole_list.waitUntilVisible();
            for (int begin=1;begin<RolesList.size();begin++){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (!selectedRole_list.getText().contains(RolesList.get(begin))){
                    role_Mapping1.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    withAction().moveToElement(role_Mapping1).click().sendKeys(RolesList.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                }
            }
            if (submit_btn.isEnabled()) {
                submit_btn.click();
                withAction().pause(Duration.ofSeconds(8)).build().perform();
            }
        }catch (Exception e){
            Assert.fail("User unable to remove Assigned roles"+e);
            Assert.fail();
        }
    }
    public void addLEI_ifNotAdded(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            select_DocType_addedLEI.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            docType_value.waitUntilVisible();
            select_OrgType_addedLEI.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).click().sendKeys(dataTable.get("Org Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            orgType_value.waitUntilVisible();
            if(dataTable.get("Doc Type").equalsIgnoreCase(docType_value.getText()) && dataTable.get("Org Type").equalsIgnoreCase(orgType_value.getText())){
                log.info("Corresponding value is present");
            }
            //Add the Combination for LEI if not present
            else{
                select_DocType.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(select_DocType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(select_DocType).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                select_LEI.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(select_LEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(select_LEI).click().sendKeys(dataTable.get("LEI Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                select_OrgType.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(select_OrgType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(select_OrgType).click().sendKeys(dataTable.get("Org Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                addButton.waitUntilEnabled();
                addButton.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                submit_btn.waitUntilEnabled();
                submit_btn.click();
                withAction().pause(Duration.ofSeconds(8)).build().perform();
            }
        }
        catch (Exception e){
            Assert.fail("Unable to add the combination for LEI");
        }
    }
    public void checkLegalEntity_OrgType_Online(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            profile_icon.waitUntilVisible();
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String organization_headerText= organization_header.getText().trim();
            log.info("Organization header is :" +organization_headerText);
            profile_details.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            List<WebElementFacade> columnList = findAll("//div[@class='detail-entities pf-border']");
            int column_size= columnList.size();
            log.info("column size on screen is :" +column_size);
            int columncount= 1;
            for(WebElementFacade Column_Text : columnList) {

                if (Column_Text.getText().contains("DN")) {
                    String mappedDocType_text = mapped_docType.getText().trim();
                    log.info("Mapped doc type is :" + mappedDocType_text);
                    String mappedLEI_text = mapped_LEIName.getText().trim();
                    log.info("Mapped LEI Name is :" + mappedLEI_text);
                    String mappedOrgText = mapped_orgType.getText().trim();
                    log.info("Mapped Org type is :" + mappedOrgText);
                    break;
                }
                columncount++;
            }
            navigation_btn.isVisible();
            navigation_btn.click();
            organization_btn.waitUntilClickable();
            organization_btn.click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            searchOrganization_name.clear();
            withAction().moveToElement(searchOrganization_name).click().sendKeys(organization_headerText).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            update_btn.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            organisation_DocType.waitUntilClickable();
            withAction().moveToElement(organisation_DocType).click().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(organisation_DocType).click().sendKeys("DN").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            List<WebElementFacade> LEINameList = findAll("(//tr//th)[2]//following::tr//td[2]");
//            int LEIName_size= LEINameList.size();
//            log.info("column size on screen is :" +LEIName_size);
//            for(WebElementFacade LEIName_Text : LEINameList) {

//                if (LEIName_Text.getText().equalsIgnoreCase(organization_headerText)) {
//                    withAction().moveToElement(search_LEIName_Organisations).click().sendKeys(organization_headerText);
                    switch (dataTable.get("Org Type")){
                        case "PB":
                            PBToggle_btn.waitUntilVisible();
                            if (PBToggle_btn.getText().trim().equalsIgnoreCase("Online")){
                                PBToggle_btn.click();
                                withAction().pause(Duration.ofSeconds(3)).moveToElement(confirmation_Yes_btn).click().build().perform();
                                submit_btn.click();
                                withAction().pause(Duration.ofSeconds(8)).build().perform();
                                break;
                            }
                            cancel_btn.click();
                            break;
                        case "EB":
                            EBToggle_btn.waitUntilVisible();
                            if (EBToggle_btn.getText().trim().equalsIgnoreCase("Online")){
                                EBToggle_btn.click();
                                withAction().pause(Duration.ofSeconds(3)).moveToElement(confirmation_Yes_btn).click().build().perform();
                                submit_btn.click();
                                withAction().pause(Duration.ofSeconds(8)).build().perform();
                                break;
                            }
                            cancel_btn.click();
                            break;
                        case "Client":
                            ClientToggle_btn.waitUntilVisible();
                            if (ClientToggle_btn.getText().trim().equalsIgnoreCase("Online")){
                                ClientToggle_btn.click();
                                withAction().pause(Duration.ofSeconds(3)).moveToElement(confirmation_Yes_btn).click().build().perform();
                                submit_btn.click();
                                withAction().pause(Duration.ofSeconds(8)).build().perform();
                                break;
                            }
                            cancel_btn.click();
                            break;
                    }
//                }
//            }
        }
        catch (Exception e){
            log.error("Unable to check mapped legal entity" +e);
            Assert.fail();
        }
    }
    public void checkLegalEntity_OrgType_Lite(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            profile_icon.waitUntilVisible();
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String organization_headerText= organization_header.getText().trim();
            log.info("Organization header is :" +organization_headerText);
            profile_details.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            List<WebElementFacade> columnList = findAll("//div[@class='detail-entities pf-border']");
            int column_size= columnList.size();
            log.info("column size on screen is :" +column_size);
            int columncount= 1;
            for(WebElementFacade Column_Text : columnList) {

                if (Column_Text.getText().contains("DN")) {
                    String mappedDocType_text = mapped_docType.getText().trim();
                    log.info("Mapped doc type is :" + mappedDocType_text);
                    String mappedLEI_text = mapped_LEIName.getText().trim();
                    log.info("Mapped LEI Name is :" + mappedLEI_text);
                    String mappedOrgText = mapped_orgType.getText().trim();
                    log.info("Mapped Org type is :" + mappedOrgText);
                    break;
                }
                columncount++;
            }
            navigation_btn.isVisible();
            navigation_btn.click();
            organization_btn.waitUntilClickable();
            organization_btn.click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            searchOrganization_name.clear();
            withAction().moveToElement(searchOrganization_name).click().sendKeys(organization_headerText).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            update_btn.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            organisation_DocType.waitUntilClickable();
            withAction().moveToElement(organisation_DocType).click().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(organisation_DocType).click().sendKeys("DN").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            List<WebElementFacade> LEINameList = findAll("(//tr//th)[2]//following::tr//td[2]");
//            int LEIName_size= LEINameList.size();
//            log.info("column size on screen is :" +LEIName_size);
//            for(WebElementFacade LEIName_Text : LEINameList) {

//                if (LEIName_Text.getText().equalsIgnoreCase(organization_headerText)) {
//                     withAction().moveToElement(search_LEIName_Organisations).click().sendKeys(organization_headerText);
                    switch (dataTable.get("Org Type")){
                        case "PB":
                            PBToggle_btn.waitUntilVisible();
                            if (PBToggle_btn.getText().trim().equalsIgnoreCase("Lite")){
                                PBToggle_btn.click();
                                withAction().pause(Duration.ofSeconds(3)).moveToElement(confirmation_Yes_btn).click().build().perform();
                                submit_btn.click();
                                withAction().pause(Duration.ofSeconds(8)).build().perform();
                                break;
                            }
                            cancel_btn.click();
                            break;
                        case "EB":
                            EBToggle_btn.waitUntilVisible();
                            if (EBToggle_btn.getText().trim().equalsIgnoreCase("Lite")){
                                EBToggle_btn.click();
                                withAction().pause(Duration.ofSeconds(3)).moveToElement(confirmation_Yes_btn).click().build().perform();
                                submit_btn.click();
                                withAction().pause(Duration.ofSeconds(8)).build().perform();
                                break;
                            }
                            cancel_btn.click();
                            break;
                        case "Client":
                            ClientToggle_btn.waitUntilVisible();
                            if (ClientToggle_btn.getText().trim().equalsIgnoreCase("Lite")){
                                ClientToggle_btn.click();
                                withAction().pause(Duration.ofSeconds(3)).moveToElement(confirmation_Yes_btn).click().build().perform();
                                submit_btn.click();
                                withAction().pause(Duration.ofSeconds(8)).build().perform();
                                break;
                            }
                            cancel_btn.click();
                            break;
                    }
//                }
//            }
        }
        catch (Exception e){
            log.error("Unable to check mapped legal entity" +e);
            Assert.fail();
        }
    }
    public void notificationStatusChange_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("LeiOrgType status update notification")){

                log.info("Correct notification is visible for turning the status to lite");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for turning the status to lite" +e);
            Assert.fail();
        }
    }
    public void notificationAddUserApprovalGroup_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Added to approval group")){

                log.info("Correct notification is visible for adding user to approval group");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
            notification_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to see the notification for adding user to approval group" +e);
            Assert.fail();
        }
    }
    public void notificationRemoveUserApprovalGroup_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Removed from approval group")){

                log.info("Correct notification is visible for removing user from approval group");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
            notification_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to see the notification for removing user from approval group" +e);
            Assert.fail();
        }
    }
    public void user_fills_the_group_name(){
        String ranstring = RandomString.make(5);
        try {
            groupName_box.waitUntilClickable();
            withAction().moveToElement(groupName_box).click().sendKeys(ranstring).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("user is unable to input the group name -->"+e);
            Assert.fail();
        }
    }
    //Need to use these methods again because of different xpaths
    public void user_fills_the_doc_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doc_type_box.waitUntilClickable();
            withAction().moveToElement(doc_type_box).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Doc type -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_org_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            orgType_box.waitUntilClickable();
            withAction().moveToElement(orgType_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("org type")).sendKeys(Keys.DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Org type -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_organization_name(){
        try {
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String organization_headerText= organization_header.getText().trim();
            log.info("Organization header is :" +organization_headerText);
            organizationName_box.waitUntilClickable();
            withAction().moveToElement(organizationName_box).click().sendKeys(organization_headerText).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the organisation name -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_leis(){
        try {
            leiName_box.waitUntilClickable();
            withAction().moveToElement(leiName_box).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the LEI name -->"+e);
            Assert.fail();
        }
    }
    public void addUser(){
        try{
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            profile_details.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            String users_EmailIdText = users_EmailId.getText();
            getDriver().navigate().back();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            searchEmail_Add.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(searchEmail_Add).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(searchEmail_Add).click().sendKeys(users_EmailIdText).pause(Duration.ofSeconds(2)).build().perform();
            addUser_btn.click();
            submit_btn.waitUntilEnabled();
            submit_btn.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to add user" +e);
            Assert.fail();
        }
    }
    public void notificationAddApprovalGroup_ApprovalMatrix_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Approval Matrix notification")){

                log.info("Correct notification is visible for adding approval group to the approval matrix");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for adding approval group to the approval matrix" +e);
            Assert.fail();
        }
    }
    public void notificationRemoveApprovalGroup_ApprovalMatrix_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Approval Matrix notification")){

                log.info("Correct notification is visible for adding approval group to the approval matrix");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for adding approval group to the approval matrix" +e);
            Assert.fail();
        }
    }
    public void searchApprovalMatrix(){
        try {
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String organization_headerText= organization_header.getText().trim();
            log.info("Organization header is :" +organization_headerText);
            Assert.assertTrue(searchBar.isVisible());
            withAction().moveToElement(searchBar).click().pause(Duration.ofSeconds(3)).sendKeys(organization_headerText).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("unable to input in the organization filter-->"+e);
            Assert.fail();
        }
    }
    public void selectLEI(){
        try {
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String organization_headerText= organization_header.getText().trim();
            log.info("Organization header is :" +organization_headerText);
            withAction().moveToElement(selectLEI_approvalMatrix).click().pause(Duration.ofSeconds(3)).sendKeys(organization_headerText).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to input in the lei filter-->"+e);
            Assert.fail();
        }
    }
    public void EnterDocType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(documentTypeFilter.isVisible());
            withAction().moveToElement(documentTypeFilter).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Doctype-->" + e);
            Assert.fail();
        }
    }

    public void EnterActingAs(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(ActingAs_filter.isVisible());
            withAction().moveToElement(ActingAs_filter).click().sendKeys(dataTable.get("Acting AS")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Acting as-->" + e);
            Assert.fail();
        }
    }
    public void EnterPrimeBroker1(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(PrimeBroker1Filter.isVisible());
            withAction().moveToElement(PrimeBroker1Filter).click().sendKeys(dataTable.get("PrimeBroker-1")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to type into PrimeBroker1Filter-->" + e);
            Assert.fail();
        }
    }

    public void randomEnterExecutingBroker1() {
        try {
            Random random = new Random();
            int randomNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber"  +  randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(ExecutingBroker1Filter).click().build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Executing Broker 1 " +e);
            Assert.fail();
        }
    }

    public void randomEnterClient1() {
        try {
            Random random = new Random();
            int randNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber"  +  randNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(Client1Filter).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Client 1 " +e);
            Assert.fail();
        }
    }
    public void SelectDocumentTemplate(){
//        List<Map<String, String>> data = table.asMaps(String.class, String.class);
//        Map<String,String> dataTable_map= data.get(0);
//        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(documentTemplate_filter.isVisible());
//            withAction().moveToElement(documentTemplate_filter).click().sendKeys(dataTable.get("Document template")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(documentTemplate_filter).click().pause(Duration.ofSeconds(4)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

        } catch (Exception e) {
            log.error("Unable to Select documenttemplate-->" + e);
            Assert.fail();
        }
    }
    public void dragAndDrop_forApprovalWorkflow(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> approvalworkflow : data) {
                String participant = approvalworkflow.get("Participants");
                String documentaction = approvalworkflow.get("Document_Action");
                String Approvalsequence = approvalworkflow.get("Approval_sequence");
                if (participant.equalsIgnoreCase(find(By.xpath("//div[@class='drag-box  '][text()='"+participant+"']")).getText())) {
                    WebElementFacade source = find(By.xpath("//div[@class='drag-box  '][text()='"+participant+"']"));
                    WebElementFacade destination = find(By.xpath("(//td[text()='"+documentaction+"']/following-sibling::td/div[@class='cell-container']/div[@class='drag-over'])["+Approvalsequence+"]"));
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    withAction().clickAndHold(source).moveToElement(destination).release().build().perform();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                }
            }
        }catch(Exception e){
            log.error("unable to arrange participants with document action for approval workflow");
            Assert.fail();
        }
    }
    public void reachEnforcementRulePage(){
        try{
            if (Alert_Message_for_ApprovalMatrix.getText().contains("Approval Matrix Not Found for Lei Name")){
                List<WebElementFacade> elements = findAll("//div[@class='card']//*[name()='svg']");
                int size = elements.size();
                for(int begin=1;begin<=size;begin++){
                    Crossbutton_for_RemoveParticipants_From_ApprovalSqquence.click();
                }
                withAction().pause(Duration.ofSeconds(3)).click();
                next_button.click();
                withAction().pause(Duration.ofSeconds(3)).click();
                forNewDocument_text.waitUntilVisible();
                forNewDocument_text.isVisible();
            }
        }catch (Exception e){
            log.error("unable to reach Enforcement rule page" +e);
            Assert.fail();
        }
    }

    public void click_previewSubmit(){
        try{
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",previewAndSubmit_tab);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            previewAndSubmit_tab.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(uspRiderTab_previewAndSubmitScreen.isVisible());
            submitForApproval.click();
            withAction().pause(Duration.ofSeconds(8)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to click preview submit button" +e);
            Assert.fail();
        }
    }
    public void notificationDocumentInApproval_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Approval sequence notification")){

                log.info("Correct notification is visible for document in approval");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
            notification_icon.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to see the notification for document in approval" +e);
            Assert.fail();
        }
    }
    public void clickSelectLegalTerms(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            if (textboxDocumentTerms.isVisible()) {
                textboxDocumentTerms.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(textboxDocumentTerms).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            withAction().moveToElement(textboxDocumentTerms).click().sendKeys(dataTable.get("Legal Terms")).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

            if (submitForApproval.isVisible()) {
                submitForApproval.click();
                withAction().pause(Duration.ofSeconds(5)).build().perform();
            } else if (next_button.isVisible()) {
                next_button.click();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
            }
            else {
                submit_btn.click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }

        } catch (Exception e) {
            log.error("Unable to input Legal Terms-->" + e);
            Assert.fail();

        }
    }
    public void clickSelectAuthProductGroup(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().moveToElement(AuthProducts_group).click().sendKeys(dataTable.get("Auth Product Group")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }catch (Exception e){
            log.error("Unable to click Auth Scope-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectCurrenciesGroup(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            authCurrencies.waitUntilVisible().click();
            currenciesGroup.waitUntilVisible().click();
            withAction().moveToElement(currenciesGroup).click().sendKeys(dataTable.get("Currencies Group")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(submit_btn).click().build().perform();
        }catch (Exception e){
            log.error("Unable to select Currency Group-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectAuthTenorvalue(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().moveToElement(authTenorValue).click().sendKeys(dataTable.get("Auth Value")).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to select Auth Value-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectAuthTenor(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            authSelectTenor.waitUntilVisible().click();
            withAction().moveToElement(authSelectTenor).sendKeys(dataTable.get("Auth Tenor")).pause(Duration.ofSeconds(5)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(5)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to select Auth Tenor-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectCalculationType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            calculationType_tab.click();
            withAction().moveToElement(calculationType_tab).sendKeys(dataTable.get("Calculation Type")).pause(Duration.ofSeconds(5)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to input Calculation Type-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectLimitValue(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            limitValue_tab.waitUntilVisible().click();
            withAction().moveToElement(limitValue_tab).click().sendKeys(dataTable.get("Limit Value")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input Limit Value-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectNettingType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().moveToElement(nettingType_tab).click().sendKeys(dataTable.get("Netting Type")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input Netting Type-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectDelta(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().moveToElement(delta_tab).click().sendKeys(dataTable.get("Delta")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input Delta-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectProductFamily(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().moveToElement(productFamily_tab).click().sendKeys(dataTable.get("Product Family")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input Product Family-->"+e);
            Assert.fail();
        }
    }
    public void clickSelectExcludeCLS(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().moveToElement(excludeCLS_tab).click().sendKeys(dataTable.get("Exclude CLS")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            addLimit_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            next_button.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(7)).build().perform();
        }catch (Exception e){
            log.error("Unable to input Exclude CLS-->"+e);
            Assert.fail();
        }
    }
    public void check_if_filterStatus_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_document_status).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        }catch (Exception e){
            log.error("Unable to set the status filter"+e);
            Assert.fail();
        }
    }

    public void confirmation_popup_actingAs(){
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            confirmation_pop_up_actingAs.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(confirmation_pop_up_actingAs).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(confirmation_pop_up_actingAs).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }catch (Exception e){
            log.error("Unable to select acting as");
            Assert.fail();
        }
    }
    public void confirmation_popup_Approval_Group(){
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            confirmation_pop_up_approvalGroup.click();
            confirmation_pop_up_approvalGroup.clear();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalGroup).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            if (confirmation_pop_up_approve_btn.isVisible()) {
                confirmation_pop_up_approve_btn.click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                log.info("Clicked on approve button");
            }else{
                confirmation_pop_up_reject_btn.click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                log.info("Clicked on reject button");
            }
        }catch (Exception e){
            log.error("Unable to select Approval Group");
            Assert.fail();
        }
    }
    public void notificationDocumentApproved_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Document Approved Notification")){

                log.info("Correct notification is visible for approving the document");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for approving the document" +e);
            Assert.fail();
        }
    }
    public void notificationDocumentRejected_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Document Rejected Notification")){

                log.info("Correct notification is visible for rejected the document");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for rejected the document" +e);
            Assert.fail();
        }
    }

    public void notificationDocumentCanceled_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Document Cancelled Notification")){

                log.info("Correct message is visible for cancelling the document");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the message for cancelling the document" +e);
            Assert.fail();
        }
    }
    public void assignRole_RequestDocument(List<String> RolesList)
    {
        try {
            selectedRole_list.waitUntilVisible();
            for (int begin=1;begin<RolesList.size();begin++){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (!selectedRole_list.getText().contains(RolesList.get(begin))){
                    role_Mapping1.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    role_Mapping1.clear();
                    withAction().moveToElement(role_Mapping1).click().sendKeys(RolesList.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                }
            }
        }catch (Exception e){
            Assert.fail("User unable to remove Assigned roles"+e);
            Assert.fail();
        }
    }
    public void enter_docType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectDocType.waitUntilClickable();
            withAction().moveToElement(selectDocType).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Doc type -->"+e);
            Assert.fail();
        }
    }

    public void notificationDocumentDraft_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Add document draft for participant")){

                log.info("Correct notification is visible for saving the document as draft");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for saving the document as draft" +e);
            Assert.fail();
        }
    }
    public void selectActionType_Edit(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            confirmation_pop_up_approvalGroup.waitUntilClickable();
            confirmation_pop_up_approvalGroup.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalGroup).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalGroup).click().sendKeys(dataTable.get("Action type")).pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            submit_btn.waitUntilEnabled();
            submit_btn.click();
            withAction().pause(Duration.ofSeconds(8)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select Action type" +e);
            Assert.fail();
        }
    }
    public void notificationDocumentEnforced_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("Document Enforced Notification")){

                log.info("Correct notification is visible for enforcing the document");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for enforcing the document" +e);
            Assert.fail();
        }
    }
}
