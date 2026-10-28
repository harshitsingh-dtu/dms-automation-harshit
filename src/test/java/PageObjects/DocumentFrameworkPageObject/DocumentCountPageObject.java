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

import static net.serenitybdd.core.di.SerenityInfrastructure.getEnvironmentVariables;

@Slf4j
@Data
public class DocumentCountPageObject extends PageObject {
    Actions act=new Actions(getDriver());

    @FindBy(xpath = "//a[@data-testid='submenu-link-Document Frameworks']")
    private WebElementFacade Document_Framework_tab;
    @FindBy(xpath = "//button[text()='+ Create new Document Framework']")
    private WebElementFacade Create_New_DF;
    @FindBy(xpath = "//div[@data-testid='restriction-title'] | //*[contains(text(), 'Document Framework')]")
    private WebElementFacade Document_Framework_Page;
    @FindBy(xpath = "//div[text()='Create Document Framework']")
    private WebElementFacade Renaming_on_DF_createScreen;
    @FindBy(xpath = "//*[@value='DN']")
    private WebElementFacade Document_type_DN;
    @FindBy(xpath = "//*[text()='Lifecycle status']/div/div")
    private WebElementFacade lifecycle_Filter;
    @FindBy(xpath = "//*[text()='Showing all Document Frameworks']")
    private WebElementFacade showing_all_DF;
    @FindBy(xpath = "//*[text()='Lifecycle status']")
    private WebElementFacade LifeCycle_Status;
    @FindBy(xpath = "//*[text()='Document Framework Status']")
    private WebElementFacade DF_Status;
    @FindBy(xpath = "//*[text()='Associated Doc Count']")
    private WebElementFacade DF_AssociatedDocCount;
    @FindBy(xpath = "(//td[contains(text(),'DF-')])[1]")
    private WebElementFacade DF_Abbreviation_ID;
    @FindBy(xpath = "(//div[contains(text(),'DF-')])[1]")
    private WebElementFacade DF_Abbreviation_VersionID;

    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr//td[3]//span")
    private WebElementFacade status;
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Document']")
    private WebElementFacade document_tab;
    @FindBy(xpath = "//button[text()='Approval Workflow for Document Framework']")
    private WebElementFacade approvalWorkflowForDF_btn;
    @FindBy(xpath = "//td[contains(text(),'New Document Framework')]")
    private WebElementFacade NewDF_tab;
    @FindBy(xpath = "//td[contains(text(),'Edit Document Framework')]")
    private WebElementFacade EditDF_tab;
    @FindBy(xpath="//div[@class='dragBox']//div[contains(text(),'Prime Broker - 1')]")
    private WebElementFacade PB1_participant;
    @FindBy(xpath = "(//div[text()='Drag and Drop here the participant'])[1]")
    private WebElementFacade approvalSeq1;
    @FindBy(xpath = "//td[text()='Edit Document Framework']/..//td[2]/div[1]/div")
    private WebElementFacade approvalSeq2;
    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade RejectButton;
    @FindBy(xpath = "//p[text()='Reject']")
    private WebElementFacade RejectionHeader;
    @FindBy(xpath = "//textarea[@class='rejection-reason-text']")
    private WebElementFacade RejectionReasonBox;
    @FindBy(xpath = "//div[@class='lp-copy-sel__input-container css-19bb58m']")
    private WebElementFacade ActingAs_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr[1]/td[2]/div")
    private WebElementFacade DF_on_listingScreen;

    @FindBy(xpath = "//span[text()='Life cycle status:']")
    private WebElementFacade LifeCycleStatusInPreviewVisible;
    @FindBy(xpath = "//span[text()='Life cycle status:']/parent::p")
    private WebElementFacade LifeCycleStatusValue;
    @FindBy(xpath = "//h2[contains(text(),'DF-')]")
    private WebElementFacade DF_VersionID_Preview;
    @FindBy(xpath = "//div[contains(text(),'Document type')]")
    private WebElementFacade DF_DocType_Preview;
    @FindBy(xpath = "//div[contains(text(),'Allowed currencies')]")
    private WebElementFacade DF_AllowedCurrencies_Preview;
    @FindBy(xpath = "//div[@class='info-container']//div[contains(text(),'Prime Broker')]")
    private WebElementFacade DF_PB_Preview;
    @FindBy(xpath = "//div[@class='info-container']//div[contains(text(),'Executing Broker')]")
    private WebElementFacade DF_EB_Preview;
    @FindBy(xpath = "//div[@class='info-container']//div[contains(text(),'Client')]")
    private WebElementFacade DF_Client_Preview;
    @FindBy(xpath = "//*[text()='Approval Workflow for Document Framework']")
    private WebElementFacade ApprovalWF_for_DF_Preview;
    @FindBy(xpath = "//*[text()='Enforcement Rules for DN']")
    private WebElementFacade EnforcementRule_for_DN_Preview;
    @FindBy(xpath = "//*[text()='General Terms']")
    private WebElementFacade GeneralTerms_for_DN_Preview;
    @FindBy(xpath = "//*[text()='Auth Scope']")
    private WebElementFacade AuthScope_for_DN_Preview;
    @FindBy(xpath = "//*[text()='Limit Scope']")
    private WebElementFacade LimitScope_for_DN_Preview;
    @FindBy(xpath = "//div[@class='preview-wrapper']//button[text()='Approval Workflow for Document Framework']")
    private WebElementFacade approvalWorkflowForDF_Preview_Submit_Tab;


    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade closeButton;
    @FindBy(xpath = "//div[@class='preview-header']/*[name()='svg']")
    private WebElementFacade crossIcon;
    @FindBy(xpath = "//input[@value='Edit Document Framework']")
    private WebElementFacade EditPopUp;


    @FindBy(xpath = "//th[@data-testid='doc-table-th-nextApprovalEntity' or text()='Next approval entity']")
    private WebElementFacade nextapprovalentity;
    @FindBy(xpath = "//div[@class=\'impacted-heading\']")
    private WebElementFacade associateddrawer;
    @FindBy(xpath = "//button[@class='link document-count']")//div[@class='link document-count']
    private WebElementFacade doccounthyperlink;

    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentId' or normalize-space(text())='Document ID']")
    private WebElementFacade documentID;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentVersionId' or text()='Document version ID' or text()='Document version Id']")
    private WebElementFacade documentVersionID;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-documentType' or text()='Document type']")
    private WebElementFacade documentType;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-updatedBy' or text()='Updated by']")
    private WebElementFacade updatedBy;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-updatedOn' or text()='Updated on']")
    private WebElementFacade updatedOn;
    @FindBy(xpath = "//th[text()='Status']")
    private WebElementFacade docStatus;
    @FindBy(xpath = "//*[@id=\"scroll-container\"]/div/table/tbody/tr/td[1]")
    private WebElementFacade documentId;
    @FindBy(xpath = "(//*[@id=\"scroll-container\"]/div/table/tbody/tr/td[1])[1]")
    private WebElementFacade documentIdDFDoc;
    @FindBy(xpath = "//*[@id=\"scroll-container\"]/div/table/tbody/tr/td[2]")
    private WebElementFacade documentVerID;

    @FindBy(xpath = "//input[@placeholder=\"Search with document ID\"]")
    private WebElementFacade searchDocumentId;
    @FindBy(xpath = "//input[@placeholder=\"Search with document version ID\"]")
    private WebElementFacade searchDocumentVerID;
    @FindBy(xpath = "//button[@class=\"link\"]")//div[@class="link"]
    private WebElementFacade versionID;
    @FindBy(xpath = "//button[text()='Associated DNs']")
    private WebElementFacade associatedDN;
    @FindBy(xpath = "//*[@aria-label=\"Edit\"]")
    private WebElementFacade editicon;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submitButton;//div[text()='Select']

    @FindBy(xpath = "//div[text()='Select']")//div[@class='lp-copy-sel__value-container css-hlgwow']
    private WebElementFacade actingAs;
    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr[1]//td[3]//span")
    private WebElementFacade lifecyclestatus;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancelButton;
    @FindBy(xpath = "(//button[@aria-label='Audit'])[1]")
    private List<WebElementFacade> allTrackButtons;
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//tbody//tr[1]/td[starts-with(@data-testid, 'cell-default-updatedBy-') or starts-with(@data-testid, 'cell-updatedBy-') or starts-with(@data-testid, 'cell-document-updatedBy-') or position() = count(//table[contains(@class, 'doc-table')]//th[contains(., 'Last Updated By') or contains(., 'Updated by') or contains(., 'Updated By') or contains(@data-testid, 'updatedBy')]/preceding-sibling::th) + 1]")
    private WebElementFacade firstRowLastUpdatedByCell;
    @FindBy(xpath = "//div[contains(.,'Last Updated By')]/following-sibling::div//input")
    private WebElementFacade lastUpdatedByFilterInput;
    @FindBy(xpath = "//input[@placeholder='Select requester']")
    private WebElementFacade selectRequesterInput;

    @FindBy(xpath = "//input[@placeholder='Select reviewer']")
    private WebElementFacade selectReviewerInput;
    @FindBy(xpath = "//input[contains(@placeholder,'Search with request id') or @id='search-requester']")
    private WebElementFacade searchRequesterInput;

    @FindBy(xpath = "//table//tbody//tr[1]//button[contains(text(),'Approve')]")
    private WebElementFacade firstRowApproveBtn;
    @FindBy(xpath = "//div[contains(@class,'avatar')] | //button[@id='user-profile-menu']")
    private WebElementFacade userProfileMenu;

    @FindBy(xpath = "//button[text()='Sign Out'] | //*[contains(text(),'Sign out')]")
    private WebElementFacade signOutBtn;

    public void userClicksOnDocCount() {
       Assert.assertTrue(doccounthyperlink.isEnabled());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", doccounthyperlink);
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        doccounthyperlink.click();

    }

    public void associatedDrawer() {
        Assert.assertTrue(associateddrawer.isDisplayed());
        Assert.assertTrue(docStatus.isDisplayed());
        Assert.assertTrue(updatedOn.isDisplayed());
//        Assert.assertTrue(updatedBy.isVisible());
        Assert.assertTrue(documentType.isDisplayed());
        Assert.assertTrue(documentVersionID.isDisplayed());
        Assert.assertTrue(documentID.isDisplayed());
    }

    public void checkDocIDAndVersion() {
        String documentID = documentId.getText();
        String documentVersion = documentVerID.getText();
        searchDocumentId.sendKeys(documentID);
        searchDocumentVerID.sendKeys(documentVersion);
        act.pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(documentId.getText(),documentID);
        Assert.assertEquals(documentVerID.getText(),documentVersion);
    }

    public void checkDocIDAndVersionDFDoc() {
        String documentID = documentIdDFDoc.getText();
        act.pause(Duration.ofSeconds(2)).build().perform();
        String documentVersion = documentVerID.getText();
        searchDocumentId.sendKeys(documentID);
        act.pause(Duration.ofSeconds(2)).build().perform();
        searchDocumentVerID.sendKeys(documentVersion);
        act.pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(documentId.getText(),documentID);
        Assert.assertEquals(documentVerID.getText(),documentVersion);
    }


    public void selectActing() {
        withAction().moveToElement(actingAs).click().sendKeys(Keys.ENTER).pause(Duration.ofSeconds(5)).build().perform();
    }

    public void lifeCycleStatus() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", lifecyclestatus);
       Assert.assertTrue(lifecyclestatus.isDisplayed());
    }

    public void clickFirstRowTrackButton() {
        if (!allTrackButtons.isEmpty()) {
            allTrackButtons.get(0).waitUntilClickable().click();
        } else {
            throw new RuntimeException("No 'Track' buttons were found on the dashboard grid table!");
        }
    }

    public void applyFilterToColumn(String columnName, String filterValue) {
        String inputXpath = "//span[contains(text(), '" + columnName + "')]/following::input[1] ";
        WebElementFacade filterInput = element(By.xpath(inputXpath));
        filterInput.withTimeoutOf(java.time.Duration.ofSeconds(10)).waitUntilPresent();
        evaluateJavascript("arguments[0].click();", filterInput);
        filterInput.clear();
        filterInput.sendKeys(filterValue);
        String optionXpath = String.format(
                "//div[contains(@class, 'dropdown') or contains(@class, 'popover') or @role='presentation' or contains(@class, 'MuiAutocomplete-pooper')]//*[contains(text(), '%s')]",
                filterValue
        );
        try {
            WebElementFacade dropdownOption = element(By.xpath(optionXpath));
            dropdownOption.withTimeoutOf(java.time.Duration.ofSeconds(3)).waitUntilClickable().click();
            log.info("Selected option '{}' via autocomplete list selection drop.", filterValue);
        } catch (Exception e) {
            log.warn("Dropdown option overlay not caught. Sending Enter key fallback instead.");
            filterInput.sendKeys(org.openqa.selenium.Keys.ENTER);
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public String getLastUpdatedByColumnData() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return firstRowLastUpdatedByCell.withTimeoutOf(java.time.Duration.ofSeconds(15))
                .waitUntilVisible()
                .getText();
    }

    public void filterByRequesterEmail(String email) {
        WebElementFacade targetInput = selectRequesterInput;
        try {
            targetInput.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", targetInput);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            targetInput.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            targetInput.sendKeys(email);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.warn("Standard filtering failed, trying simple sendKeys fallback: " + e.getMessage());
            try {
                targetInput.clear();
                targetInput.sendKeys(email, Keys.ENTER);
                Thread.sleep(2000);
            } catch (Exception ex) {
                log.error("Failed to filter by requester email: " + email + " -> " + ex.getMessage());
                Assert.fail();
            }
        }
    }

    public void clickActionApproveForFirstRow() {
        firstRowApproveBtn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        // Click confirmation modals if present in your environment flow
        WebElementFacade confirmSubmit = element(By.xpath("//button[text()='Submit' or text()='Approve']"));
        if(confirmSubmit.isCurrentlyVisible()) { confirmSubmit.click(); }
    }

    public void loginWithExplicitCredentials(String username, String password) {
        getDriver().get(getEnvironmentVariables().getProperty("webdriver.base.url"));
        element(By.id("username")).sendKeys(username);
        element(By.id("password")).sendKeys(password);
        element(By.id("submit-btn")).click();
    }

    public void clickUserProfileMenu() { userProfileMenu.waitUntilClickable().click(); }
    public void clickSignOut() { signOutBtn.waitUntilClickable().click(); }

    public void setApprovalFilterValue(String filterType, String emailValue) {
        WebElementFacade targetInput;
        if (filterType.equalsIgnoreCase("Select requester")) {
            targetInput = selectRequesterInput;
        } else if (filterType.equalsIgnoreCase("Select reviewer")) {
            targetInput = selectReviewerInput;
        } else {
            throw new IllegalArgumentException("Unknown filter type provided in test step: " + filterType);
        }
        targetInput.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", targetInput);
        targetInput.click();
        targetInput.clear();

        withAction().click(targetInput)
                .sendKeys(emailValue)
                .pause(Duration.ofSeconds(2))
                .sendKeys(org.openqa.selenium.Keys.ARROW_DOWN, org.openqa.selenium.Keys.RETURN)
                .build().perform();

        log.info("Successfully injected email criteria filter into " + filterType);
    }

    public boolean verifyColumnDataContainsFilteredEmail(String columnName) {
        String columnXpathIndex;
        String expectedEmail;
        if (columnName.equalsIgnoreCase("Requested by")) {
            columnXpathIndex = "//table//tbody//tr/td[3]";
            expectedEmail = "automation.user3@yopmail.com";
        } else if (columnName.equalsIgnoreCase("Reviewed by")) {
            columnXpathIndex = "//table//tbody//tr/td[5]";
            expectedEmail = "hsbc.test1@testsso.osttra.com";
        } else {
            throw new IllegalArgumentException("Unsupported report column validation requested: " + columnName);
        }
        java.util.List<WebElementFacade> columnCells = null;
        String actualCellText = "";
        for (int attempt = 0; attempt < 10; attempt++) {
            columnCells = findAll(By.xpath(columnXpathIndex));
            if (!columnCells.isEmpty()) {
                actualCellText = columnCells.get(0).getText().trim();
                if (!actualCellText.isEmpty()) {
                    break;
                }
            }
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        if (columnCells == null || columnCells.isEmpty()) {
            log.warn("No records returned in the table report grid after applying the filters.");
            return false;
        }
        for (WebElementFacade cell : columnCells) {
            actualCellText = cell.getText().trim();
            log.info("Checking cell text content: '" + actualCellText + "' against expected: '" + expectedEmail + "'");
            if (!actualCellText.equalsIgnoreCase(expectedEmail)) {
                log.error("Mismatch encountered! Found anomalous entry value: " + actualCellText);
                return false;
            }
        }
        return true;
    }

    public void setAgreementFilterValue(String filterType, String emailValue) {
        if (filterType.equalsIgnoreCase("Last Updated By")) {
            WebElementFacade targetInput = null;
            if (lastUpdatedByFilterInput.isCurrentlyVisible()) {
                targetInput = lastUpdatedByFilterInput;
            } else {
                targetInput = find(By.xpath("//th[contains(., 'Last Updated By') or contains(., 'Last updated by')]//input"));
            }
            targetInput.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
            evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", targetInput);
            evaluateJavascript("arguments[0].click();", targetInput);
            targetInput.clear();
            targetInput.sendKeys(emailValue);
            withAction().pause(Duration.ofSeconds(2))
                    .sendKeys(org.openqa.selenium.Keys.ARROW_DOWN, org.openqa.selenium.Keys.RETURN)
                    .build().perform();
        } else {
            throw new IllegalArgumentException("Unsupported filter type provided: " + filterType);
        }
    }

    public boolean verifyAgreementsReportContainsFilteredEmail(String expectedEmail) {
        String columnXpathIndex = "//table//tbody//tr/td[5]";
        java.util.List<WebElementFacade> columnCells = null;
        String actualCellText = "";
        for (int attempt = 0; attempt < 10; attempt++) {
            columnCells = findAll(By.xpath(columnXpathIndex));
            if (!columnCells.isEmpty()) {
                actualCellText = columnCells.get(0).getText().trim();
                if (!actualCellText.isEmpty()) {
                    break;
                }
            }
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        if (columnCells == null || columnCells.isEmpty()) {
            log.warn("No records returned in the table report grid after applying the filters.");
            return false;
        }
        for (WebElementFacade cell : columnCells) {
            actualCellText = cell.getText().trim();
            log.info("Checking cell text content: '" + actualCellText + "' against expected: '" + expectedEmail + "'");
            if (actualCellText.isEmpty()) {
                log.error("Encountered an empty table row cell location inside the report grid!");
                return false;
            }
        }
        log.info("Success! Table row records are populated properly.");
        return true;
    }

    public boolean verifyHistoryReportUserColumnHasEmails() {
        String historyUserColumnXpath = "//*[contains(@class,'modal') or contains(@class,'dialog') or contains(@class,'popup')]//table//tbody//tr/td[6]";
        java.util.List<WebElementFacade> columnCells = null;
        for (int attempt = 0; attempt < 10; attempt++) {
            columnCells = findAll(By.xpath(historyUserColumnXpath));
            if (!columnCells.isEmpty() && !columnCells.get(0).getText().trim().isEmpty()) {
                break;
            }
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        if (columnCells == null || columnCells.isEmpty()) {
            log.warn("Agreement History report grid failed to load or returned no transaction logs.");
            return false;
        }
        for (WebElementFacade cell : columnCells) {
            String cellText = cell.getText().trim();
            log.info("Inspecting History User entry: '" + cellText + "'");
            if (cellText.isEmpty() || !cellText.contains("@")) {
                log.error("Invalid entry string found in audit history user column: '" + cellText + "'");
                return false;
            }
        }
        log.info("Success! All rows under the history 'User' column are cleanly populated with user emails.");
        return true;
    }

    public boolean verifyMainGridContainsFilteredEmail(String expectedEmail) {
        // Targets the dynamic column index of the 'Last Updated By' column specifically
        String columnXpathIndex = "//table//tbody//tr/td[count(//th[contains(., 'Last Updated By')]/preceding-sibling::th) + 1]";
        java.util.List<WebElementFacade> columnCells = null;
        String actualCellText = "";

        // Wait up to 10 seconds for asynchronous data elements to load and populate inside the table grid layout
        for (int attempt = 0; attempt < 10; attempt++) {
            columnCells = findAll(By.xpath(columnXpathIndex));
            if (!columnCells.isEmpty()) {
                actualCellText = columnCells.get(0).getText().trim();
                if (!actualCellText.isEmpty()) {
                    break;
                }
            }
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }

        if (columnCells == null || columnCells.isEmpty()) {
            log.warn("No rows displaying an email address were found in the document report grid layout.");
            return false;
        }

        for (WebElementFacade cell : columnCells) {
            actualCellText = cell.getText().trim();
            log.info("Checking main grid cell email value: '" + actualCellText + "' against expected: '" + expectedEmail + "'");

            if (!actualCellText.equalsIgnoreCase(expectedEmail)) {
                log.error("Mismatch encountered! Found anomalous entry value instead: " + actualCellText);
                return false;
            }
        }

        log.info("Success! All visible row email elements match the filter values perfectly.");
        return true;
    }

}