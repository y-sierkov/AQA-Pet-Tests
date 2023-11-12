package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    public void inputPhoneName(String phoneName) {
        searchField.sendKeys(phoneName);
    }

    public String getSearchFieldPlaceholder() {
        return searchField.getAttribute("placeholder");
    }

    @FindBy(xpath = "//div[contains(@class,'ShowAllLinkWrapper')]/a")
    private WebElement showAllItems;

    public void clickShowAllItemsLink() {
        showAllItems.click();
    }

    @FindBy(xpath = "//a[@href='/uk/node/c1285101/']")
    private WebElement playZoneLink;

    public void clickPlayZoneLink() {
        playZoneLink.click();
    }
}