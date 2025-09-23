package org.example.tests.cartPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Continue_shopping_btn;
import static org.example.managers.MainPageManager.items_price_list;
import static org.example.managers.MainPageManager.sort_BTN;
import org.testng.annotations.Listeners;
@Listeners(org.example.listeners.ExtentListener.class)

public class ContinueShoppingTest extends AbstractAcceptance {

    /**
     * Continue shopping from the cart.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Add a random product to the cart and open the cart.
     * 4. Verify the product price matches the main page.
     * 5. Click "Continue Shopping" button.
     * <p>
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
