package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage extends BasePage {


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='erkek spor ayakkabı']")
    private WebElement searchResult ;

    @FindBy(xpath = "(//div[@class='chckbox'])[1]")
    private WebElement adidasFilter ;

    @FindBy(xpath = "(//div[@class='image-overlay-body'])[1]")
    private WebElement productLink ;



    public boolean isSearchCompleted () {
        String actualResult = searchResult.getText();
        String expectedResult = "erkek spor ayakkabı";
        return actualResult.contains(expectedResult);
    }

    public void filterBrand () {
        helper.clickElement(adidasFilter);
    }

    public void clickProductLink () {
        helper.clickElement(productLink);
    }


}
