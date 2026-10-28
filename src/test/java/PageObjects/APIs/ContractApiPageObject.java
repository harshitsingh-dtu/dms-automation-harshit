package PageObjects.APIs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.ibm.icu.impl.Assert.fail;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class ContractApiPageObject extends PageObject {

    private static final String CONTRACT_BASE_URL;
    private static final String TOKEN_ENDPOINT;
    private static final String FETCHINGUSERDETAILS_ENDPOINT;
    private static final String CRDS_CLIENTID;
    private static final String CRDS_CLIENTSECRET;
    private static final String JIGSAW_CLIENTID;
    private static final String JIGSAW_CLIENTSECRET;
    private static final String GRANT_TYPE;
    private static final String JIGSAW_ENDPOINT;
    private static final String FETCHINGUSERDETAILSBYMULTIPLEIDS_ENDPOINT;
    private static final String FETCHINGUSERDETAILSVIASEARCH_ENDPOINT;

    private ObjectMapper objectMapper = new ObjectMapper(); // Jackson's main object
//    JsonNode rootNode;

    final OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    static{
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        CONTRACT_BASE_URL = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("contract.base.url");

        TOKEN_ENDPOINT = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("token.endPoint");

        FETCHINGUSERDETAILS_ENDPOINT = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("fetchingUserDetails.endPoint");

        CRDS_CLIENTID = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("crds.client.id");

        CRDS_CLIENTSECRET = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("crds.client.secret");

        JIGSAW_CLIENTID = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("jigsaw.client.id");

        JIGSAW_CLIENTSECRET = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("jigsaw.client.secret");

        GRANT_TYPE = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("grant.type");

        JIGSAW_ENDPOINT = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("jigsaw.endpoint");

        FETCHINGUSERDETAILSBYMULTIPLEIDS_ENDPOINT = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("fetchingUserDetailsByMultipleIds.endPoint");

        FETCHINGUSERDETAILSVIASEARCH_ENDPOINT = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("fetchingUserDetailsViaSearch.endPoint");

    }

    public static String jsonToString(String jsonTxt){
        JSONObject jObj = new JSONObject(jsonTxt);
        return jObj.toString();
    }

    public static String jsonArrayToString(String jsonTxt){
        JSONArray jArray = new JSONArray(jsonTxt);
        return jArray.toString();
    }
    public static String getCookies() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/test/java/resources/cookies.json"));
        return jsonNode.get("Cookies").toString();
    }

    public  RequestBody getAPIBody(String jsonPath) throws IOException {
        MediaType mediaType = MediaType.get("application/json");
        if(jsonPath.startsWith("src/")) {
            InputStream is = Files.newInputStream(Paths.get(jsonPath));
            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
            String jsonData = jsonToString(jsonTxt);
            return RequestBody.create(jsonData, mediaType);
        }
        else {
            String jsonData = "{documentVersionId: \""+jsonPath+"\"}";
            return RequestBody.create(jsonData, mediaType);
        }
    }

    public  RequestBody getAPIArrayBody(String jsonPath) throws IOException {
            MediaType mediaType = MediaType.get("application/json");
            InputStream is = Files.newInputStream(Paths.get(jsonPath));
            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
            String jsonData = jsonArrayToString(jsonTxt);
            return RequestBody.create(jsonData, mediaType);
    }

    public String getToken(String env){
        Response response = null;
        switch (env.toUpperCase()) {
            case "CRDS" :
                response = given()
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .formParam("client_id", CRDS_CLIENTID)
                        .formParam("client_secret", CRDS_CLIENTSECRET)
                        .formParam("grant_type", GRANT_TYPE)
                        .when()
                        .post(CONTRACT_BASE_URL+TOKEN_ENDPOINT);
                response.then().statusCode(200);
                break;

            case "JIGSAW" :
                response = given()
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .formParam("client_id", JIGSAW_CLIENTID)
                        .formParam("client_secret", JIGSAW_CLIENTSECRET)
                        .formParam("grant_type", GRANT_TYPE)
                        .when()
                        .post(CONTRACT_BASE_URL+TOKEN_ENDPOINT);
                response.then().statusCode(200);
                break;
        }

        return response.jsonPath().getString("access_token");
    }

    public Response fetchUserFromEmail(String email, String env) throws IOException {
        Response response;
        RequestSpecification request;
        String token = getToken(env);
        System.out.println("My Token:- " + token);
        request = given()
                .formParam("emailId", email)
                .baseUri(CONTRACT_BASE_URL+FETCHINGUSERDETAILS_ENDPOINT)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token);

        response = request.when().get();
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        return response;
    }

    public Response fetchUserFromJigsaw(String env) throws IOException {
        Response response;
        RequestSpecification request;
        String token = getToken(env);
        System.out.println("My Token:- " + token);
        Map<String, Object> dataRequest = new HashMap<>();
        dataRequest.put("query", "SELECT lei,osttra_lei_name FROM CustomerReferenceData.gleifLeiDataView");
        dataRequest.put("pageSize", 30);

        // 2. Create the main request body Map
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("dataRequest", dataRequest);
        request = given()
                .baseUri(CONTRACT_BASE_URL+JIGSAW_ENDPOINT)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody);

        response = request.when().post();
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        return response;
    }

    public Response fetchUserFromId(String id, String env) throws IOException {
        Response response;
        RequestSpecification request;
        String token = getToken(env);
        System.out.println("My Token:- " + token);
        request = given()
                .formParam("id", id)
                .baseUri(CONTRACT_BASE_URL+FETCHINGUSERDETAILS_ENDPOINT)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token);

        response = request.when().get();
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        return response;
    }

    public Response fetchUserFromIds(String env, List<String> ids) throws IOException {
        Response response;
        RequestSpecification request;
        String token = getToken(env);
        request = given()
                .baseUri(CONTRACT_BASE_URL + FETCHINGUSERDETAILSBYMULTIPLEIDS_ENDPOINT)
                .header("Authorization", "Bearer " + token);

        Iterator<String> str = ids.iterator();
        str.next();
        while (str.hasNext()){
            request.queryParam("id", str.next());
        }

        request.log().all().when().post();

        response = request.when().get();
        System.out.println("My Token:- " + token);
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        return response;
    }

    public Response fetchUserFromListingFilter(String emailFilter, String env) throws IOException {
        Response response;
        RequestSpecification request;
        String token = getToken(env);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("page", 0);
        requestBody.put("pageSize", 25);
        requestBody.put("sortBy", "");
        requestBody.put("sortOrder", "");
        Map<String, Object> filterModelMap = new HashMap<>();
        Map<String, Object> emailIdMap = new HashMap<>();
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("type", "contains");
        conditionMap.put("filter", emailFilter);
        List<Map<String, String>> conditionsList = Arrays.asList(conditionMap);
        emailIdMap.put("conditions", conditionsList);
        emailIdMap.put("operator", "AND");
        filterModelMap.put("emailId", emailIdMap);
        requestBody.put("filterModel", filterModelMap);

        request = given()
                .baseUri(CONTRACT_BASE_URL + FETCHINGUSERDETAILSVIASEARCH_ENDPOINT)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .header("x-apigee-request-id", "1234")
                .body(requestBody);
        System.out.println("Base URI: " + CONTRACT_BASE_URL + FETCHINGUSERDETAILSVIASEARCH_ENDPOINT);
        response = request.when().post();
        System.out.println("My Token:- " + token);
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        return response;
    }

    public void validateJsonKeyAndItsType(Response response, String key, String dataType){

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(response.asString());
        } catch (Exception e) {
            fail("Failed to parse JSON response: " + e.getMessage());
            return; // Exit if parsing fails
        }
        if (key.contains("[*]")) {
            String[] parts = key.split("\\[\\*\\]\\.?");
            String basePath = parts[0];
            String subPath = (parts.length > 1) ? parts[1] : "";

            // 2. Find the array node
            JsonNode arrayNode = rootNode.at(convertPathToJsonPointer(basePath));
            assertTrue("Path " + basePath + " did not point to an array.", arrayNode.isArray());

            // 3. Iterate through the array and validate the type of each element's sub-path
            for (JsonNode element : (ArrayNode) arrayNode) {
                JsonNode finalNode = subPath.isEmpty() ? element : element.at(convertPathToJsonPointer(subPath));
                validateNodeType(finalNode, dataType, key);
            }
        } else if (key.startsWith("*.")) {
            String subPath = key.substring(2);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                JsonNode finalNode = element.at(convertPathToJsonPointer(subPath));
                validateNodeType(finalNode, dataType, key);
            }
        } else {
            // Handle a single, direct path
            JsonNode finalNode = rootNode.at(convertPathToJsonPointer(key));
            validateNodeType(finalNode, dataType, key);
        }
    }
    private void validateNodeType(JsonNode node, String expectedType, String path) {
        String errorMsg = "Data type mismatch at path '" + path + "'. Expected " + expectedType + " but found ";

        switch (expectedType.toLowerCase()) {
            case "string":
                assertTrue(errorMsg + node.getNodeType(), node.isTextual());
                break;
            case "number":
                assertTrue(errorMsg + node.getNodeType(), node.isNumber());
                break;
            case "array":
                assertTrue(errorMsg + node.getNodeType(), node.isArray());
                break;
            case "object":
                assertTrue(errorMsg + node.getNodeType(), node.isObject());
                break;
            case "boolean":
                assertTrue(errorMsg + node.getNodeType(), node.isBoolean());
                break;
            case "null":
                assertTrue(errorMsg + node.getNodeType(), node.isNull());
                break;
            default:
                fail("Unsupported data type in feature file: " + expectedType);
                break;
        }
    }

    private String convertPathToJsonPointer(String dotPath) {
        if (dotPath == null || dotPath.isEmpty()) {
            return "";
        }
        return "/" + dotPath.replace('.', '/');
    }
}