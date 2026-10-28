@DMS-990
@smoke @document_type=4-way
@bulkedit

Feature: Workflow for Bulk Edit Terminate Validation

  Scenario: User is able to bulk terminate the documents
    Given User is on Document Page
    Then User clicks on Bulk Action button
    And User selects Terminate from Bulk Action menu
    Then User will select doc type for terminate
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for terminate
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    Then User clicks on Next button
    Then User selects all documents that needs to be terminated
    And User clicks on Terminate button
    Then User will be redirected to Lite users alert page
    And click on submit button