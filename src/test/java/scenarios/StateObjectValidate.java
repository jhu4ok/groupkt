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
    String expectedMessageSuccess = "State found matching code [";
    String expectedMessageSuccessList = "Total [";
    String expectedMessageNothing = "No matching state found for requested code [";


    @BeforeMethod
    public void setUp() {

        step.initialiseBaseURI("HOST_STATE");

    }

    @Test
    public void successGetAllStatesResponse() {

        Response getResponse = step.sendGetRequest("/get/USA/all");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForStatesList(expectedMessageSuccessList, stateListResponseDTO, "", "");
        assertion.assertResponseContainsListOfAllStates(55, stateListResponseDTO);
    }

    @Test
    public void successGetOneStateResponse() {

        Response getResponse = step.sendGetRequest("/get/USA/AK");
        StateResponseDTO stateResponseDTO = step.convertResponseToStateObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForState(expectedMessageSuccess, stateResponseDTO, "/get/USA/AK");
        assertion.assertResponseContainsCorrectStateInfo(stateResponseDTO);
    }


    @Test
    public void getNothingMatchingFound() {

        Response getResponse = step.sendGetRequest("/get/USA/al");
        StateResponseDTO stateResponseDTO = step.convertResponseToStateObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForState(expectedMessageNothing, stateResponseDTO, "/get/USA/al");

    }


    @Test
    public void getStateByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("text", "wa", "/search/USA");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForStatesList(expectedMessageSuccessList, stateListResponseDTO, "", "");
        assertion.assertResponseContainsListOfAllStates(4, stateListResponseDTO);

    }


    @Test
    public void getNothingStateByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("text", "wj", "/search/USA");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForStatesList(expectedMessageNothing, stateListResponseDTO, "/search/USA", "wj");
        assertion.assertResponseContainsListOfAllStates(0, stateListResponseDTO);

    }

    @Test
    public void test() {

        Response getResponse = step.sendGetRequest("/get/USA/all");
        StateListResponseDTO stateListResponseDTO = step.convertResponseToStatesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseContainsCorrectInfo(stateListResponseDTO, "USA");

    }



}
