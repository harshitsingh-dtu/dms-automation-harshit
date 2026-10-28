@Regression @DMGS-9333 @NoChangeVersioning
Feature: No-change versioning and approval bypass rules for DN and 4-Ways agreements

 @DF_DataCreation
 Scenario: User creates a DocumentFramework and approves it
   Given User resets DF document
     | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
     | pbLeiId   |254900SLCV8KI86BHL86                  |
     | ebLeiId   |5299000CMRQLOD3YA377                  |
   Given User is on Document Framework Page
   Then User creates a document framework through API
     |Payload path|
     |src/test/java/resources/DF_Creation_09.json|
   Then User adds immediate enforcement rules via API for DN Document or Document Framework
   Then User adds General Terms via API for DN Document Framework
   Then User adds LimitScope via API for Document or Document Framework
   And user will select Column Values on Document Framework screen
     |Column Name         |value             |
     |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
     |EB Name             |Lusa - Portuguese News Agency SA            |
     |Lifecycle status    |Draft                                       |
   Then User clicks on edit icon
   Then User clicks on Next button
   Then User will Drag participants and arrange them in approval sequence correspondence to their document action
     |Participants      |Document_Action           |Approval_sequence|
     |Prime Broker - 1  |New Document              |1                |
   Then User clicks on Next button
   Then User clicks on Auth Scope Tab
   Then User Add Asset Class, Product Family, Product to the Auth Scope
     | Asset Class | Product Family    | Product |
     | FX          | Exotic Options    | Single Barrier Digital  |
   And Click on + Add currencies
   And User will search for the currency and select them
     |currency list|
     |AED|
     |CLF|
     |COP|
     |CRC|
     |ISK|
   And User will submit the changes
   And User clicks on Add Auth Line
   Then User clicks on Preview & Submit tab
   Then User validates the message
     |Auth scope saved successfully|
   Then User clicks on submit for approval button
   Then User validates the toast message
     |Document is Approved|

  @TC_01
  Scenario: Verify New version is triggered for unchanged DF agreement
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                           |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED           |
      |EB Name             |Lusa - Portuguese News Agency SA                |
      |Lifecycle status    |Approved                                        |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type |
      |Edit Document Framework|
    And User will click on Submit Button
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User clicks on ignore button for name change
    Then User validates the toast message
      |Document is Approved|

  @DN_DataCreation
  Scenario: User creates an EDN and it goes into in-approval
    Given User resets DN document
    |docTypeId    | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
    | pbLeiId     | 254900SLCV8KI86BHL86                 |
    | ebLeiId     | 5299000CMRQLOD3YA377                 |
    | clientLeiId | 549300ZLVED0VPNQPO73                 |
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB 1             |Lusa - Portuguese News Agency SA      |
      |Client 1         |3G Fund, L.P.                         |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family    | Product                 |
      | FX          | Exotic Options    | Single Barrier Digital  |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User will input Auth Tenor value for DN
      | Auth Value |
      | 10         |
    Then User will select tenor in Auth Tenor for DN
      | Auth Tenor |
      | Business Days      |
    Then User clicks on Next button
    And User validates the message
      | Auth scope saved successfully|
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      |99999999|
    Then User clicks on Next button
    Then User validates the message
      |Limit scope updated successfully|
    Then User Final Preview & Submit the Document
    Then Users click on Commit button on the following functionality is not supported pop-up
    #Then User clicks on ignore button for name change
    Then User validates the Document approved message
      |Document is In-approval|

  @TC_02
  Scenario: Verify no new version or approval is triggered for unchanged DN agreement
    Given User will go to Document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | EB-1 Legal Entity Name     |
      | Document Status            |
      | Document Action            |
    And user will select Column Values on Document listing screen
      |Column Name                    |value                                 |
      |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name         |Lusa - Portuguese News Agency SA      |
      |Client-1 Legal Entity Name     |3G Fund, L.P.                         |
      |Document Status                |In-Approval                           |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User select Action type in the edit pop up screen
      | action type   |
      | Edit Document |
    And click on the submit button on the edit pop up screen
    Then User waits for 3 seconds
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    #Then User clicks on ignore button for name change
    Then User validates the message
    |No amendments have been applied, please make changes if required|

  @TC_05
  Scenario: Verify reverted edits (net-zero change) do not trigger new version
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                    |value                                 |
      |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name         |Lusa - Portuguese News Agency SA      |
      |Client-1 Legal Entity Name     |3G Fund, L.P.                         |
    Then User deletes the document if it exists
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User select Action type in the edit pop up screen
      | action type         |
      | Remove Product      |
    And click on the submit button on the edit pop up screen
    Then User clicks on Auth Scope Tab
    Then Clicks on ExpandAll button
    Then User deletes all the auth Lines in Remove Products action
    Then User clicks on Reset Current Changes button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    #Then User clicks on ignore button for name change
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the toast message
      |No amendments have been applied, please make changes if required|

  @TC_06
  Scenario: Verify formatting variations (commas/spaces) do not trigger new version
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                    |value                                 |
      |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name         |Lusa - Portuguese News Agency SA      |
      |Client-1 Legal Entity Name     |3G Fund, L.P.                         |
    Then User deletes the document if it exists
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User select Action type in the edit pop up screen
      | action type         |
      | Edit Limit Increase |
    And click on the submit button on the edit pop up screen
    Then User clicks on Limit Scope
    #Then User clicks on edit icon for limit line
#    Then User clicks on limit line edit icon and enters value
#      | 999 999,999 |
    And User will enter the Limit Value on Limit screen
      | Limit Value |
      |999 999,99|
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    #Then User clicks on ignore button for name change
    Then Users click on Commit button on the following functionality is not supported pop-up
#    Then User validates the message
#      |No amendments have been applied, please make changes if required|
    Then User validates the toast message
      |No amendments have been applied, please make changes if required|

 @DataCreation
  Scenario: User creates a 4way document in Enforced state
   Given User resets 4Way document
     | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
     | pb1LeiId          | 254900SLCV8KI86BHL86                 |
     | pb1OrgTypeKey     | 1                                    |
     | pb2LeiId          | 506700O64XCYH0C1OC39                 |
     | pb2OrgTypeKey     | 1                                    |
     | client1LeiId      | 254900SLCV8KI86BHL86                 |
     | client1OrgTypeKey | 3                                    |
     | client2LeiId      | 549300ZLVED0VPNQPO73                 |
     | client2OrgTypeKey | 3                                    |
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1                        | Clients 1                            | Prime Broker 2 | Clients 2       |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED |Winterthur Cooperative Society|3G Fund, L.P.|
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
     Then User clicks on Next button
     Then User clicks on Auth Scope Tab
     Then User Add Asset Class, Product Family, Product to the Auth Scope
       | Asset Class | Product Family    | Product |
       | FX          | Exotic Options    | Single Barrier Digital  |
     And Click on + Add currencies
     And User will search for the currency and select them
       |currency list|
       |AED|
       |CLF|
       |COP|
       |CRC|
       |ISK|
     And User will submit the changes
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User clicks on Limit Scope
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 900000          |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
   Then User clicks on ignore button for name change
    And User validates the toast message
      |Document is In-approval|

  @TC_07
  Scenario: Verify no new version or approval is triggered for unchanged 4 Ways agreement
   Given User will go to Document screen
   When User clicks on Column Selection button
   And User will search for column, selects it if not already selected and validates the same on Document listing screen
     | Column Name                |
     | PB-1 Legal Entity Name     |
     | PB-2 Legal Entity Name     |
     | Client-1 Legal Entity Name |
     | Client-2 Legal Entity Name |
     | Document Status            |
     | Document Action            |
   And user will select Column Values on Document listing screen
     |Column Name                    |value                                   |
     |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
     |PB-2 Legal Entity Name         |Winterthur Cooperative Society          |
     |Client-1 Legal Entity Name     |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
     |Client-2 Legal Entity Name     |3G Fund, L.P.                           |
     |Document Status                |In-approval                             |
   Then User clicks on edit icon
   And User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
   And User select Action type in the edit pop up screen
     | action type   |
     | Edit Document |
    And click on the submit button on the edit pop up screen
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User clicks on ignore button for name change
    Then User validates the toast message
      |No amendments have been applied, please make changes if required|