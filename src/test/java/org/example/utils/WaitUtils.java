package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class WaitUtils {

    public static int WAIT_TIMEOUT = 5;

    public static void checkVisibility(String selector, WebDriver driver) {
        new WebDriverWait(driver, Duration.of(WAIT_TIMEOUT, ChronoUnit.SECONDS)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));

    }

    public static void checkInvisibility(String selector, WebDriver driver) {
        new WebDriverWait(driver, Duration.of(WAIT_TIMEOUT, ChronoUnit.SECONDS)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector)));
    }

    public static void checkInvisibility(String selector, int waitTimeout, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(waitTimeout))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector)));
    }

    public static void elementLocatedWithText(String selector, String text, WebDriver driver) {
        new WebDriverWait(driver, Duration.of(WAIT_TIMEOUT, ChronoUnit.SECONDS)).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(selector), text));
    }

    public static void elementsLocatedWithText(String selector, String text, int index, WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.cssSelector(selector));
        new WebDriverWait(driver, Duration.of(WAIT_TIMEOUT, ChronoUnit.SECONDS)).until(ExpectedConditions.textToBePresentInElement(elements.get(index), text));

    }
}
