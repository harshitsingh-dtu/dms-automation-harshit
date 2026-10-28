# Test Scenarios for DMGS-1753 (UI: Revised Side Menu)

This document outlines the designed Gherkin test scenarios for the revised side menu as per the DMGS-1753 specification. 

---

### TC-001: Toggle Hamburger Menu to X and Slide In Side Menu
**Category**: Happy Path
**Priority**: P0
**Preconditions**: User is logged into the ODC application and is on any landing page.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-001
Scenario: Toggle Hamburger Menu to X and Slide In Side Menu
  Given User is logged in and on the landing dashboard screen
  When User clicks on the hamburger menu button
  Then The side menu slides in from the left and shifts the main content area to the right
  And The hamburger menu icon transitions into an 'X' close button
```
**Business Rule**: Side menu slides in from left, shifts content area to right, and hamburger toggles to 'X' close button.
**Verification Layer**: E2E

---

### TC-002: Verify Side Menu Dashboard Option is Displayed Instead of Overview
**Category**: Happy Path
**Priority**: P0
**Preconditions**: User is logged into the ODC application.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-002
Scenario: Verify Side Menu Option is Dashboard instead of Overview
  Given User is logged in and opens the revised side menu
  Then User should see the option 'Dashboard' displayed on the side menu
  And The option 'Overview' should not be present on the side menu
```
**Business Rule**: Side menu option is 'Dashboard' instead of 'Overview'.
**Verification Layer**: E2E

---

### TC-003: Verify Dashboard Navigation Displays Documents Title
**Category**: Happy Path
**Priority**: P0
**Preconditions**: User is logged into the ODC application and has the side menu open.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-003
Scenario: Verify Dashboard Navigation Displays Documents Title
  Given User is logged in and opens the revised side menu
  When User selects the 'Dashboard' option from the side menu
  Then User is navigated to the Documents List report screen
  And The report title is displayed as 'Documents' instead of 'Overview'
```
**Business Rule**: Invoking the Dashboard menu displays 'Documents' as the list report title.
**Verification Layer**: E2E

---

### TC-004: Verify Logged-In Environment and Software Version Displayed at Bottom
**Category**: Happy Path
**Priority**: P1
**Preconditions**: User is logged into the ODC application.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-004
Scenario: Verify Logged-In Environment and Software Version Details
  Given User is logged in and opens the revised side menu
  Then User should see the logged-in environment name at the bottom of the side menu
  And User should see the current build version of the software displayed beside the environment name
```
**Business Rule**: Bottom section of the side menu displays logged-in environment and build version.
**Verification Layer**: E2E

---

### TC-100: Revert to Dashboard and Documents on Menu Re-invocation
**Category**: Business Rule
**Priority**: P1
**Preconditions**: User is logged in.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-100
Scenario: Validate Reverting back to Dashboard Option on Menu Re-invocation
  Given User is on the Documents List report screen with title 'Documents'
  When User clicks the 'X' button to close the side menu
  And User re-opens the side menu using the hamburger menu button
  Then The option 'Dashboard' is still displayed and highlighted as active
```
**Business Rule**: amendment of 01/02/24 to permanently revert option to 'Dashboard' and title to 'Documents'.
**Verification Layer**: E2E

---

### TC-200: Verify Side Menu UI Adaptability to User Permissions
**Category**: Security
**Priority**: P1
**Preconditions**: User has specific functional permissions (e.g. no access to Document Framework creation).
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-200
Scenario: Verify Side Menu UI Role Isolation and Structure
  Given User is logged in with restricted functional permissions
  When User opens the revised side menu
  Then The menu structure displays only authorized options
  And The side menu layout remains aesthetically intact with correct alignment of bottom metadata
```
**Business Rule**: Side menu honors role-based view restrictions and remains structure-secure.
**Verification Layer**: E2E

---

### TC-300: Close Side Menu via Clicking Outside or Escape Key
**Category**: Negative
**Priority**: P2
**Preconditions**: Side menu is currently slid open.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-300
Scenario: Close Side Menu via Off-Click and Escape Key
  Given User is logged in and the revised side menu is open
  When User clicks outside the side menu area on the main content overlay
  Then The side menu slides back to the left
  And The close button 'X' transitions back to the hamburger menu button
  When User opens the side menu again
  And User presses the 'Escape' key on the keyboard
  Then The side menu slides back to the left and closes successfully
```
**Business Rule**: Closing side menu via overlay click or ESC key triggers graceful closing slide transitions.
**Verification Layer**: Component

---

### TC-400: UI Responsive Shift and Horizontal Scroll with Open Side Menu
**Category**: Edge Case
**Priority**: P2
**Preconditions**: User is logged into the application.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-400
Scenario: Validate Horizontal Scroll and Content Area Shift on Small Resolutions
  Given User is logged in with a small browser viewport resolution
  When User clicks on the hamburger menu button to slide in the side menu
  Then The content area moves to the right
  And A horizontal scrollbar is dynamically added to the page structure if layout overflow occurs
  And No side menu options or bottom environment labels overlap or truncate
```
**Business Rule**: Content area shifts to right and introduces horizontal scroll if the sidebar causes structural overflow.
**Verification Layer**: Component

---

### TC-401: Dynamic Handling of Extremely Long Environment or Version Name
**Category**: Edge Case
**Priority**: P3
**Preconditions**: Application is deployed in an environment with a very long tag name.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-401
Scenario: Dynamic Wrap of Extremely Long Environment or Build Version Strings
  Given The application is running on an environment with an extremely long name
  When User opens the revised side menu
  Then The long environment and build version strings are displayed at the bottom
  And The text wraps elegantly or uses truncation without overlapping other menu elements
```
**Business Rule**: Bottom environment and version labels handle long text safely without breaking UI layouts.
**Verification Layer**: UI State

---

### TC-500: Verify Smooth Slide In and Sliding Animation Transitions
**Category**: UI State
**Priority**: P2
**Preconditions**: User is on any ODC screen.
**Feature File Path**: `src/test/resources/features/ODC_Menu/Revised_menu.feature`
**Gherkin Specification**:
```gherkin
@revisedmenu @TC-500
Scenario: Verify CSS Animation and Slide Transitions of Side Menu
  Given User is on the landing page
  When User toggles the hamburger menu
  Then The side menu slides smoothly from the left using standard CSS transitions
  And The transition of the content area shift occurs synchronously with the menu slide
```
**Business Rule**: Sidebar uses standard, high-performance CSS transition timing for sliding effects.
**Verification Layer**: UI State
