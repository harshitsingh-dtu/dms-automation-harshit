package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_2023PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2026PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2023Step extends PageObject {

    DMS_2023PageObject dms2023PageObject;

    DMS_2026PageObject DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject;

    @Then("User should be redirected to next tab")
    public void User_should_be_redirected_to_next_tab(){
        Assert.assertTrue(dms2023PageObject.getAuthProducts().isVisible());
        log.info("Redirected to next tab");
    }
    @And("User will enter general terms details")
    public void User_will_enter_general_terms_details(DataTable table){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.enterAddress(table);
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.enterContact(table);
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.selectActingOffice();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.selectRelationship();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.selectSpecifiedOffice();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.enterNotes(table);
    }
    @Then("User will click on next button and again click on general terms tab and verify that filled in details should be visible")
    public void User_will_click_on_next_button_and_again_click_on_general_terms_tab_and_verify_that_filled_in_details_should_be_visible(){
        dms2023PageObject.validateFilledDetails_GeneralTerms();
    }
    @And("User will search document version ID")
    public void User_will_search_document_version_ID(){
        dms2023PageObject.enterVersionId();
    }
    @And("Clicks on Edit icon")
    public void Clicks_on_Edit_icon(){
        dms2023PageObject.getEditIcon().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (dms2023PageObject.getAlertMessage().isVisible()){
            dms2023PageObject.getNo_btn().click();
        }
    }
    @Then("User will go on general terms tab and make changes")
    public void User_will_go_on_general_terms_tab_and_make_changes(){
        dms2023PageObject.makeChanges_GeneralTerms();
    }

    @Then("User will select Action Type")
    public void User_will_select_Action_Type(){
        dms2023PageObject.selectActionType();
    }
    @Then("General terms tab should be disabled")
    public void General_terms_tab_should_be_disabled(){
        Assert.assertTrue(dms2023PageObject.getGeneralTerms_tab().isDisabled());
        log.info("General Terms tab is disabled");
    }
    @Then("User will go to preview and submit tab")
    public void User_will_go_to_preview_and_submit_tab(){
        dms2023PageObject.getPreviewAndSubmit_tab().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("Click on general terms tab in preview and submit")
    public void Click_on_general_terms_tab_in_preview_and_submit(){
        dms2023PageObject.getGeneralTermsTab_previewSubmit().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("Details regarding general terms tab should be visible")
    public void Details_regarding_general_terms_tab_should_be_visible(){
        dms2023PageObject.detailsGeneralTerms_inPreviewAndSubmitTab();
    }
    @Then("User will select Action type as Edit documents")
    public void User_will_select_Action_type_as_Edit_documents(List<String> actionType){
        dms2023PageObject.selectActionType_editDocuments(actionType);
    }
    @And("User will select document action")
    public void User_will_select_document_action(List<String> documentAction){
        dms2023PageObject.select_documentAction(documentAction);
    }
    @And("User will click on enforcement rules tab and redirected to enforcement rules")
    public void User_will_click_on_enforcement_rules_tab_and_redirected_to_enforcement_rules(){
        dms2023PageObject.getEnforcementRulesTab_documentScreen().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms2023PageObject.getRedirected_enforcementRulesTab().waitUntilVisible();
    }
}
