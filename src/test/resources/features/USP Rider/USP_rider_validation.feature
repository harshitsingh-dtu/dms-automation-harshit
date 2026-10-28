@Regression
@USP_rider
Feature: Validation of USP rider creation

  @TC-2286
  Scenario: Validate default value of Client dropdown should be 30
    Given Click on USP rider template tab under Groups & Template tab
    Then Verify Client dropdown default list


  @TC-2288
  Scenario: Validate default value of PB dropdown should be 30
    Given Click on USP rider template tab under Groups & Template tab
    Then Verify PB dropdown default list


  @TC-2302
  Scenario:Verify Search by Request ID Search box functionality
    Given Click on USP rider template tab under Groups & Template tab
    Then Verify search functionality on USP rider template listing screen by ID

#Invalid TC Now - To be Deleted
#  @TC-2303
#  Scenario:Verify Last Updated By format on USP Rider Template listing screen
#    Given Click on USP rider template tab under Groups & Template tab
#    Then Verify USP rider template Last Updated By format

  @TC-2312
  Scenario: Verify elements on USP Rider Template Create New screen
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then Corresponding information should be visible on create new USP Template screen

  @TC-2318
  Scenario: Validate search functionality for PB dropdown
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    When User will enter doc type in the dropdown
    And User will search LEI in PB dropdown and able to select searched LEI
      |LEI|
      |CITIGROUP INC.|

  @TC-2320
  Scenario: Verify character limit in PB Contact
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    And  User will Enter input in PB Contact field and Check field accept maximum 100 Character only


  @TC-2328
  Scenario: Verify able to add PB counterparties
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    When User will enter LEI in search and add fund
      |Lei|
      |Automation Script|
    And User will be able to see add icon and clicks on add icon
    Then Again user will enter LEI in search and add fund
      |Lei|
      |Sample Test|


  @TC-2334
  Scenario: Validate Error displayed while trying to create already existing USP Rider template
    Given User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button and able to select doc type and select LEI for both PB and Client dropdown
    And User will enter PB Contact on Create USP Template screen
      |Contact|
      |76543210|
    And User will insert word clause on Create USP Template screen
    And User will enter LEI in search and add fund
      |Lei|
      |Automation_test|
    And User will select all YES options for PB counterparties added
    And Clicks on Submit Button of Create USP Template screen
    Then Error message should be displayed informing combination already exists


  @TC-2356 @TC-2608
  Scenario:Verify elements on USP Rider Template listing screen
    Given User is on document screen
    And Click on USP rider template tab under Groups & Template tab
    Then Verify elements on USP rider template listing screen

  @TC-2346 @TC-2611 @TC-2622
  Scenario: Validate PB Client USP Rider Template combinations are visible for New 4 Way Document
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | QHSFEYI7HUOXXZ413E03                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | QHSFEYI7HUOXXZ413E03                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 6SHGI4ZSSLCXXQSBB395                 |
      | client2OrgTypeKey | 3                                    |
    Given User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1                       | Clients 1               | Prime Broker 2           |Clients 2     |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |BNP Paribas (Suisse) SA  |BNP Paribas (Suisse) SA   |CITIGROUP INC. |
    And user will click on next button and get Success message then redirected to edit document screen
    And USer will Click on USP Rider tab and Redirected to USP Rider tab
    Then User is able to see all the Information on USP Rider Template
    And User is able to check USP Rider Document availability
    And User is able to see template combination according to Document type
    Then User able to verify datepicker
    And User will click on the cancel button
    And Click on Yes button of popup
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | PB-2 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
   And user will select Column Values on Document listing screen
      |Column Name                |value               |
      |Document Type              |4 Way               |
      |PB-1 Legal Entity Name     |OSTTRA INDIA SERVICES PRIVATE LIMITED     |
      |PB-2 Legal Entity Name     |BNP Paribas (Suisse) SA                   |
      |Client-1 Legal Entity Name |BNP Paribas (Suisse) SA                   |
      |Client-2 Legal Entity Name |CITIGROUP INC.                            |
    And User deletes the 4 Way document if it exists
    And User validates the message
      |Document is deleted |

  @TC-2367
  Scenario:	Verify Search box for impacted documents drawer
    Given User is on document screen
    And Click on USP rider template tab under Groups & Template tab
    Then Select doc type on USP listing screen
      |filters|
      |4 Way|
    And Search template which have more then zero Related Documents count
    And Click on template Related Documents count
    And Verify user is on Impacted Documents screen
    And Verify search functionality by ID on Impacted Documents screen

  @TC-2370
  Scenario:	Verify apply button on impacted documents drawer
    Given User is on document screen
    And Click on USP rider template tab under Groups & Template tab
    Then Select doc type on USP listing screen
      |filters|
      |4 Way|
    And Search template which have more then zero Related Documents count
    And Click on template Related Documents count
    And Verify user is on Impacted Documents screen
    And Verify Apply USP template functionality
#    And User waits for 3 seconds
#    And User validates the message
#     |Batch saved successfully |

  @TC-2372
  Scenario:	Verify hyperlink on impacted documents drawer
    Given User is on document screen
    And Click on USP rider template tab under Groups & Template tab
    And Search template which have more then zero Related Documents count
    And Click on update button to update USP template
    And Make changes in template and click on submit button
    When Verify user is on Impacted Documents screen
    Then Verify hyperlink on Impacted Documents screen

  @TC-2374
  Scenario:	Verify version compare pop-up elements
    Given User is on document screen
    And Click on USP rider template tab under Groups & Template tab
    And Search template which have more then zero Related Documents count
    And Click on update button to update USP template
    And Make changes in template and click on submit button
    When Verify user is on Impacted Documents screen
    Then Verify hyperlink on Impacted Documents screen
    And User click on hyperlink
    And Verify elements on compare page of USP template

  @TC-2616
  Scenario: Validate functionality if Yes button is clicked on pop-up elements visible after creating USP Rider template
    Given User is on document screen
    And User is on USP Rider Template screen
    When User is redirected to USP Rider Template listing screen
    And Clicks on Create New Template button
    And User should be redirected to create new USP Rider Template screen
    And User will select doc type on Create USP Template screen
    And User will select random LEI in PB dropdown on Create USP Template screen
    And User will select random LEI in Client dropdown on Create USP Template screen
    And User will enter PB Contact on Create USP Template screen
      |Contact|
      |76543210|
    And User will insert word clause on Create USP Template screen
    And User will enter LEI in search and add fund
      |Lei|
      |Automation_test|
    And User will select all YES options for PB counterparties added
    And Clicks on Submit Button of Create USP Template screen
    Then verify user can see popup with yes and no buttons
    And Click on Yes button of popup
    And Verify user is on Impacted Documents screen
    And Verify elements on Impacted Documents screen

  @TC-2618
  Scenario:  Validate Action type column value on Bulk request screen
    Given User is on document screen
    And Navigate to Bulk request screen
    And Verify user is on bulk request screen
    And Verify Select Document Action dropdown is present
    And Select Apply USP Rider from Document Action dropdown
    Then Verify only Apply USP Rider is present under action type column

#  @TC-2727 @TC-6165  @Sanity
  Scenario:Verify update journey when clicked Yes on pop-up after submit button -Bulk Request Screen
    Given User is on document screen
    And Click on USP rider template tab under Groups & Template tab
    And select one usp template with impacted documents
    And Click on update button to update USP template
    And Make changes in template and click on submit button
    When Verify user is on Impacted Documents screen
    And select impacted document
    And Click on Apply button on Impacted Documents screen
    And Verify user is on lite user alert screen
    Then Verify user is on bulk request screen

  @TC-2596 @TC-2594 @TC-5912
  Scenario:Verify USP rider update functionality - Enforced Document
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 6SHGI4ZSSLCXXQSBB395                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 6SHGI4ZSSLCXXQSBB395                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 8156005B759FA9AD8345                 |
      | client2OrgTypeKey | 3                                    |
    Then User clears all listing column filters
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type   | Acting As |
      | 4 Way            | PB        |
    And User select the LEIs
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
      |PB-2 Legal Entity Name        |CITIGROUP INC.         |
      |Client-2 Legal Entity Name    |BONETTI GIORDANO          |
    Then User clicks on Next button
    Then User waits for 5 seconds
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Spot    |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
    And User will submit the changes
    Then User will select tenor in Auth Tenor
      | Auth Tenor         |
      | Calendar Days      |
    Then User will input Auth Tenor value
      | Auth Value |
      | 100        |
    And User clicks on Add Auth Line
    And User clicks on Limit Scope
    And User will input Calculation Type
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 4444 |
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
    Then User tick the USP Rider checkbox
    Then User selects the USP Rider and enter the date
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then User waits for 3 seconds
    Then User is on the all document screen
    Then Click on USP rider template tab under Groups & Template tab
    Then Select doc type on USP listing screen
    |filters|
    |4 Way|
    And select PB and client on USP listing screen
      |PB Name|Client Name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |CitiGroup INC. |
    And Click on update button to update USP template
    And Make changes in template and click on submit button
    When Verify user is on Impacted Documents screen
    And Select Document version ID & apply filter on document listing screen
    And User select Acting as in the edit pop up screen
      | acting as |
      | Osttra India Services Private Limited |
    And User select Action type in the edit pop up screen
      |action type|
      |Edit document|
    And click on the submit button on the edit pop up screen
    Then User will Click on yes button on USP Rider Update POPUP and Redirected to Comparison Window
    And User will able to see all the correspondence information and buttons on Version Compare screen
    Then User will Click on Apply Update button and able to Success Message Document Version Update
    And User will click on the cancel button
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Document Type  |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | PB-2 Legal Entity Name  |
      | Client-2 Legal Entity Name   |
    And user will select Column Values on Document listing screen
      |Column Name            |value                                  |
      |Document Type          |4 Way                                  |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
      |PB-2 Legal Entity Name        |CITIGROUP INC.       |
      |Client-2 Legal Entity Name    |BONETTI GIORDANO     |
      |Document Status               |Draft                |
    And User deletes the document if it exists
    Then User validates the pop-up message
    |Document is deleted|

  @TC-2591
  Scenario:Verify USP rider update functionality
    Given Click on USP rider template tab under Groups & Template tab
    Then Select doc type on USP listing screen
      |filters|
      |4 Way|
    And select PB and client on USP listing screen
      |PB Name|Client Name|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |CitiGroup INC. |
    And Click on update button to update USP template
    And Make changes in template and click on submit button
    When Verify user is on Impacted Documents screen
    And Select Document version ID & apply filter on document listing screen
    And User select Acting as in the edit pop up screen
      | acting as |
      | citigroup |
    And User select Action type in the edit pop up screen
      |action type|
      |Edit document|
    And click on the submit button on the edit pop up screen
    Then User will Click on No button on USP Rider Update POPUP and Redirected to Approval WorkFlow Screen
    And USer will Click on USP Rider tab and Redirected to USP Rider tab
    Then User able to see atleast one highlighted New Update available link text correspondence USP Rider
    And User will click on the cancel button
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
    And user will select Column Values on Document listing screen
      |Column Name                 |value                                   |
      |Document Status             |Draft                                   |
      |Document Type               |4 Way                                   |
      |PB-1 Legal Entity Name      |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
      |Client-1 Legal Entity Name  |CITIGROUP INC.                          |
    And User deletes the 4 Way document if it exists