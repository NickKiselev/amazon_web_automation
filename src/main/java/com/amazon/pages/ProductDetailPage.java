package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends AbstractPage{
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartIcon;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ProductDetailPage addToCart(){
        click(addToCartButton);
        return this;
    }

    public CartPage openCart(){
        click(cartIcon);
        return new CartPage(driver);
    }
}
