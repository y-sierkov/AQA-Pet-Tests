package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XboxPage {

    public WebDriver driver;

    public XboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='old-price-value']/span[1]")
    private static WebElement oldXboxPrice;

    public static String getOldXboxPrice() {
        String OldXboxPrice = oldXboxPrice.getText();
        return OldXboxPrice;
    }

    @FindBy (xpath = "//div[@class='price-value difference']/span[1]")
    private static WebElement newXboxPrice;

    public static String getNewXboxPrice () {
        String actualNewXboxPrice = newXboxPrice.getText();
        return actualNewXboxPrice;
    }

    @FindBy (xpath = "//div[@class='button']")
    private WebElement buyButton;

    public void clickBuyButton () {
        buyButton.click();
    }

    @FindBy (xpath = "//button[@class='basket-button']")
    private WebElement goToCartBtn;

    public void clickGoToCartBtn () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='basket-button']")));
        goToCartBtn.click();
    }


}
