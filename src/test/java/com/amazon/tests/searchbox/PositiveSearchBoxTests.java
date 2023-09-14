package com.amazon.tests.searchbox;

import com.amazon.base.classes.AbstractTest;
import com.amazon.data.provider.CsvDataProvider;
import com.amazon.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PositiveSearchBoxTests extends AbstractTest {

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void positiveSearchBoxTest(Map<String,String> testData){
            String searchQuery = testData.get("query");
            String firstKeyWord = testData.get("key_word_1");
            String secondKeyWord = testData.get("key_word_2");
            System.out.println(firstKeyWord + " AND " + secondKeyWord);

           boolean isSearchCorrect = new MainPage(driver)
                    .openPage()
                    .enterSearchQuery(searchQuery)
                    .launchSearch()
                    .isSearchResultCorrect(firstKeyWord,secondKeyWord);

           Assert.assertTrue(isSearchCorrect, "Search result isn't correct");
    }


}
