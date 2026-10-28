package PageObjects.PermissionsPageObject;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import io.cucumber.java.bs.A;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
import java.util.List;
@Data
@Slf4j
public class ApprovalGroupPermissionsPageObject extends PageObject {
    @FindBy(xpath = "//div[@class='profile-menus']//header")
    private WebElementFacade User_organisation;
}
