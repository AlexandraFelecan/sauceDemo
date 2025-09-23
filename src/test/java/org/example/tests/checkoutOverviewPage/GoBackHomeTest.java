package org.example.tests.checkoutOverviewPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.CheckoutManager.back_home_btn;
import static org.example.managers.CheckoutManager.finish_btn;
import static org.example.managers.MainPageManager.sort_BTN;

public class GoBackHomeTest extends AbstractAcceptance {
    /**
     * Verify that the user can return to the main page after completing an order.
     * <p>
     * Steps:
     * 1. Open the application and log in with valid credentials.
     * 2. Add a product to the cart and go to the cart.
     * 3. Click the Checkout button and complete the form with valid data.
     * 4. Click the Finish button to complete the order.
     * 5. Click the Back Home button.
     * <p>
     * Expected result:
     * Successful redirection to the main page.
     */

    @Test
    public void go_back_to_main_page() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        checkoutManager.fillInForm();
        applicationManager.clickOnElement(finish_btn);
        applicationManager.clickOnElement(back_home_btn);
        WaitUtils.checkVisibility(sort_BTN, driver);
    }
}
