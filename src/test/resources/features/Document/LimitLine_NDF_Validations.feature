@LimitLine_NDF_Validations @Regression
@US=DMGS-7181

Feature: Validate Exclude NDF Clear Trades Checkbox for EDN

  @TC_01 @TC_02 @TC_03 @TC_05 @TC_06 @TC_07
  Scenario: Verify exclusion option is correctly enabled when limit scope include 'Cash' products and also validates on View as PDF screen.
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 8156005B759FA9AD8345                 |
      | clientLeiId | 549300ZLVED0VPNQPO73                 |
    Given User will go to Document screen
    Then User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name       |
      | Document Status              |
    Then User clicks on Column Selection button
    Then User clears all listing column filters
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | BONETTI GIORDANO                      |
      | Client 1       | 3G Fund, L.P.                         |
    Then User clicks on Next button
    And User waits for 5 seconds
    And User clicks on Limit Scope
    And Verify NDF Cleared Trades checkbox is visible
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      |10000|
    Then User checks the NDF Cleared Trades checkbox
    Then User validates the pop-up message
      |To exclude FX NDF cleared utilization from credit lines, please register for the enablement of the TradeServ to CreditLink connectivity flow|
    Then User clicks on Next button
    Then User validates the toast message
      |Limit scope updated successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    And Verify NDF Cleared Trades checkbox is set to True in EDN Preview
    Then User clicks on view as PDF button
    And Verify NDF Cleared Trades checkbox is set to true for View as PDF
    And User clicks on close button

  @TC_04 @TC_06 @TC_07
  Scenario: Verify exclusion option is correctly disabled when limit scope doesn't include 'Cash' products and also validates on View as PDF screen.
    Given User resets DN document
      | docTypeId   |2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |8156005B759FA9AD8345                 |
      | clientLeiId |549300ZLVED0VPNQPO73                 |
    Given User is on the all document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | BONETTI GIORDANO                      |
      | Client 1       | 3G Fund, L.P.                         |
    Then User clicks on Next button
    And User waits for 5 seconds
    And User clicks on Limit Scope
    And Verify NDF Cleared Trades checkbox is visible
    Then User enable the Limit line where Cash is not present
    And Verify NDF Cleared Trades checkbox is disabled
    Then User clicks on limit line edit icon and enters value
      |100|
    Then User clicks on Next button
    Then User validates the toast message
      |Limit scope updated successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    And Verify NDF Cleared Trades checkbox is set to False
    Then User clicks on view as PDF button
    And Verify NDF Cleared Trades checkbox is set to False for View as PDF
    And User clicks on close button
    Given User will go to Document screen
    Then User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name       |
    And User clears all listing column filters
    Then User waits for 5 seconds
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |BONETTI GIORDANO    |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User deletes the document if it exists
    Then User validates the pop-up message
      |Document is deleted|

  @TC-08 @TC-13 @TC-14
  Scenario: Verify that user is able to filter out DN’s by NDF trades using the query builder filter
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value                  |condition|
      |Exclude NDF Cleared Trades  |=       |True                   |AND      |
      |Document Type               |=       |DN                     |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User clicks on document version ID on Dashboard
    And Verify NDF Cleared Trades checkbox is set to True in EDN Preview
    Then User clicks on cross icon
    And User waits for 3 seconds
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value                  |condition|
      |Exclude NDF Cleared Trades  |=       |False                  |AND      |
      |Document Type               |=       |DN                     |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User clicks on document version ID on Dashboard
    And Verify NDF Cleared Trades checkbox is set to False
    Then User clicks on cross icon

  @TC_11
  Scenario: Verify that user validates NDF trades are included across credit limits when creating DN using copy functionality
    Given User resets DN document
      | docTypeId   |2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |8156005B759FA9AD8345                 |
      | clientLeiId |724500WVLWTWJCP7Q082                 |
    And User resets DN document
      | docTypeId   |2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |8156005B759FA9AD8345                 |
      | clientLeiId |549300ZLVED0VPNQPO73                 |
    Given User is on the all document screen
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name       |
    And User clears all listing column filters
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | BONETTI GIORDANO                      |
      | Client 1       | 3G Fund, L.P.                         |
    Then User clicks on Next button
    And User waits for 5 seconds
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion        | Bullion Vanilla Options|
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User waits for 5 seconds
    Then  User clicks on Limit Scope
    Then User enable the Limit line and validate the same
    Then User checks the NDF Cleared Trades checkbox
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User waits for 5 seconds
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value                  |condition|
      |Exclude NDF Cleared Trades  |=       |True                   |AND      |
      |Document Type               |=       |DN                     |AND      |
      |Document Status             |=       |Enforced               |AND      |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 legal entity name  |=       |3G Fund, L.P.      |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Client 1         |AmstelVisie B.V.  |
    Then User clicks on Next button
    Then User validates the toast message
      |Document copied successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    And Verify NDF Cleared Trades checkbox is set to True in EDN Preview
    Then User clicks on view as PDF button
    And Verify NDF Cleared Trades checkbox is set to true for View as PDF

@ResetData @TC_11
 Scenario: Deleting the above created DN using copy functionality - NDF trades are included
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |True         |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Draft        |AND      |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 Legal Entity Name  |=       |AmstelVisie B.V.  |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User deletes the document if it exists
    Then User validates the pop-up message
    |Document is deleted|

  @TC_09
  Scenario: Verify that user validates NDF trades values across credit limits when comparing DN - Included
    Given User is on the all document screen
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name       |
    And User clears all listing column filters
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |True         |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Enforced     |AND     |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 legal entity name  |=       |3G Fund, L.P.      |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Client 1         |AmstelVisie B.V.  |
    Then User clicks on Next button
    Then User validates the toast message
      |Document copied successfully|
    Then User is on the all document screen
    And User clears all listing column filters
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |True         |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Draft        |AND      |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 Legal Entity Name  |=       |AmstelVisie B.V. |null     |
    Then User clicks on Apply
    Then User waits for 3 seconds
    Then User clicks on compare button icon
    Then User validates text is visible
      |Text                       |
      |Version Compare            |
      |Exclude NDF Cleared Trades:|
      |True                       |

  @ResetData
  Scenario: Deleting the above DN created for validating NDF trades values across credit limits when comparing DN - Included
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |True         |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Draft        |AND      |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 Legal Entity Name  |=       |AmstelVisie B.V.  |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User deletes the document if it exists
    Then User validates the pop-up message
      |Document is deleted|

  @TC_11
  Scenario: Verify that user validates NDF trades are excluded across credit limits when creating DN using copy functionality
    Given User resets DN document
      | docTypeId   |2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |8156005B759FA9AD8345                 |
      | clientLeiId |724500WVLWTWJCP7Q082                 |
    And User resets DN document
      | docTypeId   |2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |8156005B759FA9AD8345                 |
      | clientLeiId |549300ZLVED0VPNQPO73                 |
    Given User is on the all document screen
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name       |
    And User clears all listing column filters
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | BONETTI GIORDANO                     |
      | Client 1       | 3G Fund, L.P.                         |
    Then User clicks on Next button
    And User waits for 5 seconds
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion        | Bullion Vanilla Options|
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User waits for 3 seconds
    Then  User clicks on Limit Scope
    Then User enable the Limit line and validate the same
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User waits for 5 seconds
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |False        |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Enforced     |AND     |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 Legal Entity Name  |=       |3G Fund, L.P.  |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Client 1         |AmstelVisie B.V.  |
    Then User clicks on Next button
    Then User validates the toast message
      |Document copied successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    And Verify NDF Cleared Trades checkbox is set to False
    Then User clicks on view as PDF button
    And Verify NDF Cleared Trades checkbox is set to False for View as PDF
    And User clicks on close button

  @TC_09
  Scenario: Verify that user validates NDF trades values across credit limits when comparing DN - Excluded
    Given User is on the all document screen
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name       |
    And User clears all listing column filters
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |False        |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Draft        |AND      |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 Legal Entity Name  |=       |AmstelVisie B.V. |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User clicks on compare button icon
    Then User validates text is visible
      |Text                       |
      |Version Compare            |
      |Exclude NDF Cleared Trades:|
      |False                      |

  @ResetData @TC_11
  Scenario: Deleting the above created DN using copy functionality - NDF trades are excluded
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User performs multiple Add query block
      |field                       |operator|value        |condition|
      |Exclude NDF Cleared Trades  |=       |False        |AND      |
      |Document Type               |=       |DN           |AND      |
      |Document Status             |=       |Draft        |AND      |
      |PB-1 legal entity name      |=       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |AND      |
      |EB-1 legal entity name      |=       |BONETTI GIORDANO   |AND      |
      |Client-1 Legal Entity Name  |=       |AmstelVisie B.V. |null     |
    Then User clicks on Apply
    And User waits for 3 seconds
    Then User deletes the document if it exists
    Then User validates the pop-up message
      |Document is deleted|