package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertGoodCode {

    public static HomePage homePage;
    public static ListofIPhones listofIPhones;
    public static IPhonePage iPhonePage;
    public static WebDriver driver;

    //    Initial Setup Implementation
    @BeforeClass
    public static void setup() {
        //path to the chromedriver and its setup
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //Creation of the driver exemplar
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        listofIPhones = new ListofIPhones(driver);
        iPhonePage = new IPhonePage(driver);
        //The window is opened maximized
        driver.manage().window().maximize();
        //element auto-wait = 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the start link from conf.properties file
        driver.get(ConfProperties.getProperty("homepage"));

    }

    @Test
    public void assertGoodCode() {

        String actualPlaceHolderText = homePage.getSearchFieldPlaceholder();

        String expectedPlaceholderText = "Пошук товарів";

        Assert.assertEquals(actualPlaceHolderText, expectedPlaceholderText);

//        The following if..else statement was made for educational purpose

        if (actualPlaceHolderText.equals(expectedPlaceholderText)) {
            System.out.println("Placeholder text matches the expected one");
            homePage.inputPhoneName(ConfProperties.getProperty("phoneName"));
        } else {
            System.out.println("Placeholder text doesn't match the expected one");
        }

        homePage.clickShowAllItemsLink();

        Actions actions = new Actions(driver);
        actions.moveToElement(listofIPhones.getiPhone15Plus256GBGreen());
        actions.perform();

        homePage.clickiPhone15Plus256GBGreen();

        String code = iPhonePage.getCodeIPhone15Plus256GBGreen();

        String expectedCode = "71465471";

        Assert.assertEquals(code, expectedCode);

        //        The following if..else statement was made for educational purpose

        if (code.equals(expectedCode)) {
            System.out.println("Code matches the expected one");
        } else {
            System.out.println("Code does not match the expected one");
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}