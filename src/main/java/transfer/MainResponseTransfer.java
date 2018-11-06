package transfer;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class MainResponseTransfer {

    public static Response getRequest(String url) {
        Response response =
                get(url).
                        then().
                        extract().response();
        return response;
    }

    public Response getRequestUsingText(String key, String value, String url) {
        Response response =
                given().
                        param(key, value).
                        get(url).
                        then().
                        extract().response();
        return response;
    }
}
