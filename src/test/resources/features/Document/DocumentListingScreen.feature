@Regression @DocumentListingScreen
Feature: Workflow for Basic filtering of Document page

  @TC=215
  Scenario: Verify document listing page
    Given User is on Document Page
    And User can see all the default columns in the document listing screen
    When User set the filter on the all document screen
      |filter|
      |draft |
    Then User is able to see the Compare button
    And User is able to see the Edit button
    And User is able to see the Delete button
    Then User removes the filter
    When User set the filter on the all document screen
      |filter|
      |Enforced |
    Then User is able to see the Edit button
    And User is able to see the Terminate button
    And User is able to see the Download button
    And User is able to see the Copy button
    Then User removes the filter
    When User set the filter on the all document screen
      |filter|
      |Expired |
    Then User is able to see the Compare button
    And Verify that No Terminate button is visible
    Then User removes the filter
    When User set the filter on the all document screen
      |filter|
      |Terminated |
    And User is able to see the Delete button
    Then User removes the filter
    When User set the filter on the all document screen
      |filter|
      |Rejected |
    Then User is able to see the Compare button

  @TC=86 @TC=95 @TC=87
  Scenario: verify track status is enabled, window pop-up & closed
    Given User is on Document Page
    When User set the filter on the all document screen
      |filter|
      |In-approval |
    And User can see the track button on the document screen
    And User will click on Track button
    And User will be redirected to the track screen
    Then User clicks on close button