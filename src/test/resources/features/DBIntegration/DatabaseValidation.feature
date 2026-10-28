@Database @Regression
Feature: Database Query Validation

  @DB-001
  Scenario: Dynamic fetch and store document details for API use
    Given User fetches data from "odc_doc.document" with the following filters:
      | document_type_id | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
      | modified_by       | 27cb5a2a-55cd-4d70-ad77-bc6d41b19751 |
