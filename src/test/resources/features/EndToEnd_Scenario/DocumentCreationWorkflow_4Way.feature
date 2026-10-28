@EndToEndScenarios
@document_type=4-way

Feature: Covering End to End 4 way Scenarios

  @4WayCreation
  Scenario: User creates a 4way document complete flow
    Given User is on Document Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | PB-2 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
    And user will select Column Values on Document listing screen
      |Column Name               |value                                 |
      |PB-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name|CITIC Capital China Partners III, L.P.|
      |PB-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.|
      |Client-2 Legal Entity Name|OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User deletes all the document if available
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1                       | Clients 1                             |Prime Broker 2                        |Clients 2                             |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |CITIC Capital China Partners III, L.P. |CITIC Capital China Partners III, L.P.|OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action     |Approval_sequence|
      |Prime Broker - 1  |Edit Document       |1                |
      |Prime Broker - 1  |Terminate Document  |1                |
    Then User clicks on Next button
    Then User clicks on "Enforcement Rules"
    Then User select rules in Enforcement rule
    Then User clicks on "Next"
    Then User will click on the CK editor and type text into document content
    | Document content             |
    | This is dummy data for Automation. Do not edit this. |
    Then User clicks on "Next"
    And The user Select all the dates
      | Calendar name          | date           |
      |Reference Date          |2025-11-15      |
      |Master Agreement ISDA   |2025-11-15      |
      |Master Agreement Give-Up|2025-11-15      |
      |First Issue Date        |2021-11-15      |
      |Current Issue Date      |2025-11-15      |
      |Current Return Time     |2025-11-15      |
      Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User adds Currencies
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User clicks on Next button
    And User clicks on Limit Scope
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Limit Value
      |Limit Value|
      |999999999999999|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User will input Product family
      |Product Family|
      | Bullion      |
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    And User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                      |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED      |
      |Client-1 Legal Entity Name    |CITIC Capital China Partners III, L.P.     |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.     |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED      |
    Then User waits for some time, refreshes the page and validates the status

  @4WayEdit
  Scenario: User Edits the enforced 4way document and moves it into in-Approval state
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      |Column Name               |value                                 |
      |PB-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name|CITIC Capital China Partners III, L.P. |
      |PB-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.|
      |Client-2 Legal Entity Name|OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type   |
      | EDIT DOCUMENT |
    And User will click on submit
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action    |Approval_sequence|
      |Prime Broker - 2  |Edit Document      |1                |
    And User clicks on Save As Draft button
    Then User validates the message
      |Approval Workflow Updated successfully|
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion        | Volatility Swap |
    And User adds Currencies
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 12         |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Months     |
    And User clicks on Add Auth Line
    And User clicks on Next button
    Then User validates the message
      |Auth Scope Updated successfully|
    Then User clicks on Limit Scope
    And User clicks on copy icon for lines to be copied
    And User enters values in Copied limit line
      |Limit Value|Bullion Trades|
      |25697456    |Include Metals|
#    And User click on save icon for limit line
    And User clicks on copy icon for lines to be copied
    And User enters values in Copied limit line
      |Limit Value|Bullion Trades|
      |1          |Only Metals|
#    And User click on save icon for limit line
    And User clicks on Save As Draft button
    And User validates limit scope updated successfully is displayed
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                      |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED      |
      |Client-1 Legal Entity Name    |CITIC Capital China Partners III, L.P.     |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.     |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED      |
    Then User waits for some time, refreshes the page
    And User validates the document status
      |status       |
      |In-approval  |

  @4WayRejectDocument
  Scenario: User Rejects the in-Approval document
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      |Column Name               |value                                  |
      |PB-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name|CITIC Capital China Partners III, L.P. |
      |PB-2 Legal Entity Name    |CITIC Capital China Partners III, L.P. |
      |Client-2 Legal Entity Name|OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    Then User will click on reject icon
    Then User validates the rejection reason pop-up
    And User enters the Rejection reason
      |Rejection Reason|
      | Rejected for Testing Purpose|
    And User clicks on Reject button and validates the DF screen
    Then User waits for some time, refreshes the page
    And User validates the document status
      |status       |
      |Rejected     |

  @4WayNewEnforcedVersion
  Scenario: User creates new enforced version
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      |Column Name               |value                                  |
      |PB-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name|CITIC Capital China Partners III, L.P. |
      |PB-2 Legal Entity Name    |CITIC Capital China Partners III, L.P. |
      |Client-2 Legal Entity Name|OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Document Status           |Enforced                               |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT|
    Then User will click on submit
    Then User will edit Limit Value in Edit Limit Action
      |Limit Value  |
      |10000000     |
    And User clicks on submit for approval button
    Then User validates the message
      |Limit scope updated successfully|
    Then User validates the Document approved message
      |Document is Approved|

  @Updating4WayApprovalMatrix
  Scenario: User updates approval workflow for Terminate Document Action
    Given User is on the create approval matrix screen
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      |organisation name                        |LEI filter                             |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED  |PB             |4 Way          |
    Then User clicks on update button
    Then user will select document action and approval groups
      | Document Action    | approval groups                          |
      | Terminate Document | Automation_OT_ApprovalGroup_4way_Osttra  |
    And User will click on Submit Button
    And user will click on submit button on Approval matrix Confirmation screen
    Then User validates the message
      |Approval matrix updated successfully|

  @4WayTerminate
  Scenario: User will perform Terminate Document Action
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      |Column Name               |value                                  |
      |PB-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name|CITIC Capital China Partners III, L.P. |
      |PB-2 Legal Entity Name    |CITIC Capital China Partners III, L.P. |
      |Client-2 Legal Entity Name|OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Document Status           |Enforced                               |
    Then User clicks on Terminate button
    Then User will select Acting as on the terminate confirmation pop up
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User will click on Submit Button
    Then User validates the notification for Document Termination