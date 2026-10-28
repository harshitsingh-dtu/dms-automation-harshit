@TenorConfiguration4Way @Regression @US=DMGS-7424

Feature: To validate the Tenor configuration in 4 Way

  Scenario: To validate all above steps in 4 ways
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
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | JPY           |
    And click on the submit button on pop up screen
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
    Then User click on Tenor Configuration
     Then user select tenor value and auth tenor for "Overall Tenor" product
      | 10 | Business Days |
    Then User click on save tenor button
    Then User validates text is visible
      |Text                      |
      |Tenor changes as specified will be applied to the Authorisation Scope in the document. Please confirm?|
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 10 | Business Days |
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 6 | Months |
    Then user select tenor value and auth tenor for "Forward" product
      | 6 | Years |
    Then user select tenor value and auth tenor for "Swap" product
      | 6 | Calendar Days |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 6 | Months |
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
    Then User clicks on Save As Draft button
    Then User click on Tenor Configuration
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Calendar Days |
    Then User clicks on clear all button
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Business Days |
    Then User clicks on clear all button
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Months |
    Then User clicks on clear all button
    Then user select tenor value and auth tenor for "Future" product
      | 1 | Years |
    Then User clicks on clear all button
    Then User clicks on Cancel button of tenor config popup
    Then Clicks on DF Auth scope Expand All button if Expand is visible
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

  Scenario: To validate the auth lines with different products as well in 4 Way
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
#    Then User deletes all the auth Lines
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family                 | Product                      |
      | FX          | Cash,Volatility,Exotic Options | Future,Volatility Swap,Asian |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | JPY           |
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
      | 6 | Calendar Days |
    Then user select tenor value and auth tenor for "Volatility Swap" product
      | 8 | Months |
    Then user select tenor value and auth tenor for "Asian" product
      | 10 | Years |
    Then User click on save tenor button
    Then User clicks on confirm button
    Then User will validate the tenor value and auth value
      | FX Cash Future | 6 | Calendar Days |
    Then User will validate the tenor value and auth value
      | FX Volatility Swap Volatility | 8 | Months |
    Then User will validate the tenor value and auth value
      | FX Exotic Options Asian | 10 | Years |
    Then User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
      | Product                       | Currencies | Tenor           |
      | FX Cash Future                | JPY        | 6 Calendar Days |
      | FX Volatility Volatility Swap | JPY        | 8 Months        |
      | FX Exotic Options Asian       | JPY        | 10 Years        |
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      | Product                       | Currencies | Tenor           |
      | FX Cash Future                | JPY        | 6 Calendar Days |
      | FX Volatility Volatility Swap | JPY        | 8 Months        |
      | FX Exotic Options Asian       | JPY        | 10 Years        |
    Then User clicks on close button
    Then User clicks on Cancel button
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    Then User click on delete button
    Then User validates the message
      | Document is deleted |