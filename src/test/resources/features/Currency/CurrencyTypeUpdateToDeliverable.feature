@CurrencyGroupUpdates @Regression @US=DMGS-7309 @US=7808


Feature: Update of currency type of JPY and USD

  @TC=03  @TC=06
  Scenario: User is able to validate JPY and USD have a currency type as Deliverable and able to make a currency group
    Given User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name  |
      | Test_GrpS01 |
    And User types the organization name
      | organisation name |
      | All Organisations |
    And User selects and validates currencies are deliverable in pop-up
      | JPY |
      | USD |
    Then User clicks on Cancel button

  @US=7808 @TC=01
  Scenario: User is able to validate new added currencies are present or not
    Given User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name  |
      | Test_GrpS02 |
    And User types the organization name
      | organisation name |
      | All Organisations |
    And User selects and validates currencies are present in pop-up
      | MZN |
      | UZS |
      | LKR |
    Then User clicks on Cancel button


