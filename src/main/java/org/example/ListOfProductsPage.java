package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ListOfProductsPage {
    public static WebDriver driver;

    public ListOfProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@href,'/uk/smartfon-apple-iphone-15-plus-256gb-green')]/span")
    private WebElement iPhone15Plus256GBGreen;

    @FindBy(xpath = "//div[contains(@class,'CollectionList')]//div[contains(@class,'CurrentPrice')]/span[contains(@class,'ui-library-subtitle')]")
    private WebElement itemPrice;

    @FindBy(xpath = "//div[contains(@class,'gridContainer')]//h1")
    private static WebElement headerText;

    @FindBy(xpath = "(//div[contains(@class,'FilterItem')])[2]")
    private WebElement sortByPriceBtn;


    public void clickiPhone15Plus256GBGreen() {
        iPhone15Plus256GBGreen.click();
    }

    public WebElement getiPhone15Plus256GBGreen() {
        return iPhone15Plus256GBGreen;
    }

    public static String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'gridContainer')]//h1")));
        return headerText.getText();
    }

    public WebElement getSortByPriceBtn() {
        return sortByPriceBtn;
    }

    public void clickSortByPriceBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> buttonClickable = ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'FilterItem')])[2]"));
        ExpectedCondition<WebElement> buttonVisible = ExpectedConditions.visibilityOf(sortByPriceBtn);
        wait.until(ExpectedConditions.and(buttonClickable, buttonVisible));
        sortByPriceBtn.click();
    }

    public List<WebElement> getPriceElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'CollectionList')]//div/span[contains(@class,'ui-library-subtitle')]")));
        return driver.findElements(By.xpath("//div[contains(@class,'CollectionList')]//div/span[contains(@class,'ui-library-subtitle')]"));
    }

    public List<WebElement> getProductNameElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'CollectionList')]//span[contains(@class, 'GoodsDescription')]")));
        return driver.findElements(By.xpath("//div[contains(@class,'CollectionList')]//span[contains(@class, 'GoodsDescription')]"));
    }
}
