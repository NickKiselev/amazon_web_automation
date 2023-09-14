package com.amazon.tests.searchbox;

import com.amazon.base.classes.AbstractTest;
import com.amazon.data.provider.CsvDataProvider;
import com.amazon.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeSearchBoxTests extends AbstractTest {

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void invalidInputIntoSearchBoxTest(Map<String,String> testData){
        String query = testData.get("query");
        String expectedText = testData.get("output_text");

        String actualMessage = new MainPage(driver)
                .openPage()
                .enterSearchQuery(query)
                .launchSearch()
                .getInvalidOutlineText();
        Assert.assertEquals(actualMessage,expectedText, "Text is not equal");
    }

    @Test
    public void emptyInputIntoSearchBoxTest(){
        String actualURL = new MainPage(driver)
                .openPage()
                .enterSearchQuery("")
                .launchSearch()
                .getCurrentURL();

        Assert.assertEquals(actualURL,"https://www.amazon.com/", "URL is not equal");
    }

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void spellingErrorInputIntoSearchBoxTest(Map<String,String> testData){
        String query = testData.get("query");
        String expectedText = testData.get("output_text");

        String actualMessage = new MainPage(driver)
                .openPage()
                .enterSearchQuery(query)
                .launchSearch()
                .getCorrectedOutlineText();
        Assert.assertEquals(actualMessage,expectedText, "Text is not equal");
    }
}
