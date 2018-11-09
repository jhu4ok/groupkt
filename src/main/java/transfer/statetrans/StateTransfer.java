package transfer.statetrans;

import io.restassured.response.Response;
import transfer.BaseTransfer;


import static io.restassured.RestAssured.given;

public class StateTransfer extends BaseTransfer {


    public Response getByCountryState(String path, String country, String state) {
        return given().pathParam("country", country).pathParam("state", state).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response getByText(String path, String country, String text) {
        return given().pathParam("country", country).pathParam("text", text).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }
}
