---
name: odc-domain
description: ODC (OSTTRA Documentation Centre) / DMS application domain knowledge — business rules, API endpoints, database schemas, user flows, and UI selectors. Use when writing tests, reviewing code, creating scenarios, or answering questions about how ODC works.
user-invocable: false
---

# ODC / DMS Domain Knowledge

## Overview
OSTTRA Documentation Centre (ODC), also referred to as DMS (Document Management System), is an enterprise web-based application for managing financial contract documentation. Users manage legal entities, configure approval workflows and matrices, and create/manage Document Frameworks, Designation Notices (DNs), and 4-Ways Agreements.

## Tech Stack
- **Frontend**: React-based UI with dynamic forms and tab-based navigation
- **Backend**: Java-based microservices architecture (CDS and Notification Services)
- **Database**: PostgreSQL (managed RDS Instance)
- **Testing**: Serenity BDD with Cucumber JVM, JUnit, and Selenium WebDriver
- **API Specs**: CDS and CRDS/Jigsaw REST APIs (OkHttp3 and RestAssured integration)

## Architecture
```
📂 dms-automation/ (Serenity BDD Java framework)
├── 📂 src/test/java/
│   ├── 📂 PageObjects/      # Serenity Page Objects with FindBy locators
│   │   ├── 📂 Login/        # LoginPageObject
│   │   ├── 📂 Documents/    # DocumentPageObject
│   │   ├── 📂 Approval/     # ApprovalgroupPageObject, ApprovalMatrixPageObject
│   │   └── 📂 query.java    # Database helper for PostgreSQL JDBC queries
│   └── 📂 stepDefinations/  # Cucumber Gherkin step definitions
├── 📂 src/test/resources/
│   ├── 📂 features/         # BDD Feature files mapped to ODC user journeys
│   └── serenity.conf        # Environments, PostgreSQL JDBC details, and capabilities
```

## Data Models

### Approval Group
| Field | Type | Notes |
|---|---|---|
| id | Serial (PK) | Auto-increment |
| Group Name | String | Max 255 characters, must be unique within an organisation. |
| Organisation | Dropdown | PB, EB, or Client |
| Doc Type | Dropdown | 4 Way or Designation Notice (DN) |
| Org Type | Dropdown | Prime Broker (PB), Executing Broker (EB), or Client |
| LEIs | Multiselect | List of Legal Entity Identifiers |
| Users | List | User emails added manually via "Search by Email id" |

### Approval Matrix
| Field | Type | Notes |
|---|---|---|
| id | Serial (PK) | Auto-increment |
| Organisation | Dropdown | PB, EB, or Client |
| Doc Type | Dropdown | 4 Way or Designation Notice (DN) |
| Org Type | Dropdown | PB, EB, or Client |
| LEIs | Multiselect | List of Legal Entity Identifiers |
| Review Type | Toggle | Parallel (Default) or Sequential |
| Document Actions | Mapping | Maps states (Draft, Submit, Terminate, Approve, Reject, Cancel, Edit, Copy) to Approval Groups. |

### Document Template
| Field | Type | Notes |
|---|---|---|
| id | Serial (PK) | Auto-increment |
| Template Name | String | Required |
| Organisation | Dropdown | Immutable once created |
| Doc Type | Dropdown | Immutable once created |
| Document Terms | Text Area | Configurable contract language clauses |

### Document Framework (DF)
| Field | Type | Notes |
|---|---|---|
| id | Serial (PK) | Auto-increment |
| Template Name | Dropdown | Associated Document Template skeleton |
| Organisation | Dropdown | Defaults to user's logged-in organisation |
| Doc Type | Dropdown | 4 Way or Designation Notice (DN) |
| Parties | Multiselect | Unique counterparty legal entities |
| Auth Products | List | Product Groups, Asset Classes, Product Families, and Products |
| Currencies | List | Currency Groups (Deliverable / Non-Deliverable / Bullion) |
| Workflow | Configuration | Approver groups mapped to actions |
| Manual Approval Email | String | Fallback email for manual PDF workflows |

### Designation Notice (DN)
| Field | Type | Notes |
|---|---|---|
| id | Serial (PK) | Auto-increment |
| Parent Framework | FK (DF) | Inherits all terms, scopes, and offices from parent DF |
| EB Identifier Code | String | Executing Broker alternate code for STP routing |
| Client Identifier Code| String | Client alternate code for STP routing |
| Auth Scope / Limits | Decimal | Position credit limit amounts and tenors |
| Status | String | Draft, Pending Approval, Active, Terminated |

### USP Rider
| Field | Type | Notes |
|---|---|---|
| id | Serial (PK) | Auto-increment |
| Doc Type | Dropdown | 4 Way or Designation Notice (DN) |
| Prime Broker | Dropdown | Selected from Parties |
| Client | Dropdown | Selected from Parties |
| PB Contact | String | Required contact information |
| Clause Wordings | Text Area | Standard clause text or custom contract wording |
| Covered Counterparty | Dropdown | Covered counterparty or class of covered PB counterparties |
| CFTC Fields | Multi-select | CFTC Rule 23, 402(f), and CFTC Letter options |

## Detailed Knowledge (Sub-Files)

Load these based on what the current task needs:

- **Business rules & validation logic** → read `./business-rules.md`
- **API endpoints & database assertions** → read `./api-reference.md`
- **UI page element selectors (WebElementFacade)** → read `./ui-selectors.md`
- **User flows, test scenarios & verification** → read `./user-flows.md`

### Root Reference Files
For exhaustive details or direct framework technical guidelines:
- **Comprehensive Product Specifications** → refer to `C:\Users\PawanKumar\ODC_QA\dms-automation\application_knowledge.md` (fully parsed ODC User Guide rules and updates)
- **Technical Framework/Driver Setup** → refer to `C:\Users\PawanKumar\ODC_QA\dms-automation\framework_knowledge.md` (Serenity BDD properties, Chrome capabilities, execution patterns, and connections)
