package PageObjects.DMS_PHASE2PageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import javax.swing.*;
import java.time.Duration;
@Slf4j
@Data
public class Utility extends PageObject
{

    public static void Horizontal_scroll(WebElementFacade ele, WebDriver driver)
    {
        Actions act= new Actions(driver);
        act.pause(Duration.ofSeconds(2)).build().perform();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", ele);
        act.pause(Duration.ofSeconds(2)).build().perform();
        jsExecutor.executeScript("window.scrollBy(0, 500);");
        jsExecutor.executeScript("document.querySelector(\".document-listing.conditional-scrollable\").scrollLeft=10000");

    }
    public static void explicit_wait(WebElementFacade ele, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public static void quiting_and_failing()
    {
       log.info("Data not found going to fail test");
        Assert.fail();
    }
}
