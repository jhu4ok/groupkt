package transfer.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import util.GetObjectFromJsonUtil;
import util.FileReaderUtil;

import java.io.BufferedReader;


public class FromFile {

    public GetObjectFromJsonUtil<CountryResponseDTO> get(String filePath) {
        BufferedReader reader = FileReaderUtil.readFile(filePath);
        return new GetObjectFromJsonUtil<>(reader, CountryResponseDTO.class);
    }


}
