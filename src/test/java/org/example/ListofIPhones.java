package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListofIPhones {
    public WebDriver driver;

    public ListofIPhones(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//span[contains(text(),'APPLE iPhone 15 Plus 256GB Green')]")
    private WebElement iPhone15Plus256GBGreen;

    public WebElement getiPhone15Plus256GBGreen() {
        return iPhone15Plus256GBGreen;
    }

}
