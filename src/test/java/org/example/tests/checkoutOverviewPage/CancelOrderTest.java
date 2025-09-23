package org.example.tests.checkoutOverviewPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.CheckoutManager.cancel_btn;
import static org.example.managers.MainPageManager.sort_BTN;
import org.testng.annotations.Listeners;
@Listeners(org.example.listeners.ExtentListener.class)

public class CancelOrderTest extends AbstractAcceptance {
    /**
     * Verify that the user is redirected back to the main page when canceling the checkout process.
     * <p>
     * Steps:
     * 1. Open the application and log in with valid credentials.
     * 2. Add a product to the cart and go to the cart.
     * 3. Click the Checkout button and complete the form with valid data.
     * 4. Click the Cancel button during checkout.
     * <p>
     * Expected result:
     * Successful redirection to the main page.
     */

    @Test
    public void cancel_order() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        checkoutManager.fillInForm();
        applicationManager.clickOnElement(cancel_btn);
        WaitUtils.checkVisibility(sort_BTN, driver);
    }
}
