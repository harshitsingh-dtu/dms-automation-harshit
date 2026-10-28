@ApprovalMatrixWorkflow @Regression
@ApprovalMatrix

Feature: Validation workflows for Approval matrix listing page

  @TC_ID=1398 @TC-6694
  Scenario: verify columns, search and pagination on approval matrix page
    Given user is on approval matrix listing screen
    Then user will be able to see create approval matrix button
    And user will be able to see search bar
    And user will be able to see organization name, LEIs name, org type, doc type, created on, action
    And user will be able to see update button
    Then User can see showing page
    And User can see Records per page
    And User can see Total record count
    And when the user is on the first page then prev button should be disabled
    And when the user is on the last page then next button should be disabled
    And user searches for a approval matrix and validates the results
      |approval matrix                          |LEI name  |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN          |

  @TC-1662
  Scenario: Verify Filtered item list for Doc type dropdown
    Given User is on the create approval matrix screen
    And User validates the doc type dropdown contains "4 Way"

  @TC-1898
  Scenario: Validate Org type filter on Approval Matrix Listing screen
    Given user is on approval matrix listing screen
    Then User will select and click the Org type on Approval Listing screen
      |Org Type|
      |PB  |
    Then User waits for 3 seconds
    And User validates all the Approval Matrix for the Org type searched

  @TC-1664
  Scenario: Validate org type dropdown data when doc type- 4 way
    Given user is on approval matrix listing screen
    Then user searches for a approval matrix and validates the results
      |approval matrix                          |LEI name                               |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED  |PB             |4 Way          |

  @TC-1665
  Scenario: Validate org type dropdown data when doc type- DN
    Given User is on the create approval matrix screen
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      | organisation name                       | LEI filter   | org type filter | doc type filter |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED        |PB         |DN         |
    Then User validates the select org type dropdown values for DN

  @TC-1664
  Scenario: Validate org type dropdown data when doc type- 4Way
    Given User is on the create approval matrix screen
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      | organisation name                       | LEI filter                              | org type filter | doc type filter |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED    |PB         |4 Way   |
    Then User validates the select org type dropdown values for 4 way

  @EnhancedCoverage
  Scenario: Validate org type dropdown data for DN & 4way on Approval matrix listing screen
    Given user is on approval matrix listing screen
    Then User will select the DocType on Approval Group Listing screen
      |Doc Type|
      |4 Way |
     Then User validates the select org type dropdown values for 4 way
    Then User will select the DocType on Approval Group Listing screen
      |Doc Type|
      |DN      |
    Then User validates the select org type dropdown values for DN