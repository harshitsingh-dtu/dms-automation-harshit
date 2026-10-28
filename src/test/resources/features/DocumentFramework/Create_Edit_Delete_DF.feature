@DocumentFramework @Regression
@CreateNewDF @US=DMGS-3213 @US=DMGS-3210 @US=DMGS-3815

Feature: Workflow for Create,Edit,Delete Document FrameWork & validating the Notification

  @TC=6599 @TC=6574 @TC=6576 @TC=6599 @TC=6602 @TC=6969 @TC=6973 @TC=7050
  Scenario: User creates a DN DocumentFramework and approves it
    Given User resets DF document
      | docTypeId |7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   |254900SLCV8KI86BHL86|
      | ebLeiId   |254900CRWU5C1N5WSP26|
    Given User is on Document Framework Page
    Then User creates a document framework through API
      |Payload path|
      |src/test/java/resources/DF_Creation.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds General Terms via API for DN Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
      |Column Name   |value             |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |EB Name       |A1 Fund SPC|
    Then User clicks on edit icon
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User validates the Deliverable, Non-Deliverable are displayed
    And User selects the currency group pair in AuthScope
      |Automation_OT_CurrencyPairGroup|
    And User selects the currency group in AuthScope
      |Automation_OT_currencyGroup|
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
      |COP|
      |CRC|
      |ISK|
    And click on the submit button on pop up screen
#      And User will submit the changes
      And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |A1 Fund SPC      |
    Then User approves the document
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |A1 Fund SPC      |
      |Lifecycle status |Approved|
    Then User validates the Document Framework status as approved
    And User is able to see the Terminate button
    Then User clicks on the download button
    Then User validates the file is downloaded
    Then Click on notification bell icon
    Then User is able to check the notification for approved DF
#    Then User will check the notification for in approval DF

  @TC=6971 @TC=6975
  Scenario: User Edits & Terminated the DF and validates deliverable & non-deliverable
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |A1 Fund SPC      |
      |Lifecycle status       |Approved      |
    And User clicks on edit icon
    And User will select acting as for edit document
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type |
      |Edit Document Framework|
    And User will click on Submit Button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Variance Swap |
    And Click on + Add currencies
    And User validates the Deliverable, Non-Deliverable are displayed
    And User selects the currency group pair in AuthScope
      |Automation_OT_CurrencyPairGroup|
    And User selects the currency group in AuthScope
      |Automation_OT_currencyGroup|
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
      |COP|
      |CRC|
      |ISK|
#      And User will submit the changes
      And click on the submit button on pop up screen
      And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    And User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |A1 Fund SPC|
      |Lifecycle status       |Approved|
    And User unselects the Show only latest version checkbox on DF screen if it is selected
    Then User validates the Document Framework status as approved
    And User is able to see the Terminate button
    And User clicks on Terminate button
    And Click on Yes button of popup
#    And User will click on delete icon from action column for the document
#    And User deletes the document created through API
    Then Click on notification bell icon
    Then User waits for 2 seconds
    And User is able to check the notification for terminated DF

  @TC=6744
  Scenario: Validate the approval workflow for DN in Terminated DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name             |A1 Fund SPC          |
      |Lifecycle status    |Terminated           |
    Then User waits for 2 seconds
    Then User validates the Approval Workflow for DN in the preview on DF listing screen

  @Sanity @fixed
  Scenario: Validate delete functionality for DF
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 549300GT2SFGUD4JWG60                 |
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    And validate the document type value as DN
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Prime Broker 1      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
      |EB 1                |Enbridge Supplemental Pension Plan      |
    Then User clicks on Next button
    Then User clicks on Cancel button
    And user will select Column Values on Document Framework screen
      |Column Name   |value     |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED     |
      |EB Name       |Enbridge Supplemental Pension Plan        |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

#  Scenario: User creates an ApprovalGroup for DocumentFramework
#    Given User is on create new approval group screen
#    When User generates unique the group name,organization name,LEI's,org type
#      | group name | organisation name   | doc type | LEI's          | org type |
#      |Automation_Akshita| OSTTRA INDIA SERVICES PRIVATE LIMITED      | DN    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
#    Then clicks on next
#    And user is redirected to update approval group screen
#    And User will search for the users to be added and add them
#      |user|
#      |hsbc.test1@testsso.osttra.com|
#    And  User will submit the changes after adding users to the approval group
#    Given User is on the create approval matrix screen
#    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
#      |organisation name|LEI filter |org type filter|doc type filter|
#      |OSTTRA INDIA SERVICES PRIVATE LIMITED            |121 WACKER, LLC      |PB             |DN          |
#   And User can see and click the next button on the create approval matrix screen
#    Then user will select document action and approval groups
#      | Document Action     | approval groups  |
#      | Edit Document Terms | Automation_Akshita|
#    Then User is on Document Framework Page
#    Then User creates a document framework through API
#      |Payload path|
#      |src/test/java/resources/DF_Creation.json|
##    Then Verify both Online and Lite user gets email for DF creation
#
#
#  Scenario: User copy the above DF and and verify
#    When User is on Document Framework Page
#   Then User creates a document framework through API
#      |Payload path|
#      |src/test/java/resources/DF_Creation.json|
#    Then user will select Column Values on Document Framework screen
#      |Column Name   |value             |
#      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED             |
#      |EB Name       |1230381 ONTARIO INC.       |
#    Then User validates the Copy icon and clicks on it
#    Then User select acting as
#      | Acting As |
#      | PB        |
#    And User select the LEIs
#      |Prime Broker 1      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
#      |EB 1       |1230381 ONTARIO INC.  |
#    Then User clicks on Next button
##    Then Verify both Online and Lite user gets email for DF creation
#    Then Verify Approval Workflow is not copied
