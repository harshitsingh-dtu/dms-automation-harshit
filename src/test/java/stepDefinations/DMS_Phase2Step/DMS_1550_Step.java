package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1525_PageObject;
 import PageObjects.DMS_PHASE2PageObject.DMS_1550_PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

import java.util.List;

public class DMS_1550_Step extends PageObject
{
    DMS_1550_PageObject DMS_1550;
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;

    @And("Assign at least one LEI with four way document type")
    public void assignAtLeastOneLEIWithFourWayDocumentType()
    {
        DMS_1550.Assign_LEI_with_4W_doc_type();
    }

    @And("Verify list of Four Way document should displayed")
    public void verifyListOfFourWayDocumentShouldDisplayed(DataTable dataTable)
    {
        Assert.assertFalse(Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible());
        DMS_1550.ColumnAndColumnValueCheck(dataTable);

    }


    @And("Verify Approve and Reject button should NOT be visible on listing screen")
    public void verifyApproveAndRejectButtonShouldNOTBeVisibleOnListingScreen()
    {
        Assert.assertTrue(DMS_1550.getReject_button_All_document_listing_screen().isVisible());
        Assert.assertTrue(DMS_1550.getApprove_button_All_document_listing_screen().isVisible());
    }

    @And("Verify Terminate button should NOT be visible on listing screen")
    public void verifyTerminateButtonShouldNOTBeVisibleOnListingScreen()
    {
        Assert.assertFalse(DMS_1550.getTerminate_button_All_document_listing_screen().isVisible());
    }

    @And("Verify Terminate button should be visible on listing screen")
    public void verifyTerminateButtonShouldBeVisibleOnListingScreen()
    {
        Assert.assertTrue(DMS_1550.getTerminate_button_All_document_listing_screen().isVisible());

    }

    @And("Verify if DN is selected from doc type filter No Record msg should be displayed")
    public void verifyIfDNIsSelectedFromDocTypeFilterNoRecordMsgShouldBeDisplayed(List<String> doc_type)
    {
        DMS_1550.select_doc_type(doc_type);
        Assert.assertTrue(Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible());

    }

    @And("Verify if Document status filter In_approval is set No Record msg should be displayed")
    public void verifyIfDocumentStatusFilterIn_approvalIsSetNoRecordMsgShouldBeDisplayed(List<String> doc_status)
    {
        DMS_1550.select_doc_status(doc_status);
        Assert.assertEquals("No options".toLowerCase(),DMS_1550.getDocument_Type_result().getText().toLowerCase());
    }

    @And("click on Document status filter set document status")
    public void clickOnDocumentStatusFilterSetDocumentStatus(List<String> Document_Status)
    {
        Validation_of_Document_Listing_screen_for_Doc.select_doc_status(Document_Status);
    }

    @And("Verify Edit Terminate Download buttons should be visible on listing screen")
    public void verifyEditTerminateDownloadButtonsShouldBeVisibleOnListingScreen()
    {
        if (!Validation_of_Document_Listing_screen_for_Doc.getNo_record_found_msg().isVisible())
        {
            Assert.assertTrue(DMS_1550.getTerminate_Button().isEnabled());
            Assert.assertTrue(DMS_1550.getDownload_Button().isEnabled());
            Assert.assertTrue(DMS_1550.getDocument_edit_btn().isEnabled());

        }
    }

    @And("Verify Download button should be visible for all document")
    public void verifyDowloadButtonShouldBeVisibleForAllDocument()
    {
        Assert.assertEquals(DMS_1550.getList_of_docs_on_listing_screen().size(),DMS_1550.getList_of_Download_btn_on_listing_screen().size());

    }
    @And("Verify edit button should not visible for document")
    public void verifyEditButtonShouldNotVisibleForDocument()
    {
        Assert.assertFalse(DMS_1550.getEdit_btn_on_listing_screen().isVisible());

    }

    @And("Verify delete button is visible for all document")
    public void verifyDeleteButtonIsVisibleForAllDocument()
    {
        Assert.assertEquals(DMS_1550.getList_of_docs_on_listing_screen().size(),DMS_1550.getList_of_Delete_btn_on_listing_screen().size());

    }

    @And("Verify delete button should not visible for document")
    public void verifyDeleteButtonShouldNotVisibleForDocument()
    {
        Assert.assertFalse(DMS_1550.getDelete_btn_on_listing_screen().isVisible());

    }

    @And("Verify Terminate button is visible for all document")
    public void verifyTerminateButtonIsVisibleForAllDocument()
    {
        Assert.assertEquals(DMS_1550.getList_of_docs_on_listing_screen().size(),DMS_1550.getList_of_Terminate_btn_on_listing_screen().size());
    }
}
