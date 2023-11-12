package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertGoodCodeTest {

    public static HomePage homePage;
    public static ListOfProductsPage listOfProductsPage;
    public static ProductPage productPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        productPage = new ProductPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homepage"));
    }

    @Test
    public void assertGoodCode() {

        String actualPlaceHolderText = homePage.getSearchFieldPlaceholder();

        String expectedPlaceholderText = "Пошук товарів";

        Assert.assertEquals(actualPlaceHolderText, expectedPlaceholderText, "Actual placeholder in the Search field does not match the expected one");

        homePage.inputPhoneName(ConfProperties.getProperty("phoneName"));

        homePage.clickShowAllItemsLink();

        Actions actions = new Actions(driver);
        actions.moveToElement(listOfProductsPage.getiPhone15Plus256GBGreen());
        actions.perform();

        listOfProductsPage.clickiPhone15Plus256GBGreen();

        String code = productPage.getProductCode();

        String expectedCode = "71465471";

        Assert.assertEquals(code, expectedCode, "Actual Product Code does not match the expected one");

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}