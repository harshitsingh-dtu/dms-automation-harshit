@DocumentFramework @Regression
@GeneralTermsValidation @US=DMGS-3213

Feature: Workflow for Create,Edit,Delete Document FrameWork (Uses MR @DraftDF)

@TC=6582 @TC=6583 @TC=6584 @TC=6585 @TC=6586 @TC=6587 @TC=6588 @TC=6589 @TC=6590 @TC=6591
  Scenario: Validating General Terms date in DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |EB Name       |ABC ARBITRAGE|
      |Lifecycle status    |Approved|
    And user clicks on Document Edit icon
    Then User will click on submit
    Then User clicks on Next button
    And User clicks on General Terms Tab
    Then User validates ISDA dates is visible and select random date
    Then User validates MasterAgreement dates is visible and select random date in DF
    Then User clicks on Save As Draft button
    And validate General Terms saved successfully message is displayed
    Then User validates EMTA dates is visible and select random date
    Then User clicks on Reset Current Changes button
    Then User validates EMTA dates is visible and deselect random date
    Then User validates select date is visible
    Then User validates EMTA dates is visible and select random date
    Then User clicks on Save As Draft button
#    And User clicks on Next button
    And validate General Terms saved successfully message is displayed
    And User clicks on Next button
    And User validates Auth Scope is visible
    And Verify and click back button
    And Verify and click back button
    Then User validate enforcement rules screen is visible
    Then User clicks on Cancel button
    And Validate User is on Document Framework Screen

  @TC=6592 @TC=6593
  Scenario: Validating General Terms date in Preview & Submit screen of DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |ABC ARBITRAGE |
    And user clicks on Document Edit icon
    Then User clicks on Next button
    And User clicks on General Terms Tab
    And User selects dates for General Terms if they are not already selected
    Then User clicks on Preview & Submit tab
    Then User clicks on General Terms Tab Preview tab
    Then User validates the Dates in preview screen
    And User clicks on view as PDF button
    Then User validates the Dates in Preview in DF in view as PDF

  @TC=6970 @TC=6974
  Scenario: Validating user should see currencies respectively in Auth Scope - Deliverable & Non- Deliverable
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
      |EB Name       |ABC ARBITRAGE |
    And user clicks on Document Edit icon
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
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
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line

#    putting ignore tag becuase it is failed page not found when ur enter the Current Return Time
  @TC-7306 @TC-7346 @TC-7466 @ignore
  Scenario: User enters the GeneralTerms dates and validates on Dashboard
    Given User will go to Document screen
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                  |
      | ebLeiId     | 6SHGI4ZSSLCXXQSBB395                 |
      | clientLeiId |52990009S1NJ32PLXA96|
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      | EB 1           |CITIGROUP INC.|
      | Client 1       |EKAZENT Building Rental GmbH|
    Then User clicks on Next button
    Given User will go to Document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                    |
      | PB-1 Legal Entity Name         |
      | Client-1 Legal Entity Name     |
      | EB-1 Legal Entity Name         |
      | Current Issue Date             |
      | First Issue Date               |
      |Last Updated On (Local Time)    |
      |Last Updated On (UTC Time)      |
      |Current Return Time (Local Time)|
      |Current Return Time (UTC Time)  |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |EB-1 Legal Entity Name        |CITIGROUP INC.|
      |Client-1 Legal Entity Name    |EKAZENT Building Rental GmbH|
    And User clicks on edit icon
    And User clicks on General Terms Tab
    And User verifies Physically Settled Bullion is displayed
    And User enters the current issue date
    And User enters the Reference date
    And User enters the First Issue date
#    And User enter the Current Enforcement Time
    And User enters the Current Return Time
    And User clicks on Save As Draft button
    And User validates the message
      |General terms saved successfully|
    Then User will click on GT cancel button
    Then User refreshes the browser
    Then user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |EB-1 Legal Entity Name        |CITIGROUP INC.|
      |Client-1 Legal Entity Name    |EKAZENT Building Rental GmbH|
    Then User validates the Dates data on the Dashboard
