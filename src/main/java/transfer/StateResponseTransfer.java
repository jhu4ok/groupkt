package transfer;

import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;



public class StateResponseTransfer extends MainResponseTransfer {

    public static StateResponseDTO stateObjectRepresentation(Response response) {

        String stringResponse = parseResponseToString(response);
        StateResponseDTO stateResponseDTO = createGsonObject().fromJson(stringResponse, StateResponseDTO.class);
        return stateResponseDTO;
    }
}
