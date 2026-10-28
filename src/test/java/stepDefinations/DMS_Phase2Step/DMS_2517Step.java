package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2517Step extends PageObject
{
    DMS_2517PageObject DMS_2517;
    @And("Verify update button should not visible for all USP template")
    public void verifyUpdateButtonShouldNotVisibleForAllUSPTemplate()
    {
        DMS_2517.verify_update_btn_is_visible_for_all_USP_template();
    }
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;
    @And("select document action using document action filter")
    public void selectDocumentActionUsingDocumentActionFilter(List<String> doc_action)
    {
        Validation_of_Document_Listing_screen_for_Doc.search_document_action_on_listing_screen(doc_action);
    }

    @And("Verify elements for Apply USP Rider")
    public void verifyElementsForApplyUSPRider()
    {
        DMS_2517.CheckUSPRiderTemplateCount();
    }

    @And("Verify create new button should visible on single edit USP rider screen")
    public void verifyCreateNewButtonShouldVisibleOnSingleEditUSPRiderScreen()
    {
        DMS_2517.CheckUSPRiderDocumentAvailability();
    }

    @And("Verify create new button should not visible if USP template is not available")
    public void verifyCreateNewButtonShouldNotVisibleIfUSPTemplateIsNotAvailable()
    {
        Assert.assertFalse(DMS_2517.getCreateNEW_button_for1stContainer().isVisible());
    }
}