package PageObjects.DMS_PHASE2PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Slf4j
@Data

public class DMS_2201PageObject extends PageObject {

    @FindBy(xpath="//button[text()='Create New']")
    private WebElementFacade createNewUSP_button;

    @FindBy(xpath="//input[@type='checkbox']")
    private WebElementFacade USPId_checkbox;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_button;

    @FindBy(xpath="//button[text()='USP Rider']")
    private WebElementFacade USPRiderTab_previewSubmit;

    @FindBy(xpath = "//div[text()='Final Preview']")
    private WebElementFacade finalPreview_text;

    @FindBy(xpath = "//div[text()='Edit Document']")
    private WebElementFacade editDocumentText;

    @FindBy(xpath = "//button[text()='Limit scope']")
    private WebElementFacade limitScopeTab;

    @FindBy(xpath = "//div[@class='alert-msg']")
    private WebElementFacade alertPopup;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade alertPopup_YesBtn;

    @FindBy(xpath = "//div[text()='Prime Broker']//following-sibling::strong")
    private WebElementFacade primeBrokerName_UspPreviewSubmit;

    @FindBy(xpath = "//div[text()='Client']//following-sibling::strong")
    private WebElementFacade clientName_UspPreviewSubmit;

    @FindBy(xpath = "//strong[text()='PB Contact']/following-sibling::div")
    private WebElementFacade pbContactText_UspPreviewSubmit;

    @FindBy(xpath = "//strong[text()='Word clause (Standard) ']/following-sibling::div")
    private WebElementFacade wordClauseText_UspPreviewSubmit;

    @FindBy(xpath = "//div[@class='fund-leis']//div")
    private WebElementFacade fundLEIName_UspPreviewSubmit;

    @FindBy(xpath = "//button[text()='View as PDF']")
    private WebElementFacade viewAsPDFButton_PreviewSubmitScreen;

    @FindBy(xpath = "//li[text()='USP Rider']")
    private WebElementFacade uspRiderText_ViewAsPDFScreen;

    @FindBy(xpath = "//div[@class='usp-selection-div']//strong")
    private WebElementFacade uspRiderId_ViewAsPDFScreen;

    @FindBy(xpath = "//input[@class='date-range-picker']")
    private WebElementFacade datePicker_USPRiderTab;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElementFacade uspRiderID_checkbox;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade nextButton_UspScreen;

    @FindBy(xpath="//input[@placeholder='Enter contact']")
    private WebElementFacade enterPBContact;

    @FindBy(xpath="//label[@class='clause_checkbox']")
    private WebElementFacade wordClause_checkbox;

    @FindBy(xpath="//*[@data-testid='fund-drawer-multi-select'] | //div[text()='Search & add funds']")
    private WebElementFacade searchAndAddFund;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade add_button;

    @FindBy(xpath = "//div[@class='radio']//label[text()='Yes']")
    private List<WebElementFacade> yesRadioButton;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;

    public void clickCreateNewUspButton_andCreateIfNotCreated(){
        try{
            if (uspRiderId_ViewAsPDFScreen.isVisible()){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(datePicker_USPRiderTab.isVisible());
            }
            else {
                createNewUSP_button.waitUntilVisible();
                withAction().moveToElement(createNewUSP_button).click().build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                enterPBContact.waitUntilVisible();
                withAction().moveToElement(enterPBContact).click().sendKeys("4673679").pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(wordClause_checkbox).click().build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", searchAndAddFund);
                withAction().moveToElement(searchAndAddFund).click().sendKeys("Automation_test").pause(Duration.ofSeconds(2)).build().perform();
                add_button.waitUntilVisible();
                withAction().moveToElement(add_button).click().build().perform();
                for(WebElementFacade yes_RadioButton : yesRadioButton){

                    yes_RadioButton.click();
                    log.info("Able to select all YES Radio buttons");
                }
                submit_btn.waitUntilEnabled();
                withAction().moveToElement(submit_btn).click().build().perform();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                withAction().moveToElement(uspRiderID_checkbox).click().build().perform();
                Assert.assertTrue(datePicker_USPRiderTab.isVisible());
            }
        }
        catch (Exception e){

        }
    }
}
