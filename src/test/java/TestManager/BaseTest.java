package TestManager;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static WebDriver driver;


    @BeforeSuite
    public void setup(){
        driver = DriverSetup.initialize_Driver();

    }

    //@AfterSuite
    /*public void tearDown(){
        if (driver != null)
        {
            driver.quit();
        }
    }*/
}