# ODC / DMS API & Database Reference

This reference documents the exact, verified technical specifications of the OSTTRA Documentation Centre (ODC) API gateways, relative endpoints, credentials, and JDBC PostgreSQL connection URLs as parsed recursively from the framework configurations (`src/test/resources/serenity.conf`) and Java page object source classes.

---

## 1. REST API Gateways & Environments

The DMS automation framework connects to ODC using separate REST gateway servers for core contract operations (CDS Backend) and platform reference services (CRDS / Jigsaw).

### A. Environment Base Hosts
* **QA CDS API Gateway:** `https://qa.api.cds.osttra.com/`
* **QA Reference Platform Gateway (CRDS):** `https://qa.api.osttra.com/`
* **QA Web Platform Host:** `https://odc-qa.docs.osttra.com/`

---

## 2. Authentication & JWT Generation

### A. ODC SSO Dynamic Auth Tokens (OkHttp3)
To perform contract actions, an active JWT bearer token must be dynamically requested on the fly using the framework user's email:
* **SSO Endpoint:** `GET {webdriver.base.url}/api/odc-sso/v1/sso/auth/user/token?email={email}`
* **Auth Headers Required:**
  * `Content-Type: application/json`
  * `Userroles: {api.userRoles}` (comprehensive list of edit, create, approve, and download permissions mapped dynamically under `api.userRoles` in `serenity.conf`).
* **Returned Value:** Dynamic `authToken` mapped as `Authorization: Bearer <token>` in subsequent requests.

### B. Platform Credentials OAuth (RestAssured)
To fetch reference data or jigsaw views, a standard client credentials grant handshake is used:
* **OAuth Endpoint:** `POST {contract.base.url}/oauth2/v1/token` (Base: `https://qa.api.osttra.com/`)
* **Grant Parameters:**
  * `grant_type=client_credentials`
  * `client_id` (CRDS or Jigsaw Client ID mapping)
  * `client_secret` (CRDS or Jigsaw Secret Key mapping)

---

## 3. Exhaustive Endpoints & Payloads Reference

### A. ODC Core Document & Framework APIs
All request payloads are passed as JSON strings loaded from project resource templates (e.g. `src/test/java/resources/*.json`).

| Action | HTTP Method | Endpoint URL Relative Path | Request Header / Parameter Focus |
|---|---|---|---|
| **Create Document (DN / 4W)** | `POST` | `api/document/v1/document?versionId=&isRestrictionDocument=false` | JWT Bearer Token |
| **Create Document Framework** | `POST` | `api/document/v1/document?versionId=&isRestrictionDocument=true` | JWT Bearer Token |
| **Get Document Version ID** | `GET` | `document/edit` | Resolves current edit version specifications. |
| **Delete Document Version** | `DELETE` | `api/document/v1/document/{docId}/{versionId}` | JWT Bearer Token |
| **Limit Scope lines** | `POST` | `api/document/v1/limit-lines/` | JWT Bearer Token |
| **GraphQL Doc Version** | `POST` | `api/document/graphql` | Used for GraphQL-based version queries. |

### B. Customer Reference Data (CRDS) & Jigsaw APIs
These endpoints are used inside **`ContractApiPageObject`** to search and retrieve reference data:

| Integration Target | HTTP Method | Endpoint URL Relative Path | Query Params |
|---|---|---|---|
| **Fetch User via Email** | `GET` | `crds/api/crds-user/v1/user/user-details` | `?email={email}` |
| **Fetch User via ID** | `GET` | `crds/api/crds-user/v1/user/user-details/{id}` | Direct Path Parameter |
| **Fetch Users via IDs** | `GET` | `crds/api/crds-user/v1/user/user-details/ids?` | `&id={id_1}&id={id_2}` |
| **Search User Filters** | `POST` | `crds/api/crds-user/v1/user/user-details/listing` | Filter Payload Body |
| **Jigsaw Data Viewer** | `POST` | `data-foundation/data-viewer/api/v1/views/stream` | Client Credentials Token |

---

## 4. Database Integration Layer (PostgreSQL)

The automation framework leverages direct database connections to assert, update, or isolate test accounts on target schemas.

### A. QA RDS Database URL
* **JDBC URL:** `jdbc:postgresql://osttra-dms-odc-qa-postgres.caht1wuup09h.us-east-1.rds.amazonaws.com:5432/odc?ssl=true&sslmode=require`
* **Credentials:**
  * **User:** `odc_write_user`
  * **Password:** `odc_write_user`

### B. Automation Schema Assertions (`PageObjects.query`)
Used to run JDBC queries like:
- `select id from lei_org_type where status = ?;`
- `select user_id from user_lei_org_type where lei_org_type_id = ?;`
- `select email_id from dms_user where user_id = ?;`
