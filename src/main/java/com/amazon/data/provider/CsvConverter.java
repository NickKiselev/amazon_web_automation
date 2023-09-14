package com.amazon.data.provider;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvConverter {

    public static Map<String, String> readCsvToMap(String csvPath) {
        Map<String, String> dataMap = new HashMap<>();

        try (CSVParser csvParser = new CSVParser(new FileReader(csvPath), CSVFormat.DEFAULT)){
            for(CSVRecord record:csvParser){
                if(record.size()>=2){
                    String key = record.get(0);
                    String value = record.get(1);
                    dataMap.put(key,value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataMap;
        }
    }

