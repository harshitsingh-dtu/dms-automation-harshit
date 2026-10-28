@DocumentFramework @Regression
@AssociatedDocCount @AssociatedDocCount_And_EnforcementRules

Feature: Associated Doc Count & Enforcement Rule validation

#  Created by MR - @DocumentFrameworkCreation2
@TC=6782 @TC=6783 @TC=6784 @TC=6785
  Scenario: Validate Associated Doc Count page, column values, search functionality
    Given User is on Document Framework Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name            |
    | Associated Doc Count   |
    And user will select Column Values on Document Framework screen
      |Column Name          |value                                 |
      |PB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name |3G Fund, L.P.                         |
      |Lifecycle status     |Approved                              |
  And User navigates to Associated Doc Count Column
  And User click on Associated Doc Count
  Then User validates Associated Doc Count pop-up
  And Validate the Components on Associated Doc Count Screen
  Then User validates the searching functionality
  And User validates Close button
  And User clicks on close button
  Then Validate User is on Document Framework Screen

@TC=6786 @TC=6788
  Scenario: Validate Associated DN button in DF preview and Framework Status
    Given User is on Document Framework Page
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name  |
    | DF Status    |
    And user will select Column Values on Document Framework screen
      |Column Name          |value                                 |
      |PB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name |3G Fund, L.P.                         |
      |Lifecycle status     |Approved                              |
    And User clicks on Preview of DF
    And User captures the DF version ID
    Then User validates the Associated DNs tab
    And User clicks on cross icon
    Then User validates the Framework status
    |Status|
    |Active|

@TC=6787 @TC=6825
  Scenario: Validate Associated DN button is visible on DF edit (functionality changed)
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name          |value                                 |
      |PB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name |3G Fund, L.P.                         |
      |Lifecycle status     |Approved                              |
    Then User clicks on edit icon
    And User will click on Submit Button
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment    |
      |Immediate          |Immediate        |
    And User clicks on Save As Draft button
    And User clicks on Cancel button
    Then user will select Column Values on Document Framework screen
      |Column Name          |value                                 |
      |PB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name |3G Fund, L.P.                         |
      |Lifecycle status     |Draft                                 |
#    And Validate Associated Doc count value for stored DF
#      |Doc Count Value|
#      |0              |
    And User validates Associated Doc count value row
    |Doc Count Value|
    |0               |

  #DMGS-8782 bug
@TC=6893 @TC-6896 @TC-UserSpecific @Bug=DMGS-7226 @ignore
Scenario: Validate Enforcement Rule on DF edit
    Given User is on Document Framework Page
    Then user will select Column Values on Document Framework screen
      |Column Name          |value                                 |
      |PB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name |3G Fund, L.P.                         |
      |Lifecycle status     |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on enforcement rules tab for DF
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |value |Duration |
      |Immediate          |Schedule           |1     |hour     |
    And User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User validates Scope change Preview tab is visible
    Then User validates for "For amendment" value changed from "Immediate" to "Scheduled"
    And User waits for 5 seconds
    And User clicks on submit for approval button on version Compare screen
    And User clicks on ignore button for name change
    And user will select Column Values on Document Framework screen
        |Column Name          |value                                 |
        |PB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
        |EB Name |3G Fund, L.P.                         |
        |Lifecycle status     |Approved                              |
    And Validate No options should Not be displayed

  @TC=7093
  Scenario: Validate there is no impact on DN when an approved & active DF is edited
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |3G Fund, L.P.        |
      |Client-1 Legal Entity Name    |3G Fund, L.P.        |
    Then User clicks on edit icon
#    And User waits for 10 seconds
#    And User will select action type for edit
#      | Action type |
#      | EDIT LIMIT  |
#    And User will click on Submit Button
    And User waits for 5 seconds
    Then User clicks on Limit Scope Tab DN
    Then User enable the Limit line and validate the same