package org.example.tests.mainPage;

import org.example.config.AbstractAcceptance;
import org.example.utils.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import java.util.List;

import static org.example.managers.MainPageManager.*;

@Listeners(org.example.listeners.ExtentListener.class)
public class FilterTest extends AbstractAcceptance {

    /**
     * * Test product sorting by price:
     * * 1. Open application
     * * 2. Login with valid credentials
     * * 3. Click the "Sort" button
     * * 4. Sort products by price in the specified order ("Price (low to high)" or "Price (high to low)")
     * * 5. Verify that products are displayed in the correct numerical order according to the chosen sort
     * Expected result: Product prices should be displayed in the selected numerical order (ascending or descending).
     *
     */
    @Test(dataProvider = "sortingByPrice", dataProviderClass = DataProviders.class)
    public void sortingByPrice(String sorter) {
        openApplication();
        login();
        applicationManager.selectElementsOnDropdown(sort_BTN, "Name (Z to A)");
        applicationManager.selectElementsOnDropdown(sort_BTN, sorter);

        List<WebElement> prices = driver.findElements(By.cssSelector(items_price_list));


        for (int i = 0; i < prices.size() - 1; i++) {
            String currentText = prices.get(i).getText();
            String nextText = prices.get(i + 1).getText();

            double currentPrice = Double.parseDouble(currentText.replace("$", "").trim());
            double nextPrice = Double.parseDouble(nextText.replace("$", "").trim());

            if (sorter.equals("Price (low to high)")) {
                Assert.assertTrue(currentPrice <= nextPrice, "Prices are not in ascending order.");
            } else if (sorter.equals("Price (high to low)")) {
                Assert.assertTrue(currentPrice >= nextPrice, "Prices are not in descending order.");
            }
        }
    }


    /**
     * * Test product sorting by name:
     * 1. Open application
     * 2. Login with valid credentials
     * 3. Click the "Sort" button
     * 4. Sort products by name in the specified order (ascending "Name (A to Z)" or descending "Name (Z to A)")
     * 5. Verify that products are displayed in the correct alphabetical order according to the chosen sort
     * Expected result: Product names should be displayed in the selected alphabetical order (A–Z or Z–A).
     *
     * @param sorter
     */
    @Test(dataProvider = "sortingByName", dataProviderClass = DataProviders.class)
    public void sortingByName(String sorter) {
        openApplication();
        login();
        applicationManager.selectElementsOnDropdown(sort_BTN, "Price (high to low)");
        applicationManager.selectElementsOnDropdown(sort_BTN, sorter);

        List<WebElement> item_names = driver.findElements(By.cssSelector(items_name_list));

        for (int i = 0; i < item_names.size() - 1; i++) {
            String currentName = item_names.get(i).getText();
            String nextName = item_names.get(i + 1).getText();

            if (sorter.equals("Name (A to Z)")) {
                Assert.assertTrue(currentName.compareTo(nextName) <= 0,
                        "Items are not sorted ascending: " + currentName + " vs " + nextName);
            } else if (sorter.equals("Name (Z to A)")) {
                Assert.assertTrue(currentName.compareTo(nextName) >= 0,
                        "Items are not sorted descending: " + currentName + " vs " + nextName);
            }
        }
    }
}
