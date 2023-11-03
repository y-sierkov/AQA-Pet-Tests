package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddItemToCart {

    public static HomePage homePage;
    public static PlayZonePage playZonePage;
    public static XboxPage xboxPage;
    public static ShoppingCart shoppingCart;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //path to the chromedriver and its setup
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //Creation of the driver exemplar
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        playZonePage = new PlayZonePage(driver);
        xboxPage = new XboxPage(driver);
        shoppingCart = new ShoppingCart(driver);
        //The window is opened maximized
        driver.manage().window().maximize();
        //element auto-wait = 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the start link from conf.properties file
        driver.get(ConfProperties.getProperty("homepage"));
    }

    @Test
    public void addItemToCartTest() {

        homePage.clickPlayZoneLink();

        playZonePage.clickGameConsolesLink();

        playZonePage.clickOnXbox1TbLink();

        String actualOldXboxPrice = XboxPage.getOldXboxPrice();

        String expectedOldXboxPrice = "27 999";

        String actualNewXboxPrice = XboxPage.getNewXboxPrice();

        String expectedNewXboxPrice = "25 999";

        Assert.assertEquals(actualOldXboxPrice, expectedOldXboxPrice);

        Assert.assertEquals(actualNewXboxPrice, expectedNewXboxPrice);

//        The following if..else instruction was made just for practise purpose

        if (actualOldXboxPrice.equalsIgnoreCase(expectedOldXboxPrice) && actualNewXboxPrice.equalsIgnoreCase(expectedNewXboxPrice)) {
            System.out.println("Actual prices match expected results");
            xboxPage.clickBuyButton();
        } else {
            System.out.println("Actual prices do not match expected results");
        }

        xboxPage.clickGoToCartBtn();

        String actualTotalCartValue = shoppingCart.getTotalCartValue();

        Assert.assertEquals(actualTotalCartValue, expectedNewXboxPrice);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
