package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isHeadless() {
        String headlessSys = System.getProperty("headless");
        if (headlessSys != null) {
            return Boolean.parseBoolean(headlessSys);
        }
        return Boolean.parseBoolean(properties.getProperty("browser.headless"));
    }

    public static String getUrlSauceDemo() {
        return properties.getProperty("url.saucedemo");
    }
}
