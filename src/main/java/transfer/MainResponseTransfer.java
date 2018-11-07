package transfer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import util.ArrayAdapterFactoryUtil;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class MainResponseTransfer {

    public Response getRequest(String url) {

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

    protected static String parseResponseToString(Response response) {

        String str = response.getBody().asString();
        return str;
    }

    protected static Gson createGsonObject() {

        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ArrayAdapterFactoryUtil()).create();
        return gson;
    }
}
