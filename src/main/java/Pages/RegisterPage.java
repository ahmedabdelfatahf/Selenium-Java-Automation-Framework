package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By signInElement = By.xpath("//DIV[@class=\"w-full bg-white\"]/DIV/DIV/DIV[2]/DIV/BUTTON");
    By emailElement = By.xpath("//DIV[@class=\"flex flex-col items-center gap-5\"]/DIV[1]/BUTTON[2]");
    By emailField = By.xpath("//DIV[@class=\"flex w-full flex-col gap-1\"]/input");
    By continueButton = By.xpath("//DIV[@class=\"flex flex-col items-center gap-5\"]/button");
    By firstName = By.xpath("//div[@class=\"relative top-1.5 flex w-full\"]/input[@id=\"firstName\"]");
    By lastName = By.xpath("//div[@class=\"relative top-1.5 flex w-full\"]/input[@id=\"lastName\"]");
    By passwordElement = By.xpath("//div[@class=\"relative top-1.5 flex w-full\"]/input[@id=\"password\"]");
    By agreeAndContinue = By.xpath("//form[@class=\"flex w-full max-w-96 flex-col gap-3\"]/button");
    By accountName = By.xpath("//button[@id=\"nav-in-button\"]/div/p[2]");

    public boolean isSignInButtonDisplayed() {
        return isDisplayed(signInElement);
    }

    public void goToRegisterPage() {
        click(signInElement);
    }

    public boolean isEmailOptionDisplayed() {
        return isDisplayed(emailElement);
    }

    public void emailForm() {
        click(emailElement);
    }

    public boolean isEmailFieldDisplayed() {
        return isDisplayed(emailField);
    }

    public boolean isContinueButtonDisplayed() {
        return isDisplayed(continueButton);
    }

    public void enterEmail(String email) {
        write(emailField, email);
    }

    public String getEmailValue() {
        return getValue(emailField);
    }

    public void continueAfterEmail() {
        click(continueButton);
    }

    /**
     * Some runs intermittently "stick" after clicking Continue. This helper retries the click once
     * if the first-name field doesn't appear quickly, then waits for the name form to load.
     */
    public void continueAfterEmailToNameForm() {
        click(continueButton);

        if (!isVisibleWithin(firstName, Duration.ofSeconds(5))) {
            click(continueButton);
        }

        waitUntilVisible(firstName, Duration.ofSeconds(30));
    }

    public boolean isFirstNameFieldDisplayed() {
        return isDisplayed(firstName);
    }

    public boolean isLastNameFieldDisplayed() {
        return isDisplayed(lastName);
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordElement);
    }

    public boolean isAgreeAndContinueDisplayed() {
        return isDisplayed(agreeAndContinue);
    }

    public void enterFirstName(String fName) {
        write(firstName, fName);
    }

    public String getFirstNameValue() {
        return getValue(firstName);
    }

    public void enterLastName(String lName) {
        write(lastName, lName);
    }

    public String getLastNameValue() {
        return getValue(lastName);
    }

    public void enterPassword(String password) {
        write(passwordElement, password);
    }

    public String getPasswordValue() {
        return getValue(passwordElement);
    }

    public void submitRegistration() {
        click(agreeAndContinue);
    }

    public boolean isAccountNameDisplayed() {
        return isDisplayed(accountName);
    }

    public String getAccountName() {
        return read(accountName);
    }
}
