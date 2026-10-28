@PlatformServices
@Regression @US=DMGS-3566 @US=DMGS-3557

Feature: Validate Platform Services Functionality is no longer visible for ODC

  @TC-7489
  Scenario: Validate that ‘OSTTRA Platform Services’ user role should be removed from user profile
    Given User is on the all document screen
    When User is on Profile details screen
    And User validates text is NOT visible
      |OSTTRA Platform Services|

  @TC-7488 @TC-7495
  Scenario: Validate that Platform Services should be removed from ODC App
    Given User is on Document Page
    Then User clicks on Menu bar on Dashboard
    Then User validates Platform Services is not visible
#    And Validate following field is not displayed
#      |Field    |
#      |Platform Services  |

  @TC-7487
  Scenario: Verify that Osttra Platform services checkbox has been removed from role mapping
    Given User is on the User onboarding screen
    When User will search for the User
      |User|
      |surbhi.singh2@osttra.com|
    Then User clicks on update button
    Then User searches for the role in User Access Screen without selecting
      |Roles                   |
      |Osttra Platform services|
    Then Validate No options should be displayed in Role dropdown
