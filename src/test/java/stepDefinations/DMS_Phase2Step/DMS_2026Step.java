package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_2026PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.With;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

@Slf4j
@Data

public class DMS_2026Step extends PageObject {

    DMS_2026PageObject DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject;


    @And("Click on document version ID under document version column")
    public void Click_on_document_version_ID_under_document_version_column(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getDocumentVersionID_link().waitUntilVisible();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getDocumentVersionID_link().click();
        withAction().pause(Duration.ofSeconds(12)).build().perform();
    }
    @Then("User should be able to see General terms fields and corresponding information in the Document preview")
    public void User_should_be_able_to_see_General_terms_fields_and_corresponding_information_in_the_Document_preview(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.checkInfo_GeneralTerms();
    }
    @Then("User will scroll to appendix section of PDF and able to see funds")
    public void User_will_scroll_to_appendix_section_of_PDF_and_able_to_see_funds(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getAppendix_section());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getAppendix_section().isVisible());
        Assert.assertTrue(DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getFunds_text().isVisible());
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.viewFundDetails();
    }
    @And("User will select Acting As on popup screen")
    public void User_will_select_Acting_As_on_popup_screen(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.popup_actingAs();
    }
    @When("User will click on preview and submit tab")
    public void User_will_click_on_preview_and_submit_tab(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getPreviewAndSubmit_tab().waitUntilVisible();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getPreviewAndSubmit_tab().click();
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getFinalPreview().isVisible());
    }

    @And("User will enter general terms details and click next")
    public void User_will_enter_general_terms_details_and_click_next(DataTable table){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.enterAddress(table);
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.enterContact(table);
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.selectActingOffice();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.selectRelationship();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.selectSpecifiedOffice();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.enterNotes(table);
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getNextButton().waitUntilClickable();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getNextButton().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @And("Click general terms tab on preview and submit screen")
    public void Click_general_terms_tab_on_preview_and_submit_screen(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getGeneralTerms_tab().waitUntilVisible();
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getGeneralTerms_tab().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    @Then("User should be able to see General terms fields and corresponding information on preview and submit screen")
    public void User_should_be_able_to_see_General_terms_fields_and_corresponding_information_on_preview_and_submit_screen(){
        Assert.assertTrue(DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getGeneralTerms_info().isVisible());
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.checkInfo_GeneralTerms_FinalPreview();
    }
    @And("User will be able to add funds for Client one if not added")
    public void User_will_be_able_to_add_funds_for_Client_1_if_not_added(DataTable table){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.addFunds_Client1(table);
    }
    @And("User will be able to add funds for Client two if not added")
    public void User_will_be_able_to_add_funds_for_Client_2_if_not_added(DataTable table){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.addFunds_Client2(table);
    }
    @And("User will click on Save As Draft and search document version ID")
    public void User_will_click_on_Save_As_Draft_and_search_document_version_ID(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.searchDocument_VersionId();
    }
    @And("Click on general terms tab on document screen")
    public void Click_on_general_terms_tab_on_document_screen(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getGeneralTermsTab_documentScreen().click();
    }
    @Then("User will be redirected to general terms tab on document screen")
    public void User_will_be_redirected_to_general_terms_tab_on_document_screen(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getRedirected_generalTermsTab().waitUntilVisible();
        Assert.assertTrue(DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getRedirected_generalTermsTab().isVisible());
    }
    @And("Click on next button on general terms screen")
    public void Click_on_next_button_on_general_terms_screen(){
        DMS2026AddGeneraltermsandthelistoffundstothepdfversionofthedocumentPageObject.getNextButton().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();
    }
}
