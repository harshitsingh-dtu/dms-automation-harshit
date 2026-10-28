package stepDefinations.ApprovalMatrix;

import PageObjects.Approval.ApprovalMatrixCreatePageObject;
import PageObjects.Approval.ApprovalMatrixPageObject;
import PageObjects.Approval.ApprovalMatrixUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Slf4j
public class ApprovalMatrixUpdateStep extends PageObject {
    ApprovalMatrixUpdatePageObject approvalMatrixUpdatePageObject;
    ApprovalMatrixCreatePageObject approvalMatrixCreatePageObject;
    ApprovalMatrixPageObject approvalMatrixPageObject;

    @Then("user clicks on the update button")
    public void user_clicks_on_the_update_button() {
        approvalMatrixPageObject.clickupdatebtn();
    }
    @Then("User click on seqential sequence")
    public void user_clicks_on_the_sequential_button() {
        approvalMatrixPageObject.clicksequenctialbtn();
    }

    @When("^User validates the org type and clicks on Update button$")
    public void user_validate_OrgType(List<String> approvalMatrix)  {
        approvalMatrixPageObject.searchAndValidateOrgType(approvalMatrix);
    }

    @When("^user validates the update approval matrix screen$")
    public void user_validate_Update_Approval_matrix()  {
        approvalMatrixPageObject.getUpdateApprovalMatrix().withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        Assert.assertTrue(approvalMatrixPageObject.getUpdateApprovalMatrix().isVisible());
    }
    @When("^user validates the approval matrix screen$")
    public void user_validate_Approval_matrix()  {
        Assert.assertTrue(approvalMatrixPageObject.getApprovalMatrixScreen().waitUntilVisible().isVisible());
    }
    @When("^user will click on submit button on Approval matrix Confirmation screen$")
    public void click_Submit_button()  {
        Assert.assertTrue(approvalMatrixPageObject.getSubmitButton_Matrix().waitUntilVisible().isVisible());
        approvalMatrixPageObject.getSubmitButton_Matrix().click();
    }
    @When("^user validates the Approval group warning message$")
    public void user_validate_approvalGroupWarningMessage()  {
        Assert.assertTrue(approvalMatrixPageObject.getApprovalGroupWarningMessage().isVisible());
    }

    @Then("^User validates the approval matrix information$")
    public void user_validates_approval_matrix_information(DataTable table) {
        Assert.assertTrue(approvalMatrixUpdatePageObject.getOrganisation_name().isVisible());
        Assert.assertTrue(approvalMatrixUpdatePageObject.getLEI_name().isVisible());
        Assert.assertTrue(approvalMatrixUpdatePageObject.getOrgtype_name().isVisible());
        Assert.assertTrue(approvalMatrixUpdatePageObject.getDoctype_name().isVisible());
        Assert.assertTrue(approvalMatrixUpdatePageObject.validateApprovalMatrixInfo(table));
    }

    @And("^User validates the document action dropdown$")
    public void user_validate_document_action_dropdown() {
        Assert.assertTrue(approvalMatrixUpdatePageObject.getDocumentAction_filter_txt().isVisible());
    }

    @Then("user will select document action and approval groups")
    public void user_will_select_document_action_and_approval_groups(DataTable table){
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        approvalMatrixUpdatePageObject.DocumentActionandapprovalgroup(table);
    }

    @Then("user ensures {string} column is added in Approval Matrix")
    public void user_ensures_sequence_column_is_added(String sequenceLabel){
        approvalMatrixUpdatePageObject.ensureSequenceColumnExists(sequenceLabel);
    }
    @And("user selects the Sequential approval order if not already selected")
    public void userSelectsSequentialApprovalOrder() {
        approvalMatrixUpdatePageObject.selectSequentialRadioIfNotSelected();
    }

    @Then("user will select document action and approval groups on DF")
    public void user_will_select_document_action_and_approval_groups_on_DF(DataTable table){
        approvalMatrixUpdatePageObject.DocumentActionandapprovalgroupUpdate(table);
    }

    @Then("user will select document action and update the approval groups")
    public void user_will_select_document_action_and_update_the_approval_groups(DataTable table){
        approvalMatrixUpdatePageObject.DocumentActionandapprovalgroupUpdate(table);
    }

    @Then("user will select document action and update the approval groups in approval matrix")
    public void user_will_select_document_action_and_update_the_approval_groups_in_approval_matrix(DataTable table){
        approvalMatrixUpdatePageObject.DocumentActionandapprovalgroupUpdateAgain(table);
    }

    @And("user reaches on the update screen of the approval matrix")
    public void user_reaches_on_the_update_screen_of_the_approval_matrix() {
        Assert.assertTrue(approvalMatrixUpdatePageObject.getUpdate_approval_matrix_header_text().isVisible());

    }

    @And("user will click on Submit button of confirmation pop-up")
    public void confirmation_Submit_popUp() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getConfirmation_submit_btn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
    @And("user will click on Confirm button of confirmation pop-up")
    public void confirmation_Confirm_popUp() {
        Assert.assertTrue(approvalMatrixUpdatePageObject.getRenameConfirmationConfirmBtn().waitUntilVisible().isVisible());
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getRenameConfirmationConfirmBtn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @And("User validates for the updated Approval group name in Approval matrix")
    public void user_validates_the_approval_GroupName(String ApprovalGroupName) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approvalMatrixUpdatePageObject.getApprovalGroupName());
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getApprovalGroupName());
        approvalMatrixUpdatePageObject.getApprovalGroupName().sendKeys(Keys.BACK_SPACE,ApprovalGroupName);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertEquals(ApprovalGroupName,approvalMatrixUpdatePageObject.getDropDownList().getText());
    }
    @Then("Add a deleted approval group in approval matrix to check whether it is still present")
    public void user_will_select_document_action_and_for_deleted_approval_groups(DataTable table) {
        approvalMatrixUpdatePageObject.DocumentActionAndDeletedApprovalgroup(table);
    }

    @And("user will click on Apply All button")
    public void userWillClickOnApplyAllButton() {
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getApply_all_button());

    }

    @Then("user validate that approval group has been selected for all the action type")
    public void userValidateThatApprovalGroupHasBeenSelectedForAllTheActionType(DataTable table) {
        approvalMatrixUpdatePageObject.Apply_All_Approval_group(table);
    }

    @Then("user clears the approval groups to reset data")
    public void userClearsTheApprovalGroupsToResetData(DataTable table) {
        approvalMatrixUpdatePageObject.clearApprovalGroups(table);
    }

    @And("user click on Sequential checkbox")
    public void userClickOnSequentialCheckbox() {
        approvalMatrixUpdatePageObject.getSequential_radioBox().waitUntilPresent();
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getSequential_radioBox());
    }

    @And("User click on confirm button")
    public void userClickOnConfirmButton() {
        Assert.assertTrue(approvalMatrixUpdatePageObject.getConfirm_button().waitUntilVisible().isVisible());
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getConfirm_button());
    }    @And("^User validates Submit button is disabled$")
    public void user_validates_submit_button_is_disabled() {
        approvalMatrixUpdatePageObject.getSubmit_btn().waitUntilVisible();
        // This allows the JS on the page a few seconds to finish its logic
        waitForCondition().until(driver ->
                !approvalMatrixUpdatePageObject.getSubmit_btn().isEnabled()
        );
        Assert.assertFalse("The Submit button is expected to be disabled, but it was enabled.",
                approvalMatrixUpdatePageObject.getSubmit_btn().isEnabled());
    }

    @Then("^user conditionally configures approval group \"([^\"]*)\" for all action types if not already selected$")
    public void user_conditionally_configures_approval_group_if_not_selected(String groupName, DataTable table) {
        log.info("Starting conditional check for approval group in matrix: " + groupName);
        
        // Step 1: Read expectations from DataTable and verify if the matrix is already correctly configured
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        boolean isAllConfigured = true;
        
        // Resolve group name if needed
        String resolvedGroup = PageObjects.Approval.ApprovalgroupCreatePageObject.getGeneratedGroupName(groupName.trim());
        if (resolvedGroup != null) {
            groupName = resolvedGroup;
        } else {
            groupName = groupName.trim();
        }
        
        for (Map<String, String> row : rows) {
            String actionName = row.get("Document Action");
            String xpath = "//td[normalize-space()='" + actionName + "']/following-sibling::td//input";
            try {
                // Scroll label into view to ensure element is rendered
                String labelXpath = "//td[normalize-space()='" + actionName + "']";
                WebElement labelElement = getDriver().findElement(By.xpath(labelXpath));
                evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", labelElement);
                withAction().pause(Duration.ofMillis(200)).build().perform();
                
                WebElementFacade el = find(By.xpath(xpath));
                String actualGroup = el.getAttribute("value").trim();
                if (!actualGroup.equalsIgnoreCase(groupName)) {
                    isAllConfigured = false;
                    log.info("Mismatch found for action '" + actionName + "'. Expected: '" + groupName + "', Actual: '" + actualGroup + "'");
                    break;
                }
            } catch (Exception e) {
                isAllConfigured = false;
                log.info("Action row or input for '" + actionName + "' not visible/found. Configuring matrix.");
                break;
            }
        }
        
        if (isAllConfigured) {
            log.info("Approval Matrix is ALREADY configured with approval group '" + groupName + "' for all actions. Navigating back to listing screen...");
            approvalMatrixPageObject.navigateToApprovalMatrixListingScreen();
            return;
        }
        
        log.info("Approval Matrix is NOT fully configured. Initiating configuration steps...");
        
        // Step 2: Perform configuration steps
        // Click sequence column if needed
        String action = "New Document";
        int targetSequence = 1;
        String rowInputsXpath = "//td[normalize-space()='" + action + "']/parent::tr//input";
        List<WebElementFacade> existingInputs = findAll(By.xpath(rowInputsXpath));

        if (existingInputs.size() < targetSequence) {
            int clicksNeeded = targetSequence - existingInputs.size();
            WebElementFacade AddSequenceColumnButton = approvalMatrixUpdatePageObject.getAddSequenceColumnButton();
            for (int i = 0; i < clicksNeeded; i++) {
                evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", AddSequenceColumnButton);
                AddSequenceColumnButton.waitUntilVisible();
                evaluateJavascript("arguments[0].click();", AddSequenceColumnButton);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }

        WebElementFacade inputField = find(By.xpath("(//td[normalize-space()='" + action + "']/parent::tr//input)[" + targetSequence + "]"));
        evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", inputField);

        withAction().moveToElement(inputField).pause(Duration.ofMillis(500)).perform();
        String clearBtnXpath = "(//td[normalize-space()='" + action + "']/parent::tr//button[@title='Clear'])[" + targetSequence + "]";
        List<WebElementFacade> clearButtons = findAll(By.xpath(clearBtnXpath));

        if (!clearButtons.isEmpty() && clearButtons.get(0).isCurrentlyVisible()) {
            evaluateJavascript("arguments[0].click();", clearButtons.get(0));
            withAction().pause(Duration.ofMillis(500)).build().perform();
        } else {
            inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        }

        withAction().click(inputField)
                .pause(Duration.ofMillis(500))
                .sendKeys(groupName)
                .pause(Duration.ofSeconds(2))
                .build().perform();

        String exactOptionXpath = "//li[@role='option' and normalize-space()='" + groupName + "']";
        List<WebElementFacade> exactOptions = findAll(By.xpath(exactOptionXpath));
        if (!exactOptions.isEmpty()) {
            evaluateJavascript("arguments[0].click();", exactOptions.get(0));
        } else {
            log.error("No exact-match option found in dropdown for group: '" + groupName + "'. Falling back to first available.");
            List<WebElementFacade> anyOptions = findAll(By.xpath("//li[@role='option']"));
            Assert.assertFalse("No approval group options rendered for input: " + groupName, anyOptions.isEmpty());
            evaluateJavascript("arguments[0].click();", anyOptions.get(0));
        }

        // Click Apply All button
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getApply_all_button());
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        // Click Submit Button on the update screen
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getSubmit_btn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        // Click Submit button on confirmation pop-up
        evaluateJavascript("arguments[0].click();", approvalMatrixUpdatePageObject.getConfirmation_submit_btn());
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        log.info("Approval Matrix configuration successfully updated in main window.");
    }
}