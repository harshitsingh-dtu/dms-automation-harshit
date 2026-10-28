@Doc4WayAmendment @Regression

Feature: Validating 4way Amendment Scenarios

  @TC-7721 @TC-7709 @TC-7720 @TC-7708
  Scenario: User selects Acting as PB/Client then then only Prime Broker-1/Client 1 data should come from ODC otherwise the rest data should come from Jigsaw while copying a 4 way doc
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      | Column Name     | value    |
      | Document ID     | 4W       |
      | Document Status | Enforced |
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | Client    |
    And User select the LEIs
      | Prime Broker 1 | Kelpop B.V |
    And User validates the LEI "Kelpop B.V" is NOT present in the dropdown for "Client 1"
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Client 1 | Kelpop B.V |
    And User validates the LEI "Kelpop B.V" is NOT present in the dropdown for "Prime Broker 1"

  @TC-7703 @TC-7704
  Scenario: User selects Acting as PB/Client then then only Prime Broker-1/Client 1 data should come from ODC otherwise the rest data should come from Jigsaw while creating a doc
    Given User is on Document Page
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | Client    |
    And User select the LEIs
      | Prime Broker 1 | Kelpop B.V |
    And User validates the LEI "Kelpop B.V" is NOT present in the dropdown for "Client 1"
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Client 1 | Kelpop B.V |
    And User validates the LEI "Kelpop B.V" is NOT present in the dropdown for "Prime Broker 1"

  @TC-2528
  Scenario: Validate preview of user edited & copied details in document - 4 way
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      | Column Name     | value    |
      | Document ID     | 4W       |
      | Document Status | Enforced |
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | 1355 STORM PARKWAY LLC                |
      | Prime Broker 2 | Xenophon B.V.                         |
      | Client 2       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Limit Scope
    And User clicks on edit icon
    And User clicks on Delete icon for limit line
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    And User clicks on Limit Scope Tab in Final Preview
    And User validates the limit line
      | Calculation Type | Limit Value     | Netting Type | Bullion trades | Delta | Product Family | Exclude CLS |
      | DSL              | 999999999999999 | Greater L/S  | Exclude Metals | Yes   | Exotic Options | Yes         |
    Then User clicks on Cancel button
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | PB-2 Legal Entity Name     |
      | Client-2 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Xenophon B.V.                         |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |

  @TC-6321
  Scenario: Validate currency pair when specifying the authorization scope on 4 Way doc
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 724500SKJBPCQP9YV662                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 9845008BSEED6B1A9984                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 6SHGI4ZSSLCXXQSBB395                |
      | client2OrgTypeKey | 3                                    |
    Given User is on Document Page
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | 1355 STORM PARKWAY LLC                |
      | Prime Broker 2 | Xenophon B.V.                         |
      | Client 2       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    Then User clicks on multiple Currencies-Pair and enter currency pair in the filter
      | Currencies-pair |
      | DKK-EUR         |
      | EUR-ISK         |
      | ARS-HUF         |
      | GBP-CNY         |
      | EUR-KRW         |
      | EUR-BGN         |
      | CNY-CAD         |
      | CLP-SGD         |
      | EUR-TWD         |
      | CHF-HUF         |
      | AUD-GBP         |
      | CAD-BRL         |
      | CLP-MXN         |
      | EUR-TRY         |
      | CHF-SEK         |
      | CHF-JPY         |
      | AUD-MYR         |
      | EUR-RUB         |
      | AUD-RUB         |
      | EUR-KES         |
      | COP-EUR         |
    And click on the submit button on pop up screen
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User clicks on Save As Draft button
    Then User clicks on Cancel button
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | PB-2 Legal Entity Name     |
      | Client-2 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Xenophon B.V.                         |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |

  @TC=6250 @TC=6251 @TC=6252 @TC=6253
  Scenario: Validate query builder for volatility Swap for 4 Way
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 724500SKJBPCQP9YV662                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 9845008BSEED6B1A9984                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 6SHGI4ZSSLCXXQSBB395                |
      | client2OrgTypeKey | 3                                    |
    Given User is on Document Page
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | 1355 STORM PARKWAY LLC                |
      | Prime Broker 2 | Xenophon B.V.                         |
      | Client 2       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
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
      | Years      |
    Then User clicks on Add Auth Line
    Then User clicks on Save As Draft button
    And User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
      | Product                       | Currencies | Tenor   |
      | FX Volatility Volatility Swap | AED        | 3 Years |
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      | Product                       | Currencies | Tenor   |
      | FX Volatility Volatility Swap | AED        | 3 Years |
    And User clicks on close button
    And User clicks on Cancel button
    And User waits for 3 seconds
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      | query name    |
      | Test_Automate |
    And User clicks on Add query block
    And User performs multiple Add query block
      | field                      | operator | value                                 | condition |
      | Product Family             | =        | Volatility                            | AND       |
      | Document Type              | =        | 4 Way                                 | AND       |
      | PB-1 Legal Entity Name     | =        | Osttra India Services Private Limited | AND       |
      | Client-1 Legal Entity Name | =        | 1355 STORM PARKWAY LLC                | AND       |
      | PB-2 Legal Entity Name     | =        | Xenophon B.V.                         | AND       |
      | Client-2 Legal Entity Name | =        | CITIGROUP INC.                        | null      |
    Then User clicks on Apply
    And User clicks on Preview of Document
    And User validates Auth Scope Data in view as PDF
      | Product                       | Currencies | Tenor   |
      | FX Volatility Volatility Swap | AED        | 3 Years |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |