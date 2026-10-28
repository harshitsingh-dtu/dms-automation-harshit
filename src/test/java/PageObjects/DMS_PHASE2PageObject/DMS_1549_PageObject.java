package PageObjects.DMS_PHASE2PageObject;

import PageObjects.UserManagement.UserManagementEditDetailsPageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.List;

@Data
@Slf4j
public class DMS_1549_PageObject extends PageObject {
    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade rolemapping_dropdown_list;
    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade  roleMapping;
    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade Profileicon;
    @FindBy(xpath = "(//div[text()='Organisation name']//following-sibling::div")
    private WebElementFacade UserOrganisationName;

    UserManagementEditDetailsPageObject userManagementEditDetailsPageObject;
    public void check_DN_roles(List<String> userRolesList){
        try{
            withAction().moveToElement(roleMapping).click().build().perform();
            for (int begin=1;begin<userRolesList.size();begin++){
                if (!rolemapping_dropdown_list.getText().contains(userRolesList.get(begin))){
                    Assert.fail();
                }

            }
        }catch (Exception e){
            log.error("the following expection faced"+ e);
        }
    }
    public void check_4W_roles(List<String> userRolesList){
        try{
            withAction().moveToElement(roleMapping).click().build().perform();
            for (int begin=1;begin<userRolesList.size();begin++){
                if (!rolemapping_dropdown_list.getText().contains(userRolesList.get(begin))){
                    Assert.fail();
                }
            }
        }catch (Exception e){
            log.error("the following expection faced"+ e);
        }
    }
    public void check_admin_roles(List<String> userRolesList){
        try{
           if (UserOrganisationName.getText().equalsIgnoreCase("Osttra")){
               withAction().moveToElement(roleMapping).click().build().perform();
               log.info("method");
               for (int begin=1;begin<userRolesList.size();begin++){
                   if (!rolemapping_dropdown_list.getText().contains(userRolesList.get(begin))){
                       Assert.fail();
                   }
               }
            }


        }catch (Exception e){
            log.error("the following expection faced"+ e);
        }
    }
    public void check_assigned_roles(List<String> userRolesList){
            try {
                for (int begin=1;begin<userRolesList.size();begin++){
                    log.info(userManagementEditDetailsPageObject.getSelectedRoles().getText());
                    if (!userManagementEditDetailsPageObject.getSelectedRoles().getText().contains(userRolesList.get(begin))){
                        Assert.fail();
                    }}

    }catch (Exception e){
            log.error("Roles not found"+e);}
    }
}
