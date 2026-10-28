@DocumentFramework @Regression
@CreateAndCancelDF @US=DMGS-3210 @US=DMGS-3690

Feature: Workflow for Create and Cancel Document FrameWork

  @TC=6737 @TC=6738 @TC=6739 @US=DMGS-3690 @TC_01
  Scenario: Verify the screen of Approval workflow for DF
    Given User is on Document Framework Page
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   |549300ZLVED0VPNQPO73                 |
      | ebLeiId   |254900SLCV8KI86BHL86                 |
#    And User select the LEIs
#      | Prime Broker 1   |  3G Fund, L.P.                          |
#      | EB 1             |  OSTTRA INDIA SERVICES PRIVATE LIMITED  |
#    And User checks if Document already exists
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | EB        |
    And User select the LEIs
      |Prime Broker 1   |3G Fund, L.P. |
      |EB 1             |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    Then User clicks on Next button
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants         |Document_Action           |Approval_sequence|
      |Executing Broker - 1 |New Document Framework    |1                |
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User validates the tabs of approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |New Document              |1                |
      |Prime Broker - 1  |Edit Approval Workflow    |1                |
#    Then User validates the message
#      |Participant already exists|
    And User clicks on Save As Draft button
    Then Verify and click back button
    Then User clicks on Next button
    Then User validates the data in approval Workflow
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |New Document              |1                |
      |Prime Broker - 1  |Edit Approval Workflow             |1                |
    Then User clicks on Next button
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
      |COP|
      |CRC|
      |ISK|
    And User will submit the changes
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    Then User will input Product family
      | Product Family |
      | Bullion        |
    Then User will input Delta
      | Delta |
      | No    |
    Then User will input Calculation Type
      | Calculation Type |
      | DSL              |
    * User will input Netting Type
      | Netting Type |
      | Greater      |
    And User enter Bullion Trades in Limit Scope
      | Only Metals  |
    * User will input Exclude CLS from calculation
      | Exclude CLS |
      | No          |
    Then User clicks on Add Limit button
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then Now user will enter email in email pop up for lite user.
      |Enter Email 1            |
      |surbhi.singh2@osttra.com |
    Then User validates the toast message
      |There is no signed Approval Agreement between PB and EB. Either remove EB as an approver or select the PB on Behalf of EB flag to no|
    Then User clicks on Approval Workflow for DN Scope Tab
    And User selects the PB on behalf of EB checkbox on DF
    And User clicks on Save As Draft button
    Then User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User validates the Document approved message
      |Document is In-approval|

  @TC=6745
  Scenario: Validate the approval workflow for DN in Cancelled DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name          |value                |
      |PB Name |3G Fund, L.P.        |
      |EB Name |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Lifecycle status     |In-Approval          |
    And User click on Cancel icon and select yes
    And user will clear the filter for following column
      |Column Name         |
      |Lifecycle status    |
    And User refreshes the browser
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name|3G Fund, L.P.                         |
      |EB Name|OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Lifecycle status    |Cancelled                             |
    Then User validates the Approval Workflow for DN in the preview on DF listing screen
