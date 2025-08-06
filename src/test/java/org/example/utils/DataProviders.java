package org.example.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "sortingByPrice")
    public static Object[][] sortingByPrice() {
        return new Object[][]{
                {"Price (high to low)"},
                {"Price (low to high)"},
        };
    }

    @DataProvider(name = "sortingByName")
    public static Object[][] sortingByName() {
        return new Object[][]{
                {"Name (A to Z)"},
                {"Name (Z to A)"},
        };
    }
}
