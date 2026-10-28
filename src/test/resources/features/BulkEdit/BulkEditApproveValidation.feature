@DMS-990
@dmsphase1
@document_type=4-way
@bulkedit

#@document_type=4-way
Feature: Workflow for Bulk Edit Approval Validation

  Scenario: User is able to bulk approve the documents
    Given User is on Document Page
    Then User clicks on Bulk Action button
    And User selects Approve from Bulk Action menu
    Then User will select doc type for approval
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for approval
      | Acting as      |
      |254900SLCV8KI86BHL86 (Client)|
    And User will select approval group for approval
      | Approval Group |
      |dummy01|
    Then User clicks on Next button
    Then User selects all documents that needs to be approved
    And click on Approve button





