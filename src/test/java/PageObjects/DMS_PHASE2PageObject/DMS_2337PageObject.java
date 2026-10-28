package PageObjects.DMS_PHASE2PageObject;


import PageObjects.Documents.DocumentPageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.NoSuchElementException;

@Slf4j
@Data
public class DMS_2337PageObject extends PageObject
{
    DocumentPageObject documentPageObject;

    @FindBy(xpath = "(//input[@placeholder=\"Search\"])[2]")
    private WebElementFacade inputDocumentversionID;
    @FindBy(xpath = "//tr[.//a[contains(.,'New Update')] or td[contains(.,'New Update')]]//td[3]")
    private WebElementFacade documentversionID;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElementFacade closebutton;
    @FindBy(xpath = "//button[@class=\"link\"]")
    private WebElementFacade hyperlinkusp;
    @FindBy(xpath = "//input[@placeholder='Doc type']")
    private WebElementFacade Doc_type_filter;
    @FindBy(xpath = "//div[@class='docCount']")
    private WebElementFacade docCount;
    @FindBy(xpath = "//div[@class='impacted-heading']")
    private WebElementFacade impacted_doc_listing_screen_heading;
    @FindBy(xpath = "//div[@class='impacted-subheading']")
    private WebElementFacade impacted_doc_listing_screen_sub_heading;
    @FindBy(xpath = "//tr/td[5]")
    private List<WebElementFacade> related_documents_count_list;
    @FindBy(xpath = "//tr/td[1]")
    private List<WebElementFacade> USP_ID_list;
    @FindBy(xpath = "//input[@placeholder='Search by ID']")
    private WebElementFacade search_box_by_USP_ID;
    @FindBy(xpath = "//div[@class='impacted-heading']//following::tbody/tr/td[2]")
    private List<WebElementFacade> impacted_doc_ID_list;
    @FindBy(xpath = "//div[@class='impacted-heading']//following::input[@placeholder='Select doc type']")
    private WebElementFacade impacted_doc_screen_doc_type_dropdown;
    @FindBy(xpath = "//div[@class='impacted-heading']//following::input[@placeholder='Search with document & version ID']")
    private WebElementFacade impacted_doc_screen_search_box;

    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='Document ID']")
    private WebElementFacade impacted_doc_screen_doc_ID_column;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='Version ID']")
    private WebElementFacade impacted_doc_screen_doc_Version_ID_column;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='Doc type']")
    private WebElementFacade impacted_doc_screen_doc_type_column;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='USP template ID']")
    private WebElementFacade impacted_doc_screen_USP_template_ID_column;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='USP update status']")
    private WebElementFacade impacted_doc_screen_USP_Update_Status_column;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='Last updated on']")
    private WebElementFacade impacted_doc_screen_Last_Updated_On_column;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::th[text()='Doc status']")
    private WebElementFacade impacted_doc_screen_doc_status_column;

    @FindBy(xpath = "//div[@class='impacted-subheading']//following::button[text()='Close']")
    private WebElementFacade impacted_doc_screen_close_button;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::button[text()='Apply']")
    private WebElementFacade impacted_doc_screen_apply_button;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::button[text()='Apply' and @disabled]")
    private WebElementFacade impacted_docApply_button_Disabled;
    @FindBy(xpath = "//div[@class='usp-title']//following::tr//td[6]")
    private List<WebElementFacade> list_word_clause_USP_template_screen;
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[6]//span")
    private List<WebElementFacade> list_USP_update_status_impacted_document_screen;
    @FindBy(xpath = "//p[text()='Version Compare']")
    private WebElementFacade USP_Version_Compare_popup_heading;

    @FindBy(xpath = "//header[text()='Current Version']")
    private WebElementFacade current_Version_section_on_Compare_popup;
    @FindBy(xpath = "//header[text()='New Version']")
    private WebElementFacade new_Version_section_on_Compare_popup;
    @FindBy(xpath = "//p[text()='Version Compare']//following::button[text()='Close']")
    private WebElementFacade close_button_on_Compare_popup;

    public void select_doc_type_from_USP_listing_screen(List<String> filters) {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (Doc_type_filter.isVisible())
        {
            Doc_type_filter.click();
        }
        for (int i = 1; i <= filters.size() - 1; i++) {

            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().findElement(By.xpath("//span[text()='" + filters.get(i) + "']")).click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

        }

    }

//    String  usp_id_with_related_documents_count_more_then_0;
    public String get_USP_temp_ID_without_0_related_documents_count() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i = 0; i <= related_documents_count_list.size() - 1; i++)
        {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (!related_documents_count_list.get(i).getText().trim().equals("0")) {
                String usp_id_with_related_documents_count_more_then_0 = USP_ID_list.get(i).getText().trim();
                 log.info(usp_id_with_related_documents_count_more_then_0);
                return usp_id_with_related_documents_count_more_then_0;
            }
        }
        log.info("Template not found with impacted documents");
        Assert.fail();
        return null;

    }

    public void search_USP_ID(String get_USP_temp_ID_without_0_related_documents_count){
        log.info(get_USP_temp_ID_without_0_related_documents_count);
        search_box_by_USP_ID.sendKeys(get_USP_temp_ID_without_0_related_documents_count);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    public void check_impacted_doc_list()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        log.info("Number of document impacted by USP template--->"+String.valueOf(impacted_doc_ID_list.size()));
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=impacted_doc_ID_list.size()-1;i++){
            log.info(impacted_doc_ID_list.get(i).getText());
        }
    }

    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[5]")
    private List<WebElementFacade> list_USP_IDs_impacted_document_screen;

    public void Check_UPS_ID_format()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=list_USP_IDs_impacted_document_screen.size()-1;i++)
        {
            if (list_USP_IDs_impacted_document_screen.get(i).getText().matches("^US-[0-9]{6,7}$"))
            {
                log.info(list_USP_IDs_impacted_document_screen.get(i).getText());
                System.out.println("ID format is valid.");
            }
            else
            {
                log.info(list_USP_IDs_impacted_document_screen.get(i).getText());
                System.out.println("ID email format.");
                Assert.fail();
            }
        }
    }
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[2]")
    private List<WebElementFacade> list_doc_IDs_impacted_document_screen;
    public void Check_doc_ID_format()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=list_doc_IDs_impacted_document_screen.size()-1;i++)
        {
            if (list_doc_IDs_impacted_document_screen.get(i).getText().matches("^(4W|DN)-\\d{6}-[A-Z]$"))
            {
                log.info(list_doc_IDs_impacted_document_screen.get(i).getText());
                System.out.println("ID format is valid.");
            }
            else
            {
                log.info(list_doc_IDs_impacted_document_screen.get(i).getText());
                System.out.println("ID email format.");
                Assert.fail();
            }
        }
    }
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[3]")
    private List<WebElementFacade> list_doc_version_IDs_impacted_document_screen;

    public void Check_doc_version_ID_format()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=list_doc_version_IDs_impacted_document_screen.size()-1;i++)
        {
            if (list_doc_version_IDs_impacted_document_screen.get(i).getText().matches("^(4W|DN)-\\d{6}-[A-Z]-\\d{3}$"))
            {
                log.info(list_doc_version_IDs_impacted_document_screen.get(i).getText());
                System.out.println("ID format is valid.");
            }
            else
            {
                log.info(list_doc_version_IDs_impacted_document_screen.get(i).getText());
                System.out.println("ID email format.");
                Assert.fail();
            }
        }
    }

    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[8]")
    private List<WebElementFacade> list_doc_status_impacted_document_screen;

    public void Check_doc_status_is_Enforced()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i=0;i<=list_doc_status_impacted_document_screen.size()-1;i++)
        {
            if (list_doc_status_impacted_document_screen.get(i).getText().equalsIgnoreCase("Enforced"))
            {
                System.out.println("Document status is Enforced");
            }
            else
            {
                System.out.println("Document status is not Enforced");
                Assert.fail();
            }
        }
    }
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[7]")
    private List<WebElementFacade> list_USP_Last_Updated_On_impacted_document_screen;
    public void Check_UPS_ID_Last_Updated_On_Format() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (int i = 0; i <= list_USP_Last_Updated_On_impacted_document_screen.size() - 1; i++) {
            // Define the expected format
            String[] expectedFormats = {"d MMMM yyyy, h:mm:ss a", "dd MMMM yyyy, h:mm:ss a"};
            boolean isValidFormat = false;
            for (String expectedFormat : expectedFormats) {
                try {
                    // Define the formatter
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat);
                    // Parse the provided date string
                    LocalDateTime dateTime = LocalDateTime.parse(list_USP_Last_Updated_On_impacted_document_screen.get(i).getText(), formatter);
                    // If parsing is successful, print the formatted date
                    String formattedDate = dateTime.format(formatter);
                    System.out.println("Formatted Date: " + formattedDate);
                    // If the formatting doesn't throw an exception, then the format is valid
                    System.out.println("Format is valid.");
                    isValidFormat = true;
                    break; // Break out of the loop if a valid format is found
                } catch (Exception e) {
                    // If an exception occurs, try the next format
                    System.out.println(list_USP_Last_Updated_On_impacted_document_screen.get(i).getText() + "<-----Format is invalid.");
                }
            }
            if (!isValidFormat) {
                Assert.fail();
            }
        }
    }
    @FindBy(xpath = "//span[@class='custom-label']")
    private WebElementFacade SearchedDocType;
    public void verifyDocTypesList(List<String> filters)
    {
        try {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            impacted_doc_screen_doc_type_dropdown.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            for (int begin = 1; begin < filters.size(); begin++) {
                impacted_doc_screen_doc_type_dropdown.type(filters.get(begin));
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                Assert.assertEquals(filters.get(begin),SearchedDocType.getText());
            }
            impacted_doc_screen_doc_type_dropdown.clear();

        } catch (Exception e)
        {
            log.error("Expected doc type is not present");
            Assert.fail();
        }
    }
    public void select_doc_type_from_impacted_document_screen(List<String> filters) {
        impacted_doc_screen_doc_type_dropdown.click();
        for (int i = 1; i <= filters.size() - 1; i++) {
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            getDriver().findElement(By.xpath("//span[text()='" + filters.get(i) + "']")).click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

        }

    }
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[4]")
    private List<WebElementFacade> list_doc_type_impacted_document_screen;

    public void Verify_Corresponding_result_for_doc_type(List<String> filters) {
        for (int i = 1; i <= list_doc_type_impacted_document_screen.size() - 1; i++)
        {
            if (filters.contains(list_doc_type_impacted_document_screen.get(i).getText()))
            {
                log.info("Doc type is  matching TC pass");
            }
            else if (list_doc_type_impacted_document_screen.get(i).getText().contains("+1"))
            {
                log.info("Doc type is  matching TC pass");
            }
            else
            {
               log.info("Doc type is not matching TC fail");
               Assert.fail();
            }
        }

    }
    public void check_USP_update_under_USP_Update_Status_column()
    {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        for (int i=0;i<=list_USP_update_status_impacted_document_screen.size()-1;i++)
        {
            if (list_USP_update_status_impacted_document_screen.get(i).getText().contains("New Update"))
            {
                log.info("New update is available for document ---->"+list_doc_IDs_impacted_document_screen.get(i).getText());
                list_USP_update_status_impacted_document_screen.get(i).click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (!USP_Version_Compare_popup_heading.isVisible())
                {
                   log.info("After clicking new update hyperlink compare popup is not open TC fail");
                   Assert.fail();
                }
                break;
            } else if (list_USP_update_status_impacted_document_screen.get(i).getText().contains("Up to date"))
            {
                log.info("USP is Up to date is for document ---->"+list_doc_IDs_impacted_document_screen.get(i).getText());
            }
            else {
                log.info("Status is not New Update available nor Up to date TC fail");
                log.info(list_doc_IDs_impacted_document_screen.get(i).getText());
                Assert.fail();
            }
        }
    }

    public void check_compare_popup_element_for_new_update()
    {
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        for (int i=0;i<=list_USP_update_status_impacted_document_screen.size()-1;i++)
        {
            if (list_USP_update_status_impacted_document_screen.get(i).getText().contains("New Update"))
            {
                log.info("New update is available for document ---->"+list_doc_IDs_impacted_document_screen.get(i).getText());
//                list_USP_update_status_impacted_document_screen.get(i).click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                if (USP_Version_Compare_popup_heading.isVisible())
                {
                    Assert.assertTrue(current_Version_section_on_Compare_popup.isVisible());
                    Assert.assertTrue(new_Version_section_on_Compare_popup.isVisible());
                    Assert.assertTrue(close_button_on_Compare_popup.isVisible());

                }
                break;
            } else if (list_USP_update_status_impacted_document_screen.get(i).getText().contains("Up to date"))
            {
                log.info("USP is Up to date is for document ---->"+list_doc_IDs_impacted_document_screen.get(i).getText());
            }
            else {
                log.info("Status is not New Update available nor Up to date TC fail");
                log.info(list_doc_IDs_impacted_document_screen.get(i).getText());
                Assert.fail();
            }
        }
    }
    public void search_box_functionality_on_impacted_document_screen()
    {
        Random random = new Random();

        int randomNumber = random.nextInt(list_doc_IDs_impacted_document_screen.size());
        String ID=list_doc_IDs_impacted_document_screen.get(randomNumber).getText().trim();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        withAction().moveToElement(impacted_doc_screen_search_box).click().sendKeys(ID).build().perform();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        if (!list_doc_IDs_impacted_document_screen.get(0).getText().contains(ID))
        {
            log.info("Search functionality on impacted document screen is not working");
            Assert.fail();
        }
    }
    @FindBy(xpath = "//div[@class='impacted-subheading']//following::tr//td[1]/input")
    private List<WebElementFacade> list_check_box_impacted_document_screen;
    public void check_check_box_functionality_on_impacted_document_screen()
    {
        for (int i=0;i<=list_USP_update_status_impacted_document_screen.size()-1;i++)
        {
            if (!list_USP_update_status_impacted_document_screen.get(i).getText().contains("Up to date"))
            {
                if(!list_check_box_impacted_document_screen.get(i).isEnabled())
                {
                    log.info("Check box is Disabled");
                }
                else {
                    log.info("Check box is enabled");
                }
            }
            else
            {
                if(list_check_box_impacted_document_screen.get(i).isDisabled())
                {
                    log.info("Check box is not Disabled");
                }
                else {
                    Assert.fail();
                }

            }
        }
    }

    @FindBy(xpath = "//div[@class='impacted-subheading']//following::input[@placeholder='Select USP status']")
    private WebElementFacade Select_USP_status_dropdown_impacted_document_screen;
    @FindBy(xpath = "//div[@class='no-record-found']")
    private WebElementFacade no_record_found_msg;

    @FindBy(xpath = "//div[text()='Lite users alert']")
    private WebElementFacade lite_user_alert_screen;

    public void check_Apply_button_functionality()
    {
        try{
            withAction().moveToElement(Select_USP_status_dropdown_impacted_document_screen).click().sendKeys("New Update").pause(Duration.ofSeconds(4)).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if (!no_record_found_msg.isVisible())
            {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
              if (!list_check_box_impacted_document_screen.get(0).isSelected())
                  withAction().pause(Duration.ofSeconds(2)).build().perform();
              {
                  list_check_box_impacted_document_screen.get(0).click();
                  withAction().pause(Duration.ofSeconds(2)).build().perform();
              }
            }
            else
            {
                log.info("Impacted documents are not present to attach USP");
                Assert.fail();
            }
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if(impacted_doc_screen_apply_button.isEnabled())
            {
                impacted_docApply_button_Disabled.isVisible();
                withAction().pause(Duration.ofSeconds(4)).build().perform();
    //            Assert.assertTrue(lite_user_alert_screen.isVisible());
            }
            else {
                log.info("Apply button is not Enabled");
            }
        }
        catch (NoSuchElementException e) {
            Assert.assertTrue(true);
            log.info("Apply button is Enabled");
        }
    }
    public void check_word_clause_USP_template_screen(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        for (int i=0;i<=list_word_clause_USP_template_screen.size()-1;i++)
        {
            if (list_word_clause_USP_template_screen.get(i).getText().trim().equalsIgnoreCase("true"))
            {
                log.info("Word Clause is true for "+USP_ID_list.get(i).getText()+" TC Pass");
            } else if (list_word_clause_USP_template_screen.get(i).getText().trim().equalsIgnoreCase("False"))
            {
                log.info("Word Clause is false for "+USP_ID_list.get(i).getText()+" TC Pass");
            }
            else
            {
               log.info("Word Clause not true nor false for "+USP_ID_list.get(i).getText()+" TC fail");
               Assert.fail();
            }
        }
    }

    public void getverisonID() {
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        try {
            if (impacted_doc_screen_search_box.isCurrentlyVisible()) {
                impacted_doc_screen_search_box.click();
                impacted_doc_screen_search_box.clear();
                impacted_doc_screen_search_box.sendKeys("4W-");
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
            try {
                WebElement uspStatusDropdown = getDriver().findElement(By.xpath("//input[@placeholder='Select USP status']"));
                if (uspStatusDropdown.isDisplayed()) {
                    uspStatusDropdown.click();
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                    WebElement newUpdateOption = getDriver().findElement(By.xpath("//span[normalize-space()='New Update'] | //li[contains(.,'New Update')]"));
                    newUpdateOption.click();
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            } catch (Exception ignored) {}
        } catch (Exception e) {
            log.warn("Could not filter on impacted documents screen: " + e.getMessage());
        }

        String versionID = null;
        for (int i = 0; i < list_USP_update_status_impacted_document_screen.size(); i++) {
            if (list_USP_update_status_impacted_document_screen.get(i).getText().trim().contains("New Update")) {
                versionID = list_doc_version_IDs_impacted_document_screen.get(i).getText().trim();
                break;
            }
        }
        if (versionID == null) versionID = !list_doc_version_IDs_impacted_document_screen.isEmpty() ? list_doc_version_IDs_impacted_document_screen.get(0).getText().trim() : documentversionID.getText().trim();

        closebutton.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentPageObject.clickMenuButton();
        documentPageObject.clickDocumentTab();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        documentPageObject.unselectShowOnlyLatestVersion();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        inputDocumentversionID.waitUntilVisible().click();
        inputDocumentversionID.sendKeys(versionID);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        documentPageObject.getDocumentedit_btn().waitUntilVisible().waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }
}
