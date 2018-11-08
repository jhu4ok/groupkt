package transfer;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import transfer.req_spec.ReqSpec;

import static io.restassured.RestAssured.given;

public class BaseTransfer {

    private final ReqSpec reqSpec = new ReqSpec();

    public BaseTransfer() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public Response getByState(String path, String state) {
        return given().pathParam("state", state).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

}
