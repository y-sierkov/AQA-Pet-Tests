package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String waitForElementToGetText(WebElement element) {
        WebElement elementToGetTextFrom = wait.until(ExpectedConditions.visibilityOf(element));
        return elementToGetTextFrom.getText();
    }

    public WebElement waitForPresenceOfElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToClear(WebElement element) {
        WebElement elementToClear = wait.until(ExpectedConditions.elementToBeClickable(element));
        elementToClear.clear();
        return elementToClear;
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
        return clickableElement;
    }

    public boolean isElementValueEmpty(WebElement element) {
        return !wait.until(ExpectedConditions.textToBePresentInElementValue(element, ""));
    }

    public Boolean waitForElementToHaveAttribute(WebElement element, String attributeName, String expectedValue) {
        expectedValue = expectedValue.replaceAll("\\s", "");
        return wait.until(ExpectedConditions.attributeToBe(element, attributeName, expectedValue));
    }

    public List<WebElement> waitForAllElementsToBePresentAndCollect(By xpath) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath));
        return elements;
    }

    public List<WebElement> waitForAllElementsToBeVisibleAndCollect(By xpath) {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
        return elements;
    }

    public WebElement waitForElementToNotHaveText (WebElement element,String stringToSend) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, ""));
        element.sendKeys(stringToSend);
        return element;
    }

}
