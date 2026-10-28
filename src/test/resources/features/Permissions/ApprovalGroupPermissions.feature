@smoke
 @document_type=4-way
Feature: Validate the Approval group permissions
  Background: User will reach Admin User's User management screen
    Given User is on the Dashboard
    When User clicks on User management
    And User reaches the User Management screen

Scenario: verify CREATE_OWN permission. If CREATE_OWN permission is granted,
then User will only be able to create Approval groups of it's own lei
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
  When User is on create new approval group screen
  When User fills the group name,organization name,doc type,LEI's,org type
    | group name | organisation name   | doc type | LEI's          | org type |
    | aproval_group_permission_ | CITIGROUP INC.      | 4 Way    | CITIGROUP INC. | client       |
  Then User organisation name is same as selected organisation name
  And clicks on next
  And user is redirected to update approval group screen

  Scenario: verify CREATE_ALL permission. If CREATE_ALL permission is granted,
  then User will be able to create Approval groups for all LEIs
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
    When User is on create new approval group screen
    And User fills in the approval group name
    |group name|
    |dummy_approval_group|
    And User fills in the organisation name and checks if able to enter all orgs
    |organisation name|
    |citigroup|
    |anand bhawan|

  Scenario: verify EDIT_OWN permission. If EDIT_OWN permission is granted,
  then User will only be able to Edit Approval groups of it's own lei
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
    When User is on Approval group screen
#    Then User will search for group name and reaches the update screen //The checkSearchBar() for this is modified hence check this
#      |group name|
#      |aproval_group_permission|

  Scenario: verify EDIT_ALL permission. If EDIT_ALL permission is granted,
  then User will be able to Edit Approval groups for all LEIs
    And User will search for the User
      |User|
      |mahesh.shelke@osttra.com|
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
      |mahesh.shelke@osttra.com|
    And user types in the password and submit
      |password|
      |Dummy@1234|
    When User is on Approval group screen
    Then User will search for LEI and reaches the update screen


  Scenario: verify VIEW_OWN permission. If VIEW_OWN permission is granted,
  then User will only be able to view Approval groups of it's own lei
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
    When User is on Approval group screen
    #    logic change
    And User searches for group name in the search bar and checks Organisation is same as User
      |19_jan_auto|
      |test_approval_group|

  Scenario: verify VIEW_ALL permission. If VIEW_ALL permission is granted,
  then User will be able to view Approval groups of all lei
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
    When User is on Approval group screen
    #    logic change
