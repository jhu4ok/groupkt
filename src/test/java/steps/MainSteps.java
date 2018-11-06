package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import transfer.StateResponseTransfer;
import util.PropertiesUtil;

public class MainSteps {

    protected StateResponseTransfer stateResponseTransfer = new StateResponseTransfer();

    public static String initialiseBaseURI(String propertyName) {
        RestAssured.baseURI = PropertiesUtil.getProp(propertyName);
        return RestAssured.baseURI;
    }

    public Response sendGetRequest(String resourceName) {

        Response response = stateResponseTransfer.getRequest(PropertiesUtil.getProp(resourceName));
        return response;
    }

    public Response sendGetWithText(String key, String value, String url) {

        Response response = stateResponseTransfer.getRequestUsingText(PropertiesUtil.getProp(key), PropertiesUtil.getProp(value), PropertiesUtil.getProp(url));
        return response;
    }




}
