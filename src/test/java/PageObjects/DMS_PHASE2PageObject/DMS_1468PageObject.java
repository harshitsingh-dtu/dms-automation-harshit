package PageObjects.DMS_PHASE2PageObject;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Switch;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Slf4j
public class DMS_1468PageObject extends PageObject {
    Random random=new Random();
    boolean skipFirst = true;
@FindBy(xpath = "//input[@placeholder='Select Doc Type']")
private WebElementFacade doctype_filter;
@FindBy(xpath = "//th[text()='Doc type']")
private WebElementFacade doctype_column;
@FindBy(xpath = "//div[@class='all-status']//button")
private WebElementFacade LEIOrgtypestatusmapping_list;
@FindBy(xpath = "//div[@role='presentation']//ul")
private WebElementFacade doctype_filter_list;
@FindBy(xpath = "//tr/td[3]")
private List<WebElementFacade> doctype_column_list;
@FindBy(xpath = "//button[@title='Clear']")
private WebElementFacade doctype_Filter_clear;
@FindBy(xpath = "//div[@class='info-head']")
private List<WebElementFacade> staticdata_heading_list;
@FindBy(xpath = "//div[@class='info-head']")
private List<WebElementFacade> staticdata_value_list;
@FindBy(xpath = "//tbody//tr//td[1]")
private List<WebElementFacade> LEIid_list_listingscreen;
@FindBy(xpath = "//input[@placeholder='Search by LEI id or organisation name']")
private WebElementFacade search_LEI;
@FindBy(xpath="//button[text()='Update']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
private WebElementFacade update_btn;
@FindBy(xpath = "//input[@placeholder=\"Search by LEI's id or name\"]")//input[@placeholder='Search by LEIs id or name']
private WebElementFacade search_LEI_onUpdatescreen;//input[@placeholder="Search by LEI's id or name"]
@FindBy(xpath = "//tbody//td[1]")
private List <WebElementFacade> LEIid_list_onUpdatescreen;
@FindBy(xpath = "//table//thead//th[text()='Org type status']//following::th")
private List<WebElementFacade> Orgtype_status_list;
@FindBy(xpath = "//thead//th[1]//button[@value='Lite']")
private WebElementFacade FourWay_PB_Lite_button;
@FindBy(xpath = "//thead//th[1]//button[text()='Neutral']")
private WebElementFacade FourWay_PB_Neutral_button;
@FindBy(xpath = "//thead//th[1]//button[text()='Online']")
private WebElementFacade FourWay_PB_Online_button;
    @FindBy(xpath = "//thead//th[2]//button[@value='Lite']")
    private WebElementFacade FourWay_Client_Lite_button;
    @FindBy(xpath = "//thead//th[2]//button[text()='Neutral']")
    private WebElementFacade FourWay_Client_Neutral_button;
    @FindBy(xpath = "//thead//th[2]//button[text()='Online']")
    private WebElementFacade FourWay_Client_Online_button;
    @FindBy(xpath = "//thead//th[1]//button[@value='Lite']")
    private WebElementFacade DN_PB_Lite_button;
    @FindBy(xpath = "//thead//th[1]//button[text()='Neutral']")
    private WebElementFacade DN_PB_Neutral_button;
    @FindBy(xpath = "//thead//th[1]//button[text()='Online']")
    private WebElementFacade DN_PB_Online_button;
    @FindBy(xpath = "//thead//th[2]//button[@value='Lite']")
    private WebElementFacade DN_EB_Lite_button;
    @FindBy(xpath = "//thead//th[2]//button[text()='Neutral']")
    private WebElementFacade DN_EB_Neutral_button;
    @FindBy(xpath = "//thead//th[2]//button[text()='Online']")
    private WebElementFacade DN_EB_Online_button;
    @FindBy(xpath = "//thead//th[3]//button[@value='Lite']")
    private WebElementFacade DN_Client_Lite_button;
    @FindBy(xpath = "//thead//th[3]//button[text()='Neutral']")
    private WebElementFacade DN_Client_Neutral_button;
    @FindBy(xpath = "//thead//th[3]//button[text()='Online']")
    private WebElementFacade DN_Client_Online_button;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_button_organisationUpdate;

  // Flag to skip the first item

    @FindBy(xpath = "//tbody//tr")
    private List<WebElementFacade> LEIid_list;
    @FindBy(xpath = "//tbody//tr[1]//td[4]")
    private WebElementFacade FourWay_PB;
    @FindBy(xpath = "//tbody//tr[1]//td[5]")
    private WebElementFacade FourWay_Client;
    @FindBy(xpath = "//tbody//tr[1]//td[6]")
    private WebElementFacade DN_PB;
    @FindBy(xpath = "//tbody//tr[1]//td[8]")
    private WebElementFacade DN_Client;
    @FindBy(xpath = "//tbody//tr[1]//td[7]")
    private WebElementFacade DN_EB;
    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    private WebElementFacade LEI_name;
    @FindBy(xpath = "(//div[@role='dialog']//button[text()='Yes'])[1]")//div[@role='dialog']//button[text()='Yes']
    private WebElementFacade confirmation_yes_btn;//div[@role='dialog']//button[text()='Yes'])[1]
    @FindBy(xpath = "//div[@role='dialog']//button[text()='No']")
    private WebElementFacade confirmation_no_btn;

    @FindBy(xpath = "//div[text()=\"Are you sure you want to proceed?\"]")
    private WebElementFacade sureelement;
    @FindBy(xpath = "//div[contains(text(),'Are you sure you want to proc')]")
    private WebElementFacade popupelement;
    @FindBy(xpath = "//div[text()=\"Status Updated successfully\"]")
    private WebElementFacade successmessage;


    @FindBy(xpath = "//div[@class='status-container']//thead//th[1]//button[@value='Lite']")
    private WebElementFacade side_window_PB_Lite_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[1]//button[text()='Neutral']")
    private WebElementFacade side_window_PB_Neutral_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[1]//button[text()='Online']")
    private WebElementFacade side_window_PB_Online_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[2]//button[@value='Lite']")
    private WebElementFacade side_window_EB_Lite_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[2]//button[text()='Neutral']")
    private WebElementFacade side_window_EB_Neutral_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[2]//button[text()='Online']")
    private WebElementFacade side_window_EB_Online_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[3]//button[@value='Lite']")
    private WebElementFacade side_window_Client_Lite_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[3]//button[text()='Neutral']")
    private WebElementFacade side_window_Client_Neutral_button;
    @FindBy(xpath = "//div[@class='status-container']//thead//th[3]//button[text()='Online']")
    private WebElementFacade side_window_Client_Online_button;


     // Flag to skip the first item
    public void check_status_present(List<String> list){
    try {
        boolean skipFirst = true;
        for(String item: list){
            if (skipFirst) {
                skipFirst = false;  // Unset the flag after skipping the first item
                continue;           // Continue to the next iteration
            }
            find(LEIOrgtypestatusmapping_list+"[text()='"+item+"']").isVisible();

        }
    }catch (Exception e){
        log.error("Can't get the LEI Org type status mapping list"+e);
        Assert.fail();
    }
}
public void check_doctype_filter_list(List<String> list){
        String fiter_list=doctype_filter_list.getText();
    boolean skipFirst = true;
    for(String item: list){
            if (skipFirst) {
                skipFirst = false;  // Unset the flag after skipping the first item
                continue;           // Continue to the next iteration
            }
            if (fiter_list.contains(item)) {
                continue;
            }
            else {
                log.error("Doc types do not match");
                Assert.fail();
            }

        }
}
public void select_doc_type_and_checkresult_inLEImappingtable(List<String> list){
    boolean skipFirst = true;
    for(String item: list){
        if (skipFirst) {
            skipFirst = false;  // Unset the flag after skipping the first item
            continue;           // Continue to the next iteration
        }
        doctype_filter.clear();
        withAction().moveToElement(doctype_filter).click().sendKeys(item).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=doctype_column_list.size()-1;i++){
            if (!doctype_column_list.get(i).getText().equalsIgnoreCase(item)){
                Assert.fail();
            }
        }

    }
}


public void verify_static_information(){
        try {
    List<String> headings= new ArrayList<>();
    List<String> values= new ArrayList<>();
    doctype_filter.waitUntilVisible();
    for (int item=1;item<=staticdata_heading_list.size()-1;item++){
            headings.add(staticdata_heading_list.get(item).getText());
            values.add(staticdata_value_list.get(item).getText());
            if (item==staticdata_heading_list.size()){
                withAction().moveToElement(doctype_filter).click().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.RETURN).pause(Duration.ofSeconds(3)).build().perform();
                for (int check=1;check<=staticdata_heading_list.size();check++){
                    Assert.assertTrue(headings.contains(staticdata_heading_list.get(check).getText()));
                    Assert.assertTrue(values.contains(staticdata_value_list.get(check).getText()));
                }
            }
        }
}catch (Exception e){
        log.error("Static information does not match after change in filter"+e);
        Assert.fail();}
}
public void click_on_random_Organisation_Update_button(){
        try {
            int list_item=random.nextInt(LEIid_list_listingscreen.size());
            withAction().moveToElement(search_LEI).click().sendKeys(LEIid_list_listingscreen.get(list_item).getText()).moveToElement(update_btn).click().build().perform();
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }

}
  public void   search_for_lei_id_or_name_that_belongs_to_doc_type_searched(){
        try {
            int list_item=random.nextInt(LEIid_list_onUpdatescreen.size());
            withAction().moveToElement(search_LEI_onUpdatescreen).click().sendKeys(LEIid_list_onUpdatescreen.get(list_item).getText()).build().perform();
            if (LEIid_list_onUpdatescreen.isEmpty()){
                Assert.fail();
            }
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
  }
    public void search_for_lei_id_or_name_that_does_not_belong_to_doc_type_searched(List<String>list){
        try {
            search_LEI_onUpdatescreen.clear();
            withAction().moveToElement(search_LEI_onUpdatescreen).click().sendKeys(list.get(1)).build().perform();
            if (LEIid_list_onUpdatescreen.isEmpty()){
                Assert.fail();
            }
            else if (find(By.xpath("//tbody//tr[1]")).getText().equalsIgnoreCase("No Record Found")){
                Assert.fail();
            }
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void check_orgtype_onOrganisationUpdatescreen(List<String>list){
        try {
            for (String item:list){
                for (int index=1;index<=Orgtype_status_list.size()-1;){
                    if (!Orgtype_status_list.get(index).getText().equalsIgnoreCase(item)){
                        if (index<Orgtype_status_list.size()){
                            index++;
                        } else if (index== Orgtype_status_list.size()) {
                            Assert.fail();
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void Bulk_update_for_PB_toOnline(){
       try {
           if (doctype_filter.getText().equalsIgnoreCase("DN")){
               withAction().moveToElement(DN_PB_Online_button).click().build().perform();
           }
           else {
               withAction().moveToElement(FourWay_PB_Online_button).click().build().perform();
           }

       }catch (Exception e){
           log.error(""+e);
           Assert.fail();
       }
    }
    public void Bulk_update_for_PB_toLite(){
        try {
            if (doctype_filter.getText().equalsIgnoreCase("DN")){
                withAction().moveToElement(DN_PB_Lite_button).click().build().perform();
            }
            else {
                withAction().moveToElement(FourWay_PB_Lite_button).click().build().perform();
            }
            confirmation_yes_btn.waitUntilClickable();
            withAction().moveToElement(confirmation_yes_btn).click().build().perform();

        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void Bulk_update_for_Client_toOnline(){
        try {
            if (doctype_filter.getText().equalsIgnoreCase("DN")){
                withAction().moveToElement(DN_Client_Online_button).click().build().perform();
            }
            else {
                withAction().moveToElement(FourWay_Client_Online_button).click().build().perform();
            }

        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void Bulk_update_for_Client_toLite(){
        try {
            if (doctype_filter.getText().equalsIgnoreCase("DN")){
                withAction().moveToElement(DN_Client_Lite_button).click().build().perform();
            }
            else {
                withAction().moveToElement(FourWay_Client_Lite_button).click().build().perform();
            }
            confirmation_yes_btn.waitUntilClickable();
            withAction().moveToElement(confirmation_yes_btn).click().build().perform();

        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void Bulk_update_for_EB_toOnline(){
        try {
                withAction().moveToElement(DN_EB_Online_button).click().build().perform();
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void Bulk_update_for_EB_toLite(){
        try {
            withAction().moveToElement(DN_EB_Lite_button).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            confirmation_yes_btn.waitUntilClickable();
            withAction().moveToElement(confirmation_yes_btn).click().build().perform();
        }catch (Exception e){
            log.error(""+e);
            Assert.fail();
        }
    }
    public void search_random_LEIid(){
        int list_item=random.nextInt(LEIid_list_onUpdatescreen.size());
        withAction().moveToElement(search_LEI_onUpdatescreen).click().sendKeys(LEIid_list_onUpdatescreen.get(list_item).getText()).pause(Duration.ofSeconds(4)).build().perform();
    }
//public void clickSubmit()
//{
//    withAction().moveToElement(getSubmit_button_organisationUpdate()).click().pause(Duration.ofSeconds(1)).build().perform();
//
//}
//public void clickSubmit() {
//    getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", getSubmit_button_organisationUpdate());
//    withAction().pause(Duration.ofMillis(500)).build().perform();
//    getJavascriptExecutorFacade().executeScript("arguments[0].click();", getSubmit_button_organisationUpdate());
//}

    public void clickSubmit() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", getSubmit_button_organisationUpdate());
        withAction().pause(Duration.ofMillis(500)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", getSubmit_button_organisationUpdate());
    }
public void validateSuccess()
{
    getSuccessmessage().waitUntilVisible().isVisible();
}
//    public void bulk_LEI_changeStatusTo_Online(List<String> list) {
//        try {
//            String docType = doctype_filter.getText();
//            String role = list.get(1).trim();
//
//            if (docType.equalsIgnoreCase("DN")) {
//                if (role.equalsIgnoreCase("PB")) {
//                    handleLiteToOnlineUpdate(DN_PB_Online_button);
//                } else if (role.equalsIgnoreCase("EB")) {
//                    handleLiteToOnlineUpdate(DN_EB_Online_button);
//                } else if (role.equalsIgnoreCase("Client")) {
//                    handleLiteToOnlineUpdate(DN_Client_Online_button);
//                }
//            } else {
//                // Correctly placed FourWay logic
//                if (role.equalsIgnoreCase("PB")) {
//                    handleLiteToOnlineUpdate(FourWay_PB_Online_button);
//                } else if (role.equalsIgnoreCase("Client")) {
//                    handleLiteToOnlineUpdate(FourWay_Client_Online_button);
//                }
//            }
//        } catch (Exception e) {
//            log.error("Error in LEI_changeStatusTo_Online: " + e.getMessage());
//            Assert.fail("Function failed: " + e.getMessage());
//        }
//    }

    /**
     * Helper method to handle the specific click-and-confirm logic for Online status
     */
    private void handleLiteToOnlineUpdate(WebElement element) {

            withAction().moveToElement(element).click().build().perform();

            // Fixed: Ensure the confirmation button is actually clicked

            clickSubmit();
            validateSuccess();
            log.info("Status updated from Lite to Online successfully.");

    }
//    public void bulk_LEI_changeStatusTo_Lite(List<String> list) {
//
//        String docType = doctype_filter.getValue();
//        String role = list.get(1).trim();
//
//        if (docType.equalsIgnoreCase("DN")) {
//            if (role.equalsIgnoreCase("PB")) {
//                handleOnlinetoLiteUpdate(DN_PB_Lite_button);
//            } else if (role.equalsIgnoreCase("EB")) {
//                handleOnlinetoLiteUpdate(DN_EB_Lite_button);
//            } else if (role.equalsIgnoreCase("Client")) {
//                handleOnlinetoLiteUpdate(DN_Client_Lite_button);
//            }
//        } else {
//            // Correctly placed FourWay logic
//            if (role.equalsIgnoreCase("PB")) {
//                handleOnlinetoLiteUpdate(FourWay_PB_Lite_button);
//            } else if (role.equalsIgnoreCase("Client")) {
//                handleOnlinetoLiteUpdate(FourWay_Client_Lite_button);
//            }
//        }
//
//    }
//    public void LEI_changeStatusTo_Lite(List<String> list) {
//
//            String docType = doctype_filter.getValue();
//            String role = list.get(1).trim();
//
//            if (docType.equalsIgnoreCase("DN")) {
//                if (role.equalsIgnoreCase("PB")) {
//                    handleOnlinetoLiteUpdate(DN_PB);
//                } else if (role.equalsIgnoreCase("EB")) {
//                    handleOnlinetoLiteUpdate(DN_EB);
//                } else if (role.equalsIgnoreCase("Client")) {
//                    handleOnlinetoLiteUpdate(DN_Client);
//                }
//            } else {
//                // Correctly placed FourWay logic
//                if (role.equalsIgnoreCase("PB")) {
//                    handleOnlinetoLiteUpdate(FourWay_PB);
//                } else if (role.equalsIgnoreCase("Client")) {
//                    handleOnlinetoLiteUpdate(FourWay_Client);
//                }
//            }
//
//    }

    /**
     * Helper method to handle the specific click-and-confirm logic for Online status
     */
//    private void handleOnlinetoLiteUpdate(WebElement element) {
//
//            withAction().moveToElement(element).click().build().perform();
//
//            // Fixed: Ensure the confirmation button is actually clicked
//        try {
//            confirmation_yes_btn.waitUntilClickable();
//            withAction().moveToElement(confirmation_yes_btn).click().build().perform();
//            log.info("Status Changed to Lite ");
//        } catch (Exception e) {
//                        log.info("Status Changed to Online ");
//        }
//        finally {
//            clickSubmit();
//            validateSuccess();
//        }
//
//
//
//    }

    /**
     * Helper method to handle the specific click-and-confirm logic for Lite status
     */
    private void handleOnlinetoLiteUpdate(WebElementFacade liteBtn, WebElementFacade onlineBtn) {
        log.info("Attempting to change bulk status to Lite...");

        // --- PRE-ACTION SCROLL ---
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", liteBtn);
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        // 1. JS Click the Bulk Lite button (Headless safe)
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", liteBtn);
        withAction().pause(Duration.ofSeconds(1)).build().perform(); // Give React time to calculate state

        // 2. Handle the warning popup if it appears
        try {
            if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        } catch (Exception ignored) {}

        // 3. SMART RESET CHECK: Check true DOM attributes for disabled state
        boolean isSubmitDisabled = !getSubmit_button_organisationUpdate().isEnabled() || getSubmit_button_organisationUpdate().getAttribute("disabled") != null;

        if (isSubmitDisabled) {
            log.info("Submit button is disabled. Organization was ALREADY Lite! Performing Smart Reset to Online...");

            // --- RESET PHASE ---
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", onlineBtn);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", onlineBtn);

            try {
                if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                }
            } catch (Exception ignored) {}

            clickSubmit();
            validateSuccess();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

            // --- ACTUAL TEST PHASE ---
            log.info("State reset to Online. Now clicking Bulk Lite again to validate the transition...");
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", liteBtn);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", liteBtn);

            try {
                if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            } catch (Exception ignored) {}
        }

        // 4. Final Submit and Validate
        clickSubmit();
        validateSuccess();
        log.info("Successfully validated transition to Lite.");
    }

    /**
     * Helper method to handle the specific click-and-confirm logic for Online status
     */
    private void handleLiteToOnlineUpdate(WebElementFacade onlineBtn, WebElementFacade liteBtn) {
        log.info("Attempting to change bulk status to Online...");

        // --- PRE-ACTION SCROLL ---
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", onlineBtn);
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        // 1. JS Click the Bulk Online button
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", onlineBtn);
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        // 2. Handle the warning popup if it appears
        try {
            if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        } catch (Exception ignored) {}

        // 3. SMART RESET CHECK: Check true DOM attributes for disabled state
        boolean isSubmitDisabled = !getSubmit_button_organisationUpdate().isEnabled() || getSubmit_button_organisationUpdate().getAttribute("disabled") != null;

        if (isSubmitDisabled) {
            log.info("Submit button is disabled. Organization was ALREADY Online! Performing Smart Reset to Lite...");

            // --- RESET PHASE ---
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", liteBtn);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", liteBtn);

            try {
                if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                }
            } catch (Exception ignored) {}

            clickSubmit();
            validateSuccess();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

            // --- ACTUAL TEST PHASE ---
            log.info("State reset to Lite. Now clicking Bulk Online again to validate the transition...");
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", onlineBtn);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", onlineBtn);

            try {
                if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            } catch (Exception ignored) {}
        }

        // 4. Final Submit and Validate
        clickSubmit();
        validateSuccess();
        log.info("Successfully validated transition to Online.");
    }

    public void LEI_updateStatus(List<String> list, String currentStatus) {
        try {
            String docType = doctype_filter.getValue();
            String role = list.get(1).trim();
            WebElement targetElement = null;

            // 1. Identify the correct element based on DocType and Role
            if (docType.equalsIgnoreCase("DN")) {
                if (role.equalsIgnoreCase("PB")) targetElement = DN_PB;
                else if (role.equalsIgnoreCase("EB")) targetElement = DN_EB;
                else if (role.equalsIgnoreCase("Client")) targetElement = DN_Client;
            } else {
                if (role.equalsIgnoreCase("PB")) targetElement = FourWay_PB;
                else if (role.equalsIgnoreCase("Client")) targetElement = FourWay_Client;
            }

            // 2. Execute the update logic if an element was found
            if (targetElement != null) {
                executeStatusChange(targetElement, currentStatus);
            } else {
                log.warn("No matching element found for Role: " + role + " and DocType: " + docType);
            }

        } catch (Exception e) {
            log.error("Failed to update status: " + e.getMessage());
            Assert.fail();
        }
    }

    /**
     * Shared helper to handle the UI interaction
     */
    private void executeStatusChange(WebElement element, String targetText) {
        if (element.getText().equalsIgnoreCase(targetText)) {
            withAction().moveToElement(element).click().build().perform();

            confirmation_yes_btn.waitUntilClickable();
            withAction().moveToElement(confirmation_yes_btn).click().build().perform();

            log.info("Successfully clicked and confirmed status change from: " + targetText);
        } else {
            log.info("Element status is " + element.getText() + " (not " + targetText + "), skipping action.");
        }
    }

    /**
     * Helper method to reduce code duplication
     */
    private void handleStatusUpdate(WebElement element) {
        if (element.getText().equalsIgnoreCase("Online")) {
            withAction().moveToElement(element).click().build().perform();

            // Using clickable is generally safer than visible for buttons
            confirmation_yes_btn.waitUntilClickable();
            withAction().moveToElement(confirmation_yes_btn).click().build().perform();
            log.info("Status updated successfully.");
        } else {
            log.info("Already Online so no action performed");
        }
    }
public void bulk_update_sidewindow_toOnline(List<String> list){
        if (list.get(1).trim().equalsIgnoreCase("PB")){
            withAction().moveToElement(side_window_PB_Online_button).click().build().perform();
        } else if (list.get(1).trim().equalsIgnoreCase("Client")) {
            withAction().moveToElement(side_window_Client_Online_button).click().build().perform();
        }
        else {
            withAction().moveToElement(side_window_EB_Online_button).click().build().perform();
        }
}
    public void bulk_update_sidewindow_toLite(List<String> list){
        if (list.get(1).trim().equalsIgnoreCase("PB")){
            withAction().moveToElement(side_window_PB_Lite_button).click().build().perform();
        } else if (list.get(1).trim().equalsIgnoreCase("Client")) {
            withAction().moveToElement(side_window_Client_Lite_button).click().build().perform();
        }
        else {
            withAction().moveToElement(side_window_EB_Lite_button).click().build().perform();
        }
    }
    public void bulk_LEI_changeStatusTo_Online(List<String> list) {
        try {
            String docType = doctype_filter.getText();
            String role = list.get(1).trim();

            if (docType.equalsIgnoreCase("DN")) {
                if (role.equalsIgnoreCase("PB")) {
                    handleLiteToOnlineUpdate(DN_PB_Online_button, DN_PB_Lite_button);
                } else if (role.equalsIgnoreCase("EB")) {
                    handleLiteToOnlineUpdate(DN_EB_Online_button, DN_EB_Lite_button);
                } else if (role.equalsIgnoreCase("Client")) {
                    handleLiteToOnlineUpdate(DN_Client_Online_button, DN_Client_Lite_button);
                }
            } else {
                // Correctly placed FourWay logic
                if (role.equalsIgnoreCase("PB")) {
                    handleLiteToOnlineUpdate(FourWay_PB_Online_button, FourWay_PB_Lite_button);
                } else if (role.equalsIgnoreCase("Client")) {
                    handleLiteToOnlineUpdate(FourWay_Client_Online_button, FourWay_Client_Lite_button);
                }
            }
        } catch (Exception e) {
            log.error("Error in LEI_changeStatusTo_Online: " + e.getMessage());
            Assert.fail("Function failed: " + e.getMessage());
        }
    }

    public void bulk_LEI_changeStatusTo_Lite(List<String> list) {
        String docType = doctype_filter.getValue();
        String role = list.get(1).trim();

        if (docType.equalsIgnoreCase("DN")) {
            if (role.equalsIgnoreCase("PB")) {
                handleOnlinetoLiteUpdate(DN_PB_Lite_button, DN_PB_Online_button);
            } else if (role.equalsIgnoreCase("EB")) {
                handleOnlinetoLiteUpdate(DN_EB_Lite_button, DN_EB_Online_button);
            } else if (role.equalsIgnoreCase("Client")) {
                handleOnlinetoLiteUpdate(DN_Client_Lite_button, DN_Client_Online_button);
            }
        } else {
            // Correctly placed FourWay logic
            if (role.equalsIgnoreCase("PB")) {
                handleOnlinetoLiteUpdate(FourWay_PB_Lite_button, FourWay_PB_Online_button);
            } else if (role.equalsIgnoreCase("Client")) {
                handleOnlinetoLiteUpdate(FourWay_Client_Lite_button, FourWay_Client_Online_button);
            }
        }
    }

//    public void LEI_changeStatusTo_Lite(List<String> list) {
//        String docType = doctype_filter.getValue();
//        String role = list.get(1).trim();
//
//        // Note: For individual rows, you need to use the specific row buttons.
//        // Assuming DN_PB, DN_EB, etc., are individual row buttons, we pass the opposite row button here.
//        if (docType.equalsIgnoreCase("DN")) {
//            if (role.equalsIgnoreCase("PB")) {
//                handleOnlinetoLiteUpdate(DN_PB, DN_PB); // If you have specific Online/Lite buttons for the row, update these!
//            } else if (role.equalsIgnoreCase("EB")) {
//                handleOnlinetoLiteUpdate(DN_EB, DN_EB);
//            } else if (role.equalsIgnoreCase("Client")) {
//                handleOnlinetoLiteUpdate(DN_Client, DN_Client);
//            }
//        } else {
//            // Correctly placed FourWay logic
//            if (role.equalsIgnoreCase("PB")) {
//                handleOnlinetoLiteUpdate(FourWay_PB, FourWay_PB);
//            } else if (role.equalsIgnoreCase("Client")) {
//                handleOnlinetoLiteUpdate(FourWay_Client, FourWay_Client);
//            }
//        }
//    }

    public void LEI_changeStatusTo_Lite(List<String> list) {
        String docType = doctype_filter.getValue();
        String role = list.get(1).trim();

        if (docType.equalsIgnoreCase("DN")) {
            if (role.equalsIgnoreCase("PB")) handleIndividualRowToggle(DN_PB, "Lite");
            else if (role.equalsIgnoreCase("EB")) handleIndividualRowToggle(DN_EB, "Lite");
            else if (role.equalsIgnoreCase("Client")) handleIndividualRowToggle(DN_Client, "Lite");
        } else {
            if (role.equalsIgnoreCase("PB")) handleIndividualRowToggle(FourWay_PB, "Lite");
            else if (role.equalsIgnoreCase("Client")) handleIndividualRowToggle(FourWay_Client, "Lite");
        }
    }


    /**
     * Helper method specifically designed for Individual Row Toggle Switches
     */
    private void handleIndividualRowToggle(WebElementFacade cellElement, String targetState) {
        log.info("Attempting to change individual row status to " + targetState);

        // 1. Scroll to the cell and read its current state
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", cellElement);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        String currentState = cellElement.getText().trim();
        log.info("Current cell state is: " + currentState);

        // 2. Extract LEI ID and Column Index so we can find this EXACT cell again via JS
        String leiId = (String) getJavascriptExecutorFacade().executeScript(
                "var row = arguments[0].closest('tr');" +
                        "return row ? row.querySelector('td:nth-child(1)').innerText.trim() : '';", cellElement);

        Long colIndex = (Long) getJavascriptExecutorFacade().executeScript(
                "var td = arguments[0]; var index = 0; while ((td = td.previousElementSibling) != null) index++; return index + 1;", cellElement);

        // JS Command with a fallback: Finds exact LEI row, or defaults to first row if LEI gets wiped out
        String jsDynamicClick =
                "var lei = '" + leiId + "'; " +
                        "var targetRow = null; " +
                        "var rows = document.querySelectorAll('tbody tr'); " +
                        "for(var i=0; i<rows.length; i++) { " +
                        "  var firstCol = rows[i].querySelector('td:nth-child(1)'); " +
                        "  if(firstCol && firstCol.innerText.trim() === lei) { targetRow = rows[i]; break; } " +
                        "} " +
                        "if (!targetRow && rows.length > 0) targetRow = rows[0]; " + // Fallback to first row
                        "if (targetRow) { " +
                        "  var cell = targetRow.querySelector('td:nth-child(" + colIndex + ")'); " +
                        "  if(cell) { " +
                        "    var clickable = cell.querySelector('input') || cell.querySelector('.MuiSwitch-root') || cell; " +
                        "    clickable.click(); " +
                        "  } " +
                        "}";

        // 3. SMART RESET CHECK
        if (currentState.equalsIgnoreCase(targetState)) {
            log.info("Cell is ALREADY " + targetState + ". Performing Smart Reset (toggling to opposite state first)...");

            getJavascriptExecutorFacade().executeScript(jsDynamicClick);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            try {
                if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            } catch (Exception ignored) {}

            clickSubmit();
            validateSuccess();
            // Wait slightly longer to let React fetch finish
            withAction().pause(Duration.ofSeconds(6)).build().perform();
        }

        // 4. ACTUAL TEST PHASE (With React-Beating Retry Loop)
        log.info("Toggling cell to target state: " + targetState);
        boolean isSubmitReady = false;

        for (int i = 0; i < 5; i++) {
            // Execute JS click
            getJavascriptExecutorFacade().executeScript(jsDynamicClick);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            // Clear popup if it exists
            try {
                if (confirmation_yes_btn.withTimeoutOf(Duration.ofSeconds(2)).isCurrentlyVisible()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", confirmation_yes_btn);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            } catch (Exception ignored) {}

            // Verify the submit button survived the React render cycle
            if (submit_button_organisationUpdate.isCurrentlyVisible() && submit_button_organisationUpdate.isCurrentlyEnabled()) {
                isSubmitReady = true;
                break; // Victory! Break out of the loop
            }

            log.info("React wiped out the toggle state. Retrying JS click... (Attempt " + (i + 2) + ")");
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }

        if (!isSubmitReady) {
            Assert.fail("Failed to toggle status to " + targetState + " - Submit button never became active after 5 attempts.");
        }

        // 5. Final Submit
        clickSubmit();
        validateSuccess();
        log.info("Successfully validated individual transition to " + targetState);
    }

    public void LEI_changeStatusTo_Online(List<String> list) {
        String docType = doctype_filter.getValue();
        String role = list.get(1).trim();

        if (docType.equalsIgnoreCase("DN")) {
            if (role.equalsIgnoreCase("PB")) handleIndividualRowToggle(DN_PB, "Online");
            else if (role.equalsIgnoreCase("EB")) handleIndividualRowToggle(DN_EB, "Online");
            else if (role.equalsIgnoreCase("Client")) handleIndividualRowToggle(DN_Client, "Online");
        } else {
            if (role.equalsIgnoreCase("PB")) handleIndividualRowToggle(FourWay_PB, "Online");
            else if (role.equalsIgnoreCase("Client")) handleIndividualRowToggle(FourWay_Client, "Online");
        }
    }

}
