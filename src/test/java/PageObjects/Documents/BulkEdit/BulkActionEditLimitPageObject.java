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
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class BulkActionEditLimitPageObject extends PageObject {

    @FindBy(xpath = "//div[@id='panel1a-header']")
    private WebElementFacade header_dropdown_edit_limit_scope;

    @FindBy(xpath = "(//span/strong)[1]")
    private WebElementFacade doc_id_on_edit_limit_scope;

    @FindBy(xpath = "(//span/strong)[2]")
    private WebElementFacade doc_version_id_on_edit_limit_scope;

    @FindBy(xpath = "//table//input")
    private WebElementFacade limit_value_text_box;
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
    private WebElementFacade search_document_id;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElementFacade check_box_for_doc;
    @FindBy(xpath =" //button[text()='Submit for Approval']")
    private WebElementFacade submit_for_approval_btn;

    public void Verify_document_id(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(doc_id_on_edit_limit_scope.isVisible());
            Assert.assertEquals(doc_id_on_edit_limit_scope.getText(),dataTable.get("DocumentID"));
        }
        catch (Exception e){
            log.info("Document Id is not match" + e);
            Assert.fail();
        }
    }

    public void Verify_document_version_id(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(doc_version_id_on_edit_limit_scope.isVisible());
            Assert.assertEquals(doc_version_id_on_edit_limit_scope.getText(),dataTable.get("DocumentVersionID"));
        }
        catch (Exception e){
            log.info("Document version ID is not match" + e);
            Assert.fail();
        }
    }


    public void Select_doc(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            search_document_id.waitUntilVisible();
            search_document_id.type(dataTable.get("Document ID"));
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            check_box_for_doc.waitUntilVisible();
            Assert.assertFalse( check_box_for_doc.isSelected());
            check_box_for_doc.click();
            Assert.assertTrue( check_box_for_doc.isSelected());

        }
        catch (Exception e){
            log.info("unable to select Document by ID" + e);
            Assert.fail();
        }
    }

    public void Select_first_doc()
    {
        try {
            String versionID = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_VERSION_ID");
            
            // Wait for any potential overlay to disappear
            try {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                WebElement overlay = getDriver().findElement(org.openqa.selenium.By.className("MuiDialog-container"));
                if (overlay.isDisplayed()) {
                    log.info("Overlay detected, waiting for it to disappear...");
                    waitForAbsenceOf(".MuiDialog-container");
                }
            } catch (Exception e) {
                // No overlay found, proceed
            }

            if (versionID != null && !versionID.isEmpty()) {
                log.info("Searching for specific document with Version ID: " + versionID);
                search_document_id.waitUntilVisible();
                // Use JS click to avoid interception
                ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", search_document_id);
                search_document_id.type(versionID);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }
            
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            check_box_for_doc.waitUntilVisible();
            if (!check_box_for_doc.isSelected()) {
                // Use JS click here too as it's also prone to interception in grids
                ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", check_box_for_doc);
            }
            // Add a small pause to let the selection register
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue("Document checkbox should be selected", check_box_for_doc.isSelected());
        }
        catch (Exception e){
            log.info("unable to select Document by ID" + e);
            Assert.fail();
        }
    }

    public void change_limit_value(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            header_dropdown_edit_limit_scope.waitUntilVisible().click();
            Assert.assertTrue(limit_value_text_box.isVisible());
            limit_value_text_box.clear();
            withAction().moveToElement(limit_value_text_box).click().sendKeys(dataTable.get("New Value")).pause(Duration.ofSeconds(2)).build().perform();

        }
        catch (Exception e){
            log.info("unable to change limit value" + e);
            Assert.fail();
        }

    }

    public void change_limit_value_again(DataTable table)
    {List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(limit_value_text_box.isVisible());
            limit_value_text_box.clear();
            withAction().moveToElement(limit_value_text_box).click().sendKeys(dataTable.get("New Value")).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.info("unable to change limit value" + e);
            Assert.fail();
        }

    }

    public void Click_submit_for_approval_button(){
        submit_for_approval_btn.waitUntilVisible().click();

    }
}
