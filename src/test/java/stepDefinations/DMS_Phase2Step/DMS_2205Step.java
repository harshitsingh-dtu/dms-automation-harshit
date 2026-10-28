package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_2205PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2205Step extends PageObject {

    DMS_2205PageObject dms2205PageObject;

    @And("Search document version id to check download button visibility")
    public void Search_document_version_id_to_check_download_button_visibility(){
        dms2205PageObject.searchDocumentVersionIdRandomly();
    }
    @Then("Download button should be visible under action column")
    public void Download_button_should_be_visible_under_action_column(){
        dms2205PageObject.getDownloadIcon_documentScreen().waitUntilVisible();
        Assert.assertTrue(dms2205PageObject.getDownloadIcon_documentScreen().isVisible());
        log.info("Download icon is visible on document listing screen");
    }
    @And("User will select USP Rider status on document listing screen")
    public void User_will_select_USP_Rider_status_on_document_listing_screen(List<String> uspStatus){
        dms2205PageObject.input_UspRiderStatus(uspStatus);
    }
    @And("Validate content of USP Rider tab under preview and submit section and pdf version should match")
    public void Validate_content_of_USP_Rider_tab_under_preview_and_submit_section_and_pdf_version_should_match(){
        dms2205PageObject.validateContentUSPTabUnderPreviewSubmit_PdfVersion();
    }
    @And("User will click on USP Rider tab and click on accordion button then date picker should be visible")
    public void User_will_click_on_USP_Rider_tab_and_click_on_accordion_button_then_date_picker_should_be_visible(){
        dms2205PageObject.getUspRiderTab_button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms2205PageObject.getDatePicker_USPRiderTab().isVisible());
    }
    @And("Validate content of USP Rider tab and pdf version should match")
    public void Validate_content_of_USP_Rider_tab_and_pdf_version_should_match(){
        dms2205PageObject.validateContentUSPRiderTab_PdfVersion();
    }
}
