package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='goods-code']/span")
    private WebElement productCode;

    public String getProductCode() {
        return productCode.getText();
    }

    @FindBy(xpath = "//div[@class='old-price-value']/span[@class='value']")
    private static WebElement oldProductPrice;

    public static String getOldProductPrice() {
        return oldProductPrice.getText();
    }

    @FindBy(xpath = "//div[@class='price-value difference']/span[@class='value']")
    private static WebElement newProductPrice;

    public static String getNewProductPrice() {
        return newProductPrice.getText();
    }

    @FindBy(xpath = "//div[@class='button']")
    private WebElement buyButton;

    public void clickBuyButton() {
        buyButton.click();
    }

    @FindBy(xpath = "//button[@class='basket-button']")
    private WebElement goToCartBtn;

    public void clickGoToCartBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='basket-button']")));
        goToCartBtn.click();
    }
}
