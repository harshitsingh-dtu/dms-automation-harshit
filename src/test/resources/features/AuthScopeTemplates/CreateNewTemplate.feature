@AuthScopeTemplates @Regression
@US=DMGS-10353

Feature: Create, Edit, Save, and Delete Authorisation Scope Templates

  Background:
    Given User navigates to screen "Authorisation scope templates" under menu "Groups & templates"
    Then User verifies the screen header is "Authorisation scope templates"
    And User validates Authorisation scope templates listing screen elements
      | Heading                       | Sub heading                               |
      | Authorisation scope templates | Showing all authorisation scope templates |

  @DMGS-10353 @TC_01 @AuthScopeTemplate
  Scenario: AC1 & AC4 - Create, save, and submit an authorisation scope template
    When User clicks on Create Template button
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    When User enters template name on create screen
      | Template Name |
      | Test Create7   |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product                 |
      | FX          | Exotic Options | Single Barrier Digital  |
    And Click on + Add currencies on template screen
    And User searches and selects currencies on template screen
      | currency list |
      | AOA           |
      | ARS           |
      | AUD           |
      | BBD           |
    And User clicks on Add Auth Line on template screen
    And User selects attributes for "FX Exotic Options Single Barrier Digital" on template screen
      | Exercise Style | Touch Direction | Contract Type | Barrier Style | Barrier Type |
      | European       | Up              | Call          | European      | Up-and-In    |
    And User enters Tenor details for authorisation line on template screen
      | Tenor Value | Tenor Unit    |
      | 10          | Calendar Days |
    Then User clicks on Submit button
    And User validates the message
      | Auth scope template saved successfully |
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7   |
    Then User validates template record in Authorisation scope templates table
      | Template Name | Status    |
      | Test Create7   | Published |

  @DMGS-10353 @TC_02 @AuthScopeTemplate
  Scenario: AC2 & AC4 - Edit and save as draft an existing authorisation scope template
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7   |
    And User clicks on Edit icon for template in Action column
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    And Click on + Add currencies on template screen
    And User searches and selects currencies on template screen
      | currency list |
      | XAG           |
      | XAU           |
      | XPD           |
    And User clicks on Add Auth Line on template screen
    And User enters Tenor details for authorisation line on template screen
      | Tenor Value | Tenor Unit    |
      | 5           | Months        |
    And User disables the active status toggle button beside Save As Draft
    When User clicks on Save As Draft button
    And User validates the message
      | Auth scope template updated successfully |
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7   |
    Then User validates template record in Authorisation scope templates table
      | Template Name | Status |
      | Test Create7   | Draft  |

  @DMGS-10353 @TC_03 @AuthScopeTemplate
  Scenario: AC3 - Delete an authorisation scope template
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7   |
    And User clicks on Delete icon for template in Action column
    And User confirms deletion on popup
    Then User validates the message
      | Authorisation Scope Template deleted successfully. |
    And User validates template status is updated or removed
      | Template Name | Status  |
      | Test Create7   | Deleted |

  @DMGS-10353 @TC_04 @AuthScopeTemplate
  Scenario: AC5 - Verify user is not able to add authorisation lines with optional tenors in a template
    When User clicks on Create Template button
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    When User enters template name on create screen
      | Template Name    |
      | FX_No_Tenor_Temp |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product                 |
      | FX          | Exotic Options | Single Barrier Digital  |
    And Click on + Add currencies on template screen
    And User searches and selects currencies on template screen
      | currency list |
      | AOA           |
      | ARS           |
      | AUD           |
      | BBD           |
    And User clicks on Add Auth Line on template screen
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

  @DMGS-10353 @TC_05 @AuthScopeTemplate @AuditHistory
  Scenario: Full Audit History - Verify what, when, how and who changed template contents in reverse chronological order
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7   |
    And User clicks on Audit icon for template in Action column
    Then User validates Authorisation scope template audit history screen is displayed
    And User validates the audit history details for template
      | Template Name | Audit Event               | Updated By               | Event Changes     |
      | Test Create7   | Update Auth Scope Template| automation.adminosttra05@yopmail.com | Auth Scope update |
    And User verifies audit events are ordered in reverse chronological order

  @DMGS-10353 @TC_06 @AuthScopeTemplate @ExtractCSV
  Scenario: Extract Template - Download extract for authorisation scope template in CSV file format with fixed columns
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7  |
    Then User clicks on Download extract icon for template in Action column