package org.example.tests.chechoutPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.CheckoutManager.first_name_input;
import static org.example.managers.MainPageManager.items_price_list;

public class InitiateCheckout extends AbstractAcceptance {

    /**
     * Verify that a user can initiate the checkout process from the cart.
     *
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Add a random product to the cart and store its price.
     * 4. Open the cart and verify the product price matches.
     * 5. Click the "Checkout" button.
     * 6. Wait for the checkout page to load (first name input visible).
     *
     * Expected result:
     * The user is successfully redirected to the checkout page.
     */

    @Test
    public void initiate_checkout(){
        openApplication();
        login();
        String expectedPrice = cartManager.addToCart();

        applicationManager.clickOnElement(Cart_icon);
        String actualPrice = applicationManager.getTextOnElement(items_price_list);
        Assert.assertEquals(actualPrice, expectedPrice, "Product price in cart does not match");
        applicationManager.clickOnElement(Checkout_btn);
        WaitUtils.checkVisibility(first_name_input, driver);
    }
}
