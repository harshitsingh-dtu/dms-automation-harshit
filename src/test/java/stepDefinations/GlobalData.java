package stepDefinations;

import PageObjects.Approval.*;
import PageObjects.Currency.CurrencygroupCreateNewPageObject;
import PageObjects.Currency.CurrencygroupPageObject;
import PageObjects.Currency.CurrencygroupUpdatePageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1523PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_2198PageObject;
import PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject;
import PageObjects.DocumentTemplate.DocumentTemplatePageObject;
import PageObjects.Documents.DocumentPageObject;
import PageObjects.ProductGroup.ProductGroupCreatePageObject;
import PageObjects.ProductGroup.ProductGroupUpdatePageObject;
import PageObjects.ProductGroup.ProductGroupValidationPageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class GlobalData extends PageObject {
    Actions act=new Actions(getDriver());
    DMS_2198PageObject dms2198PageObject;
    ApprovalgroupPageObject approvalgroupPageObject;
    DocumentPageObject documentPageObject;
    ProductGroupValidationPageObject productGroupValidationPageObject;
    ProductGroupCreatePageObject productGroupCreatePageObject;
    ProductGroupUpdatePageObject productGroupUpdatePageObject;
    ApprovalgroupUpdatePageObject approvalgroupUpdatePageObject;
    ApprovalgroupCreatePageObject approvalgroupCreatePageObject;
    CurrencygroupPageObject currencygroupPageObject;
    CurrencygroupCreateNewPageObject currencygroupCreateNewPageObject;
    CurrencygroupUpdatePageObject currencygroupUpdatePageObject;
    DocumentTemplatePageObject documentTemplatePageObject;
    DocumentTemplateCreatePageObject documentTemplateCreatePageObject;
    ApprovalMatrixPageObject approvalMatrixPageObject;
    ApprovalMatrixUpdatePageObject approvalMatrixUpdatePageObject;

    DMS_1523PageObject dms1523PageObject;

    boolean result =false;

    @Given("Check required approval group exist or not")
    public void Check_required_approval_group_exist_or_not(DataTable table) {
            approvalgroupPageObject.navigateToApprovalgrpScreen();
            result = approvalgroupPageObject.checkSearchBar(table);
        if (result){
            log.info("Approval group already present");
        }
        else {
            approvalgroupCreatePageObject.clickcreatenew_btn();
            approvalgroupCreatePageObject.user_fills_the_group_name(table);
            approvalgroupCreatePageObject.user_fills_the_organization_name(table);
            approvalgroupCreatePageObject.user_fills_the_doc_type(table);
            approvalgroupCreatePageObject.user_fills_the_leis(table);
            approvalgroupCreatePageObject.user_fills_the_org_type(table);
            withAction().pause(Duration.ofSeconds(3)).moveToElement(approvalgroupCreatePageObject.getNext_btn()).click().build().perform();
            approvalgroupUpdatePageObject.searchandAddUsers(table);
            approvalgroupUpdatePageObject.submitchanges();
        }
        }

    @Given("Check required product group exist or not")
    public void Check_required_product_group_exist_or_not(DataTable table) {
        documentPageObject.clickMenuButton();
        productGroupValidationPageObject.clickProductGroupTab();
        act.pause(Duration.ofSeconds(2)).build().perform();
        productGroupUpdatePageObject.clickProductGroupSearch_bar(table);
        result = productGroupUpdatePageObject.checkresult();
        if (result){
            log.info("product group already present");
        }
        else {
            productGroupCreatePageObject.clickCreateProductGroup();
            productGroupCreatePageObject.productGroup(table);
            productGroupCreatePageObject.Organisation(table);
            productGroupCreatePageObject.AssetClass(table);
            productGroupCreatePageObject.ProductFamily(table);
            productGroupCreatePageObject.Product(table);
            productGroupCreatePageObject.AddProductLine();
            productGroupCreatePageObject.Submit_btn();
        }
    }

    @Given("Check required currency group exist or not")
    public void Check_required_currency_group_exist_or_not(DataTable table) {
        List<String> currencyList = Arrays.asList("DZD","BBD","VND","CLF","AOA","KWD");
        currencygroupPageObject.navigateToCurrencyscreen();
        currencygroupPageObject.checkifonCurrencygrpscreen();
        currencygroupPageObject.clickCurrencyGroupSearch_bar(table);
        if (currencygroupPageObject.checkCurrencyResult()){
            log.info("currency group already present");
        }
        else {
            currencygroupCreateNewPageObject.clickcreatenewgrp_btn();
            currencygroupCreateNewPageObject.typesgrouppname(table);
            currencygroupCreateNewPageObject.typesorganizationname(table);
            currencygroupUpdatePageObject.updated_search_for_the_currency_and_select_them(currencyList);
            currencygroupUpdatePageObject.submitChanges();
        }
    }

    @Given("Check required currency pair group exist or not")
    public void Check_required_currency_pair_group_exist_or_not(DataTable table) {
        List<String> currencyList = Arrays.asList("AED-EGP","CAD-PLN","USD-LBP","UYU-USD","GBP-PHP","HKD-NOK");
        currencygroupPageObject.navigateToCurrencyscreen();
        currencygroupPageObject.navigatetoCurrencyPairgroupscreen();
        currencygroupPageObject.clickCurrencyGroupSearch_bar(table);
        result = currencygroupPageObject.checkCurrencyResult();
        if (result){
            log.info("currency pair group already present");
        }
        else {
            currencygroupCreateNewPageObject.clickcreatenewgrp_btn();
            currencygroupCreateNewPageObject.typesgrouppname(table);
            currencygroupCreateNewPageObject.typesorganizationname(table);
            currencygroupUpdatePageObject.updated_search_for_the_currency_and_select_them(currencyList);
            currencygroupUpdatePageObject.submitChanges();
        }
    }

    @Given("Check required document template exist or not for 4way")
    public void Check_required_document_template_exist_or_not(DataTable table) {
        documentPageObject.clickMenuButton();
        documentTemplatePageObject.clickDocumentTemplateTab();
        documentTemplatePageObject.clickTemplateGroupSearch_bar(table);
        result = documentTemplatePageObject.checkTemplateResult();
        System.out.println(result);
        if (result){
            log.info("Document template already present");
        }
        else {
            documentTemplateCreatePageObject.clickCreatebtn();
            documentTemplateCreatePageObject.checkifOnCreateTemplatescreen();
            documentTemplateCreatePageObject.selectTemplateName(table);
            documentTemplateCreatePageObject.selectOrganisationName(table);
            documentTemplateCreatePageObject.selectDocType(table);
            documentTemplateCreatePageObject.clickTemplateNextbtn();
            documentTemplateCreatePageObject.clickApprovalWorkflow_btn();
            documentTemplateCreatePageObject.selectApprovalWorkflow();
            documentTemplateCreatePageObject.clickEnforcementRules_btn();
            documentTemplateCreatePageObject.typeinto_fornewdocument();
            documentTemplateCreatePageObject.typeinto_forammendment();
            documentTemplateCreatePageObject.typeinto_fortermination();
            documentTemplateCreatePageObject.clickNext_btn();
            documentTemplateCreatePageObject.typetextintoCKEditordocumentcontent(table);
            documentTemplateCreatePageObject.clickSubmit_btn();


        }
    }
    @Given("Check required document template exist or not for DN")
    public void Check_required_document_template_exist_or_notforDN(DataTable table) {
        documentPageObject.clickMenuButton();
        documentTemplatePageObject.clickDocumentTemplateTab();
        documentTemplatePageObject.clickTemplateGroupSearch_bar(table);
        result = documentTemplatePageObject.checkTemplateResult();
        System.out.println(result);
        if (result){
            log.info("Document template already present");
        }
        else {
            documentTemplateCreatePageObject.clickCreatebtn();
            documentTemplateCreatePageObject.checkifOnCreateTemplatescreen();
            documentTemplateCreatePageObject.selectTemplateName(table);
            documentTemplateCreatePageObject.selectOrganisationName(table);
            documentTemplateCreatePageObject.selectDocType(table);
            documentTemplateCreatePageObject.clickTemplateNextbtn();
            documentTemplateCreatePageObject.typetextintoCKEditordocumentcontent(table);
            documentTemplateCreatePageObject.clickSubmit_btn();
        }
    }

    @Given("Check required USP rider exist or not")
    public void Check_required_USP_rider_exist_or_not(DataTable table) {
        dms2198PageObject.navigateToUSPRiderTemplateScreen();
        dms2198PageObject.select_docTypeDropdown(table);
        dms2198PageObject.selectLei_PBDropdown(table);
        dms2198PageObject.selectLei_ClientDropdown(table);
        result = dms2198PageObject.getNoRecord().containsText("No Record Found");
        if (result) {
            dms2198PageObject.getCreateNewTemplate_btn().click();
            withAction().pause(Duration.ofSeconds(3)).build().perform();
            dms2198PageObject.select_CreateDocType(table);
            dms2198PageObject.selectPBDropdown(table);
            dms2198PageObject.selectClientDropdown(table);
            dms2198PageObject.enterContact(table);
            dms2198PageObject.getWordClause_checkbox().click();
            dms2198PageObject.addFund(table);
            dms2198PageObject.select_allYesOptions();
            dms2198PageObject.getSubmit_btn().click();
        } else {
            log.info("Document template already present");
        }
    }

    @Given("Check required approval matrix exist or not")
    public void Check_required_approval_matrix_exist_or_not(DataTable table) {
        dms1523PageObject.navigateToApprovalMatrixListingScreen();
        dms1523PageObject.selectLEI(table);
        dms1523PageObject.checkIfDocTypeFilter_and_type(table);
        dms1523PageObject.checkIfOrgTypeFilter_and_type(table);
        result = dms1523PageObject.getSearchedresult_grpname().getText().equalsIgnoreCase(dms1523PageObject.getSelectLEI().getAttribute("value"));
        if (result) {
            log.info("APPROVAL matrix already present");
        } else {
            approvalMatrixPageObject.clickcreatebtn();
            dms1523PageObject.checkIfOrganizationFilter_and_type(table);
            dms1523PageObject.checkIfDocTypeFilter_and_type(table);
            dms1523PageObject.checkIfLEIsFilter_and_type(table);
            dms1523PageObject.checkIfOrgTypeFilter_and_type(table);
            Assert.assertTrue(dms1523PageObject.getNext_btn().isEnabled());
            dms1523PageObject.getNext_btn().click();
            withAction().pause(Duration.ofSeconds(4)).build().perform();
            approvalMatrixUpdatePageObject.DocumentActionandapprovalgroup(table);
        }
    }

}