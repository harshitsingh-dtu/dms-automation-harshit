@Regression @AlternateLegalEntityName
@US=DMGS-3773

Feature: Validating AlternateLegalEntityName screen and Functionality

@TC=7888 @TC-7890 @TC-7891 @TC-7892 @TC-7893 @TC-7894 @TC-7895 @TC-7896
Scenario: Validate all the approval agreement Screen Elements
    Given User is on Alternate Legal Entity names Screen
    Then Validate User is on Alternate Legal Entity names Screen
    Then User searches for the LEI in the search bar
      |update screen search lei|
      |BNP PARIBAS|
    And User validates data
      | Data               |
      | LEI                |
      |Legal Entity Name   |
      |2763TSAJ0VP4CVMFM028|
    Then User clicks on update button
    Then User validates user is on Organisation information screen
    Then User searches for the LEI in the search bar
      |update screen search lei|
      |BNP PARIBAS             |
    And User validates data
      | Data                |
      | LEI                 |
      | BNP PARIBAS         |
      | 2763TSAJ0VP4CVMFM028|
    Then User clicks on versions button
    And User validates data
      | Data               |
      |2763TSAJ0VP4CVMFM028|

  @TC-7897 @TC-7900
  Scenario: Verify User is able to update the name of the org
    Given User is on Alternate Legal Entity names Screen
    Then Validate User is on Alternate Legal Entity names Screen
    Then User searches for the LEI in the search bar
      |update screen search lei   |
      |LEBE INVEST AS 1                   |
    Then User clicks on update button
    Then User clicks on versions button
    Then User click on Add new button
    And User enters new Alternate name and Comments
      |New Alternate Name|Comments            |
      |Testing LEI       | Regression Testing |
    Then Clicks on Submit Button
    Then User validates text is visible
      |Text                      |
      |Confirm new alternate name|
    Then User clicks on confirm button
    Then User waits for 2 seconds
    And User validates the message
      |New legal name has been updated|
    Then User validates the history record values
      |Alternate Legal entity Name |Updated By                    |Created On (Local Time)|Created On (UTC Time)|
      |Testing LEI                 |hsbc.test1@testsso.osttra.com |Current Date           |Current Date         |

  @TC-7926
  Scenario: User Validates latest name while creating DN
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |Testing LEI |
    Then User validates the LEI has name has been updated
      |Updated LEI Name|
      |Testing LEI     |
    Then User clicks on Discard button
    And user will select Column Values on Document listing screen
      |Column Name                   |value       |
      |PB-1 Legal Entity Name        |Testing LEI |
    And User validates the updated name is coming on DashboardFilters
      |Testing LEI|

  @TC-7904
  Scenario: User Validates latest name while creating DF & 4way
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    And validate the document type value as DN
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Prime Broker 1      |Testing LEI  |
    Then User validates the LEI has name has been updated
      |Updated LEI Name|
      |Testing LEI     |
    Then User clicks on Discard button
    And user will select Column Values on Document Framework screen
      |Column Name   |value         |
      |PB Name       |Testing LEI   |
    And User validates the updated name is coming on DashboardFilters
      |Testing LEI|
    Then User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      |Prime Broker 1   |Testing LEI |
    Then User validates the LEI has name has been updated
      |Updated LEI Name|
      |Testing LEI     |
    Then User clicks on Discard button
    And user will select Column Values on Document listing screen
      |Column Name                   |value       |
      |PB-1 Legal Entity Name        |Testing LEI |
    And User validates the updated name is coming on DashboardFilters
      |Testing LEI|

  @TC-7909
  Scenario: User Validates latest name while creating currency group
    Given User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name    |
      |Automation_Test_Curr_01 |
    And User types the organization name
      |organisation name|
      |Testing LEI      |
    Then User validates the updated name is coming in Dropdown
      |Testing LEI|

  @TC-7909
  Scenario: User Validates latest name while creating currency pair group
    Given User is on the Currency pair screen
    When User go to create new group screen
    And User types the currency pair group name
      | group name         |
      | Automation_Test_CurrPair_01 |
    And User types the organization name
      |organisation name|
      |Testing LEI      |
    Then User validates the updated name is coming in Dropdown
      |Testing LEI|

  @TC-7911
  Scenario: Verify that product groups should use latest alternate organisation name
    Given User is on the Dashboard page and navigate to Product Group
    When User clicks on Create Product Group
    And User enters the Product group name
      | Product Group Name         |
      | Test_Automation_TBD        |
    And Select the Organisation Name
      | Organisation Name |
      | Testing LEI       |
    Then User validates the updated name is coming in Dropdown
      |Testing LEI|

  @TC-7912
  Scenario: Verify that approval groups listing should use latest alternate organisation name
    Given User is on create new approval group screen
    And User generates unique the group name,organization name,LEI's,org type
      | group name  | organisation name   |doc type |  LEI's      | org type |
      | Automation  | Testing LEI         | DN      | Testing LEI | Client   |
    And User validates the updated name is coming in Dropdown
      |Testing LEI|

  @TC-7913
  Scenario: Verify that approval matrix listing should use latest alternate organisation name
    Given User is on the create approval matrix screen
    Then User enter the org value on create approval matrix screen
      |organisation name|
      |Testing LEI      |
    Then User validates the updated name is coming in Dropdown
      |Testing LEI|

  @TC-7915
  Scenario: validate create new template functionality for Doc type 4 way
    Given User will go to Document template screen
    And User will click on create new template button and get redirected to create new document template screen
    Then user will enter template name organisation name and Doctype
      |Template Name     |Organisation Name       |Doc Type |
      |Autotest_4Way     |Testing LEI             |4 Way    |
    Then User validates the updated name is coming in Dropdown
      |Testing LEI|

  @TC-7916
  Scenario: Validate User is able to create USP Rider template With only mandatory fields
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    And User will select doc type on Create USP Template screen
    And User will select PB and client dropdown on Create USP Template screen
      |PB Name                               |Client Name   |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |Testing LEI   |
    Then User validates the updated name is coming for USP Rider
      |Testing LEI|

  @TC-7917 @TC-7918
  Scenario: Verify that approval agreement listing screen  should  show latest alternate entity name
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value       |
      |PB Legal Entity Name       |Testing LEI |
    Then User validates the updated org name is coming for approval agreement
      |Testing LEI|
    Then User clicks on Create New Approval agreement
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs in Approval Agreement
      | Prime Broker   |  Testing LEI           |
    Then User validates the updated org name is coming for approval agreement
      |Testing LEI|

   @ResetData
  Scenario: Resetting back to Original name
    Given User is on Alternate Legal Entity names Screen
    Then Validate User is on Alternate Legal Entity names Screen
    Then User searches for the LEI in the search bar
      |update screen search lei   |
      |Testing LEI                |
    Then User clicks on update button
    Then User clicks on versions button
    Then User click on Add new button
    And User enters new Alternate name and Comments
      |New Alternate Name|Comments        |
      |LEBE INVEST AS 1           | Resetting Data |
    Then Clicks on Submit Button
    Then User validates text is visible
      |Text                      |
      |Confirm new alternate name|
    Then User clicks on confirm button
     Then User waits for 2 seconds
     And User validates the message
       |New legal name has been updated|