package stepDefinations.UserManagementStep; // Change this to your actual package

import Utilities.SecondaryUserLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebdriverManager;
import net.thucydides.core.pages.Pages;

import java.time.Duration;

public class SecondaryUserSteps {

    WebDriver primaryDriver;
    SecondaryUserLogin secondaryLogin = new SecondaryUserLogin();
    WebDriver secondDriver;
    @When("^The secondary user navigates to the document listing screen$")
    public void The_secondary_user_navigates_to_the_document_listing_screen() {
        WebDriverWait wait = new WebDriverWait(secondDriver, Duration.ofSeconds(20));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Pending Approval')] | //button[contains(., 'Columns Selection')]")));
            Thread.sleep(3000);
        } catch (Exception e) {
            org.junit.Assert.fail("Secondary user Dashboard did not load within the expected time. Error: " + e.getMessage());
        }
    }

    @When("A {string} user logs into the application in an incognito window")
    public void a_secondary_user_logs_into_the_application_in_an_incognito_window(String user) {
        primaryDriver = ThucydidesWebDriverSupport.getDriver();
        secondDriver = secondaryLogin.loginSecondaryUserIncognito(user);
        WebdriverManager manager = ThucydidesWebDriverSupport.getWebdriverManager();
        manager.registerDriver(secondDriver);
        Pages pages = ThucydidesWebDriverSupport.getPages();
        pages.setDriver(secondDriver);
        ThucydidesWebDriverSupport.useDriver(secondDriver);
    }

    @Then("^Close the secondary browser$")
    public void close_the_secondary_browser() {
        if (primaryDriver != null) {
            WebdriverManager manager = ThucydidesWebDriverSupport.getWebdriverManager();
            manager.registerDriver(primaryDriver);
            Pages pages = ThucydidesWebDriverSupport.getPages();
            pages.setDriver(primaryDriver);
            ThucydidesWebDriverSupport.useDriver(primaryDriver);
        }
        secondaryLogin.closeIncognitoBrowser();
    }

}