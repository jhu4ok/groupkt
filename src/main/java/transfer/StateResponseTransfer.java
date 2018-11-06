package transfer;

import dto.stateservisedto.StateListResponseDTO;


import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class StateResponseTransfer extends MainResponseTransfer{

    public static StateResponseDTO stateObjectRepresentation(Response response) {
        ResponseBody body = response.getBody();
        StateResponseDTO RestResponse = body.as(StateResponseDTO.class);
        return RestResponse;
    }
}
