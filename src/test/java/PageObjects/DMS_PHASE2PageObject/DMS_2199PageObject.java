package PageObjects.DMS_PHASE2PageObject;


import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DMS_2199PageObject extends PageObject {


    @FindBy(xpath = "//th[text()='Document Action']//input")
    private WebElementFacade DocumentAction_Column_Input;
    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade searched_result;
    @FindBy(xpath = "//th[text()='Document Status']//input")
    private WebElementFacade DocumentStatus_Column_Input;
    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade EditButton;
    @FindBy(xpath = "//div[text()='Edit Document']")
    private WebElementFacade EditDocument_text;
    @FindBy(xpath = "//button[text()='USP Rider']")
    private WebElementFacade USPRider_button;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]")
    private WebElementFacade USPRiderContainer;
    @FindBy(xpath = "//div[text()='Document type']/following-sibling::div/div")
    private WebElementFacade documenttype_text;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]")
    private WebElementFacade USPRiderContainer2;
    @FindBy(xpath = "//p[text()='Edit']")
    private WebElementFacade Edit_Text;
    @FindBy(xpath = "//div[@class='lp-copy-sel__input-container css-19bb58m']")
    private WebElementFacade ActingAs_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//label[text()='Action type']/following::input")
    private WebElementFacade Actingtype_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade SubmitButtonONEDIT_POPUP;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElementFacade Successmessage;
    @FindBy(xpath = "//table/tbody/tr[9]/td[1]")
    private WebElementFacade USPApprovalmatrix;
    @FindBy(xpath = "//div[@class='content-label']")
    private WebElementFacade Document_Version_ID_text;
    @FindBy(xpath = "//th[text()='Document Version ID']//input")
    private WebElementFacade SearchBox_of_DocumentVersionID;
    ///USP Rider tab
    @FindBy(xpath = "//div[text()  ='Prime Broker'and text()='1']")
    private WebElementFacade PrimeBroker1Text_ON_USP_RIDER_tab;
    @FindBy(xpath = "//div[text()  ='Client'and text()='1']")
    private WebElementFacade Client1Text_ON_USP_RIDER_tab;
    @FindBy(xpath = "//div[text()  ='Prime Broker'and text()='1']/following-sibling::div")
    private WebElementFacade LEI_IDofPrimeBroker1_ON_USP_RIDER_tab;
    @FindBy(xpath = "//div[text()  ='Prime Broker'and text()='1']/following-sibling::strong")
    private WebElementFacade LEI_NameofPrimeBroker1_ON_USP_RIDER_tab;
    @FindBy(xpath = "//div[text()  ='Client'and text()='1']/following-sibling::div")
    private WebElementFacade LEI_IDofClient1_ON_USP_RIDER_tab;
    @FindBy(xpath = "//div[text()  ='Client'and text()='1']/following-sibling::strong")
    private WebElementFacade LEI_NameofClient1_ON_USP_RIDER_tab;
    @FindBy(xpath = "//img[@alt='arrow']")
    private WebElementFacade Arrow_to_Show_Further_INFO_of_Template;
    @FindBy(xpath = "//div[@class='usp-rider-detail-container']")
    private WebElementFacade USP_rider_DetailContainer;
    @FindBy(xpath = "//div[text()='USP Rider document not available']")
    private WebElementFacade USP_RiderDocument_Not_Available_text;
    @FindBy(xpath = "//button[text()='Create New']")
    private WebElementFacade CreateNEW_button;
    @FindBy(xpath = "//div[text()='Available USP Rider document']")
    private WebElementFacade Available_USP_Rider_Document_text;
    @FindBy(xpath = "//div[text()='Available USP Rider document']/following::input[@name='checkbox']")
    private WebElementFacade CheckBox_For_Available_USP_Rider;
    @FindBy(xpath = "//div[text()='Available USP Rider document']/following-sibling::div")
    private WebElementFacade Template_ID_for_Available_USP_Rider;
//////////////////////////
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='USP Rider document not available']")
    private WebElementFacade USP_RiderDocument_Not_Available_text_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='USP Rider document not available']")
    private WebElementFacade USP_RiderDocument_Not_Available_text_for2ndContainer;

    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//button[text()='Create New']")
    private WebElementFacade CreateNEW_button_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//button[text()='Create New']")
    private WebElementFacade CreateNEW_button_for2ndContainer;

    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='Available USP Rider document']")
    private WebElementFacade Available_USP_Rider_Document_text_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='Available USP Rider document']/following::input[@name='checkbox']")
    private WebElementFacade CheckBox_For_Available_USP_Rider_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='Available USP Rider document']/following-sibling::div")
    private WebElementFacade Template_ID_for_Available_USP_Rider_for1stContainer;

    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='Available USP Rider document']")
    private WebElementFacade Available_USP_Rider_Document_text_for2ndContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='Available USP Rider document']/following::input[@name='checkbox']")
    private WebElementFacade CheckBox_For_Available_USP_Rider_for2ndContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='Available USP Rider document']/following-sibling::div")
    private WebElementFacade Template_ID_for_Available_USP_Rider_for2ndContainer;
//////////////////////////////////////////////////////////////
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforprimebroker1party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[@class='head-status ']")
    private WebElementFacade OnlineStatusFOR_PrimeBroker1_Party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforprimebroker2party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[@class='head-status ']")
    private WebElementFacade OnlineStatusFOR_PrimeBroker2_Party;
////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Cancel_Button;
    @FindBy(xpath = "//button[text()='Back']")
    private WebElementFacade Back_Button;
    @FindBy(xpath = "//button[text()='Reset current changes']")
    private WebElementFacade Reset_Current_changes_Button;
    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade Save_As_draft_Button;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade Next_Button;
    @FindBy(xpath = "//button[text()='Submit for approval']")
    private WebElementFacade Submit_forApproval_Button;
    @FindBy(xpath = "//div[@class='detail-pf ']//h4")
    private WebElementFacade AssignedRoles_For_loggedIN_USER;
    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    private WebElementFacade datepickercheckbox;
    @FindBy(xpath = "//input[@value=\"Select Date\"]")
    private WebElementFacade datepicker;



    public void Selectitemfor_DocumentAction_Column(List<String> DocAction) {
        try {
//        Next 6 line code is performing horizontal scrolling of table
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentAction_Column_Input);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            jsExecutor.executeScript("window.scrollBy(0, 500);");
            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            withAction().pause(Duration.ofSeconds(3)).build().perform();
            DocumentAction_Column_Input.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin=1;begin<DocAction.size();begin++)
            {
                DocumentAction_Column_Input.type(DocAction.get(begin));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertTrue(DocAction.get(begin).equalsIgnoreCase(searched_result.getText()));
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//                if (DocAction.get(begin).equalsIgnoreCase(searched_result.getText()))
//                {
//                    withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//                }
            }
        }catch (Exception e){
            log.error("unable to Select item from Document Action Column " + e);
            Assert.fail();
        }
    }

    public void Selectitemfor_DocumentStatus_Column(List<String> DocStatus) {
        try {
////        Next 6 line code is performing horizontal scrolling of table
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
//            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentStatus_Column_Input);
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            jsExecutor.executeScript("window.scrollBy(0, 500);");
//            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(DocumentStatus_Column_Input).pause(Duration.ofSeconds(3)).click().build().perform();
//            DocumentStatus_Column_Input.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin=1;begin<DocStatus.size();begin++)
            {
                DocumentStatus_Column_Input.type(DocStatus.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(DocStatus.get(begin).equalsIgnoreCase(searched_result.getText()));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//                if (DocAction.get(begin).equalsIgnoreCase(searched_result.getText()))
//                {
//                    withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//                }
            }
        }catch (Exception e){
            log.error("unable to Select item from Document Status Column " + e);
            Assert.fail();
        }
    }

    public void SelectActionType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Actingtype_Input_ONEDIT_POPUP.waitUntilVisible();
            withAction().moveToElement(Actingtype_Input_ONEDIT_POPUP).click().sendKeys(dataTable.get("Action type")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to select Action type" +e);
            Assert.fail();
        }
    }

    public void CheckUSPRiderDocumentAvailability() {
        try {
            if (documenttype_text.getText().equals("DN")){
                if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && OnlineStatusFOR_PrimeBroker1_Party.isVisible() ) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CreateNEW_button_for1stContainer.isVisible());
                } else if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && litestatusforprimebroker1party.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertFalse(CreateNEW_button_for1stContainer.isVisible());
                } else if (Available_USP_Rider_Document_text_for1stContainer.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CheckBox_For_Available_USP_Rider_for1stContainer.isVisible());
                    Assert.assertTrue(Template_ID_for_Available_USP_Rider_for1stContainer.isVisible());
                }
            } else if (documenttype_text.getText().equals("4 Way")) {
                if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && OnlineStatusFOR_PrimeBroker1_Party.isVisible() ) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CreateNEW_button_for1stContainer.isVisible());
                } else if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && litestatusforprimebroker1party.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertFalse(CreateNEW_button_for1stContainer.isVisible());
                } else if (Available_USP_Rider_Document_text_for1stContainer.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CheckBox_For_Available_USP_Rider_for1stContainer.isVisible());
                    Assert.assertTrue(Template_ID_for_Available_USP_Rider_for1stContainer.isVisible());
                }
                if (USP_RiderDocument_Not_Available_text_for2ndContainer.isVisible() && OnlineStatusFOR_PrimeBroker2_Party.isVisible() ) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CreateNEW_button_for2ndContainer.isVisible());
                } else if (USP_RiderDocument_Not_Available_text_for2ndContainer.isVisible() && litestatusforprimebroker2party.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertFalse(CreateNEW_button_for2ndContainer.isVisible());
                } else if (Available_USP_Rider_Document_text_for2ndContainer.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CheckBox_For_Available_USP_Rider_for2ndContainer.isVisible());
                    Assert.assertTrue(Template_ID_for_Available_USP_Rider_for2ndContainer.isVisible());
                }
            }

        }catch (Exception e){
            log.error("unable to validate Document template and create new Availability ");
            Assert.fail();
        }
    }

    public void CheckUSPRiderTemplateCount(){
        try {
            if (documenttype_text.getText().equals("DN")){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(USPRiderContainer.isVisible());
            } else if (documenttype_text.getText().equals("4 Way")) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(USPRiderContainer.isVisible());
                Assert.assertTrue(USPRiderContainer2.isVisible());
            }
        }catch (Exception e){
            log.error("USP rider template count is not correct according to Document Type" +e);
            Assert.fail();
        }
    }

    public void CheckUSPDetailContainervisiblity(){
        try {
            if (Template_ID_for_Available_USP_Rider.isVisible() && Available_USP_Rider_Document_text.isVisible()) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(USP_rider_DetailContainer.isVisible());
            }else {
                log.info("User is not able to see USP Rider Container for available usp rider");
            };
        }catch (Exception e){
            log.error("USP Rider Detail container is not Visible " +e);
            Assert.fail();
        }
    }

    public void UpdateAvailableUSPRider(){
        try {
            if(Available_USP_Rider_Document_text.isVisible() && CheckBox_For_Available_USP_Rider.isVisible()){
                boolean checkboxbefore = CheckBox_For_Available_USP_Rider.isSelected();
                if (!CheckBox_For_Available_USP_Rider.isSelected()){
                    CheckBox_For_Available_USP_Rider.click();
                    log.info("USP is is Added to Document");
                }else {
                    CheckBox_For_Available_USP_Rider.click();
                    log.info("USP Rider is removed from Document");
                }
                String versionID= Document_Version_ID_text.getText();
                Save_As_draft_Button.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(Successmessage.getText().contains("USP Rider for document saved successfully"));
                getDriver().navigate().back();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                SearchBox_of_DocumentVersionID.waitUntilVisible();
                withAction().moveToElement(SearchBox_of_DocumentVersionID).click().sendKeys(versionID).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(EditButton.isVisible());
                EditButton.click();
                withAction().pause(Duration.ofSeconds(6)).build().perform();
                Assert.assertTrue(EditDocument_text.isVisible());
                Assert.assertTrue(USPRider_button.isVisible());
                USPRider_button.click();
                withAction().pause(Duration.ofSeconds(5)).build().perform();
                Assert.assertNotEquals((boolean) checkboxbefore, CheckBox_For_Available_USP_Rider.isSelected());
            }else {
                Assert.assertTrue(USP_RiderDocument_Not_Available_text.isVisible());
                log.info("Document doesn't have any USP Rider to Update");
            }

        }catch (Exception e){
            log.error("Unable to Update Available USP Rider " +e);
            Assert.fail();
        }
    }






}

