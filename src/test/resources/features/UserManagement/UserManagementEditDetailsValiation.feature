@Regression @usermanagmenteditdetails

Feature: Validation of User Management Edit Details Screen Elements

  Scenario: User Information should be visible on the Edit screen
    Given User is on User Management Edit Details screen
      |users                    |
      |surbhi.singh2@osttra.com|
    Then User will see all the information
      | Field              | Value                      |
      | Dummy Automation | hsbc.test1@testsso.osttra.com|

  Scenario: Verify Edit button of User management service
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |surbhi.singh2@osttra.com |
    And User will reach on the Edit Details screen
    Then User can see role mapping,LEI,Org type actions

    # failed due to bug DMGS-8842
    @TC-6701 @ignore
  Scenario: Verify View button of User management service
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |hsbc.test1@testsso.osttra.com |
    And User will reach on the View Details screen
    Then User can see Selected Roles

  Scenario: verify active button on user service Edit screen
    Given User is on User Management Edit Details screen
      |users|
      |automation.user1@yopmail.com |
    Then User can see Active in Active toggle button

  Scenario: User should be able to see all the LEI's
    Given User is on User Management Edit Details screen
      |users|
      |automation.user1@yopmail.com |
    When User will search lei on the screen Org LEI
      |Org LEI|
      |CITIGROUP INC.|
    And User will search org type on the screen Org type
      |Org type|
      |Client|
    Then User should get a list of LEI's

  Scenario: User will be able to Edit Details of a LEI
    Given User is on the User onboarding screen
    When User will search for the User
      | User        |
      |automation.user1@yopmail.com|
    And User will reach on the Edit Details screen
    Then User will perform role mapping,Doc type,LEI,Org type actions
      |role mapping|Doc Type|LEI|Org type|
      |4W Org View Only|4 Way|OSTTRA INDIA SERVICES PRIVATE LIMITED |PB|
    And user will submit the changes

  Scenario: Verify role mapping dropdown on user management service edit screen
    Given User is on the User onboarding screen
    And User will search for the User
      | User       |
      |automation.user1@yopmail.com|
    Then User checks if status is active, if not makes it active
    Then User refreshes the browser
    And User will search for the User
      | User       |
      |automation.user1@yopmail.com|
    And User will reach on the Edit Details screen
    Then User is able to see role mapping dropdown
    And User is able to assign a role
      |role mapping|
      |4W Org View Only|
    And User is able to remove a role
      |role mapping|
      |4W Org View Only|
    And user will submit the changes

  Scenario: Verify remove role mapping dropdown on user management service edit screen
    Given User is on the User onboarding screen
    And User will search for the User
      | User       |
      |automation.user1@yopmail.com|
    And User will reach on the Edit Details screen
    Then User is able to see role mapping dropdown
    And User is able to assign a role
      |role mapping|
      |4W Org View Only|
    And user will submit the changes
    Then User will set the organization,status,roles filters
      | organisation        | status | roles       |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED  | Active | 4W Org View Only |
    And User will search for the User
      | User       |
      |automation.user1@yopmail.com|
    And User will reach on the Edit Details screen
    Then User is able to see role mapping dropdown
    And User is able to remove a role
      |role mapping|
      |4W Org View Only|
    And user will submit the changes

    #Failed Due to DMGS-6048
  Scenario: verify LEI/Org type mapping on user management service Edit screen
    Given User is on the User onboarding screen
    And User will search for the User
      |User|
      |automation.user1@yopmail.com|
    And User will reach on the Edit Details screen
    Then User checks LEIs,Doc Type and Orgtype dropdowns
    And User is able to select Doc type from Doc type dropdown
      |Doc Type|
      |4 Way|
    And User is able to select LEI from LEIs dropdown
      |LEI|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      |Org type|
      |PB|
    And User is able to add the LEI Org type combination
    And user will submit the changes

  Scenario: Verify search functionality and validate the details
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |hsbc.test1@testsso.osttra.com |
    Then corresponding information of user will be visible on the screen