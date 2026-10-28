package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.json.JSONObject;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

@Slf4j
public class DocumentMapping {

    File mappingFile = new File("src/test/java/resources/DocumentMapping.json");
    Properties prop = new Properties();
    public String readConfigFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(mappingFile);
        //Pass the TC ID here to get the document ID
        return jsonNode.get("TC-API").toString();
    }
    public void writeConfigFile(List<String> testID) throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        // write the Testcase & corresponding Document ID here
        map.put(testID.get(1),"123456780");
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, String>>() {}.getType();
        try (FileWriter fileWriter = new FileWriter(mappingFile)) {
            gson.toJson(map, mapType, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
