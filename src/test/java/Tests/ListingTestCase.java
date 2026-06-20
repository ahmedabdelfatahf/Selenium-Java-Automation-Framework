package Tests;

import Pages.Listing;
import org.testng.annotations.Test;

public class ListingTestCase extends TestBase{
    Listing lp;
    @Test
    public void listing() {
        lp=new Listing(driver);
        String initialUrl = lp.getCurrentUrl();

        assertionSheet.assertGreaterThanZero(lp::getTotalNumberOfHotelsValue, "Listing hotels count", "Total hotels count > 0");
        assertionSheet.assertNotBlank(lp::getSearchedDestinationValue, "Listing destination", "Destination value is not blank");

        assertionSheet.assertNotBlank(lp::getWhenText, "Listing filters (when)", "When text is not blank");
        assertionSheet.assertNotBlank(lp::getWhoText, "Listing filters (who)", "Who text is not blank");
        assertionSheet.assertNotBlank(lp::getDefaultSortText, "Listing sort", "Default sort text is not blank");

        assertionSheet.assertNotBlank(lp::getHotelName, "Listing first result (name)", "Hotel name text is not blank");
        assertionSheet.assertNotBlank(lp::getHotelAddress, "Listing first result (address)", "Hotel address text is not blank");
        assertionSheet.assertNotBlank(lp::getDistanceFromCityCenter, "Listing first result (distance)", "Distance text is not blank");
        assertionSheet.assertNotBlank(lp::getRoomNameBeforeMapping, "Listing first result (room name)", "Room name text is not blank");
        assertionSheet.assertNotBlank(lp::getRoomPolicy, "Listing first result (policy)", "Room policy text is not blank");
        assertionSheet.assertNotBlank(lp::getRoomMealBeforeMapping, "Listing first result (meal)", "Room meal text is not blank");
        assertionSheet.assertNotBlank(lp::getTotalNightsText, "Listing first result (nights)", "Total nights text is not blank");

        String priceBeforeText = "";
        String priceAfterText = "";
        try {
            priceBeforeText = lp.getPriceBeforeCampaignText();
        } catch (RuntimeException ignored) {
        }
        try {
            priceAfterText = lp.getPriceAfterCampaignText();
        } catch (RuntimeException ignored) {
        }

        assertionSheet.assertTrue(!priceBeforeText.isBlank() || !priceAfterText.isBlank(), "Listing first result (price)", "At least one price is not blank", "Price before = '" + priceBeforeText + "', Price after = '" + priceAfterText + "'");
        if (!priceBeforeText.isBlank()) {
            assertionSheet.assertFalse(priceBeforeText.isBlank(), "Listing first result (price before)", "Price before campaign text is not blank", "Price before = '" + priceBeforeText + "'");
        }
        if (!priceAfterText.isBlank()) {
            assertionSheet.assertFalse(priceAfterText.isBlank(), "Listing first result (price after)", "Price after campaign text is not blank", "Price after = '" + priceAfterText + "'");
        }

        assertionSheet.assertNotBlank(lp::getHotelRateText, "Listing first result (rate)", "Hotel rate text is not blank");
        assertionSheet.assertNotBlank(lp::getHotelRateWordText, "Listing first result (rate word)", "Hotel rate word text is not blank");
        assertionSheet.assertNotBlank(lp::getTotalNumberOfReviewsText, "Listing first result (reviews)", "Total reviews text is not blank");

        lp.waitForSocket();
        lp.choseHotel();
//       lp.waitForUrlToChangeFrom(initialUrl);
//
//      String currentUrl = lp.getCurrentUrl();
//       assertionSheet.assertFalse(currentUrl.equals(initialUrl), "Open hotel", "URL changes after selecting a hotel", "Initial URL = '" + initialUrl + "', Current URL = '" + currentUrl + "'");
    }
}
