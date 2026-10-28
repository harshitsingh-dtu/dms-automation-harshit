

@productgroup @ProductGroupCreateWorkflow @Fixed
@Regression

Feature: Workflow for Creating New Product Group

  @TC-2697 @TC-2698 @Sanity @TC-6662
  Scenario Outline:User creates a product group with data, delete it and recreates the same
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      | <productGroupName> |
      When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Spot    |
    And Click on Submit and verifies the Product Group notification pop up
  Then User deletes the following Product group and validate the success
      | Product group      |
      | <productGroupName> |
    Then User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family  | Product   |
      | <productGroupName> | All               | FX          | <productFamily> | <product> |
    And Click on Submit and verifies the Product Group notification pop up
    And verifies the Product Group
        Examples:
      | Scenario           | productFamily | product         | productGroupName |
      | Same data set      | Cash          | Spot            | Automation_01    |
      | Different data set | Volatility    | Volatility Swap | Automation_01    |

  @TC-2699 @TC-2700
  Scenario:Validate Notification on Empty product group Creation
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      | Automation_02 |
    When User clicks on Create Product Group
    And User enters the Product group name
      | Product Group Name |
      | Automation_02      |
    And Select the Organisation Name
      | Organisation Name |
      | All               |
    And Click on Submit
    Then User validates the toast message
      |At least one product line is required|
    #And verifies the Authline Mandatory notification pop up

  @TC-2702 @TC-2712 @TC=6255 @TC=6261
  Scenario:Validate only Line Deletion  on Update Action
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      | Automation_03 |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product         |
      | Automation_03      | Osttra            | FX          | Volatility     | Volatility Swap |
    And Click on Submit and verifies the Product Group notification pop up
    And verifies the Product Group
       Then User clicks on search for the product group to update
      | Product group |
      | Automation_03 |
    Then User Click on Update button
    And Clicks on ExpandAll button
    Then User Click on ProductLine delete button
    Then Autline Validation on LastLine Deletion
    Then User clicks on Cancel button


  @TC-2702 @TC-2712 @TC=6255 @TC=6261
  Scenario Outline:Validate Line Deletion on Update Action
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product         |
      | <productGroupName> | Osttra            | FX          | Volatility     | Volatility Swap |
      | <productGroupName> | Osttra            | FX          | Cash           | Future          |
      | <productGroupName> | Osttra            | FX          | Cash           | Spot            |
    And Click on Submit and verifies the Product Group notification pop up
    Then User waits for 3 seconds
    And verifies the Product Group
      Then User clicks on search for the product group to update
      | Product group      |
      | <productGroupName> |
    Then User Click on Update button
    And Clicks on ExpandAll button
    Then User Click on ProductLine delete button
    Then Clicks on Submit Button
    Then User validates the message
      |Product Group updated successfully|

    Examples:
      | productGroupName |
      | Automation_04    |

  @TC-6681
  Scenario Outline: Validate duplicate product line in product group
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Future  |
      | <productGroupName> | All               | FX          | Cash           | Future  |
    Then Clicks on Submit Button
    Then User validates the Document approved message
      | Duplicate Product Line|
    Then User clicks on Cancel button
    Examples:
      | productGroupName |
      | Automation_06    |

  @TC-6681
  Scenario Outline: To Validate duplicate product line in product group Using Copy
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Future  |
    Then Copy the existing line
    Then User click on submit button
    Then User validates the Document approved message
      | Duplicate Product Line|
    Then User clicks on Cancel button
    Examples:
      | productGroupName |
      | Automation_07    |

  @TC-6681
  Scenario Outline: To Validate duplicate product line in product group Using Copy while updating
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      | <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Future  |
    Then User click on submit button
    Then User clicks on search for the product group to update
      | Product group      |
      | <productGroupName> |
    Then User Click on Update button
    And Clicks on ExpandAll button
    Then Copy the existing line
    Then User click on submit button
    Then User validates the Document approved message
      | Duplicate Product Line|
    Then User clicks on Cancel button

    Examples:
      | productGroupName |
      | Automation_08    |

  @TC-6710
  Scenario Outline: To Validate updating a product group
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      | <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | <org_Name>        | FX          | Cash           | Future  |
    Then Clicks on Submit Button
    Then User clicks on search for the product group to update
      | Product group      |
      | <productGroupName> |
    Then User Click on Update button
    Given User Update the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | <org_Name>        | FX          | Cash           | Spot    |
    Then Clicks on Submit Button
    Then User validates the message
      | Product Group updated successfully |

    Examples:
      | productGroupName | org_Name |
      | Automation_09    | Osttra   |

  @TC-2541
  Scenario Outline:User creates a template and validates Expand All button
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Spot    |
      | <productGroupName> | All               | FX          | Cash           | Future  |
    And Clicks on FX Cash ProductExpand button
    And Clicks on ExpandAll button
    And User validates product lines are expanded
      | Product |
      | Spot    |
      | Future  |
    And User validates CollapseAll button
    And Click on Submit and verifies the Product Group notification pop up
    And verifies the Product Group
    Examples:
      | productGroupName |
      | Automation_10    |

  Scenario Outline:Validate Uniqueness in Product Group Name
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | Osttra               | FX          | Cash           | Spot    |
    And Click on Submit and verifies the Product Group notification pop up
    Then User deletes the following Product group if it exists
      | Product group      |
      | <productGroupName> |
    Then User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family  | Product   |
      | <productGroupName> | All               | FX          | <productFamily> | <product> |
    And Click on Submit and verifies the Product Group notification pop up
    And verifies the Product Group

    Examples:
      | Scenario           | productFamily | product         | productGroupName |
      | Same data set      | Cash          | Spot            | Automation_11    |
      | Different data set | Volatility    | Volatility Swap | Automation_11    |

  @TC-2542,@TC-2543
  Scenario Outline:User opens an existing PG and validates Expand/Collapse All button
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Spot    |
      | <productGroupName> | All               | FX          | Cash           | Future  |
    And Click on Submit and verifies the Product Group notification pop up
    When User clicks on search for the product group to update
      | Product group      |
      | <productGroupName> |
    And Clicks on update button
    And Clicks on ExpandAll button
    And User validates product lines are expanded
      | Product |
      | Spot    |
      | Future  |
    And User validates CollapseAll button
    Examples:
      | productGroupName |
      | Automation_12    |

  @TC-2544,@TC-2545
  Scenario Outline:User updates an existing PG and validates Expand/Collapse All button
    Given User is on the Dashboard page and navigate to Product Group
    Then User deletes the following Product group if it exists
      | Product group |
      |  <productGroupName> |
    When User clicks on Create Product Group
    Given User enters the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product |
      | <productGroupName> | All               | FX          | Cash           | Spot    |
      | <productGroupName> | All               | FX          | Cash           | Future  |
    And Click on Submit and verifies the Product Group notification pop up
    When User clicks on search for the product group to update
      | Product group      |
      | <productGroupName> |
    And Clicks on update button
    Given User Update the Product Group details
      | Product Group Name | Organisation Name | Asset Class | Product Family | Product         |
      | <productGroupName> | All               | FX          | Volatility     | Volatility Swap |
    And Clicks on ExpandAll button
    And User validates product lines are expanded
      | Product |
      | Spot    |
      | Future  |
      | Volatility Swap |
    And User validates CollapseAll button
    Examples:
      | productGroupName |
      | Automation_13    |



  @TC-1345
  Scenario:User validates product group listing screen
    Given User is on the Dashboard page and navigate to Product Group
    Then User validated product group listing screen



