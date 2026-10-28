package PageObjects.DMS_PHASE2PageObject;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Random;
import java.util.List;



@Slf4j
@Data
public class DMS_2518PageObject extends PageObject {

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organization_filter;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade docType_filter;
    @FindBy(xpath = "//div[text()='Select Leis']")
    private WebElementFacade LEI_filter_CreateNewApprovalMatrix_Screen;
    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgType_filter_CreateNewApprovalMatrix_Screen;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_btn_CreateNewApprovalMatrix_Screen;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn_CreateNewApprovalMatrix_Screen;
    @FindBy(xpath = "//div[text()='Update approval matrix']")
    private WebElementFacade UpdateApprovalMatrix_text;
    @FindBy(xpath = "//td[text()='Apply USP Rider']")
    private WebElementFacade ApplyUSPRider_UnderDocumentAction;
    @FindBy(xpath = "//input[@placeholder='Select Doc type']")
    private WebElementFacade documenttypefilter;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filteredActiontype;
    @FindBy(xpath = "//label[text()='Action type']/following::input")
    private WebElementFacade Actingtype_Input_ONEDIT_POPUP;


    @FindBy(xpath = "//div[text()='Available USP Rider document']")
    private WebElementFacade Available_USP_Rider_Document_text;
    @FindBy(xpath = "//div[text()='Available USP Rider document']/following::input[@name='checkbox']")
    private WebElementFacade CheckBox_For_Available_USP_Rider;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElementFacade Successmessage;
    @FindBy(xpath = "//div[@class='content-label']")
    private WebElementFacade Document_Version_ID_text;
    @FindBy(xpath = "//button[text()='Submit for approval']")
    private WebElementFacade Submit_forApproval_Button;
    @FindBy(xpath = "//span[text()='approved']")
    private WebElementFacade approvedstatus_for_ApprovedDocument;
    @FindBy(xpath = "//th[text()='Document Version ID']//input")
    private WebElementFacade SearchBox_of_DocumentVersionID;
    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade EditButton;
    @FindBy(xpath = "//div[text()='USP Rider document not available']")
    private WebElementFacade USP_RiderDocument_Not_Available_text;


    public void randomllySelectOrganizationName() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
                Random random = new Random();
                int randomNumber;
                randomNumber = random.nextInt(10) + 1;
                log.info("randomNumber" + randomNumber);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                organization_filter.waitUntilVisible().isVisible();
                withAction().moveToElement(organization_filter).click().build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                for (int i = 1; i < randomNumber; i++) {
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
                }
                withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Organization  on create new approval matrix" +e);
            Assert.fail();
        }
    }

    public void randomllySelectDocType() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(2) + 1;
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            docType_filter.waitUntilVisible().isVisible();
            withAction().moveToElement(docType_filter).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Doctype on Create new approval matrix  " +e);
            Assert.fail();
        }
    }

    public void randomllySelectLEIs() {
        try {

            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(11) + 1;
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(LEI_filter_CreateNewApprovalMatrix_Screen).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error(" Unable to Select Select LEI's  " + e);
            Assert.fail();
        }
    }

    public void randomllySelectORGType() {
        try {

            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(11) + 1;
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(orgType_filter_CreateNewApprovalMatrix_Screen).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select LEIs on Create new approval matrix  " +e);
            Assert.fail();
        }
    }

    public void randomllySelectOrgtype() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(8) + 1;
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            orgType_filter_CreateNewApprovalMatrix_Screen.waitUntilVisible().isVisible();
            withAction().moveToElement(orgType_filter_CreateNewApprovalMatrix_Screen).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Org type on Create new approval matrix  " +e);
            Assert.fail();
        }
    }

    public void EnterinputforDoctype(){
        try {
            Assert.assertTrue(documenttypefilter.isVisible());
            withAction().moveToElement(documenttypefilter).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Acting as-->" + e);
            Assert.fail();
        }
    }

    public void filteredActiontypeforEditPOPup(List<String> ActiontypeList){
        try {
            for (int begin=1;begin<ActiontypeList.size();begin++)
            {
                Actingtype_Input_ONEDIT_POPUP.waitUntilClickable().click();
                Actingtype_Input_ONEDIT_POPUP.type(ActiontypeList.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(ActiontypeList.get(begin),filteredActiontype.getText());
                Actingtype_Input_ONEDIT_POPUP.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found filtered item for Action Type POPUP-->" + e);
            Assert.fail();
        }
    }

    public void performchangesONUSPRidertab(){
        try {
            if(Available_USP_Rider_Document_text.isVisible() && CheckBox_For_Available_USP_Rider.isVisible()){
                if (!CheckBox_For_Available_USP_Rider.isSelected()){
                    CheckBox_For_Available_USP_Rider.click();
                    log.info("USP is is Added to Document");
                }else {
                    CheckBox_For_Available_USP_Rider.click();
                    log.info("USP Rider is removed from Document");
                }
                String versionID= Document_Version_ID_text.getText();
                Submit_forApproval_Button.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(Successmessage.getText().contains("USP Rider for document saved successfully"));
                Assert.assertTrue(Successmessage.getText().contains("Document is Approved"));
//                Assert.assertTrue(Successmessage.getText().contains("USP Rider template created"));
                getDriver().navigate().back();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                SearchBox_of_DocumentVersionID.waitUntilVisible();
                withAction().moveToElement(SearchBox_of_DocumentVersionID).click().sendKeys(versionID).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                Assert.assertTrue(approvedstatus_for_ApprovedDocument.isVisible());
            } else {
                Assert.assertTrue(USP_RiderDocument_Not_Available_text.isVisible());
                log.info("Document doesn't have any USP Rider to Update");
            }
        }catch (Exception e){
            log.error("Unable to Update Available USP Rider " +e);
            Assert.fail();
        }
    }

}
