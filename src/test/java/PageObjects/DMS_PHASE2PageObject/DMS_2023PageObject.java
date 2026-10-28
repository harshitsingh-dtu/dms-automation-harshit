package PageObjects.DMS_PHASE2PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data

public class DMS_2023PageObject extends PageObject {

    @FindBy(xpath = "//div[text()='Auth Products']")
    private WebElementFacade authProducts;

    @FindBy(xpath = "//button[text()='General Terms']")
    private WebElementFacade generalTerms_tab;

    @FindBy(xpath = "//input[@placeholder='Enter address (max. 100 characters)']")
    private WebElementFacade enterAddress_PB;

    @FindBy(xpath = "//input[@placeholder='Enter contact (max. 100 characters)']")
    private WebElementFacade enterContact_PB;

    @FindBy(xpath = "//input[@placeholder='Type & Select Acting Office']")
    private WebElementFacade selectActingOffice_PB;

    @FindBy(xpath = "//input[@placeholder='Select Relationship']")
    private WebElementFacade selectRelationship_PB;

    @FindBy(xpath = "//input[@placeholder='Type & Select Specified office(s)']")
    private WebElementFacade selectSpecifiedOffice_PB;

    @FindBy(xpath = "//textarea[@placeholder='Enter notes (max. 1000 characters)']")
    private WebElementFacade enterNotes;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElementFacade nextButton;

    @FindBy(xpath = "(//div[@class='link'])[1]")
    private WebElementFacade versionID_input;

    @FindBy (xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade search_versionID;

    @FindBy(xpath = "//img[@alt='Edit']")
    private WebElementFacade editIcon;

    @FindBy(xpath = "//button[text()='Save as Draft']")
    private WebElementFacade SaveAsDraft_btn;

    @FindBy(xpath = "//div//label[text()='Action type']//following::input")
    private WebElementFacade select_ActionType;

    @FindBy(xpath = "//button[text()='Preview & Submit']")
    private WebElementFacade previewAndSubmit_tab;

    @FindBy(xpath = "//button[text()='General terms']")
    private WebElementFacade generalTermsTab_previewSubmit;

    @FindBy(xpath = "//tr/th[text()='Document Action']//input")
    private WebElementFacade filter_documentAction;

    @FindBy(xpath = "//div[@class='alert-msg']")
    private WebElementFacade alertMessage;

    @FindBy(xpath = "//button[text()='No']")
    private WebElementFacade No_btn;

    @FindBy(xpath = "//button[text()='Enforcement rule']")
    private WebElementFacade enforcementRulesTab_documentScreen;

    @FindBy(xpath = "//div[text()='For new document']")
    private WebElementFacade redirected_enforcementRulesTab;

    public void validateFilledDetails_GeneralTerms(){
        try{
            String AddressValue = enterAddress_PB.getValue();
            String ContactValue = enterContact_PB.getValue();
            String ActingOfficeValue = selectActingOffice_PB.getValue();
            String RelationshipValue = selectRelationship_PB.getValue();
            String SpecifiedOfficeValue = selectSpecifiedOffice_PB.getValue();
            String NotesValue = enterNotes.getValue();
            nextButton.click();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            generalTerms_tab.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String AddressValue1 = enterAddress_PB.getValue();
            String ContactValue1 = enterContact_PB.getValue();
            String ActingOfficeValue1 = selectActingOffice_PB.getValue();
            String RelationshipValue1 = selectRelationship_PB.getValue();
            String SpecifiedOfficeValue1 = selectSpecifiedOffice_PB.getValue();
            String NotesValue1 = enterNotes.getValue();
            Assert.assertTrue(AddressValue.equalsIgnoreCase(AddressValue1));
            Assert.assertTrue(ContactValue.equalsIgnoreCase(ContactValue1));
            Assert.assertTrue(ActingOfficeValue.equalsIgnoreCase(ActingOfficeValue1));
            Assert.assertTrue(RelationshipValue.equalsIgnoreCase(RelationshipValue1));
            Assert.assertTrue(SpecifiedOfficeValue.equalsIgnoreCase(SpecifiedOfficeValue1));
            Assert.assertTrue(NotesValue.equalsIgnoreCase(NotesValue1));
        }
        catch (Exception e){
            log.error("Unable to validate general terms tab details" +e);
            Assert.fail();
        }
    }
    public void enterVersionId(){
        try{
            String Version_ID= versionID_input.getText();
            withAction().moveToElement(search_versionID).click().sendKeys(Version_ID).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to search version ID" +e);
            Assert.fail();
        }
    }
    public void makeChanges_GeneralTerms(){
        try{
            generalTerms_tab.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            selectSpecifiedOffice_PB.waitUntilVisible();
            withAction().moveToElement(selectSpecifiedOffice_PB).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(enterNotes).click().sendKeys("Hi...Automation Tester").pause(Duration.ofSeconds(3)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to make changes in general terms tab" +e);
            Assert.fail();
        }
    }
    public void selectActionType(){
        try{
            select_ActionType.waitUntilClickable();
            withAction().moveToElement(select_ActionType).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().moveToElement(select_ActionType).click().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).pause(Duration.ofSeconds(1)).build().perform();
        }
        catch (Exception e){
            log.error("Unable to select Action Type" +e);
            Assert.fail();
        }
    }
    public void detailsGeneralTerms_inPreviewAndSubmitTab(){
        try{
            List<WebElementFacade> infoList = findAll("//div[@class='gt-preview-info']");
            int column_size= infoList.size();
            log.info("column size on screen is :" +column_size);

            for(WebElementFacade Info_Text : infoList){

                Assert.assertTrue(Info_Text.isVisible());
                log.info(Info_Text.getText());

            }
        }
        catch (Exception e){
            log.error("Unable to see details of general terms in preview and submit tab" +e);
            Assert.fail();
        }
    }
    public void selectActionType_editDocuments(List<String> actionType){
        try {
            for (int begin = 1; begin < actionType.size(); begin++) {
                select_ActionType.waitUntilClickable();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(select_ActionType).click().sendKeys(actionType.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to select action type" +e);
            Assert.fail();
        }
    }
    public void select_documentAction(List<String> documentAction){
        try {
            for (int begin = 1; begin < documentAction.size(); begin++) {
                filter_documentAction.waitUntilClickable();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().moveToElement(filter_documentAction).click().sendKeys(documentAction.get(begin)).pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }
        }
        catch (Exception e){
            log.error("Unable to select document action" +e);
            Assert.fail();
        }
    }
}
