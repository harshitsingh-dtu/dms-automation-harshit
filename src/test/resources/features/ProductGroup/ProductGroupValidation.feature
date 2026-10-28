@productgroup @ProductGroupValidation @Fixed
@Regression
Feature: Workflow for Product Group Validation


  @TC-2547 @TC-2573 @DMGS-7478 @TC=08 @ignored
  Scenario: User creates a new document and verifies Expand/Collapse All functionality for Auth scope
    Given User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    When User select unique parties as Client1,PrimeBroker2
      | Prime Broker 1                        | Clients 1                  | Prime Broker 2                  | Clients 2                  |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | Acuitas Group Holdings LLC | CHECKOUT PAYMENTS GROUP LIMITED | BROADSTONE SUMMERHILL, LLC |
    Then User clicks on Next button
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
##    Then User add Auth line in Auth Scope
    Then User is on the Dashboard page and navigate to Product Group
    When User clicks on Create Product Group
    And Enters the new Product group name
      | Product Group Name |
      | Test_Automation_PG |
    And Select the Organisation Name
      | Organisation Name |
      | All               |
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family |
      | Cash           |
    And Select product in Auth Product
      | Product |
      | Spot    |
      | Future  |
    Then Click on Add Product Line
    And Click on Submit
    Then User is on Document Page Again
    When User clicks on Column Selection button
    Then User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | PB-2 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Client-2 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | PB-2 Legal Entity Name     | CHECKOUT PAYMENTS GROUP LIMITED       |
      | Client-1 Legal Entity Name | Acuitas Group Holdings LLC            |
      | Client-2 Legal Entity Name | BROADSTONE SUMMERHILL, LLC            |
    And User clicks on edit icon
    Then User clicks on Auth Scope Tab
    * User will select Auth Product Group
      | Auth Product Group |
      | Test_Automation_PG |
    And User adds Currencies
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And Clicks on ExpandAll button
    And User validates product lines are expanded
    And User validates CollapseAll button
    And User Deletes Product Line to the product group
#    And User Deletes Product Line to the product group
    And User validates CollapseAll button should not be there
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Exotic Options | Asian   |
    And User adds Currencies
#    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    * User will input Calculation Type
      | Calculation Type |
      | DSL              |
    Then User enters limit value on Edit limit screen Again
      | Limit Value |
      | 99999       |
    * User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    * User will input Delta
      | Delta |
      | No    |
    * User will input Product family
      | Product Family |
      | Cash           |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | No          |
    Then User clicks on Add Limit button
    Then User clicks on NextButton Again
    Then User clicks on NextButton Again
#    Then Verify no click elements
#    Then User clicks on "No"
#    Then User adds LimitScope via API for Document or Document Framework
#    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User waits for some time, refreshes the page and validates the status

  @TC-2574 @ignored
  Scenario: Validates the expand All functionality when all attributes are already expanded of Draft Document (Run TC-2573 of DocumentCreation before this)
    Given User is on Document Page
    When User clicks on Column Selection button
    Then User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | PB-2 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Client-2 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | PB-2 Legal Entity Name     | CHECKOUT PAYMENTS GROUP LIMITED       |
      | Client-1 Legal Entity Name | Acuitas Group Holdings LLC            |
      | Client-2 Legal Entity Name | BROADSTONE SUMMERHILL, LLC            |
#    Then User clicks on Create New Document
#    Then User select document type,acting as
#      | Document Type | Acting As |
#      | 4 Way         | PB        |
#    When User select unique parties as Client1,PrimeBroker2
#      | Prime Broker 1 | Clients 1                  | Prime Broker 2                  | Clients 2                  |
#      | OSTTRA         | Acuitas Group Holdings LLC | CHECKOUT PAYMENTS GROUP LIMITED | BROADSTONE SUMMERHILL, LLC |
#    Then User clicks on Next button
#    Then User clicks on Next button
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type   |
      | EDIT DOCUMENT |
    And User will click on submit
    Then User clicks on Auth Scope Tab
    * User will select Auth Product Group
      | Auth Product Group |
      | Test_Automation_PG |
    And User adds Currencies
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Expand Icon
    Then User validates CollapseAll button
    Then User clicks on Next button

  @TC-2575, @2577 @ignored
  Scenario: Validates the expand All functionality when some attributes are already expanded of Draft Document (Run TC-2574 of DocumentCreation before this)
    Given user will select Column Values on Document listing screen
      | Column Name     | value |
      | Document Status | Draft |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product          |
      | FX          | Exotic Options | European Digital |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And User will submit the changes
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor    |
      | Calendar Days |
    And User clicks on Add Auth Line
    Then User clicks on one Expand Icon and validates it
    Then Clicks on ExpandAll button
    And User validates product lines are expanded
    And User validates CollapseAll button
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User waits for some time, refreshes the page and validates the status

  @TC-2577  @ignored
  Scenario: Validates the expand All functionality when some attributes are already expanded of Enforced Document
    Given user will select Column Values on Document listing screen
      | Column Name     | value    |
      | Document Status | Enforced |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | 549300TVVMO4C1HNSG64 |
    And User select Action type in the edit pop up screen
      | action type   |
      | Edit Document |
    And click on the submit button on the edit pop up screen
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product          |
      | FX          | Exotic Options | European Digital |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
    And User will submit the changes
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor    |
      | Calendar Days |
    And User clicks on Add Auth Line
    Then User clicks on one Expand Icon and validates it
    Then Clicks on ExpandAll button
    And User validates product lines are expanded
    And User validates CollapseAll button


