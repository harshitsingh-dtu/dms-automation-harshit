package stepDefinations.CurrencyStep;

import PageObjects.Currency.CurrencygroupPageObject;
import PageObjects.Currency.CurrencygroupUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class CurrencygroupUpdateWorkflowStep extends PageObject {
    CurrencygroupPageObject currencygroupPageObject;
    CurrencygroupUpdatePageObject currencygroupUpdatePageObject;
    @When("User searches for the currency group")
    public void user_searches_for_the_currency_group(List<String> currency_group) {
        currencygroupPageObject.searchCurrencygroup(currency_group);
    }

    @Then("User will search all currency")
    public void userWillSearchAllCurrency() {
        currencygroupPageObject.Selectallcurrency();
    }

    @Then("User is able to delete the existing currency group")
    public void User_is_able_to_delete_the_existing_currency_group(){
        currencygroupPageObject.mapCurrencygroup();
    }

    @Then("User is able to delete the existing currency pair group")
    public void User_is_able_to_delete_the_existing_currency_pair_group(){
        currencygroupPageObject.mapCurrencypairgroup();
    }

    @Then("User will search for the currency and select them")
    public void user_will_search_for_the_currency_and_select_them(List<String> selectcurrencyList){
        currencygroupUpdatePageObject.search_for_the_currency_and_select_them(selectcurrencyList);
    }

    @Then("User will search for the currency and select them for DF AuthScreen")
    public void user_will_search_for_the_currency_and_select_them_for_DF_AuthScreen(List<String> selectcurrencyList){
        currencygroupUpdatePageObject.updated_search_for_the_currency_and_select_them_for_DF_AuthScope(selectcurrencyList);
    }

    @Then("User will search for the Non Deliverable currency and select them")
    public void user_will_search_for_the_Non_Deliverable_currency_and_select_them(List<String> selectcurrencyList) {
        currencygroupUpdatePageObject.search_for_the_NonDeliverablecurrency_and_select_them(selectcurrencyList);
    }

    @Then("User will search for the Non Deliverable currency and select them on Auth Scope")
    public void user_will_search_for_the_Non_Deliverable_currency_and_select_them_on_Auth_Scope(List<String> selectcurrencyList) {
        currencygroupUpdatePageObject.search_for_the_NonDeliverablecurrency(selectcurrencyList);
    }

    @Then("User will search for the currency deselect and select them")
    public void user_will_search_for_the_currency_deselect_and_select_them(List<String> selectcurrencyList){
        currencygroupUpdatePageObject.search_for_the_currency_and_select_them(selectcurrencyList);
    }

    @Then("User selects the Bullion checkbox")
    public void user_select_bullion_checkbox(){
        currencygroupUpdatePageObject.getBullionCheckbox().waitUntilVisible().click();
    }

    @And("User will search for the currency and select them for the updated screen")
    public void user_will_search_for_the_currency_and_select_them_for_the_updated_screen(List<String> updated_currencyList){
        currencygroupUpdatePageObject.updated_search_for_the_currency_and_select_them(updated_currencyList);
    }

    @And("User will search for the currency pair and select them for the updated screen")
    public void user_will_search_for_the_currency_pair_and_select_them_for_the_updated_screen(List<String> updatedcurrencyList){
        currencygroupUpdatePageObject.update_search_for_the_currency_pair_and_select_them(updatedcurrencyList);
    }

    @And("User clicks on the update button for Currency")
    public void user_reaches_the_update_screen(){
        currencygroupPageObject.navigateToCurrencygroupUpdatescreen();
    }

    @And("User will remove the currency after searching them")
    public void user_will_remove_the_currency_after_searching_them(List<String> remove_currencyList){
        currencygroupUpdatePageObject.remove_the_currency_after_searching_them(remove_currencyList);
    }

    @And("User will submit the changes")
    public void user_will_submit_the_changes(){
        currencygroupUpdatePageObject.submitChanges();
    }
    @Then("User will change the currency group name")
    public void user_will_change_the_currency_group_name(DataTable table){
        currencygroupUpdatePageObject.change_the_currency_group_name(table);
    }

    @And("User will change the organization")
    public void user_will_change_the_organization(DataTable table) {
        currencygroupUpdatePageObject.change_the_organization(table);
    }
    @Given("User is one the currency group update screen")
    public void user_is_one_the_currency_group_update_screen(List<String> currency_group) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        currencygroupPageObject.navigateToCurrencyscreen();
        currencygroupPageObject.searchCurrencygroup(currency_group);
        currencygroupPageObject.navigateToCurrencygroupUpdatescreen();
    }

    @Given("User is on the currency Pair group update screen")
    public void user_is_on_the_currency_pair_group_update_screen(List<String> name){
        currencygroupPageObject.navigateToCurrencyscreen();
        currencygroupPageObject.navigatetoCurrencyPairgroupscreen();
        currencygroupPageObject.searchCurrencyPairgroup(name);
        currencygroupPageObject.navigateToCurrencygroupUpdatescreen();
    }
    @Then("Verify if the user is able to search for currencies using the predictive search")
    public void verify_if_the_user_is_able_to_search_for_currencies_using_the_predictive_search(List<String> currency){
        currencygroupUpdatePageObject.checkifsearchcurrency(currency);
    }

    @Then("user is able to search for currency pairs using predictive search bar")
    public void user_is_able_to_search_for_currency_pairs_using_predictive_search_bar(List<String> currency){
        currencygroupUpdatePageObject.checkifsearchcurrencyPair(currency);
    }

    @And("User is able to select currency in the currencies tab")
    public void user_is_able_to_select_currency_in_the_currencies_tab(List<String> selectcurrencyList){
        currencygroupUpdatePageObject.updated_search_for_the_currency_and_select_them(selectcurrencyList);
    }

    @And("User is able to deselect currencies")
    public void user_is_able_to_deselect_currencies(List<String> remove_currencyList){
        currencygroupUpdatePageObject.remove_the_currency_after_searching_them(remove_currencyList);
    }

    @And("Verify if the User is able to deselect all the currencies at the same time using 'Remove All'")
    public void verify_if_the_user_is_able_to_deselect_all_the_currencies_at_the_same_time_using_remove_all() {
        currencygroupUpdatePageObject.removeallcurrency();
    }

    @And("User is able to save the changes")
    public void user_is_able_to_save_the_changes(){
        currencygroupUpdatePageObject.submitChanges();
    }

    @And("User is able to select currency in the currency Pair tab")
    public void user_is_able_to_select_currency_in_the_currency_pair_tab(List<String> selectcurrencyList) {
        currencygroupUpdatePageObject.search_for_the_currency_pair_and_select_them(selectcurrencyList);
    }

    @And("User is able to deselect currency Pair")
    public void user_is_able_to_deselect_currency_pair(List<String> removecurrencyList) {
        currencygroupUpdatePageObject.remove_the_currency_pair_after_searching_them(removecurrencyList);
    }

    @And("User is able to deselect all the currency pair at the same time using 'Remove All'")
    public void user_is_able_to_deselect_all_the_currency_pair_at_the_same_time_using_remove_all(){
        currencygroupUpdatePageObject.removeallcurrency();
    }

    @Given("User is on the Currency pair screen")
    public void user_is_on_the_currency_pair_screen(){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        currencygroupPageObject.navigateToCurrencyscreen();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        currencygroupPageObject.navigatetoCurrencyPairgroupscreenAlone();
    }

    @Given("User is on the Currency pair screen Alone")
    public void user_is_on_the_currency_pair_screen_alone(){
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        currencygroupPageObject.navigateToCurrencyscreenAgain();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        currencygroupPageObject.navigatetoCurrencyPairgroupscreenAlone();
    }

    @When("User searches for the currency pair group")
    public void user_searches_for_the_currency_pair_group(List<String> name){
        currencygroupPageObject.searchCurrencyPairgroup(name);

    }

    @Then("User will search for the currency pair and select them")
    public void user_will_search_for_the_currency_pair_and_select_them(List<String> selectcurrencyList){
        currencygroupUpdatePageObject.search_for_the_currency_pair_and_select_them(selectcurrencyList);
    }

    @Then("User will search for the currency pair and select them on Currency Pair Screen")
    public void user_will_search_for_the_currency_pair_and_select_them_CPScreen(List<String> selectcurrencyList){
        currencygroupUpdatePageObject.search_for_the_currency_pair_and_select_themSecond(selectcurrencyList);
    }


    @And("User will remove the currency pair after searching them")
    public void user_will_remove_the_currency_pair_after_searching_them(List<String> removecurrencyList){
        currencygroupUpdatePageObject.remove_the_currency_pair_after_searching_them(removecurrencyList);
    }

    @Then("User validates the Deliverable, Non-Deliverable are displayed")
    public void validate_Deliverable_NonDeliverable(){
        Assert.assertEquals(currencygroupUpdatePageObject.getDeliverableField().size(),1);
        Assert.assertEquals(currencygroupUpdatePageObject.getNonDeliverableField().size(),1);
    }
    @Then("User selects the currency group in AuthScope")
    public void searchesCurrencyGroup(List<String> currencyGroup){
        Assert.assertTrue(currencygroupUpdatePageObject.searchForCurrency(currencyGroup));

    }
    @Then("User clicks on the currency group pair tab in AuthScope")
    public void selectCurrencyGroupPairtab(){
        currencygroupUpdatePageObject.getCurrencyGroupPairTab().waitUntilVisible();
        currencygroupUpdatePageObject.getCurrencyGroupPairTab().click();
    }
    @Then("User selects the currency group pair in AuthScope")
    public void searchesCurrencyPairGroup(List<String> currencyGroup){
        Assert.assertTrue(currencygroupUpdatePageObject.searchForCurrencyPair(currencyGroup));
    }

    @And("User selects and validates currencies are deliverable in pop-up")
    public void user_selects_and_validates_currencies_are_deliverable(List<String> currencies) {
        currencygroupUpdatePageObject.selectAndValidateDeliverableCurrencies(currencies);
    }

    @And("User selects and validates deliverable currencies via Advanced Filter")
    public void user_selects_and_validates_deliverable_currencies_via_advanced_filter(List<String> currencies) {
        currencygroupUpdatePageObject.selectAndValidateAdvanceFilterCurrencies(currencies);
    }

    @And("User selects and validates currencies are present in pop-up")
    public void user_selects_and_validates_currencies_are_present(List<String> currencies) {
        currencygroupUpdatePageObject.selectAndValidateCurrencies(currencies);
    }
    @And("User selects and validates both currencies via Advanced Filter")
    public void user_selects_and_validates_both_currencies_via_advanced_filter(List<String> currencies) {
        currencygroupUpdatePageObject.selectAndValidateBothCurrenciesForAdvanceFilters(currencies);
    }
    @And("User validates the currency group name is displayed on Auth line")
    public void user_validates_currencygroupname_displayed(List<String> currencyGroupName) {
        currencygroupUpdatePageObject.validateCurrencyGroupNameDisplayed(currencyGroupName);
    }
    @Then("User edits the currencies for the auth line")
    public void user_edits_the_currencies_for_the_auth_line(DataTable dataTable) {
        currencygroupUpdatePageObject.editCurrenciesForAuthLine(dataTable);
    }
    @When("^User will click on 'Select All' Checkbox for currency selection$")
    public void user_will_click_on_select_all_checkbox_for_currency_selection() {
        currencygroupUpdatePageObject.clickSelectAllCheckbox();
    }
    @When("^User clears the currency search bar$")
    public void user_clear_currency_searchbar() {
        net.serenitybdd.core.pages.WebElementFacade searchInput = currencygroupUpdatePageObject.getSearchSelectCurrency();
        searchInput.waitUntilVisible();
        searchInput.click();
        searchInput.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"), org.openqa.selenium.Keys.BACK_SPACE);
        try {
            getJavascriptExecutorFacade().executeScript(
                "var input = arguments[0];" +
                "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(HTMLInputElement.prototype, 'value').set;" +
                "if (nativeInputValueSetter) { nativeInputValueSetter.call(input, ''); }" +
                "var ev = new Event('input', { bubbles: true });" +
                "input.dispatchEvent(ev);" +
                "var changeEv = new Event('change', { bubbles: true });" +
                "input.dispatchEvent(changeEv);",
                searchInput
            );
        } catch (Exception e) {
            // Fallback
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @When("^User will click on All currency permitted checkbox$")
    public void user_will_click_on_all_currency_permitted_checkbox() {
        currencygroupUpdatePageObject.clickAllCurrencyPermittedCheckbox();
    }
    @Then("^User validates the text \"([^\"]*)\" is displayed$")
    public void user_validates_the_text_is_displayed(String expectedText) {
        currencygroupUpdatePageObject.validateTextDisplayed(expectedText);
    }
}