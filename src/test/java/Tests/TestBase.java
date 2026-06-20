package Tests;

import Utils.AssertionSheet;
import Utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

private static final String URL = "https://v5.macqueen.co/en";
protected static WebDriver driver;
protected AssertionSheet assertionSheet;
private static final ThreadLocal<TestInfo> currentTest = new ThreadLocal<>();
private static final DateTimeFormatter FILE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

private static final class TestInfo {
    private final String testClassName;
    private final String testMethodName;

    private TestInfo(String testClassName, String testMethodName) {
        this.testClassName = testClassName;
        this.testMethodName = testMethodName;
    }
}

@BeforeSuite(alwaysRun = true)
@Parameters({"suiteName"})
public void setUp(@Optional("MacqueenSuite") String suiteName) {
    ExtentReportManager.init(suiteName);

    if (driver != null) {
        return;
    }

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get(URL);
}
@BeforeMethod(alwaysRun = true)
    public void createAssertionSheet(Method method){
    currentTest.set(new TestInfo(getClass().getSimpleName(), method.getName()));
    ExtentReportManager.startTest(getClass().getSimpleName(), method.getName());
    assertionSheet = new AssertionSheet(getClass().getSimpleName(), method.getName());
}
@AfterMethod(alwaysRun = true)
    public void saveAssertionSheet(ITestResult result){
    if (assertionSheet == null){
        return;
    }
    assertionSheet.writeSummary(result.isSuccess() ? "PASSED" : "FAILED");
    if (!result.isSuccess()) {
        Path screenshotPath = tryCaptureScreenshot(getClass().getSimpleName(), result.getMethod().getMethodName());
        if (screenshotPath != null) {
            ExtentReportManager.attachScreenshot("Failure screenshot", screenshotPath);
        }
    }
    ExtentReportManager.clearCurrentTest();
    currentTest.remove();
}

@AfterSuite(alwaysRun = true)
public void tearDown() {
    if (driver != null) {
        driver.quit();
        driver = null;
    }
    ExtentReportManager.flush();
}

private static Path tryCaptureScreenshot(String testClassName, String testMethodName) {
    if (driver == null) {
        return null;
    }
    if (!(driver instanceof TakesScreenshot takesScreenshot)) {
        return null;
    }

    byte[] bytes;
    try {
        bytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
    } catch (RuntimeException e) {
        return null;
    }

    Path directory = Paths.get("target", "reports", "screenshots");
    try {
        Files.createDirectories(directory);
    } catch (IOException e) {
        return null;
    }

    String fileName = testClassName + "_" + testMethodName + "_" + LocalDateTime.now().format(FILE_TIME_FORMAT) + ".png";
    Path path = directory.resolve(fileName);
    try {
        Files.write(path, bytes);
        return path;
    } catch (IOException e) {
        return null;
    }
}
}
