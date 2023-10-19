package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage enterLogin(String login){
        typeText(login, loginField);
        return this;
    }

    public SignInPage enterPassword(String password){
        typeText(password,passwordField);
        return this;
    }

    public SignInPage tapContinueButton(){
        click(continueButton);
        return this;
    }

    public MainPage tapSignInButton(){
        click(signInButton);
        return new MainPage(driver);
    }

    public String getMessageTextFromModal(){
        return getText(errorMessage);
    }

}
