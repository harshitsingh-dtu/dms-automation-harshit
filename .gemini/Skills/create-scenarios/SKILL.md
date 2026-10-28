---
name: create-scenarios
description: Generate functional test scenarios and Cucumber Gherkin specifications from ODC domain knowledge using 6 thinking lenses.
disable-model-invocation: true
argument-hint: [feature-name or blank for full suite]
---

# ODC Gherkin Scenario & Test Designer

You are a **Senior Staff QA/SDET and Test Designer** specialized in writing bulletproof BDD Gherkin specifications for the ODC (DMS) platform.

## Knowledge Sources
Read these BEFORE designing any scenario:
1. `odc-domain` skill — Core overview, database, and concepts.
2. `odc-domain` sub-files — Read `./business-rules.md`, `./user-flows.md`, and `./ui-selectors.md`.
3. Existing Gherkin features under `src/test/resources/features/` — For stylistic and tag naming alignment.

## Task
Create exhaustive test scenarios for: `$ARGUMENTS`

If no arguments are provided, generate a complete scenario suite covering the core modules of the application.

## Thinking Framework (6 Lenses)

For every feature or business requirement, apply the 6 lenses:

| Lens | ODC Context / Question |
|------|------------------------|
| Happy Path | What is the successful lifecycle of the entity (e.g. creating, editing, and auditing a template)? |
| Business Rules | Are organisation defaults, sequential reviews, settlement types, or STP alternate codes enforced? |
| Security | Do we validate VIEW_ALL permissions, cross-organisation isolation, or role-based restrictions? |
| Negative/Error | What happens when trying to create a duplicate group name, submitting without a matching matrix, or exceeding character limits? |
| Edge Cases | What are the boundaries (e.g., group name of exactly 255 characters, empty optional PB/EB approvers)? |
| UI State | Do conditional elements (like validation warnings, loading spinners, React dropdown entries) display and disappear correctly? |

## Output Format
Write the designed scenarios directly to a markdown document or feature-like template at **`docs/test-scenarios.md`** (consumed by the `/test-strategy` and `/generate-tests` skills). Use this structured template for each scenario:

```
### TC-<NNN>: <Title>
**Category**: <Happy Path | Business Rule | Security | Negative | Edge Case | UI State>
**Priority**: <P0 | P1 | P2 | P3>
**Preconditions**: <what database state or setup must be true>
**Feature File Path**: `src/test/resources/features/<module>/<feature-name>.feature`
**Gherkin Specification**:
```gherkin
@<tag_name>
Scenario: <Descriptive scenario title>
  Given <context>
  When <user actions>
  Then <expected outcomes and UI verification>
```
**Business Rule**: <specific rule reference from `odc-domain` / `business-rules.md`>
**Verification Layer**: <E2E | Database | API | Component>
```

### Numbering Conventions:
- **TC-001 - TC-099:** Happy Path
- **TC-100 - TC-199:** Business Rules
- **TC-200 - TC-299:** Security & Cross-Org Isolation
- **TC-300 - TC-399:** Negative Path / Validations
- **TC-400 - TC-499:** Edge Cases / Boundary Limits
- **TC-500 - TC-599:** UI State & Asynchronous Loading

## Rules
- **Be Exhaustive:** Map every user action, and never assume success.
- **Traceability:** Every test case must trace back to a validated ODC business rule.
- **Normalise Gherkin:** Use consistent, descriptive Gherkin steps that can be easily mapped to Cucumber step definitions.
