@LegalEntityName @Regression

Feature: Renaming of 'LEI Name' changed to 'Legal Entity Name'

  @TC-2496 @TC=6656
  Scenario:Validate renaming on approval group column
    Given User is on Document Page
    When User is on Approval group screen
    Then User should be able to see headers of approval Group table
    Then User searches for Approval group name in the search bar and validates
      |group name|
      |Automation_MR_AG_Empty_|
    Then User clicks on update button
    And User validates the renaming at approval group update page

  @TC-2497 @TC=6657
  Scenario:Validate renaming on approval matrix column
    Given User is on Document Page
    When user is on approval matrix listing screen
    Then user will be able to see organization name, LEIs name, org type, doc type, created on, action
    When user searches for a approval matrix and validates the results
      |approval matrix |LEI name  |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
    And user clicks on the update button
    Then User validates the renaming at approval matrix update page

  @TC-2499
  Scenario: Verify renaming on add/edit query in documents.
    Given User is on Document Page
    And User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    When User gives the unique query name on Add Edit screen
      |query name|
      |auto_test_13th|
    And User clicks on Add query block
    And User selects the field operator and value
      |field|operator|value|
      |PB-1 Legal Entity Name|= |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User selects the field operator and value
      |field|operator|value|
      |PB-2 Legal Entity Name|= |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User selects the field operator and value
      |field|operator|value|
      |Client-1 Legal Entity Name|= |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User selects the field operator and value
      |field|operator|value|
      |Client-2 Legal Entity Name|= |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User selects the field operator and value
      |field|operator|value|
      |EB-1 Legal Entity Name|= |OSTTRA INDIA SERVICES PRIVATE LIMITED |