@DF_to_DocCreation @document_type=DN
@API @Global_MRs
Feature: Create Document via API

@DocumentFrameworkCreation
Scenario: TC-1 - User creates a DN DocumentFramework and approves it
    Given User is on Document Framework Page
    Then User creates a document framework through API
        |Payload path|
        |src/test/java/resources/DF_Creation_MR1.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds General Terms via API for DN Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
        |Column Name   |value                                 |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
        |EB Name       |CITIGROUP INC.                        |
    Then User clicks on edit icon
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
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Bullion        | Bullion Exotic Options,Bullion Vanilla Options,Bullion Spot or Forward|
    And Click on + Add currencies
    And User will search for the currency and select them
        |currency list|
        |XAG|
        |XAU|
        |XPD|
        |XPT|
    And User will submit the changes
    * User will input Auth Tenor value
        | Auth Value |
        | 100        |
    * User will select tenor in Auth Tenor
        | Auth Tenor |
        | Business Days      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document Framework screen
        |Column Name   |value                |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
        |EB Name       |CITIGROUP INC.       |
    Then User validates the Document Framework status as approved

@DraftEDN
Scenario: TC-1 - User creates a draft document from DocumentFramework
    When User creates a document through API
    |Payload path|
    |src/test/java/resources/DocCreation_MR1.json|
#    And User deletes the document created through API
#    Given User rights data into the file
#    |TC ID|
#    |TC-API  |

@DocumentFrameworkCreation2
Scenario: TC-2 - User creates another DN DocumentFramework and approves it
    Given User is on Document Framework Page
    Then User creates a document framework through API
        |Payload path|
        |src/test/java/resources/DF_Creation_MR2.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds General Terms via API for DN Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
        |Column Name   |value                |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
        |EB Name       |3G Fund, L.P.        |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Exotic Options | Double Barrier |
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
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Cash           | Spot    |
    And Click on + Add currencies
    And User will search for the currency and select them
        |currency list|
        |AED|
        |AOA|
    And User will submit the changes
    And User enables Tenor
    * User will select tenor in Auth Tenor
        | Auth Tenor    |
        | Spot-only     |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Cash           | Spot    |
    And Click on + Add currencies
    And User will search for the currency and select them
        |currency list|
        |CLF|
        |CRC|
    And User will submit the changes
    And User enables Tenor
    * User will select tenor in Auth Tenor
        | Auth Tenor         |
        | Calendar Days      |
    * User will input Auth Tenor value
        | Auth Value |
        | 365        |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Bullion        | Bullion Vanilla Options|
    And Click on + Add currencies
    And User will search for the currency and select them
        |currency list|
        |XAG|
        |XAU|
        |XPD|
        |XPT|
    And User will submit the changes
    And User enables Tenor
    * User will input Auth Tenor value
        | Auth Value |
        | 10          |
    * User will select tenor in Auth Tenor
        | Auth Tenor |
        | Business Days      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document Framework screen
        |Column Name   |value                |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
        |EB Name       |3G Fund, L.P.        |
    Then User validates the Document Framework status as approved

@DraftDocument2
Scenario: TC-2 - User creates a draft document from DocumentFramework
    Given User is on Document Page
    When User creates a document through API
        |Payload path|
        |src/test/java/resources/DocCreation_MR2.json|
#    And User deletes the document created through API
#    Given User rights data into the file
#    |TC ID|
#    |TC-API  |

@ApprovedEDN
Scenario: User creates an Approved EDN from DocumentFramework
    Given User is on Document Page
    When User creates a document through API
        |Payload path|
        |src/test/java/resources/DocCreation_MR3.json|
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Exotic Options | Double Barrier |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Bullion | Bullion Vanilla Options |
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
        |9999999|
#    And User click on save icon for limit line
    Then User clicks on Next button
    Then User Final Preview & Submit the Document
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
    |Document is Approved|

@DraftDF
Scenario: Creating Draft DF
    Given User is on Document Framework Page
    And Click on create New Document Framework button
    And validate the document type value as DN
    Then User select acting as
        | Acting As |
        | PB        |
    And User select the LEIs
        |Prime Broker 1      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
        |EB 1                |ABC ARBITRAGE   |
    Then User clicks on Next button
    Then User clicks on Cancel button


@DocumentFrameworkCreation4
Scenario: TC-1 - User creates a DN DocumentFramework and approves it
    Given User is on Document Framework Page
    Then User creates a document framework through API
        |Payload path|
        |src/test/java/resources/DF_Creation_MR4.json|
    Then User adds immediate enforcement rules via API for DN Document or Document Framework
    Then User adds General Terms via API for DN Document Framework
    Then User adds LimitScope via API for Document or Document Framework
    And user will select Column Values on Document Framework screen
        |Column Name   |value                                        |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED        |
        |EB Name       |Osttra Group Ltd.                            |
    Then User clicks on edit icon
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
    Then User Add Asset Class, Product Family, Product to the Auth Scope
        | Asset Class | Product Family | Product |
        | FX          | Bullion        | Bullion Exotic Options,Bullion Vanilla Options,Bullion Spot or Forward|
    And Click on + Add currencies
    And User will search for the currency and select them
        |currency list|
        |XAG|
        |XAU|
        |XPD|
        |XPT|
    And User will submit the changes
    * User will input Auth Tenor value
        | Auth Value |
        | 100        |
    * User will select tenor in Auth Tenor
        | Auth Tenor |
        | Business Days      |
    And User clicks on Add Auth Line
    Then User clicks on Next button
    Then User validates the message
        |Limit scope updated successfully|
    And User clicks on Limit Scope
    And User will input Calculation Type
        |Calculation Type|
        |NOP|
    And User will input Netting Type
        |Netting Type        |
        |Gross excluding USD |
    Then User enter Bullion Trades in Limit Scope
        |Include Metals|
    Then User will input Delta
        |Delta|
        |Yes  |
    Then User will input Product family
        |Product Family   |
        | Cash            |
        | Vanilla Options |
        | Volatility      |
        | Bullion         |
    Then User clicks on Add Limit button
    Then User clicks on Save As Draft button
    Then User validates the message
        |Limit scope updated successfully|
    And User clicks on Preview & Submit tab
    Then User Final Preview & Submit the Document
    And user will select Column Values on Document Framework screen
        |Column Name   |value                                        |
        |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED        |
        |EB Name       |Osttra Group Ltd.                            |
    Then User validates the Document Framework status as approved

    @TC3-Test
    Scenario: TC-3 - User creates another DN DocumentFramework and approves it
        Given User is on Document Framework Page
        Then User creates a document framework through API
            |Payload path|
            |src/test/java/resources/DF_Creation_MR9.json|
        Then User adds immediate enforcement rules via API for DN Document or Document Framework
        Then User adds General Terms via API for DN Document Framework
        Then User adds Cash and Non-Cash LimitScope via API for Document or Document Framework
        And user will select Column Values on Document Framework screen
            |Column Name   |value                |
            |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED               |
            |EB Name       |BONETTI GIORDANO        |
        Then User waits for 5 seconds
        Then User clicks on edit icon
        And User clicks on Auth Scope Tab
        Then User Add Asset Class, Product Family, Product to the Auth Scope
            | Asset Class | Product Family | Product |
            | FX          | Exotic Options | Double Barrier |
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
        And User will input Auth Tenor value
            | Auth Value |
            | 3          |
        And User will select tenor in Auth Tenor
            | Auth Tenor |
            | Years      |
        And User clicks on Add Auth Line
        Then User Add Asset Class, Product Family, Product to the Auth Scope
            | Asset Class | Product Family | Product |
            | FX          | Vanilla Options  | Vanilla Option  |
        And Click on + Add currencies
        And User will search for the currency and select them
            |currency list|
            |AED|
            |CLF|
            |COP|
            |CRC|
            |ISK|
        And User will submit the changes
        Then User waits for 2 seconds
        And User will input Auth Tenor value
            | Auth Value |
            | 3          |
        And User will select tenor in Auth Tenor
            | Auth Tenor |
            | Years      |
        And User clicks on Add Auth Line
        Then User Add Asset Class, Product Family, Product to the Auth Scope
            | Asset Class | Product Family | Product |
            | FX          | Bullion        | Bullion Vanilla Options|
        And Click on + Add currencies
        And User will search for the currency and select them
            |currency list|
            |XAG|
            |XAU|
            |XPD|
            |XPT|
        And User will submit the changes
        Then User waits for 2 seconds
        And User will input Auth Tenor value
            | Auth Value |
            | 10          |
        And User will select tenor in Auth Tenor
            | Auth Tenor |
            | Business Days      |
        And User clicks on Add Auth Line
        Then User Add Asset Class, Product Family, Product to the Auth Scope
            | Asset Class | Product Family | Product |
            | FX          | Cash           | Spot    |
        And Click on + Add currencies
        And User will search for the currency and select them
            |currency list|
            |AED|
            |BHD|
        And User will submit the changes
        And User will select tenor in Auth Tenor
            | Auth Tenor    |
            | Spot-only     |
        And User clicks on Add Auth Line
        Then User Add Asset Class, Product Family, Product to the Auth Scope
            | Asset Class | Product Family | Product |
            | FX          | Cash           | Spot    |
        And Click on + Add currencies
        And User will search for the currency and select them
            |currency list|
            |CAD|
            |CHF|
        And User will submit the changes
        And User will select tenor in Auth Tenor
            | Auth Tenor         |
            | Business Days      |
        And User will input Auth Tenor value
            | Auth Value |
            | 365        |
        And User clicks on Add Auth Line
        Then User clicks on Next button
        Then User Final Preview & Submit the Document
        Then User checks if Legal Name changes pop-up appears ignore it
        And user will select Column Values on Document Framework screen
            |Column Name   |value                |
            |PB Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED        |
            |EB Name       |BONETTI GIORDANO        |
            |Lifecycle status | Approved                                |
        Then User waits for 5 seconds
        Then User validates the Document Framework status as approved