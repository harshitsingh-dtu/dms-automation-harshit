@DocumentCreate_DeleteWorkflow_DN @Regression
@document_type=DN @US=DMGS-3206 @US=DMGS-2818 @US=DMGS-3377 @US=DMGS-3190
Feature: Workflow for Delete Document

  @TC=6768
  Scenario: User creates a DN such that no DF exists
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |CITIGROUP INC.           |
      |EB 1             |CITIGROUP INC.           |
      |Client 1         |CITIGROUP INC.           |
    Then User clicks on Next button
    Then User validates the toast message
      |No approved DF version with selected PB, EB and currency exists|

  @TC=7143 @TC=6941 @TC=7026 @TC=7027
  Scenario: User validates enforcement rule is read only and auth scope cannot be empty message
    Given User will go to Document screen
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 549300ZLVED0VPNQPO73                 |
      | clientLeiId | 549300GTZKKRPSBCIC83                 |
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Created On (Local Time)  |
      | Created On (UTC Time)    |
      | PB-1 Legal Entity Name    |
      | EB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name    |
      | Document Status    |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                            |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                            |
      |EB-1 Legal Entity Name        |3G Fund, L.P.                    |
      |Client-1 Legal Entity Name    |123-57 Sanford Avenue, LLC       |
      |Document Status               |Draft                            |
    #And User checks if Document already exists
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB 1             |3G Fund, L.P.                          |
      |Client 1         |123-57 Sanford Avenue, LLC             |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User clicks on Next button
    Then User validates the enforcement screen
    And User validates the enforcement screen is read only
    And User clicks on General Terms Tab
    And User verifies Physically Settled Bullion is displayed
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User validates the toast message
      |Auth scope is required|

  @TC=6831 @TC=6832 @TC=6833 @TC=6834 @TC=7026
  Scenario: User creates an Add/Edit Query for CreatedOn Local & UTC Time
    Given User is on the all document screen
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |Automation_Query_test|
    And User clicks on Add query block
    And User selects the field operator and value
      |field                    |operator|value        |condition|
      |Created on (local time)  |=       |Current Date |AND      |
      |Created on (UTC time)    |=       |Current Date |AND      |
      |Document status          |=       |Draft        |null     |
    Then User clicks on Apply
    And validates query is applied successfully
    And user validates the document is created

  @TC=7026 @TC=6827 @TC=6228 @TC=6830 @TC=2688 @TC=6815 @TC=6979 @TC=6766
  Scenario: Validate created on(Local time) and created on (UTC time) filters and toast message when Limit scope is empty
    Given User will go to Document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | Created On (Local Time)  |
      | Created On (UTC Time)    |
      | PB-1 Legal Entity Name    |
      | EB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name    |
      | Document Status    |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                            |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                          |
      |EB-1 Legal Entity Name        |3G Fund, L.P.                    |
      |Client-1 Legal Entity Name    |123-57 Sanford Avenue, LLC       |
      |Document Status               |Draft                            |
    Then User clicks on edit icon
    #Then User clicks on Next button
    And User clicks on Auth Scope Tab
    And Validate following field is not displayed
      |Field    |
      |Auth Tenor    |
      |Auth Currencies |
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family  | Product          |
      | FX          | Bullion  |Bullion Vanilla Options  |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Exotic Options | Asian |
#    And User clicks on Add Auth Line
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Cash           | Spot |
#    And User clicks on Add Auth Line
#    Then User Validates Other lines should be greyed out
#      | Asset Class | Product Family | Product |
#      | FX          | Cash           | Spot    |
#    Then User validate Add Auth Line is disabled
#    Then User enables all Auth Lines
#    Then User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Exotic Options | Asian  |
#    And User clicks on Add Auth Line
#    Then User enables Tenor
#    Then User clicks on "Disabled"
#    Then User clicks on disable button for tenor
#    And Click on DN Edit currencies
#    And User will search for the currency deselect and select them
#      |currency list|
#      |AED|
#    And User will submit the changes
#    And User will input Auth Tenor value
#      | Auth Value |
#      | 3          |
#    And User will select tenor in Auth Tenor
#      | Auth Tenor |
#      | Years      |
#    And User clicks on Add Auth Line
#    Then User clicks on Next button
#    And User clicks on Add Auth Line
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product |
#      | FX          | Bullion        | Bullion Vanilla Options|
#    And Click on + Add currencies
#    And User will search for the currency and select them
#      |currency list|
#      |XAG|
#      |XAU|
#      |XPD|
#      |XPT|
#    And User will submit the changes
#    And User clicks on Add Auth Line
#    Then User enables all Auth Lines
#    Then Clicks on ExpandAll button
#    Then User selects the Settlement type
#      |Non Deliverable|
#    Then User clicks on Save As Draft button
#    Then User validates the message
#      |There is a mismatch in settlement type and selected currencies in product group|
#    Then User selects the Settlement type
#      |Deliverable|
#    Then User clicks on Save As Draft button
    Then User clicks on Next button
    Then User validates the toast message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    And Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the toast message
      |Limit scope is required|
    And User clicks on Cancel button
    Then User refreshes the browser
    And user will select Column Values on Document listing screen
      |Column Name                   |value                       |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                       |
      |EB-1 Legal Entity Name        |3G Fund, L.P.               |
      |Client-1 Legal Entity Name    |123-57 Sanford Avenue, LLC  |
    Then User applies filter of the current date for CreatedOn Local Time
    And user validates the document is created
    Then User applies filter of the current date for CreatedOn UTC Time
    And user validates the document is created

 @TC=7028 @TC=7035 @TC=7036 @TC=7037 @TC=7038 @TC=7040 @TC=7041 @TC=7146
  Scenario: Validate no toast message when both authorisation scope and position limits added prior to submission for approval.
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                            |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                            |
      |EB-1 Legal Entity Name        |3G Fund, L.P.                    |
      |Client-1 Legal Entity Name    |123-57 Sanford Avenue, LLC       |
      |Document Status               |Draft                            |
    Then User clicks on edit icon
  #  Then User clicks on Next button
    Then User clicks on Limit Scope
#     * User will input Calculation Type
#       | Calculation Type |
#       | NOP              |
#     * User will input Netting Type
#       | Netting Type |
#       | Greater L/S  |
#     Then User enter Bullion Trades in Limit Scope
#       |Exclude Metals|
#     * User will input Delta
#       | Delta |
#       | No    |
#     * User will input Product family
#       | Product Family |
#       | Cash           |
#     Then User clicks on Add Limit button
   Then User enable the Limit line and validate the same
   Then User clicks on Next button
     Then User clicks on Preview & Submit tab
     Then User clicks on submit for approval button
   And User validates the unsupported functionality popup message for CreditLink
     | Heading                                                    | Message                                                                 |
     | The Following Functionality Is Not Supported In CreditLink | NOP and DSL calculations are based on forward rates (defaults to spot). |
#     Then User validates the message
#       |The following functionality is not supported in CreditLink|
#     Then User validates the message
#       |NOP and DSL calculations are based on forward rates (defaults to spot).|
#   Then User clicks on submit for approval button
#     Then User validates the message
#       |Currency authorization for exotic options.|
#     Then User validates the message
#       |Bullion products are considered as regular FX products for credit calculations.|
#   Then Users click on Commit button on the following functionality is not supported pop-up
#     Then User clicks on Cancel button
#     And Users click on Commit button on the following functionality is not supported pop-up
   And Users click on Commit button on the following functionality is not supported pop-up
     Then User validates the Document approved message
       |Document is Approved|
    Then User waits for some time, refreshes the page and validates the status

@ResetData
    Scenario: User Terminates the document
      Given User will go to Document screen
      And user will select Column Values on Document listing screen
        |Column Name                   |value                                 |
        |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
        |EB-1 Legal Entity Name        |3G Fund, L.P.                         |
        |Client-1 Legal Entity Name    |123-57 Sanford Avenue, LLC            |
        |Document Status               |Enforced                              |
      And User will click on terminate icon
      And User will select acting as LEIs for edit
        | Acting as            |
        | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
        |Action type |
        |Terminate Document|
      And Click on Submit
      Then User validates the Document approved message
        |Document is terminated|
  Then User validate that doc status has been changed to terminated

    @Sanity @fixed
    Scenario: Validate delete functionality for DN
      Given User resets DN document
        | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
        | pbLeiId     | 254900SLCV8KI86BHL86                 |
        | ebLeiId     | 549300ZLVED0VPNQPO73                 |
        | clientLeiId | 724500Q59D1FS2E4PI53                 |
    Then User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB 1             |3G Fund, L.P.                          |
      |Client 1         |Koudenburg B.V.                        |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    And User clicks on Cancel button
      When User clicks on Column Selection button
      And User will search for column, selects it if not already selected and validates the same on Document listing screen
        | Column Name                  |
        | PB-1 Legal Entity Name       |
        | Client-1 Legal Entity Name   |
        | EB-1 Legal Entity Name       |
    And user will select Column Values on Document listing screen
      |Column Name                   |value             |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED             |
      |EB-1 Legal Entity Name        |3G Fund, L.P.     |
      |Client-1 Legal Entity Name    |Koudenburg B.V. |
      And User click on delete button
      Then User validates the Document approved message
        |Document is deleted|

  Scenario: User creates a DN such that DF exists
    Given User is on Document Framework Page
        Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 549300Y0KRJ81QOQO128                 |
    Then User creates a document framework through API
      |Payload path|
      |src/test/java/resources/DF_Creation_MR7.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds General Terms via API for DN Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                     |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED     |
      |EB Name       |1101214 ONTARIO INC.                      |
    Then User clicks on edit icon
    #Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And Click on + Add currencies
    And User validates the Deliverable, Non-Deliverable are displayed
    And User selects the currency group pair in AuthScope
      |Automation_OT_CurrencyPairGroup|
    And User selects the currency group in AuthScope
      |Automation_OT_currencyGroup|
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
      |COP|
      |CRC|
      |ISK|
    And User will submit the changes
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User will go to Document screen
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 549300Y0KRJ81QOQO128                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED           |
      |EB 1             |1101214 ONTARIO INC.           |
      |Client 1         |CITIGROUP INC.           |
    Then User clicks on Next button
    Then User validates the toast message
      |Document Created|
#  Then User is on create new approval group screen
#    When User generates unique the group name,organization name,LEI's,org type
#      | group name | organisation name   | doc type | LEI's          | org type |
#      |Automation_| OSTTRA INDIA SERVICES PRIVATE LIMITED      | DN    | 121 WACKER, LLC | PB       |
#    Then clicks on next
#    And user is redirected to update approval group screen
#    And User will search for the users to be added and add them
#      |user|
#      |hsbc.test1@testsso.osttra.com|
#    And  User will submit the changes after adding users to the approval group
#    Given User is on the create approval matrix screen
#    Then user validates and fills the organization filter,LEI filter,org type filter,doc type filter on create approval matrix screen
#      |organisation name|LEI filter |org type filter|doc type filter|
#      |OSTTRA INDIA SERVICES PRIVATE LIMITED            |121 WACKER, LLC      |PB             |DN          |
#    Then User will drag and drop to Edit Document option
#    Then User will use drag and drop PB1 to approval Seq 1 in DF