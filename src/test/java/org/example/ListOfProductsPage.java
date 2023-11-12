package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfProductsPage {
    public WebDriver driver;

    public ListOfProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@href,'/uk/smartfon-apple-iphone-15-plus-256gb-green')]/span")
    private WebElement iPhone15Plus256GBGreen;

    public void clickiPhone15Plus256GBGreen() {
        iPhone15Plus256GBGreen.click();
    }

    public WebElement getiPhone15Plus256GBGreen() {
        return iPhone15Plus256GBGreen;
    }
}

