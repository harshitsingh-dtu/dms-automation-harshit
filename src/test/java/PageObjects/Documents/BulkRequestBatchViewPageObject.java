package PageObjects.Documents;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class BulkRequestBatchViewPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath="//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade navigation_btn;
    @FindBy(xpath = "//div[text()='Bulk request']")
    private WebElementFacade bulkrequest_btn;
    @FindBy(xpath = "//div[normalize-space()='Document']")
    private WebElementFacade documentnavigation_btn;
    @FindBy(xpath="//input[@placeholder='Search by batch id']")
    private WebElementFacade search_batchid;
    @FindBy(xpath = "//input[@placeholder='Select Document Initiator']")
    private WebElementFacade filter_documentinitiator;
    // @FindBy(xpath = "//input[@placeholder='Select Document Action']")
    // private WebElementFacade filter_documentaction;
    @FindBy(xpath="//input[@id='mui-26']")
    private WebElementFacade filter_documentaction;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-batchId' or text()='Batch ID']")
    private WebElementFacade col_batchid;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-actionType' or text()='Action type']")
    private WebElementFacade col_actiontype;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-initiator' or text()='Initiator']")
    private WebElementFacade col_initiator;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-batchStatus' or text()='Batch status']")
    private WebElementFacade col_batchstatus;
    @FindBy(xpath = "//th[text()='Total']")
    private WebElementFacade col_total;
    @FindBy(xpath = "//th[text()='In process']")
    private WebElementFacade col_inprocess;
    @FindBy(xpath = "//th[text()='Processed']")
    private WebElementFacade col_processed;
    @FindBy(xpath = "//th[text()='Not processed']")
    private WebElementFacade col_notprocessed;
    @FindBy(xpath = "//th[text()='Failed']")
    private WebElementFacade col_failed;
    @FindBy(xpath = "//th[text()='Last updated on']")
    private WebElementFacade col_lastupdatedon;
    @FindBy(xpath = "//tr[1]//td[1]")
    private WebElementFacade searched_batchid;
    @FindBy(xpath = "")
    private WebElementFacade searched_actiontype;
    @FindBy(xpath = "")
    private WebElementFacade searched_initiator;
    public void navigatetobulkrequestscreen(){
        try {
            withAction().pause(Duration.ofSeconds(15)).build().perform();
            navigation_btn.waitUntilClickable();
            navigation_btn.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            documentnavigation_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            bulkrequest_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to rech bulk request screen -->"+e);
            Assert.fail();
        }
    }
    public void searchBatchid(DataTable batchid){
        List<Map<String, String>> data = batchid.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            search_batchid.waitUntilVisible().click();
            typeInto(search_batchid,dataTable.get("batch id"));
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void typeintofilter_documentinitiator(DataTable documentinitiator){
        List<Map<String, String>> data = documentinitiator.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            filter_documentinitiator.waitUntilVisible();
            typeInto(filter_documentinitiator,dataTable.get("document initiator"));
        }catch (Exception e){
            log.error(""+e);
//            Assert.fail();
        }
    }
    public void typeintofilter_documentaction(DataTable documentinitiator){
        List<Map<String, String>> data = documentinitiator.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            filter_documentaction.waitUntilVisible().click();
            typeInto(filter_documentaction,dataTable.get("document action_col"));
        }catch (Exception e){
            log.error(""+e);
//            Assert.fail();
        }
    }
    public void checkifcolumnsvisible(){
        try {
            Assert.assertTrue(col_batchid.isVisible());
            Assert.assertTrue(col_actiontype.isVisible());
            Assert.assertTrue(col_initiator.isVisible());
            Assert.assertTrue(col_batchstatus.isVisible());
            Assert.assertTrue(col_total.isVisible());
            Assert.assertTrue(col_inprocess.isVisible());
            Assert.assertTrue(col_processed.isVisible());
            Assert.assertTrue(col_notprocessed.isVisible());
            Assert.assertTrue(col_failed.isVisible());
            Assert.assertTrue(col_lastupdatedon.isVisible());
            log.info("All the elements are present on the screen");
        }catch (AssertionError e){
            log.error("Element not visible -->"+e);
        }
    }

}
