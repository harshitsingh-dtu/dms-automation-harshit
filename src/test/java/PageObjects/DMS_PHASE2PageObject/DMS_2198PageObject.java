package PageObjects.DMS_PHASE2PageObject;

import PageObjects.Documents.DocumentPageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
@Slf4j
@Data

public class DMS_2198PageObject extends PageObject {
    DocumentPageObject documentPageObject;
    Actions act = new Actions(getDriver());
    @FindBy(xpath = "//*[@placeholder='Select Orgtype']")
    private WebElementFacade selectActingAs;

    @FindBy(xpath = "//*[text()='+Create new document' or text()='+ Create new document']")
    private WebElementFacade createNewDocument;
    @FindBy(xpath = "//input[@placeholder=\"Select Doc type\"]")
    private WebElementFacade selectDocType;

    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Document']")
    private WebElementFacade document_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-All documents']")
    private WebElementFacade allDocument_tab;
    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')]")
    private WebElementFacade menu_btn;

    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')]")
    private WebElementFacade navigation_btn;

    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupsAndTemplate;

    @FindBy(xpath = "//a[@data-testid='submenu-link-USP Riders']")
    private WebElementFacade USPRiderTemplate;

    @FindBy(xpath = "//div[text()='Showing all USP Riders']")
    private WebElementFacade USPRiderTemplate_screen;

    @FindBy(xpath = "//button[text()='+ Create New USP Rider']")
    private WebElementFacade createNewTemplate_btn;

    @FindBy(xpath = "//h3[text()='Create New USP Rider']")
    private WebElementFacade createNewUSPTemplate_screen;

    @FindBy(xpath = "//input[@placeholder='Doc type']")
    private WebElementFacade docType_dropdown;

    @FindBy(xpath = "//input[@placeholder=\"Select Doc Type\"]")
    private WebElementFacade createDocType_dropdown;

    @FindBy(xpath = "//input[@placeholder='PB']")
    private WebElementFacade selectPrimeBroker;

    @FindBy(xpath = "//*[text()='Select Prime Broker']/..//input")
    private WebElementFacade selectUSPPB;

    @FindBy(xpath = "//*[text()='Select Client']/..//input")
    private WebElementFacade selectUSP_Client;

    @FindBy(xpath = "//header[text()='Client*']/following-sibling::div[@class='custom-select-container create-select']")
    private WebElementFacade selectClient;

    @FindBy(xpath = "//input[@placeholder='Enter contact']")
    private WebElementFacade enterPBContact;

    @FindBy(xpath = "//label[@class='clause_checkbox']")
    private WebElementFacade wordClause_checkbox;

    @FindBy(xpath = "//th[text()='Covered PB counterparty/Class of covered PB counterparties']")
    private WebElementFacade firstColumn_text;

    @FindBy(xpath = "//*[@data-testid='fund-drawer-multi-select']//input | //div[text()='Search & add fund']")
    private WebElementFacade searchAndAddFund;

    @FindBy(xpath = "//*[@data-testid='fund-drawer-multi-select'] | //div[text()='Search & add funds']")
    private WebElementFacade searchAndAddFund2;

    @FindBy(xpath = "//th[text()='Agreed in writing to (x) oral disclosure of pre-trade mid and basic METs and (y) disclosure for multiple swaps as described in CFTC Rule 23.402(f)']")
    private WebElementFacade secondColumn_text;

    @FindBy(xpath = "//th[text()='Agreed in writing to (x) oral disclosure of pre-trade mid and basic METs and (y) disclosure for multiple swaps as described in CFTC Rule 23.402(f)']//following::div[@class='radio-block'][1]")
    private WebElementFacade secondColumn_radioBlock;

    @FindBy(xpath = "//th[text()='Agreed in writing to non-disclosure of pre-trade mid in accordance with relief provided in CFTC Letter']")
    private WebElementFacade thirdColumn_text;

    @FindBy(xpath = "//th[text()='No. 12-42']")
    private WebElementFacade firstSubColumn_text;

    @FindBy(xpath = "//th[text()='No. 12-42']//following::div[@class='radio-block'][2]")
    private WebElementFacade firstSubColumn_radioBlock;

    @FindBy(xpath = "//th[text()='No. 12-58']")
    private WebElementFacade secondSubColumn_text;

    @FindBy(xpath = "//th[text()='No. 12-58']//following::div[@class='radio-block'][3]")
    private WebElementFacade secondSubColumn_radioBlock;

    @FindBy(xpath = "//th[@data-testid='usp-table-th-subcolumn-additionalRelief']")
    private WebElementFacade additionalRelief_text;

    @FindBy(xpath = "//div[contains(@class, 'radio-block') and .//input[contains(@name, 'additionalRelief')]]")
    private WebElementFacade additionalRelief_radioBlock;

    @FindBy(xpath = "//span[text()='4 Way']")
    private WebElementFacade fourWay_text;

    @FindBy(xpath = "//span[text()='DN']")
    private WebElementFacade DN_text;

    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade noOptionForDocType;

    @FindBy(xpath = "(//div[@class='select-menu-container'])[10]")
    private WebElementFacade lists_lastLEI;

    @FindBy(xpath = "//div[@id='react-select-2-listbox']")
    private WebElementFacade searchedResult;

    @FindBy(xpath = "//div[@id='react-select-3-listbox']")
    private WebElementFacade searchedResult2;

    @FindBy(xpath = "//div[@class='select-head select-label']")
    private WebElementFacade searchedResult3;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancel_btn;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;

    @FindBy(xpath = "//textarea[@placeholder='Type word clause']")
    private WebElementFacade typeWordClause_field;

    @FindBy(xpath = "//img[@alt='Add']")
    private WebElementFacade add_icon;

    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade delete_icon;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade add_button;

    @FindBy(xpath = "//div[@class='radio']//label[text()='Yes']")
    private List<WebElementFacade> yesRadioButton;

    @FindBy(xpath = "//div[@class='radio']//label[text()='Yes']")
    private WebElementFacade yesButton;

    @FindBy(xpath = "//div[@class='radio']//label[text()='No']")
    private List<WebElementFacade> noRadioButton;

    @FindBy(xpath = "//div[@class='radio']//label[text()='No']")
    private WebElementFacade noButton;

    @FindBy(xpath = "//button[@title='Clear']")
    private WebElementFacade clearIcon;

    @FindBy(xpath = "//div[@class='radio-block']")
    private List<WebElementFacade> radioButtonCombination;

    @FindBy(xpath = "//div[@class='alert-msg']")
    private WebElementFacade alertPopup;

    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade alertPopup_NoBtn;

    @FindBy(xpath = "//div[text()='USP Rider created']")
    private WebElementFacade USPTemplateCreate_toastMessage;

    @FindBy(xpath = "(//tr/td)[4]/div")
    private static WebElementFacade inputFirstDocType;

    @FindBy(xpath = "(//tr/td)[2]")
    private WebElementFacade inputFirstPBLei;

    @FindBy(xpath = "(//tr/td)[3]")
    private WebElementFacade inputFirstClientLei;

    @FindBy(xpath = "//*[@role=\"alert\"]/div[2]")
    private WebElementFacade toastAlert_USPCreateScreen;

    @FindBy(xpath = "//div[@class='lei-org-title']//input[@placeholder='Select Doc Type']")
    private WebElementFacade select_DocType_addedLEI;

    @FindBy(xpath = "//div[@class='lei-org-title']//input[@placeholder='Select Org Type']")
    private WebElementFacade select_OrgType_addedLEI;

    @FindBy(xpath = "//span[@class='lei-name']")
    private WebElementFacade check_LEIName;

    @FindBy(xpath = "//tbody//button[@class='cross-btn']")
    private WebElementFacade cross_btn;

    @FindBy(xpath = "//div[@class=\"lp-copy-sel__indicator lp-copy-sel__clear-indicator css-1xc3v61-indicatorContainer\"]")
    private WebElementFacade cross_icon;


    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade YES_Btn_confirmation;

    @FindBy(xpath = "//tbody//button[@class='cross-btn']")
    private List<WebElementFacade> crossButtonSize;

    @FindBy(xpath = "//div[@class=\"no-record-found\"]")
    private WebElementFacade noRecord;

    @FindBy(xpath = "//*[text()='Select Prime Broker - 1']")
    private WebElementFacade selectPB1;
    @FindBy(xpath = "//*[text()='Select Client - 1']")
    private WebElementFacade selectClient1;
    @FindBy(xpath = "//*[text()='Select Prime Broker - 2']")
    private WebElementFacade selectPB2;
    @FindBy(xpath = "//*[text()='Select Client - 2']")
    private WebElementFacade selectClient2;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_btn;

    @FindBy(xpath = "//th[text()='CreditLink Sync Status']")
    private WebElementFacade creditLinkStatus;

    @FindBy(xpath = "//button[text()='+ Create new document']")
    private WebElementFacade CreateNewDocument_Button;

    @FindBy(xpath = "(//button[text()='Update'])[1]")
    private WebElementFacade Update_Button;

    @FindBy(xpath = "//h3[text()='Edit USP Rider']")
    private WebElementFacade Edit_USP_Rider;

    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade closeDropDown;

    @FindBy(xpath = "//textarea[@placeholder='Type word clause']")
    List<WebElementFacade> USP_Rider_Text;

    @FindBy(xpath = "//label[text()='Yes']/preceding-sibling::input[@value='true']")
    List<WebElementFacade> Yes_Selected;

    @FindBy(xpath = "(//td[img[@class='audit-log-btn']])[1]")
    private WebElementFacade Audit_Button;

    @FindBy(xpath = "//div[text()='USP Rider History']")
    private WebElementFacade UspRiderScreen_Text;

    @FindBy(xpath = "//div[contains(@class,'modal')]//tbody/tr[1]/td[3]")
    private WebElementFacade USP_History_AuditEvent;

    @FindBy(xpath = "//div[contains(@class,'modal')]//tbody/tr[1]/td[4]")
    private WebElementFacade USP_History_Date;

    @FindBy(xpath = "//div[contains(@class,'modal')]//tbody/tr[1]/td[5]")
    private WebElementFacade USP_History_UpdatedBy;

    @FindBy(xpath = "//div[contains(@class,'modal')]//tbody/tr[1]/td[6]")
    private WebElementFacade USP_History_EventChanges;

    public void navigateToUSPRiderTemplateScreen() {
        try {
            navigation_btn.waitUntilClickable();
            navigation_btn.click();
            withAction().moveToElement(groupsAndTemplate).click().build().perform();
            withAction().moveToElement(USPRiderTemplate).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("Unable to navigate to USP Rider Template screen" + e);
            Assert.fail();
        }
    }

    public void checkMultiselect_docType() {
        try {
            docType_dropdown.click();
            if (fourWay_text.isVisible() && DN_text.isVisible()) {
                fourWay_text.click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                DN_text.click();
                log.info("Able to select both doc type simultaneously");
            } else {
                log.info("4 Way and DN is not visible simultaneously");
                Assert.fail();
            }
        } catch (Exception e) {
            log.error("Unable to select both doc type simultaneously" + e);
            Assert.fail();
        }
    }

    public void check_docTypeDropdown(List<String> docType) {
        try {
            for (int begin = 1; begin < docType.size(); begin++) {
                if (clearIcon.isVisible()) {
                    clearIcon.click();
                }
                withAction().moveToElement(docType_dropdown).click().sendKeys(docType.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                if (fourWay_text.isVisible()) {
                    fourWay_text.click();
                    log.info("Able to select 4 Way Doc type ");
                } else if (DN_text.isVisible()) {
                    DN_text.click();
                    log.info("Able to select DN Doc type ");
                } else {
                    log.info("No Options is visible");
                }
            }
        } catch (Exception e) {
            log.error("Unable to select doc type" + e);
            Assert.fail();
        }
    }

    public void validate_searchAndAddFund() {
        try {
            List<WebElementFacade> infoList = findAll("//div[@class='select-menu-container']");
            int column_size = infoList.size();
            log.info("column size on screen is :" + column_size);

            for (WebElementFacade Info_Text : infoList) {

                Assert.assertTrue(Info_Text.isVisible());
                log.info(Info_Text.getText());

            }
            if (column_size == 10) {
                log.info("By Default list size equals to 10");
            } else {
                log.info("By Default list size is not equals to 10");
                Assert.fail();
            }
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", lists_lastLEI);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        } catch (Exception e) {
            log.error("Unable to validate search & add fund dropdown" + e);
            Assert.fail();
        }
    }

    public void select_searchAndAddFund(List<String> lei) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", searchAndAddFund);
            for (int begin = 1; begin < lei.size(); begin++) {
                withAction().moveToElement(searchAndAddFund).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
                withAction().moveToElement(searchAndAddFund).click().sendKeys(lei.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                String SearchedResultText = searchedResult.getText().trim();
                log.info("Searched result text :" + SearchedResultText);
                if (SearchedResultText.contains(lei.get(begin))) {
                    log.info("Searched LEI Name or ID is visible");
                } else {
                    log.info("Searched LEI Name or ID is not visible");
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            log.error("Searched LEI Name or ID is not visible");
            Assert.fail();
        }
    }

    public void checkCharacterLengthOfPBContactField() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", enterPBContact);
        withAction().pause(Duration.ofSeconds(2)).build().perform();

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
            withAction().moveToElement(enterPBContact).click().sendKeys(generatedString).pause(Duration.ofSeconds(2)).build().perform();
            int EnteredStringLength = enterPBContact.getAttribute("value").length();
            Assert.assertEquals(100, EnteredStringLength);

        } catch (Exception e) {
            log.error("Unable to validate length of Character for PB Contact Field" + e);
            Assert.fail();
        }
    }

    public void selectDocType() {
        try {
            Random random = new Random();
            int randomNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(createDocType_dropdown).click().build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).click().build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error(" Unable to Select doc type " + e);
            Assert.fail();
        }
    }

    public void selectDoc() {
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(createDocType_dropdown).click().build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            withAction().sendKeys(Keys.ENTER).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            withAction().sendKeys(Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            closeDropDown.click();
        } catch (Exception e) {
            log.error(" Unable to Select doc type " + e);
            Assert.fail();
        }
    }

    public void validate_PB_ClientDropdown() {
        try {
            List<WebElementFacade> infoList = findAll("//div[@class='select-menu-container']");
            int column_size = infoList.size();
            log.info("column size on screen is :" + column_size);

            for (WebElementFacade Info_Text : infoList) {

                Assert.assertTrue(Info_Text.isVisible());

            }
        } catch (Exception e) {
            log.error("No list is visible in the dropdown" + e);
            Assert.fail();
        }
    }

    public void searchLei_PBDropdown(List<String> lei) {
        try {
            withAction().moveToElement(selectUSPPB).click().sendKeys(lei.get(1)).pause(Duration.ofSeconds(3)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).pause(Duration.ofSeconds(1)).build().perform();
            String SearchedResultText = searchedResult3.getText();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if (SearchedResultText.contains(lei.get(1).trim())) {
                log.info("Correct LEI is selected");
            } else {
                log.info("No options is visible");
            }
        } catch (Exception e) {
            log.error("Unable to validate search in PB dropdown" + e);
            Assert.fail();
        }
    }

    public void searchLei_clientDropdown(List<String> lei) {
        try {
            withAction().moveToElement(selectClient).click().sendKeys(lei.get(1)).pause(Duration.ofSeconds(3)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).pause(Duration.ofSeconds(1)).build().perform();
            String SearchedResultText = searchedResult.getText().trim();
            if (SearchedResultText.contains(lei.get(1).trim())) {
                log.info("Correct LEI is selected");
            } else {
                log.info("No options is visible");
            }
        } catch (Exception e) {
            log.error("Unable to validate search in Client dropdown" + e);
            Assert.fail();
        }
    }

    public void edit_wordClauseTextBox() {
        try {
            typeWordClause_field.clear();
            log.info("Able to edit word clause text box");
        } catch (Exception e) {
            log.info("Unable to edit word clause text box" + e);
            Assert.fail();
        }
    }

    public void enterSearchAddFund(List<String> lei) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView({ block: 'center' });", searchAndAddFund);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            for (int begin = 1; begin < lei.size(); begin++) {
                log.info("Adding LEI [{} of {}]: {}", begin, lei.size() - 1, lei.get(begin));
                withAction().moveToElement(searchAndAddFund).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).sendKeys(lei.get(begin)).pause(Duration.ofSeconds(1)).build().perform();
                try {
                    if (searchedResult != null && searchedResult.isCurrentlyVisible()) searchedResult.click();
                    else withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
                } catch (Exception e) { withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform(); }
                withAction().pause(Duration.ofMillis(500)).build().perform();
                try { add_button.withTimeoutOf(Duration.ofSeconds(3)).waitUntilClickable().click(); } 
                catch (Exception e) { js.executeScript("arguments[0].click();", add_button); }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to input search and add fund: " + e.getMessage());
            Assert.fail();
        }
    }

    public void enterSearchAddFund2(List<String> lei) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", searchAndAddFund);
            for (int begin = 1; begin < lei.size(); begin++) {
                log.info("LEI Size :" + lei.size());
                withAction().moveToElement(searchAndAddFund).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
                withAction().moveToElement(searchAndAddFund).click().sendKeys(lei.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                String SearchedResultText = searchedResult2.getText().trim();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (add_button.isVisible()) {
                    add_button.click();
                } else if (SearchedResultText.contains(lei.get(begin))) {
                    log.info("Searched LEI Name or ID is visible");
                    searchedResult2.click();
                } else {
                    log.info("Searched LEI Name or ID is not visible");
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            log.error("Unable to input search and add fund");
            Assert.fail();
        }
    }

    public void select_allYesOptions() {
        try {
            int column_size = yesRadioButton.size();
            log.info("column size on screen is :" + column_size);

            for (WebElementFacade yes_RadioButton : yesRadioButton) {

                yes_RadioButton.click();
                log.info("Able to select all YES Radio buttons");
            }
        } catch (Exception e) {
            log.error("Unable to select all YES Radio buttons" + e);
            Assert.fail();
        }
    }

    public void select_allNOOptions() {
        try {
            int column_size = noRadioButton.size();
            log.info("column size on screen is :" + column_size);

            for (WebElementFacade no_radioButton : noRadioButton) {

                no_radioButton.click();
                log.info("Able to select all NO Radio buttons");
            }
        } catch (Exception e) {
            log.error("Unable to select all NO Radio buttons" + e);
            Assert.fail();
        }
    }

    public void select_randomCombinationYes_NO() {
        try {
            int column_size = radioButtonCombination.size();
            log.info("column size on screen is :" + column_size);

            for (int i = 1; i <= column_size; i++) {

                final String[] options = {"Yes", "No"};
                Random random = new Random();
                int index = random.nextInt(options.length);
                System.out.println(options[index]);
                if (index == 1) {
                    yesButton.click();
                } else {
                    noButton.click();
                }
            }
        } catch (Exception e) {
            log.error("Unable to select random Radio buttons" + e);
            Assert.fail();
        }
    }

    public void enterNonExistingLEI(List<String> lei) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", searchAndAddFund);
            for (int begin = 1; begin < lei.size(); begin++) {
                withAction().moveToElement(searchAndAddFund).click().sendKeys(lei.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to input search and add fund");
            Assert.fail();
        }
    }

    public void enterLEIPBDropdown() {
        try {
            Random random = new Random();
            int randomNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randomNumber);
            int randomIndex = random.nextInt(26);
            char a = (char) (randomIndex + 97);
            String randomLetter = String.valueOf(a);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(selectUSPPB).click().sendKeys(randomLetter).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error(" Unable to Select LEI in PB dropdown " + e);
            Assert.fail();
        }
    }

    public void enterLEIClientDropdown() {
        try {
            Random random = new Random();
            int randomNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randomNumber);
            int randomIndex = random.nextInt(26);
            char a = (char) (randomIndex + 97);
            String randomLetter = String.valueOf(a);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(selectUSP_Client).click().sendKeys(randomLetter).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to select LEI in Client dropdown" + e);
            Assert.fail();
        }
    }

    public void enterPBContact(List<String> contact) {
        try {
            for (int begin = 1; begin < contact.size(); begin++) {
                enterPBContact.clear();
                withAction().moveToElement(enterPBContact).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
                withAction().moveToElement(enterPBContact).click().sendKeys(contact.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to enter PB Contact" + e);
            Assert.fail();
        }
    }

    public void selectDocType_AndParties() {
        try {
            String FirstDocTypeText = "4 Way";
            String FirstPBLEIText = inputFirstPBLei.getText().trim();
            String FirstClientLEIText = inputFirstClientLei.getText().trim();
            withAction().moveToElement(createNewTemplate_btn).click().build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(createDocType_dropdown).click().sendKeys(FirstDocTypeText).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
            closeDropDown.click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(selectUSPPB).click().sendKeys(FirstPBLEIText).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(selectUSP_Client).click().sendKeys(FirstClientLEIText).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select doc type and LEI in both PB and Client dropdown" + e);
            Assert.fail();
        }
    }

    public void selectOrgType_USPRider(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_OrgType_addedLEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).click().sendKeys(dataTable.get("org type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if (check_LEIName.isVisible()) {
                int column_size = crossButtonSize.size();
                log.info("column size on screen is :" + column_size);

                for (WebElementFacade Cross_Button : crossButtonSize) {

                    Cross_Button.click();
                    YES_Btn_confirmation.waitUntilVisible();
                    YES_Btn_confirmation.click();
                }
            }
            if (submit_btn.isEnabled()) {
                submit_btn.click();
                withAction().pause(Duration.ofSeconds(10)).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to remove DN PB LEI" + e);
            Assert.fail();
        }
    }

    public void selectDocType_OrgType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_DocType_addedLEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_DocType_addedLEI).click().sendKeys(dataTable.get("doc type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            select_OrgType_addedLEI.waitUntilClickable();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(select_OrgType_addedLEI).click().sendKeys(dataTable.get("org type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if (check_LEIName.isVisible()) {
                cross_btn.click();
                YES_Btn_confirmation.waitUntilVisible();
                YES_Btn_confirmation.click();
            }
            if (submit_btn.isEnabled()) {
                submit_btn.click();
                withAction().pause(Duration.ofSeconds(10)).build().perform();
            }
        } catch (Exception e) {
            log.error("Unable to remove DN PB LEI" + e);
            Assert.fail();
        }
    }

    public void select_docTypeDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            docType_dropdown.isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(docType_dropdown).click().sendKeys(dataTable.get("Doc Type")).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().findElement(By.xpath("//div[@role='presentation']//*[text()='" + dataTable.get("Doc Type") + "']")).click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select doc type" + e);
            Assert.fail();
        }
    }

    public void selectPBDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(selectUSPPB).click().sendKeys(dataTable.get("LEI")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.info("unable to input Legal Terms-->" + e);
            Assert.fail();
        }
    }

    public void selectClientDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(selectUSP_Client).click().sendKeys(dataTable.get("Client")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.info("unable to input Legal Terms-->" + e);
            Assert.fail();
        }
    }

    public void select_CreateDocType(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            createDocType_dropdown.isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(createDocType_dropdown).click().sendKeys(dataTable.get("Doc Type")).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().findElement(By.xpath("//div[@role='presentation']//*[text()='" + dataTable.get("Doc Type") + "']")).click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select doc type" + e);
            Assert.fail();
        }
    }

    public void selectLei_PBDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            selectPrimeBroker.waitUntilVisible().click();
            typeInto(selectPrimeBroker, dataTable.get("LEI"));
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(selectPrimeBroker).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("unable to select PB dropdown->" + e);
            Assert.fail();
        }
    }

    public void selectLei_ClientDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            selectUSP_Client.waitUntilVisible().click();
            typeInto(selectUSP_Client, dataTable.get("Client"));
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            withAction().moveToElement(selectUSP_Client).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("unable to client dropdown-->" + e);
            Assert.fail();
        }
    }

    public void enterContact(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            enterPBContact.waitUntilVisible().click();
            typeInto(enterPBContact, dataTable.get("Contact"));

        } catch (Exception e) {
            log.error("Unable to enter PB Contact" + e);
            Assert.fail();
        }
    }

    public void addFund(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", searchAndAddFund);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(searchAndAddFund).click().sendKeys(dataTable.get("LEI")).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.TAB).build().perform();
        } catch (Exception e) {
            log.error("Unable to add fund" + e);
            Assert.fail();
        }
    }

    public void filterAndSelectValues() {
        try {
            DMS_2198PageObject dmsObject = new DMS_2198PageObject();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            WebElementFacade filterOnListingScreen = find(By.xpath("//th[text()='" + "CITIGROUP INC" + "']//input"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", creditLinkStatus);
            getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
            filterOnListingScreen.click();
            filterOnListingScreen.clear();
            withAction().pause(Duration.ofSeconds(1)).sendKeys("CITIGROUP INC").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("failed to create document with usp participants " + e);
        }
    }

    public void enterPBDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            selectUSPPB.waitUntilClickable();
            Assert.assertTrue(selectUSPPB.isVisible());
            withAction().moveToElement(selectUSPPB).click().sendKeys(dataTable.get("PB Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.error("Unable to input PB Name-->" + e);
            Assert.fail();
        }
    }

    public void enterClientDropdown(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            selectUSP_Client.waitUntilClickable();
            Assert.assertTrue(selectUSP_Client.isVisible());
            withAction().moveToElement(selectUSP_Client).click().sendKeys(dataTable.get("Client Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.error("Unable to input PB Name-->" + e);
            Assert.fail();
        }
    }

    public Boolean USPRiderWordClause() {
        boolean result = false;
        StringBuilder actual = new StringBuilder();
        String expected = "Reference is made to the (i) Master Foreign Exchange Give-up Agreement dated [Date] (as such may be amended from time to time) in which [Prime Broker] (the \"PB\") acts as prime broker and [Executing Dealer] (the \"ED\") acts as executing dealer (the \"Master Give-up Agreement\"), and (ii) ISDA Derivatives/FX Prime Brokerage Business Conduct Allocation Protocol (\"ISDA PB Protocol\") to which both the PB and ED are or expect to become \"Adhering Parties\" (as defined in the ISDA PB Protocol).\n" +
                "\n" +
                "In accordance with paragraphs (b)(3) and (b)(8) of the Annex to the ISDA PB Protocol (the \"Annex\"), we hereby notifies you that: We designate the PB Counterparties or classes of PB Counterparties specified below as Covered PB counterparties and, with respect to each such counterparty or class, the relevant information for purposes of paragraphs (b)(8) of the Annex is as follows:\n" +
                "\n" +
                "Your signature and subsequent return to us as PB of the Designation Notice(s) under the Master Give-up Agreement for the Covered PB counterparties/Class of Covered PB counterparties listed here in shall constitute your acceptance of the terms of notice.";

        for (int i = 0; i < USP_Rider_Text.size(); i++) {
            actual.append(USP_Rider_Text.get(i).getText());
        }
        if (expected.equalsIgnoreCase(String.valueOf(actual))) {
            result = true;
        }
        return result;
    }

    public boolean validatecontact(DataTable table) {
        boolean visible = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        if (dataTable.get("PBContact").equalsIgnoreCase("Contact")) {
            visible = find(By.xpath("//input[@value='" + dataTable.get("Value") + "']")).isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        return visible;
    }

    public boolean addedfund(DataTable table) {
        boolean visible = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(1);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        if (dataTable.get("PBContact").equalsIgnoreCase("Fund")) {
            visible = find(By.xpath("//div[contains(text(),'" + dataTable.get("Value") + "')]")).isVisible();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        return visible;
    }

    public void validateUspRiderAuditHistoryData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);
        USP_History_AuditEvent.waitUntilVisible();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String expectedDate;
        if (dataTable.get("Date").contains("Current")) {
            boolean dateMatch = USP_History_Date.getText().contains(today) ||
                    USP_History_Date.getText().contains(tomorrow);
            Assert.assertTrue("Date Mismatch!", dateMatch);
        } else {
            expectedDate = dataTable.get("Date").trim();
            Assert.assertTrue("Date Mismatch!", USP_History_Date.getText().contains(expectedDate));
        }
        String actualChanges = USP_History_EventChanges.getText()
                .replace((char) 160, ' ')
                .replaceAll("\\s+", " ").trim();
        String rawExpected = dataTable.get("Event Changes");
        String[] partsToVerify = rawExpected.split(";");
        for (String part : partsToVerify) {
            String expectedPart = part.trim();
            Assert.assertTrue("UI text did not contain: [" + expectedPart + "]. Actual UI text: " + actualChanges,
                    actualChanges.contains(expectedPart));
        }
        Assert.assertTrue("Audit Event mismatch!",
                USP_History_AuditEvent.getText().trim().contains(dataTable.get("Audit Event").trim()));

        Assert.assertTrue("Updated By mismatch!",
                USP_History_UpdatedBy.getText().trim().equalsIgnoreCase(dataTable.get("Updated By").trim()));
    }
}
