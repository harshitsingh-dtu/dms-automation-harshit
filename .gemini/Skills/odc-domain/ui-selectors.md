# ODC / DMS UI Selectors Reference (WebElementFacade)

The following selectors are defined inside the official automation page objects of the Ostra_DMS repository. Always use these exact locators to avoid element-not-found or timeout failures.

---

## 1. Login Page Elements (`PageObjects.Login.LoginPageObject`)
- **Username / Email input (`username`):** `//input[@placeholder='Enter registered email id']`
- **Password input (`pass`):** `//input[@type='password']`
- **Submit button (`submit`):** `//button[@type='submit']`
- **Profile / Avatar icon (`profile`):** `//div[@class='profile-icon']`
- **User Not Found Alert (`usernotfound_alert`):** `//div[@class='Toastify']//div[@role='alert']`
- **Logout button (`logout_btn`):** `//*[text()='Sign Out']`
- **Forgot Password link (`forgot_btn`):** `//div//a`
- **Reset Link Popup message (`resetLinkPopup`):** `//div//div[text()='A password reset link has been sent to your email. Please check your inbox.']`
- **Main Landing Page Logo (`Main_Page_Logo`):** `//img[@src='/container/latest/a0b505d17aff9f21d1f9c62b50ce977d.svg']`
- **Internal Dashboard Logo (`Internal_Page_Logo`):** `//div[@class='header-wrapper']//img[@src='/container/latest/2f805e88389181e764b407e10890bbc8.svg']`

---

## 2. Universal Navigation & Document Page Elements (`PageObjects.Documents.DocumentPageObject`)
- **Main Sidebar Menu Expander (`menu_btn`):** `//div[contains(@class,'sidebar-icon')]`
- **Document Tab expander (`document_tab`):** `//div[@data-testid='menu-category-name' and normalize-space()='Document']`
- **All Documents Sub-link (`allDocument_tab`):** `//*[@data-testid='submenu-link-All documents']`
- **Title header text block (`document_text`):** `//div[@class='title']`
- **Create New Document button (`createnewdocument_btn`):** `//button[text()='+ Create new document']`
- **Reload / Refresh Dashboard button (`refreshButton`):** `//div[@class='reload-icon-container']`
- **Bulk Action selection button (`bulkaction_btn`):** `//button[text()='Bulk Action']`
- **Search bar filter input:** `//input[@placeholder='Search with document & version ID']`

---

## 3. Static Data: Approval Groups Page (`PageObjects.Approval.ApprovalgroupPageObject`)
- **Create Approval Group Button:** `//button[text()='+ Create Approval Group']`
- **Next Button:** `//button[text()='Next']`
- **Cancel Button:** `//button[text()='Cancel']`
- **Organisation Name input:** `//input[@placeholder='Select Organisation']`
- **Doc Type input:** `//input[@placeholder='Select Doc Type']`
- **Org Type input:** `//input[@placeholder='Select Org Type']`
- **LEI Dropdown box:** `//div[text()='Select Leis']`
- **Group Name input:** `//input[@placeholder='Enter group name']`
- **Search bar:** `//input[@placeholder='Search by group name']`
- **First row group name cell:** `//table/tbody//td[1]`
- **Group Already Exists Alert:** `//div[text()='Group name already exists.']`
- **Update Group Name Field:** `//div[text()='Group name']//following-sibling::input`
- **Legal Entity Name filter input:** `//input[contains(@placeholder, 'Select Legal entity name')]` or `//input[contains(@placeholder, 'Legal entity name')] | //label[contains(., 'Legal entity name')]/..//input`
- **Clear filter icon button:** `//input[contains(@placeholder, 'Legal entity name')]/parent::div//button[@title='Clear' or @aria-label='Clear']`

---

## 4. Static Data: Approval Matrices Page (`PageObjects.Approval.ApprovalMatrixPageObject`)
- **Create Approval Matrix Button:** `//button[text()='+ Create Approval Matrix']`
- **Update button (first row):** `//tr[1]//button[text()='Update']`
- **View button:** `//button[text()='View']`
- **Success toast message:** `//*[contains(text(), 'Approval matrix created successfully') or contains(text(), 'successfully')]`
- **Dropdown List option:** `//li[@role='option' and contains(., '{text}')]` or `//div[contains(@class, 'option') and contains(., '{text}')]`
- **Apply All matrix columns:** `//button[text()='Apply All']`
- **Sequential checkbox trigger:** `//label[.//span[contains(text(),'Sequential')]]`
- **Add Parallel Column:** `//button[normalize-space()='+ Add Parallel Column']`

---

## 5. Static Data: Currency & Currency-Pair Groups Page (`PageObjects.Currency.CurrencygroupPageObject`)
- **Currency Groups Sidebar Menu link:** `//div[text()='Currencies Group']`
- **Create New Group button:** `//button[text()='Create New Group']` or `//button[contains(., 'Create New Group')]`
- **Group Name input:** `//input[@placeholder='Enter currencies group name']` or `//input[@name='currenciesGroupName']`
- **Organisation Name input:** `//input[@placeholder='Select Organisation']`
- **Currencies-Pair toggle sub-tab:** `//button[text()='Currencies-pair']` or `//button[text()='Currencies pair']`
- **Currencies standard sub-tab:** `//button[text()='Currencies']`
- **Search currencies text box:** `//input[@placeholder='Search currencies']`
- **Bullion checkbox:** `//span[text()='Bullion']` or `//input[@type='checkbox' and following-sibling::span[text()='Bullion']]`
- **Submit button:** `//button[text()='Submit']`
- **Success toast message:** `//*[contains(text(), 'Currency group created successfully') or contains(text(), 'successfully')]`
- **Search by currencies group name filter input:** `//input[contains(@placeholder, 'Search by currencies group name') or contains(@placeholder, 'Search')]`
- **Delete / Remove icon:** `//img[@title='Delete']` or `//button[@aria-label='delete']`

---

## 6. Static Data: Product Groups Page (`PageObjects.ProductGroup.ProductGroupCreatePageObject`)
- **Product Group Sidebar Menu link:** `//div[text()='Product Group']`
- **Create Product Group button:** `//button[text()='+ Create Product Group']` or `//button[contains(., 'Create Product Group')]`
- **Group Name input:** `//input[@placeholder='Enter product group name']` or `//input[@data-testid='product-group-name-input']`
- **Organisation Name input:** `//input[@placeholder='Select Organisation']`
- **Asset Class input:** `//*[@placeholder='Asset Class']`
- **Product Family input:** `//*[@placeholder='Select Product Family']`
- **Product input:** `//*[@placeholder='Select Product']`
- **Add Product Line button:** `//button[text()='Add Product Line']`
- **Product Line Delete button:** `//img[@alt='delete-line']` or `//img[@title='Delete']`
- **Expand All attributes toggle:** `//button[text()='Expand All']`
- **Collapse All attributes toggle:** `//button[text()='Collapse All']`
- **Submit button:** `//button[text()='Submit']`
- **Success toast message:** `//div[contains(text(),'Product Group created successfully')]`
- **Search Product Group input:** `//input[contains(@placeholder, 'Search by product group name')]`

---

## 7. Static Data: Document Templates Page (`PageObjects.DocumentTemplate.DocumentTemplateCreatePageObject`)
- **Document Template Sidebar Menu link:** `//*[text()='Document Template']`
- **Create New Template button:** `//button[text()='+ Create New Template']`
- **Template Name input:** `//input[@placeholder='Enter template name']` or `//input[@placeholder='Enter template name']`
- **Organisation input:** `//input[@placeholder='Select Organisation']`
- **Doc Type input:** `//input[@placeholder='Select Doc Type']`
- **Next button:** `//button[text()='Next']`
- **Approval Workflow tab button:** `//button[text()='Approval Workflow']` or `//button[text()='Approval workflow']`
- **Enforcement Rules tab button:** `//button[text()='Enforcement Rules']` or `//button[text()='Enforcement rules']`
- **Document Terms tab button:** `//button[text()='Document Terms']` or `//button[text()='Document terms']`
- **Rich Text Editor content area:** `//p[@data-placeholder='Type or paste your content here!']` or `//*[@class='ck ck-editor__main']//p`
- **Submit button:** `//button[text()='Submit']`
- **Search by template name input:** `//input[@placeholder='Search by template name']`
- **Audit trail icon:** `//img[@class='audit-log-btn']//..`

---

## 8. Static Data: USP Riders Page (`PageObjects.DMS_PHASE2PageObject.DMS_2198PageObject`)
- **USP Rider Sidebar Menu link:** `//div[text()='USP Rider']` or `//div[text()='USP Rider Template']`
- **Create New USP Rider button:** `//button[text()='+ Create New USP Rider']`
- **Header indicator:** `//h3[text()='Create New USP Rider']`
- **Success toast message:** `//div[text()='USP Rider created']`
- **Edit header indicator:** `//h3[text()='Edit USP Rider']`
- **Audit screen header indicator:** `//div[text()='USP Rider History']`
- **Tab in document preview screen:** `//button[text()='USP Rider']`
- **Available USP Rider document label:** `//div[text()='Available USP Rider document']`
- **Checkbox for available USP Rider:** `//div[text()='Available USP Rider document']/following::input[@name='checkbox']`
- **Template ID for available USP Rider:** `//div[text()='Available USP Rider document']/following-sibling::div`
- **USP Rider document not available text:** `//div[text()='USP Rider document not available']`
- **USP Rider detail container:** `//div[@class='usp-rider-detail-container']`

---

## 9. Approval Agreements (DMGS-9106)
- **Sign Prime Broker Button:** `//button[contains(.,'Sign Prime Broker') or contains(.,'Sign PB')]`
- **Sign Executing Broker Button:** `//button[contains(.,'Sign Executing Broker') or contains(.,'Sign EB')]`
- **PB Approvers Field:** `//div[@class='approval-creation-approvers'][1]//input[@role='combobox']`
- **EB Approvers Field:** `//div[@class='approval-creation-approvers'][2]//input[@role='combobox']`
- **Electronic Signature Checkbox:** `//input[@name='electronicSignature' or @type='checkbox']`

---

## 10. Universal Dashboard Navigation & Column Sorting (DMGS-8042)
- **Navigation Toggle Button:** `//div[contains(@class,'header-wrapper')]//img[@alt='menu-drag-icon']`
- **General Table Wrapper:** `//table`
- **Table Rows:** `//tbody/tr`
- **Asynchronous Spinner Loader:** `//div[contains(@class, 'spinner') or contains(@class, 'loading') or @data-testid='loader']`
- **Empty State Indicator:** `//div[@class='no-record-found' or contains(text(), 'No records found')]`
- **Table Pagination Footers:** `//div[contains(@class, 'pagination')]`
