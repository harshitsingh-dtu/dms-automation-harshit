@ApprovalMatrixCreate @Regression
@ApprovalMatrix

Feature: Workflows for create screen of Approval matrix

  @TC-1660
  Scenario: validation of create new Approval Matrix screen
    Given User is on the create approval matrix screen
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      |organisation name|LEI filter |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED            |OSTTRA INDIA SERVICES PRIVATE LIMITED      |PB             |4 Way          |
    And User can see the cancel button on the create approval matrix screen
    And User can see the next button on the create approval matrix screen

  Scenario: Validate approval matrix already exists message
    Given User is on the create approval matrix screen
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      |organisation name|LEI filter |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED            |OSTTRA INDIA SERVICES PRIVATE LIMITED      |PB             |4 Way          |
    And User can see and click the next button on the create approval matrix screen
    Then User validates the message
      | Approval Matrix already exists |

