@Regression @DashboardValidations
@US=DMGS-8051
Feature: Validate Columns and filters on DF Dashboard, Document Dashboard, Bulk edit screen

  @TC_02
  Scenario: Verify Drag Handle count for Dashboard, Bulk edit on Column Selection
    Given User is on Document Page
    When User clicks on Column Selection button
    And User verifies the Drag handle is visible for each column on Document Dashboard
    Then User clicks on BulkAction button
    Then User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as          |
      |254900SLCV8KI86BHL86|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT|
    Then User clicks on NextButton
    Then User clicks on Column Selection button
    And User verifies the Drag handle is visible for each column on Document Dashboard
    Then User is on Document Framework Page Again
    Then User clicks on Column Selection button
    And User verifies the Drag handle is visible for each column on DF Dashboard

  @TC_02
  Scenario: Verify Re-order column "Cancel button" via Drag & Drop of Document Dashboard & Bulk action
    Given User is on Document Page
    When User clicks on Column Selection button
    And User Drags the column to the top
      |Column Name         |
      |Document type       |
    Then User clicks on Cancel button
    And User verify the sequence of Columns
      |Sequence             |
      |Document ID          |
      |Document version ID  |
      |Document status      |
    Then User clicks on BulkAction button
    Then User clicks on editButton for BulkEdit
    Then User waits for 2 seconds
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as          |
      |254900SLCV8KI86BHL86|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT|
    Then User clicks on NextButton
    Then User waits for 2 seconds
    When User clicks on Column Selection button
    And User Drags the column to the top
      |Column Name         |
      |Document type       |
    Then User clicks on Cancel button
    And User verify the sequence of Columns for Bulk Edit Screen
      |Sequence             |
      |Document ID          |
      |Document version ID  |
      |Document status      |

  @TC_03 @TC_06
  Scenario: Verify Re-order column "Accept Button" via Drag & Drop of Document Dashboard & Bulk action
    Given User is on Document Page
    When User clicks on Column Selection button
    And User Drags the column to the top
      |Column Name         |
      |Document status     |
    Then User can see Apply button on the Add Edit screen
    Then User clicks on Apply button
    And User verify the sequence of Columns
      |Sequence             |
      |Document status      |
      |Document ID          |
      |Document version ID  |
    Then User refreshes the browser
    And User verify the sequence of Columns
      |Sequence             |
      |Document status      |
      |Document ID          |
      |Document version ID  |
    Then User clicks on BulkAction button
    Then User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as          |
      |254900SLCV8KI86BHL86|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT|
    Then User clicks on NextButton
    When User clicks on Column Selection button
    And User Drags the column to the top
      |Column Name         |
      |Document status     |
    Then User can see Apply button on the Add Edit screen
    Then User clicks on Apply button
    And User verify the sequence of Columns for Bulk Edit Screen
      |Sequence             |
      |Document status      |
      |Document ID          |
      |Document version ID  |
    Then User refreshes the browser
    And User verify the sequence of Columns for Bulk Edit Screen
      |Sequence             |
      |Document status      |
      |Document ID          |
      |Document version ID  |

  @TC_02 @TC_03 @TC_011
  Scenario: Verify Drag & Drop of DF Dashboard
    Given User is on Document Framework Page
    When User clicks on Column Selection button
    And User Drags the column to the top
      |Column Name         |
      |Lifecycle status    |
    Then User clicks on Apply button
    And User verify the sequence of Columns
      |Sequence             |
      |Lifecycle status     |
      |Document framework ID |
      |DF version ID        |
    Then User refreshes the browser
    And User verify the sequence of Columns
      |Sequence             |
      |Lifecycle status     |
      |Document framework ID                |
      |DF version ID        |

  @TC_04
  Scenario: Validating logging out and logging back in, the user’s custom column arrangement is preserved
    Given User is on Document Page
    And User verify the sequence of Columns
      |Sequence             |
      |Document status      |
      |Document ID          |
      |Document version ID  |
    Then User clicks on BulkAction button
    Then User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as          |
      |254900SLCV8KI86BHL86|
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT|
    Then User clicks on NextButton
    And User verify the sequence of Columns for Bulk Edit Screen
      |Sequence             |
      |Document status      |
      |Document ID          |
      |Document version ID  |
    Then User is on Document Framework Page Again
    And User verify the sequence of Columns
      |Sequence             |
      |Lifecycle status     |
      |Document framework ID|
      |DF version ID        |

#Step def for line no.172 to be shared by Akshita
#  @TC_01 @TC_09
#  Scenario: Login as diff user & verify default sequence for EDN & DF Dashboard
#    Given User is on Document Page
#    Then A secondary user logs into the application in an incognito window
#    And User verify the sequence of Columns
#      |Sequence             |
#      |Document ID          |
#      |Document Version ID  |
#      |Document Status      |
#      |Document Type        |
#    Then User clicks on BulkAction button
#    Then User clicks on editButton for BulkEdit
#    Then User will select doc type for edit
#      | Doc Type |
#      | 4 way    |
#    Then User will select acting as LEIs for edit
#      | Acting as          |
#      |254900SLCV8KI86BHL86|
#    And User will select action type for edit
#      | Action type |
#      | EDIT LIMIT|
#    Then User clicks on NextButton
#    And User verify the sequence of Columns for Bulk Edit Screen
#      |Sequence             |
#      |Document ID          |
#      |Document Version ID  |
#      |Document Status      |
#      |Document Type        |
#    Then User is on Document Framework Page Again
#    And User verify the sequence of Columns
#      |Sequence             |
#      |DF ID                |
#      |DF Version ID        |
#      |Lifecycle status     |

@ResetData
  Scenario: Resetting the Data back to original sequence
    Given User is on Document Page
    When User clicks on Column Selection button
    And User Drags the column to 3rd position
      |Column Name         |
      |Document status     |
    Then User can see Apply button on the Add Edit screen
    Then User clicks on Apply button
    And User verify the sequence of Columns
      |Sequence             |
      |Document ID          |
      |Document version ID  |
      |Document status      |
    Then User refreshes the browser
    And User verify the sequence of Columns
      |Sequence             |
      |Document ID          |
      |Document version ID  |
      |Document status      |
  Then User clicks on BulkAction button
  Then User clicks on editButton for BulkEdit
  Then User will select doc type for edit
    | Doc Type |
    | 4 way    |
  Then User will select acting as LEIs for edit
    | Acting as          |
    |254900SLCV8KI86BHL86|
  And User will select action type for edit
    | Action type |
    | EDIT LIMIT|
  Then User clicks on NextButton
  When User clicks on Column Selection button
  And User Drags the column to 3rd position
    |Column Name         |
    |Document status     |
  Then User can see Apply button on the Add Edit screen
  Then User clicks on Apply button
  And User verify the sequence of Columns for Bulk Edit Screen
    |Sequence             |
    |Document ID          |
    |Document version ID  |
    |Document status      |
  Then User refreshes the browser
  And User verify the sequence of Columns for Bulk Edit Screen
    |Sequence             |
    |Document ID          |
    |Document version ID  |
    |Document status      |
    Then User is on Document Framework Page Again
    When User clicks on Column Selection button
    And User Drags the column to 3rd position
      |Column Name         |
      |Lifecycle status    |
    Then User clicks on Apply button
    And User verify the sequence of Columns
      |Sequence             |
      |Document framework ID                |
      |DF version ID        |
      |Lifecycle status     |
    Then User refreshes the browser
    And User verify the sequence of Columns
      |Sequence             |
      |Document framework ID                |
      |DF version ID        |
      |Lifecycle status     |