@document_type=4-way @orgManagement
@Regression @US=3620 @US=3283

Feature: Workflow of DN PushNotifications for organisations

  @TC-1353 @TC-7660 @TC-7661 @TC-7669 @TC-7670                                                                                               @TC-7665
   Scenario: Validate ‘DN Push Notifications’ and alternate client ID & Broker ID validations
    Given User navigates to the organisation screen
    Then User validates DN Push Notification button on Organisation Screen
    Then User searches the Organisation
      |search_orgname |
      | BARCLAYS PLC  |
    #And User click toggle button for DN Push Notification
    And User click toggle button for DN Push Notification to enable
    And User validates the message
      |DN push notifications enabled for BARCLAYS PLC|
    Then User is on Document Page
    And User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   | BARCLAYS PLC  |
    And User validates the Alternate Executing Broker ID field is visible Second
    And User validates the Alternate Client ID field is visible
    Then User enters the random characters into Alternate Executing Broker ID dropdown value button
    Then User enters the random characters into Alternate Client ID dropdown value button

  Scenario:User creates a draft DN document for below testcase validation
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d|
      | pbLeiId     |213800LBQA1Y9L22JB70|
      | ebLeiId     |254900SLCV8KI86BHL86|
      | clientLeiId |254900SLCV8KI86BHL86|
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |BARCLAYS PLC|
      |EB 1             |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Client 1         |OSTTRA INDIA SERVICES PRIVATE LIMITED|
    Then User clicks on Next button

  @TC-7662 @TC-7671
  Scenario: Validate amending a DN user can enter or change the alternate EB and Client identifier codes
    Given User is on Document Page
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |BARCLAYS PLC |
      |EB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |Document Status               |Draft                                 |
    Then User clicks on edit icon
    Then User click on add Alternate ID
    Then User enters the random characters into the Alternate ID in document
    And User validates the message
      |Document Participant Data Updated|
    Then User click on add Alternate ID
    Then User enters the random characters into the Alternate ID in document
    And User validates the message
      |Document Participant Data Updated|
#    And User validates the text field length for Alternate ID
    Then User clicks on edit icon for Alternate ID
    Then User enter the value in Alternate ID field for document
      |TestingRegression|
    And User validates the message
      |Document Participant Data Updated|

  @TC-7674 @TC-7675 @TC-7672 @ignore @DMGS-8954
  Scenario: Validate user is able to filter the data for these columns and visible in Document preview on dashboard
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    And User selects the field operator and value
      |field                |operator  |value               |
      |EB Alternate ID      |=         |TestingRegression   |
    Then User clicks on Apply
    Then User validates the document version ID
      |Document Version ID|
      | DN-|
    And Verify the Total Record Count
      |1|
    Then User clicks on document version ID on Dashboard
    And User validates text is visible in preview
      |TestingRegression|

  @TC-7676
  Scenario: Validate 4Way document user should not see the alternate EB and Client identifier codes
    Given User is on Document Page
    And User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      |Prime Broker 1   |	OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    And User validates the Alternate ID field is not visible

  @TC-7662
  Scenario: Validate toggle button for ‘DN Push Notifications’ is added at organisation page
    Given User navigates to the organisation screen
    Then User validates DN Push Notification button on Organisation Screen
    Then User searches the Organisation
      | search_orgname       |
      |	 BARCLAYS PLC        |
    #Then User click toggle button for DN Push Notification
    Then User click toggle button for DN Push Notification to disable
    And User validates the message
      |DN push notifications disabled for BARCLAYS PLC|