package steps;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;
import io.restassured.response.Response;
import transfer.RestRequestTransfer;


public class Steps {

    private RestRequestTransfer restRequestTransfer = new RestRequestTransfer();


    public Response sendGetRequest(String stateResourse) {

        Response response = restRequestTransfer.getRequest(stateResourse);
        return response;
    }

    public Response sendGetWithText(String key, String value, String url) {

        Response response = restRequestTransfer.getRequestUsingText(key, value, url);
        return response;
    }

    public StateResponseDTO convertResponseToStateObject(Response response) {

        StateResponseDTO stateResponseDTO = restRequestTransfer.objectRepresentationState(response);
        return stateResponseDTO;
    }

    public StateListResponseDTO convertResponseToStatesListObject(Response response) {

        StateListResponseDTO stateListResponseDTO = restRequestTransfer.objectRepresentationStateList(response);
        return stateListResponseDTO;
    }


}

