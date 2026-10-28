package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data

public class DMS_1768PageObject extends PageObject {

    @FindBy(xpath = "//div[normalize-space()='Document']")
    private WebElementFacade document_tab;

    @FindBy(xpath = "//div[text()='Documents access request']")
    private WebElementFacade documentsAccessRequest;

    @FindBy(xpath = "//input[@placeholder='Search by request ID']")
    private WebElementFacade search_RequestID;

    @FindBy(xpath = "//input[@placeholder='Select requester']")
    private WebElementFacade select_Requester;

    @FindBy(xpath = "//input[@placeholder='Select requester LEI']")
    private WebElementFacade select_RequesterLEI;

    @FindBy(xpath = "//input[@placeholder='Select reviewer']")
    private WebElementFacade select_Reviewer;

    @FindBy(xpath = "//input[@placeholder='Select reviewer LEI']")
    private WebElementFacade select_ReviewerLEI;

    @FindBy(xpath = "//input[@placeholder='Select doc type']")
    private WebElementFacade select_docType;

    @FindBy(xpath = "//input[@placeholder='Select status']")
    private WebElementFacade select_status;

    @FindBy(xpath = "//button[text()='View Details']")
    private WebElementFacade viewDetails_btn;

    @FindBy(xpath = "//p[text()='Pending']")
    private WebElementFacade pending_text;

    @FindBy(xpath = "//p[text()='Approved']")
    private WebElementFacade approved_text;

    @FindBy(xpath = "//p[text()='Rejected']")
    private WebElementFacade rejected_text;

    @FindBy(xpath = "//tr/td[1]")
    private List<WebElementFacade> requests_ID_list;

    @FindBy(xpath = "//tbody/tr/td[1]")
    private WebElementFacade request_ID_number;

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

    @FindBy(xpath = "//option[text()='10']")
    private WebElementFacade onezerorecordperpage;

    @FindBy(xpath = "//option[text()='25']")
    private WebElementFacade twofiverecordperpage;

    @FindBy(xpath = "//option[text()='50']")
    private WebElementFacade fivezerorecordperpage;

    @FindBy(xpath = "//option[text()='100']")
    private WebElementFacade onezerozerorecordperpage;

    @FindBy(xpath = "//tr/td[8]")
    private List<WebElementFacade> requests_version_ID_list;

    @FindBy(xpath ="//div[@class='profile-icon']")
    private WebElementFacade profileIcon;

    @FindBy(xpath ="//header[@class='pf-header']")
    private WebElementFacade organisationHeader;

    @FindBy(xpath ="//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_documentAccessScreen;


    public void validateColumns(){
        try{
            List<WebElementFacade> infoList = findAll("//thead//tr//th");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){

                Assert.assertTrue(Info_Text.isVisible());
                log.info(Info_Text.getText());

            }
        }
        catch (Exception e){
            log.error("Unable to validate all columns" +e);
            Assert.fail();
        }
    }
    public void selectStatus(List<String> status){
       try {
           for (int begin = 1; begin < status.size(); begin++) {
               select_status.waitUntilClickable();
               withAction().pause(Duration.ofSeconds(1)).build().perform();
               withAction().moveToElement(select_status).click().sendKeys(status.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
               withAction().pause(Duration.ofSeconds(4)).build().perform();
           }
       }
       catch (Exception e){
           log.error("Unable to select status" +e);
           Assert.fail();
       }
    }
    public void verify_request_ID_format(){
        for (int i=0;i<=requests_ID_list.size()-1;i++)
        {
            log.info(requests_ID_list.size() +"<--------");

            if (requests_ID_list.get(i).getText().matches("^[a-zA-Z0-9-]+$")){
                log.info("Request ID is in right format");
            }
            else {
                log.info("Request ID format is wrong ");
                Assert.fail();

            }
        }
    }
    public void search_requestID(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            String Output_RequestID= request_ID_number.getText().trim();
            withAction().moveToElement(search_RequestID).click().sendKeys(dataTable.get("Request ID")).pause(Duration.ofSeconds(1)).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            if(dataTable.get("Request ID").equalsIgnoreCase(Output_RequestID)){
                log.info("Corresponding value is visible on the document access request screen");
                }
        }
        catch (Exception e){
          log.error("Unable to search Request ID" +e);
          Assert.fail();
        }
    }
    public void input_docType(List<String> docType){
        try {
            for (int begin = 1; begin < docType.size(); begin++) {
                select_docType.waitUntilClickable();
                select_docType.clear();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(select_docType).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to select doc type" +e);
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
    public void NavigateToDocumentAccessRequestTab(){
        try{
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (!documentsAccessRequest.isVisible()) {
                document_tab.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            documentsAccessRequest.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            documentsAccessRequest.isVisible();
        }catch (Exception e){
            log.error("Unable to click Document Access Request Tab-->"+e);
            Assert.fail();
        }
    }
    public void checkBlankVersionID_Column(){
        try{
            List<WebElementFacade> infoList = findAll("//tbody//tr//td[8]");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){
                String VersionIDColumn_text = Info_Text.getText();
            if (VersionIDColumn_text == null || VersionIDColumn_text.trim().isEmpty()) {
                System.out.println("Version ID Column data is blank");
            }
            else{
                log.info("Version ID Column data is not blank");
                Assert.fail();
            }
            }
        }
        catch (Exception e){
            log.error("Version ID Column data is not blank");
            Assert.fail();
        }
    }
    public void checkVersionID_Column(){
        try{
            List<WebElementFacade> infoList = findAll("//tbody//tr//td[8]");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){
                String VersionIDColumn_text = Info_Text.getText();
                if (!(VersionIDColumn_text == null)) {
                    System.out.println("Version ID Column data is visible");
                }
                else{
                    log.info("Version ID Column data is blank");
                    Assert.fail();
                }
            }
        }
        catch (Exception e){
            log.error("Version ID Column data is not blank");
            Assert.fail();
        }
    }
    public void verify_version_ID_format(){
        for (int i=0;i<=requests_version_ID_list.size()-1;i++)
        {
            log.info(requests_version_ID_list.size() +"<--------");

            if (requests_version_ID_list.get(i).getText().matches("^[a-zA-Z0-9-]+$")){
                log.info("Version id is in right format");
            }
            else {
                log.info("Version id format is wrong");
                Assert.fail();

            }
        }
    }
    public void checkBlankReviewedBy_Column(){
        try{
            List<WebElementFacade> infoList = findAll("//tbody//tr//td[5]");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){
                String VersionIDColumn_text = Info_Text.getText();
                if (VersionIDColumn_text == null || VersionIDColumn_text.trim().isEmpty()) {
                    System.out.println("Reviewed By Column data is blank");
                }
                else{
                    log.info("Reviewed By Column data is not blank");
                    Assert.fail();
                }
            }
        }
        catch (Exception e){
            log.error("Reviewed By Column data is not blank");
            Assert.fail();
        }
    }
    public void checkReviewedBy_Column(){
        try{
            List<WebElementFacade> infoList = findAll("//tbody//tr//td[5]");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            int rowcount = 1;
            for(WebElementFacade Info_Text : infoList){
                String VersionIDColumn_text = Info_Text.getText();
                if (!(VersionIDColumn_text == null)) {
                    log.info("Reviewed By Column data is visible");
                    Assert.assertTrue(VersionIDColumn_text.matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9.]+$"));
                    log.info("Row value " + rowcount + " is " + VersionIDColumn_text + " and it has correct format");
                }
                else{
                    log.info("Reviewed By Column Data is blank");
                    Assert.fail();
                }
                rowcount++;
            }
        }
        catch (Exception e){
            log.error("Reviewed By Column Data is blank");
            Assert.fail();
        }
    }
    public void selectMultipleRequester(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(2) + 1;
            log.info("randomNumber" + randomNumber);
            select_Requester.waitUntilVisible();
            withAction().moveToElement(select_Requester).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedRequester = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[" + begin + "]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedRequester).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                String SelectedRequester1_text = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[1]")).getText();
                List<WebElementFacade> infoList = findAll("//tbody//tr//td[3]");
                int column_size = infoList.size();
                log.info("column size on screen is :" + column_size);

                if (column_size > 0) {
                    for (WebElementFacade Info_Text : infoList) {
                        String RequestedByColumn_text = Info_Text.getText();
                        if (RequestedByColumn_text.equals(SelectedRequester.getText()) || RequestedByColumn_text.equals(SelectedRequester1_text)) {
                            log.info("Corresponding requesters is present on the listing screen");
                        } else {
                            log.info("Unable to see corresponding requesters on the listing screen");
                            Assert.fail();
                        }
                    }
                }
                else{
                    log.info("No Record Found is present either it could be a bug or test data is not created");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("Unable to see corresponding requesters on the listing screen" +e);
            Assert.fail();
        }
    }
    public void selectMultipleRequesterLEI(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(2) + 1;
            log.info("randomNumber" + randomNumber);
            select_RequesterLEI.waitUntilVisible();
            withAction().moveToElement(select_RequesterLEI).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedRequesterLEI = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[" + begin + "]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedRequesterLEI).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                String SelectedRequesterLEI1_text = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[1]")).getText();
                List<WebElementFacade> infoList = findAll("//tbody//tr//td[4]");
                int column_size = infoList.size();
                log.info("column size on screen is :" + column_size);

                if (column_size > 0) {
                    for (WebElementFacade Info_Text : infoList) {
                        String RequestedByColumn_text = Info_Text.getText();
                        if (RequestedByColumn_text.contains(SelectedRequesterLEI.getText()) || RequestedByColumn_text.contains(SelectedRequesterLEI1_text)) {
                            log.info("Corresponding requesters LEI is present on the listing screen");
                        } else {
                            log.info("Unable to see corresponding requesters LEI on the listing screen");
                            Assert.fail();
                        }
                    }
                }
                else{
                    log.info("No Record Found is present either it could be a bug or test data is not created");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("Unable to see corresponding requesters LEI on the listing screen" +e);
            Assert.fail();
        }
    }
    public void selectMultipleReviewer(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(2) + 1;
            log.info("randomNumber" + randomNumber);
            select_Reviewer.waitUntilVisible();
            withAction().moveToElement(select_Reviewer).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedRequesterLEI = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[" + begin + "]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedRequesterLEI).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                String SelectedRequesterLEI1_text = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[1]")).getText();
                List<WebElementFacade> infoList = findAll("//tbody//tr//td[5]");
                int column_size = infoList.size();
                log.info("column size on screen is :" + column_size);

                if (column_size > 0) {
                    for (WebElementFacade Info_Text : infoList) {
                        String RequestedByColumn_text = Info_Text.getText();
                        if (RequestedByColumn_text.equals(SelectedRequesterLEI.getText()) || RequestedByColumn_text.equals(SelectedRequesterLEI1_text)) {
                            log.info("Corresponding reviewers is present on the listing screen");
                        } else {
                            log.info("Unable to see corresponding reviewers on the listing screen");
                            Assert.fail();
                        }
                    }
                }
                else{
                    log.info("No Record Found is present either it could be a bug or test data is not created");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("Unable to see corresponding reviewers on the listing screen" +e);
            Assert.fail();
        }
    }
    public void selectMultipleReviewerLEI(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(2) + 1;
            log.info("randomNumber" + randomNumber);
            select_ReviewerLEI.waitUntilVisible();
            withAction().moveToElement(select_ReviewerLEI).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedRequesterLEI = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[" + begin + "]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedRequesterLEI).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                String SelectedRequesterLEI1_text = find(By.xpath("(//li[@class='MuiAutocomplete-option'])[1]")).getText();
                List<WebElementFacade> infoList = findAll("//tbody//tr//td[6]");
                int column_size = infoList.size();
                log.info("column size on screen is :" + column_size);

                if (column_size > 0) {
                    for (WebElementFacade Info_Text : infoList) {
                        String RequestedByColumn_text = Info_Text.getText();
                        if (RequestedByColumn_text.contains(SelectedRequesterLEI.getText()) || RequestedByColumn_text.contains(SelectedRequesterLEI1_text)) {
                            log.info("Corresponding reviewers LEI is present on the listing screen");
                        } else {
                            log.info("Unable to see corresponding reviewers LEI on the listing screen");
                            Assert.fail();
                        }
                    }
                }
                else{
                    log.info("No Record Found is present either it could be a bug or test data is not created");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("Unable to see corresponding reviewers LEI on the listing screen" +e);
            Assert.fail();
        }
    }
    public void validateRequesterLEI_column(){
        try{
            profileIcon.click();
            String OrganisationName= organisationHeader.getText();
            log.info("Organisation name is :" +OrganisationName);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            List<WebElementFacade> infoList = findAll("//tbody//tr//td[4]");
            int column_size = infoList.size();
            log.info("column size on screen is :" + column_size);

            for (WebElementFacade Info_Text : infoList) {
                Assert.assertTrue(Info_Text.containsText(OrganisationName));
                log.info("Requests belongs to same organisation");
            }
        }
        catch (Exception e){
            log.error("Requests does not belongs to same organisation");
            Assert.fail();
        }
    }
}
