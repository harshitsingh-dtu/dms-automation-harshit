@DF_DNIntegration @Regression
@Enforced_EDN
@US=DMGS-3377 @US=DMGS-3175 @US=DMGS-4183

Feature: Impact on EDN on addition/Deletion of new Limit/AuthLines in DF, where EDN is in Draft or enforced state

  Scenario: User creates an enforced EDN
    Given User will go to Document screen
    Then User clicks on Create New Document
    Then User select document type,acting as
    | Document Type | Acting As |
    | DN            | PB        |
    And User select the LEIs
    |Prime Broker 1   |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    |EB 1             |Osttra Group Ltd.                      |
    |Client 1         |3G Fund, L.P.                          |
    Then User clicks on Next button
    And User is able to see approval workflow tab
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Volatility | Volatility Swap |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion        | Bullion Exotic Options,Bullion Vanilla Options,Bullion Spot or Forward|
    And User clicks on Add Auth Line
    Then User enables all Auth Lines
    Then User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on limit line edit icon and enters value
      |99999999|
    Then User clicks on Next button
    Then User validates the message
      |Limit scope updated successfully|
    Then User Final Preview & Submit the Document
    Then User checks if Legal Name changes pop-up appears ignore it
    Then User validates the Document approved message
      |Document is Approved|
    Then User waits for some time, refreshes the page and validates the status

  @TC=7029 @DMGS-9333 @TC_03
  Scenario: Validate error message when user perform Remove Currency & try to submit document
    Given User will go to Document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | EB-1 Legal Entity Name     |
      | Document Status            |
      | Document Action            |
    And user will select Column Values on Document listing screen
      |Column Name                    |value                                 |
      |PB-1 Legal Entity Name         |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name         |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name     |3G Fund, L.P.                         |
      |Document Status                |Enforced                              |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type      |
      | Remove currency  |
    And User will click on submit
    And User is on Auth Scope tab
    Then User will search for the currency and select them
      |currency list|
      |XAG|
      |XAU|
      |XPD|
      |XPT|
      |AED|
      |CLF|
      |COP|
      |CRC|
      |ISK|
    Then User clicks on submit for approval button
    Then User validates the message
      |Auth Scope can not be empty|

  @TC=7029
  Scenario: Validate error message when user perform Remove Products & try to submit document
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Status              |Enforced                              |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type      |
      | Remove Products  |
    And User will click on submit
    Then User validates the warning pop-up message
      |A Draft version of this document already exists:|
    Then User clicks on "Ok" button
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Status              |Draft                                 |
    Then User deletes the document if it exists
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type      |
      | Remove Products  |
    And User will click on submit
    And User is on Auth Scope tab
    Then User deletes all the auth Lines in Remove Products action
    Then User clicks on submit for approval button
    Then User validates the message
      |Auth Scope can not be empty|

  @TC=7176 @TC=7179 @TC=7180
  Scenario: Validate show latest version is displayed, last updated document is coming on top & selected and working with other filters on Document screen
    Given User will go to Document screen
    And User validates Show latest version screen
    Then User stores the first Document ID from Document dashboard and searches it
    Then User clicks on Show latest version screen checkbox
    Then User validates the document status
      |status|
      |Draft |
    And Verify the Total Record Count
      |1|
    And User will click on Apply More Filters
    And User will be redirected to Advance Filters Screen
    Then User enters Auth Scope values in Advance filters
      |Product Family|Product                   |Tenor Value|Tenor         |
      |Bullion       |Bullion Vanilla Options   |100        |Business Days |
    Then Click on Apply Filters
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Status              |Enforced                              |
    And Verify the Total Record Count
      |1|

  @TC=7029
  Scenario: Validate error message when user perform edit limit & try to submit document
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Status              |Enforced                              |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type |
      | EDIT LIMIT  |
    And User will click on submit
    Then User validates the warning pop-up message
      |A Draft version of this document already exists:|
    Then User clicks on "Ok" button
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Status              |Draft                                 |
    Then User deletes the document if it exists
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type      |
      | EDIT LIMIT       |
    And User will click on submit
    And User is on Limit Scope tab
    Then User disables the Limit line and validate the same
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the message
      |Limit Scope can not be empty|

@TC=7276
  Scenario: Validate that User update the Limit Scope values via Edit Limit should get reflected in Compare functionality
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Action              |Edit Limit                            |
    Then User clicks on edit icon
    Then User enters limit value on Edit limit screen
      |Limit Value|
      |99999      |
    Then User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the message
      |Limit scope updated successfully|
    Then Click on Yes button
    Then User validates text is visible
      |Text           |
      |Version Compare|
      |View Difference|
      | $ 99999       |
    Then User clicks on submit for approval button on version Compare screen
    Then User validates the Document approved message
      |Document is Approved|
    Then User waits for some time, refreshes the page and validates the status

  @TC=7276 @TC=7277
  Scenario: Validate that User update the Limit Scope values via Edit Limit should get reflected in Compare functionality
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
      |Column Name                  |value                                 |
      |PB-1 Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
      |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
      |Document Status              |Enforced                              |
    Then User clicks on edit icon
    And User will select action type for edit
      | Action type      |
      | Edit Document    |
    And User will click on submit
    And User is able to see approval workflow tab
    Then User is on Limit Scope tab
    Then User clicks on limit line edit icon and enters value
      |100000|
    Then User validates the message
      |Limit scope updated successfully|
    Then User clicks on Preview & Submit tab
    And User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
      |Document is Approved|
    Then User clicks on compare button icon
    Then User validates text is visible
      |Text           |
      |Version Compare|
      |View Difference|
      | $ 100000      |

  @TC-6704 @TC-6674
  Scenario: Validating the filter is working for the updated value
    Given User is on Document Page
    Then User will click on the Add Edit query button
    And User clicks on Add query block
    And User performs multiple Add query block
      | field                      | operator | value                                 | condition |
      | PB-1 Legal Entity Name     | =        | OSTTRA INDIA SERVICES PRIVATE LIMITED | AND       |
      | EB-1 Legal Entity Name     | =        | Osttra Group Ltd.                     | AND       |
      | Client-1 Legal Entity Name | =        | 3G Fund, L.P.                         | AND       |
      | Document Status            | =        | Enforced                              | null      |
    Then User clicks on Apply
    And User waits for 3 seconds
    And User clicks on document version ID on Dashboard
    Then User validates the limit value in the limit line in Pdf
      | limit value   |
      | $ 100,000     |
    Then User clicks on close button

  @TC=7280
  Scenario:Validate that compare button is Not available for Enforced,Cancelled & Terminated button
    Given User will go to Document screen
    And user will select Column Values on Document listing screen
    |Document Status          |Enforced    |
    Then Validate Compare button is not visible
    And user will clear the filter for following column
      |Column Name         |
      |Document Status     |
    And user will select Column Values on Document listing screen
      |Document Status          |Terminated    |
    Then Validate Compare button is not visible
    And user will clear the filter for following column
      |Column Name         |
      |Document Status     |
    And user will select Column Values on Document listing screen
      |Document Status          |Cancelled    |
    Then Validate Compare button is not visible

    @ResetData
    Scenario: Deleting draft & terminating the enforced Document
      Given User is on Document Page
      And user will select Column Values on Document listing screen
        |Column Name                  |value                                 |
        |PB-1 Legal Entity Name       |Osttra India Services Private Limited |
        |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
        |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
        |Document Status              |Draft                                 |
      Then User deletes the document if it exists
      Then User validates the message
        |Document is deleted|
      Then user will select Column Values on Document listing screen
        |Column Name                  |value                                 |
        |PB-1 Legal Entity Name       |Osttra India Services Private Limited |
        |EB-1 Legal Entity Name       |Osttra Group Ltd.                     |
        |Client-1 Legal Entity Name   |3G Fund, L.P.                         |
        |Document Status              |Enforced                              |
      Then User clicks on Terminate button
      And Click on Submit
      Then User validates the notification for Document Termination
