package Tests;

import Pages.SearchPage;
import org.testng.annotations.Test;

public class Search extends TestBase {
    SearchPage sp;

    @Test
    public void searching() {
        sp = new SearchPage(driver);
        String initialUrl = sp.getCurrentUrl();

        assertionSheet.assertDisplayed(sp::isSearchFieldDisplayed, "Search field visible", "Search field");

        assertionSheet.assertDoesNotThrow(sp::clickOnSearchField, "Open search", "Search field is clickable");

        assertionSheet.assertNotBlank(sp::getDestinationText, "Search suggestion (destination)", "Destination suggestion text is not blank");
        assertionSheet.assertDoesNotThrow(sp::choseDestination, "Choose destination", "Destination suggestion is clickable");
       assertionSheet.assertNotBlank(sp::getWhenText, "Search filters (when)", "When text is not blank");
       assertionSheet.assertNotBlank(sp::getWhoText, "Search filters (who)", "Who text is not blank");

        assertionSheet.assertDisplayed(sp::isSearchButtonDisplayed, "Search button visible", "Search button");

        assertionSheet.assertDoesNotThrow(sp::clickOnSearchButton, "Submit search", "Search button is clickable");
        assertionSheet.assertDoesNotThrow(() -> sp.waitForUrlToChangeFrom(initialUrl), "Wait for navigation", "URL changes after submitting search");

        String currentUrl = sp.getCurrentUrl();
        assertionSheet.assertFalse(currentUrl.equals(initialUrl), "Submit search", "URL changes after search", "Initial URL = '" + initialUrl + "', Current URL = '" + currentUrl + "'");
    }
}
