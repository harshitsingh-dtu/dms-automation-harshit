package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1528PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1571PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1571Step extends PageObject{



    DMS_1571PageObject dms1571PageObject;

    @Then("User will click and enter the document type and be able to see the filtered item list")
    public void User_will_click_and_enter_the_document_type_and_be_able_to_see_the_filtered_item_list(List<String> doctype) {
        dms1571PageObject.Filtereddoctype(doctype);
    }

//need look
    @When("User will click on Request to Create new document button and redirected to Request to Create new document screen")
    public void User_will_click_on_Request_to_Create_new_document_button_and_redirected_to_Request_to_Create_new_document_screen(){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1571PageObject.getRequest_to_CreateNewDocument_button().isVisible());
        dms1571PageObject.getRequest_to_CreateNewDocument_button().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1571PageObject.getRequest_to_CreateNewDocument_text().isVisible());
    }

    @And("User will Enter input for Document type.")
    public void user_will_enter_input_for_document_type(DataTable dataTable) {
        dms1571PageObject.EnterDocType(dataTable);
    }

    @Then("user will enter input for Acting As and able to see filtered item list when Doc type is 4 way")
    public void user_will_enter_input_for_acting_as_and_able_to_see_filtered_item_list_when_doc_type_is_four_way(List<String> Actingas) {
        dms1571PageObject.FilteredActingAS(Actingas);
    }

    @Then("user will enter input for Acting As and able to see filtered item list when Doc type is DN")
    public void user_will_enter_input_for_acting_as_and_able_to_see_filtered_item_list_when_doc_type_is_dn(List<String> Actingas) {
        dms1571PageObject.FilteredActingAS(Actingas);
    }

    @And("User will Enter input for Acting As.")
    public void User_will_Enter_input_for_Acting_As(DataTable dataTable){
        dms1571PageObject.EnterActingas(dataTable);
    }
    @And("User will Select input for Acting As")
    public void User_will_Select_input_for_Acting_As(){
        dms1571PageObject.EnterinpurforActingas();
    }

//    @Then("user is able to see Select parties section with PrimeBroker-1 and ExecutingBroker-1 and Client-1 filters")
//    public void user_is_able_to_see_Select_parties_section_with_PrimeBroker1_and_ExecutingBroker1_and_Client1_filters(){
//        Assert.assertTrue(dms1571PageObject.getSelectparties_text().isVisible());
//        Assert.assertTrue(dms1571PageObject.getPrimeBroker1Filter().isVisible());
//        Assert.assertTrue(dms1571PageObject.getExecutingBroker1Filter().isVisible());
//        Assert.assertTrue(dms1571PageObject.getClient1Filter().isVisible());
//    }

    @And("User will select parties all required parties")
    public void ser_will_select_parties_all_required_parties(DataTable dataTable){
        dms1571PageObject.EnterPrimeBroker1(dataTable);
        dms1571PageObject.randomEnterExecutingBroker1();
        dms1571PageObject.randomEnterClient1();
        dms1571PageObject.randomEnterPrimeBroker2();
        dms1571PageObject.randomEnterClient2();
    }

//    @And("User will select document template from document template dropdown.")
//    public void User_will_select_document_template_from_document_template_dropdown(DataTable dataTable){
//        dms1571PageObject.Selectdocumenttemplate(dataTable);
//        withAction().pause(Duration.ofSeconds(4)).build().perform();
//    }



    @And("User will able to see Template preview for Approval workflow Enforcement rules and legal terms with there respective data")
    public void user_will_able_to_see_template_preview_for_approval_workflow_enforcement_rules_and_legal_terms_with_there_respective_data() {
        Assert.assertTrue(dms1571PageObject.getTemplatepreview_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getApprovalworkflow().isVisible());
        dms1571PageObject.getApprovalworkflow().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (dms1571PageObject.getDocumentactionstext().isVisible()) {
            Assert.assertTrue(dms1571PageObject.getDocumentactionstext().isVisible());
            Assert.assertTrue(dms1571PageObject.getApprovalsequencecolumntext().isVisible());
        }else {
            Assert.assertTrue(dms1571PageObject.getNoDataFound_text_forApprovalWorkflow().isVisible());
        }
        dms1571PageObject.getApprovalworkflow().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1571PageObject.getEnforcementrule().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (dms1571PageObject.getFornewdocumentenforcementcolumntext().isVisible()) {
            Assert.assertTrue(dms1571PageObject.getFornewdocumentenforcementcolumntext().isVisible());
            Assert.assertTrue(dms1571PageObject.getForamendmentcolumntext().isVisible());
            Assert.assertTrue(dms1571PageObject.getForterminationcolumntext().isVisible());
        }else {
            Assert.assertTrue(dms1571PageObject.getNoDataFound_text_forEnforcementrule().isVisible());
        }
        dms1571PageObject.getEnforcementrule().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1571PageObject.getLegalterm().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        if (dms1571PageObject.getParaforlegaltems().isVisible()) {
            Assert.assertTrue(dms1571PageObject.getParaforlegaltems().isVisible());
        }else {
            Assert.assertTrue(dms1571PageObject.getNoDataFound_text_forlegalterm().isVisible());
        }
        dms1571PageObject.getLegalterm().click();
        withAction().pause(Duration.ofSeconds(2)).build().perform();
    }



    @And("user will click on next button and redirected to edit document screen.")
    public void user_will_click_on_next_button_and_redirected_to_edit_document_screen(){
        Assert.assertTrue(dms1571PageObject.getNext_button().isVisible());
        dms1571PageObject.getNext_button().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1571PageObject.getEditdocument_text().isVisible());
    }

    @And("User will able to see Document version information section with all respective information")
    public void User_will_able_to_see_Document_version_information_section_with_all_respective_information(){
        Assert.assertTrue(dms1571PageObject.getDocumentversionid_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getDocumenttype_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getAllowedcurrencies_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectedpartyprimebroker1_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectedpartyClient1text().isVisible());
        Assert.assertTrue(dms1571PageObject.getViewDetailButton_FOR_Client1().isVisible());
        if (dms1571PageObject.getDocumenttype_text().getText().equals("DN")){
            Assert.assertTrue(dms1571PageObject.getSelectedpartyExecutingBroker1_text().isVisible());
        } else if (dms1571PageObject.getDocumenttype_text().getText().equals("4 Way")) {
            Assert.assertTrue(dms1571PageObject.getSelectedpartyprimebroker2_text().isVisible());
            Assert.assertTrue(dms1571PageObject.getSelectedpartyClient2text().isVisible());
            Assert.assertTrue(dms1571PageObject.getViewDetailButton_FOR_Client2().isVisible());
        }
        dms1571PageObject.statuscheckforselectedparties();
    }

    @Given("User will click on Auth Scope tab and redirected to Auth Scope screen")
    public void user_will_click_on_auth_scope_tab_and_redirected_to_auth_scope_tab() {
        Assert.assertTrue(dms1571PageObject.getAuthScopeButton().isVisible());
        dms1571PageObject.getAuthScopeButton().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1571PageObject.getAuthproducts_text().isVisible());
    }

    @Given("User will be able to See all the Information, filters, buttons and required popupwindow")
    public void user_will_be_able_to_see_all_the_information_section_filters_button_and_required_popupwindow() {
        Assert.assertTrue(dms1571PageObject.getAuthproducts_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectproductgroup_filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getAssertclass_filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectproductfamily_filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelectproduct_filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getAuthCurrencies_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getAuthtenor_text().isVisible());
        Assert.assertTrue(dms1571PageObject.getAuthtenorvalue_filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getSelecttenor_filter().isVisible());
        Assert.assertTrue(dms1571PageObject.getAddauthlinebutton().isVisible());
        Assert.assertTrue(dms1571PageObject.getAddCurrencies_button().isVisible());
        dms1571PageObject.getAddCurrencies_button().click();
        Assert.assertTrue(dms1571PageObject.getCurrenciesandcurrenciespair_popuptext().isVisible());
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1571PageObject.getCancelbutton_currenciespopup().click();
    }

    @And("User will click on limit Scope tab and redirected to limit Scope screen")
    public void user_will_click_on_limit_scope_tab_and_redirected_to_limit_scope_screen() {
        Assert.assertTrue(dms1571PageObject.getLimitscope_tab().isVisible());
        dms1571PageObject.getLimitscope_tab().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1571PageObject.getCalculationtype_dropdown().isVisible());
    }





}
