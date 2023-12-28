package TestMain;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ProductDetailPage;
import PageObjects.ProductsPage;
import TestManager.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestClass extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage ;

    ProductDetailPage productDetailPage ;

    CartPage cartPage ;

    @Description("TrendyolE2ETest")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Navigate website")
    public void navigateWebsite () {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        Assert.assertTrue(homePage.isOnHomePage());
    }

    @Test(priority = 2 , description = "Search product on search bar", dependsOnMethods = "navigateWebsite")
    public void searchProduct () {
        productsPage = new ProductsPage(driver);
        homePage.searchProduct();
        Assert.assertTrue(productsPage.isSearchCompleted());
    }

    @Test(priority = 3,description = "Pick adidas from filters", dependsOnMethods = "searchProduct")
    public void selectAdidasFilter () throws InterruptedException {
        productsPage.filterBrand();
        Thread.sleep(5000);
    }

    @Test(priority = 4 , description = "select product from list",dependsOnMethods = "selectAdidasFilter")
    public void selectProduct () {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.clickProductLink();
        Assert.assertTrue(productDetailPage.isOnProductPage());
    }

    @Test(priority = 5 , description = "add product basket",dependsOnMethods = "selectProduct")
    public void addToCart () {
        productDetailPage.addProductToBasket();
        productDetailPage.viewBasket();
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductAddedCart());
    }



}
