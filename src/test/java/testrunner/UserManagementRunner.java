package testrunner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.core.pages.PageObject;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(features = "src/test/resources/features/",
//        plugin = "pretty",
//        tags = "@cookiesCode or ",
        plugin = {
                "pretty",
                "rerun:target/rerun.txt"
        },
        tags = "@Regression and not @ignored",
        glue = "stepDefinations")
public class UserManagementRunner extends PageObject {
}
