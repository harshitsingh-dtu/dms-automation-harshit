@Regression @US=DMGS-7712 @UserIdValidationInTrackDF

Feature: To Validate the User Ids present in the track for DF

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

  @TC=07
  Scenario: Validation of No record found message
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
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Save As Draft button
    Then User clicks on Cancel button
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Draft                                 |
    Then User will click on Track button
    Then User validates text is visible
      | No Approval workflow was defined for this document action. |
    Then User clicks on close button

  Scenario: Creation of DF document for further operations
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Draft                                 |
    Then User clicks on edit icon
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

  Scenario: Validate DF when same user present in different approval group
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | In-approval                                 |
    And Clicks on Approve Button for approval Group on DF screen
    And User will select approval group for approval
      | Approval Group   |
      | Automation_AG_01 |
    And Click on Approve button of popup
    And Clicks on Approve Button for approval Group on DF screen
    And User will select approval group for approval
      | Approval Group   |
      | Automation_AG_02 |
    And Click on Approve button of popup
    Then User validates the toast message
      |You have approved this agreement already during this approval cycle and cannot approve it again|

#  Requriment yet to be finalized updated -  same user is present in both apporval grp that why it failed at selecting Automation_AG_02

#  @TC-01 @TC-03 @TC-04 @TC-06 @TC-09 @TC-12 @TC-15 @ignore
#  Scenario: To validate the usernames and the approval groups for the document
#    Given User is on Document Framework Page
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | In-approval                                 |
#    #And Clicks on Approve Button for approval Group
#    And Clicks on Approve Button for approval Group on DF screen
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_01 |
#    And Click on Approve button of popup
#    #And Clicks on Approve Button for approval Group
#    And Clicks on Approve Button for approval Group on DF screen
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_02 |
#    And Click on Approve button of popup
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
#  @TC-17 @TC-19 @ignore
#  Scenario: To check the compare functionality of the document
#    Given User is on Document Framework Page
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Approved                              |
#    Then User clicks on edit icon
#    Then User click on submit button
#    Then User remove the approver
#    Then User clicks on Save As Draft button
#    Then User clicks on Cancel button
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Draft                              |
#    Then User clicks on compare button icon
#    Then User will compare the version of the document
#      | Enforced version | Current version |
#      | 001              | 002             |
#    Then User closes the compare screen
#    Then User refreshes the browser
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Approved                              |
#    Then User clicks on edit icon
#    Then User click on submit button
#    Then User remove the approver
#    Then User clicks on Save As Draft button
#    Then User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product         |
#      | FX          | Volatility     | Volatility Swap |
#    And Click on + Add currencies
#    And User selects and validates currencies are deliverable in pop-up
#      | JPY |
#    And click on the submit button on pop up screen
#    And User enables Tenor
#    * User will input Auth Tenor value
#      | Auth Value |
#      | 5          |
#    * User will select tenor in Auth Tenor
#      | Auth Tenor |
#      | Years      |
#    Then User clicks on Add Auth Line
#    Then User clicks on Save As Draft button
#    Then User clicks on Preview & Submit tab
#    Then User clicks on submit for approval button
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Draft                              |
#    Then User clicks on compare button icon
#    Then User will compare the version of the document
#      | Enforced version | Current version |
#      | 001              | 002             |
#    Then User closes the compare screen
#
#  @TC-18 @ignore
#  Scenario: To check the compare functionality of the document DF
#    Given User is on Document Framework Page
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Draft                              |
#    Then User clicks on edit icon
#    Then User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product       |
#      | FX          | Volatility     | Variance Swap |
#    And Click on + Add currencies
#    And User selects and validates currencies are deliverable in pop-up
#      | JPY |
#    And click on the submit button on pop up screen
#    And User enables Tenor
#    * User will input Auth Tenor value
#      | Auth Value |
#      | 5          |
#    * User will select tenor in Auth Tenor
#      | Auth Tenor |
#      | Years      |
#    Then User clicks on Add Auth Line
#    Then User clicks on Preview & Submit tab
#    Then User clicks on submit for approval button
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Approved                              |
#    Then User clicks on edit icon
#    Then User click on submit button
#    Then User clicks on Cancel button
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Draft                              |
#    Then User clicks on compare button icon
#    Then User will compare the version of the document
#      | Enforced version | Current version |
#      | 002              | 004             |
#    Then User closes the compare screen
#    Then User click on delete button
#    Then User refreshes the browser
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Approved                              |
#    Then User clicks on Terminate button
#    Then Click on Yes button of popup
#    Then User validates the message
#      | Document is terminated |
#
#  @ignore
#  Scenario: To create a document to validate the reject document case
#    Given User is on Document Framework Page
#    And Click on create New Document Framework button
#    Then User select acting as
#      | Acting As |
#      | PB        |
#    And User select the LEIs
#      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB 1           | Koudenburg B.V.                       |
#    Then User clicks on Next button
#    Then User will use drag and drop PB1 to approval Seq 1 in DF
#    Then User clicks on Next button
#    Then User clicks on enforcement rules tab for DF
#    And User validates the enforcement screen
#    And User will select Enforcement rule for new document for amendment and for termination
#      | For new document | For amendment |
#      | Immediate        | Immediate     |
#    And User clicks on Save As Draft button
#    Then User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Cash           | Future  |
#    And Click on + Add currencies
#    And User selects and validates currencies are deliverable in pop-up
#      | JPY |
#    And click on the submit button on pop up screen
#    And User enables Tenor
#    * User will input Auth Tenor value
#      | Auth Value |
#      | 3          |
#    * User will select tenor in Auth Tenor
#      | Auth Tenor |
#      | Years      |
#    Then User clicks on Add Auth Line
#    Then User clicks on Next button
#    Then User will input Calculation Type
#      | Calculation Type |
#      | DSL              |
#    * User will input Netting Type
#      | Netting Type        |
#      | Gross excluding USD |
#    And User enter Bullion Trades in Limit Scope
#      | Include Metals |
#    Then User will input Delta
#      | Delta |
#      | No    |
#    Then User will input Product family
#      | Product Family |
#      | Cash           |
#    * User will input Exclude CLS from calculation
#      | Exclude CLS |
#      | No          |
#    Then User clicks on Add Limit button
#    And User clicks on Save As Draft button
#    Then User clicks on Preview & Submit tab
#    Then User clicks on submit for approval button
#
#  @TC-05 @TC-13 @ignore
#  Scenario: To validate the user Ids in case of reject document
#    Given User is on Document Framework Page
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | In-approval                           |
#    #And Clicks on Approve Button for approval Group
#    And Clicks on Approve Button for approval Group on DF screen
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_01 |
#    And Click on Approve button of popup
#    And User will click on reject icon
#    And User will select approval group for approval
#      | Approval Group   |
#      | Automation_AG_02 |
#    Then User click on Reject Button on popup
#    Then User refreshes the browser
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Rejected                           |
#    Then User will click on Track button
#    Then User clicks on Expand Icon for approval groups
#    Then User verify approved tick mark for the 1st approval group
#    Then User verify rejected tick mark for the approval group
#    Then User validates the user id of the designated approval group
#      | GroupName        | UserID                        |
#      | Automation_AG_02 | hsbc.test1@testsso.osttra.com |
#    Then User validates rejected document status in track graph
#    Then User clicks on close button

  @ResettingTheData
  Scenario: Resetting the data
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
    Then user will select document action and approval groups
      | Document Action | approval groups                          | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_DN_Osttra    | 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
