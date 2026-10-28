@DocumentFramework @Regression
@Notification_and_validating_DF @GeneralTermsValidation

Feature: Notifications for Document FrameWork actions

@TC=6573 @TC=6575
Scenario: Validate if restriction is created and in Draft state then the in app notification is send
  Given User is on Document Framework Page
  And Click on create New Document Framework button
  And validate the document type value as DN
  Then User select acting as
    | Acting As |
    | PB        |
  And User select the LEIs
    | Prime Broker 1   |  OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    | EB 1             |  3243575 CANADA INC.  |
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
  Then Click on notification bell icon
  And User clicks on view all notifications
  Then User is able to check the notification for new draft DF

  @TC=6578 @TC=6577
    Scenario: Validate if restriction is edited then the in app notification is send & no Notification for expired
      Given User is on Document Framework Page
      When User clicks on Column Selection button
      And User will search for column, selects it if not already selected and validates the same on Document listing screen
      |Column Name|
      |PB Name    |
      |EB Name    |
      And user will select Column Values on Document Framework screen
      |Column Name   |value                                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |EB Name       |3243575 CANADA INC.                  |
    And user clicks on Document Edit icon
    And User will select acting as for edit document
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will click on Submit Button
    And User clicks on Next button
    And User Final Preview & Submit the Document
    And Refresh web page
    Then Click on notification bell icon
    And User clicks on view all notifications
    And User is able to check the notification for edited DF
    And validate that No notification is sent for expired DF

  @TC=6572
  Scenario: Validate clicking on Restriction Version ID of Expired & Draft Restriction on Restriction listing screen
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |3243575 CANADA INC.  |
    And user selects the lifecycle status filter value for DF
      |lifeCycle status|
      |	Terminated        |
    Then User clicks on Preview of DF
    Then User validates the DF version ID in the preview
    Then User Validates the DocumentType, Allowed Currencies, PB & EB for DF
    Then User Validates the approval Wokflow for DF and actions
    Then User validates the approval Wokflow for DN
    Then User validates the enforcement rule for DN
    Then User validates the general terms
    Then User validates the Auth Scope
    Then User validates the limit scope

@TC=6569
  Scenario: Validate clicking on Restriction Version ID of Expired & Draft Restriction on Restriction listing screen Again
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |3243575 CANADA INC.  |
  And user clicks on Document Edit icon
  And User will select acting as for edit document
    |acting as|
    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
  And User will click on Submit Button
  And User clicks on Cancel button
#  And verify cancel button
  And user will select Column Values on Document Framework screen
    |Column Name   |value                |
    |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
    |EB Name       |3243575 CANADA INC.  |
    And user selects the lifecycle status filter value for DF
      |lifeCycle status|
      |Draft        |
    Then User clicks on Preview of DF
    Then User validates the DF version ID in the preview
    Then User Validates the DocumentType, Allowed Currencies, PB & EB for DF
    Then User Validates the approval Wokflow for DF and actions
    Then User validates the approval Wokflow for DN
    Then User validates the enforcement rule for DN
    Then User validates the general terms
    Then User validates the Auth Scope
    Then User validates the limit scope

  @Resetting_Data
  Scenario: Resetting the above data
      Given User is on Document Framework Page
      And user will select Column Values on Document Framework screen
        |Column Name   |value                |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
        |EB Name       |3243575 CANADA INC.  |
    And user selects the lifecycle status filter value for DF
      |lifeCycle status|
      |Draft        |
      And User will click on delete icon from action column for the document

  @Resetting_Data
  Scenario: Resetting the above data by Terminate
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |3243575 CANADA INC.  |
    And user selects the lifecycle status filter value for DF
      |lifeCycle status|
      |Approved        |
    Then User clicks on Terminate button
    And Click on Yes button of popup
    And User refreshes the browser
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |3243575 CANADA INC. |
    And User will click on delete icon from action column for the document