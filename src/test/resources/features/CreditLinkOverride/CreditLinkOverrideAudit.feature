@Regression @CreditLinkOverrideAudit
@US=DMGS-7364 @US=DMGS-6284

Feature: Validating Audit History of Screens and Functionality

  Scenario: Validate User can see what has changed after making a change to the CreditLink Overrrides
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei   |
      | JP MORGAN DIVERSIFIED RISK |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User Enters the text PB Column
      | Testing |
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User clicks on Audit button for CL Override
    And User Validates the CL Override Audit history Screen
    And User Validates the data on Cl Override Audit history Screen
      | Updated By                    | Event Changes                         |
      | hsbc.test1@testsso.osttra.com | PB Override ID was Added as 'Testing' |

  Scenario: Validate User can see removing the Override ID to the CreditLink Overrrides
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei   |
      | JP MORGAN DIVERSIFIED RISK |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the PB value
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User clicks on Audit button for CL Override
    And User Validates the CL Override Audit history Screen
    And User Validates the data on Cl Override Audit history Screen
      | Updated By                    | Event Changes              |
      | hsbc.test1@testsso.osttra.com | PB Override ID was Removed |

  @US=DMGS-6284 @TC=04
  Scenario: Validate the cross button on auditing screen
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei   |
      | JP MORGAN DIVERSIFIED RISK |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on Audit button for CL Override
    Then User clicks on cross button
    Then User validates the Organisation information screen is displayed

  @TC=01 @TC=02 @TC=03
  Scenario: Validate add, update and delete functionality from the cl override audit screen
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei |
      | 07 GALOIS                |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    When user clears the PB override text if present
    Then User will click on Submit Button
    Then User waits for 3 seconds
    Then User clicks on edit icon
    Then User Enters the text only for PB Column
      | Testing |
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the toast message
      | Data saved successfully |
    Then User clicks on Audit button for CL Override
    And User Validates the CL Override Audit history Screen
    And User Validates the all data on Cl Override Audit history Screen
      | Updated By                    | Event Changes                         |
      | hsbc.test1@testsso.osttra.com | PB Override ID was Added as 'Testing' |
    Then User clicks on cross button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the PB value
    Then User Enters the text only for PB Column
      | TESTING |
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User clicks on Audit button for CL Override
    And User Validates the CL Override Audit history Screen
    And User Validates the all data on Cl Override Audit history Screen
      | Updated By                    | Event Changes                                      |
      | hsbc.test1@testsso.osttra.com | PB Override ID updated from 'Testing' to 'TESTING' |
    Then User clicks on cross button
    Then User clicks on edit icon
    Then User removes the PB value
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User clicks on Audit button for CL Override
    And User Validates the CL Override Audit history Screen
    And User Validates the data on Cl Override Audit history Screen
      | Updated By                    | Event Changes              |
      | hsbc.test1@testsso.osttra.com | PB Override ID was Removed |

  @TC-6265_01
  Scenario: Verify that Admin User can see CL override tab
    Given User clicks on the profile button
    Then User verifies the following roles are present on the profile screen
      | OSTTRA View All   |
      | OSTTRA_PSUSER     |
      | OSTTRA Onboarding |
    Then User clicks on Menu bar on Dashboard
    Then User clicks on the Organisation Dropdown
    And Verify CreditLink Override text is present