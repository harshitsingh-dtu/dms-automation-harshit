package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data
public class DMS_1525_PageObject extends PageObject
{

    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentType' or text()='Document type']//input")
    private WebElementFacade Document_Type_Input;
    @FindBy(xpath = "(//img[@alt='menu-drag-icon'])[1]")
    private WebElementFacade navigation_btn;
    @FindBy(xpath = "//div[normalize-space()='Document']")
    private WebElementFacade document_tab;
    @FindBy(xpath = "//*[text()='All documents']")
    private WebElementFacade allDocument_tab;
    @FindBy(xpath = "//ul[contains(@class,'MuiAutocomplete-listbox')]/li")
    private List<WebElementFacade> listOfDocType;
    @FindBy(xpath = "//p[contains(@class,'MuiTypography-root MuiTypography-body1')]")
    private WebElementFacade SearchedDocType;
    @FindBy(xpath = "//td[text()='DN']")
    private WebElementFacade DN_DocTypeFromDocList;
    @FindBy(xpath = "//td[text()='4 Way']")
    private WebElementFacade four_Way_DocTypeFromDocList;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentId' or text()='Document ID']//input")
    private WebElementFacade search_documentID;
    @FindBy(xpath = "(//tbody//td)[1]")
    private WebElementFacade resultant_documentID;

    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentVersionId' or text()='Document version ID']//input")
    private WebElementFacade search_versionID;
    @FindBy(xpath = "(//tbody//div)[1]")
    private WebElementFacade resultant_document_versionID;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentStatus' or text()='Document status']//input")
    private WebElementFacade filter_document_status;
    @FindBy(xpath = "//span[@class='batch-status enforced']")
    private WebElementFacade resultant_document_status;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade no_record_found_msg;
    @FindBy(xpath = "//button[text()='Columns Selection']")
    private WebElementFacade columns_selection_button;
    @FindBy(xpath = "//div[@class='search-add-container col-search']//input")
    private WebElementFacade columns_selection_search_box;
    @FindBy(xpath = " //input[@type='checkbox']")
    private WebElementFacade columns_selection_searched_filter_checkbox;
    @FindBy(xpath = " //label[@class='col_checkbox']")
    private WebElementFacade columns_selection_searched_result;
    @FindBy(xpath = " //button[text()='Apply']")
    private WebElementFacade Apply_button;
    @FindBy(xpath = "//tr/th[text()='EB-1 LEI ID']//input")
    private WebElementFacade search_EB_1_LEI_ID;
    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade searched_Result;
    @FindBy(xpath = "//th[text()='EB-1 LEI ID']")
    private WebElementFacade EB_1_LEI_ID_filter_on_listing_screen;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-eb1Name' or text()='EB-1 LEI name']//input")
    private WebElementFacade search_EB_1_LEI_Name;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-eb1Name' or text()='EB-1 LEI name']//button")
    private WebElementFacade search;
    @FindBy(xpath = "//button[text()='+ Add/Edit query']")
    private WebElementFacade Add_or_Edit_query_btn;
    @FindBy(xpath = "//button[text()='+ Add query block']")
    private WebElementFacade Add_query_block_btn;
    @FindBy(xpath = "//input[@placeholder='Select field']")
    private WebElementFacade Select_input_field;
    @FindBy(xpath = "//p[contains(@class,'MuiTypography-root MuiTypography-body1')]")
    private WebElementFacade searched_select_field_result;
    @FindBy(xpath = "//input[@placeholder='Enter query name']")
    private WebElementFacade Enter_query_name_field;
    @FindBy(xpath = "//input[@placeholder='Operators']")
    private WebElementFacade Enter_Operators_field;
    @FindBy(xpath = "//p[contains(@class,'MuiTypography-root MuiTypography-body1')]")
    private WebElementFacade searched_Operators_field_result;
    @FindBy(xpath = "//input[@placeholder='Select value']")
    private WebElementFacade Select_value_field;
    @FindBy(xpath = "//p[contains(@class='MuiTypography-root MuiTypography-body1')]")
    private WebElementFacade Searched_Select_value;
    @FindBy(xpath = "//button[text()='Save & Apply']")
    private WebElementFacade save_and_apply_btn;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentAction' or text()='Document action']//input")
    private WebElementFacade search_document_action;
    Random random = new Random();

    public void ColumnAndColumnValueCheck(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {

            List<WebElementFacade> columnList = findAll("//tr//th");
            int column_size = columnList.size();
            log.info("column size on screen is :" + column_size);
            int columncount = 1;
            for (WebElementFacade Column_Text : columnList) {
                String Columntext = Column_Text.getText();
                log.info("column name is " + Columntext);
                if (dataTable.get("field").equalsIgnoreCase(Columntext)) {
                    Assert.assertTrue(dataTable.get("field").equalsIgnoreCase(Columntext));
                    log.info("Corresponding column name on the screen" + columncount);
                    List<WebElementFacade> RowList = findAll("//tr//td[" + columncount + "]");
                    int Rowsize = RowList.size();
                    log.info("Row count is " + Rowsize);
                    int rowcount = 1;
                    for (WebElementFacade ROW_Text : RowList) {
                        String Rowtext = ROW_Text.getText();
                        log.info("column name is " + Rowtext);

                        Assert.assertTrue(dataTable.get("value").equalsIgnoreCase(Rowtext));   //there is no other way to fail this script
                        rowcount++;
                    }
                    break;
                }
                columncount++;
            }
        } catch (Exception e) {
            log.error("unable to check column and column value" + e);
            Assert.fail();
        }

    }

    public void verifyDocTypesList(List<String> filters)
    {
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Document_Type_Input.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin = 1; begin < filters.size(); begin++) {
                withAction().moveToElement(Document_Type_Input).click().sendKeys(filters.get(begin)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(filters.get(begin),SearchedDocType.getText());
//                return SearchedDocType.getText();
            }
            Document_Type_Input.clear();

        } catch (Exception e)
        {
            log.error("Expected doc type is not present");
            Assert.fail();
        }
//        return null;
    }


    public void clickMenuButton() {
        navigation_btn.waitUntilVisible();
        navigation_btn.waitUntilClickable();
        navigation_btn.click();
    }

    public void clickDocumentTab() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        document_tab.waitUntilVisible().click();
        allDocument_tab.waitUntilClickable().click();
    }

    public void select_doc_type(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Document_Type_Input.waitUntilVisible();
        Document_Type_Input.clear();
        withAction().moveToElement(Document_Type_Input).click().sendKeys(dataTable.get("filters")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void SearchDocByID(List<String> document_ID) {

        withAction().moveToElement(search_documentID).click().sendKeys(document_ID.get(1)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();

    }
    public void pick_and_search_random_doc_id()
    {

        int randNumber = Math.abs(random.nextInt(10));
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        WebElement random_doc_id = getDriver().findElement(By.xpath("(//tr//td[1])["+randNumber+"]"));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        String doc_id = random_doc_id.getText();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        withAction().moveToElement(search_documentID).click().sendKeys(random_doc_id.getText()).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
        log.info(doc_id+"------------"+randNumber);
        withAction().pause(Duration.ofSeconds(5)).build().perform();

        Assert.assertEquals(doc_id,resultant_documentID.getText());

    }

    public void ClearDocVersionID_TextBox() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_versionID.clear();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

    }

    public void ClearDocID_TextBox() {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_documentID.clear();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

    }

    public void SearchDocByVersionID(DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        withAction().moveToElement(search_versionID).click().sendKeys(dataTable.get("Document Version ID")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
    }

    public void checkResultOfScearchedDocVersionID(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(dataTable.get("Document Version ID"), resultant_document_versionID.getText());
    }

    public void select_doc_status(List<String> Document_Status) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        search_versionID.clear();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_documentID.clear();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        withAction().moveToElement(filter_document_status).click().sendKeys(Document_Status.get(1)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void checkResultOfScearchedDocStatus(List<String> Document_Status) {

        if (Document_Status.get(1).equalsIgnoreCase(resultant_document_status.getText()))
        {
            log.info("Got Enforced document on listing screen");
        }
        else
        {
            log.info("Enforced document not found on listing screen");
            Assert.fail();
        }
    }


    public void Click_On_columns_selection_button() {
        Assert.assertTrue(columns_selection_button.isVisible());
        columns_selection_button.click();
    }

    public void verify_filters_List_From_columns_selection(List<String> filters) {
        try {
            for (int begin = 1; begin < filters.size(); begin++) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(columns_selection_search_box).click().sendKeys(filters.get(begin)).build().perform();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertEquals(filters.get(begin), columns_selection_searched_result.getText());
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                columns_selection_search_box.clear();
            }
        } catch (Exception e) {
            log.error("Expected doc type is not present");
            Assert.fail();
        }
    }

    public void select_filters_List_From_columns_selection(List<String> filters) {
        for (int begin = 1; begin < filters.size(); begin++) {
            withAction().moveToElement(columns_selection_search_box).click().sendKeys(filters.get(begin)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals(filters.get(begin), columns_selection_searched_result.getText());
            System.out.println(filters.get(begin) + "----->" + columns_selection_searched_result.getText());
            if (!columns_selection_searched_filter_checkbox.isSelected()) {
                columns_selection_searched_filter_checkbox.click();
            }
            columns_selection_search_box.clear();
        }
    }

    public void verify_filter_is_visible_on_listing_screen(List<String> filter) {
        for (int begin = 1; begin < filter.size(); begin++) {
            WebElement filterOnListingScreen = getDriver().findElement(By.xpath("//th[text()='" + filter.get(begin) + "']"));
            Assert.assertTrue(filterOnListingScreen.isDisplayed());
        }
    }

    public void search_LEI_ID_verify_corresponding_results(List<String> LEI_ID) {

        Utility.Horizontal_scroll(search_EB_1_LEI_ID, getDriver());

        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_EB_1_LEI_ID.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin = 1; begin < LEI_ID.size(); begin++) {
            withAction().moveToElement(search_EB_1_LEI_ID).click().sendKeys(LEI_ID.get(begin)).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertEquals(LEI_ID.get(begin), searched_Result.getText());
            if (LEI_ID.get(begin).equals(searched_Result.getText())) {
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            }
            WebElement result_EB_1_LEI_ID = getDriver().findElement(By.xpath("//td[text()='" + LEI_ID.get(begin) + "']"));
            Assert.assertEquals(LEI_ID.get(begin), result_EB_1_LEI_ID.getText());
        }
    }
    public void search_document_action_on_listing_screen(List<String> doc_action) {

        Utility.Horizontal_scroll(search_document_action, getDriver());

        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_document_action.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin = 1; begin < doc_action.size(); begin++) {
            withAction().moveToElement(search_document_action).click().sendKeys(doc_action.get(begin)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals(doc_action.get(begin), searched_Result.getText());
            if (doc_action.get(begin).equals(searched_Result.getText())) {
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            }
        }
    }

    public void search_LEI_ID_on_listing_screen(List<String> LEI_ID) {

        Utility.Horizontal_scroll(search_EB_1_LEI_ID, getDriver());

        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_EB_1_LEI_ID.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin = 1; begin < LEI_ID.size(); begin++) {
            withAction().moveToElement(search_EB_1_LEI_ID).click().sendKeys(LEI_ID.get(begin)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals(LEI_ID.get(begin), searched_Result.getText());
            if (LEI_ID.get(begin).equals(searched_Result.getText())) {
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            }
        }
    }

    public void search_LEI_Name_verify_corresponding_results(List<String> LEI_Name) {

        Utility.Horizontal_scroll(search_EB_1_LEI_Name, getDriver());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        search_EB_1_LEI_Name.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin = 1; begin < LEI_Name.size(); begin++) {
            withAction().moveToElement(search_EB_1_LEI_Name).click().sendKeys(LEI_Name.get(begin)).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertEquals(LEI_Name.get(begin), searched_Result.getText());
            if (LEI_Name.get(begin).equals(searched_Result.getText())) {
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            }
            WebElement result_EB_1_LEI_ID = getDriver().findElement(By.xpath("//td[text()='" + LEI_Name.get(begin) + "']"));
            Assert.assertEquals(LEI_Name.get(begin), result_EB_1_LEI_ID.getText());
        }
    }

    public void search_LEI_Name_on_listing_screen(List<String> LEI_Name) {

        Utility.Horizontal_scroll(search_EB_1_LEI_Name, getDriver());

        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_EB_1_LEI_Name.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin = 1; begin < LEI_Name.size(); begin++) {
            withAction().moveToElement(search_EB_1_LEI_Name).click().sendKeys(LEI_Name.get(begin)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals(LEI_Name.get(begin), searched_Result.getText());
            if (LEI_Name.get(begin).equals(searched_Result.getText())) {
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            }
        }
    }

    public void refresh_web_page() {
        getDriver().navigate().refresh();
        withAction().pause(Duration.ofSeconds(3)).build().perform();

    }

    public void clickOnAddEditQueryButton() {
        Add_or_Edit_query_btn.click();
    }

    public void click_On_Add_query_block_btn() {
        Add_query_block_btn.click();
    }


    public void Enter_query_name(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
//        Random string added for dynamic name
        String s = RandomStringUtils.randomAlphabetic(3);
        withAction().moveToElement(Enter_query_name_field).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("Query name") + "--" + s).build().perform();

    }

    public void clickOnSelectFieldAndSelectFilterFromDropdown(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(Select_input_field).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter")).build().perform();
        Assert.assertEquals(dataTable.get("filter"), searched_select_field_result.getText());
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    }

    public void selectOperator(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(Enter_Operators_field).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("Operator")).build().perform();
        Assert.assertEquals(dataTable.get("Operator"), searched_Operators_field_result.getText());
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    public void verifyValuesOnQueryBlock(List<String> value)
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Select_value_field.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        try {
            for (int begin = 1; begin < value.size(); begin++) {
                withAction().moveToElement(Select_value_field).click().sendKeys(value.get(begin)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(value.get(begin), Searched_Select_value.getText());
                Select_value_field.clear();
            }
        } catch (Exception e) {
            log.error("Expected value is not present");
            Assert.fail();
        }
    }

    public void selectValueOnQueryBlock(DataTable table)
    {
        HashMap<String, String> dataTable = Maps.newHashMap(Maps.newHashMap(table.asMaps(String.class, String.class).get(0)));

        withAction().moveToElement(Select_value_field).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("value")).build().perform();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertEquals(dataTable.get("value"), Searched_Select_value.getText());
        withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    }

    public void clickOnSaveApply()
    {
        save_and_apply_btn.click();
    }

}
