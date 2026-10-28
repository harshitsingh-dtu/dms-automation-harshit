package PageObjects.APIs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
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
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class ApiIntegrationPageObject extends PageObject {

    private static final String WEB_HOST;
    private static final String REST_HOST;
    private static final String CREATE_DOCUMENT;
    private static final String GET_DOCUMENT;
    private static final String GENERIC_DOCUMENT;
    private static final String AUTH_Token_API;
    private static final String USER_ROLES;
    private static final String GET_DOC_VERSIONID;
    private static final String USERID;
    private static final String GET_LIMIT_SCOPE;
    private static final String CREATE_DOCUMENT_FRAMEWORK;
    private static final String USERNAME;

    // Per-document-type initiator IDs, read from serenity.conf (initiator.id.df / .dn / .4way)
    private static final String INITIATOR_ID_DF;
    private static final String INITIATOR_ID_DN;
    private static final String INITIATOR_ID_4WAY;

    // 4-Way payloads carry this documentTypeId; DN/DF share a different one.
    // Used to tell DN apart from 4-Way when both flow through createDocumentAPIcall().
    private static final String DOC_TYPE_ID_4WAY = "4dcb345e-4611-4a3c-931f-b5325c3df722";

    final OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    static{
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        WEB_HOST = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");

        REST_HOST = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.url");

        USERID = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("userID");

        USERNAME = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("username");

        USER_ROLES = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.userRoles");

        AUTH_Token_API = WEB_HOST+ EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("authTokenAPI");

        CREATE_DOCUMENT = WEB_HOST + EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("createDocument");

        CREATE_DOCUMENT_FRAMEWORK = WEB_HOST + EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("Create_DocumentFramework");

        GET_DOCUMENT = REST_HOST + EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("DocumentVersionId");

        GENERIC_DOCUMENT = WEB_HOST + EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("GenericDocument");

        GET_DOC_VERSIONID = REST_HOST + EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("DocumentVersionId");

        GET_LIMIT_SCOPE = WEB_HOST + EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("limitScope");

        INITIATOR_ID_DF = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("initiator.id.df");

        INITIATOR_ID_DN = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("initiator.id.dn");

        INITIATOR_ID_4WAY = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("initiator.id.4way");

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
        return getAPIBody(jsonPath, null);
    }

    /**
     * Builds the request body from a JSON test-data file.
     * If the payload contains an "initiatorId" field, it is overridden with the
     * environment-specific value from serenity.conf rather than the hardcoded
     * value baked into the JSON test-data file.
     *
     * @param jsonPath           path to the JSON test-data file (or a raw documentVersionId)
     * @param initiatorIdOverride explicit initiator id to use (e.g. DF calls always pass
     *                            INITIATOR_ID_DF). Pass null to auto-detect DN vs 4-Way
     *                            based on the payload's documentTypeId.
     */
    public  RequestBody getAPIBody(String jsonPath, String initiatorIdOverride) throws IOException {
        MediaType mediaType = MediaType.get("application/json");
        if(jsonPath.startsWith("src/")) {
            InputStream is = Files.newInputStream(Paths.get(jsonPath));
            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
            JSONObject jObj = new JSONObject(jsonTxt);

            if (jObj.has("initiatorId")) {
                String idToUse = initiatorIdOverride;

                // No explicit override supplied (i.e. this is a DN/4-Way call via
                // createDocumentAPIcall) -> auto-detect from documentTypeId in the payload
                if (idToUse == null) {
                    String docTypeId = jObj.optString("documentTypeId", "");
                    idToUse = DOC_TYPE_ID_4WAY.equals(docTypeId) ? INITIATOR_ID_4WAY : INITIATOR_ID_DN;
                }
                jObj.put("initiatorId", idToUse);
            }

            return RequestBody.create(jObj.toString(), mediaType);
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

    public String  generateAuthToken() throws IOException {
        String email= USERNAME.toLowerCase();
        Request request = new Request.Builder()
                .url(AUTH_Token_API+email)
//                    .post(getAPIBody("src/test/java/resources/AuthTokenGeneration.json"))
                .addHeader("Content-Type", "application/json")  // Add another header
                .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                .build();

        Response response = client.newCall(request).execute();
        //Reading json response
        AuthTokenPOJO AuthToken = gson.fromJson(response.body().string(), AuthTokenPOJO.class);
        System.out.println("Auth Token : ---- "+AuthToken.getAuthToken());
        return AuthToken.getAuthToken();
    }

    public Response createDocumentAPIcall(DataTable jsonPath) throws IOException {
        try{List<String> json = jsonPath.asList(String.class);
            String jsonPathValue= json.get(1);
            Request request = new Request.Builder()
                    .url(CREATE_DOCUMENT)
                    .post(getAPIBody(jsonPathValue))
                    .addHeader("Authorization","Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
                    .addHeader("Userroles", USER_ROLES)
                    // .addHeader("Cookie", getCookies())
                    .build();
            return client.newCall(request).execute();
        }
        catch (Exception e)
        {
            log.info("Exception occured :" +e);
            return null;
        }

    }

    public Response createDocumentFrameworkAPIcall(DataTable jsonPath) throws IOException {
        try{List<String> json = jsonPath.asList(String.class);
            String jsonPathValue= json.get(1);
            Request request = new Request.Builder()
                    .url(CREATE_DOCUMENT_FRAMEWORK)
                    .post(getAPIBody(jsonPathValue, INITIATOR_ID_DF))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();
            System.out.println("Response Body: " + USER_ROLES);
            return client.newCall(request).execute();
        }
        catch (Exception e)
        {
            log.info("Exception occured :" +e);
            return null;
        }

    }

    //Need to check the feasibility
    public Response getDocumentAPIcall(DataTable docVersionID) throws IOException {
        List<String> json = docVersionID.asList(String.class);
        String jsonPathValue= json.get(1);

        Request request = new Request.Builder()
                .url(GET_DOC_VERSIONID)
                .post(getAPIBody(jsonPathValue))
                .addHeader("Authorization", generateAuthToken())  // Add header
                .addHeader("Content-Type", "application/json")  // Add another header
                .addHeader("Userroles", USER_ROLES)
//                .addHeader("Cookie", getCookies())
                .build();

        return client.newCall(request).execute();
    }

    public Response deleteDocumentAPIcall(String docID,String docVersionID) throws IOException {
        try {
            String url = GENERIC_DOCUMENT+docID+"?versionId="+docVersionID+"&userId="+USERID;

            Request request = new Request.Builder()
                    .url(url)
                    .put(getAPIBody("resources/DocDeletion_DN.json"))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Response immediateEnforcementRule_4way(String docID,String docVersionID) throws IOException {
        try {
            String url = GENERIC_DOCUMENT+docID+"?versionId="+docVersionID+"&userId=undefined";

            Request request = new Request.Builder()
                    .url(url)
                    .put(getAPIBody("src/test/java/resources/4way_ImmediateEnforcementRules.json"))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Response generalTerms_4way(String docID,String docVersionID) throws IOException {
        try {
            String url = GENERIC_DOCUMENT+docID+"?versionId="+docVersionID+"&userId=undefined";

            Request request = new Request.Builder()
                    .url(url)
                    .put(getAPIBody("src/test/java/resources/4way_GeneralTerms.json"))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
//                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Response LimitScope_4way(String docID,String docVersionID) throws IOException {
        try {
            String url = GET_LIMIT_SCOPE+docID+"/"+docVersionID;

            Request request = new Request.Builder()
                    .url(url)
                    .post(getAPIBody("src/test/java/resources/4way_LimitScope.json"))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
//                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }public Response immediateEnforcementRule_DN(String docID,String docVersionID) throws IOException {
        try {
            String url = GENERIC_DOCUMENT+docID+"?versionId="+docVersionID+"&userId=undefined";

            Request request = new Request.Builder()
                    .url(url)
                    .put(getAPIBody("src/test/java/resources/4way_ImmediateEnforcementRules.json"))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
//                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Response generalTerms_DN(String docID,String docVersionID) throws IOException {
        try {
            String url = GENERIC_DOCUMENT+docID+"?versionId="+docVersionID+"&userId=undefined";
            Request request = new Request.Builder()
                    .url(url)
                    .put(getAPIBody("src/test/java/resources/DN_GeneralTerms.json"))
                    .addHeader("Authorization", "Bearer "+generateAuthToken())  // Add header
                    .addHeader("Content-Type", "application/json")  // Add another header
//                    .addHeader("Userroles", USER_ROLES)
//                    .addHeader("Cookie", getCookies())
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Response Limit_Scope_Cash_Non_cash(String docID, String docVersionID) throws IOException {
        try {
            String url = GET_LIMIT_SCOPE + docID + "/" + docVersionID;

            Request request = new Request.Builder()
                    .url(url)
                    .post(getAPIBody("src/test/java/resources/DN_LimitScope2.json"))
                    .addHeader("Authorization", "Bearer " + generateAuthToken())
                    .addHeader("Content-Type", "application/json")
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
