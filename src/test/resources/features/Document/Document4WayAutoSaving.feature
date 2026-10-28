@Doc4WayAutoSaving @Regression
@US=DMGS-6373 @US=DMGS-3690

Feature: Validating 4way Continually saving data when applying agreement amendments

  @TC_07 @TC_08 @TC_09 @TC_13 @TC_14 @TC_15 @TC_16 @TC_17 @TC_18 @US=DMGS-3690 @TC_02
  Scenario: 4 Way document creation and validations on Next & back Button - Approval Workflow & Auth Scope
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 724500SKJBPCQP9YV662                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 969500A5K697NXKXL917                 |
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
      | Client 1       | 07 GALOIS                              |
      | Prime Broker 2 | Xenophon B.V.                         |
      | Client 2       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |New Document              |1                |
    Then User clicks on Next button
    Then User validates the toast message
      |Document workflow updated successfully|
    And Verify and click back button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Client - 1  |New Document              |2                |
    Then User clicks on Next button
    Then User validates the message
      |Approval matrix for Lei 07 GALOIS does not contain any approval group for action New Document|
    Then User waits for 7 seconds
    Then User clicks on Document terms tab
    Then User validates the message
      |Approval matrix for Lei 07 GALOIS does not contain any approval group for action New Document|
    Then User waits for 5 seconds
    Then User deletes the data from approval workflow
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product    |
      | FX          | Cash           | Forward    |
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
    Then User clicks on General Terms Tab
    Then User validates the message
      | There is a mismatch in settlement type and selected currencies in product group.|
    Then User waits for 7 seconds
    Then Verify and click back button
    Then User validates the message
      | There is a mismatch in settlement type and selected currencies in product group.|
    Then User waits for 7 seconds
    Then User clicks on Next button
    Then User validates the message
      | There is a mismatch in settlement type and selected currencies in product group.|

  @TC_10 @TC_11 @TC_012
  Scenario: 4 Way document creation and validations on Next & back Button - Limit Scope & USP Rider
    Given User is on Document Page
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
      | Client-1 Legal Entity Name | 07 GALOIS                             |
      | PB-2 Legal Entity Name     | Xenophon B.V.                         |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Limit Scope
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 1000000         |
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
    Then User edit the Product family
      |Product Family   |
      | Cash            |
#    And User click on save icon for limit line for DF
    And User clicks on Save As Draft button
    Then User validates the message
      |Delta and product family selection is invalid|
    Then User waits for 7 seconds
    Then User clicks on Next button
    Then User validates the message
      |Delta and product family selection is invalid|
    Then User waits for 7 seconds
    Then Verify and click back button
    Then User validates the message
      |Delta and product family selection is invalid|
    Then User waits for 7 seconds
    Then User will click on USP Rider tab in document edit
    Then User validates the message
      |Delta and product family selection is invalid|

  @TC_02 @TC_03 @TC_04 @TC_05 @TC_06
  Scenario: 4 Way document saving the data & clicking next & back Button
    Given User is on Document Page
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
      | Client-1 Legal Entity Name | 07 GALOIS                             |
      | PB-2 Legal Entity Name     | Xenophon B.V.                         |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    Then User clicks on edit icon
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
    Then User clicks on Next button
    Then User validates the message
      |Document workflow updated successfully|
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then Verify and click back button
    Then User validates the message
      |Enforcement rules updated successfully|
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      | For new document |For amendment      |value |Duration |
      |Immediate         |Schedule           |1     |hour     |
    Then User clicks on Next button
    Then User waits for 5 seconds
    Then User validates Document terms screen
    And User will click on the CK editor and type text into document content
      | Content           |
      | Test for Document Terms     |
    Then User clicks on Next button
    Then User validates the message
      |Document terms updated successfully|
    And User enters the current issue date
    Then Verify and click back button
    Then User validates the message
      |General terms saved successfully|
    Then User validates the Document terms data
      |Test for Document Terms|
    Then User validates the current issue date
    Then User clicks on Next button
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
    Then User clicks on Next button
    Then User validates the message
      |Auth scope saved successfully|
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 1000000         |
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
    Then Verify and click back button
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product          |
      | FX          | Volatility      | Volatility Swap  |
    Then User clicks on Next button
    And User validates the limit line
      | Calculation Type|Netting Type  | Bullion trades| Delta  |Product Family     |
      | DSL             |Greater L/S   | Exclude Metals|  Yes   | Exotic Options    |
    Then User clicks on Next button
    Then User will click on USP Rider tab in document edit
    Then User tick the USP Rider checkbox
    Then User selects the USP Rider and enter the date
    Then User clicks on Next button
    Then User validates the message
      |USP Rider for document saved successfully|
    And User clicks on view as PDF button
    And User validates Enforcement rule data
      |For new document   |For amendment      |value      |Duration |
      |Immediate          |Schedule           |2          |Hours    |
    And User validates the Document terms data in view as PDF
      |Test for Document Terms|
    And User validates Auth Scope Data in view as PDF
      |Product                        |Currencies   | Tenor      |
      |FX Volatility Volatility Swap  | AED         | 3 Years    |

  @ResetData
  Scenario: 4 Way document data reset
    Given User is on Document Page
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
      | Client-1 Legal Entity Name | 07 GALOIS                             |
      | PB-2 Legal Entity Name     | Xenophon B.V.                         |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Draft                                 |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |
