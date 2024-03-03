package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListOfProductsPage {
    public static WebDriver driver;
    public static WaitUtils waitUtils;

    public ListOfProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
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
        waitUtils.waitForElementToBeClickable(iPhone15Plus256GBGreen);
    }

    public WebElement getiPhone15Plus256GBGreen() {
        waitUtils.waitForVisibilityOfElement(iPhone15Plus256GBGreen);
        return iPhone15Plus256GBGreen;
    }

    public static String getHeaderText() {
        return waitUtils.getElementText(headerText);
    }

    public WebElement getSortByPriceBtn() {
        waitUtils.waitForElementToBeClickable(sortByPriceBtn);
        return sortByPriceBtn;
    }

    public void clickSortByPriceBtn() {
        waitUtils.waitForElementToBeClickable(sortByPriceBtn);
    }

    public List<WebElement> getPriceElements() {
        return waitUtils.getListOfElements(By.xpath("//div[contains(@class,'CollectionList')]//div/span[contains(@class,'ui-library-subtitle')]"));
    }

    public List<WebElement> getProductNameElements() {
        return waitUtils.getListOfElements(By.xpath("//div[contains(@class,'CollectionList')]//span[contains(@class, 'GoodsDescription')]"));
    }
}
