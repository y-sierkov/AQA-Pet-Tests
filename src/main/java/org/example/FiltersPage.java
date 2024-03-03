package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FiltersPage {
    public WebDriver driver;
    public WaitUtils waitUtils;

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

    public void clearMinPriceField() {
        waitUtils.clearElementText(minPriceField);
    }

    public void inputMinPrice(String minPrice) {
        waitUtils.waitForElementToNotHaveText(minPriceField);
        minPriceField.sendKeys(minPrice);
    }

    public void clearMaxPriceField() {
        waitUtils.clearElementText(maxPriceField);
    }

    public void inputMaxPrice(String maxPrice) {
        waitUtils.waitForElementToNotHaveText(maxPriceField);
        maxPriceField.sendKeys(maxPrice);
    }

    public WebElement getApplyPriceBtn() {
        waitUtils.waitForVisibilityOfElement(applyPriceBtn);
        return applyPriceBtn;
    }

    public void clickApplyPriceBtn() {
        waitUtils.waitForElementToBeClickable(applyPriceBtn);
    }

    public WebElement getBrandLg() {
        waitUtils.waitForVisibilityOfElement(brandLg);
        return brandLg;
    }

    public void clickLgBrand() {
        waitUtils.waitForElementToBeClickable(brandLg);
    }

}