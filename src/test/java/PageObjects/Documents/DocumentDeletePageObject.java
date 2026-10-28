package PageObjects.Documents;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DocumentDeletePageObject extends PageObject {
    //@FindBy(xpath = "//th[normalize-space()='Version ID']//input[@placeholder='Search']")
    //private WebElementFacade document_id;

    @FindBy(xpath="//th[@data-testid='doc-table-th-documentVersionId' or normalize-space()='Document version ID']//input[@placeholder='Search']")
    private WebElementFacade document_id;
    @FindBy(xpath = "//button[@aria-label='Delete']//img[@alt='Delete']")
    private WebElementFacade delete_btn;
    @FindBy(xpath = "//div[@class='alert-msg']")
    private WebElementFacade alert_msg;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElementFacade delete_confirmation;
    @FindBy(xpath = "//span[@class='batch-status deleted']")
    private WebElementFacade delete_Status;
    @FindBy(xpath = "//div[contains(text(),'Document is deleted')]")
    private WebElementFacade delete_notification;
    @FindBy(xpath = "//span[contains(@data-testid, 'cell-status-') and text()='Terminated']")
    private WebElementFacade docStatus_Terminated;

    public void searchDocument(DataTable DocumentName){
        List<Map<String, String>> data = DocumentName.asMaps(String.class, String.class);
        Map<String, String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            document_id.waitUntilVisible();
            typeInto(document_id,dataTable.get("Document Version ID"));
        }catch (Exception e){
            log.error("Unable to input Document ID-->"+e);
            Assert.fail();
        }
    }
    public void clickDeleteBtn() {
        try{
            delete_btn.waitUntilVisible().click();
            alert_msg.waitUntilPresent();
            delete_confirmation.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Document deleted successfully");
        }catch (Exception e) {
            log.error("Unable to click Delete button-->" + e);
            Assert.fail();
        }
    }
    public void verifyDeletedDocument() {
        try{
            delete_Status.waitUntilPresent();
        }catch (Exception e) {
            log.error("Unable to check Delete status-->" + e);
            Assert.fail();
        }
    }
}