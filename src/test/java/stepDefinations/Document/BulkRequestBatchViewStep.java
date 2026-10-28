package stepDefinations.Document;
import PageObjects.Documents.BulkRequestBatchViewPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class BulkRequestBatchViewStep extends PageObject {
    BulkRequestBatchViewPageObject bulkRequestBatchViewPageObject;
    @Given("User is able to reach the Bulk Request Batch screen")
    public void user_is_able_to_reach_the_bulk_request_batch_screen(){
        bulkRequestBatchViewPageObject.navigatetobulkrequestscreen();
    }

    @Then("user is able to search using Batch id")
    public void user_is_able_to_search_using_batch_id(DataTable batchid) {
        bulkRequestBatchViewPageObject.searchBatchid(batchid);
    }

    @And("user can set filter by selecting document initiator")
    public void user_can_set_filter_by_selecting_document_initiator(DataTable table) {
        bulkRequestBatchViewPageObject.typeintofilter_documentinitiator(table);
    }

    @And("^user can set filter by selecting document action$")
    public void user_can_set_filter_by_selecting_document_action(DataTable table) {
        bulkRequestBatchViewPageObject.typeintofilter_documentaction(table);
    }

    @And("^all the columns related to batch information is visible on screen$")
    public void all_the_columns_related_to_batch_information_is_visible_on_screen() {
        bulkRequestBatchViewPageObject.checkifcolumnsvisible();
    }
    @When("^user will search the batch id and set the filters$")
    public void user_will_search_the_batch_id_and_set_the_filters(DataTable table) {
        bulkRequestBatchViewPageObject.typeintofilter_documentinitiator(table);
        bulkRequestBatchViewPageObject.typeintofilter_documentaction(table);
        bulkRequestBatchViewPageObject.checkifcolumnsvisible();
    }

    @Then("^user can see the batch status$")
    public void user_can_see_the_batch_status()  {

    }
    @Then("^Batch status is updated to completed after scheduler runs$")
    public void batch_status_is_updated_to_completed_after_scheduler_runs(){

    }

    @And("^Batch status is submitted$")
    public void batch_status_is_submitted(){

    }
    @Then("^No of entries on batch view screen will not exceed more than 10$")
    public void no_of_entries_on_batch_view_screen_will_not_exceed_more_than_10(){

    }
    @And("^in process should be zero$")
    public void inprocess_should_be_zero() {

    }
    @And("^user should be able to see batch requests under in process$")
    public void user_should_be_able_to_see_batch_requests_under_inprocess(){

    }

}