@Regression @DashboardValidations
@US=DMGS-3331
Feature: Validate Columns and filters on Dashboards

  @TC=6912 @TC=6913
  Scenario: Validate 'DNM EDN ID, DNM EDN Main ID on odc dashboard & DF dashboard with filter capability
    Given User is on Document Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name        |
      |DNM EDN ID         |
      |DNM EDN main ID    |
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block for DN
      |field           |operator|value |condition|
      |DNM EDN ID      |=       |123   |AND      |
      |DNM EDN main ID |=       |567   |null     |
    Then User clicks on Apply
    And User validates no record found

  @TC=6912
  Scenario: DNM MA ID,DNM MA Main ID should display for migrated EDN on DF dashboard
    Given User is on Document Framework Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      |Column Name        |
      |DNM MA ID          |
      |DNM MA main ID     |
    And User Validates the columns are displayed on Dashboard
      |Column Name        |
      |DNM MA ID          |
      |DNM MA main ID     |