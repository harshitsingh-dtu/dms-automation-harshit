@ApprovalGroupCreationAndDeletionDN @Regression

@ApprovalGroup @ApprovalMatrix @US=DMGS-7552 @US=DMGS-3690

Feature: Workflow for Approval Groups and Approval Matrix Amendments in DN

  @TC-2681
  Scenario: Verify creating a new approval group and adding user to it
    Given User is on create new approval group screen
    Then User is able to see filters of group name, organisation name, LEI, org type and next button
    And User generates unique the group name,organization name,LEI's,org type
      | group name                              | organisation name                       | doc type | LEI's      | org type |
      | Automation_Approval_Group_Testing_AG_01 | OSTTRA INDIA SERVICES PRIVATE LIMITED   | DN       | OSTTRA     | PB       |
    Then User clicks on Next button
    And User validates approval group created successfully notification
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group
    Then User validates the message
      |1 user added successfully |

  @TC-2681
  Scenario: Verify creating a new approval group and adding user to it -2
    Given User is on create new approval group screen
    Then User is able to see filters of group name, organisation name, LEI, org type and next button
    And User generates unique the group name,organization name,LEI's,org type
      | group name                              | organisation name                       | doc type | LEI's      | org type |
      | Automation_Approval_Group_Testing_AG_02 | OSTTRA INDIA SERVICES PRIVATE LIMITED   | DN       | OSTTRA     | PB       |
    Then User clicks on Next button
    And User validates approval group created successfully notification
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group
    Then User validates the message
      |1 user added successfully |

  @TC=01
  Scenario: To observe the status column of the approval group
    Given User is on Approval group screen
    Then User validates the status dropdown values
    Then the "Status" column should only contain "Active" or "Inactive" for the rows

  @CreatingApprovalGroups
  Scenario: Creating approval group for further operations
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then User clicks on update button
    Then user ensures "Sequence 2" column is added in Approval Matrix
    Then user will select document action and approval groups
      | Document Action | approval groups                         | Approval Sequence |
      | New Document    | Automation_Approval_Group_Testing_AG_01 | 1                 |
    Then user will select document action and approval groups
      | Document Action | approval groups                         | Approval Sequence |
      | New Document    | Automation_Approval_Group_Testing_AG_02 | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up

  @CreatingDFForFurtherOperations
  Scenario: create a DF for further operations
    Given User is on Document Framework Page
        Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 724500Q59D1FS2E4PI53                 |
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
    Then User clicks on Next button
    Then User click on Approval Workflow for DN tab
    Then User will use drag and drop PB1 to approval Seq 1 in DF
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
    Then User validates the toast message
      |Document is Approved|

  @TC=11 @TC=12 @TC=03 @TC=04 @TC=05 @TC=06 @TC=07 @TC=10 @TC-6682 @TC_01 @TC=03 @US=DMGS-3690
  Scenario: Check approval group deletion over "In-approval" DN doc status
    Given User will go to Document screen
        Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                  |
      | ebLeiId     | 724500Q59D1FS2E4PI53                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      | 123456789 |
    Then User clicks on Next button
    Then User validates the message
      | Limit scope updated successfully |
    And User clicks on Preview & Submit tab
    And User clicks on submit for approval button
    And Click on Commit button of popup if it appears
    And User validates the message
      |Document is In-approval|
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                              |
      | Automation_Approval_Group_Testing_AG_01 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently|
    When User searches for Approval group name in the search bar
      | group name                                |
      | Automation_Approval_Group_Testing_AG_02   |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently|

  @TC=13 @TC=14 @TC=15 @TC-6672 @TC-6685 @TC-6695 @TC-6704 @TC-8347
  Scenario: Check approval group deletion over "Enforced" & "Terminated" status for doc for second approver
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | In-approval                           |
    And Clicks on Approve Button for approval Group
    And Click on Approve button of popup
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                              |
      | Automation_Approval_Group_Testing_AG_01 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently|
    When User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AG_02    |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently|
    Then User waits for 10 seconds
    Then User is on document listing screen again
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Enforced                              |
    Then User clicks on Terminate button
    Then User will click submit button on the terminate confirmation pop up
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                              |
      | Automation_Approval_Group_Testing_AG_01 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently.|

  @DocumentRejectCase
  Scenario: Check approval group deletion over "Reject" DN doc status
    Given User will go to Document screen
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                  |
      | ebLeiId     | 724500Q59D1FS2E4PI53                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      | 123456789 |
    Then User clicks on Next button
    Then User validates the message
      | Limit scope updated successfully |
    And User clicks on Preview & Submit tab
    And User clicks on submit for approval button
    And Click on Commit button of popup if it appears
    And User validates the message
      |Document is In-approval|
    Then User will click on reject icon
    Then User click on Reject Button on popup
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                              |
      | Automation_Approval_Group_Testing_AG_01 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |There are approval matrices in-flight using this Approval Group and it cannot be deleted currently|

  @ResettingTheData
  Scenario: Resetting the data
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User clicks on Terminate button
    Then Click on Yes button of popup

  @ResettingTheData
  Scenario: Resetting the Approval Matrix data
    Given user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then User clicks on update button
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 2                 |
    Then user will select document action and approval groups
      | Document Action | approval groups                          | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_DN_Osttra    | 1                 |