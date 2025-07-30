package org.example.managers;

import org.openqa.selenium.WebDriver;

public class LoginManager {

    private WebDriver driver;

    // SELECTORS
    public static String Login_BTN = "#login-button";
    public static String Logout_BTN = "#logout_sidebar_link";
    public static String Username_input = "#user-name";
    public static String Password_input = "#password";
    public static String Standard_USER = "standard_user";
    public static String Password = "secret_sauce";
    public static String Error_msg = ".error-message-container";

    // MESSAGES
    public static String Wrong_credentials_msg = "Epic sadface: Username and password do not match any user in this service";
    public static String Username_required = "Epic sadface: Username is required";
    public static String Password_required = "Epic sadface: Password is required";
}
