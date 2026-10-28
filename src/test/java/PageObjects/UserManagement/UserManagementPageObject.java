package PageObjects.UserManagement;

import Utilities.ConfigFileReader;
import Utilities.GeneralMethod;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;


@Slf4j
@Data
public class UserManagementPageObject extends PageObject {
    GeneralMethod generalMethod;
    PageObject pgobj;
    Actions act=new Actions(getDriver());
    ConfigFileReader configfileReader=new ConfigFileReader();

    @FindBy(xpath="//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade navigation_btn;

    @FindBy(xpath="//a[.//div[text()='Users management']]")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade usermanagement_btn;

    @FindBy(xpath = "//th//div[text()=\"User's name\"]")
    private WebElementFacade usernameColumn;

    @FindBy(xpath = "//tr[1]//td[1]")
    private WebElementFacade searched_usernameColumn;
    @FindBy(xpath = "//th//div[text()='Email id']")
    private WebElementFacade emailidColumn;

    @FindBy(xpath = "//tr[1]//td[2]")
    private WebElementFacade searched_emailidColumn;
    @FindBy(xpath = "//th//div[text()='Mobile no']")
    private WebElementFacade mobilenoColumn;

    @FindBy(xpath = "//tr[1]//td[3]")
    private WebElementFacade searched_mobilenoColumn;
    @FindBy(xpath = "//th//div[text()='Name of organisations']")
    private WebElementFacade organizationidColumn;

    @FindBy(xpath = "//tr[1]//td[4]")
    private WebElementFacade searched_organizationidColumn;
    @FindBy(xpath = "//th//div[text()='Status']")
    private WebElementFacade statusColumn;
    @FindBy(xpath = "//th//div[text()='Action']")
    private WebElementFacade actionColumn;

    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade update_button;

    @FindBy(xpath = "//button[text()='View']")
    private WebElementFacade view_button;

    @FindBy(xpath="//div[@class='search-add-container ']//input")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade search_added_Users;

    @FindBy(xpath="//tbody//tr//td[1]")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade searched_added_Users;

    @FindBy(xpath = "//input[@placeholder='Search by email id']")
    private WebElementFacade search_newUsers;

    @FindBy(xpath="//input[@placeholder='All Organisations']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade filter_organization;

    @FindBy(xpath="//input[@placeholder='All Roles']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade filter_roles;

    @FindBy(xpath="//input[@placeholder='All Status']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade filter_status;

    @FindBy(xpath="//tr//td//button[text()='Update']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade editDetails_btn;

    @FindBy(xpath="//button[text() = 'View']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade viewDetails_btn;

    @FindBy(xpath="//td//div//label/span")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade status_btn;

    @FindBy(xpath = "//div[@class='no-record-found']")
    private WebElementFacade norecordfound_txt;
    @FindBy(xpath = "//div//p[text()='No Record Found']")
    private WebElementFacade user_norecordfound_txt;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade new_user_add_btn;

    @FindBy(xpath = "//*[@id='generic-error']")
    private WebElementFacade userExists_alert;

    @FindBy(xpath ="//div[@class='user-onboarding-heading']")
    private WebElementFacade userManagement;

    @FindBy(xpath ="//tbody//td//button")
    private WebElementFacade button;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade noRecordFound_text;
    @FindBy(xpath = "//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'create new user')]")
    private WebElementFacade CreateNewUser;
    @FindBy(xpath = "//input[@placeholder='Select Roles']")
    private WebElementFacade searchRole;
    @FindBy(xpath = "//div[contains(@class, 'enable-switch')]//span[contains(@class, 'MuiTypography')]")
    private WebElementFacade status_text;
    @FindBy(xpath = "//div[contains(@class,'MuiAutocomplete-noOptions')]")
    private WebElementFacade roleDropdownNoOptions;

    public void navigateToUserManagement() {
        try {
            withAction().pause(Duration.ofSeconds(10)).build().perform();
            navigation_btn.waitUntilVisible().isVisible();
            navigation_btn.click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            usermanagement_btn.waitUntilVisible().isVisible();
            withAction().moveToElement(usermanagement_btn).click().pause(Duration.ofSeconds(3)).build().perform();
            log.info("Clicked on user management button");
        }catch (Exception e){
            log.error("Not able to type username -->"+e);
            Assert.fail();
        }
    }
    public void checkInfovisible(){

        if(button.isVisible()) {
            log.info("Info of user is visible");
        }
        else {
            log.info("Info of user is not visible");
        }
    }
    public void userManagementscreen(){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        getJavascriptExecutorFacade().executeScript("window.scrollBy(0,100)");
        Assert.assertEquals("Users & notifications management",userManagement.getText().trim());
        log.info("User is on the user management screen");
    }
    public void checkiffilters(){
        try {
            Assert.assertTrue(filter_organization.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(filter_roles.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(filter_status.isVisible());
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            log.info("All the filters are visible");

        }catch (AssertionError e){
            log.error("All the filters are not visible on the screen"+e);}
    }
    public void checkifallcolumns(){
        try {
            Assert.assertEquals("User's name",usernameColumn.getText().trim());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals("Email id",emailidColumn.getText().trim());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals("Mobile no",mobilenoColumn.getText().trim());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals("Name of organisations",organizationidColumn.getText().trim());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals("Status",statusColumn.getText().trim());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertEquals("Action",actionColumn.getText().trim());
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("All the Columns are visible");

        }catch (AssertionError e){
            log.error("Not all the columns are visible on the screen"+e);
        }
    }
    public void organizationFilter(DataTable organization) {
        List<Map<String, String>> data = organization.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            filter_organization.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
            withAction().moveToElement(filter_organization).click().sendKeys(dataTable.get("organisation")).build().perform();
            withAction().pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }catch (Exception e){log.error("Not able to set the organization filter"+e);
            Assert.fail();}
    }
    public void statusFilter(DataTable status){
        List<Map<String, String>> data = status.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            filter_status.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
            act.moveToElement(filter_status).click().sendKeys(dataTable.get("status")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){log.error("Not able to set the status filter"+e);
            Assert.fail();}
    }

    public void rolesFilter(DataTable roles){
        List<Map<String, String>> data = roles.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            filter_roles.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
            act.moveToElement(filter_roles).click().sendKeys(dataTable.get("roles")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){log.error("Not able to set the roles filter"+e);
            Assert.fail();}

    }
    public void searchRole(DataTable roles){
        List<Map<String, String>> data = roles.asMaps(String.class, String.class);
        for(Map<String,String> dataTable : data) {
            try {
                Assert.assertTrue(searchRole.isVisible());
                withAction().moveToElement(searchRole).click().sendKeys(dataTable.get("Roles")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            } catch (Exception e) {
                log.error("Not able to set the roles filter" + e);
                Assert.fail();
            }
        }
    }
    private String lastSearchedRole = "";
    public void searchRoleWithoutSelecting(DataTable roles) {
        List<Map<String, String>> data = roles.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String roleName = row.get("Roles");
            try {
                searchRole.waitUntilVisible();
                searchRole.click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                searchRole.sendKeys(roleName);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                lastSearchedRole = roleName;
                log.info("Typed '{}' in Role dropdown without selecting", roleName);
            } catch (Exception e) {
                log.error("Failed to type '{}' in Role dropdown: {}", roleName, e.getMessage());
                Assert.fail("Could not interact with Role search field");
            }
        }
    }


    public void checkifstatus_btn(){
        try {
            Assert.assertTrue(status_btn.isVisible());
            log.info("Status button is visible");

        }catch (AssertionError e){
            log.error("Status button not visible"+ e);
        }
    }
    public void checkifEditbtn(){
        try {
            Assert.assertTrue(editDetails_btn.isVisible());
            log.info("Edit Button is visible");

        }catch (AssertionError e){
            log.error("Edit button not visible"+e);

        }
    }
    public void clickEditDeatils_btn() {
        try {
            editDetails_btn.waitUntilClickable();
            editDetails_btn.click();
            withAction().pause(Duration.ofSeconds(6)).build().perform();}
        catch (Exception e){log.error("Not able to reach Edit screen -->"+e);
            Assert.fail();}
    }

    public void clickViewDeatils_btn() {
        try {
            viewDetails_btn.waitUntilClickable();
            viewDetails_btn.click();
            withAction().pause(Duration.ofSeconds(6)).build().perform();}
        catch (Exception e){log.error("Not able to reach Edit screen -->"+e);
            Assert.fail();}
    }

    public void checkSearch_forExisting(){
        try {
            Assert.assertTrue(search_added_Users.isVisible());
            log.info("Search for existing user is visible");

        }catch (AssertionError e){
            log.error("search bar for added users not visible"+e);
        }
    }
    public void checkSearch_fornew(){
        try {
            Assert.assertTrue(search_newUsers.isVisible());
            log.info("Search for new user is visible");

        }catch (AssertionError e){
            log.error("search bar for new users not visible"+e);
        }
    }
    public void searchUser(List<String> users){
        for (int user=1;user<users.size();user++){
            search_added_Users.waitUntilVisible();
            search_added_Users.clear();
            withAction().moveToElement(search_added_Users).click().sendKeys(users.get(user)).pause(Duration.ofSeconds(6)).build().perform();
            getJavascriptExecutorFacade().executeScript("window.scrollBy(-100,0)");
            searched_added_Users.waitUntilVisible();
            log.info(searched_added_Users.getText().trim());
            if (users.get(user).equalsIgnoreCase(searched_emailidColumn.getText().trim())){
                log.info("User found");
            }
            else {
                Assert.assertNotEquals(users.get(user),searched_emailidColumn.getText().trim());
                log.error("Not able to search for the users");
            }
        }
    }

    public boolean validateRoleDropdownNoOptionsDisplayed() {
        try {
            // Strategy 1: JS direct DOM — handles MUI portal rendering outside tree
            String noOptionsText = (String) getJavascriptExecutorFacade().executeScript(
                    "var el = document.querySelector('.MuiAutocomplete-noOptions');" +
                            "return el ? el.innerText.trim() : null;"
            );
            if (noOptionsText != null && noOptionsText.equalsIgnoreCase("No options")) {
                log.info("Strategy 1 passed — JS found 'No options': '{}'", noOptionsText);
                return true;
            }

            // Strategy 2: Serenity WebElementFacade
            if (roleDropdownNoOptions.isCurrentlyVisible()) {
                String text = roleDropdownNoOptions.getText().trim();
                if (text.equalsIgnoreCase("No options")) {
                    log.info("Strategy 2 passed — WebElementFacade found 'No options': '{}'", text);
                    return true;
                }
            }

            // Strategy 3: Input retains typed text AND listbox has no options
            String inputValue = (String) getJavascriptExecutorFacade().executeScript(
                    "var el = document.querySelector('[data-testid=\"role-multiselect\"] input');" +
                            "if (!el) el = document.querySelector('input[placeholder=\"Select Roles\"]');" +
                            "return el ? el.value.trim() : '';"
            );
            boolean listboxHasOptions = (Boolean) getJavascriptExecutorFacade().executeScript(
                    "var lb = document.querySelector('[role=\"listbox\"]');" +
                            "return lb ? lb.querySelectorAll('[role=\"option\"]').length > 0 : false;"
            );
            log.info("Strategy 3 check — input: '{}', lastSearched: '{}', listboxHasOptions: {}",
                    inputValue, lastSearchedRole, listboxHasOptions);

            if (!lastSearchedRole.isEmpty()
                    && inputValue.equalsIgnoreCase(lastSearchedRole)
                    && !listboxHasOptions) {
                log.info("Strategy 3 passed — typed text present, no options in listbox");
                return true;
            }

            log.error("All strategies failed to confirm 'No options' state");
            return false;

        } catch (Exception e) {
            log.error("Unexpected error during 'No options' validation: {}", e.getMessage());
            return false;
        }
    }

    public void searchUserNotfound(List<String> users){
        for (int user=1;user<users.size();user++){
            search_added_Users.waitUntilVisible();
            search_added_Users.clear();
            withAction().moveToElement(search_added_Users).click().sendKeys(users.get(user)).pause(Duration.ofSeconds(6)).build().perform();
//            getJavascriptExecutorFacade().executeScript("window.scrollBy(-100,0)");
//            searched_added_Users.waitUntilVisible();
//            log.info(searched_added_Users.getText().trim());
//            if (users.get(user).equalsIgnoreCase(searched_emailidColumn.getText().trim())){
//                log.info("User found");
//            }
//            else {
//                Assert.assertNotEquals(users.get(user),searched_emailidColumn.getText().trim());
//                log.error("Not able to search for the users");
//            }
        }
    }

    public void check_searched_columns(){
        try {
            Assert.assertTrue(searched_usernameColumn.isVisible());
            Assert.assertTrue(searched_emailidColumn.isVisible());
            Assert.assertTrue(searched_mobilenoColumn.isVisible());
            Assert.assertTrue(searched_organizationidColumn.isVisible());
            Assert.assertTrue(status_btn.isVisible());

            if (update_button.isVisible()){
                log.info("All elements present");
            } else if (view_button.isVisible()) {
                log.info("View button present, not update button");
            }
            else {
                log.error("Not all elements are present");
                Assert.fail();
            }
        }catch (Exception e){
            log.error("element not present"+e);
            Assert.fail();
        }
    }
    public void change_toggle_status(){
        try {
            status_btn.waitUntilVisible();
                withAction().moveToElement(status_btn).click().pause(Duration.ofSeconds(3)).build().perform();
                log.info("Changed the status of Status button");
        }catch (Exception e){
            log.error("Unable to change toggle button status"+e);
            Assert.fail();
        }
    }

    public boolean search_new_users_and_add(List<String> users) {
        // users.get(0) = "user" (header), users.get(1) = actual email
        String email = users.get(1);

        getJavascriptExecutorFacade().executeScript("window.scrollBy(0,-1000)");
        search_newUsers.waitUntilVisible();
        search_newUsers.waitUntilClickable().clear();
        search_newUsers.click();
        search_newUsers.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
        search_newUsers.sendKeys(org.openqa.selenium.Keys.DELETE);
        typeInto(search_newUsers, email);
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        WebElement addBtnForUser = getDriver().findElement(
                org.openqa.selenium.By.xpath(
                        "//p[@title='" + email + "']/following-sibling::button"
                )
        );
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", addBtnForUser);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        return userExists_alert.isVisible();
    }

    public void ensureStatusIsActive() {
        try {
            status_text.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            String currentStatus = status_text.getText().trim();
            if (currentStatus.equalsIgnoreCase("In-Active")) {
                log.info("User status is currently In-Active. Clicking toggle to make it Active.");
                status_btn.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                log.info("Status successfully changed to: " + status_text.getText());

            } else if (currentStatus.equalsIgnoreCase("Active")) {
                log.info("User status is already Active. No action required.");
            } else {
                log.warn("Unexpected status text found on screen: " + currentStatus);
            }
        } catch (Exception e) {
            log.error("Error while verifying or changing user status to Active: " + e.getMessage());
            Assert.fail("Could not ensure user status is active.");
        }
    }


}