package stepDefinations.ProductGroup;

import PageObjects.Documents.DocumentCreateNewPageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.ProductGroup.ProductGroupCreatePageObject;
import PageObjects.ProductGroup.ProductGroupValidationPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductGroupCreateWorkflowPageStep extends PageObject {
    Actions act=new Actions(getDriver());
    DocumentPageObject documentPageObject;
    ProductGroupValidationPageObject productGroupValidationPageObject;
    ProductGroupCreatePageObject productGroupCreatePageObject;
    DocumentCreateNewPageObject documentCreateNewPageObject;
    @Given("^User is on the Dashboard page and navigate to Product Group$")
    public void user_is_on_the_dashboard_page_and_navigate_to_product_group() {
        documentPageObject.clickMenuButton();
        productGroupValidationPageObject.clickProductGroupTab();
    }
    @And("^verifies the Authline Mandatory notification pop up$")
    public void verifies_the_authline_mandatory_notification() {
        productGroupCreatePageObject.ProductGroupAlertPopUp();
    }
    @When("^User clicks on Create Product Group$")
    public void user_clicks_on_create_product_group() {
        productGroupCreatePageObject.clickCreateProductGroup();
    }
    @When("Enters the new Product group name")
    @And("User enters the Product group name")
    public void enters_the_product_group_name (DataTable table) {
        productGroupCreatePageObject.productGroup(table);
    }
    @And("User enters unique Product group name")
    public void unique_product_group_name (DataTable table) {
        productGroupCreatePageObject.uniqueProductGroup(table);
    }
    @And("^Select the Organisation Name$")
    public void select_the_organisation(DataTable table) {
        productGroupCreatePageObject.Organisation(table);
    }

    @When("^User creates the following product groups$")
    public void user_creates_following_product_groups(DataTable dataTable) {
        productGroupCreatePageObject.createMultipleProductGroups(dataTable);
    }

    @Then("^verify the created product groups are visible on the listing screen$")
    public void verify_created_product_groups_are_visible() {
        productGroupCreatePageObject.verifyGeneratedProductGroupsVisibility();
    }

    @When("^User updates the created product groups by modifying their names$")
    public void user_updates_created_product_groups() {
        productGroupCreatePageObject.updateGeneratedProductGroups();
    }

    @Then("^Select asset class in Auth Products$")
    public void select_asset_class_in_auth_products(DataTable table) {
        productGroupCreatePageObject.AssetClass(table);
    }
    @Then("^Select product family in Auth Products$")
    public void select_product_family_in_auth_products(DataTable table) {
        productGroupCreatePageObject.ProductFamily(table);
    }
    @And("^Select product in Auth Product$")
    public void select_product_in_auth_product(DataTable table) {
        productGroupCreatePageObject.Product(table);
    }
    @Then("^Click on Add Product Line$")
    public void click_on_add_product_line() {
        productGroupCreatePageObject.AddProductLine();
    }
    @And("^Click on Submit$")
    public void click_on_submit() {
        documentCreateNewPageObject.startContinuousToastInterceptor();
        productGroupCreatePageObject.Submit_btn();
        act.pause(Duration.ofSeconds(2)).build().perform();
    }
    @And("^verifies the Product Group$")
    public void verifies_the_product_group() {
        productGroupCreatePageObject.ProductGroupText();
    }
    @And("^verifies the Product Group created notification pop up$")
    public void verifies_the_product_group_notification() {
        act.pause(Duration.ofSeconds(2)).build().perform();
        productGroupCreatePageObject.ProductGroupNotificationPopUp();
    }
    @And("^verifies the Product Group deleted notification pop up$")
    public void verifies_the_product_group_dlt_notification() {
        productGroupCreatePageObject.ProductGroupDeleteNotificationPopUp();

    }
    @And("^User validates product lines are expanded$")
    public void verifies_the_product_lines_expanded(DataTable table) {
        productGroupCreatePageObject.ProductLinesExpanded(table);
    }

    @Then("User is on product Group Page")
    public void navigate_to_product_grp (){
        productGroupCreatePageObject.navigateToProductGrpPage();
    }
    @And("User validates product group name length")
    public void validate_product_group_name_length (){
        productGroupCreatePageObject.validateProductGroupNameMaxLength();
    }

    @Given("User creates a new Product Group from the feature file data")
    public void userCreatesNewProductGroup(DataTable table) {
        productGroupCreatePageObject.createNewProductGroupFromFeature(table);
    }

    @Given("^User (enters|Update) the Product Group details$")
    public void userEntersOrUpdatesTheProductGroupDetails(String action, DataTable table) {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if (action.equalsIgnoreCase("enters")) {
            productGroupCreatePageObject.enterProductGroupDetails(table);
        } else if (action.equalsIgnoreCase("Update")) {
            productGroupCreatePageObject.updateProductGroupDetails(table);
        }
    }

    @Then("^User Click on ProductLine delete button$")
    public void user_click_on_productline_delete_button() {
        productGroupCreatePageObject.clickProductLineDeleteBtn();
    }

    @Then("Autline Validation on LastLine Deletion")
    public void autlineValidationOnLastLineDeletion() {
        productGroupCreatePageObject.validateLastLineDeletionAlert();
    }

    @Then("Copy the existing line")
    public void copyTheExistingLine() {
        productGroupCreatePageObject.clickCopyButton();
    }

    @And("^Click on Submit and verifies the Product Group (?:created )?notification pop up$")
    public void click_on_submit_and_verify() {
        productGroupCreatePageObject.submitAndVerify();
    }
}
