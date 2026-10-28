package stepDefinations.PermissionsStep;

import PageObjects.UserManagement.UserManagementPageObject;
import io.cucumber.java.en.And;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;
@Slf4j
@Data
public class UserPermissionsStep extends PageObject{
    UserManagementPageObject userManagementPageObject;
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    @And("^User is able to search for User and update button is visible corresponding to the User$")
    public void userIsAbleToSearchForUserAndUpdateButtonIsVisible(List<String> users) {
        for (int user=1;user<users.size();user++){
            userManagementPageObject.getSearch_added_Users().waitUntilVisible();
            userManagementPageObject.getSearch_added_Users().clear();
            typeInto(userManagementPageObject.getSearch_added_Users(),users.get(user));
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            userManagementPageObject.getSearch_added_Users().waitUntilVisible();
            log.info(userManagementPageObject.getSearch_added_Users().getText().trim());
            if (users.get(user).equalsIgnoreCase(userManagementPageObject.getSearch_added_Users().getText().trim())){
                log.info("User found");
                Assert.assertTrue(userManagementPageObject.getUpdate_button().isVisible());
            }
            else {
                Assert.assertNotEquals(users.get(user),userManagementPageObject.getSearch_added_Users().getText().trim());
                log.error("Not able to search for the users");
//                    getDriver().quit();
                Assert.fail();
            }
        }

    }
    @And("^User is able to search for User and view button is visible corresponding to the User$")
    public void userIsAbleToSearchForUserAndViewButtonIsVisible(List<String> users) {
        for (int user=1;user<users.size();user++){
            userManagementPageObject.getSearch_added_Users().waitUntilVisible();
            userManagementPageObject.getSearch_added_Users().clear();
            typeInto(userManagementPageObject.getSearch_added_Users(),users.get(user));
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            userManagementPageObject.getSearch_added_Users().waitUntilVisible();
            log.info(userManagementPageObject.getSearch_added_Users().getText().trim());
            if (users.get(user).equalsIgnoreCase(userManagementPageObject.getSearch_added_Users().getText().trim())){
                log.info("User found");
                Assert.assertTrue(userManagementPageObject.getView_button().isVisible());
            }
            else {
                Assert.assertNotEquals(users.get(user),userManagementPageObject.getSearch_added_Users().getText().trim());
                log.error("Not able to search for the users");
//                    getDriver().quit();
                Assert.fail();
            }
        }

    }
}
