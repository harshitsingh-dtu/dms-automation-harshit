package PageObjects.DocumentTemplate;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class DocumentTemplatePageObject extends PageObject {
    Actions act=new Actions(getDriver());

    @FindBy(xpath = "//div[@data-testid='menu-category-name' and normalize-space()='Groups & templates']")
    private WebElementFacade groupAndTemplate_tab;
    @FindBy(xpath = "//a[@data-testid='submenu-link-Document templates']")
    private WebElementFacade document_template_tab;
    @FindBy(xpath = "//*[contains(text(),'Document templates')]")
    private WebElementFacade document_template_text;
    @FindBy(xpath = "//input[@placeholder=\"Search by template name\"]")
    private WebElementFacade search;
    @FindBy(xpath = "//table[@class=\"csm_standard_table undefined\"]//tbody//tr//td[1]")
    private WebElementFacade searchedresult_grpname;
    public void clickDocumentTemplateTab(){
        try{
            Assert.assertTrue(groupAndTemplate_tab.isVisible());
            groupAndTemplate_tab.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Assert.assertTrue(document_template_tab.isVisible());
            document_template_tab.waitUntilClickable().click();
        }catch (Exception e){
            log.error("Unable to click document template tab -->"+e);
            Assert.fail();
        }
    }
    public void verifyDocumentTemplateText(){
        Assert.assertTrue(document_template_text.isVisible());
        log.info("Successfully verified document template text");
    }

    public void clickTemplateGroupSearch_bar(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try{
            search.waitUntilVisible().click();
            search.clear();
            typeInto(search,dataTable.get("Template Name"));
            act.pause(Duration.ofSeconds(2)).build().perform();
        }catch (Exception e){
            log.error("Unable to click search bar-->"+e);
            Assert.fail();
        }
    }

    public boolean checkTemplateResult() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (searchedresult_grpname.getText().equalsIgnoreCase(search.getAttribute("value"))){
            return true;
        }
        else {
            return false;
        }
    }
}