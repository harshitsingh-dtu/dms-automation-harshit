package PageObjects.PlatformServices;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.time.Duration;
@Slf4j
@Data
public class PlatformServicesPageObject extends PageObject {
    @FindBy(xpath="//div[text()='Platform services']")
    private WebElementFacade platformServices;
    @FindBy(xpath="//div[text()='Parent Organisations']")
    private WebElementFacade parentOrganisations;
    @FindBy(xpath="//label[normalize-space()='Parent Organisation']")
    private WebElementFacade parentOrganisations_text;
    @FindBy(xpath="//div[text()='Legacy Organisations']")
    private WebElementFacade legacyOrganisations;
    @FindBy(xpath="//header[normalize-space()='Legacy Organisations']")
    private WebElementFacade legacyOrganisations_text;
    @FindBy(xpath="//div[@class='subitem-content']//div[contains(text(),'Legacy Users')]")
    private WebElementFacade legacyUsers;
    @FindBy(xpath="//div[@class='pt-scr-container legacy-users-listing']//div[contains(text(),'Legacy Users')]")
    private WebElementFacade legacyUsers_text;
    @FindBy(xpath = "//div[@class='subitem-content']/div[text()='Legal Entities']")
    private WebElementFacade legalEntities_tab;
    @FindBy(xpath = "//div[@class='subitem-content']/div[text()='Platform Users']")
    private WebElementFacade platform_users_tab;
    @FindBy(xpath = "//header//div[text()='Platform Users']")
    private WebElementFacade platform_users_title;
    public void clickParentOrganisations() {
        Assert.assertFalse(platformServices.isVisible());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void verifyParentOrganisations() {
        Serenity.reportThat("Parent Organisations page is visible and verified with Parent Organisations Text",
                () -> Assert.assertTrue(parentOrganisations_text.isVisible()));
    }
    public void clickLegacyOrganisations() {
        Assert.assertTrue(platformServices.isVisible());
        platformServices.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(legacyOrganisations.isVisible());
        legacyOrganisations.waitUntilClickable().click();
    }
    public void verifyLegacyOrganisations() {
        Serenity.reportThat("Legacy Organisations page is visible and verified with Legacy Organisations Text",
                () -> Assert.assertTrue(legacyOrganisations_text.isVisible()));
    }
    public void clickLegacyUsers() {
        Assert.assertTrue(platformServices.isVisible());
        platformServices.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(legacyUsers.isVisible());
        legacyUsers.waitUntilClickable().click();
    }
    public void verifyLegacyUsers() {
        Serenity.reportThat("Legacy Users page is visible and verified with Legacy Users Text",
                () -> Assert.assertTrue(legacyUsers_text.isVisible()));
    }
    public void clickPlatformUsers() {
        Assert.assertTrue(platformServices.isVisible());
        platformServices.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(platform_users_tab.isVisible());
        platform_users_tab.waitUntilClickable().click();
    }
    public void verifyPlatformUsers() {
        Serenity.reportThat("Legacy Users page is visible and verified with Legacy Users Text",
                () -> Assert.assertTrue(platform_users_title.isVisible()));
    }

}