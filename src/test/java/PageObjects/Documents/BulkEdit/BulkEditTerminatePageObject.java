package PageObjects.Documents.BulkEdit;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class BulkEditTerminatePageObject extends PageObject {
    @FindBy(xpath = "((//div[@class='pop-box'])/li)[4]")
    private WebElementFacade bulkEditTerminate_btn;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade Doctypeaction;
    @FindBy(xpath = "//input[@class='lp-copy-sel__input']")
    private WebElementFacade actingAs_Action;

    @FindBy(xpath = "//div[@class='acting-content dif']/div/div/div/input")
    private WebElementFacade approvalGroup_Action;

    @FindBy(xpath = "//div[text()='Select documents for terminate in bulk']")
    private WebElementFacade inTerminatePage_bulk;
    @FindBy(xpath = "(//input[@type=\"checkbox\"])[1]")
    private WebElementFacade inTerminatePage_checkbox;
    @FindBy(xpath = "//button[@aria-label='Terminate']")
    private WebElementFacade terminate_btn;
    @FindBy(xpath = "//div[text()=\"Lite users alert\"]")
    private WebElementFacade liteUser_page;
    @FindBy(xpath = "//button[text()=\"Submit\"]")
    private WebElementFacade submit_btn;
    @FindBy(xpath = "//button[text()=\"Confirm\"]")
    private WebElementFacade confirm_btn;

    public void clickBulkEditTerminateAction() {
        try{
            bulkEditTerminate_btn.click();
        }catch (Exception e){
            log.info("Unable to click Bulk Edit Approve Action" + e);
        }
    }
    public void selectdoctypeAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            Doctypeaction.waitUntilVisible();
            withAction().moveToElement(Doctypeaction).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
        }catch (Exception e){
            log.info("Unable to select Doc Type" + e);
        }
    }

    public void selectActingAsAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            actingAs_Action.waitUntilVisible();
            withAction().moveToElement(actingAs_Action).click().sendKeys(dataTable.get("Acting as")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
        }catch (Exception e){
            log.info("Unable to select Acting As LEIs" + e);
        }
    }
    public void selectApprovalGroupAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            approvalGroup_Action.waitUntilVisible();
            withAction().moveToElement(approvalGroup_Action).click().sendKeys(dataTable.get("Approval group")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
        }catch (Exception e){
            log.info("Unable to select approval group" + e);
        }
    }
    public void selectBulkTerminateDocuments() {
        try{
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            inTerminatePage_bulk.waitUntilVisible();
            Assert.assertTrue(inTerminatePage_bulk.isVisible());
            inTerminatePage_checkbox.waitUntilVisible();
            inTerminatePage_checkbox.click();

        }catch (Exception e){
            log.info("Unable to check Bulk Edit Terminate Checkbox" + e);
        }
    }
    public void clickTerminateBtn() {
        try{
            terminate_btn.waitUntilVisible();
            Assert.assertTrue(terminate_btn.isVisible());
            terminate_btn.click();
        }catch (Exception e){
            log.info("Unable to click Terminate Button" + e);
        }
    }
    public void liteUserPage() {
        try{
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            liteUser_page.waitUntilVisible();
            Assert.assertTrue(liteUser_page.isVisible());

        }catch (Exception e){
            log.info("Unable to redirected to lite user page" + e);
        }
    }
    public void liteUser_submitPage() {
        try{
            submit_btn.click();
        }catch (Exception e){
            log.info("Unable to click Submit Button" + e);
        }
    }

    public void liteUser_confirmButton() {
        try{
            confirm_btn.click();
        }catch (Exception e){
            log.info("Unable to click Confirm Button" + e);
        }
    }
}