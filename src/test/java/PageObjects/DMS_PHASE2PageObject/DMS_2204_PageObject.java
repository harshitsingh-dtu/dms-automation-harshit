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
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Data
public class DMS_2204_PageObject extends PageObject
{
    @FindBy(xpath = "//a[@data-testid='submenu-link-USP Riders']")
    private WebElementFacade USP_rider_Template_tab;
    @FindBy(xpath = "//div[@class='usp-title']")
    private WebElementFacade usp_title;
    @FindBy(xpath = "//div[@class='doclist-content']")
    private WebElementFacade doclist_content;
    @FindBy(xpath = "//tr/td[1]")
    private List<WebElementFacade> list_USP_IDs;
    @FindBy(xpath = "//tr/td[2]")
    private List<WebElementFacade> list_USP_with_PBs;
    @FindBy(xpath = "//div[@class='usp-subtitle']")
    private WebElementFacade USP_sub_tittle;
    @FindBy(xpath = "//input[@placeholder='Search by ID']")
    private WebElementFacade search_box_by_USP_ID;
    @FindBy(xpath = "//button[text()='+ Create New USP Rider']")
    private WebElementFacade create_new_USP_template_button;
    @FindBy(xpath = "//input[@placeholder='PB']")
    private WebElementFacade PB_dropdown;
    @FindBy(xpath = "//input[@placeholder=\"Client\"]")
    private WebElementFacade Clients_dropdown;
    @FindBy(xpath = "//input[@placeholder='Doc type']")
    private WebElementFacade Doc_type_filter;

    @FindBy(xpath = "//div[text()='ID']")
    private WebElementFacade ID_column;
    @FindBy(xpath = "//div[text()='PB name']")
    private WebElementFacade PB_Name_column;
    @FindBy(xpath = "//div[text()='Client name']")
    private WebElementFacade Client_Name_column;
    @FindBy(xpath = "//div[text()='Doc type']")
    private WebElementFacade Doc_type_column;
    @FindBy(xpath = "//div[text()='Word clause']")
    private WebElementFacade word_clause_column;

    @FindBy(xpath = "//div[text()='Last updated by']")
    private WebElementFacade Last_Updated_By_column;
    @FindBy(xpath = "//div[text()='Last updated on']")
    private WebElementFacade Last_Updated_on_column;
    @FindBy(xpath = "//div[text()='Action']")
    private WebElementFacade Action_column;
    @FindBy(xpath = "//div[text()='Related documents']")
    private WebElementFacade related_documents_column;
    @FindBy(xpath = "//div[@class='paginator']")
    private WebElementFacade Pagination_column;
    @FindBy(xpath = "//span[@class='page-size-num']")
    private WebElementFacade records_on_page;
    @FindBy(xpath = "//tr/td[7]")
    private List<WebElementFacade> list_USP_Last_Updated_By;
    @FindBy(xpath = "//tr/td[8]")
    private List<WebElementFacade> list_USP_Last_Updated_On;
    @FindBy(xpath = "//input[@@role=presentation']//div]")
    private List<WebElementFacade> PB_dropdown_list;
    @FindBy(xpath = "//input[@aria-activedescendant=\"mui-161-option-9\"]")
    private List<WebElementFacade> Client_dropdown_list;
    @FindBy(xpath = "//tr/td[3]")
    private List<WebElementFacade> list_USP_with_Clients;
    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade SearchedDocType;
    @FindBy(xpath = "//td/button")
    private WebElementFacade action_button;
    @FindBy(xpath = "//tr/td[2]")
    private List<WebElementFacade> PB_list_of_USP_templates;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElementFacade> list_of_USP_templates;
    @FindBy(xpath = "//td/button")
    private List<WebElementFacade> list_of_action_button;
    @FindBy(xpath = "//div[@class='no-record-found']")
    private WebElementFacade no_record_found;
    public void check_all_temp_have_View_button(){
        for (int i=0;i<=list_of_USP_templates.size()-1;i++)
        {
            if (list_of_action_button.get(i).getText().toLowerCase().contains("view")){
                log.info("Template have View button TC Pass");
            }
            else {
                log.info("Template dont have View button TC fail");
                Assert.fail();
            }
        }
    }
    public void Check_UPS_ID_format()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();

        for (int i=0;i<=list_USP_IDs.size()-1;i++)
        {
            if (list_USP_IDs.get(i).getText().matches("^US-[0-9]{6,7}$"))
            {
                log.info(list_USP_IDs.get(i).getText());
                System.out.println("ID format is valid.");
            }
            else
            {
                log.info(list_USP_IDs.get(i).getText());
                System.out.println("ID email format.");
                Assert.fail();
            }


        }
    }
    public void Check_USP_ID_Last_Updated_By_Format()
    {
withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=list_USP_Last_Updated_By.size()-1;i++)
        {
           if (list_USP_Last_Updated_By.get(i).getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
           {
               log.info(list_USP_Last_Updated_By.get(i).getText());
                System.out.println("Email format is valid.");
           }
           else
            {
                log.info(list_USP_Last_Updated_By.get(i).getText());
                System.out.println("Invalid email format.");
                Assert.fail();
            }


        }
    }
    public void Check_UPS_ID_Last_Updated_On_Format() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i = 0; i <= list_USP_Last_Updated_On.size() - 1; i++) {
            // Define the expected format
            String[] expectedFormats = {"d MMMM yyyy, h:mm:ss a", "dd MMMM yyyy, h:mm:ss a"};
            boolean isValidFormat = false;
            for (String expectedFormat : expectedFormats) {
                try {
                    // Define the formatter
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat);
                    // Parse the provided date string
                    LocalDateTime dateTime = LocalDateTime.parse(list_USP_Last_Updated_On.get(i).getText(), formatter);
                    // If parsing is successful, print the formatted date
                    String formattedDate = dateTime.format(formatter);
                    System.out.println("Formatted Date: " + formattedDate);
                    // If the formatting doesn't throw an exception, then the format is valid
                    System.out.println("Format is valid.");
                    isValidFormat = true;
                    break; // Break out of the loop if a valid format is found
                } catch (Exception e) {
                    // If an exception occurs, try the next format
                    System.out.println(list_USP_Last_Updated_On.get(i).getText() + "<-----Format is invalid.");
                }
            }
            if (!isValidFormat) {
                Assert.fail();
            }
        }
    }

    public void verify_search_functionality_by_ID()
    {
        Random random = new Random();

        int randomNumber = random.nextInt(list_USP_IDs.size());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        String random_USP_ID = list_USP_IDs.get(randomNumber).getText().trim();
             withAction().moveToElement(search_box_by_USP_ID).click().sendKeys(random_USP_ID).build().perform();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
             if (list_USP_IDs.get(0).getText().trim().contains(random_USP_ID))
             {
                 log.info("Search functionality working properly");
             }
             else {
                 log.info("Search functionality not working properly TC fail");
                 Assert.fail();
             }
    }
    public void verify_records_are_same_on_webpage_as_per_web_page()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        int records = Integer.parseInt(records_on_page.getText());
        log.info(records+"<----->"+list_USP_IDs.size());
        if (list_USP_IDs.size()==records)
        {
            log.info("Records are matching with pagination");
        }
        else
        {
            log.info("Records are not matching with pagination");
            Assert.fail();
        }
    }
    public void check_default_list_under_PB_dropdown(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        PB_dropdown.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        withAction().sendKeys(Keys.ARROW_UP).build().perform();
        Assert.assertTrue(getPB_dropdown().getAttribute("aria-activedescendant").contains("option-29"));
    }
    public void verify_search_functionality_by_PB()
    {
        Random random = new Random();
        int randomNumber = random.nextInt(list_USP_with_PBs.size());
        withAction().moveToElement(PB_dropdown).click().sendKeys(list_USP_with_PBs.get(randomNumber).getText()).build().perform();
        withAction().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        if (list_USP_with_PBs.get(1).getText().contains(list_USP_with_PBs.get(randomNumber).getText()))
        {
            log.info("Search functionality working properly");
        }
        else {
            log.info("Search functionality not working properly TC fail");
            Assert.fail();
        }
    }

    public void check_default_list_under_client_dropdown(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Clients_dropdown.click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        withAction().sendKeys(Keys.ARROW_UP).build().perform();
        Assert.assertTrue(getClients_dropdown().getAttribute("aria-activedescendant").contains("option-29"));
    }
    public void verify_search_functionality_by_Client()
    {
        Random random = new Random();
        int randomNumber = random.nextInt(list_USP_with_Clients.size());
        withAction().moveToElement(Clients_dropdown).click().sendKeys(list_USP_with_Clients.get(randomNumber).getText()).build().perform();
        withAction().pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        if (list_USP_with_Clients.get(1).getText().contains(list_USP_with_Clients.get(randomNumber).getText()))
        {
            log.info("Search functionality working properly");
        }
        else
        {
            log.info("Search functionality not working properly TC fail");
            Assert.fail();
        }
    }

    public void verifyDocTypesList(List<String> filters)
    {
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            Doc_type_filter.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin = 1; begin < filters.size(); begin++) {
                Doc_type_filter.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(filters.get(begin),SearchedDocType.getText());
            }
            Doc_type_filter.clear();

        } catch (Exception e)
        {
            log.error("Expected doc type is not present");
            Assert.fail();
        }
    }
    @FindBy(xpath = "//tr/td[4]")
    private List<WebElementFacade> list_of_doc_types_of_USP_template;
    public void verify_search_functionality_by_Doc_Type_Filter(List<String> filters)
    {
        for (int i=1;i<=filters.size()-1;i++)
        {
            Doc_type_filter.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().findElement(By.xpath("//span[text()='" + filters.get(i)+"']")).click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

            for (int j=0;j<=list_of_doc_types_of_USP_template.size()-1;j++) {
                if (list_of_doc_types_of_USP_template.get(j).getText().toLowerCase().contains(filters.get(i).toLowerCase()))
                {
                    log.info("Doc type filter working properly");
                }
                else if (list_of_doc_types_of_USP_template.get(j).getText().toLowerCase().contains("+1"))
                {
                    log.info("Doc type filter working properly");
                }
                else
                {
                    log.info("Doc type filter not working properly TC fail");
                    Assert.fail();
                }
            }
        getDriver().navigate().refresh();
        }
    }
    @FindBy(xpath = "//div[@class='profile-menus']//header")
    private WebElementFacade User_organisation;
    @FindBy(xpath = "//div[@class='profile-icon']")
    private WebElementFacade profile;
    public void check_user_can_see_other_org_under_PB_column()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim().toLowerCase();
                for (int i=0;i<=PB_list_of_USP_templates.size();i++)
                {
                    try
                    {
                       if (!PB_list_of_USP_templates.get(i).getText().toLowerCase().contains(parent_org_name))
                       {
                        log.info("User can see other org USP Template TC Pass ");
                        break;
                       }
                    }
                    catch (Exception e)
                    {
                        log.info("User can't see other org USP Template TC fail ");
                        Assert.fail();
                    }
                }

    }

    public void check_user_can_see_only_own_org_under_PB_column()
    {
        withAction().pause(Duration.ofSeconds(5)).moveToElement(profile).click().pause(Duration.ofSeconds(4)).build().perform();
        String parent_org_name = User_organisation.getText().trim().toLowerCase();
        for (int i=0;i<=PB_list_of_USP_templates.size()-1;i++)
        {
                if (PB_list_of_USP_templates.get(i).getText().toLowerCase().contains(parent_org_name))
                {
                    log.info("User can see own org USP Template TC Pass ");
                }
            else
            {
                log.info("User can see other org USP Template TC fail ");
                Assert.fail();
            }
        }
    }

    public void check_update_button_should_visible_only_for_4Way_temp()
    {
        for (int i=0;i<=list_of_USP_templates.size()-1;i++)
        {
         if (list_of_doc_types_of_USP_template.get(i).getText().equalsIgnoreCase("4 Way"))
         {
             if (list_of_action_button.get(i).getText().equalsIgnoreCase("Update"))
             {
              log.info("Update button is visible for 4 Way template");
             }
             else
             {
                 log.info("Update button is not visible for 4 Way template TC fail");
                 Assert.fail();
             }
         }
         else if (!list_of_doc_types_of_USP_template.get(i).getText().equalsIgnoreCase("4 Way"))
         {
             if (list_of_action_button.get(i).getText().equalsIgnoreCase("Update"))
             {
                 log.info("Update button is visible for non 4 Way USP template TC fail");
                 Assert.fail();
             }
         }
        }
    }
    public void check_view_button_should_visible_other_then_4Way_temp()
    {
        for (int i=0;i<=list_of_USP_templates.size()-1;i++)
        {
            if (!list_of_doc_types_of_USP_template.get(i).getText().equalsIgnoreCase("4 Way"))
            {
                if (list_of_action_button.get(i).getText().equalsIgnoreCase("View"))
                {
                    log.info("View button is visible for other then 4 Way USP template");
                }
                else
                {
                    log.info("View button is not visible for other then 4 Way USP template");
                    Assert.fail();
                }
            }
            else if (list_of_doc_types_of_USP_template.get(i).getText().equalsIgnoreCase("4 Way"))
            {
                if (list_of_action_button.get(i).getText().equalsIgnoreCase("View"))
                {
                    log.info("View button is visible for 4 Way USP template TC fail");
                    Assert.fail();
                }
            }
        }
    }

    public void check_update_button_should_visible_only_for_DN_USP_temp()
    {
        for (int i=0;i<=list_of_USP_templates.size()-1;i++)
        {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            String docType = list_of_doc_types_of_USP_template.get(i).getText().trim();
            log.info("----->"+docType);
            if (docType.equalsIgnoreCase("DN"))
            {
                if (list_of_action_button.get(i).getText().equalsIgnoreCase("Update"))
                {
                    log.info("Update button is visible for DN template");
                }
                else
                {
                    log.info("Update button is not visible for DN template TC fail");
                    Assert.fail();
                }
            }
            else// (!docType.equalsIgnoreCase("DN"))
            {
                if (list_of_action_button.get(i).getText().equalsIgnoreCase("Update"))
                {
                    log.info(list_USP_IDs.get(i).getText()+"Update button is visible for non DN USP template TC fail"+i);
                    Assert.fail();
                }
            }
        }
    }

    public void check_view_button_should_visible_other_then_DN_USP_temp()
    {
        for (int i=0;i<=list_of_USP_templates.size()-1;i++)
        {
            if (!list_of_doc_types_of_USP_template.get(i).getText().equalsIgnoreCase("DN"))
            {
                if (list_of_action_button.get(i).getText().equalsIgnoreCase("View"))
                {
                    log.info("View button is visible for other then DN USP template");
                }
                else
                {
                    log.info("View button is not visible for other then DN USP template");
                    Assert.fail();
                }
            }
            else if (list_of_doc_types_of_USP_template.get(i).getText().equalsIgnoreCase("DN"))
            {
                if (list_of_action_button.get(i).getText().equalsIgnoreCase("View"))
                {
                    log.info("View button is visible for DN USP template TC fail");
                    Assert.fail();
                }
            }
        }
    }
    public void verify_search_functionality_of_PB_dropdown_of_USP_listing_screen()
    {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Set<String> PBs_to_select = new HashSet<>();
        for (WebElementFacade PBS : PB_list_of_USP_templates)
        {
            log.info(PBS.getText()+"<-----adding");
            PBs_to_select.add(PBS.getText());
           if (PBs_to_select.size()==2)
           {
             break;
           }
        }
      PB_dropdown.click();
        List<String> selected_PBs = new LinkedList<>();
        for (String pb : PBs_to_select)
        {
            log.info("Print---->"+pb);
         withAction().sendKeys(pb).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            selected_PBs.add(pb);
        }
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        for (WebElementFacade pb:PB_list_of_USP_templates){
            if (!selected_PBs.contains(pb.getText()))
            {
                log.info("Search is not working TC fail");
                Assert.fail();
            }

        }
    }

    public void verify_search_functionality_of_Clients_dropdown_of_USP_listing_screen()
    {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Set<String> PBs_to_select = new HashSet<>();
        for (WebElementFacade PBS : list_USP_with_Clients)
        {
            PBs_to_select.add(PBS.getText());
            if (PBs_to_select.size()==2)
            {
                break;
            }
        }
        Clients_dropdown.click();
        List<String> selected_PBs = new LinkedList<>();
        for (String pb : PBs_to_select)
        {
            withAction().sendKeys(pb).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            selected_PBs.add(pb);
        }
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        for (WebElementFacade pb:list_USP_with_Clients){
            if (!selected_PBs.contains(pb.getText()))
            {
                log.info("Search is not working TC fail");
                Assert.fail();
            }

        }
    }

    public void SelectUSPPB(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(PB_dropdown).click().sendKeys(dataTable.get("PB Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.error("Unable to input PB Name-->" + e);
            Assert.fail();
        }

    }
    public void SelectUSPclient(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String,String> dataTable_map= data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(Clients_dropdown).click().sendKeys(dataTable.get("Client Name")).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.error("Unable to input PB Name-->" + e);
            Assert.fail();
        }

    }
}