@LimitScopeDraftDF @Regression
@US=DMGS-6336

Feature: Validate SelectAll functionality for authorisation scope in DF/DN/4Way (Uses MR @DraftDF)

@DMGS-6336 @TC_01 @TC_04 @TC_12
Scenario: Verify select all is available in Product Family options for LimitScope for a DF
  Given User resets DF document
      | docTypeId |7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   |254900SLCV8KI86BHL86                 |
      | ebLeiId   |5299000GMGMY4R9QB553                 |
  Given User is on Document Framework Page
  Then User creates a document framework through API
    |Payload path|
    |src/test/java/resources/DF_Creation_MR6.json|
    Then User refreshes the browser
    Then User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |Diocese of Innsbruck                     |
      | Lifecycle status | Draft                                 |
    And user clicks on Document Edit icon
    And User waits for 5 seconds
    And User clicks on Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all Product Families should be selected for Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
  Then User validates all selected Products are deSelected in LimitScope

  @TC_05
  Scenario: Verify that Product family added via select all checkbox is showing on DF preview screen for Limit Scope
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |Diocese of Innsbruck                     |
      | Lifecycle status | Draft                               |
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
      | Select All   |
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User validates the toast message
      |Limit scope updated successfully|
    And User clicks on Limit Scope Tab in Final Preview
    And User validates the limit line
      | Calculation Type|Netting Type  | Bullion trades| Delta |Product Family |
      | DSL             |Greater L/S   | Exclude Metals|  Yes   | Cash, Vanilla Options, Volatility, Bullion, Exotic Options          |

  @TC_07
  Scenario: Verify that Product family added via select all checkbox in DF Copy
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                      |
      |Lifecycle status    |Approved             |
    And User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Prime Broker 1      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
      |EB 1                |JP MORGAN DIVERSIFIED RISK              |
    And User clicks on Next button
    Then User validates the toast message
      |Document copied successfully|
    And User waits for 3 seconds
    And User clicks on Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all Product Families should be selected for Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all selected Products are deSelected in LimitScope

  @TC_03
  Scenario: Verify select all is available in Product Family options for limit scope for a 4way
    Given User is on the all document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | PB-2 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
      | Document Type                |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.      |
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.      |
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all Product Families should be selected for Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all selected Products are deSelected in LimitScope

  @TC_04 @TC_05
  Scenario: Verify that Product family added via select all checkbox is showing on 4way preview screen for Limit Scope
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.      |
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.      |
    Then User clicks on edit icon
    Then User waits for 5 seconds
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
      |Product Family|
      | Select All   |
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User validates the toast message
      |Limit scope updated successfully|
    And User clicks on Preview & Submit tab
    And User clicks on Limit Scope Tab in Final Preview
    And User validates the limit line
      | Calculation Type|Netting Type  | Bullion trades| Delta |Product Family |
      | DSL             |Greater L/S   | Exclude Metals|  Yes   | Cash, Vanilla Options, Volatility, Bullion, Exotic Options          |

@TC_08
Scenario: Verify that Product family added via select all checkbox is showing on 4way -copied Document preview screen for Limit Scope
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      | Document Type                | 4 way               |
      | Document Status              |Enforced             |
    And User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1     | Clients 1                                | Prime Broker 2                        |Clients 2                              |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | CITIC Capital China Partners III, L.P.   |Reiter Property Management GbR |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    Then User clicks on Next button
    Then User validates the toast message
      |Document copied successfully|
    And User waits for 3 seconds
    And User clicks on Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all Product Families should be selected for Limit Scope
    Then User will input Product family
      |Product Family|
      | Select All   |
    Then User validates all selected Products are deSelected in LimitScope

  @TC_08
  Scenario: Verify that Product family added via select all checkbox is showing on 4way-Copied preview screen for Limit Scope
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                  |
      |PB-1 Legal Entity Name        |Osttra India Services Private Limited|
      |Client-1 Legal Entity Name    |CITIC Capital China Partners III, L.P.|
      |PB-2 Legal Entity Name        |Reiter Property Management GbR|
      |Client-2 Legal Entity Name    |Osttra India Services Private Limited|
    Then User clicks on edit icon
    Then User waits for 5 seconds
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
      |Product Family|
      | Select All   |
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User validates the toast message
      |Limit scope updated successfully|
    And User clicks on Preview & Submit tab
    And User clicks on Limit Scope Tab in Final Preview
    And User validates the limit line
      | Calculation Type|Netting Type  | Bullion trades| Delta |Product Family |
      | DSL             |Greater L/S   | Exclude Metals|  Yes   | Cash, Vanilla Options, Volatility, Bullion, Exotic Options          |

@ResetData @DFCopyReset
Scenario: Deleting the DF-Copy dataset
  Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |JP MORGAN DIVERSIFIED RISK               |
     And User click on delete button
     Then User validates the Document approved message
      |Document is deleted|

  @ResetData @DFReset
  Scenario: Verify that data is Reset for DF limit scope
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |Diocese of Innsbruck                            |
    And user clicks on Document Edit icon
    And User waits for 5 seconds
    And User clicks on Limit Scope
    Then User deletes the all the limit lines
    And User validates No Lines are there

  @ResetData @DFReset
  Scenario: Verify that data is Reset for DF limit scope
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                    |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name       |Diocese of Innsbruck                            |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

  @ResetData @4WayReset
  Scenario: Verify that data is Reset for 4way limit scope
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.      |
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.      |
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Limit Scope
    Then User deletes the all the limit lines
    And User validates No Lines are there
    Then User clicks on Next button

  @ResetData @4WayCopyReset
  Scenario: Verify that data is Reset for 4way limit scope
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                  |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                    |
      |Client-1 Legal Entity Name    |CITIC Capital China Partners III, L.P. |
      |PB-2 Legal Entity Name        |Reiter Property Management GbR  |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|