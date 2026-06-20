package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingOverviewPage extends PageBase{
    public BookingOverviewPage(WebDriver driver) {
        super(driver);
    }

By pageName =By.xpath("//div[@class=\"mb-3 hidden items-center gap-3 sm:flex\"]/h2");
By firstName=By.xpath("//div[@class=\"grid grid-cols-1 gap-3 md:grid-cols-2\"]/div[1]/input");
By lastName=By.xpath("//div[@class=\"grid grid-cols-1 gap-3 md:grid-cols-2\"]/div[2]/input");
By email=By.xpath("//div[@class=\"grid grid-cols-1 gap-3\"]/div[1]/input");
By mobileNumberLocater =By.xpath("//div[@class=\"grid grid-cols-1 gap-3\"]/div[2]/div/div/input");
By hotelName=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[1]/div[2]/p");
By roomNameAfterMapping=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[1]/div[2]/h2");
By guestsCount=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[2]/p[2]");
By hotelAddress=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[2]/div");
By checkIn=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[3]/div[1]/p[2]");
By checkOut=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[3]/div[2]/p[2]");
By totalNights=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[4]/p");
By priceBeforeCampaign=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[4]/div/p[1]");
By priceAfterCampaign=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[4]/div/p[2]");
By continueButton=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[1]/div[5]/button");
By mqPoints=By.xpath("//div[@class=\"flex flex-col-reverse gap-4 lg:flex-col\"]/div[2]/div/p");

public void clickOnContinue(){
    click(continueButton);
}
public boolean isPageNameDisplayed() {
        return isDisplayed(pageName);
    }

    public String getPageName() {
        return read(pageName);
    }
    public boolean isFirstNameDisplayed() {
        return isDisplayed(firstName);
    }

    public String getFirstNameValue() {
        return getValue(firstName);
    }

    public boolean isLastNameDisplayed() {
        return isDisplayed(lastName);
    }

    public String getLastNameValue() {
        return getValue(lastName);
    }

    public boolean isEmailDisplayed() {
        return isDisplayed(email);
    }

    public String getEmailValue() {
        return getValue(email);
    }

    public void enterMobileNumber(int mobileNumber){
        writeNumber(mobileNumberLocater, mobileNumber);
    }
    public String getMobileNumberValue() {
        return getValue(mobileNumberLocater);
    }

    public boolean isHotelNameDisplayed() {
        return isDisplayed(hotelName);
    }

    public String getHotelName() {
        return read(hotelName);
    }


    public boolean isRoomNameDisplayed() {
        return isDisplayed(roomNameAfterMapping);
    }

    public String getRoomName() {
        return read(roomNameAfterMapping);
    }

    public boolean isGuestsCountDisplayed() {
        return isDisplayed(guestsCount);
    }

    public String getGuestsCount() {
        return read(guestsCount);
    }
    public boolean isHotelAddressDisplayed() {
        return isDisplayed(hotelAddress);
    }

    public String getHotelAddress() {
        return read(hotelAddress);
    }
    public boolean isCheckInDisplayed() {
        return isDisplayed(checkIn);
    }

    public String getCheckIn() {
        return read(checkIn);
    }
    public boolean isCheckOutDisplayed() {
        return isDisplayed(checkOut);
    }

    public String getCheckOut() {
        return read(checkOut);
    }
    public boolean isTotalNightsDisplayed() {
        return isDisplayed(totalNights);
    }

    public String getTotalNights() {
        return read(totalNights);
    }
    public boolean isPriceBeforeCampaignDisplayed() {
        return isDisplayed(priceBeforeCampaign);
    }

    public String getPriceBeforeCampaign() {
        return read(priceBeforeCampaign);
    }
    public boolean isPriceAfterCampaignDisplayed() {
        return isDisplayed(priceAfterCampaign);
    }

    public String getPriceAfterCampaign() {
        return read(priceAfterCampaign);
    }
    public boolean isMqPointsDisplayed() {
        return isDisplayed(mqPoints);
    }

    public String getMqPoints() {
        return read(mqPoints);
    }
}
