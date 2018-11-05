package steps;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;
import io.restassured.response.Response;


public class StepsForStateService extends MainSteps {


    public StateResponseDTO convertResponseToStateObject(Response response) {

        StateResponseDTO stateResponseDTO = restRequestTransfer.objectRepresentationState(response);
        return stateResponseDTO;
    }

    public StateListResponseDTO convertResponseToStatesListObject(Response response) {

        StateListResponseDTO stateListResponseDTO = restRequestTransfer.objectRepresentationStateList(response);
        return stateListResponseDTO;
    }
}

