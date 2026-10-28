package PageObjects.Funds;

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
public class FundsPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//button[text()='+ Add Fund']")
    private List<WebElementFacade> AddFunds_Size;
    @FindBy(xpath = "(//button[text()='+ Add Fund'])[1]")
    private WebElementFacade AddFunds;
    @FindBy(xpath = "//div[text()='Client' and text()=' - ' and text() = '2']//button[text() = '+ Add Fund']")
    private WebElementFacade AddFundsClient2;
    @FindBy(xpath = "(//button[text() = 'Edit']")
    private WebElementFacade EditFunds;
    @FindBy(xpath = "//*[@class ='fund-name-header']//input")
    private WebElementFacade SearchFundBar;
    @FindBy(xpath = "//header[text()='Funds']")
    private WebElementFacade FundHeader;
    @FindBy(xpath = "//input[@placeholder='Search by id or name']")
    private WebElementFacade searchAddedFundList;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade cancelButton;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElementFacade saveButton;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade Validate_AddButton;
    @FindBy(xpath = "//div[text()='Funds updated successfully']")
    private WebElementFacade FundsSuccessMessage;
    @FindBy(xpath = "//div[text()='Add']")
    private WebElementFacade AddButton;


    public void addFunds(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", SearchFundBar);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        SearchFundBar.clear();
        SearchFundBar.type(dataTable.get("Funds"));
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        find(By.xpath("(//div[contains(text(),'"+dataTable.get("Funds")+"')])[1]")).click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        withAction().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
      }
    }
    public void removeFunds(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        find(By.xpath("//header[text()='"+dataTable.get("Funds")+"']//..//following-sibling::button")).click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", SearchFundBar);
    }
    public boolean validatedAddedFunds(DataTable table){
        boolean visible = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        if(dataTable.get("Funds").equalsIgnoreCase("LEI Name"))
        {
            visible= find(By.xpath("//div[@class = 'fund-item' and contains(., '"+dataTable.get("Value")+"')]")).isVisible();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
//           visible= find(By.xpath("//header[contains(text(),'"+dataTable.get("Value")+"')]")).isVisible();
//           withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        else{
            visible= find(By.xpath("//div[contains(text(),'"+dataTable.get("Value")+"')]")).isVisible();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        return visible;
    }

    public void AddingNewFunds(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        withAction().moveToElement(SearchFundBar).click().sendKeys("Dummy_LEI").pause(Duration.ofSeconds(2)).build().perform();
        Validate_AddButton.waitUntilVisible();
    }
    public void addLongFundName(int length) {
        String longFundName = new String(new char[length]).replace('\0', 'A');
        SearchFundBar.waitUntilVisible();
        // Use JS click to avoid interception by placeholders
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", SearchFundBar);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        
        SearchFundBar.clear();
        SearchFundBar.type(longFundName);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        
        String actualValue = SearchFundBar.getValue();
        if (actualValue == null) actualValue = SearchFundBar.getAttribute("value");
        
        if (actualValue != null && actualValue.length() == length) {
            log.info("Success: Input box holds " + length + " characters.");
        } else {
            int actualLength = (actualValue == null) ? 0 : actualValue.length();
            log.error("Length mismatch! Expected: " + length + ", but found: " + actualLength);
            throw new AssertionError("Expected " + length + " chars, but found " + actualLength);
        }
    }

    public void removeAllFunds() {
        List<WebElementFacade> removeButtons = findAll(By.xpath("//button[@class='cross-btn']"));
        for (WebElementFacade removeButton : removeButtons) {
            removeButton.click();
        }
    }

    public void clickAddButton() {
        try {
            Validate_AddButton.waitUntilPresent().waitUntilClickable();
            // Use JS click to avoid interception
            ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", Validate_AddButton);
            log.info("Add button clicked successfully using JS.");
        } catch (Exception e) {
            log.error("Failed to click Add button: " + e.getMessage());
            Assert.fail("Add button click failed.");
        }
    }


}
