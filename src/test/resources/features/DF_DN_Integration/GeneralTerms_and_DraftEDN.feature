@DF_DNIntegration @Regression
 @GeneralTerms_and_DraftEDN
@US=DMGS-3312 @US=DMGS-3210 @US=DMGS-3211 @US=DMGS-3502 @US=DMGS-3313 @US=DMGS-2822 @US=DMGS-3326 @US=DMGS-3806

Feature: Impact on Draft DN When DF is Draft/in-approval/Approved/Rejected/Expired state

  @TC=6849 @TC=6853 @TC=7112 @TC-6696
  Scenario: User edits a DocumentFramework and makes it in draft state
    Given User is on Document Framework Page
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name         |
      | PB Name             |
      | EB Name             |
      | Lifecycle status    |
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                 |
      |PB Name          |Osttra India Services Private Limited |
      |EB Name          |3G Fund, L.P.                         |
      |Lifecycle status |Approved                              |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as                             |
      | Osttra India Services Private Limited |
    And User will click on Submit Button
    Then User adds General Terms via API for DN Document Framework
    And User clicks on General Terms Tab
    Then User validates the Date values for General Terms in Document
      | Date                      | Value         |
      | Master Agreement ISDA     |2025-12-20     |
      | Master Agreement Give-up  |2025-12-31     |
      | EMTA                      |2025-12-20     |

  @TC=6849 @TC=6853 @TC=7112
Scenario: Validate General Terms date on associated DN
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |Osttra India Services Private Limited               |
      |EB-1 Legal Entity Name        |3G Fund, L.P.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    And User clicks on General Terms Tab
    Then User validates the Date values for General Terms in Document
      | Date                      | Value         |
      | Master Agreement ISDA     |12/20/2025     |
      | Master Agreement Give-Up  |12/31/2025     |

  @TC=7094 @TC=6741 @TC=6889 @TC=6850 @TC=6854 @TC=7120
  Scenario: User edits a DocumentFramework and makes in in-approval state
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
        |Column Name                |value                |
        |PB Name       |Osttra India Services Private Limited |
        |EB Name       |3G Fund, L.P.        |
        |Lifecycle status           |Approved       |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | Osttra India Services Private Limited |
    And User will click on Submit Button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |Edit Document Framework   |1                |
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User clicks on Next button
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |value      |Duration |
      |Immediate          |Schedule           |random     |Minutes  |
    And User clicks on Next button
    And User clicks on General Terms Tab
    And User update the General Terms dates with Current date
      | Date                      |
      | Master Agreement ISDA     |
      | Master Agreement Give-up  |
      | EMTA                      |
    And User clicks on Save As Draft button
    Then User validates the message
      |General terms saved successfully|
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User clicks on Submit for Scope Change Preview
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name        |Osttra India Services Private Limited               |
      |EB Name        |3G Fund, L.P.        |
      |Lifecycle status    |In-Approval    |
    And User validates the DF on listing screen

  @TC=7094 @TC=7101 @TC=6748 @TC=6880 @TC=6881 @TC=6884 @TC=7113 @TC=7119 @TC=7123 @TC=6850 @TC=6854 @TC=7120 @TC=7121 @TC=7299
  Scenario: Validate that all associated DN's moves in suspension if new edited version of DF moves in approval
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |Osttra India Services Private Limited               |
      |EB-1 Legal Entity Name        |3G Fund, L.P.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |Edit Approval Workflow    |1                |
    Then User validates the data in approval Workflow
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |Edit Approval Workflow    |1                |
    Then User clicks on Next button
    And User validates Enforcement rule data
      |For new document   |For amendment      |value      |Duration |
      |Immediate          |Schedule           |random     |Minutes  |
    And User clicks on General Terms Tab
    Then User validates the Date values for General Terms in Document
      | Date                      | Value         |
      | Master Agreement ISDA     |12/20/2025     |
      | Master Agreement Give-Up  |12/31/2025     |
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User validate the error message for DN operations prohibited

  @TC=7096 @TC=7115 @TC=6852
  Scenario: Validate the DF life cycle status once in-approval DF version moved in approved state
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                |
      |PB Name              |Osttra India Services Private Limited |
      |EB Name              |3G Fund, L.P.        |
      |Lifecycle status    |Approved             |
    And User fetches the document version ID
    And user will clear the filter for following column
      |Column Name         |
      |Lifecycle status    |
    And user will select Column Values on Document Framework screen
      |Column Name         |value                |
      |Lifecycle status    |In-approval          |
    And User approves the document
    Then User validates the Document Framework approved successfully notification
    And user will clear the filter for following column
      |Column Name         |
      |Lifecycle status    |
    Then User validates the previous approved version is expired

  @TC=7097 @TC=7099 @TC=7100 @TC=6855 @TC=7117 @TC=7124 @TC=6852
  Scenario:Validate the updation of DF corresponding Id in associated document when DF version 002 moved in approved state
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                   |
      |PB Name              |Osttra India Services Private Limited   |
      |EB Name              |3G Fund, L.P.                           |
      |Lifecycle status    |Approved                                |
    And User fetches the document version ID
    Then User clicks on All documents in side menu
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name           |Osttra India Services Private Limited               |
      |EB-1 Legal Entity Name        |3G Fund, L.P.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User validates the data in approval Workflow
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |Edit Approval Workflow    |1                |
    Then User clicks on Next button
    Then User clicks on General Terms Tab
    Then User validates the DF version in DN
    Then User validates the Date values for General Terms in Document
      | Date                      | Value           |
      | Master Agreement ISDA     |Current Date     |
      | Master Agreement Give-Up  |Current Date     |
    Then Click on notification bell icon
    And User should not see any notification related to DN

  @TC=7095 @TC=7101 @TC=6882 @TC=7112 @TC=7114 @TC=6851
  Scenario: Validate that suspension removed when DF is rejected and No notification is sent for Associated DNs
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                |
      |PB Name              |Osttra India Services Private Limited               |
      |EB Name              |3G Fund, L.P.        |
      |Lifecycle status    |Approved             |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | Osttra India Services Private Limited |
    And User will select action type for edit
      | Action type |
      |Edit Document Framework|
    And User will click on Submit Button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User clicks on Submit for Scope Change Preview
    And user will select Column Values on Document Framework screen
      |Column Name   |value                |
      |PB Name        |Osttra India Services Private Limited               |
      |EB Name        |3G Fund, L.P.        |
      |Lifecycle status    |In-Approval    |
    And User validates the DF on listing screen
    Then User will click on reject icon
    Then User validates the rejection reason pop-up
    And User enters the Rejection reason
      |Rejection Reason|
      |Rejected for DF-DN Integration TestCase|
    And User clicks on Reject button and validates the DF screen
    Then User clicks on All documents in side menu
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |Osttra India Services Private Limited               |
      |EB-1 Legal Entity Name        |3G Fund, L.P.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User validate the error message for DN operations prohibited should not come

  @TC=6742 @TC=6754
  Scenario: Validates the Approval Workflow for DN in the preview on DF listing screen
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name         |value                |
      |PB Name              |Osttra India Services Private Limited               |
      |EB Name              |3G Fund, L.P.        |
      |Lifecycle status    |Expired              |
    Then User validates the Approval Workflow for DN in the preview on DF listing screen

@TC=6746 @TC=6751 @TC=6875 @TC=6876 @TC=6851 @TC=6771
Scenario: verify that approval workflow for DN should be imported on doc creation in read only mode
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value               |
      |PB-1 Legal Entity Name        |Osttra India Services Private Limited   |
      |EB-1 Legal Entity Name        |3G Fund, L.P.       |
      |Client-1 Legal Entity Name    |3G Fund, L.P.       |
      |Document Status               |Draft               |
    Then User clicks on edit icon
    Then User validates PB and EB are disabled for DN
    And Validate Client is not displayed
    Then User clicks on General Terms Tab
    Then User validates the Date values for General Terms in Document
      | Date                      | Value           |
      | Master Agreement ISDA     |Current Date     |
      | Master Agreement Give-Up  |Current Date     |
