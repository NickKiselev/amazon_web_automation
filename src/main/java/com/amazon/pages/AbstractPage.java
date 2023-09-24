package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    protected void openURL(String url){
        driver.get(url);
    }

    protected void click(WebElement element){
        waiterFunction(element).click();
    }

    protected void typeText(String text, WebElement element){
        waiterFunction(element).sendKeys(text);
    }

    protected String getText(WebElement element){
        return waiterFunction(element).getText();
    }

    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    protected boolean compareMaps(Map<String, String> allAccountCards, Map<String, String> expectedValues){

        if(allAccountCards.size()!=0 && expectedValues.size() != 0) {
            for (String key : allAccountCards.keySet()) {
                if (!expectedValues.containsKey(key)) {
                    return false;
                }
                if (!allAccountCards.get(key).equals(expectedValues.get(key))) {
                    return false;
                }
            }
        }else{
            throw new IllegalArgumentException("Lists are empty. Cannot check.");
        }
        return true;
    }

    private WebElement waiterFunction(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}
