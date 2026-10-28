@GeneralTerms @DocumentGeneralTerms_DN @Regression
@document_type=DN
Feature: User validates the GeneralTerms

  @Bug=7064
  @TC=6818 @TC=2780 @TC=2779 @TC=2778 @TC=2767 @TC=2765 @TC=2763 @TC=2764 @TC=2762 @TC=2759 @TC=2774 @TC=2271 @TC=2736 @TC=2738 @TC=2202 @TC=2270 @TC=2272 @TC=2203 @TC=2110 @TC=2206 @TC=2204 @TC=2205 @TC=2273
  Scenario: User validates the GeneralTerms dates & Notes
    Given User will go to Document screen
    When User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name                   |
      | PB-1 Legal Entity Name        |
      | Client-1 Legal Entity Name    |
      | EB-1 Legal Entity Name        |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED|
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
      |Document status               |Draft                |
    And User clicks on edit icon
    And User clicks on General Terms Tab
    And User verifies Physically Settled Bullion is displayed
#    And User selects the Physically Settled Bullion checkbox //Bug
#    And User edits the bullion dates
    And User validates Notes are visible for Prime Broker and not for Client
    And Common notes section should be displayed and enter dummy text
    And User clicks on Save As Draft button
    And Validate the Address max character limit is 100
    Then User validates the toast message
      |General terms saved successfully|
    And Verify and click back button
    #And verify Confirmation popup
    And User validates Document terms screen
    And User clicks on Next button
#    And Validate the Contact max character limit is 400 //check this in UAT its 100
    And User navigate to Relationship Status and its values
    And Validate the Notes max character limit is 1000
    And User clicks on Reset Current Changes button
    And Validate Contact is reset to blank
    And User clicks on Preview & Submit tab
    And User clicks on General Terms Tab Preview tab
#    And validate the Physically Settled Bullion is true -Bug
    And User validates PB notes data in preview
    |This is dummy PB Notes|
    And User validate Common notes data in preview
    |This is dummy Common Notes|
    And User clicks on Cancel button

@TC=6820 @TC=6821
Scenario: User Validate "Physically Settled Bullion" filter in Dashboard
  Given User will go to Document screen
  When User clicks on Column Selection button
  And User will search for column, selects it if not already selected and validates the same on Document listing screen
    | Column Name    |
    | Physically settled bullion  |
  Then user will select Column Values on Document listing screen
    |Column Name                   |value                |
    |Physically settled bullion    |True                 |
  And User validates the documents are displayed with Physically bullion value as True
  Then user will select Column Values on Document listing screen
    |Column Name                   |value                |
    |Physically settled bullion    |False                 |
  And User validates the documents are displayed with Physically bullion value as False


@TC=6822
Scenario: Validate user is able to make query for "Physically Settled Bullion"
  Given User will go to Document screen
  And User will click on the Add Edit query button
  And User will be redirected to Add Edit query screen
  And User clicks on Add query block
  And User selects the field operator and value
    |field                |operator  |value |
    |Physically settled bullion   |=      |True    |
  Then User clicks on Apply
  And User validates the documents are displayed with Physically bullion value as True
  And User will click on the Add Edit query button
  And User will be redirected to Add Edit query screen
  And User clicks on Add query block
  And User selects the field operator and value
    |field                |operator  |value |
    |Physically settled bullion   |=      |False    |
  Then User clicks on Apply
  And User validates the documents are displayed with Physically bullion value as False