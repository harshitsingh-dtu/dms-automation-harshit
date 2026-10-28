package stepDefinations.Document;

import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
public class DMGS_9333_NoChangeVersioningStepDefs extends PageObject {

    DocumentCreateNewPageObject docCreatePage;

    @Then("Verify that the document version ID has not changed")
    public void verifyVersionIDHasNotChanged() {
        String previousVersionID = Serenity.sessionVariableCalled("STORED_VERSION_ID");
        if (previousVersionID == null || previousVersionID.isEmpty()) {
            Assert.fail("Test Failure: No captured version ID found in session!");
        }
        
        docCreatePage.waitForCreationScreen();
        String currentVersionID = docCreatePage.getDocVersionID_Edit().getText().trim();
        
        log.info("Previous Version: " + previousVersionID + " | Current Version: " + currentVersionID);
        Assert.assertEquals("The Document Version ID should NOT have changed!", previousVersionID, currentVersionID);
    }

    @Then("Verify that the document version ID has incremented")
    public void verifyVersionIDHasIncremented() {
        String previousVersionID = Serenity.sessionVariableCalled("STORED_VERSION_ID");
        if (previousVersionID == null || previousVersionID.isEmpty()) {
            Assert.fail("Test Failure: No captured version ID found in session!");
        }

        docCreatePage.waitForCreationScreen();
        String currentVersionID = docCreatePage.getDocVersionID_Edit().getText().trim();

        log.info("Previous Version: " + previousVersionID + " | Current Version: " + currentVersionID);
        Assert.assertNotEquals("The Document Version ID should have incremented!", previousVersionID, currentVersionID);
    }
}
