@smoke
@document_type=4-way
Feature: Validate the Approval Matrix permissions
  Background: User will reach Admin User's User management screen
    Given User is on the Dashboard
    When User clicks on User management
    And User reaches the User Management screen

  Scenario: verify CREATE_OWN permission. If CREATE_OWN permission is granted,
  then User will only be able to create Approval matrix of it's own lei
    And User will search for the User
      |User|
      |Abheek Babel|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |APPROVAL_MANAGER|
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |abheek.babel@ihsmarkit.com|
    And user types in the password and submit
      |password|
      |Dummy@123456|
    When User is on the create approval matrix screen
    And User can see and able to fill organization filter LEI filter org type filter doc type filter in all the fields
      | organization filter | LEI filter   | org type filter | doc type filter |
      |CITIGROUP INC.     |CITIGROUP INC.     |PB             |4 Way          |
    Then User organisation name is same as selected organisation name

  Scenario: verify CREATE_ALL permission. If CREATE_ALL permission is granted,
  then User will be able to create Approval matrix for all LEIs
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |OSTTRA_OPSUSER|
      |OSTTRA_PSUSER |
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |app_svc_user@osttra.com|
    And user types in the password and submit
      |password|
      |dummy_pass|
    When User is on the create approval matrix screen
    And User fills in the organisation name and checks if able to enter all orgs
      |citigroup|
      |anand bhawan|

  Scenario: verify EDIT_OWN permission. If EDIT_OWN permission is granted,
  then User will only be able to Edit Approval matrix of it's own lei
    And User will search for the User
      |User|
      |Abheek Babel|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |APPROVAL_MANAGER|
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |abheek.babel@ihsmarkit.com|
    And user types in the password and submit
      |password|
      |Dummy@123456|
    When user is on approval matrix listing screen
    Then user seaches for a approval matrix
      | approval matrix |
      |citigroup|
    And user clicks on the update button

  Scenario: verify EDIT_ALL permission. If EDIT_ALL permission is granted,
  then User will be able to Edit Approval matrix for all LEIs
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |OSTTRA_OPSUSER|
      |OSTTRA_PSUSER |
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |app_svc_user@osttra.com|
    And user types in the password and submit
      |password|
      |dummy_pass|
    When user is on approval matrix listing screen
    Then user seaches for a approval matrix
      | approval matrix |
      |citigroup|
    And user clicks on the update button

  Scenario: verify VIEW_OWN permission. If VIEW_OWN permission is granted,
  then User will only be able to view Approval matrix of it's own lei
    And User will search for the User
      |User|
      |Abheek Babel|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |APPROVAL_MANAGER|
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |abheek.babel@ihsmarkit.com|
    And user types in the password and submit
      |password|
      |Dummy@123456|
    When user is on approval matrix listing screen
    And User searches for group name in the search bar and checks Organisation is same as User
      |citigroup|

  Scenario: verify VIEW_ALL permission. If VIEW_ALL permission is granted,
  then User will be able to view Approval matrix of all lei
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |OSTTRA_OPSUSER|
      |OSTTRA_PSUSER |
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |app_svc_user@osttra.com|
    And user types in the password and submit
      |password|
      |dummy_pass|
    When user is on approval matrix listing screen
