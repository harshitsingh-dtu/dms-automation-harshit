package stepDefinations.PermissionsStep;
import PageObjects.Approval.ApprovalgroupCreatePageObject;
import PageObjects.Approval.ApprovalgroupPageObject;
import PageObjects.PermissionsPageObject.ApprovalGroupPermissionsPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import PageObjects.Login.LoginPageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
@Slf4j
@Data
public class ApprovalGroupPermissionsStep extends PageObject {
    LoginPageObject loginPageObject;
    ApprovalgroupCreatePageObject approvalgroupCreatePageObject;
    ApprovalGroupPermissionsPageObject approvalGroupPermissionsPageObject;
    ApprovalgroupPageObject approvalgroupPageObject;
    @Then("User organisation name is same as selected organisation name")
    public void user_organisation_name_is_same_as_selected_organisation_name() {
        try {
            withAction().pause(Duration.ofSeconds(5)).moveToElement(loginPageObject.getProfile()).click().pause(Duration.ofSeconds(4)).build().perform();
            Assert.assertEquals(approvalGroupPermissionsPageObject.getUser_organisation().getText().trim(), approvalgroupCreatePageObject.getOrganizationname_box().getValue().trim());

        } catch (Exception e) {
            log.error("Failing to compare organisations" + e);
        }
    }

    @And("User fills in the approval group name")
    public void user_fills_in_approval_group_name(DataTable table) {
        approvalgroupCreatePageObject.user_fills_the_group_name(table);
    }

    @And("User fills in the organisation name and checks if able to enter all orgs")
    public void user_fills_in_organisation_name_and_checks_if_able_to_enter_all_orgs(DataTable orgNameTable) {
        List<String> orgNames = orgNameTable.asList(String.class);
        try {
            for (String orgName : orgNames) {
                approvalgroupCreatePageObject.getOrganizationname_box().waitUntilClickable().clear();
                withAction().moveToElement(approvalgroupCreatePageObject.getOrganizationname_box()).click().sendKeys(orgName).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN, Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();

            }
        } catch (Exception e) {
            log.error("Unable to fill in the organization name -->" + e);
            Assert.fail();
        }
    }

    @And("User searches for group name in the search bar and checks Organisation is same as User")
    public void user_searches_for_group_name_and_checks_organisation(DataTable groupNameTable) {
        List<String> groupNames = groupNameTable.asList(String.class);
        try {
            for (String groupName : groupNames) {
                approvalgroupPageObject.getSearchbar().waitUntilClickable().clear();
                approvalgroupPageObject.getSearchbar().typeAndEnter(groupName);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().pause(Duration.ofSeconds(5)).moveToElement(loginPageObject.getProfile()).click().pause(Duration.ofSeconds(4)).build().perform();
                if (approvalGroupPermissionsPageObject.getUser_organisation().isVisible()){
                    Assert.assertEquals(approvalGroupPermissionsPageObject.getUser_organisation().getText().trim(), find(By.xpath("//tbody/tr[1]/td[2]")).getText().trim());

                }
            }
        }catch (Exception e){
            Assert.assertEquals(approvalGroupPermissionsPageObject.getUser_organisation().getText().trim(), find(By.xpath("//tbody/tr[1]/td[1]")).getText().trim());

        }

    }
}