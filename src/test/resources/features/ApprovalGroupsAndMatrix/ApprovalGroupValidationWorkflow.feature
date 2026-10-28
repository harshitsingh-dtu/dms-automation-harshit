@ApprovalGroupValidationWorkflow @Regression
@ApprovalGroup
Feature: Workflow for Approval Groups Validation

  @TC-1387
  Scenario: Verify that search box should show respective group when enter value
    Given User is on Approval group screen
    Then User waits for 2 seconds
    When User validates the search field
    When User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_OT_ApprovalGroup_DN_Osttra|

  @TC-1718
  Scenario:Verify search functionality for 4way doc type on Approval Group Listing screen
    Given User is on Approval group screen
    Then User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_OT_ApprovalGroup_4way_Osttra|

  @TC-1894
  Scenario:Validate LEIs filter on Approval Group Listing screen
    Given User is on Approval group screen
    Then User validates the list of LEIs
    Then User will search for the LEI on Approval Group Listing screen
    |LEI name|
    |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
    And User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_OT_ApprovalGroup_DN_Osttra|

  @TC-1895
  Scenario:Validate Org type filter on Approval Group Listing screen
    Given User is on Approval group screen
    Then User will select and click the Org type on Approval Listing screen
      |Org Type|
      |PB  |
    And User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_OT_ApprovalGroup_DN_Osttra|

  @TC-1896
  Scenario:Validate Doc type filter on Approval Group Listing screen
    Given User is on Approval group screen
    And User validates the doc type dropdown contains "4 Way"
    Then User will select the DocType on Approval Group Listing screen
      |Doc Type|
      |4 Way |
    And User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_OT_ApprovalGroup_4way_Osttra|

  @TC-1388
  Scenario: Verify pagination
    Given User is on Approval group screen
    Then User can see showing page
    And User can see Records per page
    And User can see Total record count
    And when the user is on the first page then prev button should be disabled
    And when the user is on the last page then next button should be disabled

  @EnhancedCoverage
  Scenario: Validate org type dropdown data for DN & 4way on Approval Group listing screen
    Given User is on Approval group screen
    Then User will select the DocType on Approval Group Listing screen
      |Doc Type|
      |4 Way |
    Then User validates the select org type dropdown values for 4 way
    Then User will select the DocType on Approval Group Listing screen
      |Doc Type|
      |DN      |
    Then User validates the select org type dropdown values for DN

  @EnhancedCoverage
  Scenario: Validate org type dropdown data for DN & 4way on Approval Group creation screen
    Given User is on create new approval group screen
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      | organisation name                       | LEI filter                              | org type filter | doc type filter |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED    |PB         |4 Way   |
    Then User validates the select org type dropdown values for 4 way
    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
      | organisation name                       | LEI filter                              | org type filter | doc type filter |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED    |OSTTRA INDIA SERVICES PRIVATE LIMITED    |PB               |DN   |
    Then User validates the select org type dropdown values for DN