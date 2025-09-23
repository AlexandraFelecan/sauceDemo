package org.example.tests.cartPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.MainPageManager.*;
import org.testng.annotations.Listeners;
@Listeners(org.example.listeners.ExtentListener.class)

public class BackToProductsTest extends AbstractAcceptance {

    /**
     * Add a product to the cart and return to the main page:
     * 1. Open the application
     * 2. Login with valid credentials
     * 3. Add a random product to the cart
     * 4. Click the cart icon
     * 5. Open the burger menu and click "All items"
     * 6. Wait for the main page to load (sort button visible)
     * <p>
     * Expected result: User is successfully redirected back to the main products page.
     */

    @Test
    public void back_to_products_from_cart() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(burger_menu);
        WaitUtils.checkVisibility(all_items_btn, driver);
        applicationManager.clickOnElement(all_items_btn);
        WaitUtils.checkVisibility(sort_BTN, driver);
    }
}
