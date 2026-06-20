package Tests;

import Pages.DealsPage;
import org.testng.annotations.Test;

public class DealsTestCase extends TestBase{
    DealsPage dp ;
    @Test
    public void dealTest(){
        dp=new DealsPage(driver);

        assertionSheet.assertDoesNotThrow(dp::moveToTheNextTap, "Switch to deals tab", "New tab is opened and switched");
        assertionSheet.assertDoesNotThrow(dp::waitForDealsLoaded, "Deals page loaded", "Deals header is visible");

        assertionSheet.assertNotBlank(dp::getHotelName, "Deals hotel name", "Hotel name text is not blank");
        assertionSheet.assertNotBlank(dp::getHotelAddressText, "Deals hotel address", "Hotel address text is not blank");

        assertionSheet.assertNotBlank(dp::getWhenText, "Deals filters (when)", "When text is not blank");
        assertionSheet.assertNotBlank(dp::getWhoText, "Deals filters (who)", "Who text is not blank");

        assertionSheet.assertNotBlank(dp::getRoomNameAfterMappingText, "Deals room name", "Room name text is not blank");
        assertionSheet.assertNotBlank(dp::getRoomMealText, "Deals room meal", "Room meal text is not blank");
        assertionSheet.assertNotBlank(dp::getRoomPolicyText, "Deals room policy", "Room policy text is not blank");

        assertionSheet.assertNotBlank(dp::getTotalNightsText, "Deals total nights", "Total nights text is not blank");

        String priceBeforeText = "";
        String priceAfterText = "";
        try {
            priceBeforeText = dp.getPriceBeforeCampaignText();
        } catch (RuntimeException ignored) {
        }
        try {
            priceAfterText = dp.getPriceAfterCampaignText();
        } catch (RuntimeException ignored) {
        }
        assertionSheet.assertTrue(!priceBeforeText.isBlank() || !priceAfterText.isBlank(), "Deals price", "At least one price is not blank", "Price before = '" + priceBeforeText + "', Price after = '" + priceAfterText + "'");
        if (!priceBeforeText.isBlank()) {
            assertionSheet.assertFalse(priceBeforeText.isBlank(), "Deals price before", "Price before campaign text is not blank", "Price before = '" + priceBeforeText + "'");
        }
        if (!priceAfterText.isBlank()) {
            assertionSheet.assertFalse(priceAfterText.isBlank(), "Deals price after", "Price after campaign text is not blank", "Price after = '" + priceAfterText + "'");
        }

        assertionSheet.assertNotBlank(dp::getHotelRateText, "Deals hotel rate", "Hotel rate text is not blank");
        assertionSheet.assertNotBlank(dp::getHotelRateWordText, "Deals hotel rate word", "Hotel rate word text is not blank");
        assertionSheet.assertNotBlank(dp::getTotalNumberOfReviewsText, "Deals reviews", "Total reviews text is not blank");
        dp.skipNotification();
        assertionSheet.assertNotBlank(dp::getBookNowButtonText, "Deals book now", "Book now button text is not blank");

        dp.bookNowAndSoldOutLogic();
    }


}
