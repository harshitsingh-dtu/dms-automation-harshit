package PageObjects.PlatformServices;


import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class LegalEntitiesPageObject extends PageObject {
    @FindBy(xpath = "//div[@class='title' and text()='Legal Entities']")
    private WebElementFacade legalEntities_title;
    @FindBy(xpath = "//input[@placeholder='Search by LEI ID or Legal entity name']")
    private WebElementFacade search_byLEIid;
    @FindBy(xpath = "//label[text()='All Legal entity types']")
    private WebElementFacade filter_legalEntityType;
    @FindBy(xpath = "//label[text()='All Parent orgs']")
    private WebElementFacade filter_parentOrgs;
    @FindBy(xpath = "//div//img[@alt='download CSV']")
    private WebElementFacade download_btn;
    @FindBy(xpath = "//th//div")
    private WebElementFacade columns;
    @FindBy(xpath = "//button[text()='View Details']")
    private WebElementFacade viewDetails_btn;
    @FindBy(xpath = "//tbody//tr[2]//td[1]")
    private WebElementFacade searched_LEIid;
    @FindBy(xpath = "//tr//td//div[text()='No Record Found']")
    private WebElementFacade norecordfound;
    @FindBy(xpath = "//div[@class='go-back']")
    private WebElementFacade goback_btn;
    @FindBy(xpath = "//tr//th//div[text()='Parent LEI ID']")
    private WebElementFacade column_parentLEIID;
    @FindBy(xpath = "//tr//th//div[text()='Parent Org Name']")
    private WebElementFacade column_parentOrgName;
    @FindBy(xpath = "//tr//th//div[text()='Last updated by']")
    private WebElementFacade column_LastUpdatedBy;
    @FindBy(xpath = "//tr//th//div[text()='Last updated on (UTC)']")
    private WebElementFacade column_LastUpdatedOn;
    @FindBy(xpath = "//tr//th//div[text()='Status']")
    private WebElementFacade column_Status;
    @FindBy(xpath = "//tr//th//div[text()='Action']")
    private WebElementFacade column_Action;
    @FindBy(xpath = "//tr//th//div[text()='Legal entity type']")
    private WebElementFacade column_legalEntityType;
    @FindBy(xpath = "//tr//th//div[text()='Legal entity name']")
    private WebElementFacade column_legalEntityName;
    @FindBy(xpath = "//tr//th//div[text()='LEI ID']")
    private WebElementFacade column_LEIID;
    //    view screen elements
    @FindBy(xpath = "//div[text()='LEI ID']")
    private WebElementFacade viewscreen_column_LEIID;
    @FindBy(xpath = "//div[@data-testid='doc-table-th-legalEntityName' or text()='Legal entity name']")
    private WebElementFacade viewscreen_column_legalEntityName;
    @FindBy(xpath = "//div[text()='Address']")
    private WebElementFacade viewscreen_column_address;

    @FindBy(xpath = "//tr//th//div[text()='Parent LEI ID']")
    private WebElementFacade viewscreen_parentorg_column_parentLEIID;
    @FindBy(xpath = "//tr//th//div[text()='Parent LEI ID']")
    private WebElementFacade viewscreen_parentorg_column_Parent_org_name;
    @FindBy(xpath = "//tr//th//div[text()='Parent LEI ID']")
    private WebElementFacade viewscreen_parentorg_column_active_users;
    @FindBy(xpath = "//tr//th//div[text()='Parent LEI ID']")
    private WebElementFacade viewscreen_parentorg_column_total_users;
    @FindBy(xpath = "//tr//th//div[text()='Parent LEI ID']")
    private WebElementFacade viewscreen_parentorg_column_action;

    //2/7/24
    @FindBy(xpath = "//td[text()='Child']")
    private WebElementFacade legalEntityTypeResult;
    @FindBy(xpath = "(//td)[5]")
    private WebElementFacade parentOrgResult;





    public void checkColumns(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> row :data){
                Assert.assertTrue(find(By.xpath("//th//div[text()='"+row.get("columns")+"']")).isVisible());

//                Assert.assertTrue(find(By.xpath(columns+"[text()='"+row.get("columns")+"']")).isVisible());
//                withAction().moveToElement(find(By.xpath("//th//div"+))).build().perform();
            }
        }catch (Exception e){
            log.error("Element not found"+e);
            Assert.fail();
        }
    }
    public void check_SearchByLEIid(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            withAction().moveToElement(search_byLEIid).sendKeys(dataTable.get("LEI ID")).pause(Duration.ofSeconds(10)).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to search"+e);
            Assert.fail();
        }
    }public void checkSearchResult(){
        try {
            if (!searched_LEIid.isVisible()){
                norecordfound.isVisible();
            }
        }catch (Exception e){
            log.error("Error while Search "+e);
        }
    }
    public void type_filterLegalEntityType(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            withAction().moveToElement(filter_legalEntityType).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }catch (Exception e){
            log.error("Unable to set the filter");
        }
    }public void type_filterParentOrg(DataTable table){
        try {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            Map<String, String> dataTable_map = data.get(0);
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            withAction().moveToElement(filter_parentOrgs).click().sendKeys(dataTable.get("filter")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
        }catch (Exception e){
            log.error("Unable to set the filter");
        }
    }
    public void check_legalEntityInformation(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> row :data){
                Assert.assertTrue(find(By.xpath("//div[text()='"+row.get("columns")+"']")).isVisible());
//                Assert.assertTrue(find(By.xpath(columns+"[text()='"+row.get("columns")+"']")).isVisible());
//                withAction().moveToElement(find(By.xpath("//th//div"+))).build().perform();
            }
        }catch (Exception e){
            log.error("Element not found"+e);
            Assert.fail();
        }
    }
    public void check_parentOrgInformation(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> row :data){
                Assert.assertTrue(find(By.xpath("//div[text()='"+row.get("columns")+"']")).isVisible());
//                Assert.assertTrue(find(By.xpath(columns+"[text()='"+row.get("columns")+"']")).isVisible());
//                withAction().moveToElement(find(By.xpath("//th//div"+))).build().perform();
            }
        }catch (Exception e){
            log.error("Element not found"+e);
            Assert.fail();
        }
    }

    //2/7/2024
    public void legal_entity_filter_result(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        Assert.assertEquals(dataTable.get("filter"),legalEntityTypeResult.getText());
    }
    public void parent_org_filter_result(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        legalEntityTypeResult.waitUntilClickable().click();
        parentOrgResult.isVisible();
        Assert.assertEquals(dataTable.get("filter"),parentOrgResult.getText());
    }

}