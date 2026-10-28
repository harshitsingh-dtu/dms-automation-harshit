package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data

public class DMS_2495PageObject extends PageObject {

    @FindBy(xpath="//div[@role='dialog']")
    private WebElementFacade popup_body;
    @FindBy(xpath="//div[@role='dialog']//button[text()='No']")
    private WebElementFacade popup_No_btn;
    @FindBy(xpath="//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade popup_Yes_btn;
    @FindBy(xpath="//div[text()='Lite users alert']//following::button[text()='Submit']")
    private WebElementFacade submit_btn_on_lite_user_alert_screen;
    @FindBy(xpath="//div[@class='bulk-req-list ch-scr-container']")
    private WebElementFacade bulk_request_screen;//strong[text()='Bulk request']
    @FindBy(xpath="//strong[text()='Bulk request']")
    private WebElementFacade bulk_request_screenverify;
    @FindBy(xpath="//input[@placeholder='Select Document Initiator by Lei']")
    private WebElementFacade initiator_search;
    @FindBy(xpath="//button[text()='View Details']")
    private WebElementFacade viewDetails_BR;
    @FindBy(xpath="//h3[text()='Batch details']")
    private WebElementFacade batch_details_screen;
    @FindBy(xpath="(//td[contains(text(),'Submitted')])[1]")
    private WebElementFacade batchStatus_Submitted;
    @FindBy(xpath="(//td[contains(text(),'Processed')])[1]")
    private WebElementFacade batchStatus_Processed;
    @FindBy(xpath="(//td[contains(text(),'Completed')])[1]")
    private WebElementFacade batchStatus_Completed;
    @FindBy(xpath="//button[text()='Update']")
    private WebElementFacade USP_template_update_btn;
    @FindBy(xpath="//input[@placeholder='Enter contact']")
    private WebElementFacade contact_input_box;
    @FindBy(xpath="//button[text()='Submit']")
    private WebElementFacade USP_template_Submit_btn;
    @FindBy(xpath="//div[@class='impacted-subheading']//following::tr/th/input")
    private WebElementFacade impacted_document_select_checkbox;
    @FindBy(xpath="//div[@class='impacted-subheading']//following::button[text()='Apply']")
    private WebElementFacade impacted_document_screen_apply_btn;
    @FindBy(xpath = "//div[text()='Lite users alert']")
    private WebElementFacade lite_user_alert_screen;
    @FindBy(xpath = "//h2[text()='Submitting bulk request']")
    private WebElementFacade submitting_Bulk_request_Screen;
    @FindBy(xpath = "//strong[text()='Bulk request']")
    private WebElementFacade bulk_request_screen_heading;
    @FindBy(xpath = "//div[text()='Bulk request']")
    private WebElementFacade bulk_request_tab;
    @FindBy(xpath = "//input[@placeholder='Select Document Action']")
    private WebElementFacade document_action_dropdown;
    @FindBy(xpath = "//div[@class='bulk-req-list ch-scr-container']//following::tr/td[3]")
    private List<WebElementFacade> action_type_list;
    public void change_contact_in_usp_template()
    {
        String random_value= RandomString.make(7);
        contact_input_box.clear();
        contact_input_box.sendKeys(random_value);

    }
    public void select_doc_action_Apply_USP_Rider()
    {
        withAction().moveToElement(document_action_dropdown).click().sendKeys("Apply USP Rider").sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }
    public void check_only_Apply_USP_Rider_present_under_Action_type_column()
    {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        
        if (action_type_list.isEmpty()) {
            log.error("No items found in the Action Type list. Expected 'Apply USP Rider'.");
            Assert.fail("The Action Type column list is empty. No data found on the screen.");
        }

        log.info("Validating " + action_type_list.size() + " items in the Action Type column.");
        for (WebElementFacade actionItem : action_type_list)
        {
            String actualText = actionItem.getText().trim();
            if (!actualText.toLowerCase().contains("apply usp rider"))
            {
                log.error("Validation failed! Found unexpected action: '" + actualText + "'. Expected contains: 'Apply USP Rider'");
                Assert.fail("Unexpected action type found: " + actualText);
            }
        }
        log.info("Successfully verified all items contain 'Apply USP Rider'.");
    }

    public void selectInitiatorBYLEI(List<String> approvalGroup){
        try {
            initiator_search.waitUntilClickable();
            initiator_search.click();
            initiator_search.type(approvalGroup.get(1));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            act.pause(Duration.ofSeconds(2)).build().perform();
            viewDetails_BR.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Assert.assertTrue(batch_details_screen.isVisible());
        }catch (Exception e){
            log.error("Not able to interact with search bar"+e);
            Assert.fail();
        }
    }

    public void validateBatchStatus(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(batchStatus_Submitted.getText().trim().equalsIgnoreCase("Submitted"));
        }catch (Exception e){
            log.error("Not able to interact with search bar"+e);
            Assert.fail();
        }
    }

    public void validateProcessedBatchStatus(){
        int maxRetries = 5;
        boolean statusFound = false;
        for (int i = 0; i < maxRetries; i++) {
            try {
                log.info("Checking for Processed batch status... Attempt " + (i + 1));
                if (withTimeoutOf(Duration.ofSeconds(60)).waitFor(
                        ExpectedConditions.or(
                                ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Processed')])[1]")),
                                ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Completed')])[1]"))
                        )
                ) != null) {
                    statusFound = true;
                    log.info("Batch status successfully updated to Processed or Completed.");
                    break;
                }
            } catch (Exception e) {
                if (i < maxRetries - 1) {
                    log.info("Batch status not updated yet. Refreshing the browser...");
                    getDriver().navigate().refresh();
                    withAction().pause(Duration.ofSeconds(20)).build().perform();
                }
            }
        }
        if (!statusFound) {
            log.error("Batch status did not become 'Processed' or 'Completed' within the timeout period.");
            Assert.fail("Batch status did not become 'Processed' or 'Completed' within the timeout period.");
        }
    }
}