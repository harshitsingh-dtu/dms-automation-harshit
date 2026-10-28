package PageObjects.ProductGroup;

import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.fail;

@Slf4j
@Data
public class ProductGroupCreatePageObject extends PageObject {
    public static String lastGeneratedProductName;
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//button[text()='+ Create Product Group']")
    private WebElementFacade createProductGroup;
    @FindBy(xpath = "//input[@placeholder='Enter product group name']")
    private WebElementFacade productGroupName;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organisation;
    @FindBy(xpath = "//*[@placeholder='Asset Class']")
    private WebElementFacade SelectAssetClass;
    @FindBy(xpath = "//*[@placeholder='Select Product Family']")
    private WebElementFacade SelectProductFamily;
    @FindBy(xpath = "//*[@placeholder='Select Product']")
    private WebElementFacade SelectProduct;
    @FindBy(xpath = "//button[text()='Add Product Line']")
    private WebElementFacade AddProductLine_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;
    @FindBy(xpath = "//div[contains(.,'Product Group created successfully') or contains(.,'Product Group updated successfully')]")
    private WebElementFacade Notification_popUp;
    @FindBy(xpath = "//div[contains(text(),'No attributes available')]")
    private WebElementFacade FXCashFuture;
    @FindBy(xpath = "//div[contains(text(),'Settlement Type')]")
    private WebElementFacade FXCashSpot;
    @FindBy(xpath = "//span[normalize-space()='FX Exotic Options European Digital']")
    private WebElementFacade EuropeanDigital;
    @FindBy(xpath = "//div[contains(text(),'Product Group deleted successfully!')]")
    private WebElementFacade PG_dlt_popUp;
    @FindBy(xpath = "//div[contains(text(),'At least one product line is required. ')]")
    private WebElementFacade alert_popUp;
    @FindBy(xpath="//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
    private WebElementFacade navigation_btn;
    @FindBy(xpath ="//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupstemplate_btn;
    @FindBy(xpath ="//a[@data-testid='submenu-link-Product groups']")//div[text()='Currencies Group']
    private WebElementFacade ProductGrp_Btn;
    @FindBy(xpath = "//button[@class='button' and @data-testid='delete-button']//img[@alt='delete-line']")
    private WebElementFacade ProductLine_Delete_Btn;
    @FindBy(xpath = "//div[contains(@class, 'Toastify__toast-container') and contains(., 'There should be at least one line to create this product group')]")
    private WebElementFacade lastLineDeletionAlert;
    @FindBy(xpath = "//button[@data-testid='copy-button']")
    private WebElementFacade copyButton;

    public void createNewProductGroupFromFeature(DataTable table) {
        clickCreateProductGroup();
        
        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
        
        // Loop over each row in the datatable and enter details. Add product line after each.
        for(int i = 0; i < dataList.size(); i++) {
            Map<String, String> row = dataList.get(i);
            
            // Set Product Group Name only for the first row
            if(i == 0) {
                 try {
                    productGroupName.waitUntilVisible().click();
                    productGroupName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                    lastGeneratedProductName = row.get("Product Group Name");
                    productGroupName.sendKeys(lastGeneratedProductName);
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                }catch (Exception e){
                    log.error("Unable to input product name-->"+e);
                    Assert.fail();
                }
            }
            
            // Set Organisation
             try{
                organisation.waitUntilClickable().click();
                organisation.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                organisation.sendKeys(row.get("Organisation Name"));
                withAction().pause(Duration.ofMillis(1200)).build().perform(); // Safe wait for React list filtering
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input organisation-->"+e);
                Assert.fail();
            }
            
            // Set Asset Class
             try{
                SelectAssetClass.click();
                SelectAssetClass.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                act.moveToElement(SelectAssetClass).click().sendKeys(row.get("Asset Class")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input Asset class-->"+e);
                Assert.fail();
            }
            
            // Set Product Family
            try{
                SelectProductFamily.click();
                SelectProductFamily.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                act.moveToElement(SelectProductFamily).click().sendKeys(row.get("Product Family")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input product family-->"+e);
                Assert.fail();
            }
            
            // Set Product
            try{
                SelectProduct.click();
                SelectProduct.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                act.moveToElement(SelectProduct).click().sendKeys(row.get("Product")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to select Product-->"+e);
                Assert.fail();
            }
            
            AddProductLine();
        }
        Submit_btn();
    }
    
    public void enterProductGroupDetails(DataTable table) {
        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
        
        // Loop over each row in the datatable and enter details. Add product line after each.
        for(int i = 0; i < dataList.size(); i++) {
            Map<String, String> row = dataList.get(i);
            
            // Set Product Group Name only for the first row
            if(i == 0) {
                 try {
                    productGroupName.waitUntilVisible().click();
                    productGroupName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                    lastGeneratedProductName = row.get("Product Group Name");
                    productGroupName.sendKeys(lastGeneratedProductName);
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                }catch (Exception e){
                    log.error("Unable to input product name-->"+e);
                    Assert.fail();
                }
            }
            
            // Set Organisation
             try{
                organisation.waitUntilClickable().click();
                organisation.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                organisation.sendKeys(row.get("Organisation Name"));
                withAction().pause(Duration.ofMillis(1200)).build().perform(); // Safe wait for React list filtering
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input organisation-->"+e);
                Assert.fail();
            }
            
            // Set Asset Class
             try{
                SelectAssetClass.click();
                SelectAssetClass.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                act.moveToElement(SelectAssetClass).click().sendKeys(row.get("Asset Class")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input Asset class-->"+e);
                Assert.fail();
            }
            
            // Set Product Family
            try{
                SelectProductFamily.click();
                SelectProductFamily.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                act.moveToElement(SelectProductFamily).click().sendKeys(row.get("Product Family")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input product family-->"+e);
                Assert.fail();
            }
            
            // Set Product
            try{
                SelectProduct.click();
                SelectProduct.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                act.moveToElement(SelectProduct).click().sendKeys(row.get("Product")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to select Product-->"+e);
                Assert.fail();
            }
            
            AddProductLine();
        }
    }


    public void updateProductGroupDetails(DataTable table) {
        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
        
        // Loop over each row in the datatable and enter details. Add product line after each.
        for(int i = 0; i < dataList.size(); i++) {
            Map<String, String> row = dataList.get(i);
            
            // Set Product Group Name only for the first row
            if(i == 0) {
                 try {
                    productGroupName.waitUntilVisible().click();
                    productGroupName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                    lastGeneratedProductName = row.get("Product Group Name");
                    productGroupName.sendKeys(lastGeneratedProductName);
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                }catch (Exception e){
                    log.error("Unable to input product name-->"+e);
                    Assert.fail();
                }
            }
            
            // Set Asset Class
             try{
                SelectAssetClass.click();
                act.moveToElement(SelectAssetClass).click().sendKeys(row.get("Asset Class")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input Asset class-->"+e);
                Assert.fail();
            }
            
            // Set Product Family
            try{
                SelectProductFamily.click();
                act.moveToElement(SelectProductFamily).click().sendKeys(row.get("Product Family")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to input product family-->"+e);
                Assert.fail();
            }
            
            // Set Product
            try{
                SelectProduct.click();
                act.moveToElement(SelectProduct).click().sendKeys(row.get("Product")).pause(Duration.ofMillis(500)).build().perform();
                act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            }catch (Exception e){
                log.error("Unable to select Product-->"+e);
                Assert.fail();
            }
            
            AddProductLine();
        }
    }


    public void clickProductLineDeleteBtn() {
        ProductLine_Delete_Btn.waitUntilClickable().click();
    }

    public void validateLastLineDeletionAlert() {
        Assert.assertTrue("Last line deletion alert is not displayed", lastLineDeletionAlert.isVisible());
    }

    public void clickCopyButton() {
        copyButton.waitUntilClickable().click();
    }


    public static List<String> generatedProductGroupNames = new ArrayList<>();

    public void clickCreateProductGroup(){
        try {
            createProductGroup.withTimeoutOf(Duration.ofSeconds(15)).waitUntilClickable().click();
        } catch (Exception e) {
            WebElement btn = getDriver().findElement(By.xpath("//button[contains(text(),'Create Product Group')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", btn);
        }
    }
    public void productGroupName(DataTable productgroupname){
       StringBuilder random =  DocumentTemplateCreatePageObject.randomStringGenerator();
        List<Map<String, String>> data = productgroupname.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            productGroupName.waitUntilVisible();
            lastGeneratedProductName = dataTable.get("Product Group Name")+random;
            act.moveToElement(productGroupName).click().sendKeys(lastGeneratedProductName).pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to input product name-->"+e);
            Assert.fail();
        }
    }
    public void Organisation(DataTable organizationname){
        List<Map<String, String>> data = organizationname.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            organisation.waitUntilClickable().click();
            act.moveToElement(organisation).click().sendKeys(dataTable.get("Organisation Name")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input organisation-->"+e);
            Assert.fail();
        }
    }
    public void AssetClass(DataTable assetClass){
        List<Map<String, String>> data = assetClass.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SelectAssetClass.click();
            act.moveToElement(SelectAssetClass).click().sendKeys(dataTable.get("Asset Class")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to input Asset class-->"+e);
            Assert.fail();
        }
    }
    public void ProductFamily(DataTable ProductFamily){
        List<Map<String, String>> data = ProductFamily.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SelectProductFamily.waitUntilClickable().click();
            SelectProductFamily.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(300)).build().perform();
            try {
                WebElement clearBtn = getDriver().findElement(By.xpath("//div[contains(@data-testid, 'product-family')]//button[@title='Clear'] | //button[@title='Clear']"));
                if (clearBtn.isDisplayed()) {
                    clearBtn.click();
                }
            } catch (Exception ignored) {}
            SelectProductFamily.sendKeys(dataTable.get("Product Family"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SelectProductFamily.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }catch (Exception e){
            log.error("Unable to input product family-->"+e);
            Assert.fail();
        }
    }
    public void Product(DataTable Product){
        List<Map<String, String>> data = Product.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            SelectProduct.waitUntilClickable().click();
            SelectProduct.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(300)).build().perform();
            try {
                WebElement clearBtn = getDriver().findElement(By.xpath("//div[contains(@data-testid, 'product')]//button[@title='Clear'] | //button[@title='Clear']"));
                if (clearBtn.isDisplayed()) {
                    clearBtn.click();
                }
            } catch (Exception ignored) {}
            SelectProduct.sendKeys(dataTable.get("Product"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SelectProduct.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }catch (Exception e){
            log.error("Unable to select Product-->"+e);
            Assert.fail();
        }
    }
    public void AddProductLine(){
        Assert.assertTrue( AddProductLine_btn.isVisible());
        AddProductLine_btn.waitUntilPresent().click();
    }
    public void Submit_btn(){
        Submit_btn.waitUntilClickable().click();
    }
    
    public void submitAndVerify() {
        Submit_btn();
        try {
            Notification_popUp.waitUntilVisible();
            Assert.assertTrue("Notification popup not visible", Notification_popUp.isVisible());
        } catch (Exception e) {
             log.error("Unable to find notification popup-->"+e);
        }
        ProductGroupText();
    }
    
    public void ProductGroupText(){
        createProductGroup.waitUntilVisible();
        Assert.assertTrue(createProductGroup.isVisible());
    }
    public void ProductGroupNotificationPopUp(){
        Notification_popUp.waitUntilVisible();
        Assert.assertTrue(Notification_popUp.isVisible());
    }

    public void ProductGroupAlertPopUp(){
        alert_popUp.waitUntilVisible();
        Assert.assertTrue(alert_popUp.isVisible());
    }
    public void ProductGroupDeleteNotificationPopUp(){
        PG_dlt_popUp.waitUntilVisible();
        Assert.assertTrue(PG_dlt_popUp.isVisible());
    }
    public void ProductLinesExpanded(DataTable table){
        List<String> products = table.asList(String.class);
        for(int i = 1; i < products.size(); i++) { // Start at 1 to skip header
            String productName = products.get(i).trim();
            try {
                String dynamicXpath = "//span[contains(translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productName.toLowerCase() + "')]";
                WebElementFacade productElement = find(By.xpath(dynamicXpath));
                productElement.waitUntilVisible();
                Assert.assertTrue("Product line for " + productName + " is not expanded/visible", productElement.isVisible());
            } catch (Exception e) {
                log.error("Error finding expanded product line for: " + productName, e);
                Assert.fail("Failed to validate expanded product line for: " + productName);
            }
        }
    }

    public void productGroup(DataTable productgroupname){
//        StringBuilder random =  DocumentTemplateCreatePageObject.randomStringGenerator();
        List<Map<String, String>> data = productgroupname.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            productGroupName.waitUntilVisible();
            act.moveToElement(productGroupName).click().sendKeys(dataTable.get("Product Group Name")).pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to input product name-->"+e);
            Assert.fail();
        }
    }
    public void uniqueProductGroup(DataTable productgroupname){
        StringBuilder random =  DocumentTemplateCreatePageObject.randomStringGenerator();
        List<Map<String, String>> data = productgroupname.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            productGroupName.waitUntilVisible();
            lastGeneratedProductName = dataTable.get("Product Group Name")+random;
//            lastGeneratedProductName = dataTable.get("Product Group Name")+random;
            lastGeneratedProductName = dataTable.get("Product Group Name");
            act.moveToElement(productGroupName).click().sendKeys(lastGeneratedProductName).pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to input product name-->"+e);
            Assert.fail();
        }
    }

    public void navigateToProductGrpPage(){
        try {
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            navigation_btn.waitUntilClickable().click();
            if (ProductGrp_Btn.isVisible()) {
                ProductGrp_Btn.waitUntilClickable().click();
            }
            else{
                groupstemplate_btn.waitUntilClickable().click();
                ProductGrp_Btn.click();
            }
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Service not found in the navigation menu -->"+e);
            Assert.fail();
        }
    }

    public void validateProductGroupNameMaxLength() {
        WebElementFacade groupNameInput = find(By.xpath("//input[@data-testid=\"product-group-name-input\"]"));
        groupNameInput.waitUntilVisible();
        groupNameInput.clear();
        groupNameInput.sendKeys(RandomStringUtils.randomAlphabetic(256));
        int actualLength = groupNameInput.getValue().length();
        if (actualLength > 255) {
            throw new AssertionError("Product group name field accepts more than 255 characters.");
        } else {
            log.info("Product group name field correctly restricts input to 255 characters.");
        }
    }

    public void createMultipleProductGroups(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        generatedProductGroupNames.clear();
        for (Map<String, String> row : data) {
            String baseName = row.get("Product Group Name");
            String orgName = row.get("Organisation Name");
            String assetClass = row.get("Asset Class");
            String productFamily = row.get("Product Family");
            String product = row.get("Product");
            String uniqueGroupName = baseName + "_" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5);
            generatedProductGroupNames.add(uniqueGroupName);
            String currentAction = "Initializing Creation";
            log.info("--- Starting creation cycle for Product Group: {} ---", uniqueGroupName);
            try {
                currentAction = "Clicking '+ Create Product Group' button";
                WebElementFacade createBtn = $(By.xpath("//button[contains(., 'Create Product Group')]")).waitUntilClickable();
                createBtn.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // B. Enter Product Group Name
                currentAction = "Entering Product Group Name";
                WebElementFacade nameInput = $(By.xpath("//input[contains(@placeholder, 'product group name') or @name='productGroupName']")).waitUntilPresent();
                nameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                nameInput.sendKeys(uniqueGroupName);

                // C. Select Organisation
                currentAction = "Selecting Organisation: " + orgName;
                WebElementFacade orgInput = $(By.xpath("//input[contains(@placeholder, 'Select Organisation')]")).waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", orgInput);
                orgInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                orgInput.sendKeys(orgName);
                orgInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE); // Wake up React API
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                $(By.xpath("//li[@role='option' and contains(., '" + orgName + "')]")).waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                // D. Select Asset Class
                currentAction = "Selecting Asset Class: " + assetClass;
                WebElementFacade assetInput = $(By.xpath("//input[contains(@placeholder, 'Asset Class') or contains(@placeholder, 'Select Asset')]")).waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", assetInput);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                $(By.xpath("//li[@role='option' and contains(., '" + assetClass + "')]")).waitUntilClickable().click();

                // E. Select Product Family
                currentAction = "Selecting Product Family: " + productFamily;
                WebElementFacade familyInput = $(By.xpath("//input[contains(@placeholder, 'Product Family')]")).waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", familyInput);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                $(By.xpath("//li[contains(., '" + productFamily + "')]")).waitUntilClickable().click();

                // F. Select Product
                currentAction = "Selecting Product: " + product;
                WebElementFacade productInput = $(By.xpath("//input[@placeholder='Select Product']")).waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", productInput);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                $(By.xpath("//li[contains(., '" + product + "')]")).waitUntilClickable().click();

                // G. Add Product Line & Submit
                currentAction = "Clicking 'Add Product Line'";
                $(By.xpath("//button[contains(., 'Add Product Line')]")).waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                currentAction = "Clicking 'Submit'";
                WebElementFacade submitBtn = $(By.xpath("//button[contains(., 'Submit')]")).waitUntilClickable();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", submitBtn);

                // Wait for the save animation and redirection back to the main listing screen
                withAction().pause(Duration.ofSeconds(4)).build().perform();
                log.info("Successfully created and returned to listing for: {}", uniqueGroupName);

            } catch (Exception e) {
                log.error("Failed during action: '{}' for template '{}'. Error: {}", currentAction, uniqueGroupName, e.getMessage());
                org.junit.Assert.fail("Failed during: " + currentAction + " | Group: " + uniqueGroupName);
            }
        }
    }

    // 3. The Validation Method
    public void verifyGeneratedProductGroupsVisibility() {
        log.info("--- Verifying visibility of newly created Product Groups ---");

        if (generatedProductGroupNames.isEmpty()) {
            org.junit.Assert.fail("No Product Groups were found in memory. The creation step may have failed.");
        }

        String searchBoxXPath = "//input[contains(@placeholder, 'Search by product group name')]";

        for (String groupName : generatedProductGroupNames) {
            String currentAction = "Initializing Search Validation";
            try {
                // Search for the specific unique template we just created
                currentAction = "Locating and clearing the main search box";
                WebElementFacade searchBox = $(By.xpath(searchBoxXPath)).waitUntilPresent();
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", searchBox);
                searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                currentAction = "Searching for generated group: " + groupName;
                searchBox.sendKeys(groupName);
                searchBox.sendKeys(Keys.RETURN);
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for table to filter

                // Verify it actually appears in the table rows
                currentAction = "Checking table rows for group: " + groupName;
                String tableResultXPath = "//table/tbody/tr//td[contains(text(), '" + groupName + "')]";
                boolean isVisible = !findAll(By.xpath(tableResultXPath)).isEmpty();

                if (isVisible) {
                    log.info("Validation Passed: Product Group '{}' was successfully created and is visible.", groupName);
                } else {
                    org.junit.Assert.fail("VIEW_ALL Security Failure: Product Group '" + groupName + "' was created but is NOT visible on the listing screen.");
                }

            } catch (Exception e) {
                log.error("Failed during action: '{}' while validating '{}'. Error: {}", currentAction, groupName, e.getMessage());
                org.junit.Assert.fail("Validation step failed during: " + currentAction);
            }
        }
        $(By.xpath(searchBoxXPath)).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    public void updateGeneratedProductGroups() {
        log.info("--- Starting Update lifecycle for Product Groups ---");

        if (generatedProductGroupNames.isEmpty()) {
            fail("No Product Groups found in memory. The creation step may have failed.");
        }

        List<String> successfullyUpdatedNames = new ArrayList<>();

        for (String groupName : generatedProductGroupNames) {
            String updatedName = groupName + "_UPD";
            log.info("Updating Product Group: '{}' to '{}'", groupName, updatedName);

            try {
                // 1. Search for the previously created product group
                $("//input[contains(@placeholder, 'Search by product group name') or contains(@placeholder, 'Search')]").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                $("//input[contains(@placeholder, 'Search by product group name') or contains(@placeholder, 'Search')]").sendKeys(groupName);

                withAction().pause(Duration.ofSeconds(1)).build().perform(); // React debounce pause
                $("//input[contains(@placeholder, 'Search by product group name') or contains(@placeholder, 'Search')]").sendKeys(Keys.RETURN);
                withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for table to filter

                // 2. Click the Update button on the resulting row
                evaluateJavascript("arguments[0].click();", $("//tr[contains(., '" + groupName + "')]//button[contains(., 'Update') or contains(., 'Edit')] | //tr[contains(., '" + groupName + "')]//*[local-name()='svg' and (contains(@class, 'edit') or @data-testid='EditIcon')]").waitUntilClickable());
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // 3. Clear the old name and enter the updated name
                $("//input[contains(@placeholder, 'Product group name') or @name='productGroupName']").waitUntilVisible()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, updatedName);

                // 4. Submit the Update
                evaluateJavascript("arguments[0].click();", $("//button[contains(., 'Submit') or contains(., 'Update') or contains(., 'Save')]").waitUntilClickable());

                // 5. Wait for the success toast to ensure the backend saved it and the page redirected
                $("//*[contains(text(), 'successfully') or contains(text(), 'Updated')]").waitUntilVisible();
                withAction().pause(Duration.ofSeconds(2)).build().perform();

                // Save the new name into our temporary list
                successfullyUpdatedNames.add(updatedName);
                log.info("Successfully updated product group to '{}'", updatedName);

            } catch (Exception e) {
                log.error("Failed to update product group '{}'. Error: {}", groupName, e.getMessage());
                fail("Update lifecycle failed for Product Group: " + groupName + " with error: " + e.getMessage());
            }
        }

        // 6. Sync the memory list so any subsequent steps look for the "_UPD" names!
        generatedProductGroupNames.clear();
        generatedProductGroupNames.addAll(successfullyUpdatedNames);
    }

    public void deleteProductGroupIfExists(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String groupName = data.get(0).get("Product group");

        // Search for the product group
        WebElementFacade searchBox = find(By.xpath("//input[contains(@placeholder, 'Search by product group name')]"));
        searchBox.waitUntilVisible().clear();
        searchBox.sendKeys(groupName);
        searchBox.sendKeys(Keys.RETURN);

        withAction().pause(Duration.ofSeconds(3)).build().perform();

        // Check if the product group exists
        String groupXPath = "//td[contains(text(),'" + groupName + "')]";
        List<WebElementFacade> searchResults = findAll(groupXPath);

        if (!searchResults.isEmpty()) {
            // If it exists, delete it
            WebElementFacade deleteButton = find(By.xpath(groupXPath + "/following-sibling::td//button[contains(@data-testid, 'delete')]"));
            deleteButton.waitUntilClickable().click();
            
            WebElementFacade confirmDelete = find(By.xpath("//button[text()='Yes']"));
            confirmDelete.waitUntilClickable().click();

            // Validate success message
            PG_dlt_popUp.waitUntilVisible();
            Assert.assertTrue("Product group deletion message not shown.", PG_dlt_popUp.isVisible());
            log.info("Product Group '{}' found and deleted successfully.", groupName);
        } else {
            // If it doesn't exist, log it
            log.info("Product Group '{}' not found. Nothing to delete.", groupName);
        }
    }
}