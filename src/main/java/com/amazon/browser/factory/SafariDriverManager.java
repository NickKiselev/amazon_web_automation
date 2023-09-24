package com.amazon.browser.factory;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager{
    @Override
    protected void createDriver() {
        driver = new SafariDriver();
    }
}
