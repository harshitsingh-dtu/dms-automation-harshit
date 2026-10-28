@Regression @CreditLinkOverrideFunction  @US=DMGS-6274 @US=DMGS-6265

Feature: Validating Creditlink Override Functionality

  @TC=01
  Scenario: Verify that Creditlink Override is inside Organisation Dropdown
    Then User clicks on Menu bar on Dashboard
    Then User clicks on the Organisation Dropdown
    And Verify CreditLink Override text is present

  @TC=03 @TC=05
  Scenario: Verify that User can set and then save CreditLink Override Lei's for PB/EB/Client
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei       |
      | GOLDMAN SACHS INTERNATIONAL |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the value from PB, EB, Client if not empty
    Then User Enter the text PB Column
    Then User Enters the text EB Column
    Then User Enters the text Client Column
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |

  @TC=04
  Scenario: Verify that User can set and then save CreditLink Override Lei's for PB/Client
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei       |
      | GOLDMAN SACHS INTERNATIONAL |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | 4 Way    |
    Then User clicks on edit icon
    Then User removes the value from PB, Client if not empty
    Then User Enter the text PB Column
    Then User Enters the text Client Column for 4 Way
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |

  @TC=06
  Scenario: To Verify whether Override ID's have a maximum length of 100 characters
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei       |
      | GOLDMAN SACHS INTERNATIONAL |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the value from PB, EB, Client if not empty
    Then User validates the length of Override ID is 100 characters

  @TC=07 @TC=08
  Scenario: Verify that User can save the information only by clicking submit button and working of cancel button on the Organisation Information screen
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei       |
      | GOLDMAN SACHS INTERNATIONAL |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the value from PB, EB, Client if not empty
    Then User Enter the text PB Column
    Then User Enters the text EB Column
    Then User Enters the text Client Column
    Then User clicks on Save button for Override Values
    And User verifies whether Save message appears or not
      | Data saved successfully |
    And User clicks on Cancel button
    Then User validates the CL override Page

  @TC=02
  Scenario: To validate columns and buttons over the CL Override Screen
    Given User is on the CL override screen
    Then User validates column Lei, Legal Entity Name and Action columns are present
    And User searches for the LEI in the search bar
      | update screen search lei       |
      | GOLDMAN SACHS INTERNATIONAL |
    Then User clicks on update button
    And User validates column Organisation Id and name, active users, total users
    Then User clicks on Cancel button

#    TC-09, TC-10, TC-11 are partially automated as we cannot verify them in ODC through automation scripts
  @TC=09
  Scenario: Verify that User can create a document after updating Override Id
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 984500FF08A0VDFA6976                 |
      | clientLeiId | 6SHGI4ZSSLCXXQSBB395                 |
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei              |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the value from PB, EB, Client if not empty
    Then User Enter the text PB Column
    Then User Enters the text EB Column
    Then User Enters the text Client Column
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User will go to Document screen
    Then User will click on Create new document
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN            | PB        |
    And User select the LEIs
      | Prime Broker 1 | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB 1           | Osttra Group Ltd.                     |
      | Client 1       | CITIGROUP INC.                        |
    Then User clicks on Next button
    Then User clicks on Auth Scope Tab
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product                 |
      | FX          | Bullion        | Bullion Vanilla Options |
    And User clicks on Add Auth Line
    And User enables all Auth Lines
    And User clicks on Next button
    Then User enable the Limit line and validate the same
    Then User clicks on Next button
    Then User validates the message
      | Limit scope updated successfully |
    Then User clicks on Next button
    And User clicks on Preview & Submit tab
    And User clicks on submit for approval button
    Then Users click on Commit button on the following functionality is not supported pop-up
    Then User validates the Document approved message
      | Document is Approved |


  @TC=10
  Scenario: Verify that User can edit a document after updating Override Id
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei              |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the value from PB, EB, Client if not empty
    Then User Enter the text PB Column
    Then User Enters the text EB Column
    Then User Enters the text Client Column
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User will go to Document screen
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | EB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Document Status            |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Osttra Group Ltd.                     |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Enforced                              |
    Then User clicks on edit icon
    And User will select acting as LEIs for edit
      | Acting as                             |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will select action type for edit
      | Action type |
      | Edit Limit  |
    Then User will click on submit
    And User will input Limit Value on Edit Limit screen
      | Limit Value |
      | 10000000000           |
    Then User clicks on submit for approval button for Edit Limit
    And User validates the message
      | Limit scope updated successfully |
    Then User validates the Document approved message
      | Document is Approved |

  @TC=11
  Scenario: Verify that User can terminate a document after updating Override Id
    Given User is on the CL override screen
    Then User validates the CL override Page
    And User searches for the LEI in the search bar
      | update screen search lei              |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on update button
    Then User will select the Doc type for CL Overrride
      | Doc Type |
      | DN       |
    Then User clicks on edit icon
    Then User removes the value from PB, EB, Client if not empty
    Then User Enter the text PB Column
    Then User Enters the text EB Column
    Then User Enters the text Client Column
    Then User clicks on Save button for Override Values
    Then User will click on Submit Button
    Then User validates the message
      | Data saved successfully |
    Then User will go to Document screen
    Then User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                |
      | PB-1 Legal Entity Name     |
      | EB-1 Legal Entity Name     |
      | Client-1 Legal Entity Name |
      | Document Status            |
    And user will select Column Values on Document listing screen
      | Column Name                | value                                 |
      | PB-1 Legal Entity Name     | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | EB-1 Legal Entity Name     | Osttra Group Ltd.                     |
      | Client-1 Legal Entity Name | CITIGROUP INC.                        |
      | Document Status            | Enforced                              |
    Then User clicks on Terminate button
    Then user will submit the changes
