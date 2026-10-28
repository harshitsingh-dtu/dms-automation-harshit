package PageObjects.DocumentFrameworkPageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class BulkActionPageObject extends PageObject {
    Actions act = new Actions(getDriver());
    @FindBy(xpath = "//*[text()='Error to CreditLink']")
    private WebElementFacade bulkErrorCL_btn;

    @FindBy(xpath = "//th[text()=\"CreditLink Sync Status\"]")
    private WebElementFacade clstatus;

    @FindBy(xpath = "//span[@class=\"creditLinkSyncStatus\"]")
    private WebElementFacade errorackstatus;


    public void clickBulkEditErrorCLAction() {
        bulkErrorCL_btn.click();
    }

    public void validate_document_status() {
        clstatus.waitUntilVisible();
    }
}