package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    public WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class,'ShowAllLinkWrapper')]/a")
    private WebElement showAllItems;

    @FindBy(xpath = "//a[@href='/uk/node/c1285101/']")
    private WebElement playZoneLink;

    @FindBy(xpath = "//span[contains(@class,'RandomizerButton')]")
    private WebElement giftGeneratorBtn;

    @FindBy(xpath = "(//div[@id='range-input-price']/input)[1]")
    private WebElement minPriceField;

    @FindBy(xpath = "(//div[@id='range-input-price']/input)[2]")
    private WebElement maxPriceField;

    @FindBy(xpath = "//button[@class='submit-prices']")
    private WebElement generateBtn;

    @FindBy(xpath = "//a[@href='/uk/node/c1038944/']")
    private WebElement smartphonesAndTelephonesSideLink;

    @FindBy(xpath = "//a[@href='/uk/node/c1038957/']")
    private WebElement tvAndAudioDevicesLink;

    public void inputPhoneName(String phoneName) {
        waitUtils.waitForVisibilityOfElement(searchField);
        searchField.sendKeys(phoneName);
    }

    public String getSearchFieldPlaceholder() {
        return waitUtils.getElementAttribute(searchField, "placeholder");
    }

    public void clickShowAllItemsLink() {
        waitUtils.waitForElementToBeClickable(showAllItems);
    }

    public void clickPlayZoneLink() {
        waitUtils.waitForElementToBeClickable(playZoneLink);
    }

    public void clickGiftGeneratorBtn() {
        waitUtils.waitForElementToBeClickable(giftGeneratorBtn);
    }

    public void clearMinPriceField() {
        waitUtils.clearElementText(minPriceField);
    }

    public void clearMaxPriceField() {
        waitUtils.clearElementText(maxPriceField);
    }

    public void inputMinPrice(String minPrice) {
        waitUtils.waitForElementToNotHaveText(minPriceField);
        minPriceField.sendKeys(minPrice);
    }

    public void inputMaxPrice(String maxPrice) {
        waitUtils.waitForElementToNotHaveText(maxPriceField);
        maxPriceField.sendKeys(maxPrice);
    }

    public void clickGenerateBtn() {
        waitUtils.waitForElementToBeClickable(generateBtn);
    }

    public List<WebElement> getPriceElements() {
        return waitUtils.getListOfElements(By.xpath("//div[@class='price-wrapper']/span[not(contains(@class,'ukraine-currency'))]"));
    }

    public void clickSmartphonesAndTelephonesSideLink() {
        waitUtils.waitForElementToBeClickable(smartphonesAndTelephonesSideLink);
    }

    public void clickTvAndAudioDevicesLink() {
        waitUtils.waitForElementToBeClickable(tvAndAudioDevicesLink);
    }
}