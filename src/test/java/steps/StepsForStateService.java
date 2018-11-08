package steps;

import assertions.StateServiceAssertions;
import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import transfer.Api;
import transfer.Context;
import transfer.StateResponseTransfer;
import transfer.routers.state.ByState;


public class StepsForStateService extends MainSteps {

    private final ByState searchByState = new Api().getState().getByState();

    public StateResponseDTO convertResponseToStateObject(Response response) {

        StateResponseDTO stateResponseDTO = StateResponseTransfer.stateObjectRepresentation(response);
        return stateResponseDTO;
    }


    public void basicResponseAssertion(Response getResponse, String expectedMessage, StateResponseDTO stateResponseDTO, String resourseURL, String value) {

        StateServiceAssertions.assertStatusCode(getResponse, HttpStatus.SC_OK);
        StateServiceAssertions.assertResponseMessage(expectedMessage, stateResponseDTO, resourseURL, value);
    }

    public Context<StateResponseDTO> getStateByName(String state) {
        return searchByState.get(state);
    }
}

