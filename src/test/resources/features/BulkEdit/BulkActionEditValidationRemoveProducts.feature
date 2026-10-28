@smoke
 @document_type=4-way
Feature: Workflow for Bulk Action Edit remove product validation
  Background:

    Given User is on DocumentPage
    Then User clicks on BulkAction button
    And User selects edit button
    And User clicks on editButton for BulkEdit


  Scenario: Verify back button and its popup
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE PRODUCT|
    Then User clicks on NextButton
    And Select document to remove currency
      |Document ID|
      |4W-776690-A|
    And Verify next button and click
    And Verify select product family
    |product family|
    |cash|
    And Verify product selection
    |product|
    |Future|
    And Verify remove product line button
    And Verify and click back button
    And verify Confirmation popup


  Scenario: Verify select product
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE PRODUCT|
    Then User clicks on NextButton
    And Select document to remove currency
      |Document ID|
      |4W-776690-A|
    And Verify next button and click
    And Verify select product family
      |product family|
      |cash|
    And Verify product selection
      |product|
      |Future|
    And Verify remove product line button


  Scenario: Verify submit for approval button
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE PRODUCT|
    Then User clicks on NextButton
    And Select document to remove currency
      |Document ID|
      |4W-776690-A|
    And Verify next button and click
    And Verify select product family
      |product family|
      |cash|
    And Verify product selection
      |product|
      |Future|
    And Verify remove product line button
    And Verify submit for approval button for remove product


#    this will break
  Scenario: Verify cancel button
    Then User will select doc type for edit
      | Doc Type |
      | 4 way   |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |254900SLCV8KI86BHL86 (PB)|
    And User will select action type for edit
      | Action type |
      | REMOVE PRODUCT|
    Then User clicks on NextButton
    And verify cancel button
