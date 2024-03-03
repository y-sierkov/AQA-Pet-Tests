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

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getElementText(WebElement element) {
        WebElement elementToGetTextFrom = wait.until(ExpectedConditions.visibilityOf(element));
        return elementToGetTextFrom.getText();
    }

    public void clearElementText(WebElement element) {
        WebElement elementToClear = wait.until(ExpectedConditions.elementToBeClickable(element));
        elementToClear.clear();
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
    }

    public String getElementAttribute(WebElement element,String attributeName) {
        WebElement elementToGetAttributeFrom = wait.until(ExpectedConditions.visibilityOf(element));
        return elementToGetAttributeFrom.getAttribute(attributeName);
    }

    public List<WebElement> getListOfElements(By xpath) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath));
        return elements;
    }

    public void waitForElementToNotHaveText(WebElement element) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, ""));
    }

}
