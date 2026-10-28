@Regression @US=DMGS-3163 @US=DMGS-8156
@documenttemplate @DocumentTemplateCreateWorkflow


Feature: Document template create new template workflows

  @TC-1760 @TC-1761 @1762 @1763 @TC-6814 @TC-6807 @Sanity @TC-6761 @TC-196 @TC-197 @TC-198
  Scenario: validate create new template functionality for Doc type 4 way
    Given User will go to Document template screen
    And User will click on create new template button and get redirected to create new document template screen
    Then user will enter template name organisation name and Doctype
      |Template Name     |Organisation Name                         |Doc Type |
      |Autotest_4Way     |OSTTRA INDIA SERVICES PRIVATE LIMITED     |4 Way     |
    And user will click on next button and redirected Update screen of Template screen
    And user will able to see Document Template information and Approval Workflow tab Enforcement Rules tab Legal Terms tab Discard  button Save as Draft button Next button
    And user is able to see approval workflow tab and their respective information
    And User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |New Document              |1                |
      |Initiator         |Edit Approval Workflow    |1                |
    Then User clicks on Next button
    And User validates the enforcement screen
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |value |Duration |
      |Immediate          |Schedule           |1     |hour  |
    Then User clicks on Next button
    Then User validates Document terms screen
    And user will be able to see no.of connected user and CK editor
    And User will click on the CK editor and type text into document content
      | Content           |
      | Test for Document Terms     |
    And User will click on Submit button and redirect to Document template listing screen

#Will Fail after DMGS-8350 is Fixed
#Failing due to DMGS-8680
@US=DMGS-8156 @TC_01 @TC_02 @TC_03 @ignore
Scenario: User click on Audit button for Doc type 4 way
  Given User will go to Document template screen
  And User will search for the document template
    | Document Name    |
    | Autotest_4Way    |
  Then User sorts in "Created on" in descending order
  Then User clicks on Audit button for Approval Group
  And User Validates Document Template history Screen
  And User Validates the data on Document Template history Screen
    |Template Audit ID| Template Name | Template Org                          |Audit Event              | Date     | Updated By                   | Event Changes           |
    |4                | Autotest_4Way | OSTTRA INDIA SERVICES PRIVATE LIMITED |Update Document Template | Current  |hsbc.test1@testsso.osttra.com | Test for Document Terms |

  @TC-6809, @TC-6810 @TC-6813 @TC-6805  @TC-6803 @TC-6764
  Scenario: validate approval workflow & enforcement rule not present for Doc type DN while creation
    Given User will go to Document template screen
    And User will click on create new template button and get redirected to create new document template screen
    Then user will enter template name organisation name and Doctype
      |Template Name|Organisation Name|Doc Type |
      |Autotest_DN     |OSTTRA INDIA SERVICES PRIVATE LIMITED            |DN     |
    And user will click on next button and redirected Update screen of Template screen
    And User will able to see Document Template information and not able to see Approval Workflow tab Enforcement Rules tab
    Then User validates Document terms screen
    And user will be able to see no.of connected user and CK editor
    And User will click on the CK editor and type text into document content
      | Content           |
      | Test for Document Terms     |
    And User will click on Submit button and redirect to Document template listing screen

  #Will Fail after DMGS-8350 is Fixed
  #Failing due to DMGS-8680
  @US=DMGS-8156 @TC_01 @TC_02 @TC_03 @ignore
  Scenario: User click on Audit button for Doc type DN
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name    |
      | Autotest_DN      |
    Then User sorts in "Created on" in descending order
    Then User clicks on Audit button for Approval Group
    And User Validates Document Template history Screen
    And User Validates the data on Document Template history Screen
      |Template Audit ID| Template Name  | Template Org                          | Audit Event              | Date     | Updated By                    | Event Changes |
      |2                | Autotest_DN    | OSTTRA INDIA SERVICES PRIVATE LIMITED | Update Document Template | Current  |hsbc.test1@testsso.osttra.com  | Test for Document Terms |

  @TC-6806  @TC-6808
  Scenario: Validate document template while document creation for 4W and DN
    Given User is on Document Page
    And  User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the document template for 4 Way & check all tabs in preview
      |Autotest_4Way|
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN        | PB        |
    And User select the document template for DN Way & check all tabs in preview
      |Autotest_DN|

  @TC-1668
  Scenario:Validate case sensitivity for Doc type dropdown
    Given User will go to Document template screen
    And User will click on create new template button and get redirected to create new document template screen
    Then user will enter template name organisation Name
      |Template Name|Organisation Name|
      |Autotest_DN     |OSTTRA INDIA SERVICES PRIVATE LIMITED            |
    And user will be able to see doctype for different case sensitive doctypename
      |Doc Type |
      |4     |
      |4 W   |
      |d     |
      |D     |
      |Dn    |
      |4 wAy |
      |43rsf |

  @TC-1667
  Scenario:Validate Filtered item list for Doc type dropdown
    Given User will go to Document template screen
    And User will click on create new template button and get redirected to create new document template screen
    Then user will enter template name organisation Name
      |Template Name|Organisation Name|
      |Autotest     |OSTTRA INDIA SERVICES PRIVATE LIMITED            |
    And user will be able to see the filtered list for doctype
      |Doc Type |
      |4 Way   |
      |DN      |
    And User clicks on Cancel button

  @US=DMGS-8156 @TC_08
  Scenario:Validate that No edit/deletion is possible for the Audit entries
    Given User will go to Document template screen
    Then User clicks on Audit button for Approval Group
    And User Validates Document Template history Screen
    Then User verifies no Edit or delete icon is present
