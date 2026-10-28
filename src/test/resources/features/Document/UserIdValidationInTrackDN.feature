@Regression @US=DMGS-7703 @UserIdValidationInTrackDN

Feature: To Validate the User Ids present in the track for DN

  Scenario: Creation of Approval Groups for the further use
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then user ensures "Sequence 2" column is added in Approval Matrix
    Then user will select document action and approval groups
      | Document Action | approval groups  | Approval Sequence |
      | New Document    | Automation_AG_01 | 1                 |
    Then user will select document action and approval groups
      | Document Action | approval groups  | Approval Sequence |
      | New Document    | Automation_AG_02 | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up

  Scenario: Creating a DF for further use
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 724500Q59D1FS2E4PI53                 |
    Given User is on Document Framework Page
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

  @TC-07
  Scenario: To Validate No approval workflow message
        Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 724500Q59D1FS2E4PI53                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    Given User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Cancel button
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    Then User will click on Track button
    Then User validates text is visible
      | No Approval workflow was defined for this document action|
    Then User clicks on close button
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
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
    And User clicks on Preview & Submit tab
    And User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
      | Document is In-approval |

  Scenario: Validate when same user present in different approval group
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document status           | In-approval                           |
    And Clicks on Approve Button for approval Group
    And User will select approval group for approval
      | Approval Group   |
      | Automation_AG_01 |
    And Click on Approve button of popup
    And Clicks on Approve Button for approval Group
    And User will select approval group for approval
      | Approval Group   |
      | Automation_AG_02 |
    And Click on Approve button of popup
    Then User validates the toast message
      |You have approved this agreement already during this approval cycle and cannot approve it again|

#  @TC-01 @TC-03 @TC-04 @TC-06 @TC-09 @TC-12 @TC-15 @US-DMGS-8276 @ignore
#  Scenario: To Validate the userIds on DN
#    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | In-approval                           |
#    And Clicks on Approve Button for approval Group
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_01 |
#    And Click on Approve button of popup
#    And Clicks on Approve Button for approval Group
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_02 |
#    And Click on Approve button of popup
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User will click on Track button
#    Then Validate the initiator lei in the track
#      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#    Then User clicks on Expand Icon for approval groups
#    Then User verify approved tick mark for the 1st approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_01 | hsbc.test1@testsso.osttra.com |
#    Then User verify approved tick mark for the 2nd approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_02 | hsbc.test1@testsso.osttra.com |
#    Then User validates approved document status in track graph
#    Then User clicks on close button
#
#  @TC-17 @TC-19 @US-DMGS-8276 @ignore
#  Scenario: To check the compare functionality of the document
#    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User clicks on edit icon
#    And User will select action type for edit
#      | Action type |
#      | Edit Limit  |
#    Then User will click on submit
#    Then User clicks on Cancel button for edit screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Draft                                 |
#    Then User clicks on compare button icon
#    Then User will compare the version of the document
#      | Enforced version | Current version |
#      | 001              | 002             |
#    Then User closes the compare screen
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User clicks on edit icon
#    And User will select action type for edit
#      | Action type |
#      | Edit Limit  |
#    Then User will click on submit
#    And User will input Limit Value on Edit Limit screen
#      | Limit Value |
#      | 1323231     |
#    Then User clicks on submit for approval button for Edit Limit
#    And User validates the message
#      | Limit scope updated successfully |
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Draft                                 |
#    Then User clicks on compare button icon
#    Then User will compare the version of the document
#      | Enforced version | Current version |
#      | 001              | 002             |
#    Then User closes the compare screen
#
#  @TC-18 @US-DMGS-8276 @ignore
#  Scenario: To check the compare functionality of the document with the new version
#    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Draft                                 |
#    Then User clicks on edit icon
#    And User will input Limit Value on Edit Limit screen
#      | Limit Value |
#      | 13232311    |
#    Then User clicks on submit for approval button for Edit Limit
#    Then User clicks on No button
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User clicks on edit icon
#    And User will select action type for edit
#      | Action type |
#      | Edit Limit  |
#    Then User will click on submit
#    Then User clicks on Cancel button for edit screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Draft                                 |
#    Then User clicks on compare button icon
#    Then User will compare the version of the document
#      | Enforced version | Current version |
#      | 002              | 004             |
#    Then User closes the compare screen
#    Then User click on delete button
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User clicks on Terminate button
#    Then User will click submit button on the terminate confirmation pop up
#    Then User validates the message
#      | Document is terminated |
#
#  @TC-05 @TC-13  @US-DMGS-8276 @ignore
#  Scenario: To create a document to validate the reject document case
#    Given User will go to Document screen
#    Then User will click on Create new document
#    Then User select document type,acting as
#      | Document Type | Acting As |
#      | DN            | PB        |
#    And User select the LEIs
#      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB 1           | Koudenburg B.V.                       |
#      | Client 1       | CITIGROUP INC.                        |
#    Then User clicks on Next button
#    Then User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Cash           | Future  |
#    And User clicks on Add Auth Line
#    And User enables all Auth Lines
#    And User clicks on Next button
#    Then User enable the Limit line and validate the same
#    Then User clicks on limit line edit icon and enters value
#      | 123456789 |
#    Then User clicks on Next button
#    Then User validates the message
#      | Limit scope updated successfully |
#    And User clicks on Preview & Submit tab
#    And User clicks on submit for approval button
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | In-approval                           |
#    And Clicks on Approve Button for approval Group
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_01 |
#    And Click on Approve button of popup
#    And User will click on reject icon
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_02 |
#    Then User click on Reject Button on popup
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Rejected                              |
#    Then User will click on Track button
#    Then User clicks on Expand Icon for approval groups
#    Then User verify approved tick mark for the 1st approval group
#    Then User verify rejected tick mark for the approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_02 | hsbc.test1@testsso.osttra.com |
#    Then User validates rejected document status in track graph
#    Then User clicks on close button

  #delete the DN doc.
  @ResettingTheData
    Scenario: To reset and cancel the DN doc.
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | In-approval                           |
      Then User will click on cancel icon and select yes
      Then User waits for some time, refreshes the page

  @ResettingTheData
  Scenario: Resetting the data
#    Given User is on Document Framework Page
#    And user will select Column Values on Document Framework screen
#      | Column Name            | value                                 |
#      |PB Name | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name | Koudenburg B.V.                       |
#      | Lifecycle status       | Approved                              |
#    Then User clicks on Terminate button
#    Then Click on Yes button of popup
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    When User clicks on the delete icon for sequence column "sequence2"
    And User clicks on the Confirm button on the popup
    Then user will select document action and approval groups
      | Document Action |approval groups  | Approval Sequence |
      | New Document    |Automation_OT_ApprovalGroup_DN_Osttra| 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
