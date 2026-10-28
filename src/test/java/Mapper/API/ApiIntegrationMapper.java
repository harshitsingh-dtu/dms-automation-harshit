package Mapper.API;

import PageObjects.APIs.ApiIntegrationPageObject;
import PageObjects.APIs.DocumentPOJO;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import okhttp3.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

@Slf4j
@Data
public class ApiIntegrationMapper extends PageObject {
    Actions act=new Actions(getDriver());
    ApiIntegrationPageObject apiIntegration = new ApiIntegrationPageObject();
    Gson gson = new Gson();
    DocumentPOJO docData = new DocumentPOJO();

    public void createDocPostCall(DataTable table) throws IOException {
        Response response = apiIntegration.createDocumentAPIcall(table);
        //Converting the API response to Json
        docData= gson.fromJson(response.body().string(),DocumentPOJO.class);
        Assert.assertEquals(201,response.code());
    }

    public void createDFPostCall(DataTable table) throws IOException {
        Response response = apiIntegration.createDocumentFrameworkAPIcall(table);
        String responseBody = response.body().string();
        System.out.println("Response Code: " + response.code());
        System.out.println("Response Body: " + responseBody);
        //Converting the API response to Json
        docData= gson.fromJson(responseBody,DocumentPOJO.class);
        Assert.assertEquals(201,response.code());
    }

    public void getDocumentAPIcall(DataTable table) throws IOException {
//        apiIntegration.getDocumentAPIcall(table);
//
//        //Converting the API response to Json
//        DocumentPOJO docData= gson.fromJson(response.body().string(),DocumentPOJO.class);
//        System.out.println("Document version is" + docData.getDocumentVersionId());
//        System.out.println("Document version is" + docData.getDocumentId());
//
//        Assert.assertEquals(200,response.code());

    }
    public void deleteDocumentAPIcall() throws IOException {
        Response response = apiIntegration.deleteDocumentAPIcall(docData.getDocumentId(),docData.getDocumentVersionId());

        //Converting the API response to Json
        System.out.println("response body"+ response.body().string());
        Assert.assertEquals(200,response.code());
        Assert.assertEquals("Document Version Updated",response.body().string());
    }
    public void immEnforcementRule_4way() throws IOException {
        Response response = apiIntegration.immediateEnforcementRule_4way(docData.getDocumentId(),docData.getDocumentVersionId());
        Assert.assertEquals(200,response.code());
    }
    public void generalTerms_4way() throws IOException {
        Response response = apiIntegration.generalTerms_4way(docData.getDocumentId(),docData.getDocumentVersionId());
        Assert.assertEquals(200,response.code());
    }
    public void LimitScope_4way() throws IOException {
        Response response = apiIntegration.LimitScope_4way(docData.getDocumentId(),docData.getDocumentVersionId());
        Assert.assertEquals(200,response.code());
        System.out.println(response.toString());
    }
    public void immEnforcementRule_DN() throws IOException {
        Response response = apiIntegration.immediateEnforcementRule_DN(docData.getDocumentId(),docData.getDocumentVersionId());
        String responseBody = response.body().string();
        System.out.println("Response Code: " + response.code());
        System.out.println("Response Body: " + responseBody);
        Assert.assertEquals(200,response.code());

    }
    public void generalTerms_DN() throws IOException {
        Response response = apiIntegration.generalTerms_DN(docData.getDocumentId(),docData.getDocumentVersionId());
        Assert.assertEquals(200,response.code());
    }

    public void Add_Cash_Non_cash_Limit_lines() throws IOException {
        Response response = apiIntegration.Limit_Scope_Cash_Non_cash(docData.getDocumentId(),docData.getDocumentVersionId());
        Assert.assertEquals(200,response.code());
        System.out.println(response.toString());
    }
}