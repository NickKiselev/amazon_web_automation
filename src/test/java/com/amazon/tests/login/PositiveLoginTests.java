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
public class PositiveLoginTests extends AbstractTest {

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void positiveLoginTest(Map<String,String> testData){
        String login = testData.get("username");
        String password = testData.get("password");
        String profileName = testData.get("profile_name");

        logger.info("LOGIN: " + login);
        logger.info("PASSWORD " + password);

        String actualProfileText = new MainPage(driver)
                .openPage()
                .openSignInPage()
                .enterLogin(login)
                .tapContinueButton()
                .enterPassword(password)
                .tapSignInButton()
                .getAccountName();

        Assert.assertEquals(actualProfileText, profileName);
    }



}
