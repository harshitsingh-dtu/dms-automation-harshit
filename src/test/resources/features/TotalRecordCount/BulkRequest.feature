@Regression @BulkEdit
@TotalRecordCount
Feature: Validation of Total Record count on BulkEdit

#  Failing Due to DMGS-6984
  @TC-2467 @TC-2471
  Scenario: Validate text label updated to display Total record count & results remain same on next page
    Given User is on document screen
    And Navigate to Bulk request screen
    And Verify user is on bulk request screen
    Then User can see showing page
    And User can see Records per page
    And User validates the Total record count text
    And User can see Total record count
    And Validate total number of records returned remains same when user switch to next page and enters the next page number