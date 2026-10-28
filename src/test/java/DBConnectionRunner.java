import PageObjects.query;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class DBConnectionRunner {

    @Test
    public void testSpecificQuery() {
        query dbQuery = new query();
        String sql = "select * from odc_doc.approval_agreement where agreement_id='AG-8826325'";
        System.out.println("Executing specific query: " + sql);
        
        List<Map<String, Object>> result = dbQuery.fetchData(sql);
        
        if (result != null && !result.isEmpty()) {
            Map<String, Object> dataMap = result.get(0);
            System.out.println("--- QUERY RESULT START ---");
            for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("--- QUERY RESULT END ---");
        } else {
            System.out.println("No data found or connection failed.");
        }
    }
}
