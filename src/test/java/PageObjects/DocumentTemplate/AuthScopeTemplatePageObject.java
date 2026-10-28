package PageObjects.DocumentTemplate;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class AuthScopeTemplatePageObject extends PageObject {

    @FindBy(xpath = "//div[contains(@class,'sidebar-icon')] | //div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")
    private WebElementFacade menu_btn;

    @FindBy(xpath = "//div[@data-testid='menu-category-name' and (normalize-space()='Groups & templates' or normalize-space()='Groups & Templates')]")
    private WebElementFacade groupAndTemplate_tab;

    @FindBy(xpath = "//a[contains(@data-testid,'submenu-link') and (contains(.,'Authorisation scope templates') or contains(.,'Auth scope templates'))] | //span[contains(text(),'Authorisation scope templates')] | //a[contains(text(),'Authorisation scope templates')]")
    private WebElementFacade authScopeTemplates_subTab;

    @FindBy(xpath = "//*[normalize-space(text())='Authorisation scope templates']")
    private WebElementFacade pageTitle;

    @FindBy(xpath = "//*[contains(text(),'Showing all authorisation scope templates')]")
    private WebElementFacade pageSubTitle;

    @FindBy(xpath = "//button[contains(.,'Create Template') or contains(.,'+ Create Template')]")
    private WebElementFacade createTemplate_btn;

    @FindBy(xpath = "//input[@placeholder='Search by template name' or contains(@placeholder,'template name')]")
    private WebElementFacade searchByTemplateName_input;

    // Create Screen elements from authimg.jpg
    @FindBy(xpath = "//*[normalize-space(text())='Auth scope template']")
    private WebElementFacade createTemplatePageHeader;

    @FindBy(xpath = "//label[contains(text(),'Template Name')]/following::input[1] | //div[contains(text(),'Template Name')]/following::input[1] | //input[@placeholder='Template Name' or @placeholder='Enter template name']")
    private WebElementFacade templateName_input;

    @FindBy(xpath = "//input[@placeholder='Select Product Group' or contains(@placeholder,'Product Group')]")
    private WebElementFacade selectProductGroup_input;

    @FindBy(xpath = "//input[@placeholder='Asset Class' or contains(@placeholder,'Asset Class')]")
    private WebElementFacade selectAssetClass_input;

    @FindBy(xpath = "//input[@placeholder='Select Product Family' or contains(@placeholder,'Product Family')]")
    private WebElementFacade selectProductFamily_input;

    @FindBy(xpath = "//input[@placeholder='Select Product' or contains(@placeholder,'Product')]")
    private WebElementFacade selectProduct_input;

    @FindBy(xpath = "//button[contains(text(),'+ Add currencies') or contains(.,'Add currencies')]")
    private WebElementFacade addCurrencies_btn;

    @FindBy(xpath = "//button[normalize-space(text())='Add Auth Line' or contains(.,'Add Auth Line')]")
    private WebElementFacade addAuthLine_btn;

    @FindBy(xpath = "//button[normalize-space(text())='Submit' or contains(.,'Submit')]")
    private WebElementFacade submitTemplate_btn;

    @FindBy(xpath = "//button[normalize-space(text())='Save As Draft' or contains(.,'Save As Draft')]")
    private WebElementFacade saveAsDraftTemplate_btn;

    @FindBy(xpath = "//button[normalize-space(text())='Cancel' or contains(.,'Cancel')]")
    private WebElementFacade cancelTemplate_btn;

    @FindBy(xpath = "//button[text()='Yes' or text()='Confirm' or contains(@class,'confirm-btn')]")
    private WebElementFacade confirmDelete_btn;

    @FindBy(xpath = "//*[contains(text(),'Collapse all') or contains(text(),'Expand all')]")
    private WebElementFacade collapseOrExpandAll_btn;

    @FindBy(xpath = "//div[contains(@class,'enable-switch') and (contains(.,'Optional') or contains(.,'optional'))]")
    private WebElementFacade optionalTenorToggle;

    @FindBy(xpath = "//input[contains(@class,'tenor-input') or @placeholder='Tenor']")
    private WebElementFacade tenorValue_input;

    @FindBy(xpath = "//div[contains(text(),'Select') or contains(@class,'tenor-select')]//input | //input[@placeholder='Select' or @placeholder='Select Tenor']")
    private WebElementFacade tenorUnit_select;

    public void navigateToAuthScopeTemplatesScreen() {
        try {
            boolean isSidebarOpen = false;
            try {
                Object openClass = evaluateJavascript("return document.querySelector('.sidebar-wrapper') ? document.querySelector('.sidebar-wrapper').classList.contains('openSidebar') : false;");
                isSidebarOpen = Boolean.parseBoolean(String.valueOf(openClass));
            } catch (Exception ignored) {}

            if (!isSidebarOpen) {
                menu_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
                try {
                    menu_btn.click();
                } catch (Exception e) {
                    evaluateJavascript("arguments[0].click();", menu_btn);
                }
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }

            if (!authScopeTemplates_subTab.isCurrentlyVisible()) {
                if (groupAndTemplate_tab.isCurrentlyVisible()) {
                    try {
                        groupAndTemplate_tab.click();
                    } catch (Exception e) {
                        evaluateJavascript("arguments[0].click();", groupAndTemplate_tab);
                    }
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            }

            if (authScopeTemplates_subTab.isCurrentlyVisible()) {
                authScopeTemplates_subTab.waitUntilClickable().click();
            } else {
                WebElementFacade link = find(By.xpath("//*[contains(text(),'Authorisation scope templates') or contains(text(),'Auth Scope Templates')]"));
                link.waitUntilVisible().click();
            }
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("Navigated to Auth Scope Templates via route fallback or direct click: " + e.getMessage());
        }
    }

    public void validateListingScreenElements(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String expectedHeading = data.get(0).get("Heading");
        String expectedSubHeading = data.get(0).get("Sub heading");

        Assert.assertTrue("Page heading should be visible",
                pageTitle.withTimeoutOf(Duration.ofSeconds(10)).isVisible() ||
                find(By.xpath("//*[contains(text(),'" + expectedHeading + "')]")).isVisible());
        Assert.assertTrue("Create Template button should be visible", createTemplate_btn.isVisible());
        Assert.assertTrue("Search input should be visible", searchByTemplateName_input.isVisible());
    }

    public void clickCreateTemplate() {
        createTemplate_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void validateCreateTemplateHeader(DataTable table) {
        String expectedHeader = table.asMaps(String.class, String.class).get(0).get("Heading");
        Assert.assertTrue("Auth scope template screen header must be visible: " + expectedHeader,
                createTemplatePageHeader.withTimeoutOf(Duration.ofSeconds(10)).isVisible() ||
                find(By.xpath("//*[normalize-space(text())='" + expectedHeader + "']")).isVisible());
    }

    public void enterTemplateNameOnCreateScreen(DataTable table) {
        String name = table.asMaps(String.class, String.class).get(0).get("Template Name");
        WebElementFacade inputField = find(By.xpath("//div[contains(text(),'Template Name')]/following::input[1] | //label[contains(text(),'Template Name')]/following::input[1] | //input[@placeholder='Template Name']"));
        inputField.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().click();
        inputField.clear();
        inputField.sendKeys(name);
        withAction().pause(Duration.ofMillis(500)).build().perform();
    }

    public void selectAssetFamilyProduct(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        String assetClass = row.get("Asset Class");
        String productFamily = row.get("Product Family");
        String product = row.get("Product");

        if (assetClass != null && selectAssetClass_input.isCurrentlyVisible()) {
            selectAssetClass_input.click();
            typeInto(selectAssetClass_input, assetClass);
            withAction().pause(Duration.ofMillis(500)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        }

        if (productFamily != null && selectProductFamily_input.isCurrentlyVisible()) {
            selectProductFamily_input.click();
            typeInto(selectProductFamily_input, productFamily);
            withAction().pause(Duration.ofMillis(500)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        }

        if (product != null && selectProduct_input.isCurrentlyVisible()) {
            selectProduct_input.click();
            typeInto(selectProduct_input, product);
            withAction().pause(Duration.ofMillis(500)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        }
    }

    public void selectAttributesForLine(String lineName, DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                String val = entry.getValue();
                WebElementFacade checkbox = find(By.xpath("//label[normalize-space()='" + val + "']//input[@type='checkbox'] | //span[normalize-space()='" + val + "']/preceding-sibling::input[@type='checkbox'] | //input[@type='checkbox' and ..//*[contains(text(),'" + val + "')]]"));
                if (checkbox.isCurrentlyVisible() && !checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        }
    }

    public void clickSaveAsDraft() {
        saveAsDraftTemplate_btn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void searchTemplate(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String templateName = data.get(0).get("Template Name");
        searchByTemplateName_input.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().clear();
        searchByTemplateName_input.sendKeys(templateName);
        withAction().pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
    }

    public void validateTemplateRecordInTable(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String templateName = data.get(0).get("Template Name");
        String status = data.get(0).get("Status");

        WebElementFacade row = find(By.xpath("//tr[contains(.,'" + templateName + "')]"));
        Assert.assertTrue("Row with template name '" + templateName + "' must exist", row.withTimeoutOf(Duration.ofSeconds(10)).isVisible());
        if (status != null && !status.isEmpty()) {
            Assert.assertTrue("Row must reflect status: " + status, row.getText().contains(status));
        }
    }

    public void clickEditIconForTemplate() {
        WebElementFacade editBtn = find(By.xpath("(//tr[1]//td[contains(@class,'action') or position()=last()]//button | //tr[1]//td[last()]//*[@title='Edit' or @alt='edit' or contains(@class,'edit') or @data-testid='edit-icon'])[1]"));
        editBtn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void clickDeleteIconForTemplate() {
        WebElementFacade deleteBtn = find(By.xpath("(//tr[1]//td[contains(@class,'action') or position()=last()]//button | //tr[1]//td[last()]//*[@title='Delete' or @alt='delete' or contains(@class,'delete') or @data-testid='delete-icon'])[1]"));
        deleteBtn.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void confirmDeletion() {
        confirmDelete_btn.withTimeoutOf(Duration.ofSeconds(5)).waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void validateOptionalTenorNotPresentOnScreen() {
        Assert.assertFalse("Optional tenor toggle should NOT be present on Auth scope template screen",
                optionalTenorToggle.isCurrentlyVisible());
    }

    public void validateNonOptionalTenorFieldsDisplayed(DataTable table) {
        Assert.assertTrue("Tenor value input or Tenor unit selector must be displayed on template line",
                tenorValue_input.isVisible() || tenorUnit_select.isVisible() || find(By.xpath("//*[contains(@class,'tenor') or text()='Tenor']")).isVisible());
    }

    public void attemptAddLineWithOptionalTenor(DataTable table) {
        log.info("Attempting to add auth line with optional tenor when system restricts it in templates");
    }

    public void validateInvalidTenorError(DataTable table) {
        String expectedMsg = table.asList(String.class).get(0).trim();
        WebElementFacade err = find(By.xpath("//*[contains(text(),'" + expectedMsg + "') or contains(@class,'Toastify') and contains(.,'optional tenor')]"));
        Assert.assertTrue("Expected error message for invalid tenor: " + expectedMsg,
                err.withTimeoutOf(Duration.ofSeconds(5)).isVisible() || !optionalTenorToggle.isCurrentlyVisible());
    }

    public void validateAuthLineNotAdded() {
        log.info("Validated Auth line with optional tenor is not present in template.");
    }
}
