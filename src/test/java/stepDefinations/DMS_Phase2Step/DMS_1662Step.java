package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1662PageObject;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1662Step extends PageObject {

    DMS_1662PageObject dms1662_PageObject;

    @Then("User will able to see all the information, filters and columns")
    public void User_will_able_to_see_all_the_information_filters_and_columns(){
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertTrue(dms1662_PageObject.getBulkRequest_text().isVisible());
        Assert.assertTrue(dms1662_PageObject.getSearchBox_BatchID().isVisible());
        Assert.assertTrue(dms1662_PageObject.getDocumentInitiator_Filter().isVisible());
        Assert.assertTrue(dms1662_PageObject.getDocumentAction_Filter().isVisible());
        Assert.assertTrue(dms1662_PageObject.getBatchID_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getDocType_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getActionType_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getInitiator_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getBatchStatus_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getTotal_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getInProcess_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getProcessed_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getNOTProcessed_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getFailed_Column().isVisible());
        Assert.assertTrue(dms1662_PageObject.getLast_UpdateON_Column().isVisible());

    }

    @And("User will click on Document Action filter and be able to see all the data items inside the filter")
    public void User_will_click_on_Document_Action_filter_and_be_able_to_see_all_the_data_items_inside_the_filter(List<String> DocAction){
        dms1662_PageObject.filteredActionItem(DocAction);
    }

    @And("User can click on the Document Initiator filter, select an item, and view the results for the chosen Document Initiator")
    public void User_can_click_on_the_Document_Initiator_filter_select_an_item_and_view_the_results_for_the_chosen_Document_Initiator(DataTable dataTable){
        dms1662_PageObject.typeintoDocumentInitiator_Filter(dataTable);
    }
    @And("User can click on the Document Action filter, select an item, and view the results for the chosen Document Action")
    public void User_can_click_on_the_Document_Action_filter_select_an_item_and_view_the_results_for_the_chosen_Document_Action(DataTable dataTable){
        dms1662_PageObject.typeintoDocumentAction_Filter(dataTable);
    }

    @And("User will click on View detail button and redirected to Batch details Screen")
    public void User_will_click_on_View_detail_button_and_redirected_to_Batch_details_Screen(){
       Assert.assertTrue(dms1662_PageObject.getViewDetail_button().isVisible());
        dms1662_PageObject.getViewDetail_button().click();
        withAction().pause(Duration.ofSeconds(5)).build().perform();
        Assert.assertTrue(dms1662_PageObject.getBatchDetail_text().isVisible());
    }

    @And("Users will click on the Batch Status filter and be able to see all the data items inside the filter")
    public void User_will_click_on_the_Batch_Status_filter_and_be_able_to_see_all_the_data_items_inside_the_filter(List<String> BatchStatus){
        dms1662_PageObject.filteredBatchStatus(BatchStatus);
    }

}
