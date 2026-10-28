package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data
public class DMS_2203PageObject extends PageObject {

    @FindBy(xpath = "//div[@class='search-add-container col-search']//input")
    private WebElementFacade columns_selection_search_box;
    @FindBy(xpath = "//label[@class='col_checkbox']")
    private WebElementFacade columns_selection_searched_result;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElementFacade result_checkbox;
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElementFacade Apply_button;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-uspStatus']//input")
    private WebElementFacade USPRider_Column_Input;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filteredUSPRider;
    @FindBy(xpath = "//tr//th")
    List<WebElementFacade> columnList;
    @FindBy(xpath = "//div[@class='link']")
    private WebElementFacade First_DocumentVersion;
    @FindBy(xpath = "//label[text()='Document Preview']")
    private WebElementFacade DocumentPreview_text;
    @FindBy(xpath = "//div[@class='usp-update-alert']")
    private WebElementFacade Prominent_Message_ON_DocumentPreviewScreen;
    @FindBy(xpath = "//button[text()='View']")
    private WebElementFacade ViewButton_on_DocumentPreviewScreen;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade CloseButton_on_DocumentPreviewScreen;

    @FindBy(xpath = "//p[text()='Version Compare']")
    private WebElementFacade VersionCompare_Screen_text;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root css-1ty026z']//button")
    private WebElementFacade USPRiderID_on_VersionCompareScreen;
    @FindBy(xpath = "//div[@class='compare-version'][1]")
    private WebElementFacade CurrentVersion_window_on_VersionCompareScreen;
    @FindBy(xpath = "//div[@class='compare-version'][2]")
    private WebElementFacade NewVersion_window_on_VersionCompareScreen;
    @FindBy(xpath = "//div[@class='button-content']//button[text()='Close']")
    private WebElementFacade CLose_button_on_VersioncompareScreen;
    @FindBy(xpath = "//div[@class='button-content']//button[text()='Apply Update']")
    private WebElementFacade ApplyUpdate_button_on_VersioncompareScreen;

    @FindBy(xpath = "//div[@class='confirmation-heading']")
    private WebElementFacade Confirmation_text_on_UpdatedUSPRider_POPUP;
    @FindBy(xpath = "//div[@class='confirmation-msg']")
    private WebElementFacade UpdateAvailableForUSPtext_on_UpdatedUSPRider_POPUP;
    @FindBy(xpath = "//div[@class='message']")
    private WebElementFacade ForAskToViewAvailableUpdate_text_on_UpdatedUSPRider_POPUP;
    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade NOButton_on_UpdateAvailableForUSP_POPUP;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade YesButton_on_UpdateAvailableForUSP_POPUP;
    @FindBy(xpath = "//label[text()='Action type']/following::input")
    private WebElementFacade Actingtype_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//div[@class='usp-rider-check']//*[text()='New Update Available']")
    private WebElementFacade NewUpdateAvailable_linktext;
    @FindBy(xpath = "//input[@value='Select Date']")
    private WebElementFacade DateFilter;

    @FindBy(xpath = "//th[text()='Document Status']//input")
    private WebElementFacade DocumentStatus_Column_Input;



    public void ChecktheVisibilityofColumnInsidetheColumnSelection(List<String> filters){
        try {

            for (int begin = 1; begin < filters.size(); begin++) {
                columns_selection_search_box.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(filters.get(begin).equalsIgnoreCase(columns_selection_searched_result.getText()));
            }
        }catch (Exception e){
            log.error("Unable to see column inside the column Selection filter"+ e);
            Assert.fail();
        }
    }

    public void SelectandDeselectcheckbox(List<String> filters){
        try {
            for (int begin = 1; begin < filters.size(); begin++) {
                columns_selection_search_box.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(filters.get(begin).equalsIgnoreCase(columns_selection_searched_result.getText()));
                if (result_checkbox.isSelected()) {
                    result_checkbox.click();
                    log.info("CheckBox is Deselected");
                    result_checkbox.click();
                    log.info("CheckBox is Selected");

                } else if (!result_checkbox.isSelected()) {
                    result_checkbox.click();
                    log.info("CheckBox is Deselected");
                    result_checkbox.click();
                    log.info("CheckBox is Selected");
                }
                columns_selection_search_box.clear();
            }
        }catch (Exception e){
            log.error("Unable to see column inside the column Selection filter"+ e);
            Assert.fail();
        }
    }

    public void ApplyforSearchedColumn(List<String> filters){
        try {
            for (int begin = 1; begin < filters.size(); begin++) {
                columns_selection_search_box.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(filters.get(begin).equalsIgnoreCase(columns_selection_searched_result.getText()));
                if (!result_checkbox.isSelected()) {
                    result_checkbox.click();
                }
                columns_selection_search_box.clear();
            }
            Apply_button.click();
        }catch (Exception e){
            log.error("Unable to see column inside the column Selection filter"+ e);
            Assert.fail();
        }
    }

    public void CheckfilteredUSPRider(List<String> USPRiderlist){
        try {
            for (int begin=1;begin<USPRiderlist.size();begin++)
            {
//        Next 6 line code is performing horizontal scrolling of table
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", USPRider_Column_Input);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                jsExecutor.executeScript("window.scrollBy(0, 500);");
                jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

                withAction().pause(Duration.ofSeconds(2)).build().perform();

                USPRider_Column_Input.waitUntilClickable().click();
                USPRider_Column_Input.type(USPRiderlist.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(USPRiderlist.get(begin),filteredUSPRider.getText());
                USPRider_Column_Input.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found entered Doc Type-->" + e);
            Assert.fail();
        }
    }

    public void SelectinputforUSPRiderFilter(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
//          Next 6 line code is performing horizontal scrolling of table
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", USPRider_Column_Input);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            jsExecutor.executeScript("window.scrollBy(0, 500);");
            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            USPRider_Column_Input.waitUntilVisible().isVisible();
            USPRider_Column_Input.clear();
            withAction().moveToElement(USPRider_Column_Input).click().sendKeys(dataTable.get("USP Rider")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to Select Query -->" + e);
            Assert.fail();
        }
    }

    public void RandomSelectDocumentStatus(){
        try {
            Random random = new Random();
            int randNumber;
            randNumber = random.nextInt(8) + 3;
            int begin=1;
            DocumentStatus_Column_Input.waitUntilVisible().isVisible();
            DocumentStatus_Column_Input.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("random number is " + randNumber);
            for (begin=1;begin<=randNumber;begin++){
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                WebElement DocStatus = find(By.xpath("(//span[@class='custom-label'])["+begin+"]"));
                log.info("DocStatus is " + DocStatus.getText());
                String DocumentStatus = DocStatus.getText();
                if (!DocumentStatus.equals("Draft") && !DocumentStatus.equals("Enforced")){
                    withAction().sendKeys(Keys.ENTER).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    break;
                }
            }
        } catch (Exception e) {
            log.error("Unable to Select Document Status other then Draft and Enforce -->" + e);
            Assert.fail();
        }
    }

    public void RandomSelectActiontype(){
        try {
            Random random = new Random();
            int randNumber;
            randNumber = random.nextInt(8) + 1;
            int begin=1;
            Actingtype_Input_ONEDIT_POPUP.waitUntilVisible().isVisible();
            Actingtype_Input_ONEDIT_POPUP.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("random number is " + randNumber);
            for (begin=1;begin<=randNumber;begin++){
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                WebElement Actiontype = find(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3'])["+begin+"]"));
                log.info("Action type is " + Actiontype.getText());
                String DocumentStatus = Actiontype.getText();
                if (!DocumentStatus.equals("Edit Documents")){
                    withAction().sendKeys(Keys.ENTER).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    break;
                }
            }
        } catch (Exception e) {
            log.error("Unable to Select Action type other then Edit Document -->" + e);
            Assert.fail();
        }
    }






}
