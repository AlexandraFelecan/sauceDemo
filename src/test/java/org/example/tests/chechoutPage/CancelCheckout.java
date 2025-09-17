package org.example.tests.chechoutPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.*;
import static org.example.managers.CheckoutManager.cancel_btn;

public class CancelCheckout extends AbstractAcceptance {

    /**
     * Verify that a user can cancel the checkout process and return to the cart.
     *
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Add a product to the cart.
     * 4. Open the cart and click the "Checkout" button.
     * 5. Click the "Cancel" button on the checkout page.
     * 6. Wait for the cart page to display.
     *
     * Expected result:
     * The user is successfully redirected back to the cart page.
     */

    @Test
    public void cancel_checkout() {
        openApplication();
        login();
        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        applicationManager.clickOnElement(cancel_btn);
        WaitUtils.checkVisibility(Continue_shopping_btn, driver);
    }
}
