@Global_OTs @document_type=4-way
Feature: Validate one time data exists or not

 Scenario: User creates an approval group exist or not for 4 Way
    Given Check required approval group exist or not
      | group name                              | organisation name | doc type  | LEI's    | org type | user |
      |Automation_OT_ApprovalGroup_4way_Osttra  | OSTTRA INDIA SERVICES PRIVATE LIMITED            | 4 Way     | OSTTRA INDIA SERVICES PRIVATE LIMITED   | PB       |hsbc.test1@testsso.osttra.com|

  Scenario: User creates an approval group exist or not for DN -PB
    Given Check required approval group exist or not
      | group name                           | organisation name   | doc type | LEI's          | org type | user |
      |Automation_OT_ApprovalGroup_DN_Osttra | OSTTRA INDIA SERVICES PRIVATE LIMITED              | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED  | PB       |hsbc.test1@testsso.osttra.com|

  Scenario: User creates an approval group exist or not for DN -PB(Barclay org)
    Given Check required approval group exist or not
      | group name                           | organisation name   | doc type | LEI's          | org type | user |
      | Automation_Approval_Barclays         | BARCLAYS PLC | DN       | BARCLAYS PLC  | PB       |nonadminautomationuser1@yopmail.com |

  Scenario: User creates an approval group exist or not for DN - EB
    Given Check required approval group exist or not
      | group name       | organisation name                      | doc type | LEI's          | org type | user |
      |Automation_MR_EB  | OSTTRA INDIA SERVICES PRIVATE LIMITED  | DN       | OSTTRA INDIA SERVICES PRIVATE LIMITED  | EB       |hsbc.test1@testsso.osttra.com|

  Scenario: User creates an approval matrix & check if already exist for DN - PB
    Given Check required approval matrix exist or not
      |Select LEI    |doc type filter| org type filter |organisation name|LEI filter| Document Action    | approval groups |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED        |     DN	       |PB	           |OSTTRA INDIA SERVICES PRIVATE LIMITED            |OSTTRA INDIA SERVICES PRIVATE LIMITED | New Document       | Automation_OT_ApprovalGroup_DN_Osttra|

  Scenario: User creates an approval matrix & check if already exist for DN - PB(Barclays)
    Given Check required approval matrix exist or not
      |Select LEI    |doc type filter| org type filter |organisation name|LEI filter| Document Action    | approval groups |
      |BARCLAYS PLC        |     DN	       |PB	           |BARCLAYS PLC            |BARCLAYS PLC | New Document       | Automation_Approval_Barclays |

  Scenario: User creates an approval matrix & check if already exist for DN- EB
    Given Check required approval matrix exist or not
      |Select LEI    |doc type filter| org type filter |organisation name|LEI filter| Document Action    |approval groups |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED        |     DN	       |EB	           |OSTTRA INDIA SERVICES PRIVATE LIMITED            |OSTTRA INDIA SERVICES PRIVATE LIMITED | New Document       |Automation_MR_EB |

  Scenario: User creates an approval matrix & check if already exist for 4 way
    And Check required approval matrix exist or not
      |Select LEI |doc type filter| org type filter |organisation name|LEI filter| Document Action    | approval groups |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |     4 Way	       |PB	              |OSTTRA INDIA SERVICES PRIVATE LIMITED |OSTTRA INDIA SERVICES PRIVATE LIMITED | New Document       | Automation_OT_ApprovalGroup_4way_Osttra|

  Scenario: User creates an product group & check if already exist
    Given Check required product group exist or not
      | Product group | Product Group Name  | Organisation Name  | Asset Class    | Product Family | Product |
      |Automation_OT_ProductGroup| Automation_OT_ProductGroup  |All  | FX    | Cash   |  Spot    |

  Scenario: User creates an currency group & check if already exist
    Given Check required currency group exist or not
      |Currency group|organisation name|
      |Automation_OT_currencyGroup|OSTTRA INDIA SERVICES PRIVATE LIMITED |

  Scenario: User creates an currency pair group & check if already exist
    Given Check required currency pair group exist or not
      |Currency group|organisation name|
      |Automation_OT_CurrencyPairGroup|OSTTRA INDIA SERVICES PRIVATE LIMITED |

  Scenario: User creates an document template & check if already exist for 4 way
    Given Check required document template exist or not for 4way
      | Template Name  | Organisation | Doc Type | Content  |
      | Automation_OT_DocumentTemplate_4Way| OSTTRA INDIA SERVICES PRIVATE LIMITED       | 4 way    | Test for Document Terms |

  Scenario: User creates an document template & check if already exist for DN
    Given Check required document template exist or not for DN
      | Template Name  | Organisation | Doc Type | Content  |
      | Automation_OT_DocumentTemplate_DN | OSTTRA INDIA SERVICES PRIVATE LIMITED       | DN    | Test for Document Terms |

  Scenario: User creates an USP rider & check if already exist
    Given Check required USP rider exist or not
      |Doc Type|LEI           |Client                 |Contact|
      |4 Way   |CITIGROUP INC.| 1355 STORM PARKWAY LLC|76543210|

  Scenario: User creates a USP rider between PB & client
    Given User is on USP Rider Template screen
    And Clicks on Create New Template button
    Then User should be redirected to create new USP Rider Template screen
    And User will select doc type on Create USP Template screen
    And User will select PB and client dropdown on Create USP Template screen
      |PB Name                               |Client Name   |
      |OSTTRA INDIA SERVICES PRIVATE LIMITED |CITIGROUP INC.|
    And User will enter LEI in search and add fund
      |Lei|
      |Automation_test|
    And User will select all YES options for PB counterparties added
    And Clicks on Submit Button of Create USP Template screen
    And Click on No button of popup
    Then User should be redirected to USP Rider Template listing screen and success message of creation should be visible
