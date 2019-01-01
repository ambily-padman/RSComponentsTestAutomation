package com.rscomponents.rscomponentsUI.utilities;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
//
//    public List<String[]> readAll(Reader reader) throws Exception {
//        CSVReader csvReader = new CSVReader(reader);
//        List<String[]> list = new ArrayList<>();
//        list = csvReader.readAll();
//        reader.close();
//        csvReader.close();
//        return list;
//    }
//
//    public static String[] readCSV(String fileName) {
//       String[] content =null;
//        try {
//            String file = fileName;
//            Reader reader = Files.newBufferedReader(Paths.get(file));
//            CSVReader csvReader = new CSVReader(reader);
//            String[] attributes;
//            while ((attributes = csvReader.readNext()) != null) {
//              content=attributes;
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//        return content;
//    }

}
