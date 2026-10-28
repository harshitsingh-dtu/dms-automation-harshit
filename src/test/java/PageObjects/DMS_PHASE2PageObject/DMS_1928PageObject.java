package PageObjects.DMS_PHASE2PageObject;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
public class DMS_1928PageObject extends PageObject {


    @FindBy(xpath = "//div[normalize-space()='Document']")
    private WebElementFacade document_tab;
    @FindBy(xpath = "//div[text()='Approval request']")
    private WebElementFacade ApprovalAccessRequestTab;
    @FindBy(xpath = "//div[text()='Documents access request']")
    private WebElementFacade DocumentAccessRequestTab;
    @FindBy(xpath = "//input[@placeholder='Search by request ID']")
    private WebElementFacade SearchForRequestID;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade NORecordFound_text;
    @FindBy(xpath = "//input[@placeholder='Select status']")
    private WebElementFacade SelectStatus;
    @FindBy(xpath = "//button[text()='View Details']")
    private WebElementFacade ViewDetailsButton;
    @FindBy(xpath = "//button[text()='Approve/Reject']")
    private WebElementFacade ApproveRejectButton;
    @FindBy(xpath = "//strong[text()='Approval access request']")
    private WebElementFacade ApprovalAccessRequest_text;
    @FindBy(xpath = "//strong[text()='Documents access request']")
    private WebElementFacade DocumentsAccessRequest_text;
    @FindBy(xpath = "//label[text()='Details of approval request']")
    private WebElementFacade Detailsofapprovalrequest_Text;
    @FindBy(xpath = "//label[text()='Details of access request']")
    private WebElementFacade DetailsofAccessRequest_text;
    //Details of approval request screen
    @FindBy(xpath = "//div[text()='Status']")
    private WebElementFacade Status_text;
    @FindBy(xpath = "//div[text()='PENDING']")
    private WebElementFacade PendingStatus_text;
    @FindBy(xpath = "//div[text()='APPROVED']")
    private WebElementFacade ApprovedStatus_text;
    @FindBy(xpath = "//div[text()='REJECTED']")
    private WebElementFacade RejectedStatus_text;
    @FindBy(xpath = "//div[text()='Requested ID']")
    private WebElementFacade RequestedID_text;
    @FindBy(xpath = "//div[text()='Requested ID']//following-sibling::div[@class='info-label']")
    private WebElementFacade RequestID;
    @FindBy(xpath = "//div[text()='Requested type']")
    private WebElementFacade Requestedtype_text;
    @FindBy(xpath = "//div[text()='Doc type']")
    private WebElementFacade Doctype_text;
    @FindBy(xpath = "//div[text()='Requested by']")
    private WebElementFacade Requestedby_text;
    @FindBy(xpath = "//div[text()='Requested on']")
    private WebElementFacade Requestedon_text;
    @FindBy(xpath = "//label[text()='Request document details']")
    private WebElementFacade Requestdocumentdetails_text;
    @FindBy(xpath = "//div[text()='Document type']")
    private WebElementFacade Documenttype_text;
    @FindBy(xpath = "//div[text()='Acting as']")
    private WebElementFacade Actingas_text;
    @FindBy(xpath = "//div[text()='Allowed currencies']")
    private WebElementFacade Allowedcurrencies_text;
    @FindBy(xpath = "//div[text()='Select parties']")
    private WebElementFacade Selectparties_text;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade Closebutton;
    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade RejectButton;
    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade ApproveButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade CancelButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElementFacade MessageforUpdateStatus;
    @FindBy(xpath = "//span[text()='APPROVED']")
    private WebElementFacade ApprovedStatus;
    @FindBy(xpath = "//span[text()='REJECTED']")
    private WebElementFacade RejectedStatus;

    @FindBy(xpath = "//div[@class='paginator']")
    private WebElementFacade pagination_container;
    @FindBy(xpath = "//span[text()='Showing page ']")
    private WebElementFacade showing_page_text;
    @FindBy(xpath = "//input[@class='page-number']")
    private WebElementFacade showing_CurrentPagenumber;
    @FindBy(xpath = "//span[@class='total-page']")
    private WebElementFacade total_pageNumber;
    @FindBy(xpath = "//span[text()=' Records per page ']")
    private WebElementFacade records_per_page_text;
    @FindBy(xpath = "//select[@class='page-row-size']")
    private WebElementFacade records_per_page_value;
    @FindBy(xpath = "//span[text()='Total record count']")
    private WebElementFacade Total_record_count_text;
    @FindBy(xpath = "//span[@class='page-size-num']")
    private WebElementFacade current_record_page_value;
    @FindBy(xpath ="//div[@class='btn-container']//button[1]")
    private WebElementFacade previous_page_button;
    @FindBy(xpath ="//div[@class='btn-container']//button[2]")
    private WebElementFacade next_page_button;
    @FindBy(xpath = "//tr")
    private WebElementFacade NoofRecordOnPage;
    @FindBy(xpath = "//option[text()='10']")
    private WebElementFacade onezerorecordperpage;
    @FindBy(xpath = "//option[text()='25']")
    private WebElementFacade twofiverecordperpage;
    @FindBy(xpath = "//option[text()='50']")
    private WebElementFacade fivezerorecordperpage;
    @FindBy(xpath = "//option[text()='100']")
    private WebElementFacade onezerozerorecordperpage;


    public void NavigateToApprovalAccessRequestTab(){
        try{
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            document_tab.waitUntilVisible().click();
            ApprovalAccessRequestTab.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            ApprovalAccessRequest_text.isVisible();
        }catch (Exception e){
            log.error("Unable to click Approval Access Request Tab-->"+e);
            Assert.fail();
        }
    }
    public void NavigateToDocumentAccessRequestTab(){
        try{
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            if (!DocumentAccessRequestTab.isVisible()) {
                document_tab.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            DocumentAccessRequestTab.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            DocumentsAccessRequest_text.isVisible();
        }catch (Exception e){
            log.error("Unable to click Document Access Request Tab-->"+e);
            Assert.fail();
        }
    }

    public void SearchForRequestID(List<String> RequestId){
        try {
            for (int begin=1;begin<RequestId.size();begin++)
            {
                SearchForRequestID.waitUntilClickable().click();
                SearchForRequestID.type(RequestId.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                WebElement searchedID = find(By.xpath("//tr//td[text()='"+RequestId.get(begin)+"']"));
                Assert.assertEquals(RequestId.get(begin),searchedID.getText());
                SearchForRequestID.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found searched Data-->" + e);
            Assert.fail();
        }
    }

    public void ClickonRespectivebutton(){
        if (ViewDetailsButton.isVisible()){
            ViewDetailsButton.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Detailsofapprovalrequest_Text.isVisible();
        } else if (ApproveRejectButton.isVisible()) {
            ApproveRejectButton.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Detailsofapprovalrequest_Text.isVisible();
        }
    }

    public void Validateinformation(){
        try {
              if (PendingStatus_text.isVisible()){
                 withAction().pause(Duration.ofSeconds(3)).build().perform();
                 Assert.assertTrue(RejectButton.isVisible());
                 Assert.assertTrue(ApproveButton.isVisible());
                 Assert.assertTrue(CancelButton.isVisible());
              } else if (ApprovedStatus_text.isVisible() || RejectedStatus_text.isVisible()) {
                  withAction().pause(Duration.ofSeconds(4)).build().perform();
                  Assert.assertTrue(Closebutton.isVisible());
//              } else if (RejectedStatus_text.isVisible()) {
//                   withAction().pause(Duration.ofSeconds(4)).build().perform();
//                   Assert.assertTrue(Closebutton.isVisible());

              }
        } catch (Exception e) {
            log.error("Unable to found correct information for assigned Status-->" + e);
            Assert.fail();
        }
    }


        public void SelectStatusAndValidatetheButton(List<String> Status){
        try {
            for (int begin=1;begin<Status.size();begin++)
            {
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                SelectStatus.waitUntilClickable().click();
                SelectStatus.type(Status.get(begin));
                withAction().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String Statusvalue = SelectStatus.getAttribute("value");
                switch(Statusvalue){
                    case "Pending":
                        withAction().pause(Duration.ofSeconds(4)).build().perform();
                        Assert.assertTrue(ApproveRejectButton.isVisible());
                        break;
                    case "Approved":
                    case "Rejected":
                        withAction().pause(Duration.ofSeconds(4)).build().perform();
                        Assert.assertTrue(ViewDetailsButton.isVisible());
                        break;
                }
//                SelectStatus.clear();
                withAction().moveToElement(SelectStatus).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to validate information for Respective Status-->" + e);
            Assert.fail();
        }
    }


    public void SelectStatus(List<String> Status){
        try {
            for (int begin=1;begin<Status.size();begin++)
            {
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                SelectStatus.waitUntilClickable().click();
                SelectStatus.type(Status.get(begin));
                withAction().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                }
        } catch (Exception e) {
            log.error("Unable to select Status-->" + e);
            Assert.fail();
        }
    }

//    public void CheckApprovedStatusForRequestID(List<String> RequestId){
//        try {
//            for (int begin=1;begin<RequestId.size();begin++)
//            {
//                SearchForRequestID.waitUntilClickable().click();
//                SearchForRequestID.type(RequestId.get(begin));
//                withAction().pause(Duration.ofSeconds(3)).build().perform();
//                WebElement searchedID = find(By.xpath("//tr//td[text()='"+RequestId.get(begin)+"']"));
//                Assert.assertEquals(RequestId.get(begin),searchedID.getText());
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//                Assert.assertTrue(ApprovedStatus.isVisible());
//                SearchForRequestID.clear();
//            }
//        } catch (Exception e) {
//            log.error("Unable to found Approved Status for Searched RequestID-->" + e);
//            Assert.fail();
//        }
//    }

//    public void CheckRejectedStatusForRequestID(List<String> RequestId){
//        try {
//            for (int begin=1;begin<RequestId.size();begin++)
//            {
//                SearchForRequestID.waitUntilClickable().click();
//                SearchForRequestID.type(RequestId.get(begin));
//                withAction().pause(Duration.ofSeconds(3)).build().perform();
//                WebElement searchedID = find(By.xpath("//tr//td[text()='"+RequestId.get(begin)+"']"));
//                Assert.assertEquals(RequestId.get(begin),searchedID.getText());
//                withAction().pause(Duration.ofSeconds(2)).build().perform();
//                Assert.assertTrue(RejectedStatus.isVisible());
//                SearchForRequestID.clear();
//            }
//        } catch (Exception e) {
//            log.error("Unable to found Rejected Status for Searched RequestID-->" + e);
//            Assert.fail();
//        }
//    }

    public void CheckNextPagebutton(){
        try {
            String pageNumberBeforeChangePage = showing_CurrentPagenumber.getAttribute("value");
            Assert.assertTrue(next_page_button.isVisible());
            if (next_page_button.isEnabled()) {
                next_page_button.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String pageNumberAfterChangePage = showing_CurrentPagenumber.getAttribute("value");
                Assert.assertNotEquals(pageNumberBeforeChangePage, pageNumberAfterChangePage);
            }
            log.info("Next Button is Disabled so Not able to click on it");
        }catch (Exception e){
            log.error("Next page Button is functioning Properly" +e);
            Assert.fail();
        }
    }

    public void CheckPreviousPagebutton(){
        try {
            String pageNumberBeforeChangePage = showing_CurrentPagenumber.getAttribute("value");
            Assert.assertTrue(previous_page_button.isVisible());
            if (previous_page_button.isEnabled()) {
                previous_page_button.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String pageNumberAfterChangePage = showing_CurrentPagenumber.getAttribute("value");
                Assert.assertNotEquals(pageNumberBeforeChangePage, pageNumberAfterChangePage);
            }
            log.info("Previous Button is Disabled so Not able to click on it");
        }catch (Exception e){
            log.error("Previous page Button is not functioning Properly" +e);
            Assert.fail();
        }
    }

    public void CheckPerpageRecordDropdown(List<String> Record){
        try {
            for (int begin=1;begin<Record.size();begin++) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                WebElement noofrecordDropdown = find(By.xpath("//select[@class='page-row-size']"));
                Select Recordperpage = new Select(noofrecordDropdown);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Recordperpage.selectByValue(""+Record.get(begin)+"");
                withAction().pause(Duration.ofSeconds(7)).build().perform();
                List<WebElementFacade> noofrowonpage = findAll("//tr");
                int noofrecord= noofrowonpage.size() -1;
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (noofrecord == Integer.parseInt(Record.get(begin))){
                    Assert.assertTrue(previous_page_button.isDisabled());
                } else if (noofrecord < Integer.parseInt(Record.get(begin))) {
                    Assert.assertTrue(next_page_button.isDisabled());
                }
            }
        }catch (Exception e){
            log.error("Record per page Dropdown is not working as expected" +e);
            Assert.fail();
        }
    }

    public void RequestAppproved_Successfully(){
//        try {
            ApproveButton.waitUntilVisible().isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String Approve_Reject_requestID = RequestID.getText();
            ApproveButton.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            MessageforUpdateStatus.waitUntilVisible();
            Assert.assertTrue(MessageforUpdateStatus.getText().contains("Document request status updated"));
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            ApprovalAccessRequest_text.waitUntilVisible().isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SearchForRequestID.waitUntilVisible().isVisible();
            withAction().moveToElement(SearchForRequestID).click().sendKeys(Approve_Reject_requestID).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Assert.assertTrue(ApprovedStatus.isVisible());
//        }catch (Exception e){
//            log.error("Unable to get or Check recently Approve Request"  +e);
//            Assert.fail();
//        }
    }

    public void RequestReject_Successfully(){
        try {
            RejectButton.waitUntilVisible().isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String Approve_Reject_requestID = RequestID.getText();
            RejectButton.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(MessageforUpdateStatus.getText().contains("Document request status updated"));
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            ApprovalAccessRequest_text.waitUntilVisible().isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SearchForRequestID.waitUntilVisible().isVisible();
            withAction().moveToElement(SearchForRequestID).click().sendKeys(Approve_Reject_requestID).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Assert.assertTrue(RejectedStatus.isVisible());
        }catch (Exception e){
            log.error("Unable to get or Check recently Reject Request"  +e);
            Assert.fail();
        }
    }


}
