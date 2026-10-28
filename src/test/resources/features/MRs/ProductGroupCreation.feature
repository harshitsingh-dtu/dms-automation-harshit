@document_type=DN @Global_MRs
@ProductGroup

Feature: Creating Product group for DMGS-7478

  Scenario:User creates first product group with data - for DMGS-7478
    Given User is on the Dashboard page and navigate to Product Group
    When User clicks on Create Product Group
    And User enters the Product group name
      | Product Group Name         |
      | Test_Automation_7478_1     |
    And Select the Organisation Name
      | Organisation Name     |
      | All Organisations     |
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family |
      | Vanilla        |
    And Select product in Auth Product
      | Product           |
      | Vanilla Option    |
    Then Click on Add Product Line
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Exotic Options      |
    And Select product in Auth Product
      | Product                    |
      | Single Barrier Digital    |
    Then Click on Add Product Line
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option"
    Then User selects the Settlement type
      |Non Deliverable|
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option"
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital"
    Then User selects the Touch direction for "FX Exotic Options Single Barrier Digital"
      | Touch Direction |
      | Up              |
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital"
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Bullion             |
    And Select product in Auth Product
      | Product                      |
      | Bullion Vanilla Options      |
    Then Click on Add Product Line
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Exotic Options      |
    And Select product in Auth Product
      | Product         |
      | One Touch       |
    Then Click on Add Product Line
    Then User clicks on Expand Icon for "FX Exotic Options One Touch"
    Then User selects the Touch direction for "FX Exotic Options One Touch"
      | Touch Direction |
      | Up              |
    Then User selects the Contract type Input for "FX Exotic Options One Touch"
      | Contract Type |
      | Call          |
    Then User selects Barrier Type for "FX Exotic Options One Touch"
      |Barrier Type|
      |No Barrier  |
      |Knock-Out   |
    And Click on Submit
    And verifies the Product Group created notification pop up
    And verifies the Product Group

  Scenario:User creates second product group with data - for DMGS-7478
    Given User is on the Dashboard page and navigate to Product Group
    When User clicks on Create Product Group
    And User enters the Product group name
      | Product Group Name         |
      | Test_Automation_7478_2     |
    And Select the Organisation Name
      | Organisation Name     |
      | All Organisations     |
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family |
      | Vanilla        |
    And Select product in Auth Product
      | Product           |
      | Vanilla Option    |
    Then Click on Add Product Line
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Exotic Options      |
    And Select product in Auth Product
      | Product                    |
      | Single Barrier Digital    |
    Then Click on Add Product Line
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option"
    Then User selects the Settlement type
      |Deliverable      |
    Then User selects the Contract type Input for "FX Vanilla Options Vanilla Option"
      | Contract Type |
      | Call          |
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option"
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital"
    Then User selects the Contract type Input for "FX Exotic Options Single Barrier Digital"
      | Contract Type |
      | Call          |
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital"
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Cash                |
    And Select product in Auth Product
      | Product     |
      | Future      |
    Then Click on Add Product Line
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Exotic Options      |
    And Select product in Auth Product
      | Product         |
      | One Touch       |
    Then Click on Add Product Line
    Then User clicks on Expand Icon for "FX Exotic Options One Touch"
    Then User selects the Touch direction for "FX Exotic Options One Touch"
      | Touch Direction |
      | Down            |
    Then User selects the Contract type Input for "FX Exotic Options One Touch"
      | Contract Type |
      | Call          |
    Then User selects Barrier Type for "FX Exotic Options One Touch"
      |Barrier Type       |
      |Reverse-Knock-Out  |
    And Click on Submit
    And verifies the Product Group created notification pop up
    And verifies the Product Group

  Scenario:User creates second product group with data - for DMGS-6758
    Given User is on the Dashboard page and navigate to Product Group
    When User clicks on Create Product Group
    And User enters the Product group name
      | Product Group Name       |
      | Test_Automation_4Way     |
    And Select the Organisation Name
      | Organisation Name     |
      | All Organisations     |
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family |
      | Vanilla Options       |
    And Select product in Auth Product
      | Product           |
      | Vanilla Option    |
    Then Click on Add Product Line
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Exotic Options      |
    And Select product in Auth Product
      | Product                    |
      | Single Barrier Digital     |
    Then Click on Add Product Line
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option"
    Then User selects the Settlement type
      |Deliverable      |
    Then User selects the Contract type Input for "FX Vanilla Options Vanilla Option"
      | Contract Type |
      | Call          |
      | Put           |
    Then User clicks on Expand Icon for "FX Vanilla Options Vanilla Option"
    Then User waits for 2 seconds
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital"
    Then User waits for 2 seconds
    Then User selects the Contract type Input for "FX Exotic Options Single Barrier Digital"
      | Contract Type |
      | Call          |
      | Put           |
    Then User clicks on Expand Icon for "FX Exotic Options Single Barrier Digital"
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Cash                |
    And Select product in Auth Product
      | Product     |
      | Future      |
    Then Click on Add Product Line
    Then Select asset class in Auth Products
      | Asset Class |
      | FX          |
    Then Select product family in Auth Products
      | Product Family      |
      | Exotic Options      |
    And Select product in Auth Product
      | Product         |
      | One Touch       |
    Then Click on Add Product Line
    Then User clicks on Expand Icon for "FX Exotic Options One Touch"
    Then User selects the Touch direction for "FX Exotic Options One Touch"
      | Touch Direction |
      | UP              |
      | Down            |
    Then User selects the Contract type Input for "FX Exotic Options One Touch"
      | Contract Type |
      | Call          |
      | Put           |
    Then User selects Barrier Type for "FX Exotic Options One Touch"
      |Barrier Type       |
      |No Barrier         |
      |Knock-Out          |
      |Reverse-Knock-Out  |
    And Click on Submit
    And verifies the Product Group created notification pop up
    And verifies the Product Group
