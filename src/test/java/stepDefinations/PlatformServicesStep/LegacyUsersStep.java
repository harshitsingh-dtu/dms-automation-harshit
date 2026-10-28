package stepDefinations.PlatformServicesStep;

import PageObjects.PlatformServices.LegalEntitiesPageObject;
import PageObjects.PlatformServices.LegalUsersPageObject;
import PageObjects.PlatformServices.PlatformUsersPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
public class LegacyUsersStep extends PageObject {
    LegalUsersPageObject legalUsersPageObject;
    PlatformUsersPageObject platformUsersPageObject;
    LegalEntitiesPageObject legalEntitiesPageObject;
    @Then("User is able to see search by user name or email on the legal Users listing screen")
    public void verifySearchByUserNameOrEmail() {
        Assert.assertTrue(legalUsersPageObject.getSearch_ByEmailid().isVisible());
    }
    @Then("User is able to see filter legacy orgs on the legal Users listing screen")
    public void verifyFilterLegacyOrgs() {
        Assert.assertTrue(legalUsersPageObject.getFilter_legacyorgs().isVisible());
    }

    @Then("User is able to see filter legacy org types on the legal Users listing screen")
    public void verifyFilterLegacyOrgTypes() {
        Assert.assertTrue(legalUsersPageObject.getFilter_legacyorgstype().isVisible());
    }

    @Then("User is able to see filter applications on the legal Users listing screen")
    public void verifyFilterApplications() {
        Assert.assertTrue(legalUsersPageObject.getFilter_applications().isVisible());
    }

    @Then("User is able to see filter status on the legal Users listing screen")
    public void verifyFilterStatus() {
        Assert.assertTrue(legalUsersPageObject.getFilter_status().isVisible());
    }

    @Then("User is able to see all the elements on the legal users listing screen")
    public void verifyAllElements() {
        try {
            Assert.assertTrue(legalUsersPageObject.getColumn_Action().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Platform_user().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_LegacyUsername().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Username().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Email_Id().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Contact_Number().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Legacy_org().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Legacy_org_type().isVisible());
            Assert.assertTrue(legalUsersPageObject.getColumn_Source_Application().isVisible());
        }catch (AssertionError e){
            log.error("Elements Missing"+e);
        }}
    @And("User is able to see view details button on the legal users listing screen")
    public void verifyViewDetailsButton() {
        Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
    }

    @Then("User will click view details button on the legal users listing screen")
    public void clickViewDetailsButton() {
        legalEntitiesPageObject.getViewDetails_btn().waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    @And("User is able to see legacy organisation details on the legal users view details screen")
    public void verifyLegacyOrganisationDetails() {
        try{
            Assert.assertTrue(legalUsersPageObject.getViewScreen_legacycolumn_Action().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_legacycolumn_Legacy_Org_type().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_legacycolumn_Name_of_legacy_Org().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_legacycolumn_Parent_LEI_ID().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_legacycolumn_Parent_Org_name().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_legacycolumn_Source_Application().isVisible());
        }catch (AssertionError e){
            log.error("Elements Missing");
        }
    }

    @And("User is able to see Parent user details on the legal users view details screen")
    public void verifyParentUserDetails() {
        try {
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Action().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Contact_number().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Email_ID().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Parent_LEI_ID().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Parent_Org_name().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Password_status().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_Status().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_platformcolumn_username().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements"+e);
        }
    }

    @Then("User is able to see legacy user information on the legal users view details screen")
    public void verifyLegacyUserInformation() {
//        legalEntitiesPageObject.check_parentOrgInformation(dataTable);
        try {
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_LegacyUsername().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Legacy_Org().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Username().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Email_ID().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Contact_number().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Legacy_Org_type().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Source_Application().isVisible());
            Assert.assertTrue(legalUsersPageObject.getViewScreen_column_Platform_status().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements"+e);
        }
    }

    @And("user is able to Search for legacy user and set status on the legal users listing screen")
    public void type_Search_for_legacy_user_and_set_status_on_the_legal_users_listing_screen(DataTable table){
        legalUsersPageObject.Statusforlegacyusers(table);
        legalUsersPageObject.SearchforLegacyuser(table);


    }

    @When("User click on Create map in Platform button on the legal users listing screen")
    public void clickonCreate_in_Platform_button(){
        legalUsersPageObject.clickCreate_in_Platform_button();
    }

    @And("User click on the create new user in platform button on User does not exist POPUP")
    public void clickcreate_new_user_in_platform(){
        legalUsersPageObject.Clickoncreatenewuserinplatformonuserdoesnotexistinplatformpopup();
    }

    @When("Check if popup is present stop else add Legacy user")
    public void check_if_popup_is_present_stop_else_add_legacy_user()
    {
        legalUsersPageObject.check_popup_is_present_or_not();
    }
    @When("User is on create new Platform Users")
    public void user_is_on_create_new_platform_users()
    {
        Assert.assertTrue(legalUsersPageObject.getCeate_new_platform_user_page_header_text().isVisible());
    }

    @When("Fill data to create new Platform User")
    public void fill_data_to_create_new_platform_user(DataTable table)
    {
        legalUsersPageObject.insert_email(table);
        legalUsersPageObject.insert_first_name(table);
        legalUsersPageObject.insert_last_name(table);
        legalUsersPageObject.insert_parent_org_name(table);
    }
    @Then("user enter parent org on Create new platform user screen")
    public void Enterparentorg(DataTable datatable){
        platformUsersPageObject.typeParentOrg(datatable);
    }

}