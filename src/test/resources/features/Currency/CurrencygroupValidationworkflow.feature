@currencygroup @currencygroupvalidation
@Regression
Feature: Workflow of Currency group elements Validation

@TC-1340
  Scenario: Validation of Currency /currency pair group elements on the screen
    Given User is on the Currency screen
    Then Create new group button is visible to the User
    And Organization filter is visible to the User
    And Search bar is visible to the User
    And Columns Currency group name, Organizations, Created On, Action is visible to the User
    And Delete button is visible to the User
    And Update button is visible to the user
    And User can reach to Currency Pair group screen
    Then Create new group button is visible to the User
    And Organization filter is visible to the User
    And Currencies pair groups Search bar is visible to the User
    And Columns Currency group name, Organizations, Created On, Action is visible to the User
    And Delete button is visible to the User
    And Update button is visible to the user

@TC-1340
  Scenario: Verify pagination
    Given User is on the Currency screen
    Then User can see showing page
    And User can see Records per page
    And User can see Total record count
    And when the user is on the first page then prev button should be disabled
    And when the user is on the last page then next button should be disabled

@TC-6842 @TC=6843
  Scenario: Verify that User is able to see Deliverable , Non-Deliverable, bullion & both deliverable Non-deliverable  under currency groups in Groups & templates
    Given User is on the Currency screen
    When User go to create new group screen
    Then User validates deliverable and Non_deliverable on create currency group page
    Then User validates the currencies available for "Currency"
    Then User clicks on Currency group pair radio button
    Then User validates deliverable and Non_deliverable on create currency group page
    Then User validates the currencies available for "CurrencyPair"
    And User selects the Bullion checkbox
    Then User validates the available Bullion for "CurrencyPair"
    Then User clicks on Currency group radio button
    And User validates the available Bullion for "Currency"

  @TC-6673
  Scenario: To Validate the maximum length in currency group, approval group, document template and product group
    Given User is on Approval Group Screen
    Then User click on create new approval group button
    Then User validates approval group name length
    Then User clicks on Cancel button
    Then User will go to currency group listing screen
    Then User go to create new group screen
    Then User validates currency group name length
    Then User clicks on Cancel button
    Then User is on product Group Page
    Then User clicks on Create Product Group
    Then User validates product group name length
    Then User clicks on Cancel button
    Then User is on document Template screen
    Then User will click on create new template button
    Then User validates document template name length
    Then User clicks on Cancel button




