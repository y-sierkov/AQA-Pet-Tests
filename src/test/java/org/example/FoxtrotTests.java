package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoxtrotTests extends Setup {

    public static HomePage homePage;
    public static PlayZonePage playZonePage;
    public static ProductPage productPage;
    public static ShoppingCartPage shoppingCartPage;
    public static ListOfProductsPage listOfProductsPage;

    @Test(description = "Positive test scenario for adding Item to the cart and checking prices")
    public void AddItemToCartTest() {

        homePage = new HomePage(driver);
        playZonePage = new PlayZonePage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        homePage.clickPlayZoneLink();

        playZonePage.clickGameConsolesLink();

        playZonePage.clickOnXbox1TbLink();

        String expectedOldProductPrice = "27 999";

        String actualOldProductPrice = ProductPage.getOldProductPrice();

        String expectedNewXboxPrice = "24 599";

        String actualNewXboxPrice = ProductPage.getNewProductPrice();

        Assert.assertEquals(actualOldProductPrice, expectedOldProductPrice, "Actual outdated product price does not match the expected one");

        Assert.assertEquals(actualNewXboxPrice, expectedNewXboxPrice, "Actual discounted price does not match the expected one");

        productPage.clickBuyButton();

        productPage.clickGoToCartBtn();

        String actualTotalCartValue = shoppingCartPage.getTotalCartValue();

        Assert.assertEquals(actualTotalCartValue, expectedNewXboxPrice, "Actual Total Cart value does not match the expected one");
    }

    @Test(description = "Positive test scenario to check product code on the product page")
    public void AssertItemCodeTest() {

        homePage = new HomePage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        productPage = new ProductPage(driver);

        String actualPlaceHolderText = homePage.getSearchFieldPlaceholder();

        String expectedPlaceholderText = "Пошук товарів";

        Assert.assertEquals(actualPlaceHolderText, expectedPlaceholderText, "Actual placeholder in the Search field does not match the expected one");

        String phoneName = "iPhone 15";

        homePage.inputPhoneName(phoneName);

        homePage.clickShowAllItemsLink();

        Actions actions = new Actions(driver);
        actions.moveToElement(listOfProductsPage.getiPhone15Plus256GBGreen()).perform();

        listOfProductsPage.clickiPhone15Plus256GBGreen();

        String code = productPage.getProductCode();

        String expectedCode = "71465471";

        Assert.assertEquals(code, expectedCode, "Actual Product Code does not match the expected one");
    }

    @Test(description = "Positive test scenario to check prices range on the Gift Generator Pop-Up")
    public void giftGeneratorTest() {

        homePage = new HomePage(driver);

        homePage.clickGiftGeneratorBtn();

        homePage.clearMinPriceField();

        int expectedMinPrice = 1;

        String minPriceToSend = Integer.toString(expectedMinPrice);

        homePage.inputMinPrice(minPriceToSend);

        homePage.clearMaxPriceField();

        int expectedMaxPrice = 1000;

        String maxPriceToSend = Integer.toString(expectedMaxPrice);

        homePage.inputMaxPrice(maxPriceToSend);

        homePage.clickGenerateBtn();

        List<WebElement> priceElements = homePage.getPriceElements();

        List<Integer> prices = extractPricesFromElements(priceElements);

        Pattern pattern = Pattern.compile("\\d+");

        boolean priceOutOfRange = isPriceOutOfRange(prices,expectedMinPrice, expectedMaxPrice);

        Assert.assertFalse(priceOutOfRange, "Product prices are not in expected range");
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

    public List<Integer> extractPricesFromElements(List<WebElement> elements) {
        List<Integer> prices = new ArrayList<>();
        for (WebElement element : elements) {
            String priceText = element.getText();
            Integer priceValue = Integer.parseInt(priceText.replace(" ", ""));
            prices.add(priceValue);
        }
        return prices;
    }
}