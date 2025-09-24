package org.example.tests.chechoutPage;

import org.example.config.AbstractAcceptance;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.CartManager.Checkout_btn;
import static org.example.managers.CheckoutManager.*;
import static org.example.managers.LoginManager.Error_msg;
import static org.testng.Assert.assertEquals;

@Listeners(org.example.listeners.ExtentListener.class)

public class FillFormWrongTest extends AbstractAcceptance {
    /**
     * Verify that the checkout process shows an error when all fields are empty.
     * <p>
     * Steps:
     * 1. Open the application.
     * 2. Log in with valid credentials.
     * 3. Add a product to the cart and go to checkout.
     * 4. Click "Continue" without filling any fields.
     * <p>
     * Expected result:
     * The error message "Error: First Name is required" is displayed.
     */


    @Test
    public void continue_with_empty_fields() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        applicationManager.clickOnElement(continue_btn);
        assertEquals(first_name_error_msg, applicationManager.getTextOnElement(Error_msg));
    }

    /**
     * Verify that the checkout process shows an error when the last name is missing.
     * <p>
     * Steps:
     * 1. Open the application.
     * 2. Log in with valid credentials.
     * 3. Add a product to the cart and go to checkout.
     * 4. Fill first name and postal code, leave last name empty, then click "Continue".
     * <p>
     * Expected result:
     * The error message "Error: Last Name is required" is displayed.
     */

    @Test
    public void continue_without_last_name() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        applicationManager.writeOnElement(first_name_input, "Abc");
        applicationManager.writeOnElement(postal_code, "456");
        applicationManager.clickOnElement(continue_btn);
        assertEquals(last_name_error_msg, applicationManager.getTextOnElement(Error_msg));
    }

    /**
     * Verify that the checkout process shows an error when the first name is missing.
     * <p>
     * Steps:
     * 1. Open the application.
     * 2. Log in with valid credentials.
     * 3. Add a product to the cart and go to checkout.
     * 4. Fill last name and postal code, leave first name empty, then click "Continue".
     * <p>
     * Expected result:
     * The error message "Error: First Name is required" is displayed.
     */
    @Test
    public void continue_without_first_name() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        applicationManager.writeOnElement(last_name_input, "Abc");
        applicationManager.writeOnElement(postal_code, "456");
        applicationManager.clickOnElement(continue_btn);
        assertEquals(first_name_error_msg, applicationManager.getTextOnElement(Error_msg));
    }

    /**
     * Verify that the checkout process shows an error when the postal code is missing.
     * <p>
     * Steps:
     * 1. Open the application.
     * 2. Log in with valid credentials.
     * 3. Add a product to the cart and go to checkout.
     * 4. Fill first and last name, leave postal code empty, then click "Continue".
     * <p>
     * Expected result:
     * The error message "Error: Postal Code is required" is displayed.
     */

    @Test
    public void continue_without_postal_code() {
        openApplication();
        login();

        cartManager.addToCart();
        applicationManager.clickOnElement(Cart_icon);
        applicationManager.clickOnElement(Checkout_btn);
        applicationManager.writeOnElement(first_name_input, "Abc");
        applicationManager.writeOnElement(last_name_input, "Abc");
        applicationManager.clickOnElement(continue_btn);
        assertEquals(postal_code_error_msg, applicationManager.getTextOnElement(Error_msg));
    }
}
