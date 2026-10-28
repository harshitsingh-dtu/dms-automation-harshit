@OrganisationsUpdate @Organisation
@Regression
Feature: Organization Management Functionality

  @TC-1645 @fixed
  Scenario: User is able to change online to lite
    Given User is on the organization update screen
      | listing screen search lei |
      |GLOBAL YIELD               |
    When User searches for the LEI in the search bar
      | update screen search lei |
      |GLOBAL YIELD              |
    Then User is able to change the status of org type from online to lite
      | Org type |
      | PB       |

  @TC-1652 @TC-6700 @fixed
  Scenario: User is able to change lite to online
    Given User is on the organization update screen
      | listing screen search lei |
      |GLOBAL YIELD               |
    When User searches for the LEI in the search bar
      | update screen search lei |
      |GLOBAL YIELD              |
    Then User is able to change the status of org type from lite to online
      | Org type |
      | PB       |

  @TC-1619 @TC-7573 @fixed
  Scenario: User is able to see all the elements on the Organization Update screen
    Given User will reach the Organization section
    And User is on the update screen
    When User should be able to see all the details of the Organization
    And User should be able to see predictive search bar
    And User should be able to see LEI org type status table
    And User should be able to see cancel button
    And User should be able to see submit button

  @TC-6670 @TC-6703
  Scenario: To check whether the neutral button is clickable or not
    Given User is on the organization update screen
      | listing screen search lei |
      | 07 GALOIS                 |
    Then User validates the neutral button is clickable



