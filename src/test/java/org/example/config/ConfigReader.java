package org.example.config;

import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (Exception ignored) {
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
