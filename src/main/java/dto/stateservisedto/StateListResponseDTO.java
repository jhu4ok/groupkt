package dto.stateservisedto;

import lombok.Getter;

import java.util.List;

@Getter
public class StateListResponseDTO {

    private List<String> messages;
    private List<StateDTO> result;
}
