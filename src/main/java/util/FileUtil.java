package util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FileUtil {
    public static FileInputStream fileReader() throws FileNotFoundException {
        return new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\env.properties");
    }
}
