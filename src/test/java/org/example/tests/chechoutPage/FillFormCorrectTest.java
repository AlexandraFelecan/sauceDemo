package org.example.tests.chechoutPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.CheckoutManager.finish_btn;

public class FillFormCorrectTest extends AbstractAcceptance {

    /**
     * Verify that the checkout form can be filled and submitted successfully.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Add a product to the cart.
     * 4. Open the cart and click the Checkout button.
     * 5. Fill in the checkout form with valid information.
     * 6. Click Continue to proceed.
     * <p>
     * Expected result:
     * The user is redirected to the final checkout page with the Finish button visible.
     */

    @Test
    public void fill_in_form() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        checkoutManager.fillInForm();
        WaitUtils.checkVisibility(finish_btn, driver);
    }
}
