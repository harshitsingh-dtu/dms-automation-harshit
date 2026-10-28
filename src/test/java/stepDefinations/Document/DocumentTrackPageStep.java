package stepDefinations.Document;

import PageObjects.Documents.DocumentPageObject;
import PageObjects.Documents.DocumentTrackPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;

import java.time.Duration;

public class DocumentTrackPageStep extends PageObject {
    DocumentTrackPageObject documentTrackPageObject;
    DocumentPageObject documentPageObject;
    @Given("User will go to Document screen")
    public void user_will_go_to_document_screen()
    {
        documentPageObject.clickMenuButton();
        documentPageObject.clickDocumentTab();
        documentPageObject.verifyDocumentText();
        documentPageObject.unselectShowOnlyLatestVersion();
    }
    @Then("User will search the document to be track")
    public void user_will_search_the_document_to_be_track(DataTable table) {
        documentTrackPageObject.searchDocument(table);
    }
    @Then("User will be click on track icon from track status column for the document")
    public void user_will_be_click_on_track_icon_from_track_status_column_for_the_document() {
        documentTrackPageObject.click_Track();
    }
    @Then("User is able to verify the current status of the document")
    public void user_is_able_to_verify_the_current_status_of_the_document() {
        documentTrackPageObject.verify_TrackStatus();
    }
}