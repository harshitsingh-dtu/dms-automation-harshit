@Regression @OrganisationPage
@TotalRecordCount
Feature: Validation of Total Record count on Organisation

  @TC-2460 @TC-2463
  Scenario: Validate text label updated to display Total record count & results remain same on next page
    Given User navigates to the organisation screen
    Then User can see showing page
    And User can see Records per page
    And User validates the Total record count text
    And User can see Total record count
    And Validate total number of records returned remains same when user switch to next page

  @TC-2461
  Scenario: Validate total number of records returned for a given search in Organisations pages.
    Given User navigates to the organisation screen
    When User will be able to see predictive search bar and type for searching LEI id's
      |search lei|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And Verify the Total Record Count
      |1|
