@TenorConfigurationDF @Regression @US=DMGS-7424

Feature: To validate the Tenor configuration in DF

  @TC=01 @TC=02 @TC=03 @TC=04 @TC=05 @TC=07 @TC=08
  Scenario: To Check overall Tenor Configuration in DF
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
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User click on Tenor Configuration
    Then User waits for 2 seconds
#    Then user select tenor value and auth tenor for "FX Tenor" product
#      | 10 | Business Days |
    Then user select tenor value and auth tenor for "Overall Tenor" product
      | 10 | Business Days |
    Then User click on save tenor button
#    Then User validates the message
#      | Tenor changes as specified will be applied to the Authorisation Scope in the document. Please confirm? |
    Then User validates text is visible
      |Text                      |
      |Tenor changes as specified will be applied to the Authorisation Scope in the document. Please confirm?|
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 10 | Business Days |
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 6 | Months |
#    Then user select tenor value and auth tenor for "Forward" product
#      | 6 | Years |
#    Then user select tenor value and auth tenor for "Swap" product
#      | 6 | Calendar Days |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 6 | Months |
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 10 | Years |
#    Then user select tenor value and auth tenor for "Forward" product
#      | 1 | Years |
#    Then user select tenor value and auth tenor for "Swap" product
#      | 1 | Years |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 10 | Years |
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Overall Tenor" product
      | 5 | Business Days |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 5 | Business Days |
    Then User will edit Auth Tenor value
      | 20 |
    Then User will validate the tenor value and auth value
      | FX Cash Future | 20 | Business Days |
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Calendar Days |
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Business Days |
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Months |
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Years |
    Then User clicks on clear all button
    Then User clicks on Cancel button of tenor config popup
    Then User clicks on Cancel button
    Then User clicks on Yes button

  @TC=02
  Scenario: To validate the auth lines with different products as well in DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family            | Product               |
      | FX          | Volatility,Exotic Options | Volatility Swap,Asian |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Volatility Swap" product
      | 121 | Calendar Days |
    Then user select tenor value and auth tenor for "Asian" product
      | 198 | Business Days |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Volatility Volatility Swap | 121 | Calendar Days |
    Then User will validate the tenor value and auth value
      | FX Exotic Options Asian | 198 | Business Days |
    #Then User deletes all the auth Lines
    Then Clicks on DF Auth scope Expand All button
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                                                                |
      | FX          | Bullion        | Bullion Vanilla Options,Bullion Exotic Options,Bullion Spot or Forward |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | XAG           |
    And click on the submit button on pop up screen
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Bullion Vanilla Options" product
      | 6 | Months |
    Then user select tenor value and auth tenor for "Bullion Exotic Options" product
      | 1 | Years |
    Then user select tenor value and auth tenor for "Bullion Spot or Forward" product
      | 5 | Years |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Bullion Bullion Vanilla Options | 6 | Months |
    Then User will validate the tenor value and auth value
      | FX Bullion Bullion Exotic Options | 1 | Years |
    Then User will validate the tenor value and auth value
      | FX Bullion Bullion Spot or Forward | 5 | Years |
    Then User clicks on Cancel button
    Then User clicks on Yes button

  @TC=06 @TC=11
  Scenario: To check auth lines for the spot products in DF
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
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Spot    |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Up-to-spot |
    Then User clicks on Add Auth Line
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Spot" product
      | 1 | Spot-only |
    Then User clicks on clear all button
    Then user select tenor value and auth tenor for "Spot" product
      | 1 | Up-to-spot |
    Then User clicks on clear all button
    Then user select tenor value and auth tenor for "Overall Tenor" product
      | 5 | Years |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User will validate the tenor value in DF
      | FX Cash Spot | Up-to-spot |
    Then User clicks on Save As Draft button
    Then User waits for 2 seconds
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family                 | Product                      |
      | FX          | Cash,Volatility,Exotic Options | Future,Volatility Swap,Asian |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And click on the submit button on pop up screen
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Months     |
    Then User clicks on Add Auth Line
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 6 | Years |
    Then user select tenor value and auth tenor for "Volatility Swap" product
      | 6 | Years |
    Then user select tenor value and auth tenor for "Asian" product
      | 6 | Years |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 6 | Years |
    Then User will validate the tenor value and auth value
      | FX Volatility Swap Volatility | 6 | Years |
    Then User will validate the tenor value and auth value
      | FX Exotic Options Asian | 6 | Years |
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
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
      | Product                       | Currencies | Tenor      |
      | FX Cash Future                | AED        | 6 Years    |
      | FX Volatility Volatility Swap | AED        | 6 Years    |
      | FX Exotic Options Asian       | AED        | 6 Years    |
      | FX Cash Spot                  | AED        | Up-to-spot |
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      | Product                       | Currencies | Tenor      |
      | FX Cash Future                | AED        | 6 Years    |
      | FX Volatility Volatility Swap | AED        | 6 Years    |
      | FX Exotic Options Asian       | AED        | 6 Years    |
      | FX Cash Spot                  | AED        | Up-to-spot |
    Then User clicks on close button
    Then User clicks on submit for approval button
    Then User validates the message
      | Document is Approved |

  @TC=09 @TC=10
  Scenario: To Check the exceeding tenor limit validation in DN
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
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    Then User will edit Auth Tenor value
      | 8 |
    Then User clicks on Save As Draft button
    Then User validates the message
      | Invalid value in tenor |
    Then User deletes all the auth Lines
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family                 | Product                           |
      | FX          | Cash,Volatility,Exotic Options | Future,Volatility Swap,Asian,Spot |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 10 | Calendar Days |
    Then user select tenor value and auth tenor for "Volatility Swap" product
      | 11 | Business Days |
    Then user select tenor value and auth tenor for "Asian" product
      | 15 | Months |
    Then user select tenor value and auth tenor for "Spot" product
      | 15 | Calendar Days |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 10 | Calendar Days |
    Then User will validate the tenor value and auth value
      | FX Volatility Swap Volatility | 11 | Business Days |
    Then User will validate the tenor value and auth value
      | FX Exotic Options Asian | 15 | Months |
    Then User will validate the tenor value
      | FX Cash Spot | Up-to-spot |
    Then User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
      | Product                       | Currencies | Tenor            |
      | FX Cash Future                | AED        | 10 Calendar Days |
      | FX Volatility Volatility Swap | AED        | 11 Business Days |
      | FX Exotic Options Asian       | AED        | 15 Months        |
      | FX Cash Spot                  | AED        | Up-to-spot       |
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      | Product                       | Currencies | Tenor            |
      | FX Cash Future                | AED        | 10 Calendar Days |
      | FX Volatility Volatility Swap | AED        | 11 Business Days |
      | FX Exotic Options Asian       | AED        | 15 Months        |
      | FX Cash Spot                  | AED        | Up-to-spot       |
    Then User clicks on close button
    Then User will click on cancel button
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    Then User click on delete button
    Then User validates the message
      | Document is deleted |

  @ResettingTheData @TC=10
  Scenario: Resetting the data
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value                                 |
      | PB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name          | Koudenburg B.V.                       |
      | Lifecycle status | Approved                              |
    Then User clicks on Terminate button
    Then Click on Yes button of popup
    Then User validates the message
      | Document is terminated |