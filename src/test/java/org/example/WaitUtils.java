package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    public WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForElementToHaveAttribute(WebElement element, String attributeName, String expectedValue) {
        expectedValue = expectedValue.replaceAll("\\s", "");
        return wait.until(ExpectedConditions.attributeToBe(element, attributeName, expectedValue));
    }

    public List<WebElement> waitForAllElementsToBePresent(By xpath) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath));
    }

}
