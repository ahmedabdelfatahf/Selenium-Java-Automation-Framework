package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilVisible(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean isVisibleWithin(By locator, Duration timeout) {
        try {
            waitUntilVisible(locator, timeout);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void click(By locator) {
        waitUntilClickable(locator).click();
    }

    public void write(By locator, String data) {
        WebElement element = waitUntilVisible(locator);
        element.sendKeys(data);
    }

    public void writeNumber(By locator, long data) {
        WebElement element = waitUntilVisible(locator);
        element.sendKeys(String.valueOf(data));
    }

    public String read(By locator) {
        return waitUntilVisible(locator).getText().trim();
    }

    public boolean isDisplayed(By locator) {
        return waitUntilVisible(locator).isDisplayed();
    }

    public String getValue(By locator) {
        return waitUntilVisible(locator).getDomProperty("value");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForUrlToChangeFrom(String oldUrl) {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
    }
    private int getHotelCount(By locator) {
        String text = driver.findElement(locator).getText().trim();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void waitForHotelCountStableFluent(By hotelCountLocator) {

        // Mutable holders to track previous count + stability cycles
        final int[] previousCount = { getHotelCount(hotelCountLocator) };
        final int[] stableCycles  = { 0 };

        System.out.println("Initial Count = " + previousCount[0]);

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))      // max total wait
                .pollingEvery(Duration.ofSeconds(2))    // check every 3s
                .ignoring(Exception.class);

        wait.until(driver -> {

            int currentCount = getHotelCount(hotelCountLocator);

            System.out.println(
                    "Poll → Previous: " + previousCount[0] +
                            " | Current: " + currentCount
            );

            if (currentCount == previousCount[0]) {
                // No change → socket quiet → stability++
                stableCycles[0]++;
                System.out.println("Stable cycles = " + stableCycles[0] + "/3");
            } else {
                // New hotels arrived → reset window
                stableCycles[0] = 0;
                System.out.println("Count increased — resetting stability window");
            }

            previousCount[0] = currentCount;

            // stop only after 3 consecutive stable polls
            return stableCycles[0] >= 3;
        });
        System.out.println("Socket finished — count stable for 2 cycles.");
    }
    // wait for the socket to finish
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
    }
    public boolean selectAvailableDeal() {
        By dealButtons = By.xpath("//div[@class='flex flex-col gap-4']/div/div[2]/div[2]/div[2]/div/button");
        By soldOutMessage = By.xpath("//div[@class='grid w-full min-w-0 flex-1 gap-1 text-start']/div");

        List<WebElement> deals = driver.findElements(dealButtons);

        for (int i = 0; i < deals.size(); i++) {
            deals = driver.findElements(dealButtons);
            WebElement deal = deals.get(i);
               deal.click();
        }
        System.out.println("All deals are sold out.");
        return false;
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return !driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
