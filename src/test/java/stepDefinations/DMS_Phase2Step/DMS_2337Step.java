package stepDefinations.DMS_Phase2Step;


import PageObjects.DMS_PHASE2PageObject.DMS_2337PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_2337Step extends PageObject
{
    DMS_2337PageObject DMS_2337;
    @Then("Select doc type on USP listing screen")
    public void selectDocTypeOnUSPListingScreen(List<String> filters)
    {
        DMS_2337.select_doc_type_from_USP_listing_screen(filters);
    }

    @And("Search template which have more then zero Related Documents count")
    public void searchTemplateWhichHaveMoreThenZeroRelatedDocumentsCount()
    {
        DMS_2337.search_USP_ID(DMS_2337.get_USP_temp_ID_without_0_related_documents_count());
    }

    @And("Verify impacted documents are visible under Related Documents count")
    public void verifyImpactedDocumentsAreVisibleUnderRelatedDocumentsCount()
    {
        DMS_2337.check_impacted_doc_list();
    }

    @And("Click on template Related Documents count")
    public void clickOnTemplateRelatedDocumentsCount()
    {
        DMS_2337.getDocCount().click();
    }

    @And("Verify user is on Impacted Documents screen")
    public void verifyUserIsOnImpactedDocumentsScreen()
    {

        Assert.assertTrue(DMS_2337.getImpacted_doc_listing_screen_heading().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();

    }

    @And("Verify elements on Impacted Documents screen")
    public void verifyElementsOnImpactedDocumentsScreen()
    {
        Assert.assertTrue(DMS_2337.getImpacted_doc_listing_screen_heading().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_listing_screen_sub_heading().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_doc_type_dropdown().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_search_box().isVisible());

        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_doc_ID_column().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_doc_Version_ID_column().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_doc_type_column().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_USP_template_ID_column().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_USP_Update_Status_column().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_Last_Updated_On_column().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_doc_status_column().isVisible());

        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_close_button().isVisible());
        Assert.assertTrue(DMS_2337.getImpacted_doc_screen_apply_button().isVisible());
    }

    @And("Verify Apply should not visible on Impacted Documents screen")
    public void verifyApplyShouldNotVisibleOnImpactedDocumentsScreen()
    {
        Assert.assertFalse(DMS_2337.getImpacted_doc_screen_apply_button().isVisible());
    }

    @And("Verify USP id format for impacted documents drawer")
    public void verifyUSPIdFormatForImpactedDocumentsDrawer()
    {
        DMS_2337.Check_UPS_ID_format();
    }


    @And("Verify doc ID format for impacted documents drawer")
    public void verifyDocIDFormatForImpactedDocumentsDrawer()
    {
        DMS_2337.Check_doc_ID_format();
    }

    @And("Verify doc version id format for impacted documents drawer")
    public void verifyDocVersionIdFormatForImpactedDocumentsDrawer()
    {
        DMS_2337.Check_doc_version_ID_format();
    }

    @And("Verify doc status should be enforced format for impacted documents drawer")
    public void verifyDocStatusShouldBeEnforcedFormatForImpactedDocumentsDrawer()
    {
        DMS_2337.Check_doc_status_is_Enforced();
    }

    @And("Verify Last Updated on format for impacted documents drawer")
    public void verifyLastUpdatedOnFormatForImpactedDocumentsDrawer()
    {
        DMS_2337.Check_UPS_ID_Last_Updated_On_Format();
    }

    @And("Verify Doc type filter data items for impacted documents drawer")
    public void verifyDocTypeFilterDataItemsForImpactedDocumentsDrawer(List<String> filters)
    {
        DMS_2337.verifyDocTypesList(filters);
    }

    @And("Select doc type four way for impacted documents drawer")
    public void selectDocTypeFourWayForImpactedDocumentsDrawer(List<String> filters)
    {
        DMS_2337.select_doc_type_from_impacted_document_screen(filters);
    }

    @And("Verify Close button on Impacted Documents screen")
    public void verifyCloseButtonOnImpactedDocumentsScreen()
    {
        DMS_2337.getImpacted_doc_screen_close_button().click();
    }

    @And("Select doc type four way for impacted documents drawer verify corresponding result")
    public void selectDocTypeFourWayForImpactedDocumentsDrawerVerifyCorrespondingResult(List<String> filters)
    {
        DMS_2337.select_doc_type_from_impacted_document_screen(filters);
        DMS_2337.Verify_Corresponding_result_for_doc_type(filters);
    }

    @And("Select doc type DN for impacted documents drawer verify Search query corresponding result")
    public void selectDocTypeDNForImpactedDocumentsDrawerVerifySearchQueryCorrespondingResult(List<String> filters)
    {
        DMS_2337.select_doc_type_from_impacted_document_screen(filters);
        DMS_2337.Verify_Corresponding_result_for_doc_type(filters);
    }

    @And("Select both doc type for impacted documents drawer verify Search query corresponding result")
    public void selectBothDocTypeForImpactedDocumentsDrawerVerifySearchQueryCorrespondingResult(List<String> filters)
    {
        DMS_2337.select_doc_type_from_impacted_document_screen(filters);
        DMS_2337.Verify_Corresponding_result_for_doc_type(filters);
    }


    @And("Verify New Update button under USP update status on Impacted Documents screen")
    public void verifyNewUpdateButtonUnderUSPUpdateStatusOnImpactedDocumentsScreen()
    {
        DMS_2337.check_USP_update_under_USP_Update_Status_column();
    }

    @And("Verify elements on compare page of USP template")
    public void verifyElementsOnComparePageOfUSPTemplate()
    {
        DMS_2337.check_compare_popup_element_for_new_update();
    }

    @And("Verify search functionality by ID on Impacted Documents screen")
    public void verifySearchFunctionalityByIDOnImpactedDocumentsScreen()
    {
        DMS_2337.search_box_functionality_on_impacted_document_screen();
    }

    @And("Verify Document ID search box and check box is enable if USP update status is not Up to date")
    public void verifyDocumentIDSearchBoxAndCheckBoxIsEnableIfUSPUpdateStatusIsNotUpToDate()
    {
        DMS_2337.check_check_box_functionality_on_impacted_document_screen();
    }

    @And("Verify Apply USP template functionality")
    public void verifyApplyUSPTemplateFunctionality()
    {
        DMS_2337.check_Apply_button_functionality();
    }
    @Then("Verify values under Word Clause should true or False")
    public void verifyValuesUnderWordClauseShouldTrueOrFalse()
    {
        DMS_2337.check_word_clause_USP_template_screen();
    }
    @And("Verify hyperlink on Impacted Documents screen")
    public void verifyhyperlinkOnImpactedDocumentsScreen()
    {

        Assert.assertTrue(DMS_2337.getHyperlinkusp().isVisible());
    }
    @And("User click on hyperlink")
    public void userClickOnHyperlink()
    {
        DMS_2337.getHyperlinkusp().click();
    }

    @And ("Select Document version ID & apply filter on document listing screen")
      public void Select_document_versio_apply_filter()
      {
      DMS_2337.getverisonID();
      }


}