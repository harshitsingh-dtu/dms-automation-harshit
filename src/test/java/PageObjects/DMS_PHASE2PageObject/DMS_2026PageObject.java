package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class DMS_2026PageObject extends PageObject {

    @FindBy(xpath = "//div[@class='link']")
    private WebElementFacade documentVersionID_link;

    @FindBy(xpath = "//li[text()='General Terms']")
    private WebElementFacade generalTerms_text;

    @FindBy(xpath = "//div[@class='gt-preview-wrapper']")
    private WebElementFacade generalTerms_info;

    @FindBy(xpath = "//div//label[text()='Acting as']//following::input[1]")
    private WebElementFacade confirmation_pop_up_actingAs;

    @FindBy(xpath = "//div[@class='acting-content dif']//input")
    private WebElementFacade pop_up_actionType;

    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade previewAndSubmit_tab;

    @FindBy(xpath = "//div[text()='Final Preview']")
    private WebElementFacade finalPreview;

    @FindBy(xpath = "//h1[@class='apppendix-1']")
    private WebElementFacade appendix_section;

    @FindBy(xpath = "//li[text()='Funds']")
    private WebElementFacade funds_text;

    @FindBy(xpath = "//div[@class='fund-lei']")
    private WebElementFacade funds_LEIName;

    @FindBy(xpath = "//div[@class='fund-info']")
    private WebElementFacade funds_info;

    @FindBy(xpath = "//input[@placeholder='Enter address (max. 100 characters)']")
    private WebElementFacade enterAddress_PB;

    @FindBy(xpath = "//input[@placeholder='Enter contact (max. 100 characters)']")
    private WebElementFacade enterContact_PB;

    @FindBy(xpath = "//input[@placeholder='Type & Select Acting Office']")
    private WebElementFacade selectActingOffice_PB;

    @FindBy(xpath = "//input[@placeholder='Select Relationship']")
    private WebElementFacade selectRelationship_PB;

    @FindBy(xpath = "//input[@placeholder='Type & Select Specified office(s)']")
    private WebElementFacade selectSpecifiedOffice_PB;

    @FindBy(xpath = "//textarea[@placeholder='Enter notes (max. 1000 characters)']")
    private WebElementFacade enterNotes;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade nextButton;

    @FindBy(xpath = "//button[text()='General terms']")
    private WebElementFacade generalTerms_tab;

    @FindBy(xpath = "//div[@class='info-head ']//span")
    private WebElementFacade viewFund_details_Client1;

    @FindBy(xpath = "(//div[@class='info-head ']//span)[2]")
    private WebElementFacade viewFund_details_Client2;

    @FindBy(xpath = "//div[@class='info-head ']//span")
    private WebElementFacade noRecordFound;

    @FindBy(xpath = "//button[text()='Edit']")
    private WebElementFacade editButton;

    @FindBy(xpath = "//*[@data-testid='fund-drawer-multi-select'] | //div[text()='Search & add funds']")
    private WebElementFacade search_addFund;

    @FindBy(xpath = "//div[@role='listbox']")
    private WebElementFacade checkbox;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElementFacade saveButton;

    @FindBy(xpath = "//div[text()='Funds updated successfully']")
    private WebElementFacade funds_notification;

    @FindBy(xpath = "//div[@class='btn-content']//button[text()='Cancel']")
    private WebElementFacade cancelButton;

    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade saveAsDraft_btn;

    @FindBy (xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade search_versionID;

    @FindBy (xpath = "//div[@class='content-label']")
    private WebElementFacade get_versionID;

    @FindBy (xpath = "//div[@class='fund-item']")
    private WebElementFacade fundItem;

    @FindBy (xpath = "//div[text()='Contact/Specified offices']")
    private WebElementFacade redirected_generalTermsTab;

    @FindBy(xpath = "//button[text()='General Terms']")
    private WebElementFacade generalTermsTab_documentScreen;


    public void checkInfo_GeneralTerms(){
        try{
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",generalTerms_text);
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            generalTerms_text.waitUntilVisible();
            Assert.assertTrue(generalTerms_text.isVisible());
            Assert.assertTrue(generalTerms_info.isVisible());
            List<WebElementFacade> infoList = findAll("//div[@class='gt-preview-info']");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){

                Assert.assertTrue(Info_Text.isVisible());
                log.info(Info_Text.getText());

            }
            log.info("All General Terms info is visible in the document preview");
        }
        catch (Exception e){
            log.error("Unable to see info for general terms in the document preview");
            Assert.fail();
        }
    }
    public void popup_actingAs() {
        try {
            withAction().moveToElement(confirmation_pop_up_actingAs).click().sendKeys(Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select acting as");
            Assert.fail();
        }
    }
    public void enterAddress(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            enterAddress_PB.waitUntilVisible();
            enterAddress_PB.clear();
            withAction().moveToElement(enterAddress_PB).click().sendKeys(dataTable.get("Address")).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to enter address" +e);
            Assert.fail();
        }
    }
    public void enterContact(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            enterContact_PB.waitUntilVisible();
            enterContact_PB.clear();
            withAction().moveToElement(enterContact_PB).click().sendKeys(dataTable.get("Contact")).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to enter contact" +e);
            Assert.fail();
        }
    }
    public void selectActingOffice(){
        try{
            selectActingOffice_PB.waitUntilVisible();
            withAction().moveToElement(selectActingOffice_PB).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select acting office" +e);
            Assert.fail();
        }
    }
    public void selectRelationship(){
        try{
            selectRelationship_PB.waitUntilVisible();
            withAction().moveToElement(selectRelationship_PB).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select relationship" +e);
            Assert.fail();
        }
    }
    public void selectSpecifiedOffice(){
        try{
            selectSpecifiedOffice_PB.waitUntilVisible();
            withAction().moveToElement(selectSpecifiedOffice_PB).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select specified office" +e);
            Assert.fail();
        }
    }
    public void enterNotes(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            enterNotes.waitUntilClickable();
            enterNotes.clear();
            withAction().moveToElement(enterNotes).click().sendKeys(dataTable.get("Notes")).pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to enter notes" +e);
            Assert.fail();
        }
    }
    public void checkInfo_GeneralTerms_FinalPreview(){
        try{
            List<WebElementFacade> infoList = findAll("//div[@class='gt-preview-info']");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){

                Assert.assertTrue(Info_Text.isVisible());
                log.info(Info_Text.getText());

            }
            log.info("All General Terms info is visible in the document preview");
        }
        catch (Exception e){
            log.error("Unable to see info for general terms in the document preview");
            Assert.fail();
        }
    }
    public void addFunds_Client1(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            viewFund_details_Client1.waitUntilVisible();
            viewFund_details_Client1.click();
            if (noRecordFound.isPresent()){
                editButton.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().moveToElement(search_addFund).click().sendKeys(dataTable.get("Funds")).pause(Duration.ofSeconds(4)).build().perform();
                checkbox.waitUntilVisible();
                checkbox.click();
                saveButton.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Assert.assertTrue(funds_notification.isVisible());
                withAction().pause(Duration.ofSeconds(8)).build().perform();
            }
            else if (fundItem.isPresent()){
                cancelButton.waitUntilVisible();
                cancelButton.click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to add funds details for Client 1" +e);
            Assert.fail();
        }
    }
    public void addFunds_Client2(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            viewFund_details_Client2.waitUntilVisible();
            viewFund_details_Client2.click();
            if (noRecordFound.isPresent()){
                editButton.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(search_addFund).click().sendKeys(dataTable.get("Funds")).pause(Duration.ofSeconds(2)).build().perform();
                checkbox.waitUntilVisible();
                checkbox.click();
                saveButton.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Assert.assertTrue(funds_notification.isVisible());
                withAction().pause(Duration.ofSeconds(8)).build().perform();
            }
            else if (fundItem.isPresent()){
                cancelButton.waitUntilVisible();
                cancelButton.click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to add funds details for Client 2" +e);
            Assert.fail();
        }
    }
    public void searchDocument_VersionId(){
        try{
            saveAsDraft_btn.waitUntilClickable().click();
            String VersionId = get_versionID.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().navigate().back();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(search_versionID).click().sendKeys(VersionId).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to get document version ID" +e);
            Assert.fail();
        }
    }
    public void viewFundDetails(){
        try{
            List<WebElementFacade> LEIList = findAll("//div[@class='fund-lei']");
            int LeiList_size= LEIList.size();
            log.info("LEI List size on screen is :" +LeiList_size);

            for(WebElementFacade LEI_Text : LEIList){

                Assert.assertTrue(LEI_Text.isVisible());
                log.info(LEI_Text.getText());

            }
            List<WebElementFacade> FundsList = findAll("//div[@class='fund-info']");
            int FundsList_size= FundsList.size();
            log.info("Funds List size on screen is :" +FundsList_size);

            for(WebElementFacade Funds_Text : FundsList){

                Assert.assertTrue(Funds_Text.isVisible());
                log.info(Funds_Text.getText());

            }
            log.info("All funds information is visible in the document preview");

        }
        catch (Exception e){
            log.error("Unable to see funds details" +e);
            Assert.fail();
        }
    }
}
