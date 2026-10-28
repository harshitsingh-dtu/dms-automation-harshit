@smoke @document
@jkl
Feature: Bulk Request Batch View workflow Validations
  Scenario: Validating Bulk Request Batch elements
    Given User is able to reach the Bulk Request Batch screen
    Then user is able to search using Batch id
      |batch id|
      |BATCH-440481-O|
    * user can set filter by selecting document initiator
      | document initiator |
      |CITIGROUP INC.|
    * user can set filter by selecting document action
      |document action|
      |REMOVE CURRENCY|
    * all the columns related to batch information is visible on screen

  Scenario:Batch status is visible corresponding to the batch id searched
    Given User is able to reach the Bulk Request Batch screen
    When user will search the batch id and set the filters
      |batch id|document initiator|document action|
      |BATCH-133629-Z|CITIGROUP INC|Bulk Approve|
    Then user can see the batch status


  Scenario: Verify Batch status change to completed from submitted
    Given User is able to reach the Bulk Request Batch screen
    Then user is able to search using Batch id
      |batch id|
      |BATCH-361751-D|
    And Batch status is submitted
    Then Batch status is updated to completed after scheduler runs

  Scenario: Verify in-process column when submitted--> completed
    Given User is able to reach the Bulk Request Batch screen
    And user should be able to see batch requests under in process
    Then Batch status is updated to completed after scheduler runs
    And in process should be zero

  Scenario: Verify Batch view listing have pagination of entries not more than 10
    Given User is able to reach the Bulk Request Batch screen
    Then No of entries on batch view screen will not exceed more than 10