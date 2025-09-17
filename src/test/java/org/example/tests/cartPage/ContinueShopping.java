package org.example.tests.cartPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Continue_shopping_btn;
import static org.example.managers.MainPageManager.*;

public class ContinueShopping extends AbstractAcceptance {

    /**
     * Continue shopping from the cart.
     *
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Add a random product to the cart and open the cart.
     * 4. Verify the product price matches the main page.
     * 5. Click "Continue Shopping" button.
     *
     * Expected result:
     * Successful redirection to the main page of the application.
     */
    @Test
    public void continueShoppingFromCart() {
        openApplication();
        login();

        String expectedPrice = cartManager.addToCart();

        applicationManager.clickOnElement(Cart_icon);
        String actualPrice = applicationManager.getTextOnElement(items_price_list);
        Assert.assertEquals(actualPrice, expectedPrice, "Product price in cart does not match");

        applicationManager.clickOnElement(Continue_shopping_btn);
        WaitUtils.checkVisibility(sort_BTN, driver);
    }
}
