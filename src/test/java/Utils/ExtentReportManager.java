package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExtentReportManager {

    private static final DateTimeFormatter FILE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    private static ExtentReports extent;
    private static Path reportPath;

    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    private ExtentReportManager() {
    }

    public static synchronized void init(String suiteName) {
        if (extent != null) {
            return;
        }

        Path directory = Paths.get("target", "reports");
        try {
            Files.createDirectories(directory);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create report directory.", e);
        }

        String safeSuiteName = suiteName == null || suiteName.isBlank()
                ? "Suite"
                : suiteName.trim().replaceAll("\\s+", "_");

        reportPath = directory.resolve("TestReport_" + safeSuiteName + "_" + LocalDateTime.now().format(FILE_TIME_FORMAT) + ".html");

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath.toString());
        spark.config().setDocumentTitle("Test Report");
        spark.config().setReportName(safeSuiteName);

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static synchronized Path getReportPath() {
        return reportPath;
    }

    public static ExtentTest startTest(String testClassName, String testMethodName) {
        if (extent == null) {
            init("Suite");
        }
        ExtentTest test = extent.createTest(testClassName + "." + testMethodName);
        currentTest.set(test);
        return test;
    }

    public static ExtentTest getCurrentTest() {
        return currentTest.get();
    }

    public static void clearCurrentTest() {
        currentTest.remove();
    }

    public static void logStep(String step, String expected, String actual, boolean pass) {
        ExtentTest test = getCurrentTest();
        if (test == null) {
            return;
        }

        String message = step
                + " | Expected: " + nullToEmpty(expected)
                + " | Actual: " + nullToEmpty(actual);

        if (pass) {
            test.pass(message);
        } else {
            test.fail(message);
        }
    }

    public static void attachScreenshot(String title, Path screenshotPath) {
        ExtentTest test = getCurrentTest();
        if (test == null || screenshotPath == null) {
            return;
        }

        test.addScreenCaptureFromPath(screenshotPath.toString(), title);
    }

    public static synchronized void flush() {
        if (extent == null) {
            return;
        }
        try {
            extent.flush();
        } finally {
            extent = null;
            reportPath = null;
        }
    }

    private static String nullToEmpty(String value) {
        return value == null ? "" : value;
    }
}

