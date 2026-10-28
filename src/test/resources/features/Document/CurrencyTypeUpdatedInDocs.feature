@DNAndDFCurrencyValidations @Regression @US=DMGS-7309 @US=7808

Feature: Validate the currency type of the currency JPY and USD is deliverable or non deliverable

  @TC=01  @TC=04
  Scenario: User is able to validate JPY and USD have a currency type as Deliverable
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           |De Wit/Koudenburg B.V.                 |
    Then User clicks on Next button
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    And User clicks on Save As Draft button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are deliverable in pop-up
      | JPY |
      | USD |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
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
    Then User clicks on submit for approval button
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | De Wit/Koudenburg B.V.                       |
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF for Deliverable currencies
      | Deliverable |
      | JPY         |
      | USD         |
    And User clicks on close button

  @TC=02 @TC=05
  Scenario: User is able to validate JPY and USD have a currency type as Deliverable
    Given User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | De Wit/Koudenburg B.V.                |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    And User clicks on Save As Draft button
    Then User clicks on Cancel button
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | EB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | De Wit/Koudenburg B.V.                |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
    And User clicks on Preview of Document
    And User validates Auth Scope Data in view as PDF for Deliverable currencies
      | Deliverable |
      | JPY         |
      | USD         |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | De Wit/Koudenburg B.V.                       |
      |Lifecycle status|Approved             |
    Then User clicks on Terminate button
    And User clicks on Yes button
    Then User validates the Document approved message
      | Document is terminated |


  @TC=07  @TC=08
  Scenario: User is able to validate JPY and USD have a currency type as Deliverable for 4 way
    Given User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       |1355 STORM PARKWAY LLC                |
      | Prime Broker 2 |1355 STORM PARKWAY LLC                    |
      | Client 2       |OSTTRA INDIA SERVICES PRIVATE LIMITED                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are deliverable in pop-up
      | JPY |
      | USD |
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
      | PB-2 Legal Entity Name     | 1355 STORM PARKWAY LLC                         |
      | Client-2 Legal Entity Name | OSTTRA INDIA SERVICES PRIVATE LIMITED                        |
    And User clicks on Preview of Document
    And User validates Auth Scope Data in view as PDF for Deliverable currencies
      | Deliverable |
      | JPY         |
      | USD         |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |


  @TC=09
  Scenario: Validate that User is able to verify the currency JPY and USD as deliverable through advance filter
    Given User is on the all document screen
    Then User will click on Apply More Filters
    And User selects and validates deliverable currencies via Advanced Filter
      | JPY |
      | USD |
    Then User clicks on Cancel button

  @TC=10
  Scenario: Validate that user is able to verify the currency JPY and USD as deliverable at bulk edit remove currency screen
    Given User is on Document Page
    Then User clicks on Bulk Action button
    Then User selects edit button
    Then User will select doc type for edit
      | Doc Type |
      | 4 Way    |
    Then User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type     |
      | Remove Currency |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select first document
    And Verify next button and click
    And User selects and validates currencies are deliverable in pop-up
      | JPY |
      | USD |
    And User clicks on Cancel button

  @US=7808 @TC-02
  Scenario: User is able to validate newly added currencies in DF
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | De Wit/Koudenburg B.V.                |
    Then User clicks on Next button
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    And User clicks on Save As Draft button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are present in pop-up
      | MZN |
      | UZS |
      | LKR |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    Then User clicks on Add Auth Line
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
    Then User clicks on submit for approval button
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | De Wit/Koudenburg B.V.                |
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF for Deliverable currencies
      | Deliverable |
      | MZN         |
      | UZS         |
      | LKR         |
    And User validates Auth Scope Data in view as PDF for Non-Deliverable currencies
      | Deliverable |
      | MZN         |
      | UZS         |
      | LKR         |
    And User clicks on close button

  @US=7808 @TC-03
  Scenario: User is able to validate the newly added currencies in the DN
    Given User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | De Wit/Koudenburg B.V.                |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    And User clicks on Save As Draft button
    Then User clicks on Cancel button
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | EB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | De Wit/Koudenburg B.V.                |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
    And User clicks on Preview of Document
    And User validates Auth Scope Data in view as PDF for Deliverable currencies
      | Deliverable |
      | MZN         |
      | UZS         |
      | LKR         |
    And User validates Auth Scope Data in view as PDF for Non-Deliverable currencies
      | Deliverable |
      | MZN         |
      | UZS         |
      | LKR         |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | De Wit/Koudenburg B.V.                |
    Then User clicks on Terminate button
    And User clicks on Yes button
    Then User validates the Document approved message
      | Document is terminated |

  @US=7808 @TC-04
  Scenario: User is able to newly added currencies in 4Way doc
    Given User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | 1355 STORM PARKWAY LLC                |
      | Prime Broker 2 | 1355 STORM PARKWAY LLC                         |
      | Client 2       | OSTTRA INDIA SERVICES PRIVATE LIMITED                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    And User selects and validates currencies are present in pop-up
      | MZN |
      | UZS |
      | LKR |
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
      | PB-2 Legal Entity Name     | 1355 STORM PARKWAY LLC                          |
      | Client-2 Legal Entity Name | OSTTRA INDIA SERVICES PRIVATE LIMITED                        |
    And User clicks on Preview of Document
    And User validates Auth Scope Data in view as PDF for Deliverable currencies
      | Deliverable |
      | MZN         |
      | UZS         |
      | LKR         |
    And User validates Auth Scope Data in view as PDF for Non-Deliverable currencies
      | Deliverable |
      | MZN         |
      | UZS         |
      | LKR         |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |

  @US=7808 @TC-05
  Scenario: Validate that User is able to verify the newly added currencies through advance filter
    Given User is on the all document screen
    Then User will click on Apply More Filters
    And User selects and validates both currencies via Advanced Filter
      | MZN |
      | UZS |
      | LKR |
    Then User clicks on Cancel button