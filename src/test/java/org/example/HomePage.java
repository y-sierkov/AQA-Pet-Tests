package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    // class constructor for field initialization
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
        String placeHolderText = searchField.getAttribute("placeholder");
        return placeHolderText;
    }

    @FindBy(xpath = "//a[@href='/uk/search/?q=iPhone%2015']")
    private WebElement showAllItems;

    public void clickShowAllItemsLink() {
        showAllItems.click();
    }

    @FindBy(xpath = "//span[contains(text(),'APPLE iPhone 15 Plus 256GB Green')]")
    private WebElement iPhone15Plus256GBGreen;

    public void clickiPhone15Plus256GBGreen() {
        iPhone15Plus256GBGreen.click();
    }

    @FindBy(xpath = "//p[text()='Ігрова зона']/ancestor::a")
    private WebElement playZoneLink;

    public void clickPlayZoneLink() {
        playZoneLink.click();
    }


}