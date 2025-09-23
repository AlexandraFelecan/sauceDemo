package org.example.managers;

import org.openqa.selenium.WebDriver;

public class CheckoutManager {
    private WebDriver driver;
    private ApplicationManager applicationManager;


    public CheckoutManager(WebDriver driver) {
        this.driver = driver;
        this.applicationManager = new ApplicationManager(driver);
    }

    // SELECTORS
    public static String first_name_input = "#first-name";
    public static String last_name_input = "#last-name";
    public static String postal_code = "#postal-code";
    public static String cancel_btn = "#cancel";
    public static String continue_btn = "#continue";
    public static String finish_btn = "#finish";
    public static String back_home_btn = "#back-to-products";
    public static String order_complete_msg = ".complete-header";
    public static String first_name_error_msg = "Error: First Name is required";
    public static String last_name_error_msg = "Error: Last Name is required";
    public static String postal_code_error_msg = "Error: Postal Code is required";

    // METHODS

    public void fillInForm() {
        applicationManager.writeOnElement(first_name_input, "Abc");
        applicationManager.writeOnElement(last_name_input, "Abc");
        applicationManager.writeOnElement(postal_code, "456");
        applicationManager.clickOnElement(continue_btn);
    }
}
