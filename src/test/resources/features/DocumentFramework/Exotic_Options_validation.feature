@Regression @Touchdirection_validation

@US=DMGS-7533
Feature: Exotic Options Touch Direction Validation

  @TC=01 @TC=02 @TC=03 @TC=04 @TC=05 @TC=06 @TC=07 @TC=08 @TC=09 @TC=10 @TC=11 @TC=12
  Scenario:Exotic Options Touch Direction Validation DF
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
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document | For amendment |
      | Immediate        | Immediate     |
    And User clicks on Save As Draft button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                |
      | FX          | Exotic Options | Single Barrier Digital |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
    And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    #Then Clicks on ExpandAll button
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Touch direction
      | Touch Direction |
      | Down            |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Down            |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s.|
    Then User Deselects the Contract type
      | Contract Type |
      | Put           |
    Then User selects the Contract type Input
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Up              |
    Then User selects the Touch direction
      | Touch Direction |
      | Down            |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User Deselects the Contract type
      | Contract Type |
      | Put           |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User Deselects the Contract type
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    And User validates the pop-up message
      | Auth scope saved successfully |
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

  @document_type=DN
  Scenario: Exotic Options Touch Direction Validation for DN

    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 724500Q59D1FS2E4PI53                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
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
      | Asset Class | Product Family | Product                |
      | FX          | Exotic Options | Single Barrier Digital |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    #Then Clicks on ExpandAll button
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User selects the Touch direction
      | Touch Direction |
      | Down            |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Down            |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User Deselects the Contract type
      | Contract Type |
      | Put           |
    Then User selects the Contract type Input
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Up              |
    Then User selects the Touch direction
      | Touch Direction |
      | Down            |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User Deselects the Contract type
      | Contract Type |
      | Put           |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User Deselects the Contract type
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s |
    Then User selects the Contract type Input
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    And User validates the pop-up message
      | Auth scope saved successfully |
    Then User clicks on Cancel button
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Koudenburg B.V.                       |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | Koudenburg B.V.                       |
    Then User clicks on Terminate button
    And User clicks on Yes button
    Then User validates the Document approved message
      | Document is terminated |

  @document_type=4-way @TC=14
  Scenario: Exotic Options Touch Direction Validation 4way
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
    Given User is on Document Page
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
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                |
      | FX          | Exotic Options | Single Barrier Digital |
    And User adds Currencies
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    #Then Clicks on ExpandAll button
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Touch direction
      | Touch Direction |
      | Down            |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Down            |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User Deselects the Contract type
      | Contract Type |
      | Put           |
    Then User selects the Contract type Input
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User Deselects the Touch direction
      | Touch Direction |
      | Up              |
    Then User selects the Touch direction
      | Touch Direction |
      | Down            |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Touch direction
      | Touch Direction |
      | Up              |
    Then User Deselects the Contract type
      | Contract Type |
      | Put           |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Put           |
    Then User Deselects the Contract type
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    Then User validates the pop-up message
      | There is a mismatch between the specified Touch Direction’s and Contract Type’s. |
    Then User selects the Contract type Input
      | Contract Type |
      | Call          |
    Then User clicks on Save As Draft button
    And User validates the pop-up message
      | Auth scope saved successfully |
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
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |