@ApprovalGroupAmendmentsInDF @Regression @US=DMGS-7552 @US=DMGS-3690

Feature: Workflow for Approval Groups and Approval Matrix Amendments in DF(make sure approval matrix should be sequential)

  @CreatingApprovalGroupsForDF
  Scenario: Creating approval group for further operations for DF
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name                                 | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_Approval_Group_Testing_AGT1_008 | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And User will submit the changes after adding users to the approval group
    And User click on create new approval group button
    And User generates unique the group name,organization name,LEI's,org type
      | group name                                 | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_Approval_Group_Testing_AGT1_009 | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And User will submit the changes after adding users to the approval group
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then User click on seqential sequence
    Then user will select document action and approval groups
      | Document Action | approval groups                            | Approval Sequence |
      | New Document    | Automation_Approval_Group_Testing_AGT1_008 | 1                 |
    Then User adds Sequential Column in Approval Matrix Screen
    Then user will select document action and approval groups
      | Document Action | approval groups                            | Approval Sequence |
      | New Document    | Automation_Approval_Group_Testing_AGT1_009 | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up

  @CreateADF
  Scenario: Check approval group deletion for doc on various states
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants     |Document_Action           |Approval_sequence|
      |Prime Broker - 1 |New Document Framework    |1                |
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    And User clicks on Save As Draft button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are deliverable in pop-up
      | JPY |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User clicks on Next button
    Then User will input Calculation Type
      | Calculation Type |
      | DSL              |
    * User will input Netting Type
      | Netting Type        |
      | Gross excluding USD |
    And User enter Bullion Trades in Limit Scope
      | Include Metals |
    Then User will input Delta
      | Delta |
      | No    |
    Then User will input Product family
      | Product Family |
      | Cash           |
    * User will input Exclude CLS from calculation
      | Exclude CLS |
      | No          |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    And user will select Column Values on Document Framework screen
      | Column Name          | value                                 |
      | PB Name | OSTTRA INDIA SERVICES PRIVATE LIMITED              |
      | EB Name | Koudenburg B.V.                                    |
      | Lifecycle status     | In-approval                           |
    And Clicks on Approve Button for approval Group
    And Click on Approve button of popup
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AGT1_008 |
    When the user selects active from the Status filter
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name          | value                                 |
      | PB Name | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name | Koudenburg B.V.                       |
      | Lifecycle status     | In-approval                           |
    And Clicks on Approve Button for approval Group
    And Click on Approve button of popup
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AGT1_009 |
    When the user selects active from the Status filter
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group

  @RejectDocScenario
  Scenario: Check approval group deletion over Reject status for doc
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name          | value                                 |
      | PB Name | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name | Koudenburg B.V.                       |
      | Lifecycle status     | Approved                              |
    Then User clicks on Terminate button
    Then Click on Yes button of popup
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants     |Document_Action           |Approval_sequence|
      |Prime Broker - 1 |New Document Framework    |1                |
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    And User clicks on Save As Draft button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are deliverable in pop-up
      | JPY |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User clicks on Next button
    Then User will input Calculation Type
      | Calculation Type |
      | DSL              |
    * User will input Netting Type
      | Netting Type        |
      | Gross excluding USD |
    And User enter Bullion Trades in Limit Scope
      | Include Metals |
    Then User will input Delta
      | Delta |
      | No    |
    Then User will input Product family
      | Product Family |
      | Cash           |
    * User will input Exclude CLS from calculation
      | Exclude CLS |
      | No          |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User will click on reject icon
    Then User click on Reject Button on popup
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AGT1_008 |
    When the user selects active from the Status filter
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validate error message upon failed deletion of approval group


  @TC=03 @US=DMGS-3690
  Scenario: To Validate error message of approval group missing in DF
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    Then User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants     |Document_Action           |Approval_sequence|
      |Prime Broker - 1 |New Document Framework    |1                |
    Then User clicks on Next button
    Then User validates the message
      | Approval matrix for Lei OSTTRA INDIA SERVICES PRIVATE LIMITED does not contain any approval group for action New Document |

  @ResettingData
  Scenario: Reset the data used
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name          | value                                 |
      | PB Name | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name | Koudenburg B.V.                       |
      | Lifecycle status     | Draft                              |
    And User click on delete button
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AGT1_008 |
    When the user selects active from the Status filter
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AGT1_009 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup

  Scenario: Reset the Approval Group data used
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups                       | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_DN_Osttra | 1                 |
    And User will submit the changes