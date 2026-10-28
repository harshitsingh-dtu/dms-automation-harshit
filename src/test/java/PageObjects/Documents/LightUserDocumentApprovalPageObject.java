package PageObjects.Documents;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;
@Slf4j
@Data
public class LightUserDocumentApprovalPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//*[text()='Select Prime Broker - 1']")
    private WebElementFacade selectPB1;
    public WebElementFacade SelectPB1() {  return selectPB1; }
    public void clickParties(){}
}