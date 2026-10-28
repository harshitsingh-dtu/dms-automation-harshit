@DFAutoSaving @Regression
@US=DMGS-6373 @ignore
  #puting ignore tag due to bug -due to approval matrix

Feature: Validating DF Continually saving data when applying agreement amendments

  @TC_01 @TC_02 @TC_03 @TC_04 @TC_05 @TC_06
  Scenario: DF creation and validations on Next & back Button - Approval Workflow & Auth Scope
    Given User resets DF document
      | docTypeId |7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   |254900SLCV8KI86BHL86|
      | ebLeiId   |9845008BSEED6B1A9984|
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      | Prime Broker 1   |  OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1             |  1355 STORM PARKWAY LLC                |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants       | Document_Action        | Approval_sequence |
      | Prime Broker - 1   | New Document Framework | 1                 |
    Then User clicks on Approval Workflow for DN
    Then User validates the message
      |Document workflow updated successfully|
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants           | Document_Action        | Approval_sequence |
      | Executing Broker - 1   | New Document           | 1                 |
    Then Verify and click back button
    Then User validates the message
      |Approval Matrix Not Found for Lei Name : 1355 STORM PARKWAY LLC.|
    Then User waits for 7 seconds
    Then User clicks on Limit Scope
    Then User validates the message
      |Approval Matrix Not Found for Lei Name : 1355 STORM PARKWAY LLC. |
    Then User waits for 5 seconds
    Then User deletes the data from approval workflow
    Then User clicks on Next button
    Then User clicks on enforcement rules tab for DF
    Then User semi fills the enforcement rules
    Then User clicks on Next button
    Then User validates the message
      |Enforcement rules cannot be semi-filled|
    Then User waits for 5 seconds
    Then Verify and click back button
    Then User validates the message
      |Enforcement rules cannot be semi-filled|
    Then User clicks on Auth Scope Tab
    Then User validates the message
      |Enforcement rules cannot be semi-filled|
    Then User clicks on Reset Current Changes button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then Verify and click back button
    Then User validates the message
      |Enforcement rules updated successfully|
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product    |
      | FX          | Cash           | Forward    |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And click on the submit button on pop up screen
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
    Then User clicks on Reset Current Changes button
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                    |
      | FX          | Bullion        | Bullion Vanilla Options    |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | XAG           |
    And click on the submit button on pop up screen
    Then User clicks on Add Auth Line
    Then User clicks on Limit Scope
    Then User validates the message
      |Auth scope saved successfully|

  @TC_01
  Scenario: DF creation and validations on Next & back Button - Limit Scope
    Given User is on Document Framework Page
    Then user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |1355 STORM PARKWAY LLC                |
      |Lifecycle status    |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Limit Scope
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
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
#    Then User clicks on edit icon
    Then User edit the Product family for DF
      |Product Family   |
      | Cash            |
#    And User click on save icon for limit line for DF
    And User clicks on Save As Draft button
    Then User validates the message
      |Delta and product family selection is invalid|
    Then User clicks on Next button
    Then User validates the message
      |Please save the changes.|
    Then User waits for 7 seconds
    Then Verify and click back button
    Then User validates the message
      |Please save the changes.|
    Then User waits for 7 seconds
    Then User clicks on Preview & Submit tab
    Then User validates the message
      |Please save the changes.|

  @TC_02 @TC_03 @TC_04 @TC_05 @TC_06
  Scenario: EDN document saving the data & clicking next & back Button
    Given User is on Document Framework Page
    Then user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |1355 STORM PARKWAY LLC                |
      |Lifecycle status    |Draft                                 |
    Then User clicks on edit icon
    And User clicks on General Terms Tab
    And User enters the current ISDA date
    Then Verify and click back button
    Then User validates the message
      |General terms saved successfully|
    Then User clicks on Next button
    Then User clicks on Limit Scope
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
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
    Then User clicks on Auth Scope Tab
    Then User validates the message
      |Limit scope updated successfully|
    Then User clicks on Next button
    And User validates the limit line
      | Calculation Type|Netting Type  | Bullion trades| Delta  |Product Family     |
      | DSL             |Greater L/S   | Exclude Metals|  Yes   | Exotic Options    |
    Then User clicks on Next button
    And User clicks on view as PDF button
    And User validates Enforcement rule data
      |For new document   |For amendment      |value      |Duration |
      |Immediate          |Schedule           |2          |Hours    |
    And User validates Auth Scope Data in view as PDF
      |Product                             |Currencies   | Tenor       |
      |FX Bullion Bullion Vanilla Options  | XAG         | Unspecified |

  @ResetData
  Scenario: DF document data reset
    Given User is on Document Framework Page
    Then user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |1355 STORM PARKWAY LLC                |
      |Lifecycle status    |Draft                                 |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |
