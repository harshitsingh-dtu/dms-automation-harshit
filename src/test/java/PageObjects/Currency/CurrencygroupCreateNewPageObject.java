package PageObjects.Currency;

import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
@Slf4j
@Data
public class CurrencygroupCreateNewPageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath = "//button[text()='+ Create New Group']")
    private WebElementFacade createnewgrp_btn;
    @FindBy(xpath ="//input[@placeholder='Enter currencies group name']")
    private WebElementFacade groupname;
    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationName;
    @FindBy(xpath = "//input[@value='CURRENCYGROUP']")
    private WebElementFacade currencygrp_radio;
    @FindBy(xpath = "//input[@value='CURRENCYPAIR']")
    private WebElementFacade currencypairgrp_radio;
    @FindBy(xpath ="//input[@placeholder='Search by currencies group name']")
    private WebElementFacade search;
    @FindBy(xpath ="//button[text()='Currencies-pair group']")
    private WebElementFacade currencyPairgrptab;
    @FindBy(xpath = "//div[contains(@data-testid,'left-currency-accordion-title-Deliverable')]")
    List<WebElementFacade> deliverable;
    @FindBy(xpath = "//div[contains(@data-testid,'left-currency-accordion-title-Non Deliverable')]")
    List<WebElementFacade> non_deliverable;
    @FindBy(xpath ="//div[@class='header-label' and text()='Deliverable and Non Deliverable']")
    List<WebElementFacade> non_deliverable_deliverable;
    @FindBy(xpath ="//button[@class='card  ']")
    List<WebElementFacade> deliverable_available_currencies;
    @FindBy(xpath ="//div[@class='header-label' and text()='Deliverable']")
    List<WebElementFacade> deliverabletext;
    @FindBy(xpath ="//button[@class='card  pink-icon']")
    List<WebElementFacade> deliverable_nondeliverable_available_currencies;
    @FindBy(xpath ="//button[@class='card  ']")
    List<WebElementFacade> bullion_currency;
    @FindBy(xpath ="//button[@class='card  ']")
    List<WebElementFacade> bullion_currency_pair;

    String groupnametxt="auto_test";
    public void clickcreatenewgrp_btn(){
        try {
            createnewgrp_btn.waitUntilClickable();
            createnewgrp_btn.click();
            withAction().pause(Duration.ofSeconds(10)).build().perform();
        }catch (Exception e){
            log.error("Not able to redirect to create new group screen");
        }

    }
    public void typesgrpname(List<String> currencygroupname){
        try {
            StringBuilder randomStr =  DocumentTemplateCreatePageObject.randomStringGenerator();
            groupname.waitUntilVisible();
            groupname.clear();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(groupname).click().sendKeys(currencygroupname.get(1)+ LocalDate.now()+randomStr).build().perform();
//            +java.time.LocalTime.now()
        }catch (Exception e){
            log.error("Not able to type in the group name");
        }
    }
    public void typesgrpnamecurrencypair(){

        groupname.waitUntilVisible();
        groupname.clear();
        groupname.type(groupnametxt);
    }

    public void typesorganizationname(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            organizationName.waitUntilClickable().clear();
//            withAction().moveToElement(organizationName).click().sendKeys(dataTable.get("organisation name")).pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().moveToElement(organizationName).click().sendKeys(dataTable.get("organisation name")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        }catch (Exception e){
            log.error("Not able to typpe in the organization name");
        }
    }
    public void selectcurrencygrp(){
        currencygrp_radio.waitUntilClickable();
        currencygrp_radio.click();
    }
    public void selectcurrencypairgrp(){
        currencypairgrp_radio.waitUntilClickable();
        currencypairgrp_radio.click();
    }

    public void navigatetocurrencypairtab(){
        try{
            currencyPairgrptab.waitUntilClickable();
            currencyPairgrptab.click();
        }

        catch (Exception e){
            log.error("Not able to switch on currency pair tab");
        }
    }
    public void searchCurrencygroup(List<String> currencygroupname){
        try {
            search.waitUntilVisible();
            search.type(currencygroupname.get(1)+LocalDate.now());
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Not able to search for the currency group");
        }

    }

    public void typesgrouppname(DataTable table) {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            try {
                groupname.waitUntilVisible().click();
                groupname.clear();
                typeInto(groupname, dataTable.get("Currency group"));
                act.pause(Duration.ofSeconds(2)).build().perform();
            } catch (Exception e) {
                log.error("unable to type -->" + e);
                Assert.fail();
            }

    }
    }