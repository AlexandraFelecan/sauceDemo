package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.managers.MainPageManager.*;

public class AddToBasketTest extends AbstractAcceptance {

    /**
     * Verify that adding a product to the cart from the individual product page works correctly.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Click on a random product.
     * 4. Click the "Add to Cart" button.
     * 5. Verify that the button text changes to "Remove".
     * <p>
     * Expected result:
     * The "Add to Cart" button changes to "Remove" after adding the product to the cart.
     */
    @Test
    public void addToCartFromProductPage() {
        openApplication();
        login();
        mainPageManager.clickRandomProduct();
        applicationManager.clickOnElement(add_product_to_cart);
        String btn_text = applicationManager.getTextOnElement(remove_btn_individual);
        Assert.assertEquals(btn_text, "Remove", "Button text has not changed");
    }

    /**
     * Verify that removing a product from the cart on the individual product page works correctly.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Click on a random product to navigate to its detail page.
     * 4. Add the product to the cart.
     * 5. Wait for the "Remove" button to appear and click it.
     * 6. Verify that the button text changes back to "Add to cart".
     * <p>
     * Expected result:
     * The "Remove" button changes back to "Add to cart" after removing the product from the cart.
     */
    @Test
    public void removeFromBasket() {
        openApplication();
        login();
        mainPageManager.clickRandomProduct();
        applicationManager.clickOnElement(add_product_to_cart);
        WaitUtils.elementLocatedWithText(remove_btn_individual, "Remove", driver);
        applicationManager.clickOnElement(remove_btn_individual);
        String btn_text = applicationManager.getTextOnElement(add_to_cart_buttons);
        Assert.assertEquals(btn_text, "Add to cart", "Button text has not changed");

    }
}
