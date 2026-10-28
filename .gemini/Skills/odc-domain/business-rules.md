# ODC / DMS Business Rules Reference

This reference documents the official validated business rules, validation logic, and regulatory constraints of the OSTTRA Documentation Centre (ODC), as aligned with the ODC User Guide (Version 1.3d).

---

## 1. Approval Groups (Static Data)
*   **Attributes required:** Every Approval Group requires a Group name, Organisation, Doc type, LEIs, and Org type to be defined on creation.
*   **Name Uniqueness & Limit:** Strictly validated; group names must be unique within an organisation and limited between 1 and 255 characters. The same group name can exist across different organisations (since Drop 2b).
*   **Default State:** A newly created Approval Group contains **no users by default**. 
*   **User Association:** Users must be added manually by typing their email in "Search by Email id" and selecting "Add" from the dropdown. 
    *   *Constraint:* The available users eligible to join a group are restricted based on the selected Organisation and LEI.
*   **Deletions & Name Changes:** 
    *   *Constraint:* Deletions or name modifications are strictly blocked if the group is currently assigned to any active, submitted, or in-flight Document Frameworks, Designation Notices, or 4-Ways agreements.
*   **Auditability:** Every create, edit, and deletion event must log a permanent entry in the Approval Group History audit trail.

---

## 2. Approval Matrices (Static Data)
*   **Purpose:** Maps document action and legal entity combinations to designated Approval Groups.
*   **Action Coverage:** Handles states including Draft, Submit, Terminate, Approve, Reject, Cancel, Edit, Copy.
*   **Initial Setup:** When an Approval Matrix is created for the first time, it is initialized with **no approval groups assigned** to any document actions.
*   **Approval Ordering:** By default, the approval order is set to **Parallel**. Users can manually toggle to **Sequential** steps (Sequential review added in Drop 2b).
*   **Bulk Assignment (Apply All):** Users can click the **Apply All** button to quickly assign a single chosen Approval Group across all document actions on a parallel step, saving administration time.
*   **Submission Gatekeeper:** Submission of any Document Framework, Designation Notice, or 4-Ways is immediately blocked if a matching Approval Matrix is not set up and active for the chosen document action combination.

---

## 3. Currency Groups & Currencies-Pair Groups (Static Data)
*   **Ownership & Visibility:** The Currencies & Currencies-Pair homepage lists groups that belong to either a specific organisation or global currency groups. By default, they are displayed for all organisations.
*   **Creation Details:** Group Name and Organisation must be specified.
*   **Currency Selection:**
    *   Currencies can be selected from either **Deliverable** or **Non Deliverable** sections.
    *   Selecting the **Bullion** checkbox exposes bullion currencies under the Bullion section, which can then be selected.
    *   Supports a **Select All** checkbox to select all currencies in respective sections. Deselecting it clears the selection.
    *   Hovering over any selected currency reveals a remove (x) symbol to surgically remove individual currencies.
*   **Edit Constraints:** 
    *   A Currency Group or Currency-Pair Group name and selected currencies can be edited/updated.
    *   *Constraint:* A Currency Group or Currency-Pair Group's **Organisation cannot be edited** after creation.
*   **Deletion:** Can be deleted using the delete/trash symbol.

---

## 4. Product Groups (Static Data)
*   **Ownership & Scope:** The listed Product Groups on the homepage are filtered and shown as per the user's Organisation.
*   **Creation Details:** Requires Product Group Name and Organisation.
*   **Authorisation Products:**
    *   Select Asset Class, Product Family, and Product, then click **Add Product Line** to add it to the Product Group.
    *   Selected options under Product Family and Product appear as `<first selected option> + count of remaining selected options`.
    *   Selected options in Organisation, Asset Class, Product Family, and Product can be removed via the hover remove symbol.
*   **Attribute Management:**
    *   Toggle caret/dropdown arrow for a product line to select specific underlying attributes.
    *   Supports an **Expand All** button to expand all underlying FX product attributes for the specified products, and a **Collapse All** button to collapse them.
    *   Supports an **Edit** dialog to update existing Auth Products.
    *   Supports a **Delete** action to delete a product line and a **Copy** action to duplicate a product line to the bottom.
*   **Edit Constraints:** Product Group Name, Asset Class, Product Family, Product, and attributes can be updated.
    *   *Constraint:* A Product Group's **Organisation cannot be edited** after creation.

---

## 5. Document Templates (Static Data)
*   **Ownership & Scope:** Listed Document Templates on the homepage are shown as per the user's Organisation.
*   **Creation Details:** 
    *   Step 1: Enter Template Name, select Organisation, and select Doc Type (4 Way or DN), then click **Next**.
    *   Step 2: Enter the Document Terms text/clauses in the Update Document Template page, then click **Submit**.
*   **Edit Constraints:** 
    *   Template Name and Document Terms can be edited/updated.
    *   *Constraint:* A Document Template's **Organisation and Doc Type cannot be edited** after creation.
*   **Auditability:** Click the Audit icon under Action to view the Document Template History audit trail.

---

## 6. USP Riders (Static Data)
*   **Creation Details:** 
    *   Requires selecting Document Type, selecting Prime Broker and Client counterparties, and entering a PB Contact.
    *   Enter the word clause text directly or select a predefined **standard clause wording** dropdown option.
    *   Select Covered Counterparty or Class of Covered PB counterparties.
    *   Configure CFTC options under CFTC Rule 23, 402(f), and CFTC Letter.
    *   Click the "+" symbol to add more rows, or "-" to delete rows.
*   **Confirmation Prompt:** Submitting a USP Rider shows a success toast and prompts whether you want to view impacted documents. Clicking **No** closes the prompt.
*   **Edit Constraints:** 
    *   PR Contact and Clause Wordings can be edited.
*   **Auditability:** Click the Audit icon to view the USP Rider History audit trail.

---

## 7. Document Frameworks (DF)
*   **Party Defaulting:** Prime Broker (PB) and Executing Broker (EB) fields default to the logged-in user's organization. If the user possesses dual representation, manual selection is prompted.
*   **Party Uniqueness:** Every Document Framework must have unique "Select Parties" options to complete creation successfully.
*   **Product Selection Ease:** Supports single-click multi-selection for all available product families or product options.
*   **Office Inheritance:** Supports configuring office details on a DF that are automatically inherited by the child Designation Notice (DN) (since Drop 3).
*   **Manual Fallback:** A `Manual PDF approval email` can be configured on the DF to process offline manual signatures when electronic flows are bypassed.
*   **Change Impact:** If currencies on an approved DF are modified, any linked child DNs dynamically recalculate and report their authorization scopes as either "increased" or "decreased".

---

## 8. Designation Notices (DN)
*   **Creation Origin:** Automatically inherits all terms, offices, and rules on creation from its parent approved Document Framework (DF).
*   **Alternate Identifier Codes (STP):** Users can manually input alternate Executing Broker and Client identifier codes on the DN. These are forwarded in the JSON Push API payload for Straight Through Processing (STP) with downstream systems (e.g. CreditLink).
*   **Settlement Conflict Checks:** Throws an in-flight validation warning if the selected authorization scope currencies do not match the settlement type criteria (deliverable or non-deliverable).
*   **Attribute Conflict Validation:** Throws an in-flight validation warning if selected attributes contradict (e.g. specifying `Touch Direction = Up` while `Contract Type = Put`).

---

## 9. Approval Agreements (DMGS-9106)
*   **Counterparty Signature Constraints:**
    *   PB users can only sign electronic approval agreements on behalf of the Prime Broker counterparty.
    *   EB users can only sign electronic approval agreements on behalf of the Executing Broker counterparty.
    *   *Cross-Signing Blocked:* PB users are restricted from signing for EB, and EB users are restricted from signing for PB.
*   **Administrative Ownership:**
    *   Only PB users are authorized to edit and save configurations for the required number of approvers and signature types (Electronic Signature vs Agreement Signed Externally).
    *   These fields render as disabled/read-only for EB or other user roles.

---

## 10. Dashboards, Reports, & Column Sorting (DMGS-8042)
*   **Data Downloads:** Dashboards support downloading table listings in Excel formats, fully preserving active filters, columns, and custom order states.
*   **Saved Sorting Preferences:** Custom column sorting preferences are persisted to the user profile database, loading as the default state on subsequent log-ins.
*   **Default Neutral State:** Tables initialize in their unsorted system default database sequence upon first visit, displaying neutral, unhighlighted sort indicators.
*   **Cycle States:** Column headers support a 3-state sorting cycle: `Unsorted ➔ Ascending ➔ Descending ➔ Unsorted`.
*   **Chronological Audits:** Descending sorting order is strictly enforced on all audit trails to ensure historical events display newest-first.
