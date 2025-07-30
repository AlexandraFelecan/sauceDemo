package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.managers.ApplicationManager;
import org.example.utils.WaitUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.example.managers.LoginManager.Login_BTN;

public class AbstractAcceptance {

    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver localDriver = new ChromeDriver(options);
        localDriver.manage().window().maximize();
        this.driver = localDriver;

        this.applicationManager = new ApplicationManager(this.driver);
    }

    protected void openApplication(){
        driver.get("https://www.saucedemo.com/");
        WaitUtils.checkVisibility(Login_BTN, driver);
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
