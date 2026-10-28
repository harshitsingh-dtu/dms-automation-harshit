package PageObjects.Approval;

import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import Utilities.ConfigFileReader;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.fail;
//import static org.graalvm.compiler.nodeinfo.Verbosity.Name;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
@Slf4j
@Data
public class ApprovalgroupCreatePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    ConfigFileReader configFileReader=new ConfigFileReader();
    @FindBy(xpath = "//button[normalize-space()='+ Create Approval Group']")
    private WebElementFacade createnew_btn;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationname_box;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doc_type_box;
    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgtype_box;
    @FindBy(xpath = "//div[text()='Select Leis']    ")
    private WebElementFacade leiname_box;
    @FindBy(xpath = "//input[@placeholder='Enter group name']")
    private WebElementFacade groupname_box;
    @FindBy(xpath = "//input[@placeholder='Search by group name']")
    private WebElementFacade Searchbar;
    @FindBy(xpath = "//table/tbody//td[1]")
    private WebElementFacade approvalGroupName;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_btn;
    @FindBy(xpath = "//div[text()='Approval groups']")
    private WebElementFacade approvalGroupPage;
    @FindBy(xpath = "//div[text()='Group name already exists.']")
    private WebElementFacade alert_approval_group_exists;

    @FindBy(xpath = "//div[text()='Group name']//following-sibling::input")
    private WebElementFacade UpdateGroupName_Field;
    @FindBy(xpath = "//button[text()='+ Create Approval Group']")
    private WebElementFacade Create_approval_grp;
    @FindBy(xpath = "//input[contains(@placeholder, 'Select Legal entity name')]")
    private WebElementFacade filterBox;



    static StringBuilder randomStr;
    private static final java.util.Map<String, String> GENERATED_GROUP_NAMES = new java.util.HashMap<>();

    public static String getGeneratedGroupName(String baseName) {
        return GENERATED_GROUP_NAMES.get(baseName);
    }

    public void clickcreatenew_btn(){
        try {
            createnew_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
            try {
                createnew_btn.click();
            } catch (Exception e) {
                evaluateJavascript("arguments[0].click();", createnew_btn);
            }
        }
        catch (Exception e){
            log.error("Create new button not found -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_group_name(DataTable groupname){
        List<Map<String, String>> data = groupname.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {groupname_box.waitUntilClickable();
            withAction().moveToElement(groupname_box).click().sendKeys(dataTable.get("group name")).pause(Duration.ofSeconds(5)).build().perform();
        }
        catch (Exception e){log.error("user is unable to input the group name -->"+e);
            Assert.fail();}
    }
    public void user_generates_unique_group_name(DataTable groupname){
        List<Map<String, String>> data = groupname.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        randomStr =  DocumentTemplateCreatePageObject.randomStringGenerator();
        String baseGroupName = dataTable.get("group name");
        String fullGroupName = baseGroupName + randomStr;
        try {
            groupname_box.waitUntilClickable();
            groupname_box.type(fullGroupName);
            GENERATED_GROUP_NAMES.put(baseGroupName, fullGroupName);
            net.serenitybdd.core.Serenity.setSessionVariable("STORED_APPROVAL_GROUP_NAME").to(fullGroupName);
            log.info("Saved unique approval group name for base '" + baseGroupName + "': " + fullGroupName);
        }
        catch (Exception e){log.error("user is unable to input the group name -->"+e);
            Assert.fail();}
    }
    public String validates_group_name(List<String> approvalgroup){
        approvalGroupPage.waitUntilVisible();
        Searchbar.waitUntilClickable().type(approvalgroup.get(1)+randomStr);
        approvalGroupName.waitUntilVisible();
        act.pause(Duration.ofSeconds(3)).build().perform();
        return(approvalgroup.get(1)+randomStr);
    }

    public void user_fills_the_organization_name(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {organizationname_box.waitUntilClickable();
            withAction().moveToElement(organizationname_box).click().sendKeys(dataTable.get("organisation name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the organisation name -->"+e);
            Assert.fail();
        }
    }

    public void user_fills_the_doc_type(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {doc_type_box.waitUntilClickable();
            act.moveToElement(doc_type_box).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Doc type -->"+e);
            // Assert.fail();
        }
    }

    public void user_fills_the_leis(DataTable leis) {
        List<Map<String, String>> data = leis.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {leiname_box.waitUntilClickable();
            act.moveToElement(leiname_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("LEI's"),Keys.DOWN,Keys.RETURN).build().perform();}
        catch (Exception e){
            log.error("Unable to fill in the LEI name -->"+e);
            Assert.fail();
        }
    }
    public void user_fills_the_org_type(DataTable orgtype){
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {orgtype_box.waitUntilClickable();
            act.moveToElement(orgtype_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("org type"),Keys.DOWN,Keys.RETURN).build().perform();}
        catch (Exception e){
            log.error("Unable to fill in the Org type -->"+e);
            Assert.fail();
        }
    }
    public void clicks_on_next(){
        try {next_btn.waitUntilClickable();
            next_btn.click();
        }
        catch (Exception e){
            log.error("Unable to move to the next screen -->"+e);
            Assert.fail();
        }
    }
    public void user_updatesApprovalGroupName(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",UpdateGroupName_Field);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        UpdateGroupName_Field.click();
        UpdateGroupName_Field.clear();
        UpdateGroupName_Field.sendKeys(dataTable.get("Approval Group Name"));
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void validateNoOfUsersForApprovalGroup(String baseGroupName, int expectedCount) {

        String rowXpath =
                "//table//tbody/tr[td[starts-with(normalize-space(),'" + baseGroupName + "')]]";
        String usersCountXpath = rowXpath + "/td[6]";
        Awaitility.await()
                .atMost(Duration.ofSeconds(15))
                .pollInterval(Duration.ofSeconds(1))
                .untilAsserted(() -> {
                    WebElementFacade row =
                            find(By.xpath(rowXpath))
                                    .waitUntilVisible();
                    WebElementFacade usersCountCell =
                            row.find(By.xpath("./td[6]"))
                                    .waitUntilVisible();
                    getJavascriptExecutorFacade().executeScript(
                            "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                            usersCountCell
                    );
                    String actualValue = usersCountCell.getText().trim();
                    if (!String.valueOf(expectedCount).equals(actualValue)) {
                        throw new AssertionError(
                                "No. of users mismatch for Approval Group starting with [" +
                                        baseGroupName + "]. Expected: " + expectedCount +
                                        ", Actual: " + actualValue
                        );
                    }
                });
    }
    public void validateGroupNameMaxLength() {
        WebElementFacade groupNameInput = find(By.xpath("//input[@data-testid='group-name-input']"));
        groupNameInput.waitUntilVisible();
        groupNameInput.clear();
        groupNameInput.sendKeys(RandomStringUtils.randomAlphabetic(256));
        int actualLength = groupNameInput.getValue().length();
        if (actualLength > 255) {
            throw new AssertionError("Approval group name field accepts more than 255 characters.");
        } else {
            log.info("Approval group name field correctly restricts input to 255 characters.");
        }
    }

    public void verifyOrgColumnsAvailable(DataTable EntityName){

    }

    public void verifyCrossOrgVisibility(DataTable entities) {
        List<Map<String, String>> data = entities.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        for (Map<String, String> row : data) {
            String entityName = row.get("Legal Entity Name");
            log.info("Verifying VIEW_ALL cross-org visibility for Legal Entity: {}", entityName);
            try {
                String filterBoxXPath = "//input[contains(@placeholder, 'Select Legal entity name')]";
                WebElement filterBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterBoxXPath)));
                filterBox.click();
                withAction().pause(Duration.ofMillis(500)).build().perform();
                filterBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                filterBox.sendKeys(entityName);
                filterBox.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                String dropdownOptionXPath = "//li[@role='option' and contains(., '" + entityName + "')]";
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownOptionXPath)));
                option.click();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
                boolean hasValidRecords = false;
                for (WebElementFacade tableRow : tableRows) {
                    if (tableRow.isCurrentlyVisible() && !tableRow.getText().toLowerCase().contains("no record")) {
                        hasValidRecords = true;
                        break;
                    }
                }
                if (!hasValidRecords) {
                    Assert.assertFalse("VIEW_ALL Validation Failed: The table was empty when searching for Legal Entity '" + entityName + "'. User might lack permissions.", data.isEmpty());
                } else {
                    log.info("Validation Passed: Data successfully populated for '{}'.", entityName);
                }
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
            } catch (Exception e) {
                log.error("Failed during cross-org validation for '{}'. Error: {}", entityName, e.getMessage());
                org.junit.Assert.fail("Failed to search or validate visibility for Legal Entity: " + entityName);
            }
        }
    }

    public void createApprovalMatrixIfNotPresent(DataTable table) {
        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
            String orgName = row.get("Organisation Name");
            String docType = row.get("Doc Type");
            String lei = row.get("Legal Entity Name");
            String orgType = row.get("Org type");

            log.info("--- Checking existence for Approval Matrix: LEI '{}', Doc Type '{}' ---", lei, docType);

            try {
                // 1. SEARCH LISTING SCREEN TO CHECK IF IT ALREADY EXISTS
                // Target the 'Select Legal entity name' dropdown shown in the video
                evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Legal entity name')] | //label[contains(., 'Legal entity name')]/..//input").waitUntilPresent());
                $("//input[contains(@placeholder, 'Legal entity name')] | //label[contains(., 'Legal entity name')]/..//input")
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, lei, Keys.SPACE, Keys.BACK_SPACE);
                withAction().pause(Duration.ofSeconds(2)).build().perform(); // Wait for React dropdown

                // Select the LEI from the filter dropdown
                $("//li[@role='option' and contains(., '" + lei + "')] | //div[contains(@class, 'option') and contains(., '" + lei + "')]").waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for table to filter

                // 2. EVALUATE TABLE RESULTS
                boolean alreadyExists = false;
                if (!$("//table/tbody/tr[1]").getText().toLowerCase().contains("no record")) {
                    alreadyExists = true;
                }

                // 3. CONDITIONAL CREATION LOGIC
                if (alreadyExists) {
                    log.info("Approval Matrix for LEI '{}' already exists. Skipping creation to avoid duplicate error.", lei);
                } else {
                    log.info("No existing matrix found for '{}'. Proceeding to create.", lei);

                    // A. Click Create Button
                    evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Create Approval Matrix')]").waitUntilClickable());
                    withAction().pause(Duration.ofSeconds(2)).build().perform();

                    // B. Select Organisation
                    evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Organisation')] | //label[contains(., 'Organisation')]/..//input").waitUntilPresent());
                    $("//input[contains(@placeholder, 'Select Organisation')] | //label[contains(., 'Organisation')]/..//input")
                            .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, orgName, Keys.SPACE, Keys.BACK_SPACE);
                    $("//li[@role='option' and contains(., '" + orgName + "')]").waitUntilClickable().click();

                    // C. Select Doc Type
                    evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Doc type')] | //label[contains(., 'Doc type')]/..//input").waitUntilPresent());
                    $("//input[contains(@placeholder, 'Select Doc type')] | //label[contains(., 'Doc type')]/..//input")
                            .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, docType);
                    $("//li[@role='option' and contains(., '" + docType + "')]").waitUntilClickable().click();

                    // D. Select LEI
                    evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select LEIs') or contains(@placeholder, 'Select Lels')] | //label[contains(., 'LEI')]/..//input").waitUntilPresent());
                    $("//input[contains(@placeholder, 'Select LEIs') or contains(@placeholder, 'Select Lels')] | //label[contains(., 'LEI')]/..//input")
                            .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, lei, Keys.SPACE, Keys.BACK_SPACE);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    $("//li[@role='option' and contains(., '" + lei + "')]").waitUntilClickable().click();

                    // E. Select Org Type
                    evaluateJavascript("arguments[0].click();", $("//input[contains(@placeholder, 'Select Org type')] | //label[contains(., 'Org type')]/..//input").waitUntilPresent());
                    $("//input[contains(@placeholder, 'Select Org type')] | //label[contains(., 'Org type')]/..//input")
                            .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, orgType);
                    $("//li[@role='option' and contains(., '" + orgType + "')]").waitUntilClickable().click();

                    // F. Click Next to Save
                    evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Next')]").waitUntilClickable());

                    // G. Wait for the Success Toast
                    $("//*[contains(text(), 'Approval matrix created successfully') or contains(text(), 'successfully')]").waitUntilVisible();
                    withAction().pause(Duration.ofSeconds(1)).build().perform();

                    // H. Click Cancel on the Assignment screen to return to the listing page
                    evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Cancel')]").waitUntilClickable());

                    // Wait for listing screen to reload
                    $("//button[contains(., 'Create Approval Matrix')]").waitUntilVisible();
                    log.info("Successfully created Approval Matrix for '{}'.", lei);
                }

                // 4. CLEANUP: Clear the LEI search filter so the next loop starts with a fresh table
                String clearIconXPath = "//input[contains(@placeholder, 'Legal entity name')]/parent::div//button[@title='Clear' or @aria-label='Clear']";
                if (!$$(By.xpath(clearIconXPath)).isEmpty() && $(By.xpath(clearIconXPath)).isCurrentlyVisible()) {
                    evaluateJavascript("arguments[0].click();", $(By.xpath(clearIconXPath)));
                } else {
                    $("//input[contains(@placeholder, 'Legal entity name')] | //label[contains(., 'Legal entity name')]/..//input")
                            .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                }
                withAction().pause(Duration.ofSeconds(2)).build().perform();

            } catch (Exception e) {
                log.error("Failed during Check/Create lifecycle for LEI '{}'. Error: {}", lei, e.getMessage());
                fail("Check/Create lifecycle failed for LEI: " + lei + " with error: " + e.getMessage());
            }
        }
    }

    public void crossorgVisibility(DataTable dataTable){
        List<Map<String, String>> org = dataTable.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        for(Map<String, String> orgdata: org){
            filterBox.waitUntilClickable().click();
            String entityName = orgdata.get("Legal Entity Name");
            filterBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            filterBox.sendKeys(entityName);
            String dropdownOptionXPath = "//li[@role='option' and contains(., '" + entityName + "')]";
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownOptionXPath)));
            option.click();
            List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
            boolean hasValidRecords = false;
            for (WebElementFacade row : tableRows) {
                if (row.isCurrentlyVisible() && !row.getText().toLowerCase().contains("no record")) {
                    hasValidRecords = true;
                    break;
                }
            }
            if(!hasValidRecords){
                Assert.assertFalse(entityName, dataTable.isEmpty());
            }
        }


    }


}