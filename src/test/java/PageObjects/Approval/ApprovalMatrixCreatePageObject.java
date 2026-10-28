package PageObjects.Approval;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@Data
public class ApprovalMatrixCreatePageObject extends PageObject {

    Actions act=new Actions(getDriver());

    @FindBy(xpath = "//*[contains(text(),'Create new approval matrix')]")
    private WebElementFacade createnewapprovalmatrix_txt;
    @FindBy(xpath = "//*[contains(text(),'Organisation*')]")
    private WebElementFacade organization_filter_txt;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organization_filter;
    @FindBy(xpath = "//*[contains(text(),'LEIs*')]")
    private WebElementFacade LEI_filter_txt;
    @FindBy(xpath = "//div[text()='Select Leis']")
    private WebElementFacade LEI_filter;
    @FindBy(xpath = "//*[contains(text(),'Org type*')]")
    private WebElementFacade orgtype_filter_txt;
    @FindBy(xpath = "//input[@placeholder=\"Select Org Type\"]")
    private WebElementFacade orgtype_filter;
    @FindBy(xpath = "//*[contains(text(),'Doc type*')]")
    private WebElementFacade doctype_filter_txt;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctype_filter;
    @FindBy(xpath = "//button[normalize-space()='Next']")
    private WebElementFacade next_btn;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElementFacade cancel_btn;
    @FindBy(xpath = "//div[contains(text(),'Approval Matrix already exists.')]")
    private WebElementFacade matrix_already_exists;
    @FindBy(xpath = "//button[contains(., '+ Add Sequence Column')]")
    private WebElementFacade add_seqential_column;
    @FindBy(xpath = "//button[contains(., '+ Add Parallel Column')]")
    private WebElementFacade add_parallel_column;
    @FindBy(xpath = "//div[@role='dialog']//button[normalize-space()='Confirm']")
    private WebElementFacade confirmPopupBtn;


    public void checkiforganizationfilter_and_type(DataTable organizationfilter){
        List<Map<String, String>> data = organizationfilter.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            organization_filter_txt.waitUntilVisible();
            withAction().moveToElement(organization_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("organisation name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("unable to input in the organization filter-->"+e);
            Assert.fail();
        }

    }
    public void checkifLEIsfilter_and_type(DataTable leifilter){
        List<Map<String, String>> data = leifilter.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            LEI_filter_txt.waitUntilVisible();
            withAction().moveToElement(LEI_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("LEI filter")).pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input in the lei filter-->"+e);
            Assert.fail();
        }


    }
    public void checkifOrgtypefilter_and_type(DataTable orgtypefilter){
        List<Map<String, String>> data = orgtypefilter.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            orgtype_filter_txt.waitUntilVisible();
            withAction().moveToElement(orgtype_filter).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("org type filter")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input in the org type filter-->"+e);
            Assert.fail();
        }


    }
    public void checkifDoctypefilter_and_type(DataTable doctypefilter){
        List<Map<String, String>> data = doctypefilter.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doctype_filter_txt.waitUntilVisible();
            doctype_filter.click();
            doctype_filter.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            act.pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(doctype_filter).click().pause(Duration.ofSeconds(1)).sendKeys(dataTable.get("doc type filter")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("unable to input in the doc type filter-->"+e);
            Assert.fail();
        }


    }
    public void checkifcancalbtn(){
        Assert.assertTrue(cancel_btn.isVisible());
    }
    public void checkifnextbtn(){
        Assert.assertTrue(next_btn.isVisible());
    }
    public void click_next_btn(){
        next_btn.waitUntilVisible();
        evaluateJavascript("arguments[0].click();", next_btn);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    public void remove_approval_group(DataTable table){
        Map<String, String> data = table.asMaps(String.class, String.class).get(0);
        String documentAction = data.get("Document Action");
        String sequence = data.get("Approval Sequence");
        String inputFieldXpath = String.format("(//td[normalize-space()='%s']/parent::tr//input)[%s]", documentAction, sequence);
        String clearBtnXpath = String.format("(//td[normalize-space()='%s']/parent::tr//button[@title='Clear'])[%s]", documentAction, sequence);

        WebElementFacade inputField = find(By.xpath(inputFieldXpath));
        try {
            inputField.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();
            evaluateJavascript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", inputField);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            withAction().moveToElement(inputField).pause(Duration.ofMillis(500)).build().perform();

            WebElementFacade clearButton = find(By.xpath(clearBtnXpath));

            if (clearButton.isCurrentlyVisible()) {
                evaluateJavascript("arguments[0].click();", clearButton.getElement());
                withAction().pause(Duration.ofMillis(500)).build().perform();
                log.info("Successfully cleared approval group for action: '{}' at sequence: {}", documentAction, sequence);
            } else {
                log.warn("Clear button not visible for action: '{}'. Attempting to clear input field directly.", documentAction);
                inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            }
        } catch (Exception e) {
            log.error("Failed to remove approval group for action: '{}'. Error: {}", documentAction, e.getMessage());
            Assert.fail("Could not remove the approval group value from the matrix.");
        }
    }
    public void deleteSequenceColumn(String sequenceId) {
        String dynamicXpath = "//*[@data-testid='delete-column-icon-" + sequenceId + "']";
        WebElementFacade deleteIcon = find(By.xpath(dynamicXpath));
        deleteIcon.withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", deleteIcon);
        withAction().pause(Duration.ofMillis(500)).build().perform();

        try {
            deleteIcon.waitUntilClickable().click();
            log.info("Successfully clicked delete icon for: {}", sequenceId);
        } catch (Exception e) {
            log.warn("Standard click intercepted for {}, falling back to JS Click...", sequenceId);
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", deleteIcon);
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void clickConfirmOnPopup() {
        try {
            confirmPopupBtn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().waitUntilClickable();
            confirmPopupBtn.click();
            log.info("Successfully clicked the Confirm button on the popup.");
            withAction().pause(Duration.ofSeconds(2)).build().perform();

        } catch (Exception e) {
            log.warn("Standard click failed on Confirm button, attempting JS click. Error: {}", e.getMessage());
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmPopupBtn);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }

}