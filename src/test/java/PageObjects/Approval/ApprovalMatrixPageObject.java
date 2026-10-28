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
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class ApprovalMatrixPageObject extends PageObject {
    Actions act=new Actions(getDriver());

    @FindBy(xpath = "//button[text()='+ Create Approval Matrix']")
    private WebElementFacade create_btn;
    @FindBy(xpath = "//tr[1]//button[text()='Update']")
    private WebElementFacade update_btn;
    @FindBy(xpath = "//input[@value='PARALLEL']")
    private WebElementFacade sequential_btn;
    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElementFacade confirm_btn;
    @FindBy(xpath = "//button[text()='View']")
    private WebElementFacade view_btn;
    @FindBy(xpath = "//input[contains(@placeholder,'Search by organisation name')]")
    private WebElementFacade searchBar;

    @FindBy(xpath = "//input[contains(@placeholder,'Select Org Type')]")
    private WebElementFacade selectOrgType;

    @FindBy(xpath = "//input[contains(@placeholder,'Select Legal entity name')]")
    private WebElementFacade selectLEI;
    @FindBy(xpath = "//*[text()='Legal entity name']")
    private WebElementFacade rename_LEI_UpdateScreen;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade selectDocType;

    @FindBy(xpath = "//*[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'approval matrix')]")
    private WebElementFacade approvalMatrix_txt;

    @FindBy(xpath = "//th[1]")
    private WebElementFacade organizationName_col;

    @FindBy(xpath = "//th[3]")
    private WebElementFacade LEIsName_col;

    @FindBy(xpath = "//th[4]")
    private WebElementFacade orgType_col;
    @FindBy(xpath = "//tbody//td[4]")
    private List<WebElementFacade> orgTypeResults;

    @FindBy(xpath = "//th[2]")
    private WebElementFacade docType_col;

    @FindBy(xpath = "//th[5]")
    private WebElementFacade createdOn_col;

    @FindBy(xpath = "//th[6]")
    private WebElementFacade action_col;
    @FindBy(xpath="//div[contains(@class,'sidebar-icon')] | //div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Approval matrices']")
    private WebElementFacade approvalMatrix_btn;
    @FindBy(xpath = "//tr[1]//td[1]")
    private WebElementFacade searchedMatrix;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_txt;
    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupstemplate_btn;
    @FindBy(xpath = "//div[text()='Update approval matrix' or text()='Update approval matrices']")
    private WebElementFacade UpdateApprovalMatrix;
    @FindBy(xpath = "//*[contains(text(),'Showing all approval matrices')]")
    private WebElementFacade ApprovalMatrixScreen;
    @FindBy(xpath = "//div[contains(text(),'User not present for approval')]")
    private WebElementFacade approvalGroupWarningMessage;

    @FindBy(xpath = "//div[contains(text(),'Group mapping already exists')]")
    private WebElementFacade groupMappingAlreadyExists;
    @FindBy(xpath = "(//button[normalize-space()='Submit'])[2]")
    private WebElementFacade submitButton_Matrix;

    @FindBy(xpath = "//div[@class='notification-wrapper flex space-around align-center pointer']")
    private WebElementFacade notificationButton;
    @FindBy(xpath = "//div[@class='nf-item'][1]/div[@class='list']")
    private WebElementFacade approvalMatrixNotification;
    @FindBy(xpath = "//div[@class='nf-item'][1]/div[@class='list']/span")
    private WebElementFacade approvalMatrixNotificationMessage;


    public void navigateToApprovalMatrixListingScreenAlone(){
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        navigation_btn.waitUntilClickable();
        navigation_btn.click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
        approvalMatrix_btn.waitUntilClickable();
        approvalMatrix_btn.click();
    }

    public void navigateToApprovalMatrixListingScreen(){
        navigateToApprovalMatrixScreen();
        create_btn.withTimeoutOf(Duration.ofSeconds(30)).waitUntilVisible();
    }
    public void navigateToApprovalMatrixScreen(){
        try {
            if (create_btn.isCurrentlyVisible()) {
                log.info("Already on Approval Matrix screen.");
                return;
            }

            log.info("Navigating to Approval Matrix screen...");
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            boolean isSidebarOpen = false;
            try {
                Object openClass = ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return document.querySelector('.sidebar-wrapper') ? document.querySelector('.sidebar-wrapper').classList.contains('openSidebar') : false;");
                isSidebarOpen = Boolean.parseBoolean(String.valueOf(openClass));
            } catch (Exception ignored) {}

            if (!isSidebarOpen) {
                navigation_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
                try {
                    navigation_btn.click();
                } catch (Exception e) {
                    ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", navigation_btn);
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }

            if (!approvalMatrix_btn.isCurrentlyVisible()) {
                try {
                    groupstemplate_btn.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
                    try {
                        groupstemplate_btn.click();
                    } catch (Exception e) {
                        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", groupstemplate_btn);
                    }
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                } catch (Exception e) {
                    log.info("Groups & template menu item not clickable or already expanded: " + e.getMessage());
                }
            }

            approvalMatrix_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            try {
                approvalMatrix_btn.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", approvalMatrix_btn);
            }
            withAction().pause(Duration.ofSeconds(3)).build().perform();

        } catch (Exception e) {
            log.error("Not able to reach the approval matrix screen -->"+e);
            Assert.fail("Failed to navigate to Approval Matrix screen: " + e.getMessage());
        }
    }

    public void checkifcreateApprovalMatrixbtn(){
        Assert.assertTrue(create_btn.isVisible());
    }
    public void checkifupdatebtn(){
        Assert.assertTrue(update_btn.isVisible());
    }

    public void checkifviewbtn() {
        try {
            view_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", view_btn);
            Assert.assertTrue("The 'View' button is NOT visible on the Approval Matrix screen!", view_btn.isCurrentlyVisible());
            log.info("Successfully verified visibility of 'View' button.");
        } catch (Exception e) {
            log.error("Failed to verify 'View' button visibility: " + e.getMessage());
            Assert.fail("The 'View' button was not found or is not visible.");
        }
    }

    public void checkifAllcolumns(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(organizationName_col.isVisible());
        Assert.assertEquals("Organisation name",organizationName_col.getText().trim());
        Assert.assertTrue(LEIsName_col.isVisible());
        Assert.assertEquals("Legal entity name",LEIsName_col.getText().trim());
        Assert.assertTrue(orgType_col.isVisible());
        Assert.assertEquals("Org type",orgType_col.getText().trim());
        Assert.assertTrue(docType_col.isVisible());
        Assert.assertEquals("Doc type",docType_col.getText().trim());
        Assert.assertTrue(createdOn_col.isVisible());
        Assert.assertEquals("Created on",createdOn_col.getText().trim());
        Assert.assertTrue(action_col.isVisible());
        Assert.assertEquals("Action",action_col.getText().trim());
    }

    public void searchapprovalMatrix(List<String> approvaMatrix){
        searchBar.waitUntilVisible();
        searchBar.typeAndEnter(approvaMatrix.get(1));
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }

    public void searchAndValidateOrgType(List<String> approvalMatrix){
        find(PageElement.containingText("//tr",approvalMatrix.get(1))).findNestedElementsMatching(Button.containingText("Update")).get(0).click();
        act.pause(Duration.ofSeconds(2)).build().perform();
    }

    public boolean searchApprovalMatrix(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            // Select LEI
            selectLEI.waitUntilVisible();
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectLEI);
            selectLEI.type(dataTable.get("LEI name"));
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElement leiOption = getDriver().findElement(org.openqa.selenium.By.xpath(
                    "//li/p[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("LEI name").trim().toLowerCase() + "']"));
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", leiOption);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // Select Doc Type
            selectDocType.waitUntilVisible();
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectDocType);
            selectDocType.type(dataTable.get("doc type filter"));
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElement docOption = getDriver().findElement(org.openqa.selenium.By.xpath("//li/p[contains(text(), '" + dataTable.get("doc type filter") + "')]"));
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", docOption);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // Select Org Type
            selectOrgType.waitUntilVisible();
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", selectOrgType);
            selectOrgType.type(dataTable.get("org type filter"));
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElement orgOption = getDriver().findElement(org.openqa.selenium.By.xpath("//li/p[text()='" + dataTable.get("org type filter") + "']"));
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", orgOption);
            withAction().pause(Duration.ofSeconds(3)).build().perform();

            searchedMatrix.waitUntilVisible();
            System.out.println("Found matrix: " + searchedMatrix.getText());
            return searchedMatrix.getText().trim().equalsIgnoreCase(dataTable.get("approval matrix").trim());
        } catch (Exception e) {
            log.error("Error during searchApprovalMatrix: " + e.getMessage());
            return false;
        }
    }

    public void clickupdatebtn(){
        try {
            update_btn.waitUntilVisible();
            evaluateJavascript("arguments[0].click();", update_btn);
            act.pause(Duration.ofSeconds(4)).build().perform();
        }catch(Exception e){
            log.error("user is not able to reach update approval matrix screen"+e);

        }
    }
    public void clicksequenctialbtn(){
        try {
            act.pause(Duration.ofSeconds(2)).build().perform();
            sequential_btn.waitUntilVisible().click();
            act.pause(Duration.ofSeconds(2)).build().perform();
            confirm_btn.waitUntilVisible().click();
        }catch(Exception e){
            log.error("user is not able to reach update approval matrix screen"+e);

        }
    }
    public void clickcreatebtn(){
        try{ create_btn.waitUntilVisible();
            evaluateJavascript("arguments[0].click();", create_btn);
            act.pause(Duration.ofSeconds(4)).build().perform();
        }catch(Exception e){
            log.error("user is not able to reach Create approval matrix screen"+e);

        }
    }

    public boolean ValidateOrgTyperesults(){
        boolean result=false;
        for(int i =0; i<orgTypeResults.size();i++)
        {
            if(orgTypeResults.get(i).getText().equalsIgnoreCase("PB"))
            {
                result= true;
            }
            else {
                result= false;
                break;
            }
        }
        return result;
    }
    public boolean validateNotification(){
        boolean result = false;
        notificationButton.click();
        act.pause(Duration.ofSeconds(3)).build().perform();
        if(approvalMatrixNotification.getText().equalsIgnoreCase("Approval Matrix notification"))
        {
            if(approvalMatrixNotificationMessage.getText().contains("Your Automation_OT_ApprovalGroup_4way_Osttra was added to the Approval Matrix of 4 Way CITIGROUP INC. PB"))
            {
                result= true;
            }
            else if(approvalMatrixNotificationMessage.getText().contains("Your Automation_OT_ApprovalGroup_4way_Osttra was removed from the Approval Matrix of 4 Way CITIGROUP INC. PB")) {
                result = true;
            }
            else {
                log.error("user is not able to add/remove the approval group in approval matrix");
            }
        }
        return result;
    }
}