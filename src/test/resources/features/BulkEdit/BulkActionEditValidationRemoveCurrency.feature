@smoke
@document_type=4-way
Feature: Workflow for Bulk Action Edit remove currency validation
  Background:

    Given User is on DocumentPage
    Then User clicks on BulkAction button
    And User selects edit button
    And User clicks on editButton for BulkEdit

  Scenario: Verify search functionality by Document ID
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE CURRENCY   |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Verify search functionality by Document ID
    |Document ID|
    |4W-458694-A|

  Scenario: Verify search functionality by Document Version ID
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE CURRENCY |
    Then User clicks on NextButton
    And Verify search functionality by Document Version ID
    |DocumentVersionID|
    |4W-458694-A-001|

  Scenario: verify remove currency in Bulk Action
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE CURRENCY   |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document to remove currency
      |Document ID|
      |4W-458694-A|
    And Verify next button and click
    Then Verify user able to addCurrency
      |currency list|
      |AED|
      |BHD|
      |BIF|
    Then Verify user able to removeCurrency
      |remove currency list|
      |BHD|
      |BIF|


  Scenario: Verify submit for approval button
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE CURRENCY   |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document to remove currency
      |Document ID|
      |4W-458694-A|
    And Verify next button and click
    Then Verify user able to addCurrency
      |currency list|
      |AED|
      |BHD|
      |BIF|
    Then Verify user able to removeCurrency
      |remove currency list|
      |BHD|
      |BIF|
#    And Verify submit for approval button

  Scenario: verify cancel button in Bulk Action

    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE CURRENCY   |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document to remove currency
      |Document ID|
      |4W-776690-A|
    And Verify next button and click
  And verify cancel button

  Scenario: verify back button in Bulk Action

    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE CURRENCY   |
    Then User clicks on NextButton
    And Select document to remove currency
      |Document ID|
      |4W-776690-A|
    And Verify next button and click
    And Verify and click back button
    And verify Confirmation popup
