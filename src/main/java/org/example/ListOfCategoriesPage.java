package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfCategoriesPage {

    public WebDriver driver;

    public ListOfCategoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(.//a[@href='/uk/smartphones/c1038946/'])[2]")
    private WebElement smartPhonesLink;

    @FindBy(xpath = "(//a[@href='/uk/led/c1038962/']/span)[1]")
    private WebElement tvLink;

    public void clickSmartPhonesLink() {
        smartPhonesLink.click();
    }

    public void clickTvLink() {
        tvLink.click();
    }

}