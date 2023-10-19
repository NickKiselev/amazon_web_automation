package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//span[contains(text(), 'Account & Lists')]")
    private WebElement accountListMenu;

    @FindBy(xpath = "//span[@class='nav-text'][contains(text(), 'Account')]")
    private WebElement accountLink;

    @FindBy(xpath = "//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement signInForm;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement errorMessage;

    private final String URL = "https://www.amazon.com";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage(){
        openURL(URL);
        return this;
    }

    public SignInPage openSignInPage(){
        click(signInForm);
        return new SignInPage(driver);
    }

    public String getAccountName(){
        return signInForm.getText();
    }

    public String getMessageTextFromModal(){
        return getText(errorMessage);
    }
    public MainPage enterSearchQuery(String query){
        typeText(query, searchBox);
        return this;
    }

    public SearchResultsPage launchSearch(){
        click(searchButton);
        return new SearchResultsPage(driver);
    }

    public MainPage openAccountListMenu(){
        new Actions(driver).moveToElement(waiterFunction(accountListMenu)).build().perform();
        return this;
    }

    public YourAccountPage openAccountPage(){
        click(accountLink);
        return new YourAccountPage(driver);
    }






}
