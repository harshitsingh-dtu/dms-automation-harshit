@Regression @BasicFiltering
@US=DMGS-6364

@Regression @Basic123
Feature: Workflow for Basic filtering of Document page

  @TC=1673
  Scenario: Validate case sensitivity for Doc type filter
    Given User will reach the Organization section
    And User is on the update screen
    Then Select data for Doc type filter and Corresponding result should be visible in the doc type filter
      |doc type|
      |4 way   |
      |4 wAY   |
      |DN|
      |dn|
      |Dn|
      |4 wa|
      |4 wa|
      |d   |
      |D   |
      |4 Way|
      Then User validates the doc type dropdown values

  @TC=1677
  Scenario:Validate Document Listing screen filters
    Given User is on Document Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Document Type  |
      | EB-1 LEI    |
      | PB-1 Legal Entity Name     |
      | Document Status            |
      | Allowed Currencies         |
    And user will select Column Values on Document listing screen
      |Column Name            |value               |
      |Document Type          |DN                  |
      |PB-1 Legal Entity Name |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB-1 LEI               |6SHGI4ZSSLCXXQSBB395      |
      |Document Status        |Draft              |
    Then User validates the document version ID
      |Document Version ID|
      | DN-|
    Then User can see Allowed currency filter
    And User can see Document type filter

  @TC-1704
  Scenario: Verify listing of Acting as & select parties dropdown when doc type = 4 way/DN
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User validates the PB and Client
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN         | PB        |
    Then User validates the PB,EB and Client

  @TC-1710
  Scenario: Verify document template data in tabs when creating a document using template
    Given User is on Document Page
    When User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And Verify user is able to select Templates
      |Templates|
      |Automation_OT_DocumentTemplate_4Way|
    Then Verify ApprovalWorkflow , Enforcement Rule , Document Terms Text and dropdown button are visible of templates
    Then verify prefilled data

#  Scenario: User is able to set Allowed currency filter on the document screen
#    Given User is on the all document screen
#    Then User can see Allowed currency filter
#    And User is able to type into Allowed currency filter
#      |filter |
#      |FX     |
#
#  Scenario: User is able to set Document type filter on the document screen
#    Given User is on the all document screen
#    Then User can see Document type filter
#    And User is able to type into Document type filter
#      |filter |
#      |4 Way |
#
#  Scenario: User is able to set Document initiator filter on the document screen
#    Given User is on the all document screen
#    Then User can see Document initiator filter
#    And User is able to type into Document initiator filter
#      |filter |
#      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
#
#  Scenario: User is able to set status filter on the document screen
#    Given User is on the all document screen
#    And User can see the status filter
#    Then User is able to type into status filter
#     |filter |
#      |Terminated|
#
#  Scenario: User is able to set Document actions on the document screen
#    Given User is on the all document screen
#    Then User can see Document actions filter
#    And User is able to type into Document actions filter
#      |filter |
#      |EDIT APPROVAL WORKFLOW|

@US=DMGS-5909 @TC-8067 @TC-8068 @TC-8069 @TC-8070 @TC-8071 @TC-8072 @TC-8074 @TC-8075 @ignore
  Scenario: Validate Client-2 Funds filter and Fund value
    Given User is on Document Page
#  When User clicks on Column Selection button
#  And User will search for column, selects it if not already selected and validates the same on Document listing screen
#    | Column Name    |
#    | PB-1 Legal Entity Name  |
#    | PB-2 Legal Entity Name  |
#    | Client-1 Legal Entity Name   |
#    | Client-2 Legal Entity Name   |
#  And user will select Column Values on Document listing screen
#    |Column Name                   |value                                  |
#    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
#    |Client-1 Legal Entity Name    |CITIGROUP INC.                         |
#    |PB-2 Legal Entity Name        |CITIGROUP INC.                         |
#    |Client-2 Legal Entity Name    |3G Fund, L.P.                          |
#  And User click on delete button
#  Then User validates the Document approved message
#    |Document is deleted|
    Then User clicks on Create New Document
    Then User select document type,acting as
    | Document Type | Acting As |
    | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
    | Prime Broker 1                       | Clients 1                       | Prime Broker 2                   |Clients 2           |
    |OSTTRA INDIA SERVICES PRIVATE LIMITED |CITIGROUP INC. | CITIGROUP INC. |3G Fund, L.P. |
  And User clicks on Add fund button
  Then User add the funds
    |Funds               |
    |1355 STORM PARKWAY LLC|
  And User clicks on Save button
  And User clicks on Add fund button
  Then User validates the added funds
    |Funds      |Value|
    |LEI Name   |1355 STORM PARKWAY LLC|
    |LEI ID     |9845008BSEED6B1A9984|
  Then User clicks on Cancel button
#  And Search for fund name
#    |Column Name    |Value               |
#    |Fund name|1355 STORM PARKWAY LLC|
#  And User validate the Fund count
#  And User clicks on Client-2 Funds fund count
#  Then User validates the added funds
#    |Funds      |Value|
#    |LEI Name   |1355 STORM PARKWAY LLC|
#    |LEI ID     |9845008BSEED6B1A9984|
  Then User clicks on Next button
  Then User clicks on Cancel button
#  And Search for fund name
#    |Column Name    |Value               |
#    |Client-2 Funds|1355 STORM PARKWAY LLC|
#  And User validate the Fund count
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Client-2 Funds  |
      | PB-1 Legal Entity Name  |
      | PB-2 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | Client-2 Legal Entity Name   |
  And user will select Column Values on Document listing screen
    |Column Name                   |value                                  |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    |Client-1 Legal Entity Name    |CITIGROUP INC.                         |
    |PB-2 Legal Entity Name        |CITIGROUP INC.                         |
    |Client-2 Legal Entity Name    |3G Fund, L.P.                          |
    And Search for fund name
      |Column Name    |value               |
      |Client-2 Funds |1355 STORM PARKWAY LLC  |
    And User validate the Fund count
#    And User clicks on Client-2 Funds fund count
#    Then User validates the added funds
#      |Funds      |Value|
#      |LEI Name   |1355 STORM PARKWAY LLC|
#      |LEI ID     |9845008BSEED6B1A9984|
   And Refresh web page
  When User clicks on Column Selection button
  And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name    |
    | PB-1 Legal Entity Name  |
    | PB-2 Legal Entity Name  |
    | Client-1 Legal Entity Name   |
    | Client-2 Legal Entity Name   |
   And user will select Column Values on Document listing screen
    |Column Name                   |value                                   |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
    |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
    |PB-2 Legal Entity Name        |CITIGROUP INC.                          |
    |Client-2 Legal Entity Name    |CITIGROUP INC.                          |
   And Validate No Funds appear if fund is not added
#  And User will search for column, selects it if not already selected and validates the same on Document listing screen
#    | Column Name                  |
#    | PB-1 Legal Entity Name       |
#    | PB-2 Legal Entity Name       |
#    | Client-1 Legal Entity Name   |
#    | Client-2 Legal Entity Name   |
  And Refresh web page
  When User clicks on Column Selection button
  And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name    |
    | PB-1 Legal Entity Name  |
    | PB-2 Legal Entity Name  |
    | Client-1 Legal Entity Name   |
    | Client-2 Legal Entity Name   |
  And user will select Column Values on Document listing screen
    |Column Name                   |value                                  |
    |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    |Client-1 Legal Entity Name    |CITIGROUP INC.                         |
    |PB-2 Legal Entity Name        |CITIGROUP INC.                         |
    |Client-2 Legal Entity Name    |3G Fund, L.P.                          |
  And User click on delete button
  Then User validates the Document approved message
    |Document is deleted|

  @US=DMGS-5909 @TC-8071
  Scenario: Validate Query filter for Client-2 Funds
    Given User is on Document Page
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |Client-2 Funds|
    And User clicks on Add query block
    And User selects the field operator and value
      |field            |operator|value |
      |Client-2 Funds  |IS     |1355 STORM PARKWAY LLC |
    Then User clicks on save and apply
    And User clicks on Client-2 Funds fund count
    Then User validates the added funds
      |Funds      |Value|
      |LEI Name   |1355 STORM PARKWAY LLC|
      |LEI ID     |9845008BSEED6B1A9984|


  @US=DMGS-7129
  Scenario: Verify that user can download data from the Dashboard to Excel format file.
    Given User is on Document Page
    Then User clicks on the download button
    Then User validates the file is downloaded