package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1707PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1707Step extends PageObject {

    DMS_1707PageObject dms1707PageObject;

    @And("user clicks on the Add Edit query button, the query drawer will open")
    public void user_clicks_on_the_Add_Edit_query_button_the_query_drawer_will_open() {
        Assert.assertTrue(dms1707PageObject.getAddEditQuery_Button().isVisible());
        dms1707PageObject.getAddEditQuery_Button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1707PageObject.getQueryName_Text_ON_Drawer().isVisible());
    }

    @When("user enter the query name on the query drawer screen")
    public void user_enter_the_query_name_on_the_query_drawer_screen(DataTable dataTable) {
        Assert.assertTrue(dms1707PageObject.getQueryName_input().isVisible());
        dms1707PageObject.EnterQueryName(dataTable);
    }

    @When("User click on Add query block then Select Field dropdown is visible")
    public void user_click_on_add_query_blockhen_Select_Field_dropdown_is_visible() {
        Assert.assertTrue(dms1707PageObject.getAddQueryBlock_button().isVisible());
        dms1707PageObject.getAddQueryBlock_button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1707PageObject.getSelectField_dropdown().isVisible());
    }

    @Then("user select the field, the operator and value dropdown will become visible")
    public void user_select_the_field_the_operator_and_value_dropdown_will_become_visible(DataTable dataTable) {
        Assert.assertTrue(dms1707PageObject.getSelectField_dropdown().isVisible());
        dms1707PageObject.Selectfield(dataTable);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1707PageObject.getOperators_dropdown().isVisible());
        Assert.assertTrue(dms1707PageObject.getSelectValue_dropdown().isVisible());
    }

    @Then("User will select operator and value")
    public void user_will_select_operator_and_value(DataTable dataTable) {
        dms1707PageObject.Selectoperator(dataTable);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1707PageObject.SelectValue(dataTable);
    }

    @Then("User clicks on Apply, and reach the all documents listing screen")
    public void User_clicks_on_Apply_and_reach_the_all_documents_listing_screen() {
        Assert.assertTrue(dms1707PageObject.getSaveAndApply_button().isVisible());
        dms1707PageObject.getSaveAndApply_button().click();
        withAction().pause(Duration.ofSeconds(10)).build().perform();
        dms1707PageObject.getCreatenewDocument_button().waitUntilVisible();
        Assert.assertTrue(dms1707PageObject.getCreatenewDocument_button().isVisible());

    }

    @And("User will Click on Value Dropdown and able to see List of Value when Selected field is Document type")
    public void User_will_Click_on_Value_Dropdown_and_able_to_see_List_of_Value_when_Selected_field_is_Document_type(List<String> valuelist){
        Assert.assertTrue(dms1707PageObject.getSelectValue_dropdown().isVisible());
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1707PageObject.ValuelistforDocumentTypeField(valuelist);
    }

    @And("User will select operator")
    public void User_will_select_operator(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1707PageObject.getOperators_dropdown().isVisible());
        dms1707PageObject.Selectoperator(dataTable);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }



    @And("User will able to see Selected field and Value for Respective field")
    public void User_will_able_to_see_Selected_field_and_Value_for_Respective_field(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        dms1707PageObject.ColumnAndColumnValueCheck(dataTable);
    }


    @Then("user select the field, the operator and value input field will become visible")
    public void user_select_the_field_the_operator_and_value_input_field_will_become_visible(DataTable dataTable) {
        Assert.assertTrue(dms1707PageObject.getSelectField_dropdown().isVisible());
        dms1707PageObject.Selectfield(dataTable);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1707PageObject.getOperators_dropdown().isVisible());
        Assert.assertTrue(dms1707PageObject.getEntervalue().isVisible());
    }

    @Then("User will select operator and Enter value")
    public void user_will_select_operator_and_Enter_value(DataTable dataTable) {
        dms1707PageObject.Selectoperator(dataTable);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        dms1707PageObject.EnterValue(dataTable);
    }

    @When("User Click on Column Selection button")
    public void User_Click_on_Column_Selection_button(){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        Assert.assertTrue(dms1707PageObject.getColumnsSelection_button().isVisible());
        dms1707PageObject.getColumnsSelection_button().click();
        withAction().pause(Duration.ofSeconds(3)).build().perform();
    }

    @Then("User will search for column and select it if it is not already selected and able to see Selected Column on all Document Screen")
    public void User_will_search_for_column_and_select_it_if_it_is_not_already_selected_and_able_to_see_Selected_Column_on_Document_Screen(List<String> filters){
        dms1707PageObject.SelectitemfromColumnSelection(filters);
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1707PageObject.getApply_button().isVisible());
        dms1707PageObject.getApply_button().click();
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms1707PageObject.CheckFilterOnListingScreen(filters);
    }


//    @Then("User will search for column and select it if it is not already selected and able to see Selected Column EB-1 LEI and EB-1 LEI Name on all Document Screen")
//    public void User_will_search_for_column_and_select_it_if_it_is_not_already_selected_and_able_to_see_Selected_Column_EB1_LEI_and_EB1_LEI_Name_on_all_Document_Screen(List<String> filters){
//        dms1707QueryBuilder_changes_as_per_DocType_levelPageObject.SelectitemfromColumnSelection(filters);
//        withAction().pause(Duration.ofSeconds(3)).build().perform();
//        Assert.assertTrue(dms1707QueryBuilder_changes_as_per_DocType_levelPageObject.getApply_button().isVisible());
//        dms1707QueryBuilder_changes_as_per_DocType_levelPageObject.getApply_button().click();
//        withAction().pause(Duration.ofSeconds(4)).build().perform();
//        dms1707QueryBuilder_changes_as_per_DocType_levelPageObject.CheckFilterOnListingScreen(filters);
//    }


    @And("User will select LEI's for EB-1 LEI ID filter")
    public void User_will_select_LEIs_for_EB1_LEI_ID_filter(List<String> LEI_ID){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1707PageObject.getEB1_LEI_ID_Column_Input().isVisible());
        dms1707PageObject.SelectitemforEB1_LEI_ID_Column(LEI_ID);
    }

    @And("User will select LEI's Name for EB-1 LEI Name filter")
    public void  User_will_select_LEIsName_for_EB1_LEI_Name_filter(List<String> LEI_ID_NAME){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1707PageObject.getEB1_LEI_ID_Name_Column_Input().isVisible());
        dms1707PageObject.SelectitemforEB1_LEI_ID_Name_Column(LEI_ID_NAME);
    }

    @Then("User will Select doctype 4 Way and able to see No record found message on all Document Screen Because EB does't exist for 4 Way")
    public void User_will_Select_doctype_4Way_and_able_to_see_No_record_found_message_on_all_Document_Screen_Because_EB_doesnot_exist_for_4Way(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1707PageObject.getDoctype_column_Input().isVisible());
        dms1707PageObject.EnterDoctype(dataTable);
        Assert.assertTrue(dms1707PageObject.getNORecordFound_text().isVisible());
    }

    @Then("User will Select doctype DN and able to see correspondence result on all document Screen")
    public void User_will_Select_doctype_DN_and_able_to_see_correspondence_result_on_all_document_Screen(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1707PageObject.getDoctype_column_Input().isVisible());
        dms1707PageObject.EnterDoctype(dataTable);
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        dms1707PageObject.ColumnAndColumnValueCheck(dataTable);
    }

    @And("user will select LEI's for for Client-1 LEI ID filter")
    public void user_will_select_LEIsfor_for_Client1_LEI_ID_filter(List<String> Client1_LEI_ID){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1707PageObject.getClient1_LEI_ID_Name_Column_Input().isVisible());
        dms1707PageObject.Selectitemfor_Client1_LEI_ID_filter(Client1_LEI_ID);

//        Assert.assertTrue(dms1707QueryBuilder_changes_as_per_DocType_levelPageObject.getClient1LEIID_columnTEXT().isVisible());
//        dms1707QueryBuilder_changes_as_per_DocType_levelPageObject.getClient1LEIID_columnTEXT().click();


    }

    @Then("User will able to see Correspondence result for selected LEI's")
    public void User_will_able_to_see_Correspondence_result_for_selected_LEIs(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms1707PageObject.ColumnAndColumnValueCheck(dataTable);
    }

    @And("user will select value for Initiator filter")
    public void user_will_select_value_for_Initiator_filter(List<String> Initiator){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1707PageObject.getInitiator_column_Input().isVisible());
        dms1707PageObject.Selectitemfor_Initiator_Column(Initiator);

    }

}
