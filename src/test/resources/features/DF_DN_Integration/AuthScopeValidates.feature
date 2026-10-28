@AuthScopeValidates @DF_DNIntegration @Regression

@US=DMGS-3207 @US=DMGS-3303 @US=DMGS-3213 @US=DMGS-3806

Feature: Edit/Copy/Delete Auth Lines in an EDN

@TC=6861 @TC=6862 @TC=6863
  Scenario: Validate that User is able to copy/delete the Auth Line in EDN
    Given User is on the all document screen
    Then User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 8156005B759FA9AD8345                 |
      | clientLeiId | 549300ZLVED0VPNQPO73                 |
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   | OSTTRA INDIA SERVICES PRIVATE LIMITED    |
      |EB 1             | BONETTI GIORDANO         |
      |Client 1         | 3G Fund, L.P.            |
    Then User clicks on Next button
    Then User validates the toast message
      | Document Created |
    Then User clicks on Auth Scope Tab
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion        | Bullion Vanilla Options|
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on copy icon for lines to be copied
    Then User validates Auth line is copied and disabled
    Then User enables all Auth Lines
    Then User clicks on Save As Draft button
    Then User validates the message
      |Duplicate authorization lines exist for Bullion: Bullion Vanilla Options, Bullion: Bullion Vanilla Options products with the same currency|
    Then User deletes the copied line and validate the same

#Bug ID DMGS-8838
@TC=6864 @TC=6865 @TC=6869 @TC=6989 @TC=6988 @TC=6977 @TC=7284 @TC=7026 @TC=7033
  Scenario: Validate that User is able to edit the copied Auth Line in EDN
    Given User is on the all document screen
    Then User clicks on Column Selection button
   Then User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name                  |
    | PB-1 Legal Entity Name       |
    | Client-1 Legal Entity Name   |
    | EB-1 Legal Entity Name       |
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |BONETTI GIORDANO       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Vanilla Options | Vanilla Option|
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on copy icon for lines to be copied
    Then User waits for 5 seconds
    Then User click on edit icon of currency for the Auth line
    Then User waits for 5 seconds
    And User validates the Deliverable, Non-Deliverable are displayed
    And User will remove the currency after searching them
      |remove currency list|
      |AED|
      |CLF|
    And User will submit the changes
    Then User enables all Auth Lines
    Then User edit currency for the copied line
    And User will remove the currency after searching them
      |remove currency list|
      |COP|
      |CRC|
    And User will submit the changes
    Then User clicks on Save As Draft button
    Then User validates the message
      |Duplicate authorization lines exist for Vanilla Options: Vanilla Option, Vanilla Options: Vanilla Option products with the same currency|
    Then User waits for 5 seconds
    Then User deletes all the auth Lines
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then User validates text is visible
      |Auth Scope is required|

  @TC=6978 @TC=6980 @TC=6981
  Scenario: Validate that User validates the Deliverable & Non-Deliverable messages
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |BONETTI GIORDANO       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Vanilla Options | Vanilla Option  |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User waits for 5 seconds
    Then User selects the Settlement type
      |Non Deliverable|
    Then User clicks on Save As Draft button
    Then User validates the message
      |There is a mismatch in settlement type and selected currencies in product group.|
    Then User selects the Settlement type
      |Non Deliverable|
    Then User selects the Settlement type
      |Deliverable|
    Then User waits for 5 seconds
    Then User clicks on Save As Draft button
    Then User validates the message
      |There is a mismatch in settlement type and selected currencies in product group.|
    Then User waits for 5 seconds
    Then User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |BONETTI GIORDANO       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User deletes the document if it exists
    Then User validates the toast message
      |Document is deleted|
