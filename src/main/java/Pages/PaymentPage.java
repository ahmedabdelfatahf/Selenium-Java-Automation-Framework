package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends PageBase{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

By Use_a_new_card_button=By.xpath("//div[@class=\"flex flex-col gap-4\"]/div[3]/div/button");

By cardNumber=By.cssSelector("iframe[data-testid=\"card-number\"]");
By cardExpiryDate=By.cssSelector("iframe[data-testid=\"card-expiry-date\"]");
By cardCvv=By.cssSelector("iframe[data-testid=\"card-cvv\"]");
By saveCardWeb=By.xpath("//div[@class=\"flex items-center gap-2\"]/button[@type=\"button\"]");
By pageName=By.xpath("//div[@class=\"flex items-center gap-3\"]/h3");
By hotelName=By.xpath("//div[@class=\"flex flex-col\"]/p");
By roomName=By.xpath("//div[@class=\"flex flex-col\"]/h3");
By numberOfGuests=By.xpath("//div[@class=\"flex flex-col gap-1\"]/p[2]");
By CheckIn=By.xpath("//div[@class=\"flex text-sm\"]/div[1]/p[2]");
By CheckOut=By.xpath("//div[@class=\"flex text-sm\"]/div[2]/p[2]");
By OriginalPrice=By.xpath("//div[@class=\"flex flex-col gap-4 border-b pb-3\"]/div/div[1]/span[2]");
By MacQueenDiscount=By.xpath("//div[@class=\"flex flex-col gap-4 border-b pb-3\"]/div/div[2]/span[2]");
By priceBeforeCampaign=By.xpath("//div[@class=\"flex flex-col font-semibold\"]/P[1]");
By priceAfterCampaign=By.xpath("//div[@class=\"flex flex-col font-semibold\"]/P[2]");
By PROCEED=By.xpath("//div[@class=\"flex flex-col gap-4 rounded-lg bg-white p-6 shadow-[0_0_12px_rgba(0,0,0,0.1)]\"]/button");
By cancellationPolicy=By.xpath("//ul[@class=\"flex flex-col gap-2\"]/li[3]/span/span");

public void addNewCard()
{
    click(Use_a_new_card_button);
}

public void enterCardNumber(long CardNumber)
{
    writeNumber(cardNumber,CardNumber);
}

public void enterCardExpiryDate(String CardExpiryDate)
{
    write(cardExpiryDate,CardExpiryDate);
}
public void enterCardCvv(long CardCvv)
    {
        writeNumber(cardCvv,CardCvv);
    }

    public void SaveCardForFuturePurchases(){
    click(saveCardWeb);
    }
public void clickPaymentButton()
{
    click(PROCEED);
}

public boolean isUseNewCardButtonDisplayed() {
    return isDisplayed(Use_a_new_card_button);
}

public boolean isCardNumberDisplayed() {
    return isDisplayed(cardNumber);
}

public String getCardNumberValue() {
    return getValue(cardNumber);
}

public boolean isCardExpiryDateDisplayed() {
    return isDisplayed(cardExpiryDate);
}

public String getCardExpiryDateValue() {
    return getValue(cardExpiryDate);
}

public boolean isCardCvvDisplayed() {
    return isDisplayed(cardCvv);
}

public String getCardCvvValue() {
    return getValue(cardCvv);
}

public boolean isSaveCardButtonDisplayed() {
    return isDisplayed(saveCardWeb);
}

public boolean isPageNameDisplayed() {
    return isDisplayed(pageName);
}

public String getPageName() {
    return read(pageName);
}

public String getHotelName() {
    return read(hotelName);
}

public String getRoomName() {
    return read(roomName);
}

public String getNumberOfGuests() {
    return read(numberOfGuests);
}

public String getCheckIn() {
    return read(CheckIn);
}

public String getCheckOut() {
    return read(CheckOut);
}

public String getOriginalPrice() {
    return read(OriginalPrice);
}

public String getMacQueenDiscount() {
    return read(MacQueenDiscount);
}

public String getPriceBeforeCampaign() {
    return read(priceBeforeCampaign);
}

public String getPriceAfterCampaign() {
    return read(priceAfterCampaign);
}

public boolean isProceedButtonDisplayed() {
    return isDisplayed(PROCEED);
}

public String getCancellationPolicy() {
    return read(cancellationPolicy);
}

}
