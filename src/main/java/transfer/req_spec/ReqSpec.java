package transfer.req_spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import util.PropertiesUtil;


public class ReqSpec {

    private static final String BASE_URL = PropertiesUtil.getProp("BASE_URL");

    public RequestSpecification getBaseReqSpec() {
        return getRequestSpecWithoutHeaders().build();
    }

    private RequestSpecBuilder getRequestSpecWithoutHeaders() {
        return new RequestSpecBuilder().setBaseUri(BASE_URL);
    }

}
