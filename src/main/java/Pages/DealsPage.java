package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class DealsPage extends PageBase{
By hotelNameDeals=By.xpath("//section[@class=\"mb-6 flex w-full items-center justify-between gap-4\"]/div/h1");
By hotelAddress=By.xpath("//div[@class=\"mt-2 hidden items-center md:flex\"]/p");
By hotelRateWord=By.xpath("//div[@class=\"hidden md:block\"]/div/div/div[2]/p[1]");
By totalNumberOfReviews=By.xpath("//div[@class=\"hidden md:block\"]/div/div/div[2]/p[2]");
By hotelRate=By.xpath("//div[@class=\"hidden md:block\"]/div/div/div[1]/p");
By when =By.xpath("//header[@class=\"relative mb-4\"]/div/div[1]/div[2]/div/button/div/div/p");

By who=By.xpath("//header[@class=\"relative mb-4\"]/div/div[3]/div[2]/button/div/p");

By roomNameAfterMapping=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[1]/h3");

By roomMeal=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/label[1]/span");
By roomPolicy=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/label[1]/span");
By bookNowButton=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[2]/div[2]/div/button");
By totalNights=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[2]/div[2]/div/div/p[1]");
By priceBeforeCampaign=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[2]/div[2]/div/div/p[2]/span[1]");
By priceAfterCampaign=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[1]/div[2]/div[2]/div[2]/div/div/p[2]/span[2]");
By notificationAlert=By.xpath("//div[@class=\"text-center\"]/div/button[2]");
    By dealBookNowButtons = By.xpath("//div[@class='flex flex-col gap-4']/div/div[2]/div[2]/div[2]/div/button");
    By soldOutMessage = By.xpath("//div[@class='grid w-full min-w-0 flex-1 gap-1 text-start']/div");
    ArrayList<String> taps;
    public DealsPage(WebDriver driver) {
        super(driver);
    }

public void moveToTheNextTap() {
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    taps = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(taps.get(1));
}

public void waitForDealsLoaded() {
    waitUntilVisible(hotelNameDeals);
}

public boolean isHotelNameDisplayed() {
    return isDisplayed(hotelNameDeals);
}

public String getHotelName() {
   return read(hotelNameDeals);
}

public boolean isHotelAddressDisplayed() {
    return isDisplayed(hotelAddress);
}

public String getHotelAddressText() {
    return read(hotelAddress);
}

public boolean isHotelRateDisplayed() {
    return isDisplayed(hotelRate);
}

public String getHotelRateText() {
    return read(hotelRate);
}

public boolean isHotelRateWordDisplayed() {
    return isDisplayed(hotelRateWord);
}

public String getHotelRateWordText() {
    return read(hotelRateWord);
}

public boolean isTotalNumberOfReviewsDisplayed() {
    return isDisplayed(totalNumberOfReviews);
}

public String getTotalNumberOfReviewsText() {
    return read(totalNumberOfReviews);
}

public boolean isWhenDisplayed() {
    return isDisplayed(when);
}

public String getWhenText() {
    return read(when);
}

public boolean isWhoDisplayed() {
    return isDisplayed(who);
}

public String getWhoText() {
    return read(who);
}

public boolean isRoomNameAfterMappingDisplayed() {
    return isDisplayed(roomNameAfterMapping);
}

public String getRoomNameAfterMappingText() {
    return read(roomNameAfterMapping);
}

public boolean isRoomMealDisplayed() {
    return isDisplayed(roomMeal);
}

public String getRoomMealText() {
    return read(roomMeal);
}

public boolean isRoomPolicyDisplayed() {
    return isDisplayed(roomPolicy);
}

public String getRoomPolicyText() {
    return read(roomPolicy);
}

public boolean isBookNowButtonDisplayed() {
    return isDisplayed(bookNowButton);
}

public String getBookNowButtonText() {
    return read(bookNowButton);
}
public void bookNow(){
        click(bookNowButton);
}
public boolean isTotalNightsDisplayed() {
    return isDisplayed(totalNights);
}

public String getTotalNightsText() {
    return read(totalNights);
}

public boolean isPriceBeforeCampaignDisplayed() {
    return isDisplayed(priceBeforeCampaign);
}

public String getPriceBeforeCampaignText() {
    return read(priceBeforeCampaign);
}

public boolean isPriceAfterCampaignDisplayed() {
    return isDisplayed(priceAfterCampaign);
}

public String getPriceAfterCampaignText() {
    return read(priceAfterCampaign);
}

// Backwards compatibility with older tests
public String hotelName() {
    return getHotelName();
}
//public void scrollToBookNowButton(){
//        scrollToElement(bookNowButton);
//}
public void bookNowAndSoldOutLogic(){
    java.util.List<org.openqa.selenium.WebElement> bookNowButtons = driver.findElements(dealBookNowButtons);

    for (int i = 0; i < bookNowButtons.size(); i++) {
        bookNowButtons = driver.findElements(dealBookNowButtons);
        org.openqa.selenium.WebElement currentBookNowButton = bookNowButtons.get(i);
        String currentUrl = driver.getCurrentUrl();

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", currentBookNowButton);
        wait.until(ExpectedConditions.elementToBeClickable(currentBookNowButton)).click();

        try {
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(4))
                    .until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
            return;
        } catch (org.openqa.selenium.TimeoutException ignored) {
        }

        if (!isElementDisplayed(soldOutMessage)) {
            return;
        }
    }

    throw new RuntimeException("All deals are sold out.");
}
public  void skipNotification(){
        click(notificationAlert);
}
}
