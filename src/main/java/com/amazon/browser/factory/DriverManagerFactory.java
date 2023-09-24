package com.amazon.browser.factory;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser){
        DriverManager driverManager;

        switch (browser){
            case "chrome" -> driverManager = new ChromeDriverManager();
            case "safari" -> driverManager = new SafariDriverManager();
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        }
        return driverManager;
    }
}
