@DocumentFramework @Regression
@Validate_RenamingToDF @US=DMGS-6355

Feature: Validate renaming of MA to Document Framework

@US=DMGS-6355 @TC=01 @TC=04 @TC=6612 @TC=6613 @TC=6614 @TC=6615 @TC=6616 @TC=6617 @TC=6618 @TC=6619 @TC=6620 @TC=6623 @TC=6624 @TC=6625 @TC=6626
Scenario: Validate renaming on Document Framework listing screen
  Given User resets DF document
    | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
    | pbLeiId   | 254900SLCV8KI86BHL86                 |
    | ebLeiId   | 9845008BSEED6B1A9984                 |
  Given User is on Document Framework Page
  And User validates the renaming to showing all DF on listing screen
  And Validate renaming of ID, VersionID, Status to DF respectively
  And Validate the abbreviation of DocumentFramework on Document Version & ID
  And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name    |
    | PB Name  |
    | Allowed currencies|
  And Validate renaming of allowed currency to allowed currencies
  And Click on create New Document Framework button
  And validate the document type value as DN
  Then User select acting as
    | Acting As |
    | PB        |
  And User select the LEIs
    | Prime Broker 1   |  OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    | EB 1             |  1355 STORM PARKWAY LLC  |
  Then User clicks on Next button
  And User clicks on enforcement rules tab for DF
  And User select rules in Enforcement rule
  And User clicks on Auth Scope Tab
  Then User Add Asset Class, Product Family, Product to the Auth Scope
    | Asset Class | Product Family | Product |
    | FX          | Exotic Options | Double Barrier |
  And Click on + Add currencies
  And User will search for the currency and select them
    |currency list|
    |AED|
    |CLF|
    |COP|
    |CRC|
    |ISK|
  And User will submit the changes
  And User enables Tenor
  * User will input Auth Tenor value
    | Auth Value |
    | 3          |
  * User will select tenor in Auth Tenor
    | Auth Tenor |
    | Years      |
  And User clicks on Add Auth Line
  And User clicks on Next button
  * User will input Calculation Type
    | Calculation Type |
    | NOP              |
  * User will input Netting Type
    | Netting Type |
    | Greater      |
  Then User enter Bullion Trades in Limit Scope
    |Exclude Metals|
  * User will input Delta
    | Delta |
    | No    |
  * User will input Product family
    | Product Family |
    | Cash           |
  Then User clicks on Add Limit button
  And User clicks on Next button
  And User Final Preview & Submit the Document
  And Validate User is on Document Framework Screen
  And Refresh web page
  And user will select Column Values on Document Framework screen
    |Column Name   |value                |
    |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Name       |1355 STORM PARKWAY LLC |
  And User clicks on Preview of DF
  And User Validates the approval Wokflow for DF and actions
  And User clicks on cross icon
  And User clicks on edit icon
  Then User will select Acting as on the terminate confirmation pop up
    |acting as|
    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
  And User will select action type for edit
    | Action type |
    |Edit Document Framework|
  And Validate renaming of edit pop up for DF
  And verify cancel button
  And User validates the Copy icon and clicks on it
  And Validate renaming at copy DF screen
  And Validate renaming of allowed currency to allowed currencies
  And User clicks on Discard button
#  And user will select Column Values on Document Framework screen
#    |Column Name   |value                |
#    |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
#    |EB Name       |1355 STORM PARKWAY LLC |
  Then User clicks on Terminate button
  And Click on Yes button of popup
#  And User refreshes the browser
#  And user will select Column Values on Document Framework screen
#    |Column Name   |value                |
#    |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
#    |EB Name       |1355 STORM PARKWAY LLC |
#  And User will click on delete icon from action column for the document
  And User refreshes the browser
  Then Click on notification bell icon
  Then User validates the DF abbreviation in notification

  @US=DMGS-6355 @TC=05 @TC=06
  Scenario: Validate removal of Doc Type Column & DNM MA ID/DNM MA Main ID to be the last 2 columns
    Given User is on Document Framework Page
    And User validates DocType column is removed from DF Dashboard
    And User Validates DNM MA ID and Main ID are last columns on Dashboard