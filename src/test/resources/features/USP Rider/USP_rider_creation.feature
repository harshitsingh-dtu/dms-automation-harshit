@Regression
@USP_rider
Feature: Validation of USP rider flow

@TC-2332 @TC-5910 @TC-01 @TC-02 @TC-03
  Scenario: Validate User is able to create USP Rider template With only mandatory fields and able to view the audit history of created USP rider
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    And User will select doc type on Create USP Template screen
    And User will select random LEI in PB dropdown on Create USP Template screen
    And User will select random LEI in Client dropdown on Create USP Template screen
    And User will enter PB Contact on Create USP Template screen
    |Contact|
    |76543210|
  And User will insert word clause on Create USP Template screen
    And User will enter LEI in search and add fund
     |Lei|
     |Automation_test|
    And User will select all YES options for PB counterparties added
    And Clicks on Submit Button of Create USP Template screen
    And Click on No button of popup
    Then User should be redirected to USP Rider Template listing screen and success message of creation should be visible
    And user click on audit  icon
    And User Validates the USP Rider Audit history Screen
    And User Validates the data on USP Rider Audit history Screen
     | Audit Event      | Date   |          Updated By            |Event Changes|
     | Create USP Rider |Current  |hsbc.test1@testsso.osttra.com| Contact: 76543210; Standard clause wording used: Yes; Word Clause: Reference is made to the (i) Master Foreign Exchange Give-up Agreement dated [Date] (as such may be ...; Funds Added: Automation_test () ;Relief 12-58: Yes; Other Relief: Yes; Pre-Trade Mid Disclosure: Yes; Relief 12-42: Yes |
  Then User clicks on close button

  @TC-2333
  Scenario: Validate User is able to Discard USP Rider template
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    And User will select doc type on Create USP Template screen
    And User will select random LEI in PB dropdown on Create USP Template screen
    And User will select random LEI in Client dropdown on Create USP Template screen
    And User will enter PB Contact on Create USP Template screen
     |Contact|
     |76543210|
    And User will insert word clause on Create USP Template screen
    And User will enter LEI in search and add fund
     |Lei|
     |Automation_test|
    And User will select all YES options for PB counterparties added
    And Clicks on Discard Button of Create USP Template screen
    Then User should be redirected to USP Rider Template listing screen

@DataValidation @CoverageIncreased @TC-04 @TC-08
  Scenario: Validate User is able to verify the USP rider data and able to view audit history of Updated USP rider data
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    And User will select doc type on Create USP Template screen
    And User will select random LEI in PB dropdown on Create USP Template screen
    And User will select random LEI in Client dropdown on Create USP Template screen
    And User will enter PB Contact on Create USP Template screen
      |Contact|
      |76543210|
    And User will insert word clause on Create USP Template screen
    And User will enter LEI in search and add fund
      |Lei|
      |Automation_test|
    And User will select all YES options for PB counterparties added
    And Clicks on Submit Button of Create USP Template screen
    And Click on No button of popup
    Then User should be redirected to USP Rider Template listing screen and success message of creation should be visible
    And User Click on Update button
    Then User verify the content of USP rider
     |PBContact |Value|
     |Contact   |76543210|
     |Fund      |Automation_test|
  And User will enter PB Contact on Create USP Template screen
    |Contact|
    |765432109|
  And Clicks on Submit Button of Create USP Template screen
  And Click on No button of popup
  Then User should be redirected to USP Rider Template listing screen and success message of creation should be visible
  And user click on audit  icon
  And User Validates the USP Rider Audit history Screen
  And User Validates the data on USP Rider Audit history Screen
    | Audit Event      | Date   |          Updated By            |Event Changes|
    | Update USP Rider |Current |hsbc.test1@testsso.osttra.com   | Contact: from 76543210 to 765432109 |
  Then User clicks on close button


