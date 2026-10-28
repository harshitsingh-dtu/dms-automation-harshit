@DF_DNIntegration @Regression
@CurrencyGroupand_DraftEDN
@US=DMGS-8449

Feature: Adding Currency via currency group in Auth line should be reflected on Auth lines

  @TC_01 @TC_02
  Scenario: Validate User is able to see currency group name & add multiple currency groups on the Auth line -DF
    Given User is on Document Framework Page
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name         |
      | PB Name             |
      | EB Name             |
      | Lifecycle status    |
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                 |
      |PB Name          |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name          |ABC ARBITRAGE                         |
      |Lifecycle status |Draft                                 |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
#Then Clicks on DF Auth scope Expand All button
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines if available
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    Then User selects the currency group in AuthScope
      |Automation_OT_currencyGroup|
    And User will submit the changes
    Then User clicks on Add Auth Line
    Then User validates the currency group name is displayed on Auth line
      | Automation_OT_currencyGroup |
    Then User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family    | Product         |
      | FX          | Vanilla Options   | Vanilla Option  |
    And Click on + Add currencies
    Then User clicks on the currency group pair tab in AuthScope
    And User selects the currency group pair in AuthScope
      |Automation_OT_CurrencyPairGroup|
    And User will submit the changes
    Then User clicks on Add Auth Line
    Then User validates the currency group name is displayed on Auth line
      | Automation_OT_CurrencyPairGroup |
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|

  @TC_02 @TC_04
  Scenario: Validate if above Auth line is deleted & added back, the currency list should be updated - DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                 |
      |PB Name          |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name          |ABC ARBITRAGE                         |
      |Lifecycle status |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Future  |
    And Click on + Add currencies
    Then User selects the currency group in AuthScope
      |Automation_OT_currencyGroup|
    And User will submit the changes
    Then User clicks on Add Auth Line
    Then User validates the currency group name is displayed on Auth line
      | Automation_OT_currencyGroup |
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Bullion        | Bullion Spot or Forward  |
    And Click on + Add currencies
    And User will search for the currency and select them
      |currency list|
      |XAG|
      |XAU|
      |XPD|
      |XPT|
    And User will submit the changes
    Then User clicks on Add Auth Line
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|

  @TC_03 @TC_08 @TC_09
  Scenario: Validate User is add/dlt the currencies in the currency group added & validate they are displayed in the preview, view as pdf -DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                 |
      |PB Name          |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name          |ABC ARBITRAGE                         |
      |Lifecycle status |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    #Then User Add Asset Class, Product Family, Product to the Auth Scope
    #  | Asset Class | Product Family | Product |
    #  | FX          | Cash           | Future  |
    #And Click on + Add currencies
    Then User edits the currencies for the auth line
      |Auth line                          | Add Currencies  | Remove currencies |
      |FX Cash Future                     | AOA             | BBD               |
      |FX Bullion Bullion Spot or Forward | NA              | XAG, XAU          |
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|
    Then User clicks on Preview & Submit tab
    Then User clicks on Auth Scope Tab in Final Preview
    And User validates Auth Scope Data in Document Preview
      |Product                                |Currencies         | Tenor           |
      |FX Cash Future                         | AOA,KWD,CLF,VND   | Unspecified     |
      |FX Bullion Bullion Spot or Forward     | XPD,XPT           | Unspecified     |
    Then User clicks on view as PDF button
    And User validates Auth Scope Data in view as PDF
      |Product                                |Currencies         | Tenor           |
      |FX Cash Future                         | AOA,KWD,CLF,VND   | Unspecified     |
      |FX Bullion Bullion Spot or Forward     | XPD,XPT           | Unspecified     |


  @TC_08
  Scenario: Validate updated currencies are displayed in Dashboard preview - DF
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                 |
      |PB Name          |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name          |ABC ARBITRAGE                         |
      |Lifecycle status |Draft                                 |
    Then User clicks on document version ID on Dashboard
    And User validates Auth Scope Data in view as PDF
      |Product                                |Currencies         | Tenor           |
      |FX Cash Future                         | AOA,KWD,CLF,VND   | Unspecified     |
      |FX Bullion Bullion Spot or Forward     | XPD,XPT           | Unspecified     |

  @ResetData
  Scenario: Resetting DF Data
    Given User is on Document Framework Page
    And user will select Column Values on Document Framework screen
      |Column Name      |value                                 |
      |PB Name          |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Name          |ABC ARBITRAGE                         |
      |Lifecycle status |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Auth Scope Tab
    Then Clicks on DF Auth scope Expand All button if Expand is visible
    Then User deletes all the auth Lines
    Then User clicks on Save As Draft button
    And User validates the message
      |Auth scope saved successfully|
