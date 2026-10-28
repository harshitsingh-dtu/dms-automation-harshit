package stepDefinations.DMS_Phase2Step;

import io.cucumber.java.en.And;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import PageObjects.DMS_PHASE2PageObject.Bulk_Edit_Document_Doc_type_DN_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1525_PageObject;
import PageObjects.DMS_PHASE2PageObject.DMS_1708_PageObject;

import java.time.Duration;
import java.util.List;

public class DMS_1708_Step extends PageObject
{     DMS_1708_PageObject DMS_1708;
      DMS_1525_PageObject Validation_of_Document_Listing_screen_for_Doc;
    Bulk_Edit_Document_Doc_type_DN_PageObject bulkEditDocumentDocTypeDnPageObject;



    @And("Verify error msg if user havent DN roles assign and user is going to select DN doc type")
    public void verifyErrorMsgIfUserHavenTDNRolesAssignAndUserIsGoingToSelectDNDocType(List<String> document_type)
    {
        DMS_1708.select_doc_type_while_assigning_LEI(document_type);
        Assert.assertEquals("The user doesn't have access to this document type.".toLowerCase(),DMS_1708.getToast_msg().getText().toLowerCase());

    }

    @And("Verify error msg if user havent four way roles assign and user is going to select four way doc type")
    public void verifyErrorMsgIfUserHavenTFourWayRolesAssignAndUserIsGoingToSelectfourwayDocType(List<String> document_type)
    {
        DMS_1708.select_doc_type_while_assigning_LEI(document_type);
        Assert.assertEquals("The user doesn't have access to this document type.".toLowerCase(),DMS_1708.getToast_msg().getText().toLowerCase());
    }

    @And("Verify DN LEIOrgtype Mapping should NOT Added on user management update screen")
    public void verifyDN_LEIOrgtypeMappingShouldNOTAddedOnUserManagementUpdateScreen()
    {
        Assert.assertFalse(DMS_1708.getAssigned_LEI_with_DN().isVisible());
    }

    @And("Verify four Way LEIOrgtype Mapping should NOT Added on user management update screen")
    public void verifyFourWay_LEIOrgtypeMappingShouldNOTAddedOnUserManagementUpdateScreen()
    {
        withAction().pause(Duration.ofSeconds(3)).build().perform();
        Assert.assertFalse(DMS_1708.getAssigned_LEI_with_4W().isVisible());
    }

    @And("Verify roles which are already assign should be visible in Selected roles section")
    public void verifyRolesWhichAreAlreadyAssignShouldBeVisibleInSelectedRolesSection(List<String>roles)
    {
        for (int begin = 1; begin < roles.size(); begin++)
        {
            Assert.assertTrue(DMS_1708.getSelectedRoles().getText().contains(roles.get(begin)));
        }
    }

    @And("Verify user can see document types according assign role")
    public void verifyUserCanSeeDocumentTypesAccordingAssignRole(List<String>Doc_types)
    {
        bulkEditDocumentDocTypeDnPageObject.getDoctype().click();
        for (int begin = 1; begin < Doc_types.size(); begin++)
        {
            Assert.assertTrue(DMS_1708.getDoc_types_list().getText().contains(Doc_types.get(begin)));
        }
    }
}
