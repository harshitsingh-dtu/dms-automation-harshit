@Currency @CurrencySelectionClear @Regression
@US=DMGS-9631 @US=DMGS-9636 @US=DMGS-9660
Feature: UI/UX Clarity and Single-Action Clear for Currencies and Currency Pairs Selection (DMGS-9631 & DMGS-9636)

  Scenario:User creates a draft document for below testcase validation.
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 6SHGI4ZSSLCXXQSBB395                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    When User creates a document through API
      |Payload path|
      |src/test/java/resources/DocCreation_MR1.json|

  @DMGS-9631 @DMGS-9636 @DocumentFramework @TC-9631-01 @TC-9636-01 @TC-9631-02 @TC-9636-02
  Scenario: Verify currency selection clarity and single-action clear when adding authorization lines for Document Framework (DF)
    Given User is on Document Framework Page
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name          |
      | PB Name              |
      | EB Name              |
      | Lifecycle status     |
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                           |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED           |
      |EB Name             |ABC ARBITRAGE                                   |
      |Lifecycle status    |Draft                                           |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                 |
      | FX          | Cash           | Future                  |
    And Click on + Add currencies
    When User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | ISK           |
    Then Verify selected currencies are clearly and obviously highlighted as "Selected" with visual badges on the UI
    And Verify user is able to easily identify all selected currencies after scrolling
    When User clicks on "Remove All" button to clear selected currencies in a single action
    Then Verify that the currency selection is completely cleared and all checkmarks are deselected
    And User will click on All currency permitted checkbox
    Then User validates the text "All Deliverables Currencies Permitted" is displayed
    And User will click on All currency permitted checkbox
    Then User validates the text "No Deliverables selected" is displayed
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And User will submit the changes
    And User clicks on Add Auth Line
    Then User clicks on Save As Draft button
    And User validates the message
      | Auth scope saved successfully |
    And User waits for 3 seconds
    Then Clicks on ExpandAll button
    Then User deletes all the auth Lines
    Then User clicks on Save As Draft button
    And User validates the message
      | Auth scope saved successfully |

  @DMGS-9631 @DMGS-9636 @DesignationNotice @TC-9631-03 @TC-9636-03
  Scenario: Verify currency selection clarity and single-action clear when opting-in for authorization lines on Designation Notice (DN)
    Given User will go to Document screen
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | EB-1 Legal Entity Name     |
      | Document Status            |
    And user will select Column Values on Document listing screen
      |Column Name                    |value                                 |
      |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name         |CITIGROUP INC.                        |
      |Client-1 Legal Entity Name     |CITIGROUP INC.                        |
      |Document Status                |Draft                                 |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                      |
      | FX          | Bullion        | Bullion Vanilla Options      |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on edit icon in Auth line
    Then Verify that inherited currencies from the parent DF are clearly and obviously highlighted as "Selected"
    And Verify user is able to easily identify all opted-in currencies on the UI
    When User clicks on "Remove All" button to clear opted-in currencies in a single action
    Then Verify that all selected and inherited currencies are cleared and deselected instantly

  @DMGS-9631 @DMGS-9636 @FourWays @TC-9631-04 @TC-9636-04
  Scenario: Verify currency selection clarity and single-action clear when creating/amending authorization lines for 4 Ways Agreement
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86               |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 6SHGI4ZSSLCXXQSBB395                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 254900SLCV8KI86BHL86                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 6SHGI4ZSSLCXXQSBB395                |
      | client2OrgTypeKey | 3                                    |
    Given User will go to Document screen
    Then User creates a document through API
      |Payload path|
      |src/test/java/resources/DocCreation3_4way.json|
    Then User adds immediate enforcement rules via API for 4way Document or Document Framework
    Then User adds General Terms via API for 4way Document
    Then User adds LimitScope via API for Document or Document Framework
    Given User will go to Document screen
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | PB-2 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Client-2 Legal Entity Name |
      | Document Status            |
    And user will select Column Values on Document listing screen
      |Column Name                    |value                                 |
      |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name         |CITIGROUP INC.                        |
      |Client-1 Legal Entity Name     |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-2 Legal Entity Name     |CITIGROUP INC.                        |
      |Document Status                |Draft                                 |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                      |
      | FX          | Exotic Options | Single Barrier Digital       |
    And Click on + Add currencies
    When User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | ISK           |
    Then Verify selected or amended currencies are clearly and obviously distinguished with highlighted visual badges
    When User clicks on "Remove All" button to clear selected currencies in a single action
    Then Verify that all currency selections are completely cleared and deselected in a single action
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And User will submit the changes
    * User will input Auth Tenor value
      | Auth Value |
      | 10         |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Business Days      |
    And User clicks on Add Auth Line
    Then User clicks on Save As Draft button
    And User validates the message
      | Auth scope saved successfully |
    And User waits for 3 seconds
    Then Clicks on ExpandAll button
    Then User deletes all the auth Lines
    Then User clicks on Save As Draft button
    And User validates the message
      | Auth scope saved successfully |

  @DMGS-9631 @DMGS-9636 @CurrencyGroup @TC-9631-05 @TC-9636-05
  Scenario: Verify currency selection clarity and single-action clear when creating or amending Currency Groups
    Given User is on the Currency screen
    When User go to create new group screen
    And User will search for the currency and select them
      | currency list |
      | BBD           |
      | CLF           |
      | KZT           |
    Then Verify selected or amended currencies are clearly and obviously distinguished with highlighted visual badges
    When User clicks on "Remove All" button to clear selected currencies in a single action
    Then Verify that all currency selections are completely cleared and deselected in a single action
    Then User clicks on Currency group pair radio button
    And User clears the currency search bar
    And User refreshes the browser
    Then User waits for 5 seconds
    And User will click on 'Select All' Checkbox for currency selection
    Then Verify selected or amended currencies are clearly and obviously distinguished with highlighted visual badges
    When User clicks on "Remove All" button to clear selected currencies in a single action
    Then Verify that all currency selections are completely cleared and deselected in a single action

  @DMGS-9660
  Scenario: Verify currency selection clarity and single-action clear when creating or amending Currency Groups for bullion
    Given User is on the Currency screen
    When User go to create new group screen
    And User selects the Bullion checkbox
    And User will click on All currency permitted checkbox
    Then User validates the text "All Bullion Currencies Permitted" is displayed
    Then User clicks on Currency group pair radio button
    And User will click on 'Select All' Checkbox for currency selection
    Then Verify selected or amended currencies are clearly and obviously distinguished with highlighted visual badges
    When User clicks on "Remove All" button to clear selected currencies in a single action
    Then Verify that all currency selections are completely cleared and deselected in a single action