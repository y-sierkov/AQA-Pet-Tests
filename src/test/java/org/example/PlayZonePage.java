package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayZonePage {

    public WebDriver driver;

    public PlayZonePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/uk/gaming_consoles/c1284951/']/span[contains(@class,'subtitle')]")
    private WebElement gameConsoles;

    public void clickGameConsolesLink() {
        gameConsoles.click();
    }

    @FindBy(xpath = "//a[@href='/uk/konsoli-xbox-series-x/p71410857/']/span")
    private WebElement xBox1Tb;

    public void clickOnXbox1TbLink() {
        xBox1Tb.click();
    }
}
