@smoke
 @document_type=4-way
Feature: Validate the Currency permissions
  Background: User will reach Admin User's User management screen
    Given User is on the Dashboard
    When User clicks on User management
    And User reaches the User Management screen

  Scenario: verify CREATE_OWN permission. If CREATE_OWN permission is granted,
  then User will only be able to create currency of it's own Organisation
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
    And User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name    |
      |test_auto_jan21th_qa|
    And User types the organization name
      |organisation name|
      |citigroup|
    Then User organisation name is same as selected organisation name

  Scenario: verify CREATE_ALL permission. If CREATE_ALL permission is granted,
  then User will be able to create currency for all LEIs
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
    Given User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name    |
      |test_auto_jan21th___qa|
    And User types the organization name
      |organisation name|
      |All Organisations|

  Scenario: verify EDIT_OWN permission. If EDIT_OWN permission is granted,
  then User will only be able to Edit currency of it's own lei
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
    When User is on the Currency screen
    When User searches for the currency group
      |search currency group|
      |123_tst|
    Then User clicks on the update button for Currency

  Scenario: verify EDIT_ALL permission. If EDIT_ALL permission is granted,
  then User will be able to Edit currency for all LEIs
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
    When User is on the Currency screen
    When User searches for the currency group
      |search currency group|
      |123_tst|
    Then User clicks on the update button for Currency

  Scenario: verify VIEW_OWN permission. If VIEW_OWN permission is granted,
  then User will only be able to view currency of it's own lei
    And User will search for the User
      |User|
      |Abheek Babel|
    And User will reach on the Edit Details screen
    When User will select VIEW_ALL roles for Org
      |roles|
      |4W_APPROVAL_MANAGER|
    And User will select Doctype LEI Orgtype mapping in case not present
    And User will Submit the update user service
    And User will logout of the application
    When user types in the email id
      |email id|
      |abheek.babel@ihsmarkit.com|
    And user types in the password and submit
      |password|
      |Dummy@123456|
    When User is on the Currency screen
    Then User searches for the currency group
      |search currency group|
      |123_tst|

  Scenario: verify VIEW_ALL permission. If VIEW_ALL permission is granted,
  then User will be able to view currency of all lei
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
    When User is on the Currency screen