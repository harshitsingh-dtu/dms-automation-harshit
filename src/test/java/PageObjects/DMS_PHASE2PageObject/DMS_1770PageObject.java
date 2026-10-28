package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data

public class DMS_1770PageObject extends PageObject {

    @FindBy(xpath = "//div[text()='Select Executing Broker - 1']")
    private WebElementFacade ExecutingBroker1Filter;

    @FindBy(xpath = "//button[text()='Submit Request']")
    private WebElementFacade submitRequest_btn;

    @FindBy(xpath = "//div[@class='list']")
    private WebElementFacade notification_message;

    public void EnterExecutingBroker1(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(ExecutingBroker1Filter.isVisible());
            withAction().moveToElement(ExecutingBroker1Filter).click().sendKeys(dataTable.get("Executing Broker-1")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.error("Unable to type into PrimeBroker1Filter-->" + e);
            Assert.fail();
        }
    }
    public void notificationRequestCreateDocument_dialogueBox(){
        try{
            String notificationMessage_text = notification_message.getText().trim();
            log.info("Message is :" +notificationMessage_text);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            if (notificationMessage_text.contains("CREATE DOCUMENT REQUEST NOTIFICATION")){

                log.info("Correct notification is visible for request to create document");

            }
            else {
                log.info("Unable to see correct message");
                Assert.fail();
            }
        }
        catch (Exception e){
            log.error("Unable to see the notification for request to create document" +e);
            Assert.fail();
        }
    }
}
