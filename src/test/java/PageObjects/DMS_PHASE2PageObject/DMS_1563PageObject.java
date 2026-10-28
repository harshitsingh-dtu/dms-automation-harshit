package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import lombok.extern.slf4j.Slf4j;
import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.List;
import java.time.Duration;
import java.util.Map;

@Slf4j
@Data

public class DMS_1563PageObject extends PageObject {

    @FindBy(xpath="//input[@placeholder='Select LEIs']")
    private WebElementFacade selectLEIs;

    @FindBy(xpath="//ul[@role='listbox']//li")
    private WebElementFacade LEI_list;

    @FindBy(xpath="//div[@class='profile-icon']")
    private WebElementFacade profile_icon;

    @FindBy(xpath="//div[@class='pf-name']//header")
    private WebElementFacade organization_header;

    @FindBy(xpath="//span[text()=' Profile details']")
    private WebElementFacade profile_details;

    @FindBy(xpath="//div[@class='flex space-between flex-gap']//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;

    @FindBy(xpath ="//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupsTemplate_btn;

    @FindBy(xpath="//a[@data-testid='submenu-link-Approval groups']")
    private WebElementFacade approvalGroup_btn;

    @FindBy(xpath="//a[@data-testid='submenu-link-Approval matrices']")
    private WebElementFacade approvalMatrix_btn;

    @FindBy(xpath = "//input[@placeholder='Select Org Type']")
    private WebElementFacade orgType_box;

    @FindBy(xpath = "//p[text()='Client']")
    private WebElementFacade client_text;

    @FindBy(xpath = "//p[text()='PB']")
    private WebElementFacade PB_text;

    @FindBy(xpath = "//p[text()='EB']")
    private WebElementFacade EB_text;

    @FindBy(xpath="//input[@placeholder='Select Doc Type']")
    private WebElementFacade selectDocType;

    @FindBy(xpath = "//p[text()='4 Way']")
    private WebElementFacade fourWayDocTypeFromDropdown;

    @FindBy(xpath = "//p[text()='DN']")
    private WebElementFacade DNDocTypeFromDropdown;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filteredValue;


    public void clickLEIDropdown_ApprovalGroup(List<String> valuelist){
        try{
            profile_icon.waitUntilVisible();
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String organization_Name = organization_header.getText().trim();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if(organization_Name.equalsIgnoreCase("OSTTRA")){
                profile_details.click();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                List<WebElementFacade> elements = findAll("//div[@class='detail-pf ']//h4");

                for(WebElementFacade element : elements) {
                   String Roles_text =element.getText();
                   if (Roles_text.contains("OSTTRA_PSUSER") || Roles_text.contains("OSTTRA_ADMIN") || Roles_text.contains("OSTTRA_OPSUSER") ){

                       navigation_btn.waitUntilClickable().click();
                       if (approvalGroup_btn.isVisible()) {
                           approvalGroup_btn.waitUntilClickable().click();
                           withAction().pause(Duration.ofSeconds(2)).build().perform();
                       }
                       else{
                           groupsTemplate_btn.waitUntilClickable().click();
                           approvalGroup_btn.click();
                           withAction().pause(Duration.ofSeconds(2)).build().perform();
                       }
                       withAction().pause(Duration.ofSeconds(4)).build().perform();
                       for (int begin=1;begin<valuelist.size();begin++)
                       {
                           selectLEIs.waitUntilClickable().click();
                           selectLEIs.type(valuelist.get(begin));
                           withAction().pause(Duration.ofSeconds(4)).build().perform();
                           Assert.assertTrue(valuelist.get(begin).equalsIgnoreCase(filteredValue.getText()));
                           withAction().pause(Duration.ofSeconds(2)).build().perform();
                           selectLEIs.clear();
                       }
                       log.info("All LEIs are visible");
                   }
                   else {
                       log.error("User do not have permissions");
                       getDriver().quit();
                   }
                }
            }
            else {
                log.error("User do not belongs to Osttra/Admin");
            }
        }
        catch (Exception e){
            log.error("Unable to see all LEIs on select LEI dropdown" +e);
            Assert.fail();
        }
    }
    public void selectLEIApprovalGroup_seeResults(DataTable table){
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String,String> dataTable_map= data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            try {
                selectLEIs.waitUntilClickable().click();
                withAction().moveToElement(selectLEIs).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(selectLEIs).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("Select LEI")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(5)).build().perform();
                List<WebElementFacade> orgName = findAll("//tbody//tr//td[4]");
                int orgName_size= orgName.size();
                log.info("LEI name size is :" +orgName_size);
                int columncount= 1;

                for(WebElementFacade orgName_values : orgName) {
                    String orgName_valuesText = orgName_values.getText();
                    if(dataTable.get("Select LEI").equalsIgnoreCase(orgName_valuesText)){
                        log.info("Corresponding value is visible on the approval group listing screen for LEI name :"+orgName_valuesText+ "-" +columncount);
                    }
                    else{
                        log.info("Corresponding values not visible for LEI name");
                    }
                    columncount++;
                }
            }
            catch (Exception e){
                log.error("Unable to see corresponding results on the approval group listing screen for LEI name-->"+e);
                Assert.fail();
            }
        }
    public void selectOrgTypeApprovalGroup_seeResults(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            orgType_box.waitUntilClickable();
            withAction().moveToElement(orgType_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("org type"),Keys.DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            List<WebElementFacade> orgType = findAll("//tbody//tr//td[5]");
            int orgType_size= orgType.size();
            log.info("Org Type size is :" +orgType_size);
            int columncount= 1;

            for(WebElementFacade orgType_values : orgType) {
                String orgType_valuesText = orgType_values.getText();
                if(dataTable.get("org type").equalsIgnoreCase(orgType_valuesText)){
                    log.info("Corresponding value is visible on the approval group listing screen for org type : " +orgType_valuesText+ "-" +columncount);
                }
                else{
                    log.info("Corresponding values not visible for org type");
                }
                columncount++;
            }

        }
        catch (Exception e){
            log.error("Unable to see corresponding results on the approval group listing screen for org type-->"+e);
            Assert.fail();
        }
    }
    public void selectDocTypeApprovalGroup_seeResults(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectDocType.waitUntilClickable();
            withAction().moveToElement(selectDocType).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN,Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(7)).build().perform();
            List<WebElementFacade> docType = findAll("//tbody//tr//td[3]");
            int docType_size= docType.size();
            log.info("Doc Type size is :" +docType_size);
            int columncount= 1;

            for(WebElementFacade docType_values : docType) {
               String docType_valuesText = docType_values.getText();
                if(dataTable.get("doc type").equalsIgnoreCase(docType_valuesText)){
                log.info("Corresponding value is visible on the approval group listing screen for doc type :  "+docType_valuesText+ "-" +columncount);
               }
                else{
                  log.info("Corresponding values not visible for doc type");
              }
                columncount++;
            }
        }
        catch (Exception e){
            log.error("Unable to see corresponding results on the approval group listing screen for doc type-->"+e);
            Assert.fail();
        }
    }
    public void selectOrgTypeApprovalMatrix_seeResults(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            orgType_box.waitUntilClickable();
            withAction().moveToElement(orgType_box).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("org type"),Keys.DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            List<WebElementFacade> orgType = findAll("//tbody//tr//td[4]");
            int orgType_size= orgType.size();
            log.info("Org Type size is :" +orgType_size);
            int columncount= 1;

            for(WebElementFacade orgType_values : orgType) {
                String orgType_valuesText = orgType_values.getText();
                if(dataTable.get("org type").equalsIgnoreCase(orgType_valuesText)){
                    log.info("Corresponding value is visible on the approval matrix listing screen for org type : " +orgType_valuesText+ "-" +columncount);
                }
                else{
                    log.info("Corresponding values not visible for org type");
                }
                columncount++;
            }
        }
        catch (Exception e){
            log.error("Unable to see corresponding results on the approval matrix listing screen for org type-->"+e);
            Assert.fail();
        }
    }
    public void selectDocTypeApprovalMatrix_seeResults(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectDocType.waitUntilClickable();
            withAction().moveToElement(selectDocType).click().pause(Duration.ofSeconds(2)).sendKeys(dataTable.get("doc type"),Keys.DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            List<WebElementFacade> docType = findAll("//tbody//tr//td[2]");
            int docType_size= docType.size();
            log.info("Doc Type size is :" +docType_size);
            int columncount= 1;

            for(WebElementFacade docType_values : docType) {
                String docType_valuesText = docType_values.getText();
                if(dataTable.get("doc type").equalsIgnoreCase(docType_valuesText)){
                    log.info("Corresponding value is visible on the approval matrix listing screen for doc type : " +docType_valuesText+ "-" +columncount);
                }
                else{
                    log.info("Corresponding values not visible for doc type");
                }
                columncount++;
            }
        }
        catch (Exception e){
            log.error("Unable to see corresponding results on the approval matrix listing screen for doc type-->"+e);
            Assert.fail();
        }
    }
    public void clickLEIDropdown_ApprovalMatrix(List<String> valuelist){
        try{
            profile_icon.waitUntilVisible();
            profile_icon.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String organization_Name = organization_header.getText().trim();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if(organization_Name.equalsIgnoreCase("OSTTRA")){
                profile_details.click();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                List<WebElementFacade> elements = findAll("//div[@class='detail-pf ']//h4");

                for(WebElementFacade element : elements) {
                    String Roles_text =element.getText();
                    if (Roles_text.contains("OSTTRA_PSUSER") || Roles_text.contains("OSTTRA_ADMIN") || Roles_text.contains("OSTTRA_OPSUSER") ){

                        navigation_btn.waitUntilClickable().click();
                        if (approvalMatrix_btn.isVisible()) {
                            approvalMatrix_btn.waitUntilClickable().click();
                            withAction().pause(Duration.ofSeconds(2)).build().perform();
                        }
                        else{
                            groupsTemplate_btn.waitUntilClickable().click();
                            approvalMatrix_btn.click();
                            withAction().pause(Duration.ofSeconds(2)).build().perform();
                        }
                        withAction().pause(Duration.ofSeconds(4)).build().perform();
                        for (int begin=1;begin<valuelist.size();begin++)
                        {
                            selectLEIs.waitUntilClickable().click();
                            selectLEIs.type(valuelist.get(begin));
                            withAction().pause(Duration.ofSeconds(4)).build().perform();
                            Assert.assertTrue(valuelist.get(begin).equalsIgnoreCase(filteredValue.getText()));
                            withAction().pause(Duration.ofSeconds(2)).build().perform();
                            selectLEIs.clear();
                        }
                        log.info("All LEIs are visible");
                    }
                    else {
                        log.error("User do not have permissions");
                        getDriver().quit();
                    }
                }
            }
            else {
                log.error("User do not belongs to Osttra/Admin");
            }
        }
        catch (Exception e){
            log.error("Unable to see all LEIs on select LEI dropdown" +e);
            Assert.fail();
        }
    }
    public void selectLEIApprovalMatrix_seeResults(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectLEIs.waitUntilClickable().click();
            withAction().moveToElement(selectLEIs).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(selectLEIs).click().pause(Duration.ofSeconds(3)).sendKeys(dataTable.get("Select LEI")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            List<WebElementFacade> orgName = findAll("//tbody//tr//td[3]");
            int orgName_size= orgName.size();
            log.info("LEI name size is :" +orgName_size);
            int columncount= 1;

            for(WebElementFacade orgName_values : orgName) {
                String orgName_valuesText = orgName_values.getText();
                if(dataTable.get("Select LEI").equalsIgnoreCase(orgName_valuesText)){
                    log.info("Corresponding value is visible on the approval group listing screen for LEI name :"+orgName_valuesText+ "-" +columncount);
                }
                else{
                    log.info("Corresponding values not visible for LEI name");
                }
                columncount++;
            }
        }
        catch (Exception e){
            log.error("Unable to see corresponding results on the approval group listing screen for LEI name-->"+e);
            Assert.fail();
        }
    }
}
