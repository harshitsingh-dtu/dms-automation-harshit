@Regression @US=DMGS-3712
@DN_BullionTrades_AND_VolatilitySwap

Feature: Validating Bullion Trades & Volatility Swap (Dataset is getting created by MR - DF to DocCreation)

  Scenario:User creates a draft document for testcases.
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 6SHGI4ZSSLCXXQSBB395                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    When User creates a document through API
      |Payload path|
      |src/test/java/resources/DocCreation_MR1.json|

  @TC=6257
  Scenario: Validate Bullion products can be specified separately when creating a DN or 4 Ways agreement.
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
    Then User clicks on edit icon
    Then User validates the document version ID on Edit screen
      |Document Version ID|
      |DN-|
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family to the Auth Scope
      | Asset Class | Product Family |
      | FX          | Bullion |
    Then User validates there should be 3 products in Bullion Family

  @TC=6258 @TC=6249 @TC=6250 @TC=6251 @TC=6258 @TC=6232 @TC=6772 @TC=6773
  Scenario: Validate preview/view as pdf of Bullion products & currency/currency pair for DN or 4 Ways doc type.
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
    Then User clicks on edit icon
    Then User validates the document version ID on Edit screen
      |Document Version ID|
      | DN-|
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion | Bullion Exotic Options,Bullion Vanilla Options  |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    And User clicks on Next button
    And User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
    |Product                            |Currencies     | Tenor            |
    |FX Bullion Bullion Vanilla Options | XAG           | 100 Business Days|
    |FX Volatility Volatility Swap      | ISK           | 3 Years          |
    |FX Bullion Bullion Exotic Options  | XAU           |100 Business Days |
    And User clicks on Limit Scope Tab in Final Preview
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      |Product                            |Currencies    | Tenor            |
      |FX Bullion Bullion Vanilla Options | XPD          | 100 Business Days|
      |FX Volatility Volatility Swap      | COP          | 3 Years      |
      |FX Bullion Bullion Exotic Options  | XPT          |100 Business Days|

  @TC=6252 @TC=6253
  Scenario: Validate query builder for volatility Swap for DN
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |Automation_Regression|
    And User clicks on Add query block
    And User performs multiple Add query block for DN
      |field                  |operator|value           |condition|
      |Product Family         |=       |Volatility      |AND|
      |Document Type          |=       |DN              |AND|
      |PB-1 Legal Entity Name |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED           |AND|
      |EB-1 Legal Entity Name |=       |CITIGROUP INC.  |And|
      |Client-1 Legal Entity Name |=       |CITIGROUP INC.  |null|
    Then User clicks on Apply
    Then User validates the DN document on listing screen
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF
      |Product                            |Currencies   | Tenor            |
      |FX Bullion Bullion Vanilla Options | XAU         | 100 Business Days|
      |FX Volatility Volatility Swap      | CRC         | 3 Years      |
      |FX Bullion Bullion Exotic Options  | XPD         |100 Business Days|

  @TC=6259
  Scenario: Validate query builder for Bullion products & currency for DN
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |Automation_Regression|
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                  |operator|value           |condition|
      |Currency               |=       |XAG             |AND|
      |Document Type          |=       |DN              |AND|
      |PB-1 Legal Entity Name |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED           |AND|
      |EB-1 Legal Entity Name |=       |CITIGROUP INC.  |And|
      |Client-1 Legal Entity Name |=       |CITIGROUP INC.  |null|
    Then User clicks on Apply
    Then User validates the DN document on listing screen
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF
      |Product                            |Currencies   | Tenor            |
      |FX Bullion Bullion Vanilla Options | XPT         | 100 Business Days|
      |FX Volatility Volatility Swap      | CRC         | 3 Years      |
      |FX Bullion Bullion Exotic Options  | XAG         |100 Business Days|

  @TC-6260 @TC=6207 @TC=6235
  Scenario: Verify Advance Filter screen
    Given User is on the all document screen
    And User will click on Apply More Filters
    And User will be redirected to Advance Filters Screen
    Then User reliably selects Auth Scope values in Advance filters
      | Product Family | Product                                        | Tenor Value | Tenor         |
      | Bullion        | Bullion Exotic Options,Bullion Vanilla Options | 100         | Business Days |
#    Then User clicks on Currencies and enter currency in the advance filter
    Then Verify user able to addCurrency
    |Currencies|
    |XPD|
    Then Click on Apply Filters
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF
      |Product                            |Currencies   | Tenor            |
      |FX Bullion Bullion Vanilla Options | XAU         | 100 Business Days|
      |FX Bullion Bullion Exotic Options  | XAG         |100 Business Days|

  @TC-6285
  Scenario:Validate Auth scope when editing the draft document in Dashboard.
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
    Then User clicks on edit icon
    Then User validates the document version ID on Edit screen
      |Document Version ID|
      | DN-|
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
    Then User clicks select All in Auth Scope for Bullion Product Family
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    Then User DeSelects Bullion Product family and validate
    Then User clicks select All in Auth Scope for Bullion Product Family
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product                  |
      | FX          | Bullion         | Bullion Vanilla Options  |
    And User enables all Auth Lines
    Then User clicks on Next Button on Auth Scope
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    And User deletes the lines created
    And User clicks on Save As Draft button
    Then User validates the message
      |Auth scope saved successfully|
    And User validates No Lines are there