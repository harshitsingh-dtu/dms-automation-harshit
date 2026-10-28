package PageObjects.Documents.BulkEdit;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class BulkEditRejectPageObject extends PageObject {

    @FindBy(xpath = "//*[text()=' Reject']")
    private WebElementFacade bulkEditReject_btn;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade DoctypeAction;
    @FindBy(xpath = "//input[@class= 'lp-copy-sel__input']")
    private WebElementFacade actingAs_Action;

    @FindBy(xpath = "//div[@class='acting-content dif']/div/div/div/input")
    private WebElementFacade approvalGroup_Action;

    @FindBy(xpath = "//div[text()=\"In-approval Documents\"]")
    private WebElementFacade inApprovalPage_bulk;
    @FindBy(xpath = "(//input[@type=\"checkbox\"])[1]")
    private WebElementFacade inApprovalPage_checkbox;
    @FindBy(xpath = "//button[text()=\"Reject\"]")
    private WebElementFacade reject_btn;
    public void clickBulkEditRejectAction() {
        try{
            bulkEditReject_btn.click();
        }catch (Exception e){
            log.info("Unable to click Bulk Edit Reject Action" + e);
        }
    }

    public void selectDoctypeAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            DoctypeAction.waitUntilVisible();
            withAction().moveToElement(DoctypeAction).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
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
            withAction().pause(Duration.ofSeconds(4)).build().perform();
//            actingAs_Action.waitUntilVisible();
            withAction().moveToElement(actingAs_Action).click().sendKeys(dataTable.get("Acting as")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Acting As LEIs" + e);
        }
    }
    public void selectApprovalGroupAction(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            approvalGroup_Action.waitUntilVisible();
            withAction().moveToElement(approvalGroup_Action).click().sendKeys(dataTable.get("Approval Group")).pause(Duration.ofSeconds(2)).build().perform();

            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.info("Unable to select Approval Group Action" + e);
        }
    }

    public void selectBulkRejectDocuments() {
        try{
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            inApprovalPage_bulk.waitUntilVisible();
            inApprovalPage_checkbox.waitUntilPresent().click();
        }catch (Exception e){
            log.info("Unable to check Bulk Edit Reject Checkbox" + e);
        }
    }

    public void clickRejectBtn() {
        try{
            reject_btn.click();
        }catch (Exception e){
            log.info("Unable to click Reject Button" + e);
        }
    }
}