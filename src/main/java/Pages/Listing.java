package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Listing extends PageBase{
    public Listing(WebDriver driver) {
        super(driver);
    }



    By totalNumberOfHotels=By.xpath("//div[@class=\"hidden justify-between sm:flex\"]/div/p");
    By searchedDestination=By.id("search-input");
    By when_Listing= By.xpath("//DIV[@class=\"flex items-center justify-between gap-10\"]/P");
    By who_Listing= By.xpath("//button//DIV[@class=\"flex items-center justify-between\"]/P");
    By defaultSortForCity=By.xpath("//div[@class=\"hidden sm:block\"]//button[@type=\"button\"]/span");
    By hotelName=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/div[2]/div[3]/div[1]/div[1]/h2");
By hotelAddress =By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[2]/DIV/SPAN");
By distanceFromCityCenter=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[2]/p");
   By roomNameBeforeMapping=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[3]/div/p");
    By roomPolicy=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[4]/div[1]/div/div[1]");
    By roomMealBeforeMapping=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[4]/div[1]/div/div[2]");
By selectHotelButton=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[4]/div[2]/div/button");
By totalNights=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[4]/div[2]/div/div/div[1]");
By priceBeforeCampaign= By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[4]/div[2]/div/div/div[2]/div/div[1]");
By priceAfterCampaign= By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV[4]/div[2]/div/div/div[2]/div/div[2]");
By hotelRate=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV/div[2]/div[1]/div[1]/p");
By hotelRateWord=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV/div[2]/div[1]/div[2]/p[1]");
By totalNumberOfReviews=By.xpath("//div[@class=\"flex w-full flex-col items-center gap-4\"]/div[1]/DIV[2]/DIV[3]/DIV/div[2]/div[1]/div[2]/p[2]");

public void waitForSocket(){
waitUntilVisible(totalNumberOfHotels);
    waitForHotelCountStableFluent(totalNumberOfHotels);
}

public boolean isTotalNumberOfHotelsDisplayed() {
    return isDisplayed(totalNumberOfHotels);
}

public String getTotalNumberOfHotelsText() {
    return read(totalNumberOfHotels);
}

public int getTotalNumberOfHotelsValue() {
    String text = getTotalNumberOfHotelsText();
    String digits = text.replaceAll("[^0-9]", "");
    if (digits.isBlank()) {
        return 0;
    }
    return Integer.parseInt(digits);
}

public boolean isSearchedDestinationDisplayed() {
    return isDisplayed(searchedDestination);
}

public String getSearchedDestinationValue() {
    String value = getValue(searchedDestination);
    return value == null ? "" : value.trim();
}

public boolean isSelectHotelButtonDisplayed() {
    return isDisplayed(selectHotelButton);
}

public boolean isHotelNameDisplayed() {
    return isDisplayed(hotelName);
}

public String getHotelName() {
    return read(hotelName);
}

public boolean isHotelAddressDisplayed() {
    return isDisplayed(hotelAddress);
}

public String getHotelAddress() {
    return read(hotelAddress);
}

public boolean isDistanceFromCityCenterDisplayed() {
    return isDisplayed(distanceFromCityCenter);
}

public String getDistanceFromCityCenter() {
    return read(distanceFromCityCenter);
}

public boolean isRoomNameBeforeMappingDisplayed() {
    return isDisplayed(roomNameBeforeMapping);
}

public String getRoomNameBeforeMapping() {
    return read(roomNameBeforeMapping);
}

public boolean isRoomPolicyDisplayed() {
    return isDisplayed(roomPolicy);
}

public String getRoomPolicy() {
    return read(roomPolicy);
}

public boolean isRoomMealBeforeMappingDisplayed() {
    return isDisplayed(roomMealBeforeMapping);
}

public String getRoomMealBeforeMapping() {
    return read(roomMealBeforeMapping);
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
    return isDisplayed(when_Listing);
}

public String getWhenText() {
    return read(when_Listing);
}

public boolean isWhoDisplayed() {
    return isDisplayed(who_Listing);
}

public String getWhoText() {
    return read(who_Listing);
}

public boolean isDefaultSortDisplayed() {
    return isDisplayed(defaultSortForCity);
}

public String getDefaultSortText() {
    return read(defaultSortForCity);
}



public void choseHotel(){
    click(selectHotelButton);
}















}
