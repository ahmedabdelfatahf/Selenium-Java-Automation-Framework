# Running tests + HTML report

## Run (Maven)

This project uses **TestNG** and generates an **HTML report** (ExtentReports) under `target/reports/`.

Example (run the registered suite profile):

```bash
mvn test -P register-search-listing
```

This profile runs the TestNG suite file `src/test/resources/testng-register-search-listing.xml` (Register → Search → Listing → Deals).

## Common “unknown” errors

- If you see something like `UnknownHostException: testng.org` while running the XML: the suite file should not reference the online DTD. (This repo’s XML no longer includes the external `<!DOCTYPE ...>` line.)
- If Maven says `Unknown lifecycle phase ...`: make sure you run `mvn test -P register-search-listing` (the `-P` is required).
- If you see `java.lang.ExceptionInInitializerError` with `com.sun.tools.javac.code.TypeTag :: UNKNOWN`: it’s usually a **JDK/toolchain mismatch** (e.g., compiling with Java 25). This project targets Java `17` (see `pom.xml`). In IntelliJ set:
  - Project SDK = 17
  - Settings → Build Tools → Maven → JDK = 17

## Output

- HTML report: `target/reports/TestReport_<suiteName>_<timestamp>.html`
- Failure screenshots: `target/reports/screenshots/*.png`

## Writing step assertions

Use `assertionSheet` in your test methods to log **step name + expected + actual + PASS/FAIL** into the HTML report:

- `assertionSheet.assertDisplayed(page::isSearchFieldDisplayed, "Search field visible", "Search field");`
- `assertionSheet.assertEquals(actual, expected, "Step name");`
- `assertionSheet.assertDoesNotThrow(action, "Step name", "Expected behavior");`
