package com.amazon.browserfactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected static WebDriver driver;
    protected abstract void createDriver();

    public WebDriver getDriver(){
        if(driver==null){
            createDriver();
        }
        return driver;
    }

    public void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
