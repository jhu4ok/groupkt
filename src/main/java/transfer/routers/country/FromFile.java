package transfer.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import transfer.ExpectedObjectFromFile;
import util.FileReaderUtil;

import java.io.BufferedReader;


public class FromFile {

    public ExpectedObjectFromFile<CountryResponseDTO> get(String filePath) {
        BufferedReader reader = FileReaderUtil.readFile(filePath);
        return new ExpectedObjectFromFile<>(reader, CountryResponseDTO.class);
    }


}
