@DMGS8977 @Regression
@AllowedCurrencies

Feature: User Story DMGS-8977 - Allowed Currencies & Authorization Scope Verification

  Background:
    Given User is on Document Page

    @InitialSetupDN
  Scenario: Testcase to set columns for the Document Listing Page
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | PB-2 Legal Entity Name     |
      | Client-2 Legal Entity Name |
      | Document Status            |
      | Document Type              |

  @InitialSetupDF
  Scenario: Testcase to set columns for the DF listing Page
    Given User is on Document Framework Page
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name      |
      | PB Name          |
      | EB Name          |
      | Lifecycle status |

  @TC-01 @TC-02 @TC-03 @TC-10 @TC-11 @Negative
  Scenario Outline: Create DF with specified Allowed Currencies and verify Authorization Scope
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    And validate the document type value as DN
    Then User select acting as
      | Acting As |
      | EB        |
    And User select the LEIs
      |Prime Broker 1      |Enbridge Supplemental Pension Plan     |
      |EB 1                |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    When User selects Allowed Currencies as "<AllowedCurrencies>"
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User verifies "<FX_Availability>" instruments are "<FX_Status>" in the Authorization Scope
    And User verifies "<Bullion_Availability>" instruments are "<Bullion_Status>" in the Authorization Scope
    Then User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | Enbridge Supplemental Pension Plan    |
      | EB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User clicks on Delete icon DF
    And User waits for 1 seconds
    And Click on Yes button of popup
    Then User validates the message
      |Document is deleted|

    Examples:
      | AllowedCurrencies | FX_Availability | FX_Status | Bullion_Availability | Bullion_Status |
      | FX                | FX              | available | Bullion              | hidden         |
      | Bullion           | FX              | hidden    | Bullion              | available      |
      | Both              | Both            | available | Both                 | available      |

  @ApprovedDF
  Scenario: Creating Approved DF for EDN - with Bullion Only
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    And validate the document type value as DN
    Then User select acting as
      | Acting As |
      | EB        |
    And User select the LEIs
      |Prime Broker 1      |Enbridge Supplemental Pension Plan RCA Trust Fund     |
      |EB 1                |OSTTRA INDIA SERVICES PRIVATE LIMITED                 |
    When User selects Allowed Currencies as "Bullion"
    Then User clicks on Next button
    Then User clicks on enforcement rules tab for DF
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion | Bullion Vanilla Options |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |XAG|
      |XAU|
      |XPD|
      |XPT|
    And User will submit the changes
    And User clicks on Add Auth Line
    Then User clicks on Next button
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
    Then User will input Product family
      | Product Family |
      | Bullion        |
    Then User will input Delta
      | Delta |
      | No    |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User validates the message
      |Document is Approved|

  @TC-04 @TC-05 @TC-06
  Scenario Outline: Create Document (DN) with specified Allowed Currencies and verify Authorization Scope
    Given User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | EB        |
    And User select the LEIs
      |Prime Broker 1   |Enbridge Supplemental Pension Plan RCA Trust Fund       |
      |EB 1             |OSTTRA INDIA SERVICES PRIVATE LIMITED                   |
      |Client 1         |Koudenburg B.V.                                         |
    Then User selects Allowed Currencies as "<AllowedCurrencies>"
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User verifies "<FX_Availability>" instruments are "<FX_Status>" in the Authorization Scope
    And User verifies "<Bullion_Availability>" instruments are "<Bullion_Status>" in the Authorization Scope
    Then User clicks on Cancel button
    Then User Verifies the Documents Page
    And user will select Column Values on Document listing screen
      | Column Name                    | value                                                 |
      | PB-1 Legal Entity Name         | Enbridge Supplemental Pension Plan RCA Trust Fund     |
      | EB-1 Legal Entity Name         | OSTTRA INDIA SERVICES PRIVATE LIMITED                 |
      | Client-1 Legal Entity Name     | Koudenburg B.V.                                       |
      | Document Status                | Draft                                                 |
    And User click on delete button
    Then User validates the message
      |Document is deleted|

    Examples:
      | AllowedCurrencies | FX_Availability | FX_Status | Bullion_Availability | Bullion_Status |
      | Bullion           | FX              | hidden    | Bullion              | available      |


  @TC-07 @TC-08 @TC-09
  Scenario Outline: Create 4 Ways with specified Allowed Currencies and verify Authorization Scope
    Then User will click on Create new document
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          |254900SLCV8KI86BHL86               |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          |724500SKJBPCQP9YV662                |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      |254900SLCV8KI86BHL86                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      |724500SKJBPCQP9YV662                 |
      | client2OrgTypeKey | 3                                    |
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Prime Broker 2 | Xenophon B.V.                         |
      | Client 2       | Xenophon B.V.                         |
    When User selects Allowed Currencies as "<AllowedCurrencies>"
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User verifies "<FX_Availability>" instruments are "<FX_Status>" in the Authorization Scope
    And User verifies "<Bullion_Availability>" instruments are "<Bullion_Status>" in the Authorization Scope
    Then User clicks on Cancel button
    Then User Verifies the Documents Page
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | PB-2 Legal Entity Name     | Xenophon B.V.                         |
      | Client-2 Legal Entity Name | Xenophon B.V.                         |
    And User click on delete button
    Then User validates the message
      |Document is deleted|

    Examples:
      | AllowedCurrencies | FX_Availability | FX_Status | Bullion_Availability | Bullion_Status |
      | FX                | FX              | available | Bullion              | hidden         |
      | Bullion            | FX              | hidden    | Bullion              | available      |
      | Both              | FX              | available | Bullion              | available      |


  @TC-12
  Scenario: 4 Ways Copy - Verify Allowed Currencies Field is Locked
    Then user will select Column Values on Document listing screen
      | Column Name     | value    |
      | Document Status | Enforced |
      | Document Type   | 4 way    |
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    Then User verifies that the Allowed Currencies field is completely locked and read-only


  @TC-13
  Scenario: Document (DN) Copy - Verify Allowed Currencies Field remains Locked
    When user will select Column Values on Document listing screen
      | Column Name     | value    |
      | Document Status | Enforced |
      | Document Type   | DN       |
    Then User validates the Copy icon and clicks on it
    Then User verifies that the Allowed Currencies field is completely locked and read-only


  @TC-14
  Scenario: Document Framework (DF) Copy - Verify Allowed Currencies Field Locked
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      | Column Name      | value    |
      | Lifecycle status | Approved |
    And User validates the Copy icon and clicks on it
    Then User verifies that the Allowed Currencies field is completely locked and read-only

    @ResetData
    Scenario: Terminate the DF created
      Then User is on Document Framework Page
      And user will select Column Values on Document Framework screen
        | Column Name      | value                                                |
        | PB Name          | Enbridge Supplemental Pension Plan RCA Trust Fund    |
        | EB Name          | OSTTRA INDIA SERVICES PRIVATE LIMITED                |
        | Lifecycle status | Approved                                             |
      And User clicks on Terminate button
      And User clicks on Yes button
      Then User validates the Document approved message
        | Document is terminated |