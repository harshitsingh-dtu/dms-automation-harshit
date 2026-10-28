package stepDefinations.Document;

import PageObjects.Documents.DocumentCreateNewPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import java.util.Arrays;
import java.time.Duration;

@Slf4j
public class DMGS_8827_AgreementStepDefs extends PageObject {

    DocumentCreateNewPageObject docCreatePage;

    @And("User validates the concurrent agreement warning message for {string} state")
    public void validateConcurrentAgreementWarning(String versionState) {
        // Retrieve the version ID captured during the first agreement creation
        String storedVersionID = Serenity.sessionVariableCalled("STORED_VERSION_ID");
        
        if (storedVersionID == null || storedVersionID.isEmpty()) {
            log.error("STORED_VERSION_ID is null or empty.");
            Assert.fail("Test Failure: No Document Version ID captured for comparison.");
        }

        // Construct the expected warning message as per DMGS-8827 requirement
        // Requirement: "A [version state] version of this agreement already exists: [document version ID]. A new version cannot be created."
        String expectedMessage = String.format("A %s version of this agreement already exists: %s. A new version cannot be created.", 
                                                versionState, storedVersionID);
        
        // Handle case where state is 'In-approval' which might be 'An' instead of 'A'
        if (versionState.equalsIgnoreCase("In-approval")) {
             expectedMessage = String.format("An %s version of this agreement already exists: %s. A new version cannot be created.", 
                                                versionState, storedVersionID);
        }

        log.info("Expected Warning Message: " + expectedMessage);
        
        DataTable dataTable = DataTable.create(Arrays.asList(Arrays.asList(expectedMessage)));
        boolean isDisplayed = docCreatePage.validateWarningPopupMessage(dataTable);
        
        Assert.assertTrue("The expected concurrent agreement warning message was not displayed.\nExpected: " + expectedMessage, isDisplayed);
    }

    @And("User validates that the next screen is displayed without warning")
    public void validateNextScreenWithoutWarning() {
        // Next screen should have Auth Scope or Approval Workflow tab visible
        boolean isTabVisible = docCreatePage.getAuthScope_tab().withTimeoutOf(Duration.ofSeconds(10)).isVisible() || 
                               docCreatePage.getApprovalWorkflow_btn().isVisible();
        
        Assert.assertTrue("The next screen was not displayed or a warning blocked progress.", isTabVisible);
        log.info("Successfully navigated to next screen without warning.");
    }
    
    @And("User captures the document version ID")
    public void captureDocID() {
        docCreatePage.captureDocumentVersionID();
    }
}
