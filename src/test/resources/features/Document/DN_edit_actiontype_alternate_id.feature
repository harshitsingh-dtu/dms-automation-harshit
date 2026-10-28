@alternate_id  @Regression
Feature: User validates the edit alternate id action type
  @US=DMGS-8954
  Scenario: Verify push notification is enabled or not . If not enabled then enable it.
    Given User navigates to the organisation screen
    Then User validates DN Push Notification button on Organisation Screen
    Then User searches the Organisation
      |search_orgname |
      | BARCLAYS PLC  |
    And User click toggle button for DN Push Notification to enable

 @TC-2853 @TC-2854 @TC-2855 @TC-2856 @TC-2848 @TC-2849
  Scenario: User validates the edit alternate  id should be visible for edit enforced DN doc type and user can update it
   Given User will go to Document screen
   And user will select Column Values on Document listing screen
     | Column Name            | value                                 |
     | PB-1 legal entity name | BARCLAYS PLC                         |
     | EB-1 legal entity name | OSTTRA INDIA SERVICES PRIVATE LIMITED|
     | Client 1               | CITIGROUP INC.                       |
     | Document Status        | Enforced                              |
   Then User clicks on edit icon
   And User will select acting as LEIs for edit
     | Acting as            |
     | BARCLAYS PLC |
  And User select Action type in the edit pop up screen
  | action type   |
  | Edit Alternate ID |
  And click on the submit button on the edit pop up screen
  Then User enters dynamic alternate IDs for Client and EB
  And User click on the Save button for edit alternate id
   Then User validates the Document approved message
      | Alternate IDs updated successfully |

    @TC-2857
  Scenario: User validates the edit alternate  id should not  be visible for edit  4way  doc
      Given User will go to Document screen
      And user will select Column Values on Document listing screen
        |Column Name                 |value                |
        |PB-1 legal entity name       |BARCLAYS PLC |
        |Client-1 legal entity name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
        |PB-2 legal entity Name        |CITIC Capital China Partners III, L.P.      |
        |Client-2 legal entity name    |CITIC Capital China Partners III, L.P.      |
        | Document Status              | Enforced            |
      Then User clicks on edit icon
      And User will select acting as LEIs for edit
        | Acting as            |
        | BARCLAYS PLC |
      And User will type into action type for edit
        | Action type |
        | Edit Alternate ID   |
      And Validate No options should be displayed

  Scenario: validate that edit alternate  id option is visible for In-approval DN
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 legal entity name    | BARCLAYS PLC |
      | EB-1 legal entity name     | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client-1 legal entity Name | CITIGROUP INC.                      |
      | Document Status        | In-approval                              |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | BARCLAYS PLC |
    And User select Action type in the edit pop up screen
      | action type   |
      | Edit Alternate ID |
    And click on the submit button on the edit pop up screen
    Then  User enters dynamic alternate IDs for Client and EB
    And User click on the Save button for edit alternate id
    Then User validates the Document approved message
      | Alternate IDs updated successfully |


