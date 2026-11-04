@AuthScopeTemplates @ExtractCSV @Regression
@US=DMGS-10373

Feature: Download and Extract Authorisation Scope Template to CSV Format

  Background:
    Given User navigates to screen "Authorisation scope templates" under menu "Groups & templates"
    Then User verifies the screen header is "Authorisation scope templates"
    And User validates Authorisation scope templates listing screen elements
      | Heading                       | Sub heading                               |
      | Authorisation scope templates | Showing all authorisation scope templates |

  @DMGS-10373 @TC_DWN_001 @TC_DWN_002 @TC_DWN_003 @TC_DWN_006
  Scenario: TC_DWN_001_002_003_006 - Verify CSV extract download with dynamic file naming, 7-column ordering and mandatory tenor
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7  |
    And User clicks on Download extract icon for template in Action column
    Then User validates the downloaded CSV extract for "Test Create7" contains fixed columns in order
      | Asset Class         |
      | Product Family      |
      | Product Name        |
      | Selected Currencies |
      | Tenor Value         |
      | Tenor               |
      | Product Attributes  |

  @DMGS-10373 @TC_DWN_004 @TC_DWN_005 @TC_DWN_008
  Scenario: TC_DWN_004_005_008 - Verify exported values match configuration, grouping by family and CSV escaping
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7  |
    And User clicks on Download extract icon for template in Action column
    Then User validates the downloaded CSV extract for "Test Create7" contains fixed columns in order
      | Asset Class         |
      | Product Family      |
      | Product Name        |
      | Selected Currencies |
      | Tenor Value         |
      | Tenor               |
      | Product Attributes  |

  @DMGS-10373 @TC_DWN_007
  Scenario Outline: TC_DWN_007 - Verify CSV download across template statuses
    When User searches for the authorisation scope template
      | Template Name   |
      | <Template Name> |
    Then User validates template record in Authorisation scope templates table
      | Template Name   | Status   |
      | <Template Name> | <Status> |
    And User clicks on Download extract icon for template in Action column
    Then User validates the downloaded CSV extract for "<Template Name>" contains fixed columns in order
      | Asset Class         |
      | Product Family      |
      | Product Name        |
      | Selected Currencies |
      | Tenor Value         |
      | Tenor               |
      | Product Attributes  |

    Examples:
      | Template Name | Status    |
      | Test Create7  | Published |

  @DMGS-10373 @TC_DWN_009
  Scenario: TC_DWN_009 - Verify file naming with special characters, spaces, and hyphens
    When User clicks on Create Template button
    Then User validates Create Auth scope template screen is displayed
      | Heading             |
      | Auth scope template |
    When User enters template name on create screen
      | Template Name              |
      | Rates & FX - Scope_v1.0    |
    And User selects Asset Class, Product Family, Product on template screen
      | Asset Class | Product Family | Product                 |
      | FX          | Cash           | Future                  |
    And Click on + Add currencies on template screen
    And User searches and selects currencies on template screen
      | currency list |
      | AED           |
      | USD           |
    And User clicks on Add Auth Line on template screen
    And User enters Tenor details for authorisation line on template screen
      | Tenor Value | Tenor Unit    |
      | 1           | Years         |
    Then User clicks on Submit button
    And User validates the message
      | Auth scope template saved successfully |
    When User searches for the authorisation scope template
      | Template Name           |
      | Rates & FX - Scope_v1.0 |
    And User clicks on Download extract icon for template in Action column
    Then User validates the downloaded CSV extract for "Rates & FX - Scope_v1.0" contains fixed columns in order
      | Asset Class         |
      | Product Family      |
      | Product Name        |
      | Selected Currencies |
      | Tenor Value         |
      | Tenor               |
      | Product Attributes  |

  @DMGS-10373 @TC_DWN_010
  Scenario: TC_DWN_010 - Verify download behavior on an empty template with zero lines
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7  |
    And User clicks on Download extract icon for template in Action column
    Then User validates the downloaded CSV extract for "Test Create7" contains fixed columns in order
      | Asset Class         |
      | Product Family      |
      | Product Name        |
      | Selected Currencies |
      | Tenor Value         |
      | Tenor               |
      | Product Attributes  |

  @DMGS-10373 @TC_DWN_011
  Scenario: TC_DWN_011 - Verify download action accessibility as per user permissions
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7  |
    Then User validates template record in Authorisation scope templates table
      | Template Name | Status    |
      | Test Create7  | Published |
    And User clicks on Download extract icon for template in Action column

  @DMGS-10373 @TC_DWN_012
  Scenario: TC_DWN_012 - Verify exported CSV reconciles with agreement creation authorisation scope
    When User searches for the authorisation scope template
      | Template Name |
      | Test Create7  |
    And User clicks on Download extract icon for template in Action column
    Then User validates the downloaded CSV extract for "Test Create7" contains fixed columns in order
      | Asset Class         |
      | Product Family      |
      | Product Name        |
      | Selected Currencies |
      | Tenor Value         |
      | Tenor               |
      | Product Attributes  |
