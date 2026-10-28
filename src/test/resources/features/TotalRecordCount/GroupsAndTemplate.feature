@Regression @GroupsAndTemplate
@TotalRecordCount
Feature: Total Record count should be visible on Groups & Template


  @TC-2475 @TC-2476 @TC-2477 @TC-2479
  Scenario: Validate text label updated to display Total record count & search for currency group
    Given User is on the Currency screen
    Then User validates the Total record count text
    And Validate total number of records returned remains same when user switch to next page
    And User types the organization name
      |organisation name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User searches for the currency group
      |group name|
      |Automation_OT_currencyGroup|
    And Verify the Total Record Count
      |1|


  @TC-2475 @TC-2476 @TC-2477 @TC-2479
  Scenario: Validate text label updated to display Total record count & search for currency group pair
    Given User is on the Currency pair screen
    Then User validates the Total record count text
    And Validate total number of records returned remains same when user switch to next page
    And User types the organization name
      |organisation name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User searches for the currency pair group
      |group name|
      |Automation_OT_CurrencyPairGroup|
    And Verify the Total Record Count
      |1|
