package PageObjects.Documents;

import PageObjects.ApprovalAgreement.ApprovalAgreementCreatePageObject;
import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Data
public class DocumentCreateNewPageObject extends PageObject {
    Actions act = new Actions(getDriver());
    @FindBy(xpath = "//*[text()='+Create new document' or text()='+ Create new document']")
    private WebElementFacade createNewDocument;
    @FindBy(xpath = "(//button[@aria-label='Edit'])[1]")
    private WebElementFacade editDocument;
    @FindBy(xpath = "//tbody/tr[1]//button[contains(text(), '4W-') or contains(text(), 'DF-') or contains(text(), 'DN-')] | //tbody/tr[1]//button[@aria-label='Preview' or contains(@class,'preview') or contains(@class,'version')] | //tbody/tr[1]/td[2]//button | //tbody/tr/td[2]//button")
    private WebElementFacade documentLink;
    @FindBy(xpath = "//*[@placeholder='Select Doc type']")
    private WebElementFacade selectDocType;
    @FindBy(xpath = "//*[@placeholder = 'Select Doc type']")
    private WebElementFacade selectDocumentType;
    @FindBy(xpath = "//ul/li/p[text() = 'DN']")
    private WebElementFacade selectDNDocumentType;
    @FindBy(xpath = "//*[@placeholder = 'Select Orgtype']")
    private WebElementFacade selectActingAs;//div[text()='Select']
    @FindBy(xpath = "//div[@role='presentation']")
    private WebElementFacade DropDownValues;

    @FindBy(xpath = "//div[text()='Select']")
    private WebElementFacade selectActingAsDFDN;

    @FindBy(xpath = "//div[contains(@class,'select-acting-as')]//input")
    private WebElementFacade actingAsInput_DFDN;

    @FindBy(xpath = "//*[text()='Select Prime Broker - 1']")
    private WebElementFacade selectPB1;
    @FindBy(xpath = "//*[text()='Select Client - 1']")
    private WebElementFacade selectClient1;
    @FindBy(xpath = "//*[text()='Select Prime Broker - 2']")
    private WebElementFacade selectPB2;
    @FindBy(xpath = "//*[text()='Select Client - 2']")
    private WebElementFacade selectClient2;
    @FindBy(xpath = "//*[text()='Select Executing Broker - 1']")
    private WebElementFacade selectEB;
    @FindBy(xpath = "//button[contains(., 'Next')]")
    private WebElementFacade next_btn;//button[text()='Next']
    @FindBy(xpath = "//button[text()='Approval Workflow']")
    private WebElementFacade approvalWorkflow_btn;
    @FindBy(xpath = "//button[text()=\"Save as Draft\"]")
    private WebElementFacade saveAsDraft_btn;
    @FindBy(xpath = "//div[@class=\"drag-box  \"][text()='Initiator']")
    private WebElementFacade Initiator;
    @FindBy(xpath = "//div[@class=\"drag-box  \"][text()='Prime Broker - 1']")
    private WebElementFacade PB1_participant;
    @FindBy(xpath = "(//*[text()='Client - 1'])[2]")
    private WebElementFacade Client1_participant;
    @FindBy(xpath = "(//*[text()='Prime Broker - 2'])[2]")
    private WebElementFacade PB2_participant;
    @FindBy(xpath = "(//*[text()='Client - 2'])[2]")
    private WebElementFacade Client2_participant;
    @FindBy(xpath = "(//div//*[text()='Drag and Drop here the participant'])[1]")
    private WebElementFacade approvalSeq1;
    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/div[1]")
    private WebElementFacade approvalSeq2;
    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/div[1]")
    private WebElementFacade approvalSeq3;
    @FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]")
    private WebElementFacade approvalSeq4;
    //    button[text()='Enforcement Rules for DN']
    @FindBy(xpath = "//button[text()='Enforcement Rules']")
    private WebElementFacade approvalEnforcement_btn;
    @FindBy(xpath = "//button[text()='Enforcement Rules']")
    private WebElementFacade Enforcement_btn;
    @FindBy(xpath = "//button[text()='Enforcement Rules']")
    private WebElementFacade Enforcement_forEDN;
    @FindBy(xpath = "//*[contains(@id, 'Immediate1')]")
    private WebElementFacade enforcenew;
    @FindBy(xpath = "//*[contains(@id, 'Immediate2')]")
    private WebElementFacade enforceammendment;
    @FindBy(xpath = "//*[contains(@id, 'Immediate3')]")
    private WebElementFacade enforcetermination;
    @FindBy(xpath = "//*[contains(@id, 'Scheduled1')]")
    private WebElementFacade Enforced_schedule1;
    @FindBy(xpath = "//*[contains(@id, 'Scheduled2')]")
    private WebElementFacade Enforced_schedule2;
    @FindBy(xpath = "//p[@class='ck-placeholder']")
    private WebElementFacade textboxDocumentTerms;
    @FindBy(xpath = "//button[text()='Document terms']")
    private WebElementFacade DocumentTermsDocTemplate;
    @FindBy(xpath = "(//button[text()='Auth Scope'])[1]")
    private WebElementFacade AuthScope_tab;
    @FindBy(xpath = "//div[contains(@class, 'preview')]//button[text()='Auth Scope'] | (//button[text()='Auth Scope'])[2]")
    private WebElementFacade AuthScope_InPreview;
    @FindBy(xpath = "//input[@placeholder='Select Product Group']")
    private WebElementFacade AuthProducts_group;
    @FindBy(xpath = "//button[text()='+ Add currencies']")
    private WebElementFacade authCurrencies;
    @FindBy(xpath = "//div[@class = 'enable-switch-container cursor-pointer']")
//div[@class='enable-switch disabled']//label[.//span[normalize-space()='Disabled']]//input[@type='checkbox']
    private WebElementFacade enableAuthTenor;//div[@class='enable-switch ']//span[1]//div[@class = 'enable-switch-container cursor-pointer']
    @FindBy(xpath = "//div[contains(@class, 'enable-switch ')]")
//div[@class='enable-switch disabled']//label[.//span[normalize-space()='Disabled']]//input[@type='checkbox']
    private WebElementFacade enableAuthTenorDF;//span[text()='Enable Tenor']
    @FindBy(xpath = "//div[@class='enable-switch disabled']")
    private WebElementFacade enableAuthTenorDFclick;
    @FindBy(xpath = "//button[text()='Currencies-pair']")
    private WebElementFacade CurrenciesPair;
    @FindBy(xpath = "//*[@placeholder='Currencies Group']")
    private WebElementFacade currenciesGroup;
    @FindBy(xpath = "//input[@class='accordion-input' and @type = 'text']")
    private WebElementFacade authTenorValue;
    @FindBy(xpath = "//input[@class='tenor-input' and @type = 'text']")
    private WebElementFacade authTenorValue4W;
    @FindBy(xpath = "//input[@class='tenor-input error' and @type = 'text']")
    private WebElementFacade authTenorValue4Werror;
    @FindBy(xpath = "//input[@class='accordion-input']")
    private WebElementFacade EditTenorValue;
    @FindBy(xpath = "//input[@class='accordion-input']")
    private WebElementFacade EditTenorValueonDF;
    @FindBy(xpath = "//input[@placeholder='Select' and @type='text']")
    private WebElementFacade authSelectTenor;
    @FindBy(xpath = "//input[@placeholder='Select Tenor' and @type='text']")
    private WebElementFacade authSelectTenor4W;
    @FindBy(xpath = "//button[text()=\"Add Auth Line\"]")
    private WebElementFacade addAuthLine;
    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='ArrowForwardIosSharpIcon']")
    private WebElementFacade ExpandAuthLine;
    @FindBy(xpath = "//div[contains(text(),'No attributes available')]")
    private WebElementFacade FXCashFuture;
    @FindBy(xpath = "(//button[text()='Limit Scope'])[1]")
    private WebElementFacade LimitScope_tab;
    @FindBy(xpath = "(//button[text()='Limit Scope'])[2]")
    private WebElementFacade Limitscope_tabInPreview;
    @FindBy(xpath = "//label[@for=\"calc-type-select\"]/following-sibling::div")
    private WebElementFacade calculationType_adFilter;
    @FindBy(xpath = "//div[text()='Calculation Type']//following-sibling::div//child::input")
    private WebElementFacade calculationType_tab;
    @FindBy(xpath = "//*[@placeholder='$ Limit value']")
    private WebElementFacade limitValue_tab;
    @FindBy(xpath = "//*[@placeholder='Limit value']")
    private WebElementFacade limitValue_tab_copy;
    @FindBy(xpath = "//tbody//td[2]/input")
    private WebElementFacade edit_limitValue_LimitAction;
    @FindBy(xpath = "//img[@alt='delete-line']")
    private List<WebElementFacade> Delete_AuthLine;
    @FindBy(xpath = "(//button[text()='USP Rider'])[1]")
    private WebElementFacade USPRider_tab;

    @FindBy(xpath = "//td[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'include metals']")
    private WebElementFacade BullionTrade_includeMetals;
    @FindBy(xpath = "//td[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'exclude metals']")
    private WebElementFacade BullionTrade_excludeMetals;
    @FindBy(xpath = "//td[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'only metals']")
    private WebElementFacade BullionTrade_OnlyMetals;

    @FindBy(xpath = "//div[@class='action-div']/img")
    private WebElementFacade Save_Icon;
    @FindBy(xpath = "//button[contains(@data-testid, 'limit-line-action-toggle-btn')]")
    private WebElementFacade Save_IconDF;
    @FindBy(xpath = "//div[text()='Netting Type']//following-sibling::div//child::input")
    private WebElementFacade nettingType_tab;
    @FindBy(xpath = "//input[contains(@value, 'Metals')]")
    private WebElementFacade BullionTradeCopied;
    @FindBy(xpath = "//div[text()='Delta']//following-sibling::div//child::input")
    private WebElementFacade delta_tab;
    @FindBy(xpath = "//div[text()='Product family']//following-sibling::div//child::input")
    private WebElementFacade productFamily_tab;
    @FindBy(xpath = "//div[text()='Product family']/following-sibling::div[@data-testid='multiselect-autocomplete-component']//input")
    private WebElementFacade productFamilyMultiSelectInput_4Way;
    @FindBy(xpath = "//div[text()='Product family']/following-sibling::div[@data-testid='multiselect-autocomplete-component']//button[contains(@class,'MuiAutocomplete-popupIndicator')]")
    private WebElementFacade productFamilyPopupToggle_4Way;
    @FindBy(xpath = "(//input[@placeholder='Select Product Family'])[2]")
    private WebElementFacade SelectFamily_tab_inLimitLine;
    @FindBy(xpath = "(//button[@aria-label='Clear'])[5]")
    private WebElementFacade RemoveAllProductFamilyValues;
    @FindBy(xpath = "(//tr/td[6]//div//div//div)[1]")
    private WebElementFacade EditProductFamilyValues;
    @FindBy(xpath = "(//tr/td[5]//div//div//div)[1]")
    private WebElementFacade EditProductFamilyValues_DF;
    @FindBy(xpath = "//*[@placeholder='Select Product Family']")
    private WebElementFacade SelectProductFamily;
    @FindBy(xpath = "//div[text()='Exclude CLS from calculation']//following-sibling::div//child::input")
    private WebElementFacade excludeCLS_tab;
    @FindBy(xpath = "//button[text()=\"Add Limit\"]")
    private WebElementFacade addLimit_btn;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElementFacade closeDropDown;

    @FindBy(xpath = "//button[text()=\"Preview & Submit\"]")
    private WebElementFacade previewAndSubmit_tab;
    @FindBy(xpath = "//button[text()='Reset current changes']")
    private WebElementFacade ResetCurrentChanges_btn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submit_btn;
    @FindBy(xpath = "//button[@aria-label='Terminate']")
    private WebElementFacade terminate_btn;
    @FindBy(xpath = "//span[text()='AED']")
    private WebElementFacade add_AED;
    @FindBy(xpath = "//span[text()='XAG']")
    private WebElementFacade add_XAG;
    @FindBy(xpath = "//span[text()='EUR-XAU']")
    private WebElementFacade add_EUR_XAU;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElementFacade popup_Yes_btn;
    @FindBy(xpath = "(//img[@alt='Copy'])[1]")
    private WebElementFacade copy_icon;//button[@aria-label='Copy'])[1]
    @FindBy(xpath = "//*[text()='Discard']")
    private WebElementFacade discard_btn;
    @FindBy(xpath = "//*[text()='New Document']//parent::tr//td[2]/div//div")
    private WebElementFacade PB_value;
    @FindBy(xpath = "//tr[@class='MuiTableRow-root css-1gqug66']")
    private WebElementFacade AuthScoperow;
    @FindBy(xpath = "//tr[@class='MuiTableRow-root css-1gqug66']/td[1]")
    private WebElementFacade Auth_cal_type;
    @FindBy(xpath = "//tr[@class='MuiTableRow-root css-1gqug66']/td[2]/span")
    private WebElementFacade Auth_Limit_Val;
    @FindBy(xpath = "(//div[@class='add-email'])[1]")
    private WebElementFacade lite_email_text;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElementFacade cancel_btn;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    private WebElementFacade cancel_btn_popup;
    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr//td[3]//span")
    private WebElementFacade status;
    @FindBy(xpath = "//div[@class='title']")
    private WebElementFacade AuthLines01;//div[@class='title'][1]/span
    @FindBy(xpath = "//div[@class='title'][2]/span")
    private WebElementFacade AuthLines02;
    @FindBy(xpath = "//button[text()=\"Document Terms\" or text()=\"Document terms\"]")
    private WebElementFacade DocumentTerms;
    @FindBy(xpath = "(//button[text()='General Terms'])[1]")
    private WebElementFacade GeneralTerms;
    @FindBy(xpath = "(//button[text()='General Terms'])[2]")
    private WebElementFacade GeneralTermsOnPreview;
    @FindBy(xpath = "(//button[text()=\"Document Terms\"])[2]")
    private WebElementFacade DocumentTermstab;
    @FindBy(xpath = "//button[text()='USP Rider']")
    private WebElementFacade UspRiderTab;
    @FindBy(xpath = "(//*[text()=\"Document Terms\"])")
    private List<WebElementFacade> DocTermsList;
    @FindBy(xpath = "//div/li[text()='Document Terms']")
    private List<WebElementFacade> DocumentTermsViewasPDF;
    @FindBy(xpath = "//div[@class='doc-create-content']")
    private WebElementFacade newDocumentScreen;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[3]")
    private WebElementFacade select_temp_dropdown;
    @FindBy(xpath = "//div[@class='auth-product-name'][1]")
    private WebElementFacade VolatilitySwap_inPreview;
    @FindBy(xpath = "//div[@class='auth-product-name'][1]")
    private WebElementFacade BullionExotic_inPreview;
    @FindBy(xpath = "//div[@class='auth-product-name'][1]")
    private WebElementFacade BullionVanilla_inPreview;
    @FindBy(xpath = "//div[@class='undefined auth-product-name'][1]")
    private WebElementFacade BullionVanilla_inPreviewDF;
    @FindBy(xpath = "//span[text()='True']")
    private List<WebElementFacade> DocumentsWithValueAsTrue;
    @FindBy(xpath = "//span[text()='False']")
    private List<WebElementFacade> DocumentsWithValueAsFalse;
    @FindBy(xpath = "//button[@class='version-link']")
    private WebElementFacade bulkApproveVersionId;
    @FindBy(xpath = "(//table[@class='csm_standard_table undefined'])/tbody/tr/td[contains(text(), '$')]")
    private List<WebElementFacade> limitValue;
    @FindBy(xpath = "//img[@data-testid=\"edit-icon\"]")
    private WebElementFacade editIconForPG;

    //Tenor
    @FindBy(xpath = "//input[@disabled and @value='Spot-only']")
    private WebElementFacade SpotOnlyDisabledTenor;
    @FindBy(xpath = "//div[contains(@data-testid, 'auth-accordion-tenor-type-select')][not(contains(@class, 'Mui-disabled')) and not(.//input[@disabled])]//button[@title='Open' or @aria-label='Open' or contains(@class, 'popupIndicator')] | //input[not(@disabled) and (@value='Business Days' or @value='Calendar Days')] | //div[contains(@data-testid,'auth-accordion-tenor-type-select')][not(contains(@class, 'Mui-disabled')) and not(.//input[@disabled])] | //input[@class='spot-value']")
    private WebElementFacade SpotValueDropDown;
    @FindBy(xpath = "//input[contains(@data-testid,'auth-accordion-tenor-value-input') and not(@disabled)] | //input[@class='accordion-input' and not(@disabled)] | //div[@class='tenor-input']/span/input")
    private WebElementFacade TenorValueInput;
    @FindBy(xpath = "//div[contains(@data-testid, 'auth-accordion-tenor-type-select')][not(contains(@class, 'Mui-disabled')) and not(.//input[@disabled])]//input | //input[not(@disabled) and (@value='Business Days' or @value='Calendar Days')] | //div[@class='spot-value']//input[not(@disabled)]")
    private WebElementFacade TenorDays;

    //General Terms
    @FindBy(xpath = "//label[text()=' Physically Settled Bullion']")
    private WebElementFacade PhysicallySettledBullion;
    @FindBy(xpath = "//input[@name='checkbox']")
    private WebElementFacade PhysicallySettledBullion_checkbox;
    @FindBy(xpath = "//div[text()='Physically Settled Bullion']/following-sibling::div[text()='True']")
    private WebElementFacade PhysicallySettledBullion_True;
    @FindBy(xpath = "//div[text()='Current Issue Date']//..//img")
    private WebElementFacade CurrentDate_picker;
    @FindBy(xpath = "(//div[@class='date-range-input-container'])[5]/input")
    private WebElementFacade CurrentDate_picker_InputField;
    @FindBy(xpath = "(//div[@class='date-range-input-container'])[1]/input")
    private WebElementFacade DF_ISDA_Date_Picker;
    @FindBy(xpath = "//div[@class='react-datepicker']//*[text()='24']")
    private WebElementFacade Date_value;
    @FindBy(xpath = "//div[@class='react-datepicker']//*[text()='26']")
    private WebElementFacade UpdateDate_value;
    @FindBy(xpath = "//div[text()='Reference Date']//..//img")
    private WebElementFacade ReferenceDate_picker;
    @FindBy(xpath = "//div[text()='First Issue Date']//..//img")
    private WebElementFacade FirstIssue_picker;
    @FindBy(xpath = "//div[text()='Current Return Time']//..//img")
    private WebElementFacade CurrentReturnTime_picker;
    @FindBy(xpath = "//div[text()='Current Enforcement Time']//..//img")
    private WebElementFacade CurrentEnforcementTime_picker;
    @FindBy(xpath = "//div[normalize-space(.)='Prime Broker']/../..//div[text()='Notes']")
//div[text()='Prime Broker']//..//..//div[text()='Notes']
    private WebElementFacade PB_Notes;
    @FindBy(xpath = "//div[normalize-space(.)='Prime Broker']/../..//div[text()='Notes']/following-sibling::textarea[@placeholder = 'Enter notes (max. 1000 characters)']")
    private WebElementFacade PB_Notes_textarea;
    @FindBy(xpath = "//div[@data-testid='gt-info-value-notes']")
    private WebElementFacade PB_Notes_Preview;
    @FindBy(xpath = "//div[normalize-space(.)='Client']/../..//div[text()='Notes']")
    private WebElementFacade Client_Notes;
    @FindBy(xpath = "//div[normalize-space(.)='Client']/../..//div[text()='Specified Office']")
    private WebElementFacade Client_Office;
    @FindBy(xpath = "//div[@class='common-notes']")
    private WebElementFacade Common_Notes;
    @FindBy(xpath = "//div[@class='common-notes']//textarea")
    private WebElementFacade Common_Notes_Textarea;
    @FindBy(xpath = "//div[@data-testid='gt-notes-section-standard']//div[@data-testid='gt-info-value-info']")
    private WebElementFacade Common_Notes_data;
    @FindBy(xpath = "(//div[text()='Address'])[1]/following-sibling::input")
    private WebElementFacade Address_field_PB;
    @FindBy(xpath = "(//div[text()='Contact'])[1]/following-sibling::textarea")
    private WebElementFacade Contact_field_PB;
    @FindBy(xpath = "//div[normalize-space(.)='Prime Broker']/../..//div[text()='Contact']/following-sibling::textarea[@placeholder = 'Enter contact (max. 4000 characters)']")
    private WebElementFacade Empty_Contact_field_PB;//div[normalize-space(.)='Prime Broker']/../..//div[text()='Notes']
    @FindBy(xpath = "(//div[text()='Relationship'])[1]/..//input")
    private WebElementFacade Relationship_PB;
    @FindBy(xpath = "(//div[text()='Relationship'])[1]/..//div[@role='presentation']")
    private WebElementFacade Relationship_PBValues;

    @FindBy(xpath = "//button[text()='View as PDF']")
    private WebElementFacade viewAsPDF_btn;
    @FindBy(xpath = "//img[@title='Delete']")
    private List<WebElementFacade> AuthScope_Delete_Icon;
    @FindBy(xpath = "//img[@alt='delete-line']")
    private WebElementFacade LimitLine_Delete_Icon;
    @FindBy(xpath = "//input[@placeholder='Select Template']")
    private WebElementFacade select_temp_input_box;
    @FindBy(xpath = "//div[contains(normalize-space(.), 'Document is terminated')]")
    private WebElementFacade Doc_terminated_Notification;
    @FindBy(xpath = " //div[text()='Template Preview']")
    private WebElementFacade temp_preview;

    @FindBy(xpath = " //p[text()='Approval Workflow']")
    private WebElementFacade approval_workflow;
    @FindBy(xpath = "//*[text()='Prime Broker - 1']")
    private WebElementFacade approval_workflow_template_data;
    @FindBy(xpath = " //p[text()='Enforcement Rules']")
    private WebElementFacade enforcement_rule;
    @FindBy(xpath = "//*[text()='Immediate']")
    private List<WebElementFacade> enforcement_rule_template_data;
    @FindBy(xpath = " //p[text()='Document Terms']")
    private WebElementFacade document_term;
    @FindBy(xpath = "//*[text()='testing']")
    private WebElementFacade document_term_templateData;
    @FindBy(xpath = "//div[@class='header-name']")
    private WebElementFacade edit_document;

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
    @FindBy(xpath = "//input[@placeholder='Select Product Family']")
    private WebElementFacade selectproductfamily_filter;
    @FindBy(xpath = "//button[@class='add-cur-btn']")
    private WebElementFacade add_currency_btn;
    @FindBy(xpath = "//div[text()='Delta']/..//input[@placeholder='Select']")
    private WebElementFacade DeltaInLimitScope;
    @FindBy(xpath = "(//tbody//td[text()='Bullion'])[1]")
    private WebElementFacade BullionLimitLine_inPreview;
    @FindBy(xpath = "(//tbody//td[text()='Bullion'])[2]")
    private WebElementFacade BullionLimitLine_inPDF;

    @FindBy(xpath = "//div[@class='currency-card']//input")
    private WebElementFacade searchSelectCurrency;
    @FindBy(xpath = "//div[@class='card ']")
    private WebElementFacade searchedCurrency;
    @FindBy(xpath = "//div[text()='Define it from above section.']")
    private WebElementFacade No_Auth_lines;

    @FindBy(xpath = "//div[text()='No Data']")
    private WebElementFacade currency_nodata;
    @FindBy(xpath = "//img[@title='Copy' or @alt='copy-line' or @alt='Copy'] | //*[@data-testid='ContentCopyIcon']")
    private WebElementFacade Copy_AuthLine;
    @FindBy(xpath = "//img[@alt='copy-line']")
    private WebElementFacade Copy_AuthLineDF;
    @FindBy(xpath = "//button[text()='Reset current changes']")
    private WebElementFacade reset_Current_Changes;
    @FindBy(xpath = "//div[contains(@class,'filter')]//input[contains(@placeholder,'Search currencies')]")
    private WebElementFacade searchRemoveCurrency;
    @FindBy(xpath = "//div[contains(@class,'card card-select')]")
    private WebElementFacade searchedRemoveCurrency;
    @FindBy(xpath = "//div[@class='doc-create-content']//div[text()='Create new document']")
    private WebElementFacade createNewDocumentText;
    @FindBy(xpath = "//h2//span[text()='Lite users alert']")
    private WebElementFacade liteUserAlertPopup;
    @FindBy(xpath = "//input[@placeholder='Enter email 1']")
    private WebElementFacade enterEmail1_input;

    //    @FindBy(xpath = "//button[text()='Submit for approval']")
    @FindBy(xpath = "//button[text()='Submit For Approval']")
    private WebElementFacade submitforapproval_btn;
    @FindBy(xpath = "//button[text()='Submit for approval']")
    private WebElementFacade submitforScopeChangePreview;
    @FindBy(xpath = "//button[text()='Ignore']")
    private WebElementFacade ignoreButton;
    private String DropDown = "//p[text()='@placeholder@']";
    private String DropDownTwo = "//div[text()='Select']";
    @FindBy(xpath = "//*[@value='4 Way']")
    private WebElementFacade docTypeValue_4way;
    @FindBy(xpath = "//*[text()='FX']")
    private WebElementFacade allowedCurrencyFX;
    @FindBy(xpath = "//*[text()='Bullion']")
    private WebElementFacade allowedCurrencyBullion;
    @FindBy(xpath = "//button[@aria-label='Approve']")
    private WebElementFacade approveDocument;
    @FindBy(xpath = "//label[text()='Approval group']/..//input")
    private WebElementFacade approvalGroupDropDown;
    @FindBy(xpath = "//button[text()='Approve']")
    private WebElementFacade approveButton;
    @FindBy(xpath = "//table[@class='doc-table']//tr[1]//td[2]")
    private WebElementFacade docVersionID;
    @FindBy(xpath = "//div[@class='content-label']")
    private WebElementFacade createDocVersionID;
    @FindBy(xpath = "//div[@class='content-label']")
//table[@class='doc-table']//button[@class='link'][1]//div[@class='content-label']
    private WebElementFacade docVersionID_Edit;//table[@class='doc-table']//button[@class='link'][1]
    //    @FindBy(xpath = "//table[@class='doc-table']/tbody/tr/td[text()='DN']")
//    private WebElementFacade DN_doc_Listing_screen;
    @FindBy(xpath = "//table[@class='doc-table']/tbody/tr/td[1][starts-with(normalize-space(.),'DN-')]")
    private WebElementFacade DN_doc_Listing_screen;
    @FindBy(xpath = "//td[contains(., '4 Way')]")
    private WebElementFacade Way4_doc_Listing_screen;
    @FindBy(xpath = "//*[text()='Document type']//parent::div//div[2]//div[@class='info-label hsize']")
    private WebElementFacade docType_Edit;
    @FindBy(xpath = "//*[text()='Allowed currencies']//parent::div//div[2]//div[@class='info-label hsize']")
    private WebElementFacade AllowedCurrency;
    @FindBy(xpath = "(//div[@class='info-label unbold'])[1]//div")
    private WebElementFacade PB_EditScreen;
    @FindBy(xpath = "(//div[@class='info-label unbold'])[2]//div")
    private WebElementFacade EB_EditScreen;
    @FindBy(xpath = "(//div[@class='info-label unbold'])[3]//div")
    private WebElementFacade Client_EditScreen;
    @FindBy(xpath = "/div[contains(@class, 'rule-container')][1]//input[@type='number']/")
    private WebElementFacade valuefor_fornewdocument_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][2]//input[@type='number']")
    private WebElementFacade valuefor_foramendment_Schedule;
    @FindBy(xpath = "//div[contains(@class, 'rule-container')][1]//input[@placeholder='Duration']")
    private WebElementFacade Durationfor_fornewdocument_Schedule;
    @FindBy(xpath = "//tr/th[text()='Document Version ID']//input")
    private WebElementFacade search_versionID;
    @FindBy(xpath = "//div[text()='Bullion Trades']/..//input")
    private WebElementFacade BullionTrade_inputField;
    @FindBy(xpath = "//th[contains(.,'EB-1 LEI') and not(contains(.,'legal entity'))]")
    private WebElementFacade EB1_LEI_Column;
    @FindBy(xpath = "//th[@data-testid='doc-table-th-eb1Name' or contains(.,'EB-1 legal entity name')]")
    private WebElementFacade EB1_LegalEntityName_Column;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElementFacade toastMessage_alert;
    @FindBy(xpath = "//button[text()='Enforcement Rules for DN']")
    private WebElementFacade enforcementRuleTab_documentTemplateScreen;
    @FindBy(xpath = "(//button[text()='Enforcement Rules'])[2]")
    private WebElementFacade enforcementRuleTabOnPreview;
    @FindBy(xpath = "//div[text()='Immediate']")
    private WebElementFacade enforcementRuleValueOnPreview;
    @FindBy(xpath = "//div[text()='For new document']")
    private WebElementFacade redirected_enforcementRuleTab;
    @FindBy(xpath = "//div[text()='For amendment']")
    private WebElementFacade Amendment_Tab;
    @FindBy(xpath = "//div[text()='For termination']")
    private WebElementFacade Termination_Tab;
    @FindBy(xpath = "//div[text()='Document Created.']")
    private WebElementFacade DocCreatedSuccessfully;
    @FindBy(xpath = "//th[text()='Document Status']//input")
    private WebElementFacade DocumentStatus_Column_Input;
    @FindBy(xpath = "//th[descendant::*[normalize-space()='Lifecycle status']]//input")
    private WebElementFacade LifecycleStatus_Column_Input;
    @FindBy(xpath = "//div[text()='Enter a non-zero value']")
    private WebElementFacade Non_ZeroValidation;
    @FindBy(xpath = "(//img[@title='Edit'])[1]")
    private WebElementFacade Edit_In_Auth_Line;
    @FindBy(xpath = "//div[@class=\'drag-box onDrag  read-only\']")
    private WebElementFacade Read_Only_Tiles;
    @FindBy(xpath = "//div[@class=\"dragBox\"]//div[text()='Client - 1']")
    private WebElementFacade Client;
    @FindBy(xpath = "//div[@style=\"opacity: 0.5; pointer-events: none;\"]")
    private WebElementFacade Drag_DropValidation;
    @FindBy(xpath = "//*[contains(text(),'No options')]")
    private WebElementFacade NoOptions;
    @FindBy(xpath = "//th[descendant::*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'created') and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'local time')]]//input[1]")
    private WebElementFacade CreatedOnLocalTimeDatePicker;
    @FindBy(xpath = "//th[descendant::*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'created') and contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'utc time')]]//input[1]")
    private WebElementFacade CreatedOnUTCTimeDatePicker;
    @FindBy(xpath = "//div[text()='Confirm']")
    private WebElementFacade ConfirmDate;

    @FindBy(xpath = "//div[@class='enable-switch ']")
    private List<WebElementFacade> EnableLimitLine;
    @FindBy(xpath = "//span[contains(@class,'Mui-checked')]")
    private WebElementFacade LimitLineEnabled;
    @FindBy(xpath = "//div[contains(text(),'Document Framework is in approval. DN operations prohibited')]")
    private WebElementFacade DN_opr_prohibited_warning;
    @FindBy(xpath = "//button[@aria-label='Cancel']")
    private WebElementFacade cancelDocument;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='Yes']")
    private WebElementFacade YES_Btn_confirm_cancel_document;
    @FindBy(xpath = "//img[@class='edit-icon ']")
    private List<WebElementFacade> EditLimitLine;
    @FindBy(xpath = "//input[@class='limit-input ' or starts-with(@data-testid, 'limit-line-input-value-')]")
    private WebElementFacade InputLimitLineValue;
    @FindBy(xpath = "//img[@alt='save-line']")
    private WebElementFacade SaveLimitLineValue;
    @FindBy(xpath = "//button[text()='Commit']")
    private WebElementFacade CommitButton;
    @FindBy(xpath = "//div[@class ='auth-tenure undefined']//div[2]")
    private List<WebElementFacade> TenorValues;
    @FindBy(xpath = "//button[contains(text(),'Submit For Approval')]")
    private WebElementFacade SubmitForApprovalButton;;
    @FindBy(xpath = "//button[text()='Submit for approval']")
    private WebElementFacade SubmitForApprovalButtonForEditLimit;
    @FindBy(xpath = "//button[contains(text(),'Submit for approval')]")
    private WebElementFacade SubmitForApprovalButton_VersionCompareScreen;
    @FindBy(xpath = "//*[contains(text(),'Legal Name(s) Changed!')]")
    private WebElementFacade LegalNameChangeScreen;
    @FindBy(xpath = "//*[contains(text(),'Ignore')]")
    private WebElementFacade IgnoreButton_Screen;
    @FindBy(xpath = "//button[normalize-space()='Submit for approval']")
    private WebElementFacade SubmitForApprovalButtonForEdit;
    @FindBy(xpath = "//p[@class= 'dialog-message']")
    private WebElementFacade DraftVersionPop_Up;

    //LimitLine Fields
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-isEnabled']")
    private WebElementFacade LimitLineHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-calculationType']")
    private WebElementFacade CalculationTypeHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-limitValue']")
    private WebElementFacade LimitvalueHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-nettingType']")
    private WebElementFacade NettingTypeHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-bullionTrades']")
    private WebElementFacade BullionTradesHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-delta']")
    private WebElementFacade DeltaHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-productFamily']")
    private WebElementFacade ProductfamilyHeader;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-excludeCLS']")
    private WebElementFacade ExcludeCLSHeader;
    @FindBy(xpath = "//th[normalize-space()='Action']")
    private WebElementFacade ActionHeader;
    @FindBy(xpath = "//label[text()='Non Deliverable']/input")
    private WebElementFacade Non_deliverable;
    @FindBy(xpath = "//label[text()='Deliverable']/input")
    private WebElementFacade deliverable;

    //LimitLine Values
    @FindBy(xpath = "//th[text()='Include Limit Line']")
    private WebElementFacade CalculationTypeValue;
    @FindBy(xpath = "//*[text()='Limit Scope']")
    private WebElementFacade LimitScope;
    @FindBy(xpath = "//*[text()='Auth Scope']")
    private WebElementFacade AuthScope;

    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'show only latest version']")
    private WebElementFacade ShowLatestVersion;
    @FindBy(xpath = "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'show only latest version']//input")
    private WebElementFacade ShowLatestVersionCheckbox;
    @FindBy(xpath = "(//table[@class='doc-table']//tbody//td[1])[1]")
    private WebElementFacade firstDocID;
    @FindBy(xpath = "//*[normalize-space()='Document ID']/ancestor::th//input")
    private WebElementFacade DocumentIDsearchBox;
    @FindBy(xpath = "(//img[@alt='Compare'])[1]")
    private WebElementFacade CompareButton;
    @FindBy(xpath = "//table[@class='doc-table']//tbody//tr[1]/td[2]/button")
    private WebElementFacade Doc_on_listingScreen;

    //Dates
    //table[contains(@class, 'doc-table')]//thead//tr//th[text()='Last Updated On (Local Time)']
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//thead//tr//th[text()='Last Updated On (Local Time)']")
    private WebElementFacade Last_Updated_On_LocalMove;
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//tbody//tr/td[count(//table[contains(@class, 'doc-table')]//th[normalize-space(.)='Last Updated On (Local Time)']/preceding-sibling::th) + 8]")
//tbody/tr/td[4]
    private WebElementFacade Last_Updated_On_Local;//table[contains(@class, 'doc-table')]//tbody//tr/td[count(//table[contains(@class, 'doc-table')]//th[normalize-space(.)='Last Updated On (Local Time)']/preceding-sibling::th) + 8]
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//tbody//tr/td[count(//table[contains(@class, 'doc-table')]//th[normalize-space(.)='Last Updated On (Local Time)']/preceding-sibling::th) + 9]")
    private WebElementFacade Last_Updated_On_UTC;
    @FindBy(xpath = "//tbody/tr/td[16]")
    private WebElementFacade Created_On_Local;
    @FindBy(xpath = "//tbody/tr/td[17]")
    private WebElementFacade Created_On_UTC;
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//tbody//tr/td[count(//table[contains(@class, 'doc-table')]//th[normalize-space(.)='Last Updated On (Local Time)']/preceding-sibling::th) + 24]")
    private WebElementFacade FirstIssueDate;
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//tbody//tr/td[count(//table[contains(@class, 'doc-table')]//th[normalize-space(.)='Last Updated On (Local Time)']/preceding-sibling::th) + 25]")
    private WebElementFacade CurrentIssueDate;
    @FindBy(xpath = "//table[contains(@class, 'doc-table')]//tbody//tr/td[count(//table[contains(@class, 'doc-table')]//th[normalize-space(.)='Last Updated On (Local Time)']/preceding-sibling::th) + 26]")
    private WebElementFacade CurrentReturnTime_On_Local;
    @FindBy(xpath = "//tbody/tr/td[13]")
    private WebElementFacade CurrentReturnTime_On_UTC;
    @FindBy(xpath = "(//div[normalize-space(.)='No Auth scope defined. Define it from above section.'])[3]")
    private WebElementFacade NoAuthlines;
    @FindBy(xpath = "//*[text()='Immediate']")
    private WebElementFacade RuleButton;
    @FindBy(xpath = "//p[@data-placeholder]")
    private WebElementFacade DocumentTermTextBox;
    @FindBy(xpath = "//*[@class=\"react-datepicker__current-month\"]")
    private WebElementFacade DisplayMonthYear;
    @FindBy(xpath = "//*[@aria-label=\"Previous Month\"]")
    private WebElementFacade PreviousMonth;
    @FindBy(xpath = "//*[@aria-label=\"Next Month\"]")
    private WebElementFacade NextMonth;
    @FindBy(xpath = "//*[@class='close-icon']")
    private WebElementFacade Compare_Close_Button;
    @FindBy(xpath = "//*[text()='Exclude NDF Cleared Trades']")
    private WebElementFacade NDF_Checkbox_Visible;
    @FindBy(xpath = "//label[contains(@class, 'disabled-ndf-check')]")
    private WebElementFacade NDF_Checkbox_Disabled;
    @FindBy(xpath = "//label[contains(@class, 'checkbox-label')]")
    private WebElementFacade NDF_Checkbox_Enabled;//div[text()='True']
    @FindBy(xpath = "//div[text()='True']")
    private WebElementFacade NDF_Checkbox_Enabled_Value;
    @FindBy(xpath = "//div[text()='False']")
    private WebElementFacade NDF_Checkbox_Disabled_Value;
    @FindBy(xpath = "//*[contains(@class,'exclude-ndf-clearing-flag')]//div[text()='True']")
    private WebElementFacade NDF_Checkbox_True_Preview;
    @FindBy(xpath = "//*[contains(@class,'exclude-ndf-clearing-flag')]//div[text()='False']")
    private WebElementFacade NDF_Checkbox_False_Preview;
    @FindBy(xpath = "(//*[contains(@class,'exclude-ndf-clearing-flag')]//div[text()='True'])[2]")
    private WebElementFacade NDF_Checkbox_True_ViewPDF;
    @FindBy(xpath = "(//*[contains(@class,'exclude-ndf-clearing-flag')]//div[text()='False'])[2]")
    private WebElementFacade NDF_Checkbox_False_ViewPDF;
    @FindBy(xpath = "//div[@class='edit-limit']//table//tbody//tr//td//input[@type='text']")
    private WebElementFacade limitValue_input;
    @FindBy(xpath = "//div[contains(@class, 'MuiAccordionSummary-expandIconWrapper')]")
    private WebElementFacade expandButton;
    @FindBy(xpath = "//td/input[@class='cds-input']")
    private WebElementFacade limit_Value_tab;
    @FindBy(xpath = "//button[text()=\"Approval Workflow for DN\"]")
    private WebElementFacade Approval_Workflow_tab;
    @FindBy(xpath = "//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']")
    private WebElementFacade navigation_btn;
    @FindBy(xpath = "//div[text()='All documents']")
    private WebElementFacade All_documents;
    @FindBy(xpath = "//div[normalize-space()='Document']")
    private WebElementFacade DocumentDropDown_btn;
    @FindBy(xpath = "//button[text()='Commit']")
    private WebElementFacade popup_Commit_btn;
    @FindBy(xpath = "(//button[@data-testid='action-buttons-trigger-approve'])[1]")
    private WebElementFacade ApproveBtn_approvalGrp;
    @FindBy(xpath = "//button[text()=\"Approval Workflow\"]")
    private WebElementFacade Approval_Workflow_tab_4Way;
    @FindBy(xpath = "//div[@class='currencies']//*[local-name()='svg']//*[local-name()='path']")
    private WebElementFacade ViewDetailsError;
    @FindBy(xpath = "//div[@role='presentation']/div/ul/*")
    private List<WebElementFacade> dropDownValues_inApprovalGroup;
    @FindBy(xpath = "//div[@class='usp-selection-div']/div")
    private WebElementFacade USP_Rider_Checkbox;
    @FindBy(xpath = "//img[@class='calIcon']")
    private WebElementFacade USP_Rider_Calendar_Icon;
    @FindBy(xpath = "(//div[@class='react-datepicker__week'])[1]/div[1]")
    private WebElementFacade USP_Rider_Date_Selection;
    @FindBy(xpath = "//div[text()='Prime Broker - 1']/following-sibling::*[local-name()='svg']")
    private WebElementFacade removeApprover;
    @FindBy(xpath = "//button[contains(., 'Tenor Configuration')]")
    private WebElementFacade TenorConfig;
    @FindBy(xpath = "//button[text()='Save Tenor']")
    private WebElementFacade SaveTenor;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    private WebElementFacade cancelButton_tenorConfig;
    @FindBy(xpath = "//button[text()='clear all']")
    private WebElementFacade clear_all_button;
    @FindBy(xpath = "//button[contains(., 'Notification recipient email ID')]")
    private WebElementFacade notificationRecipientBtn;
    @FindBy(xpath = "//input[@placeholder='Enter email id']")
    private WebElementFacade emailInputField;
    @FindBy(xpath = "//*[name()='svg' and contains(@class,'check')]")
    private WebElementFacade saveTickBtn;
    @FindBy(xpath = "//table[contains(@class,'csm_standard_table')]//tbody/tr/td[count(//table[contains(@class,'csm_standard_table')]//th[normalize-space()='Limit value']/preceding-sibling::th)+3]//input")
    WebElementFacade limitValueField;
    @FindBy(xpath = "(//header[@class='vhead']//h2)[1]")
    private WebElementFacade approvedVersionHeader;
    @FindBy(xpath = "(//header[@class='vhead']//h2)[2]")
    private WebElementFacade currentVersionHeader;
    @FindBy(xpath = "//label[contains(@data-testid,'auth-accordion-enable-switch-label')]//div[contains(@class,'enable-switch-container')]")
    private WebElementFacade enableTenorSwitch_DN;
    @FindBy(xpath = "//input[contains(@data-testid,'auth-accordion-tenor-value-input')]")
    private WebElementFacade authTenorValueInput_DN;
    @FindBy(xpath = "//div[contains(@data-testid,'auth-accordion-tenor-type-select')]//input")
    private WebElementFacade authTenorTypeSelect_DN;
    @FindBy(xpath = "(//button[contains(@data-testid, 'limit-line-action-toggle-btn')])[1]")
    private WebElementFacade limitLineEditIcon;
    @FindBy(xpath = "//div[@data-testid='auth-scope-preview-main-container']")
    private WebElementFacade AuthScopePreviewContainer;

    @FindBy(xpath = "//div[@data-testid='auth-scope-preview-main-container']//div[contains(@data-testid,'auth-line-preview-root-')]")
    private List<WebElementFacade> AuthLinePreviewRows;
    @FindBy(xpath = "//div[@data-testid='doc-flow-interactive-tabs-container']//button[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='limit scope']")
    private WebElementFacade limitScopeTab;
    @FindBy(xpath = "(//*[@data-testid='multiselect-text-field-input'])[2]")
    private WebElementFacade ProductFamilyDropDown;
    @FindBy(xpath = "//td[contains(@data-testid, 'table-cell-action-DF')]//button[@aria-label='Approve']")
    private WebElementFacade approveBtn_DFScreen;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-calculationType']")
    private WebElementFacade newHeaderCalculationType;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-limitValue']")
    private WebElementFacade newHeaderLimitValue;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-nettingType']")
    private WebElementFacade newHeaderNettingType;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-bullionTrades']")
    private WebElementFacade newHeaderBullionTrades;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-delta']")
    private WebElementFacade newHeaderDelta;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-productFamily']")
    private WebElementFacade newHeaderProductFamily;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-excludeCLS']")
    private WebElementFacade newHeaderExcludeCLS;
    @FindBy(xpath = "//th[@data-testid='limit-line-table-header-cell-isEnabled']")
    private WebElementFacade newHeaderIncludeLimitLine;

    public void validateNewLimitScopeHeaders() {
        log.info("Validating new UI Limit Scope table headers using data-testids...");
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue("Calculation type header is missing", newHeaderCalculationType.isVisible());
        Assert.assertTrue("Limit value header is missing", newHeaderLimitValue.isVisible());
        Assert.assertTrue("Netting type header is missing", newHeaderNettingType.isVisible());
        Assert.assertTrue("Bullion trades header is missing", newHeaderBullionTrades.isVisible());
        Assert.assertTrue("Delta header is missing", newHeaderDelta.isVisible());
        Assert.assertTrue("Product family header is missing", newHeaderProductFamily.isVisible());
        Assert.assertTrue("Exclude CLS header is missing", newHeaderExcludeCLS.isVisible());
        Assert.assertTrue("Include limit line header is missing", newHeaderIncludeLimitLine.isVisible());
        log.info("Successfully validated all New UI Limit Scope table headers.");
    }


    public void selectDates(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String calendarFieldName = columns.get("Calendar name");
            String dateToSelect = columns.get("date");
            selectDateForField(calendarFieldName, dateToSelect);
        }
    }

    private void selectDateForField(String fieldName, String dateString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate targetDate = LocalDate.parse(dateString, formatter);
        int targetYear = targetDate.getYear();
        int targetMonthValue = targetDate.getMonthValue();
        int targetDay = targetDate.getDayOfMonth();

        switch (fieldName) {
            case "Reference Date":
                getDriver().findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div//input")).click();
                break;
            case "Master Agreement ISDA":
                getDriver().findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div//input")).click();
                break;
            case "First Issue Date":
                getDriver().findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div//input")).click();
                break;
            case "Current Issue Date":
                getDriver().findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div//input")).click();
                break;
            case "Master Agreement Give-Up":
                getDriver().findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div//input")).click();
                break;
            case "Current Return Time":
                getDriver().findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div//input")).click();
                break;
            default:
                log.info("Not such calendar existed" + fieldName);
        }


        while (true) {
            // These XPaths are EXAMPLES. You MUST adapt them for your calendar's HTML.
            // String displayedMonthText = driver.findElement(By.className("calendar-month")).getText();
            // String displayedYearText = driver.findElement(By.className("calendar-year")).getText();

            // Simulating the calendar's state for this example.
            String displayMonthYear = DisplayMonthYear.getText();
            String displayedMonthText = displayMonthYear.substring(displayMonthYear.length() - 4);
            log.info("Month: -" + displayedMonthText);
            String displayedYearText = displayMonthYear.substring(0, displayMonthYear.length() - 5);
            log.info("Year: -" + displayedYearText);
            int displayedMonth = Month.valueOf(displayedMonthText.toUpperCase()).getValue();
            int displayedYear = Integer.parseInt(displayedYearText);

            if (displayedYear == targetYear && displayedMonth == targetMonthValue) {
                getDriver().findElement(By.xpath("//[text()='" + targetDay + "']")).click();
                break;
            }

            // Determine whether to click next or previous
            if (displayedYear < targetYear || (displayedYear == targetYear && displayedMonth < targetMonthValue)) {
                NextMonth.click();
            } else {
                PreviousMonth.click();
            }
        }

        // 4. Select the specific day.
        // String dayXPath = String.format("//td[not(contains(@class, 'disabled'))]/a[text()='%d']", targetDay);
    }

    public void selectRulesForDocument() {
        List<WebElement> rules = getDriver().findElements(By.xpath("//*[text()='Immediate']"));
        Iterator<WebElement> itr = rules.iterator();
        if (!rules.isEmpty()) {
            while (itr.hasNext()) {
                WebElement instance = itr.next();
                instance.click();
            }
        }
    }

    public void deletAllAvailableDocument() {
        List<WebElement> docCount = getDriver().findElements(By.xpath("//img[@alt='Delete']"));
        Iterator<WebElement> itr = docCount.iterator();
        if (!docCount.isEmpty()) {
            while (itr.hasNext()) {
                WebElement instance = itr.next();
                instance.click();
                popup_Yes_btn.click();
            }
        } else {
            log.info("No document is available with the above values.");
        }
    }

    public void ApprovalWorkflowNotCopied() {
        Assert.assertEquals("Drag and Drop here the participant", approvalSeq1.getText().trim());
    }

    public boolean clickNewDocument() {
        createNewDocument.waitUntilVisible();
        createNewDocument.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        return newDocumentScreen.isDisabled();
    }

    public void clickEditDocument() {
        Assert.assertTrue(editDocument.isVisible());
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", editDocument);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        editDocument.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void search_document_using_version_id(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        withAction().moveToElement(search_versionID).click().sendKeys(dataTable.get("document version ID")).build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();

    }

    public boolean validate_PB_EB_Client(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        return (dataTable.get("PB").equalsIgnoreCase(PB_EditScreen.getText().trim()) && dataTable.get("EB").equalsIgnoreCase(EB_EditScreen.getText().trim()) && dataTable.get("Client").equalsIgnoreCase(Client_EditScreen.getText().trim()));

    }

    public void Enforcement_rule(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            Enforced_schedule1.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            withAction().moveToElement(valuefor_fornewdocument_Schedule).click().sendKeys(dataTable.get("value"));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(Durationfor_fornewdocument_Schedule).click().sendKeys(dataTable.get("Duration")).pause(Duration.ofSeconds(1)).sendKeys(Keys.DOWN, Keys.ENTER).build().perform();

            Enforced_schedule2.waitUntilClickable().click();
            withAction().moveToElement(valuefor_foramendment_Schedule).click().sendKeys(dataTable.get("value"));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            withAction().moveToElement(Durationfor_fornewdocument_Schedule).click().sendKeys(dataTable.get("Duration")).pause(Duration.ofSeconds(1)).sendKeys(Keys.DOWN, Keys.ENTER).build().perform();

            enforcetermination.waitUntilClickable().click();
        } catch (Exception e) {
            log.error("unable to provide Enforcement rule for new document" + e);
        }
    }

    public void user_select_document_type(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectDocType.waitUntilVisible();
            withAction().moveToElement(selectDocType).click().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String docTypeStr = dataTable.get("Document Type").trim();
            typeInto(selectDocType, docTypeStr);
            String docTypeNormalized = docTypeStr.replace(" ", "");
            String docTypeXpath = "//p[translate(normalize-space(.), ' ', '')='" + docTypeNormalized + "' or text()='" + docTypeStr + "'] | " +
                                  "//div[@role='presentation']//*[translate(normalize-space(.), ' ', '')='" + docTypeNormalized + "'] | " +
                                  "//li[contains(translate(normalize-space(.), ' ', ''), '" + docTypeNormalized.toLowerCase() + "')]";
            getDriver().findElement(By.xpath(docTypeXpath)).click();
        } catch (Exception e) {
            log.info("Unable to select Document type-->" + e);
            Assert.fail();
        }
    }

    public void user_select_acting_as(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectActingAs.waitUntilPresent();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            withAction().moveToElement(selectActingAs).click().sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            typeInto(selectActingAs, dataTable.get("Acting As"));
            String ActAs = DropDown.replace("@placeholder@", dataTable.get("Acting As"));
            getDriver().findElement(By.xpath(ActAs)).click();
        } catch (Exception e) {
            log.info("Unable to select Acting As-->" + e);
            Assert.fail();
        }
    }

    public void user_select_acting_as_in_DF_DN(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String actingAsValue = dataTable.getOrDefault("Acting as", dataTable.get("Acting As"));
        try {
            actingAsInput_DFDN.waitUntilVisible();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            // CTRL+A then BACKSPACE (not a single BACK_SPACE) so this works whether the field
            // starts empty or arrives pre-filled with an existing LEI (e.g. Terminate modal).
            withAction().moveToElement(actingAsInput_DFDN).click()
                    .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                    .sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            withAction().sendKeys(actingAsValue).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            String ActAs = DropDown.replace("@placeholder@", actingAsValue);
            getDriver().findElement(By.xpath(ActAs)).click();
        } catch (Exception e) {
            log.info("Unable to select Acting As-->" + e);
            Assert.fail();
        }
    }

    public void search_acting_as_in_DF_DN(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        String actingAsValue = dataTable.getOrDefault("Acting as", dataTable.get("Acting As"));
        try {
            actingAsInput_DFDN.waitUntilVisible();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            withAction().moveToElement(actingAsInput_DFDN).click()
                    .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                    .sendKeys(Keys.BACK_SPACE).build().perform();
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            withAction().sendKeys(actingAsValue).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("Unable to type Acting As value '" + actingAsValue + "' -->" + e);
            Assert.fail("Unable to type into the Acting As field: " + e.getMessage());
        }
    }

    public void randomLEI() {
        Random rand = new Random();
        // Generate random integers in range 0 to 5
        int random = rand.nextInt(9);
        for (int i = 0; i <= random; i++) {
            act.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        act.sendKeys(Keys.RETURN).build().perform();
    }

    public void selectLEI(DataTable table) {
        try {
            List<List<String>> leilist = table.asLists();
            for (List<String> columns : leilist) {
                System.out.println("Column values " + columns.get(1) + columns.get(0));
                if (columns.get(1).equalsIgnoreCase("Random")) {
                    switch (columns.get(0)) {
                        case "Prime Broker 1":
                            act.moveToElement(selectPB1).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                        case "Prime Broker 2":
                            act.moveToElement(selectPB2).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                        case "Client 1":
                            act.moveToElement(selectClient1).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                        case "Client 2":
                            act.moveToElement(selectClient2).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                    }
                } else {
                    switch (columns.get(0)) {
                        case "Prime Broker 1":
                            selectPB1.waitUntilVisible();
                            act.moveToElement(selectPB1).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(2)).build().perform();
                            withAction().pause(Duration.ofSeconds(15)).build().perform();
                            act.sendKeys(Keys.RETURN).build().perform();
                            break;
                        case "Prime Broker 2":
                            act.moveToElement(selectPB2).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(2)).build().perform();
                            withAction().pause(Duration.ofSeconds(15)).build().perform();
                            act.sendKeys(Keys.RETURN).build().perform();
                            break;
                        case "Client 1":
                            act.moveToElement(selectClient1).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(2)).build().perform();
                            withAction().pause(Duration.ofSeconds(15)).build().perform();
                            act.sendKeys(Keys.RETURN).build().perform();
                            break;
                        case "Client 2":
                            act.moveToElement(selectClient2).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(2)).build().perform();
                            withAction().pause(Duration.ofSeconds(15)).build().perform();
                            act.sendKeys(Keys.RETURN).build().perform();
                            break;
                        case "EB 1":
                            act.moveToElement(selectEB).click().sendKeys(columns.get(1)).pause(Duration.ofSeconds(2)).build().perform();
                            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(2)).build().perform();
                            withAction().pause(Duration.ofSeconds(15)).build().perform();
                            act.sendKeys(Keys.RETURN).build().perform();
                            break;
                    }
                }
            }

        } catch (Exception e) {
            log.info("Unable to select Parties as PB2-->" + e);
            Assert.fail();
        }
    }
    public void selectLEIForNotification(DataTable table) {
        try {
            List<WebElement> options = new java.util.ArrayList<>();
            List<List<String>> leilist = table.asLists();
            for (List<String> columns : leilist) {
                String LeiType = columns.get(0).trim();
                String leiValue = columns.get(1).trim();

                if (leiValue.equalsIgnoreCase("Random")) {
                    switch (LeiType) {
                        case "Prime Broker 1":
                            act.moveToElement(selectPB1).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                        case "Prime Broker 2":
                            act.moveToElement(selectPB2).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                        case "Client 1":
                            act.moveToElement(selectClient1).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                        case "Client 2":
                            act.moveToElement(selectClient2).click().pause(Duration.ofSeconds(2)).build().perform();
                            randomLEI();
                            break;
                    }
                } else {
                    // Confirmed via DevTools: data-testid="party-input-wrapper-{key}" is stable and,
                    // critically, the react-select dropdown menu (lp-copy-sel__menu) renders AS A
                    // DESCENDANT of this same wrapper -- not portal-rendered elsewhere -- so scoping
                    // searches to fieldWrapper reliably stays confined to THIS field's own dropdown,
                    // even when another field (e.g. EB-1) already has the identical LEI text selected.
                    String key;
                    switch (LeiType) {
                        case "Prime Broker 1":
                        case "PB-1":
                        case "PB-1 Legal Entity Name":
                        case "PB 1":
                            key = "PB1"; break;
                        case "Prime Broker 2":
                        case "PB-2":
                        case "PB-2 Legal Entity Name":
                        case "PB 2":
                            key = "PB2"; break;
                        case "Client 1":
                        case "Client-1":
                        case "Client-1 Legal Entity Name":
                            key = "Client1"; break;
                        case "Client 2":
                        case "Client-2":
                        case "Client-2 Legal Entity Name":
                            key = "Client2"; break;
                        case "EB 1":
                        case "EB-1":
                        case "EB-1 Legal Entity Name":
                            key = "EB1"; break;
                        default:
                            log.info("Unknown LEI type: " + LeiType);
                            continue;
                    }

                    WebElementFacade fieldWrapper = find(By.xpath("//div[@data-testid='party-input-wrapper-" + key + "']"));
                    WebElementFacade targetElement = fieldWrapper.find(By.xpath(".//input"));
                    targetElement.waitUntilVisible();

                    // "type + trailing space + backspace" forces the underlying react-select input's
                    // onChange/API search to reliably re-fire. The space -- not a real character --
                    // is what gets removed by the backspace.
                    act.moveToElement(targetElement).click()
                            .sendKeys(leiValue + " ")
                            .pause(Duration.ofSeconds(1))
                            .sendKeys(Keys.BACK_SPACE)
                            .pause(Duration.ofSeconds(2))
                            .build().perform();

                    String lowerValue = leiValue.trim().toLowerCase();

                    try {
                        // Scoped to fieldWrapper AND to this field's own lp-copy-sel__menu --
                        // confirmed via DevTools to be a genuine descendant, not a page-wide/portal
                        // element -- so this can never match an already-selected value in a
                        // different field.
                        // NOTE: WebElementFacade does not expose a findAll(By) method of its own --
                        // findAll(...) elsewhere in this class is a PageObject-level (unscoped)
                        // method. WebElementFacade DOES extend the standard Selenium WebElement,
                        // which always exposes findElements(By) -- used here instead, which is
                        // guaranteed to compile and still returns results scoped to fieldWrapper's
                        // own subtree.
                        String matchXpath = ".//div[contains(@class,'lp-copy-sel__menu')]" +
                                "//*[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerValue + "']";
                        options = fieldWrapper.findElements(By.xpath(matchXpath));

                        if (!options.isEmpty()) {
                            WebElement optionToClick = options.get(0);
                            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", optionToClick);
                            withAction().pause(Duration.ofSeconds(1)).build().perform();

                            try {
                                optionToClick.click();
                            } catch (Exception clickEx) {
                                getJavascriptExecutorFacade().executeScript("arguments[0].click();", optionToClick);
                            }
                            log.info("Successfully selected LEI: " + leiValue);

                        } else {
                            throw new Exception("Dropdown option not found in DOM after waiting.");
                        }
                    } catch (Exception ex) {
                        log.warn("Click failed for LEI: " + leiValue + ". Falling back to Keyboard Actions.");
                        act.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
                    }

                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }

                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }

        } catch (Exception e) {
            log.info("Unable to select Parties -->" + e.getMessage());
            Assert.fail("Test failed while selecting LEI: " + e.getMessage());
        }
    }

//    public void selectLEIForNotification(DataTable table) {
//        try {
//            List<WebElementFacade> options = new java.util.ArrayList<>();
//            List<List<String>> leilist = table.asLists();
//            for (List<String> columns : leilist) {
//                String LeiType = columns.get(0).trim();
//                String leiValue = columns.get(1).trim();
//
//                if (leiValue.equalsIgnoreCase("Random")) {
//                    switch (LeiType) {
//                        case "Prime Broker 1":
//                            act.moveToElement(selectPB1).click().pause(Duration.ofSeconds(2)).build().perform();
//                            randomLEI();
//                            break;
//                        case "Prime Broker 2":
//                            act.moveToElement(selectPB2).click().pause(Duration.ofSeconds(2)).build().perform();
//                            randomLEI();
//                            break;
//                        case "Client 1":
//                            act.moveToElement(selectClient1).click().pause(Duration.ofSeconds(2)).build().perform();
//                            randomLEI();
//                            break;
//                        case "Client 2":
//                            act.moveToElement(selectClient2).click().pause(Duration.ofSeconds(2)).build().perform();
//                            randomLEI();
//                            break;
//                    }
//                } else {
//                    WebElementFacade targetElement = null;
//                    switch (LeiType) {
//                        case "Prime Broker 1":
//                            targetElement = selectPB1;
//                            break;
//                        case "Prime Broker 2":
//                            targetElement = selectPB2;
//                            break;
//                        case "Client 1":
//                            targetElement = selectClient1;
//                            break;
//                        case "Client 2":
//                            targetElement = selectClient2;
//                            break;
//                        case "EB 1":
//                            targetElement = selectEB;
//                            break;
//                    }
//
//                    if (targetElement != null) {
//                        targetElement.waitUntilVisible();
//
//                        // 1. Click and type the LEI value.
//                        // Trick: We add a SPACE and then BACK_SPACE. This reliably forces React/Angular
//                        // to trigger the API search for large lists (like Clients).
//                        act.moveToElement(targetElement).click()
//                                .sendKeys(leiValue + " ")
//                                .pause(Duration.ofSeconds(1))
//                                .sendKeys(Keys.BACK_SPACE) // Remove the space to trigger API
//                                .pause(Duration.ofSeconds(2)) // Wait for backend to return results
//                                .build().perform();
//
//                        String lowerValue = leiValue.trim().toLowerCase();
//
//                        try {
//                            // 2. Strict XPath: We MUST specify 'li' or 'div[@role="option"]'.
//                            // This ensures Selenium doesn't accidentally click the unclickable <ul> parent wrapper.
//                            String matchXpath = "//*[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + lowerValue + "']";
//
//                                options = findAll(By.xpath(matchXpath));
//
//                            if (!options.isEmpty()) {
//                                WebElementFacade optionToClick = options.get(0);
//                                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", optionToClick);
//                                withAction().pause(Duration.ofSeconds(1)).build().perform();
//
//                                // 3. Click the physical option row
//                                try {
//                                    optionToClick.waitUntilClickable().click();
//                                } catch (Exception clickEx) {
//                                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", optionToClick);
//                                }
//                                log.info("Successfully selected LEI: " + leiValue);
//
//                            } else {
//                                throw new Exception("Dropdown option not found in DOM after waiting.");
//                            }
//                        } catch (Exception ex) {
//                            log.warn("Click failed for LEI: " + leiValue + ". Falling back to Keyboard Actions.");
//                            // 4. Keyboard Fallback
//                            act.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
//                        }
//
//                        withAction().pause(Duration.ofSeconds(1)).build().perform();
//                    }
//                }
//
//                withAction().pause(Duration.ofSeconds(1)).build().perform();
//            }
//
//        } catch (Exception e) {
//            log.info("Unable to select Parties -->" + e.getMessage());
//            Assert.fail("Test failed while selecting LEI: " + e.getMessage());
//        }
//    }

    public void clickSelectPartiesAsPB1(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectPB1.waitUntilVisible();
            act.moveToElement(selectPB1).click().sendKeys(dataTable.get("Prime Broker 1")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(3)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as PB1-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectPartiesAsPB2(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectPB2.waitUntilVisible();
            act.moveToElement(selectPB2).click().sendKeys(dataTable.get("Prime Broker 2")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(3)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as PB2-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectPartiesAsClient1(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectClient1.waitUntilPresent();
            act.moveToElement(selectClient1).click().sendKeys(dataTable.get("Clients 1")).pause(Duration.ofSeconds(5)).build().perform();
            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(3)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as Client1-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectPartiesAsClient2(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            selectClient2.waitUntilVisible();
            act.moveToElement(selectClient2).click().sendKeys(dataTable.get("Clients 2")).pause(Duration.ofSeconds(2)).build().perform();
            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(3)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as Client2-->" + e);
            Assert.fail();
        }
    }

    public void generateRandomPB1() {
        try {
            Random rand = new Random();
            // Generate random integers in range 0 to 999
            int random = rand.nextInt(5);
            selectPB1.waitUntilVisible();
            act.moveToElement(selectPB1).click().pause(Duration.ofSeconds(5)).build().perform();
            for (int i = 0; i <= random; i++) {
                act.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            act.sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as PB2-->" + e);
            Assert.fail();
        }
    }

//    public void clickSelectPartiesAsPB1(DataTable table){
//        List<Map<String, String>> data = table.asMaps(String.class, String.class);
//        Map<String,String> dataTable_map= data.get(0);
//        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
//        try{
//            selectClient1.waitUntilVisible();
//            act.moveToElement(selectClient1).click().sendKeys(dataTable.get("PB 1")).pause(Duration.ofSeconds(2)).build().perform();
//            act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(15)).build().perform();
//            act.sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
//        }catch (Exception e){
//            log.info("Unable to select Parties as PB1-->"+e);
//            Assert.fail();
//        }
//    }


    public void generateRandomPB2() {
        try {
            Random rand = new Random();
            // Generate random integers in range 0 to 999
            int random = rand.nextInt(5);
            selectPB2.waitUntilVisible();
            act.moveToElement(selectPB2).click().pause(Duration.ofSeconds(2)).build().perform();
            for (int i = 0; i <= random; i++) {
                act.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            act.sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as PB2-->" + e);
            Assert.fail();
        }
    }

    public void generateRandomClient2() {
        try {
            Random rand = new Random();
            // Generate random integers in range 0 to 999
            int random = rand.nextInt(28);
            selectClient2.waitUntilVisible();
            act.moveToElement(selectClient2).click().pause(Duration.ofSeconds(2)).build().perform();
            for (int i = 0; i <= random; i++) {
                act.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            act.sendKeys(Keys.RETURN).build().perform();
            act.pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.info("Unable to select Parties as Client2-->" + e);
            Assert.fail();
        }
    }

    public boolean checkEB1Data(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);

        String expectedLei = dataTable.get("EB-1 LEI").trim();
        String expectedName = dataTable.get("EB-1 Legal Entity Name").trim();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EB1_LEI_Column);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            String leiXpath = "//span[contains(@data-testid, 'cell-default-eb1-') and contains(., '" + expectedLei + "')]";
            WebElement leiElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(leiXpath)));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", leiElement);
            withAction().moveToElement(leiElement).pause(Duration.ofMillis(500)).build().perform();
            Assert.assertTrue("Validation failed: EB-1 LEI '" + expectedLei + "' was not found.", leiElement.isDisplayed());
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EB1_LegalEntityName_Column);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String nameXpath = "//span[contains(@data-testid, 'cell-default-eb1Name-') and contains(., '" + expectedName + "')]";
            WebElement nameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nameXpath)));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", nameElement);
            withAction().moveToElement(nameElement).pause(Duration.ofMillis(500)).build().perform();
            return nameElement.isDisplayed();

        } catch (Exception e) {
            log.error("Failed to locate EB-1 Data. Table might still be loading. Error: " + e.getMessage());
            return false;
        }
    }


    public void validateAllowedCurrency() {
        allowedCurrencyFX.waitUntilVisible();
    }

    public void clickNextbtn() {
        next_btn.withTimeoutOf(Duration.ofSeconds(8)).waitUntilClickable();
        evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", next_btn);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", next_btn);
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(
                    driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
            );
        } catch (Exception e) {
            log.warn("Page load wait timed out or interrupted: " + e.getMessage());
        }
        withAction().pause(Duration.ofSeconds(4)).build().perform();
    }

    public void clickNextbtnonAuthScope() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        next_btn.waitUntilClickable().click();
    }

    public void clickCancelbtn() {
        withAction().pause(Duration.ofSeconds(8)).build().perform();
        evaluateJavascript("arguments[0].scrollIntoView({block: 'center'});", cancel_btn);
        cancel_btn.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void clickCancelbtnForEditLimit() {
        cancel_btn.waitUntilPresent();
        evaluateJavascript("arguments[0].click();", cancel_btn);
        withAction().pause(Duration.ofSeconds(4)).perform();
    }

    public void clickCancelbtnForPopup() {
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        cancel_btn_popup.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void dragAndDrop(WebElement from, WebElement to) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", from, to);
    }

    public void clickSelectApprovalWorkflow() {
        try {
            approvalWorkflow_btn.waitUntilPresent();
            dragAndDrop(PB1_participant, approvalSeq1);
            next_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            if (submitforapproval_btn.isVisible()) {
                submitforapproval_btn.click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            } else {
                log.info("Unable to select Approval Workflow-->" + e);
                Assert.fail();
            }

        }
    }

    public void clickSelectEnforcementRules() {
        try {
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            enforcenew.waitUntilClickable().click();
            enforceammendment.waitUntilClickable().click();
            ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            next_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            if (submitforapproval_btn.isVisible()) {
                submitforapproval_btn.click();
            }
        }
    }

    public void clickSelectLegalTerms(DataTable LegalTerms) {
        List<Map<String, String>> data = LegalTerms.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            if (textboxDocumentTerms.isVisible()) {
                textboxDocumentTerms.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                withAction().moveToElement(textboxDocumentTerms).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            withAction().moveToElement(textboxDocumentTerms).click().sendKeys(dataTable.get("Legal Terms")).build().perform();
            withAction().pause(Duration.ofSeconds(4)).build().perform();

            if (submitforapproval_btn.isVisible()) {
                submitforapproval_btn.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            } else if (next_btn.isVisible()) {
                next_btn.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }

        } catch (Exception e) {
            log.error("Unable to input Legal Terms-->" + e);
            Assert.fail();
//            if (submitforapproval_btn.isVisible()){
//                submitforapproval_btn.click();
//            }
//            else {
//                log.error("Unable to input Legal Terms-->"+e);
//                Assert.fail();
//            }

        }
    }

    public void clickSelectAuthProductGroup(DataTable AuthProductGroup) {
        List<Map<String, String>> data = AuthProductGroup.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            withAction().moveToElement(AuthProducts_group).click().sendKeys(dataTable.get("Auth Product Group")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
        } catch (Exception e) {
            log.error("Unable to click Auth Scope-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectMultipleAuthProductGroup(DataTable authProductGroupTable) {
        List<Map<String, String>> data = authProductGroupTable.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        String searchTerm = dataTable_map.get("Auth Product Group");
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", AuthProducts_group);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        AuthProducts_group.click();
        withAction().pause(Duration.ofMillis(500)).build().perform();
        AuthProducts_group.sendKeys(searchTerm);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        String listboxId = AuthProducts_group.getAttribute("aria-controls");
        if (listboxId == null || listboxId.isEmpty()) {
            Assert.fail("Auth Product Group dropdown did not open (no aria-controls) for search: " + searchTerm);
        }
        List<WebElement> options = getDriver().findElements(By.xpath(
                "//*[@id='" + listboxId + "']//li[@role='option']"));
        if (options.isEmpty()) {
            Assert.fail("No Auth Product Group options found matching: " + searchTerm);
        }
        log.info("Found {} Auth Product Group option(s) matching '{}'", options.size(), searchTerm);
        for (WebElement option : options) {
            try {
                WebElement checkbox = option.findElement(By.xpath(".//input[@type='checkbox']"));
                if (!checkbox.isSelected()) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", checkbox);
                    withAction().pause(Duration.ofMillis(500)).build().perform();
                }
            } catch (NoSuchElementException e) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", option);
                withAction().pause(Duration.ofMillis(500)).build().perform();
            }
        }

        try {
            AuthProducts_group.sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
            withAction().sendKeys(Keys.ESCAPE).build().perform();
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        log.info("Selected {} Auth Product Group(s) matching '{}'; dropdown closed.", options.size(), searchTerm);
    }

    public void validateAuthScope() {
        try {
            act.pause(Duration.ofSeconds(2)).build().perform();
            String Auth01 = AuthLines01.getText();
            Assert.assertEquals("FX Volatility\nVolatility Swap", Auth01);
        } catch (Exception e) {
            log.error("Unable to click Auth Scope-->" + e);
            Assert.fail();
        }
    }
    public void validateAuthScopeDataDetailed(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String assetClass = row.get("Asset Class").trim();
            String productFamily = row.get("Product Family").trim();
            String product = row.get("Product").trim();
            String expectedCurrency = row.get("Currencies Deliverable").trim();
            String expectedTenor = row.get("Tenor").trim(); // e.g. "3Years"

            // 1. Validate Asset Class / Product Family / Product title
            act.pause(Duration.ofSeconds(2)).build().perform();
            String actualTitle = AuthLines01.getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
            String expectedTitle = (assetClass + " " + productFamily + " " + product).replaceAll("\\s+", " ").trim();
            log.info("Auth Scope Title -> Expected: '{}' | Actual: '{}'", expectedTitle, actualTitle);
            Assert.assertTrue("Auth Scope title mismatch. Expected: '" + expectedTitle + "', found: '" + actualTitle + "'",
                    actualTitle.equalsIgnoreCase(expectedTitle));

            // 2. Validate Deliverable Currency
            WebElementFacade deliverableBlock = find(By.xpath("//span[@class='deliverable-header']/parent::div"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deliverableBlock);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            String actualCurrencyText = deliverableBlock.getText().replace("Deliverable:", "").trim();
            log.info("Deliverable Currency -> Expected: '{}' | Actual: '{}'", expectedCurrency, actualCurrencyText);
            Assert.assertTrue("Deliverable currency mismatch. Expected: '" + expectedCurrency + "', found: '" + actualCurrencyText + "'",
                    actualCurrencyText.equalsIgnoreCase(expectedCurrency));

            // 3. Validate Tenor (value + unit combined, e.g. "3Years")
            WebElementFacade tenorValueField = find(By.xpath("//input[@class='accordion-input']"));
            String actualTenorValue = tenorValueField.getValue().trim();

            WebElementFacade tenorTypeField = find(By.xpath("//div[contains(@data-testid,'tenor-type-select')]//input"));
            String actualTenorType = tenorTypeField.getValue().trim();

            String actualTenorCombined = (actualTenorValue + actualTenorType).trim();
            log.info("Tenor -> Expected: '{}' | Actual: '{}' (value='{}', type='{}')",
                    expectedTenor, actualTenorCombined, actualTenorValue, actualTenorType);
            Assert.assertTrue("Tenor mismatch. Expected: '" + expectedTenor + "', found: '" + actualTenorCombined + "'",
                    actualTenorCombined.equalsIgnoreCase(expectedTenor));

            log.info("Auth Scope data validation PASSED for: {}", expectedTitle);
        }
    }

    public boolean validateAuthScopeData(DataTable table) {
        boolean overallResult = true;
        List<String> AllTenorValues = new ArrayList<>();
        for (WebElementFacade tenor : TenorValues) {
            AllTenorValues.add(tenor.getText().replace("\n", " "));
        }

        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
            boolean rowResult = true;
            if (dataTable.containsKey("Product")) {
                String ProductValues = dataTable_map.get("Product");
                String[] splitValuesArray = ProductValues.split(" ");
                WebElement productExists = getDriver().findElement(By.xpath("//*[contains(text(),'" + splitValuesArray[2] + "')]"));
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productExists);
                rowResult = productExists.isDisplayed();
            } else if (dataTable.containsKey("Currencies")) {
                String CurrenciesValues = dataTable_map.get("Currencies");
                WebElement currencyExists = getDriver().findElement(By.xpath("//*[@class ='currencies']//text()[contains(., '" + CurrenciesValues + "')]"));
                rowResult = currencyExists.isDisplayed();
            } else if (dataTable.containsKey("Tenor")) {
                String Tenor = dataTable_map.get("Tenor");
                rowResult = AllTenorValues.contains(Tenor);
            }
            if (!rowResult) {
                overallResult = false; // If any row validation fails, the overall result is false
            }
        }
        return overallResult;
    }

    public boolean validateAuthScopeDataInPreview(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String productName = row.get("Product");
            if (productName == null || productName.trim().isEmpty()) {
                log.error("Product column is mandatory to identify which Auth Line row to validate.");
                overallResult = false;
                continue;
            }
            productName = productName.trim();

            WebElementFacade authLineRoot = null;
            for (WebElementFacade candidate : AuthLinePreviewRows) {
                WebElement header = candidate.findElement(By.xpath(".//div[contains(@data-testid,'auth-line-preview-header-')]"));
                if (header.getText().trim().equals(productName)) {
                    authLineRoot = candidate;
                    break;
                }
            }

            if (authLineRoot == null) {
                log.error("Could not find Auth Line preview row for product: " + productName);
                overallResult = false;
                continue;
            }

            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", authLineRoot);
            withAction().pause(Duration.ofMillis(300)).build().perform();

            boolean rowResult = true;

            if (hasValueForKey(row, "Currencies Deliverable")) {
                String expected = row.get("Currencies Deliverable").trim();
                boolean found = isTextPresentWithin(authLineRoot, ".//div[@class='deliverable']", expected);
                if (!found) log.error("Deliverable mismatch for '{}': expected to contain '{}'", productName, expected);
                rowResult &= found;
            }

            if (hasValueForKey(row, "Currencies Non-Deliverable")) {
                String expected = row.get("Currencies Non-Deliverable").trim();
                boolean found = isTextPresentWithin(authLineRoot, ".//div[@class='non-deliverable']", expected);
                if (!found) log.error("Non-Deliverable mismatch for '{}': expected to contain '{}'", productName, expected);
                rowResult &= found;
            }

            if (hasValueForKey(row, "Tenor")) {
                String expected = row.get("Tenor").trim();
                boolean found = isTextPresentWithin(authLineRoot,
                        ".//div[contains(@data-testid,'auth-line-preview-tenor-value-box-')]", expected);
                if (!found) log.error("Tenor mismatch for '{}': expected '{}'", productName, expected);
                rowResult &= found;
            }

            if (!rowResult) {
                overallResult = false;
            }
        }
        return overallResult;
    }

    private boolean hasValueForKey(Map<String, String> row, String key) {
        return row.containsKey(key) && row.get(key) != null && !row.get(key).trim().isEmpty();
    }

    private boolean isTextPresentWithin(WebElement scopeRoot, String relativeXpath, String expectedText) {
        try {
            WebElement element = scopeRoot.findElement(By.xpath(relativeXpath));
            String actual = element.getText().replaceAll("\\s+", " ").trim();
            String expected = expectedText.replaceAll("\\s+", " ").trim();
            return actual.contains(expected);
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean validateDocumentTermsDataInViewAsPDF(String Data) {
        WebElement DocumentTermsData = getDriver().findElement(By.xpath("//*[contains(text(),'" + Data + "')]"));
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", DocumentTermsData);
        return DocumentTermsData.isDisplayed();
    }

    public boolean validateDocumentData(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> rowData : data) {
            String targetXpath = "";
            String valueToLog = "";
            if (rowData.containsKey("Limit value")) {
                String val = rowData.get("Limit value").trim();
                targetXpath = "//table[@class='csm_standard_table undefined']/tbody/tr/td[contains(text(), '$') and contains(., '" + val + "')]";
                valueToLog = "Limit Value: " + val;

            } else if (rowData.containsKey("Product")) {
                String val = rowData.get("Product");
                String[] splitValues = val.split(" ");
                if (splitValues.length > 2) {
                    targetXpath = "//*[contains(text(),'" + splitValues[2] + "')]";
                    valueToLog = "Product: " + splitValues[2];
                } else {
                    System.out.println("⚠️ Skipping Product (format unexpected): " + val);
                    overallResult = false;
                    continue;
                }

            } else if (rowData.containsKey("Currencies")) {
                String val = rowData.get("Currencies");
                targetXpath = "//*[@class ='currencies' and contains(text(),'" + val + "')]";
                valueToLog = "Currency: " + val;

            } else if (rowData.containsKey("Tenor")) {
                String val = rowData.get("Tenor");
                targetXpath = "//*[contains(text(),'" + val + "')]";
                valueToLog = "Tenor: " + val;
            }
            if (!targetXpath.isEmpty()) {
                boolean isFound = false;
                int maxRetries = 10;

                for (int i = 0; i < maxRetries; i++) {
                    List<WebElementFacade> elements = findAll(By.xpath(targetXpath));
                    if (!elements.isEmpty() && elements.get(0).isVisible()) {
                        WebElementFacade element = elements.get(0);
                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
                        withAction().pause(Duration.ofMillis(300)).build().perform();

                        System.out.println("✅ Found " + valueToLog);
                        isFound = true;
                        break;
                    }
                    System.out.println("Searching for " + valueToLog + "... Scrolling down (Attempt " + (i + 1) + ")");
                    withAction().sendKeys(Keys.PAGE_DOWN).pause(Duration.ofSeconds(1)).build().perform();
                }
                if (!isFound) {
                    System.out.println("FAILED to find: " + valueToLog);
                    overallResult = false;
                }
            }
        }

        return overallResult;
    }

    public boolean validateDataIsNotInDocumentPreview(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> rowData : data) {
            String targetXpath = "";
            String valueToLog = "";
            if (rowData.containsKey("Product")) {
                String val = rowData.get("Product");
                targetXpath = "//*[contains(text(),'" + val + "')]";
                valueToLog = "Product: " + val;
            }
            if (!targetXpath.isEmpty()) {
                boolean isFound = false;
                try {
                    withTimeoutOf(Duration.ofSeconds(5)).find(By.xpath(targetXpath));
                    isFound = true;
                } catch (NoSuchElementException e) {
                    isFound = false;
                }
                if (isFound) {
                    System.out.println("FAILED to NOT find: " + valueToLog);
                    overallResult = false;
                } else {
                    System.out.println("✅ Did NOT find " + valueToLog);
                }
            }
        }
        return overallResult;
    }


    public boolean validateLimitValueData(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> rowData : data) {
            if (rowData.containsKey("Limit value")) {
                String expectedValue = rowData.get("Limit value").trim();
                boolean isValueFound = false;
                String dynamicXpath = "//table[@class='csm_standard_table undefined']/tbody/tr/td[contains(text(), '$') and contains(., '" + expectedValue + "')]";
                int maxRetries = 10;
                for (int i = 0; i < maxRetries; i++) {
                    List<WebElementFacade> elements = findAll(By.xpath(dynamicXpath));
                    if (!elements.isEmpty() && elements.get(0).isVisible()) {
                        WebElementFacade targetElement = elements.get(0);
                        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", targetElement);

                        System.out.println("Found Limit Value: " + expectedValue);
                        isValueFound = true;
                        break;
                    }
                    System.out.println("Searching for '" + expectedValue + "'... Scrolling down (Attempt " + (i + 1) + "/" + maxRetries + ")");
                    withAction().sendKeys(Keys.PAGE_DOWN).pause(Duration.ofSeconds(1)).build().perform();
                }
                if (!isValueFound) {
                    System.out.println("FAILED: Could not find Limit Value '" + expectedValue + "' after " + maxRetries + " scrolls.");
                    overallResult = false;
                }
            }
        }
        return overallResult;
    }


    public void clickSelectCurrenciesGroup(DataTable CurrenciesGroup) {
        List<Map<String, String>> data = CurrenciesGroup.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            authCurrencies.waitUntilVisible().click();
            currenciesGroup.waitUntilVisible().click();
            withAction().moveToElement(currenciesGroup).click().sendKeys(dataTable.get("Currencies Group")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(submit_btn).click().build().perform();
        } catch (Exception e) {
            log.error("Unable to select Currency Group-->" + e);
            Assert.fail();
        }
    }

    public void clickonCurrencies() {
        try {
            authCurrencies.waitUntilVisible().click();
            add_AED.click();
            submit_btn.waitUntilVisible().click();
        } catch (Exception e) {
            log.error("Unable to select Currency Group-->" + e);
            Assert.fail();
        }
    }


    public void clickSelectAuthTenorvalue(DataTable AuthValue) {
        List<Map<String, String>> data = AuthValue.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            authTenorValue4W.waitUntilVisible().waitUntilEnabled();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            authTenorValue4W.clear();
            withAction().moveToElement(authTenorValue4W).click().sendKeys(dataTable.get("Auth Value")).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Auth Value-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectAuthTenorvalueafterSelectingValue(DataTable AuthValue) {
        List<Map<String, String>> data = AuthValue.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            authTenorValue4Werror.waitUntilVisible().waitUntilEnabled();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            authTenorValue4Werror.clear();
            withAction().moveToElement(authTenorValue4Werror).click().sendKeys(dataTable.get("Auth Value")).pause(Duration.ofSeconds(3)).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Auth Value-->" + e);
            Assert.fail();
        }
    }

    public void clickClearAuthTenorvalue() {
        authTenorValue4Werror.waitUntilVisible().waitUntilEnabled().clear();
    }


    public void clickOnAuthScopeTab() {
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        getJavascriptExecutorFacade().executeScript("window.scrollTo(0, 0);");
        AuthScope_tab.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void clickOnExpandIcon() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        act.pause(Duration.ofSeconds(2)).build().perform();
        ExpandAuthLine.click();
    }

    public void clickOnExpandIconForAuthLine(String AuthLine) {
        By xpath = By.xpath("//span[translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + AuthLine.toLowerCase() + "']//../../../following-sibling::div//*[local-name()='svg']");
        withTimeoutOf(Duration.ofSeconds(15)).waitFor(xpath);
        WebElement AuthLineExpandIcon = getDriver().findElement(xpath);
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", AuthLineExpandIcon);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        AuthLineExpandIcon.click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    private void safeClickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript(
                "if (arguments[0].parentElement && typeof arguments[0].parentElement.click === 'function') { arguments[0].parentElement.click(); } " +
                "else if (typeof arguments[0].click === 'function') { arguments[0].click(); } " +
                "else { arguments[0].dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true, view: window })); }",
                element
            );
        }
    }

    public void clickOnExpandParentFor4Way(String parentName) {
        String lowerParent = parentName.trim().toLowerCase();
        log.info("Expanding parent on Auth Scope by clicking text: '{}'", parentName);

        String searchKeyword;
        if (lowerParent.contains("vanilla options")) {
            searchKeyword = "vanilla options";
        } else if (lowerParent.contains("exotic options")) {
            searchKeyword = "exotic options";
        } else if (lowerParent.contains("cash")) {
            searchKeyword = "cash";
        } else {
            searchKeyword = lowerParent;
        }

        String textXpath = "//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + searchKeyword + "') and not(self::script) and not(self::style)]";

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            List<WebElement> candidates = getDriver().findElements(By.xpath(textXpath));
            WebElement textElement = null;
            for (WebElement el : candidates) {
                if (el.isDisplayed()) {
                    textElement = el;
                }
            }

            if (textElement == null) {
                textElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textXpath)));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", textElement);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            safeClickElement(textElement);
            log.info("Successfully clicked text element for parent: '{}'", parentName);
        } catch (Exception ex) {
            log.error("Failed to click parent text for '{}': {}", parentName, ex.getMessage());
            Assert.fail("Failed to click parent text: " + parentName + " | " + ex.getMessage());
        }
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void clickOnExpandIconForAuthLineFor4Way(String AuthLine) {
        String lowerAuthLine = AuthLine.trim().toLowerCase();

        if (lowerAuthLine.equals("fx vanilla options") || lowerAuthLine.equals("fx exotic options") || lowerAuthLine.equals("fx cash") ||
            lowerAuthLine.equals("vanilla options") || lowerAuthLine.equals("exotic options")) {
            clickOnExpandParentFor4Way(AuthLine);
            return;
        }

        String productKeyword;
        if (lowerAuthLine.contains("vanilla option")) {
            productKeyword = "vanilla option";
        } else if (lowerAuthLine.contains("single barrier digital")) {
            productKeyword = "single barrier digital";
        } else if (lowerAuthLine.contains("one touch")) {
            productKeyword = "one touch";
        } else {
            String[] parts = lowerAuthLine.split("\\s+");
            productKeyword = parts[parts.length - 1];
        }

        log.info("Expanding child product line: '{}' (search keyword: '{}')", AuthLine, productKeyword);

        String childTextXpath = "(//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productKeyword + "') and not(self::script) and not(self::style)])[last()]";

        String childChevronXpath = childTextXpath + "/ancestor::div[1]/following-sibling::div//*[local-name()='svg' and @data-testid='ArrowForwardIosSharpIcon'] | " +
                                  childTextXpath + "/following::*[local-name()='svg' and @data-testid='ArrowForwardIosSharpIcon'][1] | " +
                                  childTextXpath + "/ancestor::div[contains(@class, 'accordion')][1]//*[local-name()='svg' and @data-testid='ArrowForwardIosSharpIcon']";

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement chevron;
        try {
            chevron = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(childChevronXpath)));
        } catch (Exception e) {
            String fallbackXpath = "(//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productKeyword + "')])[last()]/following::*[local-name()='svg'][1]";
            chevron = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fallbackXpath)));
        }

        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", chevron);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        safeClickElement(chevron);
        log.info("Successfully clicked child expand chevron for '{}'", AuthLine);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void clickOnOneExpandIcon() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        act.pause(Duration.ofSeconds(1)).build().perform();
        ExpandAuthLine.click();
        act.pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(FXCashFuture.isVisible());
    }

    public void clickSelectAuthTenor(DataTable AuthTenor) {
        List<Map<String, String>> data = AuthTenor.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            authSelectTenor4W.waitUntilVisible().waitUntilEnabled();
            authSelectTenor4W.waitUntilVisible().click();
            typeInto(authSelectTenor4W, dataTable.get("Auth Tenor"));
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Auth Tenor-->" + e);
            Assert.fail();
        }
    }

    public void clickAuthLineandNext() {
        try {
            addAuthLine.waitUntilVisible().click();
            next_btn.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(20)).build().perform();
        } catch (Exception e) {
            log.error("Unable to add auth line and click next-->" + e);
            Assert.fail();
        }
    }

    public void clickAuthLine() {
        try {
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            if (AuthScope_tab.isPresent() && AuthScope_tab.isCurrentlyVisible()) {
                log.info("Auth Scope tab is visible. Clicking it to ensure we are on the correct tab.");
                AuthScope_tab.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
            if (addAuthLine.isPresent() && addAuthLine.isEnabled()) {
                log.info("Add Auth Line button is enabled. Clicking it.");
                addAuthLine.click();
            } else {
                log.info("Add Auth Line button is present but not enabled. Skipping click as an empty Auth Line might already be open.");
            }
        } catch (Exception e) {
            log.error("Unable to add auth line and click next-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectLimitScope() {
        try {
            LimitScope_tab.waitUntilVisible();
        } catch (Exception e) {
            log.error("Unable to input Limit Scope-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectCalculationType(DataTable CalculationType) {
        List<Map<String, String>> data = CalculationType.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            calculationType_tab.waitUntilPresent().click();
            withAction().moveToElement(calculationType_tab).sendKeys(dataTable.get("Calculation Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN, Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Calculation Type-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectLimitValue(DataTable LimitValue) {
        List<Map<String, String>> data = LimitValue.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            limitValue_tab.waitUntilVisible().click();
            typeInto(limitValue_tab, dataTable.get("Limit Value"));
        } catch (Exception e) {
            log.error("Unable to input Limit Value-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectNettingType(DataTable NettingType) {
        List<Map<String, String>> data = NettingType.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            nettingType_tab.waitUntilPresent().click();
            withAction().moveToElement(nettingType_tab).sendKeys(dataTable.get("Netting Type")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Netting Type-->" + e);
            Assert.fail();
        }
    }

    public void clickSelectDelta(DataTable Delta) {
        List<Map<String, String>> data = Delta.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            delta_tab.waitUntilPresent().click();
            withAction().moveToElement(delta_tab).sendKeys(dataTable.get("Delta")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Delta-->" + e);
            Assert.fail();
        }
    }
    public void clickSelectProductFamily(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productFamilyPopupToggle_4Way);
        withAction().moveToElement(productFamilyPopupToggle_4Way).click().build().perform();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        for (Map<String, String> dataTable : data) {
            String LimitPF = "//div[@role='presentation']//*[text()='" + dataTable.get("Product Family") + "']";
            WebElement LimitPFValue = getDriver().findElement(By.xpath(LimitPF));

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", LimitPFValue);
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            LimitPFValue.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
        closeDropDown.click();
    }

//    public void clickEditProductFamily(DataTable table) {
//        EditProductFamilyValues.waitUntilVisible();
//        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EditProductFamilyValues);
//
//        EditProductFamilyValues.waitUntilClickable().click();
//        withAction().pause(Duration.ofSeconds(1)).build().perform();
//        ProductFamilyDropDown.click();
//        withAction().pause(Duration.ofSeconds(1)).build().perform();
//        toggleProductFamilyCheckboxesToMatch(table);
//
//        try {
//            closeDropDown.waitUntilClickable().click();
//        } catch (Exception e) {
//            getJavascriptExecutorFacade().executeScript("arguments[0].click();", closeDropDown);
//        }
//    }

    public void clickEditProductFamily(DataTable table) {
        log.info("Clicking Edit for Product Family...");

        // 1. Scroll and click the Edit icon on the grid
        EditProductFamilyValues.waitUntilVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EditProductFamilyValues);
        try {
            EditProductFamilyValues.waitUntilClickable().click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", EditProductFamilyValues);
        }
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        // 2. Focus the dropdown input and force it open
        ProductFamilyDropDown.waitUntilPresent(); // Use present instead of visible in case it's visually hidden

        try {
            ProductFamilyDropDown.waitUntilClickable().click();
            ProductFamilyDropDown.sendKeys(Keys.ARROW_DOWN);
        } catch (Exception e) {
            log.info("Native click or sendKeys blocked. Falling back to JS Click and Action Keys.");

            // Force the click via JS
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", ProductFamilyDropDown);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            // Because the JS click put the browser's focus on the dropdown wrapper,
            // we can safely send the ARROW_DOWN key directly to the active window focus!
            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
        }

        withAction().pause(Duration.ofSeconds(2)).build().perform(); // Wait for list to render

        // 3. Automatically uncheck old values, check new values
        toggleProductFamilyCheckboxesToMatch(table);

        // 4. Close the dropdown gracefully
        try {
            withAction().sendKeys(Keys.ESCAPE).build().perform(); // Use action escape for the same reason
            withAction().pause(Duration.ofMillis(500)).build().perform();
        } catch (Exception e) {
            log.warn("Escape key failed on dropdown");
        }

        try {
            if (closeDropDown.isPresent() && closeDropDown.isCurrentlyVisible()) {
                closeDropDown.waitUntilClickable().click();
            }
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", closeDropDown);
        }
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public void clickEditProductFamily_DF(DataTable table) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", EditProductFamilyValues_DF);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        EditProductFamilyValues_DF.click();
        toggleProductFamilyCheckboxesToMatch(table);
        closeDropDown.click();
    }
    public void editLimitScopeProductFamily(DataTable table) {
        // 1. Extract data from Cucumber DataTable
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String productFamilyValue = data.get(0).get("Product Family").trim();

        // 2. Locate the Edit Icon
        // Using contains() because the data-testid has a dynamic GUID appended to it
        String editIconXPath = "(//button[contains(@data-testid, 'limit-line-action-toggle-btn')])[1]";
        WebElementFacade editButton = find(By.xpath(editIconXPath));

        // Scroll to the Edit icon and click it
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", editButton);
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        try {
            editButton.waitUntilClickable().click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", editButton);
        }

        log.info("Clicked on Limit Scope Edit icon.");
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        // 3. Locate the Product Family Input field
        // Targeting the input specifically inside the product-family multiselect container
        String inputXPath = "//div[contains(@data-testid, 'limit-line-multiselect-product-family')]//input";
        WebElementFacade productFamilyInput = find(By.xpath(inputXPath));

        // Scroll to input just in case
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productFamilyInput);
        withAction().pause(Duration.ofMillis(500)).build().perform();

        // 4. Clear existing data and type the new value
        try {
            productFamilyInput.waitUntilClickable().click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", productFamilyInput);
        }

        // Clear existing value using Ctrl+A and Backspace (Best practice for React/MUI inputs)
        productFamilyInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        withAction().pause(Duration.ofMillis(500)).build().perform();

        // Type the desired value ("Cash")
        productFamilyInput.sendKeys(productFamilyValue);

        // Wake up React to trigger the dropdown API
        productFamilyInput.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
        withAction().pause(Duration.ofSeconds(3)).build().perform(); // Wait for dropdown to render

        // 5. Select the option from the MUI Dropdown
        String dropdownOptionXPath = "//li[@role='option' and contains(normalize-space(), '" + productFamilyValue + "')]";
        WebElementFacade optionToSelect = find(By.xpath(dropdownOptionXPath));

        try {
            optionToSelect.waitUntilVisible().click();
        } catch (Exception e) {
            getJavascriptExecutorFacade().executeScript("arguments[0].click();", optionToSelect);
        }
        log.info("Successfully selected Product Family: {}", productFamilyValue);

        // 6. Close the dropdown (since it is a multi-select, it often stays open after clicking)
        getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    public void editProductFamily4Way(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", productFamilyPopupToggle_4Way);
        withAction().moveToElement(productFamilyPopupToggle_4Way).click().build().perform();
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        String listboxId = productFamilyMultiSelectInput_4Way.getAttribute("aria-controls");
        if (listboxId == null || listboxId.isEmpty()) {
            Assert.fail("Product family dropdown did not open (no aria-controls attribute on the input) -- cannot select any options.");
        }

        for (Map<String, String> dataTable : data) {
            String desiredLabel = dataTable.get("Product Family").trim();
            String optionXpath = "(//*[@id='" + listboxId + "']//*[normalize-space(.)='" + desiredLabel + "'])[last()]";
            List<WebElement> matches = getDriver().findElements(By.xpath(optionXpath));
            if (matches.isEmpty()) {
                Assert.fail("Could not find Product Family option matching '" + desiredLabel
                        + "' inside listbox '" + listboxId + "'. The dropdown's option markup may"
                        + " differ from what this method expects -- inspect the open dropdown directly to confirm.");
            }
            WebElement row = matches.get(0);
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block:'center'});", row);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            try {
                row.click();
            } catch (Exception clickEx) {
                getJavascriptExecutorFacade().executeScript("arguments[0].click();", row);
            }
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }
        closeDropDown.click();
    }

    private void toggleProductFamilyCheckboxesToMatch(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Set<String> desiredFamilies = new HashSet<>();
        for (Map<String, String> row : data) {
            desiredFamilies.add(row.get("Product Family").trim());
        }

        withAction().pause(Duration.ofSeconds(1)).build().perform();
        List<WebElement> optionRows = getDriver().findElements(By.xpath("//li[.//input[@type='checkbox']]"));

        for (WebElement row : optionRows) {
            String label = row.getText().trim();
            if (label.equalsIgnoreCase("Select All")) {
                continue; // toggling this would flip every option at once
            }

            WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));
            boolean isChecked = checkbox.isSelected();
            boolean shouldBeChecked = desiredFamilies.contains(label);

            if (isChecked != shouldBeChecked) {
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block:'center'});", row);
                row.click();
                withAction().pause(Duration.ofMillis(500)).build().perform();
            }
        }
    }

    public void clickSelectExcludeCLS(DataTable ExcludeCLS) {
        List<Map<String, String>> data = ExcludeCLS.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", excludeCLS_tab);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            withAction().moveToElement(excludeCLS_tab).click().sendKeys(dataTable.get("Exclude CLS")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Exclude CLS-->" + e);
            Assert.fail();
        }
    }

    public void copyLimitLine(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable = data.get(0);

        try {
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            String lastLimitXpath = "//tbody[@data-testid='limit-line-table-body']//tr[last()]//td[contains(@class, 'limit-cell-limitValue')]//input";
            WebElementFacade lastLimitInput = find(By.xpath(lastLimitXpath)).waitUntilPresent().waitUntilClickable();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", lastLimitInput);
            lastLimitInput.click();
            lastLimitInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            lastLimitInput.type(dataTable.get("Limit Value"));
            String lastBullionXpath = "//tbody[@data-testid='limit-line-table-body']//tr[last()]//td[contains(@class, 'limit-cell-bullionTrades')]//input";
            WebElementFacade lastBullionInput = find(By.xpath(lastBullionXpath)).waitUntilPresent().waitUntilClickable();
            lastBullionInput.click();
            lastBullionInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            lastBullionInput.sendKeys(dataTable.get("Bullion Trades"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            lastBullionInput.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            log.info("Successfully updated the copied limit line (last row) with new values.");
            withAction().pause(Duration.ofSeconds(1)).build().perform();

        } catch (Exception e) {
            log.error("Unable to update copied limit line --> " + e.getMessage());
            Assert.fail("Failed to update copied limit line: " + e.getMessage());
        }
    }

    public void clickPreviewAndSubmit() {
        previewAndSubmit_tab.waitUntilVisible().click();
        act.pause(Duration.ofSeconds(2)).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
        submitforapproval_btn.waitUntilVisible().click();
        act.pause(Duration.ofSeconds(3)).build().perform();
    }

    public void clickPreviewAndSubmitTab() {
        try {
            if (Save_IconDF.isPresent() && Save_IconDF.isCurrentlyVisible()) {
                log.info("Found unsaved DF limit/auth line (Save_IconDF is visible). Saving it automatically first.");
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Save_IconDF);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Save_IconDF.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            } else if (Save_Icon.isPresent() && Save_Icon.isCurrentlyVisible()) {
                log.info("Found unsaved limit/auth line (Save_Icon is visible). Saving it automatically first.");
                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Save_Icon);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                Save_Icon.click();
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.warn("Attempted to auto-save limit line before preview and submit, but got exception: " + e.getMessage());
        }

        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", previewAndSubmit_tab);
        previewAndSubmit_tab.waitUntilVisible();
        previewAndSubmit_tab.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public void clickLimitScope() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", LimitScope_tab);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        LimitScope_tab.waitUntilVisible().click();
    }

    public void clickUSPRider() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", USPRider_tab);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        USPRider_tab.waitUntilVisible().click();
    }

    public void DeleteAll_AuthLines() {
        for (WebElementFacade deleteButton : Delete_AuthLine) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", deleteButton);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            deleteButton.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }
    }

    public void clickCopyIcon() {
        act.pause(Duration.ofSeconds(5)).build().perform();
        copy_icon.waitUntilVisible().click();
    }

    public void noCopyIcon() {
        try {
            copy_icon.isDisplayed();
        } catch (NoSuchElementException e) {
            log.error("Element does not exist " + e);
        }
    }

    public boolean validateApprovalWorkflowForCopiedDocument() {
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        String text = PB_value.getText();
        return text.equalsIgnoreCase("Drag and Drop here the participant");
    }

    public void clickCancel_icon() {
        cancelDocument.waitUntilVisible();
        cancelDocument.waitUntilClickable().click();
        log.info("Clicked on cancel icon");
        YES_Btn_confirm_cancel_document.waitUntilVisible();
        YES_Btn_confirm_cancel_document.waitUntilClickable().click();
        withAction().pause(Duration.ofSeconds(6)).build().perform();

    }

    public void validateLimitScope() {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            // 1. Locate the first row of the Limit Scope table robustly
            String rowXpath = "//tbody[contains(@class, 'MuiTableBody')]//tr[1] | //tbody[@data-testid='limit-line-table-body']//tr[1]";
            WebElementFacade limitRow = find(By.xpath(rowXpath));

            Assert.assertTrue("Limit Scope table row is not visible.", limitRow.isVisible());

            // 2. Fetch Calculation Type from the 1st column's input
            WebElementFacade calTypeInput = limitRow.find(By.xpath(".//td[1]//input"));
            String actualCalType = calTypeInput.getAttribute("value").trim();

            Assert.assertEquals("Calculation Type mismatch in Limit Scope!", "DSL", actualCalType);

            // 3. Fetch Limit Value from the 2nd column's input
            WebElementFacade limitValueInput = limitRow.find(By.xpath(".//td[2]//input"));
            String actualLimitValue = limitValueInput.getAttribute("value").trim();

            Assert.assertTrue("Limit Value mismatch! Found: " + actualLimitValue, actualLimitValue.contains("999,999,999"));

        } catch (Exception e) {
            log.error("Limit Scope value validation failed --> " + e.getMessage());
            Assert.fail("Limit Scope validation failed: " + e.getMessage());
        }
    }
    public void validateEmailText() {
        act.pause(Duration.ofSeconds(2)).build().perform();
        String lite_text = lite_email_text.getText();
        Assert.assertEquals("+ Notification recipient email ID", lite_text);
    }

    public void refresh_and_validate() {
        withAction().pause(Duration.ofSeconds(30)).build().perform();
        getDriver().navigate().refresh();
        createNewDocument.waitUntilVisible();
        act.pause(Duration.ofSeconds(5)).build().perform();
        String doc_status = status.getText();
        Assert.assertEquals("Enforced", doc_status);
    }

    public void wait_and_refresh() {
        withAction().pause(Duration.ofSeconds(30)).build().perform();
        getDriver().navigate().refresh();
        createNewDocument.waitUntilVisible();
        act.pause(Duration.ofSeconds(5)).build().perform();
    }

    public void CheckDocumentTerms() {
        DocumentTerms.waitUntilVisible();
        Assert.assertTrue(DocumentTerms.isVisible());
    }

    public void approveDocument() {
        approveDocument.waitUntilVisible().click();
        approveButton.waitUntilVisible().click();
    }

    public void approvalGroupSelect() {
        approvalGroupDropDown.waitUntilVisible().click();
        act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
        approveButton.waitUntilVisible().click();
    }

    public void CheckDocumentTermsComparison() {
        act.pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", DocTermsList.get(0));
        act.pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocTermsList.get(0).isVisible());
    }

    public void CheckDocumentTermsOnViewAsPdf() {
        act.pause(Duration.ofSeconds(1)).build().perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", DocumentTermsViewasPDF.get(0));
        act.pause(Duration.ofSeconds(1)).build().perform();
        Assert.assertTrue(DocumentTermsViewasPDF.get(0).isVisible());
    }

    public void PreviewAndSubmit() {
        previewAndSubmit_tab.waitUntilVisible().click();
    }

    public void CheckDocumentTermsTab() {
        DocumentTermstab.waitUntilVisible();
        Assert.assertTrue(DocumentTermstab.isVisible());
    }

    // Started from hare
    public void templatesDropdown() {
        select_temp_dropdown.waitUntilVisible();
        try {
            select_temp_dropdown.isVisible();
            select_temp_dropdown.isClickable();
        } catch (Exception e) {
            log.error("Drop down is not Visible-->" + e);
            Assert.fail();
        }
    }

    public void SelectTemplates(DataTable Templates) {
        List<Map<String, String>> data = Templates.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            select_temp_input_box.isVisible();
            withAction().moveToElement(select_temp_input_box).click().sendKeys(dataTable.get("Templates")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            log.info("Template selected successfully");

        } catch (Exception e) {
            log.error("Template is not in list-->" + e);
            Assert.fail();
        }
    }

    public void verify_temp_preview() {
        temp_preview.isVisible();
        log.info("Template preview is visible");
    }

    public void verify_prefilled_data() {
        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approval_workflow);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            approval_workflow.waitUntilVisible();
            approval_workflow.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            approval_workflow_template_data.isDisplayed();
            approval_workflow.click();
        } catch (Exception e) {
            log.error("Unable to open Approval workflow -->" + e);
            Assert.fail();
        }
        try {
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", enforcement_rule);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            enforcement_rule.waitUntilVisible();
            enforcement_rule.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Assert.assertEquals(3, enforcement_rule_template_data.size());
            enforcement_rule.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.error("Unable to open Enforcement workflow -->" + e);
            Assert.fail();
        }

        try {
            document_term.waitUntilVisible();
            document_term.click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            document_term_templateData.isDisplayed();
            document_term.click();
        } catch (Exception e) {
            log.error("Unable to open Document Terms workflow -->" + e);
            Assert.fail();
        }
    }

    public void Validate_Add_currency_from_AuthScope(List<String> updated_currencyList) {
        try {
            AuthScope_tab.waitUntilVisible();
            AuthScope_tab.click();
        } catch (Exception e) {
            log.error("Unable to click AuthScope-->" + e);
            Assert.fail();
        }

        try {
            add_currency_btn.waitUntilVisible();
            add_currency_btn.click();
        } catch (Exception e) {
            log.error("Unable to click add currency button-->" + e);
            Assert.fail();
        }

        for (int begin = 1; begin < updated_currencyList.size(); begin++) {
            searchSelectCurrency.waitUntilVisible();
            searchSelectCurrency.clear();
            searchSelectCurrency.type(updated_currencyList.get(begin));
            if (searchedCurrency.isVisible()) {
                searchedCurrency.click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            } else {
                Assert.assertTrue(currency_nodata.isVisible());
            }
        }
    }

    public void Validate_Remove_currency_from_AuthScope(List<String> remove_currencyList) {

        for (int begin = 1; begin < remove_currencyList.size(); begin++) {
            searchRemoveCurrency.waitUntilVisible();
            searchRemoveCurrency.clear();
            searchRemoveCurrency.type(remove_currencyList.get(begin));
            if (searchedRemoveCurrency.isVisible()) {
                withAction().pause(Duration.ofSeconds(3)).build().perform();
                searchedRemoveCurrency.click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            } else if (currency_nodata.isVisible()) {
                continue;
            }
        }

    }

    public void validate_EmailPopup(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            liteUserAlertPopup.waitUntilVisible();
            Assert.assertTrue(liteUserAlertPopup.isVisible());
            withAction().moveToElement(enterEmail1_input).click().sendKeys(dataTable.get("Enter Email 1")).pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            submit_btn.click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            log.info("Document created successfully with lite user");
        } catch (Exception e) {
            log.error("Unable to create document with lite user" + e);
            Assert.fail();
        }
    }

    public void randomEnterPrimeBroker2() {
        try {
            Random random = new Random();
            int randNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(selectPB2).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error(" Unable to Select Client 1 " + e);
            Assert.fail();
        }

    }

    public void randomEnterClient1() {
        try {
            Random random = new Random();
            int randNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(selectClient1).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error(" Unable to Select Client 1 " + e);
            Assert.fail();
        }

    }

    public void randomEnterClient2() {
        try {
            Random random = new Random();
            int randNumber = Math.abs(random.nextInt(10));
            log.info("randomNumber" + randNumber);
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            withAction().moveToElement(selectClient2).click().build().perform();
            for (int i = 1; i < randNumber; i++) {
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
            }
            withAction().sendKeys(Keys.RETURN).build().perform();
        } catch (Exception e) {
            log.error(" Unable to Select Client 1 " + e);
            Assert.fail();
        }

    }

    public void selectDocumentStatus(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        DocumentStatus_Column_Input.waitUntilVisible();
        DocumentStatus_Column_Input.clear();
        act.moveToElement(DocumentStatus_Column_Input).click().sendKeys(dataTable.get("Document Status")).pause(Duration.ofSeconds(2)).build().perform();
        act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
    }

    public void selectLifecycleStatus(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        LifecycleStatus_Column_Input.waitUntilVisible();
        LifecycleStatus_Column_Input.clear();
        act.moveToElement(LifecycleStatus_Column_Input).click().sendKeys(dataTable.get("Lifecycle status")).pause(Duration.ofSeconds(2)).build().perform();
        act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
//        withAction().pause(Duration.ofSeconds(5)).build().perform();
    }

    public void deleteAuthLines() {
        for (WebElementFacade Dlt : AuthScope_Delete_Icon) {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Dlt);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            Dlt.waitUntilVisible().click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        }

    }

    public boolean NoAuthlines() {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        boolean authDisplay = false;
        try {
            allowedCurrencyBullion.isDisplayed();
        } catch (NoSuchElementException exception) {
            authDisplay = true;
        }
        return authDisplay;
    }

    public int Validate_CommonNotes() {
        String randomString = RandomStringUtils.randomAlphanumeric(1002);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Common_Notes);
        act.moveToElement(Common_Notes).click().sendKeys(randomString).pause(Duration.ofSeconds(2)).build().perform();
        return Common_Notes_Textarea.getText().length();
    }

    public int Validate_ContactField() {
        String randomString = RandomStringUtils.randomAlphanumeric(410);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", Contact_field_PB);
        act.moveToElement(Contact_field_PB).click().sendKeys(randomString).pause(Duration.ofSeconds(2)).build().perform();
        return Contact_field_PB.getText().length();
    }

    public void CreatedOnLocalTime() {
        Calendar cal = Calendar.getInstance();
        WebElementFacade currentDate;
        String Month = ApprovalAgreementCreatePageObject.theMonth(cal.get(Calendar.MONTH));

        // 1. Reset scroll to the far left to start from a clean state
        getJavascriptExecutorFacade().executeScript(
                "let wrapper = document.querySelector('.conditional-scrollable') || document.querySelector('.doclist-content');" +
                        "if(wrapper) { wrapper.scrollLeft = 0; }"
        );
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        // 2. INCREMENTAL SCROLL: Scroll right slowly until React renders the column
        boolean isElementFound = false;
        for (int i = 0; i < 20; i++) { // Try scrolling up to 20 times
            if (CreatedOnLocalTimeDatePicker.isPresent() && CreatedOnLocalTimeDatePicker.isCurrentlyVisible()) {
                isElementFound = true;
                break; // Found it! Stop scrolling.
            }

            // Scroll right by 300 pixels
            getJavascriptExecutorFacade().executeScript(
                    "let wrapper = document.querySelector('.conditional-scrollable') || document.querySelector('.doclist-content');" +
                            "if(wrapper) { wrapper.scrollBy(300, 0); }"
            );
            // Crucial wait to let the React virtual DOM render the new columns
            withAction().pause(Duration.ofMillis(500)).build().perform();
        }

        if (!isElementFound) {
            org.junit.Assert.fail("Could not find the 'Created On (Local Time)' column even after scrolling the table.");
        }

        // 3. Center it and click
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", CreatedOnLocalTimeDatePicker);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        CreatedOnLocalTimeDatePicker.waitUntilClickable().click();

        // Wait for the calendar pop-up to render
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        // 4. Select the specific date
        if (cal.get(Calendar.DATE) < 10) {
            currentDate = find(By.xpath("//span[contains(text(),'" + Month + "')]/ancestor::div[@class='react-minimal-datetime-range-calendar__header']//following-sibling::div//div[text()='0" + cal.get(Calendar.DATE) + "' and contains(@class,'today')]"));
        } else {
            currentDate = find(By.xpath("//span[contains(text(),'" + Month + "')]/ancestor::div[@class='react-minimal-datetime-range-calendar__header']//following-sibling::div//div[text()='" + cal.get(Calendar.DATE) + "' and contains(@class,'today')]"));
        }

        // Perform the double-click for range selection
        currentDate.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        currentDate.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }
    public void CreatedOnUTCTime() {
        Calendar cal = Calendar.getInstance();
        WebElementFacade currentDate;
        String Month = ApprovalAgreementCreatePageObject.theMonth(cal.get(Calendar.MONTH));
//        String date = cal.get(Calendar.DATE)+Month +cal.get(Calendar.YEAR);
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", CreatedOnUTCTimeDatePicker);
        getJavascriptExecutorFacade().executeScript("window.scrollBy(20,-100)");
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        CreatedOnUTCTimeDatePicker.click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        if (cal.get(Calendar.DATE) < 10) {
            currentDate = find(By.xpath("//span[contains(text(),'" + Month + "')]/ancestor::div[@class='react-minimal-datetime-range-calendar__header']//following-sibling::div//div[text()='0" + cal.get(Calendar.DATE) + "']"));
        } else {
            currentDate = find(By.xpath("//span[contains(text(),'" + Month + "')]/ancestor::div[@class='react-minimal-datetime-range-calendar__header']//following-sibling::div//div[text()='" + cal.get(Calendar.DATE) + "']"));
        }
        currentDate.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        currentDate.waitUntilVisible().click();
        withAction().pause(Duration.ofSeconds(1)).build().perform();
    }

    public boolean validateNoProhibited_Error() {
        boolean result = false;
        try {
            DN_opr_prohibited_warning.isDisplayed();
        } catch (NoSuchElementException e) {
            result = true;
        }
        return result;
    }

    public void EnterGeneralTerms(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Calendar cal = Calendar.getInstance();
        String date = String.valueOf(cal.get(Calendar.DATE));
        for (Map<String, String> dataTable : data) {
            WebElement element = getDriver().findElement(By.xpath("//*[text()='" + dataTable.get("Date") + "']/..//input"));
//            WebElement element = getDriver().findElement(By.xpath("//div[contains(text(),'" + dataTable.get("Date") + "')]/..//input"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
            element.click();
            WebElement currentDate = getDriver().findElement(By.xpath("(//div[@class='react-datepicker__week']//div[text()='" + date + "'])[1]"));
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            currentDate.click();
        }
    }

    public boolean validateGeneralTerms(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        boolean result = false;
        Calendar cal = Calendar.getInstance();
        String expectedDate = String.valueOf(cal.get(Calendar.DATE));
        for (Map<String, String> dataTable : data) {
            WebElement element = getDriver().findElement(By.xpath("//*[text()='" + dataTable.get("Date") + "']/..//input"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            if (dataTable.get("Value").equalsIgnoreCase("Current Date")) {
                String[] actualDate = element.getDomAttribute("value").split("-");
                if (actualDate[2].equalsIgnoreCase(expectedDate)) {
                    result = true;
                }
            } else {
                if (element.getDomAttribute("value").equalsIgnoreCase(dataTable.get("Value"))) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean validateGeneralTermsOnDocumentPreview(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        boolean result = false;
        Calendar cal = Calendar.getInstance();
        String expectedDate = String.valueOf(cal.get(Calendar.DATE));
        for (Map<String, String> dataTable : data) {
            WebElement element = getDriver().findElement(By.xpath("//div[contains(text(),'" + dataTable.get("Date") + "')]//following-sibling::div"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            if (dataTable.get("Value").equalsIgnoreCase("Current Date")) {
                String[] actualDate = element.getText().split("-");
                if (actualDate[2].equalsIgnoreCase(expectedDate)) {
                    result = true;
                }
            } else {
                if (element.getText().equalsIgnoreCase(dataTable.get("Value"))) {
                    result = true;
                }
            }
        }
        return result;
    }

    public void validateLimitLine(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        withAction().pause(Duration.ofSeconds(2)).build().perform();

        for (Map<String, String> dataTable : data) {
            StringBuilder dynamicXpath = new StringBuilder("//tr");
            for (Map.Entry<String, String> entry : dataTable.entrySet()) {
                String expectedValue = entry.getValue();
                if (expectedValue != null && !expectedValue.trim().isEmpty()) {
                    dynamicXpath.append("[.//td[contains(normalize-space(.), '")
                            .append(expectedValue.trim())
                            .append("')]]");
                }
            }
            WebElement limitRow = getDriver().findElement(By.xpath(dynamicXpath.toString()));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", limitRow);
            org.junit.Assert.assertTrue("Limit line matching the provided criteria was not found or displayed.", limitRow.isDisplayed());
        }
    }

    public void validateLimitLineDeleted(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        try {
            for (Map<String, String> dataTable : data) {
                getDriver().findElement(By.xpath(
                        "//*[text()='" + dataTable.get("Calculation Type") + "']" +
                                "/following-sibling::td[text()='" + dataTable.get("Netting Type") + "']" +
                                "/following-sibling::td[text()='" + dataTable.get("Bullion trades") + "']" +
                                "/following-sibling::td[text()='" + dataTable.get("Delta") + "']" +
                                "/following-sibling::td[text()='" + dataTable.get("Product Family") + "']"
                )).isDisplayed();
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateAuthLineAdded(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        for (Map<String, String> dataTable : data) {
            Object productValue = dataTable.get("Product");
            if (productValue != null) {
                getDriver().findElement(By.xpath(
                        "(//*[normalize-space(.) = '" + dataTable.get("Asset Class") + " " +
                                dataTable.get("Product Family") + " " +
                                dataTable.get("Product") + "'])[1]"
                )).isDisplayed();
            } else {
                getDriver().findElement(By.xpath(
                        "(//*[normalize-space(.) = '" + dataTable.get("Asset Class") + " " +
                                dataTable.get("Product Family") + "'])[1]"
                )).isDisplayed();
            }
        }
    }

    public void validateAuthLineDeleted(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        try {
            for (Map<String, String> dataTable : data) {
                getDriver().findElement(By.xpath(
                        "//*/text()[normalize-space(.)='" + dataTable.get("Asset Class") + " " +
                                dataTable.get("Product Family ") + " " +
                                dataTable.get("Product") + "']"
                )).isDisplayed();
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public void firstDocumentID() {
        try {
            firstDocID.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
            String documentIdToSearch = firstDocID.getText().trim();
            DocumentIDsearchBox.waitUntilClickable();
            DocumentIDsearchBox.clear();
            DocumentIDsearchBox.type(documentIdToSearch);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Failed to capture and search for the first document ID: " + e.getMessage());
            Assert.fail("Could not search for the first document ID from the list.");
        }
    }

    public void validateText(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable : data) {
            getDriver().findElement(By.xpath("//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("Text").toLowerCase() + "']"));
        }
    }

    public void validateTextInPreview(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable : data) {
            getDriver().findElement(By.xpath("//div[@class='preview-content']//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + dataTable.get("Text").toLowerCase() + "']"));
        }
    }

    public void ValidateTextNotdisplayed(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable : data) {
            try {
                getDriver().findElement(By.xpath("//*[contains(text(),'" + dataTable.get(0) + "')]")).isDisplayed();
            } catch (NoSuchElementException e) {
                Assert.assertTrue(true);
            }
        }
    }

    public void getCurrentDate() {
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        int currentDate = today.getDayOfMonth();
        WebElement currentDateInPicker = getDriver().findElement(By.xpath("//div[text()='" + currentDate + "']"));
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        withAction().moveToElement(currentDateInPicker).click().build().perform();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }

    public boolean VerifyCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);
        return CurrentDate_picker_InputField.getValue().equalsIgnoreCase(formattedDate);
    }

    public boolean DF_ISDA(DataTable table) {
        boolean status = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> dataTable : data) {
            status = DF_ISDA_Date_Picker.getValue().equalsIgnoreCase(dataTable.get("date"));
        }
        return status;
    }

    public void validateDocumentData() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String expectedDate = dateFormat.format(cal.getTime()); // Example: "09/29/2026"

        try {
            // Wait for the table body to render
            find(By.xpath("//tbody[@data-testid='doc-table-tbody']")).waitUntilVisible();
            // 1. Last Updated On (Local Time)
            WebElementFacade lastUpdatedLocal = find(By.xpath("//span[contains(@data-testid, 'cell-default-updatedOnLocal-')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", lastUpdatedLocal);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            String actualLastUpdatedLocal = lastUpdatedLocal.getAttribute("textContent").trim().split(",")[0].trim();
            Assert.assertEquals("Last Updated On (Local Time) mismatch", expectedDate, actualLastUpdatedLocal);
            // 2. Last Updated On (UTC Time)
            WebElementFacade lastUpdatedUTC = find(By.xpath("//span[contains(@data-testid, 'cell-default-updatedOnUtc-')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", lastUpdatedUTC);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            String actualLastUpdatedUTC = lastUpdatedUTC.getAttribute("textContent").trim().split(",")[0].trim();
            Assert.assertEquals("Last Updated On (UTC Time) mismatch", expectedDate, actualLastUpdatedUTC);
            // 3. Created On (UTC Time)
            WebElementFacade createdOnUTC = find(By.xpath("//span[contains(@data-testid, 'cell-default-createdOnUtc-')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", createdOnUTC);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            String actualCreatedOnUTC = createdOnUTC.getAttribute("textContent").trim().split(",")[0].trim();
            Assert.assertEquals("Created On (UTC Time) mismatch", expectedDate, actualCreatedOnUTC);
            // 4. Created On (Local Time)
            WebElementFacade createdOnLocal = find(By.xpath("//span[contains(@data-testid, 'cell-default-createdOnLocal-')]"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", createdOnLocal);
            withAction().pause(Duration.ofMillis(500)).build().perform();
            String actualCreatedOnLocal = createdOnLocal.getAttribute("textContent").trim().split(",")[0].trim();
            Assert.assertEquals("Created On (Local Time) mismatch", expectedDate, actualCreatedOnLocal);
            log.info("Successfully validated all Dashboard Dates against expected date: " + expectedDate);
        } catch (Exception e) {
            log.error("Failed to extract or validate date columns on the Dashboard. Error: " + e.getMessage());
            Assert.fail("Date validation failed: " + e.getMessage());
        }
    }

//    public void EditLimitLine(String LimitValue) {
//        for (WebElementFacade eachLimitLine : EditLimitLine) {
//            eachLimitLine.click();
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            InputLimitLineValue.click();
//            if (!InputLimitLineValue.getAttribute("value").equalsIgnoreCase("$0")) {
//                InputLimitLineValue.clear();
//            }
//            InputLimitLineValue.sendKeys(LimitValue);
//            withAction().pause(Duration.ofSeconds(2)).build().perform();
//            SaveLimitLineValue.click();
//        }
//    }

    @FindBy(xpath = "//input[contains(@class, 'limit-input') or starts-with(@data-testid, 'limit-line-input-value-') or contains(@placeholder, 'Limit value')]")
    private List<WebElementFacade> inlineLimitValueInputs;

    public void EditLimitLine(String limitValue) {
        log.info("Editing Limit Lines inline to: " + limitValue);

        for (WebElementFacade input : inlineLimitValueInputs) {
            try {
                boolean isInputDisabled = input.isDisabled() || 
                        (Boolean) evaluateJavascript("return arguments[0].disabled || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-disabled')) || arguments[0].hasAttribute('disabled');", input);
                if (isInputDisabled) {
                    log.info("Skipping disabled limit line input...");
                    continue;
                }

                getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", input);
                withAction().pause(Duration.ofMillis(500)).build().perform();

                try {
                    input.waitUntilClickable().click();
                } catch (Exception e) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", input);
                }

                input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, limitValue, Keys.TAB);
                withAction().pause(Duration.ofSeconds(1)).build().perform();

                try {
                    if (SaveLimitLineValue.isCurrentlyVisible()) {
                        getJavascriptExecutorFacade().executeScript("arguments[0].click();", SaveLimitLineValue);
                        withAction().pause(Duration.ofSeconds(1)).build().perform();
                    }
                } catch (Exception ignored) {}
            } catch (Exception e) {
                log.warn("Failed to edit limit line row, skipping: " + e.getMessage());
            }
        }
    }

    public void EnableLimitLine() {
        try {
            // Check if 'Include all limit lines' master switch exists and is not already checked
            List<WebElement> masterSwitches = getDriver().findElements(By.xpath(
                "//*[normalize-space(text())='Include all limit lines']/ancestor::*[self::label or self::div or contains(@class,'switch')][1]//input[@type='checkbox'] " +
                "| //*[normalize-space(text())='Include all limit lines']/following::input[@type='checkbox'][1]"
            ));

            if (!masterSwitches.isEmpty()) {
                WebElement master = masterSwitches.get(0);
                boolean isMasterChecked = (Boolean) evaluateJavascript(
                    "return arguments[0].checked === true || !!arguments[0].closest('.MuiSwitch-root, .MuiSwitch-switchBase, span')?.classList.contains('Mui-checked');",
                    master
                );
                if (!isMasterChecked) {
                    evaluateJavascript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", master);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    evaluateJavascript("arguments[0].click();", master);
                    withAction().pause(Duration.ofSeconds(2)).build().perform();
                    log.info("[DEBUG] 'Include all limit lines' master switch clicked to enable.");
                    return;
                } else {
                    log.info("[DEBUG] 'Include all limit lines' is already checked.");
                    return;
                }
            }
        } catch (Exception e) {
            log.warn("[DEBUG] Error checking master 'Include all limit lines' switch: " + e.getMessage());
        }

        // Fallback: If no master switch, enable any unchecked limit line switches individually without double-clicking
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        String rowSwitchesXPath = "//tbody//tr//*[contains(@class,'MuiSwitch-root')]//input[@type='checkbox'] | //table//tr//div[contains(@class,'enable-switch')]//input[@type='checkbox']";
        int listSize = getDriver().findElements(By.xpath(rowSwitchesXPath)).size();
        if (listSize == 0) {
            log.warn("No limit lines were found in the table body to enable.");
        }
        for (int i = 0; i < listSize; i++) {
            boolean success = false;
            int retries = 0;
            while (!success && retries < 3) {
                try {
                    WebElement element = getDriver().findElements(By.xpath(rowSwitchesXPath)).get(i);
                    evaluateJavascript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                    boolean isChecked = element.isSelected() || (Boolean) evaluateJavascript(
                        "return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));",
                        element
                    );
                    if (!isChecked) {
                        evaluateJavascript("arguments[0].click();", element);
                        withAction().pause(Duration.ofSeconds(1)).build().perform();
                        log.info("[DEBUG] Toggled unchecked limit line switch to enabled.");
                    }
                    success = true;
                } catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
                    retries++;
                    withAction().pause(Duration.ofSeconds(1)).build().perform();
                }
            }
        }
    }

    public void EnableFirstLimitLine() {
        boolean success = false;
        int retries = 0;
        while (!success && retries < 3) {
            try {
                WebElement element = getDriver().findElement(By.xpath("(//div[contains(@class,'MuiSwitch-root')]//input[@type='checkbox'])[1]"));
                evaluateJavascript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                boolean isChecked = element.isSelected() || (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));", element);
                if (!isChecked) {
                    evaluateJavascript("arguments[0].click();", element);
                }
                success = true;
            } catch (StaleElementReferenceException e) {
                retries++;
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }
    }

    public void DisableLimitLine() {
        for (WebElementFacade disableEachLimitLine : EnableLimitLine) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", disableEachLimitLine);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            disableEachLimitLine.click();
            try {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                LimitLineEnabled.isDisabled();
            } catch (NoSuchElementException e) {
                Assert.assertTrue(true);
            }
        }
    }

    public void captureDocumentVersionID() {
        createDocVersionID.withTimeoutOf(Duration.ofSeconds(60)).waitUntilVisible();
        String versionText = createDocVersionID.getText().trim();
        Serenity.setSessionVariable("STORED_VERSION_ID").to(versionText);
        System.out.println("Captured Version ID: " + versionText);
    }

    public void waitForCreationScreen() {
        createDocVersionID.withTimeoutOf(Duration.ofSeconds(60)).waitUntilVisible();
    }

    public void verifyBulkApproveVersionMatches() {
        String previousVersionID = Serenity.sessionVariableCalled("STORED_VERSION_ID");
        String currentVersionID = bulkApproveVersionId.getText().trim();
        Assert.assertEquals("The Document Version IDs do not match!",
                previousVersionID,
                currentVersionID);
    }

    public boolean validateAuthScopeDataForDeliverableCurrencies(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        try {
            WebElement authScopeHeader = getDriver().findElement(By.xpath("//*[normalize-space(text())='Auth Scope'] | //div[contains(., 'Auth Scope') and @class='accordion-header']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", authScopeHeader);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            WebElement deliverableContainer = getDriver().findElement(By.xpath("//span[@class='deliverable-header']/parent::* | //*[contains(text(), 'Deliverable:')]"));
            String fullText = deliverableContainer.getAttribute("textContent");
            for (Map<String, String> row : data) {
                String currencyValue = row.get("Deliverable");
                if (currencyValue != null) {
                    currencyValue = currencyValue.trim();
                    if (!fullText.contains(currencyValue)) {
                        System.err.println("Validation failed. Expected currency not found: '" + currencyValue + "'");
                        System.err.println("Actual text found in container: '" + fullText + "'");
                        overallResult = false;
                    } else {
                        System.out.println("Successfully found Deliverable currency: " + currencyValue);
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println("Could not find the 'Auth Scope' header or Deliverable container in the DOM.");
            overallResult = false;
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during validation: " + e.getMessage());
            overallResult = false;
        }

        return overallResult;
    }
    public void clickSelectLimitValueForEditLimit(DataTable limitValueTable) {
        List<Map<String, String>> data = limitValueTable.asMaps(String.class, String.class);
        String newValue = data.get(0).get("Limit Value");
        try {
            limitValue_input.waitUntilClickable();
            limitValue_input.clear();
            limitValue_input.type(newValue);
            log.info("Successfully updated Limit Value to: " + newValue);
        } catch (Exception e) {
            log.error("Unable to input Limit Value --> " + e.getMessage());
            Assert.fail("Test failed due to exception in inputting Limit Value: " + e.getMessage());
        }
    }

    public boolean validateTenorValue(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        log.info("Validating Tenor values for Auth line: {}", data);

        for (Map<String, String> expectedRow : data) {
            String family = expectedRow.get("Family");
            String expectedTenor = expectedRow.get("Tenor").trim();
            String expectedType = expectedRow.get("Tenor Type").trim();

            List<WebElement> rows = getDriver().findElements(By.xpath(
                "//div[contains(@data-testid,'auth-accordion-row-root-')] | " +
                "//div[contains(@class, 'accordion') or contains(@class, 'Accordion')] | " +
                "//div[contains(@class, 'title')]/ancestor::div[contains(@class, 'accordion') or contains(@class, 'MuiAccordion') or contains(@class, 'row') or contains(@class, 'root')] | " +
                "//div[@class='title']/parent::*"
            ));

            boolean rowFound = false;

            for (WebElement row : rows) {
                try {
                    String rowText = row.getText();
                    if (rowText != null && (rowText.contains("Spot") || rowText.contains(family) || rowText.contains("FX Cash"))) {
                        List<WebElement> inputs = row.findElements(By.xpath(".//input | .//*[@role='combobox'] | .//*[contains(@class,'Select')]"));
                        List<String> values = new ArrayList<>();
                        for (WebElement el : inputs) {
                            String val = el.getAttribute("value");
                            if (val != null && !val.trim().isEmpty()) {
                                values.add(val.trim());
                            }
                            String txt = el.getText();
                            if (txt != null && !txt.trim().isEmpty()) {
                                values.add(txt.trim());
                            }
                        }
                        values.add(rowText);

                        boolean hasTenor = values.stream().anyMatch(v -> v.equalsIgnoreCase(expectedTenor) || v.contains(expectedTenor));
                        boolean hasType = values.stream().anyMatch(v -> v.equalsIgnoreCase(expectedType) || v.contains(expectedType));

                        if (hasTenor && hasType) {
                            log.info("Successfully validated Auth line for '{}': found Tenor '{}' and Tenor Type '{}'", family, expectedTenor, expectedType);
                            rowFound = true;
                            break;
                        }
                    }
                } catch (Exception ignored) {}
            }

            if (!rowFound) {
                log.info("Checking all page tenor inputs as fallback for Tenor '{}' and Type '{}'", expectedTenor, expectedType);
                List<WebElement> allInputs = getDriver().findElements(By.xpath(
                    "//input[contains(@data-testid, 'tenor') or contains(@class, 'accordion-input') or contains(@class, 'spot-value') or contains(@class, 'tenor')] | " +
                    "//div[contains(@data-testid, 'tenor')]//input | " +
                    "//div[contains(@data-testid, 'tenor')] | " +
                    "//div[contains(@class, 'tenor')]//input | " +
                    "//input"
                ));
                List<String> allValues = new ArrayList<>();
                for (WebElement el : allInputs) {
                    try {
                        String v = el.getAttribute("value");
                        if (v != null && !v.trim().isEmpty()) allValues.add(v.trim());
                        String t = el.getText();
                        if (t != null && !t.trim().isEmpty()) allValues.add(t.trim());
                    } catch (Exception ignored) {}
                }
                boolean hasTenor = allValues.stream().anyMatch(v -> v.equalsIgnoreCase(expectedTenor) || v.contains(expectedTenor));
                boolean hasType = allValues.stream().anyMatch(v -> v.equalsIgnoreCase(expectedType) || v.contains(expectedType));
                if (hasTenor && hasType) {
                    log.info("Successfully validated Tenor '{}' and Type '{}' from page inputs", expectedTenor, expectedType);
                    rowFound = true;
                }
            }

            if (!rowFound) {
                log.error("Could not find any Auth line for Family '{}' matching Tenor '{}' and Type '{}'", family, expectedTenor, expectedType);
                return false;
            }
        }
        return true;
    }

    public void editFirstTenorValue(String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String tenorInputXpath = "//input[@class='accordion-input']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tenorInputXpath)));
            List<WebElement> allTenorInputs = getDriver().findElements(By.xpath(tenorInputXpath));
            if (!allTenorInputs.isEmpty()) {
                WebElement firstTenorInput = allTenorInputs.get(0);

                getJavascriptExecutorFacade().executeScript(
                        "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });",
                        firstTenorInput
                );
                withAction().pause(Duration.ofMillis(500)).build().perform();

                firstTenorInput.click();
                withAction().pause(Duration.ofMillis(200)).build().perform();
                getJavascriptExecutorFacade().executeScript(
                        "var input = arguments[0];" +
                                "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                                "nativeInputValueSetter.call(input, '');" +
                                "input.dispatchEvent(new Event('input', { bubbles: true }));",
                        firstTenorInput
                );
                withAction().pause(Duration.ofMillis(300)).build().perform();
                withAction()
                        .moveToElement(firstTenorInput)
                        .sendKeys(value)
                        .pause(Duration.ofMillis(500))
                        .build()
                        .perform();
                log.info("Successfully updated the first Tenor value to: " + value);
            } else {
                Assert.fail("No Tenor input fields were found on the screen.");
            }
        } catch (Exception e) {
            log.error("Failed to edit the first Tenor value: " + e.getMessage());
            Assert.fail("Could not edit Auth Tenor value.");
        }
    }

    public boolean validateAuthScopeDataForNonDeliverableCurrencies(DataTable table) {
        boolean overallResult = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String currencyValue = row.get("Non-Deliverable");
            if (currencyValue != null) {
                currencyValue = currencyValue.trim();
                try {
                    WebElement nonDeliverableContainer = getDriver().findElement(
                            By.xpath("//span[@class='non-deliverable-header']/parent::*")
                    );
                    getJavascriptExecutorFacade().executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            nonDeliverableContainer
                    );
                    String fullText = nonDeliverableContainer.getText();
                    if (!fullText.contains(currencyValue)) {
                        System.out.println(
                                "Validation failed. Expected currency not found: " + currencyValue +
                                        " | Actual text: " + fullText
                        );
                        overallResult = false;
                    }
                } catch (NoSuchElementException e) {
                    System.out.println(
                            "Could not find Non-Deliverable section for currency: " + currencyValue
                    );
                    overallResult = false;
                }
            }
        }
        return overallResult;
    }

    public void validateValueNotPresentInDropdown(String leiValue, String fieldName) {
        // Maps the step-friendly field name to the data-testid key
        String key;
        switch (fieldName) {
            case "Prime Broker 1":
                key = "PB1";
                break;
            case "Executive Broker 1":
                key = "EB1";
                break;
            case "Client 1":
                key = "Client1";
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }

        try {
            log.info("Checking that '{}' is NOT in '{}'", leiValue, fieldName);

            // Locate the input using semantic data-testid wrapper attributes
            String inputXpath = String.format("//div[@data-testid='party-input-wrapper-%s']//input", key);
            WebElementFacade targetInput = find(By.xpath(inputXpath));

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", targetInput);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            targetInput.waitUntilClickable().click();

            // If the field already has a pre-filled value, clear it first.
            // Harmless no-op if the field was already empty.
            targetInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            targetInput.sendKeys(Keys.BACK_SPACE);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            targetInput.sendKeys(leiValue);
            log.info("Typed '{}' into '{}' field.", leiValue, fieldName);
            withAction().pause(Duration.ofSeconds(7)).build().perform();

            String menuItemsXpath = "//*[contains(@class, 'menu') or contains(@class, 'results')]//*[text()='" + leiValue + "']";
            List<WebElement> matchingOptions = getDriver().findElements(By.xpath(menuItemsXpath));

            log.info("Dropdown check for '{}' -> Options found: {}", leiValue, matchingOptions.size());

            if (matchingOptions.isEmpty()) {
                log.info("Success: '{}' was NOT found in '{}' (filtered correctly).", leiValue, fieldName);
                act.sendKeys(Keys.ESCAPE).build().perform();
            } else {
                log.error("Failure: '{}' was FOUND in '{}'.", leiValue, fieldName);
                Assert.fail("Data Source Error: '" + leiValue + "' found in '" + fieldName + "' dropdown when it should be hidden.");
            }

        } catch (Exception e) {
            log.error("Error during dropdown validation for '{}': {}", fieldName, e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }

    public boolean validateAttributeIsSelected(DataTable table) {
        boolean allSelected = true;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        for (Map<String, String> selectedAttribute : data) {
            String attr = selectedAttribute.get("Attributes").trim();
            String xpath = "//*[text()='" + attr + "']//input | " +
                           "//*[normalize-space(text())='" + attr + "']/ancestor::label//input | " +
                           "//*[normalize-space(text())='" + attr + "']/..//input | " +
                           "//label[contains(., '" + attr + "')]//input";

            WebElement attribute;
            try {
                attribute = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            } catch (Exception ex) {
                attribute = getDriver().findElement(By.xpath(xpath));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", attribute);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            boolean isSel = attribute.isSelected() || 
                            "true".equalsIgnoreCase(attribute.getAttribute("checked")) ||
                            (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));", attribute);

            log.info("Attribute '{}' selection status: {}", attr, isSel);
            if (!isSel) {
                log.error("Validation failed: Attribute '{}' is UNCHECKED, but was expected to be SELECTED!", attr);
                allSelected = false;
            }
        }
        return allSelected;
    }

    public boolean validateAttributeIsNOTSelected(DataTable table) {
        boolean anySelected = false;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        for (Map<String, String> selectedAttribute : data) {
            String attr = selectedAttribute.get("Attributes").trim();
            String xpath = "//*[text()='" + attr + "']//input | " +
                           "//*[normalize-space(text())='" + attr + "']/ancestor::label//input | " +
                           "//*[normalize-space(text())='" + attr + "']/..//input | " +
                           "//label[contains(., '" + attr + "')]//input";

            WebElement attribute;
            try {
                attribute = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            } catch (Exception ex) {
                attribute = getDriver().findElement(By.xpath(xpath));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", attribute);
            withAction().pause(Duration.ofSeconds(1)).build().perform();

            boolean isSel = attribute.isSelected() || 
                            "true".equalsIgnoreCase(attribute.getAttribute("checked")) ||
                            (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));", attribute);

            log.info("Attribute '{}' checking NOT selected, actual isSelected: {}", attr, isSel);
            if (isSel) {
                log.error("Validation failed: Attribute '{}' is CHECKED, but was expected to be UNCHECKED!", attr);
                anySelected = true;
            }
        }
        return anySelected;
    }

    public void clickSelectLimitValueInBulkEdit(DataTable LimitValue) {
        List<Map<String, String>> data = LimitValue.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            limit_Value_tab.waitUntilVisible().click();
            typeInto(limit_Value_tab, dataTable.get("Limit Value"));
        } catch (Exception e) {
            log.error("Unable to input Limit Value-->" + e);
            Assert.fail();
        }
    }

    public void getOnDocumentScreen() {
        try {
            withAction().pause(Duration.ofSeconds(6)).build().perform();
            navigation_btn.waitUntilClickable();
            navigation_btn.click();
            if (All_documents.isVisible()) {
                withAction().pause(Duration.ofSeconds(2)).build().perform();
                All_documents.waitUntilClickable().click();
            } else {
                DocumentDropDown_btn.waitUntilVisible().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                All_documents.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(3)).build().perform();
            }
        } catch (Exception e) {
            log.error("Not able to reach the approval group screen -->" + e);
            Assert.fail();
        }
    }

    public void selectTouchdirection(String AuthLine, DataTable dataTable) {
        String lowerAuthLine = AuthLine.trim().toLowerCase();
        String productKeyword;
        if (lowerAuthLine.contains("vanilla option")) {
            productKeyword = "vanilla option";
        } else if (lowerAuthLine.contains("single barrier digital")) {
            productKeyword = "single barrier digital";
        } else if (lowerAuthLine.contains("one touch")) {
            productKeyword = "one touch";
        } else {
            String[] parts = lowerAuthLine.split("\\s+");
            productKeyword = parts[parts.length - 1];
        }

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        for (Map<String, String> row : data) {
            String direction = row.get("Touch Direction").trim();
            String lowerDir = direction.toLowerCase();

            String targetLabelXpath = "(//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productKeyword + "') and not(self::script)])[last()]" +
                                      "/following::label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerDir + "')][1]";

            WebElement label;
            try {
                label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(targetLabelXpath)));
            } catch (Exception e) {
                String fallbackXpath = "//span[normalize-space()='" + AuthLine + "']//ancestor::div[@role='button']/following-sibling::div//label[contains(.,'" + direction + "')]";
                label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fallbackXpath)));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", label);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            WebElement input;
            try {
                input = label.findElement(By.xpath(".//input"));
            } catch (Exception ex) {
                input = label;
            }

            boolean isChecked = input.isSelected() || 
                                "true".equalsIgnoreCase(input.getAttribute("checked")) ||
                                (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));", input);

            if (!isChecked) {
                try {
                    label.click();
                } catch (Exception clickEx) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", label);
                }
                withAction().pause(Duration.ofMillis(500)).build().perform();
                boolean stillNotChecked = !input.isSelected() && !"true".equalsIgnoreCase(input.getAttribute("checked"));
                if (stillNotChecked) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", input);
                }
            }
        }
    }

    public void selectContractType(String AuthLine, DataTable dataTable) {
        String lowerAuthLine = AuthLine.trim().toLowerCase();
        String productKeyword;
        if (lowerAuthLine.contains("vanilla option")) {
            productKeyword = "vanilla option";
        } else if (lowerAuthLine.contains("single barrier digital")) {
            productKeyword = "single barrier digital";
        } else if (lowerAuthLine.contains("one touch")) {
            productKeyword = "one touch";
        } else {
            String[] parts = lowerAuthLine.split("\\s+");
            productKeyword = parts[parts.length - 1];
        }

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        for (Map<String, String> row : data) {
            String contractType = row.get("Contract Type").trim();
            String lowerContract = contractType.toLowerCase();

            String targetLabelXpath = "(//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productKeyword + "') and not(self::script)])[last()]" +
                                      "/following::label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + lowerContract + "')][1]";

            WebElement label;
            try {
                label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(targetLabelXpath)));
            } catch (Exception e) {
                String fallbackXpath = "//span[normalize-space()='" + AuthLine + "']//ancestor::div[@role='button']/following-sibling::div//label[contains(.,'" + contractType + "')]";
                label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fallbackXpath)));
            }

            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", label);
            withAction().pause(Duration.ofMillis(500)).build().perform();

            WebElement input;
            try {
                input = label.findElement(By.xpath(".//input"));
            } catch (Exception ex) {
                input = label;
            }

            boolean isChecked = input.isSelected() || 
                                "true".equalsIgnoreCase(input.getAttribute("checked")) ||
                                (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));", input);

            if (!isChecked) {
                try {
                    label.click();
                } catch (Exception clickEx) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", label);
                }
                withAction().pause(Duration.ofMillis(500)).build().perform();
                boolean stillNotChecked = !input.isSelected() && !"true".equalsIgnoreCase(input.getAttribute("checked"));
                if (stillNotChecked) {
                    getJavascriptExecutorFacade().executeScript("arguments[0].click();", input);
                }
            }
        }
    }

    public void select_barrierType(String AuthLine, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> dataTable_map : data) {
            String BarrierType = dataTable_map.get("Barrier Type").trim();
            WebElement element = getDriver().findElement(By.xpath("//span[normalize-space()='" + AuthLine + "']//ancestor::div[@role='button']/following-sibling::div//label[normalize-space()='" + BarrierType + "']//input[@name='checkbox']"));
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            element.click();
        }
    }

    public void enterManualPDFApprovalEmail(DataTable dataTable) {
        String emailValue = dataTable.asList().get(0);
        WebElementFacade emailField = manualPdfEmailField();
        emailField.waitUntilVisible();
        emailField.clear();
        emailField.sendKeys(emailValue);
        emailField.sendKeys(Keys.TAB);
        System.out.println("Entered email: " + emailValue);
    }


    public void validateEmailId(DataTable dataTable) {
        String expectedEmail = dataTable.asList().get(0);
        String actualEmail = getDriver().findElement(By.xpath("//input[@placeholder='Enter Manual PDF approval email']"))
                .getAttribute("value");
        if (actualEmail.equals(expectedEmail)) {
            System.out.println("Validation Successful: Expected " + expectedEmail + " and found " + actualEmail);
        } else {
            throw new AssertionError("Validation Failed! Expected: " + expectedEmail + " but found: " + actualEmail);
        }
    }

    public void validateEmptyInputBox() {
        String actualValue = getDriver().findElement(By.xpath("//input[@placeholder='Enter Manual PDF approval email']"))
                .getAttribute("value");
        if (actualValue == null || actualValue.isEmpty()) {
            System.out.println("Validation Successful: The input box is empty.");
        } else {
            throw new AssertionError("Validation Failed! Expected empty box but found: " + actualValue);
        }
    }

    public void removeEmailId() {
        WebElementFacade emailField = manualPdfEmailField();
        emailField.waitUntilVisible();
        emailField.clear();
        emailField.sendKeys(Keys.BACK_SPACE);
        System.out.println("Email field cleared successfully.");
    }


    public void validateEmailOnPreview(DataTable dataTable) {
        String expectedEmail = dataTable.asList().get(0);
        String xpath = "//div[text()='Manual PDF Approval Email']/following-sibling::div[@class='gt-field2']";
        String actualEmail = getDriver().findElement(By.xpath(xpath)).getText();
        if (actualEmail.trim().equals(expectedEmail.trim())) {
            System.out.println("Preview Validation Successful: " + actualEmail);
        } else {
            throw new AssertionError("Preview Validation Failed! Expected: " + expectedEmail + " but found: " + actualEmail);
        }
    }

    private WebElementFacade manualPdfEmailField() {
        return find(By.cssSelector("input[placeholder='Enter Manual PDF approval email']"));
    }

    public void sortInDescendingOrder(String ColumnName) {
        String xpath = "//div[@class='sorting-head']" +
                "[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')" +
                "='" + ColumnName.toLowerCase() + "']";
        WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
        withAction().pause(Duration.ofSeconds(1)).build().perform();
        withAction().doubleClick(element).build().perform();
    }

    public void selectTenorForProduct(String product, DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String tenorValue = data.get(0).get(0);
        String tenorType = data.get(0).get(1);
        try {
            String rowXpath = "//div[contains(@data-testid, 'tenor-row-container')]" +
                    "[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                    + product.toLowerCase() + "')]";
            WebElementFacade row = find(By.xpath(rowXpath));
            row.waitUntilVisible();
            WebElementFacade valueInput = row.then(By.xpath(".//input[@name='tenorValue']"));
            valueInput.waitUntilVisible().clear();
            valueInput.type(tenorValue);
            WebElementFacade dropdown = row.then(By.xpath(".//input[@placeholder='select']"));
            dropdown.waitUntilClickable().click();
            dropdown.type(tenorType);
            withAction().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        } catch (Exception e) {
            log.error("Unable to select tenor for product --> " + e);
            Assert.fail("Failed to select Tenor for product: " + product + ". Error: " + e.getMessage());
        }
    }

    public void validateTenorAndAuthValue(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String productName = data.get(0).get(0).trim();
        String expectedTenor = data.get(0).get(1).trim();
        String expectedAuthValue = data.get(0).get(2).trim();
        try {
            String[] words = productName.split("\\s+");
            StringBuilder conditionBuilder = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                conditionBuilder.append("contains(.,'")
                        .append(words[i])
                        .append("')");
                if (i < words.length - 1) {
                    conditionBuilder.append(" and ");
                }
            }
            String finalXpath = "//div[contains(@class,'accordion-summary')]" + "[.//span[" + conditionBuilder + "]]";
            WebElementFacade accordion = find(By.xpath(finalXpath));
            accordion.waitUntilClickable();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", accordion);
            accordion.click();
            WebElementFacade tenorInput = accordion.find(By.xpath(".//input[contains(@class,'accordion-input')]"));
            tenorInput.waitUntilVisible();

            Assert.assertEquals("Tenor mismatch for " + productName, expectedTenor, tenorInput.getValue().trim());
            WebElementFacade authInput = accordion.find(By.xpath(".//input[@role='combobox']"));
            Assert.assertEquals("Auth mismatch for " + productName, expectedAuthValue, authInput.getValue().trim());

        } catch (Exception e) {
            Assert.fail("Validation failed for product: " + productName +
                    " | Error: " + e.getMessage());
        }
    }

    public void validateTenorValueOnly(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String productName = data.get(0).get(0).trim();
        String expectedTenor = data.get(0).get(1).trim();
        try {
            String tenorBlockXpath = "//div[contains(.,'" + productName + "')]" + "/ancestor::div[contains(@class,'MuiButtonBase-root')]" + "//div[contains(@class,'tenor-block')]";
            WebElementFacade tenorContainer = find(By.xpath(tenorBlockXpath));
            tenorContainer.waitUntilVisible();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", tenorContainer);
            String actualTenor = "";
            List<WebElement> inputs = tenorContainer.findElements(By.xpath(".//input"));
            if (!inputs.isEmpty()) {
                actualTenor = inputs.get(0).getAttribute("value").trim();
            } else {
                actualTenor = tenorContainer.getText().trim();
            }
            actualTenor = actualTenor.replace("Tenor", "").trim();
            Assert.assertEquals("Tenor mismatch for " + productName, expectedTenor, actualTenor);
        } catch (Exception e) {
            Assert.fail("Tenor validation failed for product: " + productName + " | Error: " + e.getMessage());
        }
    }

    public void validateTenorValueOnlyInDF(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String productName = data.get(0).get(0).trim();
        String expectedTenorValue = data.get(0).get(1).trim();

        try {
            String productLower = productName.toLowerCase();
            String tenorXpath = "//*[contains(@class, 'accordion') or contains(@class, 'AccordionSummary')]" +
                    "[.//span[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productLower + "')]]" +
                    "//*[contains(@data-testid, 'auth-accordion-tenor-fields-box')]//input";
            List<WebElementFacade> tenorInputs = findAll(By.xpath(tenorXpath));
            if (tenorInputs.isEmpty()) {
                Assert.fail("No tenor input fields found for product: '" + productName + "' using XPath: " + tenorXpath);
            }
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({block: 'center'});", tenorInputs.get(0));
            withAction().pause(Duration.ofMillis(500)).build().perform();
            boolean isMatchFound = false;
            StringBuilder actualValuesFound = new StringBuilder();
            for (WebElementFacade input : tenorInputs) {
                String actualValue = input.getAttribute("value");
                if (actualValue != null) {
                    actualValue = actualValue.trim();
                    actualValuesFound.append("[").append(actualValue).append("] ");

                    if (actualValue.equalsIgnoreCase(expectedTenorValue)) {
                        isMatchFound = true;
                        break; // Match found, no need to check other inputs
                    }
                }
            }

            Assert.assertTrue("Tenor value mismatch for product '" + productName + "'. Expected: [" + expectedTenorValue + "] but found: " + actualValuesFound.toString(), isMatchFound);

        } catch (Exception e) {
            Assert.fail("Validation failed for product '" + productName + "'. Error: " + e.getMessage());
        }
    }
    public void selectProductFromPopUp(DataTable dataTable) {
        List<String> products = dataTable.asList();
        for (String productName : products) {
            String xpathExpression = String.format("//label[contains(., '%s')]/input[@type='checkbox']", productName);
            WebElementFacade checkbox = $(xpathExpression);
            checkbox.waitUntilVisible();
            if (!checkbox.isSelected()) {
                checkbox.click();
                System.out.println("Selected product: " + productName);
            }
        }
    }

    public void clickSelectCalculationTypeForAdvanceFilter(DataTable CalculationType) {
        List<Map<String, String>> data = CalculationType.asMaps(String.class, String.class);
        Map<String, String> dataTable_map = data.get(0);
        HashMap<String, String> dataTable = Maps.newHashMap(dataTable_map);
        try {
            calculationType_adFilter.waitUntilPresent().click();
            withAction().moveToElement(calculationType_adFilter).sendKeys(dataTable.get("Calculation Type")).pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN, Keys.ENTER).pause(Duration.ofSeconds(2)).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Calculation Type-->" + e);
            Assert.fail();
        }
    }

    public void validateEnabledElementExcludeCLS() {
        boolean isEnabled = excludeCLS_tab.isEnabled();
        String disabledAttr = excludeCLS_tab.getAttribute("disabled");
        if (isEnabled && disabledAttr == null) {
            log.info("SUCCESS: 'Exclude CLS' is ENABLED.");
        } else {
            log.info("INFO: 'Exclude CLS' appears DISABLED. Attempting to type 'NO' to verify...");
            try {
                excludeCLS_tab.type("NO");
                log.warn("WARNING: Element was marked disabled but accepted input!");
            } catch (Exception e) {
                log.info("CONFIRMED: 'Exclude CLS' is truly DISABLED. Input was rejected as expected.");
            }
        }
    }

    public void enterLiteUserEmail(DataTable dataTable) {
        List<String> emailData = dataTable.asList();
        String email = emailData.get(0);
        try {
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center' });", notificationRecipientBtn);
            notificationRecipientBtn.waitUntilClickable().click();
            emailInputField.waitUntilVisible().clear();
            emailInputField.type(email);
            withAction().pause(Duration.ofSeconds(2)).build().perform();
            saveTickBtn.waitUntilClickable().click();
            log.info("Successfully entered and saved email: " + email);
        } catch (Exception e) {
            log.error("Failed to enter notification email: " + e.getMessage());
            Assert.fail("Email entry workflow failed.");
        }
    }

    public void userEnterLimitValue(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String newLimitValue = data.get(0).get("Limit Value");
        try {
            limitValueField.waitUntilVisible();
            limitValueField.click();
            limitValueField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            limitValueField.sendKeys(Keys.DELETE);
            withAction().pause(Duration.ofSeconds(5)).build().perform();
            limitValueField.type(newLimitValue);
            log.info("Updated Limit Value to: " + newLimitValue);
        } catch (Exception e) {
            log.error("Failed to update limit value: " + e.getMessage());
            Assert.fail("Limit value update failed.");
        }
    }

    public void compareDocumentVersions(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String expectedApproved = data.get(0).get("Enforced version");
        String expectedCurrent = data.get(0).get("Current version");
        try {
            if ((approvedVersionHeader.waitUntilVisible().getText().trim().isEmpty()) || (currentVersionHeader.waitUntilVisible().getText().trim().isEmpty())) {
                throw new AssertionError("Document version text is empty.");
            }
            String approvedSuffix = approvedVersionHeader.waitUntilVisible().getText().trim().substring(approvedVersionHeader.waitUntilVisible().getText().trim().length() - 3);
            String currentSuffix = currentVersionHeader.waitUntilVisible().getText().trim().substring(currentVersionHeader.waitUntilVisible().getText().trim().length() - 3);
            if (!approvedSuffix.equals(expectedApproved)) {
                throw new AssertionError("Approved version mismatch. Expected: "
                        + expectedApproved + " but found: " + approvedSuffix);
            }
            if (!currentSuffix.equals(expectedCurrent)) {
                throw new AssertionError("Current version mismatch. Expected: "
                        + expectedCurrent + " but found: " + currentSuffix);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while validating document versions", e);
        }
    }
    public void ignoreLegalNameChangePopupIfPresent() {
        try {
            if (LegalNameChangeScreen.withTimeoutOf(Duration.ofSeconds(5)).isCurrentlyVisible()) {
                IgnoreButton_Screen.waitUntilClickable().click();
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            } else {
                log.info("'Legal Name(s) Changed!' pop-up was not present. Continuing execution.");
            }
        } catch (Exception e) {
            log.info("'Legal Name(s) Changed!' pop-up was not found, which is acceptable. Continuing execution.");
        }
    }
    public boolean validateWarningPopupMessage(DataTable dataTable) {
        String expectedMessage = dataTable.asList().get(0);
        boolean result;
        try {
            DraftVersionPop_Up.withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible();
            result = DraftVersionPop_Up.getText().contains(expectedMessage);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    public void clickOnDynamicButton(String buttonName) {
        try {
            String xpath = String.format("//button[normalize-space(text())='%s']", buttonName);
            WebElementFacade button = find(By.xpath(xpath));
            button.withTimeoutOf(Duration.ofSeconds(2)).waitUntilClickable();
            getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", button);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            button.click();
            withAction().pause(Duration.ofSeconds(2)).build().perform();

            log.info("Successfully clicked on button: " + buttonName);
        } catch (Exception e) {
            log.error("Failed to click on button: " + buttonName + " | Error: " + e.getMessage());
            Assert.fail("Could not click on button: " + buttonName);
        }
    }
    /**
     * Native DOM Mutation Observer Injector
     * Hooks natively into Chrome's mutation event space to trap toast overlays
     * instantly when they hit the DOM tree, independent of Java thread execution.
     */
    public void startContinuousToastInterceptor() {
        log.info("Arch-Interceptor: Injecting native JavaScript DOM MutationObserver context...");
        try {
            String observerScript =
                    "if (!window.toastObserver) {" +
                            "    window.capturedToasts = [];" +
                            "    window.toastObserver = new MutationObserver(function(mutations) {" +
                            "        mutations.forEach(function(mutation) {" +
                            "            mutation.addedNodes.forEach(function(node) {" +
                            "                if (node.nodeType === 1) {" +
                            "                    let match = node.querySelector('.Toastify__toast-body') || " +
                            "                                (node.classList && node.classList.contains('Toastify__toast-body') ? node : null);" +
                            "                    if (match) {" +
                            "                        let cleanText = match.innerText.replace(/[✕✖×✕\\s\\n]$/, '').trim();" +
                            "                        if (cleanText && !window.capturedToasts.includes(cleanText)) {" +
                            "                            window.capturedToasts.push(cleanText);" +
                            "                        }" +
                            "                    }" +
                            "                }" +
                            "            });" +
                            "        });" +
                            "    });" +
                            "    window.toastObserver.observe(document.body, { childList: true, subtree: true });" +
                            "    console.log('Native Toast Observer successfully attached to window context.');" +
                            "}";

            getJavascriptExecutorFacade().executeScript(observerScript);
        } catch (Exception e) {
            log.error("Failed to inject native DOM MutationObserver: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<String> getCapturedToastHistory() {
        try {
            // Pull the persistent historical array directly from Chrome's window execution context
            Object response = getJavascriptExecutorFacade().executeScript("return window.capturedToasts || [];");
            if (response instanceof List) {
                return (List<String>) response;
            }
        } catch (Exception e) {
            log.warn("Failed to retrieve native window.capturedToasts array: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public boolean isMessageCapturedInHistory(String expectedMessage) {
        List<String> history = getCapturedToastHistory();
        log.info("Arch-Interceptor: Evaluating native browser toast history logs: " + history);
        for (String toast : history) {
            if (toast.toLowerCase().contains(expectedMessage.toLowerCase().trim())) {
                return true;
            }
        }
        return false;
    }
    // --- DN Tenor Configuration methods ---
    public void enableTenor_DN() {
        try {
            enableTenorSwitch_DN.waitUntilPresent();
            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", enableTenorSwitch_DN);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            enableTenorSwitch_DN.waitUntilClickable().click();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.error("Unable to enable Tenor for DN-->" + e);
            Assert.fail();
        }
    }

    public void inputAuthTenorValue_DN(DataTable table) {
        Map<String, String> data = table.asMaps(String.class, String.class).get(0);
        String value = data.get("Auth Value");
        try {
            authTenorValueInput_DN.waitUntilVisible();
            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", authTenorValueInput_DN);
            authTenorValueInput_DN.clear();
            withAction().moveToElement(authTenorValueInput_DN).click().sendKeys(value)
                    .pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.error("Unable to input Auth Tenor value for DN-->" + e);
            Assert.fail();
        }
    }
    public void selectAuthTenorType_DN(DataTable table) {
        Map<String, String> data = table.asMaps(String.class, String.class).get(0);
        String tenorType = data.get("Auth Tenor");
        try {
            authTenorTypeSelect_DN.waitUntilVisible().click();
            typeInto(authTenorTypeSelect_DN, tenorType);
            withAction().pause(Duration.ofSeconds(1)).build().perform();
            act.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        } catch (Exception e) {
            log.error("Unable to select Auth Tenor type for DN-->" + e);
            Assert.fail();
        }
    }
    public void handleUnsupportedFunctionalityPopUp() {
        try {
            log.info("Checking if the 'Unsupported Functionality' pop-up is present...");

            if (IgnoreButton_Screen.isPresent() && IgnoreButton_Screen.isVisible()) {
                IgnoreButton_Screen.waitUntilClickable().click();
                log.info("Pop-up appeared. Clicked the Ignore button successfully.");
                withAction().pause(Duration.ofSeconds(2)).build().perform();
            }
        } catch (Exception e) {
            log.info("Pop-up did not appear. Ignoring and proceeding to the next step.");
        }
    }

    @FindBy(xpath = "//div[contains(@data-testid,'auth-accordion-row-root-')]")
    private List<WebElementFacade> AuthLineRows;

    public void validateAttributesForAuthLine(String authLineName, DataTable table) {
        String expectedNormalized = authLineName.replaceAll("\\s+", "").toLowerCase();

        if (!AuthLineRows.isEmpty()) {
            getJavascriptExecutorFacade().executeScript(
                    "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", AuthLineRows.get(0));
            withAction().pause(Duration.ofSeconds(1)).build().perform();
        }

        WebElement matchedRow = null;
        for (WebElementFacade row : AuthLineRows) {
            try {
                WebElement productSpan = row.findElement(By.xpath(".//span[contains(@data-testid,'auth-accordion-product-text-')]"));
                String actualNormalized = productSpan.getText().replaceAll("\\s+", "").toLowerCase();
                log.info("Auth Line row found on screen: '{}'", productSpan.getText().trim());
                if (actualNormalized.equals(expectedNormalized)) {
                    matchedRow = row;
                    break;
                }
            } catch (NoSuchElementException ignored) { }
        }

        if (matchedRow == null) {
            Assert.fail("Could not find Auth Line row matching: '" + authLineName + "'");
            return;
        }

        getJavascriptExecutorFacade().executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", matchedRow);
        withAction().pause(Duration.ofSeconds(1)).build().perform();

        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        log.info("Parsed {} row(s) from feature table. First row keys: {}", data.size(), data.isEmpty() ? "N/A" : data.get(0).keySet());

        boolean overallResult = true;

        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            Map<String, String> row = data.get(rowIndex);
            try {
                String columnName = row.getOrDefault("Column Name", "");
                columnName = (columnName == null) ? "" : columnName.trim();

                if (columnName.isEmpty()) {
                    log.error("Row {} is missing a 'Column Name' value. Row content: {}", rowIndex, row);
                    overallResult = false;
                    continue;
                }

                String selectedRaw = row.getOrDefault("Selected Attribute", "");
                selectedRaw = (selectedRaw == null) ? "" : selectedRaw.trim();

                String nonSelectedRaw = row.getOrDefault("Non-Selected Attribute", "");
                nonSelectedRaw = (nonSelectedRaw == null) ? "" : nonSelectedRaw.trim();

                if (selectedRaw.isEmpty() && nonSelectedRaw.isEmpty()) {
                    log.info("Skipping column '{}' — no attributes specified.", columnName);
                    continue;
                }

                List<WebElement> headings = matchedRow.findElements(By.xpath(
                        ".//div[contains(@data-testid,'auth-accordion-attribute-field-heading-')][normalize-space(text())='" + columnName + "']"));

                if (headings.isEmpty()) {
                    log.error("Attribute column '{}' not found for Auth Line '{}'", columnName, authLineName);
                    overallResult = false;
                    continue;
                }

                WebElement heading = headings.get(0);
                getJavascriptExecutorFacade().executeScript(
                        "arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", heading);
                withAction().pause(Duration.ofMillis(400)).build().perform();

                WebElement fieldBlock = heading.findElement(By.xpath("./.."));
                WebElement contentBox = fieldBlock.findElement(By.xpath(".//div[contains(@data-testid,'auth-accordion-attribute-field-content-box-')]"));

                Map<String, Boolean> actualStates = new HashMap<>();
                List<WebElement> checkboxLabels = contentBox.findElements(By.xpath(".//label[@class='csm_checkbox']"));
                for (WebElement label : checkboxLabels) {
                    WebElement input = label.findElement(By.xpath(".//input[@type='checkbox']"));
                    String attrText = label.getText() == null ? "" : label.getText().trim();
                    actualStates.put(attrText, input.isSelected());
                }

                for (String expectedSelected : splitCsv(selectedRaw)) {
                    Boolean actual = actualStates.get(expectedSelected);
                    if (actual == null) {
                        log.error("Attribute '{}' not found under column '{}' for Auth Line '{}'", expectedSelected, columnName, authLineName);
                        overallResult = false;
                    } else if (!actual) {
                        log.error("Expected '{}' to be SELECTED under '{}' but it was NOT.", expectedSelected, columnName);
                        overallResult = false;
                    }
                }

                for (String expectedNonSelected : splitCsv(nonSelectedRaw)) {
                    Boolean actual = actualStates.get(expectedNonSelected);
                    if (actual == null) {
                        log.error("Attribute '{}' not found under column '{}' for Auth Line '{}'", expectedNonSelected, columnName, authLineName);
                        overallResult = false;
                    } else if (actual) {
                        log.error("Expected '{}' to be NOT selected under '{}' but it WAS selected.", expectedNonSelected, columnName);
                        overallResult = false;
                    }
                }

            } catch (Exception e) {
                log.error("Unexpected error processing row {} ({}): {}", rowIndex, row, e.toString(), e);
                overallResult = false;
            }
        }

        Assert.assertTrue("Attribute validation failed for Auth Line '" + authLineName + "'. See logs above for details.", overallResult);
    }

    private List<String> splitCsv(String raw) {
        if (raw == null || raw.trim().isEmpty()) return Collections.emptyList();
        return Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    public void clickLimitScopeTab() {
        limitScopeTab.waitUntilClickable().click();
    }
    public void clickApproveButtonOnDFScreen() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", approveBtn_DFScreen);
        approveBtn_DFScreen.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
        log.info("Successfully clicked the Approve button on the DF listing screen.");
    }

    public void EnableLimitLineWithoutCash() {
        boolean success = false;
        int retries = 0;
        while (!success && retries < 3) {
            try {
                WebElement element = getDriver().findElement(By.xpath("//table//tbody//tr[not(contains(., 'Cash'))]//*[contains(@class,'MuiSwitch-root')]//input[@type='checkbox']"));
                evaluateJavascript("arguments[0].scrollIntoView({ block: 'center', inline: 'center' });", element);
                withAction().pause(Duration.ofSeconds(1)).build().perform();
                boolean isChecked = element.isSelected() || (Boolean) evaluateJavascript("return arguments[0].checked || (arguments[0].parentElement && arguments[0].parentElement.classList.contains('Mui-checked'));", element);
                if (!isChecked) {
                    evaluateJavascript("arguments[0].click();", element);
                }
                success = true;
            } catch (Exception e) {
                retries++;
                withAction().pause(Duration.ofSeconds(1)).build().perform();
            }
        }
    }

    @FindBy(xpath = "//input[contains(@class, 'limit-input')]")
    private WebElementFacade limitValueInput;
    public void clearAndEnterLimitValue(String newValue) {
        try {
            limitValueInput.waitUntilVisible().waitUntilClickable();
            limitValueInput.click();
            limitValueInput.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"), org.openqa.selenium.Keys.BACK_SPACE);
            withAction().pause(java.time.Duration.ofMillis(500)).build().perform();
            limitValueInput.sendKeys(newValue);
            log.info("Successfully cleared and entered new limit value: " + newValue);
        } catch (Exception e) {
            log.error("Failed to enter Limit Value -> " + e.getMessage());
            org.junit.Assert.fail("Could not enter Limit Value: " + e.getMessage());
        }
    }
}