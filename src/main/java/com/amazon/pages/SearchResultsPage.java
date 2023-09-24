package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends AbstractPage{
    @FindBy(xpath = "//span[@class='a-size-medium']")
    private WebElement outlineTextResults;

    @FindBy(xpath = "//span[@class='a-size-medium a-text-italic']")
    private WebElement outlineTextQuery;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base'][1]")
    private WebElement outlineNoResults;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base'][2]")
    private WebElement outlineInvalidText;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private WebElement productTitle;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isSearchResultCorrect(String firstKeyWord, String secondKeyWord){
        return isContainsKeyWords(getText(productTitle), firstKeyWord, secondKeyWord);
    }

    private boolean isContainsKeyWords(String inputString, String firstKeyWord, String secondKeyWord){
        String productTitle = inputString.toLowerCase();

        return productTitle.contains(firstKeyWord.toLowerCase()) && productTitle.contains(secondKeyWord.toLowerCase());
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public String getCorrectedOutlineText(){
        return getText(outlineTextResults) + " " + getText(outlineTextQuery);
    }

    public String getInvalidOutlineText(){
        return getText(outlineNoResults) + " " + getText(outlineInvalidText);
    }

    public String getProductTitleText(){
        return getText(productTitle);
    }

    public ProductDetailPage openProductPage(){
        click(productTitle);
        return new ProductDetailPage(driver);
    }

}