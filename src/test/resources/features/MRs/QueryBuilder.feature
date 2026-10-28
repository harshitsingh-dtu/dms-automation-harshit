 @document_type=4-way @QueryBuilder
Feature: Validate one time data exists or not

Scenario: User creates a Add/Edit Query for Document listing screen - Dataset for @TC-1563,TC-1568,TC-1567
  Given User is on the all document screen
  And User will click on the Add Edit query button
  And User will be redirected to Add Edit query screen
  When User gives the unique query name on Add Edit screen
    |query name|
    |Automation_Query|
  And User clicks on Add query block
  And User selects the field operator and value
    |field            |operator|value |
    |Document Status  |=       |Draft |
  Then User clicks on save and apply
  Then User validates the document status
    |status|
    |Draft |