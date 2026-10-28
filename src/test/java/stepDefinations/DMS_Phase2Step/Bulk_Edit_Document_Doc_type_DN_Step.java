package stepDefinations.DMS_Phase2Step;

import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import PageObjects.DMS_PHASE2PageObject.Bulk_Edit_Document_Doc_type_DN_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1525_PageObject;

import java.time.Duration;
import java.util.List;

public class Bulk_Edit_Document_Doc_type_DN_Step extends PageObject
{
    Bulk_Edit_Document_Doc_type_DN_PageObject bulkEditDocumentDocTypeDnPageObject;
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;


    @When("User able to see bulk action button")
    public void userAbleToSeeBulkActionButton()
    {
      Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_button().isEnabled());
    }

    @And("Click on Bulk Action button")
    public void clickOnBulkActionButton()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_button().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_button().click();
    }

    @And("Click on the Bulk Action Approve button")
    public void clickOnTheBulkActionApproveButton()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_Approve_btn().isVisible());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_Approve_btn().click();
    }

    @And("user will assign role")
    public void userWillAssignRole(List<String> roles)
    {
        bulkEditDocumentDocTypeDnPageObject.assign_role(roles);
    }


    @And("Click on Submit on role assigning screen")
    public void clickOnSubmitOnRoleAssigningScreen()
    {
        bulkEditDocumentDocTypeDnPageObject.Submit_btn();
    }

    @Then("User is able to see Bulk Actions list Approve,Reject,Edit,Terminate")
    public void userIsAbleToSeeBulkActionsListApproveRejectEditTerminate()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_Approve_btn().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_Reject_btn().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_edit_btn().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_Terminate_approve_btn().isEnabled());
    }

    @And("Verify elements for Bulk Action Approve popup")
    public void verifyElementsForBulkActionApprovePopup()
    {

        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_doc_type_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_acting_as_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_approval_group_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_cancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isVisible());

    }

    @And("Click on the Bulk Action edit button")
    public void clickOnTheBulkActionEditButton()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_edit_btn().isVisible());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_edit_btn().click();
    }

    @And("Verify elements for Bulk Action edit popup")
    public void verifyElementsForBulkActionEditPopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_doc_type_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_acting_as_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_action_type_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_cancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isVisible());
    }

    @And("Click on the Bulk Action Reject button")
    public void clickOnTheBulkActionRejectButton()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_Reject_btn().isVisible());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_Reject_btn().click();
    }

    @And("Verify elements for Bulk Action Reject popup")
    public void verifyElementsForBulkActionRejectPopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_doc_type_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_acting_as_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_approval_group_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_cancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isVisible());
    }

    @And("Click on the Bulk Action Terminate button")
    public void clickOnTheBulkActionTerminateButton()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_Terminate_btn().isVisible());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_Terminate_btn().click();
    }

    @And("Verify elements for Bulk Action Terminate popup")
    public void verifyElementsForBulkActionTerminatePopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_doc_type_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_acting_as_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_action_type_input().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_cancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isVisible());
    }


    @And("Assign at least one LEI with DN document type")
    public void assignAtLeastOneLEIWithDNDocumentType()
    {
        bulkEditDocumentDocTypeDnPageObject.Assign_LEI_with_DN_doc_type();

    }

    @And("Select Acting As on popup")
    public void selectActingAsOnPopup()
    {
        bulkEditDocumentDocTypeDnPageObject.Select_acting_as();
    }



    @And("Click on next button for Bulk Action Terminate popup")
    public void clickOnNextButtonForBulkActionTerminatePopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();

    }

    @And("Select document type DN on Terminate popup")
    public void selectDocumentTypeDNOnTerminatePopup()
    {
        bulkEditDocumentDocTypeDnPageObject.Select_document_type_DN();
    }

    @And("User will select Action type on the terminate popup")
    public void userWillSelectActionTypeOnTheTerminatePopup(List<String>action_type)
    {
        bulkEditDocumentDocTypeDnPageObject.Select_action_type(action_type);
    }

    @And("Verify elements Approve bulk action")
    public void verifyElementsApproveBulkAction(List<String> columns_list)
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getColumns_selection_button().isVisible());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getSelect_all_checkbox().isVisible());
        bulkEditDocumentDocTypeDnPageObject.check_columns_selection_list(columns_list);
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getList_of_doc_for_bulk_action().isVisible());
        }
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getCancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getApprove_button().isVisible());

    }

    @And("Verify elements for Terminate bulk action")
    public void verifyElementsForTerminateBulkAction(List<String> columns_list)
    {
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getColumns_selection_button().isVisible());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getSelect_all_checkbox().isVisible());
        bulkEditDocumentDocTypeDnPageObject.check_columns_selection_list(columns_list);
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getList_of_doc_for_bulk_action().isVisible());
        }
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getCancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getTerminate_button().isVisible());

    }

    @And("Select document type DN Approve on popup")
    public void selectDocumentTypeDNApproveOnPopup()
    {
        bulkEditDocumentDocTypeDnPageObject.Select_document_type_DN();
    }

    @And("Click on next button for Bulk Action Approve popup")
    public void clickOnNextButtonForBulkActionApprovePopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().click();

    }

    @And("Select Approval group on popup")
    public void selectApprovalGroupOnPopup()
    {
        try {
            bulkEditDocumentDocTypeDnPageObject.Select_Approval_group();
        }
        catch (Exception e){
                bulkEditDocumentDocTypeDnPageObject.Fail_msg();
                Assert.fail();
        }

    }

    @And("Select document type DN Reject on popup")
    public void selectDocumentTypeDNRejectOnPopup()
    {
        bulkEditDocumentDocTypeDnPageObject.Select_document_type_DN();
    }

    @And("Click on next button for Bulk Action Reject popup")
    public void clickOnNextButtonForBulkActionRejectPopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().click();

    }

    @And("Verify elements Reject bulk action")
    public void verifyElementsRejectBulkAction(List<String> columns_list)
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getColumns_selection_button().isVisible());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getSelect_all_checkbox().isVisible());
        bulkEditDocumentDocTypeDnPageObject.check_columns_selection_list(columns_list);
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getList_of_doc_for_bulk_action().isVisible());
        }
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getCancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getReject_button().isVisible());

    }

    @And("Select document type DN edit on popup")
    public void selectDocumentTypeDNEditOnPopup()
    {
        bulkEditDocumentDocTypeDnPageObject.Select_document_type_DN();
    }

    @And("Select action type on popup")
    public void selectActionTypeOnPopup(List<String>action_type)
    {
        bulkEditDocumentDocTypeDnPageObject.Select_action_type(action_type);
    }

    @And("Click on submit button on edit popup")
    public void clickOnSubmitButtonOnEditPopup()
    {
        bulkEditDocumentDocTypeDnPageObject.getSubmit_btn().click();
    }

    @And("Click on next button for Bulk Action edit popup")
    public void clickOnNextButtonForBulkActionEditPopup()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getBulk_action_popup_next_button().click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
    }

    @And("Verify elements for edit bulk action")
    public void verifyElementsForEditBulkAction(List<String> columns_list)
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getColumns_selection_button().isVisible());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getSelect_all_checkbox().isVisible());
        bulkEditDocumentDocTypeDnPageObject.check_columns_selection_list(columns_list);
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getList_of_doc_for_bulk_action().isVisible());
        }
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getCancel_button().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getNext_button().isVisible());

    }

    @And("Click on Approve button")
    public void clickOnApproveButton()
    {
        if (bulkEditDocumentDocTypeDnPageObject.getApprove_button().isEnabled())
        {
            bulkEditDocumentDocTypeDnPageObject.getApprove_button().click();
        }
    }

    @And("Click on the Check box for the documents that needs to be Approve")
    public void clickOnTheCheckBoxForTheDocumentsThatNeedsToBeApprove()
    {
//        if doc is present take doc id select that doc id
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
           bulkEditDocumentDocTypeDnPageObject.select_document_for_bulk_action();
        }
        else {
            bulkEditDocumentDocTypeDnPageObject.Fail_msg();
            Assert.fail();
        }

    }

    @And("Click on Reject button")
    public void clickOnRejectButton()
    {
        if (bulkEditDocumentDocTypeDnPageObject.getReject_button().isEnabled())
        {
            bulkEditDocumentDocTypeDnPageObject.getReject_button().click();
        }
    }

    @And("Click on Terminate button")
    public void clickOnTerminateButton()
    {
        if (bulkEditDocumentDocTypeDnPageObject.getTerminate_button().isEnabled())
        {
            bulkEditDocumentDocTypeDnPageObject.getTerminate_button().click();
        }
    }

    @And("Click on the Check box for the documents that needs to be Terminate")
    public void clickOnTheCheckBoxForTheDocumentsThatNeedsToBeTerminate()
    {
        //        if doc is present take doc id select that doc id
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            bulkEditDocumentDocTypeDnPageObject.select_document_for_bulk_action();
        }
        else {
                bulkEditDocumentDocTypeDnPageObject.Fail_msg();
                Assert.fail();

        }
    }

    @And("Click on the Check box for the documents that needs to be Reject")
    public void clickOnTheCheckBoxForTheDocumentsThatNeedsToBeReject()
    {
        //        if doc is present take doc id select that doc id
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            bulkEditDocumentDocTypeDnPageObject.select_document_for_bulk_action();
        }
        else {
            bulkEditDocumentDocTypeDnPageObject.Fail_msg();
            Assert.fail();
        }

    }

    @And("Click on the Check box for the documents that needs to be edit")
    public void clickOnTheCheckBoxForTheDocumentsThatNeedsToBeEdit()
    {
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        //        if doc is present take doc id select that doc id
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            bulkEditDocumentDocTypeDnPageObject.select_document_for_bulk_action();
        }
        else {
            bulkEditDocumentDocTypeDnPageObject.Fail_msg();
            Assert.fail();
        }

    }

    @And("Click on Next button")
    public void clickOnNextButton()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getNext_button().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getNext_button().click();
    }

    @And("Edit EDIT LIMIT")
    public void editEDITLIMIT()
    {
        bulkEditDocumentDocTypeDnPageObject.getDoc_version_id_on_bulk_action_edit_limit().isVisible();
    }

    @And("Click on Submit for Approval button for bulk action")
    public void clickOnSubmitForApprovalButtonForBulkAction()
    {
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getDoc_version_id_on_bulk_action_edit_limit().isEnabled());
        bulkEditDocumentDocTypeDnPageObject.getDoc_version_id_on_bulk_action_edit_limit().click();
    }
}
