package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_2198PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2201PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

@Slf4j
@Data

public class DMS_2201Step extends PageObject {

    DMS_2201PageObject dms2201PageObject;


    @And("User will click on create new on USP Rider tab if visible")
    public void User_will_click_on_create_new_on_USP_Rider_tab_if_visible(){
        dms2201PageObject.clickCreateNewUspButton_andCreateIfNotCreated();
    }
    @And("User will select checkbox of USP Rider ID and click next")
    public void User_will_select_checkbox_of_USP_Rider_ID_and_click_next(){
        dms2201PageObject.getUSPId_checkbox().click();
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        Assert.assertTrue(dms2201PageObject.getDatePicker_USPRiderTab().isVisible());
        dms2201PageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("User will click on next button and redirected to preview and submit screen")
    public void User_will_click_on_next_button_and_redirected_to_preview_and_submit_screen(){
        dms2201PageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        Assert.assertTrue(dms2201PageObject.getFinalPreview_text().isVisible());
    }
    @Then("User will redirected to preview and submit screen")
    public void User_will_redirected_to_preview_and_submit_screen(){
        Assert.assertTrue(dms2201PageObject.getFinalPreview_text().isVisible());
    }
    @And("USP Rider tab and view as PDF button should be visible under preview and submit section")
    public void USP_Rider_tab_and_view_as_PDF_button_should_be_visible_under_preview_and_submit_section(){
        Assert.assertTrue(dms2201PageObject.getUSPRiderTab_previewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getViewAsPDFButton_PreviewSubmitScreen().isVisible());
        log.info("USP Rider tab and View as PDF button is visible");
    }
    @Then("User should be redirected to edit screen for enforced documents")
    public void User_should_be_redirected_to_edit_screen_for_enforced_documents(){
        Assert.assertTrue(dms2201PageObject.getEditDocumentText().isVisible());
    }
    @And("User will click on limit Scope tab")
    public void User_will_click_on_limit_Scope_tab(){
        dms2201PageObject.getLimitScopeTab().click();
        if (dms2201PageObject.getAlertPopup().isVisible()){
            dms2201PageObject.getAlertPopup_YesBtn().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
    }
    @Then("User should be redirected to edit screen for draft documents")
    public void User_should_be_redirected_to_edit_screen_for_draft_documents(){
        Assert.assertTrue(dms2201PageObject.getEditDocumentText().isVisible());
    }
    @Then("User will click on USP Rider tab under preview and submit section")
    public void User_will_click_on_USP_Rider_tab_under_preview_and_submit_section(){
        dms2201PageObject.getUSPRiderTab_previewSubmit().click();
    }

    @Then("Corresponding information of USP Rider should be visible on preview and submit screen")
    public void Corresponding_information_of_USP_Rider_should_be_visible_on_preview_and_submit_screen(){
        Assert.assertTrue(dms2201PageObject.getPrimeBrokerName_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getClientName_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getPbContactText_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getWordClauseText_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getFundLEIName_UspPreviewSubmit().isVisible());
        log.info("All corresponding information of USP Rider is visible on preview and submit screen");
    }
    @And("Click on view as PDF button on preview and submit screen")
    public void Click_on_view_as_PDF_button_on_preview_and_submit_screen(){
        dms2201PageObject.getViewAsPDFButton_PreviewSubmitScreen().click();
    }

    @Then("Corresponding information of USP Rider should be visible on view as PDF screen")
    public void Corresponding_information_of_USP_Rider_should_be_visible_on_view_as_PDF_screen(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dms2201PageObject.getUspRiderText_ViewAsPDFScreen());
        Assert.assertTrue(dms2201PageObject.getPrimeBrokerName_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getClientName_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getUspRiderId_ViewAsPDFScreen().isVisible());
        Assert.assertTrue(dms2201PageObject.getPbContactText_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getWordClauseText_UspPreviewSubmit().isVisible());
        Assert.assertTrue(dms2201PageObject.getFundLEIName_UspPreviewSubmit().isVisible());
        log.info("All corresponding information of USP Rider is visible on view as PDF screen");
    }
}
