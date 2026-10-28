@QueryBuilder @QueryBuilderColumnsSelection
@Regression

Feature: Workflow for Query Builder Columns Selection

@TC-1569 @Sanity
Scenario: User is able to validate the Column Selection in Query Builder
  Given User is on Document Page
  When User clicks on Column Selection button
  And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name    |
    | Document Action |

@TC-1939
  Scenario: Validate the data for doc type 4 way with both org type EB filters from the column selection
    Given User is on Document Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Document Type  |
      | EB-1 LEI       |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name            |value               |
      |Document Type          |4 way               |
      |EB-1 Legal Entity Name |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
    Then User validates no record found

@TC-1940
  Scenario: Validate the data for doc type DN with both org type EB filters from the column selection
    Given User is on Document Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name            |
      | Document Type          |
      | EB-1 Legal Entity Name |
    And user will select Column Values on Document listing screen
      |Column Name            |value               |
      |Document Type          |DN                  |
      |EB-1 Legal Entity Name |3G Fund, L.P.|
    Then User validates DN Documents are displayed