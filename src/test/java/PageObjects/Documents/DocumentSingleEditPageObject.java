package PageObjects.Documents;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import okio.SystemFileSystem;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;

@Data
@Slf4j
public class DocumentSingleEditPageObject extends PageObject {
    public static String documentVesionID;

    @FindBy(xpath = "//div[@class='info-container']")
    private WebElementFacade editScreen_infocontainer;
    @FindBy(xpath = "//div/label[text()='Acting as']")
    private WebElementFacade actingas_text_edit_pop_up;

    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_txt;
    @FindBy(xpath = "//div[contains(@class,'select-acting-as')]//input")
    private WebElementFacade actingAs_input;

    @FindBy(xpath = "//p[text()='Edit']")
    private WebElementFacade edit_text;

    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade documentedit_btn;

    @FindBy(xpath = "//div[@class='details']//label[text()='Current Version ID']")
    private WebElementFacade currenctversionID_text;
    @FindBy(xpath = "//div[@class='details']//label[text()='Type']")
    private WebElementFacade documenttype_text;

    @FindBy(xpath = "//h2/div[@class='details']/div[1]/span")
    private WebElementFacade currenctversionID_value;

    @FindBy(xpath = "//h2/div[@class='details']/div[3]/span")
    private WebElementFacade documenttype_value;

    @FindBy(xpath = "//div[@class=\"acting-content dif\"]//input")
    private WebElementFacade actiontype_input;
    @FindBy(xpath = "//div/label[text()='Action type']")
    private WebElementFacade actiontype_text_edit_pop_up;

    @FindBy(xpath = "//div/h2/p[text()='Edit']")
    private WebElementFacade edit_title_edit_popup;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_edit_popup;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_edit_popup;

    @FindBy(xpath = "//button[text()='Approval workflow']")
    private WebElementFacade tab_approvalworkflow;
    @FindBy(xpath = "//button[text()='Enforcement rule']")
    private WebElementFacade tab_enforcementrules;
    @FindBy(xpath = "//button[text()='Legal term']")
    private WebElementFacade tab_legalterms;
    @FindBy(xpath = "//button[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'limit scope']")
    private WebElementFacade tab_limiscope;
    @FindBy(xpath = "//button[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'auth scope']")
    private WebElementFacade tab_authscope;
    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade tab_previewandsubmit;
    @FindBy(xpath = "//button[@aria-label='Edit']")
    private WebElementFacade editIcon;
    //New added 1/2/24
    @FindBy(xpath ="//div[@class='currency-card']//input")
    private WebElementFacade searchSelectCurrency;
    @FindBy(xpath ="//div[@class='card ']")
    private WebElementFacade searchedCurrency;
    @FindBy(xpath = "//div[text()='No Data']")
    private WebElementFacade currency_nodata;
    @FindBy(xpath ="//div[contains(@class,'filter')]//input[contains(@placeholder,'Search currencies')]")
    private WebElementFacade searchRemoveCurrency;
    @FindBy(xpath ="//div[contains(@class,'card card-select')]")
    private WebElementFacade searchedRemoveCurrency;
    @FindBy(xpath ="//img[@alt='edit-line']")
    private WebElementFacade edit_currency_pencil_icon;
    @FindBy(xpath ="//img[@alt='delete-line']")
    private WebElementFacade delete_product_icon;
    @FindBy(xpath ="//button[text()='+ Add currencies']")
    private WebElementFacade add_currency_button;
    @FindBy(xpath ="//img[@alt ='edit-line']")
    private WebElementFacade DN_add_currency_button;
    @FindBy(xpath ="//input[@placeholder='Currencies Group']")
    private WebElementFacade currency_grp_text_box;
    @FindBy(xpath ="//input[@placeholder='Select Tenor']")
    private WebElementFacade auth_tenor_text_box;
    @FindBy(xpath ="//tbody//td[2]/button")
    private WebElementFacade DocumentVersionID;
    @FindBy(xpath ="//th[text()='Document Framework Version ID']//input")
    private WebElementFacade DocumentVersionID_SearchField;
    @FindBy(xpath ="//table[@class='doc-table']//tbody//tr//td[3]//span")
    private WebElementFacade Life_cycle_status;

    @FindBy(xpath ="//*[contains(text(),'Document approved successfully')]")
    private WebElementFacade ApprovedNotification;
    @FindBy(xpath ="//div[text()='Prime Broker - 1' and @style ='opacity: 0.5; pointer-events: none;']")
    private WebElementFacade PB_disabled;
    @FindBy(xpath ="//div[text()='Executing Broker - 1' and @style ='opacity: 0.5; pointer-events: none;']")
    private WebElementFacade EB_disabled;
    @FindBy(xpath ="(//*[text()='Client - 1'])[2]")
    private WebElementFacade Client_1;
    @FindBy(xpath ="(//div[@data-testid='edit-model-dialog'])[last()]")
    private WebElementFacade activeModalContainer;
    @FindBy(xpath ="(//button[contains(@class, 'MuiButton-root') and text()='Save'])[last()]")
    private WebElementFacade saveButton;

   public boolean waitForPageOpen() {
        return waitForCondition().withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(500)).ignoring(Exception.class).until((ExpectedCondition<Boolean>) input -> evaluateJavascript("return typeof jQuery === 'undefined' || $.active == 0;").equals(true));
    }

    public void check_edit_button_on_the_alldocument_screen() {
        try {
            for (int row = 1; row < 11; row++) {
                boolean present = findBy("//tr[\"+row+\"]//img[@alt='Edit']").isVisible();
                if (present) {
                    log.info("element found");
                } else {
                    log.info("element not found");
                    getDriver().findElement(By.xpath("//div[text()='No Record Found']"));
                    log.info("No entry for the filter specified");
                    break;
                }
            }
        } catch (Exception e) {
            log.error("Unable to verify edit button functionality", e);
            Assert.fail();
        }

    }

    public void check_edit_button() {
        try {
            Assert.assertTrue(documentedit_btn.isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Document edit button is visible");
        } catch (Exception e) {
            noRecordFound_txt.isVisible();
            log.info("No entry for the filter specified");
            getDriver().close();
        }
    }

    public void check_edit_button_not_visible() {
        try {
            if (!documentedit_btn.isVisible()) {
                log.info("Test passed");
            }
        } catch (Exception e) {
            log.error("Unable to verify the functionality");
        }
    }

    public void check_editScreen_columns() {
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertTrue(editScreen_infocontainer.isVisible());
            log.info("Edit Screen columns are visible");
        } catch (Exception e) {
            log.error("Enable to verify if columns are present " + e);
            Assert.fail();
        }
    }

    public void edit_pop_up_screen() {
        try {
            edit_title_edit_popup.waitUntilVisible();
            Assert.assertTrue(actingas_text_edit_pop_up.isVisible());
            Assert.assertTrue(actiontype_text_edit_pop_up.isVisible());
            log.info("Both acting as and action type are visible");
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("Enable to verify the components of Edit pop up screen");
            Assert.fail();
        }
    }

    public void select_Actingas(List<String> actingas) {
        try {
            actingAs_input.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            withAction().moveToElement(actingAs_input).click().pause(Duration.ofSeconds(1)).sendKeys(actingas.get(1), Keys.ARROW_DOWN, Keys.ENTER).pause(Duration.ofSeconds(1)).build().perform();
            try {
                List<WebElement> options = getDriver().findElements(By.xpath("//div[contains(@class,'-option') or contains(@class,'select__option')]"));
                if (!options.isEmpty() && options.get(0).isDisplayed()) options.get(0).click();
            } catch (Exception ignored) {}
        } catch (Exception e) {
            log.error("Unable to select Acting As" + e);
            Assert.fail();
        }
    }

    public void select_Actiontype(List<String> actiontype) {
        try {
            withAction().moveToElement(actiontype_input).click().pause(Duration.ofSeconds(2)).sendKeys(actiontype.get(1), Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER).pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Action type" + e);
            Assert.fail();
        }
    }

    public void compare_the_version_and_submit_edit_popup() {
        try {
            String old_version = find(By.xpath("//div/label[text()='Current Version ID']//following::span")).getText();
            getDriver().findElement(By.xpath("//button[text()='Submit']")).click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            waitForPageOpen();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            String new_version = find(By.xpath("//div[@class='content-label']")).getText();
            new_version = new_version.substring(new_version.length() - 3);
            if (new_version.equals(old_version)) {
                log.error("New version is not created");
                Assert.fail();
            } else {
                log.info("New Verison is created");
            }
        } catch (Exception e) {
            log.error("Unable to redrect and compare the version" + e);
            Assert.fail();
        }
    }
    public void click_on_the_submit_button_on_the_edit_pop_up_screen() {
        try {
            Assert.assertTrue(submit_edit_popup.isVisible());
            submit_edit_popup.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(10)).build().perform();
        } catch (Exception e) {
            log.error("Unable to click on Submit " + e);
            Assert.fail("Unable to click on Submit " + e);
        }
    }
    public void Validate_Add_currency_in_AuthScope(List<String> updated_currencyList) {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        for (int begin=1;begin<updated_currencyList.size();begin++){
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(updated_currencyList.get(begin));
            if (searchedCurrency.isVisible()){
                searchedCurrency.click();
            }
            else {
                Assert.assertTrue(currency_nodata.isVisible());
            }
        }
    }

    public void Validate_Remove_currency_from_AuthScope(List<String> remove_currencyList){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        for (int begin=1;begin<remove_currencyList.size();begin++){
            searchRemoveCurrency.waitUntilVisible();
            searchRemoveCurrency.clear();
            searchRemoveCurrency.type(remove_currencyList.get(begin));
            if (searchedRemoveCurrency.isVisible()){
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                searchedRemoveCurrency.click();
            } else if (currency_nodata.isVisible()) {
                continue;
            }
        }


    }

    public void Remove_product_from_auth_scope()
    {
        try {
            delete_product_icon.click();
        }
        catch (Exception e){
            log.error("Unable to click on delete "+e);
            Assert.fail();
        }
    }
    public void Add_currency_grp(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue( currency_grp_text_box.isVisible());
            withAction().moveToElement(currency_grp_text_box).click().sendKeys(dataTable.get("Currency group")).pause(Duration.ofSeconds(3)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue( submit_edit_popup.isVisible());
            submit_edit_popup.click();
        }catch (Exception e){
            log.error("Unable to add currency group-->"+e);
            Assert.fail();
        }

    }

    public void add_auth_tenor(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(auth_tenor_text_box).click().sendKeys(dataTable.get("Auth Tenor")).pause(Duration.ofSeconds(3)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(3)).build().perform();


        }
        catch (Exception e){
            log.error("Unable to add auth_value_and_tenor-->"+e);
            Assert.fail();

        }
    }
    public void click_edit_icon(){
        editIcon.waitUntilVisible().click();
    }
    public boolean fieldNotdisplayed(DataTable table)
    {
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            WebElement filterOnListingScreen = find(By.xpath("//div[contains(text(),'" + dataTable.get("Field") + "')]"));
            return !filterOnListingScreen.isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
    }
    public void documentVersionID()
    {
        documentVesionID =  DocumentVersionID.getText();
    }
    public String previousVersionExpired()
    {
        DocumentVersionID_SearchField.waitUntilVisible();
        withAction().moveToElement(DocumentVersionID_SearchField).click().build().perform();
        withAction().sendKeys(documentVesionID).build().perform();
        return Life_cycle_status.getText();
    }
    public boolean validateDocumentVersionID()
    {
        WebElement filterOnListingScreen = find(By.xpath("//div[contains(text(),'"+documentVesionID+"')]"));
        return filterOnListingScreen.isDisplayed();
    }

    public boolean ClientNotVisible() {
        try {
            Client_1.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
    public void enterAlternateId() {
        waitFor(activeModalContainer);
        String randomClientAltId = String.valueOf((int)(Math.random() * 900000) + 100000);
        String randomEbAltId     = String.valueOf((int)(Math.random() * 900000) + 100000);

        log.info("Entering dynamic Client Alt ID: " + randomClientAltId + " and EB Alt ID: " + randomEbAltId);

        // 2. Locate elements using your exact XPaths
        WebElement nativeClientField = getDriver().findElement(
                By.xpath("(//div[@data-testid='edit-model-dialog'])[last()]//input[@placeholder='Enter Client Alternate ID']")
        );

        WebElement nativeEbField = getDriver().findElement(
                By.xpath("(//div[@data-testid='edit-model-dialog'])[last()]//input[@placeholder='Enter EB Alternate ID']")
        );

        // 3. Clear existing values and type the dynamic IDs
        nativeClientField.clear();
        nativeClientField.sendKeys(randomClientAltId);

        nativeEbField.clear();
        nativeEbField.sendKeys(randomEbAltId);
    }

    public void clickSaveButton () {
        waitFor(saveButton);
        $(saveButton).click();
    }
}