package stepDefinations.ApiStepDefs;

import Mapper.API.ApiIntegrationMapper;
import Utilities.DocumentMapping;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.util.List;

@Slf4j
public class ApiCall extends PageObject {
    ApiIntegrationMapper apiIntegration = new ApiIntegrationMapper();
    DocumentMapping fileObj = new DocumentMapping();

    @When("User creates a document through API")
    public void apiPostCall(DataTable table) throws IOException {
        apiIntegration.createDocPostCall(table);
    }
    @When("User creates a document framework through API")
    public void apiPostCall_DF(DataTable table) throws IOException {
        apiIntegration.createDFPostCall(table);
    }
    @When("User gets the document details through API")
    public void apiGetCall(DataTable table) throws IOException {
        apiIntegration.getDocumentAPIcall(table);
    }
    @When("User deletes the document created through API")
    public void apiDeleteCall() throws IOException {
        apiIntegration.deleteDocumentAPIcall();
    }
    @When("User rights data into the file")
    public void writeDataIntoFile(List<String> testID) throws IOException {
        fileObj.writeConfigFile(testID);
        fileObj.readConfigFile();
    }
    @When("User adds immediate enforcement rules via API for 4way Document or Document Framework")
    public void immediateEnforcementRules_4wayDoc() throws IOException {
        apiIntegration.immEnforcementRule_4way();
    }
    @When("User adds General Terms via API for 4way Document")
    public void generalTerms_4wayDoc() throws IOException {
        apiIntegration.generalTerms_4way();
    }
    @When("User adds LimitScope via API for Document or Document Framework")
    public void addLimitScope_4wayDoc() throws IOException {
        apiIntegration.LimitScope_4way();
    }
    @When("User adds immediate enforcement rules via API for DN Document or Document Framework")
    public void immediateEnforcementRules() throws IOException {
        apiIntegration.immEnforcementRule_DN();
    }
    @When("User adds General Terms via API for DN Document Framework")
    public void generalTerms() throws IOException {
        apiIntegration.generalTerms_DN();
    }
    @When("User adds Cash and Non-Cash LimitScope via API for Document or Document Framework")
    public void DN_LimitScope2() throws IOException {
        apiIntegration.Add_Cash_Non_cash_Limit_lines();
    }
}