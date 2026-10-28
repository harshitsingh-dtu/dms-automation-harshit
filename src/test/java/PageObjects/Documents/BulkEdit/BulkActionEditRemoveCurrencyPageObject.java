package PageObjects.Documents.BulkEdit;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Data

public class BulkActionEditRemoveCurrencyPageObject extends PageObject {
    @FindBy(xpath = "//div[@class='header-name']")
    private WebElementFacade doc_page;
    @FindBy(xpath = "//li[text()='Edit']")
    private WebElementFacade edit_btn;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade Doctype_Action;
    @FindBy(xpath = "//input[@class='lp-copy-sel__input']")
    private WebElementFacade actingAs_Action;
    @FindBy(xpath = "//div[@class='lp-copy-sel__indicators css-1wy0on6']//div[1]")
    private WebElementFacade clearActingAsFilter;
    @FindBy(xpath = "//div[@class='acting-content dif']/div/div/div/input")
    private WebElementFacade Action_type;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;
    @FindBy(xpath = "//th[contains(., 'Document ID') or @data-testid='doc-table-th-documentId']")
    private WebElementFacade document_id;
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
    private WebElementFacade search_document_id;
    @FindBy(xpath = "//table/tbody//td[2]")
    private WebElementFacade searched_document_id;

    @FindBy(xpath = "//th[contains(., 'Document version ID') or @data-testid='doc-table-th-documentVersionId']")
    private WebElementFacade document_Version_id;
    @FindBy(xpath = "(//input[@placeholder='Search'])[2]")
    private WebElementFacade search_document_version_id;
    @FindBy(xpath = "//th[contains(., 'Document status') or @data-testid='doc-table-th-documentStatus']")
    private WebElementFacade document_status;
    @FindBy(xpath = "//div[@class='link']")
    private WebElementFacade searched_document_version_id;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElementFacade check_box_for_doc;
    @FindBy(xpath = "//button[text()=\"Auth scope\"]")
    private WebElementFacade AuthScope_tab;
    @FindBy(xpath = "//button[@class='add-cur-btn']")
    private WebElementFacade add_currency_btn;
    @FindBy(xpath = "//div[normalize-space(text())='Select Currencies']/following::input[@placeholder='Search'][1]")
    private WebElementFacade searchSelectCurrency;//div[@class='currency-card']//input
    @FindBy(xpath ="//button[@class='card  ']")//button[@class='card  ']
    private WebElementFacade searchedCurrency;//div[@class='card ']
    @FindBy(xpath = "//div[text()='No Data']")
    private WebElementFacade currency_nodata;
    @FindBy(xpath = "//div[normalize-space(text())='Selected Currencies']/following::input[@placeholder='Search'][1]")
    private WebElementFacade searchRemoveCurrency;
    @FindBy(xpath ="//div[contains(@class,'card card-select')]")
    private WebElementFacade searchedRemoveCurrency;

    @FindBy(xpath =" //button[text()='Submit for approval']")
    private WebElementFacade submit_for_approval_btn;
    @FindBy(xpath ="//*[text()='Action type']/..//button[@title='Clear']")
    private WebElementFacade CrossButton;

    @FindBy(xpath ="//button[text()='Cancel']")
    private WebElementFacade cancel_btn;

    @FindBy(xpath ="//button[text()='Back']")
    private WebElementFacade back_btn;

    @FindBy(xpath ="//button[text()='No']")
    private WebElementFacade Confirmation_popup_no_btn;
    @FindBy(xpath ="//button[text()='Yes']")
    private WebElementFacade Confirmation_popup_yes_btn;
    @FindBy(xpath ="//tbody//tr//td[3]//input")
    private WebElementFacade LimitValue;
    //input[@placeholder='$ Limit value']
    @FindBy(xpath ="//input[@placeholder='$ Limit value']")
    private WebElementFacade EnterLimitValue;
    @FindBy(xpath ="//tbody/tr/td[6]/div")
    private WebElementFacade EditLimitProductFamily;
    @FindBy(xpath = "//div[@role='presentation']//*[text()='Select All']")
    private WebElementFacade selectAllProductFamilyCheckbox;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade closeDropDown;
    @FindBy(xpath = "//td[@class='checkbox']//input[@type='checkbox']")
    private WebElementFacade firstDocCheckbox;


    public void clickOnBulkActionEditButton(){
        edit_btn.click();
    }

    public void selectDocTypeAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            Doctype_Action.waitUntilVisible();
            withAction().moveToElement(Doctype_Action).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Doc Type " + e);
        }
    }
    public void selectActingAsAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> dataTable : data){
            try{
                actingAs_Action.waitUntilVisible();
                withAction().moveToElement(actingAs_Action).click().sendKeys(dataTable.get("Acting as")).pause(Duration.ofSeconds(2)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.info("Unable to select Acting As LEIs" + e);
            }
        }
    }

    public void TypeIntoActionType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> dataTable : data){
            try{
                Action_type.waitUntilVisible();
                withAction().moveToElement(Action_type).click().sendKeys(dataTable.get("Action type")).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                CrossButton.waitUntilVisible().click();
            }catch (Exception e){
                log.info("Unable to select Acting As LEIs" + e);
            }
        }
    }

    public void selectActionType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            Action_type.waitUntilVisible();
            withAction().moveToElement(Action_type).click().sendKeys(dataTable.get("Action type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Approval Group Action" + e);
        }
    }
    public void click_Nextbtn(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        next_btn.waitUntilClickable().click();
    }

    public void varify_search_functionality_for_doc_id(DataTable table)
    { List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            search_document_id.waitUntilVisible();
            search_document_id.type(dataTable.get("Document ID"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(searched_document_id.isVisible());
            Assert.assertEquals(searched_document_id.getText(),dataTable.get("Document ID"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            search_document_id.clear();
        }
        catch (Exception e){
            log.info("Search functionality is not working for Document ID" + e);
            Assert.fail();
        }

    }

    public void varify_search_functionality_for_doc_version_id(DataTable table)
    { List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            search_document_version_id.waitUntilVisible();
            search_document_version_id.sendKeys(dataTable.get("DocumentVersionID"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            search_document_id.clear();
//            search_document_version_id.type(dataTable.get("DocumentVersionID"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(searched_document_version_id.isVisible());
            Assert.assertEquals(searched_document_version_id.getText(),dataTable.get("DocumentVersionID"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            search_document_version_id.clear();
        }
        catch (Exception e){
            log.info("Search functionality is not working for Document version ID" + e);
            Assert.fail();
        }
    }
    public void Select_doc_to_remove_currency(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            search_document_id.waitUntilVisible();
            search_document_id.type(dataTable.get("Document ID"));
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            check_box_for_doc.waitUntilVisible();
            Assert.assertFalse( check_box_for_doc.isSelected());
            check_box_for_doc.click();
            Assert.assertTrue( check_box_for_doc.isSelected());

        }
        catch (Exception e){
            log.info("unable to select Document by ID" + e);
            Assert.fail();
        }
    }
    public void Validate_Add_currency(List<String> updated_currencyList) {

        for (int begin=1;begin<updated_currencyList.size();begin++){
            searchSelectCurrency.waitUntilPresent();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(updated_currencyList.get(begin));
            if (searchedCurrency.isPresent()){
                searchedCurrency.click();
            }
            else {
                Assert.assertTrue(currency_nodata.isVisible());
            }
        }
    }

    public void Validate_Remove_currencye(List<String> remove_currencyList){

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

    public void Click_submit_for_approval_button(){
        submit_for_approval_btn.waitUntilVisible().click();

    }

    public void Click_cancel_button() {

        cancel_btn.click();
    }

    public void Click_back_button() {
        back_btn.click();
    }

    public void Click_Popup_no_button() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Confirmation_popup_no_btn.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void Click_Popup_yes_button() {
        Confirmation_popup_yes_btn.click();
    }
    public void limitValueOnEditLimitScreen(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> dataTable : data)
            {
                withAction().moveToElement(EnterLimitValue).click().sendKeys(dataTable.get("Limit Value")).pause(Duration.ofSeconds(2)).build().perform();
            }

    }
    public void limitProductFamily(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> dataTable : data)
        {
            withAction().moveToElement(EditLimitProductFamily).click();
            EditLimitProductFamily.clear();
            selectAllProductFamilyCheckbox.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            closeDropDown.click();

        }

    }

    public void clickFirstDocCheckbox() {
        firstDocCheckbox.waitUntilClickable().click();
    }
    public void VerifySequence(DataTable table)
    {
        int i = 2;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            WebElement element = getDriver().findElement(By.xpath("//tr//th//span[text()='"+dataTable_map.get("Sequence")+"']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            Assert.assertTrue(getDriver().findElement(By.xpath("(//tr//th["+i+"]//span)[1]")).getText().equalsIgnoreCase(dataTable_map.get("Sequence")));
            i++;
        }
    }
}

