@Regression @document_type=4-way
@US=DMGS-7341

Feature: Validatation for Bulk Action Drop-down

  @TC=04
  Scenario: Validate where multiple legal entities could apply then the PB or EB values should be not be defaulted for the initiator dropdown
    Given User is on Document Page
    Then User clicks on Bulk Action button
    And User selects Approve from Bulk Action menu
    Then User will select doc type for approval
      | Doc Type |
      | 4 way   |
    Then User validates No Value should be coming for Acting As field in Bulk Action
    Then User clicks on Cancel button
    Then User clicks on Bulk Action button
    And User selects Approve from Bulk Action menu
    Then User will select doc type for approval
      | Doc Type |
      | DN       |
    Then User validates No Value should be coming for Acting As field in Bulk Action