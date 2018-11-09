package util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderUtil {

    private static BufferedReader rd;

    public static BufferedReader readFile(String filePath) {

        try {
            rd = new BufferedReader(new FileReader(filePath));
            if (rd == null) {
                throw new FileNotFoundException("Wrong file path");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rd;
    }
}
