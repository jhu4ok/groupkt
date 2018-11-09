package transfer;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import transfer.req_spec.ReqSpec;

public class BaseTransfer {

    protected final ReqSpec reqSpec = new ReqSpec();

    public BaseTransfer() {
        RestAssured.defaultParser = Parser.JSON;
    }

}
