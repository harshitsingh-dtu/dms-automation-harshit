package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DMS_1553PageObject extends PageObject {


    @FindBy(xpath = "//button[text()='+ Create new user']")
    private WebElementFacade UserManagementscreen;
    @FindBy(xpath = "//input[@placeholder='Search by name & email id']")
    private WebElementFacade SearchForAddedUser;
    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade Updatebuttonfor_SearchedUser;
    @FindBy(xpath = "//div[text()='User Access']")
    private WebElementFacade UserUpdateScreen;
////Roles Section
    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRoles;
    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade  roleMapping_Input;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade yesbuttonOnpopup;
    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade NObuttonOnpopup;
    /////LEIs, Org type & Doc type Section
    @FindBy(xpath = "//div[@class='select-container']//input[@placeholder='Select Doc Type']")
    private WebElementFacade SelectDoctype_input;
    @FindBy(xpath = "//div[text()='Select LEIs']")
    private WebElementFacade SelectLEIs_input;
    @FindBy(xpath = "//div[@class='select-container']//input[@placeholder='Select Org Type']")
    private WebElementFacade SelectOrgType_input;
    @FindBy(xpath = "//button[text()='+ Add']")
    private WebElementFacade Addbutton;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade SubmitButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Cancelbutton;
/////
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElementFacade AlertPopup;
    @FindBy(xpath = "//div[text()='Mapping already exists']")
    private WebElementFacade alreadyExistpopup;
/////
    @FindBy(xpath = "//div[text()='Updated Successfully']")
    private WebElementFacade SuccessMessage;

    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profile_icon;
    @FindBy(xpath = "//div[@class='pf-details']//span[text()=' Profile details']")
    private WebElementFacade profile_Details;
    @FindBy(xpath = "//span[text()='Logout']")
    private WebElementFacade logout_btn;
    @FindBy(xpath = "//input[@placeholder='Enter registered email id']")
    private WebElementFacade usernameInput;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElementFacade passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade login_btn;

    @FindBy(xpath = "//button[text()='+ Create New Template']")
    private WebElementFacade CreatenewTemplateButton;
    @FindBy(xpath = "//input[@placeholder='Search by template name']")
    private WebElementFacade SearchTemplateNameInput;
    @FindBy(xpath = "//tr//td[text()='DN']/following::button[text()='View']")
    private WebElementFacade ViewButtonForDNTemplate;
    @FindBy(xpath = "//tr//td[text()='4 Way']/following::button[text()='View']")
    private WebElementFacade ViewButtonFor4wayTemplate;
    @FindBy(xpath = "//tr//td[text()='DN']/following::button[text()='Update']")
    private WebElementFacade UpdateButtonForDNTemplate;
    @FindBy(xpath = "//tr//td[text()='4 Way']/following::button[text()='Update']")
    private WebElementFacade UpdateButtonFor4wayTemplate;
    @FindBy(xpath = "//td[text()='4 Way']")
    private WebElementFacade fourwayDoctype;
    @FindBy(xpath = "//td[text()='DN']")
    private WebElementFacade DNDoctype;

    @FindBy(xpath="//div[@class='pf-name']//header")
    private WebElementFacade organization_header;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade OrganisationDropdown;
    @FindBy(xpath = "//ul[@role='listbox']")
    private WebElementFacade organization_List;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade NoresultFoundText;





    public void SearchAddedUser(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SearchForAddedUser.waitUntilClickable();
            withAction().moveToElement(SearchForAddedUser).click().sendKeys(dataTable.get("User Email")).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElementFacade searchedResult = find(By.xpath("//td[text()='"+dataTable.get("User Email")+"']"));
            log.info("input user" +dataTable.get("User Email")+ "--------> result user"+searchedResult.getText());
            Assert.assertTrue(searchedResult.isVisible());
        }catch(Exception e){
            log.error("Unable to found Added User" +e);
            Assert.fail();
        }
        }

    public void RemoveUserRoles(List<String> RolesList){
        try {
            selectedRoles.waitUntilVisible();
            for (int begin=1;begin<RolesList.size();begin++){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (selectedRoles.getText().contains(RolesList.get(begin))){
                    roleMapping_Input.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    withAction().moveToElement(roleMapping_Input).click().sendKeys(RolesList.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    roleMapping_Input.clear();
                    if (yesbuttonOnpopup.isVisible()){
                        yesbuttonOnpopup.click();
                        withAction().pause(Duration.ofSeconds(2)).build().perform();

                    }
                }
            }
        }catch (Exception e){
            Assert.fail("User unable to remove Assigned roles"+e);
            Assert.fail();
        }
    }

    public void AssignUserRoles(List<String> RolesList){
        try {
            selectedRoles.waitUntilVisible();
            for (int begin=1;begin<RolesList.size();begin++){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (!selectedRoles.getText().contains(RolesList.get(begin))){
                    roleMapping_Input.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    withAction().moveToElement(roleMapping_Input).click().sendKeys(RolesList.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    roleMapping_Input.clear();
                }
            }
        }catch (Exception e){
            Assert.fail("User unable to remove Assigned roles"+e);
            Assert.fail();
        }
    }



    public void ReloginwithUpdatedUser(DataTable Table){
        List<Map<String, String>> data = Table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            usernameInput.waitUntilClickable().clear();
            withAction().moveToElement(usernameInput).click().sendKeys(dataTable.get("Email")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            passwordInput.waitUntilClickable().clear();
            withAction().moveToElement(passwordInput).click().sendKeys(dataTable.get("Password")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            login_btn.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        }catch (Exception e){
            log.error("Unable to re-login with Updated USer credentials" +e);
            Assert.fail();
        }
    }

    public void viewButtonDocumentTemplate(List<String> Doctemp) {
        try {
            for (int begin = 1; begin < Doctemp.size(); begin++) {
                SearchTemplateNameInput.waitUntilClickable().clear();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchTemplateNameInput.type(Doctemp.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                WebElement searchResult = find(By.xpath("//td[text()='"+Doctemp.get(begin)+"']"));
                if (Doctemp.get(begin).equalsIgnoreCase(searchResult.getText())) {
                    if (DNDoctype.isVisible()) {
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        Assert.assertTrue(ViewButtonForDNTemplate.isVisible());
                        log.info("View button is Visible for Document Template that belongs to Doc type DN ");
                    }
                    if (fourwayDoctype.isVisible()) {
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        Assert.assertTrue(ViewButtonFor4wayTemplate.isVisible());
                        log.info("View button is Visible for Document Template that belongs to Doc type 4 Way ");
                    }
                }
            }
        } catch (Exception e) {
            log.error("unable to see View Button for Searched Document Template" + e);
            Assert.fail();
        }
    }

    public void UpdateButtonDocumentTemplate(List<String> Doctemp) {
        try {
            for (int begin = 1; begin < Doctemp.size(); begin++) {
                SearchTemplateNameInput.waitUntilClickable().clear();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchTemplateNameInput.type(Doctemp.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                WebElement searchResult = find(By.xpath("//td[text()='"+Doctemp.get(begin)+"']"));
                if (Doctemp.get(begin).equalsIgnoreCase(searchResult.getText())) {
                    if (DNDoctype.isVisible()) {
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        Assert.assertTrue(UpdateButtonForDNTemplate.isVisible());
                        log.info("Update button is Visible for Document Template that belongs to Doc type DN ");
                    }
                    if (fourwayDoctype.isVisible()) {
                        withAction().pause(Duration.ofSeconds(2)).build().perform();
                        Assert.assertTrue(UpdateButtonFor4wayTemplate.isVisible());
                        log.info("Update button is Visible for Document Template that belongs to Doc type 4 Way ");
                    }
                }
            }
        } catch (Exception e) {
            log.error("unable to see Update Button for Searched Document Template" + e);
            Assert.fail();
        }
    }




    public void AddLEIS_For_Doctypes(List<String> Doctype){
        try {
            for (int begin = 1; begin < Doctype.size(); begin++) {
                if (Doctype.get(begin).equalsIgnoreCase("DN") && !DNDoctype.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    SelectDoctype_input.waitUntilVisible();
                    withAction().moveToElement(SelectDoctype_input).click().sendKeys(Doctype.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    SelectLEIs_input.waitUntilClickable();
                    withAction().moveToElement(SelectLEIs_input).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    SelectOrgType_input.waitUntilClickable();
                    withAction().moveToElement(SelectOrgType_input).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Addbutton.waitUntilClickable().click();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                } else if (Doctype.get(begin).equalsIgnoreCase("4 Way") && !fourwayDoctype.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    SelectDoctype_input.waitUntilVisible();
                    withAction().moveToElement(SelectDoctype_input).click().sendKeys(Doctype.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    SelectLEIs_input.waitUntilClickable();
                    withAction().moveToElement(SelectLEIs_input).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    SelectOrgType_input.waitUntilClickable();
                    withAction().moveToElement(SelectOrgType_input).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Addbutton.waitUntilClickable().click();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                }
            }
        }catch (Exception e){
            Assert.fail("User unable to Add LEI for Doctype" +e);
            Assert.fail();
        }
    }

    public void ValidateOrganizationList(){
        try{
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            profile_icon.waitUntilClickable().click();
            String orgheader_text = organization_header.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            OrganisationDropdown.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(organization_List.getText().contains(orgheader_text));

        }catch (Exception e) {
            log.error("Assgigned Organization is Present In Organization List Dropdown" +e);
            Assert.fail();
        }
    }


    public void CheckDocumentTemplateforDNwhenPermissionNotAssign(List<String> Doctemp) {
        try {
            for (int begin = 1; begin < Doctemp.size(); begin++) {
                SearchTemplateNameInput.waitUntilClickable().clear();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchTemplateNameInput.type(Doctemp.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                if (!DNDoctype.isVisible()) {
                   NoresultFoundText.isVisible();
                } else {
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            log.error("unable to see Searched Document Template for DN when Permission are Not Assign" + e);
            Assert.fail();
        }
    }

    public void CheckDocumentTemplatefor4waywhenPermissionNotAssign(List<String> Doctemp) {
        try {
            for (int begin = 1; begin < Doctemp.size(); begin++) {
                SearchTemplateNameInput.waitUntilClickable().clear();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchTemplateNameInput.type(Doctemp.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                if (!fourwayDoctype.isVisible()) {
                    NoresultFoundText.isVisible();
                } else {
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            log.error("unable to see Searched Document Template for 4 way when Permission are Not Assign" + e);
            Assert.fail();
        }
    }

    public void CheckDocumentTemplatewhenPermissionAssign(List<String> Doctemp) {
        try {
            for (int begin = 1; begin < Doctemp.size(); begin++) {
                SearchTemplateNameInput.waitUntilClickable().clear();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchTemplateNameInput.type(Doctemp.get(begin));
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                WebElement searchResult = find(By.xpath("//td[text()='"+Doctemp.get(begin)+"']"));
//                if (Doctemp.get(begin).equalsIgnoreCase(searchResult.getText())) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(Doctemp.get(begin).equalsIgnoreCase(searchResult.getText()));
//                }else {
//                    Assert.fail();
//                }
            }
        } catch (Exception e) {
            log.error("unable to see Searched Document Template  when Permission are Assign" + e);
            Assert.fail();
        }
    }

}


