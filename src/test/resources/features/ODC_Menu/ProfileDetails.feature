@Regression
@userprofile

@US=DMGS-4553 @US=DMGS-3974
Feature: Validation of Profile Details features/functionality

  @TC-7477
  Scenario: Verify User is not able to update their Profile Details
    Given User is on the all document screen
    When  User is on Profile details screen
    And User validates Edit icon is not visible

  @TC-6659 @TC-1571 @fixed
  Scenario: Validate the Profile Details screen
    Given User has logged in using credentials
    When User clicks on the profile button
    Then Verify if user is able to see Profile Details tab,Reset Password tab and Help and Support tab
    Then User clicks on the Profile Details Tab
    And Verify user is able to see all the information on the profile screen

  @TC-6661
  Scenario: Validate the Help&Support screen
    Given User is on the all document screen
    Then User clicks on the profile button
    Then User clicks on the Help and Support Tab
    And Validate the Help and Support Screen

  @DMGS-5887
  Scenario: Validate the Reset Password is removed from profile dropdown
    Given User is on the all document screen
    Then User clicks on the profile button only
    And Validate the Reset Password is removed