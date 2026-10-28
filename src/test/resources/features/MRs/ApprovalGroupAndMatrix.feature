@document_type=DN @Global_MRs
@ApprovalGroupAndMatrix
Feature: Validate one time data exists or not

Scenario: User creates an Empty Approval Group - Dataset for TC-2683
    Given User is on create new approval group screen
    Then User is able to see filters of group name, organisation name, LEI, org type and next button
    And User generates unique the group name,organization name,LEI's,org type
      | group name              | organisation name                     |doc type  | LEI's   | org type |
      | Automation_MR_AG_Empty_ | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       |OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    And User clicks on Next button
    And user is redirected to update approval group screen
    And User clicks on Cancel button
    And User validates for the Approval group name
      |group name             |
      |Automation_MR_AG_Empty_|

# Bug for admin user DMGS-6962
  Scenario: User creates an Approval Group and adds it to approval matrix - Dataset for TC-2683
    Given User is on create new approval group screen
    Then User is able to see filters of group name, organisation name, LEI, org type and next button
    And User generates unique the group name,organization name,LEI's,org type
      | group name                  | organisation name                       |doc type  | LEI's   | org type |
      | Automation_MR_AG_with_User_ | OSTTRA INDIA SERVICES PRIVATE LIMITED   | DN       |OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    And User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user navigates to approval matrix screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups
      | Document Action    | approval groups                 |
      | New Document       | Automation_MR_AG_with_User_     |
    And User will click on Submit Button
    And user validates the approval matrix screen


  Scenario: User adds an approval Group to approval matrix - Dataset for DF
    Given user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups
      | Document Action    | approval groups                      | Approval Sequence |
      | New Document       | Automation_OT_ApprovalGroup_DN_Osttra| 1                 |
    And User will click on Submit Button
    And user will click on submit button on Approval matrix Confirmation screen
    And user validates the approval matrix screen

Scenario: User creates an Empty Approval Group - Dataset for @DMGS=7542
  Given User is on create new approval group screen
  And User is able to see filters of group name, organisation name, LEI, org type and next button
  And User generates unique the group name,organization name,LEI's,org type
    | group name              | organisation name                     |doc type  | LEI's   | org type |
    | Automation_MR_AG_TBU    | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    |OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
  And User clicks on Next button
  And user is redirected to update approval group screen
  And User clicks on Cancel button
  And User validates for the Approval group name
    |group name             |
    |Automation_MR_AG_TBU   |

  # Failed due to Bug DMGS-8060
  @DMGS-8030 @TC-01 @TC-02 @TC-03
  Scenario: Verify Apply All functionality for Approval Groups( DN )
    Given user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups
      | Document Action    | approval groups           | Approval Sequence |
      | New Document       | Automation_OT_ApprovalGroup_DN_Osttra    | 1                 |
    And user will click on Apply All button
    Then user validate that approval group has been selected for all the action type
      | Document Action          | Expected Approval Group   |
      | New Document             |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Approval Workflow   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Enforcement Rules   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document Terms      |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Currency          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Products          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Terminate Document       |Automation_OT_ApprovalGroup_DN_Osttra|
      | Apply USP Rider          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Limit               |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document            |Automation_OT_ApprovalGroup_DN_Osttra|
    And User will click on Submit Button
    And user will click on submit button on Approval matrix Confirmation screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |DN             |
    And user clicks on the update button
    Then user clears the approval groups to reset data
      | Document Action          | Expected Approval Group   |
      | Edit Approval Workflow   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Enforcement Rules   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document Terms      |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Currency          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Products          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Terminate Document       |Automation_OT_ApprovalGroup_DN_Osttra|
      | Apply USP Rider          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Limit               |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document            |Automation_OT_ApprovalGroup_DN_Osttra|
    And User will click on Submit Button
    And user will click on submit button on Approval matrix Confirmation screen
    And user validates the approval matrix screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |DN             |
    And user clicks on the update button
    And user click on Sequential checkbox
    And User click on confirm button
    Then user will select document action and approval groups
      | Document Action    | approval groups                          | Approval Sequence |
      | New Document       | Automation_OT_ApprovalGroup_DN_Osttra    | 1                 |
    And user will click on Apply All button
    Then user validate that approval group has been selected for all the action type
      | Document Action          | Expected Approval Group   |
      | New Document             |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Approval Workflow   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Enforcement Rules   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document Terms      |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Currency          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Products          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Terminate Document       |Automation_OT_ApprovalGroup_DN_Osttra|
      | Apply USP Rider          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Limit               |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document            |Automation_OT_ApprovalGroup_DN_Osttra|
    And User will click on Submit Button
    And user will click on submit button on Approval matrix Confirmation screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |DN             |
    And user clicks on the update button
    Then user clears the approval groups to reset data
      | Document Action          | Expected Approval Group   |
      | Edit Approval Workflow   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Enforcement Rules   |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document Terms      |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Currency          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Remove Products          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Terminate Document       |Automation_OT_ApprovalGroup_DN_Osttra|
      | Apply USP Rider          |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Limit               |Automation_OT_ApprovalGroup_DN_Osttra|
      | Edit Document            |Automation_OT_ApprovalGroup_DN_Osttra|