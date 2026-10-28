package PageObjects.Documents;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@Data
public class DocumentPageObject extends PageObject {
    Actions act = new Actions(getDriver());
    @FindBy(xpath = "//div[text()='Documents']")
    public WebElementFacade title_text;
    //    @FindBy(xpath = "(//*[@class=\"pointer\"])[1]")
    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')]")
    private WebElementFacade menu_btn;
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Document']")
    private WebElementFacade document_tab;

    @FindBy(xpath = "//*[@data-testid='submenu-link-All documents']")
    private WebElementFacade allDocument_tab;
    @FindBy(xpath = "//*[@data-testid='doclist-title']")
    private WebElementFacade document_text;

    @FindBy(xpath = "//button[contains(@class,'link')]")//button[@class = 'link']
    private WebElementFacade DN_Document;  //*[contains(text(),'DN-')]
    @FindBy(xpath = "//*[contains(text(),'4W-')]")
    private WebElementFacade Way_Document;
    @FindBy(xpath = "//button[text()='Bulk Action']")
    private WebElementFacade bulkaction_btn;
    @FindBy(xpath = "//button[text()='+ Create new document']")
    private WebElementFacade createnewdocument_btn;
    @FindBy(xpath = "//div[@class='doc-dt-actions']")
    private WebElementFacade querybuilder_container;
    @FindBy(xpath = "//div[@class='reload-icon-container']")
    private WebElementFacade refreshButton;
    @FindBy(xpath = "//div[@class='kpi-container']//div//h4[text()='Pending Approval']")
    private WebElementFacade pending_approval_container;
    @FindBy(xpath = "//input[@placeholder='Search with document & version ID']")
    private WebElementFacade search_documentandversionid;

    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentId' or text()='Document ID']//input")
    private WebElementFacade search_documentID;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentVersionId' or text()='Document version ID']//input")
    private WebElementFacade search_versionID;
    //  @FindBy(xpath = "//input[@placeholder='Status']")
//  private WebElementFacade filter_status;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-allowedCurrencies' or text()='Allowed currencies']//input")
    private WebElementFacade filter_allowedcurrency;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentType' or text()='Document type']//input")
    private WebElementFacade filter_documenttype;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-initiator' or text()='Initiator']//input")
    private WebElementFacade filter_documentinitiator;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-status' or descendant::span[contains(text(),'Document status')]]//input")
    private WebElementFacade filter_document_status;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentAction' or text()='Document action']//input")
    private WebElementFacade filter_documentactions;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentId' or text()='Document ID']")
    private WebElementFacade document_id_col;

    @FindBy(xpath = "//tr[1]//td[1]")
    private WebElementFacade searched_document_id;

    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-documentVersionId' or text()='Document version ID']")
    private WebElementFacade version_id_col;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentStatus' or descendant::span[contains(text(), 'Document status')]]")
    private WebElementFacade documentstatus_col;

    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-track' or text()='Track']")
    private WebElementFacade track_col;
    @FindBy(xpath = "//tr/th[@data-testid='doc-table-th-action' or text()='Action']")
    private WebElementFacade action_col;

    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade documentedit_btn;
    @FindBy(xpath = "//td//button[text()='Track']")
    private WebElementFacade documenttrack_btn;
    @FindBy(xpath = "//button//img[@alt='Approve']")
    private WebElementFacade documentapprove_btn;
    @FindBy(xpath = "//button//img[@alt='Reject']")
    private WebElementFacade documentreject_btn;
    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    private WebElementFacade documentcancel_btn;
    @FindBy(xpath = "//button//img[@alt='Compare']")
    private WebElementFacade documentcompare_btn;
    @FindBy(xpath = "//button//img[@alt='Terminate']")
    private WebElementFacade documentterminate_btn;
    @FindBy(xpath = "//button[@class=\"download-container \"]")
    private WebElementFacade documentdownload_btn;
    @FindBy(xpath = "//button[@aria-label='Delete']//img[@alt='Delete']")
    private List<WebElementFacade> Documentdelete_btn;
    @FindBy(xpath = "//div[@class='download-container']")
    private WebElementFacade dashboardDownload_btn;

    @FindBy(xpath = "//h2//p")
    private WebElementFacade confirmation_pop_up_title;
    @FindBy(xpath = "//div//label[text()='Current Version ID']")
    private WebElementFacade confirmation_pop_up_documentversionid;
    @FindBy(xpath = "//div//label[text()='Type']")
    private WebElementFacade confirmation_pop_up_documenttype;
    @FindBy(xpath = "//div//label[text()='Action type']//following::input")
    private WebElementFacade confirmation_pop_up_actiontype;
    @FindBy(xpath = "//div//label[text()='Approval group']//following::input")
    private WebElementFacade confirmation_pop_up_approvalgroup;
    @FindBy(xpath = "//div[@data-testid='acting-as-section']//div[contains(@class,'select-acting-as')]//input")
    private WebElementFacade confirmation_pop_up_actingas;
    @FindBy(xpath = "//div[@data-testid='acting-as-section']//div[contains(@class,'select-acting-as')]")
    private WebElementFacade actingAs_selectContainer;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade confirmation_pop_up_cancel_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade confirmation_pop_up_submit_btn;
    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade confirmation_pop_up_approve_btn;
    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade confirmation_pop_up_reject_btn;
    @FindBy(xpath = "//span[text()='Messages']")
    private WebElementFacade notification_icon;
    @FindBy(xpath = "//span[text()='Messages']")
    private WebElementFacade remove_Filter;
    @FindBy(xpath = "(//button[@title='Clear'])[1]")
    private WebElementFacade clear_Filter;

    @FindBy(xpath = "//div[text()='Document History']")
    private WebElementFacade track_document_history_txt;
    //    @FindBy(xpath = "//img[@alt='compare']")
//    private WebElementFacade document_compare;
    @FindBy(xpath = "//img[@alt='Copy']")
    private WebElementFacade document_copy;
    @FindBy(xpath = "//div[@class='paginate-wrapper']")
    private WebElementFacade pagination_container;
    @FindBy(xpath = "//div[@class='icon-wrapper']")
    private WebElementFacade icon_container;


    @FindBy(xpath = "//div[text()='Confirmation']")
    private WebElementFacade msg_confirm_delete_document;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='No']")
    private WebElementFacade NO_Btn_confirm_delete_document;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade YES_Btn_confirm_delete_document;

    @FindBy(xpath = "//div//label[text()='Version Compare']")
    private WebElementFacade comparescreen_title;
    @FindBy(xpath = "//div[@class='preview-container']//span[text()='Enforced version']")
    private WebElementFacade comparescreen_enforcedversion_title;
    @FindBy(xpath = "//div[@class='preview-container']//span[text()='Current version']")
    private WebElementFacade comparescreen_currentversion_title;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade track_screen_norecordfound;
    @FindBy(xpath = "//div[@class='detail-main-container']")
    private WebElementFacade trackRecordfound;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade track_screen_close_btn;
    @FindBy(xpath = "//div[@role='alert']//div[text()='Workflow does not exist for this document version']")
    private WebElementFacade track_screen_notfound_alert;
    @FindBy(xpath = "//div[text()='Proprietary and Confidential']")
    private WebElementFacade bottomtext;
    @FindBy(xpath = "//div[text()='Dashboard']")
    private WebElementFacade Dashboard;
    @FindBy(xpath = "//div[@class='environment flex qa']")
    private WebElementFacade enviroment;
    @FindBy(xpath = "//span[@class=\"help-text\"]")
    private WebElementFacade help;
    @FindBy(xpath = "//li[text()='About OSTTRA']")
    private WebElementFacade aboutosttra;
    @FindBy(xpath = "//a[text()='read more']")
    private WebElementFacade aboutpage;
    @FindBy(xpath = "//a[text()='Terms of Use']")
    private WebElementFacade aboutpageterms;
    @FindBy(xpath = "//p[text()='Customer support']")
    private WebElementFacade aboutpagesupport;
    @FindBy(xpath = "(//div[@class='list'])[1]")
    private WebElementFacade notification_message;
    @FindBy(xpath = "//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath = "//div//button[text()='Submit']")
    private WebElementFacade submit_button;
    @FindBy(xpath = "//button[text()='Approval Workflow']")//button[text()='Approval Workflow for Document Framework']
    private WebElementFacade ApprovalWorkflowTab;
    @FindBy(xpath = "//button[text()='Approval Workflow for Document Framework']")
    private WebElementFacade ApprovalWorkflowTabDF;
    @FindBy(xpath = "//label[@class='csm_checkbox']/input")
    private WebElementFacade ShowLatestVersion;
    @FindBy(xpath = "//h4[text()='Limit Scope']/following-sibling::div[contains(@class, 'btn-clear')]")
    private WebElementFacade clear_btn_AdFiler;
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupAndTemplate_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Document templates']")
    private WebElementFacade document_template_tab;
    @FindBy(xpath = "//span[normalize-space()='Initiator']")
    private WebElementFacade initiatorHeading;
    @FindBy(xpath = "//span[normalize-space()='Initiator']/following-sibling::p")
    private WebElementFacade initiatorLei;
    @FindBy(xpath = "//p[@data-testid='view-all-link']")
    private WebElementFacade viewAllNotifications_link;
    @FindBy(xpath = "//button[normalize-space()='Set Configuration']")
    private WebElementFacade setConfiguration_btn;
    @FindBy(xpath = "//div[@class='btn-content']//button[contains(@class,'primary-button')]")
    private WebElementFacade notificationConfig_saveBtn;
    @FindBy(xpath = "//div[@data-testid='confirmation-popup-heading']")
    private WebElementFacade unsupportedFuncPopupHeading;
    @FindBy(xpath = "//p[contains(@data-testid, 'confirmation-popup-message')]")
    private WebElementFacade unsupportedFuncPopupMessage;
    @FindBy(xpath = "//label[@class='checkbox-label' and @data-testid='latest-version-label']//input[@type='checkbox']")
    private WebElementFacade latestVersionCheckboxInput;
    @FindBy(xpath = "//label[@class='checkbox-label' and @data-testid='latest-version-label']")
    private WebElementFacade latestVersionCheckboxLabel;

    public void checkTitle() {
        try {
            withAction().pause(Duration.ofSeconds(7)).build().perform();
            title_text.waitUntilVisible();
        } catch (Exception e) {
            log.error("Unable to check title-->" + e);
            Assert.fail();
        }
    }

    public void clickMenuButton() {
        try {
            if (document_tab.isVisible()) {
                log.info("Sidebar already open");
                return;
            }
            menu_btn.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to click Menu button-->" + e);
            Assert.fail();
        }
    }

    public void clickDocumentTab() {
        try {
            clickMenuButton();
            
            // Check if Document category is already expanded (indicated by arrow-up)
            if (!findAll(By.xpath("//div[contains(.,'Document')]/following-sibling::*[local-name()='svg' and @data-testid='arrow-up']")).isEmpty() || 
                allDocument_tab.isVisible()) {
                log.info("Document category already expanded");
            } else {
                document_tab.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            
            allDocument_tab.waitUntilClickable();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", allDocument_tab);
            withAction().pause(Duration.ofSeconds(3)).build().perform(); // wait for page transition
        } catch (Exception e) {
            log.error("Unable to click document tab-->" + e);
            Assert.fail();
        }
    }

    public void clickDocumentTabAgain() {
        try {
            if (!findAll(By.xpath("//div[contains(.,'Document')]/following-sibling::*[local-name()='svg' and @data-testid='arrow-up']")).isEmpty() ||
                allDocument_tab.isCurrentlyVisible()) {
                log.info("Document category already expanded");
            } else {
                document_tab.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }

            allDocument_tab.waitUntilClickable();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", allDocument_tab);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("Unable to click document tab-->" + e);
            Assert.fail();
        }
    }

    public void clickDocumentDownloadButton() {
        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", documentdownload_btn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            try {
                documentdownload_btn.waitUntilVisible().click();
            } catch (Exception e) {
                log.warn("Standard click failed for download button, trying JS click.");
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", documentdownload_btn);
            }
        } catch (Exception e) {
            log.error("Unable to click download button-->" + e);
            Assert.fail();
        }
    }

    public void validateDocumentDownload() {
        try {
            long startTime = Instant.now().toEpochMilli();
            act.pause(Duration.ofSeconds(8)).build().perform();
            String folderName = System.getProperty("user.home") + "/Downloads/";
            File[] listOfFiles;
            String fileName;
            boolean fileDownloaded = false;
            // Time to wait for download to finish
            long waitTime = Instant.now().toEpochMilli();
            // while current time is less than wait time
            if (startTime < waitTime) {
                // get all the files of the folder
                listOfFiles = new File(folderName).listFiles();
                assert listOfFiles != null;
                for (File file : listOfFiles) {
                    // get the name of the current file
                    fileName = file.getName();
                    if (file.lastModified() > startTime && fileName.contains("4W-")) {
                        // File Found
                        System.out.println("file found " + fileName);
                        fileDownloaded = true;
                        break;
                    } else if (file.lastModified() > startTime && fileName.contains("document-framework")) {
                        // File Found
                        System.out.println("file found " + fileName);
                        fileDownloaded = true;
                        break;
                    } else if (file.lastModified() > startTime && fileName.contains("document-list")) {
                        // File Found
                        System.out.println("file found " + fileName);
                        fileDownloaded = true;
                        break;
                    }
                }
                if (fileDownloaded)
                    System.out.println("file is downloaded successfully");
            }
        } catch (Exception e) {
            System.out.println("File download failed " + e);
        }
    }

    public void verifyDocumentText() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(document_text.isVisible());
        log.info("User is navigated to document page");
    }

    public void checkifBasicfilters() {
        try {
            Assert.assertTrue(search_documentID.isVisible());
            Assert.assertTrue(search_versionID.isVisible());
            Assert.assertTrue(filter_allowedcurrency.isVisible());
            Assert.assertTrue(filter_documenttype.isVisible());
            Assert.assertTrue(filter_documentinitiator.isVisible());
            Assert.assertTrue(filter_document_status.isVisible());
            Assert.assertTrue(filter_documentactions.isVisible());
        } catch (AssertionError e) {
            log.error("Filters are missing" + e);
            Assert.fail();
        }

    }

    public void checkifquerybuilder() {
        try {
            Assert.assertTrue(querybuilder_container.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (AssertionError e) {
            log.error("Query builder has some elements missing" + e);
            Assert.fail();
        }
    }

    public void checkifallcolumns() {
        try {
            Assert.assertTrue(document_id_col.isVisible());
            Assert.assertTrue(version_id_col.isVisible());
            Assert.assertTrue(documentstatus_col.isVisible());
            Assert.assertTrue(track_col.isVisible());
            Assert.assertTrue(action_col.isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (AssertionError e) {
            log.error("Unable to verify all the elements");
            Assert.fail();
        }
    }

    public void check_if_filterStatus_and_type(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(filter_document_status).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("filter"), Keys.ARROW_DOWN, Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        } catch (Exception e) {
            log.error("Unable to set the status filter" + e);
            Assert.fail();
        }
    }

    public void check_confirmation_to_delete() {
        try {
            msg_confirm_delete_document.isVisible();
            NO_Btn_confirm_delete_document.isVisible();
            YES_Btn_confirm_delete_document.isVisible();
        } catch (Exception e) {
            log.error("Unable to delete the document");
            Assert.fail();
        }
    }

    public void search_document(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(search_documentID).click().sendKeys(dataTable.get("document ID")).pause(Duration.ofSeconds(10)).build().perform();
        } catch (Exception e) {
            log.error("Unable to search the document ID" + e);
            Assert.fail();
        }
    }

    public void search_document_using_versionid(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(search_versionID).click().sendKeys(dataTable.get("document version ID")).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to search the document ID" + e);
            Assert.fail();
        }
    }

    public void confirmation_popup_actingas(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        try {
            String actingAsValue = null;
            for (String key : dataTable_map.keySet()) {
                if (key.trim().equalsIgnoreCase("acting as")) {
                    actingAsValue = dataTable_map.get(key);
                    break;
                }
            }
            if (actingAsValue == null) {
                actingAsValue = "";
            }

            // Wait for the modal to fully render
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // 1. Wait for the hidden input to be present
            confirmation_pop_up_actingas.waitUntilPresent();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", confirmation_pop_up_actingas);

            // 2. Click the input directly, clear it, type, wait for the list to filter, and press ENTER
            withAction().moveToElement(confirmation_pop_up_actingas).click()
                    .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                    .pause(Duration.ofMillis(500))
                    .sendKeys(actingAsValue)
                    .pause(Duration.ofSeconds(2)) // Crucial wait for the React dropdown list to filter
                    .sendKeys(Keys.ENTER)
                    .build().perform();

            log.info("Successfully selected Acting As in Terminate popup: " + actingAsValue);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

        } catch (Exception e) {
            log.error("Unable to select acting as: " + e.getMessage(), e);
            Assert.fail("Failed to select Acting As in the Terminate popup: " + e.getMessage());
        }
    }

    public void confirmation_popup_Approval_Group(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            confirmation_pop_up_approvalgroup.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalgroup).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalgroup).click().sendKeys(dataTable.get("Approval group")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            confirmation_pop_up_approve_btn.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Clicked on approve button");
        } catch (Exception e) {
            log.error("Unable to select Approval Group");
            Assert.fail();
        }
    }

    public void confirmation_popup_actiontype(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            confirmation_pop_up_actiontype.clear();
            withAction().moveToElement(confirmation_pop_up_actiontype).click().sendKeys(dataTable.get("action type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to select action type");
            Assert.fail();
        }
    }

    public void validate_track_screen() {
        try {
            if (track_screen_notfound_alert.isVisible()) {
                Assert.assertTrue(track_screen_norecordfound.isVisible());
            } else if (track_screen_norecordfound.isVisible()) {
                Assert.assertTrue(trackRecordfound.isVisible());
            }
            Assert.assertTrue(track_screen_close_btn.isVisible());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Validated the track screen successfully");
        } catch (Exception e) {
            log.error("Unable to validate the track screen" + e);
            Assert.fail();
        }
    }

    public void openaboutosttra() {
        help.waitUntilVisible().click();
        aboutosttra.waitUntilVisible().click();
    }

    public void click_help() {
        help.waitUntilVisible().click();
    }


//    public void selectApprovalgroup_approve(DataTable table){
//        List<Map<String, String>> data = table.asMaps(String.class, String.class);
//        Map<String,String> dataTable_map= data.get(0);
//        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
//        try {
//            Assert.assertTrue(select_approvalGroup.isVisible());
//            select_approvalGroup.waitUntilClickable().click();
//            select_approvalGroup.clear();
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            withAction().moveToElement(select_approvalGroup).sendKeys(dataTable.get("Approval Group")).build().perform();
//            withAction().pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
//
//        }
//        catch (Exception e) {
//            log.error("Not able to set the approval group" +e);
//            Assert.fail();
//        }
//    }

    public void selectapprovalgroup_reject(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            confirmation_pop_up_approvalgroup.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalgroup).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(confirmation_pop_up_approvalgroup).click().sendKeys(dataTable.get("Approval group")).build().perform();
            withAction().pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            confirmation_pop_up_reject_btn.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Clicked on reject button");
        } catch (Exception e) {
            log.error("Not able to set the approval group" + e);
            Assert.fail();
        }
    }

    public void clickNotification_bell() {
        notification_icon.waitUntilVisible();
        notification_icon.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public boolean notificationDocumentTerminated_dialogueBox() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        return notification_message.getText().contains("Document Terminated Notification");
    }

    public boolean notificationDocumentRejected_dialogueBox() {
        return notification_message.getText().contains("Document Rejected Notification");
    }

    public boolean validateLimitValuesInPdfTable(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String xpathExpression = "//table[contains(@class, 'csm_standard_table')]//tbody/tr/td[2]";
        for (Map<String, String> row : data) {
            String expectedLimit = row.get("limit value");
            if (expectedLimit == null) continue;
            try {
                WebElement limitElement = getDriver().findElement(By.xpath(xpathExpression));
                getJavascriptExecutorFacade().executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        limitElement
                );
                String actualValue = limitElement.getText().trim();
                String cleanExpected = expectedLimit.trim();
                if (actualValue.equals(cleanExpected)) {
                    System.out.println("Validation Passed: Found " + cleanExpected);
                } else {
                    System.out.println("Validation Failed. Expected: [" + cleanExpected + "] but found: [" + actualValue + "]");
                    overallResult = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Could not locate the limit value cell using XPath: " + xpathExpression);
                overallResult = false;
            }
        }
        return overallResult;
    }

    public void validateLimitValue(String expectedFormattedValue) {
        String actualValue = find(By.id("limit-value-select")).getValue();
        if (!actualValue.trim().equalsIgnoreCase(expectedFormattedValue.trim())) {
            throw new AssertionError("Limit Value Formatting Mismatch! " +
                    "\nExpected: " + expectedFormattedValue +
                    "\nActual  : " + actualValue);
        }
    }

    public void validateLimitValueInBulkEdit(String expectedFormattedValue) {
        String xpath = "//table[contains(@class, 'csm_standard_table')]//tr/td[2]/input";
        String actualValue = $(By.xpath(xpath)).getAttribute("value");
        if (!actualValue.trim().equalsIgnoreCase(expectedFormattedValue.trim())) {
            throw new AssertionError("Limit Value Formatting Mismatch! " +
                    "\nExpected: " + expectedFormattedValue +
                    "\nActual  : " + actualValue);
        }
    }

    public void navigateToDocumentTemplateScreen() {
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            navigation_btn.waitUntilClickable().click();
            if (document_template_tab.isVisible()) {
                document_template_tab.waitUntilClickable().click();
            } else {
                groupAndTemplate_tab.waitUntilClickable().click();
                document_template_tab.click();
            }
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Service not found in the navigation menu -->" + e);
            Assert.fail();
        }
    }

    public void validateDocTempNameMaxLength() {

        WebElementFacade input = find(By.xpath("//input[@placeholder='Enter template name']"));
        input.waitUntilVisible();
        input.clear();
        input.sendKeys(RandomStringUtils.randomAlphabetic(256));
        int actualLength = input.getValue().length();
        if (actualLength > 255) {
            throw new AssertionError("Template Name field accepts more than 255 characters.");
        } else {
            log.info("Template Name field correctly restricts input to 255 characters.");
        }
    }

    public boolean validateCalculationTypeInPdfTable(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String xpathExpression = "//table[contains(@class, 'csm_standard_table')]//tbody/tr/td[1]";
        for (Map<String, String> row : data) {
            String expectedLimit = row.get("limit value");
            if (expectedLimit == null) continue;
            try {
                WebElement limitElement = getDriver().findElement(By.xpath(xpathExpression));
                getJavascriptExecutorFacade().executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        limitElement
                );
                String actualValue = limitElement.getText().trim();
                String cleanExpected = expectedLimit.trim();
                if (actualValue.equals(cleanExpected)) {
                    System.out.println("Validation Passed: Found " + cleanExpected);
                } else {
                    System.out.println("Validation Failed. Expected: [" + cleanExpected + "] but found: [" + actualValue + "]");
                    overallResult = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Could not locate the limit value cell using XPath: " + xpathExpression);
                overallResult = false;
            }
        }
        return overallResult;
    }

    public void validateInitiatorDetails(DataTable table) {
        String expectedLei = table.asList().get(0);
        String actualHeading = initiatorHeading.waitUntilVisible().getText().trim();
        if (!actualHeading.equalsIgnoreCase("Initiator")) {
            throw new AssertionError("Initiator heading not displayed correctly.");
        }
        String actualLei = initiatorLei.waitUntilVisible().getText().trim();
        if (!actualLei.equalsIgnoreCase(expectedLei)) {
            throw new AssertionError(
                    "Initiator LEI mismatch. Expected: " + expectedLei + " but found: " + actualLei
            );
        }
    }

    public void clickViewAllNotifications() {
        try {
            viewAllNotifications_link.waitUntilClickable();
            viewAllNotifications_link.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to click 'View all Notifications' link -->" + e);
            Assert.fail();
        }
    }

    public void clickSetConfigurationButton() {
        try {
            setConfiguration_btn.waitUntilClickable();
            setConfiguration_btn.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to click 'Set Configuration' button -->" + e);
            Assert.fail();
        }
    }

    public void selectNotificationConfigValues(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        boolean anyChangeMade = false;

        try {
            for (Map<String, String> row : data) {
                String columnName = row.get("Column Name").trim();
                String desiredValue = row.get("value").trim();
                String lowerColumnName = columnName.toLowerCase();
                String checkboxXpath = "//*[(contains(@class, 'category-name') or contains(@class, 'subcategory-name')) and " +
                        "translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerColumnName + "']" +
                        "/ancestor::tr//td[contains(@class,'inapp-col')]//input[@type='checkbox']";

                WebElementFacade checkbox = find(By.xpath(checkboxXpath));
                checkbox.waitUntilPresent();
                getJavascriptExecutorFacade().executeScript(
                        "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", checkbox);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                boolean isCurrentlySelected = checkbox.isSelected();
                String indeterminateAttr = checkbox.getAttribute("data-indeterminate");
                boolean isIndeterminate = indeterminateAttr != null && indeterminateAttr.equals("true");

                boolean shouldBeSelected = desiredValue.equalsIgnoreCase("selected");

                if (shouldBeSelected && (!isCurrentlySelected || isIndeterminate)) {
                    // If it needs to be selected, but is either unselected or indeterminate, click it.
                    try {
                        checkbox.click();
                    } catch (Exception clickEx) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkbox);
                    }
                    anyChangeMade = true;
                    log.info("Selected checkbox for: " + columnName);
                } else if (!shouldBeSelected && (isCurrentlySelected || isIndeterminate)) {
                    // If it needs to be unselected, but is currently selected or indeterminate, click it.
                    try {
                        checkbox.click();
                    } catch (Exception clickEx) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkbox);
                    }
                    anyChangeMade = true;
                    log.info("Deselected checkbox for: " + columnName);
                } else {
                    log.info("Checkbox for '" + columnName + "' already in desired state (" + desiredValue + "). No action taken.");
                }
            }

            if (anyChangeMade) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                notificationConfig_saveBtn.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                log.info("Notification configuration saved.");
            } else {
                log.info("No changes were made to notification configuration. Skipping Save click.");
            }
        } catch (Exception e) {
            log.error("Unable to select column values on notification config -->" + e);
            Assert.fail("Failed to configure notification settings. " + e.getMessage());
        }
    }

    public void validateUnsupportedFunctionalityPopup(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String expectedHeading = data.get(0).get("Heading").trim();
        String expectedMessage = data.get(0).get("Message").trim();

        // Wait for the popup to render
        unsupportedFuncPopupHeading.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();

        // Extract actual text
        String actualHeading = unsupportedFuncPopupHeading.getText().trim();
        String actualMessage = unsupportedFuncPopupMessage.getText().trim();

        log.info("Validating Popup Heading -> Expected: '{}' | Actual: '{}'", expectedHeading, actualHeading);
        Assert.assertTrue(
                "Popup Heading mismatch. Expected: [" + expectedHeading + "] but found: [" + actualHeading + "]",
                actualHeading.equalsIgnoreCase(expectedHeading)
        );

        log.info("Validating Popup Message -> Expected: '{}' | Actual: '{}'", expectedMessage, actualMessage);
        Assert.assertTrue(
                "Popup Message mismatch. Expected: [" + expectedMessage + "] but found: [" + actualMessage + "]",
                actualMessage.equalsIgnoreCase(expectedMessage)
        );
    }

    public void unselectShowOnlyLatestVersion() {
        try {
            latestVersionCheckboxLabel.withTimeoutOf(Duration.ofSeconds(5)).waitUntilPresent();
            if (latestVersionCheckboxInput.isSelected()) {
                log.info("'Show only latest version' checkbox is currently SELECTED. Unselecting it now.");

                latestVersionCheckboxLabel.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            } else {
                log.info("'Show only latest version' checkbox is already UNSELECTED. Skipping action.");
            }
        } catch (Exception e) {
            log.error("Failed to interact with 'Show only latest version' checkbox: " + e.getMessage());
        }
    }
}


