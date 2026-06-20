package Utils;

import org.testng.Assert;

import java.nio.file.Path;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class AssertionSheet {

    private final String testClassName;
    private final String testMethodName;

    public AssertionSheet(String testClassName, String testMethodName) {
        this.testClassName = testClassName;
        this.testMethodName = testMethodName;
    }

    private void writeAssertionRow(String step, String expected, String actual, boolean pass) {
        ExtentReportManager.logStep(step, expected, actual, pass);
    }

    public String assertNotBlank(Supplier<String> supplier, String step, String expected) {
        try {
            String value = supplier.get();
            String normalized = value == null ? "" : value.trim();
            boolean pass = !normalized.isBlank();
            writeAssertionRow(step, expected, normalized, pass);
            Assert.assertFalse(normalized.isBlank(), step + " | Expected: " + expected + " | Actual: '" + normalized + "'");
            return normalized;
        } catch (RuntimeException e) {
            String actual = e.getClass().getSimpleName() + ": " + (e.getMessage() == null ? "" : e.getMessage());
            writeAssertionRow(step, expected, actual, false);
            Assert.fail(step + " | Expected: " + expected + " | Actual: " + actual, e);
            return "";
        }
    }

    public String assertNotBlank(Supplier<String> supplier, String step) {
        return assertNotBlank(supplier, step, "Value is not blank");
    }

    public int assertGreaterThanZero(IntSupplier supplier, String step, String expected) {
        try {
            int value = supplier.getAsInt();
            boolean pass = value > 0;
            writeAssertionRow(step, expected, String.valueOf(value), pass);
            Assert.assertTrue(value > 0, step + " | Expected: " + expected + " | Actual: " + value);
            return value;
        } catch (RuntimeException e) {
            String actual = e.getClass().getSimpleName() + ": " + (e.getMessage() == null ? "" : e.getMessage());
            writeAssertionRow(step, expected, actual, false);
            Assert.fail(step + " | Expected: " + expected + " | Actual: " + actual, e);
            return 0;
        }
    }

    public void assertDoesNotThrow(Runnable action, String step, String expected) {
        try {
            action.run();
            writeAssertionRow(step, expected, "No exception", true);
        } catch (RuntimeException e) {
            String actual = e.getClass().getSimpleName() + ": " + (e.getMessage() == null ? "" : e.getMessage());
            writeAssertionRow(step, expected, actual, false);
            Assert.fail(step + " | Expected: " + expected + " | Actual: " + actual, e);
        }
    }

    public void assertTrue(boolean condition, String step, String expected, String actual) {
        writeAssertionRow(step, expected, actual, condition);
        Assert.assertTrue(condition, step + " | Expected: " + expected + " | Actual: " + actual);
    }

    public void assertFalse(boolean condition, String step, String expected, String actual) {
        writeAssertionRow(step, expected, actual, !condition);
        Assert.assertFalse(condition, step + " | Expected: " + expected + " | Actual: " + actual);
    }

    public void assertEquals(String actual, String expected, String step) {
        boolean matches = expected.equals(actual);
        writeAssertionRow(step, expected, actual, matches);
        Assert.assertEquals(actual, expected, step);
    }

    public void assertDisplayed(BooleanSupplier displayedSupplier, String step, String elementName) {
        try {
            boolean displayed = displayedSupplier.getAsBoolean();
            String expected = elementName + " is displayed";
            String actual = elementName + " displayed = " + displayed;
            writeAssertionRow(step, expected, actual, displayed);
            Assert.assertTrue(displayed, step + " | Expected: " + expected + " | Actual: " + actual);
        } catch (RuntimeException e) {
            String expected = elementName + " is displayed";
            String actual = e.getClass().getSimpleName() + ": " + (e.getMessage() == null ? "" : e.getMessage());
            writeAssertionRow(step, expected, actual, false);
            Assert.fail(step + " | Expected: " + expected + " | Actual: " + actual, e);
        }
    }

    public void writeSummary(String finalStatus) {
        boolean pass = "PASSED".equalsIgnoreCase(finalStatus) || "PASS".equalsIgnoreCase(finalStatus);
        writeAssertionRow("Test Result", "Overall test should complete successfully", finalStatus, pass);
    }

    public void save() {
        // Backwards-compatible no-op (suite report is flushed in @AfterSuite).
    }

    public Path getReportPath() {
        return ExtentReportManager.getReportPath();
    }
}
