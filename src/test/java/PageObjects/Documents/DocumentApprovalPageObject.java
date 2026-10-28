package PageObjects.Documents;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
@Slf4j
@Data
public class DocumentApprovalPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//button[text()=\"Submit\"]")
    private WebElementFacade submit_btn;
    public void clickSubmit_btn() {
        try{
            submit_btn.isVisible();
            submit_btn.click();
        }catch (Exception e){
            log.error("Unable to click submit button-->"+e);
            Assert.fail();
        }
    }

}
