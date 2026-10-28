@BulkAction @Regression @ignored

Feature: Bulk Action Approved

  @TC-1788
  Scenario: User is able to approve the documents through Bulk Action
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                     |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |THE MOYRA BRUCE FAMILY TRUST |PB             |4 Way          |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups                         | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
      | Edit Document   | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
    Then User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1               | Clients 1     | Prime Broker 2 | Clients 2       |
      | THE MOYRA BRUCE FAMILY TRUST | WS Midco B.V. | CITIGROUP INC. | HB Trading B.V. |
    Then User clicks on Next button
    Then User validates the document version ID on 4W creation Screen
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
      | Prime Broker - 1 | Remove Currency | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
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
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User clicks on Bulk Action button
    And User selects Approve from Bulk Action menu
    Then User will select doc type for approval
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for approval
      | Acting as                 |
      | 213800NJVZVKN3MWD759 (PB) |
    And User will select approval group for approval
      | Approval Group                          |
      | Automation_OT_ApprovalGroup_4way_Osttra |
    Then User clicks on Next button
    Then User selects all documents that needs to be approved
    And click on Approve button
    And Verify user is on the bulk request screen now
    And User selects initiator by LEI and clicks on View Details Button
      | Approval Group               |
      | THE MOYRA BRUCE FAMILY TRUST |
    Then User validates the document version ID and compares both the ids
    And User validates the Batch status
    And User refreshes the browser on Batch Details Screen
    And User validates the Processed Batch status
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                         |
      | PB-1 Legal Entity Name     | THE MOYRA BRUCE FAMILY TRUST  |
      | Client-1 Legal Entity Name | WS Midco B.V.                 |
      | PB-2 Legal Entity Name     | CITIGROUP INC.                |
      | Client-2 Legal Entity Name | HB Trading B.V.               |
    And User will click on terminate icon


  Scenario: User is able to reject the documents through Bulk Action
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                     |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |THE MOYRA BRUCE FAMILY TRUST |PB             |4 Way          |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups                         | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
      | Edit Document   | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
    Then User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1               | Clients 1     | Prime Broker 2 | Clients 2       |
      | THE MOYRA BRUCE FAMILY TRUST | WS Midco B.V. | CITIGROUP INC. | HB Trading B.V. |
    Then User clicks on Next button
    Then User validates the document version ID on 4W creation Screen
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
      | Prime Broker - 1 | Remove Currency | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
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
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User clicks on Bulk Action button
    And User selects Reject from Bulk Action menu
    Then User will select doc type for reject
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for reject
      | Acting as                 |
      | 549300R8VQU8TQTZVP73 (PB) |
    And User will select approval group for reject
      | Approval Group                          |
      | Automation_OT_ApprovalGroup_4way_Osttra |
    Then User clicks on Next button
    Then User selects all documents that needs to be rejected
    And click on Reject button
    And Verify user is on the bulk request screen now
    And User selects initiator by LEI and clicks on View Details Button
      | Approval Group  |
      | 121 WACKER, LLC |
    Then User validates the document version ID and compares both the ids
    And User validates the Batch status
    And User refreshes the browser on Batch Details Screen
    And User validates the Processed Batch status
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                         |
      | PB-1 Legal Entity Name     | THE MOYRA BRUCE FAMILY TRUST  |
      | Client-1 Legal Entity Name | WS Midco B.V.                 |
      | PB-2 Legal Entity Name     | CITIGROUP INC.                |
      | Client-2 Legal Entity Name | HB Trading B.V.               |
    And User will click on terminate icon

  @TC-6686
  Scenario: User is able to edit the limit through Bulk Action
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                     |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |THE MOYRA BRUCE FAMILY TRUST |PB             |4 Way          |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups                         | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
      | Edit Document   | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
    Then User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1               | Clients 1       | Prime Broker 2 | Clients 2     |
      | THE MOYRA BRUCE FAMILY TRUST | HB Trading B.V. | CITIGROUP INC. | WS Midco B.V. |
    Then User clicks on Next button
    Then User validates the document version ID on 4W creation Screen
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
      | Prime Broker - 1 | Edit Limit      | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product         |
      | FX          | Volatility     | Volatility Swap |
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
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    Then User validates the document version ID on 4W creation Screen
    And User approves the document
    Then User refreshes the browser
    Then User clicks on Bulk Action button
    And User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as                 |
      | 213800NJVZVKN3MWD759 (PB) |
    And User will select action type for edit
      | Action type |
      | Edit Limit  |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
    And Verify next button and click
    And Verify user able to change edit Limit value
      | New Value      |
      | 0 |
    And Verify submit for approval
    Then User validates the Document approved message
      | Please fill all the limit values. |
    And Verify user able to change edit Limit value again
      | New Value |
      | 14        |
    And Verify submit for approval
    And Verify user is on the bulk request screen now
    And User selects initiator by LEI and clicks on View Details Button
      | Approval Group               |
      | THE MOYRA BRUCE FAMILY TRUST |
    And User validates the Batch status
    And User refreshes the browser on Batch Details Screen for status to be processed
    And User validates the Processed Batch status
    And User clicks on document version ID on Batch Details Dashboard
    And User validates Limit Value in Document Preview
      | Limit value |
      | 14          |
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                         |
      | PB-1 Legal Entity Name     | THE MOYRA BRUCE FAMILY TRUST  |
      | Client-1 Legal Entity Name | WS Midco B.V.                 |
      | PB-2 Legal Entity Name     | CITIGROUP INC.                |
      | Client-2 Legal Entity Name | HB Trading B.V.               |
    And User will click on terminate icon

  @TC-6689
  Scenario: User is able to remove products through Bulk Action
    Given User is on approval matrix listing screen
    When user searches for a approval matrix and validates the results
      |approval matrix                       |LEI name                     |org type filter|doc type filter|
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |THE MOYRA BRUCE FAMILY TRUST |PB             |4 Way          |
    And user clicks on the update button
    Then user will select document action and approval groups on DF
      | Document Action | approval groups                         | Approval Sequence |
      | New Document    | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
      | Edit Document   | Automation_OT_ApprovalGroup_4way_Osttra | 1                 |
    Then User is on Document Page
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    Then User select parties as PrimeBroker1, Client1, PrimeBroker2 and Client2
      | Prime Broker 1               | Clients 1     | Prime Broker 2 | Clients 2       |
      | THE MOYRA BRUCE FAMILY TRUST | WS Midco B.V. | CITIGROUP INC. | HB Trading B.V. |
    Then User clicks on Next button
    Then User validates the document version ID on 4W creation Screen
    Then User will Drag participants and arrange them in approval sequence correspondence to their document action
      | Participants     | Document_Action | Approval_sequence |
      | Prime Broker - 1 | New Document    | 1                 |
      | Prime Broker - 1 | Remove Products | 1                 |
    Then User clicks on Next button
    Then User select rules in Enforcement rule
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product|
      | FX          | Cash           | Future |
      | FX          | Cash           | Forward|
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
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    And User will input Netting Type
      | Netting Type |
      | Greater L/S  |
    Then User will input Product family
      | Product Family |
      | Exotic Options |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User approves the document
    Then User clicks on Bulk Action button
    And User clicks on editButton for BulkEdit
    Then User will select doc type for edit
      | Doc Type |
      | 4 way    |
    Then User will select acting as LEIs for edit
      | Acting as                             |
      | THE MOYRA BRUCE FAMILY TRUST          |
    And User will select action type for edit
      | Action type    |
      | Remove Product |
    Then User clicks on NextButton
    And Verify user is able to see Document ID, Document Version ID, Document Status
    And Select document
    And Verify next button and click
    And Verify select product family
      | product family |
      | cash           |
    And Verify product selection
      | product |
      | Future  |
    And Verify remove product line button
    And Verify submit for approval
    And Verify user is on the bulk request screen now
    And User selects initiator by LEI and clicks on View Details Button
      | Approval Group               |
      | THE MOYRA BRUCE FAMILY TRUST |
    And User validates the Batch status
    And User refreshes the browser on Batch Details Screen for status to be processed
    And User validates the Processed Batch status
    And User clicks on document version ID on Batch Details Dashboard
    And User validates Auth Scope Data is not in Document Preview of Bulk Action
      | Product |
      | Future  |
    Then User is on Document Page Again
    And user will select Column Values on Document listing screen
      | Column Name                | value                         |
      | PB-1 Legal Entity Name     | THE MOYRA BRUCE FAMILY TRUST  |
      | Client-1 Legal Entity Name | WS Midco B.V.                 |
      | PB-2 Legal Entity Name     | CITIGROUP INC.                |
      | Client-2 Legal Entity Name | HB Trading B.V.               |
    And User will click on terminate icon

  @TC-6671
  Scenario: To check listing screen of sync to CL through bulk action
    Given User is on Document Page
    Then User Click on Bulk Action Button
    Then User click on Sync to CreditLink button
    Then User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on NextButton
    Then User validates the data on listing screen
