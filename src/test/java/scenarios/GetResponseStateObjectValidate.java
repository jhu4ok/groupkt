package scenarios;

import assertions.GetResponseAssertions;
import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import io.restassured.response.Response;

import org.apache.logging.log4j.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;
import transfer.RestRequestTransfer;



public class GetResponseStateObjectValidate {

    private static Logger log = LogManager.getLogger(GetResponseStateObjectValidate.class.getName());


    GetResponseAssertions getResponseAssertions = new GetResponseAssertions();
    Steps steps = new Steps();

    @BeforeMethod
    public void setUp() {

        RestRequestTransfer.initialiseBaseURI();
        log.info("Host information" + RestRequestTransfer.initialiseBaseURI());
    }


    @Test
    public void successGetOneStateResponse() {

        Response getResponse = steps.sendGetRequest("/get/USA/AK");
        log.info(getResponse);
        StateResponseDTO stateResponseDTO = steps.convertResponseToStateObject(getResponse);

        getResponseAssertions.assertStatusCode(getResponse, 200);
        getResponseAssertions.assertResponseContainsCorrectStateInfo(stateResponseDTO);
        getResponseAssertions.assertResponseMessageForState(stateResponseDTO);

    }

    @Test
    public void successGetAllStatesResponse() {

        Response getResponse = steps.sendGetRequest("/get/USA/all");
        StateListResponseDTO stateListResponseDTO = steps.convertResponseToStatesListObject(getResponse);

        getResponseAssertions.assertStatusCode(getResponse, 200);
        getResponseAssertions.assertResponseMessageForStatesList(stateListResponseDTO);
        getResponseAssertions.assertResponseContainsListOfAllCountries(55, stateListResponseDTO);
    }

    @Test
    public void failureResponse() {

        Response getResponse = steps.sendGetRequest("/get/USA/al");
        StateResponseDTO stateResponseDTO = steps.convertResponseToStateObject(getResponse);

        getResponseAssertions.assertStatusCode(getResponse, 200);
        getResponseAssertions.assertFalseResponseMessage(stateResponseDTO, "/get/USA/al");
    }


    @Test
    public void getStateByAnyFreeFormText() {

        Response getResponse = steps.sendGetWithText("text", "wa", "/search/USA");
        StateListResponseDTO stateListResponseDTO = steps.convertResponseToStatesListObject(getResponse);

        getResponseAssertions.assertStatusCode(getResponse, 200);
        getResponseAssertions.assertResponseMessageForStatesList(stateListResponseDTO);
        getResponseAssertions.assertResponseContainsListOfAllCountries(4, stateListResponseDTO);

    }


}
