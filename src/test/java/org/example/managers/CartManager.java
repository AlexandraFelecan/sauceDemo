package org.example.managers;

import org.example.config.AbstractAcceptance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.managers.MainPageManager.add_to_cart_buttons;
import static org.example.managers.MainPageManager.remove_btn;

public class CartManager extends AbstractAcceptance {

    public static String Cart_icon = "#shopping_cart_container";

    public void addToCart(){
        List<WebElement> addButtonsAll = driver.findElements(By.cssSelector(add_to_cart_buttons));
        List<WebElement> addButtons = new ArrayList<>();

        for (WebElement button : addButtonsAll) {
            if (button.getText().equalsIgnoreCase("Add to cart")) {
                addButtons.add(button);
            }
        }
        int randomIndex = applicationManager.randomInt(0, addButtons.size() - 1);
        WebElement randomButton = addButtons.get(randomIndex);

        randomButton.click();
    }

    public void removeFromCart() throws InterruptedException {
        applicationManager.clickOnElement(remove_btn);
        Thread.sleep(Duration.ofSeconds(3));
    }
}
