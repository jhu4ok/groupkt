package steps;

import assertions.StateServiceAssertions;
import dto.stateservisedto.StateResponseDTO;
import org.apache.http.HttpStatus;
import transfer.Api;
import transfer.Context;

import util.GetObjectFromJsonUtil;
import transfer.routers.state.ByCountryState;
import transfer.routers.state.ByText;
import util.FileReaderUtil;

import java.io.BufferedReader;


public class StepsForStateService {

    private final ByCountryState searchByCountryState = new Api().getState().getByState();
    private final ByText searchByText = new Api().getState().getByText();


    public void responseValidation(Context<StateResponseDTO> context, String expectedResult) {

        StateServiceAssertions.assertStatusCode(context.getResponseStatusCode(), HttpStatus.SC_OK);
        StateServiceAssertions.assertObjectsMessage(context.getObjectFromResponse(), getExpectedResult(expectedResult).getObjectFromFile());
    }

    public Context<StateResponseDTO> getStateByName(String country, String state) {
        return searchByCountryState.get(country, state);
    }

    public Context<StateResponseDTO> getStateByText(String country, String text) {
        return searchByText.get(country, text);
    }

    private GetObjectFromJsonUtil<StateResponseDTO> getExpectedResult(String filePath) {
        BufferedReader reader = FileReaderUtil.readFile(filePath);
        return new GetObjectFromJsonUtil<>(reader, StateResponseDTO.class);
    }
}

