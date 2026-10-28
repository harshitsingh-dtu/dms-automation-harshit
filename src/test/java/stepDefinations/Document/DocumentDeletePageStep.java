package stepDefinations.Document;

import PageObjects.Documents.DocumentDeletePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class DocumentDeletePageStep extends PageObject {
    DocumentDeletePageObject documentDeletePageObject;
    @Given("User will search the document to be deleted")
    public void user_will_search_the_document_to_be_deleted(DataTable table) {
        documentDeletePageObject.searchDocument(table);
    }
    @Then("User will click on delete icon from action column for the document")
    public void user_will_be_click_on_delete_icon_from_action_column_for_the_document() {
        documentDeletePageObject.clickDeleteBtn();
    }
    @Then("User is able to verify the status of document after deleting")
    public void user_is_able_to_verify_the_status_of_document_after_deleting(DataTable table) {
        documentDeletePageObject.searchDocument(table);
        documentDeletePageObject.verifyDeletedDocument();
    }
    @Then("User Validates Document is deleted Notification")
    public void Document_Deleted_Notification() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(documentDeletePageObject.getDelete_notification().isVisible());
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }
    @Then("User validate that doc status has been changed to terminated")
    public void userValidateThatDocStatusHasBeenChangedToTerminated() {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(documentDeletePageObject.getDocStatus_Terminated().isVisible());
    }

}