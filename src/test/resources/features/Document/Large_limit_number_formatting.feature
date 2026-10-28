@Regression @ValidatingLimitValueFormat @US=DMGS-7414


Feature: Validating Limit number formatting

  @TC01 @TC02
  Scenario:  Verify the limit number formatting for DN
        Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     |254900SLCV8KI86BHL86                 |
      | ebLeiId     |549300ZLVED0VPNQPO73                 |
      | clientLeiId |549300ZLVED0VPNQPO73                 |
    Given User is on the all document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           |3G Fund, L.P.|
      | Client 1       |3G Fund, L.P.|
    Then User clicks on Next button
    Then User clicks on Limit Scope
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      | 999999999999999 |
    And User clicks on Save As Draft button
    Then User validates the message
      | Limit scope updated successfully |
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    Then User validates the limit value in the limit line in Pdf
      | limit value           |
      | $ 999,999,999,999,999 |
    Then User clicks on view as PDF button
    Then User validates the limit value in the limit line in Pdf
      | limit value           |
      | $ 999,999,999,999,999 |
    And User clicks on close button
    Then User clicks on Cancel button
    Given User is on the all document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | EB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | 3G Fund, L.P.                         |
      | Client-1 Legal Entity Name | 3G Fund, L.P.                         |
      | Document Status            | Draft                                 |
    And User clicks on Preview of Document
    Then User validates the limit value in the limit line in Pdf
      | limit value           |
      | $ 999,999,999,999,999 |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |

  @documentType=4way
  Scenario:  Verify the limit number formatting for 4 way doc
        Given User resets 4Way document
      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | pb1LeiId          |254900SLCV8KI86BHL86               |
      | pb1OrgTypeKey     | 1                                    |
      | pb2LeiId          |529900PM6WOF03NLDE34                |
      | pb2OrgTypeKey     | 1                                    |
      | client1LeiId      |529900OKJD24K7O4X993                 |
      | client1OrgTypeKey | 3                                    |
      | client2LeiId      |6SHGI4ZSSLCXXQSBB395                 |
      | client2OrgTypeKey | 3                                    |
    Given User is on the all document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client 1       | Mercedes-Benz Finance Co., Ltd.       |
      | Prime Broker 2 | Autohaus Weiss Limited Liability Company|
      | Client 2       | CITIGROUP INC.                        |
    Then User clicks on Next button
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
    Then User enter Bullion Trades in Limit Scope
      | Exclude Metals |
    Then User will input Delta
      | Delta |
      | Yes   |
    Then User will input Product family
      | Product Family |
      | Select All     |
    Then User will input Exclude CLS from calculation
      | Exclude CLS |
      | Yes         |
    Then User clicks on Add Limit button
    Then User clicks on Next button
    Then User validates the toast message
      |Limit scope updated successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on Limit Scope Tab in Final Preview
    Then User validates the limit value in the limit line in Pdf
      | limit value           |
      | $ 999,999,999,999,999 |
    Then User clicks on view as PDF button
    Then User validates the limit value in the limit line in Pdf
      | limit value           |
      | $ 999,999,999,999,999 |
    And User clicks on close button
    Then User clicks on Cancel button
    Given User is on the all document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | PB-2 Legal Entity Name     |
      | Client-2 Legal Entity Name |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Client-1 Legal Entity Name | 1355 STORM PARKWAY LLC                |
      | PB-2 Legal Entity Name     | Vladisart Oy                          |
      | Client-2 Legal Entity Name | CITIGROUP INC.                        |
    And User clicks on Preview of Document
    Then User validates the limit value in the limit line in Pdf
      | limit value           |
      | $ 999,999,999,999,999 |
    And User clicks on close button
    And User click on delete button
    Then User validates the Document approved message
      | Document is deleted |

  @AdvanceFilterValidation @TC-6697
  Scenario: Validate the formatting type for Advance Filter
    Given User is on the all document screen
    Then User will click on Apply More Filters
    And User will input Calculation Type for advance filter
      | Calculation Type |
      | DSL              |
    And User will input Limit Value
      | Limit Value     |
      | 999999999999999 |
    Then User validate the limit value
      | limit value          |
      | $999,999,999,999,999 |
    Then Click on Apply Filters
    And User clicks on Preview of Document
    Then User validates the calculation type in the limit line in Pdf
      | Calculation type |
      | DSL              |
    And User clicks on close button

  @BulkEditActionForLimitValue
  Scenario: Validate the limit value format in bulk edit
    Given User is on the all document screen
    Then User Click on Bulk Action Button
    Then User selects edit button
    Then User will select doc type for edit
      | Doc Type |
      | DN       |
    Then User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type |
      | Edit Limit  |
    Then User clicks on NextButton
    And Select first document
    Then User clicks on NextButton
    Then User clicks on Expand row Icon
    And User will input Limit Value in Bulk Edit
      | Limit Value     |
      | 999999999999999 |
    Then User validate the limit value in Bulk Edit
      | limit value          |
      | $999,999,999,999,999 |
    Then User clicks on Cancel button



