package transfer.req_spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ReqSpec {

    private static final String BASE_URL = "http://services.groupkt.com";

    public RequestSpecification getBaseReqSpec() {
        return getRequestSpecWithoutHeaders().build();
    }

    private RequestSpecBuilder getRequestSpecWithoutHeaders() {
        return new RequestSpecBuilder().setBaseUri(BASE_URL);
    }

}
