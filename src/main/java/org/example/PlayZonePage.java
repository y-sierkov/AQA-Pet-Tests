package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayZonePage {

    public static WebDriver driver;
    public static WaitUtils waitUtils;

    public PlayZonePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    @FindBy(xpath = "//a[@href='/uk/gaming_consoles/c1284951/']/span[contains(@class,'subtitle')]")
    private WebElement gameConsoles;

    @FindBy(xpath = "//a[@href='/uk/konsoli-xbox-series-x/p71410857/']/span")
    private WebElement xBox1Tb;

    public void clickGameConsolesLink() {
        waitUtils.waitForElementToBeClickable(gameConsoles);
    }

    public void clickOnXbox1TbLink() {
        waitUtils.waitForElementToBeClickable(xBox1Tb);
    }
}
