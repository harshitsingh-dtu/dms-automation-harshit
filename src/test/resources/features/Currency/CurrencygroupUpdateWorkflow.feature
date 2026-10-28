@currencygroup @CurrencygroupValidationworkflow
@Regression
Feature: Workflow of Currency group update screen

  @TC=1341 @TC=6138 @TC=6844 @Sanity @test
  Scenario: User is able to create new currency group
    Given User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name    |
      |Automation_Test_Curr_01 |
    And User types the organization name
      |organisation name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will search for the currency and select them
      |currency list|
      |BBD|
      |CLF|
      |KZT|
    And User will submit the changes
    Then User will check the notification for create currency group
#    Then User Validate the Created Currency Group
#      | group name               | organisation name | currency list |
#      | Automation_Test_Curr_01  | OSTTRA            |BBD            |

    @TC-1341 @TC=6138 @TC=6845 @TC=6846 @Sanity
    Scenario: User is able to create new currency pair group
    Given User is on the Currency pair screen
    When User go to create new group screen
    And User types the currency pair group name
      | group name         |
      |Automation_Test_CurrPair_01|
    And User types the organization name
      |organisation name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will search for the currency pair and select them on Currency Pair Screen
      |currency list|
      |AUD-DKK|
      |USD-SEK|
#      |GBP-OMR|
    And User will submit the changes
    Then User will check the notification for create currency group

  @TC-1342 @TC-6187
  Scenario: User is able to remove all the currencies
    Given User is one the currency group update screen
      |search currency group|
      |Automation_Test_Curr_01 |
    #Then User will search all currency
    And Verify if the User is able to deselect all the currencies at the same time using 'Remove All'

  @TC-1342 @TC-6187
  Scenario: User is able to remove all the currencies pair
    Given User is on the Currency pair screen
    When User searches for the currency pair group
      |group name|
      |Automation_Test_CurrPair_01|
    And User clicks on the update button for Currency
    Then Verify if the User is able to deselect all the currencies at the same time using 'Remove All'

# DMGS-6964 Bug
  @TC-6191 @TC-6187
  Scenario: User is able to update the currency group
    Given User is on the Currency screen
    When User searches for the currency group
      |group name|
      |Automation_Test_Curr_01 |
    And User clicks on the update button for Currency
    Then User will search for the currency and select them
      |currency list|
      |AED|
      |BWP|
      |BRL|
    And User will remove the currency after searching them
      |remove currency list|
      |BWP|
      |BRL|
    And User will submit the changes

@TC-6191 @TC-6187
  Scenario: User is able to update the currency pair group
    Given User is on the Currency pair screen
    When User searches for the currency pair group
      |group name|
      |Automation_Test_CurrPair_01 |
  Then User waits for 2 seconds
    And User clicks on the update button for Currency
    Then User will search for the currency pair and select them
      |currency list|
      |AUD-COP|
      |AUD-CZK|
      |AUD-DKK|
    And User will remove the currency pair after searching them
      |remove currency list|
      |AUD-CZK|
      |AUD-DKK|
    And User will submit the changes

  @TC-1343 @TC-6152
  Scenario: User is able to delete existing currency
    Given User is on the Currency screen
    When User searches for the currency group
      |search currency group|
      |Automation_Test_Curr_01 |
    And User is able to delete the existing currency group

  @TC-1343 @TC-6152
  Scenario: User is able to delete existing currency pair
    Given User is on the Currency pair screen
    When User searches for the currency pair group
      |group name|
      |Automation_Test_CurrPair_01|
    Then User is able to delete the existing currency pair group

  @TC=6262
  Scenario: User is able to create new currency group for Bullion trade
    Given User is on the Currency screen
    When User go to create new group screen
    And User types the group name
      | group name    |
      |Automation_Test_BullionCurr_01 |
    And User types the organization name
      |organisation name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User selects the Bullion checkbox
    And User will search for the currency and select them
      |currency list|
      |XAG|
      |XAU|
      |XPD|
    And User will submit the changes
    Then User will check the notification for create currency group
    Then User searches for the currency group
      |search currency group|
      |Automation_Test_BullionCurr_01         |
    And User is able to delete the existing currency group

  @TC=6262
  Scenario: User is able to create new currency group Pair for Bullion trade
    Given User is on the Currency pair screen
    When User go to create new group screen
    And User types the group name
      | group name    |
      |Test_Bullion_|
    And User types the organization name
      |organisation name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User selects the Bullion checkbox
    Then User will search for the currency pair and select them on Currency Pair Screen
      |currency list|
      |XPT-CAD|
      |XPT-AUD|
      |XPT-CHF|
    And User will submit the changes
    Then User will check the notification for create currency group
    And User is on the Currency pair screen Alone
    Then User searches for the currency pair group
      |group name|
      |Test_Bullion_|
    Then User is able to delete the existing currency pair group