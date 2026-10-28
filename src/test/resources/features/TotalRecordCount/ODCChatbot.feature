@Regression
@US=DMGS-9162 @ODCChatbotValidations

Feature: Documentation Centre Chatbot Assistance

  Scenario: User asks about ODC
    Given User will go to Document screen
    Then User click on the Need Help button
    When User ask the chatbot "What is ODC?"
    Then User should receive a response containing "The OSTTRA Documentation Centre (ODC) is a service designed for the digital capture, central management, and storage of electronic FX prime brokerage agreements"

  Scenario: Verify Chatbot UI Elements
    Given User will go to Document screen
    When User click on the Need Help button
    Then The chatbot UI elements should load successfully

  Scenario: Verify Contact Support UI Elements
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    Then The Contact Support UI elements should load successfully

  Scenario: Verify Contact Support Navigation
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    Then The Contact Support form should open successfully

  Scenario: Send button enables after filling out the Contact Support form
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    And User fill in the Contact Support form with Subject "Test Subject" and Description "Test Description"
    Then The Send button should become enabled

  Scenario: Back button navigates back to the main chatbot screen
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    And User click the Back button on the Contact Support form
    Then User should be returned to the main chatbot screen

  Scenario: Verify Contact Support Success Screen
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    And User fill in the Contact Support form with Subject "Test Subject" and Description "Test Description"
    And User click the Send button on the Contact Support form
    Then The message sent success screen should load successfully

  Scenario: Verify Ask Another Question button returns to main chat
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    And User fill in the Contact Support form with Subject "Test Subject" and Description "Test Description"
    And User click the Send button on the Contact Support form
    And User click the Ask another question button
    Then User should be returned to the main chatbot screen

  Scenario: Verify Close button dismisses the chatbot widget
    Given User will go to Document screen
    When User click on the Need Help button
    And User click on the Contact Support link in the chatbot
    And User fill in the Contact Support form with Subject "Test Subject" and Description "Test Description"
    And User click the Send button on the Contact Support form
    And User click the Close button on the success screen
    Then The chatbot widget should close

    @DMGS-9162
  Scenario: Verify the Beta tag is removed from the chatbot widget
    Given User will go to Document screen
    When User click on the Need Help button
    Then The Beta tag should not be displayed on the chatbot UI

  Scenario: Verify chatbot returns a valid text response for custom inputs
    Given User will go to Document screen
    When User click on the Need Help button
    And User ask the chatbot "What is ODC?"
    Then The chatbot should return a valid non-empty text response

  Scenario: Verify chatbot handles a different question without breaking
    Given User will go to Document screen
    When User click on the Need Help button
    And User ask the chatbot "How do I access my files?"
    Then The chatbot should return a valid non-empty text response

  Scenario: Verify chatbot handles unrecognized or unrelated queries gracefully
    Given User will go to Document screen
    When User click on the Need Help button
    And User ask the chatbot "play a game"
    Then The chatbot should display the standard fallback error message