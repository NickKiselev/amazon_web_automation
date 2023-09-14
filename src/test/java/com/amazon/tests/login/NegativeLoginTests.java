package com.amazon.tests.login;

import com.amazon.base.classes.AbstractTest;
import com.amazon.data.provider.CsvDataProvider;
import com.amazon.pages.MainPage;
import com.amazon.testlistener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Map;


@Listeners({TestListener.class})
public class NegativeLoginTests extends AbstractTest {

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void negativeLoginTest(Map<String,String> testData){
        String login = testData.get("username");
        String errorMessage = testData.get("error");
        logger.info("LOGIN: " + login);
        logger.info("ERROR MESSAGE " + errorMessage);

        String actualErrorMessage = new MainPage(driver)
                .openPage()
                .openSignInPage()
                .enterLogin(login)
                .tapContinueButton()
                .getMessageTextFromModal();

        Assert.assertEquals(actualErrorMessage, errorMessage);
    }

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void negativePasswordTest(Map<String,String> testData){
        String login = testData.get("username");
        String password = testData.get("password");
        String errorMessage = testData.get("error");

        logger.info("LOGIN: " + login);
        logger.info("PASSWORD: " + password);
        logger.info("ERROR MESSAGE " + errorMessage);

        String actualErrorMessage = new MainPage(driver)
                .openPage()
                .openSignInPage()
                .enterLogin(login)
                .tapContinueButton()
                .enterPassword(password)
                .tapSignInButton()
                .getMessageTextFromModal();

        Assert.assertEquals(actualErrorMessage, errorMessage);
    }
}
