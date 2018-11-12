package steps;

import assertions.StateServiceAssertions;
import dto.stateservisedto.StateResponseDTO;
import org.apache.http.HttpStatus;
import transfer.Api;
import transfer.Context;

import transfer.routers.state.ByCountryState;
import transfer.routers.state.ByText;
import transfer.routers.state.FromFile;


public class StepsForStateService  {

    private final ByCountryState searchByCountryState = new Api().getState().getByState();
    private final ByText searchByText = new Api().getState().getByText();
    private final FromFile expectedResult = new FromFile();

    public void responseValidation(Context<StateResponseDTO> context, String expectedResult){

        StateServiceAssertions.assertStatusCode(context.getResponseStatusCode(), HttpStatus.SC_OK);
        StateServiceAssertions.assertObjectsMessage(context.getObjectFromResponse(), this.expectedResult.get(expectedResult).getObjectFromFile());
    }

    public Context<StateResponseDTO> getStateByName(String country, String state) {
        return searchByCountryState.get(country, state);
    }

    public Context<StateResponseDTO> getStateByText(String country, String text) {
        return searchByText.get(country, text);
    }
}

