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
public class DMS_1929PageObject extends PageObject {


    @FindBy(xpath = "//th[text()='Last Updated By']//input")
    private WebElementFacade LastUpdatedBY_Column_Input;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade NORecordFound_text;
    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade searched_result;
    @FindBy(xpath = "//th[text()='Action']")
    private WebElementFacade Action_text;


    public void CheckEmailforLastUpdatedBY_Column(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            if (!NORecordFound_text.isVisible()) {
                //        Next 6 line code is performing horizontal scrolling of table

                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", LastUpdatedBY_Column_Input);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                jsExecutor.executeScript("window.scrollBy(0, 500);");
                jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

                List<WebElementFacade> columnList = findAll("//tr//th");
                int column_size = columnList.size();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                log.info("column size on screen is :" + column_size);
                int columncount = 1;
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                for (WebElementFacade Column_Text : columnList) {
                    String Columntext = Column_Text.getText();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    log.info("column name is " + Columntext);
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    if (Columntext.contains(dataTable.get("Column Name"))){
                        Assert.assertTrue(Columntext.contains(dataTable.get("Column Name")));
//                    if (dataTable.get("Column Name").equalsIgnoreCase(Columntext)) {
//                        Assert.assertTrue(dataTable.get("Column Name").equalsIgnoreCase(Columntext));
                        log.info("Corresponding column name on the screen" + columncount);
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        List<WebElementFacade> RowList = findAll("//tr//td[" + columncount + "]");
                        int Rowsize = RowList.size();
                        log.info("Row count is " + Rowsize);
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        int rowcount = 1;
                        for (WebElementFacade ROW_Text : RowList) {
                            String Rowtext = ROW_Text.getText();
                            log.info("Row value is " + Rowtext);

                            Assert.assertTrue(Rowtext.matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9.]+$"));
                            log.info("Row value " + rowcount + " is" + Rowtext + "and it has correct format");

                            rowcount++;
                        }
                        break;
                    }
                    columncount++;
                }
            }else {
                log.error("Data Not found on screen so unable to validate data");
                Assert.fail();
            }
        } catch (Exception e) {
            log.error("unable to see valid Email format for Last Updated BY Column Input" + e);
            Assert.fail();
        }
    }

    public void Selectitemfor_LastUpdatedBY_filter(List<String> LastUpdatedBY) {
        try {
//        Next 6 line code is performing horizontal scrolling of table
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
//            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", LastUpdatedBY_Column_Input);
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            jsExecutor.executeScript("window.scrollBy(0, 500);");
//            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            LastUpdatedBY_Column_Input.waitUntilClickable().click();;

            for (int begin=1;begin<LastUpdatedBY.size();begin++)
            {
                LastUpdatedBY_Column_Input.type(LastUpdatedBY.get(begin));
                withAction().pause(Duration.ofSeconds(4)).build().perform();
//                Assert.assertEquals(LastUpdatedBY.get(begin),searched_result.getText());
                Assert.assertTrue(LastUpdatedBY.get(begin).equalsIgnoreCase(searched_result.getText()));
                withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                Action_text.waitUntilClickable().click();
//                if (LastUpdatedBY.get(begin).equalsIgnoreCase(searched_result.getText()))
//                {
//                    withAction().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//                }
            }
        }catch (Exception e){
            log.error("unable to Select item from Last Updated By Column " + e);
            Assert.fail();
        }
    }


    public void ColumnAndColumnValueCheck(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            if (!NORecordFound_text.isVisible()) {

                List<WebElementFacade> columnList = findAll("//tr//th");
                int column_size = columnList.size();
                log.info("column size on screen is :" + column_size);
                int columncount = 1;
                for (WebElementFacade Column_Text : columnList) {
                    String Columntext = Column_Text.getText();
                    log.info("column name" + Columntext);
                    if (Columntext.contains(dataTable.get("Column Name"))){
                        Assert.assertTrue(Columntext.contains(dataTable.get("Column Name")));
//                    if (dataTable.get("Column Name").equalsIgnoreCase(Columntext)) {
//                        Assert.assertTrue(dataTable.get("Column Name").equalsIgnoreCase(Columntext));
                        log.info("Corresponding column name on the screen" + columncount);
                        List<WebElementFacade> RowList = findAll("//tr//td[" + columncount + "]");
                        int Rowsize = RowList.size();
                        log.info("Row count is " + Rowsize);
                        int rowcount = 1;
                        for (WebElementFacade ROW_Text : RowList) {
                            String Rowtext = ROW_Text.getText();
                            log.info("Row name is " + Rowtext);

                            Assert.assertTrue(dataTable.get("value").equalsIgnoreCase(Rowtext));   //there is no other way to fail this script
//                        if (dataTable.get("value").equalsIgnoreCase(Rowtext)) {
//                            log.info("Corresponding column name on the screen" + Rowtext);
//                            Assert.assertTrue(dataTable.get("value").equalsIgnoreCase(Rowtext));
//                        }
//                        else{
//                            log.info("No record found ");
//                              Assert.assertTrue(NORecordFound_text.isVisible());
//                        }
                            rowcount++;
                        }
                        break;
                    }
                    columncount++;
                }
            }else {
                log.error("Data Not found on screen for searched input please search for data which has some data to represent");
                Assert.fail();
            }
        }catch (Exception e){
            log.error("unable to check column and column value for Last Update By Filter"+ e);
            Assert.fail();
        }

    }




}



