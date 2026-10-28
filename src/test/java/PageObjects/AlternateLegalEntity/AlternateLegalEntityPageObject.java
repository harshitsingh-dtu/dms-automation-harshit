package PageObjects.AlternateLegalEntity;

import PageObjects.ApprovalAgreement.ApprovalAgreementCreatePageObject;
import Utilities.ConfigFileReader;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class AlternateLegalEntityPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    ConfigFileReader configFileReader=new ConfigFileReader();

    @FindBy(xpath = "//div[@class='preview-container audit']//tbody//td[5]")
    List<WebElementFacade> AgreementDateInAudit;
    @FindBy(xpath = "//div[normalize-space()='Organisations']")
    private WebElementFacade organization_btn;
    @FindBy(xpath = "//div[normalize-space()='Alternate legal entity names']")
    private WebElementFacade AlternateLegalEntityBtn;
    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'legal entities']")
    private WebElementFacade AlternateLegalEntityScreen;
    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'organisation information']")
    private WebElementFacade OrganisationInformation;
    @FindBy(xpath = "(//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'versions'])[1]")
    private WebElementFacade VersionButton;
    @FindBy(xpath = "(//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'versions'])[1]")
    private WebElementFacade VersionButtonFullLEI;
    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'add new']")
    private WebElementFacade AddNewButton;
    @FindBy(xpath = "//input[@placeholder='Enter New Alternate name']")
    private WebElementFacade newAlternateName;
    @FindBy(xpath = "//input[@placeholder='Enter Comment']")
    private WebElementFacade enterComment;


    public void validateData(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> DataTable : data)
        {
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[text()='"+DataTable.get("Data")+"']")).isDisplayed());
        }
    }
    public void newAlternateDetails(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> DataTable : data)
        {
           newAlternateName.waitUntilPresent().waitUntilVisible();
           getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",newAlternateName);
           withAction().pause(Duration.ofSeconds(2)).build().perform();
           withAction().moveToElement(newAlternateName).click().sendKeys(DataTable.get("New Alternate Name")).build().perform();
           withAction().pause(Duration.ofSeconds(1)).build().perform();

           enterComment.waitUntilPresent().waitUntilVisible();
           getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",enterComment);
           withAction().pause(Duration.ofSeconds(2)).build().perform();
           withAction().moveToElement(enterComment).click().pause(Duration.ofSeconds(2)).build().perform();
           withAction().sendKeys(DataTable.get("Comments")).pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    public void validateValuesInHistory(DataTable table)
    {
        Calendar cal= Calendar.getInstance();
        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        // Use the format() method to convert the Calendar date to a string
        String currentExpectedDate = dateFormat.format(cal.getTime());
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> DataTable : data)
        {
            String alternateNameRow = "(//td[text()='"+DataTable.get("Alternate Legal entity Name")+"'])[1]";
            WebElement alternateLEIName = getDriver().findElement(By.xpath(alternateNameRow));
            Assert.assertTrue(alternateLEIName.isDisplayed());
            WebElement updatedBy = getDriver().findElement(By.xpath(alternateNameRow+"/following-sibling::td[1]"));
            Assert.assertEquals(DataTable.get("Updated By"),updatedBy.getText());
            WebElement currentActualDateLocalTime = getDriver().findElement(By.xpath(alternateNameRow+"/following-sibling::td[2]"));
            String[] DateAndTimeLocal = currentActualDateLocalTime.getText().split(",");
            Assert.assertEquals(currentExpectedDate,DateAndTimeLocal[0]);
            WebElement currentActualDateUTCTime = getDriver().findElement(By.xpath(alternateNameRow+"/following-sibling::td[3]"));
            String[] DateAndTimeUTC = currentActualDateUTCTime.getText().split(",");
            Assert.assertEquals(currentExpectedDate,DateAndTimeUTC[0]);

        }
    }

    public void validate_Updated_LEIName_InDocument(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String,String> DataTable : data)
        {
            Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='select-menu-container']//div[text()='"+DataTable.get("Updated LEI Name")+"']")).isDisplayed());
        }
    }

}