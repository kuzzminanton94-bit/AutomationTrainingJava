package com.aqa.config;

public class Config {
    public static BrowserType getBrowserType() {
        String browser = System.getProperty("browser", "chromium");

        return BrowserType.valueOf(browser.toUpperCase());
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(
                System.getProperty("headless", "false")
        );
    }
}
