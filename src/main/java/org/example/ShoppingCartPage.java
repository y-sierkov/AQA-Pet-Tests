package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCartPage {
    public static WebDriver driver;
    public static WaitUtils waitUtils;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    @FindBy(xpath = "//div[@class='total-number']/span[@class='value']")
    private WebElement totalCartValue;

    public String getTotalCartValue() {
        return waitUtils.getElementText(totalCartValue);
    }
}