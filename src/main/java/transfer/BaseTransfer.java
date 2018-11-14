package transfer;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import transfer.req_spec.ReqSpec;

import static io.restassured.RestAssured.given;

public class BaseTransfer {

    protected final ReqSpec reqSpec = new ReqSpec();

    public BaseTransfer() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public Response get(String path) {
        return given().spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response get(String path, String param) {
        return given().pathParam("param", param).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response get(String path, String param1, String param2) {
        return given().
                pathParams("param1", param1, "param2", param2).
                spec(reqSpec.getBaseReqSpec()).when().get(path);
    }
}
