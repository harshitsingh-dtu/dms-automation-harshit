package PageObjects.DMS_PHASE2PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2202PageObject extends PageObject {

    @FindBy(xpath="//div[@class='flex align-center justify-center pointer sidebar-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath ="//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupsTemplate_btn;

    @FindBy(xpath ="//a[@data-testid='submenu-link-USP Riders']")
    private WebElementFacade uspRiderTemplate_btn;

    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade updateButton_USPListingScreen;

    @FindBy(xpath = "//div[text()='Showing all USP Rider templates']")
    private WebElementFacade redirected_USPListingScreen;

    @FindBy(xpath = "//h3[text()='Edit USP rider template']")
    private WebElementFacade updateScreen_USPRider;

    @FindBy(xpath = "//h3[text()='View USP rider template']")
    private WebElementFacade viewScreen_USPRider;

    @FindBy(xpath = "//h4[text()='Document type']/following-sibling::div")
    private WebElementFacade selectedDocType_USPRiderTempUpdateScreen;

    @FindBy(xpath = "//div[@class='usp-label']")
    private List<WebElementFacade> primeBrokerClient_LEIiDs;

    @FindBy(xpath = "//strong[@class='usp-label bold']")
    private WebElementFacade primeBrokerName_USPCreateTemplateScreen;

    @FindBy(xpath = "//strong[@class='usp-label']")
    private WebElementFacade clientName_USPCreateTemplateScreen;

    @FindBy(xpath = "//input[@placeholder='Enter contact']")
    private WebElementFacade enterPBContact_USPCreateTemplateScreen;

    @FindBy(xpath = "//textarea[@placeholder='Type word clause']")
    private WebElementFacade enterWordClause_USPCreateTemplateScreen;

    @FindBy(xpath = "//div[@class='fund-leis']")
    private WebElementFacade pbCounterParty_USPViewTemplateScreen;

    @FindBy(xpath = "//div[@class='select-menu-container']")
    private WebElementFacade pbCounterParty_USPUpdateTemplateScreen;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancelButton_USPCreateTemplateScreen;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submitButton_USPCreateTemplateScreen;

    @FindBy(xpath = "//button[text()='View']")
    private WebElementFacade viewButton_USPListingScreen;

    @FindBy(xpath = "//div[@class='value']")
    private WebElementFacade pbContactWordClauseValue_USPListingScreen;

    @FindBy(xpath = "//div[@datatestid='multi-select-Select-docType']")
    private WebElementFacade selectDocType_USPListingScreen;

    @FindBy(xpath = "//button[@title='Clear']")
    private WebElementFacade clearDocType_USPListingScreen;

    @FindBy(xpath = "//td/div[text()='4 Way']")
    private List<WebElementFacade> fourWayList_USPListingScreen;

    @FindBy(xpath = "//td/div[text()='DN']")
    private List<WebElementFacade> DNList_USPListingScreen;

    @FindBy(xpath = "//td/div[text()='DN +1']")
    private List<WebElementFacade> DNFourWayList_USPListingScreen;

    @FindBy(xpath = "//td/div[text()='DN +1']")
    private WebElementFacade DNFourWay_USPListingScreen;

    @FindBy(xpath = "//div[text()='4 Way +1']")
    private List<WebElementFacade> FourWayDNList_USPListingScreen;

    @FindBy(xpath = "//div[text()='4 Way +1']")
    private WebElementFacade FourWayDN_USPListingScreen;

    @FindBy(xpath = "//input[@placeholder='Enter contact']")
    private WebElementFacade enterPBContact_USPTempUpdateScreen;

    @FindBy(xpath = "//div[@class='alert-msg']")
    private WebElementFacade impactedDocumentPopup_USPTempUpdateScreen;

    @FindBy(xpath = "//div[text()='Confirmation']")
    private WebElementFacade confirmationText_impactedDocumentsPopup;

    @FindBy(xpath = "//div[text()='Do you want to view impacted document?']")
    private WebElementFacade messageText_impactedDocumentsPopup;

    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade noButton_impactedDocumentsPopup;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade yesButton_impactedDocumentsPopup;

    @FindBy(xpath = "//div[text()='Usprider template updated']")
    private WebElementFacade updateToastMessage_impactedDocument;

    @FindBy(xpath = "//input[@placeholder='Search with document & version ID']")
    private WebElementFacade searchDocumentAndVersionID_impactedDocumentPopup;

    @FindBy(xpath = "//table[@class='custom-batch-table']//th")
    private List<WebElementFacade> columns_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//td[@class='checkbox check']//following-sibling::td[1]")
    private WebElementFacade documentId_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade closeButton_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//button[text()='Apply']")
    private WebElementFacade applyButton_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//td[@class='checkbox check']/input")
    private List<WebElementFacade> selectDocumentCheckbox_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//div[text()='Lite users alert']")
    private WebElementFacade liteUsersAlert_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//strong[text()='Bulk request']")
    private WebElementFacade bulkRequestText_impactedDocumentsDrawerScreen;

    @FindBy(xpath = "//div[text()='DN']")
    private List<WebElementFacade> dnRelatedUspTemplatesList;

    @FindBy(xpath = "//div[text()='4 Way']")
    private List<WebElementFacade> fourWayRelatedUspTemplatesList;

    @FindBy(xpath = "//div[@class='usp-title']")
    private WebElementFacade usp_title;
    @FindBy(xpath = "//tr/td[1]")
    private List<WebElementFacade> list_USP_IDs;
    @FindBy(xpath = "//tr/td[2]")
    private List<WebElementFacade> list_USP_with_PBs;
    @FindBy(xpath = "//div[@class='usp-subtitle']")
    private WebElementFacade USP_sub_tittle;
    @FindBy(xpath = "//input[@placeholder='Search by ID']")
    private WebElementFacade search_box_by_USP_ID;
    @FindBy(xpath = "//button[text()='+ Create New USP Rider']")
    private WebElementFacade create_new_USP_template_button;
    @FindBy(xpath = "//input[@placeholder='PB']")
    private WebElementFacade PB_dropdown;
    @FindBy(xpath = "//input[@placeholder='Client']")
    private WebElementFacade Clients_dropdown;
    @FindBy(xpath = "//input[@placeholder='Doc type']")
    private WebElementFacade Doc_type_filter;


    public void clickOnUSPRiderTemplateTabUnderGroupsTemplateTab(){
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            navigation_btn.waitUntilClickable().click();
            groupsTemplate_btn.waitUntilClickable().click();
            uspRiderTemplate_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to reach USP Rider template listing screen -->"+e);
            Assert.fail();
        }
    }
    public void validateUpdateScreen_USPRiderTemplate() {
        try {
            int primeBrokerClient_LEIiDsSize = primeBrokerClient_LEIiDs.size();
            log.info("column size on screen is :" + primeBrokerClient_LEIiDsSize);

            for (WebElementFacade primeBrokerClient_LEIiDs_Text : primeBrokerClient_LEIiDs) {

                Assert.assertTrue(primeBrokerClient_LEIiDs_Text.isVisible());
            }
            int column_size = primeBrokerClient_LEIiDs.size();
            log.info("column size on screen is :" + column_size);

            for (WebElementFacade primeBrokerClient_LEIiDs_Text : primeBrokerClient_LEIiDs) {

                Assert.assertTrue(primeBrokerClient_LEIiDs_Text.isVisible());
            }
            String PBContactValue = enterPBContact_USPCreateTemplateScreen.getValue().trim();
            String WordClauseText = enterWordClause_USPCreateTemplateScreen.getText().trim();
            Assert.assertFalse(PBContactValue.isEmpty());
            Assert.assertFalse(WordClauseText.isEmpty());
        } catch (Exception e) {
            log.error("Unable to validate USP Rider update screen " + e);
            Assert.fail();
        }
    }

    public void selectDocTypeUpdate_USPTempListingScreen(List<String> docType){
        try{
            for (int begin = 1; begin < docType.size(); begin++){
                selectDocType_USPListingScreen.waitUntilClickable();
                if (clearDocType_USPListingScreen.isVisible()){
                    clearDocType_USPListingScreen.click();
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(selectDocType_USPListingScreen).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }

            int column_size= fourWayList_USPListingScreen.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade FourWayList : fourWayList_USPListingScreen){

                Assert.assertTrue(FourWayList.isVisible());
                Assert.assertTrue(updateButton_USPListingScreen.isVisible());
                log.info("Update button is visible");
            }
        }
        catch (Exception e){
            log.error("Unable to select doc type " +e);
            Assert.fail();
        }
    }
    public void selectDocTypeDNUpdate_USPTempListingScreen(List<String> docType){
        try{
            for (int begin = 1; begin < docType.size(); begin++){
                selectDocType_USPListingScreen.waitUntilClickable();
                if (clearDocType_USPListingScreen.isVisible()){
                    clearDocType_USPListingScreen.click();
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(selectDocType_USPListingScreen).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }

            int column_size= DNList_USPListingScreen.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade DNList : DNList_USPListingScreen){

                Assert.assertTrue(DNList.isVisible());
                Assert.assertTrue(updateButton_USPListingScreen.isVisible());
                log.info("Update button is visible");
            }
        }
        catch (Exception e){
            log.error("Unable to select doc type " +e);
            Assert.fail();
        }
    }
    public void selectDocTypeDNView_USPTempListingScreen(List<String> docType){
        try{
            for (int begin = 1; begin < docType.size(); begin++){
                selectDocType_USPListingScreen.waitUntilClickable();
                if (clearDocType_USPListingScreen.isVisible()){
                    clearDocType_USPListingScreen.click();
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(selectDocType_USPListingScreen).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }

            int column_size= DNList_USPListingScreen.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade DNList : DNList_USPListingScreen){

                Assert.assertTrue(DNList.isVisible());
                Assert.assertTrue(viewButton_USPListingScreen.isVisible());
                log.info("View button is visible");
            }
        }
        catch (Exception e){
            log.error("Unable to select doc type " +e);
            Assert.fail();
        }
    }
    public void selectDocTypeView_USPTempListingScreen(List<String> docType){
        try{
            for (int begin = 1; begin < docType.size(); begin++){
                selectDocType_USPListingScreen.waitUntilClickable();
                if (clearDocType_USPListingScreen.isVisible()){
                    clearDocType_USPListingScreen.click();
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(selectDocType_USPListingScreen).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }

            int column_size= fourWayList_USPListingScreen.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade FourWayList : fourWayList_USPListingScreen){

                Assert.assertTrue(FourWayList.isVisible());
                Assert.assertTrue(viewButton_USPListingScreen.isVisible());
                log.info("View button is visible");
            }
        }
        catch (Exception e){
            log.error("Unable to select doc type " +e);
            Assert.fail();
        }
    }
    public void select_bothDocType(List<String> docType){
        try{
            for (int begin = 1; begin < docType.size(); begin++) {
                selectDocType_USPListingScreen.waitUntilClickable();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(selectDocType_USPListingScreen).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            if(FourWayDN_USPListingScreen.isVisible()) {
                int FourWayDNListSize_USPListingScreen = FourWayDNList_USPListingScreen.size();
                log.info("column size on screen is :" + FourWayDNListSize_USPListingScreen);

                for (WebElementFacade FourWayDNList : FourWayDNList_USPListingScreen) {

                    Assert.assertTrue(FourWayDNList.isVisible());
                    Assert.assertTrue(viewButton_USPListingScreen.isVisible());
                    log.info("View button is visible");
                }
            }
            if (DNFourWay_USPListingScreen.isVisible()) {
                int DNFourWayListSize_USPListingScreen = DNFourWayList_USPListingScreen.size();
                log.info("column size on screen is :" + DNFourWayListSize_USPListingScreen);

                for (WebElementFacade FourWayDNList : DNFourWayList_USPListingScreen) {

                    Assert.assertTrue(FourWayDNList.isVisible());
                    Assert.assertTrue(viewButton_USPListingScreen.isVisible());
                    log.info("View button is visible");
                }
            }
        }
        catch (Exception  e){
            log.error("Unable to select doc type " +e);
            Assert.fail();
        }
    }
    public void enterPBContact_USPUpdateScreen(List<String> pBContact){
        try{
            for (int begin = 1; begin < pBContact.size(); begin++) {
                enterPBContact_USPTempUpdateScreen.waitUntilClickable();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(enterPBContact_USPTempUpdateScreen).click().sendKeys(pBContact.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(5)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to make changes on USP Update Screen " +e);
            Assert.fail();
        }
    }
    public void seeChanges_UpdatedField(){
        try{
            String PBContact_Value= enterPBContact_USPTempUpdateScreen.getValue().trim();
            submitButton_USPCreateTemplateScreen.waitUntilEnabled();
            withAction().moveToElement(submitButton_USPCreateTemplateScreen).click().build().perform();
            withAction().moveToElement(noButton_impactedDocumentsPopup).click().build().perform();
            Assert.assertTrue(updateToastMessage_impactedDocument.isVisible());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(updateButton_USPListingScreen).click().build().perform();
            String PBContactValue_AfterUpdate= enterPBContact_USPTempUpdateScreen.getValue().trim();
            if (PBContact_Value.equalsIgnoreCase(PBContactValue_AfterUpdate)){
                log.info("Correct Updates are visible");
            }
        }
        catch (Exception e){
            log.error("Unable to see any changes on update screen "+e);
            Assert.fail();
        }
    }
    public void notSeeChanges_UpdatedField(){
        try{
            String PBContact_Value= enterPBContact_USPTempUpdateScreen.getValue().trim();
            withAction().moveToElement(cancelButton_USPCreateTemplateScreen).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(updateButton_USPListingScreen).click().build().perform();
            String PBContactValue_AfterUpdate= enterPBContact_USPTempUpdateScreen.getValue().trim();
            if (!PBContact_Value.equalsIgnoreCase(PBContactValue_AfterUpdate)){
                log.info("No Updates are visible");
            }
        }
        catch (Exception e){
            log.error("Able to see changes on update screen "+e);
            Assert.fail();
        }
    }
    public void validateImpactedDocuments_drawerScreen(){
        try{
            if (documentId_impactedDocumentsDrawerScreen.isVisible()){

                int column_size= columns_impactedDocumentsDrawerScreen.size();
                log.info("column size on screen is :" +column_size);

                for(WebElementFacade AllColumns : columns_impactedDocumentsDrawerScreen){

                    Assert.assertTrue(AllColumns.isVisible());
                }
            }
            else {
                log.info("No Record Found to validate this test case that's why going to fail this test case");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to validate impacted documents drawer screen " +e);
            Assert.fail();
        }
    }
    public void checkDNRelatedUSPTemplates(){
        try{
            int column_size= dnRelatedUspTemplatesList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade DNRelatedUspTemplatesList : dnRelatedUspTemplatesList){

                Assert.assertTrue(DNRelatedUspTemplatesList.isVisible());
                Assert.assertTrue(updateButton_USPListingScreen.isVisible());
            }
        }
        catch (Exception e){
            log.error("Unable to check DN related USP Templates " +e);
            Assert.fail();
        }
    }
    public void checkFourWayRelatedUSPTemplates(){
        try{
            int column_size= fourWayRelatedUspTemplatesList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade FourWayRelatedUspTemplatesList : fourWayRelatedUspTemplatesList){

                Assert.assertTrue(FourWayRelatedUspTemplatesList.isVisible());
                Assert.assertTrue(updateButton_USPListingScreen.isVisible());
            }
        }
        catch (Exception e){
            log.error("Unable to check 4 Way related USP Templates " +e);
            Assert.fail();
        }
    }
    public void selectAllDocumentCheckbox_impactedDocumentsDrawerScreen(){
        try{
            int column_size= selectDocumentCheckbox_impactedDocumentsDrawerScreen.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade SelectAllDocumentCheckbox_impactedDocumentsDrawerScreen : selectDocumentCheckbox_impactedDocumentsDrawerScreen){

                SelectAllDocumentCheckbox_impactedDocumentsDrawerScreen.click();
            }
        }
        catch (Exception e){
            log.error("Unable to select document checkbox " +e);
            Assert.fail();
        }
    }
    public void Validate_usp_rider_listing_screen_element(){
        Assert.assertTrue(usp_title.isVisible());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(Doc_type_filter.isVisible());
        Assert.assertTrue(Clients_dropdown.isVisible());
        Assert.assertTrue(PB_dropdown.isVisible());
        Assert.assertTrue(create_new_USP_template_button.isVisible());
        }
}
