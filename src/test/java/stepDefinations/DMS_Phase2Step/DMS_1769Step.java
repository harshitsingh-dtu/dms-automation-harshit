package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1525_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1548_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1769PageObject;
import io.cucumber.java.en.And;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1769Step extends PageObject
{
    DMS_1769PageObject DMS_1769;
    DMS_1548_PageObject As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject;
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;

    @And("Verify Approval Request tab should be visible")
    public void verifyApprovalRequestTabShouldBeVisible()
    {
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().click();
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().isEnabled());
//        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().click();
        Assert.assertTrue(DMS_1769.getApproval_request_tab().isEnabled());
        DMS_1769.getApproval_request_tab().click();
    }

    @And("Verify Approval Request tab should not visible")
    public void verifyApprovalRequestTabShouldNotVisible()
    {
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().click();
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().waitUntilClickable().click();
        Assert.assertFalse(DMS_1769.getApproval_request_tab().isVisible());
    }

    @And("Click on the Approval Access Request")
    public void clickOnTheApprovalAccessRequest()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().click();
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().click();
        Assert.assertTrue(DMS_1769.getDocuments_access_request_tab().isEnabled());
        DMS_1769.getDocuments_access_request_tab().click();
    }

    @And("Verify user is on Approval Access Request screen")
    public void verifyUserIsOnApprovalAccessRequestScreen()
    {
        Assert.assertTrue(DMS_1769.getDocuments_access_request_screen_heading().isEnabled());
        DMS_1769.getDocuments_access_request_screen_heading().click();
    }

    @And("Click on Submit after role assigning screen")
    public void clickOnSubmitAfterRoleAssigningScreen()
    {
        Assert.assertTrue(DMS_1769.getSubmit_btn().isEnabled());
        DMS_1769.getSubmit_btn().click();
    }

    @And("Verify elements on Approval Access Request screen")
    public void verifyElementsOnApprovalAccessRequestScreen()
    {
        Assert.assertTrue(DMS_1769.getSelect_status_input().isVisible());
        Assert.assertTrue(DMS_1769.getSelect_doc_type_input().isVisible());
        Assert.assertTrue(DMS_1769.getSelect_reviewer_LEI_input().isVisible());
        Assert.assertTrue(DMS_1769.getSelect_reviewer_input().isVisible());
        Assert.assertTrue(DMS_1769.getSelect_requester_LEI_input().isVisible());
        Assert.assertTrue(DMS_1769.getSelect_requester_input().isVisible());
        Assert.assertTrue(DMS_1769.getSearch_by_request_ID_input().isVisible());
        Assert.assertEquals(DMS_1769.getView_details_btn().size(),DMS_1769.getRequests_list().size());
    }

    @And("Validate status filters on Approval Access Request screen")
    public void validateStatusFiltersOnApprovalAccessRequestScreen(List<String> status_filters)
    {
        Assert.assertTrue(DMS_1769.getSelect_status_input().isEnabled());
        DMS_1769.getSelect_status_input().click();
        String StatusList = DMS_1769.getList_of_filters().getText();
        for (int i=1;i<=status_filters.size()-1;i++)
        {
//            System.out.println(status_filters.get(i).toLowerCase()+"---"+StatusList.toLowerCase());
//        Assert.assertTrue(StatusList.toLowerCase().contains(status_filters.get(i).toLowerCase()));
        if (StatusList.toLowerCase().contains(status_filters.get(i).toLowerCase()))
        {
            System.out.println(status_filters.get(i)+"---> Filter is present in status filter dropdown");
        }
        else {
            Assert.fail();
        }
        }
    }

    @And("Validate Request ID search functionality on Approval Access Request screen")
    public void validateRequestIDSearchFunctionalityOnApprovalAccessRequestScreen()
    {
       DMS_1769.pick_random_Request_ID_and_verify_search_functionality();
    }

    @And("Select status and verify corresponding results")
    public void selectStatusAndVerifyCorrespondingResults(List<String> status_filters)
    {
        Assert.assertTrue(DMS_1769.getSelect_status_input().isEnabled());
//        DMS_1769.select_status_on_requests_screen(status_filters);
        DMS_1769.check_enter_filter_and_results_should_be_same(status_filters);

    }

    @And("Click on the Doc type dropdown and validate doc types")
    public void clickOnTheDocTypeDropdownAndValidateDocTypes(List<String> doc_types)
    {
        Assert.assertTrue(DMS_1769.getSelect_doc_type_input().isEnabled());
        DMS_1769.getSelect_doc_type_input().click();

        String StatusList = DMS_1769.getList_of_filters().getText();
        for (int i=1;i<=doc_types.size()-1;i++)
        {
          if (StatusList.toLowerCase().contains(doc_types.get(i).toLowerCase()))
            {
                System.out.println(doc_types.get(i)+"---> Filter is present in Doc type filter dropdown");
            }
            else {
                Assert.fail();
            }
        }
    }

    @And("Select Doc type and verify corresponding results")
    public void selectDocTypeAndVerifyCorrespondingResults(List<String> doc_types)
    {
        Assert.assertTrue(DMS_1769.getSelect_doc_type_input().isEnabled());
        DMS_1769.select_doc_types_on_requests_screen(doc_types);

        for (int i=0;i<=DMS_1769.getRequests_doc_type_list().size()-1;i++)
        {
            Assert.assertTrue(doc_types.get(1).contains(DMS_1769.getRequests_doc_type_list().get(i).getText()));
        }
    }

    @And("verify results if roles are not assign and trying to search that doc type")
    public void verifyResultsIfRolesAreNotAssignAndTryingToSearchThatDocType(List<String> doc_types)
    {
        Assert.assertTrue(DMS_1769.getSelect_doc_type_input().isEnabled());
        DMS_1769.select_doc_types_on_requests_screen(doc_types);
        Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible());
    }

    @And("Verify pagination elements")
    public void verifyPaginationElements()
    {
     Assert.assertTrue(DMS_1769.getCurrent_page_on_pagination().isVisible());
     Assert.assertTrue(DMS_1769.getTotal_page_on_pagination().isVisible());
     Assert.assertTrue(DMS_1769.getTotal_number_of_records_per_page_pagination().isVisible());
        Assert.assertTrue(DMS_1769.getNext_page_button() .isVisible());
        Assert.assertTrue(DMS_1769.getPrevious_page_button().isVisible());

    }

    @And("change items per page selection to fifty")
    public void changeItemsPerPageSelectionTo()
    {
        DMS_1769.change_Records_per_page_to_50();
    }

    @And("Verify if Pending status is selected document versions should be blank")
    public void verifyIfPendingStatusIsSelectedDocumentVersionsShouldBeBlank()
    {
//        check version id filed should be blank
        for (int i=0;i<=DMS_1769.getRequests_version_ID_list().size()-1;i++)
        {
            System.out.println(DMS_1769.getRequests_version_ID_list().size() +"<--------");
            Assert.assertEquals("",DMS_1769.getRequests_version_ID_list().get(i).getText().trim());
        }

    }

    @And("Verify if Rejected status is selected document versions should be blank")
    public void verifyIfRejectedStatusIsSelectedDocumentVersionsShouldBeBlank()
    {
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible()){
            for (int i=0;i<=DMS_1769.getRequests_version_ID_list().size()-1;i++)
            {
                System.out.println(DMS_1769.getRequests_version_ID_list().size() +"<--------");
                Assert.assertEquals("",DMS_1769.getRequests_version_ID_list().get(i).getText().trim());
            }
        }
    }


    @And("Verify if Pending status is selected Reviewed BY should be blank")
    public void verifyIfPendingStatusIsSelectedReviewedBYShouldBeBlank()
    {
        for (int i=0;i<=DMS_1769.getRequests_Reviewed_BY_list() .size()-1;i++)
        {
            System.out.println(DMS_1769.getRequests_Reviewed_BY_list().size() +"<--------");
            Assert.assertEquals("",DMS_1769.getRequests_Reviewed_BY_list().get(i).getText().trim());
        }
    }

    @And("Verify if Approved status is selected verify document version ID")
    public void verifyIfApprovedStatusIsSelectedVerifyDocumentVersionID()
    {
        DMS_1769.verify_version_ID_format();
    }

    @And("Verify if Approved status is selected verify Reviewed BY column")
    public void verifyIfApprovedStatusIsSelectedVerifyReviewedBYColumn()
    {
        DMS_1769.verify_email_ID_format();
    }

    @And("Verify if Rejected status is selected verify Reviewed BY")
    public void verifyIfRejectedStatusIsSelectedVerifyReviewedBY()
    {
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible()){
            DMS_1769.verify_email_ID_format();
        }
        else
        {
            System.out.println("Records not found on listing screen");
        }
    }


    @And("Click on the Approval Access Request and select status pending")
    public void clickOnTheApprovalAccessRequestAndSelectStatusPending(List<String> status_filters)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getNavigation_btn().click();
        Assert.assertTrue(As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().isEnabled());
        As_a_UserIShouldBeAbleToViewNewRolesAsPerTheDocumentTypePageObject.getDocument_tab().click();
        Assert.assertTrue(DMS_1769.getApproval_request_tab() .isEnabled());
        DMS_1769.getApproval_request_tab().click();
        Assert.assertTrue(DMS_1769.getSelect_status_input().isEnabled());
        DMS_1769.check_enter_filter_and_results_should_be_same(status_filters);
    }


    @And("Verify request id format")
    public void verifyRequestIdFormat()
    {
        DMS_1769.verify_version_ID_format();
    }
}
