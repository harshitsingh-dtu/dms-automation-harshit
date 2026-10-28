package stepDefinations.DocumentFramework;

import PageObjects.DocumentFrameworkPageObject.DocumentCountPageObject;
import PageObjects.DocumentFrameworkPageObject.DocumentFrameworkPageObject;
import PageObjects.Documents.DocumentPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

public class DocumentCountNewStep extends PageObject {

    DocumentCountPageObject documentCountPageObject;
    @Then("User clicks on doc count")
    public void userClicksOnDocCount() {
       documentCountPageObject.userClicksOnDocCount();
    }

    @Then("Validate user reach to associated document listing screen")
    public void validateUserReachToAssociatedDocumentListingScreen() {
        documentCountPageObject.associatedDrawer();
    }

    @Then("Validate user click on close & return to document framework screen")
    public void validateUserClickOnCloseReturnToDocumentFrameworkScreen() {
        documentCountPageObject.evaluateJavascript("arguments[0].click();", documentCountPageObject.getCloseButton());
    }

    @Then("Validate document ID & version ID search box in Associated Document")
    public void validateDocumentIDVersionIDSearchBoxInAssociatedDocument() {
        documentCountPageObject.checkDocIDAndVersion();
    }

    @Then("Validate document ID & version ID search box in Associated Document on DF")
    public void validateDocumentIDVersionIDSearchBoxInAssociatedDocumentonDF() {
        documentCountPageObject.checkDocIDAndVersionDFDoc();
    }

    @And("User clicks on document version then associated document")
    public void userClicksOnDocumentVersionThenAssociatedDocument() {
        documentCountPageObject.getVersionID().click();
        documentCountPageObject.getAssociatedDN().waitUntilVisible().click();

    }

    @And("User clicks on document version then associated document for draft DF")
    public void userClicksOnDocumentVersionThenAssociatedDocumentdraftDF() {
        documentCountPageObject.getVersionID().click();
        documentCountPageObject.getAssociatedDN().shouldNotBeVisible();
//        documentCountPageObject.getAssociatedDN().waitUntilVisible().click();
    }

    @And("User Click on edit icon then submit button")
    public void userClickOnEditIconThenSubmitButton() {
        documentCountPageObject.getEditicon().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        documentCountPageObject.getSubmitButton().waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @And("User Click on edit icon then select acting as")
    public void userClickOnEditIconThenSelectActingAs() {
        documentCountPageObject.getEditicon().click();
        documentCountPageObject.selectActing();

    }
    @And("User click on submit button on DF")
    public void userClickOnSubmitButtonOnDF() {
        documentCountPageObject.getSubmitButton().waitUntilClickable().click();
//        documentCountPageObject.getAssociatedDN().waitUntilVisible().click();
    }
    @And("Check document framework life cycle status")
    public void checkDocumentFrameworkLifeCycleStatus() {
        documentCountPageObject.lifeCycleStatus();

    }

    @Then("User close associated doc for draft document framework")
    public void userCloseAssociatedDocForDraftDocumentFramework() {
        documentCountPageObject.getCloseButton().click();
        documentCountPageObject.getCancelButton().waitUntilVisible().click();


    }

}