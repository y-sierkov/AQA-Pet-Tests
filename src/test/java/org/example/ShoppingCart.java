package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ShoppingCart {
    public WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='total-number']/span[@class='value']")
    private WebElement totalCartValue;

    public String getTotalCartValue() {
        String ActualTotalCartValue = totalCartValue.getText();
        return ActualTotalCartValue;
    }

}
