package org.example.tests.checkoutOverviewPage;

import org.example.config.AbstractAcceptance;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.CheckoutManager.finish_btn;
import static org.example.managers.CheckoutManager.order_complete_msg;
import org.testng.annotations.Listeners;
@Listeners(org.example.listeners.ExtentListener.class)

public class FinishOrderTest extends AbstractAcceptance {
    /**
     * Verify that the user can complete the checkout process successfully.
     * <p>
     * Steps:
     * 1. Open the application and log in with valid credentials.
     * 2. Add a product to the cart and go to the cart.
     * 3. Click the Checkout button and complete the form with valid data.
     * 4. Click the Finish button to complete the order.
     * <p>
     * Expected result:
     * The message "Thank you for your order!" is displayed.
     */

    @Test
    public void finish_order() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        checkoutManager.fillInForm();
        applicationManager.clickOnElement(finish_btn);
        Assert.assertEquals(applicationManager.getTextOnElement(order_complete_msg), "Thank you for your order!");
    }
}
