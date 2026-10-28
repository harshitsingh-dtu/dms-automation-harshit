@AuthLine_DraftEDN @Regression
@US=DMGS-6758

Feature: Validate the Draft 4Way Auth lines with FX cash Spot Tenor values

  @DMGS-6758 @TC-8392 @TC-8378 @TC-8382 @TC-8381 @TC-8392 @DMGS-9333 @TC_04
  Scenario: Verify that For 4Way, the 'Calendar Days' tenors for FX Spot products allows to change the number of days up to the inherited calendar days limit
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 6SHGI4ZSSLCXXQSBB395                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 8156005B759FA9AD8345                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 549300ZLVED0VPNQPO73                 |
      | client2OrgTypeKey | 3                                    |
    Given User is on the all document screen
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | PB-2 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Client-2 Legal Entity Name |
      | Document Status            |
    Then User clears all listing column filters
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type   | Acting As |
      | 4 Way            | PB        |
    And User select the LEIs
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name    |BONETTI GIORDANO       |
      |PB-2 Legal Entity Name        |CITIGROUP INC.         |
      |Client-2 Legal Entity Name    |3G Fund, L.P.          |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Spot    |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
      |BWP|
    And User will submit the changes
    Then User will select tenor in Auth Tenor
      | Auth Tenor         |
      | Calendar Days      |
    Then User will input Auth Tenor value
      | Auth Value |
      | 100        |
    And User clicks on Add Auth Line
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|
    Then Clicks on ExpandAll button
    Then User clicks on copy icon for lines to be copied
    Then User edit currency for the copied line
    Then User is able to deselect currencies
      |currency list|
      |AED|
      |BWP|
    And User will search for the currency and select them
      |currency list|
      |AUD|
      |CAD|
    And User will submit the changes
    Then User enters the Tenor Type
      | Up-to-spot |
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
      |Product          |Currencies     | Tenor                 |
      |FX Cash Spot     | AUD, CAD      | Up-to-spot            |
      |FX Cash Spot     | AED, BWP      | 100 Calendar Days     |
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      |Product          |Currencies     | Tenor                 |
      |FX Cash Spot     | AUD, CAD      | Up-to-spot            |
      |FX Cash Spot     | AED, BWP      | 100 Calendar Days     |

    @TC-8382 @TC-8383 @TC-8386 @TC-8387
    Scenario: Verify that For 4Way, the Calendar Days/Business Days tenors for FX Spot on Dashboard Preview and compare Screen
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name    |BONETTI GIORDANO       |
      |PB-2 Legal Entity Name        |CITIGROUP INC.         |
      |Client-2 Legal Entity Name    |3G Fund, L.P.          |
      |Document Status               |Draft                  |
    And User clicks on document version ID on Dashboard
    And User validates Auth Scope Data in view as PDF
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AUD, CAD      | Up-to-spot            |
    |FX Cash Spot     | AED, BWP      | 100 Calendar Days     |
    Then User clicks on close button
    Then User clicks on compare button icon
    And User validates Auth Scope Data in view as PDF
      |Product          |Currencies     | Tenor                 |
      |FX Cash Spot     | AUD, CAD      | Up-to-spot            |
      |FX Cash Spot     | AED, BWP      | 100 Calendar Days     |

#    Bug: DMGS-10284
    @TC-8389 @TC-8390 @TC-8391
    Scenario: Verify that For 4Way, Calendar Days/Business Days tenors for FX Spot in query filters
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
    |field                       |operator|value                                  |condition|
    |PB-1 Legal Entity Name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED  |AND      |
    |Client-1 Legal Entity Name  |=       |BONETTI GIORDANO                       |AND      |
    |PB-2 Legal Entity Name      |=       |CITIGROUP INC.                         |AND      |
    |Client-2 Legal Entity Name  |=       |3G Fund, L.P.                          |AND      |
    |Document Type               |=       |4 Way                                  |AND      |
    |Tenor                       |=       |Calendar Days                          |null     |
#Bug: DMGS-10284    |Tenor                       |=       |Up-to-spot                             |null      |
    Then User clicks on Apply
    And User waits for 3 seconds
    And User clicks on document version ID on Dashboard
    And User validates Auth Scope Data in view as PDF
      |Product          |Currencies     | Tenor                 |
      |FX Cash Spot     | AUD, CAD      | Up-to-spot            |
      |FX Cash Spot     | AED, BWP      | 100 Calendar Days     |

    @TC-8392 @AdvanceFiltersTest
    Scenario: Verify that For DN, Calendar Days/Business Days tenors for FX Spot in advance filters
    Given User is on the all document screen
    And User will click on Apply More Filters
    And User will be redirected to Advance Filters Screen
    Then User enters Auth Scope values in Advance filters
    |Product Family|Product    |Tenor Value|Tenor         |
    |Cash          |Spot       |100        |Calendar Days |
    And user will select Column Values on Document listing screen
        |Column Name                   |value                |
        |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
        |Client-1 Legal Entity Name    |BONETTI GIORDANO       |
        |PB-2 Legal Entity Name        |CITIGROUP INC.         |
        |Client-2 Legal Entity Name    |3G Fund, L.P.          |
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF
      |Product          |Currencies     | Tenor                 |
      |FX Cash Spot     | AUD, CAD      | Up-to-spot            |
      |FX Cash Spot     | AED, BWP      | 100 Calendar Days     |

  @DMGS-7478 @TC=02 @TC=03 @TC=06 @TC=09 @MergeLogic4Way
  Scenario: Verify the Product group merging logic for Auth line - 4Way
    Given User is on the all document screen
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | PB-2 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Client-2 Legal Entity Name |
      | Document Status            |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name    |BONETTI GIORDANO       |
      |PB-2 Legal Entity Name        |CITIGROUP INC.         |
      |Client-2 Legal Entity Name    |3G Fund, L.P.          |
      |Document Status               |Draft                  |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User deletes all the auth Lines if available
    And User will select all the visible Auth Product Groups
      | Auth Product Group     |
      | Test_Automation_4Way   |
    And User adds Currencies
    And User will input Auth Tenor value
      | Auth Value |
      | 3          |
    And User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User waits for 2 seconds
    Then Clicks on CollapseAll button
    Then User clicks on Expand Icon for parent "FX Vanilla Options" for 4Way
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option" for 4Way
    And User validates the below attribute is selected
      |Attributes     |
      |Deliverable    |
    And User validates the below attribute is NOT selected
      |Attributes     |
      |American       |
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option" for 4Way
    Then User clicks on Expand Icon for parent "FX Exotic Options" for 4Way
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital" for 4Way
    And User validates the below attribute is NOT selected
      |Attributes     |
      |Up             |
      |Down           |
      |American       |
      |European       |
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital" for 4Way
    Then User clicks on Expand Icon for "FX Exotic Options One touch" for 4Way
    And User validates the below attribute is selected
      |Attributes         |
      |Up                 |
      |Down               |
      |Call               |
      |Put                |
      |No Barrier         |
      |Knock-Out          |
      |Reverse-Knock-Out  |

  @DMGS-7478 @TC=02 @TC=03 @TC=06 @TC=09
  Scenario: Verify the Product group's selection limit
    Given User is on the all document screen
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | PB-2 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Client-2 Legal Entity Name |
      | Document Status            |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name    |BONETTI GIORDANO       |
      |PB-2 Legal Entity Name        |CITIGROUP INC.         |
      |Client-2 Legal Entity Name    |3G Fund, L.P.          |
      |Document Status               |Draft                  |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User validates the Product group selection limit
    Then User waits for 2 seconds
    Then User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 6SHGI4ZSSLCXXQSBB395                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 8156005B759FA9AD8345                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 549300ZLVED0VPNQPO73                 |
      | client2OrgTypeKey | 3                                    |