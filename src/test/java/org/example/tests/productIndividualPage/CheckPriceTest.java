package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.managers.MainPageManager.*;
import org.testng.annotations.Listeners;
@Listeners(org.example.listeners.ExtentListener.class)

public class CheckPriceTest extends AbstractAcceptance {

    /**
     * Verify that the price of a product on the main page matches the price on the individual product page.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Click on a random product name.
     * 4. Check that the product price on the detail page matches the main page.
     * <p>
     * Expected result:
     * The product price displayed on the individual product page matches the selected product.
     */

    @Test
    public void checkProductPrice() {
        openApplication();
        login();

        List<WebElement> productNames = driver.findElements(By.cssSelector(items_name_list));
        List<WebElement> priceList = driver.findElements(By.cssSelector(price_list));

        int randomIndex = applicationManager.randomInt(0, productNames.size() - 1);
        String expectedPrice = priceList.get(randomIndex).getText();

        productNames.get(randomIndex).click();
        String actualPrice = driver.findElement(By.cssSelector(product_price)).getText();
        Assert.assertEquals(actualPrice, expectedPrice,
                "The product price on the detail page does not match the main page.");

    }
}
