package stepDefinations.PlatformServicesStep;

import PageObjects.PlatformServices.LegalEntitiesPageObject;
import PageObjects.PlatformServices.PlatformServicesPageObject;
import PageObjects.PlatformServices.PlatformUsersPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;

@Slf4j
public class PlatformUsersStep extends PageObject {
    PlatformServicesPageObject platformServicesPageObject;
    PlatformUsersPageObject platformUsersPageObject;
    LegalEntitiesPageObject legalEntitiesPageObject;
    @Then("User is able to select Platform users")
    public void selectPlatformUsers() {
        platformServicesPageObject.clickPlatformUsers();
    }

    @Then("User redirects to the Platform users screen")
    public void verifyPlatformUsersScreen() {
        platformServicesPageObject.verifyPlatformUsers();
    }
    @Then("User is able to see search by user email on the Platform Users listing screen")
    public void verifySearchByUserEmail() {
        Assert.assertTrue(platformUsersPageObject.getSearch_ByuserEmail().isVisible());
    }

    @And("User is able to see filter parent orgs on the Platform Users listing screen")
    public void verifyFilterParentOrgs() {
        Assert.assertTrue(platformUsersPageObject.getFilter_parentOrgs().isVisible());
    }

    @And("User is able to see filter last updated by on the Platform Users listing screen")
    public void verifyFilterLastUpdatedBy() {
        Assert.assertTrue(platformUsersPageObject.getFilter_lastUpdatedBy().isVisible());
    }

    @And("User is able to see filter date on the Platform Users listing screen")
    public void verifyFilterDate() {
        Assert.assertTrue(platformUsersPageObject.getFilter_date().isVisible());
    }

    @And("User is able to see filter password status on the Platform Users listing screen")
    public void verifyFilterPasswordStatus() {
        Assert.assertTrue(platformUsersPageObject.getFilter_passwordStatus().isVisible());
    }

    @And("User is able to see filter status on the Platform Users listing screen")
    public void verifyFilterStatus() {
        Assert.assertTrue(platformUsersPageObject.getFilter_status().isVisible());
    }

    @And("User is able to see create platform user button on the Platform Users listing screen")
    public void verifyCreatePlatformUserButton() {
        Assert.assertTrue(platformUsersPageObject.getCreateNewUser_btn().isVisible());
    }

    @And("User is able to see all the elements on the Platform Users listing screen")
    public void verifyAllElements() {
        try {
            Assert.assertTrue(platformUsersPageObject.getColumn_Email_Id().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_First_name().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Last_name().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Parent_organisation().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Last_updated_on().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Last_updated_by().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Password_status().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Action().isVisible());
            Assert.assertTrue(platformUsersPageObject.getColumn_Status().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements");
        }
    }
    @And("User is able to see view details button on the Platform Users listing screen")
    public void verifyViewDetailsButton() {
        Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
    }

    @Then("User will click view details button on the Platform Users listing screen")
    public void clickViewDetailsButton() {
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertTrue(legalEntitiesPageObject.getViewDetails_btn().isVisible());
            legalEntitiesPageObject.getViewDetails_btn().waitUntilClickable().click();
        }catch(AssertionError e){
            log.error("view detail button is found");
            Assert.fail();
        }
    }
    @And("User is able to see Parent org details on the legal users view details screen")
    public void verifyParentOrgDetails() {
        try {
            Assert.assertTrue(platformUsersPageObject.getViewscreen_parentorg_column_Active_users().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_parentorg_column_Action().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_parentorg_column_Parent_org_name().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_parentorg_column_Total_users().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_parentorg_column_Parent_LEI_ID().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements");
        }
    }

    @And("User is able to see legacy users Parent org details on the legal users view details screen")
    public void verifyLegacyUsersParentOrgDetails() {
        try {
            Assert.assertTrue(platformUsersPageObject.getViewscreen_legacyuser_column_Contact_Number().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_legacyuser_column_Source_application().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_legacyuser_column_Legacy_org().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_legacyuser_column_Legacy_org_type().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_legacyuser_column_User_full_name().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_legacyuser_column_Username().isVisible());

        }catch (AssertionError e){
            log.error("Missing Elements");
        }
    }
    @Then("User is able to see platform user information on the Platform Users view details listing screen")
    public void verifyPlatformUserInformation() {
        try {
            Assert.assertTrue(platformUsersPageObject.getViewscreen_column_Users_name().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_Parent_Org().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_column_Email_Id().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_Contact_Number().isVisible());
            Assert.assertTrue(platformUsersPageObject.getViewscreen_Password_status().isVisible());
        }catch (AssertionError e){
            log.error("Missing Elements"+e);
        }
    }

    @Then("User will Search for Platform user by Email on the Platform Users listing screen")
    public void User_will_Search_for_Platform_user_by_Email_on_the_Platform_Users_listing_screen(DataTable datatable){
        platformUsersPageObject.typesearchbytheemail(datatable);

    }
    @When("User Will Click Update Parent Button under Parent org Details Section on Platform User's Details Screen")
    public void User_Will_Click_Update_Parent_Button_under_Parent_org_Details_Section_on_Platform_User_Details_Screen(){
        platformUsersPageObject.verifyupdateParentButtonFunctionality();
    }

    @And("User is able to Search Parent Org-Legal Entity by giving org name on Platform User's Details Screen")
    public void User_is_able_to_Search_Parent_Org_Legal_Entity_by_giving_org_name_on_Platform_User_Details_Screen(DataTable dataTable){
        platformUsersPageObject.searchorgnameforupdateparent(dataTable);
    }

    @Then("User is able to update parent for Required LEI's by Clicking on Select As Parent button")
    public void User_is_able_to_update_parent_for_Required_LEI_by_Clicking_on_Select_As_Parent_button(){
        platformUsersPageObject.setasparentforsearchedorg();
    }

    @And("User will click on create platform user button platform users screen")
    public void click_Create_plateform_user(){
        platformUsersPageObject.clickCreatenewplateformuser();
    }

    @When("User will Enter User Email ID Create new platform users Screen")
    public void User_will_Enter_User_Email_ID_Create_new_platform_users_Screen(DataTable datatable){
        platformUsersPageObject.typeuseremailoncreatenewplatformuserscreen(datatable);
    }

    @And("Click on Submit Button Create new platform users Screen")
    public void Click_on_Submit_Button_Create_new_platform_users_Screen(){
        platformUsersPageObject.SubmitButton_Createnew_platform_usersScreen();
    }

    @Then("User Will able to see user Details and Legacy details connected Section")
    public void User_Will_able_to_see_user_Details_and_Legacy_details_connected_Section(){
        try {
            Assert.assertTrue(platformUsersPageObject.getUserDetails_section().isVisible());
            Assert.assertTrue(platformUsersPageObject.getLegacydetails_connected_with_email_Section().isVisible());
        }catch (AssertionError e){
            log.info("unable to found user Detail and Legacy Detail");
            Assert.fail();
        }
    }

    @And("User will Enter First name, Last name, Contact number and Parent org in the user details Section on Create new platform users Screen")
    public void User_will_Enter_required_details_in_user_details_Section_on_Create_new_platform_users_Screen(DataTable datatable){
        platformUsersPageObject.typeFirstname(datatable);
        platformUsersPageObject.typeLastname(datatable);
        platformUsersPageObject.typeContactNumber(datatable);
        platformUsersPageObject.typeParentOrg(datatable);
    }

    @And("User Will Click on Submit Button and respond the success popup")
    public void User_Will_Click_on_Submit_Button_and_respond_the_success_popup(){
        platformUsersPageObject.ClickonSubmitButtonandrespondthesuccesspopup();
    }


}