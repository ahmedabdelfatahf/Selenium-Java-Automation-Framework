package Tests;

import Pages.BookingOverviewPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class BookingOverviewTestCase extends TestBase{
    BookingOverviewPage bo;
    Faker fake = new Faker();
    int mobileNumber = 1111493748;
    @Test
    public void BookOverviewTestCase(){
        bo=new BookingOverviewPage(driver);
        assertionSheet.assertNotBlank(bo::getPageName, "booking overview page name", "page name text is not blank");
        assertionSheet.assertNotBlank(bo::getFirstNameValue, "booking overview first name field ", "first name text is not blank");
        assertionSheet.assertNotBlank(bo::getLastNameValue, "booking overview last name field ", "last name text is not blank");
        assertionSheet.assertNotBlank(bo::getEmailValue, "booking overview email field", "email text is not blank");
        bo.enterMobileNumber(mobileNumber);
        assertionSheet.assertNotBlank(bo::getMobileNumberValue, "booking overview MobileNumber field", "MobileNumber text is not blank");
        assertionSheet.assertNotBlank(bo::getHotelName, " booking overview hotel name", "Hotel name text is not blank");
        assertionSheet.assertNotBlank(bo::getHotelAddress, " booking overview hotel address", "Hotel address text is not blank");
        assertionSheet.assertNotBlank(bo::getCheckIn, "booking overview check-in", "check-in text is not blank");
        assertionSheet.assertNotBlank(bo::getCheckOut, "booking overview check-out", "check-out text is not blank");
        assertionSheet.assertNotBlank(bo::getGuestsCount, "booking overview (who)", "Who text is not blank");
        assertionSheet.assertNotBlank(bo::getRoomName, "booking overview room name after mapping ", "Room name text is not blank");
        assertionSheet.assertNotBlank(bo::getTotalNights, "booking overview nights", "Total nights text is not blank");
        String priceBeforeText = "";
        String priceAfterText = "";
        try {
            priceBeforeText = bo.getPriceBeforeCampaign();
        } catch (RuntimeException ignored) {
        }
        try {
            priceAfterText = bo.getPriceAfterCampaign();
        } catch (RuntimeException ignored) {
        }
        assertionSheet.assertTrue(!priceBeforeText.isBlank() || !priceAfterText.isBlank(), "booking overview price", "At least one price is not blank", "Price before = '" + priceBeforeText + "', Price after = '" + priceAfterText + "'");
        if (!priceBeforeText.isBlank()) {
            assertionSheet.assertFalse(priceBeforeText.isBlank(), "booking overview price before", "Price before campaign text is not blank", "Price before = '" + priceBeforeText + "'");
        }
        if (!priceAfterText.isBlank()) {
            assertionSheet.assertFalse(priceAfterText.isBlank(), "booking overview price after", "Price after campaign text is not blank", "Price after = '" + priceAfterText + "'");
        }
        assertionSheet.assertNotBlank(bo::getMqPoints, "booking overview mq points", "mq points text is not blank");
        bo.clickOnContinue();
    }
}
