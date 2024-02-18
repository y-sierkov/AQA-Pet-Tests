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

    @FindBy(xpath = "//div[@class='old-price-value']/span[@class='value']")
    private static WebElement oldProductPrice;

    @FindBy(xpath = "//div[@class='price-value difference']/span[@class='value']")
    private static WebElement newProductPrice;

    @FindBy(xpath = "//div[@class='button']")
    private WebElement buyButton;

    @FindBy(xpath = "//button[@class='basket-button']")
    private WebElement goToCartBtn;

    public String getProductCode() {
        return productCode.getText();
    }

    public static String getOldProductPrice() {
        return oldProductPrice.getText();
    }

    public static String getNewProductPrice() {
        return newProductPrice.getText();
    }

    public void clickBuyButton() {
        buyButton.click();
    }

    public void clickGoToCartBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='basket-button']")));
        goToCartBtn.click();
    }
}
