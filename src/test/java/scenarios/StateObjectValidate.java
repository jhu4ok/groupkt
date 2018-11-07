package scenarios;

import assertions.StateServiceAssertions;
import dto.stateservisedto.StateResponseDTO;


import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.StepsForStateService;

import java.io.IOException;
import java.net.URISyntaxException;


public class StateObjectValidate {

    StateServiceAssertions assertion = new StateServiceAssertions();
    StepsForStateService step = new StepsForStateService();


    @BeforeMethod
    public void setUp() throws URISyntaxException, IOException {

        step.initialiseBaseURI("HOST_STATE");

    }


    @Test
    public void successGetAllStatesResponse() {

        Response getResponse = step.sendGetRequest("ALL_STATES_RESOURCE");
        StateResponseDTO stateResponse = step.convertResponseToStateObject(getResponse);

        step.basicResponseAssertion(getResponse, StateServiceAssertions.MESSAGE_SUCCESS_LIST, stateResponse, "", "");
        assertion.assertResponseContainsListOfAllStates(StateServiceAssertions.USA_STATES_COUNT, stateResponse);
    }


    @Test
    public void successGetOneStateResponse() {

        Response getResponse = step.sendGetRequest("ONE_STATE_RESOURCE");
        StateResponseDTO stateResponse = step.convertResponseToStateObject(getResponse);

        step.basicResponseAssertion(getResponse, StateServiceAssertions.MESSAGE_SUCCESS_STATE, stateResponse, "USA_STATES_COUNT", "");
        assertion.assertResponseContainsCorrectStateInfo("ONE_STATE_RESOURCE", stateResponse);
    }


    @Test
    public void getNothingMatchingFound() {

        Response getResponse = step.sendGetRequest("INVALID_STATE_RESOURCE");
        StateResponseDTO stateResponse = step.convertResponseToStateObject(getResponse);

        step.basicResponseAssertion(getResponse, StateServiceAssertions.MESSAGE_NOTHING, stateResponse, "INVALID_STATE_RESOURCE", "");
    }


    @Test
    public void getStateByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("KEY_TEXT", "TEXT", "SEARCH_STATE_RESOURCE");
        StateResponseDTO stateResponse = step.convertResponseToStateObject(getResponse);

        step.basicResponseAssertion(getResponse, StateServiceAssertions.MESSAGE_SUCCESS_LIST, stateResponse, "SEARCH_STATE_RESOURCE", "TEXT");
        assertion.assertResponseContainsListOfAllStates(StateServiceAssertions.COUNT_WA_STATES, stateResponse);
    }


    @Test
    public void getNothingStateByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("KEY_TEXT", "INVALID_TEXT", "SEARCH_STATE_RESOURCE");
        StateResponseDTO stateResponse = step.convertResponseToStateObject(getResponse);

        step.basicResponseAssertion(getResponse, StateServiceAssertions.MESSAGE_NOTHING, stateResponse, "SEARCH_STATE_RESOURCE", "INVALID_TEXT");
        assertion.assertResponseContainsListOfAllStates(StateServiceAssertions.NOTHING, stateResponse);
    }
}
