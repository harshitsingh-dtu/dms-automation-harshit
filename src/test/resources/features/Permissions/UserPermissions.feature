@smoke
 @document_type=4-way
Feature: Validate the User permissions
  Background: User will reach Admin User's User management screen
    Given User is on the Dashboard
    When User clicks on User management
    And User reaches the User Management screen

  Scenario: verify if user is granted with permission User VIEW_OWN,then he is able to view all users of my org
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
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
    When User is on the User onboarding screen
    And User will search for the User
      |User|
      |Shiva Sharma|
      |Surbhi Gupta|

  Scenario: verify if user is granted with permission User VIEW_ALL,,then he is able to view users of all org
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
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
    When User is on the User onboarding screen
    And User will search for the User
      |User|
      |Aastha Agarwal|
      |Surbhi Gupta|

    Scenario: verify if user is granted with permission EDIT_OWN,then he is able to edit all users of my org
  Scenario:verify if user is granted with permission EDIT_ALL(excluding ADMIN role),then he is able to edit users of all org (Except OSTTRA)
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
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
    When User is on the User onboarding screen
    And User is able to search for User and update button is visible corresponding to the User
      |User|
      |Shivani Jadon|
      |Aastha Agarwal|
    And User is able to search for User and view button is visible corresponding to the User
      |User|
      |Vijay Sharma|
      |Shiva Sharma|

  Scenario:verify if user is granted with permission EDIT_ALL(including ADMIN role),then he is able to edit users of all org (Except it's own user)
    And User will search for the User
      |User|
      |app user|
    And User will reach on the Edit Details screen
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
    When User is on the User onboarding screen
    And User is able to search for User and update button is visible corresponding to the User
      |User|
      |Vijay Sharma|
      |Shiva Sharma|
    And User is able to search for User and view button is visible corresponding to the User
      |User|
      |jack jeffreys|

