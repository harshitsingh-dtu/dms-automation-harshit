@AuthLine_DraftEDN @Regression
@US=DMGS-6758 @US=DMGS-7848

Feature: Validate the Draft EDN Auth lines with FX cash Spot Tenor values

  @DMGS-6758 @TC-8373 @TC-8374 @TC-8375 @TC-8376 @TC-8379
    Scenario: Verify that For DN, the 'Calendar Days' tenors for FX Spot products allows to change the number of days up to the inherited calendar days limit
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 8156005B759FA9AD8345                 |
      | clientLeiId | 8156005EDFB9BDCC8583                 |
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   | OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB 1             | BONETTI GIORDANO         |
      |Client 1         | UNDICI SRL UNIPERSONALE  |
    Then User clicks on Next button
    Then User validates the message
      | Document Created |
    Then User is on the all document screen
    And user will select Column Values on Document listing screen
    |Column Name                   |value                                 |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB-1 Legal Entity Name        |BONETTI GIORDANO                      |
    |Client-1 Legal Entity Name    |UNDICI SRL UNIPERSONALE                     |
    |Document Status               |Draft                                 |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
    | Asset Class | Product Family | Product |
    | FX          | Cash           | Spot |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User validates the disabled Tenor type for Spot only
    Then User validated the Tenor values for Auth line
    |Family        |Tenor | Tenor Type    |
    |FX Cash Spot  |365   | Business Days |
    Then User validates the values in Tenor drop-down for Spot only
    Then User enter Tenor Value
    |367|
    Then User clicks on Save As Draft button
    Then User validates the message
    |Invalid value in tenor|
    Then User enter Tenor Value
    |364|
    Then User clicks on Save As Draft button
    Then User validates the message
    |Auth scope saved successfully|
    Then Clicks on DF Auth scope Expand All button
    Then User enters the Tenor Type
    | Business Days |
    Then User enter Tenor Value
      |367|
    Then User clicks on Save As Draft button
    Then User validates the message
    |Invalid value in tenor|
    Then User enter Tenor Value
    |364|
    Then User clicks on Save As Draft button
    Then User validates the message
    |Auth scope saved successfully|

    @TC-8382 @TC-8383
    Scenario: Verify that For DN, the Calendar Days/Business Days tenors for FX Spot on Preview and Edit Screen
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
    |Column Name                   |value                                 |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB-1 Legal Entity Name        |BONETTI GIORDANO                      |
    |Client-1 Legal Entity Name    |UNDICI SRL UNIPERSONALE               |
    |Document Status               |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AED, BHD      | Spot-only             |
    |FX Cash Spot     | CAD, CHF      | 364 Business Days     |
    And User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AED, BHD      | Spot-only             |
    |FX Cash Spot     | CAD, CHF      | 364 Business Days     |

    @TC-8382 @TC-8383 @TC-8386 @TC-8387 @TC-8384
    Scenario: Verify that For DN, the Calendar Days/Business Days tenors for FX Spot on Dashboard Preview and compare Screen
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
    |Column Name                   |value                                 |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB-1 Legal Entity Name        |BONETTI GIORDANO                      |
    |Client-1 Legal Entity Name    |UNDICI SRL UNIPERSONALE               |
    |Document Status               |Draft                                 |
    And User clicks on document version ID on Dashboard
    And User validates Auth Scope Data in view as PDF
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AED, BHD      | Spot-only             |
    |FX Cash Spot     | CAD, CHF      | 364 Business Days     |
    Then User clicks on close button
    Then User clicks on compare button icon
    And User validates Auth Scope Data in view as PDF
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AED, BHD      | Spot-only             |
    |FX Cash Spot     | CAD, CHF      | 364 Business Days     |

      #Bug: DMGS-10284
    @TC-8389 @TC-8390 @TC-8391
    Scenario: Verify that For DN, Calendar Days/Business Days tenors for FX Spot in query filters
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
    |field                       |operator|value           |condition|
    |PB-1 Legal Entity Name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED |AND|
    |EB-1 Legal Entity Name      |=       |BONETTI GIORDANO   |AND      |
    |Client-1 Legal Entity Name  |=       |UNDICI SRL UNIPERSONALE  |AND|
    |Document Type               |=       |DN                 |AND      |
    |Tenor                       |=       |Spot-only          |null      |
#Bug: DMGS-10284    |Tenor                       |=       |Business Days      |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    And User clicks on document version ID on Dashboard
    And User validates Auth Scope Data in view as PDF
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AED, BHD      | Spot-only             |
    |FX Cash Spot     | CAD, CHF      | 364 Business Days     |

    @TC-8392
    Scenario: Verify that For DN, Calendar Days/Business Days tenors for FX Spot in advance filters
    Given User is on the all document screen
    And User will click on Apply More Filters
    And User will be redirected to Advance Filters Screen
    Then User enters Auth Scope values in Advance filters
    |Product Family|Product    |Tenor Value|Tenor         |
    |Cash          |Spot       |364        |Business Days |
    Then User clicks on Preview of DF
    And User validates Auth Scope Data in view as PDF
    |Product          |Currencies     | Tenor                 |
    |FX Cash Spot     | AED, BHD      | Spot-only             |
    |FX Cash Spot     | CAD, CHF      | 364 Business Days     |

    @ResettingData @DMGS-6758
    Scenario: Resetting the data
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
    |Column Name                   |value                                 |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB-1 Legal Entity Name        |BONETTI GIORDANO                      |
    |Client-1 Legal Entity Name    |UNDICI SRL UNIPERSONALE               |
    |Document Status               |Draft                                 |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User deletes all the auth Lines if available
    Then User clicks on Save As Draft button
    And User validates No Lines are there

  @DMGS-7484 @TC=10 @TC=04
  Scenario: Verify Product Group Selection is not available for EDN
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |BONETTI GIORDANO                      |
      |Client-1 Legal Entity Name    |UNDICI SRL UNIPERSONALE               |
      |Document Status               |Draft                                 |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    And User Validates Product group dropdown should not be there