package PageObjects.Documents;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Data
public class DocumentTrackPageObject extends PageObject {
    //@FindBy(xpath = "//th[normalize-space()='Version ID']//input[@placeholder='Search']")
    //private WebElementFacade document_id;

    @FindBy(xpath="//th[@data-testid='doc-table-th-documentVersionId' or normalize-space()='Document version ID']//input[@placeholder='Search']")
    private WebElementFacade document_id;
    @FindBy(xpath = "//div[normalize-space()='Track']")
    private WebElementFacade track_text;
    @FindBy(xpath="//span[@class='status']")
    private WebElementFacade track_status;
    @FindBy(xpath="$")
    private WebElementFacade notFound_text;
    public void searchDocument(DataTable DocumentName) {
        List<Map<String, String>> data = DocumentName.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            document_id.waitUntilVisible();
            typeInto(document_id, dataTable.get("Document Version ID"));
        } catch (Exception e) {
            log.error("Unable to input Document ID-->" + e);
            Assert.fail();
        }
    }
    public void click_Track() {
        try{
            track_text.waitUntilVisible().click();
        } catch (Exception e) {
            log.error("Unable to click Track-->" + e);
            Assert.fail();
        }
    }
    public void verify_TrackStatus() {
        try {
            if (track_status.waitUntilPresent().isVisible()){
                Serenity.reportThat("Document status is " + track_status.getText(),
                        () -> Assert.assertTrue(track_status.isVisible()));
                log.info("Successfully able to track the status");
            }
            else {
                Assert.assertTrue(notFound_text.getText().trim().equalsIgnoreCase("no record found"));
            }
        }catch (Exception e) {
            log.error("Unable to verify Track status-->" + e);
            Assert.fail();
        }
    }
}