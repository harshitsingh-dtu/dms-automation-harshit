# ODC / DMS User Flows & Test Verification

This reference documents the step-by-step user flows executed within the Serenity BDD test runner and checked directly against the ODC PostgreSQL instance, as aligned with the ODC User Guide (Version 1.3d).

---

## Flow 1: Authentication & Database-Driven Login
1. **Target Account Resolution:**
   - Execute query to find active `lei_org_type_id` by status:
     ```sql
     select id from lei_org_type where status = 'active';
     ```
   - Resolve matching `user_id` from organisation mappings:
     ```sql
     select user_id from user_lei_org_type where lei_org_type_id = ?;
     ```
   - Retrieve the user's registered login email:
     ```sql
     select email_id from dms_user where user_id = ?;
     ```
2. **UI Login Execution:**
   - Navigate to the login screen.
   - Enter the resolved email address and secure password.
   - Click Submit and verify that the user profile avatar icon is visible in the header section.
3. **Session Stability Verification:**
   - Verify environment badge shows correct deployment details beside the exit (X) button.

---

## Flow 2: Creating a Unique Approval Group
1. Navigate in the sidebar menu: **Groups & template ➔ Approval Group**.
2. Click the **Create Approval Group** button.
3. Generate a unique name using a random string generator (e.g., prefix `Group_` + random characters) and store it in Serenity's session variables (`net.serenitybdd.core.Serenity.setSessionVariable("STORED_APPROVAL_GROUP_NAME")`).
4. Enter the unique name in the group name textbox.
5. Search and select:
   - Organisation Name
   - Doc Type
   - Legal Entity (LEI)
   - Organisation Type
6. Click **Next** to open the user assignment page.
7. Type a user's email in **Search by Email id** and select **Add** from the dropdown. Confirm the user is added to the group.
8. Click **Submit** and verify the success toast.
9. Return to the list page, use the search bar to locate the group name, and verify its row count of users.

---

## Flow 3: Conditional Approval Matrix Lifecycle
To avoid duplicate matrix configuration errors during consecutive test runs, utilize a check-before-create flow:
1. Navigate in the sidebar menu: **Groups & template ➔ Approval Matrix**.
2. Type the target Legal Entity (LEI) in the search box.
3. Wait for the dropdown and select the target LEI.
4. **Evaluate Listing table:**
   - If the first row does not contain "no record", the matrix already exists ➔ **Skip Creation**.
   - If "no record" is found, proceed to creation:
5. Click **Create Approval Matrix**.
6. Select Organisation, Doc Type, LEI, and Org Type.
7. Click **Next** and wait for the success toast (`Approval matrix created successfully`).
8. On the matrix configuration screen, select your Approval Group from the dropdowns corresponding to the different Document Actions.
9. *Optional:* Click **Apply All** to populate the same approval group across all available Document Actions in a single action.
10. Click **Submit** to save changes and return to the dashboard.
11. Clear search filters to leave the listing dashboard in a fresh state.

---

## Flow 4: Creating a Currency & Currencies-Pair Group
1. Navigate in the sidebar menu: **Groups & templates ➔ Currencies Group**.
2. Click **Create New Group** button.
3. Generate and enter a unique currencies group name.
4. Select Organisation from the Organisation dropdown list.
5. Under the All currencies section:
   - Click to select standard currencies from the Deliverable and/or Non Deliverable lists.
   - *Optional:* Type in the "Search currencies" search box to filter the list.
   - *Optional:* Select the **Bullion** checkbox to expose bullion currencies, and select required bullion currencies.
6. Click **Submit** and wait for the success toast.
7. Verify that the newly created currency group appears at the top of the Currencies groups list.
8. *To Create a Currency-Pair Group:* Toggle to **Currencies-Pair Group**, click **Create New Group**, and follow the same steps to select currency pairs.

---

## Flow 5: Creating a Product Group with Attributes
1. Navigate in the sidebar menu: **Groups & template ➔ Product Group**.
2. Click **Create Product Group** button.
3. Enter a unique Product group name.
4. Select Organisation from the Organisation dropdown list.
5. Under **Auth products**, select Asset Class, Product Family, and Product.
6. Click **Add Product Line** to display the selected product line.
7. Optionally, click the caret icon toggle for a product to expand and select specific underlying attributes, or click **Expand All** to expand all underlying product attributes across all product lines.
8. Click **Submit** and verify the success notification (`Product Group created successfully`).

---

## Flow 6: Creating a Document Template
1. Navigate in the sidebar menu: **Groups & template ➔ Document Template**.
2. Click **Create New Template** button.
3. Enter Template Name, select Organisation, and select Doc Type (4 Way or DN), then click **Next** to proceed to the Update Document Template page.
4. Set up Template configurations:
   - **Approval Workflow:** Drag and drop participants (e.g., Prime Broker - 1, Client - 1) into drop zones.
   - **Enforcement Rules:** Configure timing models (e.g., toggling between Immediate or Schedule with Duration value).
   - **Document Terms:** Type or paste standard template terms in the ck-editor rich text area.
5. Click **Submit** to save the template, and verify it is listed in the Document templates list.

---

## Flow 7: Creating a USP Rider
1. Navigate in the sidebar menu: **Groups & template ➔ USP Rider**.
2. Click **Create New USP Rider** button.
3. In the Create New USP Rider page:
   - Select Document Type.
   - Select Prime Broker and Client counterparties.
   - Enter PB contact info.
   - Enter standard clause wording or type custom clause wording.
   - Select Covered counterparty/Class of covered PB counterparties.
   - Configure CFTC options (CFTC Rule 23, 402(f), and CFTC Letter).
4. Click **Submit**. When the confirmation prompt appears asking if you want to view impacted documents, click **No** to close the prompt and return to the list.

---

## Flow 8: Cross-Organisation Visibility Validation (VIEW_ALL)
1. Select the Legal Entity search filter on any dashboard.
2. Clear any existing characters, type the target Legal Entity Name, and select it from the dropdown.
3. Check table rows:
   - Loop through rendered rows in the UI table.
   - Assert that at least one visible row has valid data.
   - Fail explicitly if only "no record" is displayed, proving the lack of necessary VIEW_ALL permissions.

---

## Flow 9: Counterparty Electronic Signature & Verification (DMGS-9106)
1. **PB Signing Flow:**
   - Log in using credentials for a Prime Broker Organisation (`PB_Org`).
   - Navigate to the **Approval Agreement** Screen and filter for the target agreement.
   - Click the "Sign Prime Broker" button and assert that the action succeeds (button becomes disabled, status and audit trail updates).
   - Assert that the "Sign Executing Broker" button remains disabled/non-clickable for the PB user.
2. **EB Signing Flow:**
   - Log in using credentials for an Executing Broker Organisation (`EB_Org`).
   - Verify that the "Sign Prime Broker" button is disabled/hidden, but the "Sign Executing Broker" button is visible and active.
   - Click "Sign Executing Broker" and confirm success.

---

## Flow 10: Generalized Multi-Report Column Sorting (DMGS-8042)
1. Navigate to the target dashboard (e.g. Documents, Frameworks, Alternate Legal Entity).
2. Retrieve the baseline table rows and extract cell text values for the chosen column (e.g., `Document Name`).
3. Click the column header once to trigger ascending sorting.
4. Extract the newly rendered table cell values and programmatically assert they conform to strict alphanumeric or numeric ascending order.
5. Click the column header again to trigger descending sorting, extracting cell values to verify descending order.
6. **Persistence Check:**
   - Click the column header to apply descending sorting.
   - Log out of the application and then log back in.
   - Navigate back to the target dashboard and verify that the column remains automatically sorted in descending order by default.
