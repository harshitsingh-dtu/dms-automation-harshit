@Regression @UserManagement
@UserManagementValidationsWorkflow @US=DMGS-4553 @US=DMGS-3920 @US=DMGS-4347
Feature: User Management validation workflows for listing screen

  @TC-1371 @TC-1375 @TC-1367 @1366 @TC-1365 @TC-7384 @Sanity @TC=7641 @TC-7643 @fixed
  Scenario: Verify User,search, values functionality
    Given User has logged in
    When User clicks on User management
    Then User reaches the User Management screen
    When user will search in find and add user and click on Add and Verify User already exists
      |user|
      |surbhi.singh2@osttra.com|
    When User will search for the User
      |User|
      |surbhi.singh2@osttra.com|
    Then User will see all the information
    |Name              |Email ID                |MobileNo     |Org                                   |
    |surbhi123 singh123|surbhi.singh2@osttra.com|1 6289292928 |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User can see Active in Active toggle button
    And user will be able to see update button


  Scenario: Verify User,search, values functionality for View Only User
    Given User has logged in
    When User clicks on User management
    Then User reaches the User Management screen
    When user will search in find and add user and click on Add and Verify User already exists
      |user|
      |hsbc.test1@testsso.osttra.com|
    When User will search for the User
      |User|
      |hsbc.test1@testsso.osttra.com|
    Then User will see all the information
      |Name              |Email ID                |MobileNo     |Org                                   |
      |Dummy Automation|hsbc.test1@testsso.osttra.com|0 |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And user will be able to see View button

#   Failed due to DMGS-6048
  @TC-1739
  Scenario: Edit User details screen - 4 Way
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |automation.user1@yopmail.com|
    Then User clicks on update button
    Then User can see role mapping,LEI,Org type actions
    And User is able to select Doc type from Doc type dropdown
      |Doc Type|
      |4 Way|
    And User is able to select LEI from LEIs dropdown
      |LEI|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      |Org type|
      |PB|
    And User is able to select Org type from Org type dropdown
      |Org type|
      |Client|
    And Validate EB does not exists
      |Org type|
      |EB|

#Failed due to DMGS-6048
  @TC-1740 @TC-1377
  Scenario: Edit User details screen - DN
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |automation.user1@yopmail.com|
    Then User clicks on update button
    Then User can see role mapping,LEI,Org type actions
    And User is able to select Doc type from Doc type dropdown
      |Doc Type|
      |DN|
    And User is able to select LEI from LEIs dropdown
      |LEI|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      |Org type|
      |PB|
    And User is able to select Org type from Org type dropdown
      |Org type|
      |Client|
    And User is able to select Org type from Org type dropdown
      |Org type|
      |EB|

    #Failed due to DMGS-6048
  @TC-1741 @TC-1377
  Scenario: Mapping Already exists error
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |automation.user1@yopmail.com|
    Then User clicks on update button
    Then User can see role mapping,LEI,Org type actions
    And User is able to select Doc type from Doc type dropdown
      |Doc Type|
      |DN|
    And User is able to select LEI from LEIs dropdown
      |LEI|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      |Org type|
      |PB|
    And User is able to add the LEI Org type combination
    And User gets the Mapping already exists warning

    #Failed due to DMGS-6048
  @TC=1742 @TC=2709 @TC-1616
  Scenario: Verify Removing LEIs
    Given User is on User Management Edit Details screen
      |users|
      |automation.user1@yopmail.com|
    Then User will search for LEI org type and remove it on the user management service edit screen
      | Org LEI                               |Doc Type| Org type |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |DN      | PB       |
    And user will submit the changes
    And User reaches the User Management screen
    Then User will search for the User
      |User|
      |automation.user1@yopmail.com|
    Then User Click on Update button and redirect to update screen

    #Failed due to DMGS-6048
  @TC=1742 @TC=2709 @TC-1616
  Scenario: Verify adding of LEI
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |automation.user1@yopmail.com|
    Then User clicks on update button
    Then User can see role mapping,LEI,Org type actions
    Then User will search for LEI org type and remove it on the user management service edit screen
      | Org LEI                               |Doc Type| Org type |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |DN      | PB       |
    And User is able to select Doc type from Doc type dropdown
      |Doc Type|
      |DN|
    And User is able to select LEI from LEIs dropdown
      |LEI|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      |Org type|
      |PB|
    And User is able to add the LEI Org type combination
    And user will submit the changes
    Then User validates the user update notification
    And User reaches the User Management screen

  @TC-1365 @TC-1369 @TC-7736 @TC-7644
  Scenario: Verify features on the page and toggle button functionality
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |surbhi.singh2@osttra.com|
    Then User should be able to change the status using toggle button
    And User validates the message
      |User Status updated to in-active |
    Then User waits for 2 seconds
    Then User should be able to change the status using toggle button
    Then User validates the toast message
      |User Status updated to active |
    Then User will set the organization,status,roles filters
      | organisation                           | status | roles         |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED   | Active | OSTTRA_PSUSER |
    Then User validates no record found should Not be displayed

  @TC-7476
  Scenario: Verify that Create new User button has been removed from Users Management screen.
    Given User is on the User onboarding screen
    Then User validates Create new User button has been removed

  @TC-7382 @TC-7647
  Scenario: Validate that on searching invalid email no record found error should appear
    Given User is on the User onboarding screen
    When User will search for the User Not Found
      |User|
      |dummy@spglobal.com|
    And User validates text is visible
       |No Record Found |

  @TC-7645
  Scenario: Validate that correct details appear for newly added user at User Access page
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |surbhi.singh2@osttra.com|
    Then User clicks on update button
    Then User validates all the information on User Access Page
      |FirstName | LastName    |Email ID                |MobileNo     |Org                                   |
      |Surbhi    | Singh       |surbhi.singh2@osttra.com|+1 6289292928 |OSTTRA INDIA SERVICES PRIVATE LIMITED|