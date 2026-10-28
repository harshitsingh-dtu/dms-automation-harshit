@Regression @Documents
@TotalRecordCount
Feature: Validation of Total Record Count for Document Dashboard

  @TC-2452 @TC-2456
  Scenario: Total Record count should be visible on Document Dashboard
    Given User will go to Document screen
    Then User can see showing page
    And User can see Records per page
    And User validates the Total record count text
    And User can see Total record count
    And Validate total number of records returned remains same when user switch to next page
    And when the user is on the first page then prev button should be disabled
    And when the user is on the last page then next button should be disabled

  @TC-2454 @TC=2455
  Scenario: Total record count after applying filter on Document Dashboard
    Given User will go to Document screen
    And User will click on the Add Edit query button
    And User clicks on Add query block
    And User performs multiple Add query block
    |field|operator|value|condition|
    |Document Status |=       |Draft |AND|
    |PB-1 Legal Entity Name|= |Osttra India Services Private Limited|AND|
    |EB-1 Legal Entity Name|= |CITIGROUP INC.|AND|
    |Client-1 Legal Entity Name|= |CITIGROUP INC.|AND|
    |Document Type|= |DN|null|
    Then User clicks on Apply
    And Verify the Total Record Count
    |1|