package Tests;

import Pages.loginPage;
import org.testng.annotations.Test;

public class LoginTestCase extends TestBase {
    int phoneNumber = 1111493748;
    String password = "ahmedA@1";
    loginPage login;

    @Test
    public void tc1() {
        login = new loginPage(driver);

        boolean signInButtonDisplayed = login.isSignInButtonDisplayed();
        assertionSheet.assertTrue(signInButtonDisplayed, "Home page load", "Sign in button is visible", "Sign in button visible = " + signInButtonDisplayed);
        login.goToLoginPage();

        boolean phoneNumberFieldDisplayed = login.isPhoneNumberFieldDisplayed();
        assertionSheet.assertTrue(phoneNumberFieldDisplayed, "Open login form", "Phone number field is visible", "Phone number field visible = " + phoneNumberFieldDisplayed);

        boolean continueButtonDisplayed = login.isContinueButtonDisplayed();
        assertionSheet.assertTrue(continueButtonDisplayed, "Login phone step", "Continue button is visible", "Continue button visible = " + continueButtonDisplayed);

        login.enterPhoneNumber(phoneNumber);
        assertionSheet.assertEquals(login.getPhoneNumberValue(), String.valueOf(phoneNumber), "Enter phone number");

        login.continueAfterPhoneNumber();

        boolean passwordFieldDisplayed = login.isPasswordFieldDisplayed();
        assertionSheet.assertTrue(passwordFieldDisplayed, "Move to password step", "Password field is visible", "Password field visible = " + passwordFieldDisplayed);

        boolean submitLoginButtonDisplayed = login.isSubmitLoginButtonDisplayed();
        assertionSheet.assertTrue(submitLoginButtonDisplayed, "Login password step", "Submit login button is visible", "Submit login button visible = " + submitLoginButtonDisplayed);

        login.enterPassword(password);
        assertionSheet.assertEquals(login.getPasswordValue(), password, "Enter password");

        login.submitLogin();

        boolean accountNameDisplayed = login.isAccountNameDisplayed();
        assertionSheet.assertTrue(accountNameDisplayed, "Submit login", "Account name is visible after login", "Account name visible = " + accountNameDisplayed);

        String accountName = login.getAccountName();
        assertionSheet.assertFalse(accountName.isBlank(), "Logged in state", "Account name text is not blank", "Account name text = '" + accountName + "'");
    }
}
