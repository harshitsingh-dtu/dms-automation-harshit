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
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Slf4j
@Data
public class DMS_1931PageObject extends PageObject {


    @FindBy(xpath = "//div[text()='Contact/Specified offices']")
    private WebElementFacade ContactSpecifiedOffices_Text_on_GeneralTermTab;
    @FindBy(xpath = "//div[@class='info-container']")
    private WebElementFacade AllInfoFORDocument;

    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Enter address (max. 100 characters)'][1])[1]")
    private WebElementFacade Addressfield_for_PrimeBroker1;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Enter address (max. 100 characters)'][1])[2]")
    private WebElementFacade Addressfield_for_PrimeBroker2;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Enter contact (max. 100 characters)'][1])[1]")
    private WebElementFacade Contactfield_for_PrimeBroker1;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Enter contact (max. 100 characters)'][1])[2]")
    private WebElementFacade Contactfield_for_PrimeBroker2;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Type & Select Acting Office'][1])[1]")
    private WebElementFacade ActionOfficeDropdown_for_PrimeBroker1;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Type & Select Acting Office'][1])[2]")
    private WebElementFacade ActionOfficeDropdown_for_PrimeBroker2;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Select Relationship'][1])[1]")
    private WebElementFacade RelationshipDropdown_for_PrimeBroker1;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Select Relationship'][1])[2]")
    private WebElementFacade RelationshipDropdown_for_PrimeBroker2;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Type & Select Specified office(s)'][1])[1]")
    private WebElementFacade SpecifiedOfficeDropdown_for_PrimeBroker1;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::input[@placeholder='Type & Select Specified office(s)'][1])[2]")
    private WebElementFacade SpecifiedOfficeDropdown_for_PrimeBroker2;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::textarea[@placeholder='Enter notes (max. 1000 characters)'][1])[1]")
    private WebElementFacade NOTEStextField_for_PrimeBroker1;
    @FindBy(xpath = "(//div[text()='Prime Broker']//following::textarea[@placeholder='Enter notes (max. 1000 characters)'][1])[2]")
    private WebElementFacade NOTEStextField_for_PrimeBroker2;

    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Enter address (max. 100 characters)'][1])[1]")
    private WebElementFacade Addressfield_for_Client1;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Enter address (max. 100 characters)'][1])[2]")
    private WebElementFacade Addressfield_for_Client2;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Enter contact (max. 100 characters)'][1])[1]")
    private WebElementFacade Contactfield_for_Client1;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Enter contact (max. 100 characters)'][1])[2]")
    private WebElementFacade Contactfield_for_Client2;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Type & Select Acting Office'][1])[1]")
    private WebElementFacade ActionOfficeDropdown_for_Client1;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Type & Select Acting Office'][1])[2]")
    private WebElementFacade ActionOfficeDropdown_for_Client2;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Select Relationship'][1])[1]")
    private WebElementFacade RelationshipDropdown_for_Client1;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Select Relationship'][1])[2]")
    private WebElementFacade RelationshipDropdown_for_Client2;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Type & Select Specified office(s)'][1])[1]")
    private WebElementFacade SpecifiedOfficeDropdown_for_Client1;
    @FindBy(xpath = "(//div[text()='Client']//following::input[@placeholder='Type & Select Specified office(s)'][1])[2]")
    private WebElementFacade SpecifiedOfficeDropdown_for_Client2;
    @FindBy(xpath = "(//div[text()='Client']//following::textarea[@placeholder='Enter notes (max. 1000 characters)'][1])[1]")
    private WebElementFacade NOTEStextField_for_PrimeClient1;
    @FindBy(xpath = "(//div[text()='Client']//following::textarea[@placeholder='Enter notes (max. 1000 characters)'][1])[2]")
    private WebElementFacade NOTEStextField_for_PrimeClient2;

    @FindBy(xpath = "//div[text()='Executing Broker']//following::input[@placeholder='Enter address (max. 100 characters)'][1]")
    private WebElementFacade Addressfield_For_ExecutingBroker;
    @FindBy(xpath = "//div[text()='Executing Broker']//following::input[@placeholder='Enter contact (max. 100 characters)'][1]")
    private WebElementFacade Contactfield_For_ExecutingBroker;
    @FindBy(xpath = "//div[text()='Executing Broker']//following::input[@placeholder='Type & Select Acting Office'][1]")
    private WebElementFacade ActionOfficeDropdown_For_ExecutingBroker;
    @FindBy(xpath = "//div[text()='Executing Broker']//following::input[@placeholder='Select Relationship'][1]")
    private WebElementFacade RelationshipDropdown_For_ExecutingBroker;
    @FindBy(xpath = "//div[text()='Executing Broker']//following::input[@placeholder='Type & Select Specified office(s)'][1]")
    private WebElementFacade SpecifiedOfficeDropdown_For_ExecutingBroker;
    @FindBy(xpath = "//div[text()='Executing Broker']//following::textarea[@placeholder='Enter notes (max. 1000 characters)'][1]")
    private WebElementFacade NOTEStextField_For_ExecutingBroker;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Cancel_Button;
    @FindBy(xpath = "//button[text()='Back']")
    private WebElementFacade Back_Button;
    @FindBy(xpath = "//button[text()='Reset current changes']")
    private WebElementFacade ResetCurrentChanges_Button;
    @FindBy(xpath = "//div[text()='Documents']")
    private WebElementFacade Documents_text;



    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filtereditem;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade yesbuttonOnpopup;
    @FindBy(xpath = "//div[text()='Confirmation']")
    private WebElementFacade ConfirmationPOPUP;
    @FindBy(xpath = "//div[text()='Participants']")
    private WebElementFacade Participants_text;
    @FindBy(xpath = "//div[text()='For new document']")
    private WebElementFacade fornewdocument_text;
    @FindBy(xpath = "//div[@class='ck ck-presence-list__counter']")
    private WebElementFacade connecteduser_text;
    @FindBy(xpath = "//div[@aria-label='Editor editing area: main']")
    private WebElementFacade Ck_editor;
    @FindBy(xpath = "//div[text()='Auth Products']")
    private WebElementFacade authproducts_text;
    @FindBy(xpath = "//div[@class='input-container']")
    private WebElementFacade InputContainer_On_LimitScope;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]")
    private WebElementFacade USPRiderContainer;
    @FindBy(xpath = "//div[text()='Final Preview']")
    private WebElementFacade FinalPreview_text;



//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div/div/div")
//    private WebElementFacade Selectedpartyprimebroker1_text;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div/div/div")
//    private WebElementFacade Selectedpartyprimebroker2_text;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']/following-sibling::div/div/div")
//    private WebElementFacade SelectedpartyExecutingBroker1_text;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']/following-sibling::div/div/div")
//    private WebElementFacade SelectedpartyClient1text;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 2']/following-sibling::div/div/div")
//    private WebElementFacade SelectedpartyClient2text;
//
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']/following-sibling::div//div[@class='head-status scolor']")
//    private WebElementFacade litestatusforClient1party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 2']/following-sibling::div//div[@class='head-status scolor']")
//    private WebElementFacade litestatusforClient2party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[@class='head-status scolor']")
//    private WebElementFacade litestatusforprimebroker1party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[@class='head-status scolor']")
//    private WebElementFacade litestatusforprimebroker2party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']/following-sibling::div//div[@class='head-status scolor']")
//    private WebElementFacade litestatusforExecutingbroker1party;
//
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']/following-sibling::div//div[text()='+ Add email id']")
//    private WebElementFacade addemailbuttonforclient1party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 2']/following-sibling::div//div[text()='+ Add email id']")
//    private WebElementFacade addemailbuttonforclient2party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[text()='+ Add email id']")
//    private WebElementFacade addemailbuttonforprimebroker1party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[text()='+ Add email id']")
//    private WebElementFacade addemailbuttonforprimebroker2party;
//    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']/following-sibling::div//div[text()='+ Add email id']")
//    private WebElementFacade addemailbuttonforExecutingbroker1party;
//
//    @FindBy(xpath = "//div[text()='Client - 1']//span[text()='+ View Fund Details']")
//    private WebElementFacade ViewDetailButton_FOR_Client1;
//    @FindBy(xpath = "//div[text()='Client - 2']//span[text()='+ View Fund Details']")
//    private WebElementFacade ViewDetailButton_FOR_Client2;
//
//

    public void SelectMultipleSpecifiedOfficies(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(3) + 2;
            log.info("randomNumber" + randomNumber);
            SpecifiedOfficeDropdown_for_PrimeBroker1.waitUntilVisible().isVisible();
            withAction().moveToElement(SpecifiedOfficeDropdown_for_PrimeBroker1).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement TOBESelectedSpecifiedOffice = find(By.xpath("(//li[@class='multiselect-options-list'])["+begin+"]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(TOBESelectedSpecifiedOffice).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                WebElement SelectedSpecifiedOffices = find(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth Mui-focused MuiInputBase-formControl MuiInputBase-adornedStart MuiInputBase-adornedEnd MuiAutocomplete-inputRoot css-1si533m']"));
                log.info(SelectedSpecifiedOffices.getText() +  "------------------------------------------->" +   TOBESelectedSpecifiedOffice.getText() );
                Assert.assertTrue(SelectedSpecifiedOffices.getText().contains(TOBESelectedSpecifiedOffice.getText()));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        }catch (Exception e){
            log.error("Unable to Select Multiple Specified officies on Generalterm Tab " +e);
            Assert.fail();
        }
    }

    public void checkCharacterlengthofAddressField(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            int length = 150; // Change the length as per your requirement
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$$%^&^*(()*(_}{][";
            StringBuilder sb = new StringBuilder(length);
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
            String generatedString = sb.toString();
            withAction().moveToElement(Addressfield_for_PrimeBroker1).click().sendKeys(generatedString).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            int EnteredStringLenght = Addressfield_for_PrimeBroker1.getAttribute("value").length();
            Assert.assertEquals(100, EnteredStringLenght);

        }catch (Exception e){
            log.error("Unable to validate length of Character for Address Field" +e);
            Assert.fail();
        }
    }

    public void checkCharacterlengthofContactField(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            int length = 150; // Change the length as per your requirement
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-@^$^$_%#@#%";
            StringBuilder sb = new StringBuilder(length);
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
            String generatedString = sb.toString();
            withAction().moveToElement(Contactfield_for_PrimeBroker1).click().sendKeys(generatedString).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            int EnteredStringLenght = Contactfield_for_PrimeBroker1.getAttribute("value").length();
            Assert.assertEquals(100, EnteredStringLenght);
        }catch (Exception e){
            log.error("Unable to validate length of Character for Address Field" +e);
            Assert.fail();
        }
    }


    public void checkCharacterlengthofNotesField(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            int length = 1500; // Change the length as per your requirement
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-@^$^$_%#@#%";
            StringBuilder sb = new StringBuilder(length);
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
            String generatedString = sb.toString();
            withAction().moveToElement(NOTEStextField_for_PrimeBroker1).click().sendKeys(generatedString).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            int EnteredStringLength = NOTEStextField_for_PrimeBroker1.getText().length();
            Assert.assertEquals(1000, EnteredStringLength);
        }catch (Exception e){
            log.error("Unable to validate length of Character for Address Field" +e);
            Assert.fail();
        }
    }


    public void FilteredItemForRelationship(List<String> itemlist){

        try {
            for (int begin=1;begin<itemlist.size();begin++)
            {
                RelationshipDropdown_for_PrimeBroker1.waitUntilClickable().click();
                RelationshipDropdown_for_PrimeBroker1.type(itemlist.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(itemlist.get(begin),filtereditem.getText());
                RelationshipDropdown_for_PrimeBroker1.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found item in Relatioship Dropdown-->" + e);
            Assert.fail();
        }
    }


    public void EnterRandomInput_for_ActingOffice_Relationship_SpecifiedOffice() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(5) + 1;
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            ActionOfficeDropdown_for_PrimeBroker1.waitUntilVisible();
            withAction().moveToElement(ActionOfficeDropdown_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(ActionOfficeDropdown_for_PrimeBroker1).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            RelationshipDropdown_for_PrimeBroker1.waitUntilClickable().isVisible();
            withAction().moveToElement(RelationshipDropdown_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(RelationshipDropdown_for_PrimeBroker1).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SpecifiedOfficeDropdown_for_PrimeBroker1.waitUntilClickable().isVisible();
//            withAction().moveToElement(SpecifiedOfficeDropdown_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().moveToElement(SpecifiedOfficeDropdown_for_PrimeBroker1).click().build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();

        }catch (Exception e){
            log.error(" Unable to Select ActingOffice Relationship and SpecifiedOffice dropdown" +e);
            Assert.fail();
        }
    }


    public void EnterInput_for_Address_contact_Notes(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Addressfield_for_PrimeBroker1.waitUntilVisible().isVisible();
            withAction().moveToElement(Addressfield_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().moveToElement(Addressfield_for_PrimeBroker1).sendKeys(dataTable.get("Address")).pause(Duration.ofSeconds(4)).build().perform();

            Contactfield_for_PrimeBroker1.waitUntilVisible().isVisible();
            withAction().moveToElement(Contactfield_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().moveToElement(Contactfield_for_PrimeBroker1).sendKeys(dataTable.get("Contact")).pause(Duration.ofSeconds(4)).build().perform();

            NOTEStextField_for_PrimeBroker1.waitUntilVisible().isVisible();
            withAction().moveToElement(NOTEStextField_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().moveToElement(NOTEStextField_for_PrimeBroker1).sendKeys(dataTable.get("Notes")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

        } catch (Exception e) {
            log.error("Unable to Enter input for Address, contact and Notes fields-->" + e);
            Assert.fail();
        }
    }



    public void CheckConfirmationPOPUPWhileChangingTab() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Random random = new Random();
            int randomNumber;
            do {
                randomNumber = random.nextInt(8) + 1;
            } while (randomNumber == 4);
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            log.info("xpath is " + "(//div[@class='MuiTabs-flexContainer css-k008qs']//button)["+randomNumber+"]");
            WebElement Tab = find(By.xpath("(//div[@class='MuiTabs-flexContainer css-k008qs']//button)["+randomNumber+"]"));
            String TabName = Tab.getText();
            log.info("tab name " + TabName);
            Tab.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(ConfirmationPOPUP.isVisible());
            yesbuttonOnpopup.click();
            withAction().pause(Duration.ofSeconds(7)).build().perform();
            switch (TabName) {
                case "Approval workflow":
                    Assert.assertTrue(Participants_text.isVisible());
                    break;
                case "Enforcement rule":
                    Assert.assertTrue(fornewdocument_text.isVisible());
                    break;
                case "Legal term":
                    if (connecteduser_text.isVisible()) {
                        Assert.assertTrue(connecteduser_text.isVisible());
                    }else {
                        Assert.assertTrue(Ck_editor.isVisible());
                    }
                    break;
                case "Auth scope":
                    Assert.assertTrue(authproducts_text.isVisible());
                    break;
                case "Limit scope":
                    Assert.assertTrue(InputContainer_On_LimitScope.isVisible());
                    break;
                case "USP rider":
                    Assert.assertTrue(USPRiderContainer.isVisible());
                    break;
                case "Preview & Submit":
                    Assert.assertTrue(FinalPreview_text.isVisible());
                    break;
            }
        }catch (Exception e){
            log.error(" Unable to see confirm while changing tab Without save changes of General Tab" +e);
            Assert.fail();
        }
    }

    public void CheckTheFunctionalityOFResetCurrentChangesButton(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Addressfield_for_PrimeBroker1.waitUntilVisible().isVisible();
//            withAction().moveToElement(Addressfield_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            String BeforeResetAddress = Addressfield_for_PrimeBroker1.getAttribute("value");
            withAction().moveToElement(Addressfield_for_PrimeBroker1).sendKeys(dataTable.get("Address")).pause(Duration.ofSeconds(4)).build().perform();

            Contactfield_for_PrimeBroker1.waitUntilVisible().isVisible();
//            withAction().moveToElement(Contactfield_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            String BeforeResetContact = Contactfield_for_PrimeBroker1.getAttribute("value");
            withAction().moveToElement(Contactfield_for_PrimeBroker1).sendKeys(dataTable.get("Contact")).pause(Duration.ofSeconds(4)).build().perform();

            NOTEStextField_for_PrimeBroker1.waitUntilVisible().isVisible();
//            withAction().moveToElement(NOTEStextField_for_PrimeBroker1).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            String BeforeResetNotes = NOTEStextField_for_PrimeBroker1.getText();
            withAction().moveToElement(NOTEStextField_for_PrimeBroker1).sendKeys(dataTable.get("Notes")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            ResetCurrentChanges_Button.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(7)).build().perform();

            log.info("address field " + BeforeResetAddress,Addressfield_for_PrimeBroker1.getAttribute("value"));
            log.info("Contact field " + BeforeResetContact,Contactfield_for_PrimeBroker1.getAttribute("value"));
            log.info("Notes field " + BeforeResetNotes,NOTEStextField_for_PrimeBroker1.getText());


            Assert.assertEquals(BeforeResetAddress,Addressfield_for_PrimeBroker1.getAttribute("value"));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals(BeforeResetContact,Contactfield_for_PrimeBroker1.getAttribute("value"));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals(BeforeResetNotes,NOTEStextField_for_PrimeBroker1.getText());
        } catch (Exception e) {
            log.error("Unable to Enter input for Address, contact and Notes fields-->" + e);
            Assert.fail();
        }
    }


}