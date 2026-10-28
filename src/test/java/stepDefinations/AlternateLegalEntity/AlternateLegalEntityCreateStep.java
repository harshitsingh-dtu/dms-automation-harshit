package stepDefinations.AlternateLegalEntity;

import PageObjects.AlternateLegalEntity.AlternateLegalEntityPageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.time.Duration;
import java.util.List;

@Slf4j
public class AlternateLegalEntityCreateStep extends PageObject {
    DocumentPageObject documentPageObject;
    AlternateLegalEntityPageObject AlternateLegalEntityPageObject;

    @Given("^User is on Alternate Legal Entity names Screen$")
    public void user_Alternate_Legal_Entity_names_screen(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        documentPageObject.clickMenuButton();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        AlternateLegalEntityPageObject.getOrganization_btn().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        AlternateLegalEntityPageObject.getAlternateLegalEntityBtn().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Given("^Validate User is on Alternate Legal Entity names Screen$")
    public void user_Validates_Alternate_Legal_Entity_names_screen(){
        Assert.assertTrue(AlternateLegalEntityPageObject.getAlternateLegalEntityScreen().isDisplayed());
    }
    @Given("^User validates data$")
    public void user_Validates_LEI_IDs(DataTable table){
        AlternateLegalEntityPageObject.validateData(table);
    }
    @Given("^User validates user is on Organisation information screen$")
    public void user_Validates_Organisation_Information_screen(){
        Assert.assertTrue(AlternateLegalEntityPageObject.getOrganisationInformation().isDisplayed());
    }
    @Then("^User clicks on versions button$")
    public void Click_On_Version_Button(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(AlternateLegalEntityPageObject.getVersionButton().isDisplayed());
        AlternateLegalEntityPageObject.getVersionButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("^User clicks on versions button Full LEI$")
    public void Click_On_Version_Button_Full_LEI(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(AlternateLegalEntityPageObject.getVersionButtonFullLEI().isDisplayed());
        AlternateLegalEntityPageObject.getVersionButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @Then("^User click on Add new button$")
    public void Click_On_AddNew_Button(){
        Assert.assertTrue(AlternateLegalEntityPageObject.getAddNewButton().isDisplayed());
        AlternateLegalEntityPageObject.getAddNewButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("^User enters new Alternate name and Comments$")
    public void user_Enters_New_AlternateName(DataTable table){
        AlternateLegalEntityPageObject.newAlternateDetails(table);
    }
    @Then("^User validates the history record values$")
    public void validate_values(DataTable table){
        AlternateLegalEntityPageObject.validateValuesInHistory(table);
    }
    @Then("^User validates the LEI has name has been updated$")
    public void validate_Updated_LEIName_InDocument(DataTable table){
        AlternateLegalEntityPageObject.validate_Updated_LEIName_InDocument(table);
    }
    @And("^User validates the updated name is coming in Dropdown$")
    public void update_button_is_visible_to_the_user(List<String> LEIName) {
        Assert.assertTrue(getDriver().findElement(By.xpath("//input[@value='"+LEIName.get(0)+"']")).isDisplayed());
    }
    @And("^User validates the updated name is coming for USP Rider$")
    public void validateOrgNameUSPRider(List<String> LEIName) {
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[text()='"+LEIName.get(0)+"']")).isDisplayed());
    }
    @And("^User validates the updated name is coming on DashboardFilters$")
    public void validateOrgNameonDashboard(List<String> LEIName) {
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[text()='"+LEIName.get(0)+"']")).isDisplayed());
    }

}