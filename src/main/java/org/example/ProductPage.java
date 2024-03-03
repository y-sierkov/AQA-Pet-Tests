package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

    public static WebDriver driver;
    public static WaitUtils waitUtils;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
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
        return waitUtils.getElementText(productCode);
    }

    public static String getOldProductPrice() {
        return waitUtils.getElementText(oldProductPrice);
    }

    public static String getNewProductPrice() {
        return waitUtils.getElementText(newProductPrice);
    }

    public void clickBuyButton() {
        waitUtils.waitForElementToBeClickable(buyButton);
    }

    public void clickGoToCartBtn() {
        waitUtils.waitForElementToBeClickable(goToCartBtn);
    }
}
