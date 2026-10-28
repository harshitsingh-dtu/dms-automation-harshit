package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1468PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
public class DMS_1468Step extends PageObject {
    DMS_1468PageObject dms_1468PageObject;
    @Then("In the LEI Org type status table Doc type column should be visible")
    public void in_the_lei_org_type_status_table_doc_type_column_should_be_visible() {
        Assert.assertTrue(dms_1468PageObject.getDoctype_column().isVisible());
    }

    @Then("Below the Organisation information section Doc type Filter By default Doc type filter will be set as four way")
    public void belowTheOrganisationInformationSectionDocTypeFilterByDefaultDocTypeFilterWillBeSetAsWay() {
        dms_1468PageObject.getDoctype_filter().waitUntilVisible();
        Assert.assertTrue(dms_1468PageObject.getDoctype_filter().isDisplayed());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertEquals("4 Way",dms_1468PageObject.getDoctype_filter().getAttribute("value").trim());
    }

    @And("In the LEI Org type status table for the LEI Org type status mapping as Online or Lite There will be three states Lite Neutral and Online")
    public void inTheLEIOrgTypeStatusTableForTheLEIOrgTypeStatusMappingAsOnlineOrLiteThereWillBeStatesLiteNeutralAndOnline(List<String> list) {
        dms_1468PageObject.check_status_present(list);
    }

    @Then("Following doc types should be visible to the user Doc type filter on Organisation update screen")
    public void followingDocTypesShouldBeVisibleToTheUserDocTypeFilterOnOrganisationUpdateScreen(List<String> list) {
        dms_1468PageObject.check_doctype_filter_list(list);
    }

    @When("Click on Doc type filter on Organisation update screen")
    public void clickOnDocTypeFilterOnOrganisationUpdateScreen() {
        dms_1468PageObject.getDoctype_filter().click();
    }

    @Then("Verify the static information on Organisation update screen by changing the filter")
    public void verifyTheStaticInformationOnOrganisationUpdateScreenByChangingTheFilter() {
        dms_1468PageObject.verify_static_information();
    }
    @When("User will click on random Organisation Update button")
    public void user_will_click_on_random_organisation_update_button() {
        dms_1468PageObject.click_on_random_Organisation_Update_button();
    }



    @When("Search for LEI ID or name that belongs to doc type searched")
    public void search_for_lei_id_or_name_that_belongs_to_doc_type_searched() {
        dms_1468PageObject.search_for_lei_id_or_name_that_belongs_to_doc_type_searched();
    }

    @When("Search for LEI ID or name that does NOT belong to doc type searched")
    public void search_for_lei_id_or_name_that_does_not_belong_to_doc_type_searched(List<String> list) {
dms_1468PageObject.search_for_lei_id_or_name_that_does_not_belong_to_doc_type_searched(list);
    }

    @Then("for doc type DN Org type status column should be contain three further columns Which each will have tabs Online Neutral and Lite")
    public void forDocTypeDNOrgTypeStatusColumnShouldBeContainFurtherColumns() {
      try {

          Assert.assertTrue(dms_1468PageObject.getDN_PB_Lite_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_PB_Neutral_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_PB_Online_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_EB_Lite_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_EB_Neutral_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_EB_Online_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_Client_Lite_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_Client_Neutral_button().isVisible());
          Assert.assertTrue(dms_1468PageObject.getDN_Client_Online_button().isVisible());
      }catch (Exception e){
          log.error(""+e);
          Assert.fail();
      }
    }



    @And("Click on Submit button on Organisation Update screen")
    public void clickOnSubmitButtonOnOrganisationUpdateScreen() {
        dms_1468PageObject.clickSubmit();
    }

    @Then("for doc type Four Way Org type status column should be contain three further columns Which each will have tabs Online Neutral and Lite")
    public void forDocTypeFourWayOrgTypeStatusColumnShouldBeContainThreeFurtherColumnsWhichEachWillHaveTabsOnlineNeutralAndLite() {
        Assert.assertTrue(dms_1468PageObject.getFourWay_PB_Lite_button().isVisible());
        Assert.assertTrue(dms_1468PageObject.getFourWay_PB_Neutral_button().isVisible());
        Assert.assertTrue(dms_1468PageObject.getFourWay_PB_Online_button().isVisible());
        Assert.assertTrue(dms_1468PageObject.getFourWay_Client_Lite_button().isVisible());
        Assert.assertTrue(dms_1468PageObject.getFourWay_Client_Neutral_button().isVisible());
        Assert.assertTrue(dms_1468PageObject.getFourWay_Client_Online_button().isVisible());
    }

    @When("Click on Org type Status for Bulk Update to Online")
    public void clickOnOrgTypeStatusForBulkUpdate(List<String>list) {
        dms_1468PageObject.bulk_LEI_changeStatusTo_Online(list);

    }

    @When("Click on Org type Status for Bulk Update to Lite")
    public void clickOnOrgTypeStatusForBulkUpdateToLite(List<String>list) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
            dms_1468PageObject.bulk_LEI_changeStatusTo_Lite(list);

    }

    @When("Click on Org type status for individual LEI to Online")
    public void clickOnOrgTypeStatusForIndivualLEIToOnline(List<String> list) {
        dms_1468PageObject.LEI_changeStatusTo_Lite(list);
    }

    @And("Search for random LEI on organisation update screen")
    public void searchForRandomLEIOnOrganisationUpdateScreen() {
        dms_1468PageObject.search_random_LEIid();
    }

//    @And("Change the Status for an Org")
//    public void clickOnOrgTypeStatusForIndividualLEIToLite(List<String > list) {
//        dms_1468PageObject.LEI_changeStatusTo_Lite(list);
//    }

    @And("Change the Status for an Org to {word}")
    public void clickOnOrgTypeStatusForIndividualLEI(String targetStatus, List<String> list) {
        if (targetStatus.equalsIgnoreCase("Lite")) {
            dms_1468PageObject.LEI_changeStatusTo_Lite(list);
        } else if (targetStatus.equalsIgnoreCase("Online")) {
            dms_1468PageObject.LEI_changeStatusTo_Online(list);
        } else {
            Assert.fail("Invalid target status provided: " + targetStatus);
        }
    }

    @And("Click on LEI name on organisation update screen")
    public void clickOnLEINameOnOrganisationUpdateScreen() {
        dms_1468PageObject.getLEI_name().click();
    }

    @Then("Bulk update to Online in side window")
    public void bulkUpdateToOnlineInSideWindow(List<String > list) {
        dms_1468PageObject.bulk_update_sidewindow_toOnline(list);
    }
    @Then("Bulk update to Lite in side window")
    public void bulkUpdateToLiteInSideWindow(List<String>list) {
        dms_1468PageObject.bulk_update_sidewindow_toLite(list);
        dms_1468PageObject.getConfirmation_yes_btn().waitUntilVisible();
        withAction().moveToElement(dms_1468PageObject.getConfirmation_yes_btn()).click().build().perform();

    }

    @When("Verify pop elements")
    public void Verify_pop_elements() {
        dms_1468PageObject.getConfirmation_yes_btn().isVisible();
        dms_1468PageObject.getConfirmation_no_btn().isVisible();
    }

    @When("Verify no click elements")
    public void Verify_noclick_elements() {
//        dms_1468PageObject.getConfirmation_yes_btn().isVisible();
        dms_1468PageObject.getConfirmation_no_btn().isVisible();
        dms_1468PageObject.getConfirmation_no_btn().click();
    }

    @And("Validate successful update message")
    public void Validate_successful_update_message() {
        dms_1468PageObject.validateSuccess();
    }
}
