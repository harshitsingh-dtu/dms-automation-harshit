package stepDefinations;

import PageObjects.query;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

@Slf4j
public class DBStepDefs extends PageObject {

    query dbQuery;

    @Given("User executes the database query {string}")
    public void user_executes_the_database_query(String sqlQuery) {
        log.info("Executing query from feature file: " + sqlQuery);
        List<Map<String, Object>> results = dbQuery.fetchData(sqlQuery);
        Serenity.setSessionVariable("db_results").to(results);
    }

    @Given("User executes the following database query:")
    public void user_executes_the_following_database_query(String sqlQuery) {
        log.info("Executing multi-line query from feature file: " + sqlQuery);
        List<Map<String, Object>> results = dbQuery.fetchData(sqlQuery);
        Serenity.setSessionVariable("db_results").to(results);
    }

    @Given("User fetches data from {string} with the following filters:")
    public List<Map<String, Object>> user_fetches_data_from_table_with_filters(String tableName, Map<String, String> filters) {
        StringBuilder queryStr = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
        int i = 0;
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            queryStr.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            if (++i < filters.size()) {
                queryStr.append(" AND ");
            }
        }
        log.info("Constructed dynamic query: " + queryStr.toString());
        List<Map<String, Object>> results = dbQuery.fetchData(queryStr.toString());
        Serenity.setSessionVariable("db_results").to(results);
        
        if (results != null && !results.isEmpty()) {
            Serenity.setSessionVariable("last_db_row").to(results.get(0));
            log.info("Stored first row in 'last_db_row' session variable.");
        } else {
            log.warn("No results found for query: " + queryStr.toString());
        }
        return results;
    }

}
