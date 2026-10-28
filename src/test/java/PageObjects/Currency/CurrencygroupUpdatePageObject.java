package PageObjects.Currency;

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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Data
public class CurrencygroupUpdatePageObject extends PageObject {
    Actions act=new Actions(getDriver());
    @FindBy(xpath ="//div[@class='input-search']//input")
    private WebElementFacade searchSelectCurrency;

    @FindBy(xpath ="//button[@class='card  ']//span")
    private WebElementFacade searchedCurrency;
    @FindBy(xpath ="//button[contains(@class, 'card')]//span")
    private WebElementFacade searchedCurrencyforDFAuthScope;
    @FindBy(xpath ="//input[@placeholder='Search currencies']")
    private WebElementFacade searchedCurrencyForAdvanceFilter;
    @FindBy(xpath ="(//*[@class='card  pink-icon' or @class='card  '])[2]")
    private WebElementFacade searchedNon_DeliverableCurrency;
    @FindBy(xpath ="//button[@class='card  ']")
    private WebElementFacade searchedCurrencyCurrencyPair;
//    @FindBy(xpath ="//div[@class='card-content']//button")
//    private WebElementFacade searchedCurrencyDF;
//    @FindBy(xpath ="(//div[contains(., 'Non Deliverable')]//div[@class='card-content']//button)[2]")
//    private WebElementFacade searchedNonDeliverableCurrencyDF;
    @FindBy(xpath ="//div[contains(@class,'filter')]//input[contains(@placeholder,'Search currencies')]")
    private WebElementFacade searchRemoveCurrency;
    @FindBy(xpath = "//button[text()='+ Add currencies']")
    private WebElementFacade authCurrencies;

    @FindBy(xpath ="//*[contains(@class,'card card-select')]")
    private WebElementFacade searchedRemoveCurrency;
    @FindBy(xpath = "//input[@placeholder='Currencies Group']")
    private WebElementFacade searchCurrencyName;
    @FindBy(xpath = "//button[text()='Currencies-pair']")
    private WebElementFacade clickCurrencyGroupPair;
    @FindBy(xpath = "//button[text()='Currencies']")
    private WebElementFacade clickCurrenciesButton;
    @FindBy(xpath ="//button[normalize-space()='Cancel']")
    private WebElementFacade cancel_btn;

    @FindBy(xpath ="//input[@placeholder='Enter currencies group name']")
    private WebElementFacade groupname;

    @FindBy(xpath = "//input[@data-testid='left-select-all-checkbox-Deliverable']")
    private WebElementFacade selectAll_Deliverable;

    @FindBy(xpath = "//input[@placeholder='Select Organisation']")
    private WebElementFacade organizationName;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElementFacade submit_btn;

    @FindBy(xpath = "//div[text()='No Data']")
    private WebElementFacade currency_nodata;
    @FindBy(xpath = "//label[text()='Bullion']")
    private WebElementFacade BullionCheckbox;
    @FindBy(xpath = "//div[contains(@data-testid,'left-currency-accordion-title-Non Deliverable')]")
    private List<WebElementFacade> NonDeliverableField;
    @FindBy(xpath = "//div[contains(@data-testid,'left-currency-accordion-title-Deliverable')]")
    private List<WebElementFacade> DeliverableField;
    @FindBy(xpath = "//div[text()='Deliverable:']")
    private List<WebElementFacade> DeliverableFieldForAuthLine;
    @FindBy(xpath = "//div[text()='Deliverable and Non Deliverable']")
    private List<WebElementFacade> BothDeliverableAndNonDeliverableField;
    @FindBy(xpath =
            "//div[contains(@id,'panel-content')]" +
                    "//div[contains(@class,'currency-card-wrapper')]//button//span"
    )
    private List<WebElementFacade> deliverableCurrencies;
    @FindBy(xpath = "//div[contains(@id,'panel-header-Deliverable')]")
    private WebElementFacade deliverableAccordion;
    @FindBy(xpath = "//div[contains(@id,'panel-header-Non-Deliverable')]")
    private WebElementFacade nonDeliverableAccordion;
    @FindBy(xpath = "//button[text()='Currencies-pair']")
    private WebElementFacade CurrencyGroupPairTab;
    @FindBy(xpath = "//*[normalize-space(text())='Select All' or normalize-space(text())='Select all']//ancestor::label//input")
    private List<WebElementFacade> selectAllCheckboxes;
    @FindBy(xpath = "(//*[normalize-space(text())='All CCY Permitted']/preceding-sibling::span//div//span)[1]")
    private WebElementFacade allCurrencyPermittedCheckbox;


    public void checkifsearchcurrency(List<String > currency){
        searchSelectCurrency.waitUntilVisible();
        searchSelectCurrency.clear();
        searchSelectCurrency.type(currency.get(1));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        searchedCurrency.waitUntilVisible();
        //searchedCurrency.shouldContainOnlyText(currency);
    }

    public void checkifsearchcurrencyPair(List<String> currency) {
        act.pause(Duration.ofSeconds(5)).build().perform();
        searchSelectCurrency.waitUntilVisible();
        searchSelectCurrency.clear();
        searchSelectCurrency.type(currency.get(1));
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        searchedCurrency.waitUntilVisible();
    }

    public void search_for_the_currency_and_select_them(List<String> selectcurrencyList) {
        for (int begin = 1; begin < selectcurrencyList.size(); begin++) {
            String currencyName = selectcurrencyList.get(begin);

            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(currencyName);
            withAction().pause(Duration.ofSeconds(4)).build().perform();

            String xpath = "//button[contains(@class, 'card')]//span[normalize-space(text())='" + currencyName + "']";
            List<WebElementFacade> occurrences = findAll(By.xpath(xpath));

            if (occurrences.isEmpty()) {
                log.info("No currency cards found for: " + currencyName);
            } else {
                for (WebElementFacade occurrence : occurrences) {
                    if (occurrence.isCurrentlyVisible()) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", occurrence);
                        withAction().pause(Duration.ofSeconds(1)).build().perform();
                        occurrence.waitUntilClickable().click();
                        log.info("Clicked on currency occurrence for: " + currencyName);
                        withAction().pause(Duration.ofSeconds(1)).build().perform();
                    }
                }
            }
        }
    }

    public void updated_search_for_the_currency_and_select_them(List<String> updated_currencyList){
        for (int begin=1;begin<updated_currencyList.size();begin++){
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(updated_currencyList.get(begin));
            searchedCurrency.waitUntilEnabled();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            searchedCurrency.click();
//            searchSelectCurrency.clear();
//            searchSelectCurrency.type(selectcurrencyList.get(begin));
//            searchedCurrency.click();
        }
    }

    public void updated_search_for_the_currency_and_select_them_for_DF_AuthScope(List<String> updated_currencyList){
        for (int begin=1;begin<updated_currencyList.size();begin++){
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(updated_currencyList.get(begin));
            searchedCurrencyforDFAuthScope.waitUntilEnabled();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            searchedCurrencyforDFAuthScope.click();
        }
    }

    private WebElementFacade currencyCardInNonDeliverableDF(String currency) {
        String upperCurrency = currency.trim().toUpperCase();
        return find(By.xpath(
                "//div[contains(@data-testid,'left-currency-accordion-details-Non Deliverable')]" +
                        "//button[.//span[normalize-space()='" + upperCurrency + "']]"
        ));
    }
//    public void search_for_the_NonDeliverablecurrency_and_select_them(List<String> updated_currencyList){
//        for (int begin=1;begin<updated_currencyList.size();begin++){
//            searchSelectCurrency.waitUntilVisible();
//            searchSelectCurrency.clear();
//            searchSelectCurrency.type(updated_currencyList.get(begin));
//            if (searchedCurrencyDF.isVisible()){
//                withAction().pause(Duration.ofSeconds(5)).build().perform();
//                searchedCurrencyDF.waitUntilVisible().click();
////                submit_btn.click();
//                withAction().pause(Duration.ofSeconds(5)).build().perform();
//            }
//            else {
//                Assert.assertTrue(currency_nodata.isVisible());
//            }
////            submit_btn.click();
//        }
//        submit_btn.click();
//    }

public void search_for_the_NonDeliverablecurrency_and_select_them(List<String> updated_currencyList){
    for (int begin=1;begin<updated_currencyList.size();begin++){
        String currency = updated_currencyList.get(begin);
        searchSelectCurrency.waitUntilVisible();
        searchSelectCurrency.clear();
        searchSelectCurrency.type(currency);
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        WebElementFacade card = currencyCardInNonDeliverableDF(currency);
        if (card.isPresent()) {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", card);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            card.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } else {
            Assert.assertTrue(currency_nodata.isVisible());
        }
    }
    submit_btn.click();
}

//    public void search_for_the_NonDeliverablecurrency(List<String> updated_currencyList){
//        for (int begin=1;begin<updated_currencyList.size();begin++){
//            searchSelectCurrency.waitUntilVisible();
//            searchSelectCurrency.clear();
//            searchSelectCurrency.type(updated_currencyList.get(begin));
//            if (searchedNonDeliverableCurrencyDF.isVisible()){
//                withAction().pause(Duration.ofSeconds(5)).build().perform();
//                searchedNonDeliverableCurrencyDF.waitUntilVisible().click();
//            }
//            else {
//                Assert.assertTrue(currency_nodata.isVisible());
//            }
//        }
//    }

    public void search_for_the_NonDeliverablecurrency(List<String> updated_currencyList){
        for (int begin=1;begin<updated_currencyList.size();begin++){
            String currency = updated_currencyList.get(begin);
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(currency);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            WebElementFacade card = currencyCardInNonDeliverableDF(currency);
            if (card.isPresent()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", card);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                card.waitUntilVisible().click();
            } else {
                Assert.assertTrue(currency_nodata.isVisible());
            }
        }
    }

    public void search_for_the_currency_pair_and_select_them(List<String> selectcurrencyList){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        try {
            for (int begin=1;begin<selectcurrencyList.size();begin++){
                searchSelectCurrency.waitUntilVisible();
                searchSelectCurrency.clear();
                searchSelectCurrency.type(selectcurrencyList.get(begin));
                if (searchedCurrency.isVisible()){
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    searchedCurrency.click();
                }
            }
        }catch (Exception e){
            log.error("Not able to search for the currency pair");
        }

    }


    public void search_for_the_currency_pair_and_select_themSecond(List<String> selectcurrencyList){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        try {
            for (int begin=1;begin<selectcurrencyList.size();begin++){
                searchSelectCurrency.waitUntilVisible();
                searchSelectCurrency.clear();
                searchSelectCurrency.type(selectcurrencyList.get(begin));
                if (searchedCurrencyCurrencyPair.isVisible()){
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    searchedCurrencyCurrencyPair.click();
                }
            }
        }catch (Exception e){
            log.error("Not able to search for the currency pair");
        }

    }

    public void update_search_for_the_currency_pair_and_select_them(List<String> updatedcurrencyList){
        act.pause(Duration.ofSeconds(12)).build().perform();
        try {
            for (int begin=1;begin<updatedcurrencyList.size();begin++){
                searchSelectCurrency.waitUntilVisible();
                searchSelectCurrency.clear();
                searchSelectCurrency.type(updatedcurrencyList.get(begin));
                if (searchedCurrency.isVisible()){
                    searchedCurrency.click();
                }

            }
        }catch (Exception e){
            log.error("Not able to update the selected currencies");
        }

        //in case currency not found
    }

    public void remove_the_currency_after_searching_them(List<String> remove_currencyList){

        for (int begin=1;begin<remove_currencyList.size();begin++){
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(remove_currencyList.get(begin));
            if (searchedRemoveCurrency.isVisible()){
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                searchedRemoveCurrency.click();
            } else if (currency_nodata.isVisible()) {
                continue;
            }
        }


    }
    public void remove_the_currency_pair_after_searching_them(List<String> removecurrencyList){
        try {
            for (int begin=1;begin<removecurrencyList.size();begin++){
                searchRemoveCurrency.waitUntilVisible();
                searchRemoveCurrency.clear();
                searchRemoveCurrency.type(removecurrencyList.get(begin));
                if (searchedRemoveCurrency.isVisible()){
                    withAction().pause(Duration.ofSeconds(3)).build().perform();
                    searchedRemoveCurrency.click();
                }else if (currency_nodata.isVisible()) {
                    continue;
                }
            }
        }catch (Exception e){
            log.error("Not able to remove the currencies");
        }

    }

    public void removeallcurrency(){
        selectAll_Deliverable.waitUntilPresent();
        selectAll_Deliverable.waitUntilClickable().click();
    }

    public void submitChanges(){
        submit_btn.waitUntilPresent();
        submit_btn.click();
//        withAction().moveToElement(submit_btn).click().build().perform();
//        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void cancelChanges(){
        cancel_btn.waitUntilClickable();
        cancel_btn.click();
    }

    public void change_the_currency_group_name(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        groupname.waitUntilVisible();
        groupname.clear();
        groupname.type(dataTable.get("group name"));
    }
    public void change_the_organization(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        // organizationName.click();
        organizationName.clear();
        //organizationName.waitUntilClickable();
        organizationName.type(dataTable.get("organisation name"));
        organizationName.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);

    }

    public boolean searchForCurrency(List<String> selectCurrencyGroup){
        clickCurrenciesButton.waitUntilVisible().click();
        searchCurrencyName.waitUntilVisible();
        withAction().moveToElement(searchCurrencyName).click().sendKeys(selectCurrencyGroup.get(0)).pause(Duration.ofSeconds(2)).build().perform();
        withAction().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        return find(By.xpath("//input[@value='" + selectCurrencyGroup.get(0)+ "']")).isDisplayed();

    }
    public boolean searchForCurrencyPair(List<String> selectCurrencyGroup){
        clickCurrencyGroupPair.waitUntilVisible().click();
        searchCurrencyName.waitUntilVisible();
        withAction().moveToElement(searchCurrencyName).click().sendKeys(selectCurrencyGroup.get(0)).pause(Duration.ofSeconds(2)).build().perform();
        withAction().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        return find(By.xpath("//input[@value='" + selectCurrencyGroup.get(0)+ "']")).isDisplayed();

    }

    public void selectAndValidateDeliverableCurrencies(List<String> currencyList) {
        for (String currency : currencyList) {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(currency);
            searchedCurrency.waitUntilEnabled();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            searchedCurrency.click();
            boolean isExpanded = Boolean.parseBoolean(deliverableAccordion.getAttribute("aria-expanded"));
            Assert.assertTrue("Deliverable accordion is not expanded", isExpanded);
            List<String> actualCurrencies = deliverableCurrencies.stream()
                    .map(WebElementFacade::getText)
                    .map(String::trim)
                    .collect(Collectors.toList());
            log.info("Checking if " + currency + " is in: " + actualCurrencies);
            Assert.assertTrue(
                    "Currency " + currency + " was selected but is NOT found under Deliverable section",
                    actualCurrencies.contains(currency)
            );
        }
    }

    public void selectAndValidateAdvanceFilterCurrencies(List<String> updated_currencyList) {
        for (int begin = 1; begin < updated_currencyList.size(); begin++) {
            String currentCurrency = updated_currencyList.get(begin);
            searchedCurrencyForAdvanceFilter.waitUntilVisible();
            searchedCurrencyForAdvanceFilter.clear();
            searchedCurrencyForAdvanceFilter.type(currentCurrency);
            searchedCurrency.waitUntilEnabled();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            searchedCurrency.click();
            Assert.assertTrue("Deliverable accordion is not visible for: " + currentCurrency,
                    deliverableAccordion.isVisible());
            List<String> actualCurrencies = deliverableCurrencies.stream()
                    .map(WebElementFacade::getText)
                    .map(String::trim)
                    .collect(Collectors.toList());
            log.info("Deliverable section currently contains: " + actualCurrencies);
            Assert.assertTrue(
                    "Currency " + currentCurrency + " is NOT under Deliverable section after Advanced Filter selection",
                    actualCurrencies.contains(currentCurrency)
            );
        }
    }

//    public void selectAndValidateCurrencies(List<String> currencyList) {
//        for (String currency : currencyList) {
//
//            searchSelectCurrency.waitUntilVisible();
//            searchSelectCurrency.clear();
//            searchSelectCurrency.type(currency);
//            currencyInDeliverable(currency).waitUntilVisible().click();
//            log.info("Selected {} under Deliverable", currency);
//            currencyInNonDeliverable(currency).waitUntilVisible().click();
//            log.info("Selected {} under Non Deliverable", currency);
//        }
//    }
//    private WebElementFacade currencyInDeliverable(String currency) {
//        return find(By.xpath(
//                "//div[contains(@id,'panel-header-Deliverable')]" +
//                        "/following-sibling::div" +
//                        "//button[.//text()[normalize-space()='" + currency + "']]"
//        ));
//    }
//
//    private WebElementFacade currencyInNonDeliverable(String currency) {
//        return find(By.xpath(
//                "//div[contains(@id,'panel-header-Non Deliverable')]" +
//                        "/following-sibling::div" +
//                        "//button[.//text()[normalize-space()='" + currency + "']]"
//        ));
//    }
public void selectAndValidateCurrencies(List<String> currencyList) {
    for (String currency : currencyList) {

        searchSelectCurrency.waitUntilVisible();
        searchSelectCurrency.clear();
        searchSelectCurrency.type(currency);
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        clickCurrencyCard(currencyInDeliverable(currency), currency, "Deliverable");
        clickCurrencyCard(currencyInNonDeliverable(currency), currency, "Non Deliverable");
    }
}
    private void clickCurrencyCard(WebElementFacade card, String currency, String sectionLabel) {
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", card
        );
        withAction().pause(Duration.ofMillis(500)).build().perform();
        card.waitUntilVisible().waitUntilClickable().click();
        log.info("Selected {} under {}", currency, sectionLabel);
    }

    private WebElementFacade currencyInDeliverable(String currency) {
        return find(By.xpath(
                "//div[contains(@data-testid,'left-currency-accordion-details-Deliverable')]" +
                        "//button[.//text()[normalize-space()='" + currency + "']]"
        ));
    }

    private WebElementFacade currencyInNonDeliverable(String currency) {
        return find(By.xpath(
                "//div[contains(@data-testid,'left-currency-accordion-details-Non Deliverable')]" +
                        "//button[.//text()[normalize-space()='" + currency + "']]"
        ));
    }
    public void selectAndValidateBothCurrenciesForAdvanceFilters(List<String> currencyList) {

        for (String currency : currencyList) {

            searchedCurrencyForAdvanceFilter.waitUntilVisible();
            searchedCurrencyForAdvanceFilter.clear();
            searchedCurrencyForAdvanceFilter.type(currency);
            currencyInDeliverable(currency).waitUntilVisible().click();
            log.info("Selected {} under Deliverable Group", currency);
            currencyInNonDeliverable(currency).waitUntilVisible().click();
            log.info("Selected {} under Non Deliverable Group", currency);
        }
    }
    public void validateCurrencyGroupNameDisplayed(List<String> currencyGroup) {
        String groupName = currencyGroup.get(0).trim();

        log.info("Validating if currency group name is displayed: " + groupName);
        String xpath = "//*[contains(@class, 'currencies') or contains(@class, 'auth-line')]//*[contains(text(), '" + groupName + "')] | //*[normalize-space(text())='" + groupName + "']";

        try {
            WebElementFacade groupNameElement = find(By.xpath(xpath));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", groupNameElement);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue("Currency group name '" + groupName + "' is NOT displayed on the Auth Line.", groupNameElement.isCurrentlyVisible());
            log.info("Successfully validated that '" + groupName + "' is displayed.");

        } catch (Exception e) {
            log.error("Failed to find currency group name: " + groupName + " on the Auth line. Error: " + e.getMessage());
            Assert.fail("Currency group name '" + groupName + "' was not found on the screen.");
        }
    }
    public void editCurrenciesForAuthLine(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String authLineStr = row.get("Auth line").trim();
            String[] keywords = authLineStr.split("\\s+");
            StringBuilder conditions = new StringBuilder();
            for (String word : keywords) {
                conditions.append("[contains(., '").append(word).append("')]");
            }
            
            String editIconXpath = "//tr" + conditions + "//img[@title='Edit' or @alt='Edit' or contains(@class,'edit')] | //div[contains(@class,'accordion') or contains(@class,'row')]" + conditions + "//img[@title='Edit' or @alt='Edit' or contains(@class,'edit')]";
            
            try {
                WebElementFacade editIcon = find(By.xpath(editIconXpath));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", editIcon);
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                editIcon.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            } catch (Exception e) {
                log.error("Failed to find/click Edit icon for Auth line: " + row.get("Auth line").trim());
                Assert.fail("Failed to find/click Edit icon for Auth line: " + row.get("Auth line").trim());
            }

            if (!row.get("Add Currencies").trim().equalsIgnoreCase("NA")) {
                String[] currenciesToAdd = row.get("Add Currencies").trim().split(",");
                for (String currency : currenciesToAdd) {
                    currency = currency.trim();
                    log.info("Adding currency: " + currency);

                    searchSelectCurrency.waitUntilVisible().clear();
                    searchSelectCurrency.type(currency);
                    withAction().pause(Duration.ofSeconds(3)).build().perform();

                    String addXpath = "//button[contains(@class, 'card')]//span[normalize-space(text())='" + currency + "'] | //button[contains(@class, 'card') and contains(., '" + currency + "')]";
                    List<WebElementFacade> addOccurrences = findAll(By.xpath(addXpath));

                    if (addOccurrences.isEmpty()) {
                        log.warn("Currency card not found to Add: " + currency);
                    } else {
                        for (WebElementFacade occurrence : addOccurrences) {
                            if (occurrence.isCurrentlyVisible()) {
                                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", occurrence);
                                withAction().pause(Duration.ofSeconds(1)).build().perform();
                                occurrence.waitUntilClickable().click();
                                log.info("Clicked to Add currency: " + currency);
                                withAction().pause(Duration.ofSeconds(1)).build().perform();
                            }
                        }
                    }
                }
            }

            if (!row.get("Remove currencies").trim().equalsIgnoreCase("NA")) {
                String[] currenciesToRemove = row.get("Remove currencies").trim().split(",");
                for (String currency : currenciesToRemove) {
                    currency = currency.trim();
                    log.info("Removing currency: " + currency);

                    searchSelectCurrency.waitUntilVisible().clear();
                    searchSelectCurrency.type(currency);
                    withAction().pause(Duration.ofSeconds(3)).build().perform();

                    String removeXpath = "//*[contains(@class,'card card-select') and contains(., '" + currency + "')] | //*[contains(@class,'card card-select')]//span[normalize-space(text())='" + currency + "']";
                    List<WebElementFacade> removeOccurrences = findAll(By.xpath(removeXpath));

                    if (removeOccurrences.isEmpty()) {
                        log.warn("Currency card not found to Remove: " + currency);
                    } else {
                        for (WebElementFacade occurrence : removeOccurrences) {
                            if (occurrence.isCurrentlyVisible()) {
                                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", occurrence);
                                withAction().pause(Duration.ofSeconds(1)).build().perform();
                                occurrence.waitUntilClickable().click();
                                log.info("Clicked to Remove currency: " + currency);
                                withAction().pause(Duration.ofSeconds(1)).build().perform();
                            }
                        }
                    }
                }
            }
            try {
                submit_btn.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            } catch(Exception e) {
                log.error("Failed to submit currency changes.");
                Assert.fail("Failed to submit currency changes.");
            }
        }
    }
    public void clickSelectAllCheckbox() {
        log.info("Clicking on all 'Select All' checkboxes for currency selection");

        if (selectAllCheckboxes.isEmpty()) {
            Assert.fail("No 'Select All' checkboxes were found on the screen.");
        }
        int count = 0;
        for (WebElementFacade checkbox : selectAllCheckboxes) {
            if (checkbox.isPresent()) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", checkbox);
                withAction().pause(Duration.ofMillis(500)).build().perform();
                try {
                    checkbox.waitUntilClickable().click();
                } catch (Exception e) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkbox);
                }
                count++;
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }

        log.info("Successfully clicked on " + count + " 'Select All' checkbox(es)");
    }

    public void clickAllCurrencyPermittedCheckbox() {
        log.info("Clicking on 'All currency permitted' checkbox");
        allCurrencyPermittedCheckbox.waitUntilPresent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", allCurrencyPermittedCheckbox);
        withAction().pause(Duration.ofMillis(500)).build().perform();

        try {
            allCurrencyPermittedCheckbox.waitUntilClickable().click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", allCurrencyPermittedCheckbox);
        }

        withAction().pause(Duration.ofSeconds(1)).build().perform();
        log.info("Successfully clicked on 'All currency permitted' checkbox");
    }

    public void validateTextDisplayed(String expectedText) {
        log.info("Validating if text is displayed: " + expectedText);
        String xpath = "//*[normalize-space(.)='" + expectedText + "' and not(*[normalize-space(.)='" + expectedText + "'])]";

        try {
            WebElementFacade textElement = find(By.xpath(xpath));
            textElement.waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", textElement);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            Assert.assertTrue("Text '" + expectedText + "' is present in DOM but not visible on the UI", textElement.isCurrentlyVisible());
            log.info("Successfully validated that the text '" + expectedText + "' is displayed.");

        } catch (Exception e) {
            log.error("Failed to find text: '" + expectedText + "' on the screen. It might be missing or hidden.");
            Assert.fail("The expected text '" + expectedText + "' was not found on the screen.");
        }
    }
}
