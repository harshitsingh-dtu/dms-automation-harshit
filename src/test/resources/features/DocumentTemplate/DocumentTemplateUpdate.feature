@Regression
@documenttemplate @DocumentTemplateUpdate @US=DMGS-8156

Feature: Document template update workflows

  @TC-2714 @fixed
  Scenario:validate document search functionality
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name    |
      | Automation_OT_DocumentTemplate_4Way  |
    And User will reach the document template update screen
    Then User can see all the elements on the screen

  @TC-1352 @TC-6762 @TC-2487
  Scenario: Validate Document template update functionality for 4 way
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name    |
      |Automation_OT_DocumentTemplate_4Way|
    And User will reach the document template update screen
    When User will click on the Approval Workflow tab
    And User will Drag participants and arrange them in approval sequence correspondence to their document action
      |Participants      |Document_Action           |Approval_sequence|
      |Prime Broker - 1  |New Document              |1                |
      |Initiator         |Edit Approval Workflow    |1                |
    Then User clicks on Next button
    Then User will see all the elements of the enforcement rules
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |value |Duration |
      |Immediate          |Schedule           |1     |hour  |
    And User clicks on Next button
    Then User validates Legal Term renamed to Document terms
    And user will be able to see no.of connected user and CK editor
    And User will click on the CK editor and type text into document content
      | Content     |
      | testing     |
    And User will click on Submit button and redirect to Document template listing screen

#Failing due to Bug DMGS-8350
  @US=DMGS-8156 @TC_04 @ignore
  Scenario: User click on Audit button for Doc type 4 way
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name                          |
      | Automation_OT_DocumentTemplate_4Way    |
    Then User sorts in "Created on" in descending order
    Then User clicks on Audit button for Approval Group
    And User Validates Document Template history Screen
    And User Validates the data on Document Template history Screen
      | Template Name                       | Template Org                          |Audit Event              | Date     | Updated By                    | Event Changes   |
      | Automation_OT_DocumentTemplate_4Way | OSTTRA INDIA SERVICES PRIVATE LIMITED |Update Document Template | Current  |hsbc.test1@testsso.osttra.com  | testing         |

  @TC-6765 @TC-6811, @TC-6812 @TC-6804 @TC-2714 @TC-1352 @TC-6765
  Scenario: Validate Document template update functionality for DN
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name                   |
      |Automation_OT_DocumentTemplate_DN|
    And User will reach the document template update screen
    And User will able to see Document Template information and not able to see Approval Workflow tab Enforcement Rules tab
    And user will be able to see no.of connected user and CK editor
    And User will click on the CK editor and type text into document content
      | Content     |
      | testing     |
    And User will click on Submit button and redirect to Document template listing screen

  @US=DMGS-8156 @TC_04
  Scenario: User click on Audit button for Doc type DN
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name                          |
      | Automation_OT_DocumentTemplate_DN      |
    Then User sorts in "Created on" in descending order
    Then User clicks on Audit button for Approval Group
    And User Validates Document Template history Screen
    And User Validates the data on Document Template history Screen
      | Template Name                     | Template Org                          |Audit Event              | Date     | Updated By                    | Event Changes   |
      | Automation_OT_DocumentTemplate_DN | OSTTRA INDIA SERVICES PRIVATE LIMITED |Update Document Template | Current  |hsbc.test1@testsso.osttra.com  | testing         |

  @TC-6758
  Scenario: validate 4 Way Document template is not getting loaded for DN
    Given User is on Document Page
    And User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User will search for the document template at DN Creation page
      | Document Name    |
      |Automation_OT_DocumentTemplate_DN|
    Then Validate No options should be displayed

#   Need to login with another user Roles & permission
#  @TC-6760
#  Scenario: Validate that one organisation's Document Template should not visible for other orgs Document
#    Given User is on Document Page
#    And  User clicks on Create New Document
#    Then User select document type,acting as
#      | Document Type | Acting As |
#      | DN            | PB        |
#    And User will search for the document template at DN Creation page
#      | Document Name    |
#      |Automation_OT_DocumentTemplate_DN|
#    Then Validate No options should be displayed

@TC=6757 @TC=6759
  Scenario: Validate document template while document creation for 4W and DN
    Given User is on Document Page
    And  User clicks on Create New Document
    Then User select document type,acting as
      | Document Type | Acting As |
      | 4 Way         | PB        |
    And User select the document template for 4 Way & check all tabs in preview
      |Automation_OT_DocumentTemplate_4Way |
    Then User validates the data is loaded in preview for 4 way
      |Approval Workflow | Enforcement Rule | Document Terms|
      |Prime Broker - 1  |  1 Hour          |testing           |
    Then User select document type,acting as
      | Document Type | Acting As |
      | DN        | PB        |
    And User select the document template for DN Way & check all tabs in preview
      |Automation_OT_DocumentTemplate_DN|
    Then User validates the data is loaded in preview for DN
      | Document Terms|
      | testing       |

  @ResettingData
  Scenario: Validate Document template Data Reset functionality for 4way
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name                     |
      |Automation_OT_DocumentTemplate_4Way|
    And User will reach the document template update screen
    And User deletes the data from approval workflow
    Then User clicks on Next button
    And User will select Enforcement rule for new document for amendment and for termination
      |For new document   |For amendment      |
      |Immediate          |Immediate          |
    Then User clicks on Next button
    And User will click on the CK editor and type text into document content
      | Content                     |
      | Test for Document Terms     |
    And User will click on Submit button and redirect to Document template listing screen

  @ResettingData
  Scenario: Validate Document template Data Reset functionality for DN
    Given User will go to Document template screen
    And User will search for the document template
      | Document Name                     |
      | Automation_OT_DocumentTemplate_DN |
    And User will reach the document template update screen
    And User will click on the CK editor and type text into document content
      | Content                     |
      | Test for Document Terms     |
    And User will click on Submit button and redirect to Document template listing screen
