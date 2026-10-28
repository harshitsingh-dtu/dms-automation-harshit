@ApprovalGroupUpdateANDAuditTrial @Regression
@ApprovalGroup @DMGS-7551 @DMGS-7542

Feature: Approval Group name amendment

@TC-01 @ApprovalGroupResetCheck
Scenario: Verify use of 'Update' action for renaming
    Given user navigates to Approval group screen
    When User validates the search field
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name|
        |Automation_OT_ApprovalGroup_4way_Osttra|
    And user will be able to see update button
    Then User clicks on update button
    And user is redirected to update approval group screen
    Then User updates the group name
        |Approval Group Name                           |
        |Automation_OT_ApprovalGroup_4way_Osttra_testRename   |
    Then User will click on Submit Button
   # And user will click on Submit button of confirmation pop-up
    And user will click on Confirm button of confirmation pop-up
    Then User validates the message
        |Group name updated successfully|

#    Failing due to bug
@TC-02 @ignore
Scenario: Verify An 'Ok' advisory message appears: "All existing Approval Matrices that use this Approval Group will have their name updated automatically."
    Given User is on Approval group screen
    When User validates the search field
    When User searches for Approval group name in the search bar and validates
        |group name|
        |Automation_AG_empty_test_|

@TC-03 @TC-12
Scenario: Verify the name update in Approval Matrix
    Given user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
        |approval matrix                        |LEI name                              |org type filter|doc type filter|
        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |4 Way          |
    Then user clicks on the update button
    And user validates the update approval matrix screen
    Then User validates for the updated Approval group name in Approval matrix
        |Automation_OT_ApprovalGroup_4way_Osttra_testRename  |

@TC-05 @TC-8348
Scenario: Validate the basic input validations
    Given User is on create new approval group screen
    When User fills the group name,organization name,doc type,LEI's,org type
        | group name                                 | organisation name                        | doc type | LEI's          | org type |
        |Automation_OT_ApprovalGroup_4way_Osttra_testRename | OSTTRA INDIA SERVICES PRIVATE LIMITED    | 4 Way    |OSTTRA INDIA SERVICES PRIVATE LIMITED|PB       |
    Then clicks on next
  Then User waits for 3 seconds
    Then User validates the toast message
      |Group name already exists |

#Failing due to bug
#@TC_10 @TC_13
#Scenario: Validate approval group name change in Track for EDN
#    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#        |Column Name                   |value                                   |
#        |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
#        |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED          |
#        |Client-1 Legal Entity Name    |ACE URBAN RACE PRIVATE LIMITED          |
#        |Document Status               |In-approval                             |
#    And User will click on Track button on the document screen
#    And User will be redirected to the track screen
#    And User Validates the approval group name in Track
#        |Approval Group                               |
#        |Automation_OT_ApprovalGroup_4way_Osttra_testRename  |

#@TC_16 @TC_17
#Scenario: Validate approval group name change in Bulk edit Approve/Reject screen
#    Given User is on Document Page
#    Then User clicks on Bulk Action button
#    And User selects Reject from Bulk Action menu
#    Then User will select doc type for reject
#        | Doc Type |
#        | 4 way   |
#    Then User will select acting as LEIs for reject
#        | Acting as      |
#        | 254900SLCV8KI86BHL86 (PB)|
#    And User will select approval group for reject
#        | Approval Group                              |
#        |Automation_OT_ApprovalGroup_4way_Osttra_testRename  |
#    And Validate No options should Not be displayed
#    Then User clicks on Cancel button
#    Then User clicks on Bulk Action button
#    And User selects Reject from Bulk Action menu
#    Then User will select doc type for reject
#        | Doc Type |
#        | 4 way   |
#    Then User will select acting as LEIs for reject
#        | Acting as                 |
#        |254900SLCV8KI86BHL86 (PB)  |
#    And User will select approval group for reject
#        | Approval Group                               |
#        | Automation_OT_ApprovalGroup_4way_Osttra_testRename  |
#    And Validate No options should Not be displayed

#@TC_18 - To be done
#Scenario: Validate Unauthorized Role Access
#    Given User will login as PB-Citigroup
#    Given User is on Approval group screen
#    When User validates the search field
#    When User searches for Approval group name in the search bar and validates
#        |group name|
#        |Automation_OT_ApprovalGroup_4way_Osttra_testRename|
#    And user will be able to see View button

@TC-05 @TC-06 @TC-07 @TC-08 @TC_18
Scenario: Validate the validations & multiple updates
    Given User is on Approval group screen
    When User validates the search field
    When User searches for Approval group name in the search bar and validates
        |group name|
        |Automation_OT_ApprovalGroup_4way_Osttra_testRename |
    And user will be able to see update button
    Then User clicks on update button
    And user is redirected to update approval group screen
    Then User updates the group name
        |Approval Group Name |
        | |
    Then user validates Submit button is disabled
    Then User updates the group name
        |Approval Group Name                        |
        | Automation_OT_ApprovalGroup_4way_Osttra   |
    Then User will click on Submit Button
    And user will click on Confirm button of confirmation pop-up
    Then User validates the message
        |Group name updated successfully|

#TC_09 TC_11  TC_14 TC_15 - Pending with Akshita to provide data
#    TC_20 & TC_21 - To be done by Akshita

@DMGS=7542 @TC-01 @TC-02 @TC-03 @TC-06 @TC-08
Scenario: Validate the Audit Trail for Approval Group Update
    Given User is on Approval group screen
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name                              |
        |Automation_OT_ApprovalGroup_4way_Osttra |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    And User Validates the data on Approval Group Audit history Screen
        | Group Name                              | Audit Event  | Date     | Updated By                    | Event Changes |
        | Automation_OT_ApprovalGroup_4way_Osttra | Update Group | Current  |hsbc.test1@testsso.osttra.com  | Approval group name updated: From "Automation_OT_ApprovalGroup_4way_Osttra_testRename" to "Automation_OT_ApprovalGroup_4way_Osttra" |

@DMGS=7542 @TC-05 @TC-07
Scenario: Validate the Audit Trail for Approval Group creation
    Given User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
        | group name                        | organisation name                         | doc type | LEI's      | org type |
        |Automation_AG_with_User_AuditTrial | OSTTRA INDIA SERVICES PRIVATE LIMITED     | 4 Way    | OSTTRA     | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    Then User clicks on Cancel button
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    And User Validates the data on Approval Group Audit history Screen
        | Group Name                              | Audit Event  | Date     | Updated By                    | Event Changes                                                   |
        | Automation_AG_with_User_AuditTrial      | Create Group | Current  |hsbc.test1@testsso.osttra.com  | Approval group Created: Automation_AG_with_User_AuditTrial      |
    Then User clicks on close button

@DMGS=7542 @TC-17
Scenario: Validate the Audit Trail for Approval Group user added
    Given User is on Approval group screen
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on update button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
        |user                         |
        |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    Then User validates the message
        |1 user added successfully|
    Then User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    And User Validates the data on Approval Group Audit history Screen
        | Group Name                              | Audit Event  | Date     | Updated By                    | Event Changes                                 |
        | Automation_AG_with_User_AuditTrial      | Update Group | Current  |hsbc.test1@testsso.osttra.com  |Users added: hsbc.test1@testsso.osttra.com     |
    Then User clicks on close button

@DMGS=7542 @TC-18
Scenario: Validate the Audit Trail for Approval Group user deleted
    Given User is on Approval group screen
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on update button
    And user is redirected to update approval group screen
    And User will search for the users to be removed and remove them
        |user                         |
        |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    Then User validates the message
        |1 user removed successfully|
    Then User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    And User Validates the data on Approval Group Audit history Screen
        | Group Name                              | Audit Event  | Date     | Updated By                    | Event Changes                                 |
        | Automation_AG_with_User_AuditTrial      | Update Group | Current  |hsbc.test1@testsso.osttra.com  |Users removed: hsbc.test1@testsso.osttra.com     |
    Then User clicks on close button

@DMGS=7542 @TC-15
Scenario: Validate that if No Update and then nothing is updated logs
    Given User is on Approval group screen
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    Then User captures the number of rows
    Then User clicks on close button
    Then User clicks on update button
    Then User clicks on Cancel button
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    Then User validates the the number of rows

@DMGS=7542 @TC-09 @TC-10 @TC-04 @DMGS-7552_09
Scenario: Validate the Deletion of approval group & verify in audit trail
    Given User is on Approval group screen
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
     #Then User clicks on Delete icon
    Then User clicks on Delete icon for Approval Group
    Then Click on Yes button of popup
    Then User validates the message
        |Approval group deleted successfully|
    And User selects the status
        |Status  |
        |Inactive|
    When User searches for Approval group name in the search bar and validates
        |group name                         |
        |Automation_AG_with_User_AuditTrial |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    And User Validates the data on Approval Group Audit history Screen
        | Group Name                              | Audit Event  | Date     | Updated By                    | Event Changes                                                         |
        | Automation_AG_with_User_AuditTrial      | Delete Group | Current  |hsbc.test1@testsso.osttra.com  |Approval group Status: From Active to Inactive  |
    Then User clicks on close button

@DMGS=7542 @TC-09 @TC-16  @MultiUserApprovalGroupResetCheck
Scenario: Validate the Multi User Update for Approval Group
    #Given User is on Approval group screen
    Given user navigates to Approval group screen
    And User selects the status
        |Status  |
        |Active  |
    When User searches for Approval group name in the search bar and validates
        |group name           |
        |Automation_MR_AG_TBU |
    And user will be able to see update button
    Then User clicks on update button
    And user is redirected to update approval group screen
    Then User updates the group name
        |Approval Group Name    |
        |Automation_MR_AG_Test01  |
    Then User will click on Submit Button
    And user will click on Confirm button of confirmation pop-up
    Then User validates the toast message
        |Group name updated successfully|
    Then User searches for Approval group name in the search bar and validates
        |group name            |
        |Automation_MR_AG_Test01 |
    Then User clicks on Audit button for Approval Group
    And User Validates the Approval Group Audit history Screen
    And User Validates the data on Approval Group Audit history Screen
        | Group Name              | Audit Event  | Date     | Updated By                    | Event Changes                                                                         |
        | Automation_MR_AG_Test01   | Update Group | Current  |hsbc.test1@testsso.osttra.com  |Approval group name updated: From "Automation_MR_AG_TBU" to "Automation_MR_AG_Test01"    |

  @ResettingTheData
  Scenario: Reset the data for Multi User Update for Approval Group .
    Given user navigates to Approval group screen
    When User validates the search field
    And User selects the status
      |Status  |
      |Active  |
    When User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_MR_AG_Test01|
    And user will be able to see update button
    Then User clicks on update button
    And user is redirected to update approval group screen
    Then User updates the group name
      |Approval Group Name|
      |Automation_MR_AG_TBU|
    Then User will click on Submit Button
    And user will click on Confirm button of confirmation pop-up
    Then User validates the message
      |Group name updated successfully|



#    @DMGS=7542 @TC-16
#    Scenario: Validate the Multi User Update for Approval Group
#        Given User logs in as PB - OSTTRADE
#        Given User is on Approval group screen
#        And User selects the status
#            |Status  |
#           |Active  |
#        When User searches for Approval group name in the search bar and validates
#            |group name              |
#            |Automation_MR_AG_test   |
#        And user will be able to see update button
#        Then User clicks on update button
#        And user is redirected to update approval group screen
#        Then User updates the group name
#            |Approval Group Name    |
#            |Automation_MR_AG_TBU   |
#        Then User will click on Submit Button
#        Then User validates the message
#            |Group name updated successfully.|
#        Then User searches for Approval group name in the search bar and validates
#            |group name            |
#            |Automation_MR_AG_TBU  |
#        Then User clicks on Audit button for Approval Group
#        And User Validates the Approval Group Audit history Screen
#        And User Validates the data on Approval Group Audit history Screen
#            | Group Name              | Audit Event  | Date     | Updated By                    | Event Changes                                                                          |
#            | Automation_MR_AG_TBU    | Update Group | Current  |hsbc.test1@testsso.osttra.com  |Approval group name updated: From "Automation_MR_AG_test" to " Automation_MR_AG_TBU"    |
#
#    @DMGS=7542 @TC-13
#    Scenario: Validate the Multi User Update for Approval Group
#        Given User logs in as PB - Citigroup
#        Given User is on Approval group screen
#        And User selects the status
#           |Status  |
#           |Active  |
#        When User searches for Approval group name in the search bar and validates
#            |group name             |
#            |Automation_MR_AG_TBU   |
#        Then User validates no record found

#11
