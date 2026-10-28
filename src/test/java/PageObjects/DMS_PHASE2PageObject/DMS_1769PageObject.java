package PageObjects.DMS_PHASE2PageObject;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Slf4j
@Data
public class DMS_1769PageObject extends PageObject
{
    @FindBy(xpath = "//div[text()='Approval request']")
    private WebElementFacade approval_request_tab;
    @FindBy(xpath = "//div[text()='Documents access request']")
    private WebElementFacade documents_access_request_tab;
    @FindBy(xpath = "//strong[text()='Documents access request']")
    private WebElementFacade documents_access_request_screen_heading;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade Submit_btn;

    @FindBy(xpath = "//input[@placeholder='Search by request ID']")
    private WebElementFacade search_by_request_ID_input;
    @FindBy(xpath = "//input[@placeholder='Select requester']")
    private WebElementFacade select_requester_input;
    @FindBy(xpath = "//input[@placeholder='Select requester LEI']")
    private WebElementFacade select_requester_LEI_input;
    @FindBy(xpath = "//input[@placeholder='Select reviewer']")
    private WebElementFacade select_reviewer_input;
    @FindBy(xpath = "//input[@placeholder='Select reviewer LEI']")
    private WebElementFacade select_reviewer_LEI_input;
    @FindBy(xpath = "//input[@placeholder='Select doc type']")
    private WebElementFacade Select_doc_type_input;
    @FindBy(xpath = "//input[@placeholder='Select status']")
    private WebElementFacade select_status_input;
    @FindBy(xpath = "//button[text()='View Details']")
    private List<WebElementFacade> view_details_btn;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElementFacade> requests_list;
    @FindBy(xpath = "//ul[@role='listbox']")
    private WebElementFacade list_of_filters;
    @FindBy(xpath = "//tr/td[1]")
    private WebElementFacade first_requests_ID;
    @FindBy(xpath = "//td/span")
    private List<WebElementFacade> requests_status_list;
    @FindBy(xpath = "//tr/td[2]")
    private List<WebElementFacade> requests_doc_type_list;
    @FindBy(xpath = "//input[@class='page-number']")
    private WebElementFacade current_page_on_pagination;
//    Xpath need to check
    @FindBy(xpath = "//span[@class='total-page'][1]")
    private WebElementFacade total_page_on_pagination;
    @FindBy(xpath = "//span[@class='page-size-num']")
    private WebElementFacade total_number_of_records_per_page_pagination;
    @FindBy(xpath ="//div[@class='btn-container']//button[1]")
    private WebElementFacade previous_page_button;
    @FindBy(xpath ="//div[@class='btn-container']//button[2]")
    private WebElementFacade next_page_button;
    @FindBy(xpath = "//tr/td[8]")
    private List<WebElementFacade> requests_version_ID_list;
    @FindBy(xpath = "//tr/td[5]")
    private List<WebElementFacade> requests_Reviewed_BY_list;
    @FindBy(xpath = "//tr/td[3]")
    private List<WebElementFacade> requests_Requested_BY_list;
    @FindBy(xpath = "//div[text()='No Record Found']")
    private WebElementFacade no_record_found_msg;
    @FindBy(xpath = "//li[@aria-selected='true']//span[text()]")
    private List<WebElementFacade> list_of_elements_selected_in_multi_selectable_dropdown;
    @FindBy(xpath = "//tr/td[1]")
    private List<WebElementFacade> list_of_requests_ID;

    public void pick_random_Request_ID_and_verify_search_functionality()
    {

        Random random = new Random();
        int randomNumber = random.nextInt(list_of_requests_ID.size());
        String random_requests_ID = list_of_requests_ID.get(randomNumber).getText();
        withAction().moveToElement(search_by_request_ID_input).click().sendKeys(random_requests_ID).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        if (first_requests_ID.getText().contains(random_requests_ID)){
            log.info("Search functionality working properly");
        }
        else {
            log.error("Search functionality not working properly");
            Assert.fail();
        }
    }
    public void select_status_on_requests_screen(List<String> status_filters)
    {
        withAction().moveToElement(select_status_input).click().sendKeys(status_filters.get(1)).pause(Duration.ofSeconds(2)).sendKeys( Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    public void check_enter_filter_and_results_should_be_same(List<String> status_filters)
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=1;i<=status_filters.size()-1;i++) {
            withAction().moveToElement(select_status_input).click().sendKeys(status_filters.get(i)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
           for (int j=0;j<=requests_status_list.size()-1;j++)
           {
               if (status_filters.get(i).equalsIgnoreCase(requests_status_list.get(j).getText()))
               {
                   log.info(status_filters.get(i)+"--------------->present at index--->"+j);
               }
               else {
                   Assert.fail();
               }

           }

        }

    }
    public void change_Records_per_page_to_50()
    {
        Select pages = new Select(getDriver().findElement(By.tagName("select")));
        pages.selectByValue("100");
    }

    public void verify_version_ID_format(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        for (int i=0;i<=requests_version_ID_list.size()-1;i++)
        {
            log.info(requests_version_ID_list.size() +"<-------- IDs Size");

       if (requests_version_ID_list.get(i).getText().matches("^(4W|DN)-\\d{6}-[A-Z]-\\d{3}$")){
          log.info("Version id is right format"+requests_version_ID_list.get(i).getText());
       } else if (requests_version_ID_list.get(i).getText().matches(""))
       {
           log.info("Version id is blank");
       }
       else {
           withAction().pause(Duration.ofSeconds(4)).build().perform();
           log.info(i+"Version id format is wrong ");
           log.info("---->"+requests_version_ID_list.get(i).getText());
           Assert.fail();

       }
        }
    }

    public void verify_email_ID_format(){
        if (!no_record_found_msg.isVisible()){
            for (int i=0;i<=requests_Reviewed_BY_list.size()-1;i++)
            {
                log.info(requests_Reviewed_BY_list.size() +"<--------");

                if (requests_Reviewed_BY_list.get(i).getText().matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9.]+$")){
                    log.info("email_ID is in right format");
                }
                else {
                    log.info("email_ID format is wrong ");
                    Assert.fail();
                }
            }
        }
        else {
            log.info(no_record_found_msg.getText()+"on listing screen ");
            Assert.fail();
        }

    }
    public void select_doc_types_on_requests_screen(List<String> doc_types)
    {
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        withAction().moveToElement(Select_doc_type_input).click().sendKeys(doc_types.get(1)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

    }

}
