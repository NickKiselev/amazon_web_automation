package com.amazon.pages;

import com.amazon.data.provider.CsvConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YourAccountPage extends AbstractPage{
    private Map<String, String> allAccountCards = new HashMap<>();

    private By allCardsTitles = By.xpath("//h2[@class='a-spacing-none ya-card__heading--rich a-text-normal']");

    private By allCardsDescriptions = By.xpath("//span[@class='a-color-secondary']");


    public YourAccountPage(WebDriver driver) {
        super(driver);
    }

    public YourAccountPage getAllCardsIntoList(){
        List<WebElement> titles = findAll(allCardsTitles);
        List<WebElement> descriptions = findAll(allCardsDescriptions);

        if(titles.size()==descriptions.size()){
            for(int i=0; i<titles.size();i++){
                allAccountCards.put(getText(titles.get(i)), getText(descriptions.get(i)));
            }
        }else{
            throw new IllegalArgumentException("Lists have different sizes. Cannot combine.");
        }
        return this;
    }

    public boolean isTitleAndDescriptionCorrect(String csvFilePath){
        Map<String, String> expectedValues = CsvConverter.readCsvToMap(csvFilePath);
        return compareMaps(allAccountCards, expectedValues);
    }

}
