@Organisation @OrgManagementValidationWorkflow
@Regression @US=4338 @US=4347 @US=DMGS-4570 @US=DMGS-3548 @US=DMGS-5350 @US=DMGS-4338

Feature: Workflow of Organization Management Validation

  @TC-1353 @TC-7558 @Sanity
  Scenario: Verify the search functionality, where search by LEI ID
    Given User navigates to the organisation screen
    Then User searches the Organisation
      | search_orgname |
      | 3g FUNd, L.P.  |


  @TC-1355 @TC-1356  @TC-7573 @TC-7810 @TC-7811
  Scenario: Validation of elements present on the organization screen
    Given User navigates to the organisation screen
    When User will be able to see predictive search bar and type for searching LEI id's
      | search lei                            |
      | OSTTRA INDIA SERVICES PRIVATE LIMITED |
    And User will be able to see table consisting of columns LEI id, LEI name, DN Push Notification and action
    And User will be able to see update button
    Then User will be able to see the pagination

  @TC-1360 @TC-1619 @TC=7581
  Scenario: User is able to see all the elements on the Organization Update screen
    Given User will reach the Organization section
    And User is on the update screen
    When User should be able to see all the details of the Organization
    And User should be able to see predictive search bar
    And User should be able to see LEI org type status table
    And User should be able to see cancel button
    And User should be able to see submit button

  @TC-1621  @TC-1623
  Scenario: Verify Filtered Item List for Doc type filter
    Given User will reach the Organization section
    And User is on the update screen
#    Then Below the Organisation information section Doc type Filter By default Doc type filter will be set as four way
    When Click on Doc type filter on Organisation update screen
    Then Following doc types should be visible to the user Doc type filter on Organisation update screen
      | doc type |
      | DN       |
      | 4 Way    |
    And Select data for Doc type filter and Corresponding result should be visible in the doc type filter
      | doc type |
      | DN       |
      | 4 Way    |

  @TC-1624
  Scenario: Validate case sensitivity for Doc type filter
    Given User will reach the Organization section
    And User is on the update screen
    Then Select data for Doc type filter and Corresponding result should be visible in the doc type filter
      | doc type |
      | 4 way    |
      | 4 wAY    |
      | DN       |
      | dn       |
      | Dn       |
      | 4 wa     |
      | d        |
      | D        |

  @TC-1633 @TC-1632
  Scenario: validate LEI Org type status table data - when doc type 4 way
    Given User will reach the Organization section
    And User is on the update screen
    When User should be able to see all the details of the Organization
    Then for doc type Four Way Org type status column should be contain three further columns Which each will have tabs Online Neutral and Lite

  @TC-1634
  Scenario: validate LEI Org type status table data - when doc type DN
    Given User will reach the Organization section
    And User is on the update screen
    And Set DN doc type in update organization
    When User should be able to see all the details of the Organization
    Then for doc type DN Org type status column should be contain three further columns Which each will have tabs Online Neutral and Lite

  @TC1631
  Scenario: validate search functionality for diff doc types DN
    Given User will reach the Organization section
    Then User searches the Organisation
      | search_orgname |
      | GLOBAL YIELD    |
    And User is on the update screen
    And Set Doc type filter on Organisation update screen
      | doc type |
      | DN       |
    And Search for LEI ID or name that belongs to doc type searched
    Then User waits for 2 seconds
    And Search for LEI ID or name that does NOT belong to doc type searched
      | random LEI id |
      | dummy data    |

  @TC1653
  Scenario: Verify the side window elements
    Given User will reach the Organization section
    When User searches the Organisation
      | search_orgname |
      | GLOBAL YIELD    |
    And User is on the update screen
    And Set Doc type filter on Organisation update screen
      | doc type |
      | DN       |
    Then Search for random LEI on organisation update screen
    And Click on LEI name on organisation update screen
    Then Validate side window elements on organisation update screen

  @TC=7392 @TC=7394
  Scenario: Verify that address has been removed from organisation information/listing screen for Osttra  user
    Given User will reach the Organization section
    And Validate following field is not displayed
      | Field   |
      | Address |
    Then User searches the Organisation
      | search_orgname |
      | GLOBAL YIELD    |
    And User is on the update screen
    And Validate following field is not displayed
      | Field   |
      | Address |

  @TC1652 @TC=7578    @TC-1639  @TC-1639 @TC1635 @TC=7582 @TC-7557   @TC1642 @TC=7580 @TC-1640 @TC-2707
  Scenario Outline: Verify User is able to change org type status to Lite for Bulk
    Given User will reach the Organization section
    When User searches the Organisation
      | search_orgname |
      | GLOBAL YIELD    |
    And User is on the update screen
    And Set <Documenttype> doc type in update organization
    Then Click on Org type Status for Bulk Update to <ChangeStatus>
      | org type |
      | <org>    |

    Examples:
      | Scenario                                                 | org    | Documenttype | ChangeStatus |
      | Validate Bulk Update Online to Lite for PB for DN        | PB     | DN           | Lite         |
      | Validate Bulk Update Online to Lite for EB for DN        | EB     | DN           | Lite         |
      | Validate Bulk Update Online to Lite for Client for DN    | Client | DN           | Lite         |
      | Validate Bulk Update Lite to Online for PB for DN        | PB     | DN           | Online       |
      | Validate Bulk Update Lite to Online for EB for DN        | EB     | DN           | Online       |
      | Validate Bulk Update Lite to Online for Client for DN    | Client | DN           | Online       |
      | Validate Bulk Update Online to Lite for PB for 4-Way     | PB     | 4 Way        | Lite         |
      | Validate Bulk Update Online to Lite for Client for 4-Way | Client | 4 Way        | Lite         |
      | Validate Bulk Update Lite to Online for PB for 4-Way     | PB     | 4 Way        | Online       |
      | Validate Bulk Update Lite to Online for Client for DN    | Client | 4 Way        | Online       |

  @TC1652 @TC=7578  @TC1653
  Scenario Outline: Verify User is able to change org type status to Lite for an individual LEI for DN doc type
    Given User will reach the Organization section
    When User searches the Organisation
      | search_orgname |
      | GLOBAL YIELD    |
    And User is on the update screen
    And Set <Documenttype> doc type in update organization
    And Search for random LEI on organisation update screen
    And Change the Status for an Org to <ChangeStatus>
      | org type |
      | <org>    |

    Examples:
      | Scenario                                     | org    | Documenttype | ChangeStatus |
      | Validate Online to Lite for PB for DN        | PB     | DN           | Lite         |
      | Validate Online to Lite for EB for DN        | EB     | DN           | Lite         |
      | Validate Online to Lite for Client for DN    | Client | DN           | Lite         |
      | Validate Lite to Online for PB for DN        | PB     | DN           | Online       |
      | Validate Lite to Online for EB for DN        | EB     | DN           | Online       |
      | Validate Lite to Online for Client for DN    | Client | DN           | Online       |
      | Validate Online to Lite for PB for 4-Way     | PB     | 4 Way        | Lite         |
      | Validate Online to Lite for Client for 4-Way | Client | 4 Way        | Lite         |
      | Validate Lite to Online for PB for 4-Way     | PB     | 4 Way        | Online       |
      | Validate Lite to Online for Client for DN    | Client | 4 Way        | Online       |

