package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.Bulk_Edit_Document_Doc_type_DN_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1525_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1548_PageObject;
import PageObjects.ProductGroup.ProductGroupUpdatePageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DMS_1548_Step
{
    Bulk_Edit_Document_Doc_type_DN_PageObject bulkEditDocumentDocTypeDnPageObject;
    DMS_1548_PageObject DMS_1548;
    DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;
//Actions act=new Actions(getDriver());
    ProductGroupUpdatePageObject productGroupUpdatePageObject;
    @Then("verify roles from Role mapping dropdown")
    public void verifyRolesFromRoleMappingDropdown(List<String> roles)
    {
        DMS_1548.verifyRolesFromRoleMappingDropdown(roles);
    }


    @And("User will search product groups belongs to User's parent org")
    public void userWillSearchProductGroupsBelongsToUserSParentOrg(List<String> product_groups) {
        DMS_1548.Search_product_group(product_groups);
    }


    @And("User will search product groups User not belongs to User's parent org")
    public void userWillSearchProductGroupsUserNotBelongsToUserSParentOrg(List<String> product_groups)
    {
        DMS_1548.Search_product_group(product_groups);
    }


    @And("Verify update button is enabled for all product groups")
    public void verifyUpdateButtonIsEnabledForAllProductGroups()
    {

        Assert.assertTrue(DMS_1548.check_update_for_product_group());
    }

    @Then("Check User is on product groups listing screen")
    public void checkUserIsOnProductGroupsListingScreen()
    {
        Assert.assertTrue(DMS_1548.getProductGroupSearch_bar().isVisible());
    }

    @Then("User will add product line and Submit")
    public void userWillAddProductLineAndSubmit()
    {
        DMS_1548.Remove_all_product_lines();
        DMS_1548.select_assert_class();
        DMS_1548.Select_product_family();
        DMS_1548.Select_product();
        DMS_1548.getAddProductLine_btn().click();
        DMS_1548.getSubmit_btn().click();
        if (DMS_1548.getToast_alert_msg().getText().toLowerCase().contains("duplicate")){
            DMS_1548.Remove_all_product_lines();
            DMS_1548.select_assert_class();
            DMS_1548.Select_product_family();
            DMS_1548.Select_product();
            DMS_1548.getAddProductLine_btn().click();
            DMS_1548.getSubmit_btn().click();
        }
    }

    @And("User will select product groups belongs to Users parent org and click update button for it")
    public void userWillSelectProductGroupsBelongsToUserSParentOrgAndClickUpdateButtonForIt()
    {
        DMS_1548.Select_product_grp_belong_to_parent_org_and_click_update_btn();
    }

    @And("select max Records per page")
    public void selectMaxRecordsPerPage() {
        DMS_1548.Records_per_page_make_it_max();
    }

    @And("User will select product groups which is not belongs to Users parent org and click update button for it")
    public void userWillSelectProductGroupsWhichIsNotBelongsToUserSParentOrgAndClickUpdateButtonForIt()
    {
        DMS_1548.Select_product_grp_not_belong_to_parent_org_and_click_update_btn();
    }

    @Then("Verify user can see product groups of other Orgs")
    public void verifyUserCanSeeProductGroupsOfOtherOrgs()
    {
        DMS_1548.check_user_can_see_product_groups_of_other_orgs();
    }

    @And("Select Organisation Name for Product group")
    public void selectOrganisationName_for_Product_group()
    {
        DMS_1548.select_Org();
    }


    @And("Enter Product group name")
    public void enterProductGroupName(List<String> product_groups_name)
    {
        DMS_1548.select_product_group_name(product_groups_name);
    }

    @And("User is on the Dashboard page and navigate to Currency Group")
    public void userIsOnTheDashboardPageAndNavigateToCurrencyGroup()  {
        DMS_1548.getNavigation_btn().click();
        DMS_1548.getGroupAndTemplate_tab().click();
        DMS_1548.getCurrencies_group_tab().click();
    }

    @And("Verify update button is enabled for all Currency groups")
    public void verifyUpdateButtonIsEnabledForAllCurrencyGroups()
    {
        Assert.assertTrue(DMS_1548.check_update_for_currency_group());
    }

    @And("User will select Currency groups belongs to Users parent org and click update button for it")
    public void userWillSelectCurrencyGroupsBelongsToUserSParentOrgAndClickUpdateButtonForIt()
    {
        DMS_1548.Select_currency_grp_belong_to_parent_org_and_click_update_btn();

    }

    @And("Remove Currency from currency group and submit")
    public void removeCurrencyFromCurrencyGroupAndSubmit()
    {
        DMS_1548.remove_currency();
    }
    @When("Verify user can see Currency groups of other Orgs")
    public void verify_user_can_see_currency_groups_of_other_orgs()
    {
        DMS_1548.check_user_can_see_currency_groups_of_other_orgs();
    }

    @And("Click on create Currency Group button")
    public void clickOnCreateCurrencyGroupButton()
    {
        Assert.assertTrue(DMS_1548.getCreate_new_group_btn().isEnabled());
        DMS_1548.getCreate_new_group_btn().click();
    }

    @And("Enter currencies group name")
    public void enterCurrenciesGroupName(List<String> currencies_group_name)
    {
        DMS_1548.select_currency_group_name(currencies_group_name);
    }

    @And("Select Organisation Name for Currency group")
    public void selectOrganisationNameForCurrencyGroup()
    {
        DMS_1548.select_Org();
    }

    @And("Select currencies click on submit button")
    public void selectCurrenciesClickOnSubmitButton()
    {
        DMS_1548.Add_currency();
        Assert.assertTrue(DMS_1548.getSubmit_btn().isEnabled());
        DMS_1548.getSubmit_btn().click();
    }

    @Then("Verify update button is visible for all org users except own org users")
    public void verifyUpdateButtonIsVisibleForAllOrgUsersExceptOwnOrgUsers()
    {
        DMS_1548.verify_update_btn_for_own_org_user();
    }

    @And("Click on update button and verify tabs")
    public void clickOnUpdateButtonAndVerifyTabs()
    {
        DMS_1548.getUPDATE_buttons_Product_groups_listing_screen().click();
        Assert.assertTrue(DMS_1548.getSelectedRoles().isEnabled());
        Assert.assertTrue(DMS_1548.getActive_btn().isEnabled());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getSearch_orgType().isVisible());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getSearch_LEI().isVisible());
        Assert.assertTrue(bulkEditDocumentDocTypeDnPageObject.getDoctype().isVisible());
    }

    @Then("Verify user can see all org users")
    public void verifyUserCanSeeAllOrgUsers()
    {
        DMS_1548.check_user_can_see_other_org_users();
    }

    @And("Click on organisation")
    public void clickOnOrganisation()
    {
        DMS_1548.getNavigation_btn().click();
        DMS_1548.getOrganisations_btn().click();
    }

    @And("Verify update button is visible for all LEI org types")
    public void verifyUpdateButtonIsVisibleForAllLEIOrgTypes()
    {
        Assert.assertTrue(DMS_1548.verify_update_btn_for_organisations_management_if_user_have_EDIT_OWN_permition());

    }

    @And("Navigate to all document screen")
    public void navigateToAllDocumentScreen()
    {
        Assert.assertTrue(DMS_1548.getNavigation_btn().isEnabled());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getDocument_tab().isEnabled());
        DMS_1548.getDocument_tab().click();
        Assert.assertTrue(DMS_1548.getAllDocument_tab().isEnabled());
        DMS_1548.getAllDocument_tab().click();
    }

    @And("Verify download button")
    public void verifyDownloadButton()
    {
        Assert.assertTrue(DMS_1548.getDocument_download_btn().isClickable());
        DMS_1548.getDocument_download_btn().click();
    }

    @Then("Verify user can view own org users assigned roles and leis")
    public void verifyUserCanViewOwnOrgUsersAssignedRolesAndLeis()
    {
        DMS_1548.check_user_can_see_other_orgs_on_user_management_screen();
    }

    @Then("Verify update button is visible for own org users")
    public void verifyUpdateButtonIsVisibleForOwnOrgUsers()
    {
        DMS_1548.verify_update_btn_for_own_org_user_if_user_have_admin_role();
    }

    @And("Verify user can see other orgs on Organisations Management listing screen")
    public void verifyUserCanSeeOtherOrgsOnOrganisationsManagementListingScreen()
    {
        DMS_1548.check_user_can_see_other_orgs_on_organisations_management_screen();
    }

    @And("Navigate to Approval Groups")
    public void navigateToApprovalGroups()
    {Assert.assertTrue(DMS_1548.getNavigation_btn().isEnabled());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getGroupAndTemplate_tab().isEnabled());
        DMS_1548.getGroupAndTemplate_tab().click();
        Assert.assertTrue(DMS_1548.getApproval_group_tab().isEnabled());
        DMS_1548.getApproval_group_tab().click();
    }

    @And("Navigate to Approval Matrix")
    public void navigateToApprovalMatrix()
    {
        Assert.assertTrue(DMS_1548.getNavigation_btn().isEnabled());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getGroupAndTemplate_tab().isEnabled());
        DMS_1548.getGroupAndTemplate_tab().click();
        Assert.assertTrue(DMS_1548.getApproval_matrix_tab().isEnabled());
        DMS_1548.getApproval_matrix_tab().click();
    }

    @And("Navigate to Document Template")
    public void navigateToDocumentTemplate()
    {
        Assert.assertTrue(DMS_1548.getNavigation_btn().isEnabled());
        DMS_1548.getNavigation_btn().click();
        Assert.assertTrue(DMS_1548.getGroupAndTemplate_tab().isEnabled());
        DMS_1548.getGroupAndTemplate_tab().click();
        Assert.assertTrue(DMS_1548.getDocument_template_tab().isEnabled());
        DMS_1548.getDocument_template_tab().click();
    }

    @And("Check download button is visible for all enforced docs")
    public void checkDownloadButtonIsVisibleForAllEnforcedDocs(List<String> Document_Status)
    {
//        DMS_1548.Records_per_page_make_it_max();
        Validation_of_Document_Listing_screen_for_Doc.select_doc_status(Document_Status);
//       No of docs == no of download btn
        Assert.assertEquals(DMS_1548.getList_of_docs_on_listing_screen().size(),DMS_1548.getList_of_download_btn_on_listing_screen().size());

    }

    @And("Verify download button for assigned LEI document")
    public void verifyDownloadButtonForAssignedLEIDocument(DataTable table)  {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_download_btn_for_Assigned_lei();
    }

    @And("Verify edit button is visible for all document")
    public void verifyEditButtonIsVisibleForAllDocument()
    {
        //       No of docs == no of download btn
        Assert.assertEquals(DMS_1548.getList_of_docs_on_listing_screen().size(),DMS_1548.getList_of_Edit_btn_on_listing_screen().size());
    }

    @And("Verify document types on create page")
    public void verifyDocumentTypesOnCreatePage(List<String> filters)
    {
        DMS_1548.verifyDocTypesListOnCreateDocPage(filters);

    }



    @And("select four way doc type")
    public void selectFourWayDocType(List<String> filters)
    {
        DMS_1548.select_doc_types(filters);
    }

    @And("Verify Acting As on create page")
    public void verifyActingAsOnCreatePage(List<String> Acting_As)
    {

        DMS_1548.getSelect_acting_As_input().click();
        for (int i=0;i<=Acting_As.size()-1;i++)
        {
            System.out.println(Acting_As.get(i));
            Assert.assertTrue(DMS_1548.getList_of_acting_As_dropdown().getText().contains(Acting_As.get(i)));
        }
    }

    @And("Select Acting As on create page")
    public void selectActingAsOnCreatePage(List<String> Acting_As)
    {
        DMS_1548.select_Acting_As(Acting_As);
    }

    @And("Verify Prime Broker {int} , Clients {int} , Prime Broker {int} , Clients {int} filters are visible")
    public void verifyPrimeBrokerClientsPrimeBrokerClientsFiltersAreVisible()
    {

    }




    @And("Verify REJECT button for assigned LEI document")
    public void verifyREJECTButtonForAssignedLEIDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_REJECT_btn_for_Assigned_lei();
    }

    @And("Verify Approve button for assigned LEI document")
    public void verifyApproveButtonForAssignedLEIDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_Approve_btn_for_Assigned_lei();
    }

    @And("Verify Terminate button for assigned LEI document")
    public void verifyTerminateButtonForAssignedLEIDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_Terminate_btn_for_Assigned_lei();
    }

    @And("Verify cancel button for assigned LEI document")
    public void verifyCancelButtonForAssignedLEIDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_Cancel_btn_for_Assigned_lei();
    }

    @And("Verify Delete button for assigned LEI document")
    public void verifyDeleteButtonForAssignedLEIDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_Delete_btn_for_Assigned_lei();
    }

    @And("Verify edit button for assigned LEI document")
    public void verifyEditButtonForAssignedLEIDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_DN(table);
        DMS_1548.checking_Edit_btn_for_Assigned_lei();
    }



    @And("Verify Prime Broker one Clients one Executing Broker one filters are visible")
    public void verifyPrimeBrokerOneClientsOneExecutingBrokerOneFiltersAreVisible()
    {
        Assert.assertTrue(DMS_1548.getSelectPB1().isEnabled());
        Assert.assertTrue(DMS_1548.getSelectClient1().isEnabled());
        Assert.assertTrue(DMS_1548.getSelectEB1().isEnabled());
    }

    @And("Verify Prime Broker one Clients one Prime Broker two Clients two filters are visible")
    public void verifyPrimeBrokerOneClientsOnePrimeBrokerTwoClientsTwoFiltersAreVisible()
    {
        Assert.assertTrue(DMS_1548.getSelectPB1().isEnabled());
        Assert.assertTrue(DMS_1548.getSelectClient1().isEnabled());
        Assert.assertTrue(DMS_1548.getSelectPB2().isEnabled());
        Assert.assertTrue(DMS_1548.getSelectClient2().isEnabled());
    }

    @And("Verify Terminate button for assigned LEI four way document")
    public void verifyTerminateButtonForAssignedLEIFourWayDocument(DataTable table)
    {
     DMS_1548.check_doc_for_assigned_lei_if_doc_type_4W(table);
        DMS_1548.checking_Terminate_btn_for_Assigned_lei();
    }

    @And("Verify Delete button for assigned LEI four way document")
    public void verifyDeleteButtonForAssignedLEIFourWayDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_4W(table);
        DMS_1548.checking_Delete_btn_for_Assigned_lei();
    }

    @And("Verify edit button for assigned LEI four way document")
    public void verifyEditButtonForAssignedLEIFourWayDocument(DataTable table)
    {
        DMS_1548.check_doc_for_assigned_lei_if_doc_type_4W(table);
        DMS_1548.checking_Edit_btn_for_Assigned_lei();
    }

    @And("Check that only four Way doc list is present")
    public void checkThatOnlyFourWayDocListIsPresent(DataTable dataTable)
    {
        Validation_of_Document_Listing_screen_for_Doc.ColumnAndColumnValueCheck(dataTable);

    }

    @And("Verify user can see other org Approval Groups")
    public void verifyUserCanSeeOtherOrgApprovalGroups()
    {
        DMS_1548.check_user_can_see_Approval_Groups_of_other_orgs();
    }

    @And("Verify user can see other org Approval Matrix")
    public void verifyUserCanSeeOtherOrgApprovalMatrix()
    {
        DMS_1548.check_user_can_see_Approval_Matrix_of_other_orgs();
    }

    @And("Verify user can see self org Approval Matrix only")
    public void verifyUserCanSeeSelfOrgApprovalMatrixOnly()
    {
        DMS_1548.check_user_can_see_Approval_Matrix_of_only_self_orgs();
    }

    @And("Verify user can see assign lei Approval Groups")
    public void verifyUserCanSeeAssignLeiApprovalGroups() {
        DMS_1548.check_user_can_see_Groups_of_only_assign_lei();
        DMS_1548.check_user_can_see_Approval_Groups_of_only_assign_lei();
    }

    @And("Verify user can see assign lei Approval Matrix")
    public void verifyUserCanSeeAssignLeiApprovalMatrix() {
        DMS_1548.check_user_can_see_Matrix_of_only_assign_lei();
        DMS_1548.check_user_can_see_Approval_Matrix_of_only_assign_lei();
    }

    @And("Verify user can see self org Document Template only")
    public void verifyUserCanSeeSelfOrgDocumentTemplateOnly()
    {
        DMS_1548.check_user_can_see_Document_Template_of_only_self_orgs();

    }

    @And("Verify user can see other org Document Template")
    public void verifyUserCanSeeOtherOrgDocumentTemplate()
    {
        DMS_1548.check_user_can_see_Document_Template_of_other_orgs();
    }
}
