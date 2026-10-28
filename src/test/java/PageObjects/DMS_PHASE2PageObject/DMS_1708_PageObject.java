package PageObjects.DMS_PHASE2PageObject;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
public class DMS_1708_PageObject extends PageObject
{
    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade toast_msg;
    @FindBy(xpath = "//div[@class='select-container']//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctype;
    @FindBy(xpath = "//tr/td[text()='DN']")
    private WebElementFacade Assigned_LEI_with_DN;
    @FindBy(xpath = "//tr/td[text()='4 Way']")
    private WebElementFacade Assigned_LEI_with_4W;
    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRoles;
    @FindBy(xpath = "//ul[@role='listbox']")
    private WebElementFacade Doc_types_list;
    public void select_doc_type_while_assigning_LEI(List<String> document_type)
    {
        doctype.waitUntilClickable();
        withAction().moveToElement(doctype).click().sendKeys(document_type.get(1)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }


}
