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

    public FiltersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='price-input-number-range-min']")));
        minPriceField.clear();
    }

    public WebElement getMinPriceField() {
        return minPriceField;
    }

    public void inputMinPrice (String minPrice) {
        minPriceField.sendKeys(minPrice);
    }

    public void clearMaxPriceField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='price-input-number-range-max']")));
        maxPriceField.clear();
    }

    public WebElement getMaxPriceField() {
        return maxPriceField;
    }

    public void inputMaxPrice(String maxPrice) {
        maxPriceField.sendKeys(maxPrice);
    }

    public WebElement getApplyPriceBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='price']/button")));
        return applyPriceBtn;
    }

    public void clickApplyPriceBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='price']/button")));
        applyPriceBtn.click();
    }

    public WebElement getBrandLg() {
        return brandLg;
    }

    public void clickLgBrand() {
        brandLg.click();
    }

}
