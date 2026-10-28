package PageObjects.PermissionsPageObject;
import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import io.cucumber.java.bs.A;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
import java.util.List;
@Data
@Slf4j
public class OrganisationPermissionsPageObject extends PageObject{
    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    public void Select_userRoles(List<String> userRolesList){
        try {
            // first ! check if the role is selected in the already selected list,if yes-->> go to next role
            userManagementEditDetailsPageObject.getSelectedRoles();
            for (int begin=1;begin<userRolesList.size();begin++){
                log.info(userManagementEditDetailsPageObject.getSelectedRoles().getText());
                if (userManagementEditDetailsPageObject.getSelectedRoles().getText().contains(userRolesList.get(begin))){
                    continue;
                }
                else {
                    userManagementEditDetailsPageObject.checkrolemapping();
                    userManagementEditDetailsPageObject.getRoleMapping().waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    withAction().moveToElement(userManagementEditDetailsPageObject.getRoleMapping()).click().sendKeys(userRolesList.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                }
            }
            //if role not selected, user will search and select the role
        }catch (Exception e){
            Assert.fail("User was unable to set the desired roles"+e);
        }
    }
    public void random_4Way_LEI_Orgtype_Mapping(){
        try {
            //doc type
            userManagementEditDetailsPageObject.getDoctype().waitUntilClickable();
            withAction().moveToElement(userManagementEditDetailsPageObject.getDoctype()).click().sendKeys("4 Way").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            //LEI
            withAction().moveToElement(userManagementEditDetailsPageObject.getSearch_LEI()).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            //OrgType
            withAction().moveToElement(userManagementEditDetailsPageObject.getSearch_orgType()).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(userManagementEditDetailsPageObject.getAdd_btn()).click().pause(Duration.ofSeconds(3)).build().perform();
        }catch (Exception e){
            Assert.fail("Unable to assign Mapping to User");
        }
    }
}
