@4WayDocumentCreation @document_type=4-way
@Global_MRs
Feature: Workflow for Create New 4 way Draft Document

  @US=DMGS-5909
  Scenario: User creates a 4way draft document
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1                       | Clients 1                            | Prime Broker 2 |Clients 2     |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |CITIGROUP INC.  |CITIGROUP INC. |
    Then User clicks on Next button

  @US=DMGS-5909 @US=DMGS-6758
  Scenario: User creates a 4way draft document by adding a Fund for client 2
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1 | Clients 1    | Prime Broker 2 |Clients 2     |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |CITIGROUP INC.        |CITIGROUP INC. |3G Fund, L.P. |
    And User clicks on Add fund button for client2
    Then User add the funds
      |Funds               |
      |1355 STORM PARKWAY LLC|
    And User clicks on Save button
    Then User clicks on Next button


  Scenario: User creates a 4way document in In-approval state
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1               | Clients 1     | Prime Broker 2 | Clients 2       |
      | THE MOYRA BRUCE FAMILY TRUST |Lusa - Portuguese News Agency SA|Winterthur Cooperative Society|3G Fund, L.P.|
    Then User clicks on Next button
    Then User validates the document version ID on 4W creation Screen
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And User adds Currencies
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
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document

    @US=DMGS-8954
  Scenario: User creates a 4way document in Enforced status to check alternate id should not be visible for 4way doc type
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
      Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
        | Prime Broker 1 | Clients 1    | Prime Broker 2 |Clients 2     |
        |BARCLAYS PLC  |OSTTRA INDIA SERVICES PRIVATE LIMITED  |CITIC Capital China Partners III, L.P.       |CITIC Capital China Partners III, L.P.      |
    Then User clicks on Next button
      Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And User adds Currencies
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
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User waits for some time, refreshes the page and validates the status
