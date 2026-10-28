@QueryBuilder @QueryBuilderValidation
@Regression

Feature: Validation for Query Builder

  @TC-1562
  Scenario: Verify the Add/Edit query screen elements
    Given User is on the all document screen
    And User can see Add Edit query button
    When User will click on the Add Edit query button
    Then User will be redirected to Add Edit query screen
    And User can see select query dropdown on Add Edit screen
    And User can see and type into the query name
    And user can see Add query button
    And User can see the cancel button on Add Edit screen
    And User can see Save and Apply button on the Add Edit screen
    And  User can see Apply button on the Add Edit screen
    And User clicks on Add query block
    And User selects the field operator and value
      | field         | operator | value |
      | Document Type | =        | DN    |
    Then User clicks on Apply
    And User validates DN Documents are displayed

  @TC-1565 @Sanity @TC-6668
  Scenario: Verify add new query - Dataset for @TC-1563,TC-1568,TC-1567
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      | query name            |
      | Automation_Regression |
    And User clicks on Add query block
    And User selects the field operator and value
      | field           | operator | value |
      | Document Status | =        | Draft |
    Then User clicks on save and apply
    Then User validates the document status
      | status |
      | Draft  |

  @TC-1563 @fixed
  Scenario: Verify the functionality when existing query is applied
    Given User is on the all document screen
    When User will select a existing query from select query dropdown on document screen
      | query block      |
      | Automation_Query |
    Then User validates the document status
      | status |
      | Draft  |

  @TC-1568 @fixed
  Scenario: Add query block to a existing query
    Given User is on the all document screen
    When User will select a existing query from select query dropdown on document screen
      | query block      |
      | Automation_Query |
    And User will click on the Add Edit query button
    And User performs multiple Add query block
      | field           | operator | value | condition |
      | Document Status | =        | Draft | AND       |
      | Document Type   | =        | 4 Way | null      |
    Then User clicks on save and apply
    Then User validates the document version ID
      | Document Version ID |
      | 4W-                 |


  @TC-1567 @fixed
  Scenario: Verify User is able to remove a query block
    Given User is on the all document screen
    When User will select a existing query from select query dropdown on document screen
      | query block      |
      | Automation_Query |
    And User will click on the Add Edit query button
    And User will be able to remove a query block
      | field         |
      | Document Type |
    Then User clicks on save and apply
    Then User validates the document status
      | status |
      | Draft  |

  @US=DMGS-7129 @TC-1914 @TC-6666
  Scenario: Create Query block using Document Version ID field to filter all DN doc type documents
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      | query name            |
      | Automation_Regression |
    And User clicks on Add query block
    And User selects the field operator and value
      | field               | operator | value | condition |
      | Document Version ID | LIKE     | DN    | AND       |
      | Document Version ID | IS       | DN    | null      |
    Then User clicks on Apply
    Then User validates the document version ID
      | Document Version ID |
      | DN-                 |
    Then User clicks on the download button
    Then User validates the file is downloaded

  @TC-1564
  Scenario: Verify remove the query applied on the all document listing screen
    Given User is on the all document screen
    When User will select a existing query from Add Edit screen
      | query block      |
      | Automation_Query |
    Then User validates the document status
      | status |
      | Draft  |
    Then User removes the query applied
    Then User validates query is removed

  @TC-1570 @Sanity
  Scenario: Verify Advance Filter screen
    Given User is on the all document screen
    And User will click on Apply More Filters
    And User will be redirected to Advance Filters Screen
    Then User validates the fields on the filter screen

  @TC-1696 @TC-1700 @TC-1701 @fixed
  Scenario: Validate select field dropdown values for Query builder -Data created by API
    Given User is on the all document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | EB-1 LEI                   |
      | EB-1 Legal Entity Name     |
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User selects the field operator and value
      | field    | operator | value                |
      | EB-1 LEI | =        | 6SHGI4ZSSLCXXQSBB395 |
    Then User clicks on Apply
    Then User validates the EB-1 Data
      | EB-1 LEI             | EB-1 Legal Entity Name |
      | 6SHGI4ZSSLCXXQSBB395 | CITIGROUP INC.         |

  @TC-6712
  Scenario: To check the max and min value in query builder for limit value
    Given User is on Document Page
    And User will click on the Add Edit query button
    And User clicks on Add query block
    And User selects the field operator and value
      | field       | operator | value |
      | Limit Value | =        | 0     |
    Then User validates text is visible
      | Please enter numeric value. |
    And User selects the field operator and value
      | field       | operator | value |
      | Limit Value | =        | 1     |
    And User selects the field operator and value
      | field       | operator | value           |
      | Limit Value | =        | 999999999999999 |
    Then User validates the max value limit value
      | $999,999,999,999,999 |
    Then User clicks on Cancel button