@Regression @DMGS-8959
Feature: Re-add columns and filters showing emails and user identifiers (DMGS-8959)

  Background:
    Given User is on the Dashboard

  @TC-01
  Scenario: Validate that user is able to view the ‘Last updated by’ column and the associated filter from the Document Framework report
    Given User is on Document Framework Page
    Then Validate User is on Document Framework Screen
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name     |
      | Last updated by |
    And User verifies "Last updated by" column is visible
    And User verifies "Last updated by" filter is visible

  @TC-02 @TC-03
  Scenario: Validate that user is able to view or add the ‘Last updated by’ column and the associated filter from the Documents dashboard
    Given User will go to Document screen
    Then User clicks on Column Selection button
    And Verify columns are visible
      | Last updated by |
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name     |
      | Last updated by |
    And User verifies "Last updated by" column is visible
    And User verifies "Last updated by" filter is visible
    When User applies filter on Document Screen
      | Column Name     | value                         |
      | Last updated by | hsbc.test1@testsso.osttra.com |
    And User verifies data is populated in the "Last updated by" column
      | value                         |
      | hsbc.test1@testsso.osttra.com |

  @TC-04
  Scenario: Validate that Last updated by column is available in query filter
    Given User will go to Document screen

    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name     |
      | Last updated by |
    When User will click on the Add Edit query button
    And User will be redirected to Add Edit query screen
    And User clicks on Add query block
    Then User verifies "Last updated by" is available in query fields
    And User performs multiple Add query block
      | field           | operator | value                         | condition |
      | Document Status | =        | Draft                         | AND       |
      | Last updated by | =        | hsbc.test1@testsso.osttra.com | null      |
    Then User clicks on apply button without saving
    Then User validates the document status
      | status |
      | Draft  |
    And User verifies "Last updated by" column is visible
    And User verifies data is populated in the "Last updated by" column
      | value                         |
      | hsbc.test1@testsso.osttra.com |

  @TC-05
  Scenario: Validate that Last updated by column is available on bulk edit page
    Given User will go to Document screen
    Then User clicks on Bulk Action button
    Then User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as            |
      | 254900SLCV8KI86BHL86 |
    And User will select action type for edit
      | Action type |
      | Edit Limit  |
    Then User clicks on Next button
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name     |
      | Last updated by |
    Then User verifies "Last updated by" column is visible

  @TC-06 @TC-07
  Scenario: Validate that user is able to view the ‘Requested by’ or 'Reviewed by' columns and the associated filters from the Approval Request report
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 549300ZLVED0VPNQPO73                 |
      | clientLeiId | 724500WVLWTWJCP7Q082                 |
    Given User is on the all document screen
    And User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      | User                         |
      | automation.user3@yopmail.com |
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    Then User is able to remove all the role
    And User is able to assign a role
      | role mapping     |
      | DN Org View Only |
    And User removes all existing LEI Org type mappings
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | DN       |
    And User is able to select LEI from LEIs dropdown
      | LEI                                   |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
    And user will submit the changes
#  Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    Then User will click on Request to Create new document button and redirected to Request to Create new document screen
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | 3G Fund, L.P.                         |
      | Client 1       | AmstelVisie B.V.                      |
    And User will Click on Submit Request button and navigate to see Define Reviewer POPUP
    And User will Select Reviewer and Click on Submit Button and Get Success POPUP With Gotit Button
    And Close the secondary browser
    And The primary browser launches again
    Then User is on Document Page
    And Verify Approval Request tab should be visible
    Then User locates the pending request for "automation.user3@yopmail.com" and clicks Approve
    Then User verifies "Requested by" column is visible on Approval Request report
    And User verifies "Reviewed by" column is visible on Approval Request report
    And User verifies "Select requester" filter is visible on Approval Request report
    And User verifies "Select reviewer" filter is visible on Approval Request report
    When User inputs email filters in Approval Request report
      | filter_type      | email_value                   |
      | Select requester | automation.user3@yopmail.com  |
      | Select reviewer  | hsbc.test1@testsso.osttra.com |
    And User verifies the retrieved records display the filtered email in "Requested by" column
    And User verifies the retrieved records display the filtered email in "Reviewed by" column

  @TC-08
  Scenario: Validate that user is able to view the ‘Last updated by’ column and the associated filter from the Approval Agreements report
    Given User is on Approval Agreement Screen
    Then User verifies "Last updated by" column is visible
    And User verifies "Last updated by" filter is visible on Approval Agreements report
    When User inputs email filter in Approval Agreements report
      | filter_type     | email_value                   |
      | Last updated by | hsbc.test1@testsso.osttra.com |
    And User verifies the retrieved records display the filtered email address in Approval Agreements report column

  @TC-09
  Scenario: Validate that user is able to view the ‘User’ column from the Approval Agreements History report
    Given User is on Approval Agreement Screen
    When User opens Approval Agreements History report
    Then User verifies "User" column is visible in history report
    And User verifies data is populated with email addresses in History report User column