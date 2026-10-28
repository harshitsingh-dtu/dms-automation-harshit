@ApprovalGroupAmendments4Way @Regression @US=DMGS-7552
@ApprovalMatrix  @ApprovalGroup

Feature: Workflow for Approval Groups and Approval Matrix Amendments in 4 Way

  @Sanity @TC-1333 @TC-1395 @TC=1389 @TC=6105 @TC=03 @TC=04 @TC=05 @TC=06 @TC=07 @TC=10
  Scenario: Validate deletion error message of an approval group if it is linked to an approval matrix for 4 Way
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name                      | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_with_User_Sanity  | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    Then user clicks on the update button
    Then user will select document action and approval groups
      | Document Action | approval groups                   | Approval Sequence |
      | New Document    | Automation_AG_with_User_Sanity    | 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    Then User will navigate to approval group listing screen
    And User selects the status
      |Status  |
      |Active  |
    When User searches for Approval group name in the search bar
      | group name                       |
      | Automation_AG_with_User_Sanity   |
    Then User clicks on Delete button for approval group
    Then User validates the delete message on the popup
    Then User clicks on the No button on popup
    Then User redirects to approval group screen with no action performed
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently|

  @Sanity
  Scenario: Validate deletion of an approval group when it's unlinked to an approval matrix for 4 Way
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    Then user clicks on the update button
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                       |
      | Automation_AG_with_User_Sanity   |
    Then User clicks on Delete button for approval group
    Then User clicks on Yes button
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    Then user clicks on the update button
    Then Add a deleted approval group in approval matrix to check whether it is still present
      | Document Action | approval groups                  | Approval Sequence |
      | New Document    | Automation_AG_with_User_Sanity   | 1                 |

  @CreatingApprovalGroup
  Scenario: Creating approval group for further operations
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name                      | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_with_User_TBD_02  | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And User will submit the changes after adding users to the approval group
    And User click on create new approval group button
    And User generates unique the group name,organization name,LEI's,org type
      | group name                      | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_with_User_TBD_03  | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And User will submit the changes after adding users to the approval group
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    Then user clicks on the update button
    Then user will select document action and approval groups
      | Document Action | approval groups                 | Approval Sequence |
      | New Document    | Automation_AG_with_User_TBD_02  | 1                 |
    Then user will select document action and approval groups
      | Document Action | approval groups                 | Approval Sequence |
      | New Document    | Automation_AG_with_User_TBD_03  | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up

  @TC=11 @TC=12
  Scenario: Check approval group deletion over different 4 Way "Draft" status
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86               |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 743700BTHBACD5DF5C04                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 9845008BSEED6B1A9984                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 6SHGI4ZSSLCXXQSBB395                |
      | client2OrgTypeKey | 3                                    |
    Given User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | 1355 STORM PARKWAY LLC                |
      | Prime Broker 2 | Vladisart Oy                          |
      | Client 2       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User click on Approval Workflow in 4 Way
    Then User will use drag and drop PB1 to approval Seq 1 in 4W Document
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    Then User clicks on Next button
    Then User clicks on Cancel button
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                      |
      | Automation_AG_with_User_TBD_02  |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group

  Scenario: Check approval group deletion over different 4 Way "in-approval" status
    Given User will go to Document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | PB-2 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are present in pop-up
      | AOA |
    And click on the submit button on pop up screen
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User clicks on Next button
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 1000000         |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    And User clicks on submit for approval button
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                      |
      | Automation_AG_with_User_TBD_02  |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group
    When User searches for Approval group name in the search bar
      | group name                      |
      | Automation_AG_with_User_TBD_03  |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group

  @TC=13 @TC=14 @TC=15
  Scenario: Check approval group deletion over "Approved" status for doc for second approver
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | In-approval                           |
    And Clicks on Approve Button for approval Group
    And Click on Approve button of popup
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                      |
      | Automation_AG_with_User_TBD_02  |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group

 @ResetData @DocumentTermination
 Scenario: Terminate the document created
   Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Enforced                              |
    Then User clicks on Terminate button
    Then User will click submit button on the terminate confirmation pop up

  @ResetData @ApprovalMatrixReset
  Scenario: Resetting the Approval Matrix sequence 2
    Given user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                         |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |4 Way          |
    Then User clicks on update button
    And user validates the update approval matrix screen
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action     | Approval Sequence |
      | New Document        | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    And user validates the approval matrix screen

  @ResetData @ApprovalMatrixReset @Sanity
  Scenario: Resetting the Approval Matrix as per OT script
    Given user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                         |LEI name                              |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |OSTTRA INDIA SERVICES PRIVATE LIMITED |PB             |4 Way          |
    Then User clicks on update button
    And user validates the update approval matrix screen
    Then user will select document action and approval groups
      | Document Action    | approval groups                        | Approval Sequence |
      | New Document       | Automation_OT_ApprovalGroup_4way_Osttra| 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    And user validates the approval matrix screen

  @ResetData @ApprovalGroupDeletion
  Scenario: Delete the approval groups created
    Given User is on Approval group screen
    And User selects the status
      |Status  |
      |Active  |
    When User searches for Approval group name in the search bar and validates
      |group name                     |
      |Automation_AG_with_User_TBD_02 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |Approval group deleted successfully|
    Then User searches for Approval group name in the search bar and validates
      |group name                     |
      |Automation_AG_with_User_TBD_03 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |Approval group deleted successfully|