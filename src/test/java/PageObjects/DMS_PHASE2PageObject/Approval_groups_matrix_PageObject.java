package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import lombok.Data;

import org.junit.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class Approval_groups_matrix_PageObject extends PageObject {

    @FindBy(xpath="//button[text()='+ Create Approval Group']")
    private WebElementFacade createApprovalGroup_btn;

    @FindBy(xpath = "//p[text()='DN']")
    private WebElementFacade DN_text;

    @FindBy(xpath = "//p[text()='4 Way']")
    private WebElementFacade fourWay_text;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doc_type_box;

    @FindBy(xpath = "//div[text()='Select Leis']")
    private WebElementFacade leiName_box;

    @FindBy(xpath = "//div[@class='select-head select-label']")
    private WebElementFacade assignedLEI;

    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade noOptions_text;

    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_text;

    @FindBy(xpath = "//div[@data-testid='matrix-title'] | //*[normalize-space()='Approval matrices']")
    private WebElementFacade approvalMatrix_title;

    @FindBy(xpath="//button[text()='+ Create Approval Matrix']")
    private WebElementFacade createApprovalMatrix_btn;

    public void user_selectLEI(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            leiName_box.waitUntilClickable();
            withAction().moveToElement(leiName_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("LEI Name")).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Org type -->"+e);
            Assert.fail();
        }
    }
    public void ColumnAndColumnValueCheck(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            List<WebElementFacade> columnList = findAll("//tr//th");
            int column_size = columnList.size();
            log.info("column size on screen is :" + column_size);
            int columncount = 1;
            for (WebElementFacade Column_Text : columnList) {
                String Columntext = Column_Text.getText();
                log.info("column name is " + Columntext);
                if (Columntext.contains(dataTable.get("field"))){
                    Assert.assertTrue(Columntext.contains(dataTable.get("field")));
                    log.info("Corresponding column name on the screen " + columncount);
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
        }catch (Exception e){
            log.error("unable to check column and column value"+ e);
            Assert.fail();
        }
    }
}
