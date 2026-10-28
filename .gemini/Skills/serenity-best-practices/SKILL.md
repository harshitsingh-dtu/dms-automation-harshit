---
name: serenity-best-practices
description: Serenity BDD and Selenium WebDriver best practices — locator strategy, element finding (WebElementFacade), wait strategies, assertions, Page Object Model (POM), step definitions, and anti-patterns. Use when writing, reviewing, or debugging Serenity tests.
user-invocable: false
---

# Serenity BDD Test Automation Best Practices for ODC

## Overview
This document defines the testing standards, patterns, and best practices for writing Serenity BDD test automation in the ODC/DMS project. All test automation agents and code reviewers MUST follow these guidelines.

---

## 1. Project Test Setup

### Core Directory Structure
- **Gherkin Features**: `src/test/resources/features/<module>/<feature-name>.feature`
- **Step Definitions**: `src/test/java/stepDefinations/` *(Note spelling: stepDefinations)*
- **Page Objects**: `src/test/java/PageObjects/`
- **Configuration**: `serenity.conf`, `serenity.properties`
- **Execution / Report**: `target/site/serenity/index.html`

### Execution Command Reference
- Run full suite: `mvn clean test verify`
- Run single feature: `mvn clean test -Dcucumber.features=src/test/resources/features/ODC_Menu/Revised_menu.feature`
- Run single tag: `mvn clean test -Dtags="revisedmenu"`

---

## 2. Locator Strategy (Priority Order)

Always choose locators in this priority order inside Page Objects for reliability, maintainability, and clean code:

### Priority 1: data-testid (Most Preferred)
```java
@FindBy(css = "[data-testid='event-card']")
private WebElementFacade eventCard;

@FindBy(css = "[data-testid='book-now-btn']")
private WebElementFacade bookNowBtn;
```
Use for: Highly stable test hooks that survive UI redesigns. Always ask developers to add `data-testid` to interactive elements.

### Priority 2: Element IDs
```java
@FindBy(id = "login-btn")
private WebElementFacade loginButton;

@FindBy(id = "customer-email")
private WebElementFacade customerEmailInput;
```
Use for: Stable elements with explicit, static layout IDs in the HTML markup.

### Priority 3: Accessibility Roles and Dynamic Text
```java
@FindBy(xpath = "//button[text()='Submit']")
private WebElementFacade submitBtn;

@FindBy(xpath = "//*[text()='Sign Out']")
private WebElementFacade logoutBtn;
```
Use for: Links, buttons, and titles where the semantic user-visible text is the defining identity.

### Priority 4: CSS Selectors (Last Resort)
```java
@FindBy(css = ".confirm-booking-btn")
private WebElementFacade confirmBookingBtn;
```
Use for: Styling elements or layout structures where data-testid or IDs are absent. Keep selector chains short and maintainable.

### NEVER Use
- Fragile XPaths that depend on absolute indices: `/html/body/div[2]/div/span[3]/p`
- CSS selectors with deep, fragile ancestry: `.parent > .child:nth-child(3)`

---

## 3. Filtering and Scoping Patterns

### Filter lists of WebElementFacade by text
```java
public WebElementFacade findCardByTitle(String title) {
    return findAll("[data-testid='event-card']")
            .stream()
            .filter(element -> element.getText().contains(title))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Card not found with title: " + title));
}
```

### Scope actions to nested element boundaries
```java
public void clickBookNowOnCard(WebElementFacade card) {
    card.findBy("[data-testid='book-now-btn']").click();
}
```

---

## 4. Assertion Patterns

### Visibility Checks (Serenity Native)
```java
// Prefer Serenity's built-in assertions on WebElementFacade
eventCard.shouldBeVisible();
confirmBookingBtn.shouldNotBeVisible();
```

### JUnit & AssertJ Assertions
```java
import org.junit.Assert;

// Verify boolean checks
Assert.assertTrue("Profile icon is not visible", profileIcon.isVisible());

// Content checks
Assert.assertEquals("Title mismatch", "Documents", reportTitle.getText());
```

### Custom Element Explicit Timeouts
```java
// Auto-wait with explicit timeouts for slow rendering elements
eventCard.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
submitSpinner.withTimeoutOf(Duration.ofSeconds(15)).waitUntilNotVisible();
```

---

## 5. Test Structure Patterns

### Cucumber Step Definition Mapping (`stepDefinations/`)
- Step definition classes are light-weight. They map Gherkin text to Page Object method invocations.
- **Rule**: Keep assertions and logic *inside* Step Definitions or Page Objects, never mix raw Selenium actions directly in the step definitions.

```java
package stepDefinations.ODC_Menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import PageObjects.ODC_Menu.RevisedMenuPageObject;

public class RevisedMenuSteps {
    
    RevisedMenuPageObject menuPage;

    @Given("User is on the all document screen")
    public void user_is_on_all_document_screen() {
        menuPage.open();
    }

    @When("User clicks on Menu bar on Dashboard")
    public void user_clicks_menu_bar() {
        menuPage.clickMenuBar();
    }

    @Then("Validate osttra details in bottom")
    public void validate_osttra_details() {
        menuPage.verifyOsttraDetails();
    }
}
```

### Page Object Structure (`PageObjects/`)
- Extends `net.serenitybdd.core.pages.PageObject`.
- Expose functional action methods (e.g. `loginAs()`, `clickMenuBar()`) rather than low-level click/type sequences.

```java
package PageObjects.ODC_Menu;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import java.time.Duration;

public class RevisedMenuPageObject extends PageObject {

    @FindBy(xpath = "//div[@class='menu-bar']")
    private WebElementFacade menuBar;

    @FindBy(css = "[data-testid='osttra-footer-details']")
    private WebElementFacade footerDetails;

    public void clickMenuBar() {
        menuBar.withTimeoutOf(Duration.ofSeconds(5)).waitUntilClickable().click();
    }

    public void verifyOsttraDetails() {
        footerDetails.shouldBeVisible();
        Assert.assertTrue(footerDetails.getText().contains("OSTTRA"));
    }
}
```

---

## 6. Wait Strategies

### DO: Rely on Serenity Implicit & Auto-Waiting
```java
// WebElementFacade auto-waits before interaction
confirmBookingBtn.click();
```

### DO: Use Explicit Expected Conditions for transitions
```java
submitSpinner.waitUntilNotVisible();
successBanner.waitUntilVisible();
```

### DON'T: Use Thread.sleep()
```java
// BAD - Flaky and wastes pipeline CPU cycles
Thread.sleep(3000);
```

---

## 7. Anti-Patterns to Avoid

| Anti-Pattern | Why It's Bad | Do Instead |
|-------------|-------------|-----------|
| `Thread.sleep(N)` | Flaky, increases build duration | Use `element.waitUntilVisible()` |
| Duplicate Step definitions | Causes compilation/runtime crashes in Cucumber | Search codebase first and reuse step bindings |
| Raw Selenium `WebElement` | No built-in auto-waiting or robust features | Use Serenity's `WebElementFacade` |
| Over-assertions in loops | Slows execution, hides trace details | Assert specific targets outside the collection |
| Hardcoded Credentials | Security breach risk | Pull credentials via Config/Environment variables |
