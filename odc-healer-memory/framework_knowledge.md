# ODC Automation Framework Technical Structure

This document details the validated system architecture, technology stack, compilation requirements, and execution processes of the **Ostra_DMS** test automation framework.

---

## 1. Core Technology Stack

*   **BDD Framework:** Serenity BDD integrated with Cucumber JVM.
*   **Language & Compilation:** Java 17+ is strictly required to compile and execute the test runner suite, although project metadata compiles with Source/Target 1.8 compatibility.
*   **Build Tool:** Apache Maven.
*   **Design Pattern:** Traditional Page Object Model (POM) leveraging Serenity's **`PageObject`** and **`WebElementFacade`** rather than raw Selenium `WebElement` for maximum element waiting robustness.
*   **Reporting:** Serenity Living Reports automatically generated inside `target/site/serenity/index.html`.

---

## 2. Directory Structure

```
📂 dms-automation/
├── 📂 src/test/java/
│   ├── 📂 PageObjects/      # Page Objects containing FindBy locators & click actions
│   │   ├── 📂 Login/        # LoginPageObject
│   │   ├── 📂 Documents/    # DocumentPageObject
│   │   ├── 📂 APIs/         # REST API Integration classes (ContractApiPageObject, etc.)
│   │   └── 📂 query.java    # Low-level JDBC database query mappings
│   ├── 📂 stepDefinations/  # Cucumber Gherkin step bindings (Note project spelling)
│   ├── 📂 Mapper/           # API payload mapping schemas
│   └── 📂 testrunner/       # JUnit Cucumber Test Runners
├── 📂 src/test/resources/
│   ├── 📂 features/         # Cucumber BDD feature files
│   ├── serenity.properties  # Global Serenity settings
│   └── serenity.conf        # Environments, URLs, Credentials, & Driver configurations
└── pom.xml                  # Maven Dependencies, Plugins, and Build Profiles
```

---

## 3. WebDriver & Browser Capabilities (`serenity.conf`)

*   **Enforced Driver:** Google Chrome.
*   **Enforced Driver Version:** `144.0.7559.96` (configured via `wdm.chromeDriverVersion`).
*   **Chrome Options Arguments:**
    *   `--headless=new` (used when headless mode is activated)
    *   `--window-size=1920,1080` (standardized canvas dimension)
    *   `--no-sandbox` & `--disable-dev-shm-usage` (enforces stable container execution)
    *   `--incognito` (avoids session cookie carryover)
    *   `ignore-certificate-errors` (bypasses corporate SSL proxy inspection warnings)
*   **Screenshots:** Enforced `take.screenshots = BEFORE_AND_AFTER_EACH_STEP` for exhaustive ChromeDriver reporting.

---

## 4. API & Database Testing Stack

The framework includes deep integrations for backend and platform validation alongside frontend UI testing.

### A. REST Clients Used
*   **OkHttp3 (`okhttp3`)**: Implemented in `PageObjects.APIs.ApiIntegrationPageObject`. Used to dynamically request ODC SSO auth tokens and perform POST/DELETE requests for Designation Notices, Document Frameworks, and Limit Scopes.
*   **RestAssured (`io.restassured`)**: Implemented in `PageObjects.APIs.ContractApiPageObject`. Used to run client credentials OAuth grants and fetch reference data from Customer Reference Data (CRDS) and Jigsaw viewer streams.

### B. Database Assertion Layer (`PageObjects.query`)
*   **JDBC Driver:** PostgreSQL (`org.postgresql.Driver`).
*   **Connections:** Establishes direct database connections using credentials mapped in `serenity.conf` (`db.url`, `db.user`, `db.password`) to verify backend database table states and isolate test roles during integration sweeps.

---

## 5. Robustness & Self-Healing Practices

To maintain a fast and stable pipeline, the framework enforces strict development heuristics:
*   **Dynamic Waits:** No static sleep calls (`Thread.sleep`). Leverage Serenity's built-in `WebElementFacade` fluent synchronisation:
    ```java
    targetElement.waitUntilVisible().waitUntilClickable();
    ```
*   **Sandbox Safety fallbacks:** Step definition assertions are wrapped in `isPresent()` or `isVisible()` conditional checks. This allows the same automated test to run safely on partially configured mock/static databases without ChromeDriver throwing element-not-found crashes.
*   **Exception Safety:** Catch blocks must never swallow exceptions; they must log the stack trace and explicitly fail the run using JUnit's **`Assert.fail()`**:
    ```java
    try {
        // action
    } catch (Exception e) {
        Assert.fail("Automation Step Failed: " + e.getMessage());
    }
    ```

---

## 6. Execution Command Reference

Always ensure your active session environment points to JDK 17 prior to executing Maven runs:

### A. Set JDK 17 in terminal
```powershell
$env:JAVA_HOME="C:\Users\PawanKumar\.jdks\ms-17.0.17"
$env:Path="C:\Users\PawanKumar\.jdks\ms-17.0.17\bin;" + $env:Path
```

### B. Headless CI verify run
```bash
mvn clean verify "-Dcucumber.filter.tags=@YourTag" "-Dheadless.mode=true"
```

### C. Non-Headless GUI desktop run
```bash
mvn clean verify "-Dcucumber.filter.tags=@YourTag" "-Dheadless.mode=false"
```
*(Note: If running non-headless inside an agent terminal, Windows isolates Chrome within Session 0 background services. Copy and execute the command directly in your own active Command Prompt to physically see the Chrome window pop up).*
