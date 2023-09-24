package com.amazon.tests.addtocart;

import com.amazon.base.classes.BaseTest;
import com.amazon.pages.CartPage;
import com.amazon.pages.MainPage;
import com.amazon.pages.ProductDetailPage;
import com.amazon.pages.SearchResultsPage;
import com.amazon.testlistener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListener.class})
public class AddProductToCartTest extends BaseTest {

    @Test
    public void addProductToCartTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.enterSearchQuery("iphone");
        SearchResultsPage searchResultsPage = mainPage.launchSearch();

        String productTitle = searchResultsPage.getProductTitleText();

        ProductDetailPage productDetailPage = searchResultsPage.openProductPage();
        productDetailPage.addToCart();
        CartPage cartPage = productDetailPage.openCart();

        String productTitleFromCart = cartPage.getProductTitleFromCart();

        Assert.assertEquals(productTitleFromCart, productTitle, "Product name is not the same");
    }
}
