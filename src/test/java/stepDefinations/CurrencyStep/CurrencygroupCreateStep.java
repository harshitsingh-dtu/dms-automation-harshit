package stepDefinations.CurrencyStep;

import PageObjects.Currency.CurrencygroupCreateNewPageObject;
import PageObjects.Currency.CurrencygroupPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class CurrencygroupCreateStep extends PageObject {
    CurrencygroupCreateNewPageObject currencygroupCreateNewPageObject;
    CurrencygroupPageObject currencygroupPageObject;
    @When("User go to create new group screen")
    public void user_go_to_create_new_group_screen(){
        currencygroupCreateNewPageObject.clickcreatenewgrp_btn();
    }

    @And("User types the group name")
    public void user_types_the_group_name(List<String> groupname){
        currencygroupCreateNewPageObject.typesgrpname(groupname);
        //currencygroupCreateNewPageObject.selectcurrencygrp();
    }

    @And("User types the organization name")
    public void user_types_the_organization_name(DataTable table){
        currencygroupCreateNewPageObject.typesorganizationname(table);

    }
    @And("User will go to currency group listing screen")
    public void user_will_go_to_currency_group_listing_screen(){
        currencygroupPageObject.navigateToCurrencyscreen();
    }

    @And("User will search for the new created currency group")
    public void user_will_search_for_the_new_created_currency_group(List<String> currencygroupname){
//        currencygroupPageObject.navigatetoCurrencyPairgroupscreen();
        currencygroupCreateNewPageObject.searchCurrencygroup(currencygroupname);
    }

    @And("User will search for the new created currency group pair")
    public void user_will_search_for_the_new_created_currency_group_pair(List<String> currencygroupname){
        currencygroupPageObject.navigatetoCurrencyPairgroupscreen();
        currencygroupCreateNewPageObject.searchCurrencygroup(currencygroupname);
    }
    @Then("User will go to currency pair group listing screen")
    public void user_will_go_to_currency_pair_group_listing_screen(){
        currencygroupPageObject.navigateToCurrencyscreen();
        currencygroupPageObject.navigatetoCurrencyPairgroupscreen();
    }

    @And("User will search for the new created currency  pair group")
    public void user_will_search_for_the_new_created_currency_pair_group(List<String> currencygroupname) throws Throwable {
        currencygroupCreateNewPageObject.navigatetocurrencypairtab();
        currencygroupCreateNewPageObject.searchCurrencygroup(currencygroupname);
    }

    @And("User types the currency pair group name")
    public void user_types_the_currency_pair_group_name(List<String> groupname){
        currencygroupCreateNewPageObject.typesgrpname(groupname);
//        currencygroupCreateNewPageObject.selectcurrencypairgrp();
    }
    @And("User clicks on Currency group pair radio button")
    public void user_click_currency_group_pair(){
        Assert.assertTrue(currencygroupCreateNewPageObject.getCurrencypairgrp_radio().isVisible());
        currencygroupCreateNewPageObject.getCurrencypairgrp_radio().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User clicks on Currency group radio button")
    public void user_click_currency_group(){
        Assert.assertTrue(currencygroupCreateNewPageObject.getCurrencygrp_radio().isVisible());
        currencygroupCreateNewPageObject.getCurrencygrp_radio().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User clicks on Currency radio button")
    public void user_click_currency() {
        Assert.assertTrue(currencygroupCreateNewPageObject.getCurrencygrp_radio().isVisible());
        currencygroupCreateNewPageObject.getCurrencygrp_radio().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("User validates deliverable and Non_deliverable on create currency group page")
    public void deliverable_and_non_Deliverable_in_available_currencies() {
        Assert.assertEquals(currencygroupCreateNewPageObject.getDeliverable().size(), 1);
        Assert.assertEquals(currencygroupCreateNewPageObject.getNon_deliverable().size(), 1);
        //Assert.assertEquals(currencygroupCreateNewPageObject.getNon_deliverable_deliverable().size(), 1);
    }
    @And("User validates the currencies available for \"([^\"]*)\"$")
    public void available_currencies(String type) {
        if (type.equalsIgnoreCase("currency")){
            Assert.assertEquals(currencygroupCreateNewPageObject.getDeliverable_available_currencies().size(), 51);
            Assert.assertEquals(currencygroupCreateNewPageObject.getDeliverable_nondeliverable_available_currencies().size(), 88);
        }

        else if (type.equalsIgnoreCase("currencypair")){
            Assert.assertEquals(currencygroupCreateNewPageObject.getDeliverable_available_currencies().size(), 286);
            Assert.assertEquals(currencygroupCreateNewPageObject.getDeliverable_nondeliverable_available_currencies().size(), 504);
        }
    }
    @And("User validates the available Bullion for \"([^\"]*)\"$")
    public void available_bullion_currencies(String type) {

        if (type.equalsIgnoreCase("currencypair")){
            Assert.assertEquals(currencygroupCreateNewPageObject.getBullion_currency_pair().size(), 32);}
        else if (type.equalsIgnoreCase("currency")){
            Assert.assertEquals(currencygroupCreateNewPageObject.getBullion_currency().size(), 4);}
    }
    @Then("User validates currency group name length")
    public void validates_currency_grp_name_length () {
        currencygroupPageObject.validateCurrencyGroupNameMaxLength();
    }
}