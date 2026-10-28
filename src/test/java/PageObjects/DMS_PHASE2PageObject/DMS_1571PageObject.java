package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Data


public class DMS_1571PageObject extends PageObject{

    @FindBy(xpath = "//button[text()='+ Create new document']")
    private WebElementFacade CreateNewDocument_Button;
    @FindBy(xpath = "//div[text()='Request to create new document']")
    private WebElementFacade Request_to_CreateNewDocument_text;
    @FindBy(xpath = "//button[text()='Request to create new document']")
    private WebElementFacade Request_to_CreateNewDocument_button;
    @FindBy(xpath = "//input[@placeholder='Select Doc type']")
    private WebElementFacade documenttypefilter;
    @FindBy(xpath = "//div[@class='new-heading']")
    private WebElementFacade createnewdocument_text;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
    private WebElementFacade filtereditem;
    @FindBy(xpath = "//input[@placeholder='Select Orgtype']")
    private WebElementFacade ActingAsfilter;

    @FindBy(xpath = "//div[text()='Select parties']")
    private WebElementFacade Selectparties_text;
    @FindBy(xpath = "//div[text()='Select Prime Broker - 1']")
    private WebElementFacade PrimeBroker1Filter;
    @FindBy(xpath = "//div[text()='Select Executing Broker - 1']")
    private WebElementFacade ExecutingBroker1Filter;
    @FindBy(xpath = "//div[text()='Select Client - 1']")
    private WebElementFacade Client1Filter;
    @FindBy(xpath = "//div[text()='Select Prime Broker - 2']")
    private WebElementFacade PrimeBroker2Filter;
    @FindBy(xpath = "//div[text()='Select Client - 2']")
    private WebElementFacade Client2Filter;
//document template details
    @FindBy(xpath = "//input[@placeholder='Select Template']")
    private WebElementFacade documenttemplatefilter;
    @FindBy(xpath = "//div[text()='Template Preview']")
    private WebElementFacade templatepreview_text;
    @FindBy(xpath = "//p[text()='Approval Workflow']")
    private WebElementFacade approvalworkflow;
    @FindBy(xpath = "//div[@class='MuiAccordionDetails-root workflow-detail css-1fpbxjw' and text()='No data found.']")
    private WebElementFacade NoDataFound_text_forApprovalWorkflow;
    @FindBy(xpath = "//p[text()='Enforcement Rule']")
    private WebElementFacade Enforcementrule;
    @FindBy(xpath = "//div[@class='MuiAccordionDetails-root e-detail css-1fpbxjw' and text()='No data found.']")
    private WebElementFacade NoDataFound_text_forEnforcementrule;
    @FindBy(xpath = "//p[text()='Legal Term']")
    private WebElementFacade legalterm;
    @FindBy(xpath = "//div[@class='MuiAccordionDetails-root legal-detail css-1fpbxjw' and text()='No data found.']")
    private WebElementFacade NoDataFound_text_forlegalterm;
    @FindBy(xpath = "//tr//th[text()='Document actions']")
    private WebElementFacade documentactionstext;
    @FindBy(xpath = "//tr//th[text()='Approval sequence - ']")
    private WebElementFacade approvalsequencecolumntext;
    @FindBy(xpath = "//tr//th[text()='For new document enforcement']")
    private WebElementFacade fornewdocumentenforcementcolumntext;
    @FindBy(xpath = "//tr//th[text()='For amendment']")
    private WebElementFacade foramendmentcolumntext;
    @FindBy(xpath = "//tr//th[text()='For termination']")
    private WebElementFacade forterminationcolumntext;
    @FindBy(xpath = "//div[@class='MuiAccordionDetails-root legal-detail css-1fpbxjw']/p")
    private WebElementFacade paraforlegaltems;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade next_button;
//edit document screen
    @FindBy(xpath = "//div[text()='Edit Document']")
    private WebElementFacade Editdocument_text;
    @FindBy(xpath = "//div[@class='info-container']/div[@class='content-label']")
    private WebElementFacade Documentversionid_text;
    @FindBy(xpath = "//div[text()='Document type']/following-sibling::div/div")
    private WebElementFacade documenttype_text;
    @FindBy(xpath = "//div[text()='Allowed currencies']/following::div/div")
    private WebElementFacade allowedcurrencies_text;


    //need to look
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div/div/div")
    private WebElementFacade Selectedpartyprimebroker1_text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div/div/div")
    private WebElementFacade Selectedpartyprimebroker2_text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']/following-sibling::div/div/div")
    private WebElementFacade SelectedpartyExecutingBroker1_text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']/following-sibling::div/div/div")
    private WebElementFacade SelectedpartyClient1text;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 2']/following-sibling::div/div/div")
    private WebElementFacade SelectedpartyClient2text;
    @FindBy(xpath = "//div[text()='Client - 1']//span[text()='+ View Fund Details']")
    private WebElementFacade ViewDetailButton_FOR_Client1;
    @FindBy(xpath = "//div[text()='Client - 2']//span[text()='+ View Fund Details']")
    private WebElementFacade ViewDetailButton_FOR_Client2;

//Auth Scope tab
    @FindBy(xpath = "//button[text()='Auth scope']")
    private WebElementFacade AuthScopeButton;
    @FindBy(xpath = "//div[text()='Auth Products']")
    private WebElementFacade authproducts_text;
    @FindBy(xpath = "//input[@placeholder='Select Product Group']")
    private WebElementFacade selectproductgroup_filter;
    @FindBy(xpath = "//input[@placeholder='Asset Class']")
    private WebElementFacade Assertclass_filter;
    @FindBy(xpath = "//input[@placeholder='Select Product Family']")
    private WebElementFacade selectproductfamily_filter;
    @FindBy(xpath = "//input[@placeholder='Select Product']")
    private WebElementFacade Selectproduct_filter;
    @FindBy(xpath = "//div[text()='Auth Currencies']")
    private WebElementFacade AuthCurrencies_text;
    @FindBy(xpath = "//div[text()='Auth Tenor']")
    private WebElementFacade authtenor_text;
    @FindBy(xpath = "//input[@placeholder='Value']")
    private WebElementFacade authtenorvalue_filter;
    @FindBy(xpath = "//input[@placeholder='Select Tenor']")
    private WebElementFacade selecttenor_filter;
    @FindBy(xpath = "//ul/li/p[text()='Calendar Days']")
    private WebElementFacade selecttenor_value;
    @FindBy(xpath = "//button[text()='+ Add currencies']")
    private WebElementFacade addCurrencies_button;
    @FindBy(xpath = "//div[text()='Select currencies & currencies pair']")
    private WebElementFacade currenciesandcurrenciespair_popuptext;
    @FindBy(xpath = "//div[@class='cancel']")
    private WebElementFacade cancelbutton_currenciespopup;
    @FindBy(xpath = "//button[text()='Add Auth Line']")
    private WebElementFacade addauthlinebutton;

//Limit scope tab
    @FindBy(xpath = "//button[text()='Limit scope']")
    private WebElementFacade Limitscope_tab;
   //need a look
    @FindBy(xpath = "(//input[@placeholder='Select '])[1]")
    private WebElementFacade Calculationtype_dropdown;
    @FindBy(xpath = "(//input[@placeholder='Select '])[2]")
    private WebElementFacade NettingType_dropdown;
    @FindBy(xpath = "(//input[@placeholder='Select '])[3]")
    private WebElementFacade ExcludeCLSfromcalculation_dropdown;
    @FindBy(xpath = "//input[@placeholder='Select']")
    private WebElementFacade delta_dropdown;
    @FindBy(xpath = "//input[@placeholder='Limit value']")
    private WebElementFacade limitvalue_dropdown;
    @FindBy(xpath = "//button[text()='Add Limit']")
    private WebElementFacade Addlimit_button;
    @FindBy(xpath = "//div[@style='position: absolute;']")
    private WebElementFacade nolimitscopedefine_text;


    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforClient1party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 2']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforClient2party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforprimebroker1party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforprimebroker2party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']/following-sibling::div//div[@class='head-status scolor']")
    private WebElementFacade litestatusforExecutingbroker1party;

    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 1']/following-sibling::div//div[text()='+ Add email id']")
    private WebElementFacade addemailbuttonforclient1party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Client - 2']/following-sibling::div//div[text()='+ Add email id']")
    private WebElementFacade addemailbuttonforclient2party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 1']/following-sibling::div//div[text()='+ Add email id']")
    private WebElementFacade addemailbuttonforprimebroker1party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Prime Broker - 2']/following-sibling::div//div[text()='+ Add email id']")
    private WebElementFacade addemailbuttonforprimebroker2party;
    @FindBy(xpath = "//div[@class='info-data lchild']//div[text()='Executing Broker - 1']/following-sibling::div//div[text()='+ Add email id']")
    private WebElementFacade addemailbuttonforExecutingbroker1party;
////////
//    @FindBy(xpath = "//button[text()='Enforcement rule']")
//    private WebElementFacade EnforcementruleTAB;
//    @FindBy(xpath = "//button[text()='Yes']")
//    private WebElementFacade yesbuttononpopupEnforcementruleTAB;
//    @FindBy(xpath = "//div[text()='For new document']")
//    private WebElementFacade fornewdocument_text;
////////////////
//    @FindBy(xpath = "//div[@tabindex='-1']")
//    private WebElementFacade listofprimebrokerdropdown;
//    @FindBy(xpath = "//div[@class='lp-copy-sel__option css-10wo9uf-option']")
//    private WebElementFacade listoptionofprimebrokerdropdown;






    public void Filtereddoctype(List<String> doctypelist){

        try {
            for (int begin=1;begin<doctypelist.size();begin++)
            {
                documenttypefilter.waitUntilClickable().click();
                documenttypefilter.type(doctypelist.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(doctypelist.get(begin),filtereditem.getText());
                documenttypefilter.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found filtered Doc Type-->" + e);
            Assert.fail();
        }
    }

    public void FilteredActingAS(List<String> Actingaslist){

        try {
            for (int begin=1;begin<Actingaslist.size();begin++)
            {
                ActingAsfilter.waitUntilClickable().click();
                ActingAsfilter.type(Actingaslist.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(Actingaslist.get(begin),filtereditem.getText());
                ActingAsfilter.clear();
            }
        } catch (Exception e) {
            log.error("Unable to found filtered Acting AS-->" + e);
            Assert.fail();
        }
    }

    public void EnterDocType(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {

            Assert.assertTrue(documenttypefilter.isVisible());
            documenttypefilter.waitUntilClickable().clear();
            withAction().moveToElement(documenttypefilter).click().sendKeys(dataTable.get("Doc Type")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Doctype-->" + e);
            Assert.fail();
        }
    }

    public void EnterActingas(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(ActingAsfilter.isVisible());
            withAction().moveToElement(ActingAsfilter).click().sendKeys(dataTable.get("Acting AS")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Acting as-->" + e);
            Assert.fail();
        }
    }
    public void EnterinpurforActingas(){
        try {
            Assert.assertTrue(ActingAsfilter.isVisible());
            withAction().moveToElement(ActingAsfilter).click().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Acting as-->" + e);
            Assert.fail();
        }
    }

    public void EnterPrimeBroker1(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(PrimeBroker1Filter.isVisible());
            withAction().moveToElement(PrimeBroker1Filter).click().sendKeys(dataTable.get("PrimeBroker-1")).pause(Duration.ofSeconds(2)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.error("Unable to type into PrimeBroker1Filter-->" + e);
            Assert.fail();
        }
    }

    public void SelectPrimeBroker1(){
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(PrimeBroker1Filter.isVisible());
            withAction().moveToElement(PrimeBroker1Filter).click().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).pause(Duration.ofSeconds(2)).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        } catch (Exception e) {
            log.error("Unable to type into PrimeBroker1Filter-->" + e);
            Assert.fail();
        }
    }




    public void Selectdocumenttemplate(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Assert.assertTrue(documenttemplatefilter.isVisible());
            withAction().moveToElement(documenttemplatefilter).click().sendKeys(dataTable.get("Document template")).pause(Duration.ofSeconds(4)).build().perform();
            withAction().sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

        } catch (Exception e) {
            log.error("Unable to Select documenttemplate-->" + e);
            Assert.fail();
        }
    }


    public void statuscheckforselectedparties(){
        try {
            if (litestatusforprimebroker1party.isVisible()){
                Assert.assertTrue(addemailbuttonforprimebroker1party.isVisible());
            } else if (litestatusforExecutingbroker1party.isVisible()) {
                Assert.assertTrue(addemailbuttonforExecutingbroker1party.isVisible());
            } else if (litestatusforClient1party.isVisible()) {
                Assert.assertTrue(addemailbuttonforclient1party.isVisible());
            } else if (litestatusforprimebroker2party.isVisible()) {
                Assert.assertTrue(addemailbuttonforprimebroker2party.isVisible());
            }else if (litestatusforClient2party.isVisible()) {
                Assert.assertTrue(addemailbuttonforclient2party.isVisible());
            } else {
                log.info("All Selected parties are online");
            }
        }catch (Exception e){
            log.error("unable to check status of selected parties" + e);
            Assert.fail();
        }
    }

    public void randomEnterExecutingBroker1() {
       try {
           withAction().pause(Duration.ofSeconds(1)).build().perform();
           if(ExecutingBroker1Filter.isVisible()) {
               Random random = new Random();
//               int randomNumber = Math.abs(random.nextInt(15));
//               log.info("randomNumber" + randomNumber);
               int randomNumber;
               randomNumber = random.nextInt(15) + 1;
               log.info("randomNumber" + randomNumber);
               withAction().pause(Duration.ofSeconds(3)).build().perform();
               withAction().moveToElement(ExecutingBroker1Filter).click().build().perform();
               for (int i = 1; i < randomNumber; i++) {
                   withAction().pause(Duration.ofSeconds(1)).build().perform();
                   withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
               }
               withAction().sendKeys(Keys.RETURN).build().perform();
           }
       }catch (Exception e){
           log.error(" Unable to Select Executing Broker 1 " +e);
           Assert.fail();
       }
    }
    public void randomEnterPrimeBroker2() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            if(PrimeBroker2Filter.isVisible()) {
                Random random = new Random();
//                int randomNumber = Math.abs(random.nextInt(15));
//                log.info("randomNumber" + randomNumber);
                int randomNumber;
                randomNumber = random.nextInt(15) + 1;
                log.info("randomNumber" + randomNumber);
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().moveToElement(PrimeBroker2Filter).click().build().perform();
                for (int i = 1; i < randomNumber; i++) {
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
                }
                withAction().sendKeys(Keys.RETURN).build().perform();
            }
        }catch (Exception e){
            log.error(" Unable to Select Executing Broker 1 " +e);
            Assert.fail();
        }
    }

    public void randomEnterClient2() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            if(Client2Filter.isVisible()) {
                Random random = new Random();
//                int randomNumber = Math.abs(random.nextInt(15));
//                log.info("randomNumber" + randomNumber);
                int randomNumber;
                randomNumber = random.nextInt(15) + 1;
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                withAction().moveToElement(Client2Filter).click().build().perform();
                for (int i = 1; i < randomNumber; i++) {
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
                }
                withAction().sendKeys(Keys.RETURN).build().perform();
            }
        }catch (Exception e){
            log.error(" Unable to Select Executing Broker 1 " +e);
            Assert.fail();
        }
    }

    public void randomEnterClient1() {
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Random random = new Random();
//            int randNumber = Math.abs(random.nextInt(15));
//            log.info("randomNumber"  +  randNumber);
//            randomNumber = random.nextInt(10);
            int randNumber;
            randNumber = random.nextInt(11) + 1;
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(Client1Filter).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error(" Unable to Select Client 1 " +e);
            Assert.fail();
        }
    }


}
