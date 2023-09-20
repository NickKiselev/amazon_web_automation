package com.amazon.base.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriverInstance(String browser) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        if(driver == null){
            switch (browser) {
                case "chrome" -> {
                    return driver = new ChromeDriver();
                }
                case "safari" -> {
                    return driver = new SafariDriver();
                }
                case "edge" -> {
                    return driver = new EdgeDriver();
                }
                case "firefox" -> {
                    return driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}