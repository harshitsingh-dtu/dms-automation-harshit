package PageObjects.DMS_PHASE2PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2205PageObject extends PageObject {

    @FindBy(xpath = "//div[@class='link']")
    private WebElementFacade documentVersionIDLink;

    @FindBy(xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade documentVersionIDInput;

    @FindBy(xpath = "//img[@alt='Download']")
    private WebElementFacade downloadIcon_documentScreen;

    @FindBy(xpath = "//th[@data-testid='doc-table-th-uspStatus']//input")
    private WebElementFacade uspRiderStatus_input;

    @FindBy(xpath = "//button[text()='USP rider']")
    private WebElementFacade uspRiderTab_button;

    @FindBy(xpath = "//div[text()='Prime Broker']//following-sibling::strong")
    private WebElementFacade primeBrokerName_UspPreviewSubmit;

    @FindBy(xpath = "//div[text()='Client']//following-sibling::strong")
    private WebElementFacade clientName_UspPreviewSubmit;

    @FindBy(xpath = "//strong[text()='PB Contact']/following-sibling::div")
    private WebElementFacade pbContactText_UspPreviewSubmit;

    @FindBy(xpath = "//div[@class='fund-leis']//div")
    private WebElementFacade fundLEIName_UspPreviewSubmit;

    @FindBy(xpath = "//div[@class='usp-selection-div']//strong")
    private WebElementFacade uspRiderID_UspPreviewSubmit;

    @FindBy(xpath = "//button[text()='View as PDF']")
    private WebElementFacade viewAsPdfButton_UspPreviewSubmit;

    @FindBy(xpath = "//li[text()='USP Rider']")
    private WebElementFacade uspRiderText_pdfVersion;

    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade previewAndSubmitButton_pdfVersion;

    @FindBy(xpath = "//input[@class='date-range-picker']")
    private WebElementFacade datePicker_USPRiderTab;

    public void searchDocumentVersionIdRandomly(){
        try{
            String DocumentVersionID = documentVersionIDLink.getText().trim();
            withAction().moveToElement(documentVersionIDInput).click().sendKeys(DocumentVersionID).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search document version id " +e);
            Assert.fail();
        }
    }
    public void input_UspRiderStatus(List<String> uspStatus){
        try {
//        Next 6 line code is performing horizontal scrolling of table
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", uspRiderStatus_input);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            jsExecutor.executeScript("window.scrollBy(0, 500);");
            jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");
            withAction().pause(Duration.ofSeconds(3)).build().perform();

            for (int begin=1;begin<uspStatus.size();begin++)
            {
                uspRiderStatus_input.waitUntilVisible();
                withAction().moveToElement(uspRiderStatus_input).click().sendKeys(uspStatus.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
            }
        }
        catch (Exception e){
            log.error("unable to select USP Rider status " + e);
            Assert.fail();
        }
    }
    public void validateContentUSPTabUnderPreviewSubmit_PdfVersion(){
        try{
            JavascriptExecutor je = (JavascriptExecutor) getDriver();
            je.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", primeBrokerName_UspPreviewSubmit);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String PrimeBrokerName_UspPreviewSubmit  = primeBrokerName_UspPreviewSubmit.getText().trim();
            String ClientName_UspPreviewSubmit  = clientName_UspPreviewSubmit.getText().trim();
            String USPRiderID_UspPreviewSubmit  = uspRiderID_UspPreviewSubmit.getText().trim();
            String PBContactText_UspPreviewSubmit  = pbContactText_UspPreviewSubmit.getText().trim();
            withAction().moveToElement(viewAsPdfButton_UspPreviewSubmit).click().build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", uspRiderText_pdfVersion);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String PrimeBrokerName_PdfVersion  = primeBrokerName_UspPreviewSubmit.getText().trim();
            String ClientName_PdfVersion  = clientName_UspPreviewSubmit.getText().trim();
            String USPRiderID_pdfVersion  = uspRiderID_UspPreviewSubmit.getText().trim();
            String PBContactText_PdfVersion  = pbContactText_UspPreviewSubmit.getText().trim();
            if (PrimeBrokerName_UspPreviewSubmit.equalsIgnoreCase(PrimeBrokerName_PdfVersion) && ClientName_UspPreviewSubmit.equalsIgnoreCase(ClientName_PdfVersion) && PBContactText_UspPreviewSubmit.equalsIgnoreCase(PBContactText_PdfVersion) && USPRiderID_UspPreviewSubmit.equalsIgnoreCase(USPRiderID_pdfVersion)){
                log.info("All the fields for both USP Rider tab under preview and submit and PDF version is matched");
            }
            else {
                log.info("All the fields for both USP Rider tab under preview and submit and PDF Version is not matched");
                Assert.fail();
            }
        }
        catch(Exception e) {
            log.error("All the fields for both USP Rider tab under preview and submit and PDF Version is not matched");
            Assert.fail();
        }
    }
    public void validateContentUSPRiderTab_PdfVersion(){
        try{
            String PrimeBrokerName_UspPreviewSubmit  = primeBrokerName_UspPreviewSubmit.getText().trim();
            String ClientName_UspPreviewSubmit  = clientName_UspPreviewSubmit.getText().trim();
            String USPRiderID_UspPreviewSubmit  = uspRiderID_UspPreviewSubmit.getText().trim();
            String PBContactText_UspPreviewSubmit  = pbContactText_UspPreviewSubmit.getText().trim();
            withAction().moveToElement(previewAndSubmitButton_pdfVersion).click().build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            viewAsPdfButton_UspPreviewSubmit.waitUntilVisible();
            withAction().moveToElement(viewAsPdfButton_UspPreviewSubmit).click().build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", uspRiderText_pdfVersion);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String PrimeBrokerName_PdfVersion  = primeBrokerName_UspPreviewSubmit.getText().trim();
            String ClientName_PdfVersion  = clientName_UspPreviewSubmit.getText().trim();
            String USPRiderID_pdfVersion  = uspRiderID_UspPreviewSubmit.getText().trim();
            String PBContactText_PdfVersion  = pbContactText_UspPreviewSubmit.getText().trim();
            if (PrimeBrokerName_UspPreviewSubmit.equalsIgnoreCase(PrimeBrokerName_PdfVersion) && ClientName_UspPreviewSubmit.equalsIgnoreCase(ClientName_PdfVersion) && PBContactText_UspPreviewSubmit.equalsIgnoreCase(PBContactText_PdfVersion) && USPRiderID_UspPreviewSubmit.equalsIgnoreCase(USPRiderID_pdfVersion)){
                log.info("All the fields for both USP Rider tab and PDF version is matched");
            }
            else {
                log.info("All the fields for both USP Rider tab under preview and submit and PDF Version is not matched");
                Assert.fail();
            }
        }
        catch(Exception e) {
            log.error("All the fields for both USP Rider tab and PDF Version is not matched");
            Assert.fail();
        }
    }
}
