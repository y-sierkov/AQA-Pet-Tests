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

    @FindBy (xpath = "//span[text()='Ігрові консолі']/parent::a[@href='/uk/gaming_consoles/c1284951/']")
    private WebElement gameConsoles;

    public void clickGameConsolesLink () {
        gameConsoles.click();
    }

    @FindBy (xpath = "//span[contains(text(),'MICROSOFT Xbox Series X 1TB')]/parent::a[@href='/uk/konsoli-xbox-series-x/p71410857/']")
    private WebElement xBox1Tb;

    public void clickOnXbox1TbLink () {
        xBox1Tb.click();
    }


}
