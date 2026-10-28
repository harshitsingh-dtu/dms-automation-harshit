package stepDefinations.Funds;

import PageObjects.Funds.FundsPageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
public class Funds extends PageObject {
    DocumentPageObject documentPageObject;
    FundsPageObject Funds;

    @Then("^User validates the Add Funds Options for 4way$")
    public void ValidateAddFundsOptions4way() {
        Assert.assertEquals(Funds.getAddFunds_Size().size(),2);
    }
    @Then("^User clicks on Add fund button for client1$")
    public void ValidateAddFundsOptionsforClient1() {
        Assert.assertTrue(Funds.getAddFunds().isVisible());
        Funds.getAddFunds().click();
    }
    @Then("^User clicks on Add fund button for client2$")
    public void ValidateAddFundsOptionsforClient2() {
        Assert.assertTrue(Funds.getAddFundsClient2().isVisible());
        Funds.getAddFundsClient2().click();
    }
    @Then("^User validates the Add Funds Options for DN$")
    public void ValidateAddFundsOptions_DN() {
        Assert.assertTrue(Funds.getAddFunds().isVisible());
    }

    @Then("^User clicks on Add fund button DN$")
    public void click_AddFunds() {
        Funds.getAddFunds().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(Funds.getSearchFundBar().isVisible());
    }

    @Then("^User clicks on Add fund button$")
    public void click_AddFundsClient() {
        Funds.getAddFundsClient2().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(Funds.getSearchFundBar().isVisible());
    }
    @Then("^Validate the elements on Funds Page$")
    public void validate_AddFundsElements() {
        Assert.assertTrue(Funds.getFundHeader().isVisible());
        Assert.assertTrue(Funds.getSearchFundBar().isVisible());
        Assert.assertTrue(Funds.getSearchAddedFundList().isVisible());
        Assert.assertTrue(Funds.getCancelButton().isVisible());
        Assert.assertTrue(Funds.getSaveButton().isVisible());
    }
    @Then("^User add the funds$")
    public void click_AddFunds(DataTable table) {
        Funds.addFunds(table);
    }
    @Then("^User remove the funds$")
    public void click_removeFunds(DataTable table) {
        Funds.removeFunds(table);
    }

    @Then("^User validates the added funds$")
    public void validate_AddedFunds(DataTable table) {
       Assert.assertTrue(Funds.validatedAddedFunds(table));
    }
    @Then("^Verify Add button visible while adding new Funds in Search box$")
    public void verify_AddingNewFunds() {
        Funds.AddingNewFunds();

    }
    @Then("^User clicks on Save button$")
    public void clickOnSaveButton() {
        Assert.assertTrue(Funds.getSaveButton().isVisible());
        Funds.getSaveButton().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @Then("^Validates the Funds added successfully message$")
    public void fundsAddedSuccessfullyMessage() {
        Assert.assertTrue(Funds.getFundsSuccessMessage().isVisible());
    }

    @And("User adds a fund with 100 characters to validate input capacity")
    public void fund_length_check () {
        Funds.addLongFundName(100);
    }
    @And("User clicks on Add Button")
    public void clicks_Add_button() {
        Funds.clickAddButton();
    }

    @And("User removes all funds from client1")
    public void user_removes_all_funds_from_client1() {
        Funds.removeAllFunds();
    }
}