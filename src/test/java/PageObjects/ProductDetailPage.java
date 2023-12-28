package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@class='add-to-basket']")
    private WebElement addToBasketButton ;

    @FindBy(linkText = "Sepetim")
    private WebElement viewBasket ;

    public boolean isOnProductPage () {
        helper.windowHandle();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.trendyol.com/adidas/restound-m-p-665061330?boutiqueId=622541&merchantId=968";
        return actualUrl.equals(expectedUrl) ;
    }

    public void addProductToBasket () {
        helper.windowHandle();
        helper.clickElement(addToBasketButton);
    }

    public void viewBasket () {
        helper.clickElement(viewBasket);
    }
}
