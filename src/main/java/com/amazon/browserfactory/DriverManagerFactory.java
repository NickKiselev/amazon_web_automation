package com.amazon.browserfactory;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser){
        DriverManager driverManager;

        switch (browser){
            case "chrome" -> driverManager = new ChromeDriverManager();
            case "safari" -> driverManager = new SafariDriverManager();
            default -> driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}
