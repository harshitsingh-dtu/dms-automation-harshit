package PageObjects.Currency;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
public class CurrencySelectionClearPageObject extends PageObject {

    @FindBy(xpath = "//button[contains(text(), 'Remove All') or contains(text(), 'Remove all') or normalize-space(text())='Remove All'] | //span[contains(text(), 'Remove All') or contains(text(), 'Remove all')] | //*[text()='Remove All' or text()='Remove all']")
    private WebElementFacade removeAllBtn;

    public void verifySelectedCurrenciesHighlighted() {
        log.info("Verifying selected currencies are highlighted on the UI as 'Selected' with visual badges");
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        List<WebElementFacade> selectedCards = findAll(By.xpath("//div[contains(@class,'card-select')] | //div[contains(@class,'card card-select')] | //*[contains(@class,'card-select')]"));
        Assert.assertFalse("No selected currencies are currently highlighted or visible on the UI", selectedCards.isEmpty());
        for (WebElementFacade card : selectedCards) {
            Assert.assertTrue("Selected currency card is not visible", card.isCurrentlyVisible());
            log.info("Verified selected currency: " + card.getText());
        }
    }

    public void verifySelectedCurrenciesAfterScrolling() {
        log.info("Verifying selected currencies can be easily identified after scrolling");
        List<WebElementFacade> selectedCards = findAll(By.xpath("//div[contains(@class,'card-select')] | //div[contains(@class,'card card-select')] | //*[contains(@class,'card-select')]"));
        Assert.assertFalse("No selected currencies found to scroll", selectedCards.isEmpty());
        for (WebElementFacade card : selectedCards) {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", card);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            Assert.assertTrue("Selected currency card is not visible after scrolling", card.isCurrentlyVisible());
            log.info("Successfully scrolled and verified: " + card.getText());
        }
    }

    public void clickRemoveAllButton() {
        log.info("Clicking on all visible 'Remove All' buttons, including explicit validation for the Selected currencies window");

        String mainPageXPath = "//button[contains(normalize-space(.), 'Remove All') or contains(normalize-space(.), 'Remove all')]";
        String modalWindowXPath = "//*[contains(text(), 'Selected currencies') or contains(text(), 'Selected Currencies')]/ancestor::*[@role='dialog' or @role='presentation' or contains(@class, 'modal') or contains(@class, 'drawer')]//button[contains(normalize-space(.), 'Remove All') or contains(normalize-space(.), 'Remove all')]";

        String xpath = mainPageXPath + " | " + modalWindowXPath;

        List<WebElementFacade> btns = findAll(By.xpath(xpath));

        Assert.assertFalse("Remove All button is not found on the page or inside the Selected currencies window", btns.isEmpty());

        int clickedCount = 0;

        for (WebElementFacade btn : btns) {
            if (btn.isCurrentlyVisible()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", btn);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                try {
                    btn.waitUntilClickable().click();
                } catch (Exception e) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", btn);
                }

                clickedCount++;
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }

        Assert.assertTrue("Found 'Remove All' elements in DOM, but none were visible to click.", clickedCount > 0);
        log.info("Clicked 'Remove All' successfully " + clickedCount + " time(s).");

        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void verifyCurrencySelectionCleared() {
        log.info("Verifying that currency selection is completely cleared and all checkmarks are deselected");
        List<WebElementFacade> selectedCards = findAll(By.xpath("//div[contains(@class,'card card-select')] | //div[contains(@class,'card-select')] | //*[contains(@class,'card-select')]"));
        int visibleCount = 0;
        for (WebElementFacade card : selectedCards) {
            if (card.isCurrentlyVisible()) {
                visibleCount++;
                log.warn("Found remaining selected card: " + card.getText());
            }
        }
        Assert.assertEquals("Currency selection was not cleared completely. Remaining selected count: " + visibleCount, 0, visibleCount);
        log.info("Verified that all selected currencies have been successfully cleared/deselected.");
    }

    public void verifyAmendedOrSelectedCurrenciesDistinguished() {
        log.info("Verifying selected or amended currencies are clearly and obviously distinguished on the UI");
        List<WebElementFacade> selectedCards = findAll(By.xpath("//div[contains(@class,'card-select')] | //div[contains(@class,'card card-select')] | //*[contains(@class,'card-select')]"));
        Assert.assertFalse("No selected or amended currencies are clearly distinguished/visible on the UI", selectedCards.isEmpty());
        for (WebElementFacade card : selectedCards) {
            Assert.assertTrue("Selected or amended currency card is not visible", card.isCurrentlyVisible());
            log.info("Verified distinguished currency: " + card.getText());
        }
    }

    public void verifySelectedHighlightIndicators() {
        log.info("Verifying currencies display with explicit 'Selected' highlight indicators");
        verifySelectedCurrenciesHighlighted();
    }

    public void verifyOptedInCurrenciesIdentifiable() {
        log.info("Verifying user is able to easily identify all opted-in currencies on the UI");
        verifySelectedCurrenciesHighlighted();
    }
}
