@DocumentFramework @Regression
@Validate_AuthScope_LimitScope

Feature: Validate Auth Scope Tab and Limit Scope tabs Document Framework

@TC=6270 @TC=6273 @TC=6274 @TC=6275 @TC-6276 @TC-6278 @TC-6279 @TC-6280 @TC-6281 @TC-6282 @TC-6283 @TC-6284
  Scenario: Validate Auth Scope Tab on Document Framework
  Given User is on Document Framework Page
  Given User resets DF document
    | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
    | pbLeiId   | 254900SLCV8KI86BHL86                 |
    | ebLeiId   | 9845008BSEED6B1A9984                 |
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1   |  OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1             |  1355 STORM PARKWAY LLC                |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
  And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | PPPP       |
    Then User validate Non-Zero Value notification is displayed
  And User will clear the Auth Tenor Value in DF
    Then User Add Asset Class, Product Family, Product to the Auth Scope
    | Asset Class | Product Family | Product |
    | FX          | Bullion | Bullion Vanilla Options  |
    And User adds bullion Currencies
#    And User enables Tenor
  * User will input Auth Tenor value Again
    | Auth Value |
    | 3          |
  * User will select tenor in Auth Tenor
    | Auth Tenor |
    | Years      |
  And User clicks on Add Auth Line
  And User clicks on edit icon in Auth line
  And User clicks on Currencies-Pair and enter currency pair in the filter
    |Currencies-pair|
    |EUR-XAU|
  And User will click on Submit Button
  And User clicks on Save As Draft button
  Then Clicks on DF Auth scope Expand All button if Expand is visible
  And User clicks on copy icon for lines to be copied
  And User deletes the lines created
  And User validates No Lines are there
  And User clicks on Reset Current Changes button
  And User clicks on Next button
  And User validates Limit Scope is visible
  And Verify and click back button
  And User validates Auth Scope is visible
  And User clicks on Preview & Submit tab
  And User clicks on Auth Scope Tab in Final Preview
  And User validates the BullionTrade in Preview in DF
  And User clicks on view as PDF button
  And User validates the BullionTrade in Preview in DF in view as PDF
  And User clicks on close button
  And User clicks on Auth Scope Tab
  And User clicks on Cancel button
  And User validates the renaming to showing all DF on listing screen

@TC=6290 @TC=6291 @TC=6292 @TC=6295 @TC=6298 @TC=6296 @TC=6300 @TC=6305 @TC=6306 @TC=6308 @TC=6309 @TC=6310 @TC=6313 @TC=6314 @TC=6316
Scenario: Validate Limit Scope Tab on Document Framework
  Given User is on Document Framework Page
  And user will select Column Values on Document Framework screen
    |Column Name   |value                |
    |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
    |EB Name       |1355 STORM PARKWAY LLC      |
  And User clicks on edit icon
  Then User validates the document version ID on Edit screen
    |Document Version ID|
    | DF-|
  Then User clicks on Limit Scope
  Then User will input Product family
    | Product Family |
    | Bullion        |
  Then User will input Delta
    | Delta |
    | No    |
  Then User will input Calculation Type
    | Calculation Type |
    | DSL              |
  * User will input Netting Type
    | Netting Type |
    | Greater      |
  And User enter Bullion Trades in Limit Scope
  | Only Metals  |
  * User will input Exclude CLS from calculation
    | Exclude CLS |
    | No          |
  And User clicks on Add Limit button
  And User clicks on Save As Draft button
  And User clicks on copy icon for lines to be copied for DF
  And User deletes the lines created
  And User clicks on Reset Current Changes button
  And Verify and click back button
  And User validates Auth Scope is visible
  And User clicks on Preview & Submit tab
  Then User clicks on Limit Scope Tab in Final Preview
  And User validates the Bullion in Limit Line in Preview in DF
  And User clicks on view as PDF button
  And User validates the Bullion in Limit Line in view as PDF
  And User clicks on close button
  And User clicks on Limit Scope
  And User clicks on Cancel button
  And User validates the renaming to showing all DF on listing screen

  @ResetData
  Scenario: Deleting the DF created
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |1355 STORM PARKWAY LLC                |
      |Lifecycle status    |Draft                                 |
    And User waits for 5 seconds
    Then User clicks on Delete icon DF
    And Click on Yes button of popup
    And User validates the message
      |Document is deleted|