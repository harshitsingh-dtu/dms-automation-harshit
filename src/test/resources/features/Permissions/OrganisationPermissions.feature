@smoke
@document_type=4-way
Feature: Validate the Organisation permissions
  Background: User will reach Admin User's User management screen
    Given User is on the Dashboard
    When User clicks on User management
    And User reaches the User Management screen
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen

    Scenario: verify if user is granted with permission VIEW_ALL,then he is able to view all organisations on Organisation management listing screen
      When User will select VIEW_ALL roles for Org
      |roles|
      |OSTTRA_OPSUSER|
      |OSTTRA_PSUSER|
      And User will select Doctype LEI Orgtype mapping in case not present
      And User will Submit the update user service
      And User will logout of the application
      When user types in the email id
        |email id|
        |app_svc_user@osttra.com|
      And user types in the password and submit
        |password|
        |dummy_pass|
      When User navigates to the organisation screen
      Then User will search for other organisations and corresponding result is visible
      |organisations|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |citigroup|
      |anand bhawan|