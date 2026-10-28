@Regression @UserManagement
@TotalRecordCount
Feature: Validation of Total Record count on User Management Screen

  @TC-2443 @TC-2444
  Scenario: Validate text label updated to display 'Total record count:' & search
    Given User clicks on User management
    Then User validates the Total record count text
    And User will search for the User
      |User|
      |automation.user1@yopmail.com|
    And Verify the Total Record Count
      |1|

  @TC-2445 @TC-2447
  Scenario: Validate total number of records for filter
    Given User clicks on User management
    Then User can see Total record count
    And Validate total number of records returned remains same when user switch to next page
    Then User will search for the User
      |User|
      |automation.user1@yopmail.com|
    And User will search the LEI on the User management screen
    |Organisation|
    |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
    And Verify the Total Record Count
      |1|