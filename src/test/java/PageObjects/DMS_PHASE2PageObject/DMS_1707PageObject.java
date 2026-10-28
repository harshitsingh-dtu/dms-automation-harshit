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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DMS_1707PageObject extends PageObject {

    @FindBy(xpath = "//button[text()='+ Create new document']")
    private WebElementFacade CreatenewDocument_button;

    @FindBy(xpath = "//button[text()='+ Add/Edit query']")
    private WebElementFacade AddEditQuery_Button;
    @FindBy(xpath = "//header[text()='Query name']")
    private WebElementFacade QueryName_Text_ON_Drawer;
    @FindBy(xpath = "//input[@placeholder='Enter query name']")
    private WebElementFacade queryName_input;
    @FindBy(xpath = "//button[text()='+ Add query block']")
    private WebElementFacade AddQueryBlock_button;
    @FindBy(xpath = "//input[@placeholder='Select field']")
    private WebElementFacade SelectField_dropdown;
    @FindBy(xpath = "//input[@placeholder='Operators']")
    private WebElementFacade Operators_dropdown;
    @FindBy(xpath = "//input[@placeholder='Select value']")
    private WebElementFacade SelectValue_dropdown;
    @FindBy(xpath = "//input[@placeholder='Enter value']")
    private WebElementFacade Entervalue;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filteredvalue;

    @FindBy(xpath = "//button[text()='Save & Apply']")
    private WebElementFacade SaveAndApply_button;

    @FindBy(xpath = "//button[text()='Apply']")
    private WebElementFacade Apply_button;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade NORecordFound_text;
    @FindBy(xpath = "//button[text()='Columns Selection']")
    private WebElementFacade ColumnsSelection_button;
    @FindBy(xpath = "//div[@class='search-add-container col-search']//input")
    private WebElementFacade columns_selection_search_box;
    @FindBy(xpath = "//label[@class='col_checkbox']")
    private WebElementFacade columns_selection_searched_result;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElementFacade result_checkbox;
    @FindBy(xpath = "//*[@data-testid='CheckBoxOutlineBlankIcon']")
    private WebElementFacade ColumnResult_checkbox;
    @FindBy(xpath = "//th[text()='EB-1 LEI ID']//input")
    private WebElementFacade EB1_LEI_ID_Column_Input;
    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade searched_result;
//    @FindBy(xpath = "//input[@type='checkbox']")
//    private WebElementFacade result_checkbox;
    @FindBy(xpath = "//th[text()='EB-1 LEI Name']//input")
    private WebElementFacade EB1_LEI_ID_Name_Column_Input;
    @FindBy(xpath = "//th[text()='Initiator']//input")
    private WebElementFacade Initiator_column_Input;
    ////////////
    @FindBy(xpath = "(//th[text()='EB-1 LEI Name']//div)[4]")
    private WebElementFacade EB1_LEI_ID_Name_Column;
//    @FindBy(xpath = "//span[@class='custom-label']")
//    private WebElementFacade EB1_LEI_ID_Name_Column_searched_result;
//    @FindBy(xpath = "//input[@type='checkbox']")
//    private WebElementFacade EB1_LEI_ID_Name_searched_result_checkbox;
    @FindBy(xpath = "//th[text()='Client-1 LEI ID']//input")
    private WebElementFacade Client1_LEI_ID_Name_Column_Input;
//    @FindBy(xpath = "//span[@class='custom-label']")
//    private WebElementFacade Client1_LEI_ID_Name_Column_searched_result;
//    @FindBy(xpath = "//input[@type='checkbox']")
//    private WebElementFacade Client1_LEI_ID_searched_result_checkbox;

    @FindBy(xpath = "//th[text()='Document Type']//input")
    private WebElementFacade Doctype_column_Input;

    @FindBy(xpath = "//th[text()='Client-1 LEI ID']")
    private WebElementFacade Client1LEIID_columnTEXT;
    @FindBy(xpath = "//tr//th")
    List<WebElementFacade> columnList;



    public void EnterQueryName(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            queryName_input.waitUntilVisible();
            if (queryName_input.isVisible()){
                withAction().moveToElement(queryName_input).click().sendKeys(dataTable.get("query name")+ RandomStringUtils.randomAlphabetic(6)).pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to input into query Name-->" + e);
            Assert.fail();
        }
    }

    public void Selectfield(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            SelectField_dropdown.waitUntilVisible();
           if (SelectField_dropdown.isVisible()){
               withAction().moveToElement(SelectField_dropdown).click().sendKeys(dataTable.get("field")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
           }
        } catch (Exception e) {
            log.error("Unable to Select Query -->" + e);
            Assert.fail();
        }
    }

    public void Selectoperator(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Operators_dropdown.waitUntilVisible();
            if (Operators_dropdown.isVisible()){
                withAction().moveToElement(Operators_dropdown).click().sendKeys(dataTable.get("operator")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to Select Operator -->" + e);
            Assert.fail();
        }
    }

    public void SelectValue(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            SelectValue_dropdown.waitUntilVisible();
            if (SelectValue_dropdown.isVisible()){
                withAction().moveToElement(SelectValue_dropdown).click().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to Select Value -->" + e);
            Assert.fail();
        }
    }
    public void EnterValue(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Entervalue.waitUntilClickable().click();
            withAction().moveToElement(Entervalue).click().sendKeys(dataTable.get("value")).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("Unable to Enter Value -->" + e);
            Assert.fail();
        }
    }


    public void ValuelistforDocumentTypeField(List<String> valuelist){

        try {
            for (int begin=1;begin<valuelist.size();begin++)
            {
                SelectValue_dropdown.waitUntilClickable().click();
                SelectValue_dropdown.type(valuelist.get(begin));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertTrue(valuelist.get(begin).equalsIgnoreCase(filteredvalue.getText()));
//                if (valuelist.get(begin).equalsIgnoreCase(filteredvalue.getText())) {
//                log.info("value " + valuelist.get(begin) + " is present inside the List of Value");
//                }
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SelectValue_dropdown.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found entered Doc Type-->" + e);
            Assert.fail();
        }
    }

    public void ColumnAndColumnValueCheck(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(10)).build().perform();
            int column_size = columnList.size();
            log.info("column size on screen is :" + column_size);
            int columncount = 1;
            for (WebElementFacade Column_Text : columnList) {
                String Columntext = Column_Text.getText();
                log.info("column name is " + Columntext);
                if (Columntext.contains(dataTable.get("field"))){
                    Assert.assertTrue(Columntext.contains(dataTable.get("field")));
                    log.info("Corresponding column name on the screen" + columncount);
                    List<WebElementFacade> RowList = findAll("//tr//td[" + columncount + "]");
                    int Rowsize = RowList.size();
                    log.info("Row count is " + Rowsize);
                    int rowcount = 1;
                    for (WebElementFacade ROW_Text : RowList) {
                        String Rowtext = ROW_Text.getText();
                        log.info("Row value " +Rowtext);
                        switch (Rowtext){
                            case "No Record Found":
                                log.info("No record found. There is no result for the selected filter.");
                                Assert.assertTrue(NORecordFound_text.isVisible());
                                break;
                            default:
                                Assert.assertTrue(dataTable.get("value").equalsIgnoreCase(Rowtext));
                                log.info("Row contains value as expected");
                                log.info("Row value is " + Rowtext);
                                break;
                        }
                        rowcount++;
                    }
                    break;
                }
                columncount++;
            }
        }catch (Exception e){
            log.error("unable to check column and column value"+ e);
            Assert.fail();
        }

    }

    public void SelectitemfromColumnSelection(List<String> filters) {
        try {
            for (int begin = 1; begin < filters.size(); begin++) {
                columns_selection_search_box.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertTrue(filters.get(begin).equalsIgnoreCase(columns_selection_searched_result.getText()));
                System.out.println(filters.get(begin) + "----->" + columns_selection_searched_result.getText());
                if (!result_checkbox.isSelected()) {
                    result_checkbox.click();
                }
                columns_selection_search_box.clear();
            }
        }catch (Exception e){
            log.error("unable to Select item from Column Selection"+ e);
            Assert.fail();
    }
    }

    public void CheckFilterOnListingScreen(List<String> filter) {
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin = 1; begin < filter.size(); begin++) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                WebElementFacade filterOnListingScreen = find(By.xpath("//th[text()='" + filter.get(begin) + "']"));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(filterOnListingScreen.isDisplayed());
            }
        } catch (Exception e) {
            log.error("unable to found Selected column all document screen"+ e);
            Assert.fail();

        }
    }

    public void SelectitemforEB1_LEI_ID_Column(List<String> LEI_ID) {
        try {
//        Next 6 line code is performing horizontal scrolling of table
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EB1_LEI_ID_Column_Input);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        jsExecutor.executeScript("window.scrollBy(0, 500);");
        jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

        withAction().pause(Duration.ofSeconds(2)).build().perform();
        EB1_LEI_ID_Column_Input.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (int begin=1;begin<LEI_ID.size();begin++)
        {
            EB1_LEI_ID_Column_Input.type(LEI_ID.get(begin));
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            Assert.assertEquals(LEI_ID.get(begin),searched_result.getText());
            if (LEI_ID.get(begin).equals(searched_result.getText()))
            {
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            }
        }
       }catch (Exception e){
            log.error("unable to Select item from EB1 LEI ID Column " + e);
            Assert.fail();
        }
    }

    public void SelectitemforEB1_LEI_ID_Name_Column(List<String> LEI_ID_NAME) {
        try {
//        Next 6 line code is performing horizontal scrolling of table
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EB1_LEI_ID_Name_Column);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            jsExecutor.executeScript("window.scrollBy(0, 500);");
            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            EB1_LEI_ID_Name_Column.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin=1;begin<LEI_ID_NAME.size();begin++)
            {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                EB1_LEI_ID_Name_Column_Input.type(LEI_ID_NAME.get(begin));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertTrue(LEI_ID_NAME.get(begin).equalsIgnoreCase(searched_result.getText()));
                if (LEI_ID_NAME.get(begin).equalsIgnoreCase(searched_result.getText()))
                {
                    withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                }
            }
        }catch (Exception e){
            log.error("unable to Select item from EB1 LEI Name Column " + e);
            Assert.fail();
        }
    }

    public void EnterDoctype(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Doctype_column_Input.waitUntilClickable().click();
            withAction().moveToElement(Doctype_column_Input).click().sendKeys(dataTable.get("Doc type")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to Enter Doc type -->" + e);
            Assert.fail();
        }
    }


    public void Selectitemfor_Client1_LEI_ID_filter(List<String> Client1_LEI_ID) {
        try {
//        Next 6 line code is performing horizontal scrolling of table
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Client1_LEI_ID_Name_Column_Input);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            jsExecutor.executeScript("window.scrollBy(0, 500);");
            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Client1_LEI_ID_Name_Column_Input.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin=1;begin<Client1_LEI_ID.size();begin++)
            {
                Client1_LEI_ID_Name_Column_Input.type(Client1_LEI_ID.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertEquals(Client1_LEI_ID.get(begin),searched_result.getText());
                if (Client1_LEI_ID.get(begin).equals(searched_result.getText()))
                {
                    withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                }
            }
        }catch (Exception e){
            log.error("unable to Select item from Client 1 LEI ID Column " + e);
            Assert.fail();
        }
    }



    public void Selectitemfor_Initiator_Column(List<String> initiator) {
        try {
//        Next 6 line code is performing horizontal scrolling of table
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Initiator_column_Input);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            jsExecutor.executeScript("window.scrollBy(0, 500);");
            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Initiator_column_Input.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin=1;begin<initiator.size();begin++)
            {
                Initiator_column_Input.type(initiator.get(begin));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertTrue(initiator.get(begin).equalsIgnoreCase(searched_result.getText()));
                if (initiator.get(begin).equalsIgnoreCase(searched_result.getText()))
                {
                    withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                }
            }
        }catch (Exception e){
            log.error("unable to Select item from Initiator Column " + e);
            Assert.fail();
        }
    }


}
