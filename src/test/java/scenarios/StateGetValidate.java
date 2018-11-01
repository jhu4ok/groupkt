package scenarios;

import assertions.StateAssertions;
import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;
import transfer.RestResponseConverter;

import static io.restassured.RestAssured.given;


public class StateGetValidate {


    StateAssertions stateAssertions = new StateAssertions();
    Steps steps = new Steps();

    @BeforeMethod
    public void setUp() {
        RestResponseConverter.initialiseBaseURI();

    }


    @Test
    public void successGetOneStateResponse() {

        StateResponseDTO stateResponseDTO = steps.getRequestForSingleState("/USA/AK");

        stateAssertions.assertResponseContainsCorrectStateInfo(stateResponseDTO);
        stateAssertions.assertResponseMessageForState(stateResponseDTO);


    }

    @Test
    public void successGetAllStatesResponse() {
        StateListResponseDTO stateListResponseDTO = steps.getRequestForStatesList("/USA/all");

        stateAssertions.assertResponseMessageForStatesList(stateListResponseDTO);
        stateAssertions.assertResponseContainsListOfAllCountries(stateListResponseDTO);
    }


    @Test
    public void getStateByAnyFreeFormText() {
    }

    @Test
    public void failureResponse() {
        StateResponseDTO stateResponseDTO = steps.getRequestForSingleState("/USA/al");


        stateAssertions.assertFailseResponseMessage(stateResponseDTO, "/USA/al");
    }
}
