package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.managers.ApplicationManager;
import org.example.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.example.managers.LoginManager.*;

public class AbstractAcceptance {

    protected WebDriver driver;
    protected ApplicationManager applicationManager;

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
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
