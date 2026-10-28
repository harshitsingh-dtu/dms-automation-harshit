package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1548_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2198PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2337PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2495PageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data

public class DMS_2495Step extends PageObject {

    DMS_2495PageObject DMS_2495;
    DMS_2337PageObject DMS_2337;
    @Then("verify user can see popup with yes and no buttons")
    public void verifyUserCanSeePopupWithYesAndNoButtons()
    {
        Assert.assertTrue(DMS_2495.getPopup_body().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(DMS_2495.getPopup_Yes_btn().isVisible());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DMS_2495.getPopup_No_btn().isVisible());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    @And("Click on No button of popup")
    public void clickOnNoButtonOfPopup()
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(DMS_2495.getPopup_No_btn().isDisplayed());
        DMS_2495.getPopup_No_btn().click();
    }

    @And("Click on submit button on lite_user_alert_screen")
    public void clickOnSubmitButtonOnLite_user_alert_screen()
    {
        Assert.assertTrue(DMS_2337.getLite_user_alert_screen().isVisible());
        Assert.assertTrue(DMS_2495.getSubmit_btn_on_lite_user_alert_screen().isVisible());
        DMS_2495.getSubmit_btn_on_lite_user_alert_screen().click();
    }

    @And("Verify user is on bulk request screen")
    public void verifyUserIsOnBulkRequestScreen()
    {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(DMS_2495.getBulk_request_screen().isVisible());

    }

    @And("Verify user is on the bulk request screen now")
    public void verifyUserIsOntheBulkRequestScreen()
    {
        withAction().pause(Duration.ofSeconds(7)).build().perform();
        Assert.assertTrue(DMS_2495.getBulk_request_screenverify().isVisible());

    }

    @And("Verify user is on the Batch Details screen now")
    public void verifyUserIsOntheBatchDetailsScreen()
    {
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        Assert.assertTrue(DMS_2495.getBatch_details_screen().isVisible());

    }

    @When("User selects initiator by LEI and clicks on View Details Button")
    public void user_selects_initiator_by_lei(List<String> approvalGroup) {
        DMS_2495.selectInitiatorBYLEI(approvalGroup);
    }

    @When("User validates the Batch status")
    public void user_validates_the_batch_status() {
        DMS_2495.validateBatchStatus();
    }

    @When("User validates the Processed Batch status")
    public void user_validates_the_processed_batch_status() {
        DMS_2495.validateProcessedBatchStatus();
    }

    @And("select one usp template with impacted documents")
    public void selectOneUspTemplateWithImpactedDocuments()
    {
        DMS_2337.search_USP_ID(DMS_2337.get_USP_temp_ID_without_0_related_documents_count());
    }

    @And("Click on update button to update USP template")
    public void clickOnUpdateButtonToUpdateUSPTemplate()
    {
        DMS_2495.getUSP_template_update_btn().waitUntilVisible().click();
    }

    @And("Make changes in template and click on submit button")
    public void makeChangesInTemplateAndClickOnSubmitButton()
    {
        DMS_2495.change_contact_in_usp_template();
        DMS_2495.getUSP_template_Submit_btn().click();
        DMS_2495.getPopup_Yes_btn().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("select impacted document")
    public void selectImpactedDocument()
    {
        DMS_2495.getImpacted_document_select_checkbox().click();
    }

    @And("Click on Apply button on Impacted Documents screen")
    public void clickOnApplyButtonOnImpactedDocumentsScreen()
    {
        DMS_2495.getImpacted_document_screen_apply_btn().waitUntilEnabled();
        evaluateJavascript("arguments[0].click();", DMS_2495.getImpacted_document_screen_apply_btn());
    }

    @And("Verify user is on lite user alert screen")
    public void verifyUserIsOnLiteUserAlertScreen()
    {
//        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue( DMS_2495.getLite_user_alert_screen().isVisible());
    }

    @And("Verify user is on submitting bulk request alert screen")
    public void verifyUserIsOnSubmittingBulkRequestAlertScreen()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue( DMS_2495.getSubmitting_Bulk_request_Screen().isVisible());
    }

    @And("Click on Submit button on lite user alert screen")
    public void clickOnSubmitButtonOnLiteUserAlertScreen()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(DMS_2495.getSubmit_btn_on_lite_user_alert_screen().isEnabled());
        DMS_2495.getSubmit_btn_on_lite_user_alert_screen().click();

    }
    DMS_1548_PageObject DMS_1548;
    @And("Navigate to Bulk request screen")
    public void navigateToBulkRequestScreen()
    {

        Assert.assertTrue(DMS_1548.getNavigation_btn().isEnabled());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getDocument_tab().isEnabled());
        DMS_1548.getDocument_tab().click();
        Assert.assertTrue(DMS_2495.getBulk_request_tab().isEnabled());
        DMS_2495.getBulk_request_tab().click();

    }

    @And("Verify Select Document Action dropdown is present")
    public void verifySelectDocumentActionDropdownIsPresent()
    {
        Assert.assertTrue(DMS_2495.getDocument_action_dropdown().isEnabled());

    }

    @And("Select Apply USP Rider from Document Action dropdown")
    public void selectApplyUSPRiderFromDocumentActionDropdown()
    {
        DMS_2495.select_doc_action_Apply_USP_Rider();
    }

    @Then("Verify only Apply USP Rider is present under action type column")
    public void verifyOnlyApplyUSPRiderIsPresentUnderActionTypeColumn() {
        DMS_2495.check_only_Apply_USP_Rider_present_under_Action_type_column();
    }
}
