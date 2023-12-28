package PageObjects;

import TestManager.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookie ;

    @FindBy(xpath = "//input[@data-testid='suggestion']")
    private WebElement searchBar ;

    @FindBy(xpath = "//i[@data-testid='search-icon']")
    private WebElement searchIcon ;



    public void acceptCookies () {
        helper.clickElement(acceptCookie);
    }

    public boolean isOnHomePage () {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.trendyol.com/";
        return actualUrl.equals(expectedUrl);
    }

    public void searchProduct () {
        helper.sendKeysTo(searchBar, IDriver.PRODUCT);
        helper.clickElement(searchIcon);
    }


}
