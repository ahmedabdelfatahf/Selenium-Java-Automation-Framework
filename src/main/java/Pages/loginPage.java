package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends PageBase {
    public loginPage(WebDriver driver) {
        super(driver);
    }

    By signInElement = By.xpath("//DIV[@class=\"w-full bg-white\"]/DIV/DIV/DIV[2]/DIV/BUTTON");
    By phoneNumberElement = By.xpath("//div[@class=\"flex w-full flex-col gap-1\"]/div/div/input");
    By continueButtonElement = By.xpath("//div[@class=\"flex flex-col items-center gap-5\"]/button");
    By passwordElement = By.xpath("//div[@class=\"relative top-1.5 flex w-full\"]/input");
    By submitLoginElement = By.xpath("//form[@class=\"flex w-full max-w-96 flex-col gap-3\"]/button");
    By accountNameElement = By.xpath("//button[@id=\"nav-in-button\"]/div/p[2]");

    public boolean isSignInButtonDisplayed() {
        return isDisplayed(signInElement);
    }

    public void goToLoginPage() {
        click(signInElement);
    }

    public boolean isPhoneNumberFieldDisplayed() {
        return isDisplayed(phoneNumberElement);
    }

    public boolean isContinueButtonDisplayed() {
        return isDisplayed(continueButtonElement);
    }

    public void enterPhoneNumber(int phoneNumber) {
        writeNumber(phoneNumberElement, phoneNumber);
    }

    public String getPhoneNumberValue() {
        return getValue(phoneNumberElement);
    }

    public void continueAfterPhoneNumber() {
        click(continueButtonElement);
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordElement);
    }

    public void enterPassword(String password) {
        write(passwordElement, password);
    }

    public String getPasswordValue() {
        return getValue(passwordElement);
    }

    public boolean isSubmitLoginButtonDisplayed() {
        return isDisplayed(submitLoginElement);
    }

    public void submitLogin() {
        click(submitLoginElement);
    }

    public boolean isAccountNameDisplayed() {
        return isDisplayed(accountNameElement);
    }

    public String getAccountName() {
        return read(accountNameElement);
    }
}
