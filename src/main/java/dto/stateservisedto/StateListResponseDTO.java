package dto.stateservisedto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateListResponseDTO {
    private List<String> messages;
        private List<StateDTO> result;
}
