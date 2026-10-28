@DF_DN_Creation @document_type=DN
@API @Global_MRs

Feature: Create EDNs in In-approved/Apprved state for DFs

@DocumentFrameworkCreation3
#  failing due to DMGS-5901
Scenario:User creates this DF for DF-DN Integration
  Given User is on Document Framework Page
  Then User creates a document framework through API
    |Payload path|
    |src/test/java/resources/DF_Creation_MR3.json|
  Then User adds immediate enforcement rules via API for DN Document or Document Framework
  Then User adds General Terms via API for DN Document Framework
  Then User adds LimitScope via API for Document or Document Framework
  And user will select Column Values on Document Framework screen
    |Column Name         |value                                 |
    |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
    |Lifecycle status    |Draft                                 |
  Then User clicks on edit icon
  Then User clicks on Next button
  And User validates the approval Wokflow for DN
  Then User will Drag participants and arrange them in approval sequence correspondence to their document action
    |Participants      |Document_Action           |Approval_sequence|
    |Prime Broker - 1  |New Document              |1                |
#    |Prime Broker - 1  |Edit Document             |1                |
  Then User clicks on Next button
  And User clicks on Auth Scope Tab
  Then User Add Asset Class, Product Family, Product to the Auth Scope
    | Asset Class | Product Family | Product |
    | FX          | Exotic Options | Double Barrier |
  And Click on + Add currencies
  And User will search for the currency and select them
    |currency list|
    |AED|
    |CLF|
    |COP|
    |CRC|
    |ISK|
  And User will submit the changes
  And User enables Tenor
  * User will input Auth Tenor value
    | Auth Value |
    | 3          |
  * User will select tenor in Auth Tenor
    | Auth Tenor |
    | Years      |
  And User clicks on Add Auth Line
  Then User Add Asset Class, Product Family, Product to the Auth Scope
    | Asset Class | Product Family | Product |
    | FX          | Bullion        | Bullion Vanilla Options |
  And Click on + Add currencies
  And User will search for the currency and select them
    |currency list|
    |XAG|
    |XAU|
    |XPD|
    |XPT|
  And User will submit the changes
  * User will input Auth Tenor value
    | Auth Value |
    | 10         |
  * User will select tenor in Auth Tenor
    | Auth Tenor |
    | Business Days      |
  And User clicks on Add Auth Line
  Then User clicks on Next button
  Then User Final Preview & Submit the Document
  And user will select Column Values on Document Framework screen
    |Column Name   |value                |
    |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
    |EB Name       |ACE URBAN RACE PRIVATE LIMITED     |
  Then User validates the Document Framework status as approved

@In_Approval_EDN
Scenario: User creates an In-Approval EDN from DocumentFramework
  Given User will go to Document screen
  Then User clicks on Create New Document
  Then User select document type,acting as
    | Document Type | Acting As |
    | DN            | PB        |
  And User select the LEIs
    |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB 1             |ACE URBAN RACE PRIVATE LIMITED  |
    |Client 1         |ACE URBAN RACE PRIVATE LIMITED  |
  Then User clicks on Next button
  Then User clicks on Auth Scope Tab
  Then User Add Asset Class, Product Family, Product to the Auth Scope
   | Asset Class | Product Family | Product |
    | FX          | Exotic Options | Double Barrier |
  And User clicks on Add Auth Line
  Then User Add Asset Class, Product Family, Product to the Auth Scope
    | Asset Class | Product Family | Product |
    | FX          | Bullion | Bullion Vanilla Options |
  And User clicks on Add Auth Line
  Then User enables all Auth Lines
  Then User clicks on Next button
  Then User enable the Limit line and validate the same
  Then User clicks on limit line edit icon and enters value
  |999999999999999|
  Then User clicks on Next button
  Then User validates the message
    |Limit scope updated successfully|
  Then User Final Preview & Submit the Document
  Then User validates the Document approved message
    |Document is In-approval|

@Approved_EDN
Scenario: User creates an Enforced EDN from DocumentFramework
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB 1             |CITIGROUP INC.                        |
      |Client 1         |3G Fund, L.P.                         |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      |99999999|
    Then User clicks on Next button
    Then User validates the message
      |Limit scope updated successfully|
    Then User Final Preview & Submit the Document
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
      |Document is Approved|

  @DMGS-8954
  Scenario:User creates this DF to create a Enforced DN for  edit alternate id option (which will be visible for org which have push notification enabled)
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | BARCLAYS PLC|
      | EB 1           | OSTTRA INDIA SERVICES PRIVATE LIMITED     |
    Then User clicks on Next button
    Then User clicks on Next button
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
    And user will submit the changes
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    Then User will input Product family
      | Product Family |
      | Bullion        |
    Then User will input Delta
      | Delta |
      | No    |
    Then User will input Calculation Type
      | Calculation Type |
      | DSL              |
    * User will input Netting Type
      | Netting Type |
      | Greater      |
    And User enter Bullion Trades in Limit Scope
      | Only Metals  |
    * User will input Exclude CLS from calculation
      | Exclude CLS |
      | No          |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User validates the Document Framework status as approved

@DMGS-8954
  Scenario:User creates this Enforced DN for  edit alternate id option (which will be visible for org which have push notification enabled)
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | BARCLAYS PLC|
      | EB 1           | OSTTRA INDIA SERVICES PRIVATE LIMITED     |
      | Client 1       | CITIGROUP INC.                       |
    Then User clicks on Next button
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      |99999999|
      |9999999|
    And User click on save icon for limit line
    Then User clicks on Next button
    Then User validates the message
      |Limit scope updated successfully|
    Then User Final Preview & Submit the Document
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
      |Document is Approved|

  @DMGS-8954
  Scenario: User created  this DF to create an In-approval DN to validate edit alternate id action type for In-approval doc|
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | BARCLAYS PLC|
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User clicks on Next button
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
    And user will submit the changes
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    Then User will input Product family
      | Product Family |
      | Bullion        |
    Then User will input Delta
      | Delta |
      | No    |
    Then User will input Calculation Type
      | Calculation Type |
      | DSL              |
    * User will input Netting Type
      | Netting Type |
      | Greater      |
    And User enter Bullion Trades in Limit Scope
      | Only Metals  |
    * User will input Exclude CLS from calculation
      | Exclude CLS |
      | No          |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User validates the Document Framework status as approved

  @DMGS-8954
  Scenario: User created  In-approval DN to validate edit alternate id action type for In-approval doc|
      Given User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | BARCLAYS PLC |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client 1       | CITIGROUP INC.                       |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And User clicks on Add Auth Line
      Then User enables all Auth Lines
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User validates the Document approved message
      |Document is In-approval|
