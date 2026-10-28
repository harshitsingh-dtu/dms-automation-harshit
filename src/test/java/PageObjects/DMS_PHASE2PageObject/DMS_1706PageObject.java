package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data

public class DMS_1706PageObject extends PageObject {

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationName_box;

    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade noOptions;

    @FindBy(xpath = "//button[text()='View']")
    private WebElementFacade view_button;

    @FindBy(xpath = "//p[text()='Showing all document templates']")
    private WebElementFacade documentTemplate_screen;

    @FindBy(xpath = "//button[text()='+ Create New Template']")
    private WebElementFacade createNewTemplate_btn;

    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profileIcon_approvalGroup;

    @FindBy(xpath = "//header[@class='pf-header']")
    private WebElementFacade organisationHeader_approvalGroup;

    @FindBy(xpath = "//input[@placeholder='Select LEIs']")
    private WebElementFacade selectLEIFilter_approvalGroup;

    @FindBy(xpath = "(//tbody//tr//td)[1]")
    private WebElementFacade selectFirstApprovalGroup_approvalGroupScreen;

    @FindBy(xpath = "//input[@placeholder='Search by group name']")
    private WebElementFacade searchApprovalGroup_approvalGroupScreen;

    @FindBy(xpath = "//input[@placeholder='Search by organisation name']")
    private WebElementFacade searchApprovalMatrix_approvalMatrixScreen;

    @FindBy(xpath = "//button[text()='Update']")
    private WebElementFacade updateButton_approvalGroupScreen;

    @FindBy(xpath = "//input[@placeholder='Search by template name']")
    private WebElementFacade searchDocumentTemplate_documentTemplateScreen;

    public void user_fills_the_organization_name(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            organizationName_box.waitUntilClickable();
            withAction().moveToElement(organizationName_box).click().sendKeys(dataTable.get("Organization name")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to fill in the organisation name -->"+e);
            Assert.fail();
        }
    }
    public void searchRandomFirst_approvalGroup(){
        try{
            profileIcon_approvalGroup.waitUntilVisible();
            withAction().moveToElement(profileIcon_approvalGroup).click().build().perform();
            String OrganisationHeader_approvalGroup = organisationHeader_approvalGroup.getText().trim();
            withAction().moveToElement(selectLEIFilter_approvalGroup).click().sendKeys(OrganisationHeader_approvalGroup).pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String FirstApprovalGroup= selectFirstApprovalGroup_approvalGroupScreen.getText().trim();
            withAction().moveToElement(searchApprovalGroup_approvalGroupScreen).click().sendKeys(FirstApprovalGroup).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(updateButton_approvalGroupScreen).click().build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search approval group " +e);
            Assert.fail();
        }
    }
    public void searchRandom_approvalGroup(){
      try {
          Random random = new Random();
          int randomNumber = Math.abs(random.nextInt(10));
          log.info("randomNumber" + randomNumber);
          withAction().pause(Duration.ofSeconds(3)).build().perform();
          withAction().moveToElement(selectLEIFilter_approvalGroup).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
          withAction().moveToElement(selectLEIFilter_approvalGroup).click().build().perform();
          for (int i = 1; i < randomNumber; i++) {
              withAction().pause(Duration.ofSeconds(1)).build().perform();
              withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
          }
          withAction().sendKeys(Keys.RETURN).build().perform();
          withAction().pause(Duration.ofSeconds(3)).build().perform();
          String FirstApprovalGroup= selectFirstApprovalGroup_approvalGroupScreen.getText().trim();
          withAction().moveToElement(searchApprovalGroup_approvalGroupScreen).click().sendKeys(FirstApprovalGroup).build().perform();
          withAction().pause(Duration.ofSeconds(2)).build().perform();
          withAction().moveToElement(updateButton_approvalGroupScreen).click().build().perform();
          withAction().pause(Duration.ofSeconds(4)).build().perform();
      }
      catch (Exception e){
        log.error(" Unable to search approval group again " +e);
        Assert.fail();
    }
    }
    public void searchRandomFirst_approvalMatrix(){
        try{
            profileIcon_approvalGroup.waitUntilVisible();
            withAction().moveToElement(profileIcon_approvalGroup).click().build().perform();
            String OrganisationHeader_approvalGroup = organisationHeader_approvalGroup.getText().trim();
            withAction().moveToElement(selectLEIFilter_approvalGroup).click().sendKeys(OrganisationHeader_approvalGroup).pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String FirstApprovalMatrix= selectFirstApprovalGroup_approvalGroupScreen.getText().trim();
            withAction().moveToElement(searchApprovalMatrix_approvalMatrixScreen).click().sendKeys(FirstApprovalMatrix).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(updateButton_approvalGroupScreen).click().build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search approval matrix " +e);
            Assert.fail();
        }
    }
    public void searchRandom_approvalMatrix(){
        try {
            Random random = new Random();
            int randomNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randomNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(selectLEIFilter_approvalGroup).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
            withAction().moveToElement(selectLEIFilter_approvalGroup).click().build().perform();
            for (int i = 1; i < randomNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            String FirstApprovalMatrix= selectFirstApprovalGroup_approvalGroupScreen.getText().trim();
            withAction().moveToElement(searchApprovalMatrix_approvalMatrixScreen).click().sendKeys(FirstApprovalMatrix).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(updateButton_approvalGroupScreen).click().build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error(" Unable to search approval group again " +e);
            Assert.fail();
        }
    }
    public void searchRandom_documentTemplate(){
        try{
            String FirstDocumentTemplate= selectFirstApprovalGroup_approvalGroupScreen.getText().trim();
            withAction().moveToElement(searchDocumentTemplate_documentTemplateScreen).click().pause(Duration.ofSeconds(1)).sendKeys(FirstDocumentTemplate).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(updateButton_approvalGroupScreen).click().build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search document template " +e);
            Assert.fail();
        }
    }
}
