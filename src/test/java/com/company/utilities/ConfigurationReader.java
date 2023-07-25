package com.company.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties= new Properties();

    static {
        try{
            FileInputStream file= new FileInputStream("configuration.properties");

            properties.load(file);

            file.close();

        }  catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
}
