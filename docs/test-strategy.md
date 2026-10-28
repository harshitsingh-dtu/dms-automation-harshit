# Test Strategy for DMGS-1753 (UI: Revised Side Menu)

This document establishes the automation execution strategy and testing pyramid allocation for the revised side menu (DMGS-1753). 

---

## 1. Strategy Executive Summary

The revised side menu is a fundamental UI/UX re-branding and structure shift. However, not every scenario requires heavy browser-level testing. Direct assertions on UI state can be optimized, and specific behaviors are best suited for component or E2E layers.

### 📊 Pyramid Distribution Table

| Testing Layer | Scenario Count | Focus / Scope | Target Execution Time |
|---------------|----------------|---------------|-----------------------|
| **E2E Browser** | 5 | Core sliding menu actions, visibility of "Dashboard" menu, "Documents" report title, and dynamic bottom metadata (environment, build). | < 2.5 minutes |
| **API**         | 0 | No API backend changes for this purely UI/UX ticket. | - |
| **Database**    | 0 | Static and client-side configuration checks. No direct DB transactions or auditing. | - |
| **Component**   | 3 | Responsive shift / horizontal scroll boundaries, off-clicking overlay closing, and escape-key handling. | < 10 seconds |
| **UI State**    | 2 | CSS Timing, sliding animation, and dynamic text wrap of bottom elements. | < 2 seconds |

---

## 2. Detailed Test Cases Allocation Table

| Test ID & Title | Assigned Layer | Technical Target | Architectural Rationale |
|-----------------|----------------|------------------|-------------------------|
| **TC-001**: Toggle Hamburger Menu to X and Slide In Side Menu | **E2E Browser** | `RevisedMenuValidationPage.java`, `Revised_menu.feature` | Verifies full DOM layout changes, SVG state transition (hamburger to X icon), and content pane shifting. |
| **TC-002**: Verify Side Menu Dashboard Option is Displayed Instead of Overview | **E2E Browser** | `RevisedMenuValidationPage.java`, `DocumentPageObject.java` | Verifies the core rebranding requirement to display 'Dashboard' option instead of 'Overview'. This is high-priority UI logic. |
| **TC-003**: Verify Dashboard Navigation Displays Documents Title | **E2E Browser** | `RevisedMenuValidationPage.java`, `DocumentPageObject.java` | Verifies end-to-end routing when selecting Dashboard and confirming the title is 'Documents'. |
| **TC-004**: Verify Logged-In Environment and Software Version Displayed | **E2E Browser** | `RevisedMenuValidationPage.java`, `DocumentPageObject.java` | Verifies dynamic client-side loading of configuration variables in the bottom pane. |
| **TC-100**: Revert to Dashboard and Documents on Menu Re-invocation | **E2E Browser** | `RevisedMenuValidationPage.java`, `DocumentPageObject.java` | Verifies state persistence and UI robustness across opening/closing cycles. |
| **TC-200**: Verify Side Menu UI Adaptability to User Permissions | **E2E Browser** | `RevisedMenuValidationPage.java`, `DocumentPageObject.java` | Role-isolation E2E check. Ensures sidebar options are conditionally hidden/shown depending on the login user context. |
| **TC-300**: Close Side Menu via Clicking Outside or Escape Key | **Component** | Browser event listener triggers / Playwright element checks | Component-level check for event propagation. Faster than running a full multi-page E2E session. |
| **TC-400**: UI Responsive Shift and Horizontal Scroll with Open Side Menu | **Component** | Resize-viewport tests / Playwright layout assertions | Layout bounds verification. Viewports can be shrunk and scroll triggers checked programmatically. |
| **TC-401**: Dynamic Handling of Extremely Long Environment or Version Name | **UI State** | CSS flex wrap & text truncation inspection | Checking CSS rendering rules on small layouts. |
| **TC-500**: Verify Smooth Slide In and Sliding Animation Transitions | **UI State** | CSS transition-duration checks & timing | Ensures performance is maintained with standard 0.3s slide timing without blocking main-thread responsiveness. |

---

## 3. Code Reuse & Anti-Duplication Strategy

To prevent test-suite bloat and duplicate code blocks:
- **Reuse Existing Locators:** We will leverage the pre-defined locators in `PageObjects.Documents.DocumentPageObject` (specifically `Dashboard`, `enviroment`, `bottomtext`, `navigation_btn`).
- **Reuse Existing Step Definitions:** Rather than writing new step definitions for standard revised-menu assertions, we will reuse:
  - `@Then("Validate osttra details in bottom")`
  - `@Then("Validate the dashboard")`
  - `@Then("Validate Env details beside X icon")`
  - `@When("User clicks on Menu bar on Dashboard")`
- **Standardized Cucumber Tags:** Standardize on `@revisedmenu` and `@Regression` tags so these tests execute as part of the existing revised-menu test-suite and fit within the CI/CD pipeline naturally.

---

## 4. Anti-Patterns Flagged

1. **Avoid Hardcoded Expected Environment Values:** 
   - *Problem:* Checking for `"QA"` explicitly in step assertions can cause failures when tests run in Dev or UAT.
   - *Fix:* Read the environment context dynamically from `serenity.conf` or assert that the returned environment text is non-empty and matches the active maven profile.
2. **Avoiding Thread.sleep() for CSS Transitions:**
   - *Problem:* Adding `Thread.sleep(300)` for the side menu sliding animation to complete causes test flakiness.
   - *Fix:* Rely on Serenity BDD's `WebElementFacade.waitUntilVisible()` or wait for the sliding container to contain the active CSS class.
3. **No Duplicate Gherkin Step Mappings:**
   - *Problem:* Writing steps like `Given User is logged in and opens the revised side menu` which duplicate the base landing navigation.
   - *Fix:* Split and reuse existing steps such as `Given User is on the all document screen` and `When User clicks on Menu bar on Dashboard`.
