package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPhonePage {

    public WebDriver driver;

    public IPhonePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='goods-code']/span")
    private WebElement codeIPhone15Plus256GBGreen;

    public String getCodeIPhone15Plus256GBGreen () {
        String actualCodeIPhone15Plus256GBGreen = codeIPhone15Plus256GBGreen.getText();
        return actualCodeIPhone15Plus256GBGreen;
    }


}
