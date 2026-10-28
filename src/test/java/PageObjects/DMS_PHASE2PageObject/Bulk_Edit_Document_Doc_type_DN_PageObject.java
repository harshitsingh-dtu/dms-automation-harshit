package PageObjects.DMS_PHASE2PageObject;

import net.serenitybdd.core.pages.PageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
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
public class Bulk_Edit_Document_Doc_type_DN_PageObject extends PageObject
{
    @FindBy(xpath="//button[text()='Bulk Action']")
    private WebElementFacade Bulk_action_button;
    @FindBy(xpath = "//li[text()=' Approve']")
    private WebElementFacade bulk_action_Approve_btn;
    @FindBy(xpath = "//li[text()='Edit']")
    private WebElementFacade bulk_action_edit_btn;
    @FindBy(xpath = "//li[text()=' Reject']")
    private WebElementFacade bulk_action_Reject_btn;
    @FindBy(xpath = "//li[text()='Terminate']")
    private WebElementFacade bulk_action_Terminate_btn;
    @FindBy(xpath = "//input[@placeholder='Select Roles']")
    private WebElementFacade search_role_input;
    @FindBy(xpath = "//*[@data-testid='CheckBoxIcon']")
    private WebElementFacade searched_Result_checkbox;

    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade searched_Result_text;
    @FindBy(xpath = "//div[@class='alert-msg']")
    private WebElementFacade Confirmation_alert_popup_for_role;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade Confirmation_alert_popup_yes_btn;
    @FindBy(xpath = "//div[@class='dms-role-list']")
    private WebElementFacade selectedRoles;
    @FindBy(xpath ="//input[@placeholder='Select Roles']")
    private WebElementFacade  roleMapping;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;
    @FindBy(xpath = "//li[text()=' Approve']")
    private WebElementFacade Bulk_action_Approve_btn;
    @FindBy(xpath = "//li[text()=' Reject']")
    private WebElementFacade Bulk_action_Reject_btn;
    @FindBy(xpath = "//li[text()='Edit']")
    private WebElementFacade bulk_action_Edit_btn;
    @FindBy(xpath = "//li[text()='Terminate']")
    private WebElementFacade bulk_Terminate_approve_btn;

    @FindBy(xpath = "//input[@placeholder='Select Doc Type']")
    private WebElementFacade Bulk_action_popup_doc_type_input;
    @FindBy(xpath = "//input[@id='react-select-2-input']")
    private WebElementFacade Bulk_action_popup_acting_as_input;
    @FindBy(xpath = "//label[text()='Approval group']/following::input")
    private WebElementFacade Bulk_action_popup_approval_group_input;
    @FindBy(xpath = "//label[text()='Action type']/following::input")
    private WebElementFacade Bulk_action_popup_action_type_input;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Bulk_action_popup_cancel_button;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade Bulk_action_popup_next_button;
    @FindBy(xpath = "//tr/td[text()='DN']")
    private WebElementFacade Assigned_LEI_with_DN;

    @FindBy(xpath = "//div[@class='select-container']//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctype;
    @FindBy(xpath ="//div[text()='Select LEIs']")
    private WebElementFacade search_LEI;
    @FindBy(xpath ="//div[@class='select-container']//input[@placeholder='Select Org Type']")
    private WebElementFacade search_orgType;
    @FindBy(xpath = "//button[text()='+ Add']")
    private WebElementFacade add_btn;
    @FindBy(xpath = "//button[text()='Columns Selection']")
    private WebElementFacade columns_selection_button;
    @FindBy(xpath = "//div[@class='columns-content']")
    private WebElementFacade columns_selection_list;
    @FindBy(xpath = "//button[text()='Terminate']")
    private WebElementFacade Terminate_button;
    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade Approve_button;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade Cancel_button;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade Next_button;
    @FindBy(xpath = "//button[text()='Reject']")
    private WebElementFacade Reject_button;
    @FindBy(xpath = "//input[@checked]")
    private WebElementFacade Select_all_checkbox;
    @FindBy(xpath = "//tr/td")
    private WebElementFacade List_of_doc_for_bulk_action;
    @FindBy(xpath = "(//td//input[@type='checkbox'])[1]")
    private WebElementFacade Select_first_doc_checkbox;
    @FindBy(xpath = "(//div[@class='link'])[1]")
    private WebElementFacade first_doc_version_id;
    @FindBy(xpath = "//span[@id='version']//strong")
    private WebElementFacade doc_version_id_on_bulk_action_edit_limit;
    @FindBy(xpath = "//div[text()='No options']")
    private WebElementFacade Bulk_action_popup_no_options;
    @FindBy(xpath = "//button[@class='Toastify__close-button Toastify__close-button--light']")
    private WebElementFacade toast_msg_close_button;
    @FindBy(xpath ="//div[@class='lei-org-title']//input[@placeholder='Select Org Type']")
    private WebElementFacade search_org_Type_from_assign_lei;

    public void Submit_btn()
    {
        if (Submit_btn.isEnabled())
        {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Submit_btn.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (toast_msg_close_button.isEnabled()){
                toast_msg_close_button.click();
            }
        }
        else {
            log.info("Submit button is not enabled trying to do next step");
        }
    }
    public void assign_role(List<String> roles)
    {
        try {
            // first ! check if the role is selected in the already selected list,if yes-->> go to next role

            for (int begin=1;begin<roles.size();begin++){
                log.info(selectedRoles.getText());
                if (selectedRoles.getText().contains(roles.get(begin))){
                    continue;
                }
                else {
                    if (roleMapping.isVisible()) {
                        log.info("Role Mapping dropdown is visible");
                    }
                    else {
                        log.info("Role Mapping dropdown not visible");
                    }
                    roleMapping.waitUntilClickable();
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    roleMapping.clear();
                    withAction().moveToElement(roleMapping).click().sendKeys(roles.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
                }
            }
            //if role not selected, user will search and select the role
        }catch (Exception e){
            Assert.fail("User was unable to set the desired roles"+e);
        }
    }


    public void Assign_LEI_with_DN_doc_type()
    {
        withAction().moveToElement(search_org_Type_from_assign_lei).click().sendKeys("PB").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (!Assigned_LEI_with_DN.isVisible())
        {
            doctype.waitUntilClickable();
            withAction().moveToElement(doctype).click().sendKeys("DN").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            //LEI
            withAction().moveToElement(search_LEI).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            //OrgType
            withAction().moveToElement(search_orgType).pause(Duration.ofSeconds(2)).click().sendKeys("PB").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(add_btn).click().pause(Duration.ofSeconds(3)).build().perform();

        }
        search_org_Type_from_assign_lei.clear();
    }

    public void Select_acting_as()
    {
        withAction().moveToElement(Bulk_action_popup_acting_as_input).click().sendKeys("").pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }
    public void Select_document_type_DN()
    {
        withAction().moveToElement(Bulk_action_popup_doc_type_input).click().sendKeys("DN").pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void Select_action_type(List<String>action_type)
    {
        withAction().moveToElement(Bulk_action_popup_action_type_input).click().sendKeys(action_type.get(1),Keys.ARROW_DOWN,Keys.ENTER).build().perform();
    }
    public void check_columns_selection_list(List<String>columns_list)
    {

        columns_selection_button.click();
        for (int begin=1;begin<columns_list.size();begin++)
        {

            if (columns_selection_list.getText().contains(columns_list.get(begin)))
            {
                log.info(columns_list.get(begin)+"-->is present");
            }
            else
            {
                log.info(columns_list.get(begin)+"-->is not present in columns list");
                Assert.fail();
            }


        }

    }
    public void Select_Approval_group()
    {
        Bulk_action_popup_approval_group_input.click();
        if (!Bulk_action_popup_no_options.isVisible())
        {
          withAction().moveToElement(Bulk_action_popup_approval_group_input).sendKeys("",Keys.ARROW_DOWN,Keys.ENTER).build().perform();
          withAction().pause(Duration.ofSeconds(2)).build().perform();
        }

    }
    public void select_document_for_bulk_action()
    {
        Select_first_doc_checkbox.click();
        log.info(first_doc_version_id.getText()+"----> document is selected for bulk action");
    }
    public void Fail_msg()
    {
        log.info("Unable to perform this step due to test data TC going to fail");
    }


}
