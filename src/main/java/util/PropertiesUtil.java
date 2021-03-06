package util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class PropertiesUtil {


    public static String getProp(String propertyName){

        Properties prop = new Properties();

        try {

            String propertyFileName = "\\src\\main\\resources\\env.properties";
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + propertyFileName);
            if (file != null) {
                prop.load(file);
            } else {
                throw new FileNotFoundException("propertyFileName " + "' not found in the " + "classpath");
            }
        } catch (Exception e) {

            System.out.println("Exception: " + e);
        }

        return prop.getProperty(propertyName);
    }
}


