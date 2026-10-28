@EDN_Copy_Delete @Regression
@US=DMGS-3206 @US=DMGS-2818 @US=DMGS-3484

Feature: Validate Client is removed from DN edits

  @TC=7107
  Scenario: Validate that while creating DN document, in acting as only PB & EB is visible and client is removed
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User clicks on Acting as DropDown
    And User Validates Client is not displayed in DropDown

  @TC=7108
#  @TC=7111
  Scenario: Validate that while editing enforced DN document, in acting as client is removed
    Given User will go to Document screen
#    And User will search for column, selects it if not already selected and validates the same on Document listing screen
#      | Column Name    |
#      | PB-1 Legal Entity Name  |
#      | Client-1 Legal Entity Name   |
#      | EB-1 Legal Entity Name     |
    And User unselects the Show only latest version checkbox if it is selected
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.        |
      |Document Status              |Enforced             |
    Then User clicks on edit icon
    Then User will clear Selecting As filter
    And User searches for acting as value in DF DN Screen
      | Acting as |
      | Client    |
    Then Validate No options should be displayed
    Then User clicks on Cancel button
    Then User clicks on Terminate button
    Then User will clear Selecting As filter
    And User searches for acting as value in DF DN Screen
      | Acting as |
      | Client    |
    Then Validate No options should be displayed

  @TC=7109
  Scenario: Validate that on editing enforced DN document, the in acting as client is removed from the options
    Given User will go to Document screen
    Then User clicks on BulkAction button
    Then User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | DN       |
    Then User will select acting as LEIs for edit
      | Acting as      |
      |Client          |
    Then Validate No options should be displayed
    Then User clicks on Cancel button

  @TC=7110
  Scenario: Validate that while editing an enforced DN, then the in acting as client option is removed
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |ACE URBAN RACE PRIVATE LIMITED        |
      |Client-1 Legal Entity Name    |ACE URBAN RACE PRIVATE LIMITED        |
      |Document Status              |Enforced                           |
    #Then click on Approve button
    Then User clicks on edit icon
    And User will clear Selecting As filter
    Then User searches for acting as value in DF DN Screen
      | Acting As |
      | Client    |
    Then Validate No options should be displayed
    Then User clicks on Cancel button

#  @TC=7109
#  Scenario: Validate that while editing enforced DN document, in acting as client is removed
#    Given User will go to Document screen
#    Then User clicks on BulkAction button
#    Then User clicks on editButton for BulkEdit
#    Then User will select doc type for edit
#      | Doc Type |
#      | DN       |
#    Then User will select acting as LEIs for edit
#      | Acting as      |
#      |Client          |
#    Then Validate No options should be displayed
#    Then User clicks on Cancel button

  @TC=7138 @TC=7141
  Scenario: Validate the copy functionality for DN - Document already exists
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.        |
      |Document Status              |Enforced             |
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
#    Then User validates the PB and EB values
#      |Column Name                   |value                |
#      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
#    Then User validates the PB and EB values
#      |Column Name                   |value                |
#      |Prime Broker - 1              |OSTTRA INDIA SERVICES PRIVATE LIMITED|
#      |Executing Broker - 1          |CITIGROUP INC.       |
    And User select the LEIs
      |Client 1         |3G Fund, L.P.          |
    Then User clicks on Next button
   # Then User waits for 2 seconds
    Then User validates the toast message
      |Document already exists with this combination|

  @TC=7142 @TC-7144
  Scenario: Validate the copy functionality for DN
    Given User resets DN document
      | docTypeId   |2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |6SHGI4ZSSLCXXQSBB395                 |
      | clientLeiId |506700WVOT6I208I1422                 |
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.        |
      |Document Status              |Enforced             |
    Then User validates the Copy icon and clicks on it
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs
      |Client 1         |Anapier AG in Liquidation   |
    Then User clicks on Next button
    Then User validates the toast message
      |Document copied successfully|
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User waits for some time, refreshes the page and validates the status

  @TC=6938 @TC=6939
  Scenario: Validate while editing enforced document  "Approval Workflow" option is not seen in Action type
    Given User will go to Document screen
#    And user will select Column Values on Document listing screen
#      |Column Name                   |value                                 |
#      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      |EB-1 Legal Entity Name        |CITIGROUP INC.                        |
#      |Client-1 Legal Entity Name    |OSTTRA INDIA SERVICES PRIVATE LIMITED |
#      |Document Status              |Enforced                              |

    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |CITIGROUP INC.                        |
      |Client-1 Legal Entity Name    |3G Fund, L.P.                         |
      |Document Status              |Enforced                              |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will type into action type for edit
      | Action type |
      | Approval Workflow   |
      | Enforcement Rule    |
    And Validate No options should be displayed