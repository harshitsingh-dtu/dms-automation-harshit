@DF_DNIntegration @Regression
 @GeneralTerms_and_EnforcedEDN
@US=DMGS-3326 @US=DMGS-3303

Feature: Impact on In-Approval/Enforced EDN when DF changes

@TC=6855
Scenario: User updates the Generic Terms dates in DF & approves it
  Given User is on Document Framework Page
  And user will select Column Values on Document Framework screen
    |Column Name         |value                                 |
    |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
    |Lifecycle status    |Approved                              |
  Then User clicks on edit icon
  And User will click on Submit Button
  And User clicks on General Terms Tab
  And User update the General Terms dates with Current date
    | Date                      |
    | Master Agreement ISDA     |
    | Master Agreement Give-up  |
    | EMTA                      |
  And User clicks on Save As Draft button
  Then User validates the message
    |General terms saved successfully|
  And User clicks on Preview & Submit tab
  Then User Final Preview & Submit the Document
  And User clicks on Submit for Scope Change Preview
  And User validates the DF on listing screen

  @TC=6855 @TC=7118 @TC=7122
  Scenario: User validates that General Terms date is updated silently in an In-Approval EDN
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                   |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
      |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED          |
      |Client-1 Legal Entity Name    |ACE URBAN RACE PRIVATE LIMITED          |
      |Document Status               |In-approval                             |
    Then User clicks on document version ID on Dashboard
    Then User validates the Date values for General Terms in Document Preview on Dashboard
      | Date                      | Value           |
      | Master Agreement ISDA     |Current Date     |
      | Master Agreement Give-Up  |Current Date     |

  @TC=6856 @TC=7118
  Scenario: User updates the Generic Terms dates in another DF & approves it
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |CITIGROUP INC.                        |
      |Lifecycle status    |Approved                              |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will click on Submit Button
    And User clicks on General Terms Tab
    And User update the General Terms dates with Current date
      | Date                      |
      | Master Agreement ISDA     |
      | Master Agreement Give-up  |
      | EMTA                      |
    And User clicks on Save As Draft button
    Then User validates the message
      |General terms saved successfully|
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User clicks on Submit for Scope Change Preview
    And User validates the DF on listing screen

  @TC=6856 @TC=7118 @TC=7122
#    Failing due to DMGS-5902
  Scenario: User validates that General Terms date is updated silently in an Enforced EDN
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                  |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB-1 Legal Entity Name        |CITIGROUP INC.                         |
      |Client-1 Legal Entity Name    |3G Fund, L.P.                          |
      |Document Status               |Enforced                               |
    Then User clicks on document version ID on Dashboard
    Then User validates the Date values for General Terms in Document Preview on Dashboard
      | Date                      | Value           |
      | Master Agreement ISDA     |Current Date     |
      | Master Agreement Give-Up  |Current Date     |