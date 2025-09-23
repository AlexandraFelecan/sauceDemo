package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.example.managers.MainPageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.managers.MainPageManager.items_name_list;
import static org.example.managers.MainPageManager.product_desc_list;
import org.testng.annotations.Listeners;
@Listeners(org.example.listeners.ExtentListener.class)

public class CheckDescriptionTest extends AbstractAcceptance {

    /**
     * Verify product details on the individual product page.
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Select a random product and check its description
     * 4. Click on random product and check if description matches in the individual page
     * <p>
     * Expected result:
     * The description of the selected product on the detail page is identical to the description shown on the main page.
     */

    @Test
    public void checkProductDescription() {
        openApplication();
        login();
        List<WebElement> productNames = driver.findElements(By.cssSelector(items_name_list));
        List<WebElement> productDesc = driver.findElements(By.cssSelector(product_desc_list));

        int randomIndex = applicationManager.randomInt(0, productNames.size() - 1);
        String expectedDescription = productDesc.get(randomIndex).getText();

        mainPageManager.clickRandomProduct();

        String actualDescription = driver.findElement(By.cssSelector(MainPageManager.product_desc)).getText();

        Assert.assertEquals(actualDescription, expectedDescription,
                "The product description on the detail page does not match the main page.");
    }
}
