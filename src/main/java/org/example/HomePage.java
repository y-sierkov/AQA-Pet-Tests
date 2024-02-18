package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
        searchField.sendKeys(phoneName);
    }

    public String getSearchFieldPlaceholder() {
        return searchField.getAttribute("placeholder");
    }

    public void clickShowAllItemsLink() {
        showAllItems.click();
    }

    public void clickPlayZoneLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='/uk/node/c1285101/']")));
        playZoneLink.click();
    }

    public void clickGiftGeneratorBtn() {
        giftGeneratorBtn.click();
    }

    public void clearMinPriceField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@id='range-input-price']/input)[1]")));
        minPriceField.clear();
    }

    public void clearMaxPriceField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@id='range-input-price']/input)[2]")));
        maxPriceField.clear();
    }

    public void inputMinPrice(String minPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@id='range-input-price']/input)[1]")));
        minPriceField.sendKeys(minPrice);
    }

    public void inputMaxPrice(String maxPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@id='range-input-price']/input)[2]")));
        maxPriceField.sendKeys(maxPrice);
    }

    public void clickGenerateBtn() {
        generateBtn.click();
    }

    public List<WebElement> getPriceElements() {
        return driver.findElements(By.xpath("//div[@class='price-wrapper']/span"));
    }

    public void clickSmartphonesAndTelephonesSideLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(smartphonesAndTelephonesSideLink));
        smartphonesAndTelephonesSideLink.click();
    }

    public WebElement getSmartphonesAndTelephonesSideLink () {
        return smartphonesAndTelephonesSideLink;
    }

    public void clickTvAndAudioDevicesLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/uk/node/c1038957/']")));
        tvAndAudioDevicesLink.click();
    }
}