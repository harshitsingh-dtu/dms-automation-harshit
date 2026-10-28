@Regression @ApprovalAgreement
@US=DMGS-3215 @US=DMGS-3217 @US=DMGS-3218 @US=DMGS-4955 @US=DMGS-5665

Feature: Validating Approval Agreements Screens and Functionality

@TC=7201 @TC-7205
  Scenario: Validate the approval agreement Screen Elements
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    And User validates the columns on Approval Agreement Screen

  @TC=7200 @TC=7208 @TC=7212 @TC=7213 @TC=7214 @TC=7217 @TC=7218 @TC=7219 @TC=7220 @TC=7221 @TC=7224 @TC=7225
  Scenario: Validate that  PB user can select the prime broker online organization for the relationship from the drop-down
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User clicks on Create New Approval agreement
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs in Approval Agreement
      | Prime Broker   |  OSTTRA INDIA SERVICES PRIVATE LIMITED     |
    Then User validates Traiana Approval language terms
    Then User validates Osttra Approval language terms
    Then User selects the Agreement Signed Externally checkbox
    Then User selects Electronic Signature checkbox
    Then User select acting as
      | Acting As |
      | EB        |
    And User select the LEIs in Approval Agreement
      | Executing Broker   |  OSTTRA INDIA SERVICES PRIVATE LIMITED   |
    Then User validates Traiana Approval language terms
    Then User validates Osttra Approval language terms
    Then User selects the Agreement Signed Externally checkbox
    Then User selects Electronic Signature checkbox

  @TC=7205 @TC-7215 @TC-7222 @TC-7226 @7229
  Scenario: Validate the approval agreement Creation as PB
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User clicks on Create New Approval agreement
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs in Approval Agreement
      | Prime Broker      |  OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Executing Broker  |  CITIGROUP INC.                        |
    Then User selects the Agreement Signed Externally checkbox
    Then User selects PB Approvers Required
      |1|
    Then User selects EB Approvers Required
      |1|
    Then User enters PB Approvers Details
      |Field Name |Values |
      |firstName  |Surbhi |
      |lastName   | Singh |
      |role       |  QA   |
      |email      |surbhi.singh2@osttra.com|
      |phoneNumber    | 1233459999|
    Then User enters EB Approvers Details
      |Field Name |Values |
      |firstName  |Pawan |
      |lastName   |Kumar |
      |role       |  QA   |
      |email      |pawan.kumar9@osttra.com|
    Then Clicks on Submit Button
    And User validates Approval Agreement Created successfully notification

  @TC=7209 @7233
  Scenario: Validate the approval agreement Creation as EB
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User clicks on Create New Approval agreement
    Then User select acting as
      | Acting As |
      | EB        |
    And User select the LEIs in Approval Agreement
      | Prime Broker      |  CITIGROUP INC.      |
      | Executing Broker  |  OSTTRA INDIA SERVICES PRIVATE LIMITED   |
    Then User selects the Agreement Signed Externally checkbox
    Then User selects PB Approvers Required
      |1|
    Then User selects EB Approvers Required
      |1|
    Then User enters PB Approvers Details
      |Field Name |Values |
      |firstName  |Pawan |
      |lastName   |Kumar |
      |role       |  QA   |
      |email      |pawan.kumar9@osttra.com|
      |phoneNumber    | 1233459789|
    Then User enters EB Approvers Details
      |Field Name |Values |
      |firstName  |Surbhi |
      |lastName   |Singh |
      |role       |  QA   |
      |email      |surbhi.singh2@osttra.com|
      |phoneNumber    | 1233459999|
    Then Clicks on Submit Button
    And User validates Approval Agreement Created successfully notification

#   Check for approve/Disapprove button
  @TC=7202 @TC=7204 @TC=7203 @TC=7206 @TC=7207 @TC=7216 @TC-7230 @Bug=DMGS-9552
  Scenario: Validate the filters,edit & disabled approval agreement as PB
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value       |
      |Agreement Id               |AG-         |
      |PB Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Legal Entity Name       |CITIGROUP INC. |
      | Status                    |Active         |
    Then User validates the data filtered
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |CITIGROUP INC.                        |
      |Active                                |
    And user clicks on Document Edit icon
    Then User enters EB Approvers Details
        |Field Name     |Values     |
        |phoneNumber    | 1233458888|
#    Then User disapproves the usage terms
    Then Clicks on Submit Button
    And User validates Approval Agreement updated notification
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value       |
      |Agreement Id               |AG-         |
      |PB Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Legal Entity Name       |CITIGROUP INC. |
      | Status                    |Active         |
    Then User clicks on disable button
    Then Click on Yes button
    And User validates Agreement Disabled successfully notification

#   Check for approve/Disapprove button
  @TC=7210 @TC=7211 @TC=7223 @7234 @Bug=DMGS-9552
  Scenario: Validate the filters,edit & disabled approval agreement as EB
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value       |
      |Agreement Id               |AG-         |
      |PB Legal Entity Name       |CITIGROUP INC.    |
      |EB Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And user clicks on Document Edit icon
    Then User enters EB Approvers Details
      |Field Name     | Values    |
      |phoneNumber    | 1233458888|
#    Then User disapproves the usage terms
    Then Clicks on Submit Button
    And User validates Approval Agreement updated notification
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value       |
      |Agreement Id               |AG-         |
      |PB Legal Entity Name       |CITIGROUP INC.    |
      |EB Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    Then User clicks on disable button
    Then Click on Yes button
    And User validates Agreement Disabled successfully notification

  @TC=7227 @TC-7228 @TC-7231 @TC-7232
  Scenario: Validate that prime broker can configure the number of PB and EB approvers up to a maximum of 3 independently
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User clicks on Create New Approval agreement
    Then User select acting as
      | Acting As |
      | PB        |
    Then User validates the maximum number of PBs & EBs is 3
    Then User validates the entering more than 3 approvers shows No Option
      |4|
    Then User select acting as
      | Acting As |
      | EB        |
    Then User validates the maximum number of PBs & EBs is 3
    Then User validates the entering more than 3 approvers shows No Option
      |4|

  @US=DMGS-3219 @TC=7235 @TC=7236 @TC=7238 @TC=7239
Scenario: Validate the Audit event for each change
  Given User is on Approval Agreement Screen
  Then Validate User is on Approval Agreement Screen
  Then User applies filter on Approval Agreement Screen
    |Column Name                |value                                 |
    |Agreement Id               |AG-                                   |
    |PB Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
    |EB Legal Entity Name       |CITIGROUP INC.                        |
  And User clicks on Audit button
Then User validates the Audit event and User
  |Audit Event           |User                            |
  |Create Approval       |hsbc.test1@testsso.osttra.com   |
  |Update Approval       |hsbc.test1@testsso.osttra.com   |
  |Terminate Approval    |hsbc.test1@testsso.osttra.com   |
  Then User validated the date has been logged in Event Changes

  @US=4599  @TC-7753 @TC-7754 @TC-7755 @7756 @TC-7757
  Scenario: Validate PB and  EB approver details are not mandatory fields by entering null values
    Given User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User clicks on Create New Approval agreement
    Then User select acting as
      | Acting As |
      | PB        |
    And User select the LEIs in Approval Agreement
      | Prime Broker      |  OSTTRA INDIA SERVICES PRIVATE LIMITED |
      | Executing Broker  |  CITIGROUP INC.                        |
    Then User selects the Agreement Signed Externally checkbox
    Then User selects PB Approvers Required
      |1|
    Then User selects EB Approvers Required
      |1|
    Then Clicks on Submit Button
    And User validates Approval Agreement Created successfully notification
    Then User waits for 5 seconds
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value                                 |
      |PB Legal Entity Name       |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB Legal Entity Name       |CITIGROUP INC.                        |
    And user clicks on Document Edit icon
    Then Clicks on Submit Button
    And User validates Approval Agreement updated notification
    Then User clicks on disable button
    Then Click on Yes button
    And User validates Agreement Disabled successfully notification

  @US=5665  @TC_01 @TC_02 @TC_03
  Scenario: Validate users can only see user emails in the ‘Last Updated By’ filter values from the Approval Agreements report for users belonging to their organisation whether it’s a PB or EB
    Given A "CitigroupPB" user logs into the application in an incognito window
    Then User is on Approval Agreement Screen
    Then Validate User is on Approval Agreement Screen
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value                                  |
      |Last Updated By            |hsbc.test1@testsso.osttra.com          |
    And Validate No options should Not be displayed
    Then User applies filter on Approval Agreement Screen
      |Column Name                |value                                  |
      |Last Updated By            |automation.nonosttra01@yopmail.com     |
    And Validate No options should Not be displayed
    Then User validates the below drop down values should NOT be displayed
      |Column Name                |value                                  |
      |Last Updated By            |nonadminautomationuser2@yopmail.com    |
    And Close the secondary browser