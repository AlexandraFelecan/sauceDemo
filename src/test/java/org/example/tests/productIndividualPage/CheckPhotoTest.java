package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.managers.MainPageManager.product_img;
import static org.example.managers.MainPageManager.product_photos;

public class CheckPhotoTest extends AbstractAcceptance {

    /**
     * Verify navigation to product detail page via product image:
     * <p>
     * Steps:
     * 1. Access the application.
     * 2. Log in with valid credentials.
     * 3. Click on a random product image.
     * 4. Wait for the product detail image to load.
     * 5. Assert that the displayed image matches the selected product's image.
     * <p>
     * Expected result:
     * The product detail page shows the same image as the one clicked on the main page.
     */

    @Test
    public void checkPhoto() {
        openApplication();
        login();

        List<WebElement> productImages = driver.findElements(By.cssSelector(product_photos));
        int randomIndex = applicationManager.randomInt(0, productImages.size() - 1);

        String expectedImageSrc = productImages.get(randomIndex).getAttribute("src");
        productImages.get(randomIndex).click();

        String actualImageSrc = driver.findElement(By.cssSelector(product_img)).getAttribute("src");

        Assert.assertEquals(actualImageSrc, expectedImageSrc, "The displayed product image does not match the selected one.");
    }
}
