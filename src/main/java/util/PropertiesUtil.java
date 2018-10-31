package util;

import java.io.IOException;
import java.util.Properties;

import static util.FileUtil.fileReader;


public class PropertiesUtil {
    public static String getPropert(String propertyName) throws IOException {
        Properties prop = new Properties();
        prop.load(fileReader());
        prop.get(propertyName);
        return prop.getProperty(propertyName);
    }

}

