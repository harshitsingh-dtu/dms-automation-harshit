@LimitLine_Delta_Validations @Regression
@US=DMGS-6878

Feature: Validate Delta functionality for Limit line in DF/4Way (Uses MR @DraftDF)

@TC_01
Scenario: Verify that application throws validation when FX-Cash is select for Limit line -DF
  Given User is on Document Framework Page
    And User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 5299000EAECXJ01JK695                 |
  Then User creates a document framework through API
    |Payload path|
    |src/test/java/resources/DF_Creation_MR5.json|
  Then User adds immediate enforcement rules via API for DN Document or Document Framework
  And user will select Column Values on Document Framework screen
    |Column Name         |value                                 |
    |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Name             |WK A Hydropower Plants - Equipment GmbH|
    |Lifecycle status    |Draft                                 |
    And user clicks on Document Edit icon
    And User waits for 5 seconds
    And User clicks on Limit Scope
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User will input Product family
      |Product Family|
      | Cash   |
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User validates the message
        |Delta and product family selection is invalid|

  @TC_02
  Scenario: Verify that user is able to add/edit limit line if either exotic or Vanilla options are selected for Limit line -DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                     |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED     |
      |EB Name             |WK A Hydropower Plants - Equipment GmbH   |
      |Lifecycle status    |Draft                                     |
    And user clicks on Document Edit icon
    And User waits for 5 seconds
    And User clicks on Limit Scope
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User will input Product family
      |Product Family   |
      | Cash            |
      | Vanilla Options |
      | Volatility      |
      | Bullion         |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Save As Draft button
    Then User validates the message
      |Limit scope updated successfully|
    Then User edit the Product family for DF
      |Product Family   |
      | Cash            |
      | Volatility      |
    And User clicks on Save As Draft button
    Then User validates the message
      |Delta and product family selection is invalid|
    Then User clicks on Delete icon for limit line
    Then User clicks on Save As Draft button
    Then User validates the toast message
      |Limit scope updated successfully|

    @TC_03
  Scenario: Verify that application throws validation when FX-Cash is select for Limit line -DF Copy
    Given User is on Document Framework Page
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 2221001Z5K01CX8YWZ14                 |
    And user will select Column Values on Document Framework screen
      |Column Name         |value                |
      |Lifecycle status    |Approved             |
    And User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Prime Broker 1      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
      |EB 1                |JP MORGAN DIVERSIFIED RISK              |
    And Verify next button and click
    And User validates the message
      |Document copied successfully|
    And User waits for 3 seconds
    And User clicks on Limit Scope
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User will input Product family
      |Product Family|
      | Cash   |
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User validates the message
      |Delta and product family selection is invalid|

  @TC_04
  Scenario: Verify that user is able to add limit line if either exotic or Vanilla options are selected for Limit line for copied DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |JP MORGAN DIVERSIFIED RISK               |
      |Lifecycle status |Draft                                 |
    And user clicks on Document Edit icon
    And User waits for 5 seconds
    And User clicks on Limit Scope
    And User deletes all the Limit Lines
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User will input Product family
      |Product Family   |
      | Cash            |
      | Vanilla Options |
      | Volatility      |
      | Bullion         |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Save As Draft button
    Then User validates the message
      |Limit scope updated successfully|
    Then User edit the Product family for DF
      |Product Family   |
      | Cash            |
      | Volatility      |
    And User clicks on Save As Draft button
    Then User validates the toast message
      |Delta and product family selection is invalid|
    Then User clicks on Delete icon for limit line
    Then User clicks on Save As Draft button
    Then User validates the toast message
      |Limit scope updated successfully|

  @ResetData @DFCopyReset
  Scenario: Deleting the DF-Copy dataset
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |JP MORGAN DIVERSIFIED RISK               |
      |Lifecycle status|Draft                                 |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

  @ResetData @DFCopyReset
  Scenario: Deleting the DF dataset TC_01 and TC_02
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |WK A Hydropower Plants - Equipment GmbH|
      |Lifecycle status    |Draft                                 |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

@TC_05
  Scenario: Verify that application throws validation when FX-Cash is select for Limit line - 4way
    Given User is on the all document screen
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1                       | Clients 1        |Prime Broker 2    |Clients 2                             |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |Rolf Küstner e.K. |Rolf Küstner e.K. |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on Next button
    Then User waits for 2 seconds
    And User clicks on Limit Scope
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Limit Value
      |Limit Value|
      |999999999999999|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User will input Product family
      |Product Family   |
      | Cash            |
      | Volatility      |
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    And User validates the toast message
      |Delta and product family selection is invalid|
    Then User edit the Product family 4way
      |Product Family|
      |Bullion       |
  Then User clicks on Add Limit button
  Then User clicks on Save As Draft button
  Then User validates the toast message
    |Limit scope updated successfully|
  Then User edit the Product family
    |Product Family   |
    | Cash            |
    | Volatility      |
#  And User click on save icon for limit line for DF
  And User clicks on Save As Draft button
  Then User validates the toast message
    |Delta and product family selection is invalid|
  Then User clicks on Delete icon for limit line
  Then User clicks on Save As Draft button
  Then User validates the toast message
    |Limit scope updated successfully|


  @ResetData @DFCopyReset
  Scenario: Deleting the DF dataset TC_05
  Given User is on the all document screen
  And user will select Column Values on Document listing screen
    |Column Name                   |value                |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
    |Client-1 Legal Entity Name    |Rolf Küstner e.K. |
    |PB-2 Legal Entity Name        |Rolf Küstner e.K. |
    |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED|
    |Document Status               |Draft                |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

@TC_06
  Scenario: Verify that application throws validation when FX-Cash is select for Limit line - 4way Copy
      Given User is on the all document screen
      And User will search for column, selects it if not already selected and validates the same on Document listing screen
        | Column Name                |
        | Document Type              |
        | Document Action            |
      And user will select Column Values on Document listing screen
        |Column Name      |value    |
        |Document Type    |4 way    |
        |Document Status  |Enforced |
      And User validates the Copy icon and clicks on it
      Then User select acting as
        | Acting As |
        | PB        |
      Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
        | Prime Broker 1                       | Clients 1                                | Prime Broker 2                         |Clients 2                             |
        |OSTTRA INDIA SERVICES PRIVATE LIMITED | CITIC Capital China Partners III, L.P.   |Autohaus Weiss Limited Liability Company|OSTTRA SERVICES LIMITED               |
      Then Verify next button and click
      And User validates the message
        |Document copied successfully|
      And User waits for 3 seconds
      And User clicks on Limit Scope
      And User deletes all the Limit Lines
      And User will input Calculation Type
        |Calculation Type|
        |DSL|
      And User will input Limit Value
        |Limit Value|
        |1          |
      And User will input Netting Type
        |Netting Type|
        |Greater L/S |
      Then User enter Bullion Trades in Limit Scope
        |Exclude Metals|
      Then User will input Delta
        |Delta|
        |Yes  |
      Then User will input Product family
        |Product Family   |
        | Cash            |
        | Volatility      |
      Then User will input Exclude CLS from calculation
        |Exclude CLS|
        |Yes        |
      Then User clicks on Add Limit button
      And User validates the toast message
        |Delta and product family selection is invalid|
      Then User edit the Product family 4way
        |Product Family|
        |Select All|
      Then User clicks on Add Limit button
      Then User clicks on Save As Draft button
      Then User validates the toast message
        |Limit scope updated successfully|
  #    Then User clicks on edit icon
      Then User edit the Product family
        |Product Family   |
        | Volatility      |
  #    And User click on save icon for limit line for DF
      And User clicks on Save As Draft button
      Then User validates the toast message
        |Delta and product family selection is invalid|
      Then User clicks on Delete icon for limit line
      Then User clicks on Save As Draft button
      Then User validates the toast message
        |Limit scope updated successfully|

  @ResetData @4WayCopyReset
  Scenario: Verify that data is Reset for 4way - Copy limit scope
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                      |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                         |
      |Client-1 Legal Entity Name    |CITIC Capital China Partners III, L.P.     |
      |PB-2 Legal Entity Name        |Autohaus Weiss Limited Liability Company      |
      |Client-2 Legal Entity Name    |OSTTRA SERVICES LIMITED      |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|