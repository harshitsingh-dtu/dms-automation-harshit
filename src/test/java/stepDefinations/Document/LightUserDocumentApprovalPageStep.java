package stepDefinations.Document;

import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import java.util.List;


public class LightUserDocumentApprovalPageStep extends PageObject {
    DocumentPageObject documentPageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;

    @Then("User is able to create a Document with Lite User as Participants")
    public void user_is_able_to_create_a_document_with_lite_user_as_participants(DataTable table) {
        documentCreateNewPageObject.user_select_document_type(table);
        documentCreateNewPageObject.user_select_acting_as(table);
        documentCreateNewPageObject.clickSelectPartiesAsPB1(table);
        documentCreateNewPageObject.clickSelectPartiesAsClient1(table);
        documentCreateNewPageObject.clickSelectPartiesAsPB2(table);
        documentCreateNewPageObject.clickSelectPartiesAsClient2(table);
        documentCreateNewPageObject.clickNextbtn();
    }
    @Then("User is able to approve the document with approval workflow with Lite User")
    public void user_is_able_to_approve_the_document_with_approval_workflow_with_lite_user() {
        documentCreateNewPageObject.clickSelectApprovalWorkflow();
    }
    @Then("Now user will enter email in email pop up for lite user.")
    public void now_user_will_enter_email_in_email_pop_up_for_lite_user(DataTable table) {
        documentCreateNewPageObject.validate_EmailPopup(table);
    }
    @Then("User will fetch the link from Email")
    public void user_will_fetch_the_link_from_email() {
    }
    @Then("click on Approve or Reject button")
    public void click_on_approve_or_reject_button() {
    }
    @Then("User will fetch the OTP from mail")
    public void user_will_fetch_the_otp_from_mail() {
    }

}