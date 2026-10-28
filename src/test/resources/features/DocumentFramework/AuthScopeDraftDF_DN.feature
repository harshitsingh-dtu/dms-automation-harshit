@AuthScopeDraftDF @Regression
@US=DMGS-6327

Feature: Validate SelectAll functionality for authorisation scope in DF/DN/4Way (Uses MR @DraftDF)

@DMGS-6327 @TC_01 @TC_09 @TC_12
Scenario: Verify select all is available in Product Family options for authorisation scope for a DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                    |
      |PB Name          |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name          |ABC ARBITRAGE                            |
      |Lifecycle status |Approved                                 |
    And user clicks on Document Edit icon
  And User will select acting as LEIs for edit
    | Acting as            |
    | OSTTRA INDIA SERVICES PRIVATE LIMITED |
  And User will select action type for edit
    | Action type |
    |Edit Document Framework|
  And User will click on Submit Button
  And User clicks on Auth Scope Tab
  Then Clicks on DF Auth scope Expand All button
  Then User deletes all the auth Lines if available
    Then User clicks select All in Auth Scope Product Family
      | Asset Class | Product Family | Product       |
      | FX          | Select All     | Variance Swap |
    Then User validates all Product Families should be selected
    Then User DeSelects all Products in AuthScope and validate
    Then User clicks select All in Auth Scope Product Family
      | Asset Class | Product Family | Product       |
      | FX          | Select All     | Variance Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
    And User will click on submit
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Volatility      | Variance Swap  |
      | FX          | Cash            |                |
      | FX          | Vanilla Options |                |
      | FX          | Exotic Options  |                |
    Then User clicks on Next button
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Volatility      | Variance Swap  |
      | FX          | Cash            |                |
      | FX          | Vanilla Options |                |
      | FX          | Exotic Options  |                |

  @DMGS-6327 @TC_02 @TC_08
  Scenario: Validate all available Product options per product family in a single click for DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name           |value                                    |
      |PB Name  |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name  |ABC ARBITRAGE                            |
    And user clicks on Document Edit icon
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button
    Then User deletes all the auth Lines if available
    #Then User deletes all the auth Lines
    Then User clicks select All in Auth Scope Product
      | Asset Class | Product Family        | Product       |
      | FX          | Select All            | Select All    |
    Then User validates all Products should be selected
    Then User DeSelects all Products in AuthScope and validate
    Then User clicks select All in Auth Scope Product
      | Asset Class | Product Family        | Product       |
      | FX          | Select All            | Select All    |
    And Click on + Add currencies
    And User will search for the currency and select them for DF AuthScreen
      |currency list|
      |AED|
      |CLF|
    And User will search for the Non Deliverable currency and select them
      |currency list|
      |aoa|
      |kES|
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Cash            | Future         |
      | FX          | Cash            | Forward        |
      | FX          | Vanilla Options | Vanilla Option |
      | FX          | Exotic Options  | Asian          |
      | FX          | Volatility      | Variance Swap  |
    Then User clicks on Next button
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Cash            | Future         |
      | FX          | Cash            | Forward        |
      | FX          | Vanilla Options | Vanilla Option |
      | FX          | Exotic Options  | Asian          |
      | FX          | Volatility      | Variance Swap  |


  @DMGS-6327 @TC_03 @TC_09 @TC_12
  Scenario: Verify select all is available in Product Family options for authorisation scope for a EDN
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Auth Scope Tab
    #Then Clicks on DF Auth scope Expand All button
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
    Then User clicks select All in Auth Scope for Bullion Product Family
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    Then User DeSelects Bullion Product family and validate
    Then User clicks select All in Auth Scope for Bullion Product Family
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product                  |
      | FX          | Bullion         | Bullion Vanilla Options  |
    And User enables all Auth Lines
    Then User clicks on Next Button on Auth Scope
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product                  |
      | FX          | Bullion         | Bullion Vanilla Options  |


  @DMGS-6327 @TC_04 @TC_08
  Scenario: Validate all available Product options in a single click for EDN
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Auth Scope Tab
    #Then User deletes all the auth Lines
    Then User deletes all the auth Lines if available
    Then User clicks select All in Auth Scope for Bullion Product
      | Asset Class | Product Family | Product       |
      | FX          | Bullion        | Select All    |
    Then User validates all Bullion Product should be selected
    Then User DeSelects Bullion Product family and validate
    Then User clicks select All in Auth Scope for Bullion Product
      | Asset Class | Product Family | Product       |
      | FX          | Bullion        | Select All    |
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product                  |
      | FX          | Bullion         | Bullion Vanilla Options  |
      | FX          | Bullion         | Bullion Exotic Options   |
      | FX          | Bullion         | Bullion Spot or Forward  |
    And User enables all Auth Lines
    Then User clicks on Next button
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product                  |
      | FX          | Bullion         | Bullion Vanilla Options  |
      | FX          | Bullion         | Bullion Exotic Options   |
      | FX          | Bullion         | Bullion Spot or Forward  |

@ResettingData
Scenario: Removing added lines from EDN
  Given User is on the all document screen
  And user will select Column Values on Document listing screen
    |Column Name                   |value                |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    |EB-1 Legal Entity Name        |CITIGROUP INC.       |
    |Client-1 Legal Entity Name    |CITIGROUP INC.       |
    |Document Status               |Draft               |
  Then User clicks on edit icon
  Then User waits for 5 seconds
  And User clicks on Auth Scope Tab
  Then Clicks on DF Auth scope Expand All button
  Then User deletes all the auth Lines if available
  Then User clicks on Save As Draft button
  And User validates the message
    |Auth scope saved successfully|
  And User validates No Lines are there

  @ResettingData
  Scenario: Removing added lines from DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name           |value                                    |
      |PB Name  |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name  |ABC ARBITRAGE                            |
    And user clicks on Document Edit icon
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button
    Then User deletes all the auth Lines if available
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|
    And User validates No Lines are there

  @DMGS-7478 @TC=01 @TC=07
  Scenario: Verify the Product group merging logic for Auth line - DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name           |value                                    |
      |PB Name  |OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB Name  |ABC ARBITRAGE                            |
    And user clicks on Document Edit icon
    And User clicks on Auth Scope Tab
    * User will select all the visible Auth Product Groups
      | Auth Product Group     |
      | Test_Automation_7478   |
#    And User adds Currencies
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
    And User will submit the changes
    And User clicks on Add Auth Line
    Then User validates the following attributes for Auth Line "FX Vanilla Options Vanilla Option"
      | Column Name     | Selected Attribute           | Non-Selected Attribute |
      | Settlement Type | Deliverable, Non Deliverable |                         |
      | Exercise Style  |                               |                         |
      | Contract Type   |                               | Call, Put               |
    Then User validates the following attributes for Auth Line "FX Exotic Options One Touch"
      | Column Name     | Selected Attribute                        | Non-Selected Attribute      |
      | Exercise Style  |                                            | American                    |
      | Touch Direction | Up, Down                                   |                              |
      | Contract Type   | Call                                       | Put                          |
      | Payout Timing   |                                            | Instant, Settlement         |
      | Payout Currency |                                            | Term, Base                  |
      | Barrier Type    | No Barrier, Knock-Out, Reverse-Knock-Out  | Knock-In, Reverse-Knock-In  |

    Then User validates the following attributes for Auth Line "FX Exotic Options Single Barrier Digital"
      | Column Name     | Selected Attribute | Non-Selected Attribute |
      | Exercise Style  |                     | European                |
      | Touch Direction |                     | Up, Down                        |
      | Contract Type   |                     | Call, Put                     |
      | Barrier Style   |                     | American, European                      |

  @DMGS-10353 @TC_01 @AuthScopeTemplate
  Scenario: AC1 & AC4 - Create, save, and submit an authorisation scope template
    Given User navigates to Authorisation scope templates listing screen
    Then User validates Authorisation scope templates listing screen elements
      | Heading                       | Sub heading                               |
      | Authorisation scope templates | Showing all authorisation scope templates |
    When User clicks on Create Template button
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    When User enters template name on create screen
      | Template Name |
      | Test Create   |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product        |
      | FX          | Exotic Options | Single Barrier |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AOA           |
      | ARS           |
      | AUD           |
      | BBD           |
    And User will click on submit
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family | Product        |
      | FX          | Exotic Options | Single Barrier |
    And User selects attributes for "FX Exotic Options Single Barrier" on template screen
      | Settlement Type |
      | Deliverable     |
    Then User clicks on Submit button
    And User validates the message
      | Template saved successfully |
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create   |
    Then User validates template record in Authorisation scope templates table
      | Template Name | Status    |
      | Test Create   | Published |

  @DMGS-10353 @TC_02 @AuthScopeTemplate
  Scenario: AC2 & AC4 - Edit and save as draft an existing authorisation scope template
    Given User navigates to Authorisation scope templates listing screen
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create   |
    And User clicks on Edit icon for template in Action column
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | XAG           |
      | XAU           |
      | XPD           |
    And User will click on submit
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    When User clicks on Save As Draft button
    And User validates the message
      | Template saved successfully |
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create   |
    Then User validates template record in Authorisation scope templates table
      | Template Name | Status |
      | Test Create   | Draft  |

  @DMGS-10353 @TC_03 @AuthScopeTemplate
  Scenario: AC3 - Delete an authorisation scope template
    Given User navigates to Authorisation scope templates listing screen
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create   |
    And User clicks on Delete icon for template in Action column
    And User confirms deletion on popup
    Then User validates the message
      | Template deleted successfully |
    And User validates template status is updated or removed
      | Template Name | Status  |
      | Test Create   | Deleted |

  @DMGS-10353 @TC_04 @AuthScopeTemplate
  Scenario: AC5 - Verify user is not able to add authorisation lines with optional tenors in a template
    Given User navigates to Authorisation scope templates listing screen
    When User clicks on Create Template button
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    When User enters template name on create screen
      | Template Name    |
      | FX_No_Tenor_Temp |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product        |
      | FX          | Exotic Options | Single Barrier |
    Then User validates optional tenor toggle is not present on template screen
    And User validates only non-optional tenor fields are displayed on template line
      | Tenor Value | Tenor Unit    |
      | 10          | Calendar Days |
    When User attempts to add authorisation line with optional tenor
      | Tenor Type |
      | Optional   |
    Then User validates error message for invalid tenor
      | Authorisation lines with optional tenors cannot be added to a template |
    And User validates Auth line with optional tenor is not added
