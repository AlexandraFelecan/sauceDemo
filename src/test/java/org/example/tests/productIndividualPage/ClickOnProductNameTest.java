package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.managers.MainPageManager.items_name_list;
import static org.example.managers.MainPageManager.product_name;

@Listeners(org.example.listeners.ExtentListener.class)

public class ClickOnProductNameTest extends AbstractAcceptance {

    /**
     * Click on a random product name and verify redirection:
     * 1. Open the application
     * 2. Login with valid credentials
     * 3. Click on the name of a random product from the main page
     * 4. Wait for the individual product page to load and display the correct product name
     * <p>
     * Expected result: User is redirected to the correct product details page.
     */

    @Test
    public void clickOnProductName() {
        openApplication();
        login();

        List<WebElement> product_names = driver.findElements(By.cssSelector(items_name_list));
        int randomIndex = applicationManager.randomInt(0, product_names.size() - 1);
        WebElement randomProduct = product_names.get(randomIndex);

        String productNameText = randomProduct.getText();

        randomProduct.click();
        WaitUtils.elementLocatedWithText(product_name, productNameText, driver);
        Assert.assertTrue(applicationManager.getTextOnElement(product_name).contains(productNameText), "Product name does not match");
    }
}
