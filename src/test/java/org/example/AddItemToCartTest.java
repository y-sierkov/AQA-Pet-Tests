package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddItemToCartTest {

    public static HomePage homePage;
    public static PlayZonePage playZonePage;
    public static ProductPage productPage;
    public static ShoppingCartPage shoppingCartPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        playZonePage = new PlayZonePage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homepage"));
    }

    @Test
    public void addItemToCartTest() {

        homePage.clickPlayZoneLink();

        playZonePage.clickGameConsolesLink();

        playZonePage.clickOnXbox1TbLink();

        String actualOldProductPrice = productPage.getOldProductPrice();

        String expectedOldProductPrice = "27 999";

        String actualNewXboxPrice = productPage.getNewProductPrice();

        String expectedNewXboxPrice = "25 999";

        Assert.assertEquals(actualOldProductPrice, expectedOldProductPrice, "Actual outdated product price does not match the expected one");

        Assert.assertEquals(actualNewXboxPrice, expectedNewXboxPrice, "Actual discounted price does not match the expected one");

        if (actualOldProductPrice.equalsIgnoreCase(expectedOldProductPrice) && actualNewXboxPrice.equalsIgnoreCase(expectedNewXboxPrice)) {
            productPage.clickBuyButton();
        }

        productPage.clickGoToCartBtn();

        String actualTotalCartValue = shoppingCartPage.getTotalCartValue();

        Assert.assertEquals(actualTotalCartValue, expectedNewXboxPrice, "Actual Total Cart value does not match the expected one");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}