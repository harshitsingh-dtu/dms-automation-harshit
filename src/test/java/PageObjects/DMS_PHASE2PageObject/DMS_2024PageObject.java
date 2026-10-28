package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.*;


import static org.junit.Assert.assertEquals;


@Slf4j
@Data
public class DMS_2024PageObject extends PageObject {


    @FindBy(xpath = "//div[text()='Client' and text()='1']//span[text()='+ Add Fund']")
    private WebElementFacade AddFundButtonwithClient1;
    @FindBy(xpath = "//div[text()='Client' and text()='2']//span[text()='+ Add Fund']")
    private WebElementFacade AddFundButtonwithClient2;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElementFacade CancelButtonOnFundSideWindow;
    @FindBy(xpath = "//header[text()='Funds']")
    private WebElementFacade FundsText_onSideWindow;
    @FindBy(xpath = "//header[text()='Add Funds']")
    private WebElementFacade AddFundsText_onSideWindow;
//    @FindBy(xpath = "//header[text()='Add Funds']/following-sibling::div/div")//div[text()='Search & add fund']
//    private WebElementFacade SearchandAddfund_Input_Filter_onSideWindow;
    @FindBy(xpath = "//header[text()='Add Funds' ]//following::input[@class='lp-copy-sel__input']")
    private WebElementFacade SearchandAddfund_Input_Filter_onSideWindow;  //div[text()='Search & add fund']
    @FindBy(xpath = "//div[text()='Fund name']")
    private WebElementFacade FundNameText_onSideWindow;
    @FindBy(xpath = "//input[@placeholder='Search by id or name']")
    private WebElementFacade SearchByIDorNAME_onSideWindow;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElementFacade SaveButtonOnFundSideWindow;
    @FindBy(xpath = "//div[@class='doc-fund-list ']//div[@class='fund-item']")
    private WebElementFacade AddedFundItem_On_FundSideWindow;
    @FindBy(xpath = "//div[@class='doc-fund-list ']//button")
    private WebElementFacade CrossButton_On_FundSideWindow;
    @FindBy(xpath = "//div[@class='doc-fund-list ']//h5[text()='No Record Found']")
    private WebElementFacade NO_Record_Found_On_FundSideWindow;
    @FindBy(xpath = "//div[@class='custom-input-option  focused  css-d7l1ni-option']") ////div[@class='select-menu-container']
    private WebElementFacade Searched_result_for_LEI_IDorLEI_NAME;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElementFacade AddButton;
    @FindBy(xpath = "//div[@class='doc-fund-list ']")
    private WebElementFacade SelectedFundsinAddedList;
    @FindBy(xpath = "//input[@placeholder='Select Orgtype']")
    private WebElementFacade ActingAsfilter;
    @FindBy(xpath = "//button[text()='Submit Request']")
    private WebElementFacade SubmitRequest_Button;
    @FindBy(xpath = "//p[text()='Define reviewer']")
    private WebElementFacade DefineReviwer_POPUP_TEXT;
    @FindBy(xpath = "//div[text()='Select']")
    private WebElementFacade SelectReviwer_INPUT;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade SubmitButton_on_POPUP;
    @FindBy(xpath = "//div[@class='message']")
    private WebElementFacade SuccessMessageforSubmitRequestForCreateDocument;
    @FindBy(xpath = "//button[text()='Got it']")
    private WebElementFacade GotIT_buttonOnSubmitRequestForCreateDocument_PopUP;








// need look
    public void SearchforLEIID_or_LEI_NAME(List<String> LEIIDorLEIName) {

        try {
            for (int begin=1;begin<LEIIDorLEIName.size();begin++) {
                SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible();
                Assert.assertTrue(SearchandAddfund_Input_Filter_onSideWindow.isVisible());
                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(LEIIDorLEIName.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(Searched_result_for_LEI_IDorLEI_NAME.getText().contains(LEIIDorLEIName.get(begin)));
                log.info("assert pass to compare data");
//
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].value='';", SearchandAddfund_Input_Filter_onSideWindow);

                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.info("Unable to see Search Result and there correspondence result-->" + e);
            Assert.fail();
        }
    }

    public void SelectMultipleLEIs(){
        try {
//            withAction().pause(Duration.ofSeconds(5)).build().perform();
            Random random = new Random();
            int randomNumber;
//            randomNumber = random.nextInt(10);
            randomNumber = random.nextInt(3) + 2;
            log.info("randomNumber" + randomNumber);
            SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible();
            log.info("Search field for Funds  "    + SearchandAddfund_Input_Filter_onSideWindow.getText());
            withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedFund = find(By.xpath("(//div[@class='select-menu-container'])["+begin+"]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedFund).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                WebElement Selectedfunds = find(By.xpath("//div[@class='doc-fund-list ']"));
//                log.info(Selectedfunds.getText() +  "------------------------------------------->" +   SelectedFund.getText() );
                Assert.assertTrue(Selectedfunds.getText().contains(SelectedFund.getText()));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            AddFundsText_onSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to Select Multiple LEIS for Add Funds " +e);
            Assert.fail();
        }
    }


    public void CheckAvailabiltyofAddedFundsinsearchbox(){
        try {
            withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            List<WebElementFacade> AddedFunds = findAll("//div[@class='select-menu-container']");
            int Avaiablefunds= AddedFunds.size();
            switch (Avaiablefunds) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    log.info("Size of Fund Name List is " + Avaiablefunds + " which is less then 10");
                    break;
                default:
                    log.info("Size of Fund Name List is " + Avaiablefunds);
                    assertEquals(10,Avaiablefunds);
                    break;
            }
            for (int begin=1;begin<=Avaiablefunds;begin++) {
                WebElement SelectedFund = find(By.xpath("(//div[@class='select-menu-container'])["+begin+"]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Assert.assertTrue(SelectedFund.isDisplayed());
                withAction().sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).build().perform();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            AddFundsText_onSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to see Added Funds in multiselect dropdown " +e);
            Assert.fail();
        }
    }

    public void CheckNoRecord(){
        try {
            if (CrossButton_On_FundSideWindow.isVisible()){
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                List<WebElementFacade> CrossbuttonforSelectedFunds = findAll("//div[@class='fund-item']");
                int AddedFundsSize= CrossbuttonforSelectedFunds.size();
                log.info("Added Funds Size :" +AddedFundsSize);
                for(int i=1;i<=AddedFundsSize;i++){
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    CrossButton_On_FundSideWindow.click();
                }
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(NO_Record_Found_On_FundSideWindow.isVisible());
            }else {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(NO_Record_Found_On_FundSideWindow.isVisible());
            }
        }catch (Exception e){
            log.error("Unable to see NO Record Found Text  " +e);
            Assert.fail();
        }
    }

// need look
    public void CheckAddButtonforNewLEIID_or_LEI_NAME(List<String> LEIIDorLEIName) {

        try {
            for (int begin=1;begin<LEIIDorLEIName.size();begin++) {
                SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible().isVisible();
//                Assert.assertTrue(SearchandAddfund_Input_Filter_onSideWindow.isVisible());
                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(LEIIDorLEIName.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(Searched_result_for_LEI_IDorLEI_NAME.getText().contains(LEIIDorLEIName.get(begin)));
                Assert.assertTrue(AddButton.isVisible());
                log.info("add button Asser is working");
//                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].value='';", SearchandAddfund_Input_Filter_onSideWindow);

                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.info("Unable to Add Button -->" + e);
            Assert.fail();
        }
    }


    public void AddLEIthatDoesnotexistinsystem(List<String> Funds) {

        try {
            for (int begin=1;begin<Funds.size();begin++) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible().isVisible();
//                Assert.assertTrue(SearchandAddfund_Input_Filter_onSideWindow.isVisible());
                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(Funds.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(Searched_result_for_LEI_IDorLEI_NAME.getText().contains(Funds.get(begin)));
                Assert.assertTrue(AddButton.isVisible());
                AddButton.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(SelectedFundsinAddedList.getText().contains(Funds.get(begin)));

                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].value='';", SearchandAddfund_Input_Filter_onSideWindow);

//                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.info("Unable to Add new LEI-->" + e);
            Assert.fail();
        }
    }

    public void CheckRecentlyaddedLEIS(List<String> LEIIDorLEIName) {

        try {
            for (int begin=1;begin<LEIIDorLEIName.size();begin++) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(SelectedFundsinAddedList.getText().contains(LEIIDorLEIName.get(begin)));
            }
        } catch (Exception e) {
            log.info("Unable to see Recentlly Added LEIS-->" + e);
            Assert.fail();
        }
    }

    public void RemoveAddedFundsformList(List<String> Funds){

        try{
            for (int begin=0;begin<Funds.size();begin++) {
                if (!NO_Record_Found_On_FundSideWindow.isVisible()) {
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    List<WebElementFacade> AddedFunds = findAll("//div[@class='fund-item']");
                    int AddedFundsSize = AddedFunds.size();
                    log.info("Added Funds Size :" + AddedFundsSize   );
                    log.info("Fund name need to remove : " + Funds.get(begin)    );
                    int count = 1;
                    for (WebElementFacade AddedFunds_Text : AddedFunds) {
                        log.info("Added Fund Name is " + AddedFunds_Text.getText());
                        if (AddedFunds_Text.getText().contains(Funds.get(begin))){
                            WebElementFacade CrossButton = find(By.xpath("(//div[@class='doc-fund-list ']//button)["+count+"]"));
                            log.info("cross number to remove " +count);
                            CrossButton.click();
                        }
                        count++;
                    }
                }
            }
            String addedFundsbeforesave = SelectedFundsinAddedList.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SaveButtonOnFundSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            AddFundButtonwithClient1.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            FundsText_onSideWindow.waitUntilVisible().isVisible();
            String addedFundsafterupdate = SelectedFundsinAddedList.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            assertEquals(addedFundsbeforesave, addedFundsafterupdate);

        }catch (Exception e){
            log.error("unable to remove funds successfully " +e);
            Assert.fail();
        }
    }

    public void validateaddedfundsforChangeActingas(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            String addedFundsbeforesave = SelectedFundsinAddedList.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SaveButtonOnFundSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(ActingAsfilter.isVisible());
            withAction().moveToElement(ActingAsfilter).click().sendKeys(dataTable.get("Acting AS")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            AddFundButtonwithClient1.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            FundsText_onSideWindow.waitUntilVisible().isVisible();
            String addedFundsafterupdate = SelectedFundsinAddedList.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            assertEquals(addedFundsbeforesave, addedFundsafterupdate);
        } catch (Exception e) {
            log.error("Unable to validate Added funds After changing Acting AS-->" + e);
            Assert.fail();
        }
    }

    public void validateaddedfundslist(){
        try {
            String addedFundsbeforesave = SelectedFundsinAddedList.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            SaveButtonOnFundSideWindow.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            AddFundButtonwithClient1.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            FundsText_onSideWindow.waitUntilVisible().isVisible();
            String addedFundsafterupdate = SelectedFundsinAddedList.getText();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            assertEquals(addedFundsbeforesave, addedFundsafterupdate);
        } catch (Exception e) {
            log.error("Unable to see Added funds list without any changes-->" + e);
            Assert.fail();
        }
    }




    public void SelectRandomReviewer(){
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(SelectReviwer_INPUT).click().build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys("OSTTRA INDIA SERVICES PRIVATE LIMITED").pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Reviewer to submit Create Document Request-->" + e);
            Assert.fail();
        }
    }




    public void SelectMultipleLEI_IDAndSearchforAddedList(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(3) + 2;
            log.info("randomNumber" + randomNumber);
            SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible();
            log.info("Search field for Funds  "    + SearchandAddfund_Input_Filter_onSideWindow.getText());
            withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedFund = find(By.xpath("(//div[@class='select-menu-container'])["+begin+"]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedFund).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                WebElement Selectedfunds = find(By.xpath("//div[@class='doc-fund-list ']"));
                log.info(Selectedfunds.getText() +  "------------------------------------------->" +   SelectedFund.getText() );
                Assert.assertTrue(Selectedfunds.getText().contains(SelectedFund.getText()));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            WebElement  randomLEIID= find(By.xpath("(//div[@class='select-head'])["+randomNumber+"]"));
            String SeletedLEIID = randomLEIID.getText();
            AddFundsText_onSideWindow.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(SearchByIDorNAME_onSideWindow).click().pause(Duration.ofSeconds(1)).sendKeys(SeletedLEIID).pause(Duration.ofSeconds(1)).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(AddedFundItem_On_FundSideWindow.getText().contains(SeletedLEIID));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }catch (Exception e){
            log.error("Unable to Select Multiple LEIS for Add Funds " +e);
            Assert.fail();
        }
    }

    public void SelectMultipleLEI_NAMEAndSearchforAddedList(){
        try {
            Random random = new Random();
            int randomNumber;
            randomNumber = random.nextInt(3) + 2;
            log.info("randomNumber" + randomNumber);
            SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible();
            log.info("Search field for Funds  "    + SearchandAddfund_Input_Filter_onSideWindow.getText());
            withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            for (int begin=1;begin<=randomNumber;begin++) {
                WebElement SelectedFund = find(By.xpath("(//div[@class='select-menu-container'])["+begin+"]"));
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().click(SelectedFund).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
                WebElement Selectedfunds = find(By.xpath("//div[@class='doc-fund-list ']"));
                log.info(Selectedfunds.getText() +  "------------------------------------------->" +   SelectedFund.getText() );
                Assert.assertTrue(Selectedfunds.getText().contains(SelectedFund.getText()));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            WebElement  randomLEIName= find(By.xpath("(//div[@class='select-head select-label'])["+randomNumber+"]"));
            String SeletedLEINAME = randomLEIName.getText();
            AddFundsText_onSideWindow.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(SearchByIDorNAME_onSideWindow).click().pause(Duration.ofSeconds(1)).sendKeys(SeletedLEINAME).pause(Duration.ofSeconds(1)).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertTrue(AddedFundItem_On_FundSideWindow.getText().contains(SeletedLEINAME));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }catch (Exception e){
            log.error("Unable to Select Multiple LEIS for Add Funds " +e);
            Assert.fail();
        }
    }

    public void CheckAddRemoveFundsEffect(List<String> Funds){
        try {
            String AddedFundsforClient2 = SelectedFundsinAddedList.getText();
            SaveButtonOnFundSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            AddFundButtonwithClient1.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            for (int begin=1;begin<Funds.size();begin++) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                SearchandAddfund_Input_Filter_onSideWindow.waitUntilVisible().isVisible();
                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(Funds.get(begin)).pause(Duration.ofSeconds(2)).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(Searched_result_for_LEI_IDorLEI_NAME.getText().contains(Funds.get(begin)));
                Assert.assertTrue(AddButton.isVisible());
                AddButton.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertTrue(SelectedFundsinAddedList.getText().contains(Funds.get(begin)));

                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].value='';", SearchandAddfund_Input_Filter_onSideWindow);
//                withAction().moveToElement(SearchandAddfund_Input_Filter_onSideWindow).click().sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE).perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            String AddedFundsforClient1 = SelectedFundsinAddedList.getText();
            SaveButtonOnFundSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            AddFundButtonwithClient2.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            assertEquals(SelectedFundsinAddedList.getText(), AddedFundsforClient2);
            CrossButton_On_FundSideWindow.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            SaveButtonOnFundSideWindow.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            AddFundButtonwithClient1.click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            assertEquals(SelectedFundsinAddedList.getText(), AddedFundsforClient1);
        }catch (Exception e){
            log.error("Unable to validate Effect of add remove funds "  +e);
            Assert.fail();
        }
    }

}
