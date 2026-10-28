package stepDefinations.CurrencyStep;

import PageObjects.Currency.CurrencySelectionClearPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class CurrencySelectionClearStep extends PageObject {

    CurrencySelectionClearPageObject currencySelectionClearPageObject;

    @Then("Verify selected currencies are clearly and obviously highlighted as {string} with visual badges on the UI")
    public void verify_selected_currencies_are_clearly_and_obviously_highlighted_as_selected_with_visual_badges_on_the_ui(String highlightType) {
        currencySelectionClearPageObject.verifySelectedCurrenciesHighlighted();
    }

    @And("Verify user is able to easily identify all selected currencies after scrolling")
    public void verify_user_is_able_to_easily_identify_all_selected_currencies_after_scrolling() {
        currencySelectionClearPageObject.verifySelectedCurrenciesAfterScrolling();
    }

    @When("User clicks on {string} button to clear selected currencies in a single action")
    public void user_clicks_on_button_to_clear_selected_currencies_in_a_single_action(String buttonName) {
        currencySelectionClearPageObject.clickRemoveAllButton();
    }

    @Then("Verify that the currency selection is completely cleared and all checkmarks are deselected")
    public void verify_that_the_currency_selection_is_completely_cleared_and_all_checkmarks_are_deselected() {
        currencySelectionClearPageObject.verifyCurrencySelectionCleared();
    }

    @Then("Verify previously selected and amended currencies are clearly and obviously distinguished on the UI")
    public void verify_previously_selected_and_amended_currencies_are_clearly_and_obviously_distinguished_on_the_ui() {
        currencySelectionClearPageObject.verifyAmendedOrSelectedCurrenciesDistinguished();
    }

    @And("Verify previously selected currencies display with explicit {string} highlight indicators")
    public void verify_previously_selected_currencies_display_with_explicit_highlight_indicators(String highlightType) {
        currencySelectionClearPageObject.verifySelectedHighlightIndicators();
    }

    @Then("Verify that all selected currencies are deselected in one single click action")
    public void verify_that_all_selected_currencies_are_deselected_in_one_single_click_action() {
        currencySelectionClearPageObject.verifyCurrencySelectionCleared();
    }

    @Then("Verify that inherited currencies from the parent DF are clearly and obviously highlighted as {string}")
    public void verify_that_inherited_currencies_from_the_parent_df_are_clearly_and_obviously_highlighted_as_selected(String highlightType) {
        currencySelectionClearPageObject.verifySelectedHighlightIndicators();
    }

    @And("Verify user is able to easily identify all opted-in currencies on the UI")
    public void verify_user_is_able_to_easily_identify_all_opted_in_currencies_on_the_ui() {
        currencySelectionClearPageObject.verifyOptedInCurrenciesIdentifiable();
    }

    @When("User clicks on {string} button to clear opted-in currencies in a single action")
    public void user_clicks_on_button_to_clear_opted_in_currencies_in_a_single_action(String buttonName) {
        currencySelectionClearPageObject.clickRemoveAllButton();
    }

    @Then("Verify that all selected and inherited currencies are cleared and deselected instantly")
    public void verify_that_all_selected_and_inherited_currencies_are_cleared_and_deselected_instantly() {
        currencySelectionClearPageObject.verifyCurrencySelectionCleared();
    }

    @Then("Verify selected or amended currencies are clearly and obviously distinguished with highlighted visual badges")
    public void verify_selected_or_amended_currencies_are_clearly_and_obviously_distinguished_with_highlighted_visual_badges() {
        currencySelectionClearPageObject.verifyAmendedOrSelectedCurrenciesDistinguished();
    }

    @Then("Verify that all currency selections are completely cleared and deselected in a single action")
    public void verify_that_all_currency_selections_are_completely_cleared_and_deselected_in_a_single_action() {
        currencySelectionClearPageObject.verifyCurrencySelectionCleared();
    }
}
