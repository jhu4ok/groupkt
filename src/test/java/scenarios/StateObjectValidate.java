package scenarios;

import assertions.StateServiceAssertions;
import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.StepsForStateService;


public class StateObjectValidate {

    StateServiceAssertions assertion = new StateServiceAssertions();
    StepsForStateService step = new StepsForStateService();

    @BeforeMethod
    public void setUp() {

        step.initialiseBaseURI("HOST_STATE");

    }

    @Test
    public void successGetAllStatesResponse() {

        Response getResponse = step.sendGetRequest("ALL_STATES_RESOURCE");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForStatesList("MESSAGE_SUCCESS_LIST", stateListResponseDTO, "", "");
        assertion.assertResponseContainsListOfAllStates("USA_STATES_COUNT", stateListResponseDTO);
    }

    @Test
    public void successGetOneStateResponse() {

        Response getResponse = step.sendGetRequest("ONE_STATE_RESOURCE");
        StateResponseDTO stateResponseDTO = step.convertResponseToStateObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForState("MESSAGE_SUCCESS_STATE", stateResponseDTO, "ONE_STATE_RESOURCE");
        assertion.assertResponseContainsCorrectStateInfo("ONE_STATE_RESOURCE", stateResponseDTO);
    }


    @Test
    public void getNothingMatchingFound() {

        Response getResponse = step.sendGetRequest("INVALID_STATE_RESOURCE");
        StateResponseDTO stateResponseDTO = step.convertResponseToStateObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForState("MESSAGE_NOTHING_STATE", stateResponseDTO, "INVALID_STATE_RESOURCE");

    }


    @Test
    public void getStateByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("KEY_TEXT", "TEXT", "SEARCH_STATE_RESOURCE");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForStatesList("MESSAGE_SUCCESS_LIST", stateListResponseDTO, "", "");
        assertion.assertResponseContainsListOfAllStates("COUNT_WA_STATES", stateListResponseDTO);

    }


    @Test
    public void getNothingStateByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("KEY_TEXT", "INVALID_TEXT", "SEARCH_STATE_RESOURCE");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);

        assertion.assertResponseMessageForStatesList("MESSAGE_NOTHING_STATE",
                stateListResponseDTO, "SEARCH_STATE_RESOURCE", "INVALID_TEXT");
        assertion.assertResponseContainsListOfAllStates("NOTHING", stateListResponseDTO);

    }
}
