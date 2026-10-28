package PageObjects.Approval;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Data
public class ApprovalMatrixUpdatePageObject extends PageObject {
    ApprovalMatrixCreatePageObject approvalMatrixCreatePageObject;
    ApprovalMatrixPageObject approvalMatrixPageObject;
    Actions act = new Actions(getDriver());

    @FindBy(xpath = "//div[text()='Organisation name']")
    private WebElementFacade organisation_name;
    @FindBy(xpath = "//div[text()='Organisation name']/following-sibling::div")
    private WebElementFacade orgNameValue;

    @FindBy(xpath = "//div[text()='Legal entity name']")
    private WebElementFacade LEI_name;
    @FindBy(xpath = "//div[text()='Legal entity name']/following-sibling::div")
    private WebElementFacade LEI_Value;

    @FindBy(xpath = "//div[text()='Org type']")
    private WebElementFacade orgtype_name;
    @FindBy(xpath = "//div[text()='Org type']/following-sibling::div")
    private WebElementFacade orgtype_value;

    @FindBy(xpath = "//div[text()='Doc type']")
    private WebElementFacade doctype_name;
    @FindBy(xpath = "//div[text()='Doc type']/following-sibling::div")
    private WebElementFacade doctype_value;

    @FindBy(xpath = "//div[@class='info-label']")
    private List<WebElementFacade> approvalmatrixDetails;

    @FindBy(xpath = "//tr[1]//button[text()='Update']")
    private WebElementFacade update_btn;
    @FindBy(xpath = "//div[text()='Update approval matrix' or text()='Update approval matrices']")
    private WebElementFacade Update_approval_matrix_header_text;
    @FindBy(xpath = "//*[contains(text(),'Document actions')]")
    private WebElementFacade documentAction_filter_txt;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElementFacade cancel_btn;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElementFacade submit_btn;
    @FindBy(xpath = "(//button[normalize-space()='Submit'])[2]")
    private WebElementFacade Confirmation_submit_btn;
    @FindBy(xpath = "//div[contains(@class,'MuiDialog') or @role='presentation']//button[normalize-space()='Confirm']")
    private WebElementFacade RenameConfirmationConfirmBtn;
    @FindBy(xpath = "(//tr[1]//input)[1]")
    private WebElementFacade ApprovalGroupName;
    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade dropDownList;
    @FindBy(xpath = "//button[text()='Apply All']")
    private WebElementFacade Apply_all_button;
    @FindBy(xpath = "//label[.//span[contains(text(),'Sequential')]]")
    private WebElementFacade Sequential_radioBox;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElementFacade Confirm_button;
    @FindBy(xpath = "//button[normalize-space()='+ Add Parallel Column']")
    private WebElementFacade AddNewColumnButton;
    @FindBy(xpath = "//button[normalize-space()='+ Add Sequence Column']")
    private WebElementFacade AddSequenceColumnButton;
    @FindBy(xpath = "//input[@value='SEQUENTIAL']")
    private WebElementFacade sequentialRadioInput;
    @FindBy(xpath = "//label[@data-testid='radio-sequential']")
    private final String ACTION_ROW_DROPDOWN = "//td[normalize-space()='New Document']/following-sibling::td//input";
    private final String Clear_approval_group = "//td[normalize-space()='Edit Approval Workflow']/following-sibling::td//button[@title='Clear']";


    public void DocumentActionandapprovalgroup(DataTable table) {
        Map<String, String> data = table.asMaps(String.class, String.class).get(0);
        String action = data.get("Document Action");
        int targetSequence = Integer.parseInt(data.get("Approval Sequence"));
        String group = data.get("approval groups");

        String resolvedGroup = PageObjects.Approval.ApprovalgroupCreatePageObject.getGeneratedGroupName(group);
        if (resolvedGroup != null) {
            log.info("Resolved '" + group + "' to generated group name: " + resolvedGroup);
            group = resolvedGroup;
        } else {
            log.warn("No generated group found for base name '" + group + "'. Using literal value — this may match multiple stale groups.");
        }

        String rowInputsXpath = "//td[normalize-space()='" + action + "']/parent::tr//input";
        List<WebElementFacade> existingInputs = findAll(By.xpath(rowInputsXpath));

        if (existingInputs.size() < targetSequence) {
            int clicksNeeded = targetSequence - existingInputs.size();
            for (int i = 0; i < clicksNeeded; i++) {
                evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", AddNewColumnButton);
                AddNewColumnButton.waitUntilVisible();
                evaluateJavascript("arguments[0].click();", AddNewColumnButton);
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
                .sendKeys(group)
                .pause(Duration.ofSeconds(2))
                .build().perform();

        String exactOptionXpath = "//li[@role='option' and normalize-space()='" + group + "']";
        List<WebElementFacade> exactOptions = findAll(By.xpath(exactOptionXpath));
        if (!exactOptions.isEmpty()) {
            evaluateJavascript("arguments[0].click();", exactOptions.get(0));
        } else {
            log.error("No exact-match option found in dropdown for group: '" + group + "'. Falling back to first available option.");
            List<WebElementFacade> anyOptions = findAll(By.xpath("//li[@role='option']"));
            Assert.assertFalse("No approval group options rendered for input: " + group, anyOptions.isEmpty());
            evaluateJavascript("arguments[0].click();", anyOptions.get(0));
        }
    }

    public void ensureSequenceColumnExists(String sequenceLabel) {
        String sequenceKey = sequenceLabel.replaceAll("\\s+", "").toLowerCase();
        String sequenceHeaderXpath = "//*[@data-testid='matrix-header-" + sequenceKey + "']";

        boolean alreadyExists = !getDriver().findElements(By.xpath(sequenceHeaderXpath)).isEmpty();

        if (alreadyExists) {
            log.info("'" + sequenceLabel + "' column already exists -- skipping Add Sequence Column click.");
        } else {
            log.info("'" + sequenceLabel + "' column not found -- clicking Add Sequence Column.");
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", AddSequenceColumnButton);
            AddSequenceColumnButton.waitUntilClickable();
            evaluateJavascript("arguments[0].click();", AddSequenceColumnButton);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }

        boolean nowExists = !getDriver().findElements(By.xpath(sequenceHeaderXpath)).isEmpty();
        Assert.assertTrue("'" + sequenceLabel + "' column was not present and could not be added.", nowExists);
    }

    private WebElementFacade sequentialRadioLabel;
    public void selectSequentialRadioIfNotSelected() {
        WebElementFacade dynamicSequentialLabel = find(By.xpath("//label[@data-testid='radio-sequential']"));
        dynamicSequentialLabel.waitUntilVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", dynamicSequentialLabel);
        withAction().pause(Duration.ofMillis(500)).build().perform();
        boolean isSelected = !dynamicSequentialLabel.findElements(By.xpath(".//span[contains(@class, 'Mui-checked')]")).isEmpty();
        if (!isSelected) {
            log.info("Sequential radio button is not selected. Clicking to select it.");
            try {
                dynamicSequentialLabel.waitUntilClickable().click();
            } catch (Exception e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", dynamicSequentialLabel);
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            try {
                if (Confirm_button.withTimeoutOf(Duration.ofSeconds(3)).isCurrentlyVisible()) {
                    log.info("Confirmation pop-up appeared. Clicking Confirm.");
                    Confirm_button.waitUntilClickable().click();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                }
            } catch (Exception e) {
                log.info("No confirmation pop-up appeared after clicking Sequential.");
            }
            boolean isSelectedAfter = !dynamicSequentialLabel.findElements(By.xpath(".//span[contains(@class, 'Mui-checked')]")).isEmpty();
            Assert.assertTrue("Failed to select Sequential radio button", isSelectedAfter);
            log.info("Successfully selected Sequential radio button.");
        } else {
            log.info("Sequential radio button is already selected. No action taken.");
        }
    }

    public void DocumentActionandapprovalgroupUpdate(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> rowData : data) {
            String action = rowData.get("Document Action");
            int targetSequence = Integer.parseInt(rowData.get("Approval Sequence"));
            String group = rowData.get("approval groups");

            String resolvedGroup = PageObjects.Approval.ApprovalgroupCreatePageObject.getGeneratedGroupName(group);
            if (resolvedGroup != null) {
                log.info("Resolved '" + group + "' to generated group name: " + resolvedGroup);
                group = resolvedGroup;
            } else {
                String storedGroupName = net.serenitybdd.core.Serenity.sessionVariableCalled("STORED_APPROVAL_GROUP_NAME");
                if (storedGroupName != null && !storedGroupName.isEmpty() && (group.equalsIgnoreCase("AUTO_GENERATED") || storedGroupName.startsWith(group))) {
                    log.info("Using stored approval group name: " + storedGroupName);
                    group = storedGroupName;
                } else {
                    log.warn("No generated group found for base name '" + group + "'. Using literal value.");
                }
            }
            String rowInputsXpath = "//td[normalize-space()='" + action + "']/parent::tr//input";
            List<WebElementFacade> existingInputs = findAll(By.xpath(rowInputsXpath));
            if (existingInputs.size() < targetSequence) {
                int clicksNeeded = targetSequence - existingInputs.size();
                for (int i = 0; i < clicksNeeded; i++) {
                    evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", AddNewColumnButton);
                    AddNewColumnButton.waitUntilVisible();
                    evaluateJavascript("arguments[0].click();", AddNewColumnButton);
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
                    .sendKeys(group)
                    .pause(Duration.ofSeconds(2))
                    .build().perform();
            String exactOptionXpath = "//li[@role='option' and normalize-space()='" + group + "']";
            List<WebElementFacade> exactOptions = findAll(By.xpath(exactOptionXpath));

            if (!exactOptions.isEmpty()) {
                evaluateJavascript("arguments[0].click();", exactOptions.get(0));
                log.info("Successfully selected exact match for: " + group + " on row: " + action);
            } else {
                log.error("No exact-match option found in dropdown for group: '" + group + "'. Falling back to first available option.");
                List<WebElementFacade> anyOptions = findAll(By.xpath("//li[@role='option']"));
                Assert.assertFalse("No approval group options rendered for input: " + group, anyOptions.isEmpty());
                evaluateJavascript("arguments[0].click();", anyOptions.get(0));
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
    }

    public void DocumentActionandapprovalgroupUpdateAgain(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> rowData : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(rowData);
            String actionLabel = dataTable.get("Document Action");
            String inputXpath = "//table[@class='matrix-table']/tbody/tr/td[text()='" + actionLabel + "']/..//input";
            WebElement inputField = getDriver().findElement(By.xpath(inputXpath));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", inputField);
            evaluateJavascript("arguments[0].click();", inputField);
            String popperXpath = "//div[@role='presentation' and contains(@class, 'MuiAutocomplete-popper')]";
            waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(popperXpath)));
            List<WebElement> options = getDriver().findElements(By.xpath(popperXpath + "//li[@role='option']"));
            if (!options.isEmpty()) {
                WebElement lastOption = options.get(options.size() - 1);
                evaluateJavascript("arguments[0].click();", lastOption);
                System.out.println("Selected last option for: " + actionLabel);
            } else {
                System.out.println("No options found in the dropdown!");
            }
        }
    }


    public void removeApprovalgroup() {
        try {
            //   //tr//td[1][text()='Edit Enforcement Rules']//following-sibling::td//div//span[text()='test_auto14:27:00.615839700']
        } catch (Exception e) {

        }
    }

    public boolean validateApprovalMatrixInfo(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        if (orgNameValue.getText().equalsIgnoreCase(dataTable.get("Organisation name"))) {
            doctype_value.getText().equalsIgnoreCase(dataTable.get("Doc type"));
            LEI_Value.getText().equalsIgnoreCase(dataTable.get("Legal entity name"));
            orgtype_value.getText().equalsIgnoreCase(dataTable.get("Org type"));
            return true;
        } else {
            return false;
        }
    }

    public void DocumentActionAndDeletedApprovalgroup(DataTable table) {
        Map<String, String> dataTable = table.asMaps(String.class, String.class).get(0);
        WebElement documentActionElement = getDriver().findElement(
                By.xpath("//*[text()='" + dataTable.get("Document Action") + "']")
        );
        getJavascriptExecutorFacade()
                .executeScript("arguments[0].scrollIntoView({ block: 'center' });", documentActionElement);
        evaluateJavascript("arguments[0].click();", documentActionElement);
        WebElement approvalDropdown = getDriver().findElement(
                By.xpath("(//*[text()='" + dataTable.get("Document Action") + "']//..//input)["
                        + dataTable.get("Approval Sequence") + "]")
        );
        evaluateJavascript("arguments[0].click();", approvalDropdown);
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        List<WebElement> approvalGroupElements = getDriver().findElements(
                By.xpath("//li[normalize-space()='" + dataTable.get("approval groups") + "']")
        );
        if (!approvalGroupElements.isEmpty()) {
            throw new AssertionError(
                    "Deleted approval group '" + dataTable.get("approval groups")
                            + "' is STILL present in the approval matrix dropdown"
            );
        }
    }

    public void Apply_All_Approval_group(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String actionName = row.get("Document Action");
            String expectedGroup = row.get("Expected Approval Group");
            String action_type_dynamicXpath = String.format(ACTION_ROW_DROPDOWN, actionName);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            WebElementFacade inputElement = find(By.xpath(action_type_dynamicXpath));
            String actualGroup = inputElement.getAttribute("value").trim();
            Assert.assertEquals("Mismatch found for " + actionName, expectedGroup, actualGroup);
        }
    }

    public void clearApprovalGroups(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String actionName = row.get("Document Action");

            String inputXpath = String.format("//td[normalize-space()='%s']/following-sibling::td[1]//input", actionName);
            String clearBtnXpath = String.format("//td[normalize-space()='%s']/following-sibling::td[1]//button[@title='Clear']", actionName);

            WebElementFacade inputField = find(By.xpath(inputXpath));

            withAction().moveToElement(inputField).build().perform();
            waitABit(200);

            WebElementFacade clearButton = find(By.xpath(clearBtnXpath));

            if (clearButton.isPresent()) {
                evaluateJavascript("arguments[0].click();", clearButton);
                inputField.sendKeys(Keys.ESCAPE);
                inputField.sendKeys(Keys.TAB);

                log.info("Successfully cleared Sequence 1 for: " + actionName);
            } else {
                log.info("Field already empty or 'X' not found for: " + actionName);
            }
        }
    }

}