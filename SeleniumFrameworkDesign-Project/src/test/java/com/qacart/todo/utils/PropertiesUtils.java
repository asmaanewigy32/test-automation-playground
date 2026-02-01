package com.qacart.todo.utils;

import java.io.*;

public class PropertiesUtils {

    public static java.util.Properties loadProperties(String filePath)
    {
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            java.util.Properties properties = new java.util.Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File isn`t found");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading properties");
        }

    }
}
