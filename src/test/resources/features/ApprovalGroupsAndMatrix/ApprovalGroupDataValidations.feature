@ApprovalGroupDataValidations @Regression
@ApprovalGroup

Feature: Approval group data validations through creation journey

  @TC=1719  @TC=1720
  Scenario: Create an Approval group for Doc type 4 Way Validate the displayed data of the LEIs dropdown
    Given User will reach the Organization section
    And User searches for the LEI in the search bar
      | update screen search lei              |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And user clicks on the update button
    And Set Doc type filter on Organisation update screen
      | doc type |
      | 4 Way    |
    Then User validates that lei is online for org type PB
      | lei name                              |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User validates the Org type is as same as used to create the approval group with the same lei

  @TC=1721
  Scenario: Create new Approval group for 4 Way, which Unable to add user if mapping to LEI Org type does not exist
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name                          | organisation name | doc type | LEI's         | org type |
      | Automation_Approval_Group_Test_0101 | CITIGROUP INC.     | 4 Way    | CITIGROUP INC. | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and validate no record found
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    Then User clicks on Cancel button
    Then User validates for the Approval group name
      | group name                          |
      | Automation_Approval_Group_Test_0101 |
    And User selects the status
      |Status  |
      |Active  |
    Then User searches for Approval group name in the search bar and validates
      |group name                          |
      |Automation_Approval_Group_Test_0101 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |Approval group deleted successfully|

  @TC=1724
  Scenario: verify no of user in Approval group when user LEI Org type mapping is removed
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name                          | organisation name | doc type | LEI's        | org type |
      | Automation_Approval_Group_Test_0202 | BARCLAYS PLC      | 4 Way    | BARCLAYS PLC | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test3@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group
    Then User validates number of users is 1 for approval group
      | group name                          |
      | Automation_Approval_Group_Test_0202 |
    Then User clicks on User management
    Then User will search for the User
      | User                          |
      | hsbc.test3@testsso.osttra.com |
    Then user clicks on the update button
    Then User removes lei mapping for doc type and org type
      | doc type | Org type |
      | 4 Way    | PB       |
    Then User clicks on Yes button
    Then User will submit the changes
    Then User waits for 5 seconds
    Then User navigates to Approval group screen
    And User selects the status
      |Status|
      |Active|
    Then User searches for Approval group name in the search bar and validates
      |group name                          |
      |Automation_Approval_Group_Test_0202 |
    And User validates number of users is 0 for approval group
      | group name                          |
      | Automation_Approval_Group_Test_0202 |
    Then User clicks on Delete button for approval group
    Then Click on Yes button of popup
    Then User validates the message
      |Approval group deleted successfully|

  @TC=1724_1
  Scenario: Resetting the user lei mapping
    Given User is on the User onboarding screen
    Then User will search for the User
      | User                          |
      | hsbc.test3@testsso.osttra.com |
    Then user clicks on the update button
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | 4 Way    |
    And User is able to select LEI from LEIs dropdown
      | LEI          |
      | BARCLAYS PLC |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
    And user will submit the changes
    Then User validates the message
      |User updated successfully|