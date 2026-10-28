package stepDefinations.Document;

import PageObjects.Documents.DocumentPageObject;
import PageObjects.Documents.BasicFilteringPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
public class BasicFilteringStep extends PageObject {
    DocumentPageObject documentPageObject;
    BasicFilteringPageObject basicFilteringPageObject;

    @Then("^User can see Allowed currency filter$")
    public void user_can_see_allowed_currency_filter(){
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",basicFilteringPageObject.getFilter_allowedcurrency());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(basicFilteringPageObject.getFilter_allowedcurrency().isDisplayed());
    }

    @And("^User can see Document type filter$")
    public void user_can_see_document_type_filter() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",basicFilteringPageObject.getFilter_documenttype());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(basicFilteringPageObject.getFilter_documenttype().isDisplayed());
    }

    @And("^User can see Document initiator filter$")
    public void user_can_see_document_initiator_filter()  {
        Assert.assertTrue(basicFilteringPageObject.getFilter_documentinitiator().isVisible());
    }

    @And("^User can see the status filter$")
    public void user_can_see_the_status_filter()  {
        Assert.assertTrue(basicFilteringPageObject.getFilter_document_status().isVisible());
    }

    @And("^User can see Document actions filter$")
    public void user_can_see_document_actions_filter()  {
        Assert.assertTrue(basicFilteringPageObject.getFilter_documentactions().isVisible());
    }
//    @Then("^User can see status filter$")
//    public void user_can_see_status_filter()  {
//
//    }

    @And("^User is able to type into Allowed currency filter$")
    public void user_is_able_to_type_into_allowed_currency_filter(DataTable datatable) {
        basicFilteringPageObject.check_if_filterAllowedcurrency_and_type(datatable);
    }

    @And("^User is validates the Allowed currency filter values$")
    public void validates_allowed_currency_filter_values() {
        Assert.assertTrue(basicFilteringPageObject.allowed_currency_values());
    }

    @And("^User is able to type into Document type filter$")
    public void user_is_able_to_type_into_document_type_filter(DataTable datatable) {
        basicFilteringPageObject.check_if_filterDocumenttype_and_type(datatable);
    }

    @Then("If user enter partial input user should get Output accordingly")
    public void if_user_enter_partial_input_user_should_get_result_accordingly(DataTable dataTable)
    {
        basicFilteringPageObject.Check_doc_type_input_box_case_sensitivity(dataTable);

    }

    @And("^User is able to type into Document initiator filter$")
    public void user_is_able_to_type_into_document_initiator_filter(DataTable datatable){
        basicFilteringPageObject.check_if_filterDocumentinitiator_and_type(datatable);
    }

    @Then("^User is able to type into status filter$")
    public void user_is_able_to_type_into_status_filter(DataTable datatable) {
        documentPageObject.check_if_filterStatus_and_type(datatable);
    }

    @And("^User is able to type into Document actions filter$")
    public void user_is_able_to_type_into_document_actions_filter(DataTable datatable) {
        basicFilteringPageObject.check_if_filterDocumentactions_and_type(datatable);
    }

}