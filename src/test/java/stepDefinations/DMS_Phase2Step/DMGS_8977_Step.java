package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMGS_8977_PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DMGS_8977_Step {

    DMGS_8977_PageObject dmgs8977PageObject;

    @When("User selects Allowed Currencies as {string}")
    public void user_selects_allowed_currencies(String option) {
        log.info("Step: User selects Allowed Currencies as {}", option);
        dmgs8977PageObject.selectAllowedCurrencies(option);
    }

    @Then("User verifies {string} instruments are {string} in the Authorization Scope")
    public void user_verifies_instrument_availability(String instrumentType, String availability) {
        log.info("Step: User verifies {} instruments are {} in the Authorization Scope", instrumentType, availability);
        dmgs8977PageObject.verifyInstrumentAvailability(instrumentType, availability);
    }

    @When("User attempts to manually inject instrument {string} into Authorization Scope")
    public void user_attempts_to_manually_inject_instrument(String instrument) {
        log.info("Step: User attempts to manually inject instrument {}", instrument);
        dmgs8977PageObject.manuallyInjectInstrument(instrument);
    }

    @Then("User verifies the error message {string}")
    public void user_verifies_the_error_message(String expectedMessage) {
        log.info("Step: User verifies the error message: {}", expectedMessage);
        dmgs8977PageObject.verifyErrorMessage(expectedMessage);
    }

    @Then("User verifies that the Allowed Currencies field is completely locked and read-only")
    public void user_verifies_that_the_allowed_currencies_field_is_completely_locked_and_read_only() {
        log.info("Step: User verifies that the Allowed Currencies field is completely locked and read-only");
        dmgs8977PageObject.verifyAllowedCurrenciesIsLocked();
    }

    @And("User verifies that legacy agreements load with Allowed Currencies set to {string}")
    public void user_verifies_that_legacy_agreements_load_with_allowed_currencies_set_to(String expectedAllowedCurrencies) {
        log.info("Step: User verifies that legacy agreements load with Allowed Currencies set to {}", expectedAllowedCurrencies);
        dmgs8977PageObject.verifyLegacyAgreementDetails(expectedAllowedCurrencies);
    }

    @And("User verifies that editing migrated agreement restricts adding {string} instruments")
    public void user_verifies_that_editing_migrated_agreement_restricts_adding_instruments(String instrumentType) {
        log.info("Step: User verifies that editing migrated agreement restricts adding {} instruments", instrumentType);
        dmgs8977PageObject.verifyInstrumentAvailability(instrumentType, "hidden");
    }
}
