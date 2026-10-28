@ApprovalGroupsCreation @Global_MRs

Feature: Create an approval groups for the feature files

  Scenario: Create approval groups for further uses for DN -dataset for US-DMGS=7703 and US-DMGS=7712
    Given User is on create new approval group screen
    And User fills the group name,organization name,doc type,LEI's,org type
      | group name       | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_01 | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And User will search for the users to be added and add them
      | user                         |
      | automation.user1@yopmail.com |
    And  User will submit the changes after adding users to the approval group
    Then User click on create new approval group button
    And User fills the group name,organization name,doc type,LEI's,org type
      | group name       | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_02 | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group

  Scenario: Create approval groups for further uses for 4 Way -dataset for US-DMGS=7703
    Given User is on create new approval group screen
    And User fills the group name,organization name,doc type,LEI's,org type
      | group name       | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_03 | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test6@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group
    Then User click on create new approval group button
    And User fills the group name,organization name,doc type,LEI's,org type
      | group name       | organisation name                     | doc type | LEI's                                 | org type |
      | Automation_AG_04 | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then User clicks on Next button
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      | user                          |
      | hsbc.test1@testsso.osttra.com |
    And  User will submit the changes after adding users to the approval group