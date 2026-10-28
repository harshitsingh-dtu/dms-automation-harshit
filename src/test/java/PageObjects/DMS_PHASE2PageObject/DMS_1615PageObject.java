package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DMS_1615PageObject extends PageObject{


    @FindBy(xpath = "//button[text()='Bulk Action']")
    private WebElementFacade BulkActionButton;
    @FindBy(xpath = "//li[text()=' Approve']")
    private WebElementFacade Approvebutton;
    @FindBy(xpath = "//li[text()=' Reject']")
    private WebElementFacade Rejectbutton;
    @FindBy(xpath = "//div[text()='Select bulk action below']")
    private WebElementFacade SelectBulkActionBelowText;
    @FindBy(xpath = "//li[text()='Terminate']")
    private WebElementFacade Terminatebutton;
    @FindBy(xpath = "//li[text()='Edit']")
    private WebElementFacade Editbutton;



    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctypeDropdown;
    @FindBy(xpath = "//p[text()='4 Way']")
    private WebElementFacade FourWaydoctypefromdropdown;
    @FindBy(xpath = "//p[text()='DN']")
    private WebElementFacade DNdoctypefromdropdown;
    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade NoOptionfordoctype;
    // error Message The user does not have the necessary permission to perform this action.
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElementFacade ErrorMessage;
    @FindBy(xpath = "//li[contains(., \"Sync to CreditLink\")]")
    private WebElementFacade SyncToCLButton;
    @FindBy(xpath = "//div[@class=\"no-record-found\"]")
    private WebElementFacade NoRecordFound;
    @FindBy(xpath="//button[normalize-space()='Cancel']")
    private WebElementFacade CancelButton;


    public void CheckErrorMEssagefor4wayDoctype(DataTable Doctype){
        List<Map<String, String>> data = Doctype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doctypeDropdown.waitUntilClickable().clear();
            if (dataTable.get("Doc type").equalsIgnoreCase("4 Way")){
                withAction().moveToElement(doctypeDropdown).click().sendKeys(dataTable.get("Doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Assert.assertTrue(ErrorMessage.getText().contains("The user does not have the necessary permission to perform this action"));
            }else if (dataTable.get("Doc type").equalsIgnoreCase("DN")){
                withAction().moveToElement(doctypeDropdown).click().sendKeys(dataTable.get("Doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }else {
                log.error("Enter DocType Not Found Please Enter Valid Doctype OR Check once with Permission 'Org_user' should assigned");
                Assert.fail();
            }
        }catch (Exception e){
            log.error("Unable to check error Message for 4 way Doctype when required permission " +e);
            Assert.fail();
        }
    }

    public void CheckErrorMEssageforDNDoctype(DataTable Doctype){
        List<Map<String, String>> data = Doctype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doctypeDropdown.waitUntilClickable().clear();
            if (dataTable.get("Doc type").equalsIgnoreCase("DN")){
                withAction().moveToElement(doctypeDropdown).click().sendKeys(dataTable.get("Doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Assert.assertTrue(ErrorMessage.getText().contains("The user does not have the necessary permission to perform this action"));
            }else if (dataTable.get("Doc type").equalsIgnoreCase("4 Way")){
                withAction().moveToElement(doctypeDropdown).click().sendKeys(dataTable.get("Doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }else {
                log.error("Enter DocType Not Found Please Enter Valid Doctype OR Check once with Permission 'Org_user' should assigned");
                Assert.fail();
            }
        }catch (Exception e){
            log.error("Unable to check error Message for DN Doctype when required permission " +e);
            Assert.fail();
        }
    }

    public void validateDataOnListingScreen() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            if (!NoRecordFound.isVisible()) {
                log.info("Document data is loaded in listing screen");
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                CancelButton.click();
            } else {
                log.info("Document data is not loaded in listing screen");
            }
        } catch (Exception e) {
            log.error("Unable to load data " + e);
            Assert.fail();
        }
    }
}
