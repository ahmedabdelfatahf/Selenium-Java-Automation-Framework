package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By searchField = By.id("search-input");
    By destination = By.xpath("//div[@class=\"flex max-h-[412px] w-full flex-col gap-4 overflow-y-auto overflow-x-hidden text-start\"]/div/div[1]/div[2]/p[2]");
    By searchButton = By.xpath("//DIV[@class=\"hidden sm:block\"]/DIV/DIV/BUTTON");
    By whenElement = By.xpath("//DIV[@class=\"flex flex-grow flex-col sm:flex-row\"]/DIV/DIV/BUTTON/div/div/p");
    By whoElement = By.xpath("//button[@id=\"guests-button\"]/DIV[@class=\"flex items-center justify-between\"]/p");

    public boolean isSearchFieldDisplayed() {
        return isDisplayed(searchField);
    }

    public void clickOnSearchField() {
        click(searchField);
    }

    public String getSearchFieldValue() {
        String value = getValue(searchField);
        return value == null ? "" : value.trim();
    }

    public boolean isWhenDisplayed() {
        return isDisplayed(whenElement);
    }

    public String getWhenText() {
        return read(whenElement);
    }

    public boolean isWhoDisplayed() {
        return isDisplayed(whoElement);
    }

    public String getWhoText() {
        return read(whoElement);
    }

    public boolean isDestinationDisplayed() {
        return isDisplayed(destination);
    }

    public String getDestinationText() {
        return read(destination);
    }

    public void choseDestination() {
        click(destination);
    }

    public boolean isSearchButtonDisplayed() {
        return isDisplayed(searchButton);
    }

    public void clickOnSearchButton() {
        click(searchButton);
    }
}
