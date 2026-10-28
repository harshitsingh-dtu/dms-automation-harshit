@Regression
@revisedmenu

Feature: Validate Revised side menu

  @TC-2665 @TC-2666
  Scenario: Verify User is able see osttra details in bottom of menu
    Given User is on the all document screen
    When  User clicks on Menu bar on Dashboard
    Then  Validate osttra details in bottom

  @TC-2667 @TC-2668
  Scenario: Verify the dashboard in side menu
    Given User is on the all document screen
    When  User clicks on Menu bar on Dashboard
    And  Validate the dashboard
    Then Validate Env details beside X icon

  @TC-2673 @TC-2675 @TC-2675 @TC-2676
  Scenario: Validate the Header banner
    Given User validates the App logo
    When User validates the Messages in header section
    And User validates the User Details in header section
    Then User validates the Help in header section

  Scenario: Validate Customer Support Url and email
    Given User is on the all document screen
    Then User clicks on "Help"
    Then User clicks on "About OSTTRA"
    And Verify mail and web are hyperlinks
    Then Click on close icon
    Then User clicks on "OSTTRA INDIA SERVICES PRIVATE LIMITED"
    Then User clicks on "View Profile"
    Then User clicks on "Help & Support"
    And Verify the email mentioned is hyperlink