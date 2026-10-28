package stepDefinations.GeneralFeatures;

import PageObjects.GeneralFeatures.HeaderSectionObject;
import PageObjects.GeneralFeatures.MultiUserLoginPageObject;
import PageObjects.Login.LoginPageObject;
import io.cucumber.java.en.And;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class MultiUserLogInStep extends PageObject {
    HeaderSectionObject HeaderSection;
    MultiUserLoginPageObject MultiUserLoginPageObject;
    LoginPageObject loginPageObject;

    @And("User logs in as PB - Citigroup")
    public void MultiUserLogin() {
        MultiUserLoginPageObject.AccountReLoginPopUp();
        MultiUserLoginPageObject.AccountLoginAsPB_OSTTRA();
    }
    @And("User closes the browser")
    public void close_the_browser() {
        MultiUserLoginPageObject.closeTheBrowser();
    }

}
