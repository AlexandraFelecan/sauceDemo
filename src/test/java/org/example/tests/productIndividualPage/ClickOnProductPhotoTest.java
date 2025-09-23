package org.example.tests.productIndividualPage;

import org.example.config.AbstractAcceptance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.example.managers.MainPageManager.*;
import static org.example.utils.WaitUtils.WAIT_TIMEOUT;

public class ClickOnProductPhotoTest extends AbstractAcceptance {

    /**
     * Validate navigation to product individual page via product image:
     * 1. Open the application.
     * 2. Login using valid credentials.
     * 3. Select a product at random and click on its image.
     * 4. Capture the product name before navigation.
     * 5. After navigation, assert that the product detail page displays the correct product name.
     * Expected result: The product name displayed on the detail page matches the selected product.
     */
    @Test
    public void clickOnProductPhoto() {
        openApplication();
        login();

        List<WebElement> productNames = driver.findElements(By.cssSelector(items_name_list));
        List<WebElement> productImages = driver.findElements(By.cssSelector(product_photos));

        int randomIndex = applicationManager.randomInt(0, productImages.size() - 1);

        String expectedProductName = productNames.get(randomIndex).getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(productImages.get(randomIndex)));
        productImages.get(randomIndex).click();

        Assert.assertEquals(applicationManager.getTextOnElement(product_name), expectedProductName, "Displayed product name doesn't match selected one.");
    }
}
