@EDNAutoSaving @Regression
@US=DMGS-6373

Feature: Validating EDN Continually saving data when applying agreement amendments

  @TC_03 @TC_04
  Scenario: EDN document creation and autoSaving on Next & back Button - Approval Workflow & Auth Scope
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
    | Document Type | Acting As |
    | DN            | PB        |
    And User select the LEIs
    |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED      |
    |EB 1             |ACE URBAN RACE PRIVATE LIMITED             |
    |Client 1         |Koudenburg B.V.                            |
    Then User clicks on Next button
    Then User waits for 6 seconds
    Then User clicks on Document terms tab
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
      | Asset Class | Product Family  | Product          |
      | FX          | Vanilla Options | Vanilla Option   |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User will empty Tenor Value
    Then Verify and click back button
    Then User validates the message
      |Invalid value in tenor|
    Then User waits for 7 seconds
    Then User clicks on Next button
    Then User validates the message
      |Invalid value in tenor|
    Then User waits for 7 seconds
    Then User clicks on Limit Scope
    Then User validates the message
      |Invalid value in tenor|
    And User will edit Auth Tenor value
      | 1         |
    Then Verify and click back button
    Then User validates the message
      |Auth scope saved successfully|
    Then User clicks on Next button
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product          |
      | FX          | Vanilla Options | Vanilla Option   |
    Then User clicks on Next button
    Then User enable the Limit line and validate the same
    Then Verify and click back button
    Then User validates the message
      |Limit Value should be greater than 0. |
    Then User waits for 7 seconds
    Then User clicks on Next button
    Then User validates the message
      |Limit Value should be greater than 0. |
    Then User waits for 7 seconds
    Then User clicks on Preview & Submit tab
    Then User validates the message
      |Limit Value should be greater than 0. |

  Scenario: EDN document creation and autoSaving on Next & back Button - Limit Scope
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED        |
      |Client-1 Legal Entity Name    |Koudenburg B.V.                       |
      |Document Status               |Draft                                 |
    And User clicks on edit icon
    Then User clicks on Limit Scope
    Then User enables first limit line
    Then Verify and click back button
    Then User validates the message
      |Limit scope updated successfully |
    Then User clicks on Preview & Submit tab
    And User clicks on view as PDF button
    And User validates the Document terms data in view as PDF
      |Test for Document Terms|
    And User validates Auth Scope Data in view as PDF
      |Product                            |Currencies   | Tenor      |
      |FX Vanilla Options Vanilla Option  | COP         | 1 Months   |

  @ResetData
  Scenario: EDN data reset
    Given User is on Document Page
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | EB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED        |
      |Client-1 Legal Entity Name    |Koudenburg B.V.                       |
      |Document Status               |Draft                                 |
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |