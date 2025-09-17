package org.example.managers;

import org.example.config.AbstractAcceptance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.example.managers.MainPageManager.add_to_cart_buttons;

public class CartManager extends AbstractAcceptance {

    private WebDriver driver;

    public CartManager(WebDriver driver) {
        this.driver = driver;
    }

    // SELECTORS
    public static String Cart_icon = "#shopping_cart_container";
    public static String Checkout_btn = "#checkout";
    public static String Cart_item = ".cart_item";
    public static String Continue_shopping_btn = "#continue-shopping";

    //METHODS
    public String addToCart() {
        List<WebElement> productNames = driver.findElements(By.cssSelector(MainPageManager.items_name_list));
        List<WebElement> productPrices = driver.findElements(By.cssSelector(MainPageManager.items_price_list));

        int randomIndex = ApplicationManager.randomInt(0, productNames.size() - 1);
        String selectedPrice = productPrices.get(randomIndex).getText();

        productNames.get(randomIndex).click();

        driver.findElement(By.cssSelector(MainPageManager.add_to_cart_buttons)).click();

        return selectedPrice;
    }
}
