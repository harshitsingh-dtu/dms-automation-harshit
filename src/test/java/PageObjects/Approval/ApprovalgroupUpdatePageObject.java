package PageObjects.Approval;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class ApprovalgroupUpdatePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//div[@class='header'][text()='Update approval group']")
    private WebElementFacade updateapprovalgrp_txt;

    @FindBy(xpath = "//input[@placeholder='Search by Email id' or @placeholder='Search by email id']")

    private WebElementFacade searchUser;
    String[] userstoAdd={"shashank.singhvi@ihsmarkit.com"};

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElementFacade useradd_btn;

    @FindBy(xpath = "//tr//div[@class='cross-icon ']")
    private WebElementFacade user_remove_btn;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElementFacade submit_btn;
    @FindBy(xpath = "//div[@class='ops-list']/p[text()='No Record Found']")
    private WebElementFacade norecordsfoundtxt;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']//div[2]")
    private WebElementFacade approvalGroupNotification;
    @FindBy(xpath = "//div[contains(@class, 'delete')]/*[local-name()='svg']")
    private WebElementFacade deleteIcon;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElementFacade yesButton;
    @FindBy(xpath = "//button[normalize-space()='No']")
    private WebElementFacade noButton;

    public void checkifonupdatescreen(){
        try {

            withAction().pause(Duration.ofSeconds(4)).build().perform();
            updateapprovalgrp_txt.waitUntilVisible();
            Assert.assertTrue(updateapprovalgrp_txt.isVisible());}
        catch (AssertionError e){
            log.error("Unable to verify whether on the update screen -->"+e);
            Assert.fail();
        }
    }

    public void searchandAddUsers(DataTable users){
        List<Map<String, String>> data = users.asMaps(String.class, String.class);

        try {
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            for (Map<String, String> user: data){
                HashMap<String, String> dataTable = Maps.newHashMap(user);
                searchUser.clear();
                withAction().moveToElement(searchUser).click().sendKeys(dataTable.get("user")).pause(Duration.ofSeconds(4)).build().perform();

                if (useradd_btn.isPresent()){
                    useradd_btn.click();
                }
                else {
                    Assert.assertTrue(norecordsfoundtxt.isVisible());
                    log.info("User not present");
                }

            }
        }catch (Exception e){
            log.error("Unable to add user -->"+e);
            Assert.fail();
        }

    }

    public void searchandRemoveUsers(List<String> users){
        try {
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            for (int user=1;user<users.size();user++){

//                find(By.xpath("//tr//td[text()='"+users.get(user)+"']")).isVisible();
                if (find(By.xpath("//tr//td[text()='"+users.get(user)+"']")).isVisible()){
                    find(By.xpath("//td[text()='"+users.get(user)+"']//parent::tr//child::td//div[@class='cross-icon ']")).click();
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    //td[text()='app user']//parent::tr//child::td//div[@class='cross-icon ']
                }
                else {
                    log.info("User not present");
                }

            }
        }catch (Exception e){
            log.error("Unable to remove user"+e);
            Assert.fail();
        }
    }

    public void submitchanges()  {
        try {
            submit_btn.withTimeoutOf(Duration.ofSeconds(15)).waitUntilClickable();
            evaluateJavascript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", submit_btn);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            evaluateJavascript("arguments[0].click();", submit_btn.getElement());
            withAction().pause(Duration.ofSeconds(5)).build().perform();
        } catch (Exception e) {
            log.error("Unable to submit the changes-->" + e.getMessage());
            Assert.fail("Failed to click submit button: " + e.getMessage());
        }

    }

    public void searchUsersAndValidateNoRecordFound(DataTable users) {
        List<Map<String, String>> data = users.asMaps(String.class, String.class);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            for (Map<String, String> user : data) {
                searchUser.clear();
                withAction().moveToElement(searchUser).click().sendKeys(user.get("user")).pause(Duration.ofSeconds(4)).build().perform();
                Assert.assertFalse(
                        "User was found and Add button is visible, but mapping should not exist",
                        useradd_btn.isPresent()
                );
                Assert.assertTrue(
                        "'No Record Found' message is not displayed",
                        norecordsfoundtxt.isVisible()
                );
                log.info("No Record Found displayed as expected for user: {}", user.get("user"));
            }

        } catch (Exception e) {
            log.error("Validation failed for No Record Found scenario", e);
            Assert.fail();
        }
    }

}