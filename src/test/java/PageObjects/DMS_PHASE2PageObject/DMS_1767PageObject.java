package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data

public class DMS_1767PageObject extends PageObject {


    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRole_list;

    @FindBy(xpath="//span[@class='lei-name']")
    private WebElementFacade check_LEIName;

    @FindBy(xpath="//tbody//button[@class='cross-btn']")
    private WebElementFacade cross_btn;

    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade YES_Btn_confirmation;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;

    @FindBy(xpath="//div[@class='search-add-container ']//input")
    private WebElementFacade search_added_Users;

    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade update_btn;

    @FindBy(xpath="//div[@role='alert']//div[text()='Updated Successfully']")
    private WebElementFacade checkNotification_Updated;

    @FindBy(xpath="//button[text()='Request to create new document']")
    private WebElementFacade requestDocumentCreation_btn;

    @FindBy(xpath = "//input[@placeholder='Select Roles']")
    private WebElementFacade roleMapping;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElementFacade PopUp_Body;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade PopUp_Yes_button;

    @FindBy(xpath = "//input[@placeholder='Select Doc type']")
    private WebElementFacade select_docType;

    @FindBy(xpath = "//p[text()='4 Way']")
    private WebElementFacade fourWay_text;

    @FindBy(xpath = "//p[text()='DN']")
    private WebElementFacade DN_text;

    @FindBy(xpath = "//input[@placeholder='Select Orgtype']")
    private WebElementFacade actingAs_dropdown;

    @FindBy(xpath = "//div[text()='Allowed currencies']")
    private WebElementFacade allowedCurrencies_text;

    @FindBy(xpath = "//label[@class='csm_checkbox']")
    private WebElementFacade allowedCurrencies_checkbox;

    @FindBy(xpath = "//button[text()='Discard']")
    private WebElementFacade discard_btn;

    @FindBy(xpath = "//button[text()='Submit Request']")
    private WebElementFacade submitRequest_btn;

    @FindBy(xpath = "//div[text()='Select Prime Broker - 2']")
    private WebElementFacade primeBroker2_filter;

    @FindBy(xpath = "//div[text()='Select Client - 2']")
    private WebElementFacade Client2Filter;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElementFacade popup_alert;

    @FindBy(xpath = "//div[text()='Select']")
    private WebElementFacade select_Reviewer;

    @FindBy(xpath = "//div[@class='message']")
    private WebElementFacade messageRequest_documentCreation;

    @FindBy(xpath = "//button[text()='Got it']")
    private WebElementFacade GotIt_btn;

    @FindBy(xpath = "//strong[text()='Documents access request']")
    private WebElementFacade documentAccessRequest;

    @FindBy(xpath = "//p[text()='Client']")
    private WebElementFacade client_text;

    @FindBy(xpath = "//p[text()='Define reviewer']")
    private WebElementFacade defineReviewer_text;

    @FindBy(xpath = "//label[text()='Select reviewer']")
    private WebElementFacade selectReviewer_text;

    @FindBy(xpath = "//button[text()='+ Create new document']")
    private WebElementFacade create_NewDocument;

    @FindBy(xpath = "//div[text()='Request to create new document']")
    private WebElementFacade requestCreateNewDocument_text;


    public void removeRole(List<String> roles) {
        try {
            // first ! check if the role is selected in the already selected list,if yes-->> go to next role

            for (int begin=1;begin<roles.size();begin++){
                log.info(selectedRole_list.getText());
                if (selectedRole_list.getText().contains(roles.get(begin))){
                    if (roleMapping.isVisible()) {
                        log.info("Role Mapping dropdown is visible");
                    }
                    else {
                        log.info("Role Mapping dropdown not visible");
                    }
                    roleMapping.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    roleMapping.clear();
                    withAction().moveToElement(roleMapping).click().sendKeys(roles.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();

                    if (PopUp_Body.isVisible()){
                        PopUp_Yes_button.click();
                    }
                }
                else {
                    continue;
                }
            }
            //if role not selected, user will search and select the role
        }catch (Exception e){
            Assert.fail("User was unable to set the desired roles"+e);
        }
    }
    public void checkCombination_present(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            if (check_LEIName.isVisible()){
                cross_btn.click();
                YES_Btn_confirmation.waitUntilVisible();
                YES_Btn_confirmation.click();
                submit_btn.waitUntilEnabled();
                submit_btn.click();
                withAction().pause(Duration.ofSeconds(8)).build().perform();
                search_added_Users.waitUntilVisible();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(search_added_Users).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(search_added_Users).click().sendKeys(dataTable.get("User")).pause(Duration.ofSeconds(3)).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                update_btn.waitUntilVisible();
                update_btn.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            else{
                if (submit_btn.isEnabled()) {
                    submit_btn.click();
                    withAction().pause(Duration.ofSeconds(8)).build().perform();
                }
                else {
                    getDriver().navigate().back();
                }
                    search_added_Users.waitUntilVisible();
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().moveToElement(search_added_Users).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().moveToElement(search_added_Users).click().sendKeys(dataTable.get("User")).pause(Duration.ofSeconds(3)).build().perform();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    update_btn.waitUntilVisible();
                    update_btn.click();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to remove the combination" +e);
            Assert.fail();
        }
    }
    public void enter_docType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_docType.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            select_docType.clear();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_docType).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the Doc type -->"+e);
            Assert.fail();
        }
    }
    public void enter_actingAs(){
        try {
            actingAs_dropdown.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(actingAs_dropdown).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to select acting as");
            Assert.fail();
        }
    }
    public void randomEnterPrimeBroker2(){
        try {
            Random random = new Random();
            int randNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber"  +  randNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(primeBroker2_filter).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Prime Broker 2" +e);
            Assert.fail();
        }
    }
    public void randomEnterClient2() {
        try {
            Random random = new Random();
            int randNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber"  +  randNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(Client2Filter).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Client 2 " +e);
            Assert.fail();
        }
    }
    public void select_Reviewer(){
        try {
            select_Reviewer.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_Reviewer).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select reviewer -->"+e);
            Assert.fail();
        }
    }
    public void input_Reviewer(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_Reviewer.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_Reviewer).click().sendKeys(dataTable.get("Select Reviewer")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select reviewer -->"+e);
            Assert.fail();
        }
    }
    public void clickSelectPartiesAsPB2(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            primeBroker2_filter.waitUntilVisible();
            withAction().moveToElement(primeBroker2_filter).click().sendKeys(dataTable.get("Prime Broker 2")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
        }catch (Exception e){
            log.info("Unable to select Parties as PB2-->"+e);
            Assert.fail();
        }
    }
    public void input_actingAs(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            actingAs_dropdown.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(actingAs_dropdown).click().sendKeys(dataTable.get("Acting as")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
        }catch (Exception e){
            log.error("Unable to select acting as");
            Assert.fail();
        }
    }
}
