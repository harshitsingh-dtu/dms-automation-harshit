# Ostra DMS Automation Project Instructions

## dms-automation test healing

- This repository has a custom subagent, `odc-healer`, defined at `.gemini/agents/odc-healer.md`. Use it (or let it auto-delegate) for any requests to fix, debug, or heal failing Cucumber/Serenity BDD test cases.
- Its knowledge base lives in `odc-healer-memory/` (`fix-patterns.md`, `session-log.md`, and the `archive/` folder) — this is a project-shared, version-controlled learning log. Commit changes to it like any other source file.
- Functional/business context for the application under test lives in `application_knowledge.md` and `.gemini/Skills/odc-domain/`. `odc-healer` is required to read it before changing any assertion, so it does not confuse a real product behavior change with a test defect.
- Non-negotiable framework rules (apply outside the healer too):
  - No `Thread.sleep` — use Serenity `WebElementFacade` fluent waits.
  - No swallowed exceptions — log + `Assert.fail(...)`.
  - JDK 17 is strictly required to compile and run even though source/target is 1.8.
  - Never hardcode credentials or URLs in Java code — they belong in `serenity.conf`.
