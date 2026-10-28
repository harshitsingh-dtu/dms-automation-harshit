@DF_DNIntegration @Regression
 @Limit_AuthScope_with_In_Approval_EDN
@US=DMGS-3806 @US=DMGS-3815

Feature: Impact on EDN on addition/Deletion of new Limit/AuthLines in DF, where EDN is in In-Approval state

  @TC=7285 @TC=7049
  Scenario: User edits a DocumentFramework and expands scope of Limit scope & Auth Scope for In-approval EDN
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |Osttra India Services Private Limited |
      |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
      |Lifecycle status    |Approved                              |
    Then User clicks on edit icon
    And User will click on Submit Button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family  | Product                |
      | FX          | Exotic Options  | Single Barrier Digital |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CAD|
      |DJF|
      |CRC|
      |ISK|
    And User will submit the changes
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 999         |
    * User will select tenor in Auth Tenor
      | Auth Tenor      |
      | Business Days   |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    * User will input Calculation Type
      | Calculation Type |
      | NOP              |
    * User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    * User will input Delta
      | Delta |
      | No    |
    * User will input Product family
      | Product Family |
      | Cash           |
    Then User clicks on Add Limit button
    And User clicks on Next button
    Then User Final Preview & Submit the Document
    Then User validates Scope change Preview tab is visible
    Then User validates Auth Scope tab should be disabled in Scope Change Preview tab
    Then User clicks on Limit Scope in Scope Change Preview Tab
    Then User validates Impacted Docs button is enabled for Limit Scope

#    Failed Due to DMGS-6055
Scenario: User validates adding new Limit & Auth lines should update for In-approval EDN silently
  Given User is on Document Framework Page
  And user will select Column Values on Document Framework screen
    |Column Name         |value                                 |
    |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
    |Lifecycle status    |Approved                              |
  And User navigates to Associated Doc Count Column
  And User click on Associated Doc Count
  And User stores the Document Version IDs
  Then User clicks on close button
  And user will clear the filter for following column
    |Column Name         |
    |Lifecycle status    |
  And user will select Column Values on Document Framework screen
    |Column Name         |value                                 |
    |Lifecycle status    |Draft                                 |
  Then User clicks on edit icon
  Then User Final Preview & Submit the Document
  Then User clicks on the Impacted Limit Scope Docs button
  Then User clicks on Expand button in Scope Change Preview Tab
  Then User enabled Lines in impacted documents
  And User will input Limit Value in impacted documents
    | Limit Value |
    | 9999999999  |
  And User clicks on confirm button
  And User validates the message
    |Data saved successfully.|
  And User clicks on submit for approval button
  And User validates the message
    |Document is Approved|
  Then User clicks on All documents in side menu
  Then user searches for Document ID and validate the latest version

  Scenario: User validates newly added lines of Limit scope & Auth Scope for In-approval EDN
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                  |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED         |
      |Client-1 Legal Entity Name    |ACE URBAN RACE PRIVATE LIMITED         |
      |Document Status               |In-approval                            |
    Then User clicks on document version ID on Dashboard
    And User navigates to Auth Scope in PDF
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product                 |
      | FX          | Exotic Options  | Single Barrier Digital  |
    And User navigates to Limit Line in PDF
    And User validates the limit line
      | Calculation Type|Netting Type  | Bullion trades| Delta |Product Family |
      | NOP             |Greater L/S   | Exclude Metals|  NO   | Cash          |

@Resetdata
Scenario: User deletes an existing limit line/Auth from DF
  Given User is on Document Framework Page
  And user will select Column Values on Document Framework screen
    |Column Name         |value                                 |
    |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
    |Lifecycle status    |Approved                              |
  Then User clicks on edit icon
  And User will click on Submit Button
  Then User clicks on Auth Scope Tab
  Then User deletes the auth Lines
    | Asset Class | Product Family  | Product                 |
    | FX          | Exotic Options  | Single Barrier Digital  |
  And User clicks on Save As Draft button
  And User validates the message
    |Auth scope saved successfully|
  Then User clicks on Next button
  Then User deletes the limit Lines
    | Calculation Type|Netting Type | Bullion trades| Delta |Product Family |
    | NOP             |Greater L/S  | Exclude Metals|  NO   | Cash          |
  Then User clicks on Next button
  And User validates the message
    |Limit scope updated successfully|
  Then User Final Preview & Submit the Document
  Then User validates Scope change Preview tab is visible
  Then User validates Impacted Docs button is enabled for Limit Scope

Scenario: User validates deleting the auth/limit line should show in-approval DN under Impacted docs and in Impacted auth /limit scope docs
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
      |Lifecycle status    |Approved                              |
    And User navigates to Associated Doc Count Column
    And User click on Associated Doc Count
    And User stores the Document Version IDs and status of EDN
    Then User clicks on close button
    And user will clear the filter for following column
      |Column Name         |
      |Lifecycle status    |
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |Lifecycle status    |Draft                                 |
    Then User clicks on edit icon
    Then User Final Preview & Submit the Document
    Then User clicks on the Impacted Documents button
    And User validates the document is displayed
      |Status        |
      |In-approval   |
    Then User clicks on close button
    Then User clicks on the Impacted Auth Scope Docs button
    And User validates the document is displayed
     |Status      |
     |In-approval |
    And User clicks on confirm button
    And User validates the message
      |Enable atleast 1 Auth line for Document ID(s)|
    Then User clicks on Expand button in Scope Change Preview Tab
    Then User enabled Lines in impacted documents
    Then User clicks on confirm button
    And User validates the message
      |Data saved successfully.|
    And User clicks on submit for approval button
    And User validates the message
      |Impacted document(s) present with all the limit lines disabled|
    Then User clicks on Limit Scope in Scope Change Preview Tab
    Then User clicks on the Impacted Limit Scope Docs button
    And User validates the document is displayed
      |Status      |
      |In-approval |
    And User clicks on confirm button
    And User validates the message
      |Enable atleast 1 limit line for Document ID(s)|
    Then User clicks on Expand button in Scope Change Preview Tab
    Then User enabled Lines in impacted documents
    And User will input Limit Value in impacted documents
      | Limit Value |
      | 9999999999  |
    And User clicks on confirm button
    And User validates the message
      |Data saved successfully.|
    And User clicks on submit for approval button
    And User validates the message
      |Document is Approved|

  Scenario: Validate that No new version is created for Enforced & Draft EDN when lines are deleted
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |ACE URBAN RACE PRIVATE LIMITED        |
      |Lifecycle status    |Approved                              |
    And User navigates to Associated Doc Count Column
    And User click on Associated Doc Count
    And User stores the Document Version IDs
    Then User clicks on close button
    Then User clicks on All documents in side menu
    Then user searches for Document ID and validate the latest version

  Scenario: Validate that deleted lines are not coming in Enforced EDN
    Given User is on Document Framework Page
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                  |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED         |
      |Client-1 Legal Entity Name    |ACE URBAN RACE PRIVATE LIMITED         |
      |Document Status               |In-approval                            |
    Then User clicks on document version ID on Dashboard
    And User navigates to Auth Scope in PDF
    And User validates the Auth line is deleted
      | Asset Class | Product Family  | Product                 |
      | FX          | Exotic Options  | Single Barrier Digital  |
    And User navigates to Limit Line in PDF
    And User validates the limit line is deleted
      | Calculation Type|Netting Type  | Bullion trades| Delta |Product Family |
      | NOP             |Greater L/S   | Exclude Metals|  NO   | Cash          |
