package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.managers.ApplicationManager;
import org.example.managers.CartManager;
import org.example.managers.CheckoutManager;
import org.example.managers.MainPageManager;
import org.example.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.example.managers.CartManager.Cart_icon;
import static org.example.managers.LoginManager.*;

public class AbstractAcceptance {

    protected WebDriver driver;

    protected ApplicationManager applicationManager;
    protected MainPageManager mainPageManager;
    protected CartManager cartManager;
    protected CheckoutManager checkoutManager;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        applicationManager = new ApplicationManager(driver);
        mainPageManager = new MainPageManager(driver);
        cartManager = new CartManager(driver);
        checkoutManager = new CheckoutManager(driver);
    }

    protected void openApplication() {
        driver.get(ConfigReader.get("app.url"));
        WaitUtils.checkVisibility(Login_BTN, driver);
    }

    protected void login() {
        openApplication();
        applicationManager.writeOnElement(Username_input, Standard_USER);
        applicationManager.writeOnElement(Password_input, Password);
        applicationManager.clickOnElement(Login_BTN);
        WaitUtils.checkVisibility(Cart_icon, driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
