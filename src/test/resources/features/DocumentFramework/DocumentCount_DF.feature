@DocumentFramework @Regression
@DocumentCount

Feature: Validate document count on document framework listing screen

  @TC-6782 @TC-6783 @TC-6784 @TC-6785 @TC-6788 @ignored @DMGS-10253
  Scenario: Validated associated doc count drawer
    Given User is on Document Framework Page
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB Name        |
      | EB Name        |
      | Lifecycle status    |
    And user will select Column Values on Document Framework screen
      |Column Name   |value             |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name       |CITIGROUP INC. |
      | Lifecycle status|Approved                 |
#    And User checks if Document already exists
#    And Check document framework life cycle status
    And User clicks on doc count
    Then Validate user reach to associated document listing screen
    Then Validate document ID & version ID search box in Associated Document on DF
    Then Validate user click on close & return to document framework screen
    And Validate user is on Document Framework Screen

  @TC-6786 @ignored @DMGS-10253
  Scenario: Validated associated doc on document preview
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value       |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
      |EB Name       |CITIGROUP INC.      |
      | Lifecycle status|Approved                 |
    And User clicks on document version then associated document
    Then Validate user reach to associated document listing screen

    @TC-6787 @TC-6825 @ignored @DMGS-10253
  Scenario: Validated associated doc on document edit preview
    Given User is on Document Framework Page
      And user will select Column Values on Document Framework screen
        |Column Name   |value       |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED      |
        |EB Name       |CITIGROUP INC. |
        | Lifecycle status|Approved                 |
      And User checks if Document already exists
#    And user will select Column Values on Document Framework screen
#      |Column Name   |value       |
#      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
#      |EB Name       |CITIGROUP INC.      |
    And User Click on edit icon then select acting as
    And User click on submit button on DF
      Then User is able to see approval workflow tab for DF
      And User clicks on Cancel button
#    And Validate user reach to associated document listing screen
#    Then  User close associated doc for draft document framework
      And user will select Column Values on Document Framework screen
        |Column Name   |value       |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
        |EB Name       |CITIGROUP INC.      |
    And user selects the lifecycle status filter value for DF
        |lifeCycle status|
        |draft        |
      And User clicks on document version then associated document for draft DF
#      Then Validate user reach to associated document listing screen for draft DF


@US=DMGS-7138
  Scenario: Verify that user can download data from the DF Dashboard to Excel format file.
    Given User is on Document Framework Page
    Then User clicks on the download button
    Then User validates the file is downloaded