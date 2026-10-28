package PageObjects.DMS_PHASE2PageObject;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DMS_1550_PageObject extends PageObject
{
;
    @FindBy(xpath = "//tr/td[text()='4 Way']")
    private WebElementFacade Assigned_LEI_with_4W;

    @FindBy(xpath = "//div[@class='select-container']//input[@placeholder='Select Doc Type']")
    private WebElementFacade doctype;
    @FindBy(xpath ="//div[text()='Select LEIs']")
    private WebElementFacade search_LEI;
    @FindBy(xpath ="//div[@class='select-container']//input[@placeholder='Select Org Type']")
    private WebElementFacade search_orgType;
    @FindBy(xpath = "//button[text()='+ Add']")
    private WebElementFacade add_btn;
    @FindBy(xpath = "//img[@alt='Approve']")
    private WebElementFacade Approve_button_All_document_listing_screen;
    @FindBy(xpath = "//img[@alt='Reject']")
    private WebElementFacade Reject_button_All_document_listing_screen;
    @FindBy(xpath = "//img[@alt='Terminate']")
    private WebElementFacade Terminate_button_All_document_listing_screen;
    @FindBy(xpath="//th[text()='Document Type']//input")
    private WebElementFacade Document_Type_Input;
    @FindBy(xpath="//div[@role='presentation']")
    private WebElementFacade Document_Type_result;
    @FindBy(xpath = "//tr/th[text()='Document Status']//input")
    private WebElementFacade filter_document_status;
    @FindBy (xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade search_versionID;
    @FindBy(xpath = "//tr/th[text()='Document ID']//input")
    private WebElementFacade search_documentID;
    @FindBy(xpath = "//img[@alt='Terminate']")
    private WebElementFacade Terminate_Button;
    @FindBy(xpath = "//img[@alt='Download']")
    private WebElementFacade Download_Button;
    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade document_edit_btn;
    @FindBy(xpath = "//img[@alt='Download']")
    private List<WebElementFacade> list_of_Download_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade edit_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Delete']")
    private List<WebElementFacade> list_of_Delete_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Terminate']")
    private List<WebElementFacade> list_of_Terminate_btn_on_listing_screen;
    @FindBy(xpath = "//img[@alt='Delete']")
    private WebElementFacade Delete_btn_on_listing_screen;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElementFacade> list_of_docs_on_listing_screen;
    @FindBy(xpath ="//div[@class='lei-org-title']//input[@placeholder='Select Org Type']")
    private WebElementFacade search_org_Type_from_assign_lei;

    public void Assign_LEI_with_4W_doc_type()
    {withAction().moveToElement(search_org_Type_from_assign_lei).click().sendKeys("PB").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        if (!Assigned_LEI_with_4W.isVisible())
        {
            doctype.waitUntilClickable();
            withAction().moveToElement(doctype).click().sendKeys("4 Way").pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
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

    public void ColumnAndColumnValueCheck(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);

        try {

            List<WebElementFacade> columnList = findAll("//tr//th");
            int column_size = columnList.size();
            log.info("column size on screen is :" + column_size);
            int columncount = 1;
            for (WebElementFacade Column_Text : columnList) {
                String Columntext = Column_Text.getText();
                log.info("column name is " + Columntext);
                if (dataTable.get("field").equalsIgnoreCase(Columntext)) {
                    Assert.assertTrue(dataTable.get("field").equalsIgnoreCase(Columntext));
                    log.info("Corresponding column name on the screen" + columncount);
                    List<WebElementFacade> RowList = findAll("//tr//td[" + columncount + "]");
                    int Rowsize = RowList.size();
                    log.info("Row count is " + Rowsize);
                    int rowcount = 1;
                    for (WebElementFacade ROW_Text : RowList) {
                        String Rowtext = ROW_Text.getText();
                        log.info("column name is " + Rowtext);

                        Assert.assertTrue(dataTable.get("value").equalsIgnoreCase(Rowtext));   //there is no other way to fail this script

                        rowcount++;
                    }
                    break;
                }
                columncount++;
            }
        }catch (Exception e){
            log.error("unable to check column and column value"+ e);
            Assert.fail();
        }
    }

    public void select_doc_type(List<String> doc_type)
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Document_Type_Input.waitUntilVisible();
        Document_Type_Input.clear();
        withAction().moveToElement(Document_Type_Input).click().sendKeys(doc_type.get(1)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }
    public void select_doc_status(List<String> doc_status){

        search_versionID.clear();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        search_documentID.clear();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        withAction().moveToElement(filter_document_status).click().sendKeys(doc_status.get(1)).pause(Duration.ofSeconds(2)).build().perform();
    }
}
