package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FiltersPage {
    public WebDriver driver;
    public  WaitUtils waitUtils;

    public FiltersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    @FindBy(xpath = "//input[@id='price-input-number-range-min']")
    private WebElement minPriceField;

    @FindBy(xpath = "//input[@id='price-input-number-range-max']")
    private WebElement maxPriceField;

    @FindBy(xpath = "//div[@id='price']/button")
    private WebElement applyPriceBtn;

    @FindBy(xpath = "//p[text()='LG']/parent::a/preceding-sibling::span")
    private WebElement brandLg;

    @FindBy(xpath = "//div[contains(@class,'typographyContainer')]/span")
    private WebElement chosenFilter;

    public void clearMinPriceField () {
        WebElement element = waitUtils.waitForElementToClear(minPriceField);
    }

    public void inputMinPrice (String minPrice) {
        waitUtils.waitForElementToNotHaveText(minPriceField, minPrice);
//        minPriceField.sendKeys(minPrice);
    }

    public void clearMaxPriceField() {
        WebElement element = waitUtils.waitForElementToClear(maxPriceField);
    }

    public void inputMaxPrice(String maxPrice) {
        waitUtils.waitForElementToNotHaveText(maxPriceField, maxPrice);
//        maxPriceField.sendKeys(maxPrice);
    }

    public WebElement getApplyPriceBtn() {
        WebElement element = waitUtils.waitForPresenceOfElement(By.xpath("//div[@id='price']/button"));
        return element;
    }

    public void clickApplyPriceBtn() {
        WebElement element = waitUtils.waitForElementToBeClickable(applyPriceBtn);
    }

    public WebElement getBrandLg() {
        return brandLg;
    }

    public void clickLgBrand() {
        brandLg.click();
    }

}
