package PageObjects.GeneralFeatures;

import Utilities.ConfigFileReader;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@Slf4j
@Data
public class MultiUserLoginPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    ConfigFileReader configfileReader;

    @FindBy(xpath = "//a[text()='Click here to login again']")
    private WebElementFacade ReloginpopUp;
    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    private WebElementFacade username;

    @FindBy(xpath = "//div[text()='Sign in']")
    private WebElementFacade test;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElementFacade pass;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElementFacade login;

    public void AccountReLoginPopUp(){
        ReloginpopUp.waitUntilVisible();
        ReloginpopUp.click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    public void AccountLoginAsPB_OSTTRA(){
        $(username).click();
        $(username).sendKeys(configfileReader.getDataFromConfigFile("environments.qa2.username"));
        $(login).click();

    }
    public void closeTheBrowser(){
        getDriver().manage().deleteAllCookies();
        getJavascriptExecutorFacade().executeScript("window.localStorage.clear();");
        getJavascriptExecutorFacade().executeScript("window.sessionStorage.clear();");
        getDriver().quit();

    }

}
