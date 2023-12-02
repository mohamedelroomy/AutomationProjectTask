package com.orangehrm.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static  String PROPERTY_FILE ;
    private static Properties properties = new Properties();



    public static String getProperty(String key,String propertyFile) {
        PROPERTY_FILE=propertyFile;
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new IOException("Property file not found: " + PROPERTY_FILE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(key);
    }
}



