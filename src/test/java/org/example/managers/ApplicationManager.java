package org.example.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class ApplicationManager {
    private WebDriver driver;


    // SELECTORS
    public static String Burger_MENU = "#react-burger-menu-btn";


    //SOFT ASSERT
    public static SoftAssert softAssert = new SoftAssert();

    public ApplicationManager(WebDriver driver) {
        this.driver = driver;
    }

    public void writeOnElement(String selector, String text) {
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.clear();
        element.sendKeys(text);
    }

    public String getTextOnElement(String selector, int index) {
        List<WebElement> elements = driver.findElements(By.cssSelector(selector));
        return (elements.get(index).getText());
    }

    public String getTextOnElement(String selector) {
        WebElement element = driver.findElement(By.cssSelector(selector));
        return (element.getText());
    }


    public void clickOnElement(String selector) {
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.click();
    }

    public static int randomInt(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }

    public void selectElementsOnDropdown(String selector, String value) {
        WebElement element = driver.findElement(By.cssSelector(selector));
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public int getElementsSize(String selector) {
        return driver.findElements(By.cssSelector(selector)).size();
    }
}