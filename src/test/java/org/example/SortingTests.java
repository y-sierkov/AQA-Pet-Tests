package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SortingTests extends Setup {

    public static HomePage homePage;
    public static ListOfProductsPage listOfProductsPage;
    public static FiltersPage filtersPage;
    public static ListOfCategoriesPage listOfCategoriesPage;
    public static WaitUtils waitUtils;

    @Test(description = "Test scenario to check price sorting functionality in ascending order")
    public void PriceSortingAscTest() {

        homePage = new HomePage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        filtersPage = new FiltersPage(driver);
        listOfCategoriesPage = new ListOfCategoriesPage(driver);
        waitUtils = new WaitUtils(driver);

        waitUtils.waitForElementToBeClickable(homePage.getSmartphonesAndTelephonesSideLink());

        homePage.clickSmartphonesAndTelephonesSideLink();

        waitUtils.waitForElementToBeClickable(listOfCategoriesPage.getSmartPhonesLink());

        listOfCategoriesPage.clickSmartPhonesLink();

        Actions actions = new Actions(driver);
        actions.moveToElement(filtersPage.getApplyPriceBtn());
        actions.perform();

        waitUtils.waitForVisibilityOfElement(filtersPage.getMaxPriceField());

        filtersPage.clearMaxPriceField();

        int expectedMaxPrice = 30000;

        String maxPriceToSend = Integer.toString(expectedMaxPrice);

        filtersPage.inputMaxPrice(maxPriceToSend);

        waitUtils.waitForVisibilityOfElement(filtersPage.getMinPriceField());

//        waitUtils.waitForElementToHaveAttribute(filtersPage.getMaxPriceField(), "value", maxPriceToSend);

        filtersPage.clearMinPriceField();

        int expectedMinPrice = 10000;

        String minPriceToSend = Integer.toString(expectedMinPrice);

        filtersPage.inputMinPrice(minPriceToSend);

        waitUtils.waitForElementToBeClickable(filtersPage.getApplyPriceBtn());

        filtersPage.clickApplyPriceBtn();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,0);");

        String expectedHeaderText = String.format("СМАРТФОНИ З ЦІНОЮ ВІД %s ГРН ДО %s ГРН", expectedMinPrice, expectedMaxPrice);

        String actualHeaderText = ListOfProductsPage.getHeaderText();

        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Actual header text does not match the expected one");

        waitUtils.waitForElementToBeClickable(listOfProductsPage.getSortByPriceBtn());

        listOfProductsPage.clickSortByPriceBtn();

        waitUtils.waitForAllElementsToBePresent(By.xpath("//div[contains(@class,'CollectionList')]//div/span[contains(@class,'ui-library-subtitle')]"));

        List<WebElement> priceElements = listOfProductsPage.getPriceElements();

        List<Integer> prices = extractPricesFromElements(priceElements);

        boolean priceOutOfRange = isPriceOutOfRange(prices, expectedMinPrice, expectedMaxPrice);

        Assert.assertFalse(priceOutOfRange, "The prices are not in chosen range");

        boolean isSortedAsc = isPricesSortedAscending(prices);

        Assert.assertTrue(isSortedAsc, "Prices weren't sorted correctly");
    }

    @Test(description = "Test scenario to check price sorting functionality in descending order")
    public void PriceSortingDescTest() {
        homePage = new HomePage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        filtersPage = new FiltersPage(driver);
        listOfCategoriesPage = new ListOfCategoriesPage(driver);

        homePage.clickSmartphonesAndTelephonesSideLink();

        listOfCategoriesPage.clickSmartPhonesLink();

        Actions actions = new Actions(driver);
        actions.moveToElement(filtersPage.getApplyPriceBtn());

        filtersPage.clearMaxPriceField();

        int expectedMaxPrice = 40000;

        String maxPriceToSend = Integer.toString(expectedMaxPrice);

        filtersPage.inputMaxPrice(maxPriceToSend);

        filtersPage.clearMinPriceField();

        int expectedMinPrice = 20000;

        String minPriceToSend = Integer.toString(expectedMinPrice);

        filtersPage.inputMinPrice(minPriceToSend);

        filtersPage.clickApplyPriceBtn();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,0);");

        String expectedHeaderText = String.format("СМАРТФОНИ З ЦІНОЮ ВІД %s ГРН ДО %s ГРН", expectedMinPrice, expectedMaxPrice);

        String actualHeaderText = ListOfProductsPage.getHeaderText();

        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Actual header text does not match the expected one");

        listOfProductsPage.clickSortByPriceBtn();

        listOfProductsPage.clickSortByPriceBtn();

        List<WebElement> priceElements = listOfProductsPage.getPriceElements();

        List<Integer> prices = extractPricesFromElements(priceElements);

        boolean priceOutOfRange = isPriceOutOfRange(prices, expectedMinPrice, expectedMaxPrice);

        Assert.assertFalse(priceOutOfRange, "The prices are not in chosen range");

        boolean isSortedDesc = isPricesSortedDescending(prices);

        Assert.assertTrue(isSortedDesc, "Prices weren't sorted correctly");
    }

    @Test(description = "Test scenario to check functionality of sorting by brand functionality")
    public void brandSortingTest() {
        homePage = new HomePage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        listOfCategoriesPage = new ListOfCategoriesPage(driver);
        filtersPage = new FiltersPage(driver);

        homePage.clickTvAndAudioDevicesLink();

        listOfCategoriesPage.clickTvLink();

        Actions actions = new Actions(driver);
        actions.moveToElement(filtersPage.getBrandLg());
        actions.perform();

        filtersPage.clickLgBrand();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,0);");

        List<WebElement> productNameElements = listOfProductsPage.getProductNameElements();

        List<String> productNames = getProductNamesFromElements(productNameElements);

        boolean isCorrectBrand = areAllProductsFromBrand(productNames, "LG");

        Assert.assertTrue(isCorrectBrand, "Product names does not contain correct brand name");
    }

    public List<Integer> extractPricesFromElements(List<WebElement> elements) {
        List<Integer> prices = new ArrayList<>();
        for (WebElement element : elements) {
            String priceText = element.getText();
            Integer priceValue = Integer.parseInt(priceText.replace(" ", ""));
            prices.add(priceValue);
        }
        return prices;
    }

    public boolean isPriceOutOfRange(List<Integer> prices, int expectedMinPrice, int expectedMaxPrice) {
        boolean priceOutOfRange = false;
        for (int price : prices) {
            if (price < expectedMinPrice || price > expectedMaxPrice) {
                priceOutOfRange = true;
                break;
            }
        }
        return priceOutOfRange;
    }

    public boolean isPricesSortedAscending(List<Integer> prices) {
        boolean isSortedAsc = true;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                isSortedAsc = false;
                break;
            }
        }
        return isSortedAsc;
    }

    public boolean isPricesSortedDescending(List<Integer> prices) {
        boolean isSortedDesc = true;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                isSortedDesc = false;
                break;
            }
        }
        return isSortedDesc;
    }

    public List<String> getProductNamesFromElements(List<WebElement> elements) {
        List<String> productNames = new ArrayList<>();
        for (WebElement element : elements) {
            String productName = element.getText();
            productNames.add(productName);
        }
        return productNames;
    }

    public boolean areAllProductsFromBrand(List<String> productNames, String brandName) {
        boolean isCorrectBrand = true;
        for (String name : productNames) {
            if (!name.contains(brandName)) {
                isCorrectBrand = false;
                break;
            }
        }
        return isCorrectBrand;
    }

}