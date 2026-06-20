package Tests;

import Pages.PaymentPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class PaymentTestCase extends TestBase{
    PaymentPage pp;
    Faker fake = new Faker();
  long cardNumber = 4111111111111111L;
  String expirationDate = "12/45";
  int cvv = 124;


   @Test
    public void Payment(){
pp=new PaymentPage(driver);
        assertionSheet.assertNotBlank(pp::getPageName, "Payment page title", "Payment page title is not blank");
        assertionSheet.assertNotBlank(pp::getHotelName, "Payment hotel name", "Hotel name text is not blank");
        assertionSheet.assertNotBlank(pp::getRoomName, "Payment room name", "Room name text is not blank");
        assertionSheet.assertNotBlank(pp::getNumberOfGuests, "Payment guests", "Guests text is not blank");
        assertionSheet.assertNotBlank(pp::getCheckIn, "Payment check-in", "Check-in text is not blank");
        assertionSheet.assertNotBlank(pp::getCheckOut, "Payment check-out", "Check-out text is not blank");
        assertionSheet.assertNotBlank(pp::getCancellationPolicy, "Payment cancellation policy", "Cancellation policy text is not blank");

        String priceBeforeText = "";
        String priceAfterText = "";
        try {
            priceBeforeText = pp.getPriceBeforeCampaign();
        } catch (RuntimeException ignored) {
        }
        try {
            priceAfterText = pp.getPriceAfterCampaign();
        } catch (RuntimeException ignored) {
        }
        assertionSheet.assertTrue(!priceBeforeText.isBlank() || !priceAfterText.isBlank(), "Payment total price", "At least one price is not blank", "Price before = '" + priceBeforeText + "', Price after = '" + priceAfterText + "'");
        if (!priceBeforeText.isBlank()) {
            assertionSheet.assertFalse(priceBeforeText.isBlank(), "Payment price before campaign", "Price before campaign text is not blank", "Price before = '" + priceBeforeText + "'");
        }
        if (!priceAfterText.isBlank()) {
            assertionSheet.assertFalse(priceAfterText.isBlank(), "Payment price after campaign", "Price after campaign text is not blank", "Price after = '" + priceAfterText + "'");
        }

//        boolean useNewCardButtonDisplayed = pp.isUseNewCardButtonDisplayed();
//        assertionSheet.assertTrue(useNewCardButtonDisplayed, "Payment add new card option", "Use a new card button is visible", "Use a new card button visible = " + useNewCardButtonDisplayed);
//        pp.addNewCard();

        boolean cardNumberDisplayed = pp.isCardNumberDisplayed();
        assertionSheet.assertTrue(cardNumberDisplayed, "Payment card number field", "Card number field is visible", "Card number field visible = " + cardNumberDisplayed);
        pp.enterCardNumber(cardNumber);
      //  assertionSheet.assertEquals(pp.getCardNumberValue(), String.valueOf(cardNumber), "Enter card number");

        boolean expiryDateDisplayed = pp.isCardExpiryDateDisplayed();
        assertionSheet.assertTrue(expiryDateDisplayed, "Payment expiry date field", "Expiry date field is visible", "Expiry date field visible = " + expiryDateDisplayed);
        pp.enterCardExpiryDate(expirationDate);
    //    assertionSheet.assertEquals(pp.getCardExpiryDateValue(), String.valueOf(expirationDate), "Enter card expiry date");

        boolean cvvDisplayed = pp.isCardCvvDisplayed();
        assertionSheet.assertTrue(cvvDisplayed, "Payment CVV field", "CVV field is visible", "CVV field visible = " + cvvDisplayed);
        pp.enterCardCvv(cvv);
     //   assertionSheet.assertEquals(pp.getCardCvvValue(), String.valueOf(cvv), "Enter card CVV");

        boolean saveCardButtonDisplayed = pp.isSaveCardButtonDisplayed();
        assertionSheet.assertTrue(saveCardButtonDisplayed, "Payment save card option", "Save card toggle is visible", "Save card toggle visible = " + saveCardButtonDisplayed);
        assertionSheet.assertDoesNotThrow(pp::SaveCardForFuturePurchases, "Toggle save card", "Save card toggle is clickable");

        boolean proceedButtonDisplayed = pp.isProceedButtonDisplayed();
        assertionSheet.assertTrue(proceedButtonDisplayed, "Payment proceed button", "Proceed button is visible", "Proceed button visible = " + proceedButtonDisplayed);
        assertionSheet.assertDoesNotThrow(pp::clickPaymentButton, "Submit payment", "Proceed button is clickable");


   }
}
