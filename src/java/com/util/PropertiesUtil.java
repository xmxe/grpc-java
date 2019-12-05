package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

	public static String getKey(String name, String fileName) {
        InputStream inputStream = null;
        String strProperty = "";
        try {
            inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            
            if (inputStream == null) {
                return null;
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            strProperty = properties.getProperty(name);                     
        } catch (Exception e) {        	
           e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputStream = null;
            }
        }
        return strProperty;
    }
}
