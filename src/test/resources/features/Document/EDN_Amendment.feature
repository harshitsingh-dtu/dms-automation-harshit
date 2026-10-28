@Regression
@US=DMGS-3690

Feature: Workflow for DN/DF Amendment Documents

  @TC-8420
  Scenario: User enables and disables NDF Cleared Trades checkbox on DN Amendment and verifies Compare Screen
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 724500VDORS8ACRDA968                 |
      | clientLeiId | 724500KKIIALL8LA1R98                 |
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED           |
      |EB 1             |Gertborg Beheer B.V.           |
      |Client 1         |P. van Swam Holding B.V. |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User clicks on Next button
    Then User clicks on Limit Scope
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      |99999999|
    Then User checks the NDF Cleared Trades checkbox
    Then User clicks on Next button
    Then User clicks on Cancel button
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      |Column Name                   |value                            |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                            |
      |EB-1 Legal Entity Name        |Gertborg Beheer B.V.                    |
      |Client-1 Legal Entity Name    |P. van Swam Holding B.V.       |
      |Document Status               |Draft                            |
    Then User clicks on compare button icon
    Then User verifies NDF Cleared Trades as true on Compare Screen
    Then User closes the compare screen
    And User is on Document Page Again
    And user will select Column Values on Document listing screen
      |Column Name                   |value                            |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                            |
      |EB-1 Legal Entity Name        |Gertborg Beheer B.V.                    |
      |Client-1 Legal Entity Name    |P. van Swam Holding B.V.       |
      |Document Status               |Draft                            |
    Then User clicks on edit icon
    Then User clicks on Next button
    Then User clicks on Limit Scope
    Then User checks the NDF Cleared Trades checkbox
    Then User clicks on Next button
    Then User clicks on Cancel button
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      |Column Name                   |value                            |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                            |
      |EB-1 Legal Entity Name        |Gertborg Beheer B.V.                    |
      |Client-1 Legal Entity Name    |P. van Swam Holding B.V.       |
      |Document Status               |Draft                            |
    Then User clicks on compare button icon
    Then User verifies NDF Cleared Trades as false on Compare Screen

    @TC-7635
  Scenario: Impacted Auth Scope details on DN Amendment
      Given User resets DF document
        | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
        | pbLeiId   | 254900SLCV8KI86BHL86                 |
        | ebLeiId   | 5493005HN436M5IR0N59                 |
    Given User is on Document Framework Page
      Then User creates a document framework through API
        |Payload path|
        |src/test/java/resources/DF_Creation_MR8.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds LimitScope via API for Document or Document Framework
      And user will select Column Values on Document Framework screen
        |Column Name   |value                                        |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
        |EB Name       |Enbridge Supplemental Pension Plan Canadian Grantor Trust|
      Then User clicks on edit icon
    And User clicks on Auth Scope Tab
#    Then User Add Asset Class, Product Family, Product to the Auth Scope
#      | Asset Class | Product Family | Product     |
#      | FX          | Exotic Options | Asian       |
#      | FX          | Cash           | Future      |
      Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Exotic Options,Cash        |Asian,Future|
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |AED|
      |CLF|
      |COP|
      |CRC|
      |ISK|
      And click on the submit button on pop up screen
    And User enables Tenor
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    Then User clicks on Limit Scope
     * User will input Calculation Type
       | Calculation Type |
       | NOP              |
     * User will input Netting Type
       | Netting Type                  |
       | Greater L/S                   |
     Then User enter Bullion Trades in Limit Scope
       |Exclude Metals      |
     * User will input Delta
       | Delta |
       | No    |
     * User will input Product family
       | Product Family |
       | Cash           |
     Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User is on Document Page Again
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      |EB 1             |Enbridge Supplemental Pension Plan Canadian Grantor Trust        |
      |Client 1         |Koudenburg B.V.  |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Exotic Options | Asian |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on Next button
    Then User clicks on Cancel button
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      |Column Name   |value                                   |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED   |
      |EB Name       |Enbridge Supplemental Pension Plan Canadian Grantor Trust      |
      |Lifecycle status       |Approved                       |
    And User clicks on edit icon
    And User will select acting as for edit document
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      And User will select action type for edit
        | Action type |
        |Edit Document Framework|
      And User will click on submit
      Then User clicks on Auth Scope Tab
      Then Clicks on DF Auth scope Expand All button if Expand is visible
      And User deletes the auth Lines
      | Asset Class | Product Family  | Product                 |
      | FX          | Exotic Options  | Asian                   |
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User verifies the following deleted products are displayed in Removed Products section
      | Product Family  |
      | Exotic Options  |

  @TC-7958
  Scenario: Tenor Value impact on DF/DN Amendment Screen
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name       |value                                                                        |
      |PB Name           |OSTTRA INDIA SERVICES PRIVATE LIMITED                                        |
      |EB Name           |AGESA LIFE AND RETIREMENT INC. PARTICIPATION STOCK RETIREMENT INVESTMENT FUND|
      |Lifecycle status  |Approved                                                                     |
    And User clicks on edit icon
    And User will select acting as for edit document
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type |
      |Edit Document Framework|
    And User will click on Submit Button
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    And User will edit Auth Tenor value on DF
      | 80         |
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then User waits for 3 seconds
    And Refresh web page
    And user will select Column Values on Document Framework screen
      |Column Name       |value                                                                        |
      |PB Name           |OSTTRA INDIA SERVICES PRIVATE LIMITED                                        |
      |EB Name           |AGESA LIFE AND RETIREMENT INC. PARTICIPATION STOCK RETIREMENT INVESTMENT FUND|
      |Lifecycle status  |Approved                                                                     |
    And User clicks on Preview of Document
    And User validates Auth Scope Data on Preview of Document
      | Product                      | Currencies Deliverable      | Currencies Non-Deliverable | Tenor            |
      | FX Volatility Variance Swap  | AED, CLF, COP, CRC, ISK      | CLF, COP, CRC, ISK          | 80 Business Days |
    And User clicks on close button
    And User clicks on edit icon
    And User will select acting as for edit document
      |acting as|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type |
      |Edit Document Framework|
    And User will click on Submit Button
    And User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    And User will edit Auth Tenor value on DF
      | 100         |
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then User waits for 3 seconds
    And user will select Column Values on Document Framework screen
      |Column Name       |value                                                                        |
      |PB Name           |OSTTRA INDIA SERVICES PRIVATE LIMITED                                        |
      |EB Name           |AGESA LIFE AND RETIREMENT INC. PARTICIPATION STOCK RETIREMENT INVESTMENT FUND|
      |Lifecycle status  |Approved                                                                     |
    And User clicks on Preview of Document
    And User validates Auth Scope Data on Preview of Document
      | Product                      | Currencies Deliverable      | Currencies Non-Deliverable | Tenor            |
      | FX Volatility Variance Swap  | AED, CLF, COP, CRC, ISK      | CLF, COP, CRC, ISK          | 100 Business Days |

    @TC-7658
  Scenario: User gets prompt before document approval on DN amendment when CreditLink Service is enable
      Given User navigates to the organisation screen
      Then User searches the Organisation
        |search_orgname                       |
        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      And User is on the update screen
      When User searches for the LEI in the search bar
        | update screen search lei              |
        | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      Then User searches for organization "OSTTRA INDIA SERVICES PRIVATE LIMITED" and verifies CL status is enabled

      @TC-8277
  Scenario: DF/DN Amendment with Approval Groups when Document Framework is In-Approval
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 7437001N0TY9UPKCMZ54                 |
    Given User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user navigates to approval matrix screen
    When user searches for a approval matrix and validates the results
      |approval matrix |LEI name  |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups               | Approval Sequence |
      | New Document    | Automation_AG_For_DNAmendment | 1                 |
      | Edit Document   | Automation_AG_For_DNAmendment | 1                 |
    Then User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Turun Seudun Rengas ja Tarvike Oy     |
    Then User clicks on Next button
    And User Validates the approval Wokflow for DF and actions
    #Then User will use drag and drop PB1 to approval Seq 1 in DF
    #Then User will use drag and drop PB1 to approval Seq 2 in DF
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action         | Approval_sequence |
      | Prime Broker - 1 | New Document Framework  | 1                 |
      | Prime Broker - 1 | Edit Document Framework | 1                 |
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
      | Prime Broker - 1 | Edit Document   | 1                 |
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | CRC           |
      | ISK           |
    And user will submit the changes
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
    And  User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | Turun Seudun Rengas ja Tarvike Oy     |
      | Lifecycle status     |  In-approval     |
    And User validates the document status
      | Lifecycle status |
      | In-approval      |
    Then User will click on cancel icon and select yes

  @TC-6600
  Scenario: DF/DN Amendment with Approval Groups when Document Framework is Approved
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 7437001N0TY9UPKCMZ54                 |
    Given User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user navigates to approval matrix screen
    When user searches for a approval matrix and validates the results
      |approval matrix |LEI name  |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups               | Approval Sequence |
      | New Document    | Automation_AG_For_DNAmendment | 1                 |
      | Edit Document   | Automation_AG_For_DNAmendment | 1                 |
    Then User will click on Submit Button
    And user will click on Submit button of confirmation pop-up
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Turun Seudun Rengas ja Tarvike Oy     |
    Then User clicks on Next button

    And User Validates the approval Wokflow for DF and actions
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action         | Approval_sequence |
      | Prime Broker - 1 | New Document Framework  | 1                 |
      | Prime Broker - 1 | Edit Document Framework | 1                 |
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
      | Prime Broker - 1 | Edit Document   | 1                 |
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | CRC           |
      | ISK           |
    And user will submit the changes
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
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | Turun Seudun Rengas ja Tarvike Oy     |
      | Lifecycle status     |  In-approval     |
    Then click on Approve button on DN
    Then User waits for 5 seconds
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | Lifecycle status     | Approved     |
    And User validates the document status
      | status   |
      | Approved |

      @TC-8312
  Scenario: DF/DN Amendment with Approval Groups when Document is In-Approval
        Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 7JIRH9K3XRCRM50HTR80                 |
    Given User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN       | OSTTRA | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
       | approval matrix                       | LEI name                              | org type filter | doc type filter |
       | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | DN              |
        And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action        | approval groups               | Approval Sequence |
      | New Document           | Automation_AG_For_DNAmendment | 1                 |
      | Edit Approval Workflow | Automation_AG_For_DNAmendment | 1                 |
      | Edit Enforcement Rules | Automation_AG_For_DNAmendment | 1                 |
    And User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User clicks on Next button
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
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
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | CRC           |
      | ISK           |
    And user will submit the changes
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
    And  User is on Document Page Again
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client 1       | Koudenburg B.V.                       |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And User clicks on Add Auth Line
    Then User enables Tenor
    And Click on DN Edit currencies
    And User will search for the currency deselect and select them
      |currency list|
      |AED|
    And User will submit the changes
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
    Then User waits for some time, refreshes the page
    And User validates the document status
      |status       |
      |In-approval  |
    Then User will click on cancel icon and select yes
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User will click on terminate icon and select yes

      @TC-8315 @TC-6755  @US=DMGS-3690 @TC_01
  Scenario: DF/DN Amendment with Approval Groups when Document is Enforced
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
       | ebLeiId   | 7JIRH9K3XRCRM50HTR80                 |
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User clicks on Next button
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
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
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | CRC           |
      | ISK           |
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
    Then User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN        | OSTTRA | PB       |
    Then clicks on next
    Then User waits for 2 seconds
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix |LEI name  |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups
      | Document Action        | approval groups               | Approval Sequence |
      | New Document           | Automation_AG_For_DNAmendment | 1                 |
      | Edit Approval Workflow | Automation_AG_For_DNAmendment | 1                 |
      | Edit Enforcement Rules | Automation_AG_For_DNAmendment | 1                 |
    And User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client 1       | Koudenburg B.V.                       |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And User clicks on Add Auth Line
    Then User enables Tenor
    And Click on DN Edit currencies
    And User will search for the currency deselect and select them
      |currency list|
      |AED|
    And User will submit the changes
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then click on Approve button on DN
    Then User is on Document Page Again
    Then User waits for some time, refreshes the page
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
    And User validates the document status
      | status   |
      | Enforced |
    And User will click on terminate icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User select Action type in the edit pop up screen
       | action type   |
       | Terminate Document |
    And Click on Submit
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User will click on terminate icon and select yes

  Scenario: DF/DN Amendment with Approval Groups when Document is in Approved state
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 7JIRH9K3XRCRM50HTR80                 |
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    Then User select acting as
      | Acting As |
      | PB         |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User clicks on Next button
    Then User clicks on Next button
    And User validates the approval Wokflow for DN
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
  And User will select Enforcement rule for new document for amendment and for termination
  |For new document   |For amendment      |value      |Duration |
  |Immediate          |Schedule           |1     |Minutes  |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And Click on + Add currencies
    And User will search for the currency and select them
      | currency list |
      | AED           |
      | CLF           |
      | COP           |
      | CRC           |
      | ISK           |
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
    Then User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | DN        | OSTTRA | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix |LEI name  |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED           |OSTTRA INDIA SERVICES PRIVATE LIMITED     |PB             |DN             |
    And user clicks on the update button
    Then user will select document action and approval groups
      | Document Action        | approval groups               | Approval Sequence |
      | New Document           | Automation_AG_For_DNAmendment | 1                 |
      | Edit Approval Workflow | Automation_AG_For_DNAmendment | 1                 |
      | Edit Enforcement Rules | Automation_AG_For_DNAmendment | 1                 |
    #And  User is on Document Page Again
    And User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client 1       | Koudenburg B.V.                       |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
    And User clicks on Add Auth Line
    Then User enables Tenor
    And Click on DN Edit currencies
    And User will search for the currency deselect and select them
      |currency list|
      |AED|
    And User will submit the changes
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
      | Document is In-approval |
    Then click on Approve button on DN
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
      |Document status               |Enforced               |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type |
      | Edit Limit  |
    Then User will click on submit
    And User will input Limit Value on Edit Limit screen
      | Limit Value |
      | 12345       |
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Enbridge Pipelines (Ozark) L.L.C.     |
      | Client-1 Legal Entity Name | Koudenburg B.V.                       |
    And User validates the document status
      | status   |
      |Approved|
    Then User is on Document Framework Page Again
    And user will select Column Values on Document Framework screen
      | Column Name | value                                 |
      | PB Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB Name     | Enbridge Pipelines (Ozark) L.L.C.     |
    Then User will click on terminate icon and select yes

  @US=DMGS-3690 @TC_01 @TC_4W_InApproval
  Scenario: 4W Document with Approval Groups when Document is In-Approval
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 549300H7FILSLGGU3C96                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 254900SLCV8KI86BHL86                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 549300H7FILSLGGU3C96                 |
      | client2OrgTypeKey | 3                                    |
    Given User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user navigates to approval matrix screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action        | approval groups               | Approval Sequence |
      | New Document           | Automation_AG_For_DNAmendment | 1                 |
      | Edit Approval Workflow | Automation_AG_For_DNAmendment | 1                 |
      | Edit Enforcement Rules | Automation_AG_For_DNAmendment | 1                 |
    And  User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1 | Clients 1    | Prime Broker 2 |Clients 2     |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED        |CITIC Capital China Partners III, L.P. |CITIC Capital China Partners III, L.P. |
    Then User clicks on Next button
    Then User waits for 2 seconds
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User waits for 5 seconds
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User adds Currencies
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User clicks on Next button
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Limit Value
      |Limit Value|
      |999999999999999|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User will input Product family
      |Product Family|
      | Exotic Options      |
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then User clicks on submit for approval button
    Then User waits for 5 seconds
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                                  |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      | Client-1 Legal Entity Name | OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      | PB-2 Legal Entity Name     | CITIC Capital China Partners III, L.P. |
      | Client-2 Legal Entity Name | CITIC Capital China Partners III, L.P. |
      | Document status       |In-approval  |
    And User validates the document status
      |status       |
      |In-approval  |
    Then User will click on cancel icon and select yes

  Scenario: 4W Document with Approval Groups when Document is Enforced
    Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          | 549300H7FILSLGGU3C96                 |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      | 254900SLCV8KI86BHL86                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      | 549300H7FILSLGGU3C96                 |
      | client2OrgTypeKey | 3                                    |
    Given User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name                    | organisation name                     | doc type | LEI's  | org type |
      | Automation_AG_For_DNAmendment | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA | PB       |
    Then clicks on next
    And user is redirected to update approval group screen
    And User will search for the users to be added and add them
      |user|
      |hsbc.test1@testsso.osttra.com|
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then user navigates to approval matrix screen
    When user searches for a approval matrix and validates the results
      | approval matrix                       | LEI name                              | org type filter | doc type filter |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB              | 4 Way           |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action        | approval groups               | Approval Sequence |
      | New Document           | Automation_AG_For_DNAmendment | 1                 |
      | Edit Approval Workflow | Automation_AG_For_DNAmendment | 1                 |
      | Edit Enforcement Rules | Automation_AG_For_DNAmendment | 1                 |
    And  User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1 | Clients 1    | Prime Broker 2 |Clients 2     |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED        |CITIC Capital China Partners III, L.P. |CITIC Capital China Partners III, L.P. |
    Then User clicks on Next button
    #And User is able to see approval workflow tab
    Then User validates the data in approval Workflow
      | Participants     | Document_Action        | Approval_sequence |
      | Prime Broker - 1 | New Document           | 1                 |
      | Prime Broker - 1 | Edit Approval Workflow | 1                 |
      | Prime Broker - 1 | Edit Enforcement Rules | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User adds Currencies
    * User will input Auth Tenor value
      | Auth Value |
      | 3          |
    * User will select tenor in Auth Tenor
      | Auth Tenor |
      | Years      |
    And User clicks on Add Auth Line
    And User clicks on Next button
    And User clicks on Limit Scope
    And User will input Calculation Type
      |Calculation Type|
      |DSL|
    And User will input Limit Value
      |Limit Value|
      |999999999999999|
    And User will input Netting Type
      |Netting Type|
      |Greater L/S |
    Then User will input Product family
      |Product Family|
      | Exotic Options      |
    Then User will input Delta
      |Delta|
      |Yes  |
    Then User enter Bullion Trades in Limit Scope
      |Exclude Metals|
    Then User will input Exclude CLS from calculation
      |Exclude CLS|
      |Yes        |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User clicks on Preview & Submit tab
    Then click on Approve button on DN
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                                  |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      | Client-1 Legal Entity Name | OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      | PB-2 Legal Entity Name     | CITIC Capital China Partners III, L.P. |
      | Client-2 Legal Entity Name | CITIC Capital China Partners III, L.P. |
    Then User waits for some time, refreshes the page
    And User validates the document status
      | status   |
      | Enforced |
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                                  |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      | Client-1 Legal Entity Name | OSTTRA INDIA SERVICES PRIVATE LIMITED  |
      | PB-2 Legal Entity Name     | CITIC Capital China Partners III, L.P. |
      | Client-2 Legal Entity Name | CITIC Capital China Partners III, L.P. |
    And User will click on terminate icon
    And User will select acting as LEIs for edit
      | Acting as            |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And Click on Submit




















