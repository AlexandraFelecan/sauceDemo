package org.example.managers;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageManager {

    private WebDriver driver;

    public MainPageManager(WebDriver driver) {
        this.driver = driver;
    }

    // SELECTORS

    public static String sort_BTN = ".product_sort_container";
    public static String items_price_list = ".inventory_item_price";
    public static String items_name_list = ".inventory_item_name";
    public static String add_to_cart_buttons = ".btn_primary";
    public static String remove_btn = ".btn_secondary";
    public static String product_name = ".inventory_details_name";
    public static String product_photos = ".inventory_item_img img";
    public static String product_desc_list = ".inventory_item_desc";
    public static String product_img = ".inventory_details_img";
    public static String product_desc = ".inventory_details_desc";
    public static String price_list = ".inventory_item_price";
    public static String product_price = ".inventory_details_price";
    public static String add_product_to_cart = "#add-to-cart";
    public static String remove_btn_individual = "#remove";
    public static String back_to_products = "#back-to-products";
    public static String burger_menu = "#react-burger-menu-btn";
    public static String all_items_btn = "#inventory_sidebar_link";


    //METHODS
    public String clickRandomProduct() {
        List<WebElement> productNames = driver.findElements(By.cssSelector(items_name_list));
        int randomIndex = ApplicationManager.randomInt(0, productNames.size() - 1);
        WebElement randomProduct = productNames.get(randomIndex);

        String productNameText = randomProduct.getText();
        randomProduct.click();
        WaitUtils.checkVisibility(product_name, driver);
        return productNameText;
    }
}
