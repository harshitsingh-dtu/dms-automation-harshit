@Regression @RolesAndPermissions @ignore @DMGS-10258
Feature: Dual User Role and Permission Validation

    @TC=6394
  Scenario: Verify the user can view records for all organizations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      |User|
      |automation.user3@yopmail.com|
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    Then User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And User removes all existing LEI Org type mappings
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | 4 Way    |
    And User is able to select LEI from LEIs dropdown
      | LEI                                   |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
      And User is able to select Doc type from Doc type dropdown
        | Doc Type |
        | 4 Way    |
      And User is able to select LEI from LEIs dropdown
        | LEI                                   |
        | THE MOYRA BRUCE FAMILY TRUST |
      And User is able to select Org type from Org type dropdown
        | Org type |
        | PB       |
      And User is able to add the LEI Org type combination
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    And The secondary user navigates to the document listing screen
    And User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      | User                         |
      | automation.user3@yopmail.com |
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    Then User is on Approval group screen
    Then verify the user can view records for all organizations in the table
      | Legal Entity Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    Then User is on approval matrix listing screen
    Then verify the user can view records for all organizations in the table
      | Legal Entity Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And Close the secondary browser

  @TC-6395
  Scenario: Verify the user can view currency records for all organizations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      | User                         |
      | automation.user3@yopmail.com |
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    Then User is on the Currency screen
    Then Verify the user can view currency records for all organizations
      | Organisation Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And User can reach to Currency Pair group screen
    Then Verify the user can view currency records for all organizations
      | Organisation Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And Close the secondary browser

  @TC-6396 @TC-8442
 Scenario: verify the user can view document template for all organizations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      |User|
      |automation.user3@yopmail.com|
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | 4W Management  |
      | DN Management  |
    And User removes all existing LEI Org type mappings
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | 4 Way    |
    And User is able to select LEI from LEIs dropdown
      | LEI                                   |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | DN   |
    And User is able to select LEI from LEIs dropdown
      | LEI                                   |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    Given User will go to Document template screen
    And User will click on create new template button and get redirected to create new document template screen
    Then user will enter template name organisation name and Doctype
      |Template Name     |Organisation Name                         |Doc Type |
      |Autotest_DN     |OSTTRA INDIA SERVICES PRIVATE LIMITED     |DN     |
    Then User clicks on Next button
    And User will click on the CK editor and type text into document content
      | Content           |
      | Test for Document Terms     |
    And User will click on Submit button and redirect to Document template listing screen
    And Close the secondary browser

  @TC-6397 @TC-6398
  Scenario: Verify that user can view and download documents for all organizations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      | User                         |
      | automation.user3@yopmail.com |
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | DN Management  |
      | OSTTRA Onboarding |
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    Then User is on Document Page
    And user will select Column Values on Document listing screen
      | Column Name     | value    |
      | Document Status | Enforced |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                  |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED  |
    Then User clicks on the download button
    Then User validates the file is downloaded
#    Then Verify the user can view and download documents for all organizations
#      | Legal Entity Name                     |
#      | Osttra India Services Private Limited |
#      | CITIGROUP INC.                        |
#      | BARCLAYS PLC                          |
    And Close the secondary browser

      @TC-6399
      Scenario: Verify user can update the status for all Organisations
        Given User is on the all document screen
        And   User clicks on User management
        Then User reaches the User Management screen
        When User will search for the User
          |User|
          |automation.user3@yopmail.com|
        Then User clicks on update button
        Then User is able to see role mapping dropdown
        And User is able to remove all the role
        And User is able to assign a role
          | role mapping      |
          | OSTTRA Onboarding |
        And User is able to select Doc type from Doc type dropdown
          | Doc Type |
          | 4 Way    |
        And User is able to select LEI from LEIs dropdown
          | LEI                                   |
          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
        And User is able to select Org type from Org type dropdown
          | Org type |
          | PB       |
        And User is able to add the LEI Org type combination
        And user will submit the changes
        Then User validates the user update notification
        When A "NonAdminOsttraPB" user logs into the application in an incognito window
        Then User navigates to the Organisation Management screen
        Then User toggles PB status to Lite and then resets to Online for the following Organisations
          | Organisation Name                     |
          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
          | CITIGROUP INC.                        |
          | BARCLAYS PLC                          |
        And Close the secondary browser

    @TC-6400 @TC-8443
  Scenario: Verify user is able to create Product groups for all organisations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      |User|
      |automation.user3@yopmail.com|
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    And  User is on the Dashboard page and navigate to Product Group
    When User creates the following product groups
      | Product Group Name | Organisation Name                     | Asset Class | Product Family | Product |
      | Autotest_PG        | OSTTRA INDIA SERVICES PRIVATE LIMITED | FX          | Cash           | Spot    |
      | Autotest_PG        | CITIGROUP INC.                        | FX          | Cash           | Forward |
      | Autotest_PG        | BARCLAYS PLC                          | FX          | Cash           | Swap    |
    Then verify the created product groups are visible on the listing screen
    When User updates the created product groups by modifying their names
    And Close the secondary browser

    @TC-6401 @TC-6403 @TC-8444
  Scenario: verify the user can view/edit user profiles for all organizations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      |User|
      |automation.user3@yopmail.com|
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    And  User clicks on User management
    Then User reaches the User Management screen
    Then verify the user can view and edit user profiles for all organizations
      | Organisation Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And Close the secondary browser

  @TC-8440 @TC-6357
  Scenario: Verify the user can create/view approval group
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      |User|
      |automation.user3@yopmail.com|
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And User removes all existing LEI Org type mappings
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | 4 Way    |
    And User is able to select LEI from LEIs dropdown
      | LEI                                   |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    And The secondary user navigates to the document listing screen
    Then User is on Approval group screen
    And User is on create new approval group screen
    When User generates unique the group name,organization name,LEI's,org type
      | group name | organisation name   | doc type | LEI's          | org type |
      |Automation_AG_with_User_| OSTTRA INDIA SERVICES PRIVATE LIMITED       | 4 Way    | OSTTRA | PB       |
    Then clicks on next
    And User will search for the users to be added and add them
      | user                         |
      | automation.user3@yopmail.com |
    And  User will submit the changes after adding users to the approval group
    And  Validates User added successfully notification and lands on approval group page
    Then User validates for the Approval group name
      | group name               |
      | Automation_AG_with_User_ |
    And Close the secondary browser

    @TC-8441
  Scenario: Verify the user can create, update, and view currency and currency-pair records for all organizations
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      | User                         |
      | automation.user3@yopmail.com |
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    Then User is on the Currency screen
    When User creates and updates the following currency groups
      | Currency Group Name | Organisation Name                     | Currency |
      | Auto_Curr           | OSTTRA INDIA SERVICES PRIVATE LIMITED | USD      |
      | Auto_Curr           | CITIGROUP INC.                        | EGP      |
      | Auto_Curr           | BARCLAYS PLC                          | EUR      |
    Then Verify the user can view currency records for all organizations
      | Organisation Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And User can reach to Currency Pair group screen
    When User creates and updates the following currency pair groups
      | Currency Pair Group Name | Organisation Name                     | Currency Pair |
      | Auto_CurrPair            | OSTTRA INDIA SERVICES PRIVATE LIMITED | USD-CAD       |
      | Auto_CurrPair            | CITIGROUP INC.                        | EUR-USD       |
      | Auto_CurrPair            | BARCLAYS PLC                          | GBP-USD       |
      Then Verify the user can view currency records for all organizations
      | Organisation Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And Close the secondary browser

  @TC-6357
  Scenario: Verify the user can view records for all organizations on approval matrix
    Given User is on the all document screen
    And   User clicks on User management
    Then User reaches the User Management screen
    When User will search for the User
      |User|
      |automation.user3@yopmail.com|
    Then User clicks on update button
    Then User is able to see role mapping dropdown
    And User is able to remove all the role
    And User is able to assign a role
      | role mapping      |
      | OSTTRA Onboarding |
    And User removes all existing LEI Org type mappings
    And User is able to select Doc type from Doc type dropdown
      | Doc Type |
      | 4 Way    |
    And User is able to select LEI from LEIs dropdown
      | LEI                                   |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User is able to select Org type from Org type dropdown
      | Org type |
      | PB       |
    And User is able to add the LEI Org type combination
    And user will submit the changes
    Then User validates the user update notification
    When A "NonAdminOsttraPB" user logs into the application in an incognito window
    Then User is on approval matrix listing screen
    When User creates the approval matrix for the following combinations if not present
      | Organisation Name                     | Doc Type | Legal Entity Name                     | Org type |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED | 4 Way    | OSTTRA INDIA SERVICES PRIVATE LIMITED | PB       |
      | CITIGROUP INC.                        | 4 Way    | CITIGROUP INC.                        | PB       |
      | BARCLAYS PLC                          | 4 Way    | BARCLAYS PLC                          | PB       |
    Then verify the user can view records for all organizations in the table
      | Legal Entity Name                     |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | CITIGROUP INC.                        |
      | BARCLAYS PLC                          |
    And Close the secondary browser

    @TC-6384
    Scenario: Verify the user can view approval groups and matrix for all organizations
      Given User is on the all document screen
      And   User clicks on User management
      Then User reaches the User Management screen
      When User will search for the User
        |User|
        |automation.user3@yopmail.com|
      Then User clicks on update button
      Then User is able to see role mapping dropdown
      Then User is able to remove all the role
      And User is able to assign a role
        | role mapping    |
        | OSTTRA View All |
      And User removes all existing LEI Org type mappings
      And User is able to select Doc type from Doc type dropdown
        | Doc Type |
        | 4 Way    |
      And User is able to select LEI from LEIs dropdown
        | LEI                                   |
        | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      And User is able to select Org type from Org type dropdown
        | Org type |
        | PB       |
      And User is able to select Doc type from Doc type dropdown
        | Doc Type |
        | DN        |
      And User is able to select LEI from LEIs dropdown
        | LEI                                   |
        | OSTTRA INDIA SERVICES PRIVATE LIMITED |
      And User is able to select Org type from Org type dropdown
        | Org type |
        | PB       |
      And User is able to add the LEI Org type combination
      And user will submit the changes
      When A "NonAdminOsttraPB" user logs into the application in an incognito window
      And The secondary user navigates to the document listing screen
      Then User is on Approval group screen
      Then verify the user can view records for all organizations in the table
        | Legal Entity Name                     |
        | OSTTRA INDIA SERVICES PRIVATE LIMITED |
        | CITIGROUP INC.                        |
        | BARCLAYS PLC                          |
      Then User is on approval matrix listing screen
      Then verify the user can view records for all organizations in the table
        | Legal Entity Name                     |
        | OSTTRA INDIA SERVICES PRIVATE LIMITED |
        | CITIGROUP INC.                        |
        | BARCLAYS PLC                          |
      And Close the secondary browser

      @TC-6385
      Scenario: Verify the user view currency and currency-pair records for all organizations
        Given User is on the all document screen
        And   User clicks on User management
        Then User reaches the User Management screen
        When User will search for the User
          | User                         |
          | automation.user3@yopmail.com |
        Then User clicks on update button
        Then User is able to see role mapping dropdown
        And User is able to remove all the role
        And User is able to assign a role
          | role mapping    |
          | OSTTRA View All |
        And user will submit the changes
        When A "NonAdminOsttraPB" user logs into the application in an incognito window
        Then User is on the Currency screen
        Then Verify the user can view currency records for all organizations
          | Organisation Name                     |
          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
          | CITIGROUP INC.                        |
          | BARCLAYS PLC                          |
        And User can reach to Currency Pair group screen
        Then Verify the user can view currency records for all organizations
          | Organisation Name                     |
          | OSTTRA INDIA SERVICES PRIVATE LIMITED |
          | CITIGROUP INC.                        |
          | BARCLAYS PLC                          |
        And Close the secondary browser

        @TC-6386
        Scenario: Verify the user view Document Template records for all organizations
          Given User is on the all document screen
          And   User clicks on User management
          Then User reaches the User Management screen
          When User will search for the User
            | User                         |
            | automation.user3@yopmail.com |
          Then User clicks on update button
          Then User is able to see role mapping dropdown
          And User is able to remove all the role
          And User is able to assign a role
            | role mapping    |
            | OSTTRA View All |
          And user will submit the changes
          When A "NonAdminOsttraPB" user logs into the application in an incognito window
          Given User will go to Document template screen
          Then Verify the user can view document template for all organizations
          And Close the secondary browser

          @TC-6387
          Scenario Outline: Verify User is able to download Document for All Org
            Given User is on the all document screen
            And   User clicks on User management
            Then User reaches the User Management screen
            When User will search for the User
              |User|
              |automation.user3@yopmail.com|
            Then User clicks on update button
            Then User is able to see role mapping dropdown
            And User is able to remove all the role
            And User is able to assign a role
              | role mapping   |
              | <Role Mapping> |
            And User is able to select Doc type from Doc type dropdown
              | Doc Type   |
              | <Doc Type> |
            And User is able to select LEI from LEIs dropdown
              | LEI                                   |
              | OSTTRA INDIA SERVICES PRIVATE LIMITED |
            And User is able to select Org type from Org type dropdown
              | Org type |
              | PB       |
            And User is able to add the LEI Org type combination
            And user will submit the changes
            When A "NonAdminOsttraPB" user logs into the application in an incognito window
            Then User is on Document Page
            And user will select Column Values on Document listing screen
              | Column Name     | value    |
              | Document Status | Enforced |
            Then Verify the user can view and download documents for all organizations
              | Legal Entity Name                     |
              | OSTTRA INDIA SERVICES PRIVATE LIMITED |
              | CITIGROUP INC.                        |
              | BARCLAYS PLC                          |
            And Close the secondary browser
            Examples:
              | Role Mapping     | Doc Type |
              | 4W Org View Only | 4 Way    |
              | DN Org View Only | DN       |

  @TC-6388
            Scenario: Verify User is able to download Document for All Org
              Given User is on the all document screen
              And   User clicks on User management
              Then User reaches the User Management screen
              When User will search for the User
                |User|
                |automation.user3@yopmail.com|
              Then User clicks on update button
              Then User is able to see role mapping dropdown
              And User is able to remove all the role
              And User is able to assign a role
                | role mapping     |
                | OSTTRA View Only |
              And user will submit the changes
              When A "NonAdminOsttraPB" user logs into the application in an incognito window
              Then User is on Document Page

