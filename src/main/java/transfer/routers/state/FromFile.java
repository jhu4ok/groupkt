package transfer.routers.state;

import dto.stateservisedto.StateResponseDTO;
import transfer.ExpectedObjectFromFile;
import util.FileReaderUtil;

import java.io.BufferedReader;


public class FromFile {

    public ExpectedObjectFromFile<StateResponseDTO> get(String filePath) {
        BufferedReader reader = FileReaderUtil.readFile(filePath);
        return new ExpectedObjectFromFile<>(reader, StateResponseDTO.class);
    }


}
