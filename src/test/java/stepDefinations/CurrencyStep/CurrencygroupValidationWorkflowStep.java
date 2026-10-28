package stepDefinations.CurrencyStep;

import PageObjects.Currency.CurrencygroupCreateNewPageObject;
import PageObjects.Currency.CurrencygroupPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CurrencygroupValidationWorkflowStep extends PageObject {
    CurrencygroupCreateNewPageObject currencygroupCreateNewPageObject;
    CurrencygroupPageObject currencygroupPageObject;
//    @Before("@CurrencyValidationWorkflow")
//public void beforeHookValidationWorkflow() throws InterruptedException {
//    currencygroupPageObject.navigateToCurrencyscreen();
//}

    @Given("User is on the Currency screen")
    public void user_is_on_the_currency_screen(){
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        currencygroupPageObject.navigateToCurrencyscreen();
        currencygroupPageObject.checkifonCurrencygrpscreen();
    }

    @And("User searches for the currency group and delete if present")
    public void user_searches_for_the_currency_group_and_delete_if_present(List<String> currency_group) {
        currencygroupPageObject.searchAndDeleteCurrencyGroup(currency_group);
    }

    @Then("User can reach to Currency group screen")
    public void user_can_reach_to_currency_group_screen(){
        currencygroupPageObject.checkifonCurrencygrpscreen();
    }

    @And("User can reach to Currency Pair group screen")
    public void user_can_reach_to_currencypair_group_screen(){
        currencygroupPageObject.navigatetoCurrencyPairgroupscreen();
    }

    @When("^User creates and updates the following currency groups$")
    public void user_creates_and_updates_currency_groups(DataTable dataTable) {
        currencygroupPageObject.createAndUpdateCurrencyGroups(dataTable);
    }

    @When("^User creates and updates the following currency pair groups$")
    public void user_creates_and_updates_currency_pair_groups(DataTable dataTable) {
        currencygroupPageObject.createAndUpdateCurrencyPairGroups(dataTable);
    }

    @Then("Create new group button is visible to the User")
    public void create_new_group_button_is_visible_to_the_user(){
        currencygroupPageObject.checkifCreatenewbtn();
    }

    @And("Organization filter is visible to the User")
    public void organization_filter_is_visible_to_the_user(){
        currencygroupPageObject.checkiforganizationfilter();
    }

    @Then("^Verify the user can view currency records for all organizations$")
    public void verify_the_user_can_view_currency_records_for_all_organizations(DataTable orgTable) {
        currencygroupPageObject.verifyCurrencyCrossOrgVisibility(orgTable);
    }

//    @When("^User switches to the Currencies-Pair Group tab$")
//    public void user_switches_to_currencies_pair_group_tab() {
//        currencygroupPageObject.switchToCurrenciesPairGroupTab();
//    }

    @And("Search bar is visible to the User")
    public void search_bar_is_visible_to_the_user() {
        currencygroupPageObject.checkifSearchBar();
    }

    @And("Currencies pair groups Search bar is visible to the User")
    public void Currencies_pair_group_ssearch_bar_is_visible_to_the_user() {
        currencygroupPageObject.checkifCurrencies_pair_group_SearchBar();
    }

    @And("Columns Currency group name, Organizations, Created On, Action is visible to the User")
    public void columns_currency_group_name_organizations_created_on_action_is_visible_to_the_user(){
        currencygroupPageObject.checkifcolumns();
    }

    @And("Delete button is visible to the User")
    public void delete_button_is_visible_to_the_user() {
        currencygroupPageObject.checkifdeletebtn();
    }
    @And("^Update button is visible to the user$")
    public void update_button_is_visible_to_the_user() {
        Assert.assertTrue(currencygroupPageObject.getUpdate_btn().isVisible());
    }

}
