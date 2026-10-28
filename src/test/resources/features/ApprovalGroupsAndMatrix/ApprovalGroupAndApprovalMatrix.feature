@ApprovalGroupAndApprovalMatrix @Regression
@ApprovalMatrix

Feature: Empty Approval group and approval matrix validations

    @TC-1339 @TC-1799
    Scenario: Edit approval matrix and add the Approval Group - DN
        Given user is on approval matrix listing screen
        When user searches for a approval matrix and validates the results
            |approval matrix                        |LEI name                               |org type filter|doc type filter|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED  |OSTTRA INDIA SERVICES PRIVATE LIMITED  |PB             |DN             |
        Then User clicks on update button
        And user reaches on the update screen of the approval matrix
        Then User validates the approval matrix information
            |Organisation name                          |Doc type|Legal entity name                     |Org type|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED      |DN      |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB      |
        And User validates the document action dropdown
        Then user will select document action and approval groups
            | Document Action     | approval groups                      | Approval Sequence |
            | Edit Document Terms | Automation_OT_ApprovalGroup_DN_Osttra| 1                 |
        And User will click on Submit Button
        #And user will click on Submit button of confirmation pop-up
        #And user validates the approval matrix screen

    @TC-1747
    Scenario: User can remove approval groups from approval matrix
        Given user is on approval matrix listing screen
        When user searches for a approval matrix and validates the results
            |approval matrix |LEI name  |org type filter|doc type filter|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
        And User clicks on update button
        Then User will search for the approval group to be removed from approval matrix and remove it
            | Document Action     | Approval Sequence |
            | Edit Document Terms | 1                 |
        And User will click on Submit Button
        And user will click on Submit button of confirmation pop-up
        And user validates the approval matrix screen

    @TC-2683
    Scenario: DN - Validate that User is not able to add an Approval group with no users in an existing Approval matrix and gets the error message "User not present for Approval group --"
        Given user is on approval matrix listing screen
        When user searches for a approval matrix and validates the results
            |approval matrix |LEI name  |org type filter|doc type filter|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
        Then User clicks on update button
        And user validates the update approval matrix screen
        Then user will select document action and approval groups
            | Document Action           | approval groups        | Approval Sequence |
            | Edit Approval Workflow    | Automation_MR_AG_Empty_| 1                 |
        And User will click on Submit Button
        And user will click on Submit button of confirmation pop-up
        And user validates the Approval group warning message

    @TC-1799
    Scenario: 4way -Approval Group which the user belongs to is added to Approval Matrix
        Given user is on approval matrix listing screen
        When user searches for a approval matrix and validates the results
            |approval matrix |LEI name  |org type filter|doc type filter|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |4 Way          |
        Then User clicks on update button
        And user validates the update approval matrix screen
        Then user will select document action and approval groups
            | Document Action          | approval groups                        | Approval Sequence |
            | Edit Approval Workflow   | Automation_OT_ApprovalGroup_4way_Osttra| 1                 |
        And User will click on Submit Button
        And user will click on Submit button of confirmation pop-up
        And user validates the approval matrix screen

    @TC-2355
    Scenario: Updating an Approval Matrix for Doc type 4way- Validate that Submit button is disabled
        Given user is on approval matrix listing screen
        When user searches for a approval matrix and validates the results
            |approval matrix |LEI name  |org type filter|doc type filter|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |4 Way          |
        Then User clicks on update button
        And user validates the update approval matrix screen
        Then user will select document action and approval groups
            | Document Action    | approval groups                        | Approval Sequence |
            | New Document       | Automation_OT_ApprovalGroup_4way_Osttra| 1                 |
        And User validates Submit button is disabled

    @TC-1800
    Scenario: 4way - Approval Group which the user belongs to is removed from Approval Matrix
        Given user is on approval matrix listing screen
        When user searches for a approval matrix and validates the results
            |approval matrix |LEI name  |org type filter|doc type filter|
            |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |4 Way          |
        Then User clicks on update button
        Then User will search for the approval group to be removed from approval matrix and remove it
            | Document Action           | Approval Sequence |
            | Edit Approval Workflow    | 1                 |
        And User will click on Submit Button
        And user will click on Submit button of confirmation pop-up
        Then User validates the message
            |Approval matrix updated successfully|


  @ResetData
  Scenario: data reset Approval Groups( DN )
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