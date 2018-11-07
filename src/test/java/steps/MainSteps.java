package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import transfer.MainResponseTransfer;
import util.PropertiesUtil;

public class MainSteps {

    MainResponseTransfer mainResponseTransfer = new MainResponseTransfer();

    public static String initialiseBaseURI(String propertyName) {

        RestAssured.baseURI = PropertiesUtil.getProp(propertyName);
        return RestAssured.baseURI;
    }

    public Response sendGetRequest(String resourceName) {

        Response response = mainResponseTransfer.getRequest(PropertiesUtil.getProp(resourceName));
        return response;
    }

    public Response sendGetWithText(String key, String value, String url) {

        Response response = mainResponseTransfer.getRequestUsingText(PropertiesUtil.getProp(key), PropertiesUtil.getProp(value), PropertiesUtil.getProp(url));
        return response;
    }




}
