package org.example.tests.checkoutOverviewPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.MainPageManager.items_name_list;
import static org.example.managers.MainPageManager.product_name;

public class GoToProductPageFromCheckoutTest extends AbstractAcceptance {
    /**
     * Verify that the user can access the individual product page from the checkout flow.
     * <p>
     * Steps:
     * 1. Open the application and log in with valid credentials.
     * 2. Add a product to the cart.
     * 3. Click the "Checkout" button and complete the form with valid data.
     * 4. Click on the product name in the checkout list and verify it matches the product on the individual page.
     * <p>
     * Expected result:
     * Successful redirection to the individual product page.
     */
    @Test
    public void navigate_to_product_page() {
        openApplication();
        login();
        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        checkoutManager.fillInForm();
        String expectedText = applicationManager.getTextOnElement(items_name_list);
        applicationManager.clickOnElement(items_name_list);
        WaitUtils.checkVisibility(product_name, driver);
        Assert.assertEquals(expectedText, applicationManager.getTextOnElement(product_name), "Products do not match");
    }
}
