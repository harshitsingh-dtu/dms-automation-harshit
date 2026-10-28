package PageObjects.DMS_PHASE2PageObject;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2517PageObject extends PageObject
{
    @FindBy(xpath = "//tbody/tr")
    private List<WebElementFacade> list_of_USP_templates;
    @FindBy(xpath = "//td/button")
    private List<WebElementFacade> list_of_action_button;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='USP Rider document not available']")
    private WebElementFacade USP_RiderDocument_Not_Available_text_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='USP Rider document not available']")
    private WebElementFacade USP_RiderDocument_Not_Available_text_for2ndContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//button[text()='Create New']")
    private WebElementFacade CreateNEW_button_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//button[text()='Create New']")
    private WebElementFacade CreateNEW_button_for2ndContainer;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforprimebroker1party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[@class='head-status ']")
    private WebElementFacade OnlineStatusFOR_PrimeBroker1_Party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforprimebroker2party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[@class='head-status ']")
    private WebElementFacade OnlineStatusFOR_PrimeBroker2_Party;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='Available USP Rider document']/following::input[@name='checkbox']")
    private WebElementFacade CheckBox_For_Available_USP_Rider_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='Available USP Rider document']/following-sibling::div")
    private WebElementFacade Template_ID_for_Available_USP_Rider_for1stContainer;

    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='Available USP Rider document']")
    private WebElementFacade Available_USP_Rider_Document_text_for2ndContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='Available USP Rider document']/following::input[@name='checkbox']")
    private WebElementFacade CheckBox_For_Available_USP_Rider_for2ndContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]//div[text()='Available USP Rider document']")
    private WebElementFacade Available_USP_Rider_Document_text_for1stContainer;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]//div[text()='Available USP Rider document']/following-sibling::div")
    private WebElementFacade Template_ID_for_Available_USP_Rider_for2ndContainer;

    @FindBy(xpath = "//div[@class='lp-copy-sel__input-container css-19bb58m']")
    private WebElementFacade acting_as_input_field;
    @FindBy(xpath = "//div[@class='acting-content dif']//input")
    private WebElementFacade action_type_input_field;
    public void verify_update_btn_is_visible_for_all_USP_template(){
    for (int i=0;i<=list_of_USP_templates.size()-1;i++)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();

            if (list_of_action_button.get(i).getText().equalsIgnoreCase("Update"))
            {
                log.info("Update button is visible for USP template TC fail");
                Assert.fail();
            } else if (list_of_action_button.get(i).getText().equalsIgnoreCase("View")) {
                log.info("View button is visible for USP template TC Pass");
            }
    }
}
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[2]")
    private WebElementFacade USPRiderContainer2;
    @FindBy(xpath = "(//div[@class='usp-rider-header-container'])[1]")
    private WebElementFacade USPRiderContainer;
    @FindBy(xpath = "//div[text()='Document type']/following-sibling::div/div")
    private WebElementFacade documenttype_text;
    public void CheckUSPRiderTemplateCount(){
            if (documenttype_text.getText().equals("DN")){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(USPRiderContainer.isVisible());
            } else if (documenttype_text.getText().equals("4 Way")) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(USPRiderContainer.isVisible());
                Assert.assertTrue(USPRiderContainer2.isVisible());
            }
    }
    public void CheckUSPRiderDocumentAvailability() {
        try {
            if (documenttype_text.getText().equals("DN")){
                if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && OnlineStatusFOR_PrimeBroker1_Party.isVisible() ) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CreateNEW_button_for1stContainer.isVisible());
                } else if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && litestatusforprimebroker1party.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertFalse(CreateNEW_button_for1stContainer.isVisible());
                } else if (Available_USP_Rider_Document_text_for1stContainer.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CheckBox_For_Available_USP_Rider_for1stContainer.isVisible());
                    Assert.assertTrue(Template_ID_for_Available_USP_Rider_for1stContainer.isVisible());
                }
            } else if (documenttype_text.getText().equals("4 Way")) {
                if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && OnlineStatusFOR_PrimeBroker1_Party.isVisible() ) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CreateNEW_button_for1stContainer.isVisible());
                } else if (USP_RiderDocument_Not_Available_text_for1stContainer.isVisible() && litestatusforprimebroker1party.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertFalse(CreateNEW_button_for1stContainer.isVisible());
                } else if (Available_USP_Rider_Document_text_for1stContainer.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CheckBox_For_Available_USP_Rider_for1stContainer.isVisible());
                    Assert.assertTrue(Template_ID_for_Available_USP_Rider_for1stContainer.isVisible());
                }
                if (USP_RiderDocument_Not_Available_text_for2ndContainer.isVisible() && OnlineStatusFOR_PrimeBroker2_Party.isVisible() ) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CreateNEW_button_for2ndContainer.isVisible());
                } else if (USP_RiderDocument_Not_Available_text_for2ndContainer.isVisible() && litestatusforprimebroker2party.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertFalse(CreateNEW_button_for2ndContainer.isVisible());
                } else if (Available_USP_Rider_Document_text_for2ndContainer.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    Assert.assertTrue(CheckBox_For_Available_USP_Rider_for2ndContainer.isVisible());
                    Assert.assertTrue(Template_ID_for_Available_USP_Rider_for2ndContainer.isVisible());
                }
            }

        }catch (Exception e){
            log.error("unable to validate Document template and create new Availability ");
            Assert.fail();
        }
    }
    public void select_acting_as(String ActingAs)
    {
        withAction().moveToElement(acting_as_input_field).click().sendKeys(ActingAs,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }
    public void select_action_type(String ActionType)
    {
        withAction().moveToElement(action_type_input_field).click().sendKeys(ActionType,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }
}