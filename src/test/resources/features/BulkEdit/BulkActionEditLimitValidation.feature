@smoke
@dmsphase1
@document_type=4-way
Feature: Workflow for Bulk Action Edit Limit validation
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
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Select document
      | Document ID |
      |4W-594606-A|
    And Verify next button and click

  Scenario: Verify search functionality by Document Version ID
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Verify search functionality by Document Version ID
      |DocumentVersionID|
      |4W-594606-A-001|


  Scenario: Verify next button
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
      |Document ID|
      |4W-594606-A|
    And Verify next button and click


  Scenario: verify cancel button in Bulk Action

    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
      |Document ID|
      |4W-594606-A|
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
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Select document
      |Document ID|
      |4W-594606-A|
    And Verify next button and click
    And Verify and click back button
    And verify Confirmation popup


  Scenario: Verify Edit Limit Scope page data doc id and doc version id
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
      |Document ID|
      |4W-594606-A|
    And Verify next button and click
    And Verify Document id and Document version id
      |DocumentID|DocumentVersionID|
      |4W-594606-A|4W-594606-A-001|

  Scenario: Verify user is able to edit Limit value
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |6SHGI4ZSSLCXXQSBB395 (PB)|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
      |Document ID|
      |4W-594606-A|
    And Verify next button and click
    And Verify user able to change edit Limit value
      |New Value|
      | 123445   |

  Scenario: Verify submit for approval
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      | 254900SLCV8KI86BHL86 (PB) |
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
      |Document ID|
      |4W-594606-A|
    And Verify next button and click
    And Verify submit for approval
