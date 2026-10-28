@Regression @US=DMGS-3162 @US=DMGS-2818
@singleedit

Feature: Validating workflow for Single Edit Documents

  @TC=1726 @TC=1598 @TC=2140 @TC=1749 @TC=1712
  Scenario: Verify if edit action is enabled for documents
    Given User is on the all document screen
    And User clicks on Column Selection button
    And User will search for column, selects it if not already selected and validates the same on Document listing screen
      | Column Name    |
      | PB-1 Legal Entity Name  |
      | Client-1 Legal Entity Name   |
      | EB-1 Legal Entity Name     |
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |EB-1 Legal Entity Name        |CITIGROUP INC.       |
      |Client-1 Legal Entity Name    |CITIGROUP INC.       |
      |Document Status               |Draft                            |
    Then User clicks on edit icon
    Then User validates the document version ID on Edit screen
      |Document Version ID|
      | DN-|
    Then User validates document type on Edit screen
      |Document Type|
      | DN|
    Then User validates allowed currency on edit screen
      |Allowed Currencies|
      |BULLION, FX|
    Then User validates the PB,EB and Client on edit screen
      |PB                                    |EB            |Client        |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |CITIGROUP INC.|CITIGROUP INC.|
    Then User validates the tabs on edit screen
#    Then User performs approval workflow for the Single edit document and submit
    Then User clicks on Next button
    Then User validates the enforcement screen
    Then User clicks on Next button
    Then User validates Document terms screen
    Then User clicks on Limit Scope
    #And User will be able to See all the Information like all dropdowns and buttons
    And User validates the Limit Scope table headers in the new UI

  Scenario:User creates a draft document for below testcases.
    Given User resets DN document
      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
      | pbLeiId     | 254900SLCV8KI86BHL86                 |
      | ebLeiId     | 7JIRH9K3XRCRM50HTR80                 |
      | clientLeiId | 549300ZLVED0VPNQPO73                 |
    When User creates a document through API
      |Payload path|
      |src/test/java/resources/DocCreation_MR4.json|

  @TC=6897 @TC=6898 @TC=6771 @TC=6940
  Scenario: Verify the enforcement screen functionality for a draft DN
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                                 |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED |
      |EB-1 Legal Entity Name        |Enbridge Pipelines (Ozark) L.L.C.                        |
      |Client-1 Legal Entity Name    |3G Fund, L.P.                         |
      |Document Status               |Draft                                 |
    Then User clicks on edit icon
    Then User clicks on Next button
    Then User validates the enforcement screen
    And User validates the enforcement screen is read only
    Then User clicks on Preview & Submit tab
    Then User clicks on Enforcement rule Tab in Preview tab
    And User validates the enforcement data on preview tab
      |For new document enforcement|For amendment|For termination|
      |Immediate                   |Scheduled     |Immediate      |

  @TC=6925 @TC=6926 @TC=6927 @TC=6928 @TC=6929 @TC=6936 @TC=6860
  Scenario: Validate visibility of window period for Auth line
    Given User is on the all document screen
    And user will select Column Values on Document listing screen
      |Column Name                   |value                |
      |PB-1 Legal Entity Name        |OSTTRA INDIA SERVICES PRIVATE LIMITED                |
      |EB-1 Legal Entity Name        |Enbridge Pipelines (Ozark) L.L.C.        |
      |Client-1 Legal Entity Name    |3G Fund, L.P.        |
      |Document Status               |Draft                |
    Then User clicks on edit icon
    And User clicks on Auth Scope Tab
    And Validate following field is not displayed
      |Field    |
      |Auth Tenor    |
      |Auth Currencies |
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Exotic Options | Double Barrier |
    And User clicks on Add Auth Line
    Then User Add Asset Class, Product Family, Product to the Auth Scope
      | Asset Class | Product Family | Product |
      | FX          | Cash           | Spot |
    And User clicks on Add Auth Line
#    Then User Validates Other lines should be greyed out
#      | Asset Class | Product Family | Product |
#      | FX          | Cash           | Spot    |
    Then User validate Add Auth Line is disabled
    Then User enables all Auth Lines
    #And Clicks on ExpandAll button
    Then User validates Window period tab should be visible
      |Window|
      |None   |
      |Yes    |
      |No     |
      |Both   |