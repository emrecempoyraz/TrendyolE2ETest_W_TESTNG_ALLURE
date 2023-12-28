package TestManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Helper {

    private WebDriver driver ;

    public Helper (WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement (WebElement element) {
        if (element.isDisplayed())
            element.click();
    }

    public void sendKeysTo (WebElement element , String text) {
        if (element.isDisplayed())
            element.click();
            element.clear();
            element.sendKeys(text);
    }

    public void windowHandle () {
        Set<String> windowAllWindows = driver.getWindowHandles();
        for (String windows:windowAllWindows) {
            driver.switchTo().window(windows);
        }
    }
}
