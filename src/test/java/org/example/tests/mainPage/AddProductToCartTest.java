package org.example.tests.mainPage;

import org.example.config.AbstractAcceptance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.managers.MainPageManager.add_to_cart_buttons;
import static org.example.managers.MainPageManager.remove_btn;

@Listeners(org.example.listeners.ExtentListener.class)

public class AddProductToCartTest extends AbstractAcceptance {

    /**
     * Add a product to the cart:
     * 1. Access the application and open the homepage.
     * 2. Log in with valid user credentials.
     * 3. Click on the “Add to cart” button for a randomly selected product.
     * 4. Verify that the button’s text changes to “Remove”, confirming the product was added successfully.
     * Expected result: The clicked button should update its label to “Remove”, indicating the product is now in the cart.
     */
    @Test
    public void addToCart() {
        openApplication();
        login();

        List<WebElement> addButtons = driver.findElements(By.cssSelector(add_to_cart_buttons));
        int randomIndex = applicationManager.randomInt(0, addButtons.size() - 1);

        WebElement randomButton = addButtons.get(randomIndex);
        Assert.assertEquals(randomButton.getText(), "Add to cart", "Initial button text is not 'Add to cart'");

        randomButton.click();
        WebElement remove = driver.findElement(By.cssSelector(remove_btn));
        Assert.assertEquals(remove.getText(), "Remove");

    }
}
