package Tests;

import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class RegisterTestCase extends TestBase {
    RegisterPage register;
    Faker fake = new Faker();
    String email = fake.internet().emailAddress();
    String firstName = "ahmed";
    String lastName = "helal";
    String password = "ahmedA@1";

    @Test
    public void registerTestCase() {
        register = new RegisterPage(driver);

        assertionSheet.assertDoesNotThrow(register::goToRegisterPage, "Open register form", "Sign in button is clickable");
        assertionSheet.assertDoesNotThrow(register::emailForm, "Choose email registration", "Email registration option is clickable");

        register.enterEmail(email);
        assertionSheet.assertEquals(register.getEmailValue(), email, "Enter email");

        assertionSheet.assertDoesNotThrow(register::continueAfterEmailToNameForm, "Continue after email", "Redirects to name form (First name field visible)");
        assertionSheet.assertDisplayed(register::isFirstNameFieldDisplayed, "Name form loaded", "First name field");


        register.enterFirstName(firstName);
        assertionSheet.assertEquals(register.getFirstNameValue(), firstName, "Enter first name");
        register.enterLastName(lastName);
        assertionSheet.assertEquals(register.getLastNameValue(), lastName, "Enter last name");
        register.enterPassword(password);
        assertionSheet.assertEquals(register.getPasswordValue(), password, "Enter password");

        assertionSheet.assertDoesNotThrow(register::submitRegistration, "Submit registration", "Agree and continue is clickable");
        assertionSheet.assertNotBlank(register::getAccountName, "Registered state", "Account name text is not blank");
    }
}
