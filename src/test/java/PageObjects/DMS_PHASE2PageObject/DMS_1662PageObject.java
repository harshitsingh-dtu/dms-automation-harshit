package PageObjects.DMS_PHASE2PageObject;


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
public class DMS_1662PageObject extends PageObject {

    @FindBy(xpath = "//strong[text()='Bulk request']")
    private WebElementFacade BulkRequest_text;
    @FindBy(xpath = "//input[@placeholder='Search by batch id']")
    private WebElementFacade SearchBox_BatchID;
    @FindBy(xpath = "//input[@placeholder='Select Document Initiator by Lei']")
    private WebElementFacade DocumentInitiator_Filter;
    @FindBy(xpath = "//input[@placeholder='Select Document Action']")
    private WebElementFacade DocumentAction_Filter;
    @FindBy(xpath = "//div[text()='Batch id']")
    private WebElementFacade BatchID_Column;
    @FindBy(xpath = "//div[text()='Doc type']")
    private WebElementFacade DocType_Column;
    @FindBy(xpath = "//div[text()='Action type']")
    private WebElementFacade ActionType_Column;
    @FindBy(xpath = "//div[text()='Initiator']")
    private WebElementFacade Initiator_Column;
    @FindBy(xpath = "//div[text()='Batch status']")
    private WebElementFacade BatchStatus_Column;
    @FindBy(xpath = "//div[text()='Total']")
    private WebElementFacade Total_Column;
    @FindBy(xpath = "//div[text()='In process']")
    private WebElementFacade InProcess_Column;
    @FindBy(xpath = "//div[text()='Processed']")
    private WebElementFacade Processed_Column;
    @FindBy(xpath = "//div[text()='Not processed']")
    private WebElementFacade NOTProcessed_Column;
    @FindBy(xpath = "//div[text()='Failed']")
    private WebElementFacade Failed_Column;
    @FindBy(xpath = "//div[text()='Last updated on']")
    private WebElementFacade Last_UpdateON_Column;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade NORecordFound_text_for_bulk_request;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade Filtered_ActionItem;

    @FindBy(xpath = "//tr//td[4]")
    private WebElementFacade filterd_InitiatorDATA;
    @FindBy(xpath = "//tr//td[3]")
    private WebElementFacade filterd_ActionitemDATA;

    @FindBy(xpath = "//button[text()='View Details']")
    private WebElementFacade ViewDetail_button;
    @FindBy(xpath = "//h3[text()='Batch details']")
    private WebElementFacade BatchDetail_text;

    @FindBy(xpath = "//input[@placeholder='Batch Status']")
    private WebElementFacade BatchStatus_filter;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade Filtered_BatchStatus;







    public void filteredActionItem(List<String> ActionItemlist){

        try {
            for (int begin=1;begin<ActionItemlist.size();begin++)
            {
                DocumentAction_Filter.waitUntilClickable().click();
                DocumentAction_Filter.type(ActionItemlist.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
//                Assert.assertEquals(ActionItemlist.get(begin),Filtered_ActionItem.getText());
                if(ActionItemlist.get(begin).equalsIgnoreCase(Filtered_ActionItem.getText())){
                    log.info("Action Item" +ActionItemlist.get(begin)+ " is part of Action Item List ");
                }
                DocumentAction_Filter.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found Action Item inside the Action Item filter-->" + e);
            Assert.fail();
        }
    }

    public void typeintoDocumentInitiator_Filter(DataTable documentinitiator){
        List<Map<String, String>> data = documentinitiator.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            DocumentInitiator_Filter.waitUntilVisible();
            withAction().moveToElement(DocumentInitiator_Filter).click().sendKeys(dataTable.get("Document Initiator")).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            String InitiatorInput = DocumentInitiator_Filter.getAttribute("value").replaceAll("\\s*-\\s*", "-");

            log.info("selected initiator filter " +InitiatorInput);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            filterd_InitiatorDATA.isVisible();
            log.info("Result initiator filter " +filterd_InitiatorDATA.getText());
            if (InitiatorInput.equals(filterd_InitiatorDATA.getText())) {
                log.info("Selected Document initiator " + InitiatorInput + " match with respective results " + filterd_InitiatorDATA.getText());
            }else if (NORecordFound_text_for_bulk_request.getText().equalsIgnoreCase("No Record Found")){
                Assert.assertTrue(NORecordFound_text_for_bulk_request.isVisible());
            }else {
                Assert.fail();
            }
        }catch (Exception e){
            log.error("Unable to type or get appropriate result for selected Document Initiator " +e);
            Assert.fail();
        }
    }


    public void typeintoDocumentAction_Filter(DataTable documentActionFilter){
        List<Map<String, String>> data = documentActionFilter.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            DocumentAction_Filter.waitUntilVisible();
            withAction().moveToElement(DocumentAction_Filter).click().sendKeys(dataTable.get("Document Action")).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            filterd_ActionitemDATA.isVisible();
            if (DocumentAction_Filter.getAttribute("value").equals(filterd_ActionitemDATA.getText())) {
                log.info("Selected Document Action" + DocumentAction_Filter.getAttribute("value") +  "match with respective results" + filterd_ActionitemDATA.getText()) ;
            }else {
                Assert.fail();
            }
        }catch (Exception e){
            log.error("Unable to type or get appropriate result for selected Document Action " +e);
            Assert.fail();
        }
    }



    public void filteredBatchStatus(List<String> BatchStatus){

        try {
            for (int begin=1;begin<BatchStatus.size();begin++)
            {
                BatchStatus_filter.waitUntilClickable().click();
                BatchStatus_filter.type(BatchStatus.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
//                Assert.assertEquals(ActionItemlist.get(begin),Filtered_ActionItem.getText());
                if(BatchStatus.get(begin).equalsIgnoreCase(Filtered_BatchStatus.getText())){
                    log.info("Batch Status" + BatchStatus.get(begin) +  "is part of Batch Status Filter");
                }
                BatchStatus_filter.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found Batch Status inside the BatchStatus filter-->" + e);
            Assert.fail();
        }
    }



}
