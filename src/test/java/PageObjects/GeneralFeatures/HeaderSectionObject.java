package PageObjects.GeneralFeatures;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@Slf4j
@Data
public class HeaderSectionObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//div[text()='qa']")
    private WebElementFacade env;
    @FindBy(xpath = "//span[text()='Messages']")
    private WebElementFacade message;
    @FindBy(xpath = "//div[@class='thumbnail']")
    private WebElementFacade userIcon;
    @FindBy(xpath = "//div[@class='user-details']/b")
    private WebElementFacade userName;
    @FindBy(xpath = "//span[text()='Help']")
    private WebElementFacade HelpSection;
    @FindBy(xpath = "//img[@alt='logo']")
    private WebElementFacade Applogo;
    private WebElement searchText;
    @FindBy(xpath = "//ul[@class='support-list']/li[1]//a")
    private WebElementFacade mail;
    @FindBy(xpath = "//ul[@class='support-list']/li[2]//a")
    private WebElementFacade web;
    @FindBy(xpath = "//button[@class='osttra-modal-close']")
    private WebElementFacade closeIcon;
    @FindBy(xpath = "//*[text()='fx-support@osttra.com']")
    private WebElementFacade supportEmail;

    public void validateEnv(){
        env.waitUntilVisible();
    }
    public void validateAppLogo(){
        Applogo.waitUntilVisible();
        Assert.assertTrue(Applogo.isDisplayed());
    }
    public void validateMessage(){
        message.waitUntilVisible();
        Assert.assertTrue(message.isDisplayed());
    }
    public void validateUserDetails(){
        userIcon.waitUntilVisible();
        Assert.assertTrue(userIcon.isDisplayed());
        Assert.assertTrue(userName.isDisplayed());
    }
    public void validateHelpSection(){
        HelpSection.waitUntilVisible();
        Assert.assertTrue(HelpSection.isDisplayed());
    }
    public void clickOnTExt(String text){
        WebElementFacade element = element(By.xpath("//*[text() = '"+text+"']"));
        element.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().waitUntilClickable();
        element.click();
    }
}
