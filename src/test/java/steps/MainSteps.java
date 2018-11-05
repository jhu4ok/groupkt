package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import transfer.RestRequestTransfer;
import util.PropertiesUtil;

public class MainSteps {
    protected RestRequestTransfer restRequestTransfer = new RestRequestTransfer();

    public static String initialiseBaseURI(String propertyName) {
        RestAssured.baseURI = PropertiesUtil.getURL(propertyName);
        return RestAssured.baseURI;
    }

    public Response sendGetRequest(String stateResource) {

        Response response = restRequestTransfer.getRequest(stateResource);
        return response;
    }

    public Response sendGetWithText(String key, String value, String url) {

        Response response = restRequestTransfer.getRequestUsingText(key, value, url);
        return response;
    }


}
