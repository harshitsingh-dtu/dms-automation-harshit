package PageObjects;

import Utilities.ConfigFileReader;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class query extends PageObject {

    ConfigFileReader configFileReader = new ConfigFileReader();

    /**
     * Fetches data from the database using the provided SQL query.
     * Configuration is read from serenity.conf (db.url, db.user, db.password).
     *
     * @param sqlQuery The SQL query to execute.
     * @return A list of maps, where each map represents a row (column name -> value).
     */
    public List<Map<String, Object>> fetchData(String sqlQuery) {
        List<Map<String, Object>> results = new ArrayList<>();
        
        // Reading credentials from serenity.conf via your existing Utility
        String url = configFileReader.getDataFromConfigFile("db.url");
        String user = configFileReader.getDataFromConfigFile("db.user");
        String password = configFileReader.getDataFromConfigFile("db.password");

        log.info("Connecting to database: " + url);
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlQuery)) {

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = rs.getObject(i);
                        row.put(columnName, columnValue);
                    }
                    results.add(row);
                }
                log.info("Successfully fetched " + results.size() + " rows from the database.");
            }
        } catch (ClassNotFoundException e) {
            log.error("PostgreSQL JDBC Driver not found. Ensure it's in pom.xml", e);
        } catch (SQLException e) {
            log.error("Database error: " + e.getMessage());
            // You can choose to throw an exception here if you want the test to fail immediately
        }
        return results;
    }
    /**
     * Executes a PostgreSQL stored procedure (CALL statement).
     * Used for document cleanup/reset operations.
     *
     * @param procedureCall The full CALL statement as a string.
     */
    public void executeStoredProcedure(String procedureCall) {
        String url      = configFileReader.getDataFromConfigFile("db.url");
        String user     = configFileReader.getDataFromConfigFile("db.user");
        String password = configFileReader.getDataFromConfigFile("db.password");

        log.info("Executing stored procedure: " + procedureCall);
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt  = conn.createStatement()) {
                stmt.execute(procedureCall);
                log.info("Stored procedure executed successfully.");
            }
        } catch (ClassNotFoundException e) {
            log.error("PostgreSQL JDBC Driver not found.", e);
            throw new RuntimeException("JDBC Driver not found", e);
        } catch (SQLException e) {
            log.error("SQL error during procedure execution: " + e.getMessage(), e);
            throw new RuntimeException("Stored procedure execution failed: " + e.getMessage(), e);
        }
    }
}
