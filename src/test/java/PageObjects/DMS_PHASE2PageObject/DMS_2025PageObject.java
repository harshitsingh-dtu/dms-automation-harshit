package PageObjects.DMS_PHASE2PageObject;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Random;

@Slf4j
@Data
public class DMS_2025PageObject extends PageObject {

    @FindBy(xpath = "//button[text()='General Terms']")
    private WebElementFacade General_Term_Tab;
    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade PreviewANDSubmit_Tab;
    @FindBy(xpath = "//div[@class='info-head ' and text()='Client - 1']//span[text()='+ View Fund Details']")
    private WebElementFacade ViewFundDetails_Button_forClient1;
    @FindBy(xpath = "//div[@class='info-head ' and text()='Client - 2']//span[text()='+ View Fund Details']")
    private WebElementFacade ViewFundDetails_Button_forClient2;
    @FindBy(xpath = "//button[text()='Edit']")
    private WebElementFacade Edit_button;
    @FindBy(xpath = "//div[@class='btn-content']//button[text()='Cancel']")
    private WebElementFacade Cancel_button;
    @FindBy(xpath = "//label[text()='Action type']/following::input")
    private WebElementFacade Actingtype_Input_ONEDIT_POPUP;
    @FindBy(xpath = "//div[@class='doc-fund-list h-fix' ]//h5[text()='No Record Found']")
    private WebElementFacade NoRecordFound_When_FundsAreNotAdded;
    @FindBy(xpath = "//div[@class='doc-fund-list h-fix']//li")
    private WebElementFacade LISTOFAddedFundForSideWindowOF_ViewFundDetails_Button;




    public void SelectAnyActiontype() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
                Random random = new Random();
                int randomNumber;
                randomNumber = random.nextInt(4) + 1;
                log.info("randomNumber" + randomNumber);
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Actingtype_Input_ONEDIT_POPUP.waitUntilVisible().isVisible();
                withAction().moveToElement(Actingtype_Input_ONEDIT_POPUP).click().build().perform();
                for (int i = 1; i < randomNumber; i++) {
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
                }
                withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Executing Broker 1 " +e);
            Assert.fail();
        }
    }




}
