package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.testng.annotations.Test;

import static org.example.managers.MainPageManager.back_to_products;
import static org.example.managers.MainPageManager.sort_BTN;

public class ReturnToMainPage extends AbstractAcceptance {

    /**
     * Verify redirection to the main page using the "Back to products" button:
     * 1. Open the application
     * 2. Login with valid credentials
     * 3. Click on a random product name
     * 4. Click the "Back to products" button
     * <p>
     * Expected result: User is redirected back to the main products page.
     */

    @Test
    public void returnToMainPage() {
        openApplication();
        login();
        mainPageManager.clickRandomProduct();
        applicationManager.clickOnElement(back_to_products);
        WaitUtils.checkVisibility(sort_BTN, driver);
    }
}
