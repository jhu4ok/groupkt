package dto.stateservisedto;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import transfer.StateResponseTransfer;
import util.PropertiesUtil;

public class Test {
    @org.testng.annotations.Test
    public void successGetAllStatesResponseTEST() {
        RestAssured.baseURI = PropertiesUtil.getProp("HOST_STATE");

        Response response = StateResponseTransfer.getRequest(PropertiesUtil.getProp("ALL_STATES_RESOURCE"));

        StateResponseDTO object = StateResponseTransfer.stateObjectRepresentation(response);


//        assertion.assertResponseMessageForStatesListTEST("MESSAGE_SUCCESS_LIST", respDTO, "", "");
//        assertion.assertResponseContainsListOfAllStates("USA_STATES_COUNT", respDTO);
    }

}


