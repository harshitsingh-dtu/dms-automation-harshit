package PageObjects.Documents;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class BasicFilteringPageObject extends PageObject{
    Actions act=new Actions(getDriver());

    @FindBy(xpath = "//th[@data-testid='doc-table-th-allowedCurrencies' or contains(., 'Allowed currencies')]//input")
    private WebElementFacade filter_allowedcurrency;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentType' or contains(., 'Document type')]//input")
    private WebElementFacade filter_documenttype;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-initiator' or text()='Initiator']//input")
    private WebElementFacade filter_documentinitiator;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentStatus' or text()='Document status']//input")
    private WebElementFacade filter_document_status;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentAction' or text()='Document action']//input")
    private WebElementFacade filter_documentactions;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentType' or text()='Document type']//input")
    private WebElementFacade Document_Type_Input;
    @FindBy(xpath = "//p[contains(@class,'MuiTypography-root MuiTypography-body1')]")
    private WebElementFacade SearchedDocType;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-allowedCurrencies' or text()='Allowed currencies']//parent::div//div[@role='presentation']")
    private WebElementFacade allowedCurrencyValues;

    public void check_if_filterAllowedcurrency_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_allowedcurrency).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter"),Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the Allowedcurrency filter"+e);
            Assert.fail();
        }
    }
    public boolean allowed_currency_values(){
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_allowedcurrency).click().pause(Duration.ofSeconds(2));
        return allowedCurrencyValues.getText().equalsIgnoreCase("FX\nBULLION");
    }
    public void check_if_filterDocumenttype_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_documenttype).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter"),Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the Document type filter"+e);
            Assert.fail();
        }
    }

    public void check_if_filterDocumentinitiator_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_documentinitiator).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter"),Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the Document initiator filter"+e);
            Assert.fail();
        }
    }



    public void check_if_filterDocumentactions_and_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_documentactions).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter"),Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the Document actions filter"+e);
            Assert.fail();
        }
    }
    public void Check_doc_type_input_box_case_sensitivity(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        String partialInputs1;
        String expectedOutputs1;

        for (int i = 0; i <= 13; i++) {
            partialInputs1 = dataTable.get("partialInput");
            expectedOutputs1 = dataTable.get("Output");

            Document_Type_Input.sendKeys(partialInputs1);
            Assert.assertEquals(expectedOutputs1, SearchedDocType.getText());
            log.info("Enter value --> " + partialInputs1 + " ---Got output--->");
            Document_Type_Input.clear();
        }

    }
}
