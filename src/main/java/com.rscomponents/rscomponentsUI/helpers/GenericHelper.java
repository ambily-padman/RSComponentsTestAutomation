package com.rscomponents.rscomponentsUI.helpers;

import com.opencsv.CSVReader;
import com.rscomponents.configuration.TestConfiguration;
import com.rscomponents.rscomponentsUI.models.EndToEnd;
import com.rscomponents.rscomponentsUI.models.SearchFilter;
import com.rscomponents.rscomponentsUI.models.TestDataType;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GenericHelper<T> {
    @Autowired
    protected TestConfiguration testConfiguration;

    @Autowired
    protected  EndToEndHelper endToEndHelper;

    @Autowired
    protected  SearchFilterHelper searchFilterHelper;

    private String resourcesFolder = "/src/main/resources/testData/";

    public List<T> readTestDataFromCSV(TestDataType testDataType) {
        List<T> endToEnds = new ArrayList<>();
        try {

            String file = System.getProperty("user.dir") + resourcesFolder + getTheTestDataFilename(testDataType);
            Reader reader = Files.newBufferedReader(Paths.get(file));
            CSVReader csvReader = new CSVReader(reader);
            String[] attributes;
            while ((attributes = csvReader.readNext()) != null) {
                Object endToEnd = createTestData(testDataType,attributes);
                endToEnds.add((T) endToEnd);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();


        }

        return endToEnds;
    }

    private String getTheTestDataFilename(TestDataType testDataType) {
        String fileName = "";
        switch (testDataType) {
            case SEARCH_FILTER:
                fileName = testConfiguration.getSearchTestDataFile();
                break;
            case END_TO_END:
                fileName = testConfiguration.getEndToEndTestDataFile();
                break;
            default:
                break;
        }
        return fileName;
    }

    private Object createTestData(TestDataType testDataType,String[] attributes) {
        Object t= null;
        switch (testDataType){
            case SEARCH_FILTER:
                t=searchFilterHelper.createSearchFilterTestData(attributes);
                break;
            case END_TO_END:
                t=endToEndHelper.createEndToEndTestData(attributes);
                break;
        }
        return  t;
    }




}
