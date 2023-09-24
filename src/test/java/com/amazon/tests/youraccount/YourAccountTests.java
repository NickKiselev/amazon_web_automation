package com.amazon.tests.youraccount;

import com.amazon.base.classes.BaseTest;
import com.amazon.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class YourAccountTests extends BaseTest {

    @Parameters({"csvFilePath"})
    @Test
    public void yourAccountTest(String csvFilePath){
        boolean isAllCardsPresent = new MainPage(driver)
                .openPage()
                .openAccountListMenu()
                .openAccountPage()
                .getAllCardsIntoList()
                .isTitleAndDescriptionCorrect(csvFilePath);

        Assert.assertTrue(isAllCardsPresent);
    }
}
