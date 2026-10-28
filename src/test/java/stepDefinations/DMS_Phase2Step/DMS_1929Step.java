package stepDefinations.DMS_Phase2Step;

import PageObjects.DMS_PHASE2PageObject.DMS_1929PageObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

public class DMS_1929Step extends PageObject {


    DMS_1929PageObject dms1929usershould_be_able_to_filter_document_listings_through_the_users_email_IDPageObject;


    @And("User is able to see Valid Email Address for Last Updated By filter if is data present")
    public void User_is_able_to_see_Valid_Email_Address_for_Last_Updated_By_filter_if_is_data_present(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms1929usershould_be_able_to_filter_document_listings_through_the_users_email_IDPageObject.CheckEmailforLastUpdatedBY_Column(dataTable);
    }

    @And("user will select user for Last Updated By filter")
    public void user_will_select_user_for_Last_Updated_By_filter(List<String> LastUpdatedBY){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        Assert.assertTrue(dms1929usershould_be_able_to_filter_document_listings_through_the_users_email_IDPageObject.getLastUpdatedBY_Column_Input().isVisible());
        dms1929usershould_be_able_to_filter_document_listings_through_the_users_email_IDPageObject.Selectitemfor_LastUpdatedBY_filter(LastUpdatedBY);
    }

    @Then("User will able to see Correspondence result for selected value for Last Updated By filter")
    public void User_will_able_to_see_Correspondence_result_for_selected_value_for_Last_Updated_By_filter(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(2)).build().perform();
        dms1929usershould_be_able_to_filter_document_listings_through_the_users_email_IDPageObject.ColumnAndColumnValueCheck(dataTable);
    }

    @And("User is able to see Documents according to set Query Block")
    public void User_is_able_to_see_Documents_according_to_set_Query_Block(DataTable dataTable){
        withAction().pause(Duration.ofSeconds(4)).build().perform();
        dms1929usershould_be_able_to_filter_document_listings_through_the_users_email_IDPageObject.ColumnAndColumnValueCheck(dataTable);
    }


}
