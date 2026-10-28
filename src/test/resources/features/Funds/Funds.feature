@Regression @Funds

Feature: Validating Funds Functionality

  @TC=2210 @TC=2212 @TC-2213 @TC-2214 @TC=2216 @TC-2218 @TC-2219 @TC-2220 @TC-2225 @TC-2236
  Scenario: Validate the elements & button on Funds Screen
    Given User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User validates the Add Funds Options for 4way
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User validates the Add Funds Options for DN
    And User clicks on Add fund button DN
    And Validate the elements on Funds Page
    And User validates no record found
    Then User add the funds
      | Funds                  |
      | 1355 STORM PARKWAY LLC |
      | 6SHGI4ZSSLCXXQSBB395   |
    Then Verify Add button visible while adding new Funds in Search box
    And User clicks on Save button
    And User clicks on Add fund button DN
    Then User validates the added funds
      | Funds    | Value                  |
      | LEI Name | 1355 STORM PARKWAY LLC |
      | LEI ID   | 9845008BSEED6B1A9984   |

  @TC=2223 @TC=2224
  Scenario: Validate that changing doc type should Reset Funds
    Given User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User validates the Add Funds Options for 4way
    And User clicks on Add fund button for client1
    Then User add the funds
      | Funds                  |
      | 1355 STORM PARKWAY LLC |
      | 6SHGI4ZSSLCXXQSBB395   |
    And User clicks on Save button
    And User clicks on Add fund button for client2
    Then User add the funds
      | Funds                  |
      | 1355 STORM PARKWAY LLC |
      | 6SHGI4ZSSLCXXQSBB395   |
    And User clicks on Save button
    And User clicks on Add fund button for client1
    Then User validates the added funds
      | Funds    | Value                  |
      | LEI Name | 1355 STORM PARKWAY LLC |
      | LEI ID   | 9845008BSEED6B1A9984   |
    And User removes all funds from client1
    Then User clicks on Cancel button
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User clicks on Add fund button for client1
    And User validates no record found

  @TC=2222
  Scenario: Verify User is able to Remove Funds
    Given User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User validates the Add Funds Options for 4way
    And User clicks on Add fund button for client1
    Then User add the funds
      | Funds                  |
      | 1355 STORM PARKWAY LLC |
      | 6SHGI4ZSSLCXXQSBB395   |
    And User clicks on Save button
    And User clicks on Add fund button for client1
    Then User remove the funds
      | Funds                  |
      | 1355 STORM PARKWAY LLC |
      | 9845008BSEED6B1A9984   |
    And User clicks on Save button
    And User clicks on Add fund button for client1
    Then User remove the funds
      | Funds                |
      | CITIGROUP INC.       |
      | 6SHGI4ZSSLCXXQSBB395 |
    And User clicks on Save button
    And User clicks on Add fund button for client1
    And User validates no record found

  @TC-6663
  Scenario: To validate the funds can be added of length 100
    Given User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User clicks on Add fund button for client1
    And User adds a fund with 100 characters to validate input capacity
    And User clicks on Add Button
    And User clicks on Save button
    And User clicks on Add fund button for client1
    Then User validates text is visible
      | Text                                                                                                 |
      | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA |
  Then User clicks on Cancel button

