package org.example.tests.loginInterface;

import org.example.config.AbstractAcceptance;
import org.example.utils.WaitUtils;
import org.junit.jupiter.api.Test;

import static org.example.managers.ApplicationManager.Burger_MENU;
import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.LoginManager.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends AbstractAcceptance {

    /**
     * Login with correct credentials:
     * 1. Open application
     * 2. Insert correct credentials in inputs
     * 3. Click "Login" button
     * 4. Wait for basket icon to load
     * Expected result: Redirected to the application's main page.
     **/
    @Test
    public void correctLogin() {
        openApplication();
        applicationManager.writeOnElement(Username_input, Standard_USER);
        applicationManager.writeOnElement(Password_input, Password);
        applicationManager.clickOnElement(Login_BTN);
        WaitUtils.checkVisibility(Cart_icon, driver);
    }

    /**
     * Login with correct credentials:
     * 1. Open application
     * 2. Insert credentials in inputs
     * 3. Click "Login" button
     * 4. Check for error message
     * Expected result: An error message is expected when entering wrong password
     **/
    @Test
    public void wrongPassword() {
        openApplication();
        applicationManager.writeOnElement(Username_input, Standard_USER);
        applicationManager.writeOnElement(Password_input, "abc");
        applicationManager.clickOnElement(Login_BTN);
        assertEquals(Wrong_credentials_msg, applicationManager.getTextOnElement(Error_msg));
    }

    /**
     * Login with correct credentials:
     * 1. Open application
     * 2. Insert credentials only in password input
     * 3. Click "Login" button
     * 4. Check for error message
     * Expected result: An error message is expected for leaving username blank
     **/
    @Test
    public void usernameInputEmpty() {
        openApplication();
        applicationManager.writeOnElement(Password_input, Password);
        applicationManager.clickOnElement(Login_BTN);
        assertEquals(Username_required, applicationManager.getTextOnElement(Error_msg));
    }

    /**
     * Login with correct credentials:
     * 1. Open application
     * 2. Insert credentials only in username input
     * 3. Click "Login" button
     * 4. Check for error message
     * Expected result: An error message is expected for leaving password blank
     **/
    @Test
    public void passwordInputEmpty() {
        openApplication();
        applicationManager.writeOnElement(Username_input, Standard_USER);
        applicationManager.clickOnElement(Login_BTN);
        assertEquals(Password_required, applicationManager.getTextOnElement(Error_msg));
    }

    /**
     * Login with correct credentials:
     * 1. Open application
     * 2. Insert credentials only in username input
     * 3. Click "Login" button
     * 4. Wait for basket icon
     * 5. Click burger menu
     * 6. Click logout
     * 7. Wait for login button to confirm
     * Expected result: User is successfully logged out and redirected to the login page
     **/

    @Test
    public void logout() {
        openApplication();
        applicationManager.writeOnElement(Username_input, Standard_USER);
        applicationManager.writeOnElement(Password_input, Password);
        applicationManager.clickOnElement(Login_BTN);
        WaitUtils.checkVisibility(Cart_icon, driver);
        applicationManager.clickOnElement(Burger_MENU);
        WaitUtils.checkVisibility(Logout_BTN, driver);
        applicationManager.clickOnElement(Logout_BTN);
        WaitUtils.checkVisibility(Login_BTN, driver);
    }
}