@DMS-990
@smoke

@document_type=4-way
@bulkedit

Feature: Workflow for Bulk Edit Reject Validation

  Scenario: User is able to bulk approve the documents
    Given User is on Document Page
    Then User clicks on Bulk Action button
    And User selects Reject from Bulk Action menu
    Then User will select doc type for reject
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for reject
      | Acting as      |
      |254900SLCV8KI86BHL86 (Client)|
    And User will select approval group for reject
      | Approval Group |
      |dummy01|
    Then User clicks on Next button
    Then User selects all documents that needs to be rejected
    And click on Reject button