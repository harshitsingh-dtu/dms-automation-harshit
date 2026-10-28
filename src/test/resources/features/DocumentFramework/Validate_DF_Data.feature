@DocumentFramework @Regression
@Notification

Feature: Validate clicking on Restriction Version ID on Restriction listing screen should display correct Data

  @TC=6601
  Scenario: Validate that terminate button should be NOT be visible for any other status than approved/inactive MA docs.
    Given User is on Document Framework Page
    Then user will select value for Lifecycle Status filter value
      |Lifecycle status|
      |Terminated|
    Then Verify that No Terminate button is visible
    Then user will select value for Lifecycle Status filter value
      |Lifecycle status|
      |Cancelled|
    Then Verify that No Terminate button is visible
    Then user will select value for Lifecycle Status filter value
      |Lifecycle status|
      |Draft|
    Then Verify that No Terminate button is visible
    Then user will select value for Lifecycle Status filter value
      |Lifecycle status|
      |In-approval|
    Then Verify that No Terminate button is visible
    Then user will select value for Lifecycle Status filter value
      |Lifecycle status|
      |Expired|
    Then Verify that No Terminate button is visible