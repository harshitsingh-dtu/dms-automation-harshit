@smoke
 @document_type=4-way
Feature: Error to credit link option validation

@TC-6795
  Scenario: Verify error to credit link option
    Given User is on Document Page
    Then User clicks on Bulk Action button
  #testcase is update now.
    And User verify error to CL option from Bulk Action menu


 @TC-6800 @TC-6799
   #test needs to be updated.
  Scenario: Verify error to CL new query
    Given User is on the all document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Document Action |
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |Automation_Regression|
    And User clicks on Add query block
    And User selects the field operator and value
      |field            |operator|value |
      |CreditLink Sync Status  |=       |Error Acknowledged |
    Then User clicks on save and apply
    Then User validates the CL status
      |status|
      |error acknowledged |