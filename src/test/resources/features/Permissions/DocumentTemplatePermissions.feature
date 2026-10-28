@smoke
@document_type=4-way
Feature: Validate the Document template permissions
  Background: User will reach Admin User's User management screen
    Given User is on the Dashboard
    When User clicks on User management
    And User reaches the User Management screen

  Scenario: verify CREATE_OWN permission. If CREATE_OWN permission is granted,
  then User will only be able to create Document Template of it's own lei
    And User will search for the User
      |User|
      |Abheek Babel|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |4W_ORG_USER|
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |abheek.babel@ihsmarkit.com|
    And user types in the password and submit
      |password|
      |Dummy@123456|
    And User will go to Document template screen
    And User will be redirected to create screen after clicking create New template button
    And User input details to create a new Document Template
      | Template Name    | Organisation | Doc Type |
      | TestDemoTemp_jan21th | citigroup| 4 way    |
    Then User organisation name is same as selected organisation name

  Scenario: verify CREATE_ALL permission. If CREATE_ALL permission is granted,
  then User will be able to create Document templates for all LEIs
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
    And User will go to Document template screen
    And User will be redirected to create screen after clicking create New template button
    And User input details to create a new Document Template
      | Template Name    | Organisation | Doc Type |
      | TestDemoTemp_jan21th | All| 4 way    |

  Scenario: verify EDIT_OWN permission. If EDIT_OWN permission is granted,
  then User will only be able to Edit Document Template of it's own lei
    And User will search for the User
      |User|
      |Abheek Babel|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |4W_ORG_USER|
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |abheek.babel@ihsmarkit.com|
    And user types in the password and submit
      |password|
      |Dummy@123456|
    And User will go to Document template screen
    Then User will search for the document template
      | Document Name    |
      |TestDemoTemp0805 |
    And User will reach the document template update screen

  Scenario: verify EDIT_ALL permission. If EDIT_ALL permission is granted,
  then User will be able to Edit Document Template for all LEIs
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
    And User will go to Document template screen
    Then User will search for the document template
      | Document Name    |
      |TestDemoTemp0805 |
    And User will reach the document template update screen

  Scenario: verify VIEW_OWN permission. If VIEW_OWN permission is granted,
  then User will only be able to view Document Template of it's own lei
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
    And User will go to Document template screen

  Scenario: verify VIEW_ALL permission. If VIEW_ALL permission is granted,
  then User will be able to view Document template of all lei
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
    And User will go to Document template screen