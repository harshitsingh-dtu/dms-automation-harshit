package stepDefinations.ContractApi;

import PageObjects.APIs.ContractApiPageObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.actions.Switch;
import static com.ibm.icu.impl.Assert.fail;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContractAPIStepdefs {
    ContractApiPageObject contractApiPageObject = new ContractApiPageObject();
    private Response responseFromEmail;
    private Response responseFromId;
    private Response responseFromFilter;
    private Response responseFromMultipleId;


    @When("The user is fetched from the email {string} from {string} environment")
    public void theUserIsFetchedFromTheEmail(String email, String env) throws IOException {
        responseFromEmail = contractApiPageObject.fetchUserFromEmail(email, env);
    }

    @When("User fetch lei from Customer Reference Data from {string} environment")
    public void userFetchLeiFromCustomerReferenceDataFromEnvironment(String env) throws IOException {
        Response response = contractApiPageObject.fetchUserFromJigsaw(env);
    }

    @When("The user is fetched from the id {string} from {string} environment")
    public void theUserIsFetchedFromTheIdFromEnvironment(String id, String env) throws IOException {
        responseFromId = contractApiPageObject.fetchUserFromId(id, env);
    }


    @When("The user is fetched from ids from {string} environment")
    public void theUserIsFetchedFromIdsFromEnvironment(String env, List<String> ids) throws IOException {
        responseFromMultipleId = contractApiPageObject.fetchUserFromIds(env, ids);
    }

    @When("The user is fetched by searching filter {string} from {string} environment")
    public void theUserIsFetchedBySearchingEmailIdFilterFromEnvironment(String emailFilter, String env) throws IOException {
        responseFromFilter = contractApiPageObject.fetchUserFromListingFilter(emailFilter, env);
    }

    @Then("The response from {string} should have the following key and datatype")
    public void theJSONPathShouldHaveTheDataType(String response, DataTable dataTable) throws Throwable {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String jsonPath = row.get("jsonPath");
            String dataType = row.get("dataType");

            switch (response.toUpperCase()) {
                case "EMAIL":
                    contractApiPageObject.validateJsonKeyAndItsType(responseFromEmail, jsonPath, dataType);
                    break;
                case "ID":
                    contractApiPageObject.validateJsonKeyAndItsType(responseFromId, jsonPath, dataType);
                    break;
                case "FILTER":
                    contractApiPageObject.validateJsonKeyAndItsType(responseFromFilter, jsonPath, dataType);
                    break;
                case "MULTIPLEID":
                    contractApiPageObject.validateJsonKeyAndItsType(responseFromMultipleId, jsonPath, dataType);
                    break;
                default:
                    // Handle other cases or throw an error if needed.
                    fail("Unsupported response source in step definition: " + response);
            }
        }
    }
}