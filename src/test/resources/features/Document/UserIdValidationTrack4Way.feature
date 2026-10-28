@Regression @US=DMGS-7703 @UserIdValidationInTrack4Way
@US-DMGS-8276
Feature: To Validate the User Ids present in the track for 4Way
  @US-DMGS-8276
  Scenario: Creation of Approval Groups for the further use
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    Then user clicks on the update button
    And user selects the Sequential approval order if not already selected
    And User waits for 3 seconds
    Then user ensures "Sequence 2" column is added in Approval Matrix
    Then user will select document action and approval groups
      | Document Action | approval groups  | Approval Sequence |
      | New Document    | Automation_AG_03 | 1                 |
    Then user will select document action and approval groups
      | Document Action | approval groups  | Approval Sequence |
      | New Document    | Automation_AG_04 | 2                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up

  @TC-07 @US-DMGS-8276
  Scenario: To Validate No approval workflow message
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 743700BTHBACD5DF5C04                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 9845008BSEED6B1A9984                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 6SHGI4ZSSLCXXQSBB395                 |
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
    #Then User will use drag and drop PB1 to approval Seq 1 in 4W Document
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Save As Draft button
    Then User clicks on Cancel button
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      |Document Status               |Draft               |
    Then User will click on Track button
    Then User validates text is visible
      | No Approval workflow was defined for this document action. |
    Then User clicks on close button

  @US-DMGS-8276
  Scenario: To create a 4 way document for further operation
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are deliverable in pop-up
      | AED |
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
      | 999999999999999 |
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

  Scenario: To Validate Error msg when same userIds Approval Groups on 4way
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      |Document Status               |In-approval               |
    And Clicks on Approve Button for approval Group
    And User will select approval group for approval
      | Approval Group   |
      | Automation_AG_03 |
    And Click on Approve button of popup
    And Clicks on Approve Button for approval Group
    And User will select approval group for approval
      | Approval Group   |
      | Automation_AG_04 |
    And Click on Approve button of popup
    Then User validates the toast message
      |You have approved this agreement already during this approval cycle and cannot approve it again|

    #requriment yet to be finalized updated -  same user is present in both apporval grp that why it failed at selecting Automation_AG_04
#  @TC-01 @TC-03 @TC-04 @TC-06 @TC-09 @TC-12 @TC-15 @US-DMGS-8276 @ignore
#  Scenario: To Validate the userIds on DN
#    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
#    And Clicks on Approve Button for approval Group
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_03 |
#    And Click on Approve button of popup
#    And Clicks on Approve Button for approval Group
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_04 |
#    And Click on Approve button of popup
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User will click on Track button
#    Then Validate the initiator lei in the track
#      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#    Then User clicks on Expand Icon for approval groups
#    Then User verify approved tick mark for the 1st approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_03 | hsbc.test1@testsso.osttra.com |
#    Then User verify approved tick mark for the 2nd approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_04 | hsbc.test1@testsso.osttra.com |
#    Then User validates approved document status in track graph
#    Then User clicks on close button
#
#  @TC-17 @TC-19 @US-DMGS-8276 @ignore
#  Scenario: To check the compare functionality of the document
#    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
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
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
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
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
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
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
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
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Draft                                 |
#    Then User clicks on edit icon
#    And User will input Limit Value on Edit Limit screen
#      | Limit Value |
#      | 13232311    |
#    Then User clicks on submit for approval button for Edit Limit
#    Then User clicks on No button
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
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
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
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
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Enforced                              |
#    Then User clicks on Terminate button
#    Then User will click submit button on the terminate confirmation pop up
#    Then User validates the message
#      | Document is terminated |
#
#  @US-DMGS-8276 @ignore
#  Scenario: To create a document to validate the reject document case
#    Given User will go to Document screen
#    Then User will click on Create new document
#    Then User select document type,acting as
#      | Document Type | Acting As |
#      | 4 Way         | PB        |
#    And User select the LEIs
#      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client 1       | 1355 STORM PARKWAY LLC                |
#      | Prime Broker 2 | Vladisart Oy                          |
#      | Client 2       | CITIGROUP INC.                        |
#    Then User clicks on Next button
#    Then User click on Approval Workflow in 4 Way
#    Then User will use drag and drop PB1 to approval Seq 1 in 4W Document
#    Then User clicks on Next button
#    And User will select Enforcement rule for new document for amendment and for termination
#      | For new document | For amendment |
#      | Immediate        | Immediate     |
#    Then User clicks on Next button
#    Then User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Cash           | Future  |
#    And Click on + Add currencies
#    And User selects and validates currencies are present in pop-up
#      | AED |
#    And click on the submit button on pop up screen
#    * User will input Auth Tenor value
#      | Auth Value |
#      | 3          |
#    * User will select tenor in Auth Tenor
#      | Auth Tenor |
#      | Years      |
#    Then User clicks on Add Auth Line
#    Then User clicks on Next button
#    And User will input Calculation Type
#      | Calculation Type |
#      | DSL              |
#    And User will input Limit Value
#      | Limit Value     |
#      | 999999999999999 |
#    And User will input Netting Type
#      | Netting Type |
#      | Greater L/S  |
#    Then User enter Bullion Trades in Limit Scope
#      | Exclude Metals |
#    Then User will input Delta
#      | Delta |
#      | Yes   |
#    Then User will input Product family
#      | Product Family |
#      | Exotic Options |
#    Then User will input Exclude CLS from calculation
#      | Exclude CLS |
#      | Yes         |
#    Then User clicks on Add Limit button
#    Then User clicks on Next button
#    Then User clicks on Preview & Submit tab
#    And User clicks on submit for approval button
#
#  @TC-05 @TC-13 @US-DMGS-8276 @ignore
#  Scenario: To validate the userId for reject document case
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
#      | Automation_AG_03 |
#    And Click on Approve button of popup
#    And User will click on reject icon
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_04 |
#    Then User click on Reject Button on popup
#    Then User refreshes the document screen
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
#      | PB-2 Legal Entity Name     | Vladisart Oy                          |
#      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
#      | Document Status            | Rejected                              |
#    Then User will click on Track button
#    Then User clicks on Expand Icon for approval groups
#    Then User verify approved tick mark for the 1st approval group
#    Then User verify rejected tick mark for the approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_04 | hsbc.test1@testsso.osttra.com |
#    Then User validates rejected document status in track graph
#    Then User clicks on close button

  @ResettingTheData @US-DMGS-8276
  Scenario: Resetting the data
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    Then user clicks on the update button
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 2                 |
    When User clicks on the delete icon for sequence column "sequence2"
    And User clicks on the Confirm button on the popup
    Then user will select document action and approval groups
      | Document Action    | approval groups                        | Approval Sequence |
      | New Document       | Automation_OT_ApprovalGroup_4way_Osttra| 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up