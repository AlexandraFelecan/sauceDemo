package org.example.tests.cartPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Cart_item;
import static org.example.managers.MainPageManager.items_price_list;
import static org.example.managers.MainPageManager.remove_btn;

public class RemoveFromCartTest extends AbstractAcceptance {

    /**
     * Verify removing a product from the cart.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Add a random product to the cart and open the cart.
     * 4. Verify the product price matches the main page.
     * 5. Remove the product from the cart and wait until it disappears.
     * <p>
     * Expected result:
     * The product is removed from the cart successfully.
     */

    @Test
    public void remove_product_from_cart() {
        openApplication();
        login();

        String expectedPrice = cartManager.addToCart();

        applicationManager.clickOnElement(Cart_icon);
        String actualPrice = applicationManager.getTextOnElement(items_price_list);
        Assert.assertEquals(actualPrice, expectedPrice, "Selected product price does not match");

        applicationManager.clickOnElement(remove_btn);
        WaitUtils.checkInvisibility(Cart_item, driver);
    }
}
