package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='pb-header']")
    private WebElement cartMessage ;

    public boolean isProductAddedCart () {
        String actualMessage = cartMessage.getText();
        String expectedMessage = "Sepetim (1 Ürün)" ;
        return actualMessage.contains(expectedMessage);
    }
}
