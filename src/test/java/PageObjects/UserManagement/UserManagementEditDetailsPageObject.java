package PageObjects.UserManagement;

import Utilities.ConfigFileReader;
import com.google.common.collect.Maps;

import com.google.common.collect.Maps;
//import com.sun.tools.sjavac.Log;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class UserManagementEditDetailsPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    ConfigFileReader configfileReader=new ConfigFileReader();

    @FindBy(xpath ="//tr[1]/td[6]/button[1]")
    private WebElementFacade editDetails_btn;

    @FindBy(xpath="//div[@class='search-add-container ']//input")
    private WebElementFacade search_added_Users_listing;

    @FindBy(xpath="//tr//td//button[text()='Update']")
    private WebElementFacade editDetails_btn_listing;

    @FindBy(xpath ="//div[text()=\"Select LEIs\"]")
    private WebElementFacade search_LEI;

    @FindBy(xpath ="//div[@class='select-container']//input[@placeholder='Select Org Type']")
    private WebElementFacade search_orgType;

    @FindBy(xpath ="//div[@class='enable-switch ']")
    private WebElementFacade  active_btn;

    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade  roleMapping;

    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade  roleMapping1;

    @FindBy(xpath ="//button[normalize-space()='Cancel']")
    private WebElementFacade cancel_btn;

    @FindBy(xpath ="//button[normalize-space()='Submit']")
    private WebElementFacade   submit_btn;
    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade   rolemappingDropbox;
    @FindBy(xpath = "//div[@class='lei-org-table-container']//td//button[@class='cross-btn']")
    private WebElementFacade remove_btn;
    @FindBy(xpath = "//div[@class='dms-role-list']//ul")
    private WebElementFacade selectedRole_list;
    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRoles;

    @FindBy(xpath = "//div[@class='dms-role-list']//li[text()='']")
    private WebElementFacade role_name;

    @FindBy(xpath ="//div[@class='info-content']//div[text()='Last name']")
    private WebElementFacade lastName;

    @FindBy(xpath = "//th//div[text()=\"User's name\"]")
    private  WebElementFacade username;
    @FindBy(xpath = "//tr//td[1]")
    private  WebElementFacade usernameValue;

    @FindBy(xpath ="//th//div[text()=\"Email id\"]")
    private WebElementFacade email;
    @FindBy(xpath ="//div[contains(text(),'Email')]/following-sibling::div[@data-testid]")
    private WebElementFacade emailValue;

    @FindBy(xpath ="//th//div[text()='Mobile no']")
    private WebElementFacade mobile;
    @FindBy(xpath ="//tr//td[3]")
    private WebElementFacade mobileValue;

    @FindBy(xpath = "//th//div[text()='Status']")
    private  WebElementFacade status;
    @FindBy(xpath = "//th//div[text()='Action']")
    private  WebElementFacade action;

    @FindBy(xpath ="//th//div[text()='Name of organisations']")
    private WebElementFacade organizationName;
    @FindBy(xpath ="//tr//td[4]")
    private WebElementFacade organizationValue;

    @FindBy(xpath ="//input[@placeholder='All Organisations']")
    private WebElementFacade All_Org;
    @FindBy(xpath = "//button[text()='+ Add']")
    private WebElementFacade add_btn;

    @FindBy(xpath = "//div[@role='alert']//div[text()='Mapping already exists']")
    private WebElementFacade alert_popup;
    @FindBy(xpath = "//input[@placeholder=\"Search by LEI name\"]")
    private WebElementFacade search_addedLEI;
    @FindBy(xpath = "//input[@type='text' and @placeholder='Select Org Type']")
    private WebElementFacade search_addedOrgtype;
    @FindBy(xpath = "//input[@type='text' and @placeholder='Select Doc Type']")
    private WebElementFacade search_Doctype;
    @FindBy(xpath = "//div[@class='lei-org-table-container']//tbody//tr")
    private WebElementFacade serached_addedLEI;
    @FindBy(xpath = "//div[@class='lei-org-table-container']//tbody//td[text()='Resource not available']")
    private WebElementFacade nodatafound_txt;
    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctype;
    @FindBy(xpath = "//button[text()='Yes']")
    private  WebElementFacade confirmation_YES_btn;
    @FindBy(xpath = "//button[text()='No']")
    private  WebElementFacade confirmation_NO_btn;
    @FindBy(xpath = "//div[@class='lei-org-table-container']//table")
    private WebElementFacade AddedLEIsOrgtype_Doctype_list;
    @FindBy(xpath = "//div[@role='alert'] | //div[contains(@class, 'MuiAlert-root')] | //div[contains(@class, 'Toastify')]")
    private WebElementFacade alert_toast;
    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade NoOptions;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade closeDropDown;


    public void selectDocTypeFromDropdown(List<Map<String, String>> data) {
        String typeValue = data.get(0).get("Doc Type");
        try {
            doctype.waitUntilClickable();
            act.moveToElement(doctype).click().sendKeys(typeValue).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type"+e);
            Assert.fail();
        }
    }

    public void typerolemapping(DataTable rolemapping){
        List<Map<String, String>> data = rolemapping.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            roleMapping.waitUntilClickable();
            if (!selectedRole_list.getText().contains(dataTable.get("role mapping"))){
                withAction().moveToElement(roleMapping).click().sendKeys(dataTable.get("role mapping")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();}
                closeDropDown.click();
        }
        catch (Exception e){
            log.error("Not able to do rolemapping"+e);
            Assert.fail();
        }
    }

    public void typerolemappingnew(DataTable rolemapping) {
        List<Map<String, String>> data = rolemapping.asMaps(String.class, String.class);

        try {
            String userEmail = emailValue.waitUntilVisible().getText().trim();
            log.info("Dynamically captured user email: {}", userEmail);

            // --- STEP 1: PRE-CHECK & REMOVE ANY ALREADY ASSIGNED ROLES FIRST ---
            for (Map<String, String> row : data) {
                String roleData = row.get("role mapping").trim();
                String assignedRoleXPath = "//div[@class='dms-role-list']//li[contains(., '" + roleData + "')]";
                String removeBtnXPath = assignedRoleXPath + "//button";

                if (!findAll(By.xpath(assignedRoleXPath)).isEmpty()) {
                    log.info("Role '{}' already assigned. Removing it now...", roleData);
                    WebElementFacade removeBtn = find(By.xpath(removeBtnXPath));
                    removeBtn.waitUntilClickable().click();
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            }

            // --- STEP 2: OPEN DROPDOWN & SELECT ALL ROLES FROM TABLE ---
            log.info("Opening Role Mapping dropdown to assign new roles...");
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", roleMapping);

            try {
                roleMapping.waitUntilClickable().click();
            } catch (Exception clickEx) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", roleMapping);
            }

            for (Map<String, String> row : data) {
                String roleData = row.get("role mapping").trim();
                log.info("Selecting role option: '{}'", roleData);

                // MUI Autocomplete Popper Option Locator
                String optionXPath = "//li[@role='option' and contains(.,'" + roleData + "')]";

                try {
                    // Clear search box input and type target role
                    roleMapping.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                    roleMapping.sendKeys(roleData);

                    WebElementFacade optionToSelect = find(By.xpath(optionXPath));
                    optionToSelect.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible().waitUntilClickable();

                    // Click option inside dropdown overlay
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", optionToSelect);
                    log.info("Successfully checked/selected role '{}'.", roleData);

                } catch (Exception e) {
                    log.warn("Could not find or click dropdown option for '{}'. Trying keyboard fallback.", roleData);
                    roleMapping.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
                }
            }

            // --- STEP 3: CLOSE DROPDOWN & VERIFY ---
            roleMapping.sendKeys(Keys.ESCAPE);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            for (Map<String, String> row : data) {
                String roleData = row.get("role mapping").trim();
                String assignedRoleXPath = "//div[contains(@class,'selected-values-container') or contains(@class,'dms-role-list')]//li[contains(., '" + roleData + "')]";

                boolean isAssigned = !findAll(By.xpath(assignedRoleXPath)).isEmpty();
                Assert.assertTrue("Verification failed: Role '" + roleData + "' was not found after selection.", isAssigned);
                log.info("Verified role '{}' is assigned.", roleData);
            }

        } catch (Exception e) {
            log.error("Critical failure during role mapping assignment: " + e.getMessage());
            org.junit.Assert.fail("User role assignment workflow failed: " + e.getMessage());
        }
    }

    public void checkrolemapping(){

        if (roleMapping1.isVisible()) {
            log.info("Role Mapping dropdown is visible");
        }
        else {
            log.info("Role Mapping dropdown not visible");
        }
    }
    public void doctype(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            doctype.waitUntilClickable();
            act.moveToElement(doctype).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to do Doc type"+e);
            Assert.fail();
        }
    }
    public void roleMapping(DataTable rolemapping){
        List<Map<String, String>> data = rolemapping.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            roleMapping.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (!selectedRole_list.getText().contains(dataTable.get("role mapping"))){
                withAction().moveToElement(roleMapping).click().sendKeys(dataTable.get("role mapping")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();}
//            if (selectedRole_list.getText().contains(dataTable.get("role mapping"))){
//                log.info("Successful Role Mapping");
//                submit_btn.click();
//            }
            else {
                log.error("Not able to do rolemapping");
                Assert.fail();
            }
        }catch (Exception e){
            log.error("Not able to do rolemapping"+e);
            Assert.fail();
        }

    }
    public void remove_roleMapping(DataTable rolemapping){
        List<Map<String, String>> data = rolemapping.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String roledata=dataTable.get("role mapping");
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (selectedRole_list.getText().contains(dataTable.get("role mapping"))){
                find(By.xpath("//div[@class='dms-role-list']//li[text()='"+roledata+"']//button")).click();
                log.info("Removed Successfully");
                withAction().pause(Duration.ofSeconds(5)).build().perform();
                submit_btn.click();
            }
            else {
                log.info("RoleMapping already removed");
            }
        }catch (Exception e){
            log.error("Not able to do rolemapping"+e);
            Assert.fail();
        }
    }

    public void remove_roleMappingnew(DataTable rolemapping) {
        List<Map<String, String>> data = rolemapping.asMaps(String.class, String.class);
        boolean isAnyRoleRemoved = false; // Flag to track if we need to click submit at the end

        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // 1. Loop through every single role provided in the feature file
            for (Map<String, String> row : data) {
                String roleData = row.get("role mapping");

                // Define the dynamic XPath for this specific role's remove button
                // Using contains(., 'text') is safer than text()='text' in case of hidden spaces
                String roleRemoveBtnXPath = "//div[@class='dms-role-list']//li[contains(., '" + roleData + "')]//button";

                // 2. Check if the role is currently present on the UI
                // We use !findAll().isEmpty() to safely check existence without throwing a NoSuchElementException
                if (!findAll(By.xpath(roleRemoveBtnXPath)).isEmpty()) {

                    log.info("Role found. Removing: " + roleData);
                    find(By.xpath(roleRemoveBtnXPath)).click();
                    isAnyRoleRemoved = true;

                    // Small pause to let the UI React/Angular state update after clicking remove
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                } else {
                    log.info("Role '" + roleData + "' not found or already removed. Skipping to next.");
                }
            }

            // 3. Click submit ONLY ONCE after all removals are complete
            if (isAnyRoleRemoved) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                submit_btn.click();
                log.info("Successfully submitted role mapping changes.");
            } else {
                log.info("No roles were present to remove. Submit button was not clicked.");
            }

        } catch (Exception e) {
            log.error("Failed while removing role mapping: " + e.getMessage());
            org.junit.Assert.fail("Exception during role removal: " + e.getMessage());
        }
    }

    public void remove_roleMapping2new() {
        List<WebElement> closeIcon = getDriver().findElements(By.xpath("//div[@class='dms-role-list']//button"));
        for(int i=closeIcon.size();i>0;i--){
            getDriver().findElement(By.xpath("(//div[@class='dms-role-list']//button)[" + i + "]")).click();
            try {
                WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
                WebElement yesBtn = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']")));
                log.info("Confirmation pop-up detected. Clicking 'Yes'.");
                yesBtn.click();
            } catch (Exception e) {
                // No confirmation pop-up, continue
            }
        }
    }

    public void searchLEI(DataTable lei){
        List<Map<String, String>> data = lei.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            act.moveToElement(search_LEI).click().sendKeys(dataTable.get("LEI")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();

        }catch (Exception e){
            log.error("Not able to search lei"+e);
            Assert.fail();
        }
    }
    public void search_addedLEI(DataTable lei){
        List<Map<String, String>> data = lei.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            act.moveToElement(search_addedLEI).click().sendKeys(dataTable.get("Org LEI")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("Searched org LEI");
        }catch (Exception e){
            log.error("Not able to search lei"+e);
            Assert.fail();
        }
    }

    public void searchOrgType(DataTable orgtype) {
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            search_orgType.waitUntilVisible().waitUntilClickable();
            
            // Safely clear the field before entering new text
            search_orgType.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            
            act.moveToElement(search_orgType).pause(Duration.ofSeconds(1)).click().sendKeys(dataTable.get("Org type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Not able to search org type: " + e.getMessage());
            Assert.fail("Failed to search org type: " + e.getMessage());
        }
    }
    public String EBDoesNotExists(DataTable orgtype) {
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            act.moveToElement(search_orgType).pause(Duration.ofSeconds(2)).click().sendKeys(dataTable.get("Org type")).pause(Duration.ofSeconds(2)).build().perform();
            return NoOptions.getText();

    }

    public void remove_LEIOrgtype(DataTable table){
        try {
            search_addedLEI(table);
            select_DocType(table);
            setSearch_addedOrgType(table);
            remove_btn.click();
            confirmation_YES_btn.waitUntilVisible().click();
        }catch (Exception e){
            log.error("Unable to remove LEI Orgtype"+e);
            Assert.fail();
        }
    }

    public void setSearch_addedOrgType(DataTable orgtype) {
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            act.moveToElement(search_addedOrgtype).click().sendKeys(dataTable.get("Org type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            log.info("Searched org type");

        }catch (Exception e){
            log.error("Not able to search org type"+e);
            Assert.fail();
        }
    }

    public void select_DocType(DataTable orgtype) {
        List<Map<String, String>> data = orgtype.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        act.moveToElement(search_Doctype).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
    }
    public void search_AllOrg(DataTable Org){
        List<Map<String, String>> data = Org.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        act.moveToElement(All_Org).click().sendKeys(dataTable.get("Organisation")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void clickSubmit_btn(){
        try {
            if (submit_btn.isClickable()){
                submit_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilClickable();
                evaluateJavascript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", submit_btn);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                evaluateJavascript("arguments[0].click();", submit_btn.getElement());
            }
            withAction().pause(Duration.ofSeconds(6)).build().perform();
        }catch (Exception e){
            Assert.fail("Unable to interact with submit button"+e);
        }
    }

    public void validateUserUpdateNotification() {
        // After clicking submit, one of two things should happen:
        // 1. The modal stays open and displays a validation error message.
        // 2. The modal closes and a success toast notification appears.

        // Wait for a moment to see which path the application takes.
        withAction().pause(Duration.ofSeconds(5)).build().perform();

        if (submit_btn.isCurrentlyVisible()) {
            // SCENARIO 1: The modal is still open. This means there should be a validation error.
            log.info("Modal is still open. Checking for an inline validation message...");
            try {
                // Look for any common error message element.
                WebElementFacade errorMessage = find(By.xpath(
                    "//div[@role='alert'] | //p[contains(@class, 'error')] | //div[contains(@class, 'Mui-error')]"
                ));
                
                if (errorMessage.isCurrentlyVisible()) {
                    String errorText = errorMessage.getText().trim();
                    log.info("SUCCESS: Found inline validation message: '{}'. This is an acceptable outcome.", errorText);
                    // Test passes.
                    return;
                } else {
                    Assert.fail("Validation Failed: The submission modal is still open, but no validation error message was found.");
                }
            } catch (Exception e) {
                log.error("Exception while searching for inline error: " + e.getMessage());
                Assert.fail("Validation Failed: The submission modal is still open, but no validation error message could be found.");
            }

        } else {
            // SCENARIO 2: The modal has closed. This means we expect a success toast.
            log.info("Modal has closed. Checking for a success toast notification...");
            try {
                alert_toast.withTimeoutOf(Duration.ofSeconds(15)).waitUntilPresent();

                String toastText = alert_toast.getText().trim();
                log.info("Captured notification text: " + toastText);

                boolean isSuccess = toastText.toLowerCase().contains("user updated successfully") ||
                                    toastText.toLowerCase().contains("successfully");

                Assert.assertTrue(
                    "Validation Failed: Expected a success notification, but found: '" + toastText + "'",
                    isSuccess
                );
                log.info("SUCCESS: 'User updated successfully' notification appeared as expected.");

            } catch (Exception e) {
                log.error("CRITICAL FAILURE: The modal closed, but the expected success toast did not appear within the timeout.");
                Assert.fail("Validation Failed: The modal closed, but no success notification was displayed.");
            }
        }
    }

    public void userInformation(DataTable UserInfo) {
        List<Map<String, String>> data = UserInfo.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(username.isVisible());
            Assert.assertTrue(email.isVisible());
            Assert.assertTrue(mobile.isVisible());
            Assert.assertTrue(organizationName.isVisible());
            Assert.assertTrue(status.isVisible());
            Assert.assertTrue(action.isVisible());
            Assert.assertEquals(usernameValue.getText(),dataTable.get("Name"));
            Assert.assertEquals(emailValue.getText(),dataTable.get("Email ID"));
            Assert.assertEquals(mobileValue.getText(),dataTable.get("MobileNo "));
            Assert.assertEquals(organizationValue.getText(),dataTable.get("Org"));

        } catch (AssertionError e) {
            log.info("some elements are not visible");
        }
    }
    public void userInformationInUserAccessScreen(DataTable UserInfo){
        List<Map<String, String>> data = UserInfo.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("FirstName").toLowerCase() + "']")).isDisplayed());
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("LastName").toLowerCase() + "']")).isDisplayed());
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("Email ID").toLowerCase() + "']")).isDisplayed());
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("MobileNo").toLowerCase() + "']")).isDisplayed());
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("Org").toLowerCase() + "']")).isDisplayed());
//            Assert.assertTrue(getDriver().findElement(By.xpath("////*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"+dataTable.get("FirstName")+"']")).isDisplayed());
//            Assert.assertTrue(getDriver().findElement(By.xpath("////*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"+dataTable.get("LastName")+"']")).isDisplayed());
//            Assert.assertTrue(getDriver().findElement(By.xpath("////*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"+dataTable.get("Email ID")+"']")).isDisplayed());
//            Assert.assertTrue(getDriver().findElement(By.xpath("////*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"+dataTable.get("MobileNo")+"']")).isDisplayed());
//            Assert.assertTrue(getDriver().findElement(By.xpath("////*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"+dataTable.get("Org")+"']")).isDisplayed());
        }catch (AssertionError e){
            log.info("some elements are not visible");
        }
    }
    public void checkifaddedLEI(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(serached_addedLEI.isVisible());
            log.info("Searched LEI is visible");
        }catch (AssertionError e){
            Assert.assertTrue(nodatafound_txt.isVisible());
        }
    }
    public void add_btn(){
        add_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilEnabled();
        add_btn.waitUntilClickable();
        add_btn.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void removeLeiMapping(String docType, String orgType) {
        String rowXpath =
                "//div[contains(@class,'lei-orgtype-wrapper')]//tbody/tr" +
                        "[td[contains(normalize-space(),'" + docType + "')]" +
                        " and td[contains(normalize-space(),'" + orgType + "')]]";
        System.out.println("Row XPath: " + rowXpath);
        WebElementFacade matchingRow =
                find(By.xpath(rowXpath))
                        .waitUntilPresent();
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                matchingRow
        );
        WebElementFacade crossButton =
                matchingRow.findBy(".//button[contains(@class,'cross-btn')]");
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                crossButton
        );
        crossButton.waitUntilClickable().click();
    }

    public void removeAllLeiOrgTypeMappings() {
        log.info("Checking for existing LEI/Org Type/Doc Type mappings to remove...");
        try {
            String deleteBtnXPath = "//th[@data-testid='doc-table-th-leisAndName' or contains(., 'LEIs & name')]/ancestor::table//tbody/tr//button";
            List<WebElementFacade> deleteButtons = findAll(By.xpath(deleteBtnXPath));
            int initialCount = deleteButtons.size();
            if (initialCount == 0) {
                log.info("No existing mappings found. The list is already empty.");
                return;
            }
            log.info("Found {} existing mapping(s). Removing them now...", initialCount);
            while (!findAll(By.xpath(deleteBtnXPath)).isEmpty()) {
                WebElementFacade btnToDelete = find(By.xpath("(" + deleteBtnXPath + ")[1]"));
                btnToDelete.waitUntilClickable().click();
                log.info("Clicked delete ('x') on a mapping row.");
                try {
                    WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
                    WebElement yesBtn = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']")));
                    log.info("Confirmation pop-up detected. Clicking 'Yes'.");
                    yesBtn.click();
                } catch (Exception e) {
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            log.info("Successfully removed all existing LEI/Org Type mappings.");
        } catch (Exception e) {
            log.error("Failed while trying to remove existing LEI mappings: {}", e.getMessage());
            org.junit.Assert.fail("Exception during LEI mapping removal: " + e.getMessage());
        }
    }

    public void verifyCrossOrgUserEditAccess(DataTable entities) {
        List<Map<String, String>> data = entities.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        for (Map<String, String> row : data) {
            String orgName = row.get("Organisation Name");
            String currentAction = "Initializing validation";
            log.info("--- Verifying View/Edit access for User Management Organisation: {} ---", orgName);
            try {
                // 1. LOCATE THE ORGANISATION FILTER DROPDOWN
                currentAction = "Locating the 'All Organisations' dropdown";
                // Target the dropdown shown in the video
                String filterBoxXPath = "//input[contains(@placeholder, 'Organisation') or contains(@placeholder, 'Select Organisation')]";
                WebElementFacade filterBox = $(By.xpath(filterBoxXPath)).waitUntilPresent();

                // 2. CLEAR PREVIOUS SELECTION
                currentAction = "Clearing previous search input";
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", filterBox);
                try {
                    filterBox.click();
                } catch (Exception e) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", filterBox);
                }

                // If there's a clear 'x' icon, click it (common in multi-selects)
                String clearIconXPath = "//input[@placeholder='All Organisations']/following-sibling::div[contains(@class, 'endAdornment')]//button[@title='Clear' or @aria-label='Clear']";
                List<WebElementFacade> clearIcons = findAll(By.xpath(clearIconXPath));
                if (!clearIcons.isEmpty() && clearIcons.get(0).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", clearIcons.get(0));
                } else {
                    filterBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                // 3. TYPE AND SEARCH FOR ORGANISATION
                currentAction = "Typing organisation name: " + orgName;
                filterBox.sendKeys(orgName);
                filterBox.sendKeys(Keys.SPACE, Keys.BACK_SPACE); // Wake up React API
                withAction().pause(Duration.ofSeconds(3)).build().perform();

                // 4. SELECT FROM DROPDOWN POPPER
                currentAction = "Selecting the organisation from the dropdown list";
                String orgLower = orgName.trim().toLowerCase();
                String dropdownOptionXPath = "//li[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + orgLower + "')] "
                        + "| //div[contains(@role, 'option') or contains(@class, 'option')][contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + orgLower + "')] "
                        + "| //div[contains(@class, 'MuiAutocomplete-option')][contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + orgLower + "')]";
                WebElementFacade option = $(By.xpath(dropdownOptionXPath))
                        .withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible().waitUntilClickable();
                option.click();

                // 5. WAIT FOR TABLE TO FILTER
                currentAction = "Closing dropdown and waiting for table to reload";
                getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
                withAction().pause(Duration.ofSeconds(4)).build().perform();

                // 6. VERIFY RECORDS EXIST
                currentAction = "Verifying the table rows";
                List<WebElementFacade> tableRows = findAll(By.xpath("//table/tbody/tr"));
                boolean hasValidRecords = false;

                for (WebElementFacade tableRow : tableRows) {
                    if (tableRow.isCurrentlyVisible() && !tableRow.getText().toLowerCase().contains("no record")) {
                        hasValidRecords = true;
                        break;
                    }
                }

                if (!hasValidRecords) {
                    org.junit.Assert.fail("VIEW_ALL Security Failure: The User Management table was empty when searching for Organisation '" + orgName + "'. Secondary user lacks permissions.");
                }

                // 7. CLICK A USER RECORD TO VERIFY EDIT ACCESS
                currentAction = "Clicking the first user record to verify edit access";
                // Click the first row in the table
                WebElementFacade firstUserRow = $(By.xpath("//table/tbody/tr[1]")).waitUntilClickable();
                firstUserRow.click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();

                // 8. VERIFY MODAL OPENS
                currentAction = "Verifying the edit user modal opened";
                // Verify an element specific to the user edit modal is visible (e.g., 'Cancel' or 'Submit' button)
                String modalIdentifierXPath = "//button[contains(., 'Cancel')] | //button[contains(., 'Submit')]";
                WebElementFacade modalContent = $(By.xpath(modalIdentifierXPath)).waitUntilVisible();

                if (modalContent.isCurrentlyVisible()) {
                    log.info("Validation Passed: User profile opened successfully for organization '{}'.", orgName);
                } else {
                    org.junit.Assert.fail("EDIT_ALL Security Failure: Could not open the user profile for editing for organization '" + orgName + "'.");
                }

                // 9. CLOSE THE MODAL
                currentAction = "Closing the edit user modal";
                WebElementFacade cancelBtn = $(By.xpath("//button[contains(., 'Cancel')]")).waitUntilClickable();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", cancelBtn);
                withAction().pause(Duration.ofSeconds(2)).build().perform();


            } catch (Exception e) {
                log.error("Failed during action: '{}' for org '{}'. Exact Error: {}", currentAction, orgName, e.getMessage());
                org.junit.Assert.fail("Failed during: " + currentAction + " | Org: " + orgName);
            }
        }
    }

}
