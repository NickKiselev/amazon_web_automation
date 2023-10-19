package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage{
    @FindBy(xpath = "//span[@class='a-truncate sc-grid-item-product-title a-size-base-plus']/span[@class='a-truncate-cut']")
    private WebElement productTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitleFromCart(){
        return getText(productTitle);
    }
}
