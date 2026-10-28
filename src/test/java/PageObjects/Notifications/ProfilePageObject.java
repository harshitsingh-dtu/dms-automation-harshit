package PageObjects.Notifications;


import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class ProfilePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//*[@class=\"user-details\"]")
    private WebElementFacade profilemenu;
    @FindBy(xpath = "//li[text()='View Profile']")
    private WebElementFacade viewprofile;
    @FindBy(xpath = "//*[@class=\"input\"][1]")
    private WebElementFacade firstname;
    @FindBy(xpath = "//*[@class=\"input\"][2]")
    private WebElementFacade lastname;
    @FindBy(xpath = "//*[@aria-label=\"Edit\"]")
    private WebElementFacade editicon;
    @FindBy(xpath = "//button[text()=\"Submit\"]")
    private WebElementFacade submitbutton;
    @FindBy(xpath = "//div[contains(text(),'User details have been updated.')]")
    private WebElementFacade notification_popup;
    @FindBy(xpath = "//div[@class='detail-pf pf-border']//child::h4")
    private WebElementFacade username;
    @FindBy(xpath = "//div[contains(text(),'No change found. ')]")
    private WebElementFacade notification_no_change;
    @FindBy(xpath = "//div[contains(text(),'FirstName/LastName should not exceed more than 30 characters.')]")
    private WebElementFacade notification_limit_exceed;


    public void openProfileDeatils(){
        profilemenu.waitUntilVisible().click();
        viewprofile.waitUntilVisible().click();
    }

    public void enterFirstLastName(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            firstname.waitUntilVisible();
            firstname.clear();
            act.pause(Duration.ofSeconds(2)).build().perform();
            typeInto(firstname, dataTable.get("First Name"));
            lastname.waitUntilVisible().clear();
            act.pause(Duration.ofSeconds(2)).build().perform();
            typeInto(lastname, dataTable.get("Last Name"));
        } catch (Exception e) {
            log.info("Unable to enter first name-->" + e);
            Assert.fail();
        }
    }
    public void validateNoChange() {
        String notificationNoChange = notification_no_change.getText();
        Assert.assertEquals("No change found.",notificationNoChange);
    }

    public void ClickSubmit(){
        submitbutton.click();
        act.pause(Duration.ofSeconds(2)).build().perform();
    }

    public void validateSuccessUpdate() {
        String notification = notification_popup.getText();
        String user = username.getText();
        Assert.assertEquals("User details have been updated.",notification);
        Assert.assertEquals("test User",user);
    }
    public void validateLimitExceed() {
        String notification_Limit_Exceed = notification_limit_exceed.getText();
        Assert.assertEquals("FirstName/LastName should not exceed more than 30 characters.",notification_Limit_Exceed);
    }


}
