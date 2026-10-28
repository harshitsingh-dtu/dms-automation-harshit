@DocumentCreation @Regression
@document_type=4-way @US=DMGS-6327
Feature: Workflow for Create New Document

@TC=2482 @TC=2495 @TC=2498 @TC=1748 @TC=6248 @TC-6778 @TC-2484 @IC-2485
Scenario: User creates a 4way document, sent it to in-approval and enforce it
      Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | SLI1CVYMJ21DST0Q8K25                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | SLI1CVYMJ21DST0Q8K25                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 254900SLCV8KI86BHL86                 |
      | client2OrgTypeKey | 3                                    |
  Then User refreshes the browser
  Given User is on Document Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | PB-2 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
      |Document Status               |
    Then User creates a document through API
      |Payload path|
      |src/test/java/resources/DocCreation_4way.json|
    Then User adds immediate enforcement rules via API for 4way Document or Document Framework
    Then User adds General Terms via API for 4way Document
    Then User adds LimitScope via API for Document or Document Framework
    Then User refreshes the browser
    And User waits for 3 seconds
    And User is on Document Page
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |Client-1 Legal Entity Name    |ABSA BANK     |
      |PB-2 Legal Entity Name        |ABSA BANK     |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |Document status               |Draft              |
    Then User clicks on edit icon
   # Then User will use drag and drop PB1 to approval Seq 1 in DF
  Then User will Drag participants and arrange them in approval sequence correspondence to their document action
    | Participants     | Document_Action | Approval_sequence |
    | Prime Broker - 1 | New Document    | 1                 |
    And User clicks on Next button
#    Then User clicks on document terms tab
#    Then User will click on the CK editor and type text into document content
#    | Document content             |
#    | This is dummy data for Automation. Do not edit this. |
#    Then User clicks on Next button
#    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User adds Currencies
#    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User clicks on Next button
    And User clicks on Preview & Submit tab
    And Verify renaming of Legal term to document terms
    And User clicks on view as PDF button
    And Verify renaming of Legal term to document terms on View as PDF
    Then User clicks on close button
    Then User Final Preview & Submit the Document
  And user will select Column Values on Document listing screen
    |Column Name                   |value                |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
    |Client-1 Legal Entity Name    |ABSA BANK      |
    |PB-2 Legal Entity Name        |ABSA BANK      |
    |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
    |Document status               |In-approval               |
    Then User approves the document
    Then User waits for some time, refreshes the page and validates the status

@TC=2515 @TC=2522 @TC=2525 @TC=2526 @TC=2527 @TC-1751 @TC-2519 @TC-2521 @TC=2518 @TC=2520 @TC=2523 @TC=2524 @TC-7700
Scenario: User copies the above document.
  Given User resets 4Way document
    | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
    | pb1LeiId          | 254900SLCV8KI86BHL86                 |
    | pb1OrgTypeKey     | 1                                    |
    | pb2LeiId          | 549300H7FILSLGGU3C96                 |
    | pb2OrgTypeKey     | 1                                    |
    | client1LeiId      | 254900SLCV8KI86BHL86                 |
    | client1OrgTypeKey | 3                                    |
    | client2LeiId      | 549300H7FILSLGGU3C96                 |
    | client2OrgTypeKey | 3                                    |
    Given User is on Document Page
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Client-1 Legal Entity Name    |ABSA BANK      |
      |PB-2 Legal Entity Name        |ABSA BANK      |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Document status               |Enforced               |
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    Then User validates document type
    Then User validate the allowed currency
#    Then Verifies the Document Template field
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1 | Clients 1    | Prime Broker 2 |Clients 2                              |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED |  CITIC Capital China Partners III, L.P.|CITIC Capital China Partners III, L.P.|
#  Then Verifies the Document Template field
    Then User clicks on Next button
    Then User validates participants in Approval workflow in copied document
#    Then User clicks on Next button
    Then User validates the enforcement data as immediate in DF
#    Then User clicks on document terms tab
#    Then User validates the Document terms data
    Then User clicks on Auth Scope Tab
    #Then User validates Auth Scope data|
  Then Clicks on DF Auth scope Expand All button
  Then user validate the Auth Scope data
    | Asset Class | Product Family | Product         | Currencies Deliverable | Tenor  |
    | FX          | Volatility     | Volatility Swap | AED                     | 3Years |
    Then User clicks on Next button
    Then User validates data in Limit Scope
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User clicks on ignore button for name change
    Then User waits for some time, refreshes the page and validates the status

  @TC=2687
  Scenario: User terminates both the documents
    Given User is on Document Page
    Then user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |Client-1 Legal Entity Name    |ABSA BANK      |
      |PB-2 Legal Entity Name        |ABSA BANK      |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |Document status              |Enforced               |
    And User clicks on Terminate button
    Then User will select Acting as on the terminate confirmation pop up
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED|
    Then User will click on Submit Button
    Then User validates the notification for Document Termination
    Then User refreshes the browser
    Then user will select Column Values on Document listing screen
      |Column Name                   |value                        |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                        |
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.  |
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.  |
      |Document status               |Enforced               |
    And User clicks on Terminate button
     Then User will select Acting as on the terminate confirmation pop up
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED|
    Then User will click on Submit Button
    Then User validates the notification for Document Termination
    Then User waits for some time, refreshes the page
    And Click on notification bell icon
#    Then Check if User will be able to see notification in the dialogue box for terminating the document

  @DraftDocument4Way @TC-8410 @TC-6687 @TC-6690
  Scenario: User creates a 4way draft document
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 549300H7FILSLGGU3C96                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 254900SLCV8KI86BHL86                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 549300H7FILSLGGU3C96                 |
      | client2OrgTypeKey | 3                                    |
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1 | Clients 1    | Prime Broker 2 |Clients 2     |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED|OSTTRA INDIA SERVICES PRIVATE LIMITED|CITIC Capital China Partners III, L.P.|CITIC Capital China Partners III, L.P. |
    Then User clicks on Next button
  #    Then User will use drag and drop PB1 to approval Seq 1 in DF
  #    Then User clicks on Next button
    Then User select rules in Enforcement rule
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
    Then User will input Product family
      |Product Family|
      | Exotic Options      |
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    And User clicks on copy icon for lines to be copied for DF
    And User enters values in Copied limit line
    |Limit Value|Bullion Trades|
    |25697456    |Include Metals|
    # And User click on save icon for limit line for DF
#    And User click on save icon for limit line for 4way
    And User clicks on copy icon for lines to be copied for DF
    And User enters values in Copied limit line
      |Limit Value|Bullion Trades|
      |1          |Only Metals|
    # And User click on save icon for limit line for DF
#    And User click on save icon for limit line for 4way
    And User clicks on Save As Draft button
    And User validates limit scope updated successfully is displayed

  @TC_05 @TC_09 @TC_12 @US=DMGS-6327
  Scenario: Verify select all is available in Product Family options for authorisation scope for a 4way
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.|
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.|
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
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
    And User will submit the changes
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Volatility      | Variance Swap  |
      | FX          | Cash            |                |
      | FX          | Vanilla Options |                |
      | FX          | Exotic Options  |                |
#    Then User clicks on Next button
    Then User clicks on Next Button on Auth Scope
    And User validates the message
      |Auth scope saved successfully|
    Then User waits for 5 seconds
    Then User clicks on Preview & Submit tab
    And User clicks on Auth Scope Tab in Final Preview
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Volatility      | Variance Swap  |
      | FX          | Cash            |                |
      | FX          | Vanilla Options |                |
      | FX          | Exotic Options  |                |

  @TC_06 @TC_08 @US=DMGS-6327
  Scenario: Verify select all is available in Product options for authorisation scope for a 4way
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.      |
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.      |
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
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
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
    And User will search for the Non Deliverable currency and select them on Auth Scope
      |currency list|
      |aoa|
      |kES|
    And User will submit the changes
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User validates the Auth line is added
      | Asset Class | Product Family  | Product        |
      | FX          | Cash            | Future         |
      | FX          | Cash            | Forward        |
      | FX          | Vanilla Options | Vanilla Option |
      | FX          | Exotic Options  | Asian          |
      | FX          | Volatility      | Variance Swap  |
    Then User clicks on Next Button on Auth Scope
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

  @ResettingData
  Scenario: Removing added lines from EDN
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.|
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.|
    Then User clicks on edit icon
    Then User waits for 5 seconds
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|
    And User validates No Lines are there

  @TC=6200 @TC=6240 @TC=6243
  Scenario: User searches 4way document via query for bullion trade and Delete the document
    Given User is on Document Page
    And User can see Add Edit query button
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |Automation_Regression|
    And User clicks on Add query block
    And User performs multiple Add query block
      |field|operator|value|condition|
      |Document Status |= |Draft |AND|
      |PB-1 Legal Entity Name |= |OSTTRA INDIA SERVICES PRIVATE LIMITED|AND|
      |PB-2 Legal Entity Name |= |CITIC Capital China Partners III, L.P.|AND|
      |Bullion Trades |= |Only Metals |null|
#      |Product Family    |= | Exotic Options |null|
    Then User clicks on save and apply
    Then User validates the 4Way document on listing screen
    And User clicks on edit icon
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    Then User validates Bullion Trades in Preview
    And User clicks on Auth Scope Tab in Final Preview
    And User clicks on view as PDF button
    And User validates Bullion Trades in Preview
    Then User clicks on close button
    And User clicks on Cancel button
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |PB-2 Legal Entity Name        |CITIC Capital China Partners III, L.P.      |
      |Client-2 Legal Entity Name    |CITIC Capital China Partners III, L.P.      |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

  @Sanity @fixed
  Scenario: Validate delete functionality for 4 Way
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 335800S55XBFSN89C680                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 335800S55XBFSN89C680                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 254900SLCV8KI86BHL86                 |
      | client2OrgTypeKey | 3                                    |
    Given User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1                       | Clients 1                       | Prime Broker 2                   |Clients 2           |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |AURIOLUS FINVEST PRIVATE LIMITED | AURIOLUS FINVEST PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on Next button
    And User clicks on Cancel button
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                  |
      | PB-1 Legal Entity Name       |
      | PB-2 Legal Entity Name       |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                       |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
      |Client-1 Legal Entity Name    |AURIOLUS FINVEST PRIVATE LIMITED            |
      |PB-2 Legal Entity Name        |AURIOLUS FINVEST PRIVATE LIMITED            |
      |Client-2 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
    And User click on delete button
    Then User validates the Document approved message
      |Document is deleted|

#  Scenario: If doc presnt
#    Given User is on Document Page
#    Then User clicks on Column Selection button
#    And User will search for column, selects it if not already selected and validates the same on Document listing screen
#      | Column Name                  |
#      | PB-1 Legal Entity Name       |
#      | PB-2 Legal Entity Name       |
#      | Client-1 Legal Entity Name   |
#      | Client-2 Legal Entity Name   |
#    And user will select Column Values on Document listing screen
#      |Column Name                   |value                               |
#      |PB-1 Legal Entity Name        |Corona Avenue Member Sub, LLC       |
#      |Client-1 Legal Entity Name    |Xenophon B.V.	                |
#      |PB-2 Legal Entity Name        |AmstelVisie B.V.                       |
#      |Client-2 Legal Entity Name    |Koudenburg B.V.            |
#    Then Delete or Terminate all the relatable documents
