@DocumentFramework @Regression
@RejectionReason

Feature: Reject Document FrameWork with Rejection reason and validate same

  Scenario: User configures the notification
    Given User is on the Dashboard
    And Click on notification bell icon
    And User clicks on view all notifications
    And User clicks on Set Configuration button
    And user will select Column Values on notification
      |Column Name         |value                                 |
      |DF PB Rejected      |selected                               |

  @TC=6627 @TC=6793 @TC=6794 @TC=6579 @TC=6581 @TC=6595 @ConfigureApprovalMatrix
  Scenario: User creates a DN DocumentFramework and reject it
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 254900SLCV8KI86BHL86                 |
    Given User is on Document Framework Page
    Then User creates a document framework through API
      |Payload path|
      |src/test/java/resources/DF_Creation_02.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds General Terms via API for DN Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
      |Column Name   |value       |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
      |EB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED       |
    Then User clicks on edit icon
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
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
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document Framework screen
      |Column Name   |value        |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED        |
      |EB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED        |
    Then User will click on reject icon
    Then User validates the rejection reason pop-up
    And User enters the Rejection reason
      |Rejection Reason|
      | Rejected for Sanity TestCase|
    And User clicks on Reject button and validates the DF screen
    Then User validates the Rejection reason in the preview on DF listing screen
    And Validate the LifeCycle status of DF
      |Status|
      |REJECTED|
    And User clicks on close button
    And User refreshes the browser
    And Click on notification bell icon
    Then Check if User will be able to see notification for Rejecting the document

  @TC=6790 @TC=6596
Scenario: Validate that user is able to capture the rejection reason in General terms(without data) when rejecting a DF
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 254900SLCV8KI86BHL86                 |
    Given User is on Document Framework Page
    Then User creates a document framework through API
      |Payload path|
      |src/test/java/resources/DF_Creation_02.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
      |Column Name         |value                                 |
      |PB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name             |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |Lifecycle status    |Draft                                 |
    Then User clicks on edit icon
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
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
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User refreshes the browser
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value        |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED        |
      |EB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User will click on reject icon
    Then User validates the rejection reason pop-up
    And User enters the Rejection reason
    |Rejection Reason|
    | Rejected for Sanity TestCase|
    And User clicks on Reject button and validates the DF screen
    Then User validates the Rejection reason in the preview on DF listing screen
    And Validate the LifeCycle status of DF
      |Status|
      |REJECTED|

  @TC=6791 @TC=6571 @TC=6567 @TC=6570
  Scenario: Validate that user is able to reject a DF without Rejection reason
    Given User resets DF document
      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
      | pbLeiId   | 254900SLCV8KI86BHL86                 |
      | ebLeiId   | 254900SLCV8KI86BHL86                 |
    Given User is on Document Framework Page
    Then User creates a document framework through API
      |Payload path|
      |src/test/java/resources/DF_Creation_02.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
      |Column Name   |value       |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on edit icon
    Then User will use drag and drop PB1 to approval Seq 1 in DF
    Then User clicks on Next button
    And User clicks on Auth Scope Tab
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
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And User refreshes the browser
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name   |value        |
      |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on Preview of DF
    Then User Validates the DocumentType, Allowed Currencies, PB & EB for DF
    Then User Validates the approval Wokflow for DF and actions
    Then User validates the approval Wokflow for DN
    Then User validates the enforcement rule for DN
    Then User clicks on cross icon
    Then User will click on reject icon
    Then User validates the rejection reason pop-up
    And User clicks on Reject button and validates the DF screen
    Then User clicks on Preview of DF
    Then User validates the DF version ID in the preview
    Then User Validates the DocumentType, Allowed Currencies, PB & EB for DF
    Then User Validates the approval Wokflow for DF and actions
    Then User validates the approval Wokflow for DN
    Then User validates the enforcement rule for DN
    Then User validates the general terms
    Then User validates that NO Rejection reason is displayed in the preview
    And User validates that NO LifeCycle status of DF
      |Status|
      |REJECTED|
    Then User validates the Auth Scope
    Then User validates the limit scope
    Then User clicks on close button
    And Validate user is on Document Framework Screen
