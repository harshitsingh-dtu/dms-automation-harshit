@DFDNEmailIntegration
@US=DMGS-7752

Feature: To validate email in General Terms tab of DF synced with Dn

  @TC=01 @TC=02 @TC=06
  Scenario: Validate the manual PDF header is present
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
    Then User clicks on Next button
    Then User clicks on General Terms Tab
    Then User validates text is visible
      | Text                      |
      | Manual PDF approval email |
    Then User will input email Id
      | abc |
    Then User clicks on Save As Draft button
    Then User validates the message
      | Please enter a valid email address. |
    Then User removes the email
    Then User will input email Id
      | abc@osttra.com |
    Then User clicks on Save As Draft button
    Then User validates the Document approved message
      | General terms saved successfully |
    Then User clicks on Cancel button

  @TC=03 @TC=04 @TC=10
  Scenario: To validate sync functionality from DF to DN
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Draft                                 |
    Then User clicks on edit icon
    Then User clicks on enforcement rules tab for DF
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
    Then User clicks on view as PDF button
    Then User validates the email on preview
      | abc@osttra.com |
    Then User clicks on close button
    Then User clicks on General Terms Tab Preview tab
    Then User validates the email on preview
      | abc@osttra.com |
    Then User clicks on submit for approval button

  @ContinuationOfAboveTC
  Scenario: Validating Functionality of above steps
    Given User is on Document Page
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on General Terms Tab
    Then User validate the email id
      | abc@osttra.com |
    Then User removes the email
    Then User will input email Id
      | xyz@osttra.com |
    Then User clicks on Next button
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
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User clicks on edit icon
    Then User will click on submit
    Then User clicks on General Terms Tab
    Then User removes the email
    Then User will input email Id
      | xyz@osttra.com |
    Then User clicks on Preview & Submit tab
    Then User clicks on view as PDF button
    Then User validates the email on preview
      | xyz@osttra.com |
    Then User clicks on close button
    Then User clicks on General Terms Tab Preview tab
    Then User validates the email on preview
      | xyz@osttra.com |
    Then User clicks on submit for approval button
    Then User clicks on Submit button for Scope Change Preview

  @TC=15
  Scenario: Email sync functionality through copy button of DN
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
    Then User click on copy button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Client 1 | Koudenburg B.V. |
    Then User clicks on Next button
    Then User clicks on General Terms Tab
    Then User validate the email id
      | xyz@osttra.com |
    Then User clicks on Cancel button
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
      | Document Status            | Draft                                 |
    Then User click on delete button

  @AdditionalDataForApprovalGroup
  Scenario: To Input the data for further testcases
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name                                 | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_Approval_Group_Testing_AGT1_020 | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then user will select document action and approval groups
      | Document Action | approval groups                            | Approval Sequence |
      | New Document    | Automation_Approval_Group_Testing_AGT1_020 | 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up

  @TC=07
  Scenario: To validate email over the PB Approver
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Enforced                              |
    Then User clicks on Terminate button
    Then User will click on submit
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User clicks on edit icon
    Then User will click on submit
    Then User click on Approval Workflow for DN tab
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User is on document listing screen again
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Koudenburg B.V.                       |
      | Client 1       | Koudenburg B.V.                       |
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
    And Clicks on Approve Button for approval Group
    And Click on Approve button of popup
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
    And User clicks on Preview of Document
    Then User validates the email on preview
      | xyz@osttra.com |
    And User clicks on close button

  @ResettingData
  Scenario: Resetting the approval group and approval matrix data
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
    Then user clicks on the update button
    Then User will search for the approval group to be removed from approval matrix and remove it
      | Document Action | Approval Sequence |
      | New Document    | 1                 |
    And User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    Then User will navigate to approval group listing screen
    When User searches for Approval group name in the search bar
      | group name                                 |
      | Automation_Approval_Group_Testing_AGT1_020 |
    Then User clicks on Delete button for approval group
    Then User clicks on Yes button

  @TC=08
  Scenario: To validate the update of email in the existing DN
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User clicks on edit icon
    Then User will click on submit
    Then User click on Approval Workflow for DN tab
    Then User remove the approver
    Then User clicks on Next button
    Then User clicks on General Terms Tab
    Then User removes the email
    Then User will input email Id
      | def@osttra.com |
    Then User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User clicks on Submit button for Scope Change Preview
    Then User is on document listing screen again
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
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    And User clicks on Preview of Document
    Then User validates the email on preview
      | def@osttra.com |
    And User clicks on close button
    Then User click on delete button

  @TC=14
  Scenario: To Validate copy email functionality in DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User click on copy button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Bittium Oyj                           |
    Then User clicks on Next button
    Then User clicks on General Terms Tab
    Then User will validate empty input box
    Then User clicks on Cancel button
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Bittium Oyj                           |
      | Lifecycle status | Draft                                 |
    Then User click on delete button

  @ResettingData
  Scenario: Reset the data
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
      | Document Status            | Enforced                              |
    Then User clicks on Terminate button
    Then User will click on submit
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User clicks on Terminate button
    Then User clicks on Yes button


#  @TC=05 @TC=11 & TC=12 due to an open bug DMGS-8071
#  Scenario: To validate an empty email space sync from DF to DN
#    Given User is on Document Framework Page
#    And user will select Column Values on Document Framework screen
#      | Column Name      | value                                 |
#      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB Name          | Koudenburg B.V.                       |
#      | Lifecycle status | Approved                              |
#    Then User clicks on edit icon
#    Then User will click on submit
#    Then User click on Approval Workflow for DN tab
#    Then User remove the approver
#    Then User clicks on Next button
#    Then User clicks on Next button
#    Then User removes the email
#    Then User clicks on Save As Draft button
#    Then User clicks on Next button
#    Then User clicks on Preview & Submit tab
#    Then User clicks on submit for approval button
#    Then User clicks on Submit button for Scope Change Preview
#    Then User is on document listing screen again
#    Then User will click on Create new document
#    Then User select document type,acting as
#      | Document Type | Acting As |
#      | DN            | PB        |
#    And User select the LEIs
#      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB 1           | Koudenburg B.V.                       |
#      | Client 1       | 3G Fund, L.P.                         |
#    Then User clicks on Next button
#    Then User clicks on Document terms tab
#    Then User clicks on Next button
#    Then User will validate empty input box
#    Then User clicks on Cancel button
#    And user will select Column Values on Document listing screen
#      | Column Name                | value                                 |
#      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
#      | Client-1 Legal Entity Name | 3G Fund, L.P.                         |
#      | Document Status            | Draft                                 |
#    Then User click on delete button
